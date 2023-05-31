package br.ufcg.computacao.p2lp2.controller;

import br.ufcg.computacao.p2lp2.model.dispositivosSaida.SaidaTextual;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Fachada do SOftware de renderizacao GRÁfica - SOGRA ")
class SograFacadeTest {

    SograFacade driver;

    @BeforeEach
    void setUp() {
        driver = new SograFacade();
        driver.adicionarCirculo("circulo", 50.0, Color.BLACK, Color.CYAN);
        driver.adicionarRetangulo("retangulo", 50.0, 150.0, Color.BLACK, Color.ORANGE);
        driver.adicionarSaidaTextual("arquivotxt");
        driver.adicionarJanelaGrafica("janelagrafica");
    }

    @AfterEach
    void tearDown() {
        driver = null;
    }

    @Test
    @DisplayName("Quando se deseja calcular a área do círculo")
    void quandoCalcularAreaDoCirculo() {
        // Arrange
        // Act
        Double resultado = driver.calcularArea("circulo");
        // Assert
        assertEquals(7853.98, resultado);
    }

    @Test
    @DisplayName("Quando se deseja calcular a área do retângulo")
    void quandoCalcularAreaDoRetangulo() {
        // Arrange
        // Act
        Double resultado = driver.calcularArea("retangulo");
        // Assert
        assertEquals(7500.0, resultado);
    }

    @Test
    @DisplayName("Quando é adicionado 01(um) dispositivo do tipo Saída Textual")
    void quandoEhAdicionadoUmDispositivoSaidaTextual() {
        // Arrange
        // Act
        driver.adicionarSaidaTextual("Outro arquivo txt");
        // Assert
        assertEquals(3, driver.getDispositivosSaida().size());
    }

    @Test
    @DisplayName("Quando é adicionado 01(um) dispositivo do tipo Janela Gráfica")
    void quandoEhAdicionadoUmDispositivoJanelaGrafica() {
        // Arrange
        // Act
        driver.adicionarJanelaGrafica("Outra Janela Gráfica");
        // Assert
        assertEquals(3, driver.getDispositivosSaida().size());
    }

    @Test
    @DisplayName("Quando é adicionado 01 (um) Circulo")
    void quandoEhAdicionadoUmCirculo() {
        // Arrange
        // Act
        driver.adicionarCirculo("circulo2", 50.0, Color.BLACK, Color.CYAN);
        // Assert
        assertEquals(3, driver.getFormasGeometricas().size());
    }

    @Test
    @DisplayName("Quando é adicionado 01 (um) Retangulo")
    void quandoEhAdicionadoUmRetangulo() {
        // Arrange
        // Act
        driver.adicionarRetangulo("retangulo2", 50.0, 150.0, Color.BLACK, Color.ORANGE);
        // Assert
        assertEquals(3, driver.getFormasGeometricas().size());
    }

    @Test
    @DisplayName("Quando se exibe um Círculo na Janela Gráfica")
    void quandoExibeCirculoEmJanelaGrafica() {
        // Arrange
        // Act
        try {
            driver.exibir("circulo", "janelagrafica");
            // Assert
        } catch (Exception e) {
            fail(e.getMessage() + "=>" + Arrays.toString(e.getStackTrace()));
        }

    }

    @Test
    @DisplayName("Quando se exibe um Retângulo na Janela Gráfica")
    void quandoExibeRetanguloEmJanelaGrafica() {
        // Arrange
        // Act
        try {
            driver.exibir("retangulo", "janelagrafica");
            // Assert
        } catch (Exception e) {
            fail(e.getMessage() + "=>" + Arrays.toString(e.getStackTrace()));
        }

    }

    @Test
    @DisplayName("Quando se exibe um Círculo em SaidaTextual")
    void quandoExibeCirculoEmSaidaTextal() {
        // Arrange
        // Act
        driver.exibir("circulo", "arquivotxt");
        // Assert
        String filePath = SaidaTextual.DEFAULT_FILES_PATH + File.separator + "circulo.txt";
        File file = new File(filePath);
        assertTrue(file.exists(), "O arquivo não existe: " + filePath);
        if(file.exists()) assertTrue(file.delete());
    }

    @Test
    @DisplayName("Quando se exibe um Retangulo em SaidaTextual")
    void quandoExibeRetanguloEmSaidaTextal() {
        // Arrange
        // Act
        driver.exibir("retangulo", "arquivotxt");
        // Assert
        String filePath = SaidaTextual.DEFAULT_FILES_PATH + File.separator + "retangulo.txt";
        File file = new File(filePath);
        assertTrue(file.exists(), "O arquivo não existe: " + filePath);
        if(file.exists()) assertTrue(file.delete());
    }

}