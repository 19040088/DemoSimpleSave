package sg.edu.rp.c346.id19040088.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

       // String msg = "No greetings!";

       // Step 2a: Obtain an instance of the SharedPreferences
       SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

       // Step 2b: Retrieve the saved data with the key "greeting" from the SharedPreference object
        String msg = prefs.getString("greetings","No greetings!");

        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 1b: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1c: Add the key-value pair
        prefEdit.putString("greetings","Hello!");

        //Step 1d: Call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }


}
