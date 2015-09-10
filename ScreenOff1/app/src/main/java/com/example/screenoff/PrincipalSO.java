package com.example.screenoff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class PrincipalSO extends Activity {
	
	Button activar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_so);
        
        activar=(Button)findViewById(R.id.button1_iniciar);
        
        Toast.makeText(getApplicationContext(), "OPRIMA MENU PARA SALIR", Toast.LENGTH_LONG).show();
        
        activar.setOnClickListener( new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startService(new Intent(PrincipalSO.this,inicializarservicio.class));
				
				finish();
				
			}
			
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal_so, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
