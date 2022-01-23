package form;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class UserForm {
	private  static String Champ_Nom;
	private  static String Champ_Prenom;
	private  static String Champ_Email;
	private  static String Champ_Password;
	private  static String Champ_Password_Bis;
	private  static String Champ_DateNais;


	private Utilisateur user;
	private Map<String, String> erreurs;
	private HttpServletRequest request;
	private String statusmessage;
	private boolean status;

	public UserForm(HttpServletRequest request) {
      	this.status=false;
	    this.request=request;
	    erreurs=new HashMap<String, String>();
	}

	private void ValiderChamps(String...CHAMPS) {
		for(String champs:CHAMPS) {
			if(champs==null) {
				erreurs.put(champs, "Vous devez remplir ce champs!");
				System.out.println("Statuserreurs: "+erreurs);
			}
		}
	}
	private void validerPassword() {
		String password=request.getParameter(Champ_Password);
		String password_bis=request.getParameter(Champ_Password_Bis);
		if(password!=null && !password.equals(password_bis)) {
			erreurs.put(password, "Les deux mots de passes ne sont pas identiques!");
			erreurs.put(password_bis, "Les deux mots de passes ne sont pas identiques");
			System.out.println("Statuserreurs: "+erreurs);
		}
	}
/*	private void validerMail() {
		String regex="^(.+)@(.+)$";
		Pattern pat=Pattern.compile(regex);
		
		String mail=request.getParameter(Champ_Email);
		Matcher match=pat.matcher(mail);
		if(mail!=null & !match.matches()) {
			erreurs.put(mail,"Veuillez saissir un email valide!");
		}
	}*/
	public static String getChamp_Nom() {
		return Champ_Nom;
	}

	public static String getChamp_Prenom() {
		return Champ_Prenom;
	}

	public static String getChamp_Email() {
		return Champ_Email;
	}

	public static String getChamp_Password() {
		return Champ_Password;
	}

	public static String getChamp_Password_Bis() {
		return Champ_Password_Bis;
	}

	public static String getChamp_DateNais() {
		return Champ_DateNais;
	}

	public Utilisateur getUser() {
		return user;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public String getStatusmessage() {
		return statusmessage;
	}

	public boolean isStatus() {
		return status;
	}

	public boolean ajouter() {
		String nom=request.getParameter(Champ_Nom);
		System.out.println(nom);
		String prenom= request.getParameter(Champ_Prenom);
		System.out.println(prenom);
		String mail=request.getParameter(Champ_Email);
		System.out.println(mail);
		String password=request.getParameter(Champ_Password);
		String password_bis=request.getParameter(Champ_Password_Bis);
		String datnais=request.getParameter(Champ_DateNais);
		user=new Utilisateur(nom, prenom, mail, password, datnais);
		ValiderChamps(nom,prenom,mail,password,password_bis,datnais);
		validerPassword();
		statusmessage="Echec de l'enregistrement";
		if(erreurs.isEmpty()) {
			status=UtilisateurDao.addUser(user);
			if(status) {
				statusmessage="Enregistrement reussit";
			}
			
		}
		System.out.println("Statuserreurs: "+statusmessage);
		return status;
	}

}
