/**
 * 
 */
 
let file = null;
 
 //파일 업로드 및 썸네일 출력
 function fn_fileUpload() {
 	
 	if(document.getElementById("file").files.length != 0){ //input에서 받은 파일이 있을 때
 	
 		//갖고있는 files 중 0번째를 변수에 저장한다.
 		file = document.getElementById("file").files[0];
 		
 		alert("파일올림." + file);
 	}
 	
 	//이미지 파일인지 검사하기 위해 파일의 이름을 추출한다.
 	var fileName = file.name;
 	
 	//AJAX로 전달해주기 위해 FormData를 생성한다. <form> 과 같은 효과를 가져다주는 key/value 가 저장되는 객체이다.
 	let formData = new FormData();
 	
 	if(!checkImageType(fileName)) {
 	
 		alert("업로드 할 수 있는 파일 형식은 jpg, png, jpeg, gif 입니다.");
 		return;
 		
 	} else {
 	
 		//전달받은 file을 FormData에 넣는다.
 		formData.append("file", file);
 		//alert("formData:" + formData.get("file").name);
 		
 	}
 	
 	//contentType: false :  processData은 default 값이 "application/x-www-form-urlencoded; charset=UTF-8" 인데, 
 	//						"multipart/form-data" 로 전송이 되게 false 로 넣어준다. 
 	//processData: false : processData 관련하여, 일반적으로 서버에 전달되는 데이터는 query string 이라는 형태로 전달된다. 
 	//					   data 파라미터로 전달된 데이터를 jQuery 내부적으로 query string 으로 만드는데, 
 	//					   파일 전송의 경우 이를 하지 않아야 하고 이를 설정하는 것이 processData: false 이다.
 	
 	//ajax로 처리 해준다.(파일을 업로드 하고 업로드한 파일명을 받는다. 다음 처리(파일명으로 파일 다운로드)를 위해)
 	$.ajax({
 		type: "post",
 		url: "/file/upload",
 		data: formData,
 		dataType: "text", //서버가 응답(response)할 때 보내줄 데이터의 타입이다. 이는 success function 에 전달될 argument 의 형태를 지정하는데 사용된다고 한다.
 		contentType: false, //보내는 데이터 타입
 		processData: false,
 		success: function(data, status, req){
 			alert("파일을 저장했습니다. 저장한 이름: " + data);
 			
 			//컨트롤러를 통해 파일 드롭 박스에 썸네일 이미지를 보여준다.//
 			//드롭박스의 글자를 지운다.
 			document.getElementById("p").remove();
 			
 			//드롭박스에 추가해줄 요소
 			let str = "";
 			str = "<a href='/file/display?fileName=" + originalImg(data) + "'>"; //클릭 했을 때 원본 사진을 보여준다.
 			str += "<img src='/file/display?fileName=" + data + "'/></a>"; 
 			
 			//드롭박스에 요소를 추가한다.
 			$(".fileDrop").append(str);
 			
 			//데이터 베이스에 저장된 파일 이름을 저장하기 위해 form에 input 요소를 넣어준다.
 			let str2 = "";
 			str2 = "<div class='form-group'>";
 			str2 += "<input type='hidden' id='images' name='images' value='" + originalImg(data) + "'/>";
 			str2 += "</div>";
 			$("#frm").append(str2);
 		},
 		error: function(data, status, req) {
 			alert("파일을 저장에 실패했습니다.");
 		}
 	}); //End - ajax
 	
 	//이미지 파일인지 검사할 메소드
 	function checkImageType(fileName) {
 	
 		var pattern = /jpg|png|jpeg|gif/i; //정규표현식 (i: ignore case()(대소문자 무시), |: or)
 		
 		return fileName.match(pattern); //파일 이름 규칙에 맞는지 확인 후 참/거짓을 반환한다.
 		
 	} //End - checkImageType();
 	
 }
 
//원본 이미지 이름을 만드는 메소드
function originalImg(fileName) {
 	
 	var front = fileName.substr(0, 12); //연월일 경로(0부터 12앞까지) 
 	var end = fileName.substr(14); //경로, s_ 뒤 이름
 		
 	var name = front + end; //원본이름의 경로와 이름 사이에 s_를 빼서 원본 이미지 이름을 찾는다.
 	
	 return name;
 			
} //End - originalImg();
 
 
//파일을 드래그&드롭 할 때
$(function(){
	 
	//파일드래그의 기본효과를 막아준다.
	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
	}); 
		
	//파일 드롭의 기본효과를 막고 file 정보를 가져온다.
	$(".fileDrop").on("drop", function(event) {
	
		event.preventDefault();
		
		//input에 파일이 있으면 중복되지 않도록 처리한다.
		if(document.getElementById("file").files.length != 0){
			alert("이미 선택된 파일이 있습니다.");
		} else {
			alert("파일을 드롭했습니다.");
			
			//이벤트에서 파일을 추출한다.(여러개를 한번에 올릴 수 있기 때문에 배열형식으로)
			let files = event.originalEvent.dataTransfer.files;
			//추출한 파일 중 0번째를 변수에 저장한다.
			file = files[0];
			
			//파일 드롭 박스 안에 텍스트를 파일 이름으로 변경한다.
			$("#p").text(file.name);
			
		}
	});
});
	