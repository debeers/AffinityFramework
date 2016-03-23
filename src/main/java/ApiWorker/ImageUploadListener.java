package ApiWorker;

/**
 * Created by artem on 1/5/16.
 */
public interface ImageUploadListener {

    void onCompleted(String uploadId);

    void onError(String uploadId);

    void onProgress(String uploadId, int progress);

    void onStart(String uploadId);

}