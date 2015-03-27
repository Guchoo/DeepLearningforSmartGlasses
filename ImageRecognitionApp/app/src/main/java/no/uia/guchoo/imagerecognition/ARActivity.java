package no.uia.guchoo.imagerecognition;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.metaio.sdk.ARELActivity;
import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;


/**
 * Created by Guro on 26.03.2015.
 */
public class ARActivity extends ARViewActivity {

    @Override
    protected int getGUILayout() {return R.layout.ar_view;
    }

    @Override
    protected IMetaioSDKCallback getMetaioSDKCallbackHandler() {
        return null;
    }

    @Override
    protected void loadContents() {

    }

    @Override
    protected void onGeometryTouched(IGeometry geometry) {

    }

    public void onButtonClick(View v){

    }

    protected void onStop() {
        setResult(2);
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        setResult(2);
        super.onDestroy();
    }
}

