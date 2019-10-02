import java.sql.SQLException;
import java.util.List;

public class FirstQuery extends Connect {
    Variables variables = new Variables();
    public List query() throws SQLException {
        return super.query(variables.selectFirst);
    }
}
