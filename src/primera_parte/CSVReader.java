package primera_parte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class CSVReader {

	private String path;
	private HashMap<Integer, Tarea> hashMap;
	private HashMap<Integer, Procesador> hashMapProcesadores;
	public CSVReader() {
		this.path = "";
		this.hashMap = new HashMap<>();
		this.hashMapProcesadores = new HashMap<>();
	}
	
	public HashMap<Integer, Procesador> readProcesadores(String path) {
		this.path = path;
		// Obtengo una lista con las lineas del archivo
		// lines.get(0) tiene la primer linea del archivo
		// lines.get(1) tiene la segunda linea del archivo... y así
		ArrayList<String[]> lines = this.readContent();
		
		for (String[] line: lines) {
			// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
			Integer id_procesador = Integer.parseInt(line[0].trim());
			Integer codigo_procesador = Integer.parseInt(line[1].trim());
			Boolean esta_refrigerado = getBoolean(line[2].trim());
			Integer anio_funcionamiento = Integer.parseInt(line[3].trim());
			
			// Aca instanciar lo que necesiten en base a los datos leidos
			Procesador p = new Procesador(id_procesador, codigo_procesador, esta_refrigerado, anio_funcionamiento);
			hashMapProcesadores.put(Integer.valueOf(id_procesador).hashCode(), p);
		}
		return hashMapProcesadores;
	}

	public HashMap<Integer, Tarea> readTareas(String path) {
		this.path = path;
		// Obtengo una lista con las lineas del archivo
		// lines.get(0) tiene la primer linea del archivo
		// lines.get(1) tiene la segunda linea del archivo... y así
		ArrayList<String[]> lines = this.readContent();
		
		for (String[] line: lines) {
			// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
			Integer id_tarea = Integer.parseInt(line[0].trim());
			String nombre_tarea = (line[1].trim());
			Integer tiempo_ejecucion = Integer.parseInt(line[2].trim());
			Boolean es_critica = getBoolean(line[3].trim());
			Integer nivel_prioridad = Integer.parseInt(line[4].trim());
			
			// Aca instanciar lo que necesiten en base a los datos leidos
			Tarea t = new Tarea(id_tarea, nombre_tarea, tiempo_ejecucion, es_critica, nivel_prioridad);
			hashMap.put(Integer.valueOf(id_tarea).hashCode(), t);
		}
		return hashMap;
	}
	
	private boolean getBoolean(String value) {
		return value=="true";
	}

	private ArrayList<String[]> readContent() {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(this.path);
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

