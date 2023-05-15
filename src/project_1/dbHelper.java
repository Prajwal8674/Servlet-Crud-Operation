package project_1;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class dbHelper {
	    String driver = "com.mysql.jdbc.Driver";
		String dbName = "project";
		String url    = "jdbc:mysql://localhost:3306/"+dbName;
		String dbname ="root";
		String dbpass = "admin01";
		
		public int add(pojoOne p) throws ClassNotFoundException, SQLException{
			Class.forName(driver);
			java.sql.Connection con = DriverManager.getConnection(url,dbname,dbpass);
			java.sql.PreparedStatement ps = con.prepareStatement("insert into userdata values(?,?,?)");
			ps.setString(1, p.getUname()) ;
			ps.setString(2, p.getUemail()) ; 
			ps.setString(3, p.getUpass()) ;
			
			int a = ps.executeUpdate();
            return a;
		
		}	
		
		public boolean checkUser(String email) throws SQLException, ClassNotFoundException{
			Class.forName(driver) ;
			java.sql.Connection con =DriverManager.getConnection(url,dbname,dbpass);
			java.sql.PreparedStatement ps = con.prepareStatement("select * from userdata where email=?");
			ps.setString(1, email) ;
			ResultSet rs = ps.executeQuery() ;
			
			if(rs.absolute(1))
				return true;
				
				con.close() ;
				return false;						
}

		
		public boolean checkForLogin(String email , String pass ) throws ClassNotFoundException, SQLException{
			boolean check = false;
			Class.forName(driver);
			java.sql.Connection con =DriverManager.getConnection(url,dbname,dbpass);
			java.sql.PreparedStatement ps = con.prepareStatement("select * from userdata where email=? and password=?");
			
			ps.setString(1,email);
			ps.setString(2,pass);

			ResultSet rs = ps.executeQuery();
			check=rs.next();
			
			return check;
			
		}
		public ArrayList<pojoOne> getAllUser() throws ClassNotFoundException, SQLException {

			String sql="select * from userdata";
	        java.sql.Connection con=DriverManager.getConnection(url,dbname,dbpass);
			PreparedStatement ps=con.prepareStatement(sql);

			ResultSet  rs= ps.executeQuery();
			
			ArrayList<pojoOne> p=new ArrayList<>();
			
			while(rs.next())
			{
				pojoOne p1 =new pojoOne( rs.getString(1), rs.getString(2), rs.getString(3));
				p.add(p1);
			}
			
			con.close();
			
			return p;
			
		}
	
		}
