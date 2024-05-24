package segunda_parte;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.HashMap;
import java.util.Iterator;
//import java.util.List;
//import java.util.Map;

import primera_parte.*;

public class Backtracking {
	private CSVReader lector;
	private ArrayList<Tarea> listaTareas;
	private int[] procesadoresOcupados;
	private Collection<Procesador> listaProcesadores;
	private ArrayList<Tarea> tareasAsignadas;
	private ArrayList<Proceso> listaProcesamiento, listaProcesamientoAux;
	private int tiempoTotalEjecucion, ttAux;

	public Backtracking(String pathTareas, String pathProcesadores) {
		this.lector = new CSVReader();
		this.listaTareas = crearListaTareas(this.lector.readTareas(pathTareas).values());
		this.tareasAsignadas = new ArrayList<>();
		this.listaProcesadores = this.lector.readProcesadores(pathProcesadores).values();
		this.listaProcesamiento = new ArrayList<Proceso>();
		this.listaProcesamientoAux = new ArrayList<>();
		inicializarListaProcOcupados();
		this.tiempoTotalEjecucion = 0;
		this.ttAux = 0;
	}
	
	private ArrayList<Tarea> crearListaTareas(Collection<Tarea> tareas) {
		ArrayList<Tarea> t = new ArrayList<>();
		Iterator<Tarea> it = tareas.iterator();
		while(it.hasNext()) t.add(it.next());
		return t;
	}
	
	private void inicializarListaProcOcupados() {
		this.procesadoresOcupados = new int[listaProcesadores.size()];
		for (int i = 0; i < procesadoresOcupados.length; i++) {
			procesadoresOcupados[i] = 0;
			
		}
	}
	
	private Procesador dameUnProcesador(Tarea t) {
		Procesador p = null;
		Iterator<Procesador> i = this.listaProcesadores.iterator();
		while(i.hasNext()) {
			p = i.next();
			if(procesadoresOcupados[p.getId_procesador()-1] < ttAux && procesadorEstaApto(t, p, tiempoTotalEjecucion)) {
				return p;
			}
		}
		return p;
	}
	
	private boolean procesadorEstaApto(Tarea t, Procesador p, int ejecucion) {
		if(t.es_critica()) {
			return p.puedeEjecutarTareaCritica();
		} else if(p.esta_refrigerado()){
			return (t.getTiempo_ejecucion() <= ejecucion);
		}
		return true;
	}
	public void asignacion(int x) {
		asignacion_(x);
		System.out.println("Tiempo maximo de ejecucion: "+this.tiempoTotalEjecucion);
		Iterator<Proceso> proc = this.listaProcesamiento.iterator();
		while(proc.hasNext()) System.out.println(proc.next());
	}
	private void asignacion_(int x) {
		if(this.tareasAsignadas.size() == this.listaTareas.size()) {
//		if(this.listaTareas.size() == 0) {
			if(this.ttAux > this.tiempoTotalEjecucion) {
				this.tiempoTotalEjecucion = this.ttAux;
				this.listaProcesamiento.clear();
				this.listaProcesamiento.addAll(listaProcesamientoAux);
				Iterator<Proceso> proc = this.listaProcesamiento.iterator();
				while(proc.hasNext()) System.out.println(proc.next());
			}
		} else {
			Iterator<Tarea> itTarea = this.listaTareas.iterator();
			Tarea t;
			int tiempoAnterior = 0;
			while(itTarea.hasNext()) {
				t = itTarea.next();
				if(!this.tareasAsignadas.contains(t)) {
					Procesador p = dameUnProcesador(t);
					Proceso proceso = new Proceso(p, t, ttAux);
					this.listaProcesamientoAux.add(proceso);
					this.tareasAsignadas.add(t);
					ttAux += t.getTiempo_ejecucion();
					tiempoAnterior = procesadoresOcupados[p.getId_procesador()-1];
					procesadoresOcupados[p.getId_procesador()-1] = ttAux+t.getTiempo_ejecucion();
					asignacion_(x);
					procesadoresOcupados[p.getId_procesador()-1] = tiempoAnterior;
					ttAux -= t.getTiempo_ejecucion();
					this.tareasAsignadas.remove(t);
					this.listaProcesamientoAux.remove(proceso);
					if(t.es_critica()) p.restarUnaTareaCritica();
				}
				
			}	
			System.out.println("TERMINO WHILE");
		}
	}

}
