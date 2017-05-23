package itschool.samsung.ru.space.framework;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Dimension;
import android.view.Window;

import itschool.samsung.ru.space.MainActivity;
import itschool.samsung.ru.space.Settings;
import itschool.samsung.ru.space.framework.Renderable;
import itschool.samsung.ru.space.framework.Updatable;

/**
 * Created by vv on 14.11.2016.
 */
public class TestObj implements Renderable, Updatable {

    float ox;
    float py;
    float t;
    float g;
    float move;
    float location;
    float between;
    int R;
    int G;
    int B;
    String name;



    public TestObj(String name,float g,float move, int R,int G,int B,float location,float between) {
        this.name=name;
        this.g=g;
        this.move=move;
        this.R = R;
        this.G = G;
        this.B = B;
        paint.setARGB(255,R,G,B);
        this.location=location;
        this.between=between;
        paint1.setColor(Color.WHITE);

    }



    Paint paint = new Paint();
    Paint paint1= new Paint();

    @Override
    public void render(Canvas canvas) {

        canvas.drawCircle(ox, py,g* MainActivity.size_2_0/10, paint);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setTextSize(Settings.txt);
        canvas.drawText(name, ox-20, py+g+10, paint1);

    }

    @Override
    public void update(float dt) {
            t +=move/100*MainActivity.spid;
            ox = MainActivity.radius/10*between* location  * (float) Math.cos((double) t) + GameView.x;
            py = MainActivity.radius/10*between* location *(float) Math.sin((double) t) + GameView.y;

    }
}
