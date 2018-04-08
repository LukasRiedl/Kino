package at.htl.facades;

import at.htl.entities.Card;
import at.htl.entities.Seat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class SeatFacade {

    @PersistenceContext
    EntityManager em;



    public void save(Seat seat)
    {
        em.persist(seat);
    }

    public List<Seat> getSeatsByPre(long id, String time)
    {
        Query q = em.createQuery("select s from Seat s where s.room.id" +
                " = :room").setParameter("room", id);

        Query query = em.createQuery("select s from Card s where s.presentation.room.id = :room and s.presentation.time = :time")
                .setParameter("room",id).setParameter("time", time);

        List<Card> cards = query.getResultList();

        List<Seat> seats = q.getResultList();

        List<Seat> help = new LinkedList<>();
        int i = 0;
        for ( Card card: cards) {


            for(Seat seat : seats) {

                if (seat.getName().equals(card.getSeat())) {
                    help.add(seat);
                }

            }
            i++;
        }

        seats.removeAll(help);
        return seats;
    }

    public Seat getSeat(String x)
    {
        if(x != null && x.contains("Platz")) {
            String[] help = x.split(" ");
            Query q = em.createQuery("select s from Seat s where  s.id = :id").setParameter("id", Long.valueOf(help[0]));

            return (Seat) q.getResultList().get(0);
        }
        return null;
    }
}
