<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改卡牌</title>
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
    <form name="form" class="form-horizontal" method="post" action="/system/card/update" id="form">
        <fieldset>
            <input type="hidden" value="${vo.id}" name="id"/>

            <div class="control-group">
                <label class="control-label">名称</label>

                <div class="controls">
                    <input type="text" name="name" value="${vo.name}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">图片地址</label>

                <div class="controls">
                    <input type="text" name="icon" value="${vo.icon}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">卡牌类型</label>

                <div class="controls">
                    <select name="cardType">
                        <option value="HUMAN"
                                <c:if test="${vo.cardType=='HUMAN'}">selected="true"</c:if>
                                >人物卡
                        </option>
                        <option value="EQUIPMENT"
                                <c:if test="${vo.cardType=='EQUIPMENT'}">selected="true"</c:if>
                                >装备卡
                        </option>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">最小攻击力</label>

                <div class="controls">
                    <input type="text" name="attackMin" value="${vo.attackMin}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">最大攻击力</label>

                <div class="controls">
                    <input type="text" name="attackMax" value="${vo.attackMax}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">最小防御力</label>

                <div class="controls">
                    <input type="text" name="defenceMin" value="${vo.defenceMin}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">最大防御力</label>

                <div class="controls">
                    <input type="text" name="defenceMax" value="${vo.defenceMax}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">人物卡随机的士兵最大量</label>

                <div class="controls">
                    <input type="text" name="randomSlotCount" value="${vo.randomSlotCount}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">描述</label>

                <div class="controls">
                    <input type="text" name="desc" value="${vo.desc}">
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
