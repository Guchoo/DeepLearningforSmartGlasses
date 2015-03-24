package no.uia.guchoo.imagerecognition;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.sdk.ARViewActivity;

public class MainActivity extends ARViewActivity {

    Button abutton;

    @Override
    protected int getGUILayout() {
        return 0;
    }

    @Override
    protected IMetaioSDKCallback getMetaioSDKCallbackHandler() {
        return null;
    }

    @Override
    protected void loadContents() {
        abutton = (Button) findViewById(R.id.offbtn);

    }

    @Override
    protected void onGeometryTouched(IGeometry geometry) {

    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        winParams.flags = winParams.flags | WindowManager.LayoutParams.FLAG_FULLSCREEN;
        win.setAttributes(winParams);
        setContentView(R.layout.activity_main);

    }

    public void exitOnClick(View v){
        System.exit(0);
    }

    public void offOnClick(Button button){

    }
    public void onOnClick(View v){

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
