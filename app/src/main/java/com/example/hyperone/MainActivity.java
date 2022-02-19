package com.example.hyperone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hyperone.adapter.UiAdapter;
import com.example.hyperone.pojo.Model;
import com.example.hyperone.viewModel.ViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ViewModel viewModel;
    private UiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new UiAdapter(this);
        recyclerView.setAdapter(adapter);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getModel();
        viewModel.getModels().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                adapter.setList(models);
            }
        });

    }
}