package methodesRequetes;

/**
 * import ClassNotFoundException :  tente de charger une classe via son nom de cha�ne 
 * mais aucune d�finition de la classe avec le nom sp�cifi� n'a pu �tre trouv�e.
 * import SQLException : fournit des informations sur une erreur d'acc�s � la base de donn�es.
 * 
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.AccesBD;
import table.Apprenant;

public class Requetes {
	
	/**
	 * M�thode qui retourne une liste d'objets de type Apprenant
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
