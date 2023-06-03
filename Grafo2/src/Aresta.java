import java.util.ArrayList;
import java.util.List;

public class Aresta<S> {
    private List<Vertice<S>> vertices;
    private int metros;

    public Aresta() {
        this.vertices = new ArrayList<>();
    }

    public List<Vertice<S>> getVertices() {
        return vertices;
    }

    public void setVertices(Vertice<S> v1, Vertice<S> v2) {
        this.vertices.add(v1);
        this.vertices.add(v2);
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }
}