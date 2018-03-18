package at.htl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Card")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CA_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="CA_PRE_ID")
    private Presentation presentation;

    @Column(name="CA_PRICE")
    private Long price;

    @Column(name="CA_DATE")
    private Date date;

    public Card(Presentation presentation, Long price, Date date) {
        this.setPresentation(presentation);
        this.setPrice(price);
        this.setDate(date);
    }

    public Card() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
