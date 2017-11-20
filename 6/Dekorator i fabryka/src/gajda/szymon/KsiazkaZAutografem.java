package gajda.szymon;

public class KsiazkaZAutografem extends PublikacjaDekorator {
    String autograf;

    public KsiazkaZAutografem(Publikacja p, String autograf) throws Exception {
        super(p);

        if( p instanceof KsiazkaZObwoluta )
            throw new Exception("wyjątek! Autograf może być tylko jeden.");

        this.autograf = autograf;
    }

    @Override
    public String toString() {
        return dekorowanaPublikacja.toString() + " " + autograf + " |";
    }
}
