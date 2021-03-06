package methodesRequetes;

/**
 * @author Christine
 * 
 * PreparedStatement : Une instruction SQL est precompilee et stockee dans un PreparedStatementobjet. 
 * Cet objet peut ensuite etre utilise pour executer efficacement cette instruction plusieurs fois.
 * 
 * executeUpdate : Execute l'instruction SQL fournie, qui peut etre une instruction 
 * INSERT, UPDATE ou DELETE ; ou une instruction SQL qui ne retourne rien.
 * 
 */
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import connection.AccesBd;
import table.Apprenant;
import table.Avoir;

public class Crud {
	
	static Scanner saisie = new Scanner(System.in);
	
	
/**
 * Methode qui creer un nouvel apprenant dans la table apprenant
 * @param apprenant
 * @throws SQLException
 */
	public static void createNewApprenant(Apprenant apprenant) throws SQLException {
		
		PreparedStatement changement = AccesBd.getConnection().prepareStatement("INSERT INTO `apprenant` VALUES( ? , ? , ? , ? , ? , ? , ? )");
	
		changement.setInt(1,apprenant.getApprenantId());
		changement.setString(2,apprenant.getNom());
		changement.setString(3,apprenant.getPrenom());
		changement.setString(4, apprenant.getDateNaissance());
		changement.setString(5, apprenant.getMail());
		changement.setString(6, apprenant.getPhoto());
		changement.setInt(7, apprenant.getRegionId());
		
		changement.executeUpdate();
		
	}
	
	
/**
* Methode qui ajoute une nouvelle activite a un apprenant
* @param avoir
* @throws SQLException
*/	
	public static void newActiviteNewApprenant(Avoir avoir) throws SQLException {
		
		PreparedStatement ajouter = AccesBd.getConnection().prepareStatement("INSERT INTO `avoir` VALUES( ? , ? )");
		
		ajouter.setInt(1, avoir.getActiviteId());
		ajouter.setInt(2, avoir.getApprenantId());
		
		ajouter.executeUpdate();
		
	}
	
	
/**
* Methode qui affiche les activite non utilise par les apprenants
* @throws SQLException
*/	
	public static void activiteNotUse() throws SQLException {
		
		ResultSet resultat = AccesBd.faireUneRequete("SELECT activite.nomActivite FROM activite WHERE activite.activiteId NOT IN (SELECT avoir.activiteId FROM avoir)");
		
		while(resultat.next()) {
			String nomactivite = resultat.getString("nomActivite");
			
			System.out.println(nomactivite + " n'est pas utilise.");
		}
		
	}
	
	
/**
* Methode qui change le nom d'un apprenant
* @throws SQLException
*/	
	public static void updateName() throws SQLException {
		
		System.out.println("Entrez le nouveau nom d'un apprenant pour le modifier : ");
		String newName = saisie.nextLine();
		System.out.println("Entrez le numero de l'apprenant que vous voulez modifier : ");
		int numero = saisie.nextInt();
		
		PreparedStatement ajouter = AccesBd.getConnection().prepareStatement("UPDATE apprenant SET nom = ? WHERE apprenantId = ?");
		
				
		ajouter.setInt(2, numero);
		ajouter.setString(1, newName);
		
		ajouter.executeUpdate();
		
	}
	
	
	/**
	 * Methode qui supprime un apprenant de la class apprenant
	 * @throws SQLException
	 */
	public static void deleteApprenant() throws SQLException {
		
		System.out.println("Entrez le num�ro de l'apprenant que vous voulez supprimer : ");
		int numero = saisie.nextInt();
		
		PreparedStatement supprimer = AccesBd.getConnection().prepareStatement("DELETE FROM apprenant WHERE apprenantId = ?");
		
		supprimer.setInt(1, numero);
		
		supprimer.executeUpdate();
				
	}

}
