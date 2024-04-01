package com.example.plantoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private List<Plant> plantList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        plantList.add(new Plant(R.drawable.img1, "Watermelon", R.drawable.img_1, "🌟 4.8 (255 Reviews)", "Watermelon vines are thin, grooved and covered in tiny hairs. Vines are branching and possess deeply lobed pinnate leaves. The plant produces solitary yellow flowers and and a large spherical to oblong fruit. The fruit is a 'pepo' - a fleshy fruit protected by a thick leathery rind.", "Medium", "Orchid", "12.6''", "68.33%", "$139"));
        plantList.add(new Plant(R.drawable.img3, "Snake Plant", R.drawable.img_3, "🌟 4.9 (365 Reviews)", "It is a stemless evergreen perennial that, with proper care, will last for many years. In its native habitat, plant foliage may rise to as much as 4' tall, but is often smaller (to 2' tall) on indoor plants. Erect, fleshy, sharply-pointed, sword-shaped leaves are deep green with light gray-green horizontal stripes.", "High", "Hoya", "27.16''", "55.33%", "$205"));
        plantList.add(new Plant(R.drawable.img2, "Philodendron", R.drawable.img_2, "🌟 5.0 (89 Reviews)", "The foliage of philodendrons is usually green but may be coppery, red, or purplish; parallel leaf veins are usually green or sometimes red or white. Shape, size, and texture of the leaves vary considerably, depending on species and maturity of the plant. The fruit is a white to orange berry.", "Small", "Huperzia", "9.6''", "78.36%", "$50"));
        plantList.add(new Plant(R.drawable.img4, "Narcissus", R.drawable.img_4, "🌟 4.8 (563 Reviews)", "Narcissus is a genus of predominantly spring flowering perennial plants of the amaryllis family, Amaryllidaceae. Various common names including daffodil,narcissus and jonquil, are used to describe all or some members of the genus. Narcissus has conspicuous flowers with six petal-like tepals surmounted by a cup- or trumpet-shaped corona.", "High", "Corpse ", "32.9''", "95.33%", "$79"));
        plantList.add(new Plant(R.drawable.img5, "Palm Tree", R.drawable.img_5, "🌟 4.7 (32 Reviews)", "Any of several kinds of tropical tree with a tall, slender, smooth trunk, no branches, and large, spreading leaves at the top: All the islands have pristine shores, swaying palm trees, aquamarine waters, and lots of ocean-side adventure.", "Medium", "Orchid", "11.6''", "95%", "$965"));
        plantList.add(new Plant(R.drawable.img6, "Lily", R.drawable.img_6, "🌟 5.0 (999 Reviews)", "Lilies typically feature 6-tepaled flowers in a variety of shapes (trumpet, funnel, cup, bell, bowl or flat), sometimes nodding, sometimes with reflexed petals, atop stiff, unbranched stems (1-8' tall) clothed with linear to elliptic leaves. Flowers are often fragrant and come in a broad range of colors except blue.", "High", "Orchid", "22.7''", "83.02%", "$405"));
        plantList.add(new Plant(R.drawable.img7, "Trifurcate", R.drawable.img_7, "🌟 4.8 (354 Reviews)", "The concave area between the roots of a multi-rooted tooth. It is called “bifurcation” if a tooth has two roots. It is called “trifurcation” if a tooth has three roots.", "Medium", "Orchid", "13.6''", "75%", "$863"));
        plantList.add(new Plant(R.drawable.img8, "Dahlia", R.drawable.img_8, "🌟 4.9 (95 Reviews)", "Dahlias are tuberous perennials, and most have simple leaves that are segmented and toothed or cut. The compound flowers may be white, yellow, red, or purple in colour. ", "Small", "Corps", "10.10''", "95.32%", "$56"));

        recyclerView = findViewById(R.id.recyclerplant);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new ProductAdapter(plantList);
        recyclerView.setAdapter(adapter);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}