import java.util.Scanner;

public class InputValidator {

    // Para que no se rompa el programa a la hora de no ingresar numeros
    public int getValidInt(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.println(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("El valor no es numerico");
            }
        }
    }
}
