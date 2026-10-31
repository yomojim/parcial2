/**
 * Mago: ataca con hechizos y se defiende con un escudo mágico
 * que absorbe el 10% del daño recibido.
 */
public class Mago extends Criatura {
    private String hechizos;

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " lanza el hechizo " + hechizos + " (daño " + daño + ")");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        // El escudo mágico reduce el 10% del daño (mínimo 1)
        int dañoReal = Math.max(1, (int) (daño * 0.9));
        System.out.println("  El escudo mágico de " + getNombre() + " reduce el golpe a " + dañoReal);
        recibirDaño(dañoReal);
    }
}
