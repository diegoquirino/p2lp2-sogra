package br.ufcg.computacao.p2lp2.model.formasGeometricas;

import br.ufcg.computacao.p2lp2.model.FormaGeometrica;

import java.awt.*;
import java.util.Objects;

public class Retangulo extends FormaGeometrica {

    private Double ladoA;
    private Double ladoB;

    public Retangulo(Color corDaLinha, Color corDoPreenchimento,
                     Double ladoA, Double ladoB) {
        super(corDaLinha, corDoPreenchimento);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public Double getLadoA() {
        return ladoA;
    }

    public void setLadoA(Double ladoA) {
        this.ladoA = ladoA;
    }

    public Double getLadoB() {
        return ladoB;
    }

    public void setLadoB(Double ladoB) {
        this.ladoB = ladoB;
    }

    @Override
    public Double area() {
        return ladoA * ladoB;
    }

    @Override
    public String toString() {
        return "Retangulo{" +
                super.toString() +
                " -> ladoA=" + ladoA +
                ", ladoB=" + ladoB +
                ", area=" + area() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Retangulo retangulo)) return false;
        return Objects.equals(getLadoA(), retangulo.getLadoA()) && Objects.equals(getLadoB(), retangulo.getLadoB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLadoA(), getLadoB());
    }

    @Override
    public int compareTo(FormaGeometrica o) {
        return this.ladoA.compareTo(((Retangulo)o).getLadoA()) +
                this.ladoB.compareTo(((Retangulo)o).getLadoB());
    }

}
