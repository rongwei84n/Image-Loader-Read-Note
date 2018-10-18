package jpushdemo.sandy.com.android_universal_image_loader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.img_test);

        ImageLoader imageLoader = ImageLoader.getInstance();

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_launcher_background) // resource or drawable
                .showImageForEmptyUri(R.drawable.ic_launcher_background) // resource or drawable
                .showImageOnFail(R.drawable.ic_launcher_background) // resource or drawable
                .resetViewBeforeLoading(false)  // default
                .delayBeforeLoading(1000)
                .postProcessor(new BitmapProcessor() {
                    @Override
                    public Bitmap process(Bitmap bitmap) {
                        Log.d("sandy", "process bitmap...");
                        return bitmap;
                    }
                })
                .showImageOnLoading(R.drawable.ic_launcher_foreground)
//                .displayer(new RoundedBitmapDisplayer(5))
                .cacheInMemory(false) // default
                .cacheOnDisk(false) // default
		        .considerExifParams(false) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .build();

        imageLoader.displayImage("http://img3.imgtn.bdimg.com/it/u=2200166214,500725521&fm=27&gp=0.jpg",
                imageView, options, new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        Log.d("sandy", "onLoadingStarted imageUri: " + imageUri);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                        Log.d("sandy", "onLoadingFailed imageUri: " + imageUri
                        + " failReason: " + failReason);
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        Log.d("sandy", "onLoadingComplete imageUri: " + imageUri);
                    }

                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {
                        Log.d("sandy", "onLoadingCancelled imageUri: " + imageUri);
                    }
                }, new ImageLoadingProgressListener(){
                    @Override
                    public void onProgressUpdate(String imageUri, View view, int current, int total) {
                        Log.d("sandy", "onProgressUpdate current: " + current + " total: " + total);
                    }
                });
    }
}
