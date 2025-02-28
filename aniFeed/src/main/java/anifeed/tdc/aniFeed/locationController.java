package anifeed.tdc.aniFeed;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class locationController {

    @Autowired
    private locationService locationService;

    @GetMapping
    public ResponseEntity<List<location>> getAllLocations() {
        return new ResponseEntity<>(locationService.allLocations(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<location> addLocation(@RequestBody location newLocation) {
        location createdLocation = locationService.addLocation(newLocation);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<location> updateLocation(@PathVariable ObjectId id, @RequestBody location updatedLocation) {
        location updated = locationService.updateLocation(id, updatedLocation);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // If location not found
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable ObjectId id) {
        boolean isDeleted = locationService.deleteLocation(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // If location not found
    }
}
