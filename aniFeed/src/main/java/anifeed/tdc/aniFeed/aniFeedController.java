package anifeed.tdc.aniFeed;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ani")
public class aniFeedController {

    @Autowired
    private aniFeedService aniFeedService;

    @GetMapping
    public ResponseEntity<List<aniFeed>> getAllUsers() {
        return new ResponseEntity<>(aniFeedService.allUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<aniFeed> addUser(@RequestBody aniFeed newUser) {
        aniFeed createdUser = aniFeedService.addUser(newUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<aniFeed> updateUser(@PathVariable ObjectId id, @RequestBody aniFeed updatedUser) {
        aniFeed updated = aniFeedService.updateUser(id, updatedUser);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ObjectId id) {
        boolean isDeleted = aniFeedService.deleteUser(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
