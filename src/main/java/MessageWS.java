import br.com.ifrs.model.Message;
import br.com.ifrs.model.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/message")
@Transactional
public class MessageWS {
    @GET
    @Path("/save/{text}/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message save(@PathParam("text") String text, @PathParam("idUser") Long idUser) {

        Message message = new Message();
        message.setText(text);
        message.persistAndFlush();

        User user = User.findById(idUser);
        if (user == null)
            throw new BadRequestException("User not found");

        user.addMessage(message);
        user.persistAndFlush();

        return message;
    }
}
