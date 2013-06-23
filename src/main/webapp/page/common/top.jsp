<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#"></a>

            <div class="nav pull-left">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">用户管理</a>
                    <ul class="dropdown-menu">
                        <li><a href="/page/auth/modifyPassword.jsp">修改密码</a></li>
                        <shiro:hasPermission name="/auth/user/list">
                            <li><a href="/auth/user/list">用户操作</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/auth/role/list">
                            <li><a href="/auth/role/list">角色操作</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/auth/permission/list">
                            <li><a href="/auth/permission/list">权限操作</a></li>
                        </shiro:hasPermission>
                    </ul>
                </li>

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">系统资源管理</a>
                    <ul class="dropdown-menu">
                        <li><a href="/system/config/list">系统变量</a></li>
                        <li><a href="/system/level/list">等级</a></li>
                        <li><a href="/system/level/list">卡牌</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">任务管理</a>
                    <ul class="dropdown-menu">
                        <li><a href="/task/taskGroup/list">任务组列表</a></li>
                        <li><a href="/task/task/list">任务列表</a></li>
                        <li><a href="/task/dropGroup/list">掉落组列表</a></li>
                    </ul>
                </li>
            </div>
            <ul class="nav pull-right">
                <li><a href="#">${sessionScope.name}</a></li>
                <li><a href="/passport/logout">登出</a></li>
            </ul>
            <!-- /.nav-collapse -->
        </div>
    </div>
    <!-- /navbar-inner -->
</div>
