package PSP_T1.PSP_T1_Soluciones;

class HiloNumero extends Thread{
    private int numero;
    public HiloNumero(int numero){
        this.numero=numero;
    }

    @Override
    public void run(){
        System.out.println("Hilo número: "+numero);
    }
}

public class CienHilos {
    public static void main(String[] args) {
        for (int i = 1; i <=100 ; i++) {
            new HiloNumero(i).start();
        }
    }
}
