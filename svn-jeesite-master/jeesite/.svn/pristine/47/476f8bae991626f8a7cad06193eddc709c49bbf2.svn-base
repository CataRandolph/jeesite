<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>票机管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/terminal/manage/">票机列表</a></li>
    <li><a href="${ctx}/terminal/manage/form">票机添加</a></li>
</ul>

<form:form id="searchForm" action="${ctx}/terminal/manage/" method="post" class="breadcrumb form-search"
           commandName="macManage">
    <input id="pageNo" name="pageNo" type="hidden" value="1"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
    <div>

        <label>票机编号：</label><input id="macId" name="macId" type="text" maxlength="50" class="input-mini"
                                   value="${macManage.macId}"/>

        <label>票机运行状态：</label>
        <form:select path="macStatus" class="input-medium">
            <form:option value="" label=""/>
            <option value="" selected>全部</option>
            <form:options items="${fns:getDictList('mac_manage_type')}" itemLabel="label" itemValue="value"
                          htmlEscape="false"/>
        </form:select>


        &nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
    </div>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th class="sort-column MacID">票机编号</th>
        <th>票机属性</th>
        <th>票机运行状态</th>
        <th>当日打票张数</th>
        <th>当日打票金额</th>
        <th>票机理论余额</th>
        <th>待出票数</th>
        <th>票机预警金额</th>
        <th>当日票机限制张数</th>
        <th>可售彩种</th>
        <th>最后更新时间</th>
        <th>操作</th>
    </thead>
    <tbody><%
        request.setAttribute("strEnter", "\n");
        request.setAttribute("strTab", "\t");
    %>
    <c:forEach items="${page.list}" var="mac">
        <tr>
            <td>${mac.macId}</td>

            <%--票机属性 --%>
            <c:choose>
                <c:when test="${mac.isEnable == 0}">
                    <td style="color: red">${fns:getDictLabels(mac.isEnable, 'mac_manage_type_child', '')}</td>
                </c:when>
                <c:otherwise>
                    <td style="color: #00aa00">${fns:getDictLabels(mac.isEnable, 'mac_manage_type_child', '')}</td>
                </c:otherwise>
            </c:choose>

             <%--票机运行状态 --%>
            <c:choose>
                <c:when test="${mac.macStatus > 1}">
                    <td style="color: red">${fns:getDictLabels(mac.macStatus, 'mac_manage_type', '')}</td>
                </c:when>
                <c:otherwise>
                    <td style="color: #00aa00">${fns:getDictLabels(mac.macStatus, 'mac_manage_type', '')}</td>
                </c:otherwise>
            </c:choose>


            <c:choose>
                <c:when test="${mac.ticketQuantity >= mac.chipCountLimit}">
                    <td style="color:red"> ${mac.ticketQuantity} </td>
                </c:when>
                <c:otherwise>
                    <td>${mac.ticketQuantity}</td>
                </c:otherwise>
            </c:choose>



            <c:choose>
                <c:when test="${mac.totalAmount == null}">
                    <td>0</td>
                </c:when>
                <c:otherwise>
                    <td>${mac.totalAmount}</td>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${mac.money <= mac.warningMoney}">
                    <td style="color:red"> ${mac.money}</td>
                </c:when>
                <c:otherwise>
                    <td>${mac.money}</td>
                </c:otherwise>
            </c:choose>

            <td>${mac.notFinishCount}</td>
            <td>${mac.warningMoney}</td>


            <td>${mac.chipCountLimit == null ? 0 : mac.chipCountLimit}</td>

            <td style="word-break:break-all" width="25%" title="${mac.lotNameTitle}">${mac.lotName}</td>
            <td><fmt:formatDate value="${mac.updateTime}" type="both"/></td>

            <td><a href="${ctx}/terminal/manage/form?macId=${mac.macId}">修改</a>
                &nbsp;
                <a href="${ctx}/terminal/manage/delete?macId=${mac.macId}" onclick="return confirmx('要删除该机票配置吗？', this.href)">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>