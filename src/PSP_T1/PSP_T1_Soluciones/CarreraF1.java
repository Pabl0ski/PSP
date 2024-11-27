package PSP_T1.PSP_T1_Soluciones;

public class CarreraF1 extends Thread{
    private String piloto;

    public CarreraF1(String piloto) {this.piloto = piloto;}

    @Override
    public void run() {
        for(int vuelta = 1; vuelta <= 78; vuelta++){
            System.out.println("Piloto" + piloto + " completo la vuelta " + vuelta);
            try {
                //siimula el tiempo de la vuelta
                Thread.sleep((long) (Math.random() * 500));
            }catch (InterruptedException e){
                System.out.println("El piloto " + piloto + " tuvo un problema.");
            }

        }
        System.out.println("¡El piloto " + piloto + " ha termianado la carrera!!!");
    }

    public static void main(String[] args) {
        String[] pilotos = {"Hamilton", "Vettel", "Raikkonen", "Alonso", "Saínz Jr", "Bottas", "Vandoorne"};

        for (String piloto:pilotos){
            new CarreraF1(piloto).start();
        }
    }
}
