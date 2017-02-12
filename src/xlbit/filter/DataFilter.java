package xlbit.filter;

import xlbit.data.*;

import java.util.Map;
import java.util.stream.*;

import java.util.ArrayList;
import java.util.List;

public class DataFilter {
	
	private List<Utente> listaUtenti;
	private Filters filters;
	
	public DataFilter(Map<Integer, Utente> utentiMap){
		this.listaUtenti = new ArrayList<>(utentiMap.values());
		filters = new Filters();
	}

	public List<Utente> filter(ProjectEnums.EnumFilters fltr){
		
		return listaUtenti
				.stream()
				.filter(filters.getFilter(fltr)::test)
				.collect(Collectors.toList());

	}

}
