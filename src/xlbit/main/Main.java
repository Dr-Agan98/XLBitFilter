package xlbit.main;

import xlbit.filter.*;
import xlbit.data.*;

public class Main {
	
	static MapManager mapManager;

	public static void main(String[] args) {
		mapManager = new MapManager();
		mapManager.filterByParams(ProjectEnums.EnumFilters.STD4_5);
	}

}
