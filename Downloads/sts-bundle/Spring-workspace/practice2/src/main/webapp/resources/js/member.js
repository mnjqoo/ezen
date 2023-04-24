/**
 * 
 */
 
 //로그인하기
 function fn_loginCheck() {
 
 	//input의 값을 가져와서 변수에 저장한다.
 	let email = $("#email").val();
 	let password = $("#password").val();
 	
 	//각 항목에 입력한 값이 없으면 입력하도록 한다.
 	if($("#email").val() == "") {
 		alert("이메일을 입력해주세요.");
 		$("#email").focus();
 		return false;
 	}
 	if($("#password").val() == "") {
 		alert("비밀번호를 입력해주세요.");
 		$("#password").focus();
 		return false;
 	}
 	
 	$.ajax({
 		type: "post",
 		url: "/member/login.do",
 		data: {email: email, password: password},
 		success: function(data) {
 		
 			if(data == 1) {
 				if(confirm("회원으로 존재하지 않는 이메일입니다.\n회원가입 하시겠습니까?")){
 					location.href = "/member/register.form";
 				}
 			} else if (data == 2) {
 				alert("비밀번호가 올바르지 않습니다.");
 			} else {
 				location.href = "/main.form";
 			}
 		},
 		error: function(data) {
 			alert("로그인 통신에 실패했습니다.");
 		}
 	
 	});
 
 }
 
 
 //회원 유형에 따른 양식 변화//
 

 $(document).ready(function(){
 	
 	
 	//가입 유형에 따른 양식===============================================//
 	
 	$(".userType").click(function() {
 		
 		var user = $(this).val();
 		
 		if(user == "D"){			//가입유형이 운송기사일 때
 		
 			//추가 양식 보이기
 			$(".driver_form").css("display", "block");
 			
 			//label과 input 꾸밈 바꾸기
		  	var input = $(".register_input");
		 	
		 	input.focus(function(){
		 		
		 		$(this).parent().children("label").css({"color" : "#000"}); //label의 색을 변경하고
		 		$(this).parent().children("label").animate({				 //크기와 위치를 이동한다.
		 				"top" : "-12px", 
		 				"font-size" : "11px"
		 			}, 200);
		 		$(this).css({"box-shadow" : "none", "border" : "1px solid #000"}); //input 테두리를 변경한다.
		 		
		 	});
		 	
		 	input.blur(function(){
		 		
		 		$(this).css({"box-shadow" : "none", "border" : "1px solid #cccccc"}); //input 테두리를 원래 스타일로 바꾼다.
		 		
		 		if($(this).val() == "") { //입력된 값이 없으면
		 			
		 			$(this).parent().children("label").css({"color" : "#5c6164", "top" : "3px", "font-size" : "14px"}); //label을 원래 스타일로 바꾼다.
		 			$(this).parent().children("span").css({"visibility" : "visible"});									 //숨겨놨던 "필수"span을 보여준다.
		 			$(this).css({"box-shadow" : "none", "border" : "1px solid #da0505"});								 //input 테두리를 바꾼다.
		 			
		 		} else { //입력된 값이 있으면
		 		
		 			$(this).parents().children("span").css({"visibility" : "hidden"}); //"필수"span을 숨김상태로 유지한다.
		 		}
		 	});			
 		} else {			//가입 유형이 개인/업체 일때
 			
 			//추가 양식 숨기기
 			$(".driver_form").css("display", "none");
 		}
 		
 		
 	}); //가입 유형에 따른 양식 끝===========================================================
 	
 
 	
 	
 	//회원가입 양식 움직임====================================================================//
 	
 	//생년월일 input을 눌렀을 때
 	$("#userBirthDate, #licenseDate").datepicker({
 	
		//날짜 선택 후 값이 들어가지 않을 때
 		onSelect: function() {
 			var date = $(this).datepicker('getDate');
 			if(date != null) {
 				$(this).parents().children("label").css({"color" : "#000"});
 				$(this).parents().children("label").animate({
 					"top" : "-12px", 
 					"font-size" : "11px"
 				}, 200);
 				$(this).css({"box-shadow" : "none", "border" : "1px solid #000"});
 				$(this).parents().children("span").css({"visibility" : "hidden"});
 			}
 		}
 	});
 	$.datepicker.setDefaults({
 		maxDate: "+0m +0w", //선택 할 수 있는 최대 날짜를 지정한다. [+, -][숫자][y, m, w, d] 최소도 가능
 		minDate:   "-100y", // 100년전 날짜까지 보여준다
		yearRange: 'c-100:c+0', // 리스트박스에 보여줄 범위
		showOn: "both", //버튼과 텍스트 필드 모드 캘린더를 보여준다.
		changeYear: true, //년도를 바꿀 수 있는 select 박스 보기 옵션
		changeMonth: true, //월을 바꿀 수 있는 select 박스 보기 옵션
		showAnim: "slide", //캘린더에 애니메이션을 적용한다.
		dateFormat: "yy-mm-dd", //날짜 형식을 적용한다.
		prevText: '이전 달', //마우스 오버시 이전달이라는 텍스트 말풍선 도움말을 보여준다.
		nextText: '다음 달', //마우스 오버시 이전달이라는 텍스트 말풍선 도움말을 보여준다.
		closeText: '닫기', //닫기 버튼 텍스트 변경
		currentText: '오늘', //오늘 버튼 텍스트 변경
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], //월을 한글로 변경
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토', '일'], //요일을 한글로 변경
		showMonthAfterYear: true, //년 월 순서로 표기한다.
		showButtonPanel: true //오늘로 가는 버튼과 달력 닫기 버튼 보기 옵션
	});
 	
 	// 그 외 input을 눌렀을 때 
 	
 	var input = $(".register_input");
 	
 	input.focus(function(){		//input에 포커스가 갔을 때
 		
 		$(this).parent().children("label").css({"color" : "#000"}); //label의 색을 변경하고
 		$(this).parent().children("label").animate({				 //크기와 위치를 이동한다.
 				"top" : "-12px", 
 				"font-size" : "11px"
 			}, 200);
 		$(this).css({"box-shadow" : "none", "border" : "1px solid #000"}); //input 테두리를 변경한다.
 		
 	});
 	
 	input.blur(function(){		//input에 포커스가 해제 될 때
 		
 		$(this).css({"box-shadow" : "none", "border" : "1px solid #cccccc"}); //input 테두리를 원래 스타일로 바꾼다.
 		
 		if($(this).val() == "") { //입력된 값이 없으면
 			
 			$(this).parent().children("label").css({"color" : "#5c6164", "top" : "3px", "font-size" : "14px"}); //label을 원래 스타일로 바꾼다.
 			$(this).parent().children("span").css({"visibility" : "visible"});									 //숨겨놨던 "필수"span을 보여준다.
 			$(this).css({"box-shadow" : "none", "border" : "1px solid #da0505"});								 //input 테두리를 바꾼다.
 			
 		} else { //입력된 값이 있으면
 		
 			$(this).parents().children("span").css({"visibility" : "hidden"}); //"필수"span을 숨김상태로 유지한다.
 		}
 	});
 	
 	
 	//면허 사진 업로드 시 파일 이름 input에 뿌려주기
	$("#licenseImage").on('change',function(){
		var fileName = $("#licenseImage").val();
		$("#uploadLicenseImage").val(fileName);
		
	});
 	
 	//필수 동의 사항 내용 보기 클릭시
 	$(".joinAgreeP").on('click',function(){
		//alert($(this).text());
		//해당 p 요소의 다음 div의 css를 변경한다.
		$(this).next().toggle();
		
	});
 	
 	//회원가입 양식 움직임 끝======================================================================
 });
 
 //번호에 숫자만 보이게 한 후 자동으로 - 추가 해주는 함수========================================
function inputPhoneNumber() {
	
	//휴대폰 번호
	var userPhone = document.getElementById("userPhone");		   
    var phoneNumber = userPhone.value.replace(/[^0-9]/g, "").replace(/(\..*)\./g, '$1');
    var phone = "";
    if(phoneNumber == ""){
    	userPhone.value = "";
    }
    if(phoneNumber.length < 4) {
        return phoneNumber;
    } else if(phoneNumber.length < 8) {
        phone += phoneNumber.substr(0, 3);
        phone += "-";
        phone += phoneNumber.substr(3);
    } else {
        phone += phoneNumber.substr(0, 3);
        phone += "-";
        phone += phoneNumber.substr(3, 4);
        phone += "-";
        phone += phoneNumber.substr(7);
    }
    userPhone.value = phone;
    
    //면허 번호
    var licenseNum = document.getElementById("licenseNum");		   
    var licenseNumber = licenseNum.value.replace(/[^0-9]/g, "").replace(/(\..*)\./g, '$1');
    var license = "";
    if(licenseNumber == ""){
    	licenseNum.value = "";
    }
    if(licenseNumber.length < 2) {
        return licenseNumber;
    } else if(licenseNumber.length < 4) {
        license += licenseNumber.substr(0, 2);
        license += "-";
        license += licenseNumber.substr(2);
    } else if(licenseNumber.length < 10) {
        license += licenseNumber.substr(0, 2);
        license += "-";
        license += licenseNumber.substr(2, 2);
        license += "-";
        license += licenseNumber.substr(4);
    } else {
        license += licenseNumber.substr(0, 2);
        license += "-";
        license += licenseNumber.substr(2, 2);
        license += "-";
        license += licenseNumber.substr(4, 6);
        license += "-";
        license += licenseNumber.substr(10);
    }
    licenseNum.value = license;
}
 
 
 //=======================================================================
 //사진 업로드/삭제를 위한 파일 변수
 let file = null;
 
 //이미지 파일인지 검사할 메소드
 function checkImageType(fileName) {

	var pattern = /jpg|png|jpeg|gif/i; //정규표현식 (i: ignore case()(대소문자 무시), |: or)
	
	return fileName.match(pattern); //파일 이름 규칙에 맞는지 확인 후 참/거짓을 반환한다.
	
 } //End - checkImageType();
//========================================================================

 //회원 가입 가입하기 버튼 클릭시 해당 정보가 담긴 팝업 창을 띄운다.
 function fn_popup() {
 	
 	//input에서 입력한 정보를 가져온다.
 	var userType = document.querySelector('input[name="userType"]:checked').value;
 	if(userType == "C") {				//value값에 따라 텍스트를 지정해준다.
 		userType = "개인/업체";
 	} else {
 		userType = "운송기사";
 	}
 	var email = document.getElementById("userEmail");
 	var name = document.getElementById("userName");
 	var phone = document.getElementById("userPhone");
 	var birthDate = document.getElementById("userBirthDate");
 	var licenseNum = document.getElementById("licenseNum");
 	var pwd = document.getElementById("userPwd");
 	var repwd = document.getElementById("rePwd");
 	var licenseNum = document.getElementById("licenseNum");
 	var licenseDate = document.getElementById("licenseDate");
 	var licenseImage = document.getElementById("licenseImage");
 	
 	/*필수 입력 사항들을 확인한다.*/
 	//이메일 입력 값이 없을 때
 	if(email.value == ""){
 		email.focus();
 		return false;
 	}
 	
 	var check = "";
 	
 	//이메일이 중복인지
 	$.ajax({
 		type: "post",
 		url: "/member/emailCheck.do",
 		data: {user_email:email.value, user_type:userType},
 		success: function(data) {
 			
 			if(data > 0) {		//이메일이 이미 존재하는 경우
 				alert("이미 사용중인 이메일입니다. \n다른 이메일을 입력해주세요");
 				email.focus();
 				check = "1";
 				//document.querySelector(".popupBackground").className = "popupBackground";
 				//return false;
 			}
 		}
 	});
 	
 	console.log(check);
 	
 	if(check == "1") {		//이메일이 이미 존재하는 경우
 				alert("확인");
 				email.focus();
 				return false;
 			}
 	
 	//비밀번호 입력 값이 없을 때
 	if(pwd.value == ""){
 		pwd.focus();
 		return false;
 	}
 	//비밀번호와 비밀번호 확인 값이 다를 때
 	if(pwd.value != repwd.value){
 		alert("비밀번호 확인 번호가 다릅니다. 다시 입력해주세요");
 		repwd.focus();
 		return false;
 	}
 	//이름 입력 값이 없을 때
 	if(name.value == ""){
 		name.focus();
 		return false;
 	}
 	//휴대폰번호 입력 값이 없을 때
 	if(phone.value == ""){
 		phone.focus();
 		return false;
 	}
 	//생년월일 입력 값이 없을 때
 	if(birthDate.value == ""){
 		birthDate.focus();
 		return false;
 	}
 	
 	//가입 유형이 운송기사 일 때 추가 확인 사항
 	if(userType == "운송기사") {
 	
 		//면허 번호가 없을 때
	 	if(licenseNum.value == ""){
	 		licenseNum.focus();
	 		return false;
	 	}
 	
 		//면허 사진 첨부가 안되어있을때
 		if(licenseImage.files.length == 0){ //input에서 받은 파일이 없으면
 	
	 		alert("면허 사진 첨부는 필수입니다. 사진 파일을 확인해주세요.");
	 		$("#licenseImageLabel").css("box-shadow", "2px 2px 3px #3f8acc");
	 		return false;
 		
 		} else { //파일이 있는 경우
 		
 			//갖고있는 files 중 0번째를 변수에 저장한다.
 			file = licenseImage.files[0];
 			
 			//이미지 파일인지 확장자를 검사하기 위해 파일의 이름을 추출한다.
 			var fileName = file.name;
 			
 			//함수를 이용해 이미지 파일인지 확인한다.
 			if(!checkImageType(fileName)) { //이미지가 아니면
			
				alert("업로드 할 수 있는 파일 형식은 jpg, png, jpeg, gif 입니다. 사진 파일을 확인해주세요.");
				$("#licenseImageLabel").css("box-shadow", "2px 2px 3px #3f8acc");
	 			$("#licenseImageLabel").css("border", "1px solid #3f8acc");
	 			file = null;
				return false;
				
			} else { //이미지 파일이면
			
				//팝업창 기사용 Tr에 이름을 뿌려준다.
				$("#popLicenseImage").text(file.name);
				
			}
 		}
 		
 		//팝업창 기사용 Tr에 면허 정보를 뿌려준다.
 		$("#popLicenseNum").text(licenseNum.value);
 		$("#popLicenseDate").text(licenseDate.value);
 		//팝업창의 기사용 Tr을 보여준다.
 		$(".popDriverTr").show();
 	}
	
	//동의 사항들의 체크 여부를 확인한다.
	var agree = document.getElementsByClassName("joinAgreeCheckbox");	//공통 동의 사항
	
	for(let i = 0; i < agree.length; i++) {
		if(!agree[i].checked){
			agree[i].setAttribute("style","box-shadow: 2px 2px 3px #3f8acc;");
			return false;
		}
	}
	if(userType == "운송기사") {
		var agreeD = document.getElementsByClassName("joinAgreeCheckboxD");	//기사 동의 사항
		
		for(let i = 0; i < agree.length; i++) {
			if(!agreeD[i].checked){
				agreeD[i].setAttribute("style","box-shadow: 2px 2px 3px #3f8acc;");
				return false;
			}
		}
	}
		
	//input에서 입력한 정보를 팝업창의 table에 뿌려준다.
	$("#popUserType").text(userType);
	$("#popUserEmail").text(email.value);
	$("#popUserName").text(name.value);
	$("#popUserPhone").text(phone.value);
	$("#popUserBirthDate").text(birthDate.value);
	
	//팝업창을 보여준다.
	document.querySelector(".popupBackground").className = "popupBackground show";
 }
 
 //팝업창 닫기
 function fn_popupClose() {
  document.querySelector(".popupBackground").className = "popupBackground";
}
//=======================================================================================

//팝업창에서 가입하기 버튼 눌렀을 때
function fn_popupJoin() {
	
	//최종 회원 가입에 필요한 데이터
	var user_type = $("#popUserType").text();
	var user_email = $("#popUserEmail").text();
	var user_pwd = $("#userPwd").val();
	var user_name = $("#popUserName").text();
	var user_phone = $("#popUserPhone").text();
	var user_birthdate = $("#popUserBirthDate").text();
	var license_num = $("#popLicenseNum").text();
	var license_date = $("#popLicenseDate").text();
	
	if(user_type == "운송기사") {						//가입유형이 운송기사일 경우
		
		//ajax로 회원가입을 진행한다.
		$.ajax ({
			type: "post",
			url: "/member/register.do",
			data: {user_email:user_email, user_pwd:user_pwd, user_name:user_name, 
			user_phone:user_phone, user_birthdate:user_birthdate, user_type:'D', 
			license_num:license_num, license_date:license_date},
			success: function(data) {
				
				//회원 등록 성공 후 이미지 파일을 업로드 할 준비를 한다.
				//저장되어있든 파일 변수를 ajax로 보내주기 위해 formData에 담는다.
				let formData = new FormData();
				formData.append("file", file);
				//파일 이름으로 쓸 회원 이메일을 formData에 담아준다.
				formData.append("email", user_email);
				
				//ajax formData를 컨트롤러로 보내준다.
				$.ajax ({
					type: "post",
					url: "/image/uploadImage.do",
					processData: false,
					contentType: false,
					data: formData,
					success: function(data) {
					
						//파일 이름이 담긴 data로 t_driver의 image에 업데이트 한다.
						$.ajax ({
							type: "post",
							url: "/member/update.do",
							data: {user_email:user_email, image:data},
							success: function(data) {
								
								if(data == 1) {
									alert("회원 가입 되셨습니다. 감사합니다.");
									location.href = "/main.form";
								}
							}
						});
						
					},
					error: function(data) {
						alert("이미지 파일 업로드에 실패했습니다.");
					},
					
				
				});
				
			}
		});

	} else {											//가입유형이 개인/업체일 경우
	
		//ajax로 회원가입을 진행한다.
		$.ajax ({
			type: "post",
			url: "/member/register.do",
			data: {user_email:user_email, user_pwd:user_pwd, user_name:user_name, 
			user_phone:user_phone, user_birthdate:user_birthdate, user_type:'C'},
			success: function(data) {
				alert("회원 가입 되셨습니다. 감사합니다.");
				location.href = "/main.form";
			}
		});
		
	}
}
 