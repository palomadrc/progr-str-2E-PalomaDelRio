import java.util.Scanner;

public class Main4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = pedirEntero(scanner);
        int resultado = sumarHastaN(numero);

        System.out.println("La suma de los números del 1 al " + numero + " es: " + resultado);

        scanner.close();
    }

    /**
     * Solicita un número entero al usuario.
     *
     * @param scanner para leer
     * @return número que ingresó el usuario
     */
    public static int pedirEntero(Scanner scanner) {
        System.out.print("Ingresa un número entero positivo: ");
        return scanner.nextInt();
    }

    /**
     * Calcula la suma de los números del 1 hasta numero limite (numLimite).
     *
     * @param  número límite
     * @return suma total
     */
    public static int sumarHastaN(int numLimite) {
        int suma = 0;

        for (int i = 1; i <= numLimite; i++) {
            suma += i;
        }

        return suma;
    }
}
