import java.util.Scanner;

public class MenuConversion {

    public static void mostrarMenu() {
        System.out.println("Menú de opciones");
        System.out.println("1. °C a °F");
        System.out.println("2. °F a °C");
        System.out.println("3. Km a Millas");
        System.out.println("4. Millas a Km");
        System.out.println("5. Salir");
    }

    // Método validación de opción
    public static int obtenerOpcionValida(Scanner scanner) {
        int opcion;
        while (true) {
            System.out.print("Elige una opción del 1 al 5: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                } else {
                    System.out.println("El número ingresado es INVÁLIDO. Intenta de nuevo.");
                }
            } else {
                System.out.println("Debes ingresar un NÚMERO válido.");
                scanner.next();
            }
        }
    }

    // Método para validar números double
    public static double obtenerNumeroDouble(Scanner scanner, String mensaje) {
        double numero;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                numero = scanner.nextDouble();
                return numero;
            } else {
                System.out.println("Entrada inválida. Debes ingresar un número.");
                scanner.next(); // limpiar entrada
            }
        }
    }

    //Método para asignar case
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        int CaF = 0;
        int FaC = 0;
        int KmaMi = 0;
        int MiaKm = 0;

        do {
            mostrarMenu();
            opcion = obtenerOpcionValida(scanner);

            switch (opcion) {

                case 1:
                    double C = obtenerNumeroDouble(scanner, "Ingresa grados Celsius: ");
                    double F = (C * 9 / 5) + 32;
                    System.out.println("Resultado: " + F + " °F");
                    CaF++;
                    break;

                case 2:
                    F = obtenerNumeroDouble(scanner, "Ingresa grados Fahrenheit: ");
                    C = (F - 32) / 1.8;
                    System.out.println("Resultado: " + C + " °C");
                    FaC++;
                    break;

                case 3:
                    double Km = obtenerNumeroDouble(scanner, "Ingresa los Km: ");
                    double Mi = Km / 1.6;
                    System.out.println("Resultado: " + Mi + " millas");
                    KmaMi++;
                    break;

                case 4:
                    Mi = obtenerNumeroDouble(scanner, "Ingresa las millas: ");
                    Km = Mi * 1.6;
                    System.out.println("Resultado: " + Km + " kilómetros");
                    MiaKm++;
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
            }

            System.out.println();

        } while (opcion != 5);

        // Resumen final
        int total = CaF + FaC + KmaMi + MiaKm;

        System.out.println("Conversiones hechas anteriormente: ");
        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + CaF);
        System.out.println("°F a °C: " + FaC);
        System.out.println("Km a Millas: " + KmaMi);
        System.out.println("Millas a Km: " + MiaKm);

        scanner.close();
    }
}
