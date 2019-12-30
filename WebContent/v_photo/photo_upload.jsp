<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 TRansitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사진 업로드</title>
</head>
<body>
	<center>
		<p>사진 업로드</p>
		<form method="post" action="uploadServlet" enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td>내용: </td>
					<td><input type="text" name="content" size="50"/></td>
				</tr>
				<tr>
					<td>사진: </td>
					<td><input type="file" name="photo" size="50"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="저장">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>