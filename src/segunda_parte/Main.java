package segunda_parte;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import primera_parte.*;

public class Main {

	public static void main(String[] args) {
		Backtracking bk = new Backtracking("../tpe/src/segunda_parte/Tareas.csv", "../tpe/src/segunda_parte/Procesadores.csv");
		bk.asignacion(2);
	}

}
