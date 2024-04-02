public class Adres {
    private final String miejscowosc;
    private final String ulica;
    private final int numerBudynku;

    public Adres(String miejscowosc, String ulica, int numerBudynku) {
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.numerBudynku = numerBudynku;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNumerDomu() {
        return numerBudynku;
    }

    @Override
    public String toString() {
        return miejscowosc + ", " + ulica + " " + numerBudynku;
    }
}
