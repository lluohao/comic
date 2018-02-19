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
    private int realScore;

    public DoubanComic() {
    }

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

    public int getRealScore() {
        return realScore;
    }

    public void setRealScore(int realScore) {
        this.realScore = realScore;
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
            return name + "###" + score + "###" + count + "###" + getRealScore() + "###" + dateFormat.format(time);
        }
        return name + "###" + score + "###" + count + "###" + getRealScore() + "###" + "1970-01-01";

    }
}
