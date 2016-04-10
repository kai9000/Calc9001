package com.example.thekaizer.kaicalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlus, btnMinus, btnTimes, btnDiv;
    private EditText inputNum1, inputNum2;
    private TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();


    }

    private void init() {
        // Declare elements
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnTimes = (Button) findViewById(R.id.btnTimes);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        inputNum1 = (EditText) findViewById(R.id.inputNum1);
        inputNum2 = (EditText) findViewById(R.id.inputNum2);
        answerText = (TextView) findViewById(R.id.answerText);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnTimes.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        String num1 = inputNum1.getText().toString();
        String num2 = inputNum2.getText().toString();

        switch(v.getId()) {

            case R.id.btnPlus:
                int addition = Integer.parseInt(num1) + Integer.parseInt(num2);
                answerText.setText(String.valueOf(addition));
                break;

            case R.id.btnMinus:
                int subtraction = Integer.parseInt(num1) - Integer.parseInt(num2);
                answerText.setText(String.valueOf(subtraction));
                break;

            case R.id.btnTimes:
                try {
                    int times = Integer.parseInt(num1) * Integer.parseInt(num2);
                    answerText.setText(String.valueOf(times));

                }
                catch(Exception e) {
                    answerText.setText("Cannot Multiply");
                }

                break;
            case R.id.btnDiv:
                try {
                    int div = Integer.parseInt(num1) / Integer.parseInt(num2);
                    answerText.setText(String.valueOf(div));
                }
                catch (Exception e) {
                    answerText.setText("Cannot Divide");
                }

                break;



        }

    }
}
