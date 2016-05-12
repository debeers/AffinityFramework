package TESTResources.DataSources.AZ_AZ.DataProviders;

import com.google.common.collect.Lists;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DeBeers on 09.04.2016.
 */
public class DataProviderCategoriesBD {

    @DataProvider(name = "underCategory_validation")
    public static Object[][] underCategory_validation(ITestContext context) {

        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTSubCategoryValidation_AZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(Undercategory_AZ_RU()));
            System.out.println("Data Provider for:: AZ_RU suite used  ");
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSubCategoryValidation_KG_RU".equals(testName)) {
            result.addAll(Arrays.asList(Undercategory_KG_RU()));
            System.out.println("Data Provider for:: KG_RU suite used  ");
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSubCategoryValidation_AZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(Undercategory_AZ_AZ()));
            System.out.println("Data Provider for:: AZ_AZ suite used  ");
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTSubCategoryValidation_KG_KG".equals(testName)) {
            result.addAll(Arrays.asList(Undercategory_KG_KG()));
            System.out.println("Data Provider for:: KG_KY suite used  ");
            return result.toArray(new Object[result.size()][]);
        }
        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }


    @DataProvider(name = "thirdSubcategory_validation")
    public static Object[][] thirdSubcategory_validation(ITestContext context) {
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTThirdSubcategoryValidation_AZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(ThirdSubCategory_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTThirdSubcategoryValidation_KG_RU".equals(testName)) {
            result.addAll(Arrays.asList(ThirdSubCategory_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTThirdSubcategoryValidation_KG_KG".equals(testName)) {
            result.addAll(Arrays.asList(ThirdSubCategory_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTThirdSubcategoryValidation_AZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(ThirdSubCategory_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }

        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name = "motorcyclesYearsOfManufacture")
    public static Object[][] motorcyclesYearsOfManufacture(ITestContext context) {
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTMotorcyclesYearsOfManufacture_AZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(MotorcyclesYearsOfManufacture_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTMotorcyclesYearsOfManufacture_AZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(MotorcyclesYearsOfManufacture_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTMotorcyclesYearsOfManufacture_KG_KG".equals(testName)) {
            result.addAll(Arrays.asList(MotorcyclesYearsOfManufacture_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTMotorcyclesYearsOfManufacture_KG_RU".equals(testName)) {
            result.addAll(Arrays.asList(MotorcyclesYearsOfManufacture_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        return new Object[][]{{"Common test data"}};
    }


    @DataProvider(name = "fourthCategory_validation")
    public static Object[][] fourthCategory_validation(ITestContext context) {
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTFourthCategoryValidation_AZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(FourthCategory_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTFourthCategoryValidation_AZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(FourthCategory_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTFourthCategoryValidation_KG_RU".equals(testName)) {
            result.addAll(Arrays.asList(FourthCategory_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TEST_fourthCategory_validation_KG_KG".equals(testName)) {
            result.addAll(Arrays.asList(FourthCategory_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else {
            System.out.println("NO DATA WILL UPLOAD!");
        }
        return new Object[][]{{"Common test data"}};
    }


    public static Object[][] Undercategory_AZ_RU() {
        return new Object[][]{
                {"2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=33) AND lang_id='ru' AND l_category IS NOT NULL"},
                {"3", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=381) AND lang_id='ru' AND l_category is NOT NULL"},
                {"4", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1119) AND lang_id='ru' AND l_category IS NOT NULL"},
                {"5", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1120) AND lang_id='ru' AND l_category IS NOT NULL"},
                {"6", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1121) AND lang_id='ru' AND l_category IS NOT NULL"},
                {"7", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1122) AND lang_id='ru'"},
                {"8", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1123) AND lang_id='ru'"},
                {"10", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=36) AND lang_id='ru'"},
                {"11", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=40) AND lang_id='ru'"},
                {"18", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1581) AND lang_id='ru'"},
                {"23", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=313) AND lang_id='ru'"},
                {"45", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=9) AND lang_id='ru'"},
                {"46", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=12) AND lang_id='ru'"},
                {"47", "SELECT value FROM param_value WHERE param_id=4"},
                {"48", "SELECT value FROM param_value WHERE param_id=4"},
                {"49", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1011) AND lang_id='ru'"},
                {"51", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1080) AND lang_id='ru'"},
                {"52", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1081) AND lang_id='ru'"},
                {"53", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1082) AND lang_id='ru'"},
                {"54", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1083) AND lang_id='ru'"},
                {"55", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1084) AND lang_id='ru'"},
                {"74", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1536) AND lang_id='ru'"},
                {"75", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1537) AND lang_id='ru'"}
        };
    }


    public static Object[][] ThirdSubCategory_AZ_RU() {
        return new Object[][]{
                {"3", "1", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=379) AND lang_id='ru'"},
                {"6", "4", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1140) AND lang_id='ru'"},
                {"7", "3", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1142) AND lang_id='ru'"},
                {"51", "1", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=11)"},
                {"51", "2", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=11)"},
                {"51", "3", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1088) AND lang_id='ru'"},
                {"51", "4", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=11)"},
                {"52", "1", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=11)"},
                {"52", "2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1088) AND lang_id='ru'"},
                {"53", "1", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1089) AND lang_id='ru'"},
                {"53", "2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1090) AND lang_id='ru'"},
                {"54", "1", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=11)"},
                {"54", "2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1092) AND lang_id='ru'"},
                {"74", "2", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "3", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "4", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "5", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "6", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "7", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "8", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "9", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "10", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "11", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "12", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "13", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "14", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "15", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "16", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "17", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "18", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "19", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "20", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "21", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "22", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "23", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "24", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "25", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "26", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "27", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "28", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "29", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "30", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "31", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"74", "32", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "2", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "3", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "4", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "5", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "6", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "7", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "8", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "9", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "10", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "11", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "12", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "13", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "14", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "15", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "16", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "17", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "18", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "19", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "20", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "21", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "22", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "23", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "24", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "25", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "26", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "27", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "28", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "29", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "30", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "31", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
                {"75", "32", "SELECT l_value FROM param_value_lang WHERE param_value_id IN (SELECT id FROM param_value WHERE param_id=9)"},
        };
    }

    public static Object[][] MotorcyclesYearsOfManufacture_AZ_RU() {
        return new Object[][]{
                {"46", "1", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "2", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "3", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "4", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "5", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "6", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "7", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "8", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "9", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "10", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "11", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "12", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "13", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "14", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "15", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "16", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "17", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "18", "SELECT value FROM param_value WHERE param_id=4"},
        };
    }


    public static Object[][] FourthCategory_AZ_RU() {
        return new Object[][]{
                {"49", "1", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "2", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "3", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "4", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "5", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "6", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "7", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "8", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "9", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "10", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "11", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "12", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "13", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "14", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "15", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "16", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "17", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "18", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "19", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "20", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "21", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "22", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "23", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "24", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "25", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "26", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "27", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "28", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "29", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "30", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "31", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "32", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "33", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "34", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "35", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "36", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "37", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "38", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "39", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "40", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "41", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "42", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "43", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "44", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "45", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "46", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "47", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "48", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "49", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "50", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "51", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "52", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "53", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "54", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "55", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "56", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "57", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "58", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "59", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "60", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "61", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "62", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "63", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "64", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "65", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "66", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "67", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "68", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "69", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "70", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "71", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "72", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "73", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "74", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "75", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "76", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "77", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "78", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "79", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "80", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "81", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "82", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "83", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "84", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "85", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "86", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "87", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "88", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "89", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "90", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "91", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "92", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "93", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "94", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "95", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "96", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "97", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "98", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "99", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "100", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "101", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "102", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "103", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "104", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "105", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "106", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "107", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "108", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "109", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "110", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "111", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "112", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "113", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "114", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "115", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                {"49", "116", "SELECT l_value FROM param_value_lang WHERE l_id BETWEEN 1 AND 12"},
                //NUMBER OF ROOMS
                {"51", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                {"51", "2", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                {"51", "4", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                //{"52", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                //{"53", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},

        };
    }


        public static Object[][] Undercategory_KG_RU () {
            return new Object[][]{
                    {"2", "SELECT name FROM category WHERE lvl=3 AND parent_id=33"},
                    {"3", "SELECT name FROM category WHERE lvl=3 AND parent_id=381"},
                    {"4", "SELECT name FROM category WHERE lvl=3 AND parent_id=1119"},
                    {"5", "SELECT name FROM category WHERE lvl=3 AND parent_id=1120"},
                    {"6", "SELECT name FROM category WHERE lvl=3 AND parent_id=1121"},
                    {"7", "SELECT name FROM category WHERE lvl=3 AND parent_id=1122"},
                    {"8", "SELECT name FROM category WHERE lvl=3 AND parent_id=1123"},
                    {"10", "SELECT name FROM category WHERE lvl=3 AND parent_id=36"},
                    {"11", "SELECT name FROM category WHERE lvl=3 AND parent_id=40"},
                    {"15", "SELECT name FROM category WHERE lvl=3 AND parent_id=376"},
                    {"16", "SELECT name FROM category WHERE lvl=3 AND parent_id=377"},
                    {"21", "SELECT name FROM category WHERE lvl=3 AND parent_id=313"},
                    {"39", "SELECT name FROM category WHERE lvl=3 AND parent_id=589"},
                    {"43", "SELECT name FROM category WHERE lvl=3 AND parent_id=1011"},
                    {"44", "SELECT name FROM category WHERE lvl=3 AND parent_id=9"},
                    {"45", "SELECT name FROM category WHERE lvl=3 AND parent_id=12"},
                    {"46", "SELECT name FROM category WHERE lvl=3 AND parent_id=13"},
                    {"49", "SELECT name FROM category WHERE lvl=3 AND parent_id=1081"},
                    {"50", "SELECT name FROM category WHERE lvl=3 AND parent_id=1084"},
                    {"51", "SELECT name FROM category WHERE lvl=3 AND parent_id=1080"},
                    {"52", "SELECT name FROM category WHERE lvl=3 AND parent_id=1082"},
                    {"53", "SELECT name FROM category WHERE lvl=3 AND parent_id=1083"},
                    {"72", "SELECT name FROM category WHERE lvl=3 AND parent_id=1571"},
                    {"73", "SELECT name FROM category WHERE lvl=3 AND parent_id=1572"}
            };
        }


        public static Object[][] ThirdSubCategory_KG_RU () {
            return new Object[][]{
                    {"6", "4", "SELECT name FROM category WHERE lvl=4 AND parent_id=1140"},
                    {"7", "3", "SELECT name FROM category WHERE lvl=4 AND parent_id=1142"},
                    {"49", "1", "SELECT name FROM category WHERE lvl=3 AND parent_id=1081"},
                    {"49", "2", "SELECT name FROM category WHERE lvl=3 AND parent_id=1081"},
                    {"49", "3", "SELECT name FROM category WHERE lvl=4 AND parent_id=1088"},
                    {"51", "1", "SELECT name FROM category WHERE lvl=3 AND parent_id=1081"},
                    {"51", "2", "SELECT name FROM category WHERE lvl=3 AND parent_id=1081"},
                    {"51", "3", "SELECT name FROM category WHERE lvl=4 AND parent_id=1088"},
                    {"51", "4", "SELECT name FROM category WHERE lvl=3 AND parent_id=1081"},
                    {"52", "1", "SELECT name FROM category WHERE lvl=4 AND parent_id=1089"},
                    {"52", "2", "SELECT name FROM category WHERE lvl=4 AND parent_id=1090"},
                    {"52", "3", "SELECT name FROM category WHERE lvl=4 AND parent_id=1092"},
                    {"52", "4", "SELECT value FROM param_value WHERE param_id=11"},
                    {"53", "2", "SELECT name FROM category WHERE lvl=4 AND parent_id=1092"},
                    {"53", "3", "SELECT value FROM param_value WHERE param_id=11"},
                    {"72", "1", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "2", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "3", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "4", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "5", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "6", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "7", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "8", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "9", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "10", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "11", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "12", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "13", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "14", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "15", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "16", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "17", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "18", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "19", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "20", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "21", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "22", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "23", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "24", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "25", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "26", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "27", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "28", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "29", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "30", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "31", "SELECT value FROM param_value WHERE param_id=9"},
                    {"72", "32", "SELECT value FROM param_value WHERE param_id=9"},

            };
        }

    public static Object[][] MotorcyclesYearsOfManufacture_KG_RU() {
        return new Object[][]{
                {"45", "1", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "2", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "3", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "4", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "5", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "6", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "7", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "8", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "9", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "10", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "11", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "12", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "13", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "14", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "15", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "16", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "17", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "18", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
        };
    }


        public static Object[][] FourthCategory_KG_RU () {
            return new Object[][]{
                    {"43", "1", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "2", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "3", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "4", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "5", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "6", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "7", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "8", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "9", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "10", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "11", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "12", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "13", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "14", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "15", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "16", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "17", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "18", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "19", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "20", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "21", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "22", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "23", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "24", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "25", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "26", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "27", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "28", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "29", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "30", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "31", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "32", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "33", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "34", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "35", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "36", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "37", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "38", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "39", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "40", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "41", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "42", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "43", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "44", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "45", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "46", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "47", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "48", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "49", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "50", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "51", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "52", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "53", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "54", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "55", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "56", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "57", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "58", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "59", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "60", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "61", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "62", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "63", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "64", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "65", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "66", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "67", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "68", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "69", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"49", "70", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "71", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "72", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "73", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "74", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "75", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "76", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "77", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "78", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "79", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "80", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "81", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "82", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "83", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "84", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "85", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "86", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "87", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "88", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "89", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "90", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "91", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "92", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "93", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "94", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "95", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"49", "96", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "97", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "98", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "99", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "100", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "101", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "102", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "103", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "104", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "105", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "106", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "107", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "108", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "109", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "110", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                    {"43", "111", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},

                    //NUMBER OF ROOMS
                    {"51", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                    {"51", "2", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                    {"51", "4", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                    //{"52", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                    //{"53", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},

            };

        }


    public static Object[][] Undercategory_AZ_AZ(){
        return new Object[][]{
                {"2", "SELECT name FROM category WHERE lvl=3 AND parent_id=33"},
                {"3", "SELECT name FROM category WHERE lvl=3 AND parent_id=381"},
                {"4", "SELECT name FROM category WHERE lvl=3 AND parent_id=1119"},
                {"5", "SELECT name FROM category WHERE lvl=3 AND parent_id=1120"},
                {"6", "SELECT name FROM category WHERE lvl=3 AND parent_id=1121"},
                {"7", "SELECT name FROM category WHERE lvl=3 AND parent_id=1122"},
                {"8", "SELECT name FROM category WHERE lvl=3 AND parent_id=1123"},
                {"10", "SELECT name FROM category WHERE lvl=3 AND parent_id=36"},
                {"11", "SELECT name FROM category WHERE lvl=3 AND parent_id=40"},
                {"18", "SELECT name FROM category WHERE lvl=3 AND parent_id=1581"},
                {"23", "SELECT name FROM category WHERE lvl=3 AND parent_id=313"},
                {"45", "SELECT name FROM category WHERE lvl=3 AND parent_id=9"},
                {"46", "SELECT name FROM category WHERE lvl=3 AND parent_id=12"},
                {"47", "SELECT value FROM param_value WHERE param_id=4"},
                {"48", "SELECT value FROM param_value WHERE param_id=4"},
                {"49", "SELECT name FROM category WHERE lvl=3 AND parent_id=1011"},
                {"51", "SELECT name FROM category WHERE lvl=3 AND parent_id=1080"},
                {"52", "SELECT name FROM category WHERE lvl=3 AND parent_id=1081"},
                {"53", "SELECT name FROM category WHERE lvl=3 AND parent_id=1082"},
                {"54", "SELECT name FROM category WHERE lvl=3 AND parent_id=1083"},
                {"55", "SELECT name FROM category WHERE lvl=3 AND parent_id=1084"},
                {"74", "SELECT name FROM category WHERE lvl=3 AND parent_id=1536"},
                {"75", "SELECT name FROM category WHERE lvl=3 AND parent_id=1537"}
        };
    }


    public static Object[][] ThirdSubCategory_AZ_AZ(){
        return new Object[][]{
                {"3", "1", "SELECT name FROM category WHERE lvl =4 AND parent_id=379"},
                {"6", "4", "SELECT name FROM category WHERE lvl =4 AND parent_id=1140"},
                {"7", "3", "SELECT name FROM category WHERE lvl =4 AND parent_id=1142"},
                {"46", "1", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "2", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "3", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "4", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "5", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "6", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "7", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "8", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "9", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "10", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "11", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "12", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "13", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "14", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "15", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "16", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "17", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "18", "SELECT value FROM param_value WHERE param_id=4"},
                {"51", "1", "SELECT value FROM param_value WHERE param_id=11"},
                {"51", "2", "SELECT value FROM param_value WHERE param_id=11"},
                {"51", "3", "SELECT name FROM category WHERE lvl =4 AND parent_id=1088"},
                {"51", "4", "SELECT value FROM param_value WHERE param_id=11"},
                {"52", "1", "SELECT value FROM param_value WHERE param_id=11"},
                {"52", "2", "SELECT name FROM category WHERE lvl =4 AND parent_id=1088"},
                {"53", "1", "SELECT name FROM category WHERE lvl =4 AND parent_id=1089"},
                {"53", "2", "SELECT name FROM category WHERE lvl =4 AND parent_id=1090"},
                {"54", "1", "SELECT value FROM param_value WHERE param_id=11"},
                {"54", "2", "SELECT name FROM category WHERE lvl =4 AND parent_id=1092"},
                {"74", "2", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "3", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "4", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "5", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "6", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "7", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "8", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "9", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "10", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "11", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "12", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "13", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "14", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "15", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "16", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "17", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "18", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "19", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "20", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "21", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "22", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "23", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "24", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "25", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "26", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "27", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "28", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "29", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "30", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "31", "SELECT value FROM param_value WHERE param_id=9"},
                {"74", "32", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "2", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "3", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "4", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "5", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "6", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "7", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "8", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "9", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "10", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "11", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "12", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "13", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "14", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "15", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "16", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "17", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "18", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "19", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "20", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "21", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "22", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "23", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "24", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "25", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "26", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "27", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "28", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "29", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "30", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "31", "SELECT value FROM param_value WHERE param_id=9"},
                {"75", "32", "SELECT value FROM param_value WHERE param_id=9"}
        };
    }

    public static Object[][] MotorcyclesYearsOfManufacture_AZ_AZ() {
        return new Object[][]{
                {"46", "1", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "2", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "3", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "4", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "5", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "6", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "7", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "8", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "9", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "10", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "11", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "12", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "13", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "14", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "15", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "16", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "17", "SELECT value FROM param_value WHERE param_id=4"},
                {"46", "18", "SELECT value FROM param_value WHERE param_id=4"},
        };
    }


    public static Object[][] FourthCategory_AZ_AZ(){
        return new Object[][]{
                {"49", "1", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "2", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "3", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "4", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "5", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "6", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "7", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "8", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "9", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "10", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "11", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "12", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "13", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "14", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "15", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "16", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "17", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "18", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "19", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "20", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "21", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "22", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "23", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "24", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "25", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "26", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "27", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "28", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "29", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "30", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "31", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "32", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "33", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "34", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "35", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "36", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "37", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "38", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "39", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "40", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "41", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "42", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "43", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "44", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "45", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "46", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "47", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "48", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "49", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "50", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "51", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "52", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "53", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "54", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "55", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "56", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "57", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "58", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "59", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "60", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "61", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "62", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "63", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "64", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "65", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "66", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "67", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "68", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "69", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                //{"49", "70", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "71", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "72", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "73", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "74", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "75", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "76", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "77", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "78", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "79", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "80", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "81", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "82", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "83", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "84", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "85", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "86", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "87", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "88", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "89", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "90", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "91", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "92", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "93", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "94", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "95", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                //{"49", "96", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "97", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "98", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "99", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "100", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "101", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "102", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "103", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "104", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "105", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "106", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "107", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "108", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "109", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "110", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "111", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "112", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "113", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "114", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "115", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                {"49", "116", "SELECT value FROM param_value WHERE id IN (SELECT param_value_id FROM param_value_lang WHERE l_id BETWEEN 1 and 12)"},
                //NUMBER OF ROOMS
                {"51", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT value FROM param_value WHERE id=1776"},
                {"51", "2", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT value FROM param_value WHERE id=1776"},
                {"51", "4", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT value FROM param_value WHERE id=1776"},
                //{"52", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                //{"53", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},

        };
    }


    public static Object[][] Undercategory_KG_KG(){
        return new Object[][]{
                {"2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=33)"},
                {"3", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=381)"},
                {"4", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1119)"},
                {"5", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1120)"},
                {"6", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1121)"},
                {"7", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1122)"},
                {"8", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1123)"},
                {"10", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=36)"},
                {"11", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=40)"},
                {"15", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=376)"},
                {"16", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=377)"},
                {"21", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=313)"},
                {"39", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=589)"},
                {"43", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1011)"},
                {"44", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=9)"},
                {"45", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=12)"},
                {"46", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=13)"},
                {"49", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1081)"},
                {"50", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1084)"},
                {"51", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1080)"},
                {"52", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1082)"},
                {"53", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1083)"},
                {"72", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1571)"},
                {"73", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1572)"}
        };
    }


    public static Object[][] ThirdSubCategory_KG_KG(){
        return new Object[][]{
                {"6", "1", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1140)"},
                {"7", "3", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1142)"},
                {"49", "1", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1081)"},
                {"49", "2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1081)"},
                {"49", "3", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1088)"},
                {"51", "1", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1081)"},
                {"51", "2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1081)"},
                {"51", "3", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1088)"},
                {"51", "4", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1081)"},
                {"52", "1", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1089)"},
                {"52", "2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=4 AND parent_id=1090)"},
                {"52", "3", "SELECT name FROM category WHERE lvl=4 AND parent_id=1092"},
                {"52", "4", "SELECT value FROM param_value WHERE param_id=11"},
                {"53", "2", "SELECT name FROM category WHERE lvl=4 AND parent_id=1092"},
                {"53", "3", "SELECT value FROM param_value WHERE param_id=11"},
                {"72", "1", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "2", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "3", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "4", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "5", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "6", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "7", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "8", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "9", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "10", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "11", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "12", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "13", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "14", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "15", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "16", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "17", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "18", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "19", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "20", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "21", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "22", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "23", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "24", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "25", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "26", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "27", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "28", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "29", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "30", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "31", "SELECT value FROM param_value WHERE param_id=9"},
                {"72", "32", "SELECT value FROM param_value WHERE param_id=9"},
        };
    }

    public static Object[][] MotorcyclesYearsOfManufacture_KG_KG() {
        return new Object[][]{
                {"45", "1", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "2", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "3", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "4", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "5", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "6", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "7", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "8", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "9", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "10", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "11", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "12", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "13", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "14", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "15", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "16", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "17", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"45", "18", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
        };
    }

    public static Object[][] FourthCategory_KG_KG () {
        return new Object[][]{
                {"43", "1", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "2", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "3", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "4", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "5", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "6", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "7", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "8", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "9", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "10", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "11", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "12", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "13", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "14", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "15", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "16", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "17", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "18", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "19", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "20", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "21", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "22", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "23", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "24", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "25", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "26", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "27", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "28", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "29", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "30", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "31", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "32", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "33", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "34", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "35", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "36", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "37", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "38", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "39", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "40", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "41", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "42", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "43", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "44", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "45", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "46", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "47", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "48", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "49", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "50", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "51", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "52", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "53", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "54", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "55", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "56", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "57", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "58", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "59", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "60", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "61", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "62", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "63", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "64", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "65", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "66", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "67", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "68", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "69", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"49", "70", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "71", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "72", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "73", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "74", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "75", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "76", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "77", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "78", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "79", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "80", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "81", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "82", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "83", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "84", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "85", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "86", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "87", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "88", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "89", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "90", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "91", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "92", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "93", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "94", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "95", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"49", "96", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "97", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "98", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "99", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "100", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "101", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "102", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "103", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "104", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "105", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "106", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "107", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "108", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "109", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "110", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},
                {"43", "111", "SELECT value FROM param_value WHERE param_id=4 AND id BETWEEN 1499 AND 1791"},

                //NUMBER OF ROOMS
                {"51", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                {"51", "2", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                {"51", "4", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                //{"52", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},
                //{"53", "1", "SELECT value FROM param_value WHERE id BETWEEN 1770 AND 1775 UNION ALL SELECT l_value FROM param_value_lang WHERE l_id=84"},

        };

    }
}

