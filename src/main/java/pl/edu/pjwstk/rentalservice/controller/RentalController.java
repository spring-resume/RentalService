package pl.edu.pjwstk.rentalservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "Find movie by provided id")
    @GetMapping("/get-movie/{id}")
    public ResponseEntity<Movie> getMovie(@ApiParam(value = "unique id of movie") @PathVariable Long id) {
        return ResponseEntity.ok(rentalService.findMovie(id));
    }

    @ApiOperation(value = "Rent movie by id", notes = "provide information about movie by id")
    @PutMapping("/rent-movie/{id}")
    public ResponseEntity<Movie> rentMovie(@ApiParam(value = "unique id of movie") @PathVariable Long id) {
        return ResponseEntity.ok(rentalService.rentMovie(id));
    }

    @ApiOperation(value = "Return movie by id", notes = "provide information about movie by id")
    @PutMapping("/return-movie/{id}")
    public ResponseEntity<Movie> returnMovie(@ApiParam(value = "unique id of movie") @PathVariable Long id) {
        return ResponseEntity.ok(rentalService.returnMovie(id));
    }

    @ApiOperation(value = "Add movie", notes = "provide movie by json")
    @PostMapping("/add-movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(rentalService.createMovie(movie));
    }


}
