package c.mca.stee;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private LinearLayoutManager linearLayoutManager;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL
                ,true);
        linearLayoutManager.setStackFromEnd(true);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("POST");
        databaseReference.keepSynced(true);

        recyclerView = findViewById(R.id.Home_page_recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(linearLayoutManager);




    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

        FirebaseRecyclerAdapter<PostClass, PostViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<PostClass, PostViewHolder>(
                PostClass.class,R.layout.all_home_post_layout,PostViewHolder.class,
                        databaseReference
        )
                {

            @Override
            protected void populateViewHolder(final PostViewHolder viewHolder, PostClass model, int position) {
                viewHolder.setTitle(model.getPostTitle());
                viewHolder.setDesc(model.getPostdesp());
                viewHolder.setImage(getApplicationContext(), model.getUri());
                viewHolder.share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String desc,ptitle;
                        Drawable image;
                        desc = viewHolder.post_desc.getText().toString();
                        ptitle = viewHolder.postTitle.getText().toString();
                        image = viewHolder.post_image.getDrawable();

                        StringBuffer buffer = new StringBuffer();
                        buffer.append("\nTitle:- ");
                        buffer.append(ptitle);
                        buffer.append("\nDescription:- ");
                        buffer.append(desc);

                        buffer.append("\nImage:- ");
                        buffer.append(image);
                        //void shareImage(Bitmap bitmap,String text){

                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(android.content.Intent.EXTRA_TEXT,buffer.toString());
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);

                    }
                });


            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
    public static class PostViewHolder extends RecyclerView.ViewHolder {

        private ImageView post_image;

        private TextView postTitle,post_desc;
        private Button share;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            share = itemView.findViewById(R.id.post_share_btn);
            post_desc = itemView.findViewById(R.id.home_desp_post);
            post_image = itemView.findViewById(R.id.home_image_post);
            postTitle = itemView.findViewById(R.id.post_home_title);

        }

        public void setDesc(String desc) {

            post_desc.setText(desc);

        }
        public void setTitle(String title){
            postTitle.setText(title);

        }



        public void setImage(Context ctx, String image) {

            Picasso.get().load(image).fit().into(post_image);
            //Glide.with(ctx).load(image).fitCenter().into(post_image);



        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                Intent hintent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(hintent);

                break;

            case R.id.event:
                Intent eintent = new Intent(HomeActivity.this, EventActivity.class);
                startActivity(eintent);
                break;



            case R.id.news:
                Intent nintent = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(nintent);
                break;

            case R.id.contact:
                Intent cintent = new Intent(HomeActivity.this, ContactActivity.class);
                startActivity(cintent);
                break;

            case R.id.about:
                Intent aintent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(aintent);
                break;

            case R.id.volunteer:
                Intent vintent = new Intent(HomeActivity.this, VolunteeActivity.class);
                startActivity(vintent);
                break;

            case R.id.donation:
                Intent dintent = new Intent(HomeActivity.this, DonationActivity.class);
                startActivity(dintent);
                break;






        }
        return super.onOptionsItemSelected(item);


    }
}
