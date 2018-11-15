package table;

/**
 * @author Christine
 * initialisation des variables de la TABLE apprenant
 * creation des constructeurs
 * creation des getter et des setter
 */

public class Apprenant {
	
		private int apprenantId;
		private String nom;
		private String prenom;
		private String dateNaissance;
		private String mail;
		private String photo;
		private int regionId;
		
		
		/**
		 * generation constructeur sans parametre
		 */
		public Apprenant() {
			
		}		

		/**
		 * generation constructeur avec parametre
		 */
		public Apprenant(String nom, String prenom, String dateNaissance, String mail, String photo,
				int regionId) {
			
			this.nom = nom;
			this.prenom = prenom;
			this.dateNaissance = dateNaissance;
			this.mail = mail;
			this.photo = photo;
			this.regionId = regionId;
		}
		

		/**
		 * generation des getter et des setter
		 */
		public int getApprenantId() {
			return apprenantId;
		}

		public void setApprenantId(int apprenantId) {
			this.apprenantId = apprenantId;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getDateNaissance() {
			return dateNaissance;
		}

		public void setDateNaissance(String dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public int getRegionId() {
			return regionId;
		}

		public void setRegionId(int regionId) {
			this.regionId = regionId;
		}

		/**
		 * methode toString qui permet l'affichage des variables
		 */
		@Override
		public String toString() {
			return "la Table Apprenant comprend : apprenantId=" + apprenantId + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
					+ dateNaissance + ", mail=" + mail + ", photo=" + photo + ", regionId=" + regionId;
		}	
		
		

}



