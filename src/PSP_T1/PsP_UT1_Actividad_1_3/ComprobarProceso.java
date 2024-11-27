package PSP_T1.PsP_UT1_Actividad_1_3;

public class ComprobarProceso {
    public static void main(String[] args) {
        // Crear un hilo que represente el proceso
        Thread proceso = new Thread(() -> {
            System.out.println("El proceso ha comenzado.");
            try {
                // Simular una tarea larga de 10 segundos
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("El proceso fue interrumpido.");
            }
            System.out.println("El proceso ha terminado.");
        });

        // Iniciar el proceso
        proceso.start();

        // Comprobar periódicamente si el proceso sigue en ejecución
        while (true) {
            try {
                // Esperar 3 segundos entre comprobaciones
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("El programa fue interrumpido.");
            }

            // Verificar si el proceso sigue vivo
            if (proceso.isAlive()) {
                System.out.println("El proceso sigue en ejecución...");
            } else {
                System.out.println("El proceso ya no está en ejecución. Terminando programa.");
                break; // Salir del bucle si el proceso ha terminado
            }
        }
    }
}