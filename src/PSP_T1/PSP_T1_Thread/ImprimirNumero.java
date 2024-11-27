package PSP_T1.PSP_T1_Thread;
/*
C) Crear 100 hilos que impriman un número distinto del 1 al 100
 */

public class ImprimirNumero implements Runnable {
    private int numero;

    public ImprimirNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        System.out.println("Hilo " + numero + " -Número: " +numero);
    }

    public static void main(String[] args) {
        for (int i = 1; i <=100; i++) {
            new Thread(new ImprimirNumero(i)).start();
        }
    }
}
