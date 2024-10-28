package com.syaviraindahmaryam.task;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ViewHolder> {
    private Context context;
    private List<Agenda> agendaList;

    public AgendaAdapter(Context context, List<Agenda> agendaList) {
        this.context = context;
        this.agendaList = agendaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.agenda_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Agenda agenda = agendaList.get(position);
        holder.tvNama.setText(agenda.getNama());
        holder.tvDeskripsi.setText(agenda.getDeskripsi());

        String status = agenda.getStatus();
        holder.tvStatus.setText(status);

        if (status.equals("Selesai")) {
            holder.tvStatus.setTextColor(Color.GREEN);
        } else {
            holder.tvStatus.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return agendaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvDeskripsi, tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            tvStatus = itemView.findViewById(R.id.tv_status);
        }
    }
}
