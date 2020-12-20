package comment.on;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.Date;
import java.util.List;

@ApplicationScoped
public class CommentService {

    @Inject
    CommentRepository commentRepository;

    public void save(Comment comment){
        comment.setDate(new Date());
        commentRepository.persist(comment);
    }

    public List<Comment> getCommentsByRecordId(String recordId){
        return commentRepository.findByRecordId(recordId);
    }
}
