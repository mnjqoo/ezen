/**
 * 
 */
 
 var file = null;
 
 //파일 업로드 및 썸네일 출력
 function fn_fileUpload(inputFile) {
 	alert("파일을 올렸습니다." + inputFile);
 	
 	if(inputFile != null){ //input에서 받은 파일이 있을 때
 	
 		//file 변수에 저장한다.
 		file = inputFile;
 	}
 	
 	//AJAX로 전달해주기 위해 FormData를 생성한다.
 	let formData = new FormData();
 	
 	//전달받은 file을 FormData에 넣는다.
 	formData.append("file", file);
 	alert(formData);
 	
 }
 
//파일을 드래그&드롭 할 때
$(function(){
	 
	//파일드래그의 기본효과를 막아준다.
	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
	}); 
		
	//파일 드롭의 기본효과를 막고 file 정보를 가져온다.
	$(".fileDrop").on("drop", function(event) {
		alert("파일 드롭");
		event.preventDefault();
		
		//input에 파일이 있으면 중복되지 않도록 처리한다.
		if(document.getElementById("file") != null){
			alert("이미 선택된 파일이 있습니다.");
		} else {
			alert("파일을 드롭했습니다.")
			
		}
	});
});
	