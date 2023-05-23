package com.example.cobarecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mhs> mhslist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNama = (EditText) findViewById(R.id.edNama);
        EditText edNIM = (EditText) findViewById(R.id.edNIM);
        EditText edNoHp = (EditText) findViewById(R.id.edNoHp);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        mhslist = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListMhsActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isian_nama = edNama.getText().toString();
                String isian_nim = edNIM.getText().toString();
                String isian_noHp = edNoHp.getText().toString();

                if(isian_nama.isEmpty() || isian_nim.isEmpty() || isian_noHp.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isian Masih Kosong", Toast.LENGTH_SHORT).show();
                }else{
                    mhslist.add(new Mhs(isian_nama, isian_nim, isian_noHp));

                    edNama.setText("");
                    edNIM.setText("");
                    edNoHp.setText("");

                    intent_list.putParcelableArrayListExtra("mhslist", mhslist);
                    startActivity(intent_list);
                }
            }
        });

        Button btnLihat = (Button) findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mhslist.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Belum Ada Data", Toast.LENGTH_SHORT).show();
                }else{

                    intent_list.putParcelableArrayListExtra("mhslist", mhslist);
                    startActivity(intent_list);

                }

            }
        });

    }
}