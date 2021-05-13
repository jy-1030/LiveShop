package tabian.com.example.igtest.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.igtest.R;
import com.google.android.exoplayer2.util.Log;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import tabian.com.example.igtest.Home.HomeActivity;
import tabian.com.example.igtest.Profile.ProfileActivity;
import tabian.com.example.igtest.Search.SearchActivity;
import tabian.com.example.igtest.Share.ShareActivity;
import tabian.com.example.igtest.shop.MainActivity;

//import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by User on 5/28/2017.
 */

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationView bottomNavigationView){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
//        bottomNavigationView.enableAnimation(false);
//        bottomNavigationView.enableItemShiftingMode(false);
//        bottomNavigationView.enableShiftingMode(false);
//        bottomNavigationView.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, final Activity callingActivity, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, HomeActivity.class);//ACTIVITY_NUM = 0
                        context.startActivity(intent1);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;

//                        shopfragment
                    case R.id.ic_search:
                        Intent intent2  = new Intent(context, MainActivity.class);//ACTIVITY_NUM = 1
                        context.startActivity(intent2);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;

//                        shopfragment


                    case R.id.ic_circle:
                        Intent intent3 = new Intent(context, ShareActivity.class);//ACTIVITY_NUM = 2
                        context.startActivity(intent3);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;

//                    20210414 searchactivity
                    case R.id.ic_alert:
                        Intent intent4  = new Intent(context, SearchActivity.class);//ACTIVITY_NUM = 3
                        context.startActivity(intent4);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
//20210414 searchactivity





                    case R.id.ic_android:
                        Intent intent5 = new Intent(context, ProfileActivity.class);//ACTIVITY_NUM = 4
                        context.startActivity(intent5);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }


                return false;
            }
        });
    }
}
