package com.example.ECommerceApp.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseUtil {
    public static String currentUserId(){
        return FirebaseAuth.getInstance().getUid();
    }

    public static StorageReference getCurrentPicStorageRef(String path){
        return FirebaseStorage.getInstance().getReference().child(path)
                .child(FirebaseUtil.currentUserId());
    }

    public static DocumentReference currentUserDetails(){
        return FirebaseFirestore.getInstance().collection("users").document(currentUserId());
    }

    public static StorageReference getCurrentShopPicStorageRef(String path, String shopId){
        return FirebaseStorage.getInstance().getReference().child(path)
                .child(shopId);
    }

}
