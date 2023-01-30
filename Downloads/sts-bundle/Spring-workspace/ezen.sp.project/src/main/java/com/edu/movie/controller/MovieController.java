package com.edu.movie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.movie.dto.SeatDTO;
import com.edu.movie.dto.SeatStatusDTO;
import com.edu.movie.service.MovieService;

@Controller
@RequestMapping(value="/movie")
public class MovieController {

	Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Inject //java에서 지원하는 어노테이션. 특정 framework에 종속적이지 않다./Autowired: spring에서 지원하는 어노테이션.
	MovieService movieService;
	
	//영화관 좌석 화면 가져오기
	@RequestMapping(value="/seatReservation", method=RequestMethod.GET)
	public String seatReservation(@ModelAttribute("movieID") String mID, Model model) throws Exception {
		logger.info("MovieController의 seatReservation() 불러오기....");
		
		//예약된 좌석과 아닌 좌석 수
		int reserveOK = 0;
		int reserveNO = 0;
		//영화 종류
		int movieID = 0;
		
		//넘어온 영화종류에 대한 값이 있으면 movieID에 저장해준다.
		if(mID != null) {
			movieID = Integer.parseInt(mID);
		}
		
		//음수일때를 처리 해주고
		if(movieID < 0) {
			logger.info("MovieController의 seatReservation() ===> 유효하지 않은 값입니다.(음수)");
		} else {
			
			//해당 영화의 예약된 좌석리스트를 가져온다.
			List<SeatDTO> list = movieService.getSeatList(movieID);
			//좌석 예매 상태를 좌석 마다 지정하기 위해 배열로 지정한다.
			ArrayList<SeatStatusDTO> result = new ArrayList<SeatStatusDTO>();
			//전체 좌석 수가 200개라고 설정한다. (좌석수가 변동이되면 변수를 사용해야한다.)
			//전체 좌석 중에 list에 해당 값이 있으면 true, 없으면 false로 만든다.
			for(int i = 1; i <= 200; i++) {
				boolean findSeatID = false;
				for(int j = 0; j<list.size(); j++) { 
					if(i == list.get(j).getSeatID()) { //list의 j번째의 seatID
						findSeatID = true;
						reserveOK++; //예약된 좌석 수를 늘려준다.
					}
				}
				
				//해당 좌석이 예약된 상태이면 좌석상태객체에 좌석번호와 true를 넣어준다.
				if(findSeatID) result.add(new SeatStatusDTO(i, true));
				else result.add(new SeatStatusDTO(i, false));
			}
			
			//남은 좌석 수를 계산해준다.
			reserveNO = 200 - reserveOK;
			
			model.addAttribute("seatList", result);
			model.addAttribute("reserveOK", reserveOK);
			model.addAttribute("reserveNO", reserveNO);
			
			System.out.println("model 값: " + model);
		}
		
		return "/movie/seatReservation";
		
	}
	
	//영화관 좌석 예약 처리
	@ResponseBody
	@RequestMapping(value="/seatReservation", method=RequestMethod.POST)
	public int seatReservationOK(@RequestParam int seatID, Model model) throws Exception {
		logger.info("MovieController의 seatReservationOK() 처리하기.... 좌석번호: " + seatID);
		
		if(movieService.insertSeatID(seatID) == 1) { //예약 처리 후 결과값을 모델에 담아서 보내준다.
			
			int reservedCount = movieService.seatReservationCount();
			System.out.println("reservedCount: " + reservedCount);
			int reserveOK = reservedCount;
			int reserveNO = 200 - reservedCount;
			model.addAttribute("reserveOK", reserveOK);
			model.addAttribute("reserveNO", reserveNO);
			
			return 1;
			
		} else {
			return 0;
		}
		
	}

}
