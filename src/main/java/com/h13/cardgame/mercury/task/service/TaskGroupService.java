package com.h13.cardgame.mercury.task.service;

import com.h13.cardgame.mercury.dao.TaskGroupDAO;
import com.h13.cardgame.mercury.task.vo.TaskGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-19
 * Time: 下午4:30
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TaskGroupService {

    @Autowired
    TaskGroupDAO taskGroupDAO;

    public List<TaskGroupVO> list() {
        return taskGroupDAO.list();
    }

    public TaskGroupVO show(long id) {
        return taskGroupDAO.show(id);
    }

    public void delete(long id) {
        taskGroupDAO.delete(id);
    }

    public void create(TaskGroupVO taskGroup) {
        taskGroupDAO.create(taskGroup);
    }

    public void update(TaskGroupVO taskGroup) {
        taskGroupDAO.update(taskGroup);
    }


}
