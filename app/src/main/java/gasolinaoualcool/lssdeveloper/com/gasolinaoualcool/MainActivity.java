package gasolinaoualcool.lssdeveloper.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.resultadoTextoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strPrecoAlcool = precoAlcool.getText().toString();
                String strPrecoGasolina = precoGasolina.getText().toString();
                boolean isPrecoAlcoolVazia = strPrecoAlcool.isEmpty();
                boolean isPrecoGasolinaVazia = strPrecoGasolina.isEmpty();

                Double vlrAlcool = Double.parseDouble(strPrecoAlcool);
                Double vlrGasolina = Double.parseDouble(strPrecoGasolina);
                String msg = "Informe um preço para o álcool.";

                if(isPrecoAlcoolVazia){
                    textoResultado.setText(msg);
                }else if(isPrecoGasolinaVazia){
                    msg = "Informe um preço para a gasolina.";
                    textoResultado.setText(msg);
                }else{
                    Double resultado = vlrAlcool / vlrGasolina;
                    if (resultado >= 0.7){
                        //Gasolina
                        msg = "É melhor utilizar a gasolina.";
                        textoResultado.setText(msg);
                    }else{
                        //Álcool
                        msg = "É melhor utilizar o álcool.";
                        textoResultado.setText(msg);
                    }
                }
            }
        });
    }
}
