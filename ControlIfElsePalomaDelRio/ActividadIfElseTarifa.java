import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa tu edad: ");
        int edad = sc.nextInt();

        // Validación de  rango de edad
        if (edad < 0) {
            System.out.println("Edad ingresada inválida");
            return;
        }

        if (edad > 120) {
            System.out.println("Edad ingresada inválida");
            return;
        }


        //Validación de estudiante
        System.out.print("¿Eres estudiante? (true/false): ");
        boolean esEstudiante = sc.nextBoolean();


        //Asignación de tarifa por rango de edad
        int tarifa = 0;

        if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else if (edad >= 18) {
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        System.out.println("Resultado de datos ingresados");
        System.out.println("Edad ingresada: " + edad);

        if (esEstudiante) {
            System.out.println("Usted SI es estudiante");
        } else {
            System.out.println("Usted NO es estudiante");
        }

        System.out.println("La tarifa a pagar es: $" + tarifa);
    }
}
