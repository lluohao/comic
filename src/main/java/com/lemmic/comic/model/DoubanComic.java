package com.lemmic.comic.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luohao07 on 2018/2/14.
 */
public class DoubanComic extends AbstractComic {
    private int score;
    private int count;
    private String name;
    private Date time;

    public DoubanComic(int score, int count, String name, Date time) {
        this.score = score;
        this.count = count;
        this.name = name;
        this.time = time;
    }

    @Override
    public int score() {
        return score;
    }

    public int count() {
        return count;
    }

    public String name() {
        return name;
    }

    public Date time() {
        return time;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        if (time != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return name + "###" + score + "" + count + "###" + dateFormat.format(time);
        }
        return name + "###" + score + "###" + count + "###" + "1970-01-01";

    }
}
