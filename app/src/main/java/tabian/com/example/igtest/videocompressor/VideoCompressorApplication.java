package tabian.com.example.igtest.videocompressor;

/*
 * By Jorge E. Hernandez (@lalongooo) 2015
 * */
import android.app.Application;

import tabian.com.example.igtest.videocompressor.file.FileUtils;

public class VideoCompressorApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FileUtils.createApplicationFolder();
    }

}