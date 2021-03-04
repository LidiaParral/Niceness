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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    String TAG = "GenerateQR";
    EditText et;
    ImageView img;
    String inputvalue;
    Button btn;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    private ZXingScannerView scannerView;

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



    public void escanear(View view) {

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        scannerView.setResultHandler(this);
        scannerView.startCamera();

    }

    @Override
    public void handleResult(Result result) {

        Log.v("HandleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado del scan");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        scannerView.resumeCameraPreview(this);
    }

}