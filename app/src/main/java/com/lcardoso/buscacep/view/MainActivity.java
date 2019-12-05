package com.lcardoso.buscacep.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lcardoso.buscacep.R;
import com.lcardoso.buscacep.model.ApiService;
import com.lcardoso.buscacep.model.CEP;
import com.lcardoso.buscacep.model.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etCep;
    public String SELECTED_CEP = null;
    private TextView textCep, textRua, textBairro, textCidade;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setEditText();
        setButton();
    }

    public void setEditText() {
        etCep = findViewById(R.id.etCep);
        textCep = findViewById(R.id.textCep);
        textRua = findViewById(R.id.textRua);
        textBairro = findViewById(R.id.textBairro);
        textCidade = findViewById(R.id.textCidade);
    }

    public void setButton(){
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECTED_CEP = etCep.getText().toString();
                if(SELECTED_CEP != null && SELECTED_CEP.length() == 8){
                    getData();
                } else {
                    Toast.makeText(MainActivity.this, "Cep inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getData() {

        Call<CEP> call = ApiService.getInstance().getCEP(SELECTED_CEP);

        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if (response.isSuccessful()) {
                    CEP cep = response.body();

                    textCep.setText(cep.getCep());
                    textRua.setText(cep.getLogradouro());
                    textBairro.setText(cep.getBairro());
                    textCidade.setText(cep.getLocalidade() + "/" + cep.getUf());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });

    }
}
