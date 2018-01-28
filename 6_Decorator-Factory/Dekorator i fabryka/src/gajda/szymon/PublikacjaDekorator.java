package gajda.szymon;

public abstract class PublikacjaDekorator implements Publikacja {
    protected  Publikacja dekorowanaPublikacja;

    public PublikacjaDekorator(Publikacja p)
    {
        dekorowanaPublikacja = p;
    }

    @Override
    public String getAutor() {
        return dekorowanaPublikacja.getAutor();
    }

    @Override
    public String getTitle() {
        return dekorowanaPublikacja.getTitle();
    }

    @Override
    public int getPageCount() {
        return dekorowanaPublikacja.getPageCount();
    }

    @Override
    public String toString() {
        return dekorowanaPublikacja.toString();
    }
}
