import br.com.ifrs.model.Channel;
import br.com.ifrs.model.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/channel")
@Transactional
public class ChannelWS {
    @GET
    @Path("/save/{hash}")
    @Produces(MediaType.APPLICATION_JSON)
    public Channel save(@PathParam("hash") String hash) {
        Channel channel = new Channel();
        channel.setHash(hash);
        channel.persist();
        return channel;
    }

    @GET
    @Path("/add/{idChannel}/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public User add(@PathParam("idChannel") Long idChannel, @PathParam("idUser") Long idUser) {

        Channel channel = Channel.findById(idChannel);
        if (channel == null)
            throw new BadRequestException("Channel not found");

        User user = User.findById(idUser);
        if (user == null)
            throw new BadRequestException("User not found");

        channel.getUsers().size();
        channel.addUser(user);
        user.addChannel(channel);

        channel.persist();
        user.persist();

        return user;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Channel> list() {
        return Channel.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listMembers(@PathParam("id") Long id) {
        Channel channel = Channel.findById(id);
        if (channel == null)
            throw new NotFoundException("Channel not found");

        List<User> users = channel.getUsers();
        return users;
    }
}
