import java.util.List;
import java.util.Scanner;

public class AppGrafoGrafo {

    public static void main(String[] args) {
        Arestas<String> aresta = new Arestas<>();

        // Definição dos vértices do grafo
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "X", "Z"};

        // Adiciona os vértices ao grafo
        for (String vertice : vertices) {
            aresta.adicionaVertice(vertice);
        }

        // Adiciona as arestas do grafo
        adicionarArestas(aresta);

        // Solicita ao usuário o ponto de partida e o ponto de chegada
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o ponto de partida: ");
        String pontoPartida = scanner.nextLine();
        System.out.print("Informe o ponto de chegada: ");
        String pontoChegada = scanner.nextLine();

        // Obtém o trajeto ponto a ponto
        List<String> trajeto = aresta.setVertices(pontoPartida, pontoChegada);
        if (trajeto != null) {
            // Apresenta o trajeto e a distância
            System.out.println("Trajeto:");
            for (String ponto : trajeto) {
                System.out.print(ponto + " -> ");
            }
            System.out.println("Chegada");
            int distancia = aresta.obterDistancia(pontoPartida, pontoChegada);
            System.out.println("Distância total: " + distancia + " metros");
        } else {
            System.out.println("Não foi encontrado um trajeto entre os pontos especificados.");
        }

        scanner.close();
    }

    private static void adicionarArestas(Arestas<String> aresta) {
        // Adiciona as arestas do grafo
        aresta.adicionaAresta(300, "A", "B");
        aresta.adicionaAresta(47, "B", "C");
        aresta.adicionaAresta(62, "C", "D");
        aresta.adicionaAresta(8, "D", "E");
        aresta.adicionaAresta(13, "E", "F");
        aresta.adicionaAresta(13, "F", "E");
        aresta.adicionaAresta(230, "E", "G");
        aresta.adicionaAresta(230, "G", "E");
        aresta.adicionaAresta(8, "E", "D");
        aresta.adicionaAresta(62, "D", "C");
        aresta.adicionaAresta(141, "C", "H");
        aresta.adicionaAresta(138, "H", "I");
        aresta.adicionaAresta(153, "I", "J");
        aresta.adicionaAresta(512, "J", "K");
        aresta.adicionaAresta(135, "K", "L");
        aresta.adicionaAresta(30, "L", "M");
        aresta.adicionaAresta(30, "M", "L");
        aresta.adicionaAresta(187, "L", "N");
        aresta.adicionaAresta(108, "N", "O");
        aresta.adicionaAresta(82, "O", "P");
        aresta.adicionaAresta(215, "P", "Q");
        aresta.adicionaAresta(97, "Q", "R");
        aresta.adicionaAresta(33, "R", "S");
        aresta.adicionaAresta(243, "S", "T");
        aresta.adicionaAresta(207, "T", "U");
        aresta.adicionaAresta(370, "U", "V");
        aresta.adicionaAresta(210, "V", "U");
        aresta.adicionaAresta(107, "U", "X");
        aresta.adicionaAresta(317, "X", "A");
        aresta.adicionaAresta(370, "A", "V");
        aresta.adicionaAresta(38, "V", "S");
        aresta.adicionaAresta(33, "S", "R");
    }
}
