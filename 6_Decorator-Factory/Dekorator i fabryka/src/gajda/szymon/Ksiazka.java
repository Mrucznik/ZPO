package gajda.szymon;

public class Ksiazka implements Publikacja {
    String autor;
    String title;
    int pages;

    public Ksiazka(String autor, String title, int pages) {
        this.autor = autor;
        this.title = title;
        this.pages = pages;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getPageCount() {
        return pages;
    }

    @Override
    public String toString() {
        return String.format("| %s | %s | %d |", autor, title, pages);
    }
}
