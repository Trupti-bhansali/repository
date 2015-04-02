<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>SLA Status - Please upload Files </title>
<script
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
    $(document).ready(function() {
                        //add more file components if Add is clicked
                        $('#addFile').click(
                                        function() {
                                            var fileIndex = $('#fileTable tr').children().length;
                                            $('#fileTable')
                                                    .append(
                                                            '<tr><td>'
                                                                    + '   <input type="file" name="files['+ fileIndex +']" />'
                                                                    + '</td></tr>');
                                        });
 
                    });
</script>

</style>
</head>
<body style = "background-color:lightgrey">
    <br>
    <br>
    <div align="center">
        <h1>SLA Tracker - Please upload Files</h1>
 
        <form:form method="post" action="loadFile.html"
            modelAttribute="uploadForm" enctype="multipart/form-data">
 
            <p style="color:red">Select files to upload. Press Add button to add more file
                inputs.</p>
 
            <table id="fileTable">
                <tr>
                    <td><input name="files[0]" type="file" /></td>
                </tr>
            </table>
            <br />
            <input type="submit" value="Upload" />
           <input id="addFile" type="button" value="Add File" />
           
            
        </form:form>
 
        <br />
    </div>
</body>
</html>