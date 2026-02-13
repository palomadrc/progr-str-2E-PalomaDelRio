import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        int opc;
        Scanner sc = new Scanner(System.in);
        PersonaService personaService = new PersonaService();
        Persona[] personas = new Persona[20];

        do {
            System.out.println("Menu opciones");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja logica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
            System.out.println("0) Salir");

            // Solo aceptar numeros
            while (!sc.hasNextInt()) {
                System.out.println("Opción inválida, ingrese SOLO números (0-5)");
                sc.next();
            }

            opc = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opc) {

                case 1:
                    personaService.alta(personas, sc);
                    break;

                case 2:
                    personaService.buscar(personas, sc);
                    break;

                case 3:
                    personaService.bajaLogica(personas, sc);
                    break;

                case 4:
                    personaService.listarActivas(personas);
                    break;

                case 5:
                    personaService.actualizarNombre(personas, sc);
                    break;

                case 0:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opc != 0);

        sc.close();
    }
}
