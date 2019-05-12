package c.mca.stee;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        getSupportActionBar().setTitle("NewsFeed");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("News");

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        databaseReference.keepSynced(true);
        recyclerView = findViewById(R.id.news_recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<NewsClass, NewsViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<NewsClass, NewsViewHolder>(
                NewsClass.class,R.layout. news_card_view,NewsViewHolder.class,databaseReference
        ) {
            @Override
            protected void populateViewHolder(NewsViewHolder viewHolder, NewsClass model, int position) {
                viewHolder.setTitle(model.getHeadline());
                viewHolder.setDesc(model.getDescription());
                viewHolder.setImage(getApplicationContext(), model.getImage());


            }
        };
        recyclerView.setAdapter ( firebaseRecyclerAdapter );
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {


        private TextView post_title, post_desc;
        private ImageView post_image;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            post_title = itemView.findViewById ( R.id.post_title );
            post_desc = itemView.findViewById ( R.id.post_desc );
            post_image = itemView.findViewById ( R.id.post_image );

        }
        public void setTitle (String Title) {

            post_title.setText ( Title );

        }

        public void setDesc (String desc) {

            post_desc.setText ( desc );
        }

        public void setImage (Context ctx, String image) {

            Picasso.get().load ( image ).into ( post_image );


        }
    }

}
