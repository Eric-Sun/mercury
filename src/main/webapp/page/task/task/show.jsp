<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改任务</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="1"/>
        </jsp:include>
        <jsp:include page="/page/system/include/current.jsp">
            <jsp:param name="current" value="3"/>
        </jsp:include>
    </div>
    <form name="form" class="form-horizontal" method="post" action="/task/task/update" id="form">
        <fieldset>
            <input type="hidden" value="${vo.id}" name="id"/>

            <div class="control-group">
                <label class="control-label">名称</label>

                <div class="controls">
                    <input type="text" name="name" value="${vo.name}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">任务组id</label>

                <div class="controls">
                    <input type="text" name="taskGroupId" value="${vo.taskGroupId}">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">描述</label>

                <div class="controls">
                    <input type="text" name="description" value="${vo.description}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">能量条件</label>

                <div class="controls">
                    <input type="text" name="energy" value="${vo.condition.energy}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">银币条件</label>

                <div class="controls">
                    <input type="text" name="silver" value="${vo.condition.silver}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">金币条件</label>

                <div class="controls">
                    <input type="text" name="gold" value="${vo.condition.gold}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">掉落组id</label>

                <div class="controls">
                    <input type="text" name="dropGroupId" value="${vo.dropGroupId}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">需要完成的次数</label>

                <div class="controls">
                    <input type="text" name="count" value="${vo.count}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">冷却时间</label>

                <div class="controls">
                    <input type="text" name="cooldown" value="${vo.cooldown}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">是否是最后一个任务</label>

                <div class="controls">
                    <select name="last">
                        <option value="1"
                                <c:if test="${vo.last==1}">selected="true"</c:if>
                                >是
                        </option>
                        <option value="0"
                                <c:if test="${vo.last==0}">selected="true"</c:if>
                                >否
                        </option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <input type="submit" class="btn btn-primary" value="提交"/>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
