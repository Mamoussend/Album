package beans;

public class Album {
	
	private String nom;
	private String type;
	private String theme;
	private int idproprietaire;
	public String getNom() {
		return nom;
	}
	public Album(String nom, String type, String theme, int idproprietaire) {
		this.nom = nom;
		this.type = type;
		this.theme = theme;
		this.idproprietaire = idproprietaire;
	}
	public Album() {

	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getIdproprietaire() {
		return idproprietaire;
	}
	public void setIdproprietaire(int idproprietaire) {
		this.idproprietaire = idproprietaire;
	}
	

}
