import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.path.xml.XmlPath.from;
import static javax.swing.UIManager.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class GitHubTestUserApi {

    @Test
    public void testLogAll() {
        when().
                get("https://api.github.com/users/ivonin85").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testUrlStatus(){
        /** Кладем в переменную url из ссылки и проверяем его статус*/
        String href = when().get("https://api.github.com/users/ivonin85").then().
                contentType(ContentType.JSON).
                body("login", equalTo("ivonin85")).
                extract().path("avatar_url");

        when().get(href).then().statusCode(200);

        /** получаем разную инфо о наше api*/
        Response response = when().get("https://api.github.com/users/ivonin85");
        System.out.println(response.contentType());
        System.out.println(response.statusCode());
        System.out.println(response.path("avatar_url"));
    }

    @Test
    public void testLength(){
        /** сравнивает количество элементов на старнице*/
        when().
                get("https://api.github.com/users").
                then().
                body("login", hasSize(30));
        /** распарсили xml api, посчитали все элементы и засунуи все в лист*/
        String response = when().get("https://www.w3schools.com/xml/plant_catalog.xml").asString();
        List<String> ls = from(response).getList("CATALOG.PLANT.COMMON");
        System.out.println("элементов в файле: " + ls.size());
        for (String l : ls) {
            System.out.println(l);
        }

        /** Супер спосов посчитать количество элементов !!!*/
        String response1 = when().
                get("https://api.github.com/users").
                then().
                extract().
                asString();
        JsonPath jsonPath = new JsonPath(response1);
        List<String> ist = jsonPath.get("login");
        System.out.println("На странице https://api.github.com/users " + ist.size()+ " элементов с ключем ID ");


    }
}
