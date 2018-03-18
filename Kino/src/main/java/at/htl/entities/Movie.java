package at.htl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MOV_ID")
    private Long id;

    @Column(name="MOV_NAME")
    private String name;

    @Column(name="MOV_LENGTH")
    private String length;

    @Column(name="MOV_FSK")
    private Long fsk;

    @Column(name="MOV_DESCRIPTION")
    private String description;



    public Movie(String name, String length, Long fsk, String description) {
        this.setName(name);
        this.setLength(length);
        this.setFsk(fsk);
        this.setDescription(description);
    }

    public Movie() {
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Long getFsk() {
        return fsk;
    }

    public void setFsk(Long fsk) {
        this.fsk = fsk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
