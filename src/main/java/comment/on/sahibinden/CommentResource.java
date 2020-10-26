package comment.on.sahibinden;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Inject CommentService commentService;

    @GET
    public List<Comment> list() {
        return commentService.list();
    }

    @POST
    public List<Comment> add(Comment comment) {
        commentService.add(comment);
        return list();
    }
}
