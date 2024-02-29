package cifradocesar;
import java.util.Scanner;

public class CifradoCesar {

    public static void main(String[] args) {
        
        // Crear un objeto Scanner para la entrada del usuario
        Scanner ic = new Scanner(System.in);
        ic.useDelimiter("\n");

        // Definir el conjunto de letras del alfabeto
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        // Solicitar al usuario que ingrese una frase
        System.out.println("Dame una frase");
        String frase = ic.next();

        // Solicitar al usuario que ingrese el incremento para el cifrado César
        System.out.println("Ingrese el incremento para el cifrado César:");
        int incremento = ic.nextInt();

        // Solicitar al usuario que elija cifrar o descifrar
        System.out.println("¿Quiere cifrar o descifrar? (C/D)");
        char opcion = ic.next().toUpperCase().charAt(0);

        // Variable para almacenar el resultado del cifrado o descifrado
        String texto;

        // Determinar la opción del usuario y realizar la operación correspondiente
        switch (opcion) {
            case 'C' -> {
                texto = codificar(letras, frase, incremento);
                System.out.println("Texto codificado: " + texto);
            }
            case 'D' -> {
                texto = descodificar(letras, frase, incremento);
                System.out.println("Texto descodificado: " + texto);
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    // Función para cifrar el texto usando el cifrado César
    public static String codificar(String letras, String texto, int incremento) {
        String textoCodificado = "";

        // Convertir el texto a mayúsculas para asegurar la consistencia
        texto = texto.toUpperCase();

        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            int pos = letras.indexOf(caracter);

            // Verificar si el caracter es una letra o no
            if (pos == -1) {
                textoCodificado += caracter;
            } else {
                // Aplicar el cifrado César y agregar el caracter cifrado al resultado
                textoCodificado += letras.charAt((pos + incremento) % letras.length());
            }
        }

        return textoCodificado;
    }

    // Función para descifrar el texto usando el cifrado César
    public static String descodificar(String letras, String texto, int incremento) {
        String textoDescodificado = "";

        texto = texto.toUpperCase();

        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            int pos = letras.indexOf(caracter);

            if (pos == -1) {
                textoDescodificado += caracter;
            } else {
                // Calcular el nuevo índice después de aplicar el cifrado César inverso
                int nuevoIndice = (pos - incremento < 0) ? letras.length() + (pos - incremento) : (pos - incremento);
                textoDescodificado += letras.charAt(nuevoIndice % letras.length());
            }
        }

        return textoDescodificado;
    }
}
