package br.ufcg.computacao.p2lp2.model.formasGeometricas;

import br.ufcg.computacao.p2lp2.model.FormaGeometrica;

import java.awt.*;
import java.util.Objects;

public class Circulo extends FormaGeometrica {

    private Double raio;

    public Circulo(Color corDaLinha, Color corDoPreenchimento, Double raio) {
        super(corDaLinha, corDoPreenchimento);
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public String toString() {
        return "Circulo{" +
                super.toString() +
                " -> raio=" + raio +
                ", area=" + area() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circulo circulo)) return false;
        return Objects.equals(getRaio(), circulo.getRaio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRaio());
    }

    @Override
    public int compareTo(FormaGeometrica o) {
        return this.raio.compareTo(((Circulo)o).getRaio());
    }

}
