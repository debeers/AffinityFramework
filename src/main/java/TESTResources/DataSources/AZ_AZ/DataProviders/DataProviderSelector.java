package TESTResources.DataSources.AZ_AZ.DataProviders;

import com.google.common.collect.Lists;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

import static TESTResources.DataSources.AZ_AZ.DataProviders.DataProvidersForCategories.*;

/**
 * Created by DeBeers on 09.04.2016.
 */
public class DataProviderSelector {

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

    @DataProvider(name = "propertyParametersCheck")
    public static Object[][] propertyParametersCheck(ITestContext context) {
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTPropertyParametersCheck_AZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(PropertyParametersCheck_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTPropertyParametersCheck_AZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(PropertyParametersCheck_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTPropertyParametersCheck_KG_KG".equals(testName)) {
            result.addAll(Arrays.asList(PropertyParametersCheck_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTPropertyParametersCheck_KG_RU".equals(testName)) {
            result.addAll(Arrays.asList(PropertyParametersCheck_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name = "jobOffersCheck")
    public static Object[][] jobOffersCheck(ITestContext context) {
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTJobOffersCheck_AZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(JobOffersCheck_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTJobOffersCheck_AZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(JobOffersCheck_AZ_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTJobOffersCheck_KG_KG".equals(testName)) {
            result.addAll(Arrays.asList(JobOffersCheck_KG_KG()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTJobOffersCheck_KG_RU".equals(testName)) {
            result.addAll(Arrays.asList(JobOffersCheck_KG_RU()));
            return result.toArray(new Object[result.size()][]);
        }
        return new Object[][]{{"Common test data"}};
    }

    @DataProvider(name = "lookingForJobCheck")
    public static Object[][] lookingForJobCheck(ITestContext context) {
        List<Object[]> result = Lists.newArrayList();
        String testName = context.getName();

        if ("TESTLookingForJobCheck_AZ_AZ".equals(testName)) {
            result.addAll(Arrays.asList(LookingForJobCheck_AZ_AZ()));
            return result.toArray(new Object[result.size()][]);
        }
        else if ("TESTLookingForJobCheck_AZ_RU".equals(testName)) {
            result.addAll(Arrays.asList(LookingForJobCheck_AZ_RU()));
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
}

