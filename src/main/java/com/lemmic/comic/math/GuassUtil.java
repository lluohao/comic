package com.lemmic.comic.math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohao07 on 2018/2/14.
 */
public class GuassUtil {
    private static List<Integer> values = null;

    public static List<Integer> init() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("1.csv"));
        String line = null;
        List<Integer> pList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] valueStrins = line.split(",");
            for (int i = 1; i < valueStrins.length; i++) {
                double p = Double.parseDouble(valueStrins[i]);
                int realP = (int) (p * 10000);
                pList.add(realP);
            }
        }
        return pList;
    }

    public static double getP(int months) {
        if (values == null) {
            try {
                values = init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (months >= values.size()) {
            return 1;
        }
        return values.get(months) / 10000.0;
    }
}
