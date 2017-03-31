<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/include/taglibs.jsp" %>
<c:forEach items="${list }" var="c" varStatus="s">
		<tr>
			<td>
				${list.web_uuid}
			</td>
			<td>
				${list.user_name }
			</td>
			<td>
				${list.visit_count }
			</td>
		</tr>
</c:forEach>
