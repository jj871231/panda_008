<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/common/header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="example" class="container">
    <textarea id="editor">
          
    </textarea>
</body>
<script>
$(function(){
        $("#editor").kendoEditor({
            tools: [
                "bold",
                "italic",
                "underline",
                "strikethrough",
                "justifyLeft",
                "justifyCenter",
                "justifyRight",
                "justifyFull",
                "insertUnorderedList",
                "insertOrderedList",
                "indent",
                "outdent",
                "createLink",
                "unlink",
                "insertImage",
                "insertFile",
                "subscript",
                "superscript",
                "createTable",
                "addRowAbove",
                "addRowBelow",
                "addColumnLeft",
                "addColumnRight",
                "deleteRow",
                "deleteColumn",
                "viewHtml",
                "formatting",
                "cleanFormatting",
                "fontName",
                "fontSize",
                "foreColor",
                "backColor",
                "print"
            ],
            imageBrowser: {
            	
                transport: {
                	read: "${ctx}/uploadController/imageRead",
                    destroy: {
                        url: "${ctx}/uploadController/destroy",
                        type: "POST"
                    },
                    create: {
                        url: "${ctx}/uploadController/createDir",
                        type: "POST"
                    },
                    thumbnailUrl:"${ctx}/uploadController/imageThumbnail",
                    uploadUrl: "${ctx}/uploadController/imageUpload",
                    imageUrl: "${ctx}/uploadController/getImage?path={0}"

                }
             },
             fileBrowser: {
                
                 transport: {
                     read: "/kendo-ui/service/FileBrowser/Read",
                     destroy: {
                         url: "/kendo-ui/service/FileBrowser/Destroy",
                         type: "POST"
                     },
                     create: {
                         url: "/kendo-ui/service/FileBrowser/Create",
                         type: "POST"
                     },
                     uploadUrl: "/kendo-ui/service/FileBrowser/Upload",
                     fileUrl: "/kendo-ui/service/FileBrowser/File?fileName={0}"
                 }
             }

        });
	
	
	
})
    </script>
</html>