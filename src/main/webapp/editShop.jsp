<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="fcu.android.backend.service.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Edit</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("ShopName");
	String phone = request.getParameter("ShopPhone");
	String email = request.getParameter("ShopEmail");
	String pwd = request.getParameter("ShopPwd");
	String intro = request.getParameter("ShopIntro");
	Double longitude = Double.valueOf(request.getParameter("ShopLongitude"));
	Double latitude = Double.valueOf(request.getParameter("ShopLatitude"));
	
	ShopService shopservice = new ShopService();
	
	shopservice.update(name, pwd, phone, email, intro, longitude, latitude);
%>	

<%
	response.sendRedirect("shopInfo.jsp");
%>
</body>
</html>