<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="pageTitle">
    <span style="font-size: 150%; font-weight: bold;">
        <s:text name="web.admin.content.user.list.title" />
    </span>
    <div style="clear: both; margin: 0px; padding: 2px 0pt; text-align: right; vertical-align: middle; border-top: 2px solid rgb(0, 0, 255);"></div>
</div>
<form action="user_list!page_change" >
<div class="adminMainArea" id="mainArea">
    <div class="main">
        <div style="width: 92%; padding: 8px; background: none repeat scroll 0% 0% rgb(192, 192, 192); border: 1px solid rgb(128, 128, 128);" class="center">
            <table width="100%">
                <colgroup width="12%"></colgroup>
                <colgroup width="22%"></colgroup>
                <colgroup width="12%"></colgroup>
                <colgroup width="44%"></colgroup>
                <colgroup width="10%"></colgroup>
                <tbody><tr>
                    <td class="left">
                        <s:text name="web.admin.content.user.list.field.kikakuCd"/>
                    </td>
                    <td class="left" colspan="3" >
                        <s:if test="%{adminLogin.svFlg==\"1\"}">
                            <s:set name="subKikakuMap" value="%{cache.kikakuMap}"/>
                        </s:if>
                        <s:else>
                            <s:set name="subKikakuMap" value="#{adminLogin.kikakuCd:cache.kikakuMap.get(adminLogin.kikakuCd)}"/>
                        </s:else>
                        <s:select label=""
                                headerKey="%{getText('web.admin.content.user.list.field.kikakuCd.headerKey')}"
                                headerValue="%{getText('web.admin.content.user.list.field.kikakuCd.headerValue')}"
                                name="kikakuCd"
                                list="subKikakuMap"
                                listKey="key"
                                listValue="value"
                                multiple="false"
                                size="1"
                                required="true"
                                cssErrorClass="fieldError"
                                cssClass="select"
                        />
                        <s:fielderror>
                            <s:param>kikakuCd</s:param>
                        </s:fielderror>
                    </td>
                </tr>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.user.list.field.kanriUserId"/>
                    </td>
                    <td class="left">
                        <s:textfield name="kanriUserId" cssErrorClass="fieldError" maxlength="20" size="22" cssClass="imeoff" />
                        <s:fielderror>
                            <s:param>kanriUserId</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:text name="web.admin.content.user.list.field.kanriUserNm"/>
                    </td>
                    <td colspan="2" class="left">
                        <s:textfield name="kanriUserNm" cssErrorClass="fieldError" maxlength="20" size="22" cssClass="imeon" />
                        <s:fielderror>
                            <s:param>kanriUserNm</s:param>
                        </s:fielderror>
                    </td>
                </tr>
                <tr>
                    <td class="left">
                        <s:text name="web.admin.content.user.list.field.siyouKahiFlg"/>
                    </td>
                    <td class="left">
                        <s:select label=""
                                headerKey="%{getText('web.admin.content.user.list.field.siyouKahiFlg.headerKey')}"
                                headerValue="%{getText('web.admin.content.user.list.field.siyouKahiFlg.headerValue')}"
                                name="siyouKahiFlg"
                                list="%{getCodeMap(5050)}"
                                listKey="key"
                                listValue="value"
                                multiple="false"
                                size="1"
                                required="true"
                                cssErrorClass="fieldError"
                                cssClass="select"
                        />
                        <s:fielderror>
                            <s:param>siyouKahiFlg</s:param>
                        </s:fielderror>
                    </td>
                    <td class="left"></td>
                    <td class="left">
                        &nbsp;</td>
                    <td class="left">
                        <s:submit
                            action="user_list"
                            method="submit_search"
                            value="%{getText('web.admin.content.user.list.button.search')}"
                            cssStyle="width: 100px; height: 20px;"
                            cssClass="button"
                            cssErrorClass="fieldError"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="4" class="left"></td>
                    <td class="left">
                        <s:if test="%{adminLogin.svFlg==\"1\"}">
                            <s:url id="userRegistUrl" namespace="/webadmin" action="user_regist" method="regist"></s:url>
                            <input
                                type="button"
                                onclick="location.href = '<s:property value="userRegistUrl"/>';"
                                value='<s:text name="web.admin.content.user.list.button.add"/>'
                                style="width: 100px; height: 20px;"
                                class="button"
                            />
                        </s:if>
                    </td>
                </tr>
            </tbody></table>
        </div>
        <s:actionmessage/>
        <s:actionerror/>
            <s:if test="%{kanrisyaUserKikakuList.size != 0}">
                <div class="pager" style="display: ;">
                    <table width="100%">
                        <colgroup width="50%"></colgroup>
                        <colgroup width="25%"></colgroup>
                        <colgroup width="25%"></colgroup>
                        <tbody><tr>
                            <td class="left">

                                <s:set name="PAGING_PAGE_INDEX" value="pageIndex" />
                                <s:set name="PAGING_START_INDEX" value="startIndex" />
                                <s:set name="PAGING_LIST_CNT" value="listCnt" />
                                <s:set name="PAGING_TOTAL_REC_CNT" value="totalRecCnt" />
                                <s:set name="PAGING_NOW_VIEW_LIST_SIZE" value="kanrisyaUserKikakuList.size()" />
                                <s:set name="PAGING_SORT_ORDER_NAME" value="%{'sortItem'}" />
                                <s:set name="PAGING_SORT_ORDER_VALUE" value="sortItem" />

                                <s:set name="PAGING_ACTION_NAMESPACE" value="%{'/webadmin'}" />
                                <s:set name="PAGING_ACTION_PATH_NAME" value="%{'user_list'}" />
                                <s:set name="PAGING_ACTION_METHOD" value="%{'page_change'}" />

                                <jsp:include page="../contents_sub/paging.jsp" />
                            </td>
                            <td class="right">
                                <s:text name="web.admin.content.user.list.field.sortItem"/>
                                <s:select label=""
                                        name="sortItem"
                                        list="%{getCodeMap(5250)}"
                                        listKey="key"
                                        listValue="value"
                                        onchange="submit();"
                                        multiple="false"
                                        size="1"
                                        required="true"
                                />
                            </td>
                            <td class="right">
                                <s:text name="web.admin.content.user.list.field.listCnt"/>
                                <s:select label=""
                                        name="listCnt"
                                        list="%{getCodeMap(5450)}"
                                        listKey="key"
                                        listValue="value"
                                        onchange="submit();"
                                        multiple="false"
                                        size="1"
                                        required="true"
                                />
                            </td>
                        </tr>
                    </tbody></table>
                </div>
                <div style="display: ;margin-top: 10px;">
                    <table width="95%" class="itemListTable">
                        <colgroup width="20%"></colgroup>
                        <colgroup width="20%"></colgroup>
                        <colgroup width="20%"></colgroup>
                        <colgroup width="10%"></colgroup>
                        <colgroup width="10%"></colgroup>
                        <tbody>
                            <tr>
                                <th>
                                    <s:text name="web.admin.content.user.list.result.head.kanriUserId" />
                                </th>
                                <th>
                                    <s:text name="web.admin.content.user.list.result.head.kanriUserNm" />
                                </th>
                                <th>
                                    <s:text name="web.admin.content.user.list.result.head.kikakuName" />
                                </th>
                                <th>
                                    <s:text name="web.admin.content.user.list.result.head.siyouKahiFlg" />
                                </th>
                                <th>
                                    <s:text name="web.admin.content.user.list.result.head.edit" />
                                </th>
                            </tr>
                            <s:iterator value="kanrisyaUserKikakuList" status="userStatus">
                                <tr>
                                    <td class="left">
                                        <s:property value="kanriUserId" /><br>
                                    </td>
                                    <td class="left">
                                        <s:property value="kanriUserNm" /><br>
                                    </td>
                                    <td class="left">
                                        <s:property value="kikakuName" /><br>
                                    </td>
                                    <td class="center">
                                        <s:property value="%{getCodeValue(5620,siyouKahiFlg)}"/><br>
                                    </td>
                                    <td>
                                    <s:url id="userUrl" namespace="/webadmin" action="user_edit" method="edit">
                                        <s:param name="kanriUserId" value="kanriUserId"/>
                                    </s:url>
                                        <s:a href="%{userUrl}">
                                            <s:text name="web.admin.content.user.list.result.body.link.edit" /><br>
                                        </s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
            </s:if>
    </div>
</div><!-- mainArea -->
</form>