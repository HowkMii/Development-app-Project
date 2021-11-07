package coj.example.pwdevapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.*
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.getbase.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.security.AccessController.getContext
import java.time.LocalDateTime
import java.util.Calendar.getInstance


class MainActivity : AppCompatActivity() {
    private lateinit var codeScanner: CodeScanner

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dbManager = DbManager(this)
        var dbStudent = dbManager.DatabaseHelperStudent(this)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),100)
        }
       val fab: FloatingActionButton = findViewById(R.id.fab_addstd)
        fab.setOnClickListener {
            startActivity(
                Intent(
                    this,
                        AddStudentActivity::class.java
                )
            )
        }

        supportActionBar?.hide()
        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)

        codeScanner = CodeScanner(this, scannerView)

        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {

                Toast.makeText(this, "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
                var time =  LocalDateTime.now().toString()
                dbStudent.insertUserP(it.text,true,time)
            }
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {

            }
        }
        //var dbM:DbManager=DbManager(this)
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }



    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

}
