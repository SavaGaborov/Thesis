package metode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {

	public static Connection getKonekcija(){
		return conn;
		
	}
	
	//Zatavara se konekcija ukoliko vec postoji i prikazuje problem prilikom zatavaranja konekcije
	public static void ZatvoriKonekciju(){
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}}
	
	//Konektuje se na bazu i vraca status konekcije 
	private static Connection conn=null; //promenljiva static tipa connection 
	
	static{								// blok static koji se automatski poziva
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bpprivatnabolnica","root","start");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
