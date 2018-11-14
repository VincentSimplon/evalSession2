package table;

/**
 * @author Christine
 * initialisation des variables de la TABLE avoir
 * création des constructeurs
 * création des getter et des setter
 */

public class Avoir {

	private int activiteId;
	private int apprenantId;
	
	
	/**
	 * generation constructeur sans parametre
	 */
	public Avoir() {
		
	}

	/**
	 * generation constructeur avec parametre
	 */
	public Avoir(int activiteId, int apprenantId) {
		
		this.activiteId = activiteId;
		this.apprenantId = apprenantId;
	}

	/**
	 * generation des getter et des setter
	 */
	public int getActiviteId() {
		return activiteId;
	}
	
	public void setActiviteId(int activiteId) {
		this.activiteId = activiteId;
	}
	
	public int getApprenantId() {
		return apprenantId;
	}
	
	public void setApprenantId(int apprenantId) {
		this.apprenantId = apprenantId;
	}

	/**
	 * methode toString qui permet l'affichage des variables
	 */
	@Override
	public String toString() {
		return "La Table Avoir comprend : activiteId= " + activiteId + ", apprenantId= " + apprenantId;
	}	

}
