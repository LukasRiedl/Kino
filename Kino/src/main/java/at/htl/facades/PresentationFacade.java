package at.htl.facades;

import at.htl.entities.Presentation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PresentationFacade {

    @PersistenceContext
    EntityManager em;



    public void save(Presentation presentation)
    {
        em.persist(presentation);
    }

    public List<Presentation> getPresentationsByMovie(int id)
    {
        Query q = em.createQuery("select s from Presentation s where s.movie.id = :id")
                .setParameter("id",Long.valueOf(id));

        return q.getResultList();
    }

    public Presentation getPresentation(String x)
    {
        if(x!= null  && x.contains("Saal")) {
            String[] help = x.split(" ");
            Query q = em.createQuery("select s from Presentation s where  s.id = :id").setParameter("id", Long.valueOf(help[0]));


            return (Presentation) q.getResultList().get(0);
        }

        return null;
    }

}
