package Actions.GENERAL;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
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
}
