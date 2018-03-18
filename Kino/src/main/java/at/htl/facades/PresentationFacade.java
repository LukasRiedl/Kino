package at.htl.facades;

import at.htl.entities.Presentation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PresentationFacade {

    @PersistenceContext
    EntityManager em;



    public void save(Presentation presentation)
    {
        em.persist(presentation);
    }
}
