package pacote.aula08;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtNota1;
    private EditText txtNota2;
    private TextView tvValorMedia;
    private Button btnCalcular;
    private Button btnExibir;
    private Button btnSair;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // res > layout > activitymain.xml
        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnExibir = findViewById(R.id.btnExibir);
        btnSair = findViewById(R.id.btnSair);
        tvValorMedia = findViewById(R.id.tvValorMedia);
        btnSair.setOnClickListener(view -> System.exit(0));
        /* >>> lambda (linha acima ^) substitui a forma abaixo:
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        >>> economiza linhas e economiza imports (✿◡‿◡)!*/
        btnExibir.setOnClickListener(view -> {
            String msg = "";
            msg += txtNome.getText() + "\n";
            msg += txtEmail.getText() + "\n";
            msg += "Notas: " + txtNota1.getText() + " e " + txtNota2.getText();
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        });
        btnCalcular.setOnClickListener(view -> {
            double n1, n2, media;
            n1 = Double.parseDouble(txtNota1.getText().toString());
            n2 = Double.parseDouble(txtNota2.getText().toString());
            media = (n1 + n2) / 2;
            tvValorMedia.setText(Double.toString(media));
        });
    }
    /* >>> forma mais antiga (classe interna não-anônima) ¬_¬:
    class ListenerBtnSair implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            System.exit(0);
        }
    }*/
}