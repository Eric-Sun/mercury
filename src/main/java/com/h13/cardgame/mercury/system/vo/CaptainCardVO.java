package com.h13.cardgame.mercury.system.vo;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-7-20
 * Time: 下午11:20
 * To change this template use File | Settings | File Templates.
 */
public class CaptainCardVO {
    private long id;
    private String name;
    private String icon;
    private String desc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
