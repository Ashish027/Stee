package c.mca.stee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private LinearLayoutManager linearLayoutManager;
//private StaggeredGridLayoutManager staggeredGridLayoutManager;


    //private ShareActionProvider shareActionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        getSupportActionBar().setTitle("Events");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        //staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL
                , true);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("event");
        databaseReference.keepSynced(true);

        recyclerView = findViewById(R.id.event_recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(linearLayoutManager);



    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<EventClass, EventClassViewHolder> firebaseRecyclerAdapter =

                new FirebaseRecyclerAdapter<EventClass, EventClassViewHolder>
                (EventClass.class,R.layout.event_cardview,EventClassViewHolder.class,databaseReference) {
            @Override
            protected void populateViewHolder(final EventClassViewHolder viewHolder,
                                              EventClass model, int position) {
                viewHolder.setTitle(model.getEventname());
                viewHolder.setDesp(model.getEventdescription());
                viewHolder.setDate(model.getEventdate());
                viewHolder.setTime(model.getEventtime());

                viewHolder.share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title,desc,date,time;
                        title=viewHolder.eventTitle.getText().toString();
                        desc=viewHolder.eventDesc.getText().toString();
                        date=viewHolder.eventDate.getText().toString();
                        time=viewHolder.eventTime.getText().toString();

                        StringBuffer buffer=new StringBuffer();
                        buffer.append("Title:- ");
                        buffer.append(title);
                        buffer.append("\nDescription:- ");
                        buffer.append(desc);
                        buffer.append("\nDate:- ");
                        buffer.append(date);
                        buffer.append("\nTime:- ");
                        buffer.append(time);
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
    public static class EventClassViewHolder extends RecyclerView.ViewHolder{

        private Button share;

        private TextView eventTitle,eventDate,eventTime,eventDesc;

        public EventClassViewHolder(View itemView){
            super(itemView);


            share = itemView.findViewById(R.id.btn_share);
            eventTitle=itemView.findViewById(R.id.event_title);
            eventDate=itemView.findViewById(R.id.event_date);
            eventTime=itemView.findViewById(R.id.event_time);
            eventDesc=itemView.findViewById(R.id.event_description);
        }



        public void setTitle(String title){

            eventTitle.setText(title);
        }
        public void setDesp(String desc){

            eventDesc.setText(desc);
        }
        public void setDate(String date){


            eventDate.setText(date);
        }
        public void setTime(String time){


            eventTime.setText(time);


        }



    }


}
