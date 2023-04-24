<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 화면</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- datepicker -->
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<!-- HOME CSS -->
		<link href="/resources/css/common.css" rel="stylesheet" type="text/css">
		<link href="/resources/css/member.css" rel="stylesheet" type="text/css">
		<!-- MEMBER JS -->
		<script src="/resources/js/member.js"></script>
	</head>
	<body>
		<div>
			 <!-- 상단 메뉴 바 -->
			<jsp:include page ="../common/mainTopNav.jsp"></jsp:include>
			
			<div class="container">
				<form id="registerForm">
					<div class="form-group">
						<label for="userType">가입 유형:&nbsp&nbsp</label>
						<label class="radio-inline">
							<input type="radio" class="userType" name="userType" value="C" checked> 개인/업체&nbsp&nbsp
						</label>
						<label class="radio-inline">
							<input type="radio" class="userType" name="userType" value="D"> 운송기사
						</label>
					</div>
				
					<div class="form-group">
						<input type="text" class="form-control register_input" id="userEmail" name="userEmail" maxlength="100"/>
						<label for="email" class="register_label">이메일</label>
						<span>필수항목</span>
					</div>
					
					<div class="form-group">
						<input type="password" class="form-control register_input" id="userPwd" name="userPwd"/>
						<label for="password" class="register_label">비밀번호</label>
						<span>필수항목</span>
					</div>
					
					<div class="form-group">
						<input type="password" class="form-control register_input" id="rePwd" name="rePwd"/>
						<label for="repassword" class="register_label">비밀번호 확인</label>
						<span>필수항목</span>
					</div>
					
					<div class="form-group">
						<input type="text" class="form-control register_input" id="userName" name="userName" maxlength="10"/>
						<label for="name" class="register_label">이름</label>
						<span>필수항목</span>
					</div>
					
					<div class="form-group">
						<input type="text" class="form-control register_input" id="userPhone" name="userPhone" onKeyup="inputPhoneNumber();" maxlength="13"/>
						<label for="userPhone" class="register_label">휴대폰 번호 ("-" 제외)</label>
						<span>필수항목</span>
					</div>
					
					<div class="form-group">
						<input type="text" class="form-control register_input datepicker" id="userBirthDate" name="birthDate"/>
						<label for="userBirthDate" class="register_label">생년월일</label>
						<span>필수항목</span>
					</div>
					
					<div class="form-group driver_form">
						<input type="text" class="form-control register_input" id="licenseNum" name="licenseNum" onKeyup="inputPhoneNumber();" maxlength="15"/>
						<label for="licenseNum" class="register_label">면허 번호 ('-'제외)</label>
						<span>필수항목</span>
					</div>
					
					<div class="form-group driver_form">
						<input type="text" class="form-control register_input datepicker" id="licenseDate" name="licenseDate"/>
						<label for="licenseDate" class="register_label">면허 취득 날짜</label>
						<span>필수항목</span>
					</div>
					
					<div class="form-group driver_form">
						<input id="uploadLicenseImage" class="form-control" placeholder="면허 사진 첨부"/>
						<input type="file" id="licenseImage" name="licenseImage"/>
						<label for="licenseImage" id="licenseImageLabel">사진 업로드</label>
					</div>
					
					<div class="form-group joinAgreeDiv">
						<input type="checkbox" class="joinAgreeCheckbox" id="joinAgree1" value="first"/>
						<label for="joinAgree1">정보통신망법 제50조와 동법시행령 61조의 개인정보 수집 및 이용에 동의 (필수)</label>
						<p class="joinAgreeP">보기</p>
						<div class="joinAgreeContentDiv">
							<p><strong>[사용자 개인 정보 수집 및 이용 안내]</strong></p>
							<p>정보통신망법 제50조와 동법시행령 61조</p>
							<p>정보통신망 이용촉진 및 정보보호 등에 관한 법률  제50조(영리목적의 광고성 정보 전송 제한) </p>
							<p>① 누구든지 전자적 전송매체를 이용하여 영리목적의 광고성 정보를 전송하려면 그 수신자의 명시적인 사전 동의를 받아야 한다.</p>
							<p>다만, 다음 각 호의 어느 하나에 해당하는 경우에는 사전 동의를 받지 아니한다. <개정 2016. 3. 22., 2020. 6. 9.></p>
							<p>1. 재화등의 거래관계를 통하여 수신자로부터 직접 연락처를 수집한 자가 대통령령으로 정한 기간 이내에 자신이 처리하고 수신자와 거래한 것과 
							같은 종류의 재화등에 대한 영리목적의 광고성 정보를 전송하려는 경우</p>
							<p>정보통신망 이용촉진 및 정보보호 등에 관한 법률 시행령 제61조 (영리목적의 광고성 정보 전송기준) ① 법 제50조제1항제1호에서 
							“대통령령으로 정한 기간”이란 해당 재화등의 거래가 종료된 날부터 6개월을 말한다. <개정 2014. 11. 28.></p>
						</div>
					</div>
					
					<div class="form-group joinAgreeDiv">
						<input type="checkbox" class="joinAgreeCheckbox" id="joinAgree2"/>
						<label for="joinAgree2">위치기반서비스 이용약관(필수)</label>
						<p class="joinAgreeP">보기</p>
						<div class="joinAgreeContentDiv">
							<p>제 1 장 총칙</p>
							<p>제 1 조 (목적)</p>
							<p>본 약관은 우아한형제들(이하 "회사"라 함)이 운영, 제공하는 위치기반서비스(이하 “서비스”라 함)에 대해 
							회사와 위치기반서비스를 이용하는 개인위치정보주체(이하 “이용자”라 함)간의 권리, 의무 및 책임사항에 따른 
							이용조건 및 절차 등 기본적인 사항을 규정함을 목적으로 합니다.</p>
							<p>제 2 조 (이용약관의 효력 및 변경)</p>
							<p>① 본 약관은 서비스를 신청한 이용자가 본 약관에 동의하고 회사가 정한 소정의 절차에 따라 
							서비스의 이용자로 등록함으로써 효력이 발생합니다.</p>
							<p>② 이용자가 온라인에서 본 약관의 "동의하기" 버튼을 클릭하였을 경우 본 약관의 내용을 모두 읽고 
							이를 충분히 이해하였으며, 그 적용에 동의한 것으로 봅니다.</p>
							<p>③ 회사는 서비스에 새로운 업무 적용, 정부에 의한 시정명령의 이행 및 기타 회사의 업무상 약관을 변경해야 할 중요한 사유가 있다고 판단될 경우 
							관련법령을 위배하지 않는 범위에서 본 약관을 변경할 수 있습니다.</p>
							<p>④ 회사는 본 약관을 변경할 경우에는 변경된 약관과 사유를 적용일자 7일 전부터 서비스 홈페이지에 게시하거나 이용자에게 전자적 형태(전자우편, SMS 등)로 공지합니다. 
							다만, 이용자에게 불리하게 약관 내용을 변경하는 경우에는 최소 적용 전 30일 이상의 사전 유예기간을 두고 공지합니다.</p>
							<p>⑤ 전항에 따라 회사가 이용자에게 통지한 후 이용자가 공지 기간 내에 이의제기 또는 거부의사를 표시하지 아니하면 이용약관에 승인한 것으로 봅니다. 
							만약 이용자가 개정약관에 동의하지 않을 경우 이용자는 이용계약을 해지할 수 있습니다.</p>
						</div>
					</div>
					
					<div class="form-group joinAgreeDiv driver_form">
						<input type="checkbox" class="joinAgreeCheckboxD" id="joinAgree3"/>
						<label for="joinAgree3">정보보호서약서 (필수)</label>
						<p class="joinAgreeP">보기</p>
						<div class="joinAgreeContentDiv">
							<p>"본 계약" 제13조, 제14조 내지 제15조에 기하여 본인은 "회사"로부터 제공받는 개인정보, 영업비밀, 지식재산권 등의 보호를 위하여 
							다음의 사항을 약정하고 성실히 준수할 것을 확약하기 위해 본 약정서를 체결한다.</p>
							<p>① 본인은 "회사"의 배송대행서비스를 수행하는 자로서, 공공연히 알려져 있지 아니하고 경제적 가치를 가지는 것으로서 "회사"의 개발·영업방법 및 기타 영업활동에 유용한 기술상 또는 경영상의 정보, 
							개인정보(이하 '영업비밀' 이라 함)의 보호와 관련된 규정 및 지침, 정책을 철저히 준수한다.</p>
							<p>② 본인은 배송대행서비스 수행 중 또는 배송대행서비스와 관련 없이 취득한 영업비밀을 지정된 배송대행서비스에 한해 사용할 것을 동의한다. 또한 "본 계약"에 따른 배송대행서비스 수행 중 또는 종료 후에도 
							영업비밀에 대해서 어떠한 방법으로도 본인의 이익을 위하여 이용하거나 "회사" 이외의 제3자에게 누설 또는 공개하지 않는다. 
							(다만, "회사"의 사전 서면 동의가 있거나 영업비밀보호 관련 규정에 의해 허용된 경우는 예외로 함)</p>
							<p>③ 본인은 허가받지 않은 정보나 시설 등에는 절대로 접근하지 않으며, 불법 소프트웨어, 정보저장 및 처리장치(외장하드, 모뎀 등)을 사용하지 않는다. 
							또한 "회사"로부터 제공받은 정보자산 (문서, 사진, PC, 전자파일, 저장매체, 전산장비, 통신망 등)에 대해서는 무단변조, 훼손, 분실, 유출 및 무단반출 등으로부터 안전 하게 관리하고 사용하며, 
							이러한 정보자산을 배송대행서비스 외적인 개인적 목적으로 사용하지 않는다.</p>
							<p>④ 본인은 배송대행서비스 수행 또는 이와 관련없이 취득한 영업비밀에 대하여, 배송대행서비스에 사용하기 위한 목적을 제외하고는, 복사, 녹음, 촬영, 전송 및 기타 방법에 의한 복제를 일체 하지 않는다.
							(다만, "회사"의 사전 서면동의가 있거나 영업비밀보호관련 규정에 의해 허용된 경우는 예외로 함)</p>
							<p>본인은 위 내용에 대하여 확인 및 숙지 후 이해하여 동의합니다.</p>
						</div>
					</div>
					
					<div class="form-group joinAgreeDiv driver_form">
						<input type="checkbox" class="joinAgreeCheckboxD" id="joinAgree4"/>
						<label for="joinAgree4">개인정보 수집 이용 동의(필수)</label>
						<p class="joinAgreeP">보기</p>
						<div class="joinAgreeContentDiv">
							<p>서비스 제공을 위해 최소한의 범위 내에서 아래와 같이 개인정보를 수집 이용합니다.</p>
							<p>(1) 회사는 서비스 제공을 위하여 아이디, 비밀번호, 이름, 생년월일, 성별, 휴대전화번호, 운행정보를 수집 이용합니다.</p>
							<p>(2) 서비스 이용과정에서 아래와 같은 정보들이 자동으로 생성되어 수집·저장·조합·분석될 수 있습니다.
							IP Address, 쿠키, 서비스 이용 기록, 기기 정보(기기고유번호, OS, 버전, 모델명) 등</p>
							<p>(3) 회사는 다음의 목적을 위하여 이용자의 개인정보를 처리하고 있으며, 명시된 목적 이외의 용도로는 처리하지않습니다. 
							이용자의 개인정보는 계정탈퇴 시 즉시 파기합니다.</p>
							<p>법령 위반 기사 : 영구보관</p>
							<p>계약 위반 기사 : 계약종료 3년 후 파기</p>
							<p>-관련 법령에 의해 보관해야 하는 의무가 있는 경우에는 해당 기간동안 보관됩니다.</p>
							<p>개인정보 수집 이용에 동의하지 않으실 수 있으며 동의하지 않는 경우 배달 업무가 제한됩니다.</p>
							<p>그 밖의 사항은 본 회사의 개인정보 처리방침에 따릅니다.</p>
						</div>
					</div>
					
					<div class="form-group">
						<input type="button" class="form-control" id="joinBtn" value="가입하기" onclick="fn_popup();"/>
					</div>
				</form>
			</div>
		</div>
		
		<div class="popupBackground">
			<div class="popupWindow">
				<div class="popupContent">
					<!-- 기재한 정보 보여주는 부분 -->
					<table id="joinInfoTable">
						<tr>
							<td class="joinInfoColorTd">가입 유형</td>
							<td id="popUserType" colspan="3"></td>
						</tr>
						<tr>
							<td class="joinInfoColorTd">이름</td>
							<td id="popUserName"></td>
							<td class="joinInfoColorTd">이메일</td>
							<td id="popUserEmail"></td>
						</tr>
						<tr>
							<td class="joinInfoColorTd">휴대폰 번호</td>
							<td id="popUserPhone"></td>
							<td class="joinInfoColorTd">생년월일</td>
							<td id="popUserBirthDate"></td>
						</tr>
						<tr class="popDriverTr">
							<td class="joinInfoColorTd">면허 번호</td>
							<td id="popLicenseNum"></td>
							<td class="joinInfoColorTd">취득 날짜</td>
							<td id="popLicenseDate"></td>
						</tr>
						<tr class="popDriverTr">
							<td class="joinInfoColorTd">사진 파일</td>
							<td id="popLicenseImage" colspan="3"></td>
						</tr>
					</table>
					<p>위의 정보로 가입 하시겠습니까?</p>
					<!-- 버튼 -->
					<div>
						<button type="button" id="popJoinBtn" class="form-control" onclick="fn_popupJoin();">가입하기</button>
						<button type="button" class="form-control" onclick="fn_popupClose();">닫기</button>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
	</body>
</html>