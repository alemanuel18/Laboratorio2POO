import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorSecciones {

    public static void main(String[] args) {
       

        Funcionamiento funcionamiento=new Funcionamiento();
        Scanner teclado=new Scanner(System.in);
        int eleccion=menu();

        while (eleccion!=6) {
            if (eleccion == 1) {
                
            }else if (eleccion==2) {
                if (funcionamiento.getBibliotecas().isEmpty()) {
                    System.out.println("Debe existir almenos una biblioteca para agregar un libro.");
                }else{
                    nombreB=seleccionarBibliotecaA(funcionamiento);
                    System.out.println("Ingrese el nombre del libro");
                    nombreL=teclado.nextLine();
                    funcionamiento.agregarLibroBiblioteca(nombreB, funcionamiento.creaLibro(nombreL, code(), menu2()));
                    System.out.println("Se a creado el libro");
                }
                eleccion=menu();
            }else if (eleccion==3) {
                if (funcionamiento.getBibliotecas().isEmpty()) {
                    System.out.println("Debe existir almenos una biblioteca para agregar un usuario.");
                }else{
                    nombreB=seleccionarBibliotecaA(funcionamiento);
                    System.out.println("Ingrese el nombre del usuario");
                    nombreL=teclado.nextLine();
                    funcionamiento.agregarUsuarioBiblioteca(nombreB, funcionamiento.creaUsuario(nombreL, code()));
                    System.out.println("Se a creado el usuario");
                }
                eleccion=menu();
            }else if (eleccion==4) {
                if (funcionamiento.getBibliotecas().isEmpty()) {
                    System.out.println("Debe existir almenos una biblioteca para agregar un prestamo");
                }else{
                    biblioteca= seleccionarBibliotecaB(funcionamiento);
                    if (biblioteca.getLibros().isEmpty() || biblioteca.getUsuarios().isEmpty()) {
                        System.out.println("Esta biblioteca no tiene libros o usuarios registrados");
                    }else{
                        nombreB=biblioteca.getNombre();
                        funcionamiento.agregarPrestamoBiblioteca(nombreB, funcionamiento.crearPrestamo(funcionamiento.codigoPrestamo(fecha), seleccionarLibro(biblioteca, funcionamiento), seleccionarUsuario(biblioteca, funcionamiento)));
                        System.out.println("Se a registrado el prestamo");
                    }
                }
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
