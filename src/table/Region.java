package table;

/**
 * @author Vincent.Co
 * initialisation des variables de la TABLE region
 * cr�ation des constructeurs
 * cr�ation des getter et des setter
 */

public class Region {
	
	private int regionId;
	private String nom;
	
	public Region() {
		
	}
	
	public Region(int regionId, String nom) {
		
		this.regionId = regionId;
		this.nom = nom;
	}
	
	public int getRegionId() {
		return regionId;
	}
	
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "La table Region contient : regionId=" + regionId + ", nom=" + nom;
	}

	
}
