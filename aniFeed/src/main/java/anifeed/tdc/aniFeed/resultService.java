package anifeed.tdc.aniFeed;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class resultService {

    @Autowired
    private resultRepository resultRepository;

    public result updateResult(ObjectId id, result updatedResult) {
        Optional<result> existingResult = resultRepository.findById(id);
        if (existingResult.isPresent()) {
            result existing = existingResult.get();
            existing.setFed(updatedResult.getFed());
            existing.setFilled(updatedResult.getFilled());
            existing.setCovered(updatedResult.getCovered());
            existing.setContributed(updatedResult.getContributed());
            existing.setRegistered(updatedResult.getRegistered());
            existing.setShared(updatedResult.getShared());

            return resultRepository.save(existing);  // Save updated result
        }
        return null;  // Return null if result not found
    }
    // resultService.java

    public result getResult(ObjectId id) {
        Optional<result> existingResult = resultRepository.findById(id);
        return existingResult.orElse(null);  // Return the result if found, or null if not
    }

}
