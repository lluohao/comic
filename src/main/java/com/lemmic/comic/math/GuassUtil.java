package com.lemmic.comic.math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohao07 on 2018/2/14.
 */
public class GuassUtil {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("1.csv"));
        String line = null;
        List<Integer> pList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] valueStrins = line.split(",");
            for (int i = 1; i < valueStrins.length; i++) {
                double p = Double.parseDouble(valueStrins[i]);
                int realP = (int) ((p - 0.5) * 20000);
                pList.add(realP);
            }
        }
        for (int i = 0; i < pList.size(); i++) {
            System.out.println(i + ":" + pList.get(i));
        }
    }
}
