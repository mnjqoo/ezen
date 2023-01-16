<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="../../common/topMenu.jsp" flush="false"></jsp:include>
		
		<div class="container">
			<form class="form-horizontal" name="zipForm" method="post">
				<div class="form-group">
					<label class="col-sm-2" style="text-align:right">우편번호</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="zipcode" id="zipcode" readonly/>
						<input type="button" class="form-control btn btn-danger" onclick="daumZipCode()" value="우편번호검색"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2" style="text-align:right">주 소</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="address_1" id="address_1" readonly/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2" style="text-align:right">상세주소</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="address_2" id="address_2"/>
					</div>
				</div>
			</form>
		</div>
		
		<jsp:include page="../../common/footer.jsp" flush="false"></jsp:include>
		
		<!-- daum API 관련 Script -->
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script> 
		function daumZipCode() {//우편번호 검색 버튼 클릭
			new daum.Postcode({
		        oncomplete: function(data) {
		            //팝업에서 검색결과 항목을 클릭했을때 실행할 코드
		            
		            //각 주소의 노출 규칙에 따라서 주소를 조합해야 한다.
		            //내려오는 변수가 값이 없을 경우에는 공백('')으로 값을 가지므로 이름을 참고하여 분기를한다.
		            var fullAddr = ''; //최종 주소값을 저장할 변수
		            var subAddr = ''; //조합형 주소값을 저장할 변수
		            
		            //사용자가 선택한 주소 타입에 따라서 해당 주소 값을 가져온다. (지번/도로명)
		            if(data.userSelectedType == 'R') { //도로명주소일 경우
		            	fullAddr = data.roadAddress;
		            } else { //지번주소일 경우
		            	fullAddr = data.jibunAddress;
		            }
		            
		            //사용자가 선택한 주소에 따라 주소를 조합한다..
		            if(data.userSelectedType == 'R') { //도로명일 경우
		            	if(data.bname != '') {//법정동명이 있을 경우
		            		subAddr += data.bname; //조합한다.
		            	}
		            
		            	if(data.buildingName != '') {//건물명이 있을 경우
		            		subAddr += (subAddr != '' ? ', ' + data.buildingName : data.buildingName); //법정동명이 있으면 쉼표를 같이 붙여준다.
		            	}
		            	
		            	fullAddr += (subAddr != '' ? '(' + subAddr + ')' : ''); //조합형 주소의 유무에 따라 괄호를 추가하여 최종 주소를 만든다.
		            }
		            
		            //우편 번호와 주소 정보를 화면의 해당 필드에 출력시킨다.
		            document.getElementById('zipcode').value = data.zonecode; //우편번호
		            document.getElementById('address_1').value = fullAddr; //최종 주소
		            
		            //커서를  상세주소 입력란으로 이동시킨다.
		            document.getElementById('address_2').focus();
		        }
		    }).open({
		    	//팝업창이 여러개 뜨는 것을 방지하기 위해
		    	popupName: 'postcodePopup'
		    });
		}
		</script>
	</body>
</html>