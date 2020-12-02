package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.naver.NaverManager;
@Controller
@RequestMapping("food/")
// 6FQw_o8z3yxlzPREeUJr
// wsJ4F6HtPN
/*
 *    스프링
 *     => Container : 사용자,라이브러리 클래스를 관리하는 영역 
 *        ApplicationContext , WebApplicationContext(MVC)
 *        AnnotationConfigApplicationContext 
 *        ==> 관리 대상 클래스 전송 
 *            = XML <bean ~>
 *            = Annotation => package등록 (<component-scan base-package="">)
 *              = @Component
 *              = @Repository
 *              = @Controller
 *              = @RestController
 *              = @Service
 *        ============================= 클래스 메모리 할당 (HashMap에 저장) : DL
 *      => 메모리 할당시 필요한 데이터 전송 , 클래스 주소 전송 
 *         (DI)          =========  ============
 *         = 데이터 전송 : setterDI(p:name=""),constructorDI(c:name="")
 *         = 클래스 주소 전송 
 *           @Autowired , @Resource
 *           
 *      => 반복 제거 (AOP)
 *         PointCut
 *           => 대상 (메소드명 지정)
 *         JoinPoint
 *           => 적용 시점 
 *              = Before
 *              = After
 *              = Afetr-Returning
 *              = After-Throwing
 *              = Around
 *              
 *           public void display() 
 *           {
 *               @Before
 *               try
 *               {
 *                  ============ @Around
 *                    핵심 코딩 
 *                  ============
 *               }catch(Exception ex)
 *               {
 *                   @After-Throwing
 *               }
 *               finally
 *               {
 *                   @After
 *               }
 *               
 *               return @After-Returning
 *           }
 *           
 *        => WEB 
 *           1. 실행과정 
 *           사용자 요청 (*.do) =====> ***DispatcherServlet ========> 
 *                                      ***Model 찾기 => HandlerMapping
 *                                      Model클래스(@Controller,@RestController)
 *                                      해당 메소드 수행 
 *                                      ========
 *                                        1. RequestMapping(GET/POST)
 *                                        2. GetMapping
 *                                        3. PostMapping
 *                                      ========> JSP 호출 (request,session)
 *                                               ========
 *                                                ***ViewResolver => JSP
 *           2. 모든 데이터나 모든 클래스는 DispatcherServlet로 부터 받아서 처리
 *              => 매개변수로 값을 받는다 disp(HttpSession session)
 *              
 *           3. 전송시 
 *              == Model을 이용한다 
 *              == Redirect일 경우 : RedirectAtteibutes
 *              
 *           4. ORM (Mybatis)(Back-End) , MongoDB(Front-End)
 *              Spring                     NodeJS
 *           ============================================================
 *           MongoDB
 *             1. select
 *                 = find  => List
 *                   {$and:[{키:값},{키:값}]}
 *                   {$or:[{},{}]}
 *                   {키:{$regex:{키:값}}}
 *                 = findOne => Object(VO)
 *             2. insert()
 *             3. update() ==> $set
 *             4. remove()
 *             
 *        자바 
 *         = 변수(데이터형)
 *         = 연산자 
 *         = 제어문
 *         = 객체지향 프로그램 
 *           = 클래스 
 *           = 메소드 
 *           = 멤버변수 
 *         = 인터페이스 
 *         = 라이브러리 
 *           = util,io,sql,lang(Object,String...)
 *           = 컬렉션 
 *           
 *        오라클 
 *         = DML(SELECT,INSERT,UPDATE,DELETE)
 *               SELECT 
 *                = 내장 함수 
 *                = 연산자 
 *                = JOIN
 *                = SUBQUERY
 *         = DDL(CREATE,DROP,ALTER)
 *                CREATE 
 *                = 제약조건 
 *         = TCL(COMMIT,ROLLBCK)
 *         
 *         = VIEW,SEQUENCE
 *         
 *        JSP 
 *         = EL ${}
 *         = JSTL 
 *         = MVC
 *         
 *        HTML/CSS/JavaScript
 *         = Jquery (Ajax)
 *         = React *****
 *         = NodeJS *****
 *         ============================== 입문 
 *        코틀린 
 */
public class FoodController {
   @Autowired
   private FoodDAO fdao;
   @Autowired
   private ReplyDAO rdao;
   @Autowired
   private NaverManager nm;
   @Autowired
   private RManager rm;
   @RequestMapping("list.do")
   public String food_list(Model model)
   {
	   List<FoodCategoryVO> list=fdao.foodCategoryAllData();
	   model.addAttribute("list", list);
	   return "food/list";
   }
   @RequestMapping("food_category.do")
   public String food_category(int no,Model model)
   {
	   List<FoodVO> list=fdao.foodCategoryFoodListData(no);
	   for(FoodVO vo:list)
	   {
		   String s=vo.getPoster();
		   s=s.substring(0,s.indexOf("^"));
		   vo.setPosterOne(s);
		   
		   String ss=vo.getAddr();
		   StringTokenizer st=new StringTokenizer(ss,"지");
		   vo.setAddr1(st.nextToken());
		   String sss=st.nextToken();
		   sss=sss.substring(2);
		   vo.setAddr2(sss);
	   }
	   FoodCategoryVO vo=fdao.foodCategoryInfoData(no);
	   model.addAttribute("list", list);
	   model.addAttribute("vo", vo);
	   return "food/category";
   }
   @RequestMapping("food_detail.do")
   public String food_detail(int no,String page,Model model)
   {
	   FoodVO vo=fdao.foodDetailData(no);
	   String s=vo.getAddr();
	   StringTokenizer st=new StringTokenizer(s,"지");
	   vo.setAddr1(st.nextToken());
	   vo.setAddr2("지"+st.nextToken());
	   
	   String type=vo.getType();
	   st=new StringTokenizer(type,"/");
	   String result="";
	   while(st.hasMoreTokens())
	   {
		   result+=st.nextToken().trim()+"|";
	   }
	   result=result.substring(0,result.lastIndexOf("|"));
	   List<RecipeVO> list=fdao.foodLikeRecipeData(result);
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<ReplyVO> rList=rdao.replyListData(no, curpage);
	   nm.naverData(vo.getTitle());
	   //rm.graph(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("list", list);
	   model.addAttribute("rList", rList);
	   return "food/food_detail";
   }
   @RequestMapping("reply_insert.do")
   public String reply_insert(RedirectAttributes attr,int cno,String msg,HttpSession session)
   {
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   ReplyVO vo=new ReplyVO();
	   vo.setCno(cno);
	   vo.setMsg(msg);
	   vo.setId(id);
	   vo.setName(name);
	   rdao.replyInsert(vo);
	   attr.addAttribute("no", cno);
	   //attr.addFlashAttribute(arg0) : Object(VO,List)
	   return "redirect:../food/food_detail.do";
   }
   @RequestMapping("reply_delete.do")
   public String reply_delete(RedirectAttributes attr,int no,int cno)
   {
	   rdao.reply_delete(no);
	   attr.addAttribute("no", no);//GET 
	   return "redirect:../food/food_detail.do";
   }
   @RequestMapping("reply_update.do")
   public String reply_update(RedirectAttributes attr,int no,int cno,String msg)
   {
	   rdao.reply_update(no, msg);
	   attr.addAttribute("no", no);
	   return "redirect:../food/food_detail.do";
   }
}





