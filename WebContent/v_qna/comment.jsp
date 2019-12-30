<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
	<div class="qna_commentWrite">
			<div class="textarea">
				<textarea form="commentWrite" name="comment_content" placeholder="댓글 작성란입니다." rows="6"></textarea>
			</div>
		<form action="../comment" method="post" id="commentWrite">
			<input type="hidden" name="num" value="<%= request.getParameter("no") %>">
			<div class="writer"><input type="text" name="writer_c" placeholder="작성자 명"></div>
			<div id="commentSubmit"><input type="submit" value="작성 완료"></div>
		</form>
	</div>

</body>
</html>