<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="fcu.android.backend.service.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- 選擇性佈景主題 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- 最新編譯和最佳化的 JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<title>SuperMenu</title>
</head>
<body>
	<div class="container">
		<form method="post" action="UploadDownloadFileServlet?ShopID=0"
														enctype="multipart/form-data">
			<div class="col-md-6 col-md-offset-3">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3>
							<strong><p class="text-center">註冊</p></strong>
						</h3>

						<h4 class="text-right">
							<a href="index.jsp">回登入畫面</a>
						</h4>
					</div>

					<div class="panel-body">
						<div class="form-group">
							<label for="ShopName" class="control-label">店家名稱：</label> <input
								type="text" class="form-control" name="ShopName" id="ShopName"
								placeholder="吃到飽" required>
						</div>
						<div class="form-group required">
							<label for="ShopEmail" class="control-label">信箱： <span>(信箱將做為登入帳號)</span></label>
							<input type="email" class="form-control" name="ShopEmail"
								id="ShopEmail" placeholder="example@example.com" required>
						</div>
						<div class="form-group required">
							<label for="ShopPwd" class="control-label">密碼：</label> <input
								type="password" class="form-control" name="ShopPwd" id="ShopPwd"
								placeholder="example@example.com" required>
						</div>
						<div class="form-group required">
							<label for="ShopPwdAgain" class="control-label">確認密碼：</label> <input
								type="password" class="form-control" name="ShopPwdAgain"
								id="ShopPwdAgain" required>
						</div>
						<div class="form-group required">
							<label for="ShopPhone" class="control-label">聯絡電話：</label> <input
								type="text" class="form-control"
								placeholder="市內電話：04-xxxxxxxx ; 手機：09xx-xxx-xxx" id="ShopPhone"
								name="ShopPhone">
						</div>
						<div class="form-group required">
							<label for="ShopLongitude" class="control-label">經度： <span>(請輸入店家位置之經度)</span></label>
							<input type="text" class="form-control" placeholder="xxx.xxx"
								id="ShopLongitude" name="ShopLongitude" required>
						</div>
						<div class="form-group required">
							<label for="ShopLatitude" class="control-label">緯度： <span>(請輸入店家位置之緯度)</span></label>
							<input type="text" class="form-control" placeholder="xxx.xxx"
								id="ShopLatitude" name="ShopLatitude" required>
						</div>
						<div class="form-group required">
							<label for="ShopIntro" class="control-label">店家簡介：</label>
							<textarea class="form-control" id="message-text" name="ShopIntro"
								id="ShopIntro" rows="3"></textarea>
						</div>
						<div class="form-group">
							<table border="0">
								<tr>
									<td><label  class="control-label">
											上傳店家圖片
										</label></td>
								</tr>
								<tr>
									<td><h4>上傳檔案：</h4></td>
								</tr>
								<tr>
									<td><input type="file" name="fileName" size="50" /></td>
								</tr>
							</table>
						</div>
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-lg btn-success btn-block">註冊</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>