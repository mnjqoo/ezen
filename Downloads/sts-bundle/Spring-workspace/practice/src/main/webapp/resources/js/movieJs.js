/**
 * 
 */
 
 //게시글 작성
 function fn_movieRegister() {
 	
 	//게시글 등록 화면에서 입력한 값을 가져와서 변수에 저장한다.
 	let title = $("#title").val();
 	let genre = $("#genre").val();
 	let releaseDate = $("#releaseDate").val();
 	let raiting = $("#raiting").val();
 	let director = $("#director").val();
 	
 	//각 항목에 값이 없으면 입력하도록 한다.
 	if($("#title").val() == "") {
 		alert("제목은 필수 입력 항목입니다.");
 		$("#title").focus();
 		return false;
 	} 
 	
 	$.ajax({
 		type: "post",
 		url: "/movie/movieRegister",
 		data: {title: title, genre: genre, releaseDate: releaseDate, raiting: raiting, director:director},
 		success: function(data) {
 			if(data == "Y") {
 				alert("게시글을 등록하였습니다");
 				
 				//등록 완료 후 게시글 목록 화면으로 이동한다.
 				location.href="/movie/movieList";
 			} 
 		},
 		error: function(data) {
 			alert("게시글 등록에 실패하였습니다.");
 		}
 	});
 }
 
 //날짜선택
 $(function() {
 	$("#releaseDate").datepicker();
 });
 
 //게시글 수정
  function fn_movieUpdate(bno) {
 	
 	//게시글 등록 화면에서 입력한 값을 가져와서 변수에 저장한다.
 	let title = $("#title").val();
 	let genre = $("#genre").val();
 	let releaseDate = $("#releaseDate").val();
 	let raiting = $("#raiting").val();
 	let director = $("#director").val();
 	
 	//각 항목에 값이 없으면 입력하도록 한다.
 	if($("#title").val() == "") {
 		alert("제목은 필수 입력 항목입니다.");
 		$("#title").focus();
 		return false;
 	} 
 	
 	$.ajax({
 		type: "post",
 		url: "/movie/movieUpdate",
 		data: {bno: bno, title: title, genre: genre, releaseDate: releaseDate, raiting: raiting, director:director},
 		success: function(data) {
 			if(data == "Y") {
 				alert("게시글을 수정하였습니다");
 				
 				//등록 완료 후 게시글 상세페이지로 이동한다.
 				location.href="/movie/movieDetail?bno=" + bno;
 			} 
 		},
 		error: function(data) {
 			alert("게시글 수정에 실패하였습니다.");
 		}
 	});
 }