package ApiWorker;

/**
 * Created by artem on 2/19/15.
 */
public interface PullToRefreshRequestListener<T> {

    void onStartRequest(int pageNum);

    void onSuccess(T result, int pageNum);

    void onError(String text);
}