package at.htl.facades;

import at.htl.entities.Movie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MovieFacade {

    @PersistenceContext
    EntityManager em;



    public void save(Movie movie)
    {
        em.persist(movie);
    }
}
