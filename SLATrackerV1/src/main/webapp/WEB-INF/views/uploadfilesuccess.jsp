<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SLA Status - upload Files</title>

</head>
<body style = "background-color: #336699">
    <br>
    <br>
    <div align="center" style="font-family:verdana" >
 
        <form action="reports" >
        <h1 > SLA Tracker </h1>
        <p style = "font-weight: bold;" >Awesome.. Following files are uploaded successfully</p>
        <ol style = "font-weight: bold;">
            <c:forEach items="${files}" var="file">
           - ${file} <br>
            </c:forEach>
        </ol>
        <br />
        <p style = "font-weight: bold;">Please wait till processing...</p>
        <br />
        
        <input type="submit" value="OK" />
        <br />
        </form>
   
    </div>
</body>
</html>