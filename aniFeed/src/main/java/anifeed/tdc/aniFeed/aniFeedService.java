package anifeed.tdc.aniFeed;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class aniFeedService {

    @Autowired
    private aniFeedRepository aniFeedRepository;

    public List<aniFeed> allUsers() {
        return aniFeedRepository.findAll();
    }

    public aniFeed addUser(aniFeed newUser) {
        return aniFeedRepository.save(newUser);
    }

    public aniFeed updateUser(ObjectId id, aniFeed updatedUser) {
        Optional<aniFeed> existingUser = aniFeedRepository.findById(id);
        if (existingUser.isPresent()) {
            aniFeed userToUpdate = existingUser.get();
            userToUpdate.setUserName(updatedUser.getUserName());
            userToUpdate.setContactNumber(updatedUser.getContactNumber());
            userToUpdate.setAddress(updatedUser.getAddress());
            userToUpdate.setStartTime(updatedUser.getStartTime());
            userToUpdate.setEndTime(updatedUser.getEndTime());
            return aniFeedRepository.save(userToUpdate);
        }
        return null;  // Return null if user not found
    }

    public boolean deleteUser(ObjectId id) {
        if (aniFeedRepository.existsById(id)) {
            aniFeedRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
