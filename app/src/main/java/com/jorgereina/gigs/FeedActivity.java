package com.jorgereina.gigs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jorgereina.gigs.model.User;
import com.squareup.picasso.Picasso;

public class FeedActivity extends AppCompatActivity {

    ListView dataLv;
    DatabaseReference databaseReference;
    FirebaseListAdapter<User> firebaseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        initView();


        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");

        firebaseListAdapter = new FirebaseListAdapter<User>(this, User.class, R.layout.row, databaseReference) {
            @Override
            protected void populateView(View v, User model, int position) {
//
                TextView textView = (TextView) v.findViewById(R.id.username_tv);
                textView.setText(model.getUserName());
                ImageView imageView = (ImageView) v.findViewById(R.id.main_user_iv);
                Picasso.with(getApplicationContext()).load(R.mipmap.ic_launcher).into(imageView);
            }
        };

        dataLv.setAdapter(firebaseListAdapter);
        firebaseListAdapter.notifyDataSetChanged();

    }

    public void initView(){
        dataLv  = (ListView) findViewById(R.id.data_lv);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        menu.add("add user");
        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                databaseReference.push().setValue(new User("hello", "lol"));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
