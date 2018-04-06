package at.htl.web;

import at.htl.entities.Movie;
import at.htl.facades.MovieFacade;
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



}
