package main;

/**
 * @author Vincent et christine
 * class qui permet l'affichage des differentes methodes du CRUD
 */

import java.sql.SQLException;

import methodesRequetes.Crud;
import table.Apprenant;

public class TestCrud {
	
	
	
	public static void main(String[] args) throws SQLException {
		
		Crud.deleteApprenant();
		
		//Crud.updateName();
		
		//Avoir ajoutActivite = new Avoir(8, 17);
		//Crud.newActiviteNewApprenant(ajoutActivite);
		
		//Crud.deleteApprenant();
		
		//Apprenant Bruce = new Apprenant("Wayne", "Vincent", null, "batman@gotham.fr", " ", 1);
		//Crud.createNewApprenant(Bruce);
		
		//Crud.activiteNotUse();
		
	}

}
