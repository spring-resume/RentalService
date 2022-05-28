package pl.edu.pjwstk.rentalservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.rentalservice.model.Movie;
import pl.edu.pjwstk.rentalservice.service.RentalService;

@RestController
public class RentalController {
    private final RentalService rentalService;


    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/get-movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.findMovie(id));
    }

    @PutMapping("/rent-movie/{id}")
    public ResponseEntity<Void> rentMovie(@PathVariable Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/return-movie/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(rentalService.createMovie(movie));
    }


}
