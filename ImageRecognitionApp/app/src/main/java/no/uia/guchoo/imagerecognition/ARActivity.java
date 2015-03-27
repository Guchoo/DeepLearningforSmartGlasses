package no.uia.guchoo.imagerecognition;

import android.content.ContentValues;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


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
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                takeImage();
            }
        }, 1000,1000);

    }

    @Override
    protected void onGeometryTouched(IGeometry geometry) {

    }

    public void takeImage() {
            String dir = Environment.getExternalStorageDirectory().toString();
            File rootDir = new File(dir + File.separator + "album");
                if (!rootDir.exists()) {
                    rootDir.mkdir();
                }
                Random generator = new Random();
                int i = 10000;
                i = generator.nextInt(i);
                String fname = "GG-" + i + ".jpg";
                File file = new File(rootDir, fname);
                if (file.exists()) file.delete();
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    out.flush();
                    out.close();
                } catch (FileNotFoundException et) {
                    et.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                addImageGallery(file);
    }

    public void onButtonClick(View v){
        //request screenshot

        String storeDir = Environment.getExternalStorageDirectory().toString();
        File rootDir = new File(storeDir + File.separator + "album");
        if(!rootDir.exists()){
            rootDir.mkdir();
        }
        Random generator = new Random();
        int i = 10000;
        i = generator.nextInt(i);
        String fname = "GG-"+i+".jpg";
        File file = new File (rootDir,fname);
        if(file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        showMessage(fname);
        addImageGallery(file);
    }

    private void showMessage(String fname){
        String imagepath = Environment.getExternalStorageDirectory().getPath() + File.separator + "album" + File.separator + fname;
        metaioSDK.requestScreenshot(imagepath);
        String message = "Image Saved";
        Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    private void addImageGallery(File file) {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DATA, file.getAbsolutePath());
        values.put(MediaStore.Images.Media.MIME_TYPE,"image/jpeg");
        getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
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

