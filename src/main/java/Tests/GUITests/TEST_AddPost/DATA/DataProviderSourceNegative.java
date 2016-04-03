package Tests.GUITests.TEST_AddPost.DATA;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.DataProvider;

/**
 * Created by DeBeers on 31.03.2016.
 */
public class DataProviderSourceNegative {


    @DataProvider(name="negativePostTitle")
    public static Object[][] negativePostTitle(){
        return new Object[][]{
                {" ", "Необходимо заполнить поле «Заголовок»."},
                {RandomStringUtils.randomAlphabetic(4), "Заголовок слишком короткий (минимум 5 символов)."},
                {RandomStringUtils.randomAlphabetic(5), ""},
                {RandomStringUtils.randomAlphabetic(71), ""}
        };
    }

    @DataProvider(name="negativePostEmail")
    public static Object[][] negativePostEmail(){
        return new Object[][]{
                {"", ""},
                {"keeinesuuuuuuuuuuuuuuuuuuuuuuuuuu@mail.ru", ""},
                {"abcdefgh", "Email в неправильном формате"},
                {"#$%^&*@.com", "Email в неправильном формате"},
                {"@domain.com", "Email в неправильном формате"},
                {"email.co.in", "Email в неправильном формате"},
                {".Email@domain.com", "Email в неправильном формате"},
                {"email.@domain.com", "Email в неправильном формате"}
        };
    }

    @DataProvider(name="negativePostPhone")
    public static Object[][] negativePostPhone(){
        return new Object[][]{
                {"", "Необходимо заполнить поле «Телефон»."},
                {"dfghdfgh", ""},
                {"1111111", "Неверное поле \"Телефон\""},
                {"123", "Необходимо заполнить поле «Телефон»."}
        };
    }

    @DataProvider(name="negativePostPrice")
    public static Object[][] negativePostPrice(){
        return new Object[][]{
                {"", "Необходимо заполнить поле «Цена»."},
                {"0", "Введите правильную цену"},
                {"1", ""},
                {"2147483646", ""},
                {"2147483647", ""},
                {"2147483648", ""},
                {"asdf", "Необходимо заполнить поле «Цена»."},
                {"!@#$%^&*(", "Необходимо заполнить поле «Цена»."},
        };
    }

    @DataProvider(name="Injections")
    public static Object[][] Injections(){
        return new Object[][]{
                {"<script>alert(‘hello, Amigo’)</script>", "hello, Amigo"}
        };
    }

    @DataProvider(name="negativeDescription")
    public static Object[][] negativeDescription(){
        return new Object[][]{
                {" ", "Необходимо заполнить поле «Описание»."},
                {RandomStringUtils.randomAlphabetic(49), "Описание слишком короткий (минимум 50 символов)."},
                {RandomStringUtils.randomAlphabetic(50), ""},
                {RandomStringUtils.randomAlphabetic(2049), ""},
        };
    }

    @DataProvider(name="negativeName")
    public static Object[][] negativeName(){
        return new Object[][]{
                {" ", "Необходимо заполнить поле «Имя»."}
        };
    }
}
