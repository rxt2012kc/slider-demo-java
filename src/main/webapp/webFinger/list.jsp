<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="/include/headcss.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>芯盾网上银行演示版系统-终端管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/> 
<style type="text/css">
	table{
		text-align: left;
	}
	
	.query_area{
		padding: 10px;
	}
	
	.nav ul li.sel{
		height: 100%;
	}
	
	.nav_2{
		height: inherit;
	}
	.popover{
		z-index: 99999999;
	}
</style>
	<jsp:include page="/include/headjs.jsp"></jsp:include>
	<script src="${ctx }/lib/virtualKeyboard/jqbtk.js"></script>
</head>
<body>
<jsp:include page="/include/header.jsp"></jsp:include>
<div id="content" class="container" style="text-align: left;margin-top: 20px;width: auto;">
	<ol class="breadcrumb">
		<li><a href="#">一卡通</a></li>
		<li class="active">
	  		终端管理<span id="api_version_info"></span>
	  	</li>
	</ol>
	<div class="clearfix"></div>
	
	<table class="table table-condensed table-hover table-bordered">
		<thead>
			<tr>
				<th>web_id</th>
				<th>名称</th>
				<th>次数</th>
			</tr>
		</thead>
		<tbody id="tbody">
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
		</tbody>
	</table>
	
</div>
<div style="height: 70px;">
</div>
<div id="footer">
	欢迎使用芯盾网上银行演示版系统
</div>

<jsp:include page="/include/footjs.jsp"></jsp:include>
<script type="text/javascript">
	function query(ignore){
		$.get("${ctx }/webFinger/query.action", function (htm){
			if(htm.length < 5){
				if(!ignore){
					layer.msg("没有找到设备", {
						icon:5,
						time:2000,
						shade:0.3,
						shadeClose: true
					});
				}
			}
			$("#tbody").html(htm);
		})
	}
</script>

</body>
</html>