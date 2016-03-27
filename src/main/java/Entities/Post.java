package Entities;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class Post {

    private String category        = "";
    private String underCategory   = "";
    private String title           = "";
    private String description     = "";
    private String price           = "";
    private String currencyType    = "";
    private boolean isNegotiable   = false;
    private boolean isNegotiableOn = true;
    private String region          = "";
    private String privacyType     = "";
    private String name            = "";
    private String phone           = "";
    private boolean hideNumber     = false;
    private String email           = "";

    private File file1;
    private File file2;
    private File file3;
    private File file4;
    private File file5;


    private List<File> listOfFiles = new ArrayList<>();

    public Post(String category, String underCategory, String title, String description, String price,
                String currencyType, boolean isNegotiable, boolean isNegotiableOn, String region, String privacyType, String name,
                String phone, boolean hideNumber, String email, String file1, String file2, String file3,
                String file4, String file5) {

        this.category        = category;
        this.underCategory   = underCategory;
        this.title           = title;
        this.description     = description;
        this.price           = price;
        this.currencyType    = currencyType;
        this.isNegotiable    = isNegotiable;
        this.isNegotiableOn  = isNegotiableOn;
        this.region          = region;
        this.privacyType     = privacyType;
        this.name            = name;
        this.phone           = phone;
        this.hideNumber      = hideNumber;
        this.email           = email;

        listOfFiles.add(this.file1 = new File(file1));
        listOfFiles.add(this.file2 = new File(file2));
        listOfFiles.add(this.file3 = new File(file3));
        listOfFiles.add(this.file4 = new File(file4));
        listOfFiles.add(this.file5 = new File(file5));

        PostLogInfo();
    }

    public Post(Properties props) {
        this.category        = props.getProperty("CategoryIndex");
        this.underCategory   = props.getProperty("UnderCategoryIndex");
        this.title           = props.getProperty("PostTitle");
        this.description     = props.getProperty("Description") + RandomStringUtils.randomAlphabetic(50);
        this.price           = props.getProperty("Price");
        this.currencyType    = props.getProperty("CurrencyType");
        this.isNegotiable    = Boolean.parseBoolean(props.getProperty("IsNegotiable"));
        this.isNegotiableOn  = Boolean.parseBoolean(props.getProperty(""));
        this.region          = props.getProperty("RegionIndex");
        this.privacyType     = props.getProperty("PostAs");
        this.name            = props.getProperty("Name");
        this.phone           = props.getProperty("TelephoneNumber");
        this.hideNumber      = Boolean.parseBoolean(props.getProperty("HideNumber"));
        this.email           = props.getProperty("Email");

        listOfFiles.add(this.file1 = new File(props.getProperty("File1")));
        listOfFiles.add(this.file2 = new File(props.getProperty("File2")));
        listOfFiles.add(this.file3 = new File(props.getProperty("File3")));
        listOfFiles.add(this.file4 = new File(props.getProperty("File4")));
        listOfFiles.add(this.file5 = new File(props.getProperty("File5")));

        PostLogInfo();
    }

    private void PostLogInfo() {

        System.out.println("___________________________POST LOG INFO___________________________");
        System.out.println();
        System.out.println("CATEGORY INDEX:.............. " + this.getCategory());
        System.out.println("UNDERCATEGORY INDEX:......... " + this.getUnderCategory());
        System.out.println("POST TITLE:.................. " + this.getTitle());
        System.out.println("PRICE:....................... " + this.getPrice());
        System.out.println("CURRENCY TYPE:............... " + this.getCurrencyType());
        System.out.println("IS NEGOTIABLE:............... " + this.isNegotiable());
        System.out.println("IS NEGOTIABLE:............... " + this.isNegotiableOn());
        System.out.println("REGION INDEX:................ " + this.getRegion());
        System.out.println("POST AS:..................... " + this.getPrivacyType());
        System.out.println("USER NAME:................... " + this.getName());
        System.out.println("TELEPHONE NUMBER:............ " + this.getPhone());
        System.out.println("HIDE TELEPHONE NUMBER:....... " + this.isHideNumber());
        System.out.println("EMAIL:....................... " + this.getEmail());
        System.out.println("POST DESCRIPTION:............ " + this.getDescription());
        System.out.println("_____________________________________________________________________");
    }

    public List<File> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(List<File> listOfFiles) {
        this.listOfFiles = listOfFiles;
    }

    public String getCategory() {
        return category;
    }

    public String getUnderCategory() {
        return underCategory;
    }

    public void setUnderCategory(String underCategory) {
        this.underCategory = underCategory;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public boolean isNegotiable() {
        return isNegotiable;
    }

    public boolean isNegotiableOn() { return isNegotiableOn; }

    public void setIsNegotiable(boolean isNegotiable) {
        this.isNegotiable = isNegotiable;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPrivacyType() {
        return privacyType;
    }

    public void setPrivacyType(String privacyType) {
        this.privacyType = privacyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isHideNumber() {
        return hideNumber;
    }

    public void setHideNumber(boolean hideNumber) {
        this.hideNumber = hideNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public File getFile1() {
        return file1;
    }

    public void setFile1(File file1) {
        this.file1 = file1;
    }

    public File getFile2() {
        return file2;
    }

    public void setFile2(File file2) {
        this.file2 = file2;
    }

    public File getFile3() {
        return file3;
    }

    public void setFile3(File file3) {
        this.file3 = file3;
    }

    public File getFile4() {
        return file4;
    }

    public void setFile4(File file4) {
        this.file4 = file4;
    }

    public File getFile5() {
        return file5;
    }

    public void setFile5(File file5) {
        this.file5 = file5;
    }
}
