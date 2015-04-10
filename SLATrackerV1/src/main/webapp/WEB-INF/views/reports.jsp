<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<%@ page session="false"%>
<html>
<head>
<title>Reports</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #030609;
	margin: 0px auto;
	float: center;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #030609;
	color: #333;
	background-color: #fff;
	text-align: center;
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
	border-color: #030609;
	color: #333;
	background-color: #a7cce5;
	text-align: center;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

.tabs {
	width: 100%;
	display: inline-block;
	background-color: #336699;
}

/*----- Tab Links -----*/
/* Clearfix */
.tab-links:after {
	display: block;
	clear: both;
	content: '';
}

.tab-links li {
	float: left;
	list-style: none;
	background-color: #819FF7;
	margin: 0;
	padding: 0;
	position: relative;
	left: 30%;
}

.tab-links a {
	padding: 9px 15px;
	display: inline-block;
	border-radius: 3px 3px 0px 0px;
	background: #7FB5DA;
	font-size: 16px;
	font-weight: 600;
	color: #4c4c4c;
	transition: all linear 0.15s;
}

.tab-links a:hover {
	background: #a7cce5;
	text-decoration: none;
}

li.active a, li.active a:hover {
	background: #fff;
	color: #4c4c4c;
}

/*----- Content of Tabs -----*/
.tab-content {
	padding: 15px;
	border-radius: 3px;
	box-shadow: -1px 1px 1px rgba(0, 0, 0, 0.15);
	background-color: #336699;
}

.tab {
	display: none;
}

.tab.active {
	display: block;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="main">
			<div class="tabs standard">
				<ul class="tab-links">
					<li class="active"><a href="#tab1">Owner Reports List</a></li>
					<li><a href="#tab2">Queue Report List</a></li>
					<li><a href="#tab3">Status Report List</a></li>
				</ul>
				<!-- <h3 style="color:blue">Owner Reports List</h3> -->

				<div class="tab-content">
					<div id="tab1" class="tab active">
						<table class="tg">
							<tr>
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
						<br />
					</div>

					<div id="tab2" class="tab">
						<table class="tg">
							<tr>
								<th width="80">Queue Name</th>
								<th width="160">Already breached</th>
								<th width="160">Breaching today</th>
								<th width="160">Yet to be breached</th>
								<th width="100">Grand total</th>
							</tr>
							<c:if test="${!empty queueCaseReports}">
								<c:forEach items="${queueCaseReports}" var="reportDetailVO">
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
					</div>

					<div id="tab3" class="tab">

						<table class="tg">
							<tr>
								<th width="80">Status</th>
								<th width="160">Already breached</th>
								<th width="160">Breaching today</th>
								<th width="160">Yet to be breached</th>
								<th width="100">Grand total</th>
							</tr>
							<c:if test="${!empty statusCaseReports}">
								<c:forEach items="${statusCaseReports}" var="reportDetailVO">
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
					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		jQuery(document).ready(
				function() {
					jQuery('.tabs .tab-links a').on(
							'click',
							function(e) {
								var currentAttrValue = jQuery(this)
										.attr('href');

								// Show/Hide Tabs
								jQuery('.tabs ' + currentAttrValue).show()
										.siblings().hide();

								// Change/remove current tab to active
								jQuery(this).parent('li').addClass('active')
										.siblings().removeClass('active');

								e.preventDefault();
							});
				});
	</script>

</body>
</html>