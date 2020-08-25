package net.eu5.calibos.samplepy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;


public class MainActivity extends AppCompatActivity {

EditText e1,e2;
Integer a,b;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        e1=findViewById (R.id.a);
        e2=findViewById (R.id.b);
        b1=findViewById (R.id.add);
        b2=findViewById (R.id.sub);

        b1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (! Python.isStarted()) {
                    Python.start(new AndroidPlatform (MainActivity.this));
                }
                Python py=Python.getInstance ();
                PyObject pyo=py.getModule ("myscript");
                a=Integer.parseInt (e1.getText ().toString ());
                b=Integer.parseInt (e2.getText ().toString ());
                PyObject pyo1=pyo.callAttr ("add",a,b);
                Toast.makeText (getApplicationContext (),pyo1.toString (),Toast.LENGTH_LONG).show ();
            }
        });
        b2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (! Python.isStarted()) {
                    Python.start(new AndroidPlatform (MainActivity.this));
                }
                Python py=Python.getInstance ();
                PyObject pyo=py.getModule ("myscript");
                a=Integer.parseInt (e1.getText ().toString ());
                b=Integer.parseInt (e2.getText ().toString ());
                PyObject pyo1=pyo.callAttr ("sub",a,b);
                Toast.makeText (getApplicationContext (),pyo1.toString (),Toast.LENGTH_LONG).show ();
            }
        });

    }
}
