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
    
    
    var _validFileExtensions = [".csv"];    
    function Validate(oForm) {
        var arrInputs = oForm.getElementsByTagName("input");
        for (var i = 0; i < arrInputs.length; i++) {
            var oInput = arrInputs[i];
            if (oInput.type == "file") {
                var sFileName = oInput.value;
                if(sFileName.length == 0)
                	{
                	alert("Please upload File");
                    return false;
                	}
                var sFileSize = oInput.size
                var sizeValid = true;
                if (sFileName.length > 0) {
                    var blnValid = false;
                    for (var j = 0; j < _validFileExtensions.length; j++) {
                        var sCurExtension = _validFileExtensions[j];
                        if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                            blnValid = true;
                            break;
                        }
              
                    }
                    sFileSize += sFileSize;
                    if(sFileSize > 1000000000)
                    {
                    	sizeValid = false;
                    }
                    
                    if(! sizeValid)
                    {
                    	 alert("Sorry, File size should be less than 1GB, Currently its :" + sFileSize + " in bytes ");
                         return false;	
                    }
                    if (!blnValid) {
                        alert("Sorry, File " + sFileName + " is invalid.  Allowed extension is: " + _validFileExtensions.join(", "));
                        return false;
                    }
                }
                
            }
        }
      
        return true;
    }
    
    
</script>

</head>
<body style = "background-color:lightgrey">
    <br>
    <br>
    <div align="center">
        <h1 style="font-family:verdana">SLA Tracker </h1>
 
        <form:form onsubmit="return Validate(this);" method="post" action="loadFile.html"
            modelAttribute="uploadForm" enctype="multipart/form-data">
 			<h2> Please upload Files </h2>
            <p style="color:blue">Select files to upload. Press Add button to add more file
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