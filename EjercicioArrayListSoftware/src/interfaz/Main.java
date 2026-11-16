package interfaz;

import modelo.Desarrollador;
import modelo.Proyecto;

public class Main {
    public static void main(String[] args) {
        // 1. Creación de desarrolladores independientes (Agregación)
        Desarrollador d1 = new Desarrollador("D01", "Ana", "Backend", 20);
        Desarrollador d2 = new Desarrollador("D02", "Luis", "Frontend", 15);
        Desarrollador d3 = new Desarrollador("D03", "Carlos", "QA / Testing", 25);

        // 2. Creación del proyecto
        Proyecto proyecto = new Proyecto("Sistema de ventas");

        // Prueba proyecto vacío
        System.out.println("--- PRUEBA PROYECTO VACÍO ---");
        System.out.println(proyecto.mostrarEquipo());
        System.out.println();

        // 3. Agregar desarrolladores al proyecto
        proyecto.agregarDesarrollador(d1);
        proyecto.agregarDesarrollador(d2);
        proyecto.agregarDesarrollador(d3);

        // 4. Mostrar equipo completo
        System.out.println("--- MOSTRAR EQUIPO ---");
        System.out.println(proyecto.mostrarEquipo());
        System.out.println();

        // 5. Prueba de búsqueda (existente e inexistente)
        System.out.println("--- PRUEBA DE BÚSQUEDA ---");
        Desarrollador buscado = proyecto.buscarDesarrollador("D02");
        if (buscado != null) {
            System.out.println("Encontrado: " + buscado.mostrarInformacion());
        } else {
            System.out.println("Desarrollador no encontrado.");
        }

        Desarrollador noExiste = proyecto.buscarDesarrollador("D99");
        if (noExiste != null) {
            System.out.println("Encontrado: " + noExiste.mostrarInformacion());
        } else {
            System.out.println("Desarrollador D99 no encontrado correctamente.");
        }
        System.out.println();

        // 6. Prueba de eliminación (existente e inexistente)
        System.out.println("--- PRUEBA DE ELIMINACIÓN ---");
        boolean eliminado = proyecto.eliminarUsuario("D01"); // o eliminarDesarrollador
        System.out.println("¿Eliminado D01?: " + proyecto.eliminarDesarrollador("D01"));
        System.out.println("¿Eliminado D99?: " + proyecto.eliminarDesarrollador("D99"));
        System.out.println();

        // 7. Mostrar equipo final y total de horas
        System.out.println("--- EQUIPO DESPUÉS DE ELIMINAR ---");
        System.out.println(proyecto.mostrarEquipo());
        System.out.println();

        // 8. Desafío adicional: Obtener desarrollador con mayor carga
        System.out.println("--- DESAFÍO ADICIONAL: MAYOR CARGA ---");
        Desarrollador mayorCarga = proyecto.obtenerMayorCarga();
        if (mayorCarga != null) {
            System.out.println("Desarrollador con mayor carga de horas: " + mayorCarga.mostrarInformacion());
        }
    }
}
