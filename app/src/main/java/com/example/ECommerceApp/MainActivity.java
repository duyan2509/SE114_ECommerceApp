package com.example.ECommerceApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.core.splashscreen.SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_main);



        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.on_boarding,"Various Collection Of The Latest Products",  ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.onboarding1, "Complete Collection Of Colors And Sizes", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.onboarding2,"Find The Most Suitable Outfit For You", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.onboarding3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        skipAuth();



    }
    private void skipAuth(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
            startActivity(new Intent(MainActivity.this,UserActivity.class));
        else return;
    }
    public void signUp(View view){
        startActivity(new Intent(MainActivity.this, com.example.ECommerceApp.SignUp_Activity.class));
    }

    public void signIn(View view){
        startActivity(new Intent(MainActivity.this, com.example.ECommerceApp.SignIn_Activity.class));
    }
}