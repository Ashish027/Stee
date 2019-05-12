package c.mca.stee;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonationActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private LinearLayoutManager linearLayoutManager;

    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);


        getSupportActionBar().setTitle("Donation");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        linearLayoutManager.setStackFromEnd(true);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Donation");
        databaseReference.keepSynced(true);

        recyclerView = findViewById(R.id.donation_recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);



    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<DonationClass,DonationViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<DonationClass, DonationViewHolder>(
                        DonationClass.class,R.layout.donation_card_view,DonationViewHolder.class,databaseReference


                ) {
                    @Override
                    protected void populateViewHolder(DonationViewHolder viewHolder, DonationClass model, int position) {

                        viewHolder.setdonname(model.getDname());
                        viewHolder.setdonemail(model.getDemail());


                        viewHolder.setoccupation(model.getDoccupation());
                        viewHolder.setdonmoney(model.getDmoney());
                        viewHolder.setdoncloth(model.getDcloth());
                        viewHolder.setdonfood(model.getDfood());
                        viewHolder.setdonstationary(model.getDstationary());

                    }
                };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

   public static class DonationViewHolder  extends RecyclerView.ViewHolder {


        private TextView donName,donEmail,donOccname,donType,donMoney, donStationary;
        private TextView donCloth, donFood;

        public DonationViewHolder(@NonNull View itemView) {
            super(itemView);

            donName = itemView.findViewById(R.id.don_name);
            donEmail = itemView.findViewById(R.id.don_Email);
            donOccname = itemView.findViewById(R.id.don_Occupation);
            donType = itemView.findViewById(R.id.don_type);
            donMoney =    itemView.findViewById(R.id.don_Money);
            donCloth = itemView.findViewById(R.id.don_Cloth);
            donStationary = itemView.findViewById(R.id.don_Stationary);
            donFood = itemView.findViewById(R.id.don_Food);
        }

        public void setdonname(String donname) {
            donName.setText(donname);
        }

        public void setdonemail(String donemail) {
            donEmail.setText(donemail);
        }



        public void setoccupation(String donoccupation) {
            donOccname.setText(donoccupation);
        }

        public void setdontype(String dontype) {
            donType.setText(dontype);

        }


        public void setdonmoney(String donmoney) {
            donMoney.setText(donmoney);
        }

        public void setdonstationary(String donstationary) {
            donStationary.setText(donstationary);
        }
        public void setdoncloth(String doncloth) {
            donCloth.setText(doncloth);
        }

        public void setdonfood(String donfood) {
            donFood.setText(donfood);
        }
    }
}
