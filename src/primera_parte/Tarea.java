package primera_parte;

public class Tarea {
	private int id_tarea;
	private String nombre_tarea;
	private int tiempo_ejecucion;
	private boolean es_critica;
	private int nivel_prioridad;
	private boolean en_proceso;
	
	public Tarea(int id_t, String nombre, int tiempo, boolean critica, int nivel) {
		this.id_tarea = id_t;
		this.nombre_tarea = nombre;
		this.tiempo_ejecucion = tiempo;
		this.es_critica = critica;
		this.nivel_prioridad = nivel;
		this.en_proceso = false;
	}

	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}

	public void setNombre_tarea(String nombre_tarea) {
		this.nombre_tarea = nombre_tarea;
	}

	public void setTiempo_ejecucion(int tiempo_ejecucion) {
		this.tiempo_ejecucion = tiempo_ejecucion;
	}

	public void setEs_critica(boolean es_critica) {
		this.es_critica = es_critica;
	}

	public void setNivel_prioridad(int nivel_prioridad) {
		this.nivel_prioridad = nivel_prioridad;
	}
	
	public void ejecutar_cortar() {
		this.en_proceso = !this.en_proceso;
	}

	public int getId_tarea() {
		return id_tarea;
	}

	public String getNombre_tarea() {
		return nombre_tarea;
	}

	public int getTiempo_ejecucion() {
		return tiempo_ejecucion;
	}

	public boolean es_critica() {
		return es_critica;
	}

	public int getNivel_prioridad() {
		return nivel_prioridad;
	}
	
	public boolean estaEnProceso() {
		return this.en_proceso;
	}
	
}
