package SpringJDBC;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player> {
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException{
        Player player = new Player();
        player.setPl_id(rs.getString("pl_id"));
        player.setPl_name(rs.getString("pl_name"));
        player.setPl_distance(rs.getInt("pl_distance"));
        player.setPl_clones(rs.getInt("pl_clones"));
        player.setPl_time(rs.getTime("pl_time"));
        player.setPl_score(rs.getInt("pl_score"));
        return player;
    };
}
