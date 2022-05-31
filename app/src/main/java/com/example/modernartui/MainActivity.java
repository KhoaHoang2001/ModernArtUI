package com.example.modernartui;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view1 = findViewById(R.id.view1);
        View view2 = findViewById(R.id.view2);
        View view3 = findViewById(R.id.view3);
        View view5 = findViewById(R.id.view5);

        SeekBar sb = findViewById(R.id.seekBar);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int light_blue = getResources().getColor(R.color.light_blue);
                int pink = getResources().getColor(R.color.pink);
                int red = getResources().getColor(R.color.red);
                int blue = getResources().getColor(R.color.blue);
                int yellow = getResources().getColor(R.color.yellow);
                int beige = getResources().getColor(R.color.beige);
                int orange = getResources().getColor(R.color.orange);
                int green = getResources().getColor(R.color.green);

                view1.setBackgroundColor((int) (light_blue + (yellow - light_blue) * ( i / 100f )));
                view2.setBackgroundColor((int) (pink + (beige - pink) * ( i / 100f )));
                view3.setBackgroundColor((int) (red + (orange - red) * ( i / 100f )));
                view5.setBackgroundColor((int) (blue + (green - blue) * ( i / 100f )));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.moreinfo){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(R.string.dialog_text);
            builder.setCancelable(false);
            builder.setPositiveButton(
                    R.string.visit_MOMA,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            doPositiveClick();
                        }
                    }
            );
            builder.setNegativeButton(
                    R.string.not_now,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }
            );
            builder.create().show();
            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }

    public void doPositiveClick(){
        Uri uri = Uri.parse("http://www.moma.org");
        Intent visit = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(visit);
    }

}