package at.htl.web;

import at.htl.entities.Card;
import at.htl.entities.Movie;
import at.htl.entities.Presentation;
import at.htl.entities.Seat;
import at.htl.facades.CardFacade;
import at.htl.facades.MovieFacade;
import at.htl.facades.PresentationFacade;
import at.htl.facades.SeatFacade;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SessionScoped
@Named
public class IndexController implements Serializable{

    @Inject
    MovieFacade movieFacade;

    @Inject
    SeatFacade seatFacade;

    @Inject
    PresentationFacade presentationFacade;

    @Inject
    CardFacade cardFacade;

    private int selectedMovieId;

    private Card card;
    private String selectedStringSeat;
    private String selectedStringPresentation;
    private Seat selectedSeat;
    private Presentation selectedPresentation;

    public StreamedContent getImage()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        }
        else {
            String movieId = context.getExternalContext().getRequestParameterMap().get("pid");
            List<Movie> movieList = movieFacade.getAllMovies();
            InputStream is = new ByteArrayInputStream((byte[]) movieList.get(Integer.valueOf(movieId)-1).getMoviePic());

            return  new DefaultStreamedContent(is, "image/jpg");
        }


    }

    public List<Movie> getMovies()
    {
        return movieFacade.getAllMovies();
    }

    public void reservateCards(int id)
    {
        this.selectedMovieId = id;
    }

    public int getSelectedMovieId() {
        return selectedMovieId;
    }

    public void setSelectedMovieId(int selectedMovieId) {
        this.selectedMovieId = selectedMovieId;
    }

    public Movie getSelectedMovie()
    {
       return movieFacade.getMovieById(selectedMovieId);
    }

    public Seat getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(Seat selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    public List<String> getSeats()
    {

        List<String> list = new LinkedList<>();
        if(selectedPresentation != null) {
            for (Seat seat : seatFacade.getSeatsByPre(selectedPresentation.getRoom().getId(), selectedPresentation.getTime())) {
                list.add(seat.getId() + " " + seat.getName());
            }
        }

        return list;
    }

    public List<String> getPresentations()
    {
        List<String> list = new LinkedList<>();
        for (Presentation pre : presentationFacade.getPresentationsByMovie(selectedMovieId)) {
            list.add(pre.getId() + " Saal: " + pre.getRoom().getName() +" Uhrzeit: "+  pre.getTime());
        }
       return list;
    }

    public Presentation getSelectedPresentation() {
        return selectedPresentation;
    }

    public void setSelectedPresentation(Presentation presentation) {


        this.selectedPresentation = presentation;
    }

    public String getSelectedStringPresentation() {
        return selectedStringPresentation;
    }

    public void setSelectedStringPresentation(String selectedStringPresentation) {

        this.selectedStringPresentation = selectedStringPresentation;
        selectedPresentation = presentationFacade.getPresentation(selectedStringPresentation);


    }

    public void stateChangeListener() {
        getSeats();
    }

    public void printCard()
    {
        if(selectedPresentation != null) {
            Card c = new Card(selectedPresentation, Long.valueOf(10), selectedSeat.getName());
            setCard(c);
            cardFacade.save(c);
        }
    }

    public String getSelectedStringSeat() {
        return selectedStringSeat;
    }

    public void setSelectedStringSeat(String selectedStringSeat) {
        this.selectedStringSeat = selectedStringSeat;
       selectedSeat =  seatFacade.getSeat(selectedStringSeat);

    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setSelectionNull()
    {
        this.selectedSeat = null;
        this.selectedPresentation = null;
        this.selectedStringPresentation="";
        this.selectedStringSeat="";
    }
}
