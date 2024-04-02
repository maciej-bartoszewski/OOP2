public abstract class Wpis {
    protected final Adres adres;
    protected final NrTelefoniczny nrTelefoniczny;

    protected Wpis(Adres adres, NrTelefoniczny nrTelefoniczny) {
        this.adres = adres;
        this.nrTelefoniczny = nrTelefoniczny;
    }

    public abstract void opis();
}
