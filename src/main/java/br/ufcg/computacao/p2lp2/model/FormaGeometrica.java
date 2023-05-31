package br.ufcg.computacao.p2lp2.model;

import java.awt.*;

public abstract class FormaGeometrica implements Comparable<FormaGeometrica> {

    private Color corDaLinha;
    private Color corDoPreenchimento;
    private DispositivoSaida dispositivoSaida;

    public FormaGeometrica(Color corDaLinha, Color corDoPreenchimento, DispositivoSaida dispositivoSaida) {
        this.corDaLinha = corDaLinha;
        this.corDoPreenchimento = corDoPreenchimento;
        this.dispositivoSaida = dispositivoSaida;
    }

    public FormaGeometrica(Color corDaLinha, Color corDoPreenchimento) {
        this.corDaLinha = corDaLinha;
        this.corDoPreenchimento = corDoPreenchimento;
    }

    public Color getCorDaLinha() {
        return corDaLinha;
    }

    public void setCorDaLinha(Color corDaLinha) {
        this.corDaLinha = corDaLinha;
    }

    public Color getCorDoPreenchimento() {
        return corDoPreenchimento;
    }

    public void setCorDoPreenchimento(Color corDoPreenchimento) {
        this.corDoPreenchimento = corDoPreenchimento;
    }

    public DispositivoSaida getDispositivoSaida() {
        return dispositivoSaida;
    }

    public void setDispositivoSaida(DispositivoSaida dispositivoSaida) {
        this.dispositivoSaida = dispositivoSaida;
    }

    public abstract Double area();

    public void exibir() {
        this.dispositivoSaida.exibir(this);
    }

    @Override
    public String toString() {
        return "FormaGeometrica{" +
                "corDaLinha='" + corDaLinha + '\'' +
                ", corDoPreenchimento='" + corDoPreenchimento + '\'' +
                ", dispositivoSaida=" + dispositivoSaida +
                '}';
    }

}
