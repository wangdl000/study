<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="pageTitle">
    <span style="font-size:150%;font-weight:bold;">
        <s:text name="web.admin.content.catalog.edit.title" />
    </span>
    <div style="clear: both;margin: 0px 0px 0px 0px;padding: 2px 0;text-align: right;vertical-align:middle;border-top: 2px solid #0000ff;"></div>
</div>
<div id="mainArea" class="adminMainArea">
    <form action="catalogEdit">
    <s:actionerror/>
    <s:token />
    <div class="main">
        <div class="center">
            <table class="itemListTable noBorder" width="90%">
                <colgroup width="25%"></colgroup>
                <colgroup width="75%"></colgroup>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.catalog.edit.field.catalogId" />
                    </th>
                    <td class="left">
                    <s:property value="catalogId"/>
                    <s:hidden name="catalogId"></s:hidden>
                    </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.catalog.edit.field.catalogName" />
                    </th>
                    <td class="left">
                        <s:property value="catalogName"/>
                        <s:hidden name="catalogName"></s:hidden>
                        </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.catalog.edit.field.genre" />
                    </th>
                    <td class="left">
                    <s:set name="genreMap" value="%{cache.getKikakuGenreMap1(adminLogin.kikakuCd)}"/>
                    <s:checkboxlist name="genreList" list="genreMap" listKey="key" listValue="value" value="genreList"></s:checkboxlist>
                    </td>
                </tr>
                <tr>
                    <th class="center">
                        <s:text name="web.admin.content.catalog.edit.field.limited" />
                    </th>
                    <td class="left">
                    <s:set name="limitedMap" value="%{cache.getKikakuGenreMap0(adminLogin.kikakuCd)}"/>
                    <s:checkboxlist name="limitedList" list="limitedMap" listKey="key" listValue="value" value="limitedList"></s:checkboxlist>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="right noBorder"><br>
                    <s:submit
                         action="catalogEdit"
                         method="edit"
                         cssStyle="width: 100px; height: 30px;"
                         cssClass="button"
                         value="%{getText('web.admin.content.catalog.edit.button.edit')}"
                     />
                     <s:hidden name="koushinBi" />
                    </td>
                </tr>
            </table>
        </div>
    </div>
    </form>
</div>
