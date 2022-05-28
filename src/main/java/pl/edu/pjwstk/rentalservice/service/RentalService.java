package pl.edu.pjwstk.rentalservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.rentalservice.model.Movie;

@Service
public class RentalService {
    private final RestTemplate restTemplate;
    private final String movieServicePath;

    public RentalService(RestTemplate restTemplate, @Value("${movie.service.path}") String movieServicePath) {
        this.restTemplate = restTemplate;
        this.movieServicePath = movieServicePath;
    }

    public Movie findMovie(Long id) {
        String url= movieServicePath+"/movie/"+id;
        return restTemplate.getForObject(url, Movie.class);
    }

    public void rentMovie(Long id) {
        String url=movieServicePath+"/rent/"+id;
        restTemplate.put(url,null);
    }

    public void returnMovie(Long id) {
        String url=movieServicePath+"/return/"+id;
        restTemplate.put(url,null);
    }

    public Movie createMovie(Movie movie) {
        movie.setId(null);
        String url= movieServicePath+"/movie";
        return restTemplate.postForEntity(url,movie,Movie.class).getBody();
    }
}
