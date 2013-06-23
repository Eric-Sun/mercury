package com.h13.cardgame.mercury.task.vo;

public class TaskVO {

    /**
     * 任务的id
     */
    private long id;
    /**
     * 任务的名称
     */
    private String name;
    private String description;
    /**
     * 任务需要完成的次数
     */
    private int count;
    /**
     * 任务的奖励
     */
    private Long dropGroupId;
    /**
     * 任务本次完成之后下一次完成需要的时间（秒）
     */
    private long cooldown;
    private long taskGroupId;
    private ConditionVO condition;
    private int last;

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public ConditionVO getCondition() {
        return condition;
    }

    public void setCondition(ConditionVO condition) {
        this.condition = condition;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public long getCooldown() {
        return cooldown;
    }

    public void setCooldown(long cooldown) {
        this.cooldown = cooldown;
    }

    public long getTaskGroupId() {
        return taskGroupId;
    }

    public void setTaskGroupId(long taskGroupId) {
        this.taskGroupId = taskGroupId;
    }

    public Long getDropGroupId() {
        return dropGroupId;
    }

    public void setDropGroupId(Long dropGroupId) {
        this.dropGroupId = dropGroupId;
    }

    @Override
    public String toString() {
        return "TaskCO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", dropGroupId=" + dropGroupId +
                ", cooldown=" + cooldown +
                ", taskGroupId=" + taskGroupId +
                ", condition=" + condition +
                ", last=" + last +
                '}';
    }
}
