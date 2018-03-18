package at.htl.business;

import at.htl.entities.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;


@Startup
@Singleton
public class InitBean {

    @PersistenceContext
    EntityManager entityManager;

    public InitBean() {
    }

    @PostConstruct
    public void init()
    {
        Movie m = new Movie("Avengers", "100 min", Long.valueOf(16), "Superhero Movie");
        Room room = new Room("Room 1");
        Seat seat = new Seat("Seat 1", room);
        Seat seat2 = new Seat("Seat 2", room);
        Seat seat3 = new Seat("Seat 3", room);
        Presentation presentation = new Presentation(m,room);
        Card card = new Card(presentation, Long.valueOf(10), Date.valueOf("18.03.2018"));




        entityManager.persist(m);
        entityManager.persist(room);
        entityManager.persist(seat);
        entityManager.persist(seat2);
        entityManager.persist(seat3);
        entityManager.persist(presentation);
        entityManager.persist(card);
    }
}
