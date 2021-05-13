package tabian.com.example.igtest.materialcamera;

import android.app.Fragment;
import androidx.annotation.NonNull;
import tabian.com.example.igtest.materialcamera.internal.BaseCaptureActivity;
import tabian.com.example.igtest.materialcamera.internal.Camera2Fragment;


public class CaptureActivity2 extends BaseCaptureActivity {

  @Override
  @NonNull
  public Fragment getFragment() {
    return Camera2Fragment.newInstance();
  }
}
