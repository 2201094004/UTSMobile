package com.syaviraindahmaryam.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AgendaRepository agendaRepository;
    private RecyclerView recyclerView;
    private AgendaAdapter agendaAdapter;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agendaRepository = AgendaRepository.getInstance(this);
        recyclerView = findViewById(R.id.recyclerViewAgenda);
        fabAdd = findViewById(R.id.fabAddAgenda);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadAgendas();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TambahActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadAgendas();
    }

    private void loadAgendas() {
        List<Agenda> agendaList = agendaRepository.getAllAgendas();
        agendaAdapter = new AgendaAdapter(this, agendaList);
        recyclerView.setAdapter(agendaAdapter);
    }
}
