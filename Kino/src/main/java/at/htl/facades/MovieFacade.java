package at.htl.facades;

import at.htl.entities.Movie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MovieFacade {

    @PersistenceContext
    EntityManager em;



    public void save(Movie movie)
    {
        em.persist(movie);
    }

    public List<Movie> getAllMovies()
    {
        Query q = em.createQuery("select s from Movie s");
        return q.getResultList();
    }

    public Movie getMovieById(int id)
    {
        Query q = em.createQuery("select m from Movie m where m.id = :id")
                .setParameter("id", Long.valueOf(id));

        return (Movie) q.getResultList().get(0);
    }
}
