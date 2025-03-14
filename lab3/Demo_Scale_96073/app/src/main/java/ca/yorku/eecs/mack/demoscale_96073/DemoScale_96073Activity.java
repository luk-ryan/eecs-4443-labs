package ca.yorku.eecs.mack.demoscale_96073;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Demo_Scale - demonstrate moving and scaling an image using touch and multitouch <p>
 * Login ID - ryankluk
 * Student ID - 218096073
 * Last name - Luk
 * First name(s) - Ryan
 */

public class DemoScale_96073Activity extends Activity
{
    PaintPanel imagePanel; // the panel in which to paint the image
    StatusPanel statusPanel; // a status panel the display the image coordinates, size, and scale

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // hide title bar
        setContentView(R.layout.main);

        // get references to UI components
        // cast removed (not needed anymore, avoids warning message)
        imagePanel = findViewById(R.id.paintpanel);
        statusPanel = findViewById(R.id.statuspanel);

        // give the image panel a reference to the status panel
        imagePanel.setStatusPanel(statusPanel);
    }

    // Called when the "Reset" button is pressed.
    public void clickReset(View view)
    {
        imagePanel.xPosition = 10;
        imagePanel.yPosition = 10;
        imagePanel.scaleFactor = 1f;
        imagePanel.isLocked = false;
        imagePanel.invalidate();
    }
}
