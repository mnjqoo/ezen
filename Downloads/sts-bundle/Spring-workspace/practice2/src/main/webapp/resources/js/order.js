/*orderRegisterForm*/
/*orderRegisterForm 다음 주소 API ===========================================*/
function fn_daumZipCode(type) {
	
	new daum.Postcode({
		
		oncomplete: function(data) {		//api에서 주소를 선택완료 후
			
			var fullAddr = '';	//최종 주소값을 저장할 변수
			var subAddr = '';	//법정도명, 건물명을 저장할 변수
			
			if(data.userSelectedType == 'R') {
				//도로명 주소가 선택된 경우
				fullAddr = data.roadAddress;
				
				if(data.bname != '') {
					//법정도명이 있을 경우
					subAddr += data.bname;
				}
				if(data.buildingName != '') {
					//건물명이 있을 경우 법정도명이 있으면 앞에 ,를 붙여준다.
					subAddr += (subAddr != '' ? ', ' + data.buildingName : data.buildingName);
				}
				
				//최종 주소에 subAddr을 양쪽에 괄호를 붙여서 추가해준다.
				fullAddr += (subAddr != '' ? '(' + subAddr +' )' : ' ');
				
			} else {
				//지번 주소가 선택된 경우
				fullAddr = data.jibunAddress;
			}
			
			//준비된 주소를 알맞는 위치에 뿌려준다.
			if(type == 'D') {
				//출발지인 경우
				document.getElementById('departurePostnum').value	= data.zonecode;
				document.getElementById('departureAddress1').value	= fullAddr;
			} else {
				//도착지인 경우
				document.getElementById('arrivalPostnum').value	= data.zonecode;
				document.getElementById('arrivalAddress1').value	= fullAddr;
			}
		}
	
	}).open({
		//팝업창이 여러개 열리는 것을 방지하기 위해 이름을 지정해준다.
		popupName: "postcodePopup"
	});

} //=======================================================================================
/* orderRegisterForm 결제 예정 금액 계산해서 뿌려주기 ====================================*/
function fn_calcPrice() {
	
	//트럭 종류와 거리 값을  가져온다.
	var truck_type = document.getElementById("truck_type").value;
	var distance = document.getElementById("distance").value;
	
	//ajax를 통해 금액을 가져온다.
	$.ajax({
		type: "post",
		url: "/order/calcPrice.do",
		data: {truck_type:truck_type, distance:distance},
		success: function(data) {
			
			//금액을 필요한 위치에 뿌려준다.
			document.getElementById("price").innerText = data + "만원";
		}
	});

}
/* orderRegisterForm 운송 메모 직접입력 관련 함수 =======================================*/
function fn_orderMemo() {

	var select = document.getElementById("orderMemo"); 
 	var input = document.getElementById("order_memo"); 
	
	if(select.value == "makeMemo") {
		//직접입력을 선택하면 숨겨놨던 input의 value를 지우고 보여준다.
		input.value = "";
		input.style.display = 'block';
	} else {
		//그 외의 값을 선택하면 input을 숨기고 값을 value로 넣어준다.
		var memo = $("#orderMemo option:selected").text();
 		input.value = memo;
 		input.style.display = 'none';
	}
}
/* orderRegisterForm 운송 예약하기=======================================================*/
function fn_orderRegister(email) {
	
	//필요한 요소들을 가져온다.
	var user_email = document.getElementById("clientEmail").innerText;
	var departure_postnum = document.getElementById("departurePostnum").value;
	var departure_address1 = document.getElementById("departureAddress1").value;
	var departure_address2 = document.getElementById("departureAddress2").value;
	var arrival_postnum = document.getElementById("arrivalPostnum").value;
	var arrival_address1 = document.getElementById("arrivalAddress1").value;
	var arrival_address2 = document.getElementById("arrivalAddress2").value;
	var order_memo = document.getElementById("order_memo").value;
	var truck_type = document.getElementById("truck_type").value;
	var distance = document.getElementById("distance").value;
	var order_price = document.getElementById("price").innerText;
	
	//체크박스 체크 여부를 확인한다.
	if(!document.getElementById('userCheck').checked) {
		alert("예약자 확인 체크를 해주세요");
		document.getElementById('userCheck').setAttribute("style","box-shadow: 2px 2px 3px #3f8acc;");
		return false;
	}
	//요소들의 값들이 있는지 확인한다.
	if(departure_postnum == "") {
		document.getElementById("departurePostBtn").focus();
		return false;
	}
	if(departure_address2 == "") {
		if(confirm("상차지의 상세주소 없이 예약 하시겠습니까?")) {
			document.getElementById("departureAddress2").value = " ";
		} else {
			document.getElementById("departureAddress2").focus();
			return false;
		}
	}
	if(arrival_postnum == "") {
		document.getElementById("arrivalPostBtn").focus();
		return false;
	}
	if(arrival_address2 == "") {
		if(confirm("하차지의 상세주소 없이 예약 하시겠습니까?")) {
			document.getElementById("arrivalAddress2").value = " ";
		} else {
			document.getElementById("arrivalAddress2").focus();
			return false;
		}
	}
	
	//ajax로 운송 예약을 등록한다.
	$.ajax({
		type: "post",
		url: "/order/orderRegister.do",
		data: {client_email:user_email, departure_postnum:departure_postnum, departure_address1:departure_address1, 
		departure_address2:departure_address2, arrival_postnum:arrival_postnum, arrival_address1:arrival_address1, 
		arrival_address2:arrival_address2, order_memo:order_memo, truck_type:truck_type, distance:distance, 
		order_price:order_price, order_state:'1'},
		success: function(data) {
			
			if(data == 1) {
				alert("예약이 완료 되었습니다.");
				location.href="/order/orderList.form?arrayType=r";
			}
		}
	});
}

/*orderList*/

$(document).ready(function() {

	//예약하기 버튼을 누르면 밑에 도착 예정 시간 테이블 보이기===============================================================
	var timeBtn = $(".makeTimeTable");
	
	timeBtn.click(function() {
		//누른 버튼을 기준으로 부모 table 요소를 찾고 바로 다음 테이블을 찾는다.
		var timeTable = $(this).parent().parent().parent().parent().parent().next();
		//숨겨진 toggle 형식으로 보이게 한다.
		timeTable.toggle(); 
		
	}); //==================================================================================================================
	//운송 완료 예정 날짜 설정
	$(".boodOrderDate").datepicker({
		
	});
	$.datepicker.setDefaults({
 		maxDate: "+0m +0w +1d", //선택 할 수 있는 최대 날짜를 지정한다. [+, -][숫자][y, m, w, d] 최소도 가능
 		minDate:   "-0m -0w -0d", // 100년전 날짜까지 보여준다
		showOn: "both", //버튼과 텍스트 필드 모드 캘린더를 보여준다.
		showAnim: "slideDown", //캘린더에 애니메이션을 적용한다.
		dateFormat: "yy-mm-dd", //날짜 형식을 적용한다.
		closeText: '닫기', //닫기 버튼 텍스트 변경
		currentText: '오늘', //오늘 버튼 텍스트 변경
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], //월을 한글로 변경
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토', '일'], //요일을 한글로 변경
		showMonthAfterYear: true, //년 월 순서로 표기한다.
		showButtonPanel: true //오늘로 가는 버튼과 달력 닫기 버튼 보기 옵션
	});//===============================================================================================================
	
	//운송 완료 예정시간의 예약하기 버튼을 눌렀을 경우
	var bookBtn = $(".bookOrderBtn");
	
	bookBtn.click(function(){
		
		//입력된 날짜 값이 있는지 확인한다.
		var date = $(this).prev().prev().val();
		if(date == "") {
			alert("날짜을 설정해주세요");
			$(this).prev().prev().focus();
			return false;
		}
		
		//입력된 시간 값이 있는지 확인한다.
		var time = $(this).prev().val();
		if(time == "") {
			alert("시간을 설정해주세요");
			$(this).prev().focus();
			return false;
		}
		
		//날짜와 시간을 합쳐준다.
		var estimated_time = date + " " + time;
		var email = $("#user_email").val();
		var order_num = $(this).next().val();
		
		//주문번호에 해당하는 데이터에 운전자의 메일과 order_state를 업데이트 한다.
		$.ajax({
			type: "post",
			url: "/order/bookOrder.do",
			data: {order_num:order_num, driver_email:email, estimated_time:estimated_time, order_state:'2'},
			success: function(data) {
				if(data == 1) {
					alert("예약 완료");
					location.href="/member/myOrderList.form?array_type=r&user_email=" + email;
				} else {
					alert("이미 진행중인 운송 건과 시간이 겹칩니다.");
				}
			}
		});
	}); //==============================================================================================================================
});

/* myOrderListForm=====================================================================================================================*/
$(document).ready(function() {

	//운송출발 버튼을 눌렀을 경우
	$(".startOrderBtn").click(function(){
		if(confirm("해당 운송 상태를 운송중으로 변경합니다.")) {
			
			var order_num = $(this).next().val();
			var user_email = $("#user_email").val();
			
			//ajax로 정보 수정을 한다.
			$.ajax({
				type: "post",
				url: "/order/orderStateUpdate.do",
				data: {order_num:order_num, order_state:'3'},
				success: function(data) {
				
					let str = "arrayType=r&user_email=" + user_email;
					location.href="/member/myOrderList.form?" + str;
					
				}
			});
		}
	}); //=======================================================================================================================
	
	//운송도착 버튼을 눌렀을 경우
	$(".finishOrderBtn").click(function(){
		if(confirm("해당 운송을 완료합니다.")) {
			
			var order_num = $(this).next().val();
			var user_email = $("#user_email").val();
			
			//ajax로 정보 수정을 한다.
			$.ajax({
				type: "post",
				url: "/order/orderStateUpdate.do",
				data: {order_num:order_num, order_state:'4'},
				success: function(data) {
				
					let str = "arrayType=r&user_email=" + user_email;
					location.href="/member/myOrderList.form?" + str;
					
				}
			});
		}
	}); //=======================================================================================================================

});