package at.htl.business;

import at.htl.entities.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Startup
@Singleton
public class InitBean {

    @PersistenceContext
    EntityManager entityManager;

    public InitBean() {
    }

    @PostConstruct
    public void init() throws ParseException, IOException {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        File file = new File("C:\\Users\\Lukas\\Desktop\\Kino\\Kino\\Avengers.jpg");
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();

        File file1 = new File("C:\\Users\\Lukas\\Desktop\\Kino\\Kino\\panther.jpg");
        byte[] picInBytes1 = new byte[(int) file1.length()];
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        fileInputStream1.read(picInBytes1);
        fileInputStream1.close();

        File bienemaja = new File("C:\\Users\\Lukas\\Desktop\\Kino\\Kino\\bienemaja2.jpg");
        byte[] picInBytes2 = new byte[(int) bienemaja.length()];
        FileInputStream fileInputStream2 = new FileInputStream(bienemaja);
        fileInputStream2.read(picInBytes2);
        fileInputStream2.close();

        File deathwish = new File("C:\\Users\\Lukas\\Desktop\\Kino\\Kino\\deathwish.jpg");
        byte[] picInBytes3 = new byte[(int) deathwish.length()];
        FileInputStream fileInputStream3 = new FileInputStream(deathwish);
        fileInputStream3.read(picInBytes3);
        fileInputStream3.close();

        File verlegerin = new File("C:\\Users\\Lukas\\Desktop\\Kino\\Kino\\DieVerlegerin.jpg");
        byte[] picInBytes4 = new byte[(int) verlegerin.length()];
        FileInputStream fileInputStream4 = new FileInputStream(verlegerin);
        fileInputStream4.read(picInBytes4);
        fileInputStream4.close();

        File quietPlace = new File("C:\\Users\\Lukas\\Desktop\\Kino\\Kino\\quietPlace.jpeg");
        byte[] picInBytes5 = new byte[(int) quietPlace.length()];
        FileInputStream fileInputStream5 = new FileInputStream(quietPlace);
        fileInputStream5.read(picInBytes5);
        fileInputStream5.close();




       Movie m = new Movie("Avengers", "100 min", Long.valueOf(16), "Superhero Movie",picInBytes);
        Movie m2 = new Movie("Black Panther", "100 min", Long.valueOf(16), "Superhero Movie",picInBytes1);
        Movie m3 = new Movie("Biene Maja 2", "100 min", Long.valueOf(16), "Child Movie",picInBytes2);
        Movie m4 = new Movie("Death Wish", "100 min", Long.valueOf(16), "Action Movie",picInBytes3);
        Movie m5 = new Movie("Die Verlegerin", "100 min", Long.valueOf(16), "Thriller",picInBytes5);
        Movie m6 = new Movie("A quiet Place", "100 min", Long.valueOf(16), "Horror Movie",picInBytes4);

        Room room = new Room("Room 1");
        Seat seat = new Seat("Seat 1", room);
        Seat seat2 = new Seat("Seat 2", room);
        Seat seat3 = new Seat("Seat 3", room);
        Presentation presentation = new Presentation(m,room);
        Card card = new Card(presentation, Long.valueOf(10), date);




        entityManager.persist(m);
        entityManager.persist(m2);
        entityManager.persist(m3);
        entityManager.persist(m4);
        entityManager.persist(m5);
        entityManager.persist(m6);
        entityManager.persist(room);
        entityManager.persist(seat);
        entityManager.persist(seat2);
        entityManager.persist(seat3);
        entityManager.persist(presentation);
        entityManager.persist(card);
    }
}
