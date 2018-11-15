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
 *  Connection : Une connexion avec une base de donn�es sp�cifique. 
 *  Les instructions SQL sont ex�cut�es et les r�sultats sont renvoy�s dans le contexte d'une connexion.
 *  un objet Connection est capable de fournir des informations d�crivant ses tables
 *   
 *  DriverManager : permet de chercher le pilote de connection
 *  
 *  ResultSet : s'utilise lors d'une instruction qui interroge la base de donn�es.
 *  Un ResultSetobjet maintient un curseur pointant sur sa ligne de donn�es actuelle.  
 *  La nextm�thode d�place le curseur sur la ligne suivante et, comme elle est renvoy�e false 
 *  lorsqu'il n'y a plus de lignes dans l' ResultSetobjet, elle peut �tre utilis�e dans une whileboucle 
 *  pour parcourir le jeu de r�sultats.
 *  
 *  SQLExecption : fournit des informations sur une erreur d'acc�s � la base de donn�es ou d'autres erreurs.
 *  printStackTrace : affiche l'exception et l'�tat d'ex�cution au moment de son appel
 *  
 *  Statement : Objet utilis� pour ex�cuter une instruction SQL statique et renvoyer les r�sultats obtenus.
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
	 * M�thode permettant d'�tablir la connection
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
	 * M�thode permettant d'executer une requete
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