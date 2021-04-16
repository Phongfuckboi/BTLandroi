package com.example.orderfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.orderfood.DAO.bananDAO;

public class thembanactiv extends AppCompatActivity implements View.OnClickListener{

    EditText edt_themban;
    Button btn_themban;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themban);
        edt_themban= findViewById(R.id.edt_themban);
        btn_themban= findViewById(R.id.btn_themban);

    }
    @Override
    public void onClick(View v) {
        String sTenBanAn = edt_themban.getText().toString();
        if (sTenBanAn != null || sTenBanAn.equals("")){
            boolean kiemtra = bananDAO.ThemBanAn(sTenBanAn);
            Intent intent = new Intent();
            intent.putExtra("ketquathem", kiemtra);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

    }
}
