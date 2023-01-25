<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일 올리기(AJAX)</title>
		<style>
		.fileDrop {
			width: 100%;
			height: 200px;
			border: 1px dotted blue;
		}
		</style>
	</head>
	<body>
		<jsp:include page="../../common/topMenu.jsp" flush="false"></jsp:include>
		
		<div class="container">
			<h2 align="center">파일 올리기(AJAX)</h2>
			
			<!-- 파일을 떨어뜨리는 영역 -->
			<div class="fileDrop"></div> 
			<!-- 업로드된 파일 목록을 출력하는 영역 -->
			<div class="uploadedList"></div>
			
		</div>
		
		<jsp:include page="../../common/footer.jsp" flush="false"></jsp:include>
		
		
		
		<script> //스크립트는 jQuery를 불러들인 다음에 기술한다. 순서가 바뀌면 jQuery작동x
		$(function(){
			//드래그의 기본효과(사진을 새로운 창으로 보여주기)를 막아준다.
			$(".fileDrop").on("dragenter dragover", function(event) {
				event.preventDefault();
			});
			
			//파일 올리는 영역에 파일을 떨어뜨릴 때 사용할 함수
			$(".fileDrop").on("drop", function(event){
				alert("파일을 떨어뜨렸습니다.");
				
				event.preventDefault(); //그림이 drop 될 때 기본 효과를 막는다.
				
				//첨부파일 배열: 드래그 된 파일을 정보
				//Ctrl + 클릭으로 여러개의 파일을 동시에 올릴 수 있다.
				let files = event.originalEvent.dataTransfer.files;
				let file = files[0]; //첫번째 파일
				
				//파일 정보가 콘솔에 올라간다.
				//웹 브라우저에서 F12키를 누르면 어떤 파일인지 알 수 있다.
				console.log(file);
				
				//AJAX로 서버에 전달 할 때는 폼이 별도로 존재하지 않기 떄문에 폼 객체를 만들어주어야한다.
				let formData = new FormData(); //폼 객체 생성
				
				//폼에 file 변수를 추가한다.
				formData.append("file", file);
				
				//서버에 파일을 업로드 한다.(백그라운드에서 실행된다.)
				//contentType: false => multipart/form-data 로 처리가 된다.
				//processData: false => 일반적으로 서버에 전달하는 데이터는 query string 형태로 전달되기 때문에
				//						data 파라미터로 전달된 데이터를 jquery내부적으로 query string으로 만든다.
				//						파일 전송의 경우 이렇게 하지 않아야 하기 때문에 false로 설정해준다.
				$.ajax({
					type: "post",
					url: "${contextPath}/util/upload/uploadAjax",
					data: formData,
					dataType: "text",
					contentType: false,
					processData: false,
					success: function(data, status, req){
						
						console.log("data: " + data); //업로드 된 파일 이름
						console.log("status: " + status); //업로드 성공, 실패 여부
						console.log("req: " + req); //요청 코드 값
						
						//파일 목록 출력 영역에 출력해준다.
						let str = "";
						str = "<div>";
						
						if(checkImageType(data)) { //이미지파일인 경우
							str += "<a href='${contextPath}/util/upload/displayFile?fileName="
									+ getImageLink(data) + "'>"
									+ "<img src='${contextPath}/util/upload/displayFile?fileName=" //컨트롤러에서 처리가 안되면 엑박으로 나타난다.
									+ data + "'/></a>"
						} else { //이미지가 아닌 경우
							str += "<a href='${contextPath}/util/upload/displayFile?fileName="
								+ data + "'>" + getOriginalName(data) + "</a>";
						}
						
						str += "<span data-src='" + data + "'>[삭제]</span>";
						str += "</div>"
						$(".uploadedList").append(str);
					} //End - success
				}); //End - Ajax
			}); //End - filedrop
			
			//이미지파일인지 검사할 함수
			function checkImageType(fileName) {
				
				var pattern = /jpg|png|jpeg|gif/i; //정규표현식 (i: ignore case()(대소문자 무시))
				
				return fileName.match(pattern); //규칙에 맞으면 참/ 아니면 거짓을 반환한다.
				
			} //End - checkImageType()
			
			//파일의 원래 이름을 가져올 함수
			function getOriginalName(fileName) {
				
				if(checkImageType(fileName)) { //이미지 파일이면 skip
					return;
				}
				
				var idx = fileName.indexOf("_") + 1;
				
				return fileName.substr(idx);
				
			} //End getOriginalName()
			
			//이미지파일의 이름을 가져올 함수
			function getImageLink(fileName) {
				
				if(!checkImageType(fileName)) { //이미지 파일이 아니면 skip
					return;
				}
				
				var front = fileName.substr(0, 12); //연월일 경로(0부터 12앞까지)(/포함)
				var end = fileName.substr(14); //s_다음부터
				
				console.log(front);
				console.log(end);
				
				alert(front + "@@@@@@" + end);
				return front + end; //경로 + s_를 뺀 이름
			} //End - getImageLink()
			
			//[삭제] 버튼을 눌렀을 경우: 첨부파일 삭제하기
			$(".uploadedList").on("click", "span", function(event){
				
				//현재 클릭한 태그 찾기
				var that = $(this);
				alert(that.attr("data-src"));
				
				//[삭제] 버튼을 클릭한 이미지를 서버에게 지우도록 한다.
				$.ajax({
					url: "${contextPath}/util/upload/deleteFile",
					type: "post",
					data: "fileName=" + that.attr("data-src"),
					dataType: "text",
					success: function(result) {
						if(result == "deleted"){
							//서버에서 삭제에 성공하면 div 항목을 삭제한다.
							that.parent("div").remove();
						}
					},
					error: function(error) {
						alert("에러발생!!!");
					},
					complete: function() {
						alert("Complet....")
					}
				});
			});
		});
		</script>
		
		
	</body>
</html>