//  @ Laboratorio 2
//  @ File Name : Funcionamiento.java
//  @ Date : 10/09/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//
import java.util.ArrayList;
public class Funcionamiento {

    //Atributos
    private ArrayList<Seccion> secciones = new ArrayList<>();

    /**
     * 
     * @param nombre String
     * @param f int
     * @param c int 
     * @param precioBoleto int
     * @return Seccion
     */
    public Seccion agregarSeccion(String nombre, int f, int c, int precioBoleto){
        Seccion nuevaSeccion=new Seccion(nombre, f, c, precioBoleto);
        secciones.add(nuevaSeccion);
        return nuevaSeccion;
    }

    /**
     * 
     * @param nombre String
     */
    public void agregarReserva(String nombre){
        for(Seccion seccion : secciones){
            if (seccion.getNombre().equals(nombre)) {
                seccion.agregarReserva();
            }
        }
    }

    /**
     * 
     * @param nombre String
     */
    public void eliminarReserva(String nombre){
        for(Seccion seccion : secciones){
            if (seccion.getNombre().equals(nombre)) {
                seccion.eliminarReserva();;
            }
        }
    }

    /**
     * 
     * @param nombre Strign
     * @return String
     */
    public String mostrarDisponibilidad(String nombre) {
        StringBuilder disponibilidad = new StringBuilder();
        for (Seccion seccion : secciones) {
            if (seccion.getNombre().equals(nombre)) {
                int[][] asientos = seccion.getAsientos();

                disponibilidad.append("Disponibilidad de la sección: " + seccion.getNombre() + "\n");
                for (int i = 0; i < asientos.length; i++) {
                    for (int j = 0; j < asientos[i].length; j++) {
                        disponibilidad.append(asientos[i][j] == 0 ? "O" : "X");
                        if (j < asientos[i].length - 1) {
                            disponibilidad.append(" "); // Espacio entre columnas
                        }
                    }
                    disponibilidad.append("\n"); // Nueva línea entre filas
                }
            }
        }
        return disponibilidad.toString();
    }

    /**
     * 
     * @return ingresos totatles
     */
    public int calcularIngresosTotales() {
        int ingresosTotales = 0;
        for (Seccion seccion : secciones) {
            ingresosTotales += seccion.calcularIngresos();
        }
        return ingresosTotales;
    }

    /**
     * 
     * @return Lista de Secciones
     */
    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }
}
