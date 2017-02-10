package xlbit.data;

import xlbit.filter.*;
import java.sql.*;
import java.util.Map;
import java.util.HashMap;
//import java.util.List;

public class MapManager {

	private Database db;
	private Map<Integer, Utente> utentiMap;
	private DataFilter dataFilter;

	public MapManager() {
		this.db = new Database();
		this.utentiMap = new HashMap<>();

		try {
			db.newConnection();
			createMapUsers();
			createMapQuestionario();
			dataFilter = new DataFilter(utentiMap);
			db.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createMapUsers() throws SQLException {
		ResultSet rs = db.executeQuery("SELECT * FROM simpleusers");
		Utente ut;

		while (rs.next()) {
			ut = new Utente(rs.getInt("chiave"), rs.getInt("account"), rs.getString("sito").toLowerCase(), rs.getInt("utilizzo"),
							 (rs.getString("nome").replaceAll("\r\n", "")).toLowerCase(), rs.getString("tipoStruttura").toLowerCase(),
							  rs.getString("tipoOp").toLowerCase(), rs.getInt("livello"));
			utentiMap.put(ut.getChiave(), ut);
		}
		rs.close();
	}

	public void createMapQuestionario() throws SQLException {
		ResultSet rs = db.executeQuery("SELECT * FROM questionari");

		while (rs.next()) {
			if (utentiMap.containsKey(rs.getInt("utente"))) {
				utentiMap
				.get(rs.getInt("utente"))
				.getQuestionario()
				.addQuestionario(rs.getInt("admin"),rs.getString("categoria").toLowerCase(),rs.getString("idvoce").toLowerCase(),
								  rs.getString("value").toLowerCase(),Timestamp.valueOf(rs.getString("updated")));
			}
		}
		rs.close();
	}

	public void filterByParams(ProjectEnums.EnumFilters fltr){
		/*List<Utente> res = */dataFilter.filter(fltr);
		//System.out.println();
	}

	//Getters
	public Database getDb() {return db;}
	public Map<Integer, Utente> getUtentiMap() {return utentiMap;}
	public DataFilter getDataFilter() {return dataFilter;}

	//Setters
	public void setDb(Database db) {this.db = db;}
	public void setUtentiMap(Map<Integer, Utente> utentiMap) {this.utentiMap = utentiMap;}
	public void setDataFilter(DataFilter filter) {this.dataFilter = filter;}

}
