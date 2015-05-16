package edu.ucsd.visarts.vis141a.animation;

import android.content.Context;
import android.view.View;

/**
 * Created by beestal on 5/1/15.
 */
public abstract class AbstractView extends View {

    protected int w = 0;
    protected int h = 0;


    public AbstractView(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
    }

    /**
     * Method to start your animation (your thread or your AsyncTask)
     * @see ConcreteSampleView
     */
    public abstract void start();

    /**
     * Method to stop your animation (usually setting a boolean to false to break out of a while loop
     * * @see ConcreteView
     */
    public abstract void stop();

    /**
     * Override this method and return your name
     * @return your name
     */
    public abstract String getName();

    /**
     * Override this method and return the title
     * @return the title
     */
    public abstract String getTitle();

    /**
     * Override this method and return the description
     * @return the description
     */
    public abstract String getDescription();

}
