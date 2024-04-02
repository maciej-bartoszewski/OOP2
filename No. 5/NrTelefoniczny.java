public class NrTelefoniczny implements Comparable<NrTelefoniczny> {
    private final int nrKierunkowy;
    private final int nrTelefonu;

    public NrTelefoniczny(int nrKierunkowy, int nrTelefonu) {
        if (String.valueOf(nrKierunkowy).length() != 2 || String.valueOf(nrTelefonu).length() != 9)
            throw new IllegalArgumentException("nrKierunkowy powinien skladac sie z 2 cyfr, a nrTelefonu z 9");

        this.nrKierunkowy = nrKierunkowy;
        this.nrTelefonu = nrTelefonu;
    }

    public int getNrKierunkowy() {
        return nrKierunkowy;
    }

    public int getNrTelefonu() {
        return nrTelefonu;
    }

    @Override
    public int compareTo(NrTelefoniczny porownywany) {
        if (this.nrKierunkowy != porownywany.getNrKierunkowy()) return -1;
        if (this.nrTelefonu != porownywany.getNrTelefonu()) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "+" + nrKierunkowy + " " + nrTelefonu;
    }
}