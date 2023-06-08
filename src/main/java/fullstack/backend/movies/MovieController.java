package fullstack.backend.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
//    @GetMapping
//    public ResponseEntity<String> getallMovies(){
//        //can use curl in terminal to check whether the connection is 200 means ok
//        //curl -i http://localhost:8080/api/v1/movies
//        return new ResponseEntity<String>("All Movies!", HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Movie>> getallMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
