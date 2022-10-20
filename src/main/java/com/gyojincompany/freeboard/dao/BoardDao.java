package com.gyojincompany.freeboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gyojincompany.freeboard.dto.BoardDto;

public class BoardDao {
	
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/serverdb";
	static String user = "root";
	static String pass = "12345";
	
	public void write(String bname, String btitle, String bcontent) {  //글쓰기
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO freeboard(bname, btitle, bcontent, bhit) "
				+ "VALUES ('"+bname+"','"+btitle+"','"+bcontent+"',0)";
		
		try {
			Class.forName(driverName); // jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass);//DB 연동 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성
			
			pstmt.executeUpdate();//sql 실행
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<BoardDto> list() { //모든글을 가져오기 때문에 매개변수가 필요없음  //글목록 가져오기
		//
		String sql = "SELECT * FROM freeboard"; //DB에 저장된 모든글 가저오기(리스트용)
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs= null; //셀렉을 했을때 담을 그릇을 만드는 문구
							//셀렉트 문이 반환하는 데이터를 담는 객체 선언
		
		try {
			Class.forName(driverName); // jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass);//DB 연동 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성
			
			rs = pstmt.executeQuery();//sql 실행 -rs로 받음
			
			while (rs.next()) {     //rs의 글 개수 만큼 반복(while문이 좋음)
				int bid = rs.getInt("bid");  //첫번째 글에 대해 필드1번을 빼옴
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				
				int bhit = rs.getInt("bhit"); //조회수는 숫자로 올라가기 때문에 int로 해야됨
				
				//dto에 저장하기 위해 dto 객체를 하나 만듬
				BoardDto dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit);
//				dto.setBid(bid);
//				dto.setBname(bname);
//				dto.setBtitle(btitle);
//				dto.setBcontent(bcontent);
//				dto.setBdate(bdate);
//				dto.setBhit(bhit);
				dtos.add(dto);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;
		
		
		
		//return 모든글;
		
	}
}