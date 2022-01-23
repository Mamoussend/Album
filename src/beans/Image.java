package beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Image {

	private String titre;
	private String description;
	private int hauteur;
	private int largeur;
	private String mots_clés; 
	private String chemin;
	private String date_de_création;
	private  String date_de_mise_à_jour;
	private int idalbum;
	

	public int getIdalbum() {
		return idalbum;
	}
	public void setIdalbum(int idalbum) {
		this.idalbum = idalbum;
	}
	public Image(String titre, String description, int hauteur, int largeur, String mots_clés,String chemin,int idalbum) {

		this.titre = titre;
		this.description = description;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.mots_clés = mots_clés;
		this.chemin=chemin;
	   this.idalbum=idalbum;
	   LocalDate today = LocalDate.now();
	   
	   this.date_de_création = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
	
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public Image(String titre,String description, int hauteur, int largeur, String mots_clés,
			String date_de_création,String chemin,int idalbum) {
		this.titre = titre;
		this.description = description;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.mots_clés = mots_clés;
		this.date_de_création = date_de_création;
		this.chemin=chemin;
		this.idalbum=idalbum;
		LocalDate today = LocalDate.now();		 
		this.date_de_mise_à_jour = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
	}
	public Image(String titre,String description, int hauteur, int largeur, String mots_clés,
			String date_de_création,String chemin,int idalbum,String date_mise_a_jour) {
		this.titre = titre;
		this.description = description;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.mots_clés = mots_clés;
		this.date_de_création = date_de_création;
		this.chemin=chemin;
		this.idalbum=idalbum;
		 
		this.date_de_mise_à_jour = date_mise_a_jour;
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
	public String getMots_clés() {
		return mots_clés;
	}
	public void setMots_clés(String mots_clés) {
		this.mots_clés = mots_clés;
	}
	public String getDate_de_création() {
		return date_de_création;
	}
	public void setDate_de_création(String date_de_création) {
		this.date_de_création = date_de_création;
	}
	public String getDate_de_mise_à_jour() {
		return date_de_mise_à_jour;
	}
	public void setDate_de_mise_à_jour(String date_de_mise_à_jour) {
		this.date_de_mise_à_jour = date_de_mise_à_jour;
	}
}
