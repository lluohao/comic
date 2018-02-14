package com.lemmic.comic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.lemmic.comic.model.DoubanComic;
import com.lemmic.comic.model.IComic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by luohao07 on 2018/2/14.
 */
public class DoubanService {
    private static HttpClient client = null;
    private static final Pattern PATTERN_DOUBAN_COMIC_DATE = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    private static final Pattern PATTERN_DOUBAN_COMIC_COUNT = Pattern.compile("\\((\\d+)人评价\\)");
    private static final Pattern PATTERN_DOUBAN_COMIC_ITEM = Pattern.compile("(.+)(\\d+)[ ]+(\\d+)[ ]+([\\d\\-]+)");

    static {
        BasicHeader header = new BasicHeader("Host", "Host: movie.douban.com\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:58.0) Gecko/20100101 Firefox/58.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                "Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Connection: keep-alive\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "Cache-Control: max-age=0");
        client = HttpClientBuilder.create().setDefaultHeaders(ImmutableList.<Header>of(header)).build();

    }

    public List<IComic> loadComic(int start) {
        try {
            HttpGet get = new HttpGet("https://movie.douban.com/tag/动画?start=" + start + "&type=S");
            HttpResponse response = client.execute(get);
            Document document = Jsoup.parse(response.getEntity().getContent(), "UTF-8", "");
            System.out.println(document.text());
            Elements comicElements = document.select(".item");
            List<IComic> comics = new ArrayList<IComic>();
            for (Element comicElement : comicElements) {
                String name = parseName(comicElement);
                Date time = parseDate(comicElement);
                int score = parseScore(comicElement);
                int count = parseCount(comicElement);
                IComic comic = new DoubanComic(score, count, name, time);
                comics.add(comic);
            }
            return comics;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private int parseScore(Element element) {
        try {
            String scoreString = element.select(".star .rating_nums").first().text();
            return (int) (Double.parseDouble(scoreString) * 10);
        } catch (Exception e) {
            System.out.println("parseScore:" + element.html());
            return 0;
        }
    }

    private String parseName(Element element) {
        try {
            String fullName = element.select(".pl2 a").first().text();
            if (fullName.contains("/")) {
                return fullName.substring(0, fullName.indexOf("/"));
            }
            return fullName;
        } catch (Exception e) {
            System.out.println("parseName:" + element.html());

            return null;
        }
    }

    private int parseCount(Element element) {
        try {
            String countString = element.select(".star .pl").first().text();
            Matcher matcher = PATTERN_DOUBAN_COMIC_COUNT.matcher(countString);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));
            }
        } catch (Exception e) {
            System.out.println("parseCount:" + element.html());
            return 0;
        }
        return 0;
    }

    private Date parseDate(Element element) {
        try {
            String allDesc = element.select(".pl2 .pl").first().text().trim();
            Matcher matcher = PATTERN_DOUBAN_COMIC_DATE.matcher(allDesc);
            if (matcher.find()) {
                String dateString = matcher.group();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.parse(dateString);
            }
        } catch (Exception e) {
            System.out.println("parseDate:" + element.html());
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("1.comic"));
        DoubanService service = new DoubanService();
        List<IComic> comics = new ArrayList<IComic>();
        for (int i = 0; i < 2000; i += 20) {
            comics.addAll(service.loadComic(i));
            System.out.println("load start=" + i + ",current size=" + comics.size());
        }
        comics.sort(new Comparator<IComic>() {
            public int compare(IComic o1, IComic o2) {
                return -o1.count() + o2.count();
            }
        });
        for (IComic comic : comics) {
            if (comic == null) {
                continue;
            }
            writer.write(comic.toString());
            writer.newLine();
            System.out.println(comic);
        }
        writer.flush();
        writer.close();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(comics);
        FileWriter fileWriter = new FileWriter("1.json");
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void main1(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("1.comic"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] arr = line.split("[ \t]+");
            System.out.println(arr.length);
        }
    }
}
