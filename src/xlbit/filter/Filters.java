package xlbit.filter;

import java.util.EnumMap;
import java.util.Map;

import xlbit.data.Utente;

public class Filters {

	@FunctionalInterface
	public interface Filter<T>{
		boolean test(T t);
	}

	/*----------FILTRI----------*/
	private Filter<Utente> std1 = t->t instanceof Utente;
	private Filter<Utente> std3 = t->(
			t.getQuestionario().getRisposte().getOrDefault("gest_nessuno", "false").equals("true")
			&& t.getQuestionario().getRisposte().getOrDefault("chann_tic", "false").equals("true")
	);
	private Filter<Utente> std4_5 = t->t.getQuestionario().getRisposte().getOrDefault("gest_text", "false").contains("protel");
	private Filter<Utente> std6 = t->(
			t.getQuestionario().getRisposte().getOrDefault("gest_asa", "false").equals("true")
			||t.getQuestionario().getRisposte().getOrDefault("gest_phoenix", "false").equals("true")
			||t.getQuestionario().getRisposte().getOrDefault("gest_xenus", "false").equals("true")
			||t.getQuestionario().getRisposte().getOrDefault("chann_tic", "false").equals("true")
	);
	/*--------------------------*/
	
    private Map<ProjectEnums.EnumFilters,Filter<Utente>> filters;
	
	public Filters(){
		filters = new EnumMap<>(ProjectEnums.EnumFilters.class);
		filters.put(ProjectEnums.EnumFilters.STD1, std1);
		filters.put(ProjectEnums.EnumFilters.STD3, std3);
		filters.put(ProjectEnums.EnumFilters.STD4_5, std4_5);
		filters.put(ProjectEnums.EnumFilters.STD6, std6);
	}
	
	public Filter<Utente> getFilter(ProjectEnums.EnumFilters flt){
		return filters.get(flt); 
	}
	
}
