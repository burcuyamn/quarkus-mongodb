package comment.on;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/comment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Inject
    CommentService service;

    @GET
    @Path("/{id}")
    public Response comments(@PathParam("id") String id) {
        return Response.ok(service.getCommentsByRecordId(id)).build();
    }

    @POST
    public Response save(@Valid Comment comment) {
        service.save(comment);
        return Response.ok().build();
    }
}
