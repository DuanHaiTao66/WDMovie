package com.bw.movie.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:段海涛
 *@Date: 2020-04-29
 *@Time:20:30
 *@Description:${DESCRIPTION}
 **/
@Entity
public class CacheDao {
    @Id
    private String url;
    private String json;
    @Generated(hash = 1607819371)
    public CacheDao(String url, String json) {
        this.url = url;
        this.json = json;
    }
    @Generated(hash = 1829676853)
    public CacheDao() {
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
}
