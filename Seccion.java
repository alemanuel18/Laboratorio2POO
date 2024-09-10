public class Seccion{

    private String nombre;
    private int precioBoleto;
    int filaActual = 0;
    int columnaActual = 0;
    private int[][] asientos;

    public Seccion(String nombre, int f, int c, int precioBoleto){
        this.nombre=nombre;
        this.precioBoleto=precioBoleto;
        this.asientos=new int[f][c];
        inicializarConCeros();
    }

    private void inicializarConCeros() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = 0;  // Asignar 0 a cada posición
            }
        }
    }

    public void agregarReserva(){
        int fila = cambiarfila();
        int columna = cambiarcolumna();
        asientos[fila][columna] = (asientos[fila][columna] == 0) ? 1 : 0;
    }

    public void eliminarReserva() {
        asientos[filaActual][columnaActual] = (asientos[filaActual][columnaActual] == 1) ? 0 : 1;
    }

    public int cambiarcolumna(){
        if (columnaActual==0) {
            columnaActual++;
            return 0;
        }else{
            columnaActual++;
            return columnaActual-1;
        }

    }

    public int cambiarfila(){
        if (columnaActual >= asientos[0].length) {
            columnaActual = 0; 
            filaActual++;
            return filaActual;
        }else
        return filaActual;
    }

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int[][] getAsientos() {
        return asientos;
    }
    public String getNombre() {
        return nombre;
    }

    public int getPrecioBoleto() {
        return precioBoleto;
    }
}