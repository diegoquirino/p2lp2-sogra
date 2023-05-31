package br.ufcg.computacao.p2lp2.controller;

import br.ufcg.computacao.p2lp2.model.DispositivoSaida;
import br.ufcg.computacao.p2lp2.model.FormaGeometrica;
import br.ufcg.computacao.p2lp2.model.dispositivosSaida.JanelaGrafica;
import br.ufcg.computacao.p2lp2.model.dispositivosSaida.SaidaTextual;
import br.ufcg.computacao.p2lp2.model.formasGeometricas.Circulo;
import br.ufcg.computacao.p2lp2.model.formasGeometricas.Retangulo;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class SograFacade {

    private final Map<String, FormaGeometrica> formasGeometricas;

    private final Map<String, DispositivoSaida> dispositivosSaida;

    public SograFacade() {
        this.formasGeometricas = new HashMap<>();
        this.dispositivosSaida = new HashMap<>();
    }

    public Map<String, FormaGeometrica> getFormasGeometricas() {
        return formasGeometricas;
    }

    public Map<String, DispositivoSaida> getDispositivosSaida() {
        return dispositivosSaida;
    }

    public void adicionarSaidaTextual(String id) {
        this.dispositivosSaida.put(id, new SaidaTextual());
    }

    public void adicionarJanelaGrafica(String id) {
        this.dispositivosSaida.put(id, new JanelaGrafica());
    }

    public void adicionarCirculo(String id, Double raio, Color corDaLinha, Color corDoPreenchimento) {
        this.formasGeometricas.put(id, new Circulo(corDaLinha, corDoPreenchimento, raio));
    }

    public void adicionarRetangulo(String id, Double ladoA, Double ladoB, Color corDaLinha, Color corDoPreenchimento) {
        this.formasGeometricas.put(id, new Retangulo(corDaLinha, corDoPreenchimento, ladoA, ladoB));
    }

    public void exibir(String idFormaGeometrica, String idDispositivoSaida) {
        this.formasGeometricas.get(idFormaGeometrica)
                .setDispositivoSaida(this.dispositivosSaida.get(idDispositivoSaida));
        this.formasGeometricas.get(idFormaGeometrica)
                .exibir();
    }

    public Double calcularArea(String id) {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        return Double.parseDouble(df.format(formasGeometricas.get(id).area()));
    }


}
