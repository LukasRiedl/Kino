package at.htl.facades;

import at.htl.entities.Room;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoomFacade {

    @PersistenceContext
    EntityManager em;



    public void save(Room room)
    {
        em.persist(room);
    }
}
