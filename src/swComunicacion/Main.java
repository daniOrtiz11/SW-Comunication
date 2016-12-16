package swComunicacion;


import swComunicacion.views.PrincipalView;

public class Main {

	public static void main(String[] args) {
		 /* Voice voice;
		  String path = null;
		  try {
			path = new java.io.File(".").getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  path = path+"\\mbrola";
		   System.setProperty("mbrola.base", path);
		   listAllVoices();
		  VoiceManager voiceManager = VoiceManager.getInstance();
		  voice = voiceManager.getVoice("mbrola_us1");
		  voice.allocate();
		  voice.speak("Mi nueva voz es mas sexy");
		  voice.speak("Aunque alomejor preferís la anterior");
		  */
		Data d = new Data(true, 1000);
	   	Controller c = new Controller(d);
	   	@SuppressWarnings("unused")
	   	PrincipalView vista = new PrincipalView(c);
	}
	/*
	public static void listAllVoices() {
	    System.out.println("All voices available:");        
	    VoiceManager voiceManager = VoiceManager.getInstance();
	    Voice[] voices = voiceManager.getVoices();
	    for (int i = 0; i < voices.length; i++) {
	        System.out.println("    " + voices[i].getName()
	                           + " (" + voices[i].getDomain() + " domain)");
	    }

	}
	*/
	}


