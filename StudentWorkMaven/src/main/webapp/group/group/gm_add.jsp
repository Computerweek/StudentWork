<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>社团会议添加页面</title>
<%@ include file="../common/cssjs.inc"%>
<script language="javascript">
	function checkNull() {
		/*判断是否有空内容*/
		for (i = 0; i < form1.length; i++) {
			if (form1.elements[i].value == "") {
				alert(form1.elements[i].title + "不能为空!");
				form1.elements[i].focus();
				return false;
			}
		}
	}
</script>
</head>
<body>
<div class="content-box-header">
		<h3>新增社团会议</h3>
	</div>
	<div class="content-box-content">
		<form name="form1" action="group/addGroupMeeting.action?type=1" method="post"
			onSubmit="return checkNull()">
			<p>
				会议名称：<input class="text-input medium-input" type="text" name="groupMeeting.name" />
			</p>
			<p>
				会议时间：<input class="text-input medium-input" type="text" name="groupMeeting.startTime" />
			</p>
			<p>
			<input type="hidden" name="groupMeeting.groupId" value="<%=request.getParameter("id") %>"/>
			<input type="hidden" name="groupMeeting.st" value="1"/>
			</p>
			<p>
				<input class="button" type="submit" value="新增" /> <input
					class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>

</body>
</html>