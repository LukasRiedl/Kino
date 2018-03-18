package at.htl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Room")
public class Room implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROO_ID")
    private Long id;

    @Column(name="ROO_NAME")
    private String name;



    public Room(String name) {
        this.setName(name);
    }

    public Room() {
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

   }
