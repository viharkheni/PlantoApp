package com.example.plantoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    TextView txtName, txtRating, txtDisc, txtDetailSize, txtDetailPlant, txtDetailHeight, txtDetailHumidity, txtDetailPrice;
    TextToSpeech t1;
    ImageView imgSpeaker, imgBack;
    boolean isFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Plant plant = new Plant(
                intent.getIntExtra("img", 1),
                intent.getStringExtra("name"),
                intent.getIntExtra("image", 1),
                intent.getStringExtra("rating"),
                intent.getStringExtra("description"),
                intent.getStringExtra("size"),
                intent.getStringExtra("plant"),
                intent.getStringExtra("height"),
                intent.getStringExtra("humidity"),
                intent.getStringExtra("price"));

        ImageView productimage = findViewById(R.id.imgproduct);
        productimage.setImageResource(plant.getWithoutBgImage());

        txtRating = findViewById(R.id.txtRating);
        txtRating.setText(plant.getRating());

        txtName = findViewById(R.id.txtName);
        txtName.setText(plant.getName());

        txtDisc = findViewById(R.id.txtDisc);
        txtDisc.setText(plant.getDescription());

        txtDetailSize = findViewById(R.id.txtDetailSize);
        txtDetailSize.setText(plant.getSize());

        txtDetailPlant = findViewById(R.id.txtDetailPlant);
        txtDetailPlant.setText(plant.getPlant());

        txtDetailHeight = findViewById(R.id.txtDetailHeight);
        txtDetailHeight.setText(plant.getHeight());

        txtDetailHumidity = findViewById(R.id.txtDetailHumidity);
        txtDetailHumidity.setText(plant.getHumidity());

        txtDetailPrice = findViewById(R.id.txtDetailPrice);
        txtDetailPrice.setText(plant.getPrice());

        imgSpeaker = findViewById(R.id.imgSpeaker);
        t1 =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.CANADA_FRENCH);
                }
            }
        });

        imgSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFlag){
                    isFlag = false;
                    imgSpeaker.setImageResource(R.drawable.mute);
                    t1.stop();
                }else{
                    isFlag = true;
                    imgSpeaker.setImageResource(R.drawable.mic);
                    t1.speak(plant.getDescription(), TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnCheckout = findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CheckoutActivity.class);
                        intent.putExtra("name", plant.getName());
                        intent.putExtra("image", plant.getWithoutBgImage());
                        intent.putExtra("price", plant.getPrice());
                startActivity(intent);
            }
        });
    }

    protected void onDestroy() {
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        super.onDestroy();
    }

}