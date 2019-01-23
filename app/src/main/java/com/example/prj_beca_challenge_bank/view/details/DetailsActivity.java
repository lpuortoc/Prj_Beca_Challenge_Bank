package com.example.prj_beca_challenge_bank.view.details;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.prj_beca_challenge_bank.utils.Alert;
import com.example.prj_beca_challenge_bank.R;
import com.example.prj_beca_challenge_bank.adapter.RecentAdapter;

public class DetailsActivity extends AppCompatActivity {

    private Context context;
    private Button btnLogout;
    private RecyclerView recyclerViewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        context = DetailsActivity.this;
        //
        btnLogout = findViewById(R.id.detailsBtnLogout);
        //
        initiaizeRecyclerView();
    }

    private void initiaizeRecyclerView() {
        recyclerViewDetails = findViewById(R.id.detailsRvDetails);
        //
        initializeRecyclerViewLayoutManager();
        //
        initializeRecyclerViewAdapter();
    }

    private void initializeRecyclerViewLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerViewDetails.setLayoutManager(layoutManager);
    }

    private void initializeRecyclerViewAdapter() {
        RecentAdapter recentAdapter = new RecentAdapter();
        recyclerViewDetails.setAdapter(recentAdapter);
    }

    private void inicializarAcao() {
        buttonLogout();
    }

    private void buttonLogout() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alert.alertLogout(context, "Sair da conta", "Realmente deseja sair de sua conta?");
            }
        });
    }

//    public void callLoginActivity() {
//        Intent intent = new Intent(context, LoginActivity.class);
//        //
//        startActivity(intent);
//        //
//        finish();
//    }

    @Override
    public void onBackPressed() {
        Alert.alertLogout(context, "Sair da conta", "Realmente deseja sair de sua conta?");
    }
}
