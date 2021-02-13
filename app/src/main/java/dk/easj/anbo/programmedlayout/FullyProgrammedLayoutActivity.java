package dk.easj.anbo.programmedlayout;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FullyProgrammedLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fully_programmed_layout);
        // XML layout file NOT used

        ViewGroup.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        this.addContentView(layout, params);

        TextView textView = new TextView(this);
        textView.setText("This Activity is totally programmed. No layout XML file");
        textView.setLayoutParams(params);
        layout.addView(textView);

        final EditText editText = new EditText(this);
        editText.setHint("Number of buttons");
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setLayoutParams(params);
        layout.addView(editText);

        Button button = new Button(this);
        button.setText("Next");
        button.setLayoutParams(params);
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PartiallyProgrammedLayoutActivity.class);
                String numberStr = editText.getText().toString();
                int numberOfButtons = Integer.parseInt(numberStr);
                intent.putExtra(PartiallyProgrammedLayoutActivity.NUMBER_OF_BUTTONS, numberOfButtons);
                startActivity(intent);
            }
        });
    }
}
