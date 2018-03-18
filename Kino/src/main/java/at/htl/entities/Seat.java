package at.htl.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Seat")
public class Seat implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEA_ID")
    private Long id;

    @Column(name = "SEA_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "SEA_ROO_ID")
    private Room room;

    public Seat(String name, Room room) {
        this.name = name;
        this.setRoom(room);
    }

    public Seat() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
