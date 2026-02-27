import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Muestra de menú de opciones

        System.out.println("Menú de opciones:");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        // Declaración de variables

        double variableA;
        double variableB;
        double resultado;

        // Asignación de casos por selección de menú

        switch (opcion) {

            case 1:
                System.out.println("Operacion elegida: Sumar");
                System.out.print("Ingresa el primer número: ");
                variableA = sc.nextDouble();
                System.out.print("Ingresa el segundo número: ");
                variableB = sc.nextDouble();

                System.out.println("Valores ingresados: A = " + variableA + ", B = " + variableB);

                resultado = variableA + variableB;
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                System.out.println("Operacion elegida: Restar");
                System.out.print("Ingresa el primer número: ");
                variableA = sc.nextDouble();
                System.out.print("Ingresa el segundo número: ");
                variableB = sc.nextDouble();

                System.out.println("Valores ingresados: A = " + variableA + ", B = " + variableB);

                resultado = variableA - variableB;
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                System.out.println("Operacion elegida: Multiplicar");
                System.out.print("Ingresa el primer número: ");
                variableA = sc.nextDouble();
                System.out.print("Ingresa el segundo número: ");
                variableB = sc.nextDouble();

                System.out.println("Valores ingresados: A = " + variableA + ", B = " + variableB);

                resultado = variableA * variableB;
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                System.out.println("Operacion elegida: Dividir");
                System.out.print("Ingresa el primer número: ");
                variableA = sc.nextDouble();
                System.out.print("Ingresa el segundo número: ");
                variableB = sc.nextDouble();

                if (variableB == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    System.out.println("Valores ingresados: A = " + variableA + ", B = " + variableB);

                    resultado = variableA / variableB;
                    System.out.println("Resultado: " + resultado);
                }
                break;

             // Opción inválida

            default:
                System.out.println("Opcion invalida");
                break;
        }

        sc.close();
    }
}
