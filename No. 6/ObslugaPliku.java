import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ObslugaPliku {
    private final String nazwaPliku;
    public ObslugaPliku(String nazwaPliku){
        this.nazwaPliku = nazwaPliku;
    }
    public void zapiszWektor(ArrayList<Integer> wektorWynikowy){
        try {
            FileWriter fileWriter = new FileWriter(nazwaPliku);
            for(Integer liczba: wektorWynikowy) {
                fileWriter.write(liczba.toString() + " ");
            }
            fileWriter.close();
        } catch (IOException e){
            System.out.println("Nie udalo sie zapisac pliku");
            return;
        }
        System.out.println("Wynik dodawania zapisany do pliku: wynik.txt");
    }
}
