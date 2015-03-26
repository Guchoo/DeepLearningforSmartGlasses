package no.uia.guchoo.imagerecognition;

import android.util.Log;
import android.view.View;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.sdk.jni.Vector3d;
import com.metaio.tools.io.AssetsManager;

/**
 * Created by Guro on 26.03.2015.
 */
public class ARActivity extends ARViewActivity {
    private String mTrackingFile;
    private IGeometry mMan;


    @Override
    protected int getGUILayout() {
        return R.layout.ar_view;
    }

    @Override
    protected IMetaioSDKCallback getMetaioSDKCallbackHandler() {
        return null;
    }

    @Override
    protected void loadContents() {
        mTrackingFile = AssetsManager.getAssetPath("assets/TrackingData_MarkerlessFast.xml");

        boolean result = metaioSDK.setTrackingConfiguration(mTrackingFile);
        MetaioDebug.log("Tracking data loaded: " + result);

        String modelPath = AssetsManager.getAssetPath("assets/meatioman.md2");

        if(modelPath != null){
            mMan = metaioSDK.createGeometry(modelPath);
            if(mMan != null){
                mMan.setScale(new Vector3d(4.0f,4.0f,4.0f));
                mMan.setVisible(true);
                MetaioDebug.log("Loaded geometry "+ modelPath);
            }
            else
                MetaioDebug.log(Log.ERROR,"Error loading geometry" + modelPath);
        }
    }

    @Override
    protected void onGeometryTouched(IGeometry geometry) {

    }

    public void onManButtonClick(View v){
        mMan.setVisible(false);
    }
}

