package com.weasel.restful.service.domain;

/**
 * Created by dell on 2017/3/15.
 */
public class User {

    private long id;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
