package com.lemmic.comic.util;

import com.lemmic.comic.exception.BaseException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by luohao07 on 2018/2/19.
 */
public class StringUtils {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(StringUtils.class.getResourceAsStream("/objurl.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String fromStream(InputStream in) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            throw new BaseException();
        }
    }

    public static String objUrlDecode(String url) {
        if (url == null || url.length() == 0) {
            return url;
        }
        url = url.replace("_z2C$q", ":");
        url = url.replace("_z&e3B", ".");
        url = url.replace("AzdH3F", "/");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < url.length(); i++) {
            char c = url.charAt(i);
            if (properties.containsKey(c + "")) {
                stringBuilder.append(properties.get(c + ""));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
