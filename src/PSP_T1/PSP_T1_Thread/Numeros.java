package PSP_T1.PSP_T1_Thread;
/*
B) Crear dos hilos: uno para imprimir números pares y otro para impares (1 al 100)
 */

public class Numeros implements Runnable{
    private boolean esPar;

    public Numeros(boolean esPar){
        this.esPar = esPar;
    }

    @Override
    public void run(){
        for(int i=1; i<=100; i++){
            if(esPar && i %2 == 0){
                System.out.println("Par: "+i);
            } else if (!esPar && i %2 !=0) {
                System.out.println("Impar: "+i);
            }
        }
    }

    public static void main(String[] args){
        Thread pares = new Thread(new Numeros(true));
        Thread impares = new Thread(new Numeros(false));

        pares.start();
        impares.start();
    }
}
