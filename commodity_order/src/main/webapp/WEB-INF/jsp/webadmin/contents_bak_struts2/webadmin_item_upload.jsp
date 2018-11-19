<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="pageTitle">
    <span style="font-size:150%;font-weight:bold;">
        <s:text name="web.admin.content.itemImport.import.title"></s:text>
    </span>
    <div style="clear: both;margin: 0px 0px 0px 0px;padding: 2px 0;text-align: right;vertical-align:middle;border-top: 2px solid #0000ff;"></div>
</div>
<div id="mainArea" class="adminMainArea">
    <div class="main">
        <form action="syouhinUpload" method="post"  enctype="multipart/form-data">
        <s:token />
        <div style="margin:0px 0px 0px 20px;text-align:left;">
            <p style="font-size:120%;font-weight:bold;padding: 10px 0;">
                <s:text name="web.admin.content.itemImport.import.text.message"></s:text>
            </p>
            <br><br>
            <s:text name="web.admin.content.itemImport.import.field.syouhinFile"></s:text>
            <s:file name="syouhinFile"></s:file>
        </div>
        <br><br>
        <div style="margin:0px 20px 10px 0px;text-align:right;">
            <s:submit type= "image" src="%{#baseDir}/webadmin/images/admin/admin_03.png" method="upload"></s:submit>
        </div>
        <s:actionerror/>
        </form>
    </div>
</div><!-- mainArea -->