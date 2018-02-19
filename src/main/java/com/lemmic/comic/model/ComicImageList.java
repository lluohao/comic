/**
  * Copyright 2018 bejson.com 
  */
package com.lemmic.comic.model;
import java.util.List;

public class ComicImageList {

    private String queryEnc;
    private String queryExt;
    private int listNum;
    private int displayNum;
    private String gsm;
    private String bdFmtDispNum;
    private String bdSearchTime;
    private int isNeedAsyncRequest;
    private String bdIsClustered;
    private List<ComicImage> data;
    public void setQueryEnc(String queryEnc) {
         this.queryEnc = queryEnc;
     }
     public String getQueryEnc() {
         return queryEnc;
     }

    public void setQueryExt(String queryExt) {
         this.queryExt = queryExt;
     }
     public String getQueryExt() {
         return queryExt;
     }

    public void setListNum(int listNum) {
         this.listNum = listNum;
     }
     public int getListNum() {
         return listNum;
     }

    public void setDisplayNum(int displayNum) {
         this.displayNum = displayNum;
     }
     public int getDisplayNum() {
         return displayNum;
     }

    public void setGsm(String gsm) {
         this.gsm = gsm;
     }
     public String getGsm() {
         return gsm;
     }

    public void setBdFmtDispNum(String bdFmtDispNum) {
         this.bdFmtDispNum = bdFmtDispNum;
     }
     public String getBdFmtDispNum() {
         return bdFmtDispNum;
     }

    public void setBdSearchTime(String bdSearchTime) {
         this.bdSearchTime = bdSearchTime;
     }
     public String getBdSearchTime() {
         return bdSearchTime;
     }

    public void setIsNeedAsyncRequest(int isNeedAsyncRequest) {
         this.isNeedAsyncRequest = isNeedAsyncRequest;
     }
     public int getIsNeedAsyncRequest() {
         return isNeedAsyncRequest;
     }

    public void setBdIsClustered(String bdIsClustered) {
         this.bdIsClustered = bdIsClustered;
     }
     public String getBdIsClustered() {
         return bdIsClustered;
     }

    public void setData(List<ComicImage> data) {
         this.data = data;
     }
     public List<ComicImage> getData() {
         return data;
     }

}