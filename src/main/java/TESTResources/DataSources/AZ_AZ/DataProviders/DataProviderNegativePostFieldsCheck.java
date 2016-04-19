package TESTResources.DataSources.AZ_AZ.DataProviders;

import com.google.common.collect.Lists;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DeBeers on 16.04.2016.
 */
public class DataProviderNegativePostFieldsCheck {

    @DataProvider(name="negativeDescription")
    public static Object[][] negativeDescription(ITestContext context){
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTSuiteIncorrectDataFillinAZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(NegativeDescription_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinAZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativeDescription_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativeDescription_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_KG".equals(testName)) {
            result.addAll(Arrays.asList(NegativeDescription_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name="negativeName")
    public static Object[][] negativeName(ITestContext context){
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTSuiteIncorrectDataFillinAZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(NegativeName_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinAZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativeName_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativeName_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_KG".equals(testName)) {
            result.addAll(Arrays.asList(NegativeName_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name="negativePostEmail")
    public static Object[][] negativePostEmail(ITestContext context){
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTSuiteIncorrectDataFillinAZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostEmail_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinAZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostEmail_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostEmail_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_KG".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostEmail_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name="negativePostPhone")
    public static Object[][] negativePostPhone(ITestContext context){
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTSuiteIncorrectDataFillinAZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostPhone_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinAZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostPhone_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostPhone_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_KG".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostPhone_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name="negativePostPrice")
    public static Object[][] negativePostPrice(ITestContext context){
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTSuiteIncorrectDataFillinAZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostPrice_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinAZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostPrice_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostPrice_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_KG".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostPrice_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name="negativePostTitle")
    public static Object[][] negativePostTitle(ITestContext context){
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTSuiteIncorrectDataFillinAZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostTitle_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinAZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostTitle_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_RU".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostTitle_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSuiteIncorrectDataFillinKG_KG".equals(testName)) {
            result.addAll(Arrays.asList(NegativePostTitle_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }

    //////////////////////////////////// AZ_RU ///////////////////////////////////////////////
    public static Object[][] NegativeDescription_AZ_RU(){
        return new Object[][]{
                {"", "Необходимо заполнить поле «Описание»."},
                {RandomStringUtils.randomAlphabetic(49), ""},
                {RandomStringUtils.randomAlphabetic(50), ""},
                {RandomStringUtils.randomAlphabetic(2049), ""},
        };
    }

    public static Object[][] NegativeName_AZ_RU(){
        return new Object[][]{
                {" ", "Необходимо заполнить поле «Имя»."}
        };
    }

    public static Object[][] NegativePostEmail_AZ_RU(){
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

    public static Object[][] NegativePostPhone_AZ_RU(){
        return new Object[][]{
                {"", "Необходимо заполнить поле «Телефон»."},
                {"dfghdfgh", "Необходимо заполнить поле «Телефон»."},
                {"1111111", "Необходимо заполнить поле «Телефон»."},
                {"123", "Необходимо заполнить поле «Телефон»."}
        };
    }

    public static Object[][] NegativePostPrice_AZ_RU(){
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

    public static Object[][] NegativePostTitle_AZ_RU(){
        return new Object[][]{
                {" ", "Необходимо заполнить поле «Заголовок»."},
                {RandomStringUtils.randomAlphabetic(4), "Заголовок слишком короткий (минимум 5 символов)."},
                {RandomStringUtils.randomAlphabetic(5), ""},
                {RandomStringUtils.randomAlphabetic(71), ""}
        };
    }

    ////////////////////////////AZ_AZ/////////////////////////////////////////////

    public static Object[][] NegativeDescription_AZ_AZ(){
        return new Object[][]{
                {"", "Təsvir sırasını doldurmaq lazımdır."},
                {RandomStringUtils.randomAlphabetic(49), ""},
                {RandomStringUtils.randomAlphabetic(50), ""},
                {RandomStringUtils.randomAlphabetic(2049), ""},
        };
    }

    public static Object[][] NegativeName_AZ_AZ(){
        return new Object[][]{
                {" ", "Adınız sırasını doldurmaq lazımdır."}
        };
    }

    public static Object[][] NegativePostEmail_AZ_AZ(){
        return new Object[][]{
                {"", ""},
                {"keeinesuuuuuuuuuuuuuuuuuuuuuuuuuu@mail.ru", ""},
                {"abcdefgh", "Email düzgün formatda deyil"},
                {"#$%^&*@.com", "Email düzgün formatda deyil"},
                {"@domain.com", "Email düzgün formatda deyil"},
                {"email.co.in", "Email düzgün formatda deyil"},
                {".Email@domain.com", "Email düzgün formatda deyil"},
                {"email.@domain.com", "Email düzgün formatda deyil"}
        };
    }

    public static Object[][] NegativePostPhone_AZ_AZ(){
        return new Object[][]{
                {"", "Telefon sırasını doldurmaq lazımdır."},
                {"dfghdfgh", "Telefon sırasını doldurmaq lazımdır."},
                {"1111111", "Telefon sırasını doldurmaq lazımdır."},
                {"123", "Telefon sırasını doldurmaq lazımdır."}
        };
    }

    public static Object[][] NegativePostPrice_AZ_AZ(){
        return new Object[][]{
                {"", "Qiymət sırasını doldurmaq lazımdır."},
                {"0", "Qiyməti düzgün daxil edin"},
                {"1", ""},
                {"2147483646", ""},
                {"2147483647", ""},
                {"2147483648", ""},
                {"asdf", "Qiymət sırasını doldurmaq lazımdır."},
                {"!@#$%^&*(", "Qiymət sırasını doldurmaq lazımdır."},
        };
    }

    public static Object[][] NegativePostTitle_AZ_AZ(){
        return new Object[][]{
                {" ", "Başlıq sırasını doldurmaq lazımdır."},
                {RandomStringUtils.randomAlphabetic(4), "Başlıq çox qısa (5 simvol minimum.)"},
                {RandomStringUtils.randomAlphabetic(5), ""},
                {RandomStringUtils.randomAlphabetic(71), ""}
        };
    }

    //////////////////////////////KG_RU///////////////////////////////////////////////

    public static Object[][] NegativeDescription_KG_RU(){
        return new Object[][]{
                {"", "Необходимо заполнить поле Описание."},
                {RandomStringUtils.randomAlphabetic(49), ""},
                {RandomStringUtils.randomAlphabetic(50), ""},
                {RandomStringUtils.randomAlphabetic(2049), ""},
        };
    }

    public static Object[][] NegativeName_KG_RU(){
        return new Object[][]{
                {" ", "Необходимо заполнить поле Имя."}
        };
    }

    public static Object[][] NegativePostEmail_KG_RU(){
        return new Object[][]{
                {"", ""},
                {"keeinesuuuuuuuuuuuuuuuuuuuuuuuuuu@mail.ru", ""},
                {"abcdefgh", "Email не является правильным E-Mail адресом."},
                {"#$%^&*@.com", "Email не является правильным E-Mail адресом."},
                {"@domain.com", "Email не является правильным E-Mail адресом."},
                {"email.co.in", "Email не является правильным E-Mail адресом."},
                {".Email@domain.com", "Email не является правильным E-Mail адресом."},
                {"email.@domain.com", "Email не является правильным E-Mail адресом."}
        };
    }

    public static Object[][] NegativePostPhone_KG_RU(){
        return new Object[][]{
                {"", "Необходимо заполнить поле Телефон."},
                {"dfghdfgh", "Необходимо заполнить поле Телефон."},
                {"1111111", "Необходимо заполнить поле Телефон."},
                {"123", "Необходимо заполнить поле Телефон."}
        };
    }

    public static Object[][] NegativePostPrice_KG_RU(){
        return new Object[][]{
                {"", "Необходимо заполнить поле Цена."},
                {"0", "Введите правильную цену"},
                {"1", ""},
                {"2147483646", ""},
                {"2147483647", ""},
                {"2147483648", ""},
                {"asdf", "Введите правильную цену"},
                {"!@#$%^&*(", "Введите правильную цену"},
        };
    }

    public static Object[][] NegativePostTitle_KG_RU(){
        return new Object[][]{
                {" ", "Необходимо заполнить поле Заголовок."},
                {RandomStringUtils.randomAlphabetic(4), "Заголовок слишком короткое (Минимум: 5 симв.)."},
                {RandomStringUtils.randomAlphabetic(5), ""},
                {RandomStringUtils.randomAlphabetic(71), ""}
        };
    }
    ////////////////////////////////KG_KG////////////////////////////////////////////////

    public static Object[][] NegativeDescription_KG_KG(){
        return new Object[][]{
                {"", "Түшүндүрмө талаасын толтуруңуз."},
                {RandomStringUtils.randomAlphabetic(49), ""},
                {RandomStringUtils.randomAlphabetic(50), ""},
                {RandomStringUtils.randomAlphabetic(2049), ""},
        };
    }

    public static Object[][] NegativeName_KG_KG(){
        return new Object[][]{
                {" ", "Аты талаасын толтуруңуз."}
        };
    }

    public static Object[][] NegativePostEmail_KG_KG(){
        return new Object[][]{
                {"", ""},
                {"keeinesuuuuuuuuuuuuuuuuuuuuuuuuuu@mail.ru", ""},
                {"abcdefgh", "Email туура эмес форматта жазылды."},
                {"#$%^&*@.com", "Email туура эмес форматта жазылды."},
                {"@domain.com", "Email туура эмес форматта жазылды."},
                {"email.co.in", "Email туура эмес форматта жазылды."},
                {".Email@domain.com", "Email туура эмес форматта жазылды."},
                {"email.@domain.com", "Email туура эмес форматта жазылды."}
        };
    }

    public static Object[][] NegativePostPhone_KG_KG(){
        return new Object[][]{
                {"", "Телефон талаасын толтуруңуз."},
                {"dfghdfgh", "Телефон талаасын толтуруңуз."},
                {"1111111", "Телефон талаасын толтуруңуз."},
                {"123", "Телефон талаасын толтуруңуз."}
        };
    }

    public static Object[][] NegativePostPrice_KG_KG(){
        return new Object[][]{
                {"", "Баасы талаасын толтуруңуз."},
                {"0", "Туура баасын жазгыла"},
                {"1", ""},
                {"2147483646", ""},
                {"2147483647", ""},
                {"2147483648", ""},
                {"asdf", "Туура баасын жазгыла"},
                {"!@#$%^&*(", "Туура баасын жазгыла"},
        };
    }

    public static Object[][] NegativePostTitle_KG_KG(){
        return new Object[][]{
                {" ", "Аталышы талаасын толтуруңуз."},
                {RandomStringUtils.randomAlphabetic(4), "Аталышы аябай кыска (минимум 5 символ)."},
                {RandomStringUtils.randomAlphabetic(5), ""},
                {RandomStringUtils.randomAlphabetic(71), ""}
        };
    }
}
