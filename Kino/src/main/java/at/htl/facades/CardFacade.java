package at.htl.facades;

import at.htl.entities.Card;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CardFacade {

    @PersistenceContext
    EntityManager em;



    public void save(Card card)
    {
        em.persist(card);
    }
}
