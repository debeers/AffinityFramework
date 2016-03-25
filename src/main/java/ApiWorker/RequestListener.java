package ApiWorker;

/**
 * Created by artem on 2/19/15.
 */
public interface RequestListener<T> {

    void onStartRequest();

    void onSuccess(T result);

    void onError(String text);
}
