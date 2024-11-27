package PSP_T1.PSP_T1_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ShellExecutor {

    public static void main(String[] args) {
        // Comando de Linux a ejecutar (puedes modificarlo)
        String comando = "ls -l"; // Lista archivos en formato detallado

        try {
            // Ejecutar el comando mediante Runtime
            Process proceso = Runtime.getRuntime().exec(comando);

            // Capturar la salida estándar del comando
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            // Leer cada línea de la salida del proceso
            String linea;
            System.out.println("Salida del comando:");
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperar a que el proceso termine y capturar el código de salida
            int exitCode = proceso.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido: " + e.getMessage());
        }
    }
}
