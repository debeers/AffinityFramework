package TESTResources.DataSources.AZ_AZ.DataProviders;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dem on 13.06.2016.
 */
public class DataProviderRegistrationErrors {

    @DataProvider(name = "phoneNumberErrors")
    public static Object[][] phoneNumberErrors(ITestContext context) {

        List<Object[]> results = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTRegistrationErrorsCheck_AZ_RU".equals(testName)) {
            results.addAll(Arrays.asList(PhoneNumberErrors_AZ_RU()));
            System.out.println("Data Provider for:: AZ_RU suite is used");
            return results.toArray(new Object[results.size()][]);
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name = "emailFieldErrors")
    public static Object[][] emailFieldErrors(ITestContext context) {

        List<Object[]> results = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTRegistrationErrorsOfEmailFieldCheck_AZ_RU".equals(testName)) {
            results.addAll(Arrays.asList(EmailFieldErrors_AZ_RU()));
            System.out.println("Data Provider for:: AZ_RU suite is used");
            return results.toArray(new Object[results.size()][]);
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name = "passwordFieldErrors")
    public static Object[][] passwordFieldErrors(ITestContext context) {
        List<Object[]> results = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTRegistrationErrorsOfPasswordFieldCheck_AZ_RU".equals(testName)) {
            results.addAll(Arrays.asList(PasswordFieldErrors_AZ_RU()));
            System.out.println("Data Provider for:: AZ_RU suite is used");
            return results.toArray(new Object[results.size()][]);
        }
        return new Object[][]{{"Commond test data"}};
    }

    @DataProvider(name = "passwordConfirmFieldErrors")
    public static Object[][] passwordConfirmFieldErrors(ITestContext context) {
        List<Object[]> results = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTRegistrationErrorsOfPasswordConfirmFieldCheck_AZ_RU".equals(testName)) {
            results.addAll(Arrays.asList(PasswordConfirmFieldErrors_AZ_RU()));
            System.out.println("Data Provider for:: AZ_RU suite is used");
            return results.toArray(new Object[results.size()][]);
        }
        return new Object[][]{{"Common test data"}};
    }

    public static Object[][] PhoneNumberErrors_AZ_RU() {
        return new Object[][] {
                {"" , "Необходимо заполнить поле Телефон."},
                {"abcd" , "Необходимо заполнить поле Телефон."},
                {"213213213" , "Неверное поле \"Телефон\""},
                {"333" , "Необходимо заполнить поле Телефон."},
                {"708888888" , "Телефон принадлежит существующему пользователю. Войдите на сайт."}
        };
    }

    public static Object[][] EmailFieldErrors_AZ_RU() {
        return new Object[][] {
                {"" , "Необходимо заполнить поле Email."},
                {"kkkkkkkkkkkkkkkkkkkkeeinesuuuuuuuukeeinesuuuuuuuuuuuuuuuuuuuuuuuuu@mail.ru" , "The input exceeds the allowed length"},
                {"abcdefgh" , "Введите верный email!"},
                {"#$%^&*@.com" , "Введите верный email!"},
                {"@domain.com" , "Введите верный email!"},
                {"email.co.in" , "Введите верный email!"},
                {".Email@domain.com" , "Введите верный email!"},
                {"email.@domain.com" , "Введите верный email!"},
                {"email....email1@domain.com" , "Введите верный email!"},
                {"email@domain" , "Введите верный email!"},
                {"email@-domain.com" , "Введите верный email!"},
                {"email@123.444.555.555" , "Введите верный email!"},
                {"あいう@domain.com" , "Введите верный email!"}
        };
    }

    public static Object[][] PasswordFieldErrors_AZ_RU() {
        return new Object[][] {
                {"" , "Необходимо заполнить поле Пароль."},
                {"root" , "Пароль слишком мал (Минимум: 5)."},
                {"     " , "Необходимо заполнить поле Пароль."},
                
        };
    }

    public static Object[][] PasswordConfirmFieldErrors_AZ_RU() {
        return new Object[][] {
                {"" , "Необходимо заполнить поле Подтвердить пароль."},
                {"root" , "Подтвердить новый пароль"},
                {"     " , "Необходимо заполнить поле Подтвердить пароль."}

        };
    }
}
