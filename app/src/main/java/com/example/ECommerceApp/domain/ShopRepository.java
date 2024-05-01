package com.example.ECommerceApp.domain;

import android.content.Context;

import com.example.ECommerceApp.utils.AndroidUtil;
import com.example.ECommerceApp.utils.FirebaseUtil;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ShopRepository {
    private Context context;
    private FirebaseFirestore db;
    private Timestamp timestamp;
    private CollectionReference shopCollection;

    public ShopRepository(Context context) {
        db = FirebaseFirestore.getInstance();
        timestamp = Timestamp.now();
        shopCollection = db.collection("shop");
        this.context = context;
    }


    public void saveShop(String shopName,String phoneNumber, String shopAddress, String profileImage, String bannerImage){
        Map<String, Object> shop = new HashMap<>();

        shop.put("userId", FirebaseUtil.currentUserId());
        shop.put("shopName", shopName);
        shop.put("phoneNumber", phoneNumber);
        shop.put("shopAddress", shopAddress);
        shop.put("profileImage", profileImage);
        shop.put("bannerImage", bannerImage);
        shop.put("createdTimestamp", timestamp);

        shopCollection.add(shop)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        AndroidUtil.showToast(context, "Create Successfully");
                    }
                })
                .addOnFailureListener(e -> {
                    AndroidUtil.showToast(context, "Create Failed");
                });

    }
}
