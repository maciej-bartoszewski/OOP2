import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ObslugaPliku obslugaPliku = new ObslugaPliku("wynik.txt");
        DzialaniaNaWektorach dzialaniaNaWektorach = new DzialaniaNaWektorach();

        boolean czyWykonanoDodawanie = false;

        while (!czyWykonanoDodawanie) {
            System.out.print("Wprowadzasz pierwszy wektor. ");
            ArrayList<Integer> wektorPierwszy = dzialaniaNaWektorach.pobierzWektor();
            System.out.print("Wprowadzasz drugi wektor. ");
            ArrayList<Integer> drugiWektor = dzialaniaNaWektorach.pobierzWektor();
            ArrayList<Integer> wektorWynikowy;
            try {
                wektorWynikowy = dzialaniaNaWektorach.dodajWektory(wektorPierwszy, drugiWektor);
            } catch (WektoryRoznejDlugosciException e) {
                System.out.println(e.getMessage());
                continue;
            }
            czyWykonanoDodawanie = true;
            obslugaPliku.zapiszWektor(wektorWynikowy);
        }
    }
}