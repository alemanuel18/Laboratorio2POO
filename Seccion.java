//  @ Laboratorio 2
//  @ File Name : Seccion.java
//  @ Date : 10/09/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

public class Seccion{

    //Atributos
    private String nombre;
    private int precioBoleto;
    int filaActual = 0;
    int columnaActual = 0;
    private int[][] asientos;

    //Constructor
    /**
     * 
     * @param nombre Strign
     * @param f int
     * @param c int 
     * @param precioBoleto int
     */
    public Seccion(String nombre, int f, int c, int precioBoleto){
        this.nombre=nombre;
        this.precioBoleto=precioBoleto;
        this.asientos=new int[f][c];
        inicializarConCeros();
    }

    /**
     * Se asegura que todos los asientos se encuentren disponibles
     */
    private void inicializarConCeros() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = 0;  // Asignar 0 a cada posición
            }
        }
    }

    /**
     * agrega la reserca cambiando de 0 1
     */
    public void agregarReserva(){
        int fila = cambiarfila();
        int columna = cambiarcolumna();
        asientos[fila][columna] = (asientos[fila][columna] == 0) ? 1 : 0;
    }

    /**
     * ELimina la reserva cambiando de 1 a 0
     */
    public void eliminarReserva() {
        asientos[filaActual][columnaActual] = (asientos[filaActual][columnaActual] == 1) ? 0 : 0;
    }

    /**
     * 
     * @return posision de la columna actual
     */
    public int cambiarcolumna(){
        if (columnaActual==0) {
            columnaActual++;
            return 0;
        }else{
            columnaActual++;
            return columnaActual-1;
        }

    }

    /**
     * 
     * @return posiscion de la fila actual
     */
    public int cambiarfila(){
        if (columnaActual >= asientos[0].length) {
            columnaActual = 0; 
            filaActual++;
            return filaActual;
        }else
        return filaActual;
    }

    /**
     * 

     * @return calcula el ingreso total 
     */
    public double calcularIngresos() {
        int boletosVendidos = 0;
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] == 1) {
                    boletosVendidos++;
                }
            }
        }
        return boletosVendidos * precioBoleto;
    }
    /**
     * 
     * @return asientos
     */
    public int[][] getAsientos() {
        return asientos;
    }
    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @return preciodelboleto
     */
    public int getPrecioBoleto() {
        return precioBoleto;
    }
}