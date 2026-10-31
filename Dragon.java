/**
 * Dragón: ataca con el doble de su fuerza y se defiende con sus escamas,
 * que absorben el 30% del daño recibido.
 */
public class Dragon extends Criatura {
    private String escamas;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() * 2; // ataque más fuerte
        System.out.println(getNombre() + " lanza su aliento de fuego (daño " + daño + ")");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        // Las escamas reducen el 30% del daño (mínimo 1 para que la batalla termine)
        int dañoReal = Math.max(1, (int) (daño * 0.7));
        System.out.println("  Las escamas de " + escamas + " de " + getNombre()
                + " reducen el golpe a " + dañoReal);
        recibirDaño(dañoReal);
    }
}
