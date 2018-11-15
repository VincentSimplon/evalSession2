package methodesRequetes;

/**
 * import ClassNotFoundException :  tente de charger une classe via son nom de chaîne 
 * mais aucune définition de la classe avec le nom spécifié n'a pu être trouvée.
 * import SQLException : fournit des informations sur une erreur d'accès à la base de données.
 * 
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.AccesBD;
import table.Apprenant;

public class Requetes {
	
	/**
	 * Méthode qui retourne une liste d'objets de type Apprenant
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public static ArrayList<Apprenant> afficherNomEtPrenomApprenant() throws ClassNotFoundException, SQLException {
		
		ArrayList<Apprenant>  etudiants = new ArrayList<Apprenant>();
		String requete	= "SELECT nom, prenom FROM apprenant";
		ResultSet resultat = AccesBD.executeRequete(requete);
		
		while(resultat.next())
		{
			Apprenant eleve = new Apprenant();
			eleve.setNom(resultat.getString("nom"));
			eleve.setPrenom(resultat.getString("prenom"));
			etudiants.add(eleve);
			
		}
		return etudiants;
		
	}
	
	public static String listeApprenantRegion (int regionId) {
		return null;
	}
	
	public static String activiteApprenant (String nom) {
		return null;
	}
	
	public static String apprenantActivite (int activiteId) {
		return null;
	}

}
