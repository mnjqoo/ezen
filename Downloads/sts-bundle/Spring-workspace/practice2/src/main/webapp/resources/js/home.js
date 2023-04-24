/**
 * 
 */

$(function(){

	//div 박스 색상 변경
	$(".sec03_box").on({
		mouseenter: function () {
			$(this).css({"backgroundColor": "#17465a", "color" : "#FFF"}); 
		},
		mouseleave: function () {
			$(this).css({"backgroundColor": "#FFF", "color" : "#000"}); 
		}
	});
	
	//이미지 보여주기
	$("#sec03_01").on({
		mouseenter: function () {
			$("img[alt='sec03_img']").fadeOut(400, function(){
				$("img[alt='sec03_img']").attr("src", "resources/images/screenshot3.jpg");
				$("img[alt='sec03_img']").fadeIn(400);
			});
		}
	});
	$("#sec03_02").on({
		mouseenter: function () {
			$("img[alt='sec03_img']").fadeOut(400, function(){
				$("img[alt='sec03_img']").attr("src", "resources/images/screenshot4.jpg");
				$("img[alt='sec03_img']").fadeIn(400);
			});
		}
	});
	$("#sec03_03").on({
		mouseenter: function () {
			$("img[alt='sec03_img']").fadeOut(400, function(){
				$("img[alt='sec03_img']").attr("src", "resources/images/screenshot2.jpg");
				$("img[alt='sec03_img']").fadeIn(400);
			});
		}
	});
	$("#sec03_04").on({
		mouseenter: function () {
			$("img[alt='sec03_img']").fadeOut(400, function(){
				$("img[alt='sec03_img']").attr("src", "resources/images/screenshot4.jpg");
				$("img[alt='sec03_img']").fadeIn(400);
			});
		}
	});
});