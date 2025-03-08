import java.util.Random;  // Importamos la clase Scanner para leer la entrada del usuario
import java.util.Scanner;   // Importamos la clase Random para generar números aleatorios

public class Main {
    public static void main(String[] args) {
        // Creamos un objeto Random para generar el número aleatorio
        Random random = new Random();
        
        // Generamos un número aleatorio entre 1 y 100
        int numeroSecreto = random.nextInt(100) + 1;
        
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Variable para almacenar la adivinanza del usuario
        int intento = 0;
        
        // Contador de intentos
        int intentos = 0;
        
        // Mensaje de bienvenida
        System.out.println("¡Bienvenido al juego de adivinanza de números!");
        System.out.println("Estoy pensando en un número entre 1 y 100.");
        
        // Bucle para permitir que el usuario adivine varias veces
        while (intento != numeroSecreto) {
            System.out.print("Introduce tu adivinanza: ");
            
            // Leemos el número introducido por el usuario
            intento = scanner.nextInt();
            intentos++;
            
            // Comprobamos si el número es mayor, menor o igual
            if (intento < numeroSecreto) {
                System.out.println("El número es mayor. ¡Intenta de nuevo!");
            } else if (intento > numeroSecreto) {
                System.out.println("El número es menor. ¡Intenta de nuevo!");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
            }
        }
        
        // Cerramos el scanner para evitar problemas de recursos
        scanner.close();
    }
}

