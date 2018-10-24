package cs.uga.edu.statecapitalsquizappv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AllQuizResultsActivity extends AppCompatActivity {

    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_quiz_results);

        results = (TextView) findViewById(R.id.scoresAndDates);
        DBManager dbManager = new DBManager(getApplicationContext());
        results.setText(dbManager.getScoresAndDates());
    }
}
