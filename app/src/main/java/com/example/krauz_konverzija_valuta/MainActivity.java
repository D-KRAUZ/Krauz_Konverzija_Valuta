package com.example.krauz_konverzija_valuta;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    String DD_text;



    double Tecaj[][] = new double[3][3];







    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    Tecaj[0][0]=7.511897;
    Tecaj[0][1]=7.534500;
    Tecaj[0][2]=7.557104;

    Tecaj[1][0] =7.042843;
    Tecaj[1][1] =7.064035;
    Tecaj[1][2] =7.085227;

    Tecaj[2][0] =7.628614;
    Tecaj[2][1] =7.651569;
    Tecaj[2][2] =7.674524;

    String[] Tecaji = new String[3];
    Tecaji[0] = "Srednji Tečaj";
    Tecaji[1] = "Kupovni Tečaj";
    Tecaji[2] = "Prodajni Tečaj";

    Spinner sp1 = (Spinner) findViewById(R.id.drop);
    Button btn1= (Button) findViewById(R.id.button1);

    TextView tv1 = (TextView) findViewById(R.id.textView12);
    TextView tv2 = (TextView) findViewById(R.id.textView13);
    TextView tv3 = (TextView) findViewById(R.id.textView14);


    EditText ed1= (EditText) findViewById(R.id.editTextTextPersonName4);

    double Vrijednost[] = new double[3];

    ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.Tecaji, android.R.layout.simple_spinner_item);

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    sp1.setAdapter(adapter);
        tv1.setText(DD_text);

    sp1.setOnItemSelectedListener(this);

    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {


            if(checkerFunc(DD_text,Tecaji[0]))
            {
                try
                {

//                    Vrijednost[0] = Math.round(Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[0][0],2);
                    Vrijednost[0] = (double) Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[0][0])*100)/100 ;
                    Vrijednost[1] = (double) Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[1][0])*100)/100 ;
                    Vrijednost[2] = (double) Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[2][0])*100)/100 ;

                    tv1.setText(String.valueOf(Vrijednost[0]));
                    tv2.setText(String.valueOf(Vrijednost[1]));
                    tv3.setText(String.valueOf(Vrijednost[2]));

                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this,"Krivo si upisao broj!",Toast.LENGTH_SHORT).show();
                    ed1.setText("");
                }
            }
            if(checkerFunc(DD_text,Tecaji[1]))
            {
                try
                {
                    Vrijednost[0] = (double)Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[0][1])*100)/100 ;
                    Vrijednost[1] = (double)Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[1][1])*100)/100 ;
                    Vrijednost[2] = (double)Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[2][1])*100)/100 ;

                    tv1.setText(String.valueOf(Vrijednost[0]));
                    tv2.setText(String.valueOf(Vrijednost[1]));
                    tv3.setText(String.valueOf(Vrijednost[2]));
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Krivo si upisao broj!",Toast.LENGTH_SHORT).show();
                    ed1.setText("");
                }


            }

            if(checkerFunc(DD_text,Tecaji[2]))
            {
                try
                {
                    Vrijednost[0] = (double)Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[0][2])*100)/100 ;
                    Vrijednost[1] = (double)Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[1][2])*100)/100 ;
                    Vrijednost[2] = (double)Math.round((Double.parseDouble(String.valueOf(ed1.getText())) / Tecaj[2][2])*100)/100 ;

                    tv1.setText(String.valueOf(Vrijednost[0]));
                    tv2.setText(String.valueOf(Vrijednost[1]));
                    tv3.setText(String.valueOf(Vrijednost[2]));
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Krivo si upisao broj!",Toast.LENGTH_SHORT).show();
                    ed1.setText("");
                }


            }
        }
    });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String txt =parent.getItemAtPosition(position).toString();
        DD_text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(),txt,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
    public boolean checkerFunc(String a, String b)
    {
        boolean p = false;
        int k=0;
        for (int ip=0;ip<a.length();ip++)
        {
            if (a.toCharArray()[0] == b.toCharArray()[0])
            {
                    p = true;
            }
            else
            {
                p = false;
            }
        }
        return p;
    }
}

