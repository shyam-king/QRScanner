package com.example.qrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    CodeScanner codeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CodeScannerView scannerView = findViewById(R.id.scannerView);
        codeScanner = new CodeScanner(this, scannerView);
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_LONG).show();
            }
        });
        codeScanner.startPreview();
    }

    @Override
    protected void onResume() {
        codeScanner.startPreview();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        codeScanner.startPreview();
        super.onRestart();
    }


    @Override
    protected void onStop() {
        codeScanner.releaseResources();
        super.onStop();
    }
}
