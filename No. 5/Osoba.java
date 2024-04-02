public class Osoba extends Wpis {
    private final String imie;
    private final String nazwisko;

    public Osoba(String imie, String nazwisko, Adres adres, NrTelefoniczny nrTelefoniczny) {
        super(adres, nrTelefoniczny);
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Adres getAdres() {
        return adres;
    }

    public NrTelefoniczny getNrTelefoniczny() {
        return nrTelefoniczny;
    }

    @Override
    public void opis() {
        System.out.println("Imie: " + imie + ", Nazwisko: " + nazwisko +
                ", Adres: " + adres.toString() +
                ", Numer telefonu: " + nrTelefoniczny.toString());
    }
}
