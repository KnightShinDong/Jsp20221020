package com.gyojincompany.freeboard.dto;
												//Dto -  생성자 2개, getter,setter
public class BoardDto {
	private int bid; //게시글번호
	private String bname; //글쓴이
	private String btitle; //글게시글제목
	private String bcontent; //게시글 내용
	private String bdate; //글 게시 시간
	private int bhit; //조회수
	//private int bgroup; //댓글그룹언어
	//private int bstep; //댓글단계번호
	//private int bindent; //댓글의 댓글 들여쓰기
	
	public BoardDto() { //기본생성자
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int bid, String bname, String btitle, String bcontent, String bdate, int bhit) { //메게변수가 다르면 한클래스에 여러게의 메소드를 생성할수있다(오버로딩)-다양성
		super();
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
		//this.bgroup = bgroup;
		//this.bstep = bstep;
		//this.bindent = bindent;
	}
	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

//	public int getBgroup() {
//		return bgroup;
//	}
//
//	public void setBgroup(int bgroup) {
//		this.bgroup = bgroup;
//	}
//
//	public int getBstep() {
//		return bstep;
//	}
//
//	public void setBstep(int bstep) {
//		this.bstep = bstep;
//	}
//
//	public int getBindent() {
//		return bindent;
//	}
//
//	public void setBindent(int bindent) {
//		this.bindent = bindent;
//	}

	

}
