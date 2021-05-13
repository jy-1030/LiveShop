package tabian.com.example.igtest.materialcamera;

import android.app.Fragment;
import androidx.annotation.NonNull;

import tabian.com.example.igtest.materialcamera.internal.BaseCaptureActivity;
import tabian.com.example.igtest.materialcamera.internal.CameraFragment;

public class CaptureActivity extends BaseCaptureActivity {

  @Override
  @NonNull
  public Fragment getFragment() {
    return CameraFragment.newInstance();
  }
}
