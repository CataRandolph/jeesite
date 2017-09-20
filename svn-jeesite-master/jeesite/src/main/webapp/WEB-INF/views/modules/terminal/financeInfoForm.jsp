<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>财务信息</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#name").focus();
            $("#inputForm").validate({
                submitHandler: function (form) {
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
/*
            $("#aroseMoney").on('input propertychange', function () {
                var type = $("#correctType").val();
                var beforeMoney = $("#beforeMoney").val();
               /!* var currentBalance = $("#currentBalance").val();*!/
                var aroseMoney = $("#aroseMoney").val();
                if (type == 1) {
                    $("#currentBalance").attr("value", beforeMoney - aroseMoney);
                }
                if (type == 2) {
                    $("#currentBalance").attr("value", parseInt(beforeMoney) + parseInt(aroseMoney));
                }
                if (type == 3) {
                    $("#currentBalance").attr("value", beforeMoney - aroseMoney);
                }
                if (type == 4) {
                    $("#currentBalance").attr("value", parseInt(beforeMoney) + parseInt(aroseMoney));
                }
            });*/

        });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/terminal/financeInfo/">财务信息</a></li>
    <li class="active"><a href="${ctx}/terminal/financeInfo/save">票机修正</a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="financeInfo" action="${ctx}/terminal/financeInfo/save" method="post"
           class="form-horizontal">
    <sys:message content="${message}"/>

    <div class="control-group">
        <label class="control-label">票机编号:</label>
        <div class="controls">
            <form:input path="macId" readonly="true" htmlEscape="false" maxlength="50" class="required"/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">流水类型:</label>
        <div class="controls">
            <form:select path="correctType" class="input-medium required">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('correctType')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
        </div>
    </div>



   <%-- <div class="control-group">
        <label class="control-label">发生前金额:</label>
        <div class="controls">
            <form:input path="beforeMoney" readonly="true" htmlEscape="false" maxlength="50" class="required"/>
        </div>
    </div>--%>

    <div class="control-group">
        <label class="control-label">余额:</label>
        <div class="controls">
            <form:input path="currentBalance" readonly="true" htmlEscape="false" maxlength="50" class="required"/>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">发生金额:</label>
        <div class="controls">
            <form:input path="aroseMoney" htmlEscape="false" maxlength="8" class="required number"/>
            <span class="help-inline">金额请填数字类型</span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">备注:</label>
        <div class="controls">
            <form:input path="remarks" htmlEscape="false" maxlength="50" class="required"/>
        </div>
    </div>


    <div class="form-actions">
        <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>