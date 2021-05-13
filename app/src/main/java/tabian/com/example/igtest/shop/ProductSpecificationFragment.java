package tabian.com.example.igtest.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.igtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductSpecificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductSpecificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductSpecificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView productSpecificationRecyclerView;

    public static ProductSpecificationFragment newInstance(String param1, String param2) {
        ProductSpecificationFragment fragment = new ProductSpecificationFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_specification, container,false);

        productSpecificationRecyclerView = view.findViewById(R.id.product_specification_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        productSpecificationRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationModel> productSpecificationModelList = new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"尺碼參考"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"顏色", "咖色"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"尺寸", "F"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"衣長", "前65 後82"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"胸圍", "60"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"袖長", "70"));


//        productSpecificationModelList.add(new ProductSpecificationModel(0,"Display"));
//        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM", "4GB"));
//        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM", "4GB"));
//        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM", "4GB"));
//        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM", "4GB"));
//        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM", "4GB"));




        ProductSpecificationAdapter productSpecificationAdapter = new ProductSpecificationAdapter(productSpecificationModelList);
        productSpecificationRecyclerView.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();

        return  view;
    }
}