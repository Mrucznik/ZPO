package Przyklad4_JPA;

import java.util.List;

import javax.persistence.*;

import testJPA.Notatka;

public class Main6 {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Notatki");
	    EntityManager em = factory.createEntityManager();
	// czytamy zawartoœæ tabeli
	    Query q = em.createQuery("select t from Notatka t");
	    List<Notatka> todoList = q.getResultList();
	    for (Notatka todo : todoList)  {
	      System.out.println(todo);
	    }
	    System.out.println("Size: " + todoList.size());
	// tworzymy notatkê
	    em.getTransaction().begin();
	    Notatka todo = new Notatka();
	    todo.setTytul("Zakupy");
	    todo.setOpis("Kupiæ karpia w Carfour");
	    em.persist(todo);
	    em.getTransaction().commit();
	    em.close();
	  }
}
