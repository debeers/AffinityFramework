package GeneralHelpers;

import junit.framework.Assert;

import java.util.List;

/**
 * Created by DeBeers on 09.04.2016.
 */
public class General {

    public static void compareLists(List<String> etalon, List<String> compare){


if(!etalon.containsAll(compare) ){
    compare.removeAll(etalon);
   // Assert.assertSame();
}

    }
}
