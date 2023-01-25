package com.edu.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect //해당 클래스 객체가 Aspect를 구현한 것임을 나타내기 위해서 사용한다.
@Component //AOP와 관계는 없지만 스프링에서 Bean으로 인식하기 위해서 사용한다.
public class LogAdvice {

	private static Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	//Aspect : 흩어진 관심사를 모듈화 한 것
	//Target: Aspect를 적용하는 곳. (클래스, 매소드 등)
	//Advice: 실질적으로 어떤 일을 해야 할 지에 대한 것. 실질적인 부가기능을 담은 구현체
	//Join Point: Advice가 적용될 위치 또는 시점. (메소드 진입 시점, 생성자 호출 시점, 필드에서 꺼내올 시점 등) 스프링에서는 메소드의 실행시점을 의미한다.
	//Point Cut: Join Point의 상세한 스펙을 정의한 것.("login이라는 메소드 진입 시점에 호출하라" 처럼 구체적으로 Advice가 실행될 시점을 정한다.)
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	//@Before: Target 메소드가 실행하기 이전에 Advice 기능을 수행한다.
	//@After: Target 메소드의 결과에 상관 없이 메소드 실행 후에 Advice 기능을 수행한다.
	//@AfterReturning: Target 메소드가 정상적으로 결과를 반환한 후에 Advice 기능을 수행한다.
	//@AfterThrowing : Target 메소드가 수행 중 예외가 발생하면 Advice 기능을 수행한다.
	//@Around: Advice가 Target 메소드를 감싸서 Target 메소드 호출 전, 후에 Advice를 실행한다.
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	//execute(int minus(int, int)) : int 타입의 리턴값, 이름은 minus, 두개의 int 파라미터를 가지고 있는 메소드가 대상이다.
	//execute(* minus(int, int)) : 모든 타입의 리턴값, 이름은 minus, 두개의 int 파라미터를 가지고 있는 메소드가 대상이다.
	//execute(* minus(..)) : 모든 타입의 리턴값, 이름은 minus, 모든 타입, 갯수의 파라미터 메소드가 대상이다.
	//execute(* minus()) : 모든 타입의 리턴값, 이름은 minus, 파라미터가 없는 메소드가 대상이다.
	//execute(* *(..)) : 모든 타입의 리턴값, 모든 이름, 모든 파라미터 타입의 메소드가 대상이다.
	//execute(* com.edu.aop.Target.*(..)) : 모든 타입의 리턴값, ...aop 경로 밑의 Target.class 의 모든 메소드가 대상이다.
	//execute(* com.edu.aop.*.*(..)) : 모든 타입의 리턴값, ...aop 경로 밑의 모든 class 의 모든 메소드가 대상이다.
	//@Around("execution(* com.edu.board.service.BoardService*.*(..))") : ....BoardService로 시작하는 모든 클래스의 모든 메소드가 대상이다.
	//execution...: AspectJ의 표현식
	//execution: 접근 제한자와 특정 클래스의 메소드를 지정할 수 있다.
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	@Before("execution(* com.edu.board.service.*.*(..))")//com.edu.board.service에 있는 모든 타입의 메소드
	public void beforeComponentMethod(JoinPoint jp) {
		logger.info("AOP Before 입니다");
		logger.info("beforeComponentMethod ==>" + jp.getSignature());
	}
	
	@After("execution(* com.edu.board.service.*.*(..))")//com.edu.board.service에 있는 모든 타입의 메소드
	public void afterComponentMethod(JoinPoint jp) {
		logger.info("AOP After 입니다");
		logger.info("afterComponentMethod ==>" + jp.getSignature());
	}
	
	@Around("execution(* *..controller.*.*(..)) or execution(* *..service.*.*(..)) or execution(* *..dao.*.*(..))") //모든 controller, service, dao 패키지에 존재하는 클래스
	public Object calculateExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("AOP Around 입니다");
		logger.info("aroundrComponentMethod ==>" + pjp.getSignature());
		
		//핵심 업무에 걸린 시간을 조사하자. 핵심업무: pjp.proceed();
		//StopWath 객체를 이용한다. 
		StopWatch sw = new StopWatch();
		sw.start();
		Object result = pjp.proceed();
		sw.stop();
		long executionTime = sw.getTotalTimeMillis();
		
		logger.info(pjp.getTarget().getClass().getName() + "의" + pjp.getSignature().getName() +"메소드 처리 소요 시간: " + executionTime + "(ms)");
		
		return result;
	}
}

