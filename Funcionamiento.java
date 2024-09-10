import java.util.ArrayList;
public class Funcionamiento {
    private ArrayList<Seccion> secciones = new ArrayList<>();

    public Seccion agregarSeccion(String nombre, int f, int c, int precioBoleto){
        Seccion nuevaSeccion=new Seccion(nombre, f, c, precioBoleto);
        secciones.add(nuevaSeccion);
        return nuevaSeccion;
    }

    public void agregarReserva(String nombre){
        for(Seccion seccion : secciones){
            if (seccion.getNombre().equals(nombre)) {
                seccion.agregarReserva();
            }
        }
    }

    public void eliminarReserva(String nombre){
        for(Seccion seccion : secciones){
            if (seccion.getNombre().equals(nombre)) {
                seccion.eliminarReserva();;
            }
        }
    }

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

    public int calcularIngresosTotales() {
        int ingresosTotales = 0;
        for (Seccion seccion : secciones) {
            ingresosTotales += seccion.calcularIngresos();
        }
        return ingresosTotales;
    }

    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }
}
