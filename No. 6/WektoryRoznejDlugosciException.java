public class WektoryRoznejDlugosciException extends Exception{
    private final int dlugoscPierwszegoWektora;
    private final int dlugoscDrugiegoWektora;

    public WektoryRoznejDlugosciException(int dlugoscPierwszegoWektora, int dlugoscDrugiegoWektora){
        this.dlugoscPierwszegoWektora = dlugoscPierwszegoWektora;
        this.dlugoscDrugiegoWektora = dlugoscDrugiegoWektora;
    }

    public String getMessage(){
        return "Dlugosc pierwszego wektora: " + dlugoscPierwszegoWektora + ", a drugiego: " + dlugoscDrugiegoWektora
                + ". Dlugosci powinny byc takie same";
    }
}
