import java.util.concurrent.Semaphore;

public class Museo {
    private static final int AFORO_MAXIMO = 5;
    private static final int TOTAL_TURISTAS = 10;
    private static final Semaphore aforoMuseo = new Semaphore(AFORO_MAXIMO, true);
    private static final Semaphore salaEspecial = new Semaphore(1, true);
    private static final Semaphore puertasDobles = new Semaphore(2, true);

    public static void main(String[] args) {
        for (int i=1; i<=TOTAL_TURISTAS; i++){
            new Thread(new Turista(i)).start();
        }
    }


static class Turista implements Runnable {
    private final int id;

    public Turista(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            //acceso al museo por las puertas dobles
            System.out.println("Turista " + id + " esta intentando entrar al museo por las puertas dobles.");
            puertasDobles.acquire(); // Adquirir permiso para entrar por las puertas dobles
            System.out.println("Turista " + id + " ha entrado por las puertas dobles.");

            //intentar entrar al museo
            aforoMuseo.acquire();
            System.out.println("Turista "+id+" ha entrado al museo");
            puertasDobles.release();

            visitarMuseo();

            System.out.println("Turista "+id+" quiere entrar en la sala especial");
            salaEspecial.acquire();
            System.out.println("Turista "+id+" esta en la sala especial");
            visitarSalaEspecial();
            System.out.println("Turista "+id+" ha salido de la sala especial");
            salaEspecial.release();

            System.out.println("Turista "+id+" ha salido del mueso");
            aforoMuseo.release();

        } catch (InterruptedException e) {
            System.out.println("Turista " + id + " fue interrumpido");
        }
    }

    private void visitarMuseo() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 3000 + 1000)); // Simular estancia en el museo
    }

    private void visitarSalaEspecial() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 2000 + 1000)); // Simular estancia en la sala especial
    }
}
}
