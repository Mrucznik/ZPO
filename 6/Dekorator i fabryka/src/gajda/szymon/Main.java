package gajda.szymon;

public class Main {

    public static void main(String[] args) {

        //Zadanie 1.
        try {
            Publikacja k1 = new Ksiazka("Adam Mickiewicz", "Pan Tadeusz", 340);
            Publikacja k2 = new Ksiazka("Adam Mickiewicz", "Dziady", 130);

            Publikacja kk1 = new KsiazkaZOkladkaZwykla(k1);
            Publikacja kk2 = new KsiazkaZOkladkaTwarda(k2);

            // Publikacja fakeBook = new KsiazkaZObwoluta(k1);  // wyjątek! Nie można obłożyć obwolutą książki, która nie posiada okładki

            Publikacja kkk2 = new KsiazkaZObwoluta(kk2); // a tu OK

            // Publikacja odrzut = new KsiazkaZObwoluta(kkk2);  // wyjątek! Obwoluta może być jedna
            Publikacja dziadyZAutografemWieszcza = new KsiazkaZAutografem(kk2, "Drogiej Hani - Adam Mickiewicz");
            System.out.println(dziadyZAutografemWieszcza);
            // wypisuje: | Adam Mickiewicz | Dziady    |  130 | Okładka twarda | Drogiej Hani - Adam Mickiewicz |

            Publikacja dziadyZDwomaAutografami = new KsiazkaZAutografem(   dziadyZAutografemWieszcza, "Haniu, to nieprawda, Dziady napisałem ja, Julek Słowacki!");   // wyjątek! Autograf może być tylko jeden

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Zadanie 2.
        Wydawnictwo w = Wydawnictwo.getInstance("Józef Ignacy Kraszewski"); /* W zależności od autora wybieramy odpowiednie wydawnictwo. Wpisać kilka wariantów. Tu powstanie wydawnictwo powieści historycznych */
        Ksiazka k = w.createBook("Masław", 280);   /* Tworzy książkę klasy PowiescHistoryczna z podanym tytułem i liczbą stron. Autor przekazany będzie z wydawnictwa */
        System.out.println(k);
        System.out.println( Wydawnictwo.getInstance("Poemaciarz").createBook("Poemat 1", 567) );
        System.out.println( Wydawnictwo.getInstance("Thrilleropisarz").createBook("Thriller 1", 345) );
    }
}
