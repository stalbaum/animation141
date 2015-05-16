package edu.ucsd.visarts.vis141a.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by beestal on 5/1/15.
 */
public class ConcreteSampleView extends AbstractView {

    // don't forget, you already have w and h from the parent class
    // and they already have the width and the height in them
    // because abstract classes do that

    public Paint p = null; // you might have more than one paint. Maybe in objects.
    private boolean running = false; // you will certainly want to keep this variable (see start and stop and the thread)
    private byte counter = -128; // this is just for my silly circle... make whatever vars you need

    public ConcreteSampleView(Context context) {
        super(context);
        p = new Paint();
        // don't try to use the w and the h here just yet... they are zero until
        // the parent class AbstractView has its protected void onSizeChanged(int w, int h, int oldw, int oldh)
        // called. If you need the w and h ASAP, you can override onSizeChanged to get the values as soon as they
        // are available
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRGB(0, 0, 0);
        p.setARGB(255, (int) counter + 128, 0, 0);
        canvas.drawCircle(w / 2, h / 2, (int) counter + 128, p);
    }

    public void start() {
        if (!running) {
            running = true;
            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (running) {
                        try {
                            Thread.sleep(33);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter++;
                        postInvalidate();
                    }
                }
            };
            t.start();
        }
    }

    public void stop() {
        running = false;
    }

    /**
     * Override this method and return your name
     * @return your name
     */
    public String getName() {
        return "your name";
    }

    /**
     * Override this method and return the title
     * @return the title
     */
    public String getTitle() {
        return "the name of the animation";
    }

    /**
     * Override this method and return the description
     * @return the description
     */
    public String getDescription() {
        return "description of the animation"; // try to keep it to less than 30 words
    }
    
}
