package segunda_parte;

import primera_parte.*;

public class Proceso {
	private Procesador p;
	private Tarea t;
//	private Integer tiempo;
	public Proceso(Procesador p, Tarea t, Integer tiempo) {
		this.p = p;
		this.t = t;
//		this.p.indicarCuandoTerminaLaTarea(t.getTiempo_ejecucion()+tiempo);
//		this.tiempo = tiempo;
	}
	public Procesador getProcesador() {
		return p;
	}
	public Tarea getTarea() {
		return t;
	}
//	public Integer getTiempo() {
//		return tiempo;
//	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id_procesador: "+this.p.getId_procesador()+" id_tarea: "+this.t.getId_tarea()+" tiempo_ejec: "+this.t.getTiempo_ejecucion();
	}
}
