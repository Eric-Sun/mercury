<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>系统变量列表</title>
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
    <ul class="breadcrumb">
        <li><a href="/page/task/taskGroup/create.jsp">创建新的任务组</a></li>

    </ul>
    <div class="body">
        <div>
            <table id="myTable" class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>id</th>
                    <th>名称</th>
                    <th>下一个任务组的id</th>
                    <th>是否是最后一组任务</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${voList}">
                    <td>${dto.id}</td>
                    <td>${dto.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${dto.nextTaskGroupId==-1}">
                                这个是最后一个任务了
                            </c:when>
                            <c:otherwise>
                                ${dto.nextTaskGroupId}
                            </c:otherwise>
                        </c:choose>
                   </td>
                    <td>
                        <c:if test="${dto.last==0}">
                            否
                        </c:if>
                        <c:if test="${dto.last==-1}">
                            是
                        </c:if>
                    </td>
                    <td>
                        <div class="btn-group">
                            <a href="/task/taskGroup/show?id=${dto.id}" title="编辑"><i
                                    class="icon-edit"></i></a> <a
                                href="/task/taskGroup/delete?id=${dto.id}" rel="tooltip"
                                title="删除"><i class="icon-trash"></i></a>
                        </div>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </form>
        </div>
    </div>
    <jsp:include page="/page/common/message.jsp"/>
</div>
</body>
<script>
    $(document).ready(function () {
        $("#myTable").tablesorter({sortList: [
            [0, 0],
            [1, 0]
        ]});
    });

    function role_form_add() {
        $("#lastTime").hide();
        $("#id").remove();
        roleForm.reset();
        $("#cb").html("");
        roleForm.action = "/auth/role/create";
        add_permissions();
    }

    function add_permissions() {
        $.post("/auth/permission/jlist", {}, function (data) {
            if (null == data || "" == data) {
                do_alert(0);
                return false;
            }
            for (var i = 0; i < data.length; i++) {
                var checkstr = "";
                if (data[i].selected == 'true') {
                    checkstr = "checked";
                }
                $("#cb").append("<label class=\"checkbox inline\"><input type='checkbox' name='permissionIdArray' "
                        + checkstr + " value='" + data[i].id + "'>" + data[i].name + "</input></label>");
            }

        }, "json");
    }

    function form_update(id) {
        $("#id").remove();
        $("#cb").html("");
        roleForm.action = "/auth/role/update";
        $.post("/auth/role/fetch", {"id": id}, function (data) {

            if (null == data || "" == data) {
                do_alert(0);
                return false;
            }

            $("#roleForm").append("<input type='hidden' name='id' id='id' value='" + data.id + "'/>");

            for (var i = 0; i < data.permissionList.length; i++) {
                var checkstr = "";
                if (data.permissionList[i].selected == true) {
                    checkstr = "checked";
                }
                $("#cb").append("<label class=\"checkbox inline\"><input type='checkbox' name='permissionIdArray' "
                        + checkstr + " value='" + data.permissionList[i].id + "'>" + data.permissionList[i].name + "</input></label>");
            }

            roleForm.name.value = data.name;
        }, "json");
    }
    function form_add() {
        $("#lastTime").hide();
        $("#id").remove();
        $("#iconInfo").remove();
        roleForm.reset();
        roleForm.action = "/source/add?location=${location}";
    }

    window.onload = function () {
        CKEDITOR.replace('editor1');
    };
</script>
</html>
