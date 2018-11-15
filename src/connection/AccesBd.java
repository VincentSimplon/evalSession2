package connection;

/**
 * @author Vincent
 * classe permettant la connection à la base de données
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Connection : Une connexion avec une base de données spécifique. 
 *  Les instructions SQL sont exécutées et les résultats sont renvoyés dans le contexte d'une connexion.
 *  un objet Connection est capable de fournir des informations décrivant ses tables
 *   
 *  DriverManager : permet de chercher le pilote de connection
 *  
 *  ResultSet : s'utilise lors d'une instruction qui interroge la base de données.
 *  Un ResultSetobjet maintient un curseur pointant sur sa ligne de données actuelle.  
 *  La nextméthode déplace le curseur sur la ligne suivante et, comme elle est renvoyée false 
 *  lorsqu'il n'y a plus de lignes dans l' ResultSetobjet, elle peut être utilisée dans une whileboucle 
 *  pour parcourir le jeu de résultats.
 *  
 *  SQLExecption : fournit des informations sur une erreur d'accès à la base de données ou d'autres erreurs.
 *  printStackTrace : affiche l'exception et l'état d'exécution au moment de son appel
 *  
 *  Statement : Objet utilisé pour exécuter une instruction SQL statique et renvoyer les résultats obtenus.
 *
 */

public class AccesBd {

	/**
	 * initialisation des variables contenant les informations permettant la connection
	 */
	private static String utilisateur="root";
	private static String motDePasse="Bruc3Wayn3023007";
	private static String pilote = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/bd_apprenants?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static Connection connection = null;

	
	static {

		try { // detecte l'erreur
			Class.forName(pilote);
			System.out.println("Vous avez le bon pilote.");

		} catch (ClassNotFoundException e) { // traite l'erreur
			e.printStackTrace();
			System.out.println("Vous n'avez pas le bon pilote.");

		} 
		
	}
	
	/**
	 * Méthode permettant d'établir la connection
	 * @return connection de type Connection
	 */
	
	public static Connection getConnection() {
		
		try {
			connection = DriverManager.getConnection(url, utilisateur, motDePasse);
			System.out.println("Votre connexion est etablie.");
		} catch (SQLException f) {
			f.printStackTrace();
			System.out.println("Votre connexion n'est pas etablie.");
		}
		
		return connection;
		
	}
	
	/**
	 * Méthode permettant d'executer une requete
	 * @param requete ( la requete en SQL )
	 * @return resultat de type ResultSet
	 */
	
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