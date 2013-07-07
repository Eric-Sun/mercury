<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>创建一个掉落组</title>
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
    <form name="form" class="form-horizontal" method="post" action="/task/dropGroup/update" id="form">
        <fieldset>
            <input type="hidden" id="sum" value="${sum}"/>
            <input type="hidden" name="id" value="${vo.id}"/>
            <div class="control-group">
                <label class="control-label">名称</label>

                <div class="controls">
                    <input type="text" name="name" value="${vo.name}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">随机的银币（如果全部写-1则认为不掉落金币）</label>

                <div class="controls">
                    <input type="text" name="silverMin" value="${vo.data.silver.min}"> ~
                    <input type="text" name="silverMax" value="${vo.data.silver.max}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">随机的经验（如果全部写-1则认为不掉落金币）</label>

                <div class="controls">
                    <input type="text" name="expMin" value="${vo.data.exp.min}"> ~
                    <input type="text" name="expMax" value="${vo.data.exp.max}">
                </div>
            </div>
            <div class="control-group">
                <div class="controls"><a onclick="addCardDiv()">添加一个新的卡牌</a></div>
            </div>
            <div id="cardDiv">
                <c:forEach items="${vo.data.cardDropList}" var="cardVO" varStatus="status">
                    <div id="cardIdDiv<c:out value="${status.index}"/>" class="control-group">
                        <label class="control-label">卡牌的id</label>

                        <div class="controls">
                            <input type="text" name="cardId" value="${cardVO.cardId}"> <a
                                onclick="removeCardDiv(<c:out value="${status.index}"/>)">删除此卡牌</a>
                        </div>
                    </div>
                    <div id="weightDiv<c:out value="${status.index}"/>" class="control-group">
                        <label class="control-label">这个卡牌的权重</label>

                        <div class="controls">
                            <input type="text" name="weight" value="${cardVO.weight}">
                        </div>
                    </div>

                </c:forEach>

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
<script>
    function addCardDiv() {
        var sum = $("#sum").val();
        var divStr = "<div id=\"cardIdDiv" + sum + "\" class=\"control-group\">" +
                "<label class=\"control-label\">卡牌的id</label>    " +
                "<div class=\"controls\">                  " +
                "       <input type=\"text\" name=\"cardId\">   <a onclick=\"removeCardDiv(" + sum + ")\">删除此卡牌</a>            " +
                "       </div>                           " +
                "</div>                             " +
                "<div id=\"weightDiv" + sum + "\"class=\"control-group\">                         " +
                "        <label class=\"control-label\">这个卡牌的权重</label>       " +
                "        <div class=\"controls\">                  " +
                "        <input type=\"text\" name=\"weight\">            " +
                "        </div>                           " +
                "</div>"
        $("#cardDiv").append(divStr);
        sum++;
        $("#sum").val(sum);
    }

    function removeCardDiv(index) {
        $("#cardIdDiv" + index).remove();
        $("#weightDiv" + index).remove();
        var sum = $("#sum").val();
        sum--;
        $("#sum").val(sum);
    }

</script>
