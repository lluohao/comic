/**
 * Copyright 2018 bejson.com
 */
package com.lemmic.comic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class ComicImage {

    private String adType;
    private String hasAspData;
    private String thumbURL;
    private String middleURL;
    private String largeTnImageUrl;
    private int hasLarge;
    private String hoverURL;
    private int pageNum;
    private String objURL;
    private String fromURL;
    private String fromURLHost;
    private String currentIndex;
    private int width;
    private int height;
    private String type;
    private int is_gif;
    private String filesize;
    private String bdSrcType;
    private String di;
    private String pi;
    private String is;
    @JsonIgnore
    private List<ReplaceUrl> replaceUrl;
    private String hasThumbData;
    private int bdSetImgNum;
    private int partnerId;
    private int spn;
    private String bdImgnewsDate;
    private String fromPageTitle;
    private String fromPageTitleEnc;
    private String bdSourceName;
    private String bdFromPageTitlePrefix;
    private int isAspDianjing;
    private String token;
    private String imgType;
    private String cs;
    private String os;
    private String simid;
    private String personalized;
    private String simid_info;
    private String face_info;
    private String xiangshi_info;
    private String adPicId;
    private String source_type;

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getAdType() {
        return adType;
    }

    public void setHasAspData(String hasAspData) {
        this.hasAspData = hasAspData;
    }

    public String getHasAspData() {
        return hasAspData;
    }

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public void setMiddleURL(String middleURL) {
        this.middleURL = middleURL;
    }

    public String getMiddleURL() {
        return middleURL;
    }

    public void setLargeTnImageUrl(String largeTnImageUrl) {
        this.largeTnImageUrl = largeTnImageUrl;
    }

    public String getLargeTnImageUrl() {
        return largeTnImageUrl;
    }

    public void setHasLarge(int hasLarge) {
        this.hasLarge = hasLarge;
    }

    public int getHasLarge() {
        return hasLarge;
    }

    public void setHoverURL(String hoverURL) {
        this.hoverURL = hoverURL;
    }

    public String getHoverURL() {
        return hoverURL;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setObjURL(String objURL) {
        this.objURL = objURL;
    }

    public String getObjURL() {
        return objURL;
    }

    public void setFromURL(String fromURL) {
        this.fromURL = fromURL;
    }

    public String getFromURL() {
        return fromURL;
    }

    public void setFromURLHost(String fromURLHost) {
        this.fromURLHost = fromURLHost;
    }

    public String getFromURLHost() {
        return fromURLHost;
    }

    public void setCurrentIndex(String currentIndex) {
        this.currentIndex = currentIndex;
    }

    public String getCurrentIndex() {
        return currentIndex;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setIs_gif(int is_gif) {
        this.is_gif = is_gif;
    }

    public int getIs_gif() {
        return is_gif;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setBdSrcType(String bdSrcType) {
        this.bdSrcType = bdSrcType;
    }

    public String getBdSrcType() {
        return bdSrcType;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public String getDi() {
        return di;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getPi() {
        return pi;
    }

    public void setIs(String is) {
        this.is = is;
    }

    public String getIs() {
        return is;
    }

    public void setReplaceUrl(List<ReplaceUrl> replaceUrl) {
        this.replaceUrl = replaceUrl;
    }

    public List<ReplaceUrl> getReplaceUrl() {
        return replaceUrl;
    }

    public void setHasThumbData(String hasThumbData) {
        this.hasThumbData = hasThumbData;
    }

    public String getHasThumbData() {
        return hasThumbData;
    }

    public void setBdSetImgNum(int bdSetImgNum) {
        this.bdSetImgNum = bdSetImgNum;
    }

    public int getBdSetImgNum() {
        return bdSetImgNum;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setSpn(int spn) {
        this.spn = spn;
    }

    public int getSpn() {
        return spn;
    }

    public void setBdImgnewsDate(String bdImgnewsDate) {
        this.bdImgnewsDate = bdImgnewsDate;
    }

    public String getBdImgnewsDate() {
        return bdImgnewsDate;
    }

    public void setFromPageTitle(String fromPageTitle) {
        this.fromPageTitle = fromPageTitle;
    }

    public String getFromPageTitle() {
        return fromPageTitle;
    }

    public void setFromPageTitleEnc(String fromPageTitleEnc) {
        this.fromPageTitleEnc = fromPageTitleEnc;
    }

    public String getFromPageTitleEnc() {
        return fromPageTitleEnc;
    }

    public void setBdSourceName(String bdSourceName) {
        this.bdSourceName = bdSourceName;
    }

    public String getBdSourceName() {
        return bdSourceName;
    }

    public void setBdFromPageTitlePrefix(String bdFromPageTitlePrefix) {
        this.bdFromPageTitlePrefix = bdFromPageTitlePrefix;
    }

    public String getBdFromPageTitlePrefix() {
        return bdFromPageTitlePrefix;
    }

    public void setIsAspDianjing(int isAspDianjing) {
        this.isAspDianjing = isAspDianjing;
    }

    public int getIsAspDianjing() {
        return isAspDianjing;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public String getImgType() {
        return imgType;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getCs() {
        return cs;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public void setSimid(String simid) {
        this.simid = simid;
    }

    public String getSimid() {
        return simid;
    }

    public void setPersonalized(String personalized) {
        this.personalized = personalized;
    }

    public String getPersonalized() {
        return personalized;
    }

    public void setSimid_info(String simid_info) {
        this.simid_info = simid_info;
    }

    public String getSimid_info() {
        return simid_info;
    }

    public void setFace_info(String face_info) {
        this.face_info = face_info;
    }

    public String getFace_info() {
        return face_info;
    }

    public void setXiangshi_info(String xiangshi_info) {
        this.xiangshi_info = xiangshi_info;
    }

    public String getXiangshi_info() {
        return xiangshi_info;
    }

    public void setAdPicId(String adPicId) {
        this.adPicId = adPicId;
    }

    public String getAdPicId() {
        return adPicId;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public String getSource_type() {
        return source_type;
    }

    @Override
    public String toString() {
        if (largeTnImageUrl != null && largeTnImageUrl.length() > 0) {
            return largeTnImageUrl;
        }
        return middleURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComicImage that = (ComicImage) o;
        return ((ComicImage) o).getObjURL().equals(that.getObjURL());
    }

    @Override
    public int hashCode() {
        return objURL.hashCode();
    }
}