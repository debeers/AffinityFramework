package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 25.03.2016.
 */
public class YourPostPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//div[@class='adv']/h1")
    public WebElement postTitle;

    @FindBy(xpath = ".//div[@class='clearfix']//dl[2]//dd")
    public WebElement city;

    @FindBy(xpath = ".//div[@class='clearfix']//dl[1]//dd/span")
    public WebElement price;

    @FindBy(xpath = ".//div[@class='adv-desc']")
    public WebElement description;

    @FindBy(xpath = ".//ol[@class='category-breadcrumbs']/li")
    public List<WebElement> breadcrumbs;

    public String getPostTitle(){
        return $(postTitle).shouldBe(Condition.visible).getText();
    }

    public String getCity(){
        return $(city).shouldBe(Condition.visible).getText();
    }

    public String getPriceString(){
        return $(price).shouldBe(Condition.visible).getText();
    }

    public String getDescription(){
        return $(description).shouldBe(Condition.visible).getText();
    }

    public List<WebElement> getListOfBreadcrumbs(){
        return breadcrumbs;
    }

    public List<String> getHREFvalueFromListOfBreadcrumbs(){

        List<String> hrefs = new ArrayList<>();
        for (SelenideElement b : $$(breadcrumbs))
        //$$(breadcrumbs).stream().forEach((SelenideElement b) ->
        {

            System.out.println("Breadcrumb HREF found:::   " + b.getAttribute("href"));
            hrefs.add(b.getAttribute("href"));
        }
        return hrefs;
    }

    public List<String> getTextsFromListOfBreadcrumbs(){

        List<String> hrefs = new ArrayList<>();
        $$(breadcrumbs).stream().forEach((b)-> {

            System.out.println("Breadcrumb found:::   " + b);
            hrefs.add(b.getText());

        });
        return hrefs;
    }

    public boolean checkForYourBreadcrumbExsistByText(String compareBreadcrumb){

        final boolean[] chk = new boolean[1];
        getTextsFromListOfBreadcrumbs()
                .stream()
                .forEach((p) -> {

                    if (p.contains(compareBreadcrumb)) {
                        System.out.println("Breadcrumb found! ===>>> " + p);
                        chk[0] = true;
                    } else
                        System.out.println("Breadcrumb does not exist!");

                });

            return chk[0];
    }

    public boolean checkForYourBreadcrumbExsistByHREFValue(String compareBreadcrumbHREFValue){

        final boolean[] chk = new boolean[1];
        getHREFvalueFromListOfBreadcrumbs()
                .stream()
                .forEach((p) -> {

                    if (p.contains(compareBreadcrumbHREFValue)) {
                        System.out.println("Breadcrumb found! ===>>> " + p);
                        chk[0] = true;
                    } else
                        System.out.println("Breadcrumb does not exist!");

                });

        return chk[0];
    }

    public String getCurrency(){
        return getPriceString().subSequence(0, 1).toString();
    }

    public String getPrice(){
        return getPriceString().subSequence(2, 4).toString();
    }

    public YourPostPage(WebDriver driver) {
        super(driver);
    }
}
