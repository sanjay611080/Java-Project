package anifeed.tdc.aniFeed;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/result")
public class resultController {

    @Autowired
    private resultService resultService;

    // resultController.java

    @GetMapping("/{id}")
    public ResponseEntity<result> getResult(@PathVariable ObjectId id) {
        result fetchedResult = resultService.getResult(id);
        if (fetchedResult != null) {
            return new ResponseEntity<>(fetchedResult, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // If result with ID not found
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<result> updateResult(@PathVariable ObjectId id, @RequestBody result updatedResult) {
        result updated = resultService.updateResult(id, updatedResult);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // If result with ID not found
    }
}
