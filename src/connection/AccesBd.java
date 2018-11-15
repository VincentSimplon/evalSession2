package connection;

/**
 * @author Vincent
 * classe permettant la connection � la base de donn�es
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Connection : Une connexion avec une base de donnees specifique. 
 *  Les instructions SQL sont executees et les resultats sont renvoyes dans le contexte d'une connexion.
 *  un objet Connection est capable de fournir des informations decrivant ses tables
 *   
 *  DriverManager : permet de chercher le pilote de connection
 *  
 *  ResultSet : s'utilise lors d'une instruction qui interroge la base de donnees.
 *  Un ResultSetobjet maintient un curseur pointant sur sa ligne de donnees actuelle.  
 *  La next methode deplace le curseur sur la ligne suivante, comme elle renvoye false 
 *  lorsqu'il n'y a plus de lignes, elle peut etre utilisee dans une whileboucle 
 *  pour parcourir le jeu de resultats.
 *  
 *  SQLExecption : fournit des informations sur une erreur d'acces a la base de donnees ou d'autres erreurs.
 *  printStackTrace : affiche l'exception et l'etat d'execution au moment de son appel
 *  
 *  Statement : Objet utilise pour executer une instruction SQL statique et renvoyer les resultats obtenus.
 *
 */

public class AccesBd {

	/**
	 * initialisation des variables contenant les informations permettant la connection
	 */
	private static String utilisateur="root";
	private static String motDePasse="Bruc3Wayn3023007";
	private static String pilote = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/bd_apprenants?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
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
	 * Methode permettant d'etablir la connection
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
	 * Methode permettant d'executer une requete
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