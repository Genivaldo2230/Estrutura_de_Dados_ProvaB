//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class AppGrafo {
//    public static void main(String[] args) {
//        Map<String, Vertice<String>> vertices = new HashMap<>();
//        List<Aresta<String>> arestas = new ArrayList<>();
//
//        // Definição dos vértices do grafo
//        String[] verticesArr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "X", "Z"};
//
//        // Adiciona os vértices ao grafo
//        for (String vertice : verticesArr) {
//            Vertice<String> v = new Vertice<>(vertice);
//            vertices.put(vertice, v);
//        }
//
//        // Adiciona as arestas do grafo
//        adicionarArestas(arestas, vertices);
//
//        // Solicita ao usuário o ponto de partida e o ponto de chegada
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Informe o ponto de partida: ");
//        String pontoPartida = scanner.nextLine();
//        System.out.print("Informe o ponto de chegada: ");
//        String pontoChegada = scanner.nextLine();
//
//        // Obtém o trajeto ponto a ponto
//        List<String> trajeto = obterTrajeto(arestas, vertices, pontoPartida, pontoChegada);
//        if (trajeto != null) {
//            // Apresenta o trajeto e a distância
//            System.out.println("Trajeto:");
//            for (String ponto : trajeto) {
//                System.out.print(ponto + " -> ");
//            }
//            System.out.println("Chegada");
//            int distancia = obterDistancia(vertices.get(pontoChegada));
//            System.out.println("Distância total: " + distancia + " metros");
//        } else {
//            System.out.println("Não foi encontrado um trajeto entre os pontos especificados.");
//        }
//
//        scanner.close();
//    }
//
//    private static void adicionarArestas(List<Aresta<String>> arestas, Map<String, Vertice<String>> vertices) {
//        // Adiciona as arestas do grafo
//        // Example:
//        Aresta<String> aresta = new Aresta<>();
//        aresta.setVertices(vertices.get("A"), vertices.get("B"));
//        aresta.setMetros(300);
//        arestas.add(aresta);
//
//        // Add other edges accordingly
//    }
//
//    private static List<String> obterTrajeto(List<Aresta<String>> arestas, Map<String, Vertice<String>> vertices, String pontoPartida, String pontoChegada) {
//        Map<Vertice<String>, Integer> distancias = new HashMap<>();
//        Map<Vertice<String>, Vertice<String>> antecessores = new HashMap<>();
//        Queue<Vertice<String>> filaPrioridade = new PriorityQueue<>((v1, v2) -> distancias.get(v1) - distancias.get(v2));
//
//        for (Vertice<String> vertice : vertices.values()) {
//            if (vertice.get
