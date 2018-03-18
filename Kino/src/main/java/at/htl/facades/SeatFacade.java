package at.htl.facades;

import at.htl.entities.Seat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SeatFacade {

    @PersistenceContext
    EntityManager em;



    public void save(Seat seat)
    {
        em.persist(seat);
    }
}
