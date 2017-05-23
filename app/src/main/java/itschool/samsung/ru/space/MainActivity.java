package itschool.samsung.ru.space;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import itschool.samsung.ru.space.framework.GameView;

public class MainActivity extends AppCompatActivity {
    public static int size_2_0 = 1;
    public static int radius = 1;
    public static int spid = 1;
    public static int txt = 1;
    public static final String APP_PREFERENCES = "i";
    public static final String APP_PREFERENCES_ISize = "isize";
    public static final String APP_PREFERENCES_IRadius = "iradius";
    public static final String APP_PREFERENCES_ISpid = "ispid";
    public static final String APP_PREFERENCES_Itxt = "itxt";
    SharedPreferences sPref;
   static public int width,height;
    private static final String TAG = "MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    Load();
        setContentView(R.layout.activity_main);

        setT();

        Log.i(TAG, String.valueOf(width)+" "+ String.valueOf(height));
        GameView.x = width;
        GameView.y = height;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void Load() {
        sPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        size_2_0= sPref.getInt(APP_PREFERENCES_ISize,1);
        radius = sPref.getInt(APP_PREFERENCES_IRadius, 1);
        spid= sPref.getInt(APP_PREFERENCES_ISpid, 1);
        txt= sPref.getInt(APP_PREFERENCES_Itxt, 1);

    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_events:
                Intent intentE = new Intent(MainActivity.this, Events.class);
                startActivity(intentE);
                return true;

            case R.id.action_information:
                Intent intent = new Intent(MainActivity.this, information.class);
                startActivity(intent);
                return true;

            case R.id.action_settings:
                Intent intentS = new Intent(MainActivity.this, Settings.class);
                startActivity(intentS);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void setT() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
         width = size.x / 2;
         height = size.y / 2;
    }

}
