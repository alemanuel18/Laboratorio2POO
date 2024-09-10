import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorSecciones {

    public static void main(String[] args) {
       

        Funcionamiento funcionamiento=new Funcionamiento();
        Scanner teclado=new Scanner(System.in);
        int eleccion=menu();

        funcionamiento.agregarSeccion("VIP", 5, 10, 150);
        funcionamiento.agregarSeccion("Platino", 8, 12, 100);
        funcionamiento.agregarSeccion("Oro", 10, 15, 75);
        funcionamiento.agregarSeccion("Plata", 12, 20, 50);

        while (eleccion!=6) {
            if (eleccion == 1) {
                funcionamiento.agregarReserva(seleccionarSeccion(funcionamiento));
                eleccion=menu();

            }else if (eleccion==2) {
                funcionamiento.mostrarDisponibilidad(seleccionarSeccion(funcionamiento));
                eleccion=menu();
            }else if (eleccion==3) {
                funcionamiento.eliminarReserva(seleccionarSeccion(funcionamiento));
                eleccion=menu();
            }else if (eleccion==4) {
                System.out.println(funcionamiento.calcularIngresosTotales());
                eleccion=menu();
            }
        }
        System.out.println("Gracias por preferirnos, hasta la proxima.");
    }

    public static int menu(){
        //Se inicializan las variables
        //Se crean los objetos

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;
        

        while (verificador==false) {
            System.out.println("\nMenu\nSeleccion lo que deses realizar\n1. Reservar Asiento\n2. Mostrar Disponibilidad\n3. Cancelar Reserva\n4. Cancelar reserva\n5. Salir");
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi<1 ||eleccionUsuarioi>5){
                    System.out.println("Ingrese una de las opciones del menu");
                }else
                verificador=true;
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }
        return eleccionUsuarioi;
    }
   
    public static void mostrarSecciones(Funcionamiento funcionamiento) {
        ArrayList<Seccion> secciones = funcionamiento.getSecciones();
        for (int i = 0; i < secciones.size(); i++) {
            Seccion seccion = secciones.get(i);
            System.out.println((i + 1) + ". " + seccion.getNombre()+ " - Precio del Boleto: $"+ seccion.getPrecioBoleto());
        }
    }

    /**
     * 
     * @param funcionamiento
     * @return La biblioteca elegida
     */
    public static String seleccionarSeccion(Funcionamiento funcionamiento) {
        Scanner teclado=new Scanner(System.in);
        

        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;
        ArrayList<Seccion> secciones = funcionamiento.getSecciones();

        
        while (verificador==false) {
            System.out.println("\nSeleccione el número de la biblioteca\n");
            mostrarSecciones(funcionamiento);
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi < 1 && eleccionUsuarioi > secciones.size()){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    verificador=true;
                    eleccionUsuarioS= secciones.get(eleccionUsuarioi-1).getNombre();
                }           
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }
        return eleccionUsuarioS;
    }
}
