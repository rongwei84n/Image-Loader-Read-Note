package jpushdemo.sandy.com.android_universal_image_loader;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800) // default = device screen ，默认为屏幕宽高 dimensions，内存缓存的最大宽高
                .diskCacheExtraOptions(480, 800, null)//磁盘缓存最大宽高,默认不限制
                .threadPriority(Thread.NORM_PRIORITY - 2) // default //线程优先级
                .denyCacheImageMultipleSizesInMemory() //阻止内存中多尺寸缓存
                .memoryCacheSize(2 * 1024 * 1024) //配置缓存大小
                .memoryCacheSizePercentage(13) // default //缓存百分比
                .diskCacheSize(50 * 1024 * 1024) //磁盘缓存大小，只在使用默认缓存有效
                .diskCacheFileCount(100)  //磁盘缓存文件数，只在使用默认缓存有效
                .writeDebugLogs() //打印调试日志
                .build();

//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.ic_launcher_background) // resource or drawable
//                .showImageForEmptyUri(R.drawable.ic_launcher_background) // resource or drawable
//                .showImageOnFail(R.drawable.ic_launcher_background) // resource or drawable
//                .resetViewBeforeLoading(false)  // default
//                .delayBeforeLoading(1000)
//                .cacheInMemory(false) // default
//                .cacheOnDisk(false) // default
//		        .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
//                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .build();


        ImageLoader.getInstance().init(config);//初始化
    }
}
