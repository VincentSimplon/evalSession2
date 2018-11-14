package connection;
/**	=====================================================
 * @author Vincent.Co
 *	Package : connection
 *
 * Connexion à la base de données bd_apprenants.
========================================================
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesBD {
	
	/** 
	 * Initialisation des paramètres de connexion pour se connecter à la base de données.
	 */


	private static String utilisateur="root";
	private static String motDePasse="Bruc3Wayn3023007";
	private static String pilote = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/bd_apprenants?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	/**
	 * Création de la méthode connexion pour se connecter à la base de données bd_apprenants.
	 * Class.forName(url de la BD) permet de charger le pilote.
	 * Pour initialiser la connexion, il faut créer un objet de type Connection (import connection)qui utilise la méthode getConnection de la classe driveManager pour se connecter.
	 * Et bien sûr nous gérons les exeptions et on affiche un message en fonction de la réussite ou non de la connexion.
	 */
	
	public static void connexion() {

		try
		{
			// 1 - Charger le pilote.
			Class.forName(pilote);

			// 2 - Initialiser la connexion.
			Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
			System.out.println("La connexion est établie.");

		} catch(SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("La tentative de connexion a echouée.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("La tentative de connexion a echouée.");
		}
	}
}
