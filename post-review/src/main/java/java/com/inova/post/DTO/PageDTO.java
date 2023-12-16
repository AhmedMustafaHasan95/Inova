package com.inova.post.DTO;

public class PageDTO {
    private int size;
    private int number;
    private long allSize;
    private Object data;
    private long userId;

    public PageDTO() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getAllSize() {
        return allSize;
    }

    public void setAllSize(long allSize) {
        this.allSize = allSize;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
