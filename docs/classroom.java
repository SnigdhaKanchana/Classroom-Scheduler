import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class classroom extends HttpServlet
{
//private String user1,pwd1,email1,phone;

public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String tname1=req.getParameter("tname");
String ename1=req.getParameter("ename");
String sdname1=req.getParameter("sdname");
String sdname2 = sdname1.replace('T',' ');
String fdname1=req.getParameter("fdname");
String fdname2 = fdname1.replace('T',' ');
String descinp1=req.getParameter("descinp");

try
   {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("Select * from classtab where startdate='"+sdname2+"'");
	if(rs.next()){
		out.println("<center><h1>An Event Already Exists</h1>");
		//out.println("<a href=Registartion_details.html>Please Log in</a></center>");
	}
	else
	{

   PreparedStatement ps=con.prepareStatement("INSERT INTO classtab values(?,?,?,?,?)");
 ps.setString(1,tname1);
ps.setString(2,ename1);
ps.setString(3,sdname2);
ps.setString(4,fdname2);
ps.setString(5,descinp1);
int i=ps.executeUpdate();
if(i>0)
{
	out.println("<center><h1>Event has been added</h1>");
	//out.println("<a href='/html/wp/Registration_details.html'>Register</a></center>");
}
	}
   }
   //con.close();
catch(Exception ex)
{  out.println(ex);
}
} 
}