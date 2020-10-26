package comment.on.sahibinden;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CommentService {

    @Inject
    MongoClient mongoClient;

    public void add(Comment comment){
        Document document = new Document()
                .append("text", comment.getText())
                .append("date", comment.getDate());
        getCollection().insertOne(document);
    }

    public List<Comment> list(){
        List<Comment> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Comment comment = new Comment();
                comment.setText(document.getString("text"));
                list.add(comment);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("meteor").getCollection("comments");
    }
}
