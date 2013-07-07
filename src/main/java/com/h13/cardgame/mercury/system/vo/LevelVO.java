package com.h13.cardgame.mercury.system.vo;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class LevelVO {

    private long id;
    private int level;
    private int exp;
    private int energy;
    private int eStorageSize;
    private int sStorageSize;
    private int troopSize;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEStorageSize() {
        return eStorageSize;
    }

    public void setEStorageSize(int eStorageSize) {
        this.eStorageSize = eStorageSize;
    }

    public int getSStorageSize() {
        return sStorageSize;
    }

    public void setSStorageSize(int sStorageSize) {
        this.sStorageSize = sStorageSize;
    }

    public int getTroopSize() {
        return troopSize;
    }

    public void setTroopSize(int troopSize) {
        this.troopSize = troopSize;
    }
}
