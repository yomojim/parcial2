/**
 * Clase principal: crea las criaturas y simula las batallas.
 */
public class Main {

    /**
     * Simula una batalla por turnos entre dos criaturas.
     * Se usa polimorfismo: el método solo conoce el tipo Criatura,
     * y cada objeto ejecuta su propio atacar()/defender().
     * @return la criatura ganadora
     */
    public static Criatura simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("===== " + criatura1.getNombre() + " VS " + criatura2.getNombre() + " =====");
        int turno = 1;

        // La batalla continúa mientras ambas estén vivas
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");

            criatura1.atacar(criatura2);
            mostrarSalud(criatura1, criatura2);

            // Solo contraataca si sigue viva
            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
                mostrarSalud(criatura1, criatura2);
            }
            turno++;
        }

        Criatura ganadora = criatura1.estaViva() ? criatura1 : criatura2;
        System.out.println("\n>>> Ganador: " + ganadora.getNombre()
                + " con " + ganadora.getSalud() + " de salud\n");
        return ganadora;
    }

    /** Muestra la salud actual de ambas criaturas. */
    private static void mostrarSalud(Criatura c1, Criatura c2) {
        System.out.println("  Salud -> " + c1.getNombre() + ": " + c1.getSalud()
                + " | " + c2.getNombre() + ": " + c2.getSalud());
    }

    public static void main(String[] args) {
        Criatura dragon   = new Dragon("Smaug", 120, 12, "obsidiana");
        Criatura mago     = new Mago("Merlín", 90, 18, "Bola de fuego");
        Criatura guerrero = new Guerrero("Conan", 110, 15, "espada");

        simularBatalla(dragon, mago);
        simularBatalla(mago, guerrero);
        simularBatalla(guerrero, new Dragon("Drogon", 120, 12, "rubí"));
    }
}
