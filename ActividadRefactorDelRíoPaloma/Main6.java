import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("CALCULADORA DE PROMEDIOS8");
        System.out.println("A continuación, ingrese los números a promediar: ");
        int a = pedirEntero(scanner, "a");
        int b = pedirEntero(scanner, "b");
        int c = pedirEntero(scanner, "c");

        int suma = calcularSuma(a, b, c);
        double promedio = calcularPromedio(suma, 3);

        System.out.println("suma = " + suma);
        System.out.println("prom = " + promedio);

        scanner.close();
    }

    /**
     * Solicita un número entero al usuario.
     *
     * @param scanner  ->objeto Scanner para leer la entrada
     * @param mensaje  ->texto que se muestra al usuario
     * @return número  ->entero
     */
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextInt();
    }

    /**
     * Cálculo de la suma de tres números enteros.
     *
     * @param a ->primer número
     * @param b -> segundo número
     * @param c -> tercer número
     * @return suma -> total
     */
    public static int calcularSuma(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Cálculo del promedio.
     *
     * @param suma -> suma total de los valores
     * @param cantidad ->cantidad de números
     * @return -> promedio calculado
     */
    public static double calcularPromedio(int suma, int cantidad) {
        return suma / (double) cantidad;
    }
}
