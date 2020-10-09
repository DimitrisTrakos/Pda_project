package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUserName,txtPassword;
    TextView txtLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUserName=findViewById(R.id.txtUserName);
        txtPassword=findViewById(R.id.textPassword);
        btnLogin=findViewById(R.id.btnLogin);
        txtLogin =findViewById(R.id.txtLogin);


        FirebaseDatabase database =FirebaseDatabase.getInstance();
        final DatabaseReference table_user =database.getReference("User");


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();


                table_user.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange( DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(txtUserName.getText().toString()).exists())
                        {

                            mDialog.dismiss();

                            User user = dataSnapshot.child(txtUserName.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(txtPassword.getText().toString())) {
                                Toast.makeText(LoginActivity.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Wrong Password!", Toast.LENGTH_SHORT).show();
                            }
                        } else
                        {
                            mDialog.dismiss();
                            Toast.makeText(LoginActivity.this,"User not exist in Database",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled( DatabaseError databaseError) {

                    }
                });

        }






    });





    }
}