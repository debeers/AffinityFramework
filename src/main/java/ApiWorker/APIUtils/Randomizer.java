package ApiWorker.APIUtils;

/**
 * Created by artem on 11/13/15.
 */
public class Randomizer {

    public static int generate(int min, int max) {

        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
