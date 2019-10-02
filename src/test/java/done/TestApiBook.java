package done;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestApiBook {
    @Test
    public void testApi() {
        Variables variables = new Variables();
        when().get(variables.url).then().statusCode(200).
                body("bname", equalTo(variables.bname),
                        "Bautor", equalTo(variables.bautor),
                        "authors.ebs_user_id", hasItems(variables.authors_ebs_user_id_1, variables.authors_ebs_user_id_2),
                        "authors.FullName", hasItems(variables.fullName_1, variables.fullName_2),
                        "Byear", equalTo(variables.byear),
                        "grif_name", equalTo(variables.grif_name),
                        "bdescription", equalTo(variables.bdescription),
                        "enable_type_id", equalTo(variables.enable_type_id),
                        "themes.bstype_id", hasItems(variables.bstype_id),
                        "themes.bstype_name", hasItems(variables.bstype_name),
                        "cover_exists", equalTo(variables.cover_exists),
                        "isbn", equalTo(variables.isbn),
                        "schools.content_id", hasItems(variables.content_id),
                        "schools.partner_id", hasItems(variables.partner_id),
                        "schools.fname", hasItems(variables.fname),
                        "link", equalTo(variables.link),
                        "audiobook_available", equalTo(variables.audiobook_available),
                        "can_download", equalTo(variables.can_download),
                        "last_edition.content_id", equalTo(variables.content_id),
                        "last_edition.link", equalTo(variables.link)


                );
        System.err.println("Все OK!!!");
    }

}
