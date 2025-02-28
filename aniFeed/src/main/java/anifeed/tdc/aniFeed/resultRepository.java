package anifeed.tdc.aniFeed;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface resultRepository extends MongoRepository<result, ObjectId> {
    // No need for custom findById method, MongoRepository already provides it
}
