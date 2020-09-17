package com.sist.json;
/*
 *   "movieCd":"20201122",
 *   thumbUrl":"/common/mast/movie/2020/08/thumb/thn_a529042d7d004a6daf64a3f8a687dd69.jpg",
 *          "movieNm":"테넷",
 *          "movieNmEn":"Tenet",
 *          "synop":"당신에게 줄 건 한 단어 ‘테넷’\r\n“이해하지 말고 느껴라!”\r\n\r\n시간의 흐름을 뒤집는 인버전을 통해 현재와 미래를 오가며 세상을 파괴하려는 사토르(케네스 브래너)를 막기 위해 투입된 작전의 주도자(존 데이비드 워싱턴). 인버전에 대한 정보를 가진 닐(로버트 패틴슨)과 미술품 감정사이자 사토르에 대한 복수심이 가득한 그의 아내 캣(엘리자베스 데비키)과 협력해 미래의 공격에 맞서 제3차 세계대전을 막아야 한다!\r\n\r\n[KEY POINT]\r\n인버전: 사물의 엔트로피를 반전시켜 시간을 거스를 수 있는 미래 기술. 미래에서 인버전된 무기를 현재로 보내 과거를 파괴할 수 있다.",
 *          "director":"크리스토퍼 놀란", obj.get("director")
 *          "genre":"액션,SF", String genre=(String)obj.get("genre");
 *          "watchGradeNm":"12세이상관람가",
 *          "rank":1,
 *          
 *          Map (키,값)
 *          
 */
public class MovieVO {
    private String movieCd;//영화번호
    private String thumbUrl;// poster
    private String movieNm;//한글 제목
    private String movieNmEn;//영문제목
    private String synop;//스토리
    private String director;//감독
    private String genre;//장르
    private String watchGradeNm;//등급
    private long rank;//순위
	public String getMovieCd() {
		return movieCd;
	}
	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getMovieNmEn() {
		return movieNmEn;
	}
	public void setMovieNmEn(String movieNmEn) {
		this.movieNmEn = movieNmEn;
	}
	public String getSynop() {
		return synop;
	}
	public void setSynop(String synop) {
		this.synop = synop;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getWatchGradeNm() {
		return watchGradeNm;
	}
	public void setWatchGradeNm(String watchGradeNm) {
		this.watchGradeNm = watchGradeNm;
	}
	public long getRank() {
		return rank;
	}
	public void setRank(long rank) {
		this.rank = rank;
	}
   
   
}
