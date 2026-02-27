import java.util.Scanner;

public class Main4 {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Método para la ejecución del menú principal
     */
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("Menú opciones");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa tu peso en kg: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingresa tu altura en m: ");
                    double altura = scanner.nextDouble();

                    double imc = calcularIMC(peso, altura);
                    System.out.println("Tu IMC es: " + imc);
                    break;

                case 2:
                    System.out.print("Ingresa la base del rectángulo en cm: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingresa la altura del rectángulo en cm: ");
                    double altRectangulo = scanner.nextDouble();

                    double areaRect = calcularAreaRectangulo(base, altRectangulo);
                    System.out.println("El área del rectángulo es: " + areaRect);
                    break;

                case 3:
                    System.out.print("Ingresa los grados Celsius °C: ");
                    double celsius = scanner.nextDouble();

                    double fahrenheit = convertirCelsiusAFahrenheit(celsius);
                    System.out.println("Grados en Fahrenheit °F: " + fahrenheit);
                    break;

                case 4:
                    System.out.print("Ingresa el radio del círculo en cm: ");
                    double radio = scanner.nextDouble();

                    double areaCirculo = calcularAreaCirculo(radio);
                    System.out.println("El área del círculo es: " + areaCirculo);
                    break;

                case 5:
                    System.out.println("Cancelado");
                    break;

                default:
                    System.out.println("Opción inválida, por favor ingrese una opción del 1 al 5 :D");
            }

            System.out.println();

        } while (choice != 5);

        scanner.close();
    }

    /**
     * Calculo de IMC
     * @param peso de la persona en kg
     * @param altura de la persona en m
     * @return IMC calculado
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Calcula el área de un rectángulo
     * @param base del rectángulo
     * @param altura del rectángulo
     * @return área del rectángulo
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Converción de grados Celsius a Fahrenheit
     * @param grados en Celsius
     * @return grados en Farenheit
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Cálculo del área del círculo
     * @param  radio del círculo en cm
     * @return área del círculo en cm
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}
