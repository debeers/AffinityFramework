package Actions.GENERAL;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dem on 06.05.2016.
 */
public class TrimAdvertsInformation {
    public static List<String> trimCategoryAndSubcategoryFromTheThumb(List<String> advertsInformation) {
        List<String> trimmedAdvertsInfo = new ArrayList<>();
        if (!advertsInformation.isEmpty()) {
            trimmedAdvertsInfo.addAll(advertsInformation.stream().map(temp -> StringUtils.substringBefore(temp, "|").toLowerCase().trim()).collect(Collectors.toList()));
        }
        System.out.println(trimmedAdvertsInfo);
        return trimmedAdvertsInfo;
    }

    public static List<String> trimCitiesFromTheThumb(List<String> advertsInformation) {
        List<String> trimmedAdvertsInfo = new ArrayList<>();
        List<String> trimmedAdvertsInfoFinal = new ArrayList<>();
        if (!advertsInformation.isEmpty()) {
            trimmedAdvertsInfo.addAll(advertsInformation.stream().map(temp -> StringUtils.substringAfter(temp, "|").toLowerCase().trim()).collect(Collectors.toList()));
        }

        if (!trimmedAdvertsInfo.isEmpty()) {
            trimmedAdvertsInfoFinal.addAll(trimmedAdvertsInfo.stream().map(temp -> StringUtils.substringBefore(temp, " ").toLowerCase().trim()).collect(Collectors.toList()));
        }
        return trimmedAdvertsInfoFinal;
    }

    public static List<String> trimUpdateTimeFromTheThumb(List<String> advertsInformation) {
        List<String> trimmedAdvertsInfo = new ArrayList<>();
        if (!advertsInformation.isEmpty()) {
            trimmedAdvertsInfo.addAll(advertsInformation.stream().map(temp -> temp.toLowerCase().trim()).collect(Collectors.toList()));
        }
        return trimmedAdvertsInfo;
    }

    public static List<String> trimSlashFromUpdateTimeListFromTheThumb(List<String> advertsInformation){
        List<String> updateTimeWithoutASlash = new ArrayList<>();
        List<String> updateTimeWithASlash = trimUpdateTimeFromTheThumb(advertsInformation);
        if (!advertsInformation.isEmpty()) {
            updateTimeWithoutASlash.addAll(updateTimeWithASlash.stream().map(temp -> temp.replace(" /", "")).collect(Collectors.toList()));
        }
        return updateTimeWithoutASlash;
    }

    public static List<String> sortUpdateTimeList(List<String> advertsInformation) {
        List<String> sortedUpdateTime = trimSlashFromUpdateTimeListFromTheThumb(advertsInformation);
        Collections.sort(sortedUpdateTime);
        return sortedUpdateTime;
    }

    public static String trimAdvertIdFromUrl(String advertUrl) {
        return StringUtils.substringAfterLast(advertUrl , "-");
    }
}
