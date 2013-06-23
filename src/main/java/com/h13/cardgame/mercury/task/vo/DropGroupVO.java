package com.h13.cardgame.mercury.task.vo;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-4-12
 * Time: 下午6:01
 * To change this template use File | Settings | File Templates.
 */
public class DropGroupVO {
    private long id;
    private String name;
    private DropGroupDataVO data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DropGroupDataVO getData() {
        return data;
    }

    public void setData(DropGroupDataVO data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
