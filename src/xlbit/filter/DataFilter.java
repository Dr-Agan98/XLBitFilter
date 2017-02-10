package xlbit.filter;

import xlbit.data.*;
import java.util.Map;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class DataFilter {

	@FunctionalInterface
	public interface Filter<T>{
		boolean test(T t);
	}

	/*----------FILTRI----------*/
	Filter<Utente> std1 = t->t instanceof Utente;
	Filter<Utente> std3 = t->(
			t.getQuestionario().getRisposte().getOrDefault("gest_nessuno", "false").equals("true")
			&& t.getQuestionario().getRisposte().getOrDefault("chann_tic", "false").equals("true")
	);
	Filter<Utente> std4_5 = t->t.getQuestionario().getRisposte().getOrDefault("gest_text", "false").contains("protel");
	Filter<Utente> std6 = t->(
			t.getQuestionario().getRisposte().getOrDefault("gest_asa", "false").equals("true")
			||t.getQuestionario().getRisposte().getOrDefault("gest_phoenix", "false").equals("true")
			||t.getQuestionario().getRisposte().getOrDefault("gest_xenus", "false").equals("true")
			||t.getQuestionario().getRisposte().getOrDefault("chann_tic", "false").equals("true")
	);
	/*--------------------------*/
	
	private Map<ProjectEnums.EnumFilters,Filter<Utente>> filters;
	private List<Utente> listaUtenti;
	
	public DataFilter(Map<Integer, Utente> utentiMap){
		this.listaUtenti = new ArrayList<>(utentiMap.values());
		this.filters = new EnumMap<>(ProjectEnums.EnumFilters.class);

		this.filters.put(ProjectEnums.EnumFilters.STD1, std1);
		this.filters.put(ProjectEnums.EnumFilters.STD3, std3);
		this.filters.put(ProjectEnums.EnumFilters.STD4_5, std4_5);
		this.filters.put(ProjectEnums.EnumFilters.STD6, std6);
	}

	public List<Utente> filter(ProjectEnums.EnumFilters fltr){
		
		return listaUtenti
				.stream()
				.filter(filters.get(fltr)::test)
				.collect(Collectors.toList());

	}

}
