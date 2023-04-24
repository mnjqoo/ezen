/**
 * 
 */
 
 /* Sec02-1 */
 
 $(document).ready(function() {
 
 	//carousel-indicator 누를 때 숫자 변하기
 	$(".indicatorBtn").on("click", function() {
 		
 		//숫자에 따라 값을 바꿔준다.
 		if($("#indicatorNum").text() == "1") {	//1일경우
 			$("#indicatorNum").text("2");
 		} else {								//2일경우
 			$("#indicatorNum").text("1");
 		}
 	});
 
 });