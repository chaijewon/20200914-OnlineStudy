package com.sist.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

// http://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do 
/*
 *  ==> 오라클 (X) , JSON(파싱) , XML(JAXB) , CSV , txt 
 *                ============
 *  오브젝트 (클래스 표현법)
 *  [ ==> JSONArray
 *      { ==> JSONObject
 *          "startYearDate":"2020.09.16",
 *          "endYearDate":"2020.09.16",
 *          "startDate":"2020년 09월 16일(수)",
 *          "endDate":"2020년 09월 16일(수)",
 *          "movieCd":"20201122",
 *          "showDt":"20200916",
 *          "thumbUrl":"http://www.kobis.or.kr/common/mast/movie/2020/08/thumb/thn_a529042d7d004a6daf64a3f8a687dd69.jpg",
 *          "movieNm":"테넷",
 *          "movieNmEn":"Tenet",
 *          "synop":"당신에게 줄 건 한 단어 ‘테넷’\r\n“이해하지 말고 느껴라!”\r\n\r\n시간의 흐름을 뒤집는 인버전을 통해 현재와 미래를 오가며 세상을 파괴하려는 사토르(케네스 브래너)를 막기 위해 투입된 작전의 주도자(존 데이비드 워싱턴). 인버전에 대한 정보를 가진 닐(로버트 패틴슨)과 미술품 감정사이자 사토르에 대한 복수심이 가득한 그의 아내 캣(엘리자베스 데비키)과 협력해 미래의 공격에 맞서 제3차 세계대전을 막아야 한다!\r\n\r\n[KEY POINT]\r\n인버전: 사물의 엔트로피를 반전시켜 시간을 거스를 수 있는 미래 기술. 미래에서 인버전된 무기를 현재로 보내 과거를 파괴할 수 있다.",
 *          "prdtYear":"2020",
 *          "indieYn":null,
 *          "artmovieYn":null,
 *          "multmovieYn":null,
 *          "showTm":"149",
 *          "showTs":"59",
 *          "director":"크리스토퍼 놀란", obj.get("director")
 *          "prNm":null,
 *          "dtNm":"워너브러더스 코리아(주)",
 *          "repNationCd":"미국",
 *          "movieType":"장편",
 *          "moviePrdtStat":"개봉",
 *          "genre":"액션,SF", String genre=(String)obj.get("genre");
 *          "watchGradeNm":"12세이상관람가",
 *          "openDt":"20200826",
 *          "salesAmt":195303930,
 *          "audiCnt":21629,
 *          "scrCnt":1297,
 *          "showCnt":3327,
 *          "rank":1,
 *          "rankInten":0,
 *          "rankOldAndNew":"OLD",
 *          "rownum":1
 *          },{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20193666","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/08/thumb/thn_234cb235d23745dbb90f52575853fefb.jpg","movieNm":"오! 문희","movieNmEn":"Oh! My Gran","synop":"평화로운 금산 마을. \r\n불같은 성격에 가족 사랑도 뜨거운 ‘두원’(이희준)에게 \r\n하나뿐인 딸 ‘보미’가 뺑소니 사고를 당했다는 청천벽력 같은 소식이 전해진다. \r\n게다가 현장의 유일한 목격자는 \r\n기억이 깜빡깜빡하는 엄니 ‘문희’(나문희)와 왈왈 짖기만 하는 개 ‘앵자’뿐.\r\n\r\n의식 불명 상태로 병원에 있는 ‘보미’.\r\n경찰 수사에 진전이 없자 ‘두원’의 속은 점점 타들어간다. \r\n하지만 예기치 못한 순간 엄니 ‘문희’가 뜻밖의 단서를 기억해내고 \r\n‘두원’은 엄니와 함께 논두렁을 가르며 직접 뺑소니범을 찾아 나서기 시작하는데! \r\n\r\n아무도 못 잡으면, 우리가 직접 잡는다!\r\n","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"109","showTs":"30","director":"정세교","prNm":"(주)빅스톤픽쳐스","dtNm":"CGV아트하우스","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"코미디,드라마","watchGradeNm":"12세이상관람가","openDt":"20200902","salesAmt":57552400,"audiCnt":7166,"scrCnt":645,"showCnt":1744,"rank":2,"rankInten":0,"rankOldAndNew":"OLD","rownum":2},{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20201687","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/09/thumb/thn_85eddef62967420ba7aeef59469380b4.jpg","movieNm":"기기괴괴 성형수","movieNmEn":"Beauty Water","synop":"“새로운 삶을 원하나요?”\r\n지금부터 기적의 성형수 사용 방법을 알려드리겠습니다.\r\n본인의 얼굴을 거울로 확인해 보세요.\r\n사진을 찍어두셔도 좋습니다. 마지막 작별의 시간이니까요.\r\n물과 성형수를 4:1 비율로 섞은 후, 20분간 얼굴을 담가주세요.\r\n앞으로 당신의 근육과 살의 성질이 완전히 변하게 됩니다. 찰흙처럼 말이죠.\r\n겁먹지 말고… 당신이 원하는 얼굴을 만들어보세요\r\n이제 당신은 새로 태어나는 겁니다. 아주 새롭게…\r\n\r\n부작용, 후유증 없이 아름다워지는 단 하나의 방법\r\n바르면 성형이 되는 기적의 물 성형수\r\n올여름 가장 기괴하고 독창적인 호러성형괴담이 온다!","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":"Y","showTm":"85","showTs":"23","director":"조경훈","prNm":"(주)에스에스애니멘트 ,(주)스튜디오 애니멀","dtNm":"(주)트리플픽쳐스","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"공포(호러),스릴러","watchGradeNm":"15세이상관람가","openDt":"20200909","salesAmt":31874400,"audiCnt":3871,"scrCnt":260,"showCnt":772,"rank":3,"rankInten":0,"rankOldAndNew":"OLD","rownum":3},{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20202204","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/09/thumb/thn_5758184cd57b45c29519c4696c32bf66.jpg","movieNm":"더 렌탈 : 소리없는 감시자","movieNmEn":"The Rental","synop":"완벽한 이곳,\r\n모든 것이 감시 당하고 있다!\r\n \r\n연인 ‘찰리’와 ‘미셸’은 동생 커플과 함께\r\n오리건 해변의 멋진 뷰가 있는 렌탈 하우스로 휴가를 떠난다.\r\n\r\n즐거운 시간을 보내는 한편,\r\n완벽해 보이는 집에서 불쾌하고 낯선 시선을 느낀 네 사람은\r\n누군가에게 감시 당하고 있다는 의심을 품게 되고,\r\n숨겨둔 비밀이 하나 둘 드러나기 시작하는데..","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"88","showTs":"31","director":"데이브 프랑코","prNm":null,"dtNm":"(주)제이앤씨미디어그룹","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"공포(호러),스릴러","watchGradeNm":"15세이상관람가","openDt":"20200916","salesAmt":21694440,"audiCnt":2981,"scrCnt":245,"showCnt":478,"rank":4,"rankInten":-4,"rankOldAndNew":"NEW","rownum":4},{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20175405","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/08/thumb/thn_431ed9d0ef2a4072bd3a796cd5824237.jpg","movieNm":"뉴 뮤턴트","movieNmEn":"The New Mutants","synop":"돌연변이의 능력\r\n선물인가 저주인가 \r\n\r\n십대의 돌연변이 레인(메이지 윌리암스 분)과 일리야나(안야 테일러조이 분), 샘(찰리 히튼 분),\r\n로베르토(헨리 자가 분)는 비밀 시설에 수용되어 심리 상태를 감시 받는다.\r\n이들이 사회에는 물론 스스로에게도 위험한 존재라고 생각하는 닥터 레예스(앨리스 브라가 분)는\r\n이들에게 돌연변이 능력을 통제하는 방법을 가르쳐주고자 애쓴다.\r\n\r\n어느 날, 대재앙이 덮친 마을에서 혼자 살아남은 대니(블루 헌트 분)가 이곳에 들어오며\r\n끔찍한 일들이 벌어지기 시작하고,\r\n자신들의 힘을 두려워하고 다룰 줄 몰랐던 십대 돌연변이들은 믿기지 않는 경험을 하며\r\n자신들의 능력을 각성하기 시작하는데…","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"93","showTs":"54","director":"조쉬 분","prNm":null,"dtNm":"월트디즈니컴퍼니코리아 유한책임회사","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"액션,공포(호러),SF","watchGradeNm":"15세이상관람가","openDt":"20200910","salesAmt":22735820,"audiCnt":2703,"scrCnt":493,"showCnt":1092,"rank":5,"rankInten":-1,"rankOldAndNew":"OLD","rownum":5},{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20197922","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/07/thumb/thn_f3d5c23f669f4a0b98fa159e52fb5130.jpg","movieNm":"다만 악에서 구하소서","movieNmEn":"DELIVER US FROM EVIL","synop":"태국에서 충격적인 납치사건이 발생하고 \r\n마지막 청부살인 미션을 끝낸 암살자 인남(황정민)은 그것이 자신과 관계된 것임을 알게 된다.\r\n인남은 곧바로 태국으로 향하고, 조력자 유이(박정민)를 만나 사건을 쫓기 시작한다.\r\n한편, 자신의 형제가 인남에게 암살당한 것을 알게 된 레이(이정재). \r\n무자비한 복수를 계획한 레이는 인남을 추격하기 위해 태국으로 향하는데...\r\n\r\n처절한 암살자 VS 무자비한 추격자\r\n멈출 수 없는 두 남자의 지독한 추격이 시작된다!\r\n","prdtYear":"2019","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"107","showTs":"49","director":"홍원찬","prNm":"(주)하이브미디어코프","dtNm":"씨제이이앤엠(주)","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"범죄,액션","watchGradeNm":"15세이상관람가","openDt":"20200805","salesAmt":15033580,"audiCnt":1816,"scrCnt":305,"showCnt":465,"rank":6,"rankInten":-1,"rankOldAndNew":"OLD","rownum":6},{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20202203","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/09/thumb/thn_3e1d8618f9c343fcbb4d98887a528018.jpg","movieNm":"에이바","movieNmEn":"Ava","synop":"“조직에 위험이 되고 있어”\r\n \r\n타깃 제거 100%, 실패 확률 0%\r\n킬러 ‘에이바’(제시카 차스테인). \r\n\r\n프랑스 최대의 사기범을 제거하는 작전에 투입된 그녀는\r\n임무 중 조직의 금기를 깨트린다.\r\n\r\n한편, 그 사실을 알게 된 새로운 보스 ‘사이먼’(콜린 파렐)은\r\n그녀를 제거할 것을 명령하게 되는데…\r\n \r\n죽거나, 죽이거나\r\n타깃이 된 그녀, 살기 위한 킬링 액션이 시작된다!","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"97","showTs":"3","director":"테이트 테일러","prNm":null,"dtNm":"(주)제이앤씨미디어그룹","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"액션,범죄,드라마","watchGradeNm":"15세이상관람가","openDt":"20200909","salesAmt":6889300,"audiCnt":864,"scrCnt":231,"showCnt":367,"rank":7,"rankInten":-1,"rankOldAndNew":"OLD","rownum":7},{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20203303","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/08/thumb/thn_b953992a360e4b3bbf256d13720a8947.jpg","movieNm":"지니어스 독","movieNmEn":"Think Like a Dog","synop":"“내 생각이 들린다고..!?”\r\n\r\n자신이 개발한 텔레파시 장치를 통해 강아지 ‘헨리’의\r\n생각을 읽을 수 있게 된 천재 소년 ‘올리버’.\r\n성공에 대한 기쁨도 잠시, 가족이 떨어져 살게 될 위기에 처한\r\n‘올리버’와 ‘헨리’는 이를 막기 위해\r\n세상에서 가장 사랑스러운 프로젝트를 계획하는데…\r\n\r\n하나 하면 멍, 둘 하면 예스!\r\n귀염 지수 폭 to 발, 천재 콤비가 떴다!","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"90","showTs":"6","director":"길 정거","prNm":null,"dtNm":"(주)키다리이엔티","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"코미디,드라마","watchGradeNm":"12세이상관람가","openDt":"20200916","salesAmt":6434900,"audiCnt":850,"scrCnt":142,"showCnt":263,"rank":8,"rankInten":-8,"rankOldAndNew":"NEW","rownum":8},{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20206679","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/09/thumb/thn_c77b11b8bfd74d129a88c0f29b6568cd.jpg","movieNm":"공포체험라디오 4DX","movieNmEn":null,"synop":"4DX로 체험하는 공포라디오. 공포크리에이터 돌비와 함께하는 새로운 콘텐츠 체험.\r\n유튜브, 아프리카TV 등 웹에서 인기 급상승 중인 공포 콘텐츠를 영화관에서 감상한다. 그것도 몰입형 특수포맷인 4DX로!!\r\n공포전문 작가 HyunDC님의 스토리 \"귀신들린 집\"은 돌비 특유의 감미로우면서도 섬뜩한 목소리와 서슬퍼런 4D 효과로 주인공들과 같은 공간에 있는 착각을 들게 할 것이며, \r\n두 번째 계란과자님의 사연은 돌비공포라디오의 미공개 버전으로 CGV에서만 특별히 감상할 수 있다.","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"50","showTs":"32","director":"한동성","prNm":"CGV ICECON,씨제이포디플렉스 주식회사","dtNm":"CGV ICECON,씨제이포디플렉스 주식회사","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"공포(호러)","watchGradeNm":"15세이상관람가","openDt":"20200916","salesAmt":4956500,"audiCnt":538,"scrCnt":37,"showCnt":71,"rank":9,"rankInten":-9,"rankOldAndNew":"NEW","rownum":9},{"startYearDate":"2020.09.16","endYearDate":"2020.09.16","startDate":"2020년 09월 16일(수)","endDate":"2020년 09월 16일(수)","movieCd":"20199302","showDt":"20200916","thumbUrl":"/common/mast/movie/2020/08/thumb/thn_efd3134f0bcf425f9dac97622c7ced33.jpg","movieNm":"테스와 보낸 여름","movieNmEn":"My Extraordinary Summer with Tess","synop":"세상 진지한 4차원 소년 ‘샘’ X 저세상 텐션 5차원 소녀 ‘테스’\r\n\r\n엉뚱한 소년 ‘샘’은 가족과 함께 떠난 바닷가 휴양지에서도 죽음에 대해 고민하는 중이다.\r\n지구에 남은 마지막 공룡은 어떤 마음이었을까 상상하던 ‘샘’은\r\n언젠가 혼자 남겨질 경우를 대비해 ‘외로움 적응 훈련’에 돌입한다.\r\n그런데 섬에서 만난 소녀 ‘테스’로 인해 계획에 차질이 생기기 시작한다.\r\n첫 만남에 다짜고짜 살사 춤을 추자고 하는 더 엉뚱한 소녀 ‘테스’는\r\n어디로 튈지 알 수 없는 행동으로 ‘샘’을 놀라게 한다.\r\n그러던 중 어른들은 모르는 ‘테스’의 비밀스러운 계획을 알게 된 ‘샘’은 이에 동참하게 되는데…\r\n얼마 남지 않은 여름의 끝, 그전에 미션을 수행해야 한다!\r\n\r\n혼자도 좋지만… 함께여서 더욱 좋은!\r\n‘샘’과 ‘테스’의 인생을 건 여름 프로젝트가 시작된다!","prdtYear":"2019","indieYn":null,"artmovieYn":null,"multmovieYn":"Y","showTm":"84","showTs":"10","director":"스티븐 바우터루드","prNm":null,"dtNm":"(주)팝엔터테인먼트","repNationCd":"네덜란드","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마","watchGradeNm":"전체관람가","openDt":"20200910","salesAmt":3737270,"audiCnt":473,"scrCnt":123,"showCnt":153,"rank":10,"rankInten":-3,"rankOldAndNew":"OLD","rownum":10}]

 */
import java.util.*;
public class JSONManager {

	public List<MovieVO> movieListData(int no)
	{
		List<MovieVO> list=new ArrayList<MovieVO>();
		try
		{
			String site="";
			if(no==1)
			{
				site="http://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do";
			}
			else if(no==2)
			{
				site="http://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do";
			}
			else if(no==3)
			{
				site="http://www.kobis.or.kr/kobis/business/main/searchMainDailySeatTicket.do";
			}
			else if(no==4)
			{
				site="http://www.kobis.or.kr/kobis/business/main/searchMainOnlineDailyBoxOffice.do";
			}
			
			// 연결 시도
			Document doc=Jsoup.connect(site).get();
			Element json=doc.selectFirst("body");
			//System.out.println(json.text());
			
			// JSON파싱 
			JSONParser jp=new JSONParser();
			// 데이터를 받는다  [{},{},{},{}...]
			// [] => JSONArray
			// {} => JSONObject
			JSONArray arr=(JSONArray)jp.parse(json.text());
			//System.out.println(arr.toJSONString());
			
			
			for(int i=0;i<arr.size();i++)
			{
				//{} => JSONObject
				JSONObject obj=(JSONObject)arr.get(i);
				// {} => 10개 출력
				//System.out.println(obj.toJSONString());
				// 데이터를 VO에 저장 
				MovieVO vo=new MovieVO();
				vo.setMovieCd((String)obj.get("movieCd"));
				vo.setMovieNm((String)obj.get("movieNm"));
				vo.setMovieNmEn((String)obj.get("movieNmEn"));
				vo.setDirector((String)obj.get("director"));
				vo.setWatchGradeNm((String)obj.get("watchGradeNm"));
				vo.setRank((long)obj.get("rank"));
				vo.setGenre((String)obj.get("genre"));
				vo.setSynop((String)obj.get("synop"));
				vo.setThumbUrl((String)obj.get("thumbUrl"));
				// 디버깅 
				System.out.println("영화번호:"+vo.getMovieCd());
				System.out.println("영화명:"+vo.getMovieNm());
				System.out.println("영화명(영문):"+vo.getMovieNmEn());
				System.out.println("감독:"+vo.getDirector());
				System.out.println("포스터:"+vo.getThumbUrl());
				list.add(vo);
			}
		}catch(Exception ex){}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONManager m=new JSONManager();
		m.movieListData(2);
		/*
		 * try { String
		 * url="http://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do";
		 * //URL주소 연결 Document doc=Jsoup.connect(url).get();
		 * //System.out.println(doc.toString()); // <body>태그안에 있는 데이터만 읽기
		 * 
		 * Element json=doc.selectFirst("body"); //System.out.println(json.text());
		 * String movie_data=json.text(); JSONParser jp=new JSONParser(); JSONArray
		 * arr=(JSONArray)jp.parse(movie_data); System.out.println(arr.toJSONString());
		 * for(int i=0;i<arr.size();i++) { JSONObject obj=(JSONObject)arr.get(i);
		 * //System.out.println(obj.toJSONString()); long rank=(long)obj.get("rank"); //
		 * JSON => long String movie_name=(String)obj.get("movieNm"); String
		 * genre=(String)obj.get("genre"); String grade=(String)obj.get("watchGradeNm");
		 * String director=(String)obj.get("director"); System.out.println(rank);
		 * System.out.println(movie_name); System.out.println(genre);
		 * System.out.println(grade); System.out.println(director);
		 * System.out.println("===================="); // 문제 => 감독 } }catch(Exception
		 * ex){}
		 */
	}

}






