package AdivinarelNumero;
import java.util.Random; 
import java.util.Scanner;

public class AdivinarNumero{

    static int fueraRango = 0;
    static int noNumero = 0;

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int intentos = 0;
        int limIntentos = 7; 
        int secreto = random.nextInt(max)+min;
        boolean gano=false; 

        System.out.println("Adivina un número del 1 al 100 dentro de " +limIntentos + " intentos");

        while(intentos<limIntentos && !gano ) {
            int valor = obtenerNumeroValido(min, max, scanner, "intento:" +(intentos+1));
            intentos++;

            if(valor == secreto){
                System.out.println("!GANASTE:D!");
                System.out.println("Adivinaste en el inteto " +intentos);
                gano=true; 

            }else if(valor > secreto){
                System.out.println("El número SECRETO es MENOR al ingresado");
                
            }else{
                System.out.println("El número SECRETO es MAYOR al ingresado");
            }
        }
        
        if(!gano){
            System.out.println("PERDISTE :C");
            System.out.println("El número secreto es: " +secreto);
        }

        System.out.println("Historial");
        System.out.println("Te pasaste de rango "+fueraRango+" veces");
        System.out.println("Ingresaste "+noNumero+" veces datos NO numéricos");

        scanner.close();
    }
    
    public static int obtenerNumeroValido(int min, int max, Scanner scanner, String mensaje) {
    while (true) {
        System.out.println(mensaje);

        String entrada = scanner.nextLine(); // leer TODO como texto

        try {
            int valor = Integer.parseInt(entrada);

            if (valor >= min && valor <= max) {
                return valor;
            } else {
                System.out.println("Número fuera de rango (1-100)");
                fueraRango++;
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida, no es un número");
            noNumero++;
        }
    }
}
}
