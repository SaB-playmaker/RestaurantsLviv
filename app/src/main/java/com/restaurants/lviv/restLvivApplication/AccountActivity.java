package com.restaurants.lviv.restLvivApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class AccountActivity extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name,email,role;
    Button signOutBtn,restBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        role = findViewById(R.id.role);
        signOutBtn = findViewById(R.id.signout);
        restBtn = findViewById(R.id.rest);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            String userRole =setUserRole(acct);
            name.setText(personName);
            email.setText(personEmail);
            role.setText(userRole);
        }

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        restBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rest(acct);
            }
        });


    }

    void signOut(){

        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(AccountActivity.this,LoginActivity.class));
            }
        });
    }

    void rest(GoogleSignInAccount acct){

        if(checkAdmin(acct)){

            Intent intent = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(intent);
        }else{

            Intent intent = new Intent(AccountActivity.this, RestaurantActivity.class);
            startActivity(intent);
        }
    }
    boolean checkAdmin(GoogleSignInAccount acct){
        if(acct.getEmail().equals("obezkorovainyi@morebis.net")){
            return  true;
    }
        return false;
    }
    String setUserRole(GoogleSignInAccount acct){
        if(checkAdmin(acct)){
            return "Admin";
        }
        return "User";
    }
}
