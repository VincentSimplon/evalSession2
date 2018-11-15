package main;



import java.sql.SQLException;

import methodesRequetes.Requetes;

public class Affichage {
	
	public static void main(String[] args) throws SQLException {
		
		Requetes.afficherNomEtPrenomTousLesApprenants();
		Requetes.listeApprenantsPourChaqueRegion();
		Requetes.rechercheApprenantAfficheActivite();
		Requetes.rechercheApprenantPratiqueActivite("005");
		
		
	}
}
