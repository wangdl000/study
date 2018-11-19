<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="Section">
    <table cellspacing="7" class="tableStyle1">
        <tr>
            <td colspan="4" align =left >
                <span class="LeftFloat">
                    <b>
                        <font face="小塚明朝 Pro" Color="#ff0000">
                            <strong>&nbsp;商品一覧&nbsp;&nbsp;<s:property value="itemSearchCondition"/></strong>
                        </font>
                    </b>
                </span>

                <span class="RightFloat">
                    <jsp:include page="../tiles_contents_sub/item_paging.jsp"/>
                </span>
            </td>
        </tr>
        <tr>
        <s:iterator value="itemList" status="itemStatus" begin="#startIdx" end="#lastIdx">
            <td width="25%" valign=top>
                <jsp:include page="../tiles_contents_sub/item_block.jsp" />
            </td>

            <s:if test="#itemStatus.index  == #lastIdx" >
                <%-- 最終行なら行埋め --%>
                <s:iterator status="stat" value="(3 - ((#itemStatus.index - #startIdx) % 4) ).{ #this }" >
                    <td></td>
                </s:iterator>
            </s:if>
            <s:else>
                <%-- 行ごとにテーブルを改行する。 --%>
                <s:if test="((#itemStatus.index + 1) % 4) == 0" >
                    </tr><tr>
                </s:if>
            </s:else>

        </s:iterator>
        </tr>
        <tr>
            <td colspan="4">
                <span class="RightFloat">
                    <jsp:include page="../tiles_contents_sub/item_paging.jsp"/>
                </span>
            </td>
        </tr>
    </table>
</div>
