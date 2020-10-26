package comment.on.sahibinden;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@MongoEntity(collection = "comment")
public class Comment extends PanacheMongoEntityBase {
    @BsonId
    private ObjectId id;
    private String recordId;
    private String comment;
    private Date date;
}
