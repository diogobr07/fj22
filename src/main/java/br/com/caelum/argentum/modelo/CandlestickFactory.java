package br.com.caelum.argentum.modelo;

import java.util.List;
import java.util.Calendar;

public class CandlestickFactory {
	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		double maximo = negociacoes.get(0).getPreco();
		double minimo =  negociacoes.get(0).getPreco();
		double volume = 0;
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		
		double abertura = negociacoes.get(0).getPreco();
		double fechamento = negociacoes.get(negociacoes.size() -1).getPreco();
		
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
