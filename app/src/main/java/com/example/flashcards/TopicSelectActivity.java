package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class TopicSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_select);
    }

    public void launchActivity(View v){
        // Switches to the mastery or practice screen via a button

        // Access the intent and retrieve the desired "mode," either practice or quiz
        Intent oldi = getIntent();
        String mode = oldi.getStringExtra("mode");

        // Set the desired topic
        String topic;
        switch (v.getId()){
            case R.id.topic_addition_btn:
                topic = "ADDITION";
                break;
            case R.id.topic_subtraction_btn:
                topic = "SUBTRACTION";
                break;
            case R.id.topic_multiplication_btn:
                topic = "MULTIPLICATION";
                break;
            case R.id.topic_division_btn:
                topic = "DIVISION";
                break;
            default:
                // Should never happen as only the four above buttons should call this
                topic = "ERROR";
                break;
        }
        // Adding sound
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.btn_sound);
        mediaPlayer.start();
        // Initialize the new intent
        Intent i;
        // If we desire practice mode, launch the practice activity
        if (mode.equals("practice")){
            i = new Intent(this, PracticeActivity.class);
        }
        // If we don't want practice mode, it must be the quiz activity
        else{
            i = new Intent(this, QuizzesActivity.class);
        }

        // Before launching either quiz or practice, we pass the topic for use in that activity
        i.putExtra("topic",topic);
        startActivity(i);
    }

}