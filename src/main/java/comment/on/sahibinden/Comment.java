package comment.on.sahibinden;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@MongoEntity(collection = "comments")
public class Comment extends ReactivePanacheMongoEntity implements Serializable {
    private String id;
    private String text;
    private Date date;
}
