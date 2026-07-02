package com.example.inspireme;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.OutputStream;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView quoteText;

    Button randomBtn,nextBtn,backBtn,
            shareBtn,speakBtn,
            favoriteBtn,imageBtn,
            viewFavoriteBtn,
            notifyBtn;

    Switch darkSwitch;

    LinearLayout mainLayout;

    int currentIndex = 0;

    TextToSpeech textToSpeech;

    String[] quotes = {

            "You have to believe in yourself when no one else does — Serena Williams",

            "When you have a dream, you’ve got to grab it and never let go — Carol Burnett",

            "The most important thing is to enjoy your life—to be happy—it’s all that matters — Steve Jobs",

            "Spread love everywhere you go. Let no one ever come without leaving happier — Mother Teresa",

            "Be yourself; everyone else is already taken — Oscar Wilde",

            "Dream big and dare to fail — Norman Vaughan",

            "Stay hungry stay foolish — Steve Jobs",

            "Success is not final failure is not fatal — Winston Churchill",

            "Do what you can with what you have where you are — Theodore Roosevelt",

            "Everything you can imagine is real — Pablo Picasso",

            "Believe you can and you're halfway there — Theodore Roosevelt",

            "Turn your wounds into wisdom — Oprah Winfrey",

            "Doubt kills more dreams than failure ever will",

            "Push yourself because no one else is going to do it for you",

            "Great things never come from comfort zones",

            "Don’t stop until you’re proud",

            "Your only limit is your mind",

            "Difficult roads often lead to beautiful destinations",

            "Work hard in silence let success make the noise",

            "Small steps every day lead to big results"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        quoteText = findViewById(R.id.quoteText);

        randomBtn = findViewById(R.id.randomBtn);

        nextBtn = findViewById(R.id.nextBtn);

        backBtn = findViewById(R.id.backBtn);

        shareBtn = findViewById(R.id.shareBtn);

        speakBtn = findViewById(R.id.speakBtn);

        favoriteBtn = findViewById(R.id.favoriteBtn);

        imageBtn = findViewById(R.id.imageBtn);

        viewFavoriteBtn = findViewById(R.id.viewFavoriteBtn);

        notifyBtn = findViewById(R.id.notifyBtn);

        darkSwitch = findViewById(R.id.darkSwitch);

        mainLayout = findViewById(R.id.mainLayout);

        quoteText.setText(quotes[currentIndex]);



        // NEXT BUTTON

        nextBtn.setOnClickListener(v -> {

            if(currentIndex < quotes.length - 1){

                currentIndex++;

                quoteText.setText(quotes[currentIndex]);

            }

        });



        // BACK BUTTON

        backBtn.setOnClickListener(v -> {

            if(currentIndex > 0){

                currentIndex--;

                quoteText.setText(quotes[currentIndex]);

            }

        });



        // RANDOM BUTTON

        randomBtn.setOnClickListener(v -> {

            Random random = new Random();

            currentIndex = random.nextInt(quotes.length);

            quoteText.setText(quotes[currentIndex]);

        });



        // SHARE BUTTON

        shareBtn.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.setType("text/plain");

            intent.putExtra(Intent.EXTRA_TEXT,
                    quoteText.getText().toString());

            startActivity(Intent.createChooser(
                    intent,
                    "Share Quote"));

        });



        // TEXT TO SPEECH

        textToSpeech = new TextToSpeech(this,
                status -> {

                    if(status != TextToSpeech.ERROR){

                        textToSpeech.setLanguage(Locale.US);

                    }

                });

        speakBtn.setOnClickListener(v -> {

            textToSpeech.speak(
                    quoteText.getText().toString(),
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    null);

        });



        // FAVORITE BUTTON

        favoriteBtn.setOnClickListener(v -> {

            SharedPreferences preferences =
                    getSharedPreferences(
                            "favorites",
                            MODE_PRIVATE);

            SharedPreferences.Editor editor =
                    preferences.edit();

            editor.putString(
                    "favoriteQuote",
                    quoteText.getText().toString());

            editor.apply();

            Toast.makeText(
                    this,
                    "Added To Favorites ❤️",
                    Toast.LENGTH_SHORT).show();

        });



        // VIEW FAVORITE

        viewFavoriteBtn.setOnClickListener(v -> {

            SharedPreferences preferences =
                    getSharedPreferences(
                            "favorites",
                            MODE_PRIVATE);

            String favQuote =
                    preferences.getString(
                            "favoriteQuote",
                            "No Favorite Quote Saved");

            quoteText.setText(favQuote);

        });



        // DARK MODE

        darkSwitch.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {

                    if(isChecked){

                        mainLayout.setBackgroundColor(
                                Color.BLACK);

                        quoteText.setTextColor(
                                Color.WHITE);

                    }
                    else{

                        mainLayout.setBackgroundColor(
                                Color.WHITE);

                        quoteText.setTextColor(
                                Color.BLACK);

                    }

                });



        // IMAGE GENERATOR

        imageBtn.setOnClickListener(v -> {

            String quote =
                    quoteText.getText().toString();

            Bitmap bitmap =
                    Bitmap.createBitmap(
                            1000,
                            1000,
                            Bitmap.Config.ARGB_8888);

            Canvas canvas =
                    new Canvas(bitmap);

            canvas.drawColor(Color.BLACK);

            Paint paint =
                    new Paint();

            paint.setColor(Color.WHITE);

            paint.setTextSize(45);

            paint.setAntiAlias(true);

            canvas.drawText(
                    quote,
                    50,
                    500,
                    paint);

            ContentValues values =
                    new ContentValues();

            values.put(
                    MediaStore.Images.Media.DISPLAY_NAME,
                    "quote_image.png");

            values.put(
                    MediaStore.Images.Media.MIME_TYPE,
                    "image/png");

            values.put(
                    MediaStore.Images.Media.RELATIVE_PATH,
                    Environment.DIRECTORY_PICTURES);

            Uri uri =
                    getContentResolver().insert(
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            values);

            try {

                OutputStream outputStream =
                        getContentResolver()
                                .openOutputStream(uri);

                bitmap.compress(
                        Bitmap.CompressFormat.PNG,
                        100,
                        outputStream);

                outputStream.close();

                Toast.makeText(
                        this,
                        "Image Saved in Gallery",
                        Toast.LENGTH_SHORT).show();

            }
            catch (Exception e){

                e.printStackTrace();

            }

        });
        notifyBtn.setOnClickListener(v -> {

            NotificationManager manager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                NotificationChannel channel =
                        new NotificationChannel(
                                "quotes_channel",
                                "Quotes",
                                NotificationManager.IMPORTANCE_HIGH);

                manager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(
                            MainActivity.this,
                            "quotes_channel")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Daily Motivation")
                            .setContentText(quoteText.getText().toString())
                            .setPriority(NotificationCompat.PRIORITY_HIGH);

            manager.notify(1, builder.build());

            Toast.makeText(
                    MainActivity.this,
                    "Notification Sent",
                    Toast.LENGTH_SHORT).show();

        });
    }

    @Override
    protected void onDestroy() {

        if(textToSpeech != null){

            textToSpeech.stop();

            textToSpeech.shutdown();

        }

        super.onDestroy();

    }





}
