<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Reports</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-weight: bold;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #CCEEFF;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<br>
	<h3 style="color:blue">Owner Reports List</h3>
		<table class="tg">
			<tr >
				<th width="80">Owner</th>
				<th width="160">Already breached</th>
				<th width="160">Breaching today</th>
				<th width="160">Yet to be breached</th>
				<th width="100">Grand total</th>
			</tr>
				<c:if test="${!empty ownerCaseReports}">
				   <c:forEach items="${ownerCaseReports}" var="reportDetailVO">
				    <tr>
				     <td>${reportDetailVO.reportName}</td>
				     <td>${reportDetailVO.alreadyBreached}</td>
				     <td>${reportDetailVO.breachingToday}</td>
				     <td>${reportDetailVO.yetToBeBreached}</td>
				     <td>${reportDetailVO.grandTotal}</td>
				    </tr>
				   </c:forEach>
				  </c:if>
			<tr>
				<th>${grandTotalRow.grandRecordName}</th>
				<th>${grandTotalRow.grandRecordAlreadyBreached}</th>
				<th>${grandTotalRow.grandRecordBreachingToday}</th>
				<th>${grandTotalRow.grandRecordYetToBeBreached}</th>
				<th>${grandTotalRow.grandRecordGrandTotal}</th>
			</tr>
		</table>
</body>
</html>