package com.green.DataPractice.vo;

import java.util.Arrays;

public class OrderVO {
    private String chicken;
    private int cnt;
    private String[] add;
    private String request;

    public String getChicken() {
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String[] getAdd() {
        return add;
    }

    public void setAdd(String[] add) {
        this.add = add;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "chicken='" + chicken + '\'' +
                ", cnt=" + cnt +
                ", add=" + Arrays.toString(add) +
                ", request='" + request + '\'' +
                '}';
    }
}
