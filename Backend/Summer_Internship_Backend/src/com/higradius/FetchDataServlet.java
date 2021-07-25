package com.higradius;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class FetchDataServlet
 */
@WebServlet("/FetchDataServlet")
public class FetchDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url="jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		String userName ="root";
		String pass= "password";
		String query="SELECT * FROM highradius LIMIT 20;";
		
		try {
			//conection
			Class.forName("com.mysql.cj.jdbc.Driver");
			//conection stablished
			Connection con= DriverManager.getConnection(url,userName,pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			List<Response> data = new ArrayList<>();
			
			
			while(rs.next()) {
				Response res = new Response();
				res.setCustomerName(rs.getString("name_customer"));
				res.setCustomerNo(rs.getString("cust_number"));
				res.setDueDate(rs.getString("due_in_date"));
				res.setInvoice(rs.getString("invoice_id"));
				res.setInvoiceAmount(rs.getString("total_open_amount"));
				res.setClearDate(rs.getString("clear_date"));
				res.setPredictedAgingBucket(rs.getString("DELAY_BUCKET"));
				
				data.add(res);
			}
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(data);
			response.setContentType("application/json");
			response.getWriter().write(json);
			
			st.close();
			con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		
	}

}
