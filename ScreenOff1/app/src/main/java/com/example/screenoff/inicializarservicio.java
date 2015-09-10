package com.example.screenoff;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

public class inicializarservicio extends Service {
	
		private Timer timer;
	    final  int REFRESH=0;
	    Context context;
	   // private PendingIntent pendingIntent;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 @Override
	    public void onCreate() {
	        // TODO Auto-generated method stub
		    super.onCreate();
	          
	        try {
	        	Toast.makeText(getApplicationContext(), "SERVICIO CREADO", Toast.LENGTH_LONG).show(); 
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	 }
	 
	 public int onStartCommand(Intent intento, int bandera, int idArranque){
			
			Toast.makeText(getApplicationContext(), "SERVICIO QUE ARRANCO"+idArranque+bandera, Toast.LENGTH_LONG).show();
			
			 
//	         Intent myIntent = new Intent(inicializarservicio.this, YOURCLASS.class); 
//	         startActivity(myIntent);
			
			intento = new Intent(getBaseContext(), YOURCLASS.class);
			intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intento.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        intento.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED + WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD + WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON + WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
			getApplication().startActivity(intento);
	         
	        // pendingIntent = PendingIntent.getActivity(context, 0, myIntent, 0);
			
			return START_STICKY;
			
		}
		
		public void onDestroy(){
			super.onDestroy();
			
			Toast.makeText(getApplicationContext(), "SERVICIO DESTRUIDO", Toast.LENGTH_LONG).show();
			
			Intent intento = new Intent(getBaseContext(), PrincipalSO.class);
				intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intento.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		        //intento.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED + WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD + WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON + WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
				getApplication().startActivity(intento);
		}

	        
//	         AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
//	        Calendar calendar = Calendar.getInstance();


	         }


	


