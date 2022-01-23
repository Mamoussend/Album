package beans;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String mail;
	private String password;
	private String date_naiss;
	private String type;
	private int id;

	public int getId() {
		return id;
	}

	public Utilisateur() {
	 
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nom, String prenom, String mail, String password, String date_naiss, String type) {

		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.date_naiss = date_naiss;
		this.type = type;
	}

	public Utilisateur(String nom, String prenom, String mail, String password, String date_naiss, String type,int id) {

		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.date_naiss = date_naiss;
		this.type = type;
		this.id=id;
	}
	public Utilisateur(String nom, String prenom,int id, String type) {

		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
		this.type = type;
	}
	public Utilisateur(String nom, String prenom, String mail, String password, String date_naiss) {
	
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.date_naiss = date_naiss;
		this.type = "utilisateur";
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
