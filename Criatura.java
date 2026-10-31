/**
 * Clase abstracta que representa una criatura genérica del juego.
 * Define los atributos comunes y los comportamientos que cada
 * subclase debe implementar a su manera (polimorfismo).
 */
public abstract class Criatura {
    private String nombre;
    private int salud;
    private int fuerza;

    /**
     * Constructor de la criatura.
     * @param nombre nombre de la criatura
     * @param salud  puntos de vida iniciales
     * @param fuerza fuerza base usada para calcular el daño
     */
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    /** Ataca a otra criatura. Cada subclase define su forma de atacar. */
    public abstract void atacar(Criatura objetivo);

    /** Recibe un daño (daño = fuerza del atacante). Cada subclase define cómo se defiende. */
    public abstract void defender(int daño);

    /** Indica si la criatura sigue viva (salud > 0). */
    public boolean estaViva() {
        return salud > 0;
    }

    /**
     * Resta salud a la criatura sin dejarla en negativo.
     * Lo usan las subclases dentro de defender().
     */
    protected void recibirDaño(int daño) {
        salud = Math.max(0, salud - daño);
    }

    public String getNombre() { return nombre; }
    public int getSalud()     { return salud; }
    public int getFuerza()    { return fuerza; }
}
