package com.limi.niceness;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class CodeActivity extends AppCompatActivity {

    String TAG = "GenerateQR";
    EditText et;
    ImageView img;
    String inputvalue;
    Button btn;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codeqr);

        img = findViewById(R.id.codeqr);
        et = findViewById(R.id.etNombre);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputvalue = et.getText().toString().trim();
                if(inputvalue.length()>0){
                    WindowManager manager = (WindowManager)getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smalldimension = width<height ? width:height;
                    smalldimension = smalldimension*3/4;
                    qrgEncoder = new QRGEncoder(inputvalue,null, QRGContents.Type.TEXT, smalldimension);
                    try{
                        bitmap = qrgEncoder.encodeAsBitmap();
                        img.setImageBitmap(bitmap);
                    } catch (WriterException e){
                        Log.v(TAG,e.toString());
                    }
                } else {
                    et.setError("Required");
                }

            }
        });


    }
}