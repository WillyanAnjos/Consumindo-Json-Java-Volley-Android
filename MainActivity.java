package com.willyan.consumindoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //*************************************************
    //Código para consumir JSON
    //*************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Configuração da classe principal
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Txt resultado
        final TextView txt_resposta = (TextView) findViewById(R.id.txt_resposta);


        //Objeto para criar a requisição
        RequestQueue queue = Volley.newRequestQueue(this);

        //Endereço do json na web
        String url = "http://vendasvarejo.com/requisicao.php";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET
                , url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                
                //Bloco para controle de erros
                try {
                    //Pega o elemento especifico do response
                    String email = response.getString("Email");
                    String senha = response.getString("Senha");

                    txt_resposta.setText("email: " + email + "\n" + "senha: " + senha);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            //Caso ocorra algum erro irá ser apresentado na tela
            public void onErrorResponse(VolleyError error){
                txt_resposta.setText("Error");
            }
        });

        //adiciona os elementos da requisicao ao RequestQueue
       queue.add(jsonObjectRequest);
    }
}