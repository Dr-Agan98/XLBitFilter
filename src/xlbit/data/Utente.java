package xlbit.data;

public class Utente {

	private int chiave;
	private int account;
	private String sito;
	private int utilizzo;
	private String nomeHotel;
	private String tipoStruttura;
	private String tipoOp;
	private int livello;
	private Questionario questionario=null;

	public Utente(int chiave, int account, String sito, int utilizzo, String nomeHotel, String tipoStruttura, String tipoOp, int livello) {

		this.chiave = chiave;
		this.account = account;
		this.sito = sito;
		this.utilizzo = utilizzo;
		this.nomeHotel = nomeHotel;
		this.tipoStruttura=tipoStruttura;
		this.tipoOp=tipoOp;
		this.livello = livello;
		questionario=new Questionario(chiave);
	}

	/*--------GETTERS---------*/
	public int getChiave() {return chiave;}	
	public int getAccount() {return account;}	
	public String getSito() {	return sito;}	
	public int getUtilizzo() {	return utilizzo;}	
	public String getNomeHotel() {	return nomeHotel;}	
	public String getTipoStruttura() {	return tipoStruttura;}
	public String getTipoOp() {return tipoOp;}
	public int getLivello() {return livello;}	
	public Questionario getQuestionario() {return questionario;}

	/*--------SETTERS---------*/
	public void setChiave(int chiave) {	this.chiave = chiave;}
	public void setAccount(int account) {this.account = account;}
	public void setSito(String sito) {	this.sito = sito;}
	public void setUtilizzo(int utilizzo) {	this.utilizzo = utilizzo;}
	public void setNomeHotel(String nomeHotel) {this.nomeHotel = nomeHotel;}
	public void setTipoStruttura(String tipoStruttura) {	this.tipoStruttura = tipoStruttura;}
	public void setTipoOp(String tipoOp) {this.tipoOp = tipoOp;}
	public void setLivello(int livello) {this.livello = livello;}

}

