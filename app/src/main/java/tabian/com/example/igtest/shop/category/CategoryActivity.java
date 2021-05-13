package tabian.com.example.igtest.shop.category;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.igtest.R;

import java.util.ArrayList;
import java.util.List;

import tabian.com.example.igtest.shop.HomePageAdapter;
import tabian.com.example.igtest.shop.HomePageModel;
import tabian.com.example.igtest.shop.HorizontalProductScrollModel;
import tabian.com.example.igtest.shop.SliderModel;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CatgoryName");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

        //20210420 banner

        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner1));
        sliderModelList.add(new SliderModel(R.drawable.banner2));

        sliderModelList.add(new SliderModel(R.drawable.banner3));
        sliderModelList.add(new SliderModel(R.drawable.banner4));
        sliderModelList.add(new SliderModel(R.drawable.banner5));
        sliderModelList.add(new SliderModel(R.drawable.banner6));
        sliderModelList.add(new SliderModel(R.drawable.banner3));
        sliderModelList.add(new SliderModel(R.drawable.banner2));
        sliderModelList.add(new SliderModel(R.drawable.banner6));
        sliderModelList.add(new SliderModel(R.drawable.banner1));

        sliderModelList.add(new SliderModel(R.drawable.banner6));
        sliderModelList.add(new SliderModel(R.drawable.banner5));

        //20210420 banner


        //////////////////////horizontal prduct layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.notebook1,"文書輕薄"," ","$15900"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.nb2,"效能電競","","$33900"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.nb3,"商務辦公"," ","$28900"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.nb4,"剪片繪圖","","$39900"));



        //testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);


        List<HomePageModel> homePageModelList = new ArrayList<>();
//
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner2,"#ffffff"));
        homePageModelList.add(new HomePageModel(2,"效能筆電",horizontalProductScrollModelList));
//        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
//        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
//        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
//        homePageModelList.add(new HomePageModel(0,sliderModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //handle action bar item clicks here.
        int id = item.getItemId();

        //noinspection simplifiableIfStatement
        if (id == R.id.main_search_icon) {
            //todo:search
            return true;
        }else if (id == android.R.id.home){

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}