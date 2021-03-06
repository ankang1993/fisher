<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>查看文件</title>
    <s:head/>
</head>
<body>
<%@include file="header.jsp" %>
<s:if test="#session.level == 'mgr'">
    <%@include file="manager/mgrheader.jsp" %>
</s:if>
<s:else>
    <%@include file="employee/empheader.jsp" %>
</s:else>
<table width="960" align="center"
       background="${pageContext.request.contextPath}/images/bodybg.jpg">
    <tr>
        <td>
            <table width=80% border=0 align="center" cellspacing="1" bgcolor="#cccccc">
                <tr bgcolor="#e1e1e1">
                    <td colspan="1">
                        <div class="mytitle">查询文件</div>
                    </td>
                    <td colspan="2">
                        <s:form action="searchFile" theme="simple">
                            <s:textfield name="name" label="名字"/>
                            &nbsp;&nbsp;
                            <s:submit value="搜索"/>
                        </s:form>
                    </td>
                </tr>
                <tr bgcolor="#e1e1e1">
                    <td colspan="3">
                        <div class="mytitle">文件列表</div>
                    </td>
                </tr>
                <tr class="pt11" height="45">
                    <td><b>文件名</b></td>
                    <td><b>下载</b></td>
                    <td><b>删除</b></td>
                </tr>
                <s:iterator value="files" status="index">
                    <s:if test="#index.odd == true">
                        <tr style="background-color:#dddddd" class="pt11" height="32">
                    </s:if>
                    <s:else>
                        <tr class="pt11" height="32">
                    </s:else>
                            <td><s:property value="fileName"/></td>
                            <td><INPUT type="button" value="下载" onClick="downloadFile(${fileId})"></td>
                            <td><INPUT type="button" value="删除" onClick="deleteFile(${fileId})"></td>
                        </tr>
                </s:iterator>
            </table>
            <div>
                <s:if test="flag==0">
                    <br>
                    总共${count}条记录，共${pageCount}页，当前是第${page}页。
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="viewFile.action?page=1">首页</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <s:if test="page!=1">
                        <a href="viewFile.action?page=${page-1}">上一页</a>
                    </s:if>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <s:if test="page!=pageCount">
                        <a href="viewFile.action?page=${page+1}">下一页</a>
                    </s:if>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="viewFile.action?page=${pageCount}">尾页</a>
                </s:if>
            </div>
        </td>
    </tr>
</table>
<script>
    function downloadFile(id) {
        window.location.href = "downloadFile.action?fileId=" + id;
    }

    function deleteFile(id) {
        window.location.href = "deleteFile.action?fileId=" + id;
    }
</script>
<%@include file="footer.jsp" %>
</body>
</html>