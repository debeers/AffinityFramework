package TESTResources.DataSources.AZ_AZ.DataProviders;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dem on 19.06.2016.
 */
public class DataProviderPasswordRecoveryErrors {

    @DataProvider(name = "passwordConfirmFieldErrors")
    public static Object[][] passwordConfirmFieldErrors(ITestContext context) {

        List<Object[]> results = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTPasswordRecoveryErrorsCheck_AZ_RU".equals(testName)) {
            results.addAll(Arrays.asList(PasswordConfirmFieldErrors_AZ_RU()));
            System.out.println("Data Provider for:: AZ_RU suite is used");
            return results.toArray(new Object[results.size()][]);
        } else if ("TESTPasswordRecoveryErrorsCheck_Beta_CZ".equals(testName)) {
            results.addAll(Arrays.asList(PasswordConfirmFieldErrors_Beta_CZ()));
            System.out.println("Data Provider for:: CZ_CZ suite is used");
            return results.toArray(new Object[results.size()][]);
        }
        return new Object[][]{{"Common test data"}};
    }

    public static Object[][] PasswordConfirmFieldErrors_AZ_RU() {
        return new Object[][] {
                {",." , "Необходимо заполнить поле Телефон или Email."},
                {"justAnUnknownUser" , "User doesn't exist"},
                {"45454545454545" , "Неверное поле \"Телефон или Email\""},
                {"#$%^&*@" , "Неверное поле \"Телефон или Email\""},
                {"+994709897777" , "Такого пользователя не существует. Пройдите регистрацию."},
                {"709897777" , "Такого пользователя не существует. Пройдите регистрацию."},
                {"passworderrorcheckuser@mail.com" , "Такого пользователя не существует. Пройдите регистрацию."}
        };
    }

    public static Object[][] PasswordConfirmFieldErrors_Beta_CZ() {
        return new Object[][] {
                {",." , "Email or phone cannot be blank."},
                {"justAnUnknownUser" , "User doesn't exist"},
                {"45454545454545" , "User doesn't exist"},
                {"#$%^&*@" , "User doesn't exist"},
                {"+994709897777" , "User doesn't exist"},
                {"709897777" , "User doesn't exist"},
                {"passworderrorcheckuser@mail.com" , "User doesn't exist"}

        };
    }
}
