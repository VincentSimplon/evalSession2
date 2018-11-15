package table;

/**
 * @author Christine
 * initialisation des variables de la TABLE activite
 * creation des constructeurs
 * creation des getter et des setter
 */

public class Activite {
	
	private int activiteId;
	private String numeroActivite;
	private String nomActivite;
	
	/**
	 * generation constructeur sans parametre
	 */
	public Activite() {
		
	}

	/**
	 * generation constructeur avec parametre
	 */
	public Activite(int activiteId, String numeroActivite, String nomActivite) {
		
		this.activiteId = activiteId;
		this.numeroActivite = numeroActivite;
		this.nomActivite = nomActivite;
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

	public String getNumeroActivite() {
		return numeroActivite;
	}

	public void setNumeroActivite(String numeroActivite) {
		this.numeroActivite = numeroActivite;
	}

	public String getNomActivite() {
		return nomActivite;
	}

	public void setNomActivite(String nomActivite) {
		this.nomActivite = nomActivite;
	}
	

	/**
	 * methode toString qui permet l'affichage des variables
	 */
	@Override
	public String toString() {
		return "la table Activite comprend : activiteId=" + activiteId + ", numeroActivite=" + numeroActivite + ", nomActivite="
				+ nomActivite ;
	}	
	

}
