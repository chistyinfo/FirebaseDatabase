package com.example.developer.firebasedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView IpoName,Lot,Oferprice;
    private FirebaseDatabase fbd = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = fbd.getReference();
    private DatabaseReference mChildReferenceName = mRootReference.child("iponame");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IpoName=findViewById(R.id.iponame);
        Lot=findViewById(R.id.iponame);
        Oferprice=findViewById(R.id.oferprice);
    }

    protected void onStart(){
        super.onStart();
        mChildReferenceName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String iponame = dataSnapshot.getValue(String.class);
                IpoName.setText(iponame);
                String lot = dataSnapshot.getValue(String.class);
                Lot.setText(lot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        mChildReferenceLot.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String lot = dataSnapshot.getValue(String.class);
//                Lot.setText(lot);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        mChildReferenceOferprice.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String oferprice = dataSnapshot.getValue(String.class);
//                Oferprice.setText(oferprice);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
