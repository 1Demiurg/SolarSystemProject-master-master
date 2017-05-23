package itschool.samsung.ru.space;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by student1 on 22.05.17.
 */


public class Settings extends AppCompatActivity {

    public static int size_2_0 = MainActivity.size_2_0=10;
    public static int radius = MainActivity.radius=10;
    public static int spid = MainActivity.spid=1;
    public static int txt = MainActivity.txt=10;
    public static final String APP_PREFERENCES = "i";
    public static final String APP_PREFERENCES_ISize = "isize";
    public static final String APP_PREFERENCES_IRadius = "iradius";
    public static final String APP_PREFERENCES_ISpid = "ispid";
    public static final String APP_PREFERENCES_Itxt = "itxt";
    SharedPreferences sPref;
    TextView text;
    TextView text2;
    TextView text3;
    TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
       Load();
    }
    public void Load() {
        sPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        size_2_0= sPref.getInt(APP_PREFERENCES_ISize,10);
        radius = sPref.getInt(APP_PREFERENCES_IRadius, 10);
        spid= sPref.getInt(APP_PREFERENCES_ISpid, 1);
        txt= sPref.getInt(APP_PREFERENCES_Itxt, 10);

        text= (TextView) findViewById(R.id.text);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);

        text.setText(Integer.toString(size_2_0-9));
        text2.setText(Integer.toString(radius-9));
        text3.setText(Integer.toString(spid));
        text4.setText(Integer.toString(txt));
    }
    public void onBackPressed() {
        Load();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Save() {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt(APP_PREFERENCES_ISize, size_2_0);
        editor.putInt(APP_PREFERENCES_IRadius, radius);
        editor.putInt(APP_PREFERENCES_ISpid, spid);
        editor.putInt(APP_PREFERENCES_Itxt, txt);
        editor.apply();
        Toast toast = Toast.makeText(getApplicationContext(), ("Сохранено"), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void minusSize(View view) {
        if (size_2_0>1) {
            size_2_0 = size_2_0 - 1;

            text.setText(Integer.toString(size_2_0 - 9));
            Save();
        }
    }
    public void plusSize(View view) {
        if (size_2_0<50) {
            size_2_0 = size_2_0 + 1;
            text.setText(Integer.toString(size_2_0-9));
            Save();
        }
    }


    public void minusradius(View view) {
        if (radius == 1){radius=radius-1;}
        radius=radius-1;
        text2.setText(Integer.toString(radius-9));
        Save();
    }
    public void plusradius(View view) {
        if (radius == -1){radius=radius+1;}
        radius=radius+1;
        text2.setText(Integer.toString(radius-9));
        Save();
    }


    public void minusSpid(View view) {
        spid=spid-1;
        text3.setText(Integer.toString(spid));
        Save();
    }
    public void plusSpid(View view) {
        spid=spid+1;
        text3.setText(Integer.toString(spid));
        Save();
    }


    public void minustext(View view) {
        if (txt>1) {
            txt = txt - 1;

            text4.setText(Integer.toString(txt));
            Save();
        }
    }

    public void plustext(View view) {
        if (txt<100) {
            txt = txt + 1;
            text4.setText(Integer.toString(txt));
            Save();
        }
    }
}