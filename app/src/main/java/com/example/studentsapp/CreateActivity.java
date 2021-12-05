package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class CreateActivity extends AppCompatActivity {

    //View items
    ImageButton pictureImgbtn;
    EditText nameEt;
    EditText idEt;
    CheckBox flagCb;
    Button cancelBtn;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        getViews();

        //Set buttons listeners
        cancelBtn.setOnClickListener(v -> finish());
        saveBtn.setOnClickListener(v -> {
            //Validate unique ID was typed
            String inputId = idEt.getText().toString();
            if (Model.instance.exists(inputId)) {
                //TODO: return error "Student Exists!"
                return;
            }
            Model.instance.addStudent(new Student(idEt.getText().toString(), nameEt.getText().toString(), flagCb.isChecked(), R.drawable.empty_pic));
            finish();
        });
    }

    protected void getViews() {
        //Get View items
        pictureImgbtn = findViewById(R.id.create_picture_imgbtn);
        nameEt = findViewById(R.id.create_nameValue_et);
        idEt = findViewById(R.id.create_idValue_et);
        flagCb = findViewById(R.id.create_flag_cb);
        cancelBtn = findViewById(R.id.create_cancel_btn);
        saveBtn = findViewById(R.id.create_save_btn);
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