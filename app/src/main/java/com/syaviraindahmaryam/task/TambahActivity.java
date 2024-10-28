package com.syaviraindahmaryam.task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etDeskripsi;
    private Spinner etStatus;
    private Button btnSave;
    private AgendaRepository agendaRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etDeskripsi = findViewById(R.id.et_deskripsi);
        etStatus = findViewById(R.id.status);
        btnSave = findViewById(R.id.btn_save);
        agendaRepository = AgendaRepository.getInstance(this);

        String[] statusOptions = getResources().getStringArray(R.array.status_options);
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, statusOptions);
        etStatus.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                String deskripsi = etDeskripsi.getText().toString();
                String status = etStatus.getSelectedItem().toString();

                if (!nama.isEmpty() && !deskripsi.isEmpty()) {
                    agendaRepository.insertAgenda(nama, deskripsi, status);
                    Toast.makeText(TambahActivity.this, "Agenda berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                    updateSpinnerWithStatus(status);

                    finish();
                } else {
                    Toast.makeText(TambahActivity.this, "Lengkapi semua data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateSpinnerWithStatus(String status) {
        int position = status.equals("Selesai") ? 0 : 1;
        etStatus.setSelection(position);
    }
}
