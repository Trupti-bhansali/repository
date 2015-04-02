<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SLA Status - upload Files</title>
<style type="text/css">
body {
    background-image:
        url('http://cdn3.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
</head>
<body>
    <br>
    <br>
    <div align="center">
 
        <h1>SLA Tracker </h1>
        <p>Awesome.. Following files are uploaded successfully. Please wait till processing..</p>
        <ol>
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