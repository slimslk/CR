package SpringJDBC;

import JsonGenerator.JsonSerialization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class PlayerQuery {
    //For using AWS Database change config file to BeanAWS.xml
    ApplicationContext appCntx = new ClassPathXmlApplicationContext("Bean.xml");
    PlayerJDBCTemplate playerJdbcTemplate = (PlayerJDBCTemplate)appCntx.getBean("PlayerJDBCTemplate");

    public String getPlayerListJson(int limit) throws IOException {
        List<Player> playerList = players(limit);
        JsonSerialization jsonSerialization = new JsonSerialization();
        return jsonSerialization.writeObjectArrayToString(playerList);
    }
    public String addPlayerToDB(String playerJson) throws IOException{
        JsonSerialization jsonSerialization = new JsonSerialization();
        Player player = jsonSerialization.getPlayerFromJson(playerJson);
        writeData(player);
        return Integer.toString(position(player));
    }
    private List<Player> players(int limit){
        return playerJdbcTemplate.listPlayers(limit);
    }
    private void writeData (Player player){
        if(playerJdbcTemplate.checkPlayerID(player.getPl_id())!=null){
            boolean check = playerJdbcTemplate.isScoreSmaller(player.getPl_id(),player.getPl_score());
            if (check){
                playerJdbcTemplate.update(player);
            }else {
                System.out.println("The score is bigger in a DB");
            }
        }else{
            playerJdbcTemplate.create(player);
        }
    }
    private int position(Player player){
        return playerJdbcTemplate.definePosition(player.getPl_id());
    }
    private Player getPlayer(String id){
        return playerJdbcTemplate.player(id);
    }

}
