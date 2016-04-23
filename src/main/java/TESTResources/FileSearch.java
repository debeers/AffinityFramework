package TESTResources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DeBeers on 13.04.2016.
 */
@SuppressWarnings("ALL")
public class FileSearch {

    private String fileNameToSearch;
    private List<String> result = new ArrayList<String>();

    public String getFileNameToSearch() {
        return fileNameToSearch;
    }

    public void setFileNameToSearch(String fileNameToSearch) {
        this.fileNameToSearch = fileNameToSearch;
    }

    public List<String> getResult() {
        return result;
    }


    public static String searchResources(String beginDirectory, String testName, String local) {

        FileSearch fileSearch = new FileSearch();
        System.out.println("=================  SEARCH .xml data::  " + "TEST" + testName + "_" + local + ".xml");

        fileSearch.searchDirectory(new File(beginDirectory), "TEST" + testName + local + "_" + ".xml");
        int count = fileSearch.getResult().size();
        if (count == 0) {
            System.out.println("\nNo result found!");
            return "############## NO FILES FOUND #############";
        } else {
            System.out.println("\nFound " + count + " result!\n");
            for (String matched : fileSearch.getResult()) {
                System.out.println("Found : " + matched);
                return matched;

            }
        }
        return "############## NO FILES FOUND #############";
    }

    private void searchDirectory(File directory, String fileNameToSearch) {

        setFileNameToSearch(fileNameToSearch);

        if (directory.isDirectory()) {
            search(directory);
        } else {
            System.out.println(directory.getAbsoluteFile() + " is not a directory!");
        }
    }

    private void search(File file) {

        if (file.isDirectory()) {
            System.out.println("Searching directory ... " + file.getAbsoluteFile());

            if (file.canRead()) {
                for (File temp : file.listFiles()) {
                    if (temp.isDirectory()) {
                        search(temp);
                    } else {
                        if (getFileNameToSearch().toLowerCase().equalsIgnoreCase(temp.getName().toLowerCase())) {
                            result.add(temp.getAbsoluteFile().toString());
                        }
                    }
                }

            } else {
                System.out.println(file.getAbsoluteFile() + "Permission Denied");
            }
        }
    }
}