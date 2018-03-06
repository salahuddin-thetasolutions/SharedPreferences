package solutions.theta.sharedpreferences;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button mbuttonExit,mButtonLogout;
    String MY_PREFS_NAME = "MyPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mbuttonExit=(Button)findViewById(R.id.btnexit);
        mButtonLogout=(Button)findViewById(R.id.btnlogout);
        mbuttonExit.setOnClickListener(this);
        mButtonLogout.setOnClickListener(this);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        String nametext = prefs.getString("name",null);
        String passwordtext = prefs.getString("password", null);
        Toast.makeText(this, nametext+" "+passwordtext+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {



        if(view.getId()==R.id.btnlogout){

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Logout");
            builder1.setCancelable(false);
            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.clear();
                            editor.commit();

                            Intent ointent=new Intent(Main2Activity.this,MainActivity.class);
                            startActivity(ointent);
                            finish();

                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();


        }
        if(view.getId()==R.id.btnexit){

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Exit");
            builder1.setCancelable(false);
            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent oIntent = new Intent(Intent.ACTION_MAIN);
                            oIntent.addCategory( Intent.CATEGORY_HOME );
                            oIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(oIntent);

                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();

        }
    }
}
