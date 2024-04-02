public class Firma extends Wpis {
    private final String nazwa;

    public Firma(String nazwa, Adres adres, NrTelefoniczny nrTelefoniczny) {
        super(adres, nrTelefoniczny);
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Adres getAdres() {
        return adres;
    }

    public NrTelefoniczny getNrTelefoniczny() {
        return nrTelefoniczny;
    }

    @Override
    public void opis() {
        System.out.println("Nazwa firmy: " + nazwa +
                ", Adres: " + adres.toString() +
                ", Numer telefonu: " + nrTelefoniczny.toString());
    }
}
