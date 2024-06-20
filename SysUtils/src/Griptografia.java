import java.util.Base64;

import org.jasypt.util.text.BasicTextEncryptor;

public class Griptografia {

	String password = "kdQ@125";
	
	public String criptografarBase64(String texto) {
		
		String encod = Base64.getEncoder().encodeToString(texto.getBytes());
		return encod;
		
	}
	
	public String deserializaBase64(String texto) {
		
		String encod = new String(Base64.getDecoder().decode(texto));
		return encod;
	}
	
	public String criptografarJasypt(String texto) {
		BasicTextEncryptor encod = new BasicTextEncryptor();
		encod.setPasswordCharArray(password.toCharArray());
		return encod.encrypt(texto);
	}
	
	public String deserializaJasypt(String texto) {
		BasicTextEncryptor encod = new BasicTextEncryptor();
		encod.setPasswordCharArray(password.toCharArray());
		return encod.decrypt(texto);
	}
	
}
