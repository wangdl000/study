<%@ page language="java"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script language="javascript">
function addRow(){
	//テーブルのオブジェクトを取得する。
	var table = document.getElementById("meisaiTable");
	var cloneTab = document.getElementById("meisaiTableTmp");

	var tmpIndex = document.getElementById("tmpIndex").value;

	document.getElementById("tmpIndex").value = Number(tmpIndex) + 1;

	var cloneTabChild = cloneTab.firstChild.firstChild.cloneNode(true);

	cloneTabChild.childNodes[0].firstChild.setAttribute("name","codeList["+tmpIndex+"]");
	cloneTabChild.childNodes[1].firstChild.setAttribute("name","valueList["+tmpIndex+"]");
	cloneTabChild.childNodes[2].firstChild.setAttribute("name","bikouList["+tmpIndex+"]");
	cloneTabChild.childNodes[3].firstChild.setAttribute("name","sortOrderList["+tmpIndex+"]");
	cloneTabChild.childNodes[4].firstChild.setAttribute("name","siyouKahiFlgList["+tmpIndex+"]");
	cloneTabChild.childNodes[5].lastChild.previousSibling.previousSibling.previousSibling.setAttribute("name","delFlgList["+tmpIndex+"]");
	cloneTabChild.childNodes[5].lastChild.previousSibling.setAttribute("name","koushinBiList["+tmpIndex+"]");

	table.lastChild.appendChild(cloneTabChild);
}
function changeValue(obj){
	if(obj.checked){
		obj.nextSibling.nextSibling.nextSibling.nextSibling.value="1"
	}else{
		obj.nextSibling.nextSibling.nextSibling.nextSibling.value=""
	}
}
</script>
<div id="pageTitle">
    <span style="font-size:150%;font-weight:bold;">
        <s:text name="web.admin.content.code.edit.title" />
    </span>
    <div style="clear: both;margin: 0px 0px 0px 0px;padding: 2px 0;text-align: right;vertical-align:middle;border-top: 2px solid #0000ff;"></div>
</div>
<div id="mainArea" class="adminMainArea">
    <form action="kikakuCodeEdit">
    <s:actionerror/>
    <s:token />
    <div class="main">
        <div style="text-align:left;margin: 5px 0px 0px 40px;">
	        <strong>
	            <s:text name="web.admin.content.code.edit.head.codeJyouhou" />
	        </strong>
        </div>
        <div class="center">
            <table class="itemListTable noBorder" width="90%" id="itemListTable">
                <colgroup width="12%"></colgroup>
                <colgroup width="88%"></colgroup>
                <tr>
                    <th class="left">
                        <s:text name="web.admin.content.code.edit.field.sikibetsuCd" />
                    </th>
                    <td class="left">
                        <s:property value="sikibetsuCd"/>
                        <s:hidden name="sikibetsuCd"></s:hidden>
                    </td>
                </tr>
                <tr>
                    <th class="left">
                        <s:text name="web.admin.content.code.edit.field.sikibetsuNm" />
                    </th>
                    <td class="left">
                        <s:property value="sikibetsuNm"/>
                        <s:hidden name="sikibetsuNm"></s:hidden>
                    </td>
                </tr>
                <tr>
                    <th class="left">
                        <s:text name="web.admin.content.code.edit.field.codeMemo" />
                    </th>
                    <td class="left">
                        <s:property value="codeMemo"/>
                        <s:hidden name="codeMemo"></s:hidden>
                    </td>
                </tr>
            </table>
        </div>

        <br />
        <div style="text-align:left;margin: 0px 0px 0px 40px;">
            <strong>
                <s:text name="web.admin.content.code.edit.head.codeMeisai" />
            </strong>
        </div>
        <div class="center">
            <table class="itemListTable noBorder" width="90%" id="meisaiTable">
                <colgroup width="12%"></colgroup>
                <colgroup width="27%"></colgroup>
                <colgroup width="35%"></colgroup>
                <colgroup width="8%"></colgroup>
                <colgroup width="12%"></colgroup>
                <colgroup width="6%"></colgroup>
                <tr>
                    <th class="left">
                        <s:text name="web.admin.content.code.edit.result.head.code" />
                    </th>
                    <th class="left">
                        <s:text name="web.admin.content.code.edit.result.head.value" />
                    </th>
                    <th class="left">
                        <s:text name="web.admin.content.code.edit.result.head.bikou" />
                    </th>
                    <th class="left">
                        <s:text name="web.admin.content.code.edit.result.head.sortOrder" />
                    </th>
                    <th class="left">
                        <s:text name="web.admin.content.code.edit.result.head.siyouKahiFlg" />
                    </th>
                    <th class="center">
                        <s:text name="web.admin.content.code.edit.result.head.delFlg" />
                    </th>
                </tr>
                <s:iterator value="codeList" status="id">
                <tr>
                    <td class="left">
                        <s:textfield value="%{codeList[#id.index]}" name="codeList[%{#id.index}]" size="5" maxlength="5" cssErrorClass="fieldError" cssClass="imeoff"/>
                        <s:fielderror>
	                       <s:param value="\"codeList[\"+ #id.index +\"]\""></s:param>
	                    </s:fielderror>
                    </td>
                    <td class="left">
                        <s:textfield value="%{valueList[#id.index]}" name="valueList[%{#id.index}]" size="22" maxlength="200" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                           <s:param value="\"valueList[\"+ #id.index +\"]\""></s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:textfield value="%{bikouList[#id.index]}" name="bikouList[%{#id.index}]" size="30" maxlength="500" cssErrorClass="fieldError" cssClass="imeon"/>
                        <s:fielderror>
                           <s:param value="\"bikouList[\"+ #id.index +\"]\""></s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:textfield value="%{sortOrderList[#id.index]}" name="sortOrderList[%{#id.index}]" size="2" maxlength="5" cssErrorClass="fieldError" cssClass="imeoff"/>
                        <s:fielderror>
                           <s:param value="\"sortOrderList[\"+ #id.index +\"]\""></s:param>
                        </s:fielderror>
                    </td>
                    <td class="left">
                        <s:select label=""
                                   name="siyouKahiFlgList[%{#id.index}]"
                                   list="getCodeMap(5020)"
                                   listKey="key"
                                   listValue="value"
                                   multiple="false"
                                   size="1"
                                   required="true"
                                   value="%{siyouKahiFlgList[#id.index]}"
                                   cssErrorClass="fieldError"
                                    />
                         <s:fielderror>
                             <s:param value="\"siyouKahiFlgList[\"+ #id.index +\"]\""></s:param>
                         </s:fielderror>
                    </td>
                    <td class="left">
                        <s:if test="tuikaKahiFlg == 1">
                            <s:if test="delFlgList[#id.index] == \"1\"">
                                <s:checkbox name="delFlgListSel" id="delFlgList" onclick="changeValue(this)" fieldValue="1" value="true"></s:checkbox>
                            </s:if>
                            <s:else>
                                <s:checkbox name="delFlgListSel" id="delFlgList" onclick="changeValue(this)" fieldValue="1"></s:checkbox>
                            </s:else>
                        <s:hidden name="delFlgList[%{#id.index}]" value="%{delFlgList[#id.index]}"></s:hidden>
                        </s:if>
                        <s:else>
                        <s:hidden name="delFlgList[%{#id.index}]" value="0"></s:hidden>
                        </s:else>
                        <s:hidden name="koushinBiList[%{#id.index}]" value="%{koushinBiList[#id.index]}" />
                    </td>
                </tr>
                </s:iterator>
                <s:hidden id="tmpIndex" value="%{codeList.size()}"></s:hidden>
            </table>
            <table class="itemListTable noBorder" width="90%">
                <tr>
                    <td colspan="6" class="right noBorder">
                        <br>
                        <s:submit
                             action="kikakuCodeEdit"
                             method="edit"
                             cssStyle="width: 100px; height: 30px;"
                             cssClass="button"
                             value="%{getText('web.admin.content.code.edit.button.edit')}"
                         />
                        <s:if test="tuikaKahiFlg == 1">
                        &nbsp;&nbsp;
                        <input type="button" value="<s:text name="web.admin.content.code.edit.button.add" />" class="button" style="width:100px;height:30px" onclick="addRow();" >
                        </s:if>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <s:hidden name="tuikaKahiFlg"></s:hidden>
    </form>
    <s:if test="tuikaKahiFlg == 1">
    <table style="display:none;" width="90%" id="meisaiTableTmp">
        <tr>
            <td class="left">
                <s:textfield value="" name="codeList" id="codeList" size="5" maxlength="5" cssErrorClass="fieldError" cssStyle="ime-mode:disabled;"/>
            </td>
            <td class="left">
                <s:textfield value="" name="valueList" size="22" maxlength="200" cssErrorClass="fieldError" cssStyle="ime-mode:active;"/>
            </td>
            <td class="left">
                <s:textfield value="" name="bikouList" id="bikouList" size="30" maxlength="500" cssErrorClass="fieldError" cssStyle="ime-mode:active;"/>
            </td>
            <td class="left">
                <s:textfield value="" name="sortOrderList" id="sortOrderList" size="2" maxlength="5" cssErrorClass="fieldError" cssStyle="ime-mode:disabled;"/>
            </td>
            <td class="left">
                <s:select label=""
                           name="siyouKahiFlgList"
                           list="getCodeMap(5020)"
                           listKey="key"
                           listValue="value"
                           multiple="false"
                           size="1"
                           required="true"
                           cssErrorClass="fieldError"
                            />
            </td>
            <td class="left">
                <s:if test="tuikaKahiFlg == 1">
                <s:checkbox name="delFlgListSel" id="delFlgList" onclick="changeValue(this)" fieldValue="1"></s:checkbox>
                <s:hidden name="delFlgList" value=""></s:hidden>
                </s:if>
                <s:else>
                    &nbsp;
                </s:else>
                <s:hidden name="koushinBiList" value="" />
            </td>
        </tr>
    </table>
    </s:if>
</div>