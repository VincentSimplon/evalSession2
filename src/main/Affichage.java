package main;

import java.util.Scanner;

import java.sql.SQLException;

import methodesRequetes.Requetes;

public class Affichage {
	
	static Scanner saisie;
	
	public static void main(String[] args) throws SQLException {
		
		int choixUtilisateur;
		do {
		saisie = new Scanner(System.in);
		System.out.println("bla");
		
		
		
		System.out.println("==========================================================\n" + 
		"Bienvenue sur la base de données des apprenants Simplon 3.\n" + 
		"==========================================================\n" + 
		"Que souhaitez vous faire ?\n" + " \n" + 
		"1 - Afficher le nom et le prénom de tous les apprenants.\n" + 
		"2 - Afficher la liste des apprenants pour chaque région.\n" + 
		"3 - Afficher les acivités d'un apprenant spécifique.\n" + 
		"4 - Rechercher des apprenants qui effectuent une activité spécifique.\n" + 
		"5 - Quitter. \n" + 
		"Veuillez saisir votre choix : \n");
		
		choixUtilisateur = saisie.nextInt();
		
		switch (choixUtilisateur) {
		
		case 1 :
			Requetes.afficherNomEtPrenomTousLesApprenants();
			break;
			
		case 2 : 
			Requetes.listeApprenantsPourChaqueRegion();
			break;
			
		case 3 : 
			Requetes.rechercheApprenantAfficheActivite();
			break;
			
		case 4 : 
			Requetes.rechercheApprenantPratiqueActivite("");
			break;
			
		case 5 : 
			System.out.println("A bientôt");
			break;
			
		default :
			System.out.println("Veuillez saisir un choix entre 1 et 5.");
		}
		
		} while (choixUtilisateur != 5);
		
	}
}
