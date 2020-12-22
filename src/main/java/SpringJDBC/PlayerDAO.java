package SpringJDBC;

import javax.sql.DataSource;
import java.util.List;

public interface PlayerDAO {

    void setDataSource (DataSource ds);
    void create (Player player);
    List<Player> listPlayers(int limit);
    void update(Player player);
    String checkPlayerID(String pl_id);
    int definePosition(String pl_id);
    Player player(String id);
}
