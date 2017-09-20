<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>期次销量管理</title>
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
	<li class="active"><a href="${ctx}/thirdParty/project/">期次销量列表</a></li>
</ul>
	<form:form id="searchForm" name="searchForm" modelAttribute="issueSale" action="${ctx}/thirdParty/issueSale" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="1"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input id="flag" name="flag" type="hidden" value="1"/>
		<div class="col-md-10">
			<li>
				<label>彩种：</label>
					<select name="lotName" class="input-medium">
						<option value="" selected>全部</option>
						<c:forEach items="${macs.lotNameList}" var="stu">
							<option value="${stu}" <c:if test="${saleProject.lotName == stu}">selected</c:if>>${stu}</option>
						</c:forEach>
					</select>
			    </label>
				<label>期次编号：</label>
				<form:input id="lotIssueId" path="lotIssue" htmlEscape="false" maxlength="100" class="input-mini"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;&nbsp;&nbsp;
			</li>
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" style="TABLE-LAYOUT: fixed" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th style="text-align: center;">彩种</th>
				<th style="text-align: center;">期次编号</th>
				<th style="text-align: center;">销售金额</th>
				<th style="text-align: center;">返奖金额</th>
				<%--<th style="text-align: center;">大奖金额</th>--%>
				<th style="text-align: center;">税后金额</th>
				<th style="text-align: center;">开始时间</th>
				<th style="text-align: center;">截止日期</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="project">
			<tr>
				<td style="text-align: center;">${project.lotName}</td>
				<td style="text-align: center;">${project.lotIssue}</td>
				<td style="text-align: center;"><fmt:formatNumber value="${project.totalSell}" type="currency"/></td>
				<td style="text-align: center;"><fmt:formatNumber value="${project.totalBonus}" type="currency"/></td>
				<td style="text-align: center;"><fmt:formatNumber value="${project.totalRealbonus}" type="currency"/></td>
				<td style="text-align: center;"><fmt:formatDate value="${project.statTime}" type="both"/></td>
				<td style="text-align: center;">${project.endDate}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>