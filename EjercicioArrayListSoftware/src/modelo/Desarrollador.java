package modelo;

import utilitario.Validacion;

public class Desarrollador {
    private String identificacion;
    private String nombre;
    private String especialidad;
    private double horasAsignadas;

    public Desarrollador(String identificacion, String nombre, String especialidad, double horasAsignadas) {
        if (Validacion.esTextoValido(identificacion)) {
            this.identificacion = identificacion;
        } else {
            this.identificacion = "SIN_ID";
        }

        if (Validacion.esTextoValido(nombre)) {
            this.nombre = nombre;
        } else {
            this.nombre = "Sin Nombre";
        }

        if (Validacion.esTextoValido(especialidad)) {
            this.especialidad = especialidad;
        } else {
            this.especialidad = "General";
        }

        if (Validacion.esPositivo(horasAsignadas)) {
            this.horasAsignadas = horasAsignadas;
        } else {
            this.horasAsignadas = 0.0;
        }
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getHorasAsignadas() {
        return horasAsignadas;
    }

    public String mostrarInformacion() {
        return "ID: " + identificacion + " | Nombre: " + nombre + " | Especialidad: " + especialidad + " | Horas: " + horasAsignadas;
    }
}
