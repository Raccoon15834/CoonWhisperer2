package das.anusha.coonwhisperer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton switchButton;
    TextView message, display;
    EditText inp;
   // int msgCounter = -1;
    //String[] strArr;
    Message myMsg;
    RadioGroup pickLangOpts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        display = findViewById(R.id.displayMsg);
        inp = findViewById(R.id.inputBlank);
        switchButton = findViewById(R.id.switchButton);
        pickLangOpts = findViewById(R.id.pickLangGroup);

        myMsg = new Message(getResources().getStringArray(R.array.messagesArray));
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMsg.nextMessage();
                message.setText(myMsg.getDisp());
                display.setText(myMsg.getDisp());
                //https://developer.android.com/reference/java/util/Formatter
            }
        });
        inp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
            @Override
            public void onTextChanged(CharSequence newText, int i, int i1, int i2) {
                display.setText(myMsg.fillBlanks(newText.toString()));
            }
        });
        pickLangOpts.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int comp = radioGroup.getCheckedRadioButtonId();
                switch(comp){
                    case R.id.btnCoon:
                        display.setText("Sorry, a Raccoon has demolished the translaaaasdjghuiwew...");
                        break;
                    case R.id.btnOneUp:
                        display.setText(myMsg.oneUp());
                        break;
                    case R.id.btnCat:
                        display.setText(myMsg.cattify());
                        break;
                }
            }
        });

    }
}
