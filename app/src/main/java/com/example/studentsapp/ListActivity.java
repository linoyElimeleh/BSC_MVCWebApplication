package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    List<Student> data;
    Intent detailsIntent;
    RecyclerView list;
    ListAdapter adapter;
    Button createBtn;
    Intent createIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.d("TAG","ListActivity onCreate");

        //Creations and settings
        detailsIntent = new Intent(this, DetailsActivity.class);
        createIntent = new Intent(this, CreateActivity.class);
        data = Model.instance.getAllStudents();

        //Set list and adapter
        list = findViewById(R.id.studentlist_rv);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter();
        list.setAdapter(adapter);

        //Create the row items listeners actions
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                detailsIntent.putExtra("studentId", data.get(position).getId());
                startActivity(detailsIntent);
            }
            @Override
            public void onItemCheck(int position, boolean checked) {
                data.get(position).setFlag(checked);
            }
        });

        //Set create button
        createBtn = findViewById(R.id.create_btn);
        //TODO: replace with fragments
        createBtn.setOnClickListener(v -> startActivity(createIntent));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","ListActivity onResume");

        data = Model.instance.getAllStudents();
        adapter.notifyDataSetChanged();
    }

    //______________________Listeners Interface Wrapper______________________________________
    //Interface wrapper for a list item listeners
    interface OnItemClickListener {
        void onItemClick(int position);
        void onItemCheck(int position, boolean checked);
    }

    //______________________Recycler View Holder Implementation_____________________________
    //Holds student's row view items and links them to the view resources
    class RowHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView idTv;
        CheckBox flagCb;
        ImageView pictureIv;

        //Constructor
        public RowHolder(@NonNull View itemView, OnItemClickListener clickListener) {
            super(itemView);

            //Set row view resources
            nameTv = itemView.findViewById(R.id.listrow_name_tv);
            idTv = itemView.findViewById(R.id.listrow_id_tv);
            flagCb = itemView.findViewById(R.id.listrow_cb);
            pictureIv = itemView.findViewById(R.id.listrow_picture_imv);

            //Sets row listeners
            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                clickListener.onItemClick(pos);
            });
            flagCb.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                clickListener.onItemCheck(pos, flagCb.isChecked());
            });
        }
    }

    //______________________Recycler View Adapter Implementation_____________________________
    //Student list adapter holding also the row listeners
    class ListAdapter extends RecyclerView.Adapter<RowHolder> {

        OnItemClickListener clickListener;

        //Row listeners setters
        public void setOnItemClickListener(OnItemClickListener listener) {
            this.clickListener = listener;
        }

        @NonNull
        @Override
        //Settings for when creating the row view holder
        //Creates the row view from the row view resource and creates a view holder for it
        public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.list_row, parent, false);
            RowHolder holder = new RowHolder(view, clickListener);
            return holder;
        }

        @Override
        //Settings for when binding the view items and view resources
        public void onBindViewHolder(@NonNull RowHolder holder, int position) {
            Student student = data.get(position);
            holder.nameTv.setText(student.getName());
            holder.idTv.setText(student.getId());
            holder.flagCb.setChecked(student.isFlagged());
            holder.pictureIv.setImageResource(student.getPictureRid());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    //______________________Other Activity States_____________________________
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","ListActivity onCreate");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","ListActivity onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","ListActivity onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","ListActivity onDestroy");
    }
}