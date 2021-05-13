package tabian.com.example.igtest.shop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.igtest.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImagesViewpager;
    private TabLayout viewpagerIndicator;


    private ViewPager productDetailsViewpager;
    private TabLayout productDetailsTabLayout;

    ////product heart 20210409
    private ImageView heart;
    boolean isChanged = false;
    ////product heart 20210409

    ////rating layout
    private LinearLayout rateNowContainer;
    ////rating layout

    private Button buyNowBtn;
    //20210509
//    private Button addToCartBtn;
//    private Context context;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        productImagesViewpager = findViewById(R.id.product_images_viewpager);
        viewpagerIndicator = findViewById(R.id.viewpager_indicator);


        productDetailsViewpager = findViewById(R.id.product_details_viewpager);
        productDetailsTabLayout = findViewById(R.id.product_details_tablayout);
        buyNowBtn = findViewById(R.id.buy_now_btn);
        //202010509
       // addToCartBtn = findViewById(R.id.add_to_cart_btn);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.clothing1);
        productImages.add(R.drawable.clothing2);


        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewpager.setAdapter(productImagesAdapter);

        viewpagerIndicator.setupWithViewPager(productImagesViewpager, true);


        ////product heart 20210409
        heart = (ImageView)findViewById(R.id.product_heart_white);
        heart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (v == heart) {
                    if (isChanged) {
                        heart.setImageDrawable(getResources().getDrawable(R.drawable.ic_heart_white));
                    } else {
                        heart.setImageDrawable(getResources().getDrawable(R.drawable.ic_heart_red));
                    }

                    isChanged = !isChanged;
                }
            }
        });
        ////product heart 20210409

        productDetailsViewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(), productDetailsTabLayout.getTabCount()));
        productDetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));
        productDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ////rating layout
        rateNowContainer = findViewById(R.id.rate_now_container);
        for(int x = 0;x<rateNowContainer.getChildCount();x++){
            final int starPosition = x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }
            });
        }
        ////rating layout

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deliveryIntent = new Intent(ProductDetailsActivity.this,DeliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });


        //20210509
//        addToCartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    //Toast.makeText(context, "already add in shopping cart!!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void setRating(int starPosition) {
        for(int x = 0;x<rateNowContainer.getChildCount();x++){
            ImageView starBtn = (ImageView)rateNowContainer.getChildAt(x);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if(x<=starPosition){
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle action bar item clicks here.
        int id = item.getItemId();

        //noinspection simplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.main_search_icon) {
            //todo:notificaiton
            return true;
        } else if (id == R.id.main_cart_icon) {
            //todo:cart
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}