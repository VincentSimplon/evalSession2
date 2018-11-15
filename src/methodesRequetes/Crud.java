package methodesRequetes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.AccesBd;
import table.Apprenant;
import table.Avoir;

public class Crud {

	public static void createNewApprenant(Apprenant apprenant) throws SQLException {
		
		PreparedStatement changement = AccesBd.getConnection().prepareStatement("INSERT INTO `apprenant` VALUES( ? , ? , ? , ? , ? , ? , ? )");
	
		changement.setInt(1,apprenant.getApprenantId());
		changement.setString(2,apprenant.getNom());
		changement.setString(3,apprenant.getPrenom());
		changement.setDate(4, apprenant.getDateNaissance());
		changement.setString(5, apprenant.getMail());
		changement.setString(6, apprenant.getPhoto());
		changement.setInt(7, apprenant.getRegionId());
		
		changement.executeUpdate();
		
	}
	
	public static void newActiviteNewApprenant(Avoir avoir) throws SQLException {
		
		PreparedStatement ajouter = AccesBd.getConnection().prepareStatement("INSERT INTO `avoir` VALUES( ? , ? )");
		
	}
	
	public static void activiteNotUse() throws SQLException {
		
		ResultSet resultat = AccesBd.faireUneRequete("SELECT activite.typeActivite FROM activite WHERE activite.activiteId NOT IN (SELECT avoir.activiteId FROM avoir");
		
		while(resultat.next()) {
			String nomactivite = resultat.getString("typeActivite");
			
			System.out.println(nomactivite + " n'est pas utilisé.");
		}
		
	}
	
	public static void updateName() {
		
	}
	
	public static void deleteApprenant() {
		
	}

}
