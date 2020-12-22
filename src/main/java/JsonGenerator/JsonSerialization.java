package JsonGenerator;

import SpringJDBC.Player;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class JsonSerialization {
    final ObjectMapper mapper = new ObjectMapper();

    public String writeObjectArrayToString(List<Player> player) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out, player);
        return out.toString();
    }

    public List<Player> getPlayersFromJson(String jsonString) throws IOException{
        List<Player> players= mapper.readValue(jsonString, new TypeReference<List<Player>>(){});
        return players;
    }
    public Player getPlayerFromJson(String jsonString) throws IOException{
            Player player = mapper.readValue(jsonString, Player.class);
            return player;
    }
}
