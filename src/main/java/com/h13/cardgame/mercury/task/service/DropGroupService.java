package com.h13.cardgame.mercury.task.service;

import com.h13.cardgame.mercury.dao.DropGroupDAO;
import com.h13.cardgame.mercury.task.vo.CardRewardItemVO;
import com.h13.cardgame.mercury.task.vo.CommonRewardItemVO;
import com.h13.cardgame.mercury.task.vo.DropGroupDataVO;
import com.h13.cardgame.mercury.task.vo.DropGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class DropGroupService {

    @Autowired
    DropGroupDAO dropGroupDAO;

    public void create(String name, int silverMin, int silverMax, int expMin, int expMax,
                       Long[] cardIdList, Integer[] weightList) {
        DropGroupVO dropGroupVO = new DropGroupVO();
        dropGroupVO.setName(name);
        DropGroupDataVO dropGroupDataVO = new DropGroupDataVO();
        CommonRewardItemVO silverItem = new CommonRewardItemVO();
        if (silverMin == -1 || silverMax == -1) {
            silverItem.setDrop(false);
        } else {
            silverItem.setDrop(true);
            silverItem.setMax(silverMax);
            silverItem.setMin(silverMin);
        }

        CommonRewardItemVO expItem = new CommonRewardItemVO();
        if (expMin == -1 || expMax == -1) {
            expItem.setDrop(false);
        } else {
            expItem.setDrop(true);
            expItem.setMax(expMax);
            expItem.setMin(expMin);
        }

        List<CardRewardItemVO> cardItemList = new ArrayList<CardRewardItemVO>();
        int weightSum = 0;
        for (int i = 0; i < cardIdList.length; i++) {
            long cardId = cardIdList[i];
            int weight = weightList[i];
            CardRewardItemVO cardItem = new CardRewardItemVO();
            cardItem.setCardId(cardId);
            cardItem.setWeight(weight);
            cardItemList.add(cardItem);
            weightSum += weight;
        }
        dropGroupDataVO.setCardDropList(cardItemList);
        dropGroupDataVO.setExp(expItem);
        dropGroupDataVO.setSilver(silverItem);
        dropGroupDataVO.setWeightSum(weightSum);
        dropGroupVO.setData(dropGroupDataVO);

        dropGroupDAO.create(dropGroupVO);
    }


    public void update(long id, String name, int silverMin, int silverMax, int expMin, int expMax,
                       Long[] cardIdList, Integer[] weightList) {
        DropGroupVO dropGroupVO = new DropGroupVO();
        dropGroupVO.setName(name);
        DropGroupDataVO dropGroupDataVO = new DropGroupDataVO();
        CommonRewardItemVO silverItem = new CommonRewardItemVO();
        if (silverMin == -1 || silverMax == -1) {
            silverItem.setDrop(false);
        } else {
            silverItem.setDrop(true);
            silverItem.setMax(silverMax);
            silverItem.setMin(silverMin);
        }

        CommonRewardItemVO expItem = new CommonRewardItemVO();
        if (expMin == -1 || expMax == -1) {
            expItem.setDrop(false);
        } else {
            expItem.setDrop(true);
            expItem.setMax(expMax);
            expItem.setMin(expMin);
        }

        List<CardRewardItemVO> cardItemList = new ArrayList<CardRewardItemVO>();
        int weightSum = 0;
        for (int i = 0; i < cardIdList.length; i++) {
            long cardId = cardIdList[i];
            int weight = weightList[i];
            CardRewardItemVO cardItem = new CardRewardItemVO();
            cardItem.setCardId(cardId);
            cardItem.setWeight(weight);
            cardItemList.add(cardItem);
            weightSum += weight;
        }
        dropGroupDataVO.setCardDropList(cardItemList);
        dropGroupDataVO.setExp(expItem);
        dropGroupDataVO.setSilver(silverItem);
        dropGroupDataVO.setWeightSum(weightSum);
        dropGroupVO.setData(dropGroupDataVO);
        dropGroupVO.setId(id);
        dropGroupDAO.update(dropGroupVO);
    }

    public DropGroupVO show(long id) {
        return dropGroupDAO.show(id);
    }

    public List<DropGroupVO> list() {
        return dropGroupDAO.list();
    }

    public void delete(long id) {
        dropGroupDAO.delete(id);
    }


}
