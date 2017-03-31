<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>if(window.top !== window.self){ window.top.location = window.location;}</script>
<jsp:include page="./include/headcss.jsp"></jsp:include>
<jsp:include page="./include/headjs.jsp"></jsp:include>

<style type="text/css">


	table{ margin-top:100px;}
	tr{
		line-height:40px;
	}
	input[type="text"]{
		height:20px;
		width:240px;
	}
		
	input[type="password"]{
		height:20px;
		width:240px;}
	
	.lable{
		text-align:right;
	}
	
	.nav ul li.sel{
		height: 100%;
	}
	
	.nav_2{
		height: inherit;
	}
</style>
</head>
<body>
<jsp:include page="./include/header.jsp"></jsp:include>
<div id="content">
	 <div style="width:100%;clear: both;margin-top:100px;font-size:30px;">尊敬的客户：</div>
	 <div style="width:100%;clear: both;font-size:36px;margin-top: 30px;">欢迎您登录芯盾网上银行演示版系统</div>
</div>
<jsp:include page="./include/footjs.jsp"></jsp:include>
<div id="footer">欢迎使用芯盾网上银行演示版系统</div>

<script type="text/javascript">
var _user_id = 'unkown'; // Set to the user's ID, username, or email address, or '' if not yet known.
var _session_id = '${pageContext.session.id}'; // Set to a unique session ID for the visitor's current browsing session.

var _sift = window._sift = window._sift || [];
_sift.push(['_setAccount', '123']);
_sift.push(['_setUserId', _user_id]);
_sift.push(['_setSessionId', _session_id]);

(function() {
 function ls() {
   var e = document.createElement('script');
   var s = document.getElementsByTagName('script')[0];
   e.src = 'http://www.iitgo.com/dist/s.js';
   s.parentNode.insertBefore(e, s);
 }
 if (window.attachEvent) {
   window.attachEvent('onload', ls);
 } else {
   window.addEventListener('load', ls, false);
 }
})();

</script>
</body>
</html>