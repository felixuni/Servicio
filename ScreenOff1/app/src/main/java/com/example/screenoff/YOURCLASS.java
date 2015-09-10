package com.example.screenoff;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Vibrator;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class YOURCLASS extends Activity {
	
	int retardo=5000;
	Button cerrar;
	
	private Vibrator vibrator;
	private Ringtone ringtone;
	private int mode;
	
	// Patron de repique
	long pattern[]={0,300,200,300,500};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.presentacion);
	        
	        // Audio Manager - Se obtiene el modo de sonido
		    AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
		    mode = am.getRingerMode();
		    
		    // Verifica el modo de sonido del telefono
		    switch (am.getRingerMode()) {
		        case AudioManager.RINGER_MODE_SILENT:
		            break;
		            
		        case AudioManager.RINGER_MODE_NORMAL:
		    		Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
		    		ringtone = RingtoneManager.getRingtone(this, uri);
		    		ringtone.play();
		        case AudioManager.RINGER_MODE_VIBRATE:
		        	vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
		        	vibrator.vibrate(pattern, 0);
		            break;
		    }
	       
	        @SuppressWarnings("deprecation")
			KeyguardLock lock = ((KeyguardManager) getSystemService(Activity.KEYGUARD_SERVICE)).newKeyguardLock(KEYGUARD_SERVICE);
	        PowerManager powerManager = ((PowerManager) getSystemService(Context.POWER_SERVICE));
	        WakeLock wake = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "TAG");

	       // lock.disableKeyguard();
	       
	        //para trabajar con la pantalla bloqueada
	        
	        wake.acquire();

	        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
	                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
	                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
	                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
	                | WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
	        Toast.makeText(getApplicationContext(), "oncreate", Toast.LENGTH_LONG).show();
	        cerrar=(Button)findViewById(R.id.button1_cerrar);
	       
			cerrar.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					// Detiene el ringtone al colgarse la llamada
					switch (mode) {
				        case AudioManager.RINGER_MODE_SILENT:
				            break;
				        
				        case AudioManager.RINGER_MODE_NORMAL:
				    		ringtone.stop();
				        case AudioManager.RINGER_MODE_VIBRATE:
				        	vibrator.cancel();
				            break;
				    }
					
					setResult(RESULT_OK);
					finish();
				}
				
				
			});
			
		}

	        
	        
	 
	 
	public void onDestroy(){
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "ondestroy", Toast.LENGTH_LONG).show();
		Intent intent = new Intent();
		intent.setClass(YOURCLASS.this, inicializarservicio.class); 
		YOURCLASS.this.stopService(intent);
	}
	


}
