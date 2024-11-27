package PSP_T1.PSP_T1_Thread;

public class CheckProcessAlive {
    public static void main(String[] args) {
        // Crear un nuevo hilo que simule un proceso largo
        Thread process = new Thread(() -> {
            System.out.println("Proceso iniciado.");
            try {
                // Simulamos que el proceso tarda 10 segundos
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("El proceso fue interrumpido.");
            }
            System.out.println("Proceso terminado.");
        });

        // Iniciar el proceso
        process.start();

        // Comprobar periódicamente si el proceso sigue vivo
        while (true) {
            try {
                // Esperar 3 segundos
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("El chequeo fue interrumpido.");
            }

            // Comprobar si el proceso sigue vivo
            if (process.isAlive()) {
                System.out.println("El proceso sigue en ejecución...");
            } else {
                System.out.println("El proceso ha finalizado.");
                break; // Salir del bucle cuando el proceso termina
            }
        }

        System.out.println("Programa terminado.");
    }
}
