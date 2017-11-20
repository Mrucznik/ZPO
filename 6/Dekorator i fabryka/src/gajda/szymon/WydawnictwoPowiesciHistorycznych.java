package gajda.szymon;

public class WydawnictwoPowiesciHistorycznych extends Wydawnictwo {
    public WydawnictwoPowiesciHistorycznych(String autor) {
        super.autor = autor;
    }

    public Ksiazka createBook(String tytul, int i) {
        return new PowiescHistoryczna(autor, tytul, i);
    }
}
