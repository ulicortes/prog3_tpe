package primera_parte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Servicios {
	private HashMap<Integer, Tarea> tareas;
//	private HashMap<Integer, Procesador> procesadores;
//	private CSVReader reader;
	public Servicios(String	pathProcesadores, String pathTareas) {
//		this.procesadores = new HashMap<>();
		this.tareas = this.readTareas(pathTareas);
	}
	
	//	Expresar la complejidad temporal del servicio 1.
//	O(1)‬‭
	public Tarea servicio1(String ID) {
		Tarea tarea = tareas.get(Integer.valueOf(ID));
		return tarea;
	}
	
//	* Expresar la complejidad temporal del servicio 2.
//	O(n)‬‭
	public List<Tarea> servicio2(boolean esCritica){
		List<Tarea> tareasCriticas = new ArrayList<>();
		for(Tarea t : tareas.values()) {
			if(t.es_critica() == esCritica) tareasCriticas.add(t);
		}
		return tareasCriticas;
	}
	
//	* Expresar la complejidad temporal del servicio 3.
//	O(n)‬‭
	public List<Tarea> servicio3(int prioridadInferior‬, int prioridadSuperior‬) {
		List<Tarea> tareasEntreNiveles = new ArrayList<>();
		int nivel;
		for(Tarea t : tareas.values()) {
			nivel = t.getNivel_prioridad();
			if(nivel>=prioridadInferior‬ && nivel<=prioridadSuperior‬) tareasEntreNiveles.add(t);
		}
		return tareasEntreNiveles;
	}
	
	private HashMap<Integer, Tarea> readTareas(String path) {
		HashMap<Integer, Tarea> hashMap = new HashMap<>();
		ArrayList<String[]> lines = this.readContent(path);
		
		for (String[] line: lines) {
			
			Integer id_tarea = Integer.parseInt(line[0].trim());
			String nombre_tarea = (line[1].trim());
			Integer tiempo_ejecucion = Integer.parseInt(line[2].trim());
			Boolean es_critica = getBoolean(line[3].trim());
			Integer nivel_prioridad = Integer.parseInt(line[4].trim());
			
			Tarea t = new Tarea(id_tarea, nombre_tarea, tiempo_ejecucion, es_critica, nivel_prioridad);
			hashMap.put(Integer.valueOf(id_tarea).hashCode(), t);
		}
		return hashMap;
	}
	
	private boolean getBoolean(String value) {
		return value=="true";
	}

	private ArrayList<String[]> readContent(String path) {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		return lines;
	}
}