package modelo;

import java.util.ArrayList;
import utilitario.Validacion;

public class Proyecto {
    private String nombre;
    private ArrayList<Desarrollador> desarrolladores;

    public Proyecto(String nombre) {
        if (Validacion.esTextoValido(nombre)) {
            this.nombre = nombre;
        } else {
            this.nombre = "Proyecto sin nombre";
        }
        this.desarrolladores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarDesarrollador(Desarrollador desarrollador) {
        if (desarrollador != null) {
            desarrolladores.add(desarrollador);
        }
    }

    public Desarrollador buscarDesarrollador(String identificacion) {
        if (!Validacion.esTextoValido(identificacion)) {
            return null;
        }
        for (Desarrollador d : desarrolladores) {
            if (d.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return d;
            }
        }
        return null;
    }

    public boolean eliminarDesarrollador(String identificacion) {
        Desarrollador dev = buscarDesarrollador(identificacion);
        if (dev != null) {
            desarrolladores.remove(dev);
            return true;
        }
        return false;
    }

    public double calcularTotalHoras() {
        double total = 0.0;
        for (Desarrollador d : desarrolladores) {
            total += d.getHorasAsignadas();
        }
        return total;
    }

    public String mostrarEquipo() {
        if (desarrolladores.isEmpty()) {
            return "El proyecto '" + nombre + "' no tiene desarrolladores asignados.";
        }
        String resultado = "=== EQUIPO DEL PROYECTO: " + nombre.toUpperCase() + " ===
";
        for (Desarrollador d : desarrolladores) {
            resultado += d.mostrarInformacion() + "
";
        }
        resultado += "Total de horas asignadas al proyecto: " + calcularTotalHoras();
        return resultado;
    }

    // Desafío adicional
    public Desarrollador obtenerMayorCarga() {
        if (desarrolladores.isEmpty()) {
            return null;
        }
        Desarrollador mayor = desarrolladores.get(0);
        for (Desarrollador d : desarrolladores) {
            if (d.getHorasAsignadas() > mayor.getHorasAsignadas()) {
                mayor = d;
            }
        }
        return mayor;
    }
}
