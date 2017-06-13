

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class CustServlet
 */
@WebServlet("/CustServlet")
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub

		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql = "select FirstName, LastName, StreetAddress,City,State,ZipCode, EmailAddress, Position, customers.AddressID from customers,Address,tblPosition "
					+ "where customers.AddressID=Address.AddressID AND customers.PositionID=tblPosition.PositionID AND customers.LastName=?";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Custumers?"+ "user=root&password=password");
            pstmt = con.prepareStatement(sql);
            String LastName=request.getParameter("LastName");
            pstmt.setString(1, LastName);
            rs = pstmt.executeQuery();
    		String nextURL="/Customer.jsp";
    		String message="FirstName";
    		request.setAttribute("FirstName",message);
    		String message2="LastName";
    		request.setAttribute("FirstName",message2);
    		String message3="StreetAddress";
    		request.setAttribute("StreetAddress",message3);
    		String message4="City";
    		request.setAttribute("City",message4);
    		String message5="State";
    		request.setAttribute("State",message5);
    		String message6="ZipCode";
    		request.setAttribute("ZipCode",message6);
    		String message7="EmailAddress";
    		request.setAttribute("EmailAddress",message7);
    		String message8="Position";
    		request.setAttribute("Position",message8);
    		String message9="customers.AddressID";
    		request.setAttribute("customers.AddressID",message9);
    		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
    		

		}catch (SQLException e){

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
		//doGet(request, response);
	}
}
}
}
