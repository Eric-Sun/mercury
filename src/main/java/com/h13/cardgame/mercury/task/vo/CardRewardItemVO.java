package com.h13.cardgame.mercury.task.vo;

/**
 * 卡牌掉落的配置  包括权重和卡牌的id
 * User: sunbo
 * Date: 13-4-6
 * Time: 下午8:58
 * To change this template use File | Settings | File Templates.
 */
public class CardRewardItemVO {
    private long cardId;
    private int weight;

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "TaskRewardCardItemCO{" +
                "cardId=" + cardId +
                ", weight=" + weight +
                '}';
    }
}
