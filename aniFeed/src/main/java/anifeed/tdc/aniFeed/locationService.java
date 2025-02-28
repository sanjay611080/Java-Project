package anifeed.tdc.aniFeed;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class locationService {

    @Autowired
    private locationRepository locationRepository;

    public List<location> allLocations() {
        return locationRepository.findAll();
    }

    public location addLocation(location newLocation) {
        return locationRepository.save(newLocation);
    }

    public location updateLocation(ObjectId id, location updatedLocation) {
        Optional<location> existingLocation = locationRepository.findById(id);
        if (existingLocation.isPresent()) {
            location locationToUpdate = existingLocation.get();
            locationToUpdate.setLocation(updatedLocation.getLocation());
            locationToUpdate.setAnimalType(updatedLocation.getAnimalType());
            locationToUpdate.setTime(updatedLocation.getTime());
            return locationRepository.save(locationToUpdate);
        }
        return null;  // Return null if the location doesn't exist
    }

    public boolean deleteLocation(ObjectId id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
            return true;
        }
        return false;  // Return false if the location does not exist
    }
}
