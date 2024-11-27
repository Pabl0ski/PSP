package PSP_T1.PSP_T1_Soluciones;

public class ParesImpares extends Thread{
    public static void main(String[] args) {
        Thread hilosPares = new NumerosPares();
        Thread hilosImpares = new NumerosImpares();

        hilosPares.start();
        hilosImpares.start();
    }

}
class NumerosPares extends Thread{
    @Override
    public void run() {
        for (int i = 2; i <= 100 ; i+=2) {
            System.out.println("Par: " +i);

        }
    }
}
class NumerosImpares extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 100 ; i+=2) {
            System.out.println("Impar: " +i);

        }
    }
}
