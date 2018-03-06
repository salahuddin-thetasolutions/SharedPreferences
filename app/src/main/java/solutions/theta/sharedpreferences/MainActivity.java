package solutions.theta.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mName,mPassword;
    Button mbutton;
    String MY_PREFS_NAME = "MyPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName=(EditText)findViewById(R.id.username);
        mPassword=(EditText)findViewById(R.id.password);
        mbutton=(Button) findViewById(R.id.btnsave);
        mbutton.setOnClickListener(this);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String nametext = prefs.getString("name", null);
        String passwordtext = prefs.getString("password", null);


        if(nametext!=null && passwordtext!=null){
            Intent ointent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(ointent);
            finish();
        }
    }

    @Override
    public void onClick(View view) {

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("name", mName.getText().toString());
        editor.putString("password", mPassword.getText().toString());
        editor.apply();

        Intent ointent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(ointent);
        finish();
    }
}
