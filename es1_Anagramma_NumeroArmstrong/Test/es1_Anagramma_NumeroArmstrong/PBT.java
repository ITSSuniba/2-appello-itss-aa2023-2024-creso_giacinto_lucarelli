package es1_Anagramma_NumeroArmstrong;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

class PBT {

		Anagramma_NArmstrong nA = new Anagramma_NArmstrong(); 
		
		@Property
        @StatisticsReport(format = Histogram.class)
        void shouldReturnCorrectResultPropertyBased(@ForAll @IntRange(min = Integer.MIN_VALUE, max = Integer.MAX_VALUE)Integer numero) {
            String range = nA.isNumeroArmstrong(numero) == true ? "Numeri Di Armstrong" : "Numeri Non di Armstrong";
            String r3 = numero < 0 ? "Numeri Negativi Generati (Non Armstrong)" : "Numeri Positivi Generati";
            Statistics.label("Statistiche").collect(range).collect(r3);
        	Statistics.label("value").collect(numero);
        	}
		
}
