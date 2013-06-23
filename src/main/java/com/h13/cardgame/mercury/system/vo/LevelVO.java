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
    private int storageSize;
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

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public int getTroopSize() {
        return troopSize;
    }

    public void setTroopSize(int troopSize) {
        this.troopSize = troopSize;
    }
}
