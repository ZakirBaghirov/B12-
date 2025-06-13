package com.example.myproje;

import static com.google.firebase.appcheck.internal.util.Logger.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.messaging.FirebaseMessaging;

public class bildirim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirim);

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w("FCM", "FCM token alınamadı", task.getException());
                    Toast.makeText(bildirim.this, "Token alınamadı!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String token = task.getResult();
                if (token != null && !token.isEmpty()) {
                    Log.d("FCM", "Token: " + token);
                    Toast.makeText(bildirim.this, "Token: " + token, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(bildirim.this, "Token boş geldi!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}