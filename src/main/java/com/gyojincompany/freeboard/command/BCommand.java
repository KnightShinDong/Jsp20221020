package com.gyojincompany.freeboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface BCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
		
	
}
 