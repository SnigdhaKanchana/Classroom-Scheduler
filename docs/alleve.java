import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alleve extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
try
   {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("Select * from classtab");
	out.println("<h1 align='center' style='font-family:Verdana'>Available events</h1>"); 
	out.println("<table border=1 align='center'>");
	out.println("<tr><th style='background-color:#F5A1A3;font-size: 24px;color:white;font-family:Verdana'>Teacher name</th><th style='background-color:#F5A1A3;font-size: 24px;color:white;font-family:Verdana'>Event Name</th><th style='background-color:#F5A1A3;font-size: 24px;color:white;font-family:Verdana'>Start Date</th><th style='background-color:#F5A1A3;font-size: 24px;color:white;font-family:Verdana'>End Date</th><th style='background-color:#F5A1A3;font-size: 24px;color:white;font-family:Verdana'>Description</th></tr>");
	while(rs.next()){
		String name = rs.getString("tname");
		String eventname = rs.getString("ename");
		String start = rs.getString("startdate");
		String end = rs.getString("enddate");
        String desc = rs.getString("description");
		out.println("<tr><td style='font-family:Verdana;font-size: 24px;'>"+ name + "</td><td style='font-family:Verdana;font-size: 24px;'>"+ eventname + "</td><td style='font-family:Verdana;font-size: 24px;'>"+ start + "</td><td style='font-family:Verdana;font-size: 24px;'>"+ end + "</td><td style='font-family:Verdana;font-size: 24px;'>"+ desc +"</td></tr>");
		
	}
	out.println("</table>");
	out.println("</body></html>");
	
}
  
catch(Exception ex)
{ 
 out.println(ex);
}
} 
}