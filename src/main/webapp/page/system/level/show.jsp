<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改等级</title>
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
    <form name="form" class="form-horizontal" method="post" action="/system/level/update" id="form">
        <fieldset>
            <input type="hidden" value="${vo.id}" name="id"/>
            <div class="control-group">
                <label class="control-label">等级</label>

                <div class="controls">
                    <input type="text" name="level" value="${vo.level}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">该等级的经验上限</label>

                <div class="controls">
                    <input type="text" name="exp" value="${vo.exp}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">该等级的能量上限</label>

                <div class="controls">
                    <input type="text" name="energy" value="${vo.energy}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">该等级的仓库上限</label>

                <div class="controls">
                    <input type="text" name="storageSize" value="${vo.storageSize}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">该等级的部队上限</label>

                <div class="controls">
                    <input type="text" name="troopSize" value="${vo.troopSize}">
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
