package com.h13.cardgame.mercury.task.vo;

import java.util.List;

/**
 * 掉落组的配置
 * User: sunbo
 * Date: 13-4-6
 * Time: 下午8:43
 * To change this template use File | Settings | File Templates.
 */
public class DropGroupDataVO {

    private List<CardRewardItemVO> cardDropList;
    private CommonRewardItemVO exp;
    private CommonRewardItemVO silver;
    private int weightSum;

    public List<CardRewardItemVO> getCardDropList() {
        return cardDropList;
    }

    public void setCardDropList(List<CardRewardItemVO> cardDropList) {
        this.cardDropList = cardDropList;
    }

    public CommonRewardItemVO getExp() {
        return exp;
    }

    public void setExp(CommonRewardItemVO exp) {
        this.exp = exp;
    }

    public CommonRewardItemVO getSilver() {
        return silver;
    }

    public void setSilver(CommonRewardItemVO silver) {
        this.silver = silver;
    }

    public int getWeightSum() {
        return weightSum;
    }

    public void setWeightSum(int weightSum) {
        this.weightSum = weightSum;
    }


    @Override
    public String toString() {
        return "DropGroupCO{" +
                ", cardDropList=" + cardDropList +
                ", exp=" + exp +
                ", silver=" + silver +
                ", weightSum=" + weightSum +
                '}';
    }
}
