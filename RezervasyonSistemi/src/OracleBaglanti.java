import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OracleBaglanti {
	
	private static OracleBaglanti instance = null;
	private Connection con;

	private OracleBaglanti() {
		try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con=DriverManager.getConnection(
                   "jdbc:oracle:thin:@localhost:1521:xe","gazi1","gazi1");

            System.out.println("connection is succesfull");

        }catch(Exception e){ System.out.println(e);}
	}

	public static OracleBaglanti getInstance() {
		if (instance == null)
			instance = new OracleBaglanti();
		return instance;
	}

	public Connection getCon() {
		return con;
	}

}
