<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SLA Status - upload Files</title>

</head>
<body style = "background-color:lightgrey">
    <br>
    <br>
    <div align="center">
 
        <h1 style="font-family:verdana "> SLA Tracker </h1>
        <p>Awesome.. Following files are uploaded successfully. Please wait till processing..</p>
        <ol style="color: blue">
            <c:forEach items="${files}" var="file">
           - ${file} <br>
            </c:forEach>
        </ol>
       <br />
        <br />
        <br />
    </div>
</body>
</html>