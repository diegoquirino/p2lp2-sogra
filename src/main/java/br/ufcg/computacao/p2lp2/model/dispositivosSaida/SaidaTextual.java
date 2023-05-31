package br.ufcg.computacao.p2lp2.model.dispositivosSaida;

import br.ufcg.computacao.p2lp2.model.DispositivoSaida;
import br.ufcg.computacao.p2lp2.model.FormaGeometrica;
import br.ufcg.computacao.p2lp2.model.formasGeometricas.Circulo;
import br.ufcg.computacao.p2lp2.model.formasGeometricas.Retangulo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaidaTextual implements DispositivoSaida {

    public static final String DEFAULT_FILES_PATH = System.getProperty("user.dir");

    @Override
    public void exibir(FormaGeometrica formaGeometrica) {
        System.out.println("Exibiu " + formaGeometrica + " na saida textual");

        if(formaGeometrica instanceof Circulo) salvar((Circulo) formaGeometrica);
        else if(formaGeometrica instanceof Retangulo) salvar((Retangulo) formaGeometrica);
        else throw new RuntimeException("Não existe forma geométrica válida para ser desenhada");
    }

    public void salvar(Circulo circulo) {
        File file = new File(DEFAULT_FILES_PATH + File.separator + "circulo.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            int raio = circulo.getRaio().intValue();
            int diametro = raio * 2;
            char[][] matriz = new char[diametro + 1][diametro + 1];

            for (int i = 0; i <= diametro; i++) {
                for (int j = 0; j <= diametro; j++) {
                    double distancia = Math.sqrt(Math.pow((j - raio), 2) + Math.pow((i - raio), 2));
                    if (Math.abs(distancia - raio) < 0.5) {
                        matriz[i][j] = '*';
                    } else {
                        matriz[i][j] = ' ';
                    }
                }
            }

            for (int i = 0; i <= diametro; i++) {
                for (int j = 0; j <= diametro; j++) {
                    writer.write(matriz[i][j]);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvar(Retangulo retangulo) {
        File file = new File(DEFAULT_FILES_PATH + File.separator + "retangulo.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            int ladoA = retangulo.getLadoA().intValue();
            int ladoB = retangulo.getLadoB().intValue();
            for (int i = 0; i < ladoB; i++) {
                for (int j = 0; j < ladoA; j++) {
                    if (i == 0 || i == ladoB - 1 || j == 0 || j == ladoA - 1) {
                        writer.write("*");
                    } else {
                        writer.write(" ");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
