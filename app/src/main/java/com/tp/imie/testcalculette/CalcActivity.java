package com.tp.imie.testcalculette;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CalcActivity extends Activity {

    public Button bouton_0;
    public Button bouton_1;
    public Button bouton_2;
    public Button bouton_3;
    public Button bouton_4;
    public Button bouton_5;
    public Button bouton_6;
    public Button bouton_7;
    public Button bouton_8;
    public Button bouton_9;
    public Button bouton_point;
    public Button bouton_plus;
    public Button bouton_moins;
    public Button bouton_multi;
    public Button bouton_div;
    public Button bouton_result;
    public Button bouton_ce;
    public EditText ecran;

    private boolean update = false;
    private boolean clickOperateur = false;
    private double chiffre1;
    private String operateur = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        bouton_0 = (Button) findViewById(R.id.bouton_0);
        bouton_1 = (Button) findViewById(R.id.bouton_1);
        bouton_2 = (Button) findViewById(R.id.bouton_2);
        bouton_3 = (Button) findViewById(R.id.bouton_3);
        bouton_4 = (Button) findViewById(R.id.bouton_4);
        bouton_5 = (Button) findViewById(R.id.bouton_5);
        bouton_6 = (Button) findViewById(R.id.bouton_6);
        bouton_7 = (Button) findViewById(R.id.bouton_7);
        bouton_8 = (Button) findViewById(R.id.bouton_8);
        bouton_9 = (Button) findViewById(R.id.bouton_9);
        bouton_point = (Button) findViewById(R.id.bouton_point);
        bouton_plus = (Button) findViewById(R.id.bouton_plus);
        bouton_moins = (Button) findViewById(R.id.bouton_moins);
        bouton_multi = (Button) findViewById(R.id.bouton_multi);
        bouton_div = (Button) findViewById(R.id.bouton_div);
        bouton_ce = (Button) findViewById(R.id.bouton_ce);
        bouton_result = (Button) findViewById(R.id.bouton_result);
        ecran = (EditText) findViewById(R.id.editText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar wittZll
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void afficherChiffre(View view){
        String str = ((Button) view).getText().toString();
        Log.i("appui touche", str);
        if (!"0".equals(ecran.getText().toString())){
            str = ecran.getText() + str;
        }
        ecran.setText(str);
    }

    public void calcul(){
        if ("+".equals(operateur)){
            chiffre1 = chiffre1 + Double.valueOf(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre1));
        }

        if ("-".equals(operateur)){
            chiffre1 = chiffre1 - Double.valueOf(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre1));
        }

        if ("*".equals(operateur)){
            chiffre1 = chiffre1 * Double.valueOf(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre1));
        }

        if ("/".equals(operateur)){
            try{
                chiffre1 = chiffre1 / Double.valueOf(ecran.getText().toString());
                ecran.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                ecran.setText("0");
            }
        }
    }

    public void operateNombres(View view){

        if (clickOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        } else {
            chiffre1 = Double.valueOf(ecran.getText().toString());
            clickOperateur = true;
            ecran.setText("");
        }
        operateur = ((Button) view).getText().toString();
        Log.i("appui touche", operateur);
        update = true;
    }

    public void egal(View view){
        calcul();
        update = true;
        clickOperateur = false;
    }

    public void resetClick(View view){
        clickOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        ecran.setText("");
    }

}
