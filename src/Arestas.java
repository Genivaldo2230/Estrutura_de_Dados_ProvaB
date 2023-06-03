import java.util.ArrayList;
import java.util.List;

public class Arestas<S> {
        private List<Vertice<S>> vertices;
        private int metros;

        public Arestas() {
            this.vertices = new ArrayList<>();
        }

        public List<Vertice<S>> getVertices() {
            return vertices;
        }

    public void setVertices() {
            setVertices((Vertice<S>) null, null);
        }

    public void setVertices(Vertice<S> v1, Vertice<S> v2) {
            this.vertices.clear();
            this.vertices.add(v1);
            this.vertices.add(v2);
        }

        public int getMetros() {
            return metros;
        }

        public void setMetros(int metros) {
            this.metros = metros;
        }

    public void setMetros(Vertice<S> stringVertice, Vertice<S> stringVertice1) {
    }

    public void adicionaAresta(int i, S a, S b) {
    }

    public int obterDistancia(S pontoPartida, S pontoChegada) {

        return 0;
    }

    public List<S> setVertices(S pontoPartida, S pontoChegada) {
        return null;
    }

    public void adicionaVertice(S vertice) {
    }
}