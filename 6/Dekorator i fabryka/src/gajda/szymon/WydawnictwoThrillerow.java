package gajda.szymon;

public class WydawnictwoThrillerow extends Wydawnictwo {
    public WydawnictwoThrillerow(String autor) {
        super.autor = autor;
    }

    public Ksiazka createBook(String tytul, int i) {
        return new Thriller(autor, tytul, i);
    }
}
