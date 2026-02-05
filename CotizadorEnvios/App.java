package CotizadorEnvios;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Cotización de su envío");

        // INPUT
        double pesoKg = leerDoubleEnRango(sc, "Ingrese peso en Kg con un rango de 0.1 a 50.0: ", 0.1, 50.0);

        int distanciaKm = leerIntEnRango(sc, "Ingrese la distancia en Km con un rango de 1 a 2000: ", 1, 2000);

        int tipoServicio = leerIntEnRango(sc, "Tipo de servicio (1=Estándar, 2=Express): ", 1, 2);

        boolean zonaRemota = leerBoolean(sc, "¿Es zona remota? (true/false): ");

        ShippingCalculator calc = new ShippingCalculator();

        double subtotal = calc.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, zonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        String servicio = calc.obtenerNombreServicio(tipoServicio);

        // OUTPUT
        imprimirTicket(servicio, pesoKg, distanciaKm, zonaRemota, subtotal, iva, total);
    }

    // INPUT

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextBoolean();
    }

    // OUTPUT

    public static void imprimirTicket(String servicio, double peso, int distancia,
            boolean zonaRemota, double subtotal,
            double iva, double total) {

        System.out.println("TICKET");
        System.out.println("Tipo de Servicio: " + servicio);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia total: " + distancia + " km");
        System.out.println("Zona remota: " + zonaRemota);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA (16%): $" + iva);
        System.out.println("Total final: $" + total);
    }
}
