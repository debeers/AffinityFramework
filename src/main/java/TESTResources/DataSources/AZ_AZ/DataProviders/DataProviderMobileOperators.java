package TESTResources.DataSources.AZ_AZ.DataProviders;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dem on 20.04.2016.
 */
public class DataProviderMobileOperators {

    @DataProvider(name = "mobileOperators_registration")
    public static Object[][] mobileOperators_registration(ITestContext context) {

        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTRegistrationWithAllOperators_AZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(MobileOperators_AZ_RU()));
            System.out.println("Data Provider or:: AZ_RU suite is used ");
            return result.toArray(new Object[result.size()][]);
        } else if ("TESTRegistrationWithAllOperators_AZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(MobileOperators_AZ_RU()));
            System.out.println("Data Provider or:: AZ_AZ suite is used ");
            return result.toArray(new Object[result.size()][]);
        } else if ("TESTRegistrationWithAllOperators_KG_RU".equals(testName)) {
            result.addAll(Arrays.asList(MobileOperators_KG_RU()));
            System.out.println("Data Provider or:: KG_RU suite is used ");
            return result.toArray(new Object[result.size()][]);
        } else if ("TESTRegistrationWithAllOperators_KG_KG".equals(testName)) {
            result.addAll(Arrays.asList(MobileOperators_KG_RU()));
            System.out.println("Data Provider or:: KG_KY suite is used ");
            return result.toArray(new Object[result.size()][]);
        } else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }

    public static Object[][] MobileOperators_AZ_RU() {
        return new Object[][]{
             {"50"},
             {"51"},
             {"55"},
             {"70"},
             {"77"},
             {"40"},
             {"60"}
        };
    }

    public static Object[][] MobileOperators_KG_RU() {
        return new Object[][]{
                {"515"},
                {"517"},
                {"543"},
                {"545"},
                {"550"},
                {"551"},
                {"552"},
                {"553"},
                {"554"},
                {"555"},
                {"556"},
                {"557"},
                {"558"},
                {"559"},
                {"570"},
                {"571"},
                {"572"},
                {"573"},
                {"574"},
                {"575"},
                {"577"},
                {"578"},
                {"579"},
                {"700"},
                {"701"},
                {"702"},
                {"703"},
                {"704"},
                {"705"},
                {"706"},
                {"707"},
                {"708"},
                {"709"},
                {"770"},
                {"771"},
                {"772"},
                {"773"},
                {"775"},
                {"776"},
                {"777"},
                {"778"},
                {"779"}
        };
    }

    public static Object[][] MobileOperators_TJ_RU() {
        return new Object[][]{
                {"901"},
                {"910"},
                {"911"},
                {"912"},
                {"913"},
                {"914"},
                {"915"},
                {"916"},
                {"917"},
                {"919"},
                {"918"},
                {"981"},
                {"921"},
                {"931"},
                {"951"},
                {"961"},
                {"971"}
        };
    }

    public static Object[][] MobileOperators_NP_NP() {
        return new Object[][]{
                {"984"},
                {"985"},
                {"980"},
                {"975"},
                {"974"},
                {"981"},
                {"982"},
                {"983"},
                {"986"},
                {"987"},
                {"988"},
                {"989"},
                {"971"},
                {"972"},
                {"973"},
                {"976"},
                {"977"},
                {"978"},
                {"979"},
                {"970"}
        };
    }

    public static Object[][] MobileOperators_GR_EN() {
        return new Object[][]{
                {"685"},
                {"686"},
                {"687"},
                {"688"},
                {"689"},
                {"690"},
                {"691"},
                {"692"},
                {"693"},
                {"694"},
                {"695"},
                {"696"},
                {"697"},
                {"698"},
                {"699"},
                {"700"},
                {"701"},
                {"702"},
                {"703"},
                {"704"},
                {"705"},
                {"706"},
                {"707"},
                {"708"},
                {"709"}
        };
    }

    public static Object[][] MobileOperators_RS_EN() {
      return new Object[][]{
              {"60"},
              {"61"},
              {"62"},
              {"63"},
              {"64"},
              {"65"},
              {"66"},
              {"67"},
              {"68"},
              {"69"},
              {"44"},
              {"45"},
              {"43"},
              {"49"}
      };
    }

    public static Object[][] MobileOperators_AF_EN() {
        return new Object[][]{
                {"701"},
                {"702"},
                {"703"},
                {"704"},
                {"705"},
                {"706"},
                {"707"},
                {"708"},
                {"711"},
                {"799"},
                {"798"},
                {"797"},
                {"796"},
                {"795"},
                {"794"},
                {"793"},
                {"721"},
                {"786"},
                {"787"},
                {"788"},
                {"789"},
                {"771"},
                {"772"},
                {"773"},
                {"774"},
                {"775"},
                {"776"},
                {"777"},
                {"778"},
                {"779"},
                {"761"}
        };
    }
}
