package cs.uga.edu.statecapitalsquizappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class SplashActivity extends AppCompatActivity {

    public Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        readCSV();

        enterButton = (Button) findViewById(R.id.enter);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
    }

    public void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void readCSV(){
        DBManager dbManager = new DBManager(this);
        InputStream inputStream = getResources().openRawResource(R.raw.state_capitals_new);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String line = "";
        try {
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] tokens = line.split(",");
                dbManager.insert(tokens[0], tokens[1], tokens[2], tokens[3], tokens[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
