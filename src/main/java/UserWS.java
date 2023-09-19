import br.com.ifrs.model.Channel;
import br.com.ifrs.model.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/user")
@Transactional
// 1 - Podemos delegar o controle de transação utilizando a anotação
// @Transactional nos métodos ou no nível da classe.
public class UserWS {

    @GET
    @Path("/save/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User save(@PathParam("name") String name) {
        User user = new User();
        user.setName(name);
        // 2 - O método do Panache `persist` possibilita persistir um objeto.
        user.persist();
        return user;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<User> list() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return User.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public User list(@PathParam("id") Long id) {
        // 4 - O método do Panache `findById` recupera um objeto da classe User.
        return User.findById(id);
    }

    @GET
    @Path("/list/{id}/channels")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Channel> listChannels(@PathParam("id") Long id) {
        User user = User.findById(id);
        if (user == null)
            throw new NotFoundException("User not found");

        user.getChannels().size();

        List<Channel> channels = user.getChannels();
        return channels;
    }
}
