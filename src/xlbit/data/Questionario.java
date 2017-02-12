package xlbit.data;

import java.util.*;
import java.sql.Timestamp;

public class Questionario {

	private int nUtente;
	private int admin;
	private Timestamp updated;
	private Map<String, String> risposte;

	public Questionario(int nUtente) {
		this.nUtente = nUtente;
		this.admin = 0;
		this.risposte = new HashMap<>();
		this.updated = null;
	}

	public void addQuestionario(int admin,String categoria,String idVoce,String value,Timestamp updated) {
		this.admin = admin;
		this.updated = updated;
		risposte.put(categoria+"_"+idVoce.toLowerCase(), value.toLowerCase());
	}

	/*--------GETTERS---------*/
	public int getnUtente() {return nUtente;}
	public int getAdmin() {	return admin;}
	public Timestamp getUpdated() {return updated;}
	public Map<String, String> getRisposte() {return risposte;}

	/*--------SETTERS---------*/
	public void setnUtente(int nUtente) {this.nUtente = nUtente;}
	public void setAdmin(int admin) {this.admin = admin;}
	public void setUpdated(Timestamp updated) {this.updated = updated;}
	public void setRisposte(Map<String,String> risposte){this.risposte = risposte;}

}
