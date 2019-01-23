package com.example.prj_beca_challenge_bank.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prj_beca_challenge_bank.R;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView transaction;
        private TextView debit;
        private TextView date;
        private TextView value;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //
            transaction = itemView.findViewById(R.id.cellTvTransactionType);
            debit = itemView.findViewById(R.id.cellTvTypeDebit);
            date = itemView.findViewById(R.id.cellTvDate);
            value = itemView.findViewById(R.id.cellTvValue);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_recyclerview_details, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.transaction.setText("Pagamento");
        myViewHolder.debit.setText("Conta de luz");
        myViewHolder.date.setText("18/01/2019");
        myViewHolder.value.setText("R$ 1.000,00");
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
