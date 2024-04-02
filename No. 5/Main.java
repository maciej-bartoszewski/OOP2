import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<NrTelefoniczny, Wpis> treeMapNrTelefoniczny = new TreeMap<>();

        Osoba osoba1 = new Osoba("Aureliusz", "Kwiatkowski",
                new Adres("Międzyzdroje", "Chabrowa", 45),
                new NrTelefoniczny(45, 622967824));
        Osoba osoba2 = new Osoba("Matylda", "Zielińska",
                new Adres("Szczytno", "Matejki", 4),
                new NrTelefoniczny(75, 511235135));
        Osoba osoba3 = new Osoba("Klaudia", "Włodarczyk",
                new Adres("Wisła", "Sienkiewicza", 34),
                new NrTelefoniczny(34, 753257896));
        Firma firma1 = new Firma("Rossmann",
                new Adres("Wisła", "Kujawska", 34),
                new NrTelefoniczny(54, 590993252));
        Firma firma2 = new Firma("Big Star",
                new Adres("Zabrze", "Skromna", 34),
                new NrTelefoniczny(34, 678923425));
        Firma firma3 = new Firma("Nike",
                new Adres("Kormoranów", "Kujawska", 34),
                new NrTelefoniczny(39, 546734673));

        treeMapNrTelefoniczny.put(osoba1.getNrTelefoniczny(), osoba1);
        treeMapNrTelefoniczny.put(osoba2.getNrTelefoniczny(), osoba2);
        treeMapNrTelefoniczny.put(osoba3.getNrTelefoniczny(), osoba3);
        treeMapNrTelefoniczny.put(firma1.getNrTelefoniczny(), firma1);
        treeMapNrTelefoniczny.put(firma2.getNrTelefoniczny(), firma2);
        treeMapNrTelefoniczny.put(firma3.getNrTelefoniczny(), firma3);

        System.out.println("Wpisy gdzie kluczem jest numer telefonu:");
        Iterator<Map.Entry<NrTelefoniczny, Wpis>> iterator = treeMapNrTelefoniczny.entrySet().iterator();
        while (iterator.hasNext()) {
            iterator.next().getValue().opis();
        }

        TreeMap<String, Wpis> treeMapUlica = new TreeMap<>();
        treeMapUlica.put(osoba1.getAdres().getUlica(), osoba1);
        treeMapUlica.put(osoba2.getAdres().getUlica(), osoba2);
        treeMapUlica.put(osoba3.getAdres().getUlica(), osoba3);
        treeMapUlica.put(firma1.getAdres().getUlica(), firma1);
        treeMapUlica.put(firma2.getAdres().getUlica(), firma2);
        treeMapUlica.put(firma3.getAdres().getUlica(), firma3);

        System.out.println("\nWpisy gdzie kluczem jest ulica:");
        treeMapUlica.forEach((ulica, wpis) -> wpis.opis());
    }
}