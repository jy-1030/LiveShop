package tabian.com.example.igtest.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.igtest.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {

    //UI views

    FloatingActionButton addVideosBtn;
    private RecyclerView videosRv;
    private ArrayList<ModelVideo> videoArrayList;

    private AdapterVideo adapterVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        //change actionbar title

        setTitle("Videos");

        //init UI views
        addVideosBtn = findViewById(R.id.addVideosBtn);
        videosRv = findViewById(R.id.videosRv);



        loadVideosFromFirebase ();
        //handle click
        addVideosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start activity to add videos
                Intent intent = new Intent();
                intent.setClass(VideosActivity.this,AddVideoActivity.class);
                startActivity(intent);
                //startActivity(new Intent(VideosActivity.this,AddVideoActivity.class));
            }
        });



    }

    private void loadVideosFromFirebase() {
        videoArrayList = new ArrayList<>();
        DatabaseReference ref  = FirebaseDatabase.getInstance().getReference("Videos");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                videoArrayList.clear();
                for(DataSnapshot ds:snapshot.getChildren()){
                    ModelVideo modelVideo = ds.getValue(ModelVideo.class);
                    videoArrayList.add(modelVideo);
                }
                adapterVideo = new AdapterVideo(VideosActivity.this,videoArrayList);
                videosRv.setAdapter(adapterVideo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}