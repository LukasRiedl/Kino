package at.htl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Presentation")
public class Presentation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRE_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRE_MOV_ID")
    private Movie movie;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRE_ROO_ID")
    private Room room;

    @Column(name="PRE_TIME")
    private String time;



    public Presentation(Movie movie, Room room, String time) {
        this.setMovie(movie);
        this.setRoom(room);
        this.setTime(time);
    }

    public Presentation() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String  time) {
        this.time = time;
    }
}
