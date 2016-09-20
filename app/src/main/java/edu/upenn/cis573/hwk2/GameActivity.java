package edu.upenn.cis573.hwk2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.content.Intent;
import android.view.Menu;

public class GameActivity extends android.support.v7.app.ActionBarActivity {

    private GameView view;

    /*
    This method is called when the Activity is first launched.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Dots and Boxes");
        view = new GameView(this);
        view.reset();
        setContentView(view);
    }

    /*
    This method is called when the menu is created.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
     This method is called when a menu option is selected.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_undo) view.undo();
        else if (id == R.id.action_clear) view.reset();
        else if (id == R.id.action_quit) {
            AlertDialog dialog = onCreateDialog();
            dialog.show();
        }

        return true;
    }


    public AlertDialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Don't Leave Me!").setMessage("Are you sure you want to quit?")
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }

                })
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }

}