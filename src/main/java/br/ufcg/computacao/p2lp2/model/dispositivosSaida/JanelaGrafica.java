package br.ufcg.computacao.p2lp2.model.dispositivosSaida;

import br.ufcg.computacao.p2lp2.model.DispositivoSaida;
import br.ufcg.computacao.p2lp2.model.FormaGeometrica;
import br.ufcg.computacao.p2lp2.view.JanelaGraficaPanel;

import javax.swing.*;

public class JanelaGrafica implements DispositivoSaida {
    @Override
    public void exibir(FormaGeometrica formaGeometrica) {
        System.out.println("Exibiu " + formaGeometrica + " na janela grafica");
        desenhar(formaGeometrica);
    }

    public void desenhar(FormaGeometrica formaGeometrica) {
        JFrame frame = new JFrame("Exibição de Forma Geométrica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JPanel panel = new JanelaGraficaPanel(formaGeometrica);
        frame.add(panel);
        frame.setVisible(true);
    }
}
