package gajda.szymon;

public class KsiazkaZOkladkaTwarda extends PublikacjaDekorator{

    public KsiazkaZOkladkaTwarda(Publikacja p) throws Exception {
        super(p);

        if(p instanceof KsiazkaZOkladkaTwarda || p instanceof KsiazkaZOkladkaZwykla)
            throw new Exception("Okadka jest tylko jedna");
    }

    @Override
    public String toString() {
        return dekorowanaPublikacja.toString() + " okadka twarda |";
    }
}
