import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        String nombre = leerTextoNoVacio(sc, "Nombre del alumno: ");

        double p1 = leerDoubleEnRango(sc, "Parcial 1 (0-100): ", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Parcial 2 (0-100): ", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Parcial 3 (0-100): ", 0, 100);

        int asistencia = leerIntEnRango(sc, "Asistencia (0-100): ", 0, 100);

        boolean entregoProyecto = leerBoolean(sc, "¿Entregó proyecto? (true/false): ");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double finalCalif = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(finalCalif, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, finalCalif, estado);
    }

    //MÉTODO INPUT

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("X: Debe ingresar los datos");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("X: Debe ser un NÚMERO de entre " + min + " y " + max);
                }
            } else {
                System.out.println("X: Debe ingresar un NÚMERO VALIDO");
                sc.next();
            }
        }
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("X: Debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("X: Solo se aceptan números enteros");
                sc.next();
            }
        }
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("X: Debe ingresar solamente - true o false -");
                sc.next();
            }
        }
    }

    //MÉTODO OUTOUT

    public static void imprimirReporte(String nombre, double p1, double p2, double p3,
        double promedio, int asistencia, boolean proyecto,
        double finalCalif, String estado) {

        System.out.println("REPORTE");
        System.out.println("Nombre Alumno: " + nombre);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio Final: " + promedio);
        System.out.println("Asistencia: " + asistencia);
        System.out.println("Entregó proyecto: " + proyecto);
        System.out.println("Calificación final: " + finalCalif);
        System.out.println("Estado: " + estado);
    }
}
