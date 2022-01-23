package beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Image {

	private String titre;
	private String description;
	private int hauteur;
	private int largeur;
	private String mots_cl�s; 
	private String chemin;
	private String date_de_cr�ation;
	private  String date_de_mise_�_jour;
	private int idalbum;
	

	public int getIdalbum() {
		return idalbum;
	}
	public void setIdalbum(int idalbum) {
		this.idalbum = idalbum;
	}
	public Image(String titre, String description, int hauteur, int largeur, String mots_cl�s,String chemin,int idalbum) {

		this.titre = titre;
		this.description = description;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.mots_cl�s = mots_cl�s;
		this.chemin=chemin;
	   this.idalbum=idalbum;
	   LocalDate today = LocalDate.now();
	   
	   this.date_de_cr�ation = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
	
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public Image(String titre,String description, int hauteur, int largeur, String mots_cl�s,
			String date_de_cr�ation,String chemin,int idalbum) {
		this.titre = titre;
		this.description = description;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.mots_cl�s = mots_cl�s;
		this.date_de_cr�ation = date_de_cr�ation;
		this.chemin=chemin;
		this.idalbum=idalbum;
		LocalDate today = LocalDate.now();		 
		this.date_de_mise_�_jour = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
	}
	public Image(String titre,String description, int hauteur, int largeur, String mots_cl�s,
			String date_de_cr�ation,String chemin,int idalbum,String date_mise_a_jour) {
		this.titre = titre;
		this.description = description;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.mots_cl�s = mots_cl�s;
		this.date_de_cr�ation = date_de_cr�ation;
		this.chemin=chemin;
		this.idalbum=idalbum;
		 
		this.date_de_mise_�_jour = date_mise_a_jour;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public String getMots_cl�s() {
		return mots_cl�s;
	}
	public void setMots_cl�s(String mots_cl�s) {
		this.mots_cl�s = mots_cl�s;
	}
	public String getDate_de_cr�ation() {
		return date_de_cr�ation;
	}
	public void setDate_de_cr�ation(String date_de_cr�ation) {
		this.date_de_cr�ation = date_de_cr�ation;
	}
	public String getDate_de_mise_�_jour() {
		return date_de_mise_�_jour;
	}
	public void setDate_de_mise_�_jour(String date_de_mise_�_jour) {
		this.date_de_mise_�_jour = date_de_mise_�_jour;
	}
}
