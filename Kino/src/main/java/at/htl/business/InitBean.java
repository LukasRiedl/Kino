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

        URL classesRootDir = getClass().getProtectionDomain().getCodeSource().getLocation();


        String path = classesRootDir.toString();

        String[] help = path.split("/target");

        String help2 = help[0];

        String finalPath = help2.substring(5);

        String Uhrzeit = "18 Uhr";

        File file = new File(finalPath + "/Avengers.jpg");
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();

        File file1 = new File(finalPath + "/panther.jpg");
        byte[] picInBytes1 = new byte[(int) file1.length()];
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        fileInputStream1.read(picInBytes1);
        fileInputStream1.close();

        File bienemaja = new File(finalPath + "/bienemaja2.jpg");
        byte[] picInBytes2 = new byte[(int) bienemaja.length()];
        FileInputStream fileInputStream2 = new FileInputStream(bienemaja);
        fileInputStream2.read(picInBytes2);
        fileInputStream2.close();

        File deathwish = new File(finalPath + "/deathwish.jpg");
        byte[] picInBytes3 = new byte[(int) deathwish.length()];
        FileInputStream fileInputStream3 = new FileInputStream(deathwish);
        fileInputStream3.read(picInBytes3);
        fileInputStream3.close();

        File verlegerin = new File(finalPath + "/DieVerlegerin.jpg");
        byte[] picInBytes4 = new byte[(int) verlegerin.length()];
        FileInputStream fileInputStream4 = new FileInputStream(verlegerin);
        fileInputStream4.read(picInBytes4);
        fileInputStream4.close();

        File quietPlace = new File(finalPath + "/quietPlace.jpeg");
        byte[] picInBytes5 = new byte[(int) quietPlace.length()];
        FileInputStream fileInputStream5 = new FileInputStream(quietPlace);
        fileInputStream5.read(picInBytes5);
        fileInputStream5.close();




       Movie m = new Movie("Avengers 3: Infinity War", "100 min", Long.valueOf(12), "Nachdem die Avengers es bereits mit Loki," +
               " den Chitauri und Ultron aufgenommen haben, folgt in Avengers 3: Infinity War der epische Kampf gegen Thanos.",picInBytes);
        Movie m2 = new Movie("Black Panther", "100 min", Long.valueOf(12), "T'Challa a.k.a Black Panther" +
                " kehrt zurück in seine afrikanische Heimat Wakanda. Er bereitet sich darauf vor, seinen rechtmäßigen Platz als" +
                " König des isolierten, aber technologisch höchst fortschrittenen Staates einzunehmen.",picInBytes1);
        Movie m3 = new Movie("Biene Maja 2", "100 min", Long.valueOf(6), "Heller Aufruhr im Bienenstock: " +
                "Ein Gesandter der Kaiserin hat den weiten Weg von Summtropolis auf sich genommen, um den Bienen" +
                " eine Nachricht zu überbringen. Ob diesmal ihr Traum in Erfüllung geht?",picInBytes2);
        Movie m4 = new Movie("Death Wish", "100 min", Long.valueOf(16), "Der Chirurg Dr. Paul Kersey erlebt" +
                " die Folgen der Gewalt auf den Straßen Chicagos – bis seine Frau und seine Tochter in " +
                "den eigenen vier Wänden brutal attackiert werden. Paul beschließt kurzerhand  das Gesetz selbst in die Hand zu nehmen",picInBytes3);
        Movie m5 = new Movie("Die Verlegerin", "100 min", Long.valueOf(12), "In den 1970er Jahren übernimmt Kay Graham das Unternehmen" +
                " ihrer Familie – die Washington Post – und wird so zur ersten Zeitungsverlegerin der USA.",picInBytes4);
        Movie m6 = new Movie("A quiet Place", "100 min", Long.valueOf(18), "Die Welt ist von rätselhaften," +
                " scheinbar unverwundbaren Kreaturen eingenommen worden, die durch jedes noch so kleine Geräusch angelockt werden" +
                " und sich auf die Jagd begeben…",picInBytes5);

        Room room = new Room("Saal 1");
        Room room1 = new Room("Saal 2");
        Room room2 = new Room("Saal 3");
        Room room3 = new Room("Saal 4");
        Room room4 = new Room("Saal 5");
        Room room5 = new Room("Saal 6");

        Seat seat = new Seat("Platz 1", room);
        Seat seat2 = new Seat("Platz 2", room);
        Seat seat3 = new Seat("Platz 3", room);
        Seat seat4 = new Seat("Platz 1", room1);
        Seat seat5 = new Seat("Platz 2", room1);
        Seat seat6 = new Seat("Platz 3", room1);
        Seat seat7 = new Seat("Platz 1", room2);
        Seat seat8 = new Seat("Platz 2", room2);
        Seat seat9 = new Seat("Platz 3", room2);
        Seat seat10 = new Seat("Platz 1", room3);
        Seat seat11 = new Seat("Platz 2", room3);
        Seat seat12 = new Seat("Platz 3", room3);
        Seat seat13 = new Seat("Platz 1", room4);
        Seat seat14 = new Seat("Platz 2", room4);
        Seat seat15 = new Seat("Platz 3", room4);
        Seat seat16 = new Seat("Platz 1", room5);
        Seat seat17 = new Seat("Platz 2", room5);
        Seat seat18 = new Seat("Platz 3", room5);

        Presentation presentation = new Presentation(m,room,Uhrzeit);
        Presentation presentation2 = new Presentation(m,room,"20 Uhr");
        Presentation presentation3 = new Presentation(m2,room1,"16 Uhr");
        Presentation presentation4 = new Presentation(m2,room1,"19 Uhr");
        Presentation presentation5 = new Presentation(m3,room2,"18 Uhr");
        Presentation presentation6 = new Presentation(m3,room2,"21 Uhr");
        Presentation presentation7 = new Presentation(m4,room3,"14 Uhr");
        Presentation presentation8 = new Presentation(m4,room3,"18 Uhr");
        Presentation presentation9 = new Presentation(m5,room4,"15 Uhr");
        Presentation presentation10 = new Presentation(m5,room4,"20 Uhr");
        Presentation presentation11 = new Presentation(m6,room5,"18 Uhr");
        Presentation presentation12 = new Presentation(m6,room5,"21 Uhr");




        entityManager.persist(m);
        entityManager.persist(m2);
        entityManager.persist(m3);
        entityManager.persist(m4);
        entityManager.persist(m5);
        entityManager.persist(m6);
        entityManager.persist(room);
        entityManager.persist(room1);
        entityManager.persist(room2);
        entityManager.persist(room3);
        entityManager.persist(room4);
        entityManager.persist(room5);

        entityManager.persist(seat);
        entityManager.persist(seat2);
        entityManager.persist(seat3);
        entityManager.persist(seat4);
        entityManager.persist(seat5);
        entityManager.persist(seat6);
        entityManager.persist(seat7);
        entityManager.persist(seat8);
        entityManager.persist(seat9);
        entityManager.persist(seat10);
        entityManager.persist(seat11);
        entityManager.persist(seat12);
        entityManager.persist(seat13);
        entityManager.persist(seat14);
        entityManager.persist(seat15);
        entityManager.persist(seat16);
        entityManager.persist(seat17);
        entityManager.persist(seat18);

        entityManager.persist(presentation);
        entityManager.persist(presentation2);
        entityManager.persist(presentation3);
        entityManager.persist(presentation4);
        entityManager.persist(presentation5);
        entityManager.persist(presentation6);
        entityManager.persist(presentation7);
        entityManager.persist(presentation8);
        entityManager.persist(presentation9);
        entityManager.persist(presentation10);
        entityManager.persist(presentation11);
        entityManager.persist(presentation12);

    }
}
