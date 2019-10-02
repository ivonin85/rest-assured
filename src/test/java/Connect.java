import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Connect {
    Variables variables = new Variables();
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final static String DBNAME = "urait_mssql";
    private final static String URLFIXED =
            "jdbc:mysql://10.4.0.41:3306/" + DBNAME + "?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "";
    private final static String PASSWORD = "";
    private static Statement statement;
    private static ResultSet resultSet;

    @Test
    public List query(String querySelect) throws SQLException {
        // Соединение с базой данных
        Connection connection;


        // загружаем драйвер
        Driver driver = new com.mysql.cj.jdbc.Driver();

        // регистрируем драйвер
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);

        if (!connection.isClosed()) {
            System.out.println("Соединение с БД Установлено!");
        }

        // запрос к БД
        String query = querySelect;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        List<HashMap> result_new = resultSetToArrayList(resultSet);

        connection.close();
        if (connection.isClosed()) {
            System.out.println("Соединение с БД Закрыто!");
        }
        return result_new;
    }

    public List resultSetToArrayList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList(50);
        while (rs.next()) {
            HashMap row = new HashMap(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }
}