package com.h13.cardgame.mercury.task.vo;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-19
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
public class TaskGroupVO {
    private long id;
    private String name;
    private long nextTaskGroupId;
    private int last;

    @Override
    public String toString() {
        return "TaskGroupVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nextTaskGroupId=" + nextTaskGroupId +
                ", last=" + last +
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

    public long getNextTaskGroupId() {
        return nextTaskGroupId;
    }

    public void setNextTaskGroupId(long nextTaskGroupId) {
        this.nextTaskGroupId = nextTaskGroupId;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
}
