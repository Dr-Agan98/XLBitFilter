package xlbit.filter;

public class ProjectEnums{

	//FILTRI
	public enum EnumFilters {

		STD1,
		STD2,
		STD3,
		STD4_5,
		STD6

	}

	//CATEGORIE
	public enum Categoria {
		//manca la categoria "admin" (usata per il campo note) perché non va ciclata assieme alle altre
		//le categorie non hanno la voce "text" perché aggiunta da html
		gest("Utilizzate un software gestionale (PMS)?"
				,"Benutzen Sie eine Verwaltungssoftware (PMS)?"
				,"quadro camere/app.ti, gestione ospiti, supplementi, contabilità, ecc."
				,"Zimmer-Wohnungsplan, Kundenverwaltung, Zuschläge, Verwaltung, usw."
				,new Voce[] {Voce.no,Voce.asa,Voce.phoenix,Voce.xenus,Voce.opera,Voce.hotel2k,Voce.ericsoft,Voce.altro})
		,chann("Utilizzate un channel manager?"
				,"Benutzen Sie einen Channel Manager?"
				,"collegamento tra gestionale e portali di distribuzione/prenotazione"
				,"Verknüpfung zwischem der Verwaltugssoftware und den Buchungsportalen"
				,new Voce[] {Voce.no,Voce.tic,Voce.vertical,Voce.bookexp,Voce.seekda,Voce.easychan,Voce.ericsoft,Voce.altro})
		,siti("Vendete camere o appartamenti attraverso portali di prenotazioni (OTA)?"
				,"Vermieten Sie Zimmer oder Ferienwohnungen über Online-Hotelbuchungsplattformen? (OTA)"
				,"prenotazioni con pagamenti online"
				,"Buchungen mit Online-Zahlungen"
				,new Voce[] {Voce.no,Voce.booking,Voce.venere,Voce.expedia,Voce.altro})
		,engi("Utilizzate un software per prenotazioni dirette dal vostro sito (Booking Engine)?"
				,"Benutzen Sie eine Software für direkte Buchungen durch Ihre Webseite?"
				,""
				,""
				,new Voce[] {Voce.no,Voce.bookexp,Voce.sudtirol,Voce.altro})
		,rich("Utilizzate un software per la gestione delle richieste e per l'invio automatico delle offerte?"
				,"Benutzen Sie eine Software für die automatische Verwaltung von Anfragen und Angeboten?"
				,""
				,""
				,new Voce[] {Voce.no,Voce.easy,Voce.gest,Voce.altro})
		,rm("Chi si occupa di revenue management?"
				,"Wer kümmert sich um das Revenue Management?"
				,""
				,""
				,new Voce[] {Voce.nessuno,Voce.interno,Voce.esterno,Voce.azienda});

		private Voce[] voci;

		Categoria(String titolo_it,String titolo_de,String sottotitolo_it,String sottotitolo_de,Voce[] voci) {
			this.voci=voci;
		}


		public Voce[] getVoci() {
			return voci;
		}
	}

	//VOCE
	public enum Voce {
		//ai fini di html e javascript, è necessario che le voci che escludono le successive abbiano id="nessuno"
		//mentre le voci che richiedono di specificare dei dati nel campo di testo libero abbiano id="altro"
		nessuno("nessuno"
				,"nessuno"
				,"Niemand")
		,no("nessuno"
				,"no"
				,"Nein")
		,altro("altro"			//non salvata nel DB! viene calcolata con JS in base al valore di "text"
				,"altro (specificare)"
				,"Sonstiges (bitte angeben)")
		,text("text"	//non ha label, serve solo come id per html
				,""
				,"")

		//*** GESTIONALI ***

		,asa("asa"
				,"ASA Hotel"
				,"ASA Hotel")
		,phoenix("phoenix"
				,"phoenix hotelsoftware"
				,"phoenix hotelsoftware")
		,xenus("xenus"
				,"xenus hotelsoftware"
				,"xenus hotelsoftware")
		,opera("opera"
				,"OPERA PMS"
				,"OPERA PMS")
		,hotel2k("hotel2k"
				,"Hotel 2000"
				,"Hotel 2000")
		,ericsoft("ericsoft"
				,"Ericsoft"
				,"Ericsoft")

		//*** CHANNEL MANAGERS ***

		,tic("tic"
				,"TIC-Web"
				,"TIC-Web")
		,vertical("vertical"
				,"Vertical Booking"
				,"Vertical Booking")
		,bookexp("bookexp"
				,"Booking Expert"
				,"Booking Expert")
		,seekda("seekda"
				,"Seekda"
				,"Seekda")
		,easychan("easychan"
				,"Easy Channel"
				,"Easy Channel")

		//*** PORTALI OTA ***

		,booking("booking"
				,"Booking.com"
				,"Booking.com")
		,venere("venere"
				,"Venere.com"
				,"Venere.com")
		,expedia("expedia"
				,"Expedia.com"
				,"Expedia.com")

		//*** SOFTWARE PRENOTAZIONI ***

		,sudtirol("sudtirol"
				,"Booking Südtirol"
				,"Booking Südtirol")

		//*** SOFTWARE RICHIESTE ***

		,easy("easy"
				,"EasyMailer"
				,"EasyMailer")
		,gest("gest"
				,"il software gestionale"
				,"die Verwaltungssoftware (PMS)")

		//*** REVENUE MANAGEMENT ***

		,interno("interno"
				,"personale dell'hotel"
				,"Hotelpersonal")
		,esterno("esterno"
				,"consulente esterno"
				,"Externer Berater")
		,azienda("altro"
				,"azienda esterna (specificare)"
				,"Externe Firma (Namen angeben)")
		;

		private String id;

		Voce(String id,String label_it,String label_de) {
			this.id=id;
		}

		public String getId() {
			return id;
		}
	}

}
