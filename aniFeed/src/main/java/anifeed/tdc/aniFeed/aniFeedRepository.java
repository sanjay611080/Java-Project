package anifeed.tdc.aniFeed;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface aniFeedRepository extends MongoRepository<aniFeed, ObjectId> {
}
