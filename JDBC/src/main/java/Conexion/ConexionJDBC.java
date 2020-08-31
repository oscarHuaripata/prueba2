package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.solweb.nuevo.HomeController;



public class ConexionJDBC {
	
	Connection con=null;
	//Statement statement;
	PreparedStatement preSta;
	
	String url="jdbc:sqlserver://localhost:1433;" +
            "databaseName=nuevo;integratedSecurity=true;";
	
	
	private static final Logger logger =  LoggerFactory.getLogger(HomeController.class);
	
	
	
	public ConexionJDBC() {
		super();
		// TODO Auto-generated constructor stub
		
		try {
		    
			DriverManager.registerDriver(
					new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			
			 con=DriverManager.getConnection(url);
			 
			  //statement=con.createStatement();
			 
			// int res=statement.executeUpdate("Create table virus(id int,nombre varchar(30))");
		
					
			 //statement.close();
			// con.close();
			 System.out.println("tabla creada...");
			 
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("tabla ya existe");
			e.printStackTrace();
			
			logger.info("tabla ya fue creada");
		}
		
	}
	
	
    public void inserInfo() {
    	
    	String sql="INSERT INTO virus VALUES(?,?)";
    	
    	
    	try {
    		//int resul=statement.executeUpdate(sql);
    		for (int i = 0; i < 100; i++) {
    			
    			preSta=con.prepareStatement(sql);
    			preSta.setInt(1, i+2);
    			preSta.setString(2, "virus" +1);
    			preSta.executeUpdate();
			}
    		
    		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
