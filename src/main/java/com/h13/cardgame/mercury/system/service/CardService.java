package com.h13.cardgame.mercury.system.service;

import com.h13.cardgame.mercury.dao.CardDAO;
import com.h13.cardgame.mercury.system.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CardService {

    @Autowired
    CardDAO cardDAO;

    public void create(CardVO card) {
        cardDAO.create(card);
    }

    public void update(CardVO card) {
        cardDAO.update(card);
    }

    public void delete(long id) {
        cardDAO.delete(id);
    }

    public Object show(long id) {
        CardVO card = cardDAO.show(id);
        if (card.getCardType() == CardType.EQUIPMENT) {
            EquipmentCardVO eCard = new EquipmentCardVO();
            eCard.setDesc(card.getDesc());
            eCard.setIcon(card.getIcon());
            eCard.setName(card.getName());
            eCard.setId(card.getId());
            return eCard;
        } else if (card.getCardType() == CardType.SQUARD) {
            SquardCardVO sCard = new SquardCardVO();
            sCard.setDesc(card.getDesc());
            sCard.setName(card.getName());
            sCard.setIcon(card.getIcon());
            sCard.setId(card.getId());
            sCard.setMaxSlot(card.getSpecData().get("maxSlot"));
            sCard.setMinSlot(card.getSpecData().get("minSlot"));
            return sCard;
        } else {
            UnitsCardVO uCard = new UnitsCardVO();
            uCard.setName(card.getName());
            uCard.setDesc(card.getDesc());
            uCard.setIcon(card.getIcon());
            uCard.setId(card.getId());
            uCard.setAttackMax(card.getSpecData().get("attackMax"));
            uCard.setAttackMin(card.getSpecData().get("attackMin"));
            uCard.setDefenceMax(card.getSpecData().get("defenceMax"));
            uCard.setDefenceMin(card.getSpecData().get("defenceMin"));
            uCard.setECardId(card.getSpecData().get("eCardId"));
            uCard.setSilver(card.getSpecData().get("silver"));
            return uCard;
        }
    }

    public List<CardVO> list() {
        return cardDAO.list();
    }

    public void createSquard(SquardCardVO squardCardVO) {
        CardVO card = new CardVO();
        card.setIcon(squardCardVO.getIcon());
        card.setName(squardCardVO.getName());
        card.setDesc(squardCardVO.getDesc());
        card.setCardType(CardType.SQUARD);
        Map<String, String> map = new HashMap<String, String>();
        map.put("maxSlot", squardCardVO.getMaxSlot());
        map.put("minSlot", squardCardVO.getMinSlot());
        card.setSpecData(map);
        cardDAO.create(card);
    }

    public void createEquipment(EquipmentCardVO equipmentCardVO) {
        CardVO card = new CardVO();
        card.setIcon(equipmentCardVO.getIcon());
        card.setName(equipmentCardVO.getName());
        card.setDesc(equipmentCardVO.getDesc());
        card.setCardType(CardType.EQUIPMENT);
        Map<String, String> map = new HashMap<String, String>();
        card.setSpecData(map);
        cardDAO.create(card);
    }

    public void createUnits(UnitsCardVO unitsCardVO) {
        CardVO card = new CardVO();
        card.setIcon(unitsCardVO.getIcon());
        card.setName(unitsCardVO.getName());
        card.setDesc(unitsCardVO.getDesc());
        card.setId(unitsCardVO.getId());
        card.setCardType(CardType.UNITS);
        Map<String, String> map = new HashMap<String, String>();
        map.put("eCardId", unitsCardVO.getECardId());
        map.put("silver", unitsCardVO.getSilver());
        map.put("attackMax", unitsCardVO.getAttackMax());
        map.put("attackMin", unitsCardVO.getAttackMin());
        map.put("defenceMax", unitsCardVO.getDefenceMax());
        map.put("defenceMin", unitsCardVO.getDefenceMin());
        card.setSpecData(map);
        cardDAO.create(card);
    }

    public void updateSquard(SquardCardVO squardCardVO) {
        CardVO card = new CardVO();
        card.setIcon(squardCardVO.getIcon());
        card.setName(squardCardVO.getName());
        card.setDesc(squardCardVO.getDesc());
        card.setId(squardCardVO.getId());
        card.setCardType(CardType.SQUARD);
        Map<String, String> map = new HashMap<String, String>();
        map.put("maxSlot", squardCardVO.getMaxSlot());
        map.put("minSlot", squardCardVO.getMinSlot());
        card.setSpecData(map);
        cardDAO.update(card);
    }

    public void updateEquipment(EquipmentCardVO equipmentCardVO) {
        CardVO card = new CardVO();
        card.setIcon(equipmentCardVO.getIcon());
        card.setName(equipmentCardVO.getName());
        card.setDesc(equipmentCardVO.getDesc());
        card.setId(equipmentCardVO.getId());
        card.setCardType(CardType.EQUIPMENT);
        Map<String, String> map = new HashMap<String, String>();
        card.setSpecData(map);
        cardDAO.update(card);
    }

    public void updateUnits(UnitsCardVO unitsCardVO) {
        CardVO card = new CardVO();
        card.setIcon(unitsCardVO.getIcon());
        card.setName(unitsCardVO.getName());
        card.setDesc(unitsCardVO.getDesc());
        card.setId(unitsCardVO.getId());
        card.setCardType(CardType.UNITS);
        Map<String, String> map = new HashMap<String, String>();
        map.put("eCardId", unitsCardVO.getECardId());
        map.put("silver", unitsCardVO.getSilver());
        map.put("attackMax", unitsCardVO.getAttackMax());
        map.put("attackMin", unitsCardVO.getAttackMin());
        map.put("defenceMax", unitsCardVO.getDefenceMax());
        map.put("defenceMin", unitsCardVO.getDefenceMin());
        card.setSpecData(map);
        cardDAO.update(card);
    }
}
