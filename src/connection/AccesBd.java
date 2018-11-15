package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesBd {

	private static String utilisateur="root";
	private static String motDePasse="Bruc3Wayn3023007";
	private static String pilote = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/bd_apprenants?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static Connection connection = null;

	static {

		try {
			Class.forName(pilote);
			System.out.println("Vous avez le bon pilote.");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Vous n'avez pas le bon pilote.");

		} 
		
	}
	
	public static Connection getConnection() {
		
		try {
			connection = DriverManager.getConnection(url, utilisateur, motDePasse);
			System.out.println("Votre connexion est établie.");
		} catch (SQLException f) {
			f.printStackTrace();
			System.out.println("Votre connexion n'est pas établie.");
		}
		
		return connection;
		
	}
	
	public static ResultSet faireUneRequete(String requete) {
		
		Statement instruction = null;
		ResultSet resultat = null;
		
		try {
			instruction = getConnection().createStatement();
			resultat = instruction.executeQuery(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
		
	}
	
	

}