package com.crawler.mama.model;

public class Mama {

    private Long id;

    private String title;

    private String userName;

    private String age;

    private String city;

    /**
     * 热度：回复数/点击数
     */
    private String heat;

    private String lastActiveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getAge() {
        return this.age;
    }

    public String getCity() {
        return this.city;
    }

    public String getHeat() {
        return this.heat;
    }

    public String getLastActiveTime() {
        return this.lastActiveTime;
    }

    public Mama setTitle(String title) {
        this.title = title;
        return this;
    }

    public Mama setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Mama setAge(String age) {
        this.age = age;
        return this;
    }

    public Mama setCity(String city) {
        this.city = city;
        return this;
    }

    public Mama setHeat(String heat) {
        this.heat = heat;
        return this;
    }

    public Mama setLastActiveTime(String lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
        return this;
    }

}
