package com.example.anupama.quizfinal;
import java.util.*;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int i,count,j,r;
    static int scorrect=0;
    static int stotal=0;
    int flag=0;
    private Button mYesButton;
    private Button mNoButton;
    private Button mNextButton;
    private TextView mDisplay;
    private TextView mDisplayScore;
    private TextView mQuestionno;
    private static final String sTAG="QuizFinal";
    protected int  rand_no(){
        Random r=new Random();
        i= r.nextInt(999)+1;
        return i;
    }
    protected int prime_check(int num) {
        count=0;
        for(j=2;j<=num/2;j++) {
            if(num%j==0) {
                count++;
                break;
            }
        }
        if(count==0 && num!= 1) i=1;
        else i= 0;
        return i;
    }
    protected void nextnum(){
flag=0;
        mDisplayScore.setText("Score :"+scorrect+"/"+stotal);
        i=rand_no();
        mDisplay.setText("Is "+ i +" a Prime Number ?");
        j=prime_check(i);
        mYesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                flag=1;

                Log.d(sTAG,"Yes Button Clicked");
                mNoButton.setEnabled(false);
                if(j==1) {
                    Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
                    scorrect++;
                }
                else Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
            }
        });
        mNoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                flag=1;
                Log.d(sTAG, "Clicked No Button");
                mYesButton.setEnabled(false);
                if(j==0) {
                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    scorrect++;
                }
                else Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(sTAG,"Clicked Next Button");
                if(flag==0) {
                    Toast.makeText(getApplicationContext(), "Answer the Question", Toast.LENGTH_SHORT).show();
                }
                else {


                    mYesButton.setEnabled(true);
                    mNoButton.setEnabled(true);
                    stotal++;
                }
                nextnum();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(sTAG,"Inside oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mYesButton = (Button) findViewById(R.id.YesButton);
        mNoButton = (Button) findViewById(R.id.NoButton);
        mNextButton = (Button) findViewById(R.id.NextButton);
        mDisplay = (TextView) findViewById(R.id.Display);
        mDisplayScore=(TextView)findViewById(R.id.DisplayScore);
        nextnum();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(sTAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
         Log.d(sTAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
          Log.d(sTAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
          Log.d(sTAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
          Log.d(sTAG, "Inside OnDestroy");
    }

}
