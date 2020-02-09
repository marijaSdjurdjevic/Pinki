package timer;

import java.util.Timer;
import java.util.TimerTask;

import daoImpl.DaoOsnovnoSredstvo;


public class TimerUpis {

	public static void timerZaUpis(Object obj) {
		int MINUTES = 2; // The delay in minutes
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() { // Function runs every MINUTES minutes.
				try {
					if(obj instanceof DaoOsnovnoSredstvo)
						((DaoOsnovnoSredstvo)obj).saveAll();
//					else if(obj instanceof DaoAdministracijaEmisija)
//						((DaoAdministracijaEmisija)obj).saveAll();
//					else if(obj instanceof DaoKorisnik)
//						((DaoKorisnik)obj).saveAll();
//					else if(obj instanceof DaoSnimanje)
//						((DaoSnimanje)obj).saveAll();
//					else if(obj instanceof DaoStudio())
//						((DaoStudio)obj).saveAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, 1000 * 60 * MINUTES);
		// 1000 milliseconds in a second * 60 per minute * the MINUTES variable.
	}
	
}
