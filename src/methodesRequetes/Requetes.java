package methodesRequetes;

/**
 * @author Vincent
 * Methode demander pour le projet de la Session2
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import connection.AccesBd;
import table.Activite;
import table.Apprenant;

public class Requetes {

	static Scanner saisie;
	
	
/**
 * Methode qui retourne la liste des noms et prenoms de tous les apprenants
 * @throws SQLException
 */
	public static void afficherNomEtPrenomTousLesApprenants() throws SQLException {

		ResultSet resultat = AccesBd.faireUneRequete("SELECT apprenantId, nom, prenom FROM apprenant");

		System.out.println("===================================");

		while(resultat.next()) {
			int colonne1 = resultat.getInt("apprenantId");
			String colonne2 = resultat.getString("nom");
			String colonne3 = resultat.getString("prenom");
			System.out.println("-" + colonne1 + " " + colonne2 + " " + colonne3);

		}

		System.out.println("===================================");
	}
	
	
	
/**
 * Methode qui affiche tous les apprenants pour une meme region
 * @throws SQLException
 */
	public static void listeApprenantsPourChaqueRegion() throws SQLException {

		saisie = new Scanner(System.in);
		System.out.println("Pour quelle région souhaitez vous avoir la liste des apprenants ?");
		String region = saisie.nextLine();

		PreparedStatement prepaInstru = AccesBd.getConnection().prepareStatement("SELECT apprenant.nom, apprenant.prenom, region.nom FROM apprenant, region WHERE apprenant.regionId = region.regionId AND region.nom = ?");
		prepaInstru.setString(1, region);
		ResultSet resultat = prepaInstru.executeQuery();

		System.out.println("===================================");

		while(resultat.next()) {

			String colonne1 = resultat.getString("apprenant.nom");
			String colonne2 = resultat.getString("apprenant.prenom");
			String colonne3 = resultat.getString("region.nom");
			System.out.println(colonne1 + " " + colonne2 + " : " + colonne3);

		}

		System.out.println("===================================");
	}
	
	
/**
 * Methode qui affiche les activites d'un apprenant avec son nom
 * @throws SQLException
 */
	public static void rechercheApprenantAfficheActivite() throws SQLException {

		saisie = new Scanner(System.in);
		System.out.println("Entrez le nom d'un apprenant pour afficher ses activités : ");
		String apprenant = saisie.nextLine();

		PreparedStatement prepaInstru = AccesBd.getConnection().prepareStatement("SELECT avoir.activiteId, activite.nomActivite, apprenant.nom FROM avoir, activite, apprenant WHERE activite.activiteId = avoir.activiteId AND apprenant.apprenantID = avoir.apprenantId AND apprenant.nom = ?");
		prepaInstru.setString(1, apprenant);
		ResultSet resultat = prepaInstru.executeQuery();

		System.out.println("===================================");

		while(resultat.next()) {

			String colonne1 = resultat.getString("avoir.activiteId");
			String colonne2 = resultat.getString("activite.nomActivite");
			String colonne3 = resultat.getString("apprenant.nom");
			System.out.println(colonne1 + " " + colonne2 + " " + colonne3);
		}

		System.out.println("===================================");

	}
	

/**
 * Methode qui affiche les apprenants en fonction d'une activite
 * @param activite
 * @throws SQLException
 */

	public static void rechercheApprenantPratiqueActivite(String activite) throws SQLException {

		saisie = new Scanner(System.in);
		System.out.println("Pour quelle activité souhaitez vous afficher les apprenants ?");
		activite = saisie.nextLine();

		PreparedStatement prepaInstru = AccesBd.getConnection().prepareStatement("SELECT apprenant.nom, activite.nomActivite FROM avoir, activite, apprenant WHERE activite.activiteId = avoir.activiteId AND apprenant.apprenantID = avoir.apprenantId AND activite.numeroActivite = ?");
		prepaInstru.setString(1, activite);
		ResultSet resultat = prepaInstru.executeQuery();

		System.out.println("===================================");

		while(resultat.next()) {

			String colonne1 = resultat.getString("apprenant.nom");
			String colonne2 = resultat.getString("activite.nomActivite");
			System.out.println(colonne1 + " " + colonne2);
		}

		System.out.println("===================================");

	}
}


