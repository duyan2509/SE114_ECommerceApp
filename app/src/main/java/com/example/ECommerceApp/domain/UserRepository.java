package com.example.ECommerceApp.domain;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.ECommerceApp.UserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private FirebaseAuth auth;
    private Context context;
    private FirebaseFirestore db;
    private Timestamp timestamp;


    public UserRepository(Context context) {
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        timestamp = Timestamp.now();
        this.context = context;
    }

    public boolean checkUserIsLoggedIn(){
        return auth.getCurrentUser() != null;
    }

    public void createUser(Context context, EditText email, EditText username, EditText password) {
        String userName = username.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        //Create user
        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(context, "User Created!", Toast.LENGTH_SHORT).show();
                    String userId = auth.getCurrentUser().getUid();
                    saveUser(userId, userName, userEmail, userPassword, timestamp);
                    navigateToHomepage();

                }else {
                    Toast.makeText(context, "Error " + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void createUserWithEmail(String email) {
        //
        Query query = db.collection("users").whereEqualTo("email", email);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.getResult().isEmpty()) {
                    String userId = auth.getCurrentUser().getUid();
                    String userName = email.substring(0,email.indexOf('@'));
                    saveUser(userId,userName,email,null, timestamp);
                }

            }
        });
    }

    public void navigateToHomepage() {
        Intent intent = new Intent(context, UserActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); // Clear back stack
        context.startActivity(intent);
    }

    public void saveUser(String userId, String userName,String userEmail, String userPassword, Timestamp timestamp ){
        DocumentReference documentReference = db.collection("users").document(userId);
        Map<String, Object> user = new HashMap<>();
        user.put("username", userName);
        user.put("password", userPassword);
        user.put("email", userEmail);
        user.put("createdTimestamp", timestamp);

        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("TAG", "onSuccess: User " + userId + "is created!");
            }
        });


    }
}
