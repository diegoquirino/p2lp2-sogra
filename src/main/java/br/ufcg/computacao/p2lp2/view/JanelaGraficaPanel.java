package br.ufcg.computacao.p2lp2.view;

import br.ufcg.computacao.p2lp2.model.FormaGeometrica;
import br.ufcg.computacao.p2lp2.model.formasGeometricas.Circulo;
import br.ufcg.computacao.p2lp2.model.formasGeometricas.Retangulo;

import javax.swing.*;
import java.awt.*;

public class JanelaGraficaPanel extends JPanel {

    private FormaGeometrica formaGeometrica;

    public JanelaGraficaPanel(FormaGeometrica formaGeometrica) {
        this.formaGeometrica = formaGeometrica;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.formaGeometrica instanceof Circulo) desenharCirculo(g);
        else if(this.formaGeometrica instanceof Retangulo) desenharRetangulo(g);
        else throw new RuntimeException("Não existe forma geométrica válida para ser desenhada");
    }

    private void desenharCirculo(Graphics g) {
        // Desenhar um círculo
        Circulo circulo = (Circulo) this.formaGeometrica;
        int raio = circulo.getRaio().intValue();
        int xCirculo = raio + 100;
        int yCirculo = raio + 100;
        g.setColor(circulo.getCorDoPreenchimento());
        g.fillOval(xCirculo - raio, yCirculo - raio, raio * 2, raio * 2);
        g.setColor(circulo.getCorDaLinha());
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawOval(xCirculo - raio, yCirculo - raio, raio * 2, raio * 2);
    }

    private void desenharRetangulo(Graphics g) {
        // Desenhar um quadrado
        Retangulo retangulo = (Retangulo) this.formaGeometrica;
        int ladoA = retangulo.getLadoA().intValue();
        int ladoB = retangulo.getLadoB().intValue();
        int xQuadrado = ladoA/2 + 100;
        int yQuadrado = ladoB/2 + 100;
        g.setColor(Color.GREEN);
        g.fillRect(xQuadrado, yQuadrado, ladoA, ladoB);
        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(10));
        g.drawRect(xQuadrado, yQuadrado, ladoA, ladoB);
    }

}
