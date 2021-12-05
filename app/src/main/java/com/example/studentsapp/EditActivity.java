package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class EditActivity extends AppCompatActivity {

    String studentId;
    Student student;
    Intent result;

    //View items
    ImageView pictureImgv;
    EditText nameEt;
    EditText idEt;
    CheckBox flagCb;
    Button cancelBtn;
    Button deleteBtn;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Log.d("TAG", "EditActivity onCreate");

        //Creations and settings
        result = new Intent();

        //Get student
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            studentId = extras.getString("studentId");
        }
        student = Model.instance.getStudent(studentId);

        getViews();
        setViews();

        //TODO: replace with fragments
        //Set buttons listeners
        cancelBtn.setOnClickListener(v -> {
            Log.d("TAG", "EditActivity CANCEL");
            setResult(RESULT_OK, result);
            finish();
        });
        deleteBtn.setOnClickListener(v -> {
            Model.instance.removeStudent(student);
            setResult(RESULT_CANCELED, result);
            finish();
        });
        saveBtn.setOnClickListener(v -> {
            //Validate unique ID was typed
            String inputId = idEt.getText().toString();
            if (Model.instance.exists(inputId) && !studentId.equals(inputId)) {
                //TODO: return error "Student Exists!"
                return;
            }
            Model.instance.updateStudent(student, idEt.getText().toString(), nameEt.getText().toString(), flagCb.isChecked(), student.getPictureRid());
            result.putExtra("studentId", idEt.getText().toString());
            setResult(RESULT_OK, result);
            finish();
        });
    }

    protected void getViews() {
        //Get View items
        pictureImgv = findViewById(R.id.edit_picture_imgv);
        nameEt = findViewById(R.id.edit_nameValue_et);
        idEt = findViewById(R.id.edit_idValue_et);
        flagCb = findViewById(R.id.edit_flag_cb);
        cancelBtn = findViewById(R.id.edit_cancel_btn);
        deleteBtn = findViewById(R.id.edit_delete_btn);
        saveBtn = findViewById(R.id.edit_save_btn);
    }

    protected void setViews() {
        //Set student values in view items
        pictureImgv.setImageResource(student.getPictureRid());
        nameEt.setText(student.getName());
        idEt.setText(student.getId());
        flagCb.setChecked(student.isFlagged());
    }


    //______________________Other Activity States_____________________________
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "EditActivity onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "EditActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "EditActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "EditActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "EditActivity onDestroy");
    }
}