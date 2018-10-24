package cs.uga.edu.statecapitalsquizappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ResultsActivity extends AppCompatActivity {

    private TextView score;
    private String results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        results = intent.getStringExtra("results");
        score = (TextView) findViewById(R.id.score);
        score.setText("Score: " + results + "/6");

        DBManager dbManager = new DBManager(getApplicationContext());
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String dateStr = dateFormat.format(date);
        dbManager.insertScoresAndDates(results, dateStr);

    }
}
