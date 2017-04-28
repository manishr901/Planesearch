import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Regisration")
public class Registration extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* PrintWriter out = resp.getWriter(); */
		System.out.println("sdiuoh");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String contact = req.getParameter("contact");
		String bloodgroup = req.getParameter("blood_group");
		String street = req.getParameter("street");
		String area = req.getParameter("area");
		String city = req.getParameter("city");
		String district = req.getParameter("dist");

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"1234");
			Statement stmnt = con.createStatement();
			String sql = "insert into Registration values('" + name + "','" + email + "','" + password + "','"
					+ bloodgroup + "','" + contact + "','" + street + "','" + area + "','" + city + "','" + district
					+ "')";
			stmnt.executeUpdate(

					"insert into registration values('" + name + "','" + email + "','" + password + "','" + bloodgroup
							+ "','" + contact + "','" + street + "','" + area + "','" + city + "','" + district + "')");
			System.out.println(
					"sucessfully inserted" + name + email + contact + street + area + city + district + bloodgroup);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
