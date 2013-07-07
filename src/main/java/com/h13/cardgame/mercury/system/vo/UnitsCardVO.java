package com.h13.cardgame.mercury.system.vo;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-7-5
 * Time: 下午7:02
 * To change this template use File | Settings | File Templates.
 */
public class UnitsCardVO {
    private long id;
    private String name;
    private String icon;
    private String ECardId;
    private String silver;
    private String attackMin;
    private String attackMax;
    private String defenceMin;
    private String defenceMax;

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UnitsCardVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", ECardId='" + ECardId + '\'' +
                ", silver='" + silver + '\'' +
                ", attackMin='" + attackMin + '\'' +
                ", attackMax='" + attackMax + '\'' +
                ", defenceMin='" + defenceMin + '\'' +
                ", defenceMax='" + defenceMax + '\'' +
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

    public String getECardId() {
        return ECardId;
    }

    public void setECardId(String ECardId) {
        this.ECardId = ECardId;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public String getAttackMin() {
        return attackMin;
    }

    public void setAttackMin(String attackMin) {
        this.attackMin = attackMin;
    }

    public String getAttackMax() {
        return attackMax;
    }

    public void setAttackMax(String attackMax) {
        this.attackMax = attackMax;
    }

    public String getDefenceMin() {
        return defenceMin;
    }

    public void setDefenceMin(String defenceMin) {
        this.defenceMin = defenceMin;
    }

    public String getDefenceMax() {
        return defenceMax;
    }

    public void setDefenceMax(String defenceMax) {
        this.defenceMax = defenceMax;
    }
}
