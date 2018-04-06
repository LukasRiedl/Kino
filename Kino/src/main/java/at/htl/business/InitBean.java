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

        File file = new File("C:\\Users\\Lukas\\Documents\\stuff\\Schule2018\\NVS\\Miniprojekt\\Kino\\Avengers.jpg");
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();

        File file1 = new File("C:\\Users\\Lukas\\Documents\\stuff\\Schule2018\\NVS\\Miniprojekt\\Kino\\panther.jpg");
        byte[] picInBytes1 = new byte[(int) file1.length()];
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        fileInputStream1.read(picInBytes1);
        fileInputStream1.close();


       Movie m = new Movie("Avengers", "100 min", Long.valueOf(16), "Superhero Movie",picInBytes);
        Movie m2 = new Movie("Black Panther", "100 min", Long.valueOf(16), "Superhero Movie",picInBytes1);
       Room room = new Room("Room 1");
        Seat seat = new Seat("Seat 1", room);
        Seat seat2 = new Seat("Seat 2", room);
        Seat seat3 = new Seat("Seat 3", room);
        Presentation presentation = new Presentation(m,room);
        Card card = new Card(presentation, Long.valueOf(10), date);




        entityManager.persist(m);
        entityManager.persist(m2);

        entityManager.persist(room);
        entityManager.persist(seat);
        entityManager.persist(seat2);
        entityManager.persist(seat3);
        entityManager.persist(presentation);
        entityManager.persist(card);
    }
}
