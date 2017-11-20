package gajda.szymon;

public class WydawnictwoPoematow extends Wydawnictwo {
    public WydawnictwoPoematow(String autor) {
        super.autor = autor;
    }

    public Ksiazka createBook(String tytul, int i) {
        return new Poemat(autor, tytul, i);
    }
}
