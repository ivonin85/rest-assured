import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;


public class FirstTest {
    @Test
    public void firstTest() throws SQLException {
        Variables variables = new Variables();

        FirstQuery firstQuery = new FirstQuery();
        List<HashMap> queryResult = firstQuery.query();


        System.out.println(queryResult.get(0).get("ebs_user_id"));
        System.out.println(queryResult.get(0).get("Bautor"));

        when().get(variables.url).then().statusCode(200).
                body("bname", equalTo(queryResult.get(0).get("bname")),
                        "Bautor", equalTo(queryResult.get(0).get("Bautor")),
                        "grif_name", equalTo(queryResult.get(0).get("grif_name"))

                );


        System.err.println("Все ok!!!");
    }

    @Test
    public void valueText() {
        Variables variables = new Variables();
        System.err.println(get(variables.url).path("authors.ebs_user_id"));
    }

}
