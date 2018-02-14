package com.lemmic.comic.model;

import java.util.Date;

/**
 * Created by luohao07 on 2018/2/14.
 */
public class AbstractComic implements IComic {
    @Override
    public int score() {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Date time() {
        return new Date();
    }

    @Override
    public String name() {
        return "";
    }
}
