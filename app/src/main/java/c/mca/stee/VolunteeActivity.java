package c.mca.stee;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class VolunteeActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private LinearLayoutManager linearLayoutManager;

    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voluntee);

        getSupportActionBar().setTitle("Member's");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        linearLayoutManager.setStackFromEnd(false);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Volunteer");
        databaseReference.keepSynced(true);

        recyclerView = findViewById(R.id.volunteer_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<VolunteerClass, VolunteerViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<VolunteerClass, VolunteerViewHolder>(
                        VolunteerClass.class,R.layout.volunteer_card_view,VolunteerViewHolder.class,databaseReference
                ) {
            @Override
            protected void populateViewHolder(VolunteerViewHolder viewHolder, VolunteerClass model, int position) {

                viewHolder.setVolName(model.getVolname());
                viewHolder.setVolEmail(model.getVolemail());
                viewHolder.setVolAddress(model.getVoladdress());
                viewHolder.setVolImage(getApplicationContext(),model.getVoluri());

            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
   public static  class VolunteerViewHolder extends RecyclerView.ViewHolder {


        private TextView vol_name,vol_email, vol_address;
        private ImageView vol_image;

        public VolunteerViewHolder(@NonNull View itemView) {
            super(itemView);

            vol_name = itemView.findViewById(R.id.volname);
            vol_email = itemView.findViewById(R.id.volemail);
            vol_address = itemView.findViewById(R.id.voladdress);
            vol_image = itemView.findViewById(R.id.vol_image);




        }
        public void setVolName(String volName)
        {
            vol_name.setText(volName);
        }

        public void setVolEmail(String volEmail)
        {
            vol_email.setText(volEmail);
        }

        public void setVolAddress(String volAddress)
        {
            vol_address.setText(volAddress);
        }

        public void setVolImage(Context ctx, String volImage)
        {
            Picasso.get().load(volImage).rotate(90,0,90).fit().into(vol_image);
        }


    }

}
