package br.com.mespinas.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "LifeCycle";

    private final String SCORE_HOME = "scorehome";
    private final String SCORE_VISITOR = "scorevisitor";

    private TextView tvScoreHome;
    private TextView tvScoreVisitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScoreHome = (TextView) findViewById(R.id.tvScoreHome);
        tvScoreVisitor = (TextView) findViewById(R.id.tvScoreVisitor);

        // Retrieving saved state.
        if(savedInstanceState != null) {
            tvScoreHome.setText(savedInstanceState.getString(SCORE_HOME));
            tvScoreVisitor.setText(savedInstanceState.getString(SCORE_VISITOR));
        }
    }

    public void scoreHome(View v) {
        int currentScore = Integer.parseInt(tvScoreHome.getText().toString());
        currentScore++;
        tvScoreHome.setText(String.valueOf(currentScore));
    }

    public void scoreVisitor(View v) {
        int currentScore = Integer.parseInt(tvScoreVisitor.getText().toString());
        currentScore++;
        tvScoreVisitor.setText(String.valueOf(currentScore));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() Method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume Method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onStop Method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy Method");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Saving state for future retrieve on onCreate
        outState.putString(SCORE_HOME, tvScoreHome.getText().toString());
        outState.putString(SCORE_VISITOR, tvScoreVisitor.getText().toString());

        Log.i(TAG, "onSaveInstanceState() Method");
    }
}
