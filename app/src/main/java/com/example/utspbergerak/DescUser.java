package com.example.utspbergerak;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DescUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_user);
        // Mendapatkan data alamat dan email dari sumber daya XML
        String[] alamatArray = getResources().getStringArray(R.array.data_alamat);
        String[] emailArray = getResources().getStringArray(R.array.data_email);

        Intent intent = getIntent();

        // Mendapatkan data pengguna dari Intent
        int position = getIntent().getIntExtra("position", 0);

        String name = intent.getStringExtra("name");
        String alamat = alamatArray[position];
        String email = emailArray[position];
        int photo = intent.getIntExtra("photo", 0);

        // Menampilkan data pengguna di tampilan
        TextView nameTextView = findViewById(R.id.tv_item_name);
        TextView alamatTextView = findViewById(R.id.addressTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        ImageView photoImageView = findViewById(R.id.img_item_photo);

        nameTextView.setText(name);
        alamatTextView.setText("Alamat: " + alamat);
        emailTextView.setText("Email: " + email);
        photoImageView.setImageResource(photo);

        Glide.with(this)
                .load(photo) // Isi dengan URL atau sumber gambar
                .circleCrop() // Menggunakan crop sirkuler
                .into(photoImageView);
    }
}

