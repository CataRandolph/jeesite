<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>投注明细管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
<ul class="nav nav-tabs">
	<li class="active"><a href="${ctx}/thirdParty/project/">投注列表</a></li>
</ul>
	<form:form id="searchForm" name="searchForm" modelAttribute="saleProject" action="${ctx}/thirdParty/project" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="1"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input id="flag" name="flag" type="hidden" value="1"/>
		<div class="col-md-10">
			<li>
				<label>
				<select name="idType" class="input-mini">
					<option value="1"<c:if test="${saleProject.idType == 1}">selected</c:if>>订单号</option>
					<option value="2"<c:if test="${saleProject.idType == 2}">selected</c:if>>方案号</option>
				</select>
				</label>
				<form:input id="orderId" path="orderId" htmlEscape="false" maxlength="100" class="input-mini"/>
				<label>彩种：</label>
					<select name="lotName" class="input-medium">
						<option value="" selected>全部</option>
						<c:forEach items="${macs.lotNameList}" var="stu">
							<option value="${stu}" <c:if test="${saleProject.lotName == stu}">selected</c:if>>${stu}</option>
						</c:forEach>
					</select>
			    </label>
				<label>交易状态：</label>
				<form:select id="projStateId" name="projState" path="projState" class="input-medium">
					<form:option value="" label=""/>
					<option value="" selected>全部</option>
					<form:options items="${fns:getDictList('projState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
		</div>
	    <div class="col-md-10">
			<br>
			<li>
				<label>
					<select name="timeType" class="input-medium">
						<option value="1"<c:if test="${saleProject.timeType == 1}">selected</c:if>>出票时间</option>
						<option value="2" selected <c:if test="${saleProject.timeType == 2}">selected</c:if>>投注时间</option>
						<option value="3"<c:if test="${saleProject.timeType == 3}">selected</c:if>>派奖时间</option>
					</select>
					：
					<input id="beginDate" placeholder="开始日期" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
						   style="width:163px; background-color:#fff"
						   value="<fmt:formatDate value="${saleProject.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
						   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00'});"/>
					　--　
					<input id="endDate"  placeholder="结束日期" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
						   style="width:163px; background-color:#fff"
						   value="<fmt:formatDate value="${saleProject.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
						   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00'});"/>
				</label>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<%--<input id="export" onclick="exportExcel()" class="btn btn-primary" type="button" value="导出"/>--%>
			</li></br>
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" style="TABLE-LAYOUT: fixed" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th style="text-align: center;">方案号</th>
				<th style="text-align: center;">客户订单号</th>
				<th style="text-align: center;">彩种</th>
				<th style="text-align: center;">投注时间</th>
				<th style="text-align: center;">彩票期号</th>
				<th style="text-align: center;">投注方案</th>
				<th style="text-align: center;">投注金额</th>
				<th style="text-align: center;">中奖金额</th>
				<th style="text-align: center;">税后金额</th>
				<th style="text-align: center;">交易状态</th>
				<th style="text-align: center;">出票时间</th>
				<th style="text-align: center;">派奖时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="project">
			<tr>
				<td style="text-align: center;">${project.projId}</td>
				<td style="text-align: center;">${project.orderId}</td>
				<td style="text-align: center;">${project.lotName}</td>
				<td style="text-align: center;"><fmt:formatDate value="${project.chipTime}" type="both"/></td>
				<td style="text-align: center;">${project.lotIssue}</td>
				<td style="text-align: center;">${project.chipCount}注 X ${task.chipMul}倍</td>
				<td style="text-align: center;"><fmt:formatNumber value="${project.chipMoney}" type="currency"/></td>
				<td style="text-align: center;"><fmt:formatNumber value="${project.bonus}" type="currency"/></td>
				<td style="text-align: center;"><fmt:formatNumber value="${project.realBonus}" type="currency"/></td>
				<c:choose>
					<c:when test="${project.projState ==10}">
						<td style="text-align: center;">待处理</td>
					</c:when>
					<c:when test="${project.projState ==11}">
						<td style="text-align: center;">等待取消出票</td>
					</c:when>
					<c:when test="${project.projState ==12}">
						<td style="text-align: center;">取消投注</td>
					</c:when>
					<c:otherwise>
						<td style="text-align: center;"></td>
					</c:otherwise>
				</c:choose>
				<td style="text-align: center;"><fmt:formatDate value="${project.billTime}" type="both"/></td>
				<td style="text-align: center;"><fmt:formatDate value="${project.prizeTime}" type="both"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>