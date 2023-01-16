/**
 * 
 */
 
 
 function fn_boardRegister(flag) { //게시글 등록
 
 	//게시글 등록 화면에서 입력한 값을 가져온다.
 	
 	let subject = $("#subject").val();
 	let writer = $("#writer").val();
 	let content = $("#content").val();
 	
 	
 	//제목에 값이 없으면 입력하도록 한다.
 	if($("#subject").val() == "") {
 		alert("제목은 필수 입력 항목입니다.");
 		$("#subject").focus();
 		return false;
 	} 
 	
 	//작성자에 값이 없으면 입력하도록 한다.
 	if($("#writer").val() == "") {
 		alert("작성자는 필수 입력 항목입니다.");
 		$("#writer").focus();
 		return false;
 	}
 	
 	//내용에 값이 없으면 입력하도록 한다.
 	if($("#content").val() == "") {
 		alert("내용은 필수 입력 항목입니다.");
 		$("#content").focus();
 		return false;
 	}
 	if(flag == 0){
	 	$.ajax({
	 		type: "POST",
	 		url: "/board/boardRegister",
	 		data: {subject : subject, writer : writer, content : content},
	 		success: function(data) {
	 			if(data == "Y") {
	 				alert("게시글을 등록하였습니다.");
	 				//게시글 등록 완료 후 게시글 목록으로 이동한다.
	 				location.href = "/board/boardList";
	 			}
	 		},
	 		error: function(data) {
	 			alert("게시글 등록에 실패했습니다.");
	 		}
	 	});
	 } else if(flag == 1) {
	 	$.ajax({
	 		type: "POST",
	 		url: "/board/boardRegister",
	 		data: {subject : subject, writer : writer, content : content},
	 		success: function(data) {
	 			if(data == "Y") {
	 				alert("게시글을 등록하였습니다.");
	 				//게시글 등록 완료 후 게시글 목록으로 이동한다.
	 				location.href = "/board/boardList1";
	 			}
	 		},
	 		error: function(data) {
	 			alert("게시글 등록에 실패했습니다.");
	 		}
	 	});
	 }
 }
 
 function fn_boardDelete(bno) { //게시글 삭제
 	
 	//삭제를 진행 하기 전에 삭제 여부를 확인한다.
 	
 	if(!confirm("게시글을 삭제하시겠습니까?\n\n삭제하시려면 확인 버튼을 누르시고 아니면 취소 버튼을 누르세요.")) {
 		alert("게시글 삭제를 취소하셨습니다.");
 	} else {
 		$.ajax({
 			type: "POST",
 			url: "/board/boardDelete",
 			data: {bno : bno},
 			success : function(data) {
 				if(data == "Y"){
 					alert("게시글 삭제가 완료되었습니다.");
 					location.href="/board/boardList";
 				}
 			},
 			error: function(data){
 				alert("게시글 삭제하는데 문제가 발생했습니다.");
 			},
 			done : function(data){
 				alert("요청 성공");
 			},
 			fail: function(data){
 				alert("요청 실패");
 			},
 			always: function(data){
 				alert("요청 완료");
 			}
 		});
 	}
 }
 
 function fn_boardUpdateForm(bno) { //게시글 수정 폼 불러오기
 
 	//수정 하기 전에 수정 여부를 확인한다.
 	if(!confirm("게시글을 수정하시겠습니까?\n\n수정하시려면 확인 버튼을 누르시고 아니면 취소 버튼을 누르세요.")) {
 		alert("게시글 수정을 취소하셨습니다.");
 	} else {
 		//게시글 form에 action을 지정해준다.
 		var f = $("#frm");
 		f.attr("action", "/board/boardUpdateForm");
 		f.attr("method", "POST");
 		
 		//넘겨줄 bno가 없기때문에 input 항목을 임의로 만들어서 데이터를 넘긴다.
 		f.append($("<input/>", {type: 'hidden', name: "bno", value: bno}));
 		f.appendTo('body'); //body에 적용
 		f.submit();
 	}
 }
 
 function fn_boardUpdate(bno, flag) { //게시글 수정하기
 
 	//게시글 수정 화면에서 입력한 값을 가져온다.
 	
 	let subject = $("#subject").val();
 	let writer = $("#writer").val();
 	let content = $("#content").val();
 	
 	
 	//제목에 값이 없으면 입력하도록 한다.
 	if($("#subject").val() == "") {
 		alert("제목은 필수 입력 항목입니다.");
 		$("#subject").focus();
 		return false;
 	} 
 	
 	//작성자에 값이 없으면 입력하도록 한다.
 	if($("#writer").val() == "") {
 		alert("작성자는 필수 입력 항목입니다.");
 		$("#writer").focus();
 		return false;
 	}
 	
 	//내용에 값이 없으면 입력하도록 한다.
 	if($("#content").val() == "") {
 		alert("내용은 필수 입력 항목입니다.");
 		$("#content").focus();
 		return false;
 	}
 	
 	
	 	$.ajax({
	 		type: "POST",
	 		url: "/board/boardUpdate",
	 		data: {bno: bno, subject : subject, writer : writer, content : content},
	 		success: function(data) {
	 			if(data == "Y") {
	 				alert("게시글을 수정하였습니다.");
	 				//게시글 수정 후 상세페이지로 이동한다.
	 				fn_boardDetail(bno);
	 			}
	 		},
	 		error: function(data) {
	 			alert("게시글 수정에 실패했습니다.");
	 		}
	 	});
 }
 
 function fn_boardDetail(bno) {
 
 	location.href="/board/boardDetail?bno=" + bno + "&flag=2"; //상세페이지로 가면 조회수가 증가하는데...?
 
 }