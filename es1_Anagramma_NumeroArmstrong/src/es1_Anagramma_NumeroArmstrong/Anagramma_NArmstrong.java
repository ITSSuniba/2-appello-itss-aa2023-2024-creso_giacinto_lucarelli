package es1_Anagramma_NumeroArmstrong;
import java.util.Arrays;


public class Anagramma_NArmstrong {
	 	 
	    public boolean sonoAnagrammi(String str1, String str2) {
	        // Controlla se entrambe le stringhe sono non nulle
	        if (str1 == null || str2 == null) {
	         return false;
	        }
	 
	        // Rimuove spazi e converte le stringhe in minuscolo per la verifica dell'anagramma
	        String cleanedStr1 = str1.replaceAll("\\s", "").toLowerCase();
	        String cleanedStr2 = str2.replaceAll("\\s", "").toLowerCase();
	 
	        // Control se le lunghezze delle stringhe sono uguali
	        if (cleanedStr1.length() != cleanedStr2.length()) {
	            return false;
	        }
	 
	        // Verifica se le stringhe sono anagrammi
	        char[] chars1 = cleanedStr1.toCharArray();
	        char[] chars2 = cleanedStr2.toCharArray();
	 
	        // Ordina i caratteri delle due stringhe
	        Arrays.sort(chars1);
	        Arrays.sort(chars2);
	 
	        // Confronta i caratteri ordinati
	        return Arrays.equals(chars1, chars2);
	    }
	 
	    public boolean isNumeroArmstrong(Integer numero) {
	        
	    	//controlla che il numero inserito non sia null
	    	if (numero == null) {
	    		return false;
	    	}
	    	
	    	// Converte il numero in una stringa per ottenere la lunghezza
	        String numeroStr = Integer.toString(numero);
	        int lunghezza = numeroStr.length();
	 
	        
	        // Calcola la somma delle potenze delle cifre
	        int somma = 0;
	        int n = numero;
	        while (n > 0) {
	            int cifra = n % 10;
	            somma += Math.pow(cifra, lunghezza);
	            n /= 10;
	        }
	 
	        // Verifica se il numero è un numero di Armstrong
	        return somma == numero;
	    }
	}
