package ca.yorku.eecs.mack.demobuttons_96073;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * Demo_Buttons
 *
 * Login ID - ryankluk
 * Student ID - 218096073
 * Last name - Luk
 * First name(s) - Ryan
 */
@SuppressWarnings("unused")
public class DemoButtons_96073Activity extends Activity {
    private final static String MYDEBUG = "MYDEBUG"; // for Log.i messages

    Button b;
    CheckBox cb;
    RadioButton rb1, rb2, rb3;
    ToggleButton tb;
    ImageButton backspaceButton;
    TextView buttonClickStatus, checkBoxClickStatus, radioButtonClickStatus, toggleButtonClickStatus,
            backspaceButtonClickStatus;
    Button resetButton;
    String buttonClickString, backspaceString;
    boolean checkStatus;
    boolean rb1Status, rb2Status, rb3Status;
    boolean tbStatus;

    // called when the activity is first created
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
    }

    private void init() {
        b = (Button) findViewById(R.id.button);
        cb = (CheckBox) findViewById(R.id.checkbox);
        rb1 = (RadioButton) findViewById(R.id.radiobutton1);
        rb2 = (RadioButton) findViewById(R.id.radiobutton2);
        rb3 = (RadioButton) findViewById(R.id.radiobutton3);
        rb1.toggle();
        tb = (ToggleButton) findViewById(R.id.togglebutton);
        backspaceButton = (ImageButton) findViewById(R.id.backspacebutton);
        resetButton = (Button) findViewById(R.id.resetbutton);

        buttonClickStatus = (TextView) findViewById(R.id.buttonclickstatus);
        checkBoxClickStatus = (TextView) findViewById(R.id.checkboxclickstatus);
        radioButtonClickStatus = (TextView) findViewById(R.id.radiobuttonclickstatus);
        toggleButtonClickStatus = (TextView) findViewById(R.id.togglebuttonclickstatus);
        backspaceButtonClickStatus = (TextView) findViewById(R.id.backspacebuttonclickstatus);

        buttonClickString = "";
        backspaceString = "";

        buttonClickStatus.setText(buttonClickString);
        checkBoxClickStatus.setText(R.string.unchecked);
        radioButtonClickStatus.setText(R.string.red);
        radioButtonClickStatus.setTextColor(Color.RED);
        toggleButtonClickStatus.setText(R.string.off);
    }

    // handle button clicks
    public void buttonClick(View v) {
        // plain button
        if (v == b) {
            buttonClickString += ".";
            buttonClickStatus.setText(buttonClickString);
        }

        // checkbox
        else if (v == cb) {
            if (cb.isChecked()) {
                cb.setChecked(true);
                checkBoxClickStatus.setText(R.string.checked);
            } else {
                cb.setChecked(false);
                checkBoxClickStatus.setText(R.string.unchecked);
            }
        }

        // radio button #1 (RED)
        else if (v == rb1) {
            rb1.setChecked(true);
            radioButtonClickStatus.setText(R.string.red);
            radioButtonClickStatus.setTextColor(Color.RED);
        }

        // radio button #2 (GREEN)
        else if (v == rb2) {
            rb2.setChecked(true);
            radioButtonClickStatus.setText(R.string.green);
            radioButtonClickStatus.setTextColor(Color.GREEN);
        }

        // radio button #3 (BLUE)
        else if (v == rb3) {
            rb3.setChecked(true);
            radioButtonClickStatus.setText(R.string.blue);
            radioButtonClickStatus.setTextColor(Color.BLUE);
        }

        // toggle button
        else if (v == tb) {
            tb.setActivated(tb.isChecked());
            if (tb.isChecked())
                toggleButtonClickStatus.setText(R.string.on);
            else
                toggleButtonClickStatus.setText(R.string.off);
        }

        // backspace button
        else if (v == backspaceButton) {
            backspaceString += "BK ";
            backspaceButtonClickStatus.setText(backspaceString);
        }

        // Reset button
        else if (v == resetButton) {
            Log.i(MYDEBUG, "Reset Button Clicked!");

            // Reset stored values
            buttonClickString = "";
            backspaceString = "";

            // Reset UI elements
            buttonClickStatus.setText("");
            backspaceButtonClickStatus.setText("");
            checkBoxClickStatus.setText(R.string.unchecked);
            radioButtonClickStatus.setText(R.string.red);
            radioButtonClickStatus.setTextColor(Color.RED);
            toggleButtonClickStatus.setText(R.string.off);

            // Reset states
            cb.setChecked(false);
            rb1.setChecked(true);
            rb2.setChecked(false);
            rb3.setChecked(false);
            tb.setChecked(false);

            // Force UI refresh
            resetButton.invalidate();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save current UI states
        outState.putString("buttonClickString", buttonClickString);
        outState.putString("backspaceString", backspaceString);
        outState.putBoolean("checkStatus", cb.isChecked());
        outState.putBoolean("rb1Status", rb1.isChecked());
        outState.putBoolean("rb2Status", rb2.isChecked());
        outState.putBoolean("rb3Status", rb3.isChecked());
        outState.putBoolean("tbStatus", tb.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state variables
        buttonClickString = savedInstanceState.getString("buttonClickString", "");
        backspaceString = savedInstanceState.getString("backspaceString", "");
        checkStatus = savedInstanceState.getBoolean("checkStatus", false);
        rb1Status = savedInstanceState.getBoolean("rb1Status", true);
        rb2Status = savedInstanceState.getBoolean("rb2Status", false);
        rb3Status = savedInstanceState.getBoolean("rb3Status", false);
        tbStatus = savedInstanceState.getBoolean("tbStatus", false);

        // Restore UI elements
        buttonClickStatus.setText(buttonClickString);
        backspaceButtonClickStatus.setText(backspaceString);
        checkBoxClickStatus.setText(checkStatus ? R.string.checked : R.string.unchecked);
        radioButtonClickStatus.setText(rb1Status ? R.string.red : rb2Status ? R.string.green : R.string.blue);
        radioButtonClickStatus.setTextColor(rb1Status ? Color.RED : rb2Status ? Color.GREEN : Color.BLUE);
        toggleButtonClickStatus.setText(tbStatus ? R.string.on : R.string.off);

        // Restore states
        cb.setChecked(checkStatus);
        rb1.setChecked(rb1Status);
        rb2.setChecked(rb2Status);
        rb3.setChecked(rb3Status);
        tb.setChecked(tbStatus);
    }
}
