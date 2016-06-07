package com.AR.atomAR;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class SceneGLSurfaceView extends GLSurfaceView {
    private SceneRenderer mRenderer;

    public SceneGLSurfaceView(Context context) {
        super(context);

        // Render the view only when there is a change in the drawing data.
        // To allow the triangle to rotate automatically, this line is commented out:
        //setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320.0f;
    private float mPrevX;
    private float mPrevY;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // Trackball object rotation motion

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - mPrevX;
                float dy = y - mPrevY;

                mRenderer.setRotationX(mRenderer.getRotationX() + (dx * TOUCH_SCALE_FACTOR));
                mRenderer.setRotationY(mRenderer.getRotationY() - (dy * TOUCH_SCALE_FACTOR));

                requestRender();
        }

        mPrevX = x;
        mPrevY = y;
        return true;
    }

    public void setRenderer(SceneRenderer renderer) {
        mRenderer = renderer;
        super.setRenderer(renderer);
    }
}
