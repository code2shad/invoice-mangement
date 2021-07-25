package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		setAccessControlHeaders(response);
		
		String url="jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Response res = new Response();
		
		res.setInvoice(request.getParameter("invoiceNo"));
System.out.println(res.getInvoice());
				
				
				String userName = "root";
				String pass = "root";
				String query = "DELETE FROM highradius WHERE `invoice_id` = ?;";
				int result =0;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,userName,pass);
					PreparedStatement smt = con.prepareStatement(query);
					
					
					
					smt.setString(1, res.getInvoice());
					
					
					result = smt.executeUpdate();
					
					List<FinalResponse> resFinal = new ArrayList<>();
					FinalResponse finalResponse = new FinalResponse();
					if(result>0) {
						finalResponse.setSuccess("1");
					finalResponse.setMessage("Data deleted Successfully");
					}else {
						finalResponse.setSuccess("0");
						finalResponse.setMessage("Data deletion failed");
					}
					resFinal.add(finalResponse);
					
					Gson gson = new GsonBuilder().create();
					String json = gson.toJson(resFinal);
					response.setContentType("application/json");
					response.getWriter().write(json);
					
					
					
					
							smt.close();
						con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	private void setAccessControlHeaders(HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		
	}

}
