package methodesRequetes;

/**
 * @author Christine
 * creation des objets correspondant aux différentes Table
 * import de la bibliotheque ResultSet
 * import de la bibliotheque SQLException
 */
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * import les classes du package table
 */
import table.Activite;
import table.Apprenant;

public class Mapping {
	
	/**
	 * Méthode pour instancier un objet Activite
	 * @param resultat
	 * @return objet travail
	 * @throws SQLException
	 */
	
	public static Activite mappingActivite(ResultSet resultat) throws SQLException {
		
		Activite travail = new Activite();
		travail.setActiviteId(resultat.getInt("activiteId"));
		travail.setNumeroActivite(resultat.getString("numeroActivite"));
		travail.setNomActivite(resultat.getString("nomActivite"));
				
		return travail;
	
	}
	
	/**
	 * Méthode pour instancier un objet Apprenant
	 * @param resultat
	 * @return objet etudiant
	 * @throws SQLException
	 */
	
	public static Apprenant mappingApprenant(ResultSet resultat) throws SQLException {
		
		Apprenant etudiant = new Apprenant();
		etudiant.setApprenantId(resultat.getInt("apprenantId"));
		etudiant.setNom(resultat.getString("nom"));
		etudiant.setPrenom(resultat.getString("prenom"));
		etudiant.setDateNaissance(resultat.getDate("dateNaissance"));	
		etudiant.setMail(resultat.getString("mail"));
		etudiant.setPhoto(resultat.getString("photo"));
		
		return etudiant;
	
	}
	
	

	
	
	
}
