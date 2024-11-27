package PSP_T1.PSP_T1_Thread;
/*
A) Simular una carrera de Fórmula 1 en Mónaco
Descripción: Cada coche es un hilo que imprimirá las 78 vueltas.
Cada hilo recibe como parámetro el nombre del piloto.
 */

public class CarreraF1 implements Runnable{
    private String piloto;

    public CarreraF1(String piloto){
        this.piloto = piloto;
    }

    @Override
    public void run() {
        for(int vuelta = 1 ; vuelta <= 78 ; vuelta++){
            System.out.println("Piloto: " + piloto + " - Vuelta:" + vuelta);
            try {
                Thread.sleep(100); //Simula timpo de espera entre vueltas
            }catch (InterruptedException e){
                System.out.println(piloto + "Ha sido interrumpido");
            }
        }
    }

    public static void main(String[] args) {
        String[] pilotos = {"Hamilton", "Vettel", "Raikkonen", "Alonso", "Sainz Jr", "Bottas", "Vandoorne"};
        for (String piloto : pilotos) {
            new Thread(new CarreraF1(piloto)).start();
        }
    }
}
