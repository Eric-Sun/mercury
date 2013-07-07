package com.h13.cardgame.mercury.task.service;

import com.h13.cardgame.mercury.dao.TaskDAO;
import com.h13.cardgame.mercury.task.vo.ConditionVO;
import com.h13.cardgame.mercury.task.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-24
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TaskService {

    @Autowired
    TaskDAO taskDAO;


    public void create(TaskVO task, int energy, int silver, int gold) {
        ConditionVO condition = new ConditionVO();
        condition.setEnergy(energy);
        condition.setGold(gold);
        condition.setSilver(silver);
        task.setCondition(condition);
        taskDAO.create(task);
    }

    public void update(TaskVO task, int energy, int silver, int gold) {
        ConditionVO condition = new ConditionVO();
        condition.setEnergy(energy);
        condition.setSilver(silver);
        condition.setGold(gold);
        task.setCondition(condition);
        taskDAO.update(task);
    }

    public void delete(long id) {
        taskDAO.delete(id);
    }

    public TaskVO show(long id) {
        return taskDAO.show(id);
    }

    public List<TaskVO> list() {
        return taskDAO.list();
    }
}
