package com.lemmic.comic.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by luohao07 on 2018/2/19.
 */
public class FileUtils {
    public static void save(String path, String content) {
        try {
            File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(String path, byte[] data) {
        try {
            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(InputStream in, OutputStream os, boolean closed) {
        try {
            byte[] buff = new byte[1024 * 8];
            int len = 0;
            while ((len = in.read(buff)) >= 0) {
                os.write(buff, 0, len);
            }
            os.flush();
            if (closed) {
                os.close();
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
