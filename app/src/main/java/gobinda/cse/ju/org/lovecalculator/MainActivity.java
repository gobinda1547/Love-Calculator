package gobinda.cse.ju.org.lovecalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText hisName;
    private EditText herName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hisName = (EditText) findViewById(R.id.editTextHisName);
        herName = (EditText) findViewById(R.id.editTextHerName);
    }

    public void calculateLoveBtnPressed(View view){

        String s1 = hisName.getText().toString().replaceAll(" ","");
        String s2 = herName.getText().toString().replaceAll(" ","");

        if(s1.length() == 0){
            AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
            a_builder.setMessage("Enter His Name Please!")
                    .setCancelable(false)
                    .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }) ;
            AlertDialog alert = a_builder.create();
            alert.setTitle("Alert !!!");
            alert.show();
            return;
        }

        if(s2.length() == 0){
            AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
            a_builder.setMessage("Enter Her Name Please!")
                    .setCancelable(false)
                    .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }) ;
            AlertDialog alert = a_builder.create();
            alert.setTitle("Alert !!!");
            alert.show();
            return;
        }


        int ans1 = 0;
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            if('a'<=ch && ch<='z'){
                ans1 += ch-'a'+1;
            }else if('A'<=ch && ch<='Z'){
                ans1 += ch-'A'+1;
            }
        }

        int ans2 = 0;
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if('a'<=ch && ch<='z'){
                ans2 += ch-'a'+1;
            }else if('A'<=ch && ch<='Z'){
                ans2 += ch-'A'+1;
            }
        }

        int min = Math.min(ans1,ans2);
        int max = Math.max(ans1,ans2);

        if(max == 0){
            AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
            a_builder.setMessage("Bad Input!")
                    .setCancelable(false)
                    .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }) ;
            AlertDialog alert = a_builder.create();
            alert.setTitle("Alert !!!");
            alert.show();
            return;
        }


        double finalAns  = (min*100.0)/max;
        int finalAnsLast = (int) finalAns;
        finalAnsLast%=100;

        //System.out.println(finalAnsLast);
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("value",String.valueOf(finalAnsLast));
        startActivity(intent);
        finish();

    }


}