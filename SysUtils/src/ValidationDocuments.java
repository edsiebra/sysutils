import java.util.InputMismatchException;

public class ValidationDocuments {

public static boolean validationCPF(String cpf) {
		
		String texto = cpf;
		texto = texto.replace(".", "");
		texto = texto.replace("-", "");
		
		if(texto.equals("00000000000") || 
				texto.equals("11111111111") ||
				texto.equals("22222222222") || 
				texto.equals("33333333333") ||
				texto.equals("44444444444") ||
				texto.equals("55555555555") ||
				texto.equals("66666666666") ||
				texto.equals("77777777777") ||
				texto.equals("88888888888") ||
				texto.equals("99999999999") ||
				texto.length() != 11
				){
			return false;
		}
		
		char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {

            num = (int)(texto.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 
            
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(texto.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == texto.charAt(9)) && (dig11 == texto.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
		
	}
	
	public static boolean validationCNPJ(String cnpj) {
		
		String texto = cnpj;
		texto = texto.replace(".", "");
		texto = texto.replace("-", "");
		texto = texto.replace("/", "");
		
		
		if (texto.equals("00000000000000") || texto.equals("11111111111111") ||
				texto.equals("22222222222222") || texto.equals("33333333333333") ||
				texto.equals("44444444444444") || texto.equals("55555555555555") ||
				texto.equals("66666666666666") || texto.equals("77777777777777") ||
				texto.equals("88888888888888") || texto.equals("99999999999999") ||
		       (texto.length() != 14))
		       return(false);

		    char dig13, dig14;
		    int sm, i, r, num, peso;

		    try {
		      sm = 0;
		      peso = 2;
		      for (i=11; i>=0; i--) {

		        num = (int)(texto.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso + 1;
		        if (peso == 10)
		           peso = 2;
		      }

		      r = sm % 11;
		      if ((r == 0) || (r == 1))
		         dig13 = '0';
		      else dig13 = (char)((11-r) + 48);

		      sm = 0;
		      peso = 2;
		      for (i=12; i>=0; i--) {
		        num = (int)(texto.charAt(i)- 48);
		        sm = sm + (num * peso);
		        peso = peso + 1;
		        if (peso == 10)
		           peso = 2;
		      }

		      r = sm % 11;
		      if ((r == 0) || (r == 1))
		         dig14 = '0';
		      else dig14 = (char)((11-r) + 48);

		      if ((dig13 == texto.charAt(12)) && (dig14 == texto.charAt(13)))
		         return(true);
		      else return(false);
		    } catch (InputMismatchException erro) {
		        return(false);
		    }
		
		
	}
}
