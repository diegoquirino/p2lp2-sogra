package br.ufcg.computacao.p2lp2;

import br.ufcg.computacao.p2lp2.controller.SograFacade;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SograFacade driver = new SograFacade();
        driver.adicionarCirculo("circulo", 50.0, Color.BLACK, Color.CYAN);
        driver.adicionarRetangulo("retangulo", 50.0, 150.0, Color.BLACK, Color.ORANGE);
        driver.adicionarSaidaTextual("arquivotxt");
        driver.adicionarJanelaGrafica("janelagrafica");

        driver.exibir("retangulo", "janelagrafica");
        driver.exibir("circulo", "janelagrafica");
        driver.exibir("retangulo", "arquivotxt");
        driver.exibir("circulo", "arquivotxt");
    }

}
