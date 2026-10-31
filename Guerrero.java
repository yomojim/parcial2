/**
 * Guerrero: ataca con su espada y se defiende con su armadura,
 * que absorbe una cantidad fija de 3 puntos de daño.
 */
public class Guerrero extends Criatura {
    private String arma;

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " ataca con su " + arma + " (daño " + daño + ")");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        // La armadura resta 3 puntos de daño (mínimo 1)
        int dañoReal = Math.max(1, daño - 3);
        System.out.println("  La armadura de " + getNombre() + " reduce el golpe a " + dañoReal);
        recibirDaño(dañoReal);
    }
}
