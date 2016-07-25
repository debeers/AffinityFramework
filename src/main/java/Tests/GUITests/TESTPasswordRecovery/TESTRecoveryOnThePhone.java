package Tests.GUITests.TESTPasswordRecovery;

import Tests.BaseTest;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


/**
 * Created by Dem on 03.07.2016.
 */
public class TESTRecoveryOnThePhone extends BaseTest {

    @Test
    public void tryToReceiveJSON() {

        XmlPath xmlPath =
                given()
                        .contentType("application/json")
                        .when()
                        .log()
                        .all()
                        .get("http://beta.lalafo.az/sms.php?db=lalafo_az")
                        .xmlPath();

        System.out.println(xmlPath.getList("to"));
    }
}
