package com.gyojincompany.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyojincompany.freeboard.command.BCommand;
import com.gyojincompany.freeboard.command.BListCommand;
import com.gyojincompany.freeboard.command.BWriteCommand;


@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BFrontController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri= request.getRequestURI(); //클라이언트가 요청한 uri 전부 가져오기
		String conPath = request.getContextPath();//context path 가져오기
		String comm = uri.substring(conPath.length()); //전체 uri에서 context 경로 길이만큼 빼기
		
		BCommand command = null; // 자식클래스에서 만든 객체는 부모클래스에서 다 받을수 있다.
												
		
		if(comm.equals("/write.do")) {
			System.out.println("write.do 요청!");
			command = new BWriteCommand();  
			command.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.do");
			dispatcher.forward(request, response);
			
		} else if (comm.equals("/list.do"));{
			System.out.println("list.do 요청!");
			
			command = new BListCommand();
			command.execute(request, response);
			//request 객체에 글 리스트가 셋팅됨
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
			dispatcher.forward(request, response);
			//리스트들을 화면으로 뷰단인 list.jsp로 보냄전달하여 찍어줌
		}
	}
}
