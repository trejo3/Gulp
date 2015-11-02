

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewProfile
 */
@WebServlet("/NewProfile")
public class NewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String connectionUrl = "jdbc:oracle:thin:@localhost:1521:xe";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sql = "insert into users (username, name, email, zip) values (?, ?, ?, ?)";
//		String sql = "insert into users (username, name, email, zip) values ('testUN', 'test Name', 'testeMail@test.com', '12345')";
		System.out.println(sql);
		try
		{
			System.out.println("im in the try");
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, request.getParameter("username"));
			ps.setString(2, request.getParameter("fullName"));
			ps.setString(3, request.getParameter("email"));
			ps.setString(4, request.getParameter("zipCode"));
			System.out.println(ps.executeUpdate());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 


		//add the record count to a session
		HttpSession session = request.getSession();
		session.setAttribute("username", request.getParameter("username"));

//		request.setAttribute("message",message);
		getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}
	
	private Connection getConnection() throws ClassNotFoundException, ServletException, IOException
	{
		Connection connection = null;
		try
		{
			String url = "jdbc:oracle:thin:system/password@localhost";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties prop = new Properties();
			prop.setProperty("user", "testuserdb");
			prop.setProperty("password", "password");
			connection = DriverManager.getConnection(url, prop);
			return connection;
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
