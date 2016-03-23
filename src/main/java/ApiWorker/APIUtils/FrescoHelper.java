package ApiWorker.APIUtils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewTreeObserver;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import classifieds.yalla.R;
import classifieds.yalla.ui.widget.zoom.ZoomDraweeView;

/**
 * Created by artem on 2/28/16.
 */
public class FrescoHelper {

    public static void loadImageFromNetwork(DraweeView view, String url) {

        loadImageFromNetwork(view, url, null);
    }

    public static void loadImageFromNetwork(DraweeView view, String url, ControllerListener controllerListener) {

        if (TextUtils.isEmpty(url)) {

            view.setImageURI(null);
            return;
        }

        loadImage(view, Uri.parse(url), controllerListener, true);
    }

    public static void loadImageFromDrawable(DraweeView view, int resId) {

        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                .path(String.valueOf(resId))
                .build();

        loadImage(view, uri, null, false);
    }

    public static void loadImageFromFile(DraweeView view, String path, ControllerListener controllerListener) {

        if (TextUtils.isEmpty(path)) {

            view.setImageURI(null);
            return;
        }

        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_FILE_SCHEME)
                .path(path)
                .build();

        loadImage(view, uri, controllerListener, false);
    }

    public static void loadImage(final DraweeView view, final Uri uri, final ControllerListener controllerListener, final boolean progressive) {

        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {

                view.getViewTreeObserver().removeOnPreDrawListener(this);

                ImageRequestBuilder requestBuilder = ImageRequestBuilder
                        .newBuilderWithSource(uri)
                        .setAutoRotateEnabled(true)
                        .setProgressiveRenderingEnabled(progressive);

                int width = view.getWidth();
                int height = view.getHeight();
                if (width > 0 && height > 0)
                    requestBuilder.setResizeOptions(new ResizeOptions(width, height));

                PipelineDraweeControllerBuilder controllerBuilder = Fresco.newDraweeControllerBuilder();

                if (controllerListener != null)
                    controllerBuilder.setControllerListener(controllerListener);

                controllerBuilder
                        .setImageRequest(requestBuilder.build())
                        .setOldController(view.getController())
                        .build();
                view.setController(controllerBuilder.build());

                return true;
            }
        });
    }

    public static ZoomDraweeView createZoomDraweeView(Context ctx) {

        ZoomDraweeView view = new ZoomDraweeView(ctx);

        Drawable camera = ctx.getResources().getDrawable(R.drawable.ic_camera);

        GenericDraweeHierarchy hierarchy =
                new GenericDraweeHierarchyBuilder(ctx.getResources())
                        .setFailureImage(camera, ScalingUtils.ScaleType.CENTER_INSIDE)
                        .setPlaceholderImage(camera, ScalingUtils.ScaleType.CENTER_INSIDE)
                        .setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER)
                        .setProgressBarImage(new ProgressBarDrawable())
                        .build();

        view.setHierarchy(hierarchy);

        return view;
    }
}
