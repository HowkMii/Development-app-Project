package coj.example.pwdevapp

import android.content.ContentValues
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.app.DialogCompat
import androidx.core.widget.addTextChangedListener

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        supportActionBar?.hide()
        val button = findViewById<Button>(R.id.submit)
        val stdeditText = findViewById<EditText>(R.id.std_id)
        val fneditText = findViewById<EditText>(R.id.fname)
        val lneditText = findViewById<EditText>(R.id.lname)
        val majeditText = findViewById<EditText>(R.id.major)
        val bdeditText = findViewById<EditText>(R.id.bday)
        val dbM:DbManager.DatabaseHelperStudent=DbManager(this).DatabaseHelperStudent(this)

        button.setOnClickListener {


                if (  !(stdeditText.editableText.toString().compareTo("") == 0)
                        && !(fneditText.editableText.toString().compareTo("") == 0)
                        && !(lneditText.editableText.toString().compareTo("") == 0 )
                        && !(majeditText.editableText.toString().compareTo("") == 0)
                        && !(bdeditText.editableText.toString().compareTo("") == 0) ) {
                        Log.v("Hakim","nkfdkgnkdfngdfklngkldfngdfkn")
                    if(dbM.checkUser(stdeditText.editableText.toString())) {
                        val e :PDialog = PDialog( {
                            dbM.updateUser(stdeditText.editableText.toString(),
                                    fneditText.editableText.toString(),
                                    lneditText.editableText.toString(),
                                    majeditText.editableText.toString(),
                                    bdeditText.editableText.toString())
                        })
                        e.show(supportFragmentManager,null)
                    } else {
                        dbM.insertUser(stdeditText.editableText.toString(),
                                fneditText.editableText.toString(),
                                lneditText.editableText.toString(),
                                majeditText.editableText.toString(),
                                bdeditText.editableText.toString())
                    }

            }
        }
    }
}