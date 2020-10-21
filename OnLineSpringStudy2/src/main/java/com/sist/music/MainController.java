package com.sist.music;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 *    ==> VO를 제외한 모든 클래스는 스프링에 관리요청
 *    사용자 정의 클래스를 모아서 관리 (생명주기)
 *          => 클래스 객체 생성 ~ 객체 소멸  ==> 관계도 설정 간단하다 
 *                                      다른 클래스에 영향을 미치지 않는다
 *              결합성(의존성) 낮은 프로그램 
 *              수정 => 다른 에러가 아는지 확인   
 *              =======================
 *              메모리 할당 (스프링에서 한다) => 메모리를 낭비하지 않는다 
 *              => 싱글턴
 *    XML : 클래스나 패키지 단위로 메모리 할당 요청
 *    Annotation : 클래스 찾기,메소드 찾기 
 *    
 *    Container : 클래스를 모아서 관리 
 *      ==> ApplicationContext => application-context.xml
 *         ==================== XML 파서
 *    ***DI : 주입 (setter,생성자 매개변수에 값을 채운다)
 *    ***AOP : 반복을 제거 => 자동 호출(콜백)
 *    ORM : Mapper(데이터베이스 연결)
 *    MVC : Web
 *    ==================================
 *    Spring 5 => 순수 자바만으로 코딩 (XML을 제외) , kotlin (Annotation)
 *    
 *    DL : 클래스를 찾을 때 사용 
 *    DI : 메모리 할당시에 필요한 데이터를 받는다
 *    
 *    행정자치부 : 웹로직 (단점 : 한달에 600만원) => Spring
 */
@Controller
public class MainController {
   @RequestMapping("main/main.do")
   public String main_main(HttpServletRequest request)
   {
	   request.setAttribute("msg", "Hello Spring");
	   return "main/main";
   }
}
