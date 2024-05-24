package primera_parte;

public class Procesador {
	private int id_procesador;
	private int codigo_procesador;
	private boolean esta_refrigerado;
	private int anio_funcionamiento;
	private int cant_tareas_criticas;
	private int fin_tarea;
	private int ultima_tarea_ejecutada;
	
	public Procesador(int id_proc, int cod_proc, boolean esta_ref, int anio) {
		this.id_procesador = id_proc;
		this.codigo_procesador = cod_proc;
		this.esta_refrigerado = esta_ref;
		this.anio_funcionamiento = anio;
		this.cant_tareas_criticas = 0;
		this.fin_tarea = 0;
		this.ultima_tarea_ejecutada = 0;
	}

	public void setId_procesador(int id_procesador) {
		this.id_procesador = id_procesador;
	}

	public void setCodigo_procesador(int codigo_procesador) {
		this.codigo_procesador = codigo_procesador;
	}

	public void setEsta_refrigerado(boolean esta_refrigerado) {
		this.esta_refrigerado = esta_refrigerado;
	}

	public void setAnio_funcionamiento(int anio_funcionamiento) {
		this.anio_funcionamiento = anio_funcionamiento;
	}

	public int getId_procesador() {
		return id_procesador;
	}

	public int getCodigo_procesador() {
		return codigo_procesador;
	}

	public boolean esta_refrigerado() {
		return esta_refrigerado;
	}

	public int getAnio_funcionamiento() {
		return anio_funcionamiento;
	}
/////////////////////////////////////////////////////////////////////////////////////
	
	public void sumarUnaTareaCritica() {
		if(this.cant_tareas_criticas < 2) this.cant_tareas_criticas++;
	}
	
	public void restarUnaTareaCritica() {
		if(this.cant_tareas_criticas > 0) this.cant_tareas_criticas--;
	}
	
	public boolean puedeEjecutarTareaCritica() {
		if(this.cant_tareas_criticas < 2) {
			this.cant_tareas_criticas++;
			return true;
		}
		return false;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id_procesador+"; "+this.codigo_procesador+"; "+this.esta_refrigerado+"; "+this.anio_funcionamiento;
	}
}
