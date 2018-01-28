package gajda.szymon;

public class KsiazkaZOkladkaZwykla extends PublikacjaDekorator {

    public KsiazkaZOkladkaZwykla(Publikacja p) throws Exception {
        super(p);

        if(p instanceof KsiazkaZOkladkaTwarda || p instanceof KsiazkaZOkladkaZwykla)
            throw new Exception("Okadka jest tylko jedna");
    }

    @Override
    public String toString() {
        return dekorowanaPublikacja.toString() + " okadka zwyka |";
    }
}
