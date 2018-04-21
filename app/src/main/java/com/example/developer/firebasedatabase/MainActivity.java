package com.example.developer.firebasedatabase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView IpoName,Lot,Oferprice,Eps,Nav;
    private String imgurl = "";
    private ImageView Imageurl;
    private Firebase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IpoName=findViewById(R.id.iponame);
        Lot=findViewById(R.id.lot);
        Oferprice=findViewById(R.id.oferprice);
        Eps=findViewById(R.id.eps);
        Nav=findViewById(R.id.nav);
        Imageurl=findViewById(R.id.img);





        mRef = new Firebase("https://realtimedatabase-bc92c.firebaseio.com/");
        mRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);
                String ipoName = map.get("iponame");
                IpoName.setText(ipoName);
                String loT = map.get("lot");
                Lot.setText(loT);
                String oferPrice = map.get("oferprice");
                Oferprice.setText(oferPrice);
                String eps = map.get("eps");
                Eps.setText(eps);
                String nav = map.get("nav");
                Nav.setText(nav);
                String url = map.get("url");
                Picasso.get().load(url).into(Imageurl);


            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
