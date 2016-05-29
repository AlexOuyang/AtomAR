package com.AR.atomAR;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class AugmentedRealityActivity extends Activity {

    private SceneGLSurfaceView mGLView;
    private SceneRenderer renderer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity
        mGLView = new SceneGLSurfaceView(this);

        // Create an OpenGL ES 2.0 context.
        mGLView.setEGLContextClientVersion(2);

        renderer = new SceneRenderer(this);
        mGLView.setRenderer(renderer);

        setContentView(mGLView);

        Toast.makeText(this, R.string.user_hint, Toast.LENGTH_SHORT).show();
    }

    /*
	 * Creates the menu and populates it via xml
	 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opengl_shadow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.shadow_type_simple:
                renderer.setShadowType(0.0f);
                item.setChecked(true);
                return true;
            case R.id.shadow_type_pcf:
                renderer.setShadowType(1.0f);
                item.setChecked(true);
                return true;
            case R.id.bias_type_constant:
                renderer.setBiasType(0.0f);
                item.setChecked(true);
                return true;
            case R.id.bias_type_dynamic:
                renderer.setBiasType(1.0f);
                item.setChecked(true);
                return true;
            case R.id.depth_map_size_0:
                renderer.setShadowMapRatio(0.5f);

                // we need to run opengl calls on GLSurface thread
                mGLView.queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        renderer.generateShadowFBO();
                    }
                });

                item.setChecked(true);
                return true;
            case R.id.depth_map_size_1:
                renderer.setShadowMapRatio(1.0f);

                // we need to run opengl calls on GLSurface thread
                mGLView.queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        renderer.generateShadowFBO();
                    }
                });

                item.setChecked(true);
                return true;
            case R.id.depth_map_size_2:
                renderer.setShadowMapRatio(1.5f);

                // we need to run opengl calls on GLSurface thread
                mGLView.queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        renderer.generateShadowFBO();
                    }
                });

                item.setChecked(true);
                return true;
            case R.id.depth_map_size_3:
                renderer.setShadowMapRatio(2.0f);

                // we need to run opengl calls on GLSurface thread
                mGLView.queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        renderer.generateShadowFBO();
                    }
                });

                item.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLView.onResume();
    }


}
