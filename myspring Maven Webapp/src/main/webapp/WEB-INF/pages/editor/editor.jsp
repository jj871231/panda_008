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
                	read: "/kendo-ui/service/ImageBrowser/Read",
                    destroy: {
                        url: "/kendo-ui/service/ImageBrowser/Destroy",
                        type: "POST"
                    },
                    create: {
                        url: "/kendo-ui/service/ImageBrowser/Create",
                        type: "POST"
                    },
                    thumbnailUrl: "/kendo-ui/service/ImageBrowser/Thumbnail",
                    uploadUrl: "/kendo-ui/service/ImageBrowser/Upload",
                    imageUrl: "/kendo-ui/service/ImageBrowser/Image?path={0}"

                }
             },
             fileBrowser: {
                 messages: {
                     dropFilesHere: "Drop files here"
                 },
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