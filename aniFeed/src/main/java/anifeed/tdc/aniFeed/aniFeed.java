package anifeed.tdc.aniFeed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registeration")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class aniFeed {

    @Id
    private ObjectId id;

    private String userName;

    private String contactNumber;

    private String address;

    private String startTime;
    private String endTime;

}
