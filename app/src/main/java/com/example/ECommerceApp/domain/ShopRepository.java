package com.example.ECommerceApp.domain;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.ECommerceApp.utils.AndroidUtil;
import com.example.ECommerceApp.utils.FirebaseUtil;
import com.google.android.gms.tasks.OnFailureListener;
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
    private String shopId;

    public interface OnShopSaveListener {
        void onShopSaved(String shopId);
    }

    public ShopRepository(Context context) {
        db = FirebaseFirestore.getInstance();
        timestamp = Timestamp.now();
        shopCollection = db.collection("shop");
        this.context = context;
    }


    public void saveShop(String shopName, String phoneNumber, String shopAddress, String profileImage, String bannerImage, OnShopSaveListener listener){{
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
                        String shopId = documentReference.getId(); // Retrieve the shop ID
                        AndroidUtil.showToast(context, "Create Successfully");
                        listener.onShopSaved(shopId); // Pass the shop ID to the listener
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        AndroidUtil.showToast(context, "Create Failed");
                    }
                });
    }
    }
}
