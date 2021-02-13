package dk.easj.anbo.programmedlayout;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PartiallyProgrammedLayoutActivity extends AppCompatActivity {

    public static final String NUMBER_OF_BUTTONS = "NUMBER_OF_BUTTONS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partially_programmed_layout);

        int defaultValue = 1;
        Intent intent = getIntent();
        int howManyButtons = intent.getIntExtra(NUMBER_OF_BUTTONS, defaultValue);

        ViewGroup layout = findViewById(R.id.partiallyProgrammedLayout);
        ViewGroup.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 1; i <= howManyButtons; i++) {
            final int buttonNumber = i;
            Button button = new Button(this);
            button.setText("Buttton " + i);
            layout.addView(button, params);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getBaseContext(), "You clicked button " + buttonNumber, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}