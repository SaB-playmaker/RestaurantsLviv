package com.restaurants.lviv.restLvivApplication;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOComment
{
    private DatabaseReference databaseReference;

    public DAOComment()
    {
        FirebaseDatabase db =FirebaseDatabase.getInstance("https://restaurants-lviv-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference = db.getReference(Comment.class.getSimpleName());
    }
    public Task<Void> add(Comment emp)
    {
        return databaseReference.push().setValue(emp);
    }

    public Task<Void> update(String key, HashMap<String ,Object> hashMap)
    {
        return databaseReference.child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key)
    {
        return databaseReference.child(key).removeValue();
    }

    public Query get(String key)
    {
        if(key == null)
        {
           return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAt(key).limitToFirst(8);
    }

    public Query get()
    {
        return databaseReference;
    }
}
