package gajda.szymon;

public class KsiazkaZObwoluta extends PublikacjaDekorator {

    public KsiazkaZObwoluta(Publikacja p) throws Exception {
        super(p);

        if( p instanceof KsiazkaZObwoluta )
            throw new Exception("wyjątek! Obwoluta może być jedna");

        if( !(p instanceof KsiazkaZOkladkaTwarda || p instanceof KsiazkaZOkladkaZwykla))
            throw new Exception("wyjątek! Nie można obłożyć obwolutą książki, która nie posiada okładki.");
    }

    @Override
    public String toString() {
        return dekorowanaPublikacja.toString() + " z obwoluta |";
    }
}
