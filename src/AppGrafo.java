import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppGrafo {

    public static void main(String[] args) {
        List<Vertice<String>> vertices = new ArrayList<>();
        List<Arestas<String>> arestas = new ArrayList<>();

        // Definição dos vértices do grafo
        String[] verticesArr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "X", "Z"};

        // Adiciona os vértices ao grafo
        for (String vertice : verticesArr) {
            Vertice<String> v = new Vertice<>(vertice);
            vertices.add(v);
        }

        // Adiciona as arestas do grafo
        adicionarArestas(arestas, vertices);

        // Solicita ao usuário o ponto de partida e o ponto de chegada
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o ponto de partida: ");
        String pontoPartida = scanner.nextLine();
        System.out.print("Informe o ponto de chegada: ");
        String pontoChegada = scanner.nextLine();

        // Obtém o trajeto ponto a ponto
        Arestas<String> aresta = buscarAresta(arestas, pontoPartida, pontoChegada);
        if (aresta != null) {
            // Apresenta o trajeto e a distância
            System.out.println("Trajeto:");
            for (Vertice<String> vertice : aresta.getVertices()) {
                System.out.print(vertice.getValor() + " -> ");
            }
            System.out.println("Chegada");
            int distancia = aresta.getMetros();
            System.out.println("Distância total: " + distancia + " metros");
        } else {
            System.out.println("Não foi encontrado um trajeto entre os pontos especificados.");
        }

        scanner.close();
    }

    private static void adicionarArestas(List<Arestas<String>> arestas, List<Vertice<String>> vertices) {
        // Adiciona as arestas do grafo
        // Example:
        Arestas<String> aresta = new Arestas<>();
        aresta.setMetros(vertices.get(0), vertices.get(1));
        aresta.setMetros(300);
        arestas.add(aresta);

        // Add other edges accordingly
    }

    private static Arestas<String> buscarAresta(List<Arestas<String>> arestas, String pontoPartida, String pontoChegada) {
        for (Arestas<String> aresta : arestas) {
            if (aresta.getVertices().get(0).getValor().equals(pontoPartida) && aresta.getVertices().get(1).getValor().equals(pontoChegada)) {
                return aresta;
            }
        }
        return null;
    }
}