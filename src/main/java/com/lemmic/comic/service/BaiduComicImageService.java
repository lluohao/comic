package com.lemmic.comic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.lemmic.comic.model.ComicImage;
import com.lemmic.comic.model.ComicImageList;
import com.lemmic.comic.util.FileUtils;
import com.lemmic.comic.util.StringUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;

/**
 * Created by luohao07 on 2018/2/19.
 */
public class BaiduComicImageService {
    private static HttpClient client = null;
    private static ObjectMapper mapper = new ObjectMapper();
    private static HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
        @Override
        public boolean retryRequest(IOException exception,
                                    int executionCount, HttpContext context) {
            return false;
        }
    };

    static {
        BasicHeader header = new BasicHeader("", "Host: image.baidu.com\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:58.0) Gecko/20100101 Firefox/58.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                "Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Referer: http://image.baidu.com/search/flip?tn=baiduimage&ie=utf-8&word=%E7%A7%92%E9%80%9F%E4%BA%94%E5%8E%98%E7%B1%B3&pn=40&gsm=50&ct=&ic=0&lm=-1&width=1000&height=0\n" +
                "Connection: keep-alive\n" +
                "Upgrade-Insecure-Requests: 1");
        client = HttpClientBuilder.create().setRetryHandler(myRetryHandler).setMaxConnTotal(10).setDefaultHeaders(ImmutableList.<Header>of(header)).setConnectionTimeToLive(3000, TimeUnit.MILLISECONDS).build();

    }

    public List<ComicImage> searchImages(String comicName, int limit, int minPiex) throws Exception {
        Set<ComicImage> result = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            try {
                HttpGet get = new HttpGet("http://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=&fp=result&queryWord=" + URLEncoder.encode(comicName, "UTF-8") + "&cl=&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=&z=&ic=0&word=" + URLEncoder.encode(comicName, "UTF-8") + "&s=&se=&tab=&width=0&height=0&face=&istype=&qc=&nc=&fr=&pn=" + 100 * i + 100 + "&rn=100");
                RequestConfig config = RequestConfig.custom().setConnectTimeout(2000).setSocketTimeout(2000).build();
                get.setConfig(config);
                HttpResponse response = client.execute(get);
                String jsonString = StringUtils.fromStream(response.getEntity().getContent());
                FileUtils.save(i + ".json", jsonString);
                ComicImageList comicImageList = mapper.readValue(jsonString, ComicImageList.class);
                System.out.println(i + ":" + comicImageList.getData().size());
                for (ComicImage comicImage : comicImageList.getData()) {
                    if (comicImage.getWidth() * comicImage.getHeight() >= minPiex) {
                        result.add(comicImage);
                        if (result.size() >= limit) {
                            return new ArrayList<>(result);
                        }
                    }
                }
                get.releaseConnection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i + ":" + result.size());
            Thread.sleep(1000);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) throws Exception {
        BasicHeader header = new BasicHeader("" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Accept-Language: zh-CN,zh;q=0.9,ja;q=0.8,zh-TW;q=0.7,en;q=0.6\n" +
                "If-None-Match: cf2cbe5810b1e9d91ae12400409a5cc12bb718cc\n" +
                "\n", "");
        HttpClient client = HttpClientBuilder.create().setRetryHandler(myRetryHandler).setMaxConnTotal(3).setDefaultHeaders(ImmutableList.<Header>of(header)).setConnectionTimeToLive(3000, TimeUnit.MILLISECONDS).build();
//        HttpGet get = new HttpGet("http://i1.hdslb.com/bfs/archive/765f4e45c0680f8ce2e32032e39153d85617bbcf.jpg");
//        HttpResponse response = client.execute(get);
//        System.out.println(response.getStatusLine().getStatusCode());
//        System.out.println(StringUtils.fromStream(response.getEntity().getContent()));

        List<ComicImage> list = new BaiduComicImageService().searchImages("见崎鸣", 200, 1000 * 1000);
        for (ComicImage comicImage : list) {
            HttpGet get = new HttpGet(StringUtils.objUrlDecode(comicImage.getObjURL()));
            try {
                URL url = new URL(StringUtils.objUrlDecode(comicImage.getObjURL()));
                get.addHeader("Host", url.getHost());
                HttpResponse response = client.execute(get);
                FileUtils.save(response.getEntity().getContent(), new FileOutputStream("img/name/" + StringUtils.objUrlDecode(comicImage.getObjURL()).replaceAll("/", "-")), true);
                System.out.println(StringUtils.objUrlDecode(comicImage.getObjURL()));
                get.releaseConnection();
            } catch (Exception e) {
                get.releaseConnection();
                System.err.println("Failed:" + StringUtils.objUrlDecode(comicImage.getObjURL()));
                e.printStackTrace();
            }
        }
    }
}
