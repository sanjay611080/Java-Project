package anifeed.tdc.aniFeed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class result {

    @Id
    private ObjectId id;
    private Integer fed;
    private Integer filled;
    private Integer covered;
    private Integer contributed;
    private Integer registered;
    private Integer shared;
}
