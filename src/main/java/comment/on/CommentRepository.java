package comment.on;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CommentRepository implements PanacheMongoRepositoryBase<Comment, String> {

    public List<Comment> findByRecordId(String recordId) {
        return find("recordId", recordId).list();
    }
}
