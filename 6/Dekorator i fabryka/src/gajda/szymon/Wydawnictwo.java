package gajda.szymon;

public abstract class Wydawnictwo {
    protected String autor;

    public static Wydawnictwo getInstance(String autor) {
        if(autor.equals("Józef Ignacy Kraszewski")) {
            return new WydawnictwoPowiesciHistorycznych(autor);
        }
        if(autor.equals("Thrilleropisarz")) {
            return new WydawnictwoThrillerow(autor);
        }
        if(autor.equals("Poemaciarz")) {
            return new WydawnictwoPoematow(autor);
        }
        return null;
    }

    public abstract Ksiazka createBook(String masław, int i);
}
