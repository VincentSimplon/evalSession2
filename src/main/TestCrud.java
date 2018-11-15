package main;
import java.sql.Date;


import java.sql.SQLException;

import methodesRequetes.Crud;
import table.Apprenant;

public class TestCrud {
	
	public static void main(String[] args) throws SQLException {
		
		Apprenant Bruce = new Apprenant("Wayne", "Vincent", null, "batman@gotham.fr", " ", 1);
		Crud.createNewApprenant(Bruce);
		
		Crud.activiteNotUse();
		
	}

}
