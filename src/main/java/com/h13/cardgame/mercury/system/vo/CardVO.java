package com.h13.cardgame.mercury.system.vo;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
public class CardVO {
    private long id;
    private String name;
    private String icon;
    private CardType cardType;
    private String desc;
    private Map<String,String> specData;

    @Override
    public String toString() {
        return "CardVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", cardType=" + cardType +
                ", desc='" + desc + '\'' +
                ", specData=" + specData +
                '}';
    }

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

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, String> getSpecData() {
        return specData;
    }

    public void setSpecData(Map<String, String> specData) {
        this.specData = specData;
    }
}
