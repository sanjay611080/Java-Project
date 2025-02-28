package anifeed.tdc.aniFeed;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class location {

    @Id
    private ObjectId id;

    private String location;
    private String animalType;
    private String time;
}
