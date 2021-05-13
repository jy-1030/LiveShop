package tabian.com.example.igtest.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.igtest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import tabian.com.example.igtest.shop.category.CategoryAdapter;
import tabian.com.example.igtest.shop.category.CategoryModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link shopHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class shopHomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public shopHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment shopHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static shopHomeFragment newInstance(String param1, String param2) {
        shopHomeFragment fragment = new shopHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;

    //20210420 category icon
    private  List<CategoryModel> categoryModelList;
    private FirebaseFirestore firebaseFirestore;
    //20210420 category icon



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        //20210420 category icon

        categoryModelList = new ArrayList<CategoryModel>();


        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(),documentSnapshot.get("categoryName").toString()));

                            }

                            categoryAdapter.notifyDataSetChanged();
                        }else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

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




        ////////////////////horizontal product layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.clothing1,"質感前短後長滑料襯衫"," ","$339"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.jeanskirt,"春夏必備牛仔短裙","","$390"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.highheel,"前抓皺酒瓶跟鞋"," ","$1099"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.blacktop,"黑色洋裝","","$599"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.perfume,"Chanel Modern COCO"," ","$2590"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.toys_shark,"鯊魚填充娃娃"," ","$499"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.washing_machine,"滾筒洗衣機"," ","$33990"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.sports_shoes,"慢跑鞋"," ","$2150"));
        ////////////////////horizontal product layout


        //////////////////////////////////////////////////////////

        testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();

        homePageModelList.add(new HomePageModel(0,sliderModelList)); //type:0 ad slider
        homePageModelList.add(new HomePageModel(3,"為您推薦",horizontalProductScrollModelList)); //type:3 gridproduct
        homePageModelList.add(new HomePageModel(1,R.drawable.strip_ad_2,"#ffffff"));
        homePageModelList.add(new HomePageModel(2,"本日精選",horizontalProductScrollModelList)); //type:2 horiozntal product
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad_1,"#ffffff"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //////////////////////////////////////////////////////////

        return view;
    }



}