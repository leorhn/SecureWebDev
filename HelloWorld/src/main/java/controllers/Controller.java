package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import services.DBService;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns={"/SearchServlet"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		String dispatchPath = null;
		ArrayList<Book> bookList = new ArrayList<>();
		switch(servletPath){
		case "/SearchServlet":
			switch(session.getAttribute("filterstring").toString()){
			case "title":
				bookList = DBService.getBooksByTitle(session.getAttribute("searchstring").toString());
				request.setAttribute("booklist", bookList);
				break;
			case "author":
				bookList = DBService.getBooksByAuthor(session.getAttribute("searchstring").toString());
				request.setAttribute("booklist", bookList);
				break;
			case "publisher":
				bookList = DBService.getBooksByPublisher(session.getAttribute("searchstring").toString());
				request.setAttribute("booklist", bookList);
				break;
			}
			dispatchPath = "homepage.jsp";
			break;
		}
		request.getRequestDispatcher(dispatchPath).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
