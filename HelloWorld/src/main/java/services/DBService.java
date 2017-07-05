package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Book;
import model.Borrower;
import model.MeetingRoomReservation;
import model.Question;
import model.Review;
import model.User;

public class DBService {

	
	public static boolean checkUser(String username, String password){
		
		String sql= "SELECT * FROM user";//code to check if username and password matched
    
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt= connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getString("username").equals(username)){
					if(rs.getString("pass_word").equals(password))
						return true;
				}
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return false;
		
	}
	
	public static void addUser(User user){
		
		/*SimpleDateFormat format = null;
		Date parsed_bday = null;
		java.sql.Date bday_sql = null;*/
		
		String sql= "INSERT INTO user (username_id, first_name,middle_name,last_name,user_name,pass_word,email_address,id_number,birthday,question_id,answer,"
				+ "account_type) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt=null;
		
		try{
			pstmt= connection.prepareStatement(sql);
			pstmt.setInt(1, user.getUserNameID());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getMiddleName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getUserName());
			pstmt.setString(6, user.getPassword());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getIdNumber());
			/*try{
				format = new SimpleDateFormat("yyyyMMdd");
				parsed_bday = format.parse(user.getBirthday());
				bday_sql = new java.sql.Date(parsed_bday.getTime());
			}catch(Exception e){
				e.printStackTrace();
			}*/
			pstmt.setDate(9, user.getBirthday());
			pstmt.setInt(10, user.getQuestionID());
			pstmt.setString(11, user.getAnswer());
			pstmt.setString(12, user.getType());
			
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean editUser(User user){
		
		
		/*SimpleDateFormat format = null;
		Date parsed_bday = null;
		java.sql.Date bday_sql = null;*/
		boolean result = false;
		
		// using username replace all data in User with the given object
		String sql= "UPDATE user SET first_name=?, middle_name=?, last_name=?, pass_word=?, email_address=?, id_number=?, birthday=?, question_id=?,"
				+ "answer=?, account_type=? WHERE user_name=?";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getMiddleName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getIdNumber());
			/*try{
				format = new SimpleDateFormat("yyyyMMdd");
				parsed_bday = format.parse(user.getBirthday());
				bday_sql = new java.sql.Date(parsed_bday.getTime());
			}catch(Exception e){
				e.printStackTrace();
			}*/
			pstmt.setDate(7, user.getBirthday());
			pstmt.setInt(8, user.getQuestionID());
			pstmt.setString(9, user.getAnswer());
			pstmt.setString(10, user.getType());
			pstmt.setString(11, user.getUserName());
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	

	public static boolean deleteUser(String userName){
		boolean result = false;
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			sql="DELETE FROM user WHERE user_name=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static User getUser(String userName){

		User user=new User();
		String sql = "";
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM user WHERE user_name=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				user.setFirstName(rs.getString("first_name"));
				user.setMiddleName(rs.getString("middle_name"));
				user.setLastName(rs.getString("last_name"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("pass_word"));
				user.setEmail(rs.getString("email_address"));
				user.setIdNumber(rs.getString("id_number"));
				user.setBirthday(rs.getDate("birthday"));
				user.setQuestionID(rs.getInt("question_id"));
				user.setAnswer(rs.getString("answer"));
				user.setType(rs.getString("account_type"));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return user;
	}
	
public static void addBook(Book book){
		
		String sql= "INSERT INTO book (location, title, author, publisher, year, status, type) VALUES(?,?,?,?,?,?,?)";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt=null;
		
		try{
			pstmt= connection.prepareStatement(sql);
			pstmt.setInt(1, book.getLocation());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getYear());
			pstmt.setString(6, book.getStatus());
			pstmt.setString(7, book.getType());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<book.getTags().size(); i++){
			addTag(book.getBookID(),book.getTags().get(i));
		}
		
	}
	
	public static boolean editBook(Book book){
		
		boolean result = false;
		
		String sql= "UPDATE book SET location=?, title=?, author=?, publisher=?, year=?, status=?, type=? WHERE book_id=?";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			pstmt.setInt(1, book.getLocation());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getYear());
			pstmt.setString(6, book.getStatus());
			pstmt.setString(7, book.getType());
			pstmt.setInt(8, book.getBookID());
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(result){
			deleteTags(book.getBookID());
			for(int i=0; i<book.getTags().size(); i++){
				addTag(book.getBookID(),book.getTags().get(i));
			}
		}
		
		return result;
		
	}
	

	public static boolean deleteBook(int bookID){
		boolean result = false;
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			sql="DELETE FROM book WHERE book_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(result)
			deleteTags(bookID);
		
		return result;
	}
	
	public static Book getBook(int bookID){

		Book book = new Book();
		String sql = "";
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM book WHERE book_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				book.setBookID(rs.getInt("book_id"));
				book.setLocation(rs.getInt("location"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setYear(rs.getString("year"));
				book.setStatus(rs.getString("status"));
				book.setType(rs.getString("type"));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		book.setTags(getTags(book.getBookID()));
		
		return book;
	}
	
	public static ArrayList<Book> getAllBooks(){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM book";
			pstmt = connection.prepareStatement(sql);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
	public static ArrayList<Book> getBooksByLocation(int location){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM book WHERE location=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, location);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
	public static ArrayList<Book> getBooksByTitle(String title){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		title = "%"+title+"%";
		try{
			sql="SELECT * FROM book WHERE title LIKE ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
	public static ArrayList<Book> getBooksByAuthor(String author){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		author = "%"+author+"%";
		try{
			sql="SELECT * FROM book WHERE author LIKE ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, author);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
	public static ArrayList<Book> getBooksByPublisher(String publisher){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		publisher = "%"+publisher+"%";
		try{
			sql="SELECT * FROM book WHERE publisher LIKE ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, publisher);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
	public static ArrayList<Book> getBooksByYear(String year){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM book WHERE year=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, year);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
	public static ArrayList<Book> getBooksByStatus(String status){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM book WHERE status=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
	public static ArrayList<Book> getBooksByType(String type){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM book WHERE type=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
public static void addBorrower(Borrower borrower){
		
		String sql= "INSERT INTO borrower (user_name, book_id, date_borrowed, date_returned, returned) VALUES(?,?,?,?,?)";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt=null;
		
		try{
			pstmt= connection.prepareStatement(sql);
			pstmt.setString(1, borrower.getUserName());
			pstmt.setInt(2, borrower.getBookID());
			pstmt.setDate(3, borrower.getDateBorrowed());
			pstmt.setDate(4, borrower.getDateReturned());
			pstmt.setBoolean(5, borrower.isReturned());	
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean editBorrower(Borrower borrower){
		
		boolean result = false;
		
		String sql= "UPDATE borrower SET user_name=?, book_id=?, date_borrowed=?, date_returned=?, returned=? WHERE borrower_id=?";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			pstmt.setString(1, borrower.getUserName());
			pstmt.setInt(2, borrower.getBookID());
			pstmt.setDate(3, borrower.getDateBorrowed());
			pstmt.setDate(4, borrower.getDateReturned());
			pstmt.setBoolean(5, borrower.isReturned());
			pstmt.setInt(6, borrower.getBorrowerID());
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	

	public static boolean deleteBorrower(int borrowerID){
		boolean result = false;
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			sql="DELETE FROM borrower WHERE borrower_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, borrowerID);
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Borrower getBorrower(int borrowerID){

		Borrower borrower = new Borrower();
		String sql = "";
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM borrower WHERE borrower_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, borrowerID);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				borrower.setBorrowerID(borrowerID);
				borrower.setUserName(rs.getString("user_name"));
				borrower.setBookID(rs.getInt("book_id"));
				borrower.setDateBorrowed(rs.getDate("date_borrowed"));
				borrower.setDateReturned(rs.getDate("date_returned"));
				borrower.setReturned(rs.getBoolean("returned"));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return borrower;
	}
	
	public static Question getQuestion(int questionID){

		Question question = new Question();
		String sql = "";
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM question WHERE question_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, questionID);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				question.setQuestionID(rs.getInt("question_id"));
				question.setQuestion(rs.getString("question"));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return question;
	}
	
	public static ArrayList<Question> getAllQuestions(){

		ArrayList<Question> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM question";
			pstmt = connection.prepareStatement(sql);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Question());
				list.get(list.size()-1).setQuestionID(rs.getInt("question_id"));
				list.get(list.size()-1).setQuestion(rs.getString("question"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
public static void addReview(Review review){
		
		String sql= "INSERT INTO reviews (review, user_name, book_id, date, time) VALUES(?,?,?,?,?)";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt=null;
		
		try{
			pstmt= connection.prepareStatement(sql);
			pstmt.setString(1, review.getReview());
			pstmt.setString(2, review.getUserName());
			pstmt.setInt(3, review.getBookID());
			pstmt.setDate(4, review.getDate());
			pstmt.setTime(5, review.getTime());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean editReview(Review review){
		
		boolean result = false;
		
		String sql= "UPDATE reviews SET review=?, user_name=?, book_id=?, date=?, time=? WHERE review_id=?";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			pstmt.setString(1, review.getReview());
			pstmt.setString(2, review.getUserName());
			pstmt.setInt(3, review.getBookID());
			pstmt.setDate(4, review.getDate());
			pstmt.setTime(5, review.getTime());
			pstmt.setInt(6, review.getReviewID());
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	

	public static boolean deleteReview(int reviewID){
		boolean result = false;
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			sql="DELETE FROM reviews WHERE review_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, reviewID);
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Review getReview(int reviewID){

		Review review = new Review();
		String sql = "";
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM reviews WHERE review_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, reviewID);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				review.setReviewID(reviewID);
				review.setReview(rs.getString("review"));
				review.setUserName(rs.getString("user_name"));
				review.setBookID(rs.getInt("book_id"));
				review.setDate(rs.getDate("date"));
				review.setTime(rs.getTime("time"));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return review;
	}
	
	public static ArrayList<Review> getReviewsByUserName(String userName){

		ArrayList<Review> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM reviews WHERE user_name=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Review());
				list.get(list.size()-1).setReviewID(rs.getInt("review_id"));
				list.get(list.size()-1).setReview(rs.getString("review"));
				list.get(list.size()-1).setUserName(rs.getString("user_name"));
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setDate(rs.getDate("date"));
				list.get(list.size()-1).setTime(rs.getTime("time"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static ArrayList<Review> getReviewsByBook(int bookID){

		ArrayList<Review> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM reviews WHERE book_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Review());
				list.get(list.size()-1).setReviewID(rs.getInt("review_id"));
				list.get(list.size()-1).setReview(rs.getString("review"));
				list.get(list.size()-1).setUserName(rs.getString("user_name"));
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setDate(rs.getDate("date"));
				list.get(list.size()-1).setTime(rs.getTime("time"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
public static void addTag(int bookID, String tag){
		
		String sql= "INSERT INTO tag (book_id, tag_name) VALUES(?,?)";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt=null;
		
		try{
			pstmt= connection.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			pstmt.setString(2, tag);
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}	

	public static boolean deleteTags(int bookID){
		boolean result = false;
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			sql="DELETE FROM tag WHERE bookID=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static ArrayList<String> getTags(int bookID){

		ArrayList<String> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM tag WHERE book_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(rs.getString("tag_name"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
public static void addMeetingRoomReservation(MeetingRoomReservation meetingRoomReservation){
		
		String sql= "INSERT INTO meeting_room (room_number, user_name, date, time_in, time_out) VALUES(?,?,?,?)";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt=null;
		
		try{
			pstmt= connection.prepareStatement(sql);
			pstmt.setInt(1, meetingRoomReservation.getRoomNum());
			pstmt.setString(2, meetingRoomReservation.getUserName());
			pstmt.setDate(3, meetingRoomReservation.getDate());
			pstmt.setTime(4, meetingRoomReservation.getTimeIn());
			pstmt.setTime(5, meetingRoomReservation.getTimeOut());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean editMeetingRoomReservation(MeetingRoomReservation meetingRoomReservation){
		
		boolean result = false;
		
		String sql= "UPDATE book SET room_number=?, user_name=?, date=?, time_in=?, time_out=? WHERE meeting_room_id=?";
		
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			pstmt.setInt(1, meetingRoomReservation.getRoomNum());
			pstmt.setString(2, meetingRoomReservation.getUserName());
			pstmt.setDate(3, meetingRoomReservation.getDate());
			pstmt.setTime(4, meetingRoomReservation.getTimeIn());
			pstmt.setTime(5, meetingRoomReservation.getTimeOut());
			pstmt.setInt(6, meetingRoomReservation.getMeetingRoomID());
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	

	public static boolean deleteMeetingRoomReservation(int meetingRoomReservationID){
		boolean result = false;
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try{
			sql="DELETE FROM meeting_room WHERE meeting_room_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, meetingRoomReservationID);
			int check = pstmt.executeUpdate();
			if(check!=0)
				result = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				if(!connection.isClosed())
					connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public static ArrayList<MeetingRoomReservation> getAllMeetingRoomReservations(){

		ArrayList<MeetingRoomReservation> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM meeting_room";
			pstmt = connection.prepareStatement(sql);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new MeetingRoomReservation());
				list.get(list.size()-1).setMeetingRoomID(rs.getInt("meeting_room_id"));
				list.get(list.size()-1).setRoomNum(rs.getInt("room_number"));
				list.get(list.size()-1).setUserName(rs.getString("user_name"));
				list.get(list.size()-1).setDate(rs.getDate("date"));
				list.get(list.size()-1).setTimeIn(rs.getTime("time_in"));
				list.get(list.size()-1).setTimeOut(rs.getTime("time_out"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public static ArrayList<MeetingRoomReservation> getMeetingRoomReservationsByDate(Date date){

		ArrayList<MeetingRoomReservation> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			sql="SELECT * FROM meeting_room WHERE date=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1, date);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new MeetingRoomReservation());
				list.get(list.size()-1).setMeetingRoomID(rs.getInt("meeting_room_id"));
				list.get(list.size()-1).setRoomNum(rs.getInt("room_number"));
				list.get(list.size()-1).setUserName(rs.getString("user_name"));
				list.get(list.size()-1).setDate(rs.getDate("date"));
				list.get(list.size()-1).setTimeIn(rs.getTime("time_in"));
				list.get(list.size()-1).setTimeOut(rs.getTime("time_out"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public static ArrayList<Book> searchBooks(String s){

		ArrayList<Book> list= new ArrayList<>();
		String sql;
		Connection connection= DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String temp = "%";
		s = temp.concat(s+"%");
		try{
			sql="SELECT * FROM book WHERE author LIKE ? OR title LIKE ? OR publisher LIKE ? OR type LIKE ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, s);
			pstmt.setString(2, s);
			pstmt.setString(3, s);
			pstmt.setString(4, s);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while(rs.next()){
				list.add(new Book());
				list.get(list.size()-1).setBookID(rs.getInt("book_id"));
				list.get(list.size()-1).setLocation(rs.getInt("location"));
				list.get(list.size()-1).setTitle(rs.getString("title"));
				list.get(list.size()-1).setAuthor(rs.getString("author"));
				list.get(list.size()-1).setPublisher(rs.getString("publisher"));
				list.get(list.size()-1).setYear(rs.getString("year"));
				list.get(list.size()-1).setStatus(rs.getString("status"));
				list.get(list.size()-1).setType(rs.getString("type"));
			}

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(!pstmt.isClosed())
					pstmt.close();
				connection.close();
				if(!rs.isClosed())
					rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setTags(getTags(list.get(i).getBookID()));
		}
		
		return list;
	}
	
}
	
	

	