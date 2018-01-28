package gajda.szymon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Pracownicy");
        em = factory.createEntityManager();

        initDatabase();
        getWorkersSortedBy("nazwisko");
        getPlaceWgKraju();

        em.close();
    }

    public static void initDatabase()
    {
        em.getTransaction().begin();
        em.persist(new Pracownik("Jan", "Kowalski", "PL", 35000));
        em.persist(new Pracownik("Jiri", "Prohazka", "CZ", 28000));
        em.persist(new Pracownik("Anna", "Malinowska", "PL", 52000));
        em.persist(new Pracownik("Jan", "Kowalski", "PL", 49999));
        em.persist(new Pracownik("Jan", "Kowalski", "PL", 45000));
        em.persist(new Pracownik("Jan", "Kowalski", "PL", 45000));
        em.persist(new Pracownik("Jan", "Kowalski", "PL", 74000));
        em.persist(new Pracownik("Jan", "Kowalski", "PL", 9400));
        em.persist(new Pracownik("Jan", "Kowalski", "PL", 83000));
        em.persist(new Pracownik("Jan", "Kowalski", "PL", 32000));
        em.getTransaction().commit();
    }

    public static void getWorkersSortedBy(String column)
    {
        Query q = em.createQuery("SELECT p FROM Pracownik p ORDER BY p."+column+" ASC");
        q.getResultList().forEach(System.out::println);
    }

    public static void getPlaceWgKraju()
    {
        Query q = em.createQuery("SELECT p.narodowosc, p.wyplata FROM Pracownik p GROUP BY p.narodowosc");
        System.out.println(q.getSingleResult());
    }
}
