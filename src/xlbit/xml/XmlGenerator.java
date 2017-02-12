package xlbit.xml;

import xlbit.data.*;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.FileWriter;
import java.io.IOException;

public class XmlGenerator {

	private static DocumentBuilderFactory dFact;
	private static DocumentBuilder dBuild;
	private static Document doc;
	private static TransformerFactory tFact;
	private static Transformer trsf;
	private static DOMSource source;
	
	public static void writeXml(List<Utente> list) throws ParserConfigurationException, TransformerException{
		dFact = DocumentBuilderFactory.newInstance();
		dBuild = dFact.newDocumentBuilder();
		doc = dBuild.newDocument();
		
		Element root = doc.createElement("listaUtenti");
		doc.appendChild(root);
		
		for(int i=0;i<list.size();i++){
			
			Utente utn = list.get(i);
			
			Element utente = doc.createElement("utente");
			root.appendChild(utente);
			
			Element chiave = doc.createElement("chiave");
			chiave.appendChild(doc.createTextNode(Integer.toString(utn.getChiave())));
			utente.appendChild(chiave);
			
			Element account = doc.createElement("account");
			account.appendChild(doc.createTextNode(Integer.toString(utn.getAccount())));
			utente.appendChild(chiave);
			
			Element sito = doc.createElement("sito");
			sito.appendChild(doc.createTextNode(utn.getSito()));
			utente.appendChild(chiave);
			
			Element utilizzo = doc.createElement("utilizzo");
			utilizzo.appendChild(doc.createTextNode(Integer.toString(utn.getUtilizzo())));
			utente.appendChild(chiave);
			
			Element nomeHotel = doc.createElement("nomeHotel");
			nomeHotel.appendChild(doc.createTextNode(utn.getNomeHotel()));
			utente.appendChild(nomeHotel);
			
			Element tipoStruttura = doc.createElement("tipoStruttura");
			tipoStruttura.appendChild(doc.createTextNode(utn.getTipoStruttura()));
			utente.appendChild(tipoStruttura);
			
			Element tipoOp = doc.createElement("tipoOp");
			tipoOp.appendChild(doc.createTextNode(utn.getTipoOp()));
			utente.appendChild(tipoOp);
			
			Element livello = doc.createElement("livello");
			livello.appendChild(doc.createTextNode(Integer.toString(utn.getLivello())));
			utente.appendChild(livello);
			
			//Se è presente un questionario
			if(!(utn.getQuestionario().getRisposte().isEmpty())){
			
				Element questionario = doc.createElement("questionario");
				utente.appendChild(questionario);
				
				Element nUtente = doc.createElement("nUtente");
				nUtente.appendChild(doc.createTextNode(Integer.toString((utn.getQuestionario().getnUtente()))));
				questionario.appendChild(nUtente);
				
				Element admin = doc.createElement("admin");
				admin.appendChild(doc.createTextNode(Integer.toString((utn.getQuestionario().getAdmin()))));
				questionario.appendChild(admin);
				
				Element updated = doc.createElement("updated");
				updated.appendChild(doc.createTextNode((utn.getQuestionario().getUpdated().toString())));
				questionario.appendChild(updated);
			
				Element risposte = doc.createElement("risposte");
				questionario.appendChild(risposte);
				
				//Ciclo risposte questionario
				utn.getQuestionario().getRisposte().forEach((t,q)->{
					Element risposta = doc.createElement(t.split("_")[0]);
					risposta.setAttribute("voce", t.split("_")[1]);
					risposta.appendChild(doc.createTextNode(q));
					risposte.appendChild(risposta);
				});	
			}
		}
		
		tFact = TransformerFactory.newInstance();
		trsf = tFact.newTransformer();
		
		trsf.setOutputProperty(OutputKeys.VERSION, "1.0");
		trsf.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		trsf.setOutputProperty(OutputKeys.STANDALONE, "yes");
		trsf.setOutputProperty(OutputKeys.INDENT, "yes");
		
		source = new DOMSource(doc);
		
		try {
			FileWriter fw = new FileWriter("filteredData.xml");
			StreamResult res = new StreamResult(fw);
			trsf.transform(source, res);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
