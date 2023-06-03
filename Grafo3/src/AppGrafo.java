import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppGrafo {
    public static void main(String[] args) {
                Grafo<String> grafo = new Grafo<>();

        // Definição dos vértices do grafo
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "X", "Z"};

        // Adiciona os vértices ao grafo
        for (String vertice : vertices) {
            grafo.adicionaVertice(vertice);
        }

        // Adiciona as arestas do grafo
        adicionarArestas(grafo);

        // Solicita ao usuário o ponto de partida e o ponto de chegada
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o ponto de partida: ");
        String pontoPartida = scanner.nextLine();
        System.out.print("Informe o ponto de chegada: ");
        String pontoChegada = scanner.nextLine();

        // Obtém o trajeto ponto a ponto
        List<String> trajeto = grafo.obterTrajeto(pontoPartida, pontoChegada);
        if (trajeto != null) {
            // Apresenta o trajeto e a distância
            System.out.println("Trajeto:");
            for (String ponto : trajeto) {
                System.out.print(ponto + " -> ");
            }
            System.out.println("Chegada");
            int distancia = grafo.obterDistancia(pontoPartida, pontoChegada);
            System.out.println("Distância total: " + distancia + " metros");
        } else {
            System.out.println("Não foi encontrado um trajeto entre os pontos especificados.");
        }

        scanner.close();
    }

    private static void adicionarArestas(Grafo<String> grafo) {
        // Adiciona as arestas do grafo
        grafo.adicionaAresta(300, "A", "B");
        grafo.adicionaAresta(47, "B", "C");
        grafo.adicionaAresta(62, "C", "D");
        grafo.adicionaAresta(8, "D", "E");
        grafo.adicionaAresta(13, "E", "F");
        grafo.adicionaAresta(13, "F", "E");
        grafo.adicionaAresta(230, "E", "G");
        grafo.adicionaAresta(230, "G", "E");
        grafo.adicionaAresta(8, "E", "D");
        grafo.adicionaAresta(62, "D", "C");
        grafo.adicionaAresta(141, "C", "H");
        grafo.adicionaAresta(138, "H", "I");
        grafo.adicionaAresta(153, "I", "J");
        grafo.adicionaAresta(512, "J", "K");
        grafo.adicionaAresta(135, "K", "L");
        grafo.adicionaAresta(30, "L", "M");
        grafo.adicionaAresta(30, "M", "L");
        grafo.adicionaAresta(187, "L", "N");
        grafo.adicionaAresta(108, "N", "O");
        grafo.adicionaAresta(82, "O", "P");
        grafo.adicionaAresta(215, "P", "Q");
        grafo.adicionaAresta(97, "Q", "R");
        grafo.adicionaAresta(33, "R", "S");
        grafo.adicionaAresta(243, "S", "T");
        grafo.adicionaAresta(207, "T", "U");
        grafo.adicionaAresta(370, "U", "V");
        grafo.adicionaAresta(210, "V", "U");
        grafo.adicionaAresta(107, "U", "X");
        grafo.adicionaAresta(317, "X", "A");
        grafo.adicionaAresta(370, "A", "V");
        grafo.adicionaAresta(38, "V", "S");
        grafo.adicionaAresta(33, "S", "R");
    }

    private static class Vertice<S> {
        private S nome;

        public Vertice(S nome) {
            this.nome = nome;
        }

        public S getNome() {
            return nome;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Vertice<?> vertice = (Vertice<?>) obj;
            return nome.equals(vertice.nome);
        }

        @Override
        public int hashCode() {
            return nome.hashCode();
        }

        @Override
        public String toString() {
            return nome.toString();
        }
    }




    public static class Aresta<S> {
        private List<Vertice<S>> vertices;
        private Vertice<S> verticePartida;
        private Vertice<S> verticeChegada;
        private int metros;

        public Aresta(List<Vertice<S>> vertices, Vertice<S> verticePartida, Vertice<S> verticeChegada, int metros) {
            this.vertices = vertices;
            this.verticePartida = verticePartida;
            this.verticeChegada = verticeChegada;
            this.metros = metros;

            // Update the verticePartida reference in the vertices list
            for (Vertice<S> vertice : vertices) {
                if (vertice.equals(verticePartida)) {
                    this.verticePartida = vertice;
                    break;
                }
            }
        }

        public <S> Aresta(int metros, Vertice<S> verticePartida, Vertice<S> verticeChegada) {
        }

        public List<Vertice<S>> getVertices() {
            return vertices;
        }

        public Vertice<S> getVerticePartida() {
            return verticePartida;
        }

        public Vertice<S> getVerticeChegada() {
            return verticeChegada;
        }

        public int getMetros() {
            return metros;
        }
    }

    private static class Grafo<S> {
        private List<Vertice<S>> vertices;
        private List<Aresta<S>> arestas;

        public Grafo() {
            this.vertices = new ArrayList<>();
            this.arestas = new ArrayList<>();
        }

        public void adicionaVertice(S nome) {
            Vertice<S> vertice = new Vertice<>(nome);
            vertices.add(vertice);
        }

        public void adicionaAresta(int metros, S nomePartida, S nomeChegada) {
            Vertice<S> verticePartida = buscarVertice(nomePartida);
            Vertice<S> verticeChegada = buscarVertice(nomeChegada);
            Aresta<S> aresta = new Aresta<>(metros, verticePartida, verticeChegada);
            arestas.add(aresta);
        }

        public List<String> obterTrajeto(S nomePartida, S nomeChegada) {
            Vertice<S> verticePartida = buscarVertice(nomePartida);
            Vertice<S> verticeChegada = buscarVertice(nomeChegada);
            List<String> trajeto = new ArrayList<>();
            if (verticePartida != null && verticeChegada != null) {
                boolean[] visitado = new boolean[vertices.size()];
                List<Vertice<S>> caminhoAtual = new ArrayList<>();
                caminhoAtual.add(verticePartida);
                encontrarTrajeto(verticePartida, verticeChegada, visitado, caminhoAtual, trajeto);
            }
            return trajeto;
        }

        private void encontrarTrajeto(Vertice<S> verticeAtual, Vertice<S> verticeChegada, boolean[] visitado,
                                      List<Vertice<S>> caminhoAtual, List<String> trajeto) {
            visitado[vertices.indexOf(verticeAtual)] = true;

            if (verticeAtual.equals(verticeChegada)) {
                for (Vertice<S> vertice : caminhoAtual) {
                    trajeto.add(vertice.getNome().toString());
                }
                return;
            }

            for (Aresta<S> aresta : arestas) {
                if (aresta.getVerticePartida().equals(verticeAtual) && !visitado[vertices.indexOf(aresta.getVerticeChegada())]) {
                    caminhoAtual.add(aresta.getVerticeChegada());
                    encontrarTrajeto(aresta.getVerticeChegada(), verticeChegada, visitado, caminhoAtual, trajeto);
                    caminhoAtual.remove(aresta.getVerticeChegada());
                }
            }

            visitado[vertices.indexOf(verticeAtual)] = false;
        }

        public int obterDistancia(S nomePartida, S nomeChegada) {
            Vertice<S> verticePartida = buscarVertice(nomePartida);
            Vertice<S> verticeChegada = buscarVertice(nomeChegada);
            Aresta<S> aresta = (Aresta<S>) buscarAresta(verticePartida, verticeChegada);
            if (aresta != null) {
                return aresta.getMetros();
            }
            return 0;
        }

        private Object buscarAresta(Vertice<S> verticePartida, Vertice<S> verticeChegada) {

            return null;
        }

        private Vertice<S> buscarVertice(S nome) {
            for (Vertice<S> vertice : vertices) {
                if (vertice.getNome().equals(nome)) {
                    return vertice;
                }
            }
            return null;
        }

        private static Aresta<String> buscarAresta(List<Aresta<String>> arestas, Vertice<String> verticePartida, Vertice<String> verticeChegada) {
            for (Aresta<String> aresta : arestas) {
                if (aresta.getVerticePartida() != null && aresta.getVerticePartida().equals(verticePartida)
                        && aresta.getVerticeChegada() != null && aresta.getVerticeChegada().equals(verticeChegada)) {
                    return aresta;
                }
            }
            return null;
        }

    }
}
