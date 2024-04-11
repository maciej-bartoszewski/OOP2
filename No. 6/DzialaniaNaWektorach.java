import java.util.ArrayList;
import java.util.Scanner;

public class DzialaniaNaWektorach {
    public ArrayList<Integer> pobierzWektor(){
        ArrayList<Integer> wektor = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczby oddzielone spacją, enter konczy wektor");
        String[] split = (scanner.nextLine().strip().split(" ", 0));
        for(String liczba: split){
            try {
                wektor.add(Integer.parseInt(liczba));
            } catch (NumberFormatException e){
                System.out.println("Blad, powinienes podac tylko liczy");
                return pobierzWektor();
            }
        }

        return wektor;
    }

    public ArrayList<Integer> dodajWektory(ArrayList<Integer> wektorPierwszy, ArrayList<Integer> wektorDrugi) throws WektoryRoznejDlugosciException {
        if(wektorPierwszy.size() != wektorDrugi.size())
            throw new WektoryRoznejDlugosciException(wektorPierwszy.size(), wektorDrugi.size());

        ArrayList<Integer> wektorWynikowy = new ArrayList<>();

        for(int i = 0; i < wektorPierwszy.size(); i++){
            wektorWynikowy.add(wektorPierwszy.get(i) + wektorDrugi.get(i));
        }

        return wektorWynikowy;
    }
}
