package ca.yorku.eecs.mack.demotiltball_96073;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class ResultsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Retrieve performance data passed through the Intent
        Intent intent = getIntent();
        int laps = intent.getIntExtra("laps", 0);
        long meanLapTime = intent.getLongExtra("meanLapTime", 0);
        int wallHits = intent.getIntExtra("wallHits", 0);
        float accuracy = intent.getFloatExtra("accuracy", 0.0f);

        // Set text views with the results data
        TextView lapsText = findViewById(R.id.lapsText);
        TextView lapTimeText = findViewById(R.id.lapTimeText);
        TextView wallHitsText = findViewById(R.id.wallHitsText);
        TextView accuracyText = findViewById(R.id.accuracyText);

        lapsText.setText("Laps: " + laps);
        lapTimeText.setText("Lap Time: " + meanLapTime + " ms");
        wallHitsText.setText("Wall Hits: " + wallHits);
        accuracyText.setText("In-Path Time: " + String.format("%.2f", accuracy) + "%");

        // Buttons to return to the setup or exit the app
        Button setupButton = findViewById(R.id.setupButton);
        Button exitButton = findViewById(R.id.exitButton);

        setupButton.setOnClickListener(v -> {
            // Go back to the setup dialog
            Intent setupIntent = new Intent(ResultsActivity.this, DemoTiltBallSetup.class);
            startActivity(setupIntent);
        });

        exitButton.setOnClickListener(v -> {
            // Exit the app
            finish();
        });
    }

}
