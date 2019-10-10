package com.example.week04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
/*
    private ConstraintLayout article1Layout;
    private ConstraintLayout article2Layout;
    private ImageView bookmarkButton1;
    private ImageView bookmarkButton2;
    private ImageView shareButton1;
    private ImageView shareButton2;
    private boolean button1State = false;
    private boolean button2State = false;

    private Article articleObject1;
    private Article articleObject2;


 */
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter articleAdapter = new MyAdapter();
        articleAdapter.setData(FakeDatabase.getAllArticles());
        recyclerView.setAdapter(articleAdapter);
        /*
        // We are repeating all the code every time, for the second article.
        // This is obviously not ideal.
        // If we have 10 articles are we going to repeat the code 10 times? (No)
        // Next week we'll learn about the RecyclerView, which means we can write the code ONCE
        // and it'll create a list with as many items as we have data.
        //
        // Note that the way the code is written here, the code for the second article is EXACTLY
        // the same as the code for the first one except you just replace articleObject1 with
        // articleObject2. So really, the only thing that changes is the data we provide.
        // Thinking this way will help you next week.

        articleObject1 = FakeDatabase.getArticleById(1);
        articleObject2 = FakeDatabase.getArticleById(2);

        // Explicit intent on the article item
        article1Layout = findViewById(R.id.article1);
        article1Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ArticleDetailActivity.class);
                intent.putExtra("ArticleID", articleObject1.getArticleID());
                startActivity(intent);
            }
        });

        article2Layout = findViewById(R.id.article2);
        article2Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ArticleDetailActivity.class);
                intent.putExtra("ArticleID", articleObject2.getArticleID());
                startActivity(intent);
            }
        });

        TextView headline1 = article1Layout.findViewById(R.id.newsHeadline);
        TextView summary1 = article1Layout.findViewById(R.id.newsDetails);
        headline1.setText(articleObject1.getHeadline());
        summary1.setText(articleObject1.getSummary());

        TextView headline2 = article2Layout.findViewById(R.id.newsHeadline);
        TextView summary2 = article2Layout.findViewById(R.id.newsDetails);
        headline2.setText(articleObject2.getHeadline());
        summary2.setText(articleObject2.getSummary());

        // Just some buttons that change image on click
        bookmarkButton1 = article1Layout.findViewById(R.id.newsSaveButton);
        bookmarkButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Click1 Registered", Toast.LENGTH_SHORT).show();
                if (!button1State) {
                    bookmarkButton1.setImageResource(R.drawable.ic_bookmark_black_24dp);
                } else {
                    bookmarkButton1.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                }

                button1State = !button1State;
            }
        });

        bookmarkButton2 = article2Layout.findViewById(R.id.newsSaveButton);
        bookmarkButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Click2 Registered", Toast.LENGTH_SHORT).show();
                if (!button2State) {
                    bookmarkButton2.setImageResource(R.drawable.ic_bookmark_black_24dp);
                } else {
                    bookmarkButton2.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                }

                button2State = !button2State;
            }
        });

        // Implicit intent on the share button
        shareButton1 = article1Layout.findViewById(R.id.newsShareButton);
        shareButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Here is a cool article: " +
                        articleObject1.getHeadline());
                startActivity(intent);
            }
        });

        shareButton2 = article2Layout.findViewById(R.id.newsShareButton);
        shareButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Here is a cool article: " +
                        articleObject2.getHeadline());
                startActivity(intent);
            }
        });

         */
    }
}
