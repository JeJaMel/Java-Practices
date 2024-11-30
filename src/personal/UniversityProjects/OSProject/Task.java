package personal.UniversityProjects.OSProject;

public class Task {
    private int id; // Identificador único
    private int ti; // Tiempo inicial
    private int td; // Tiempo de duración restante
    public int originalTd; // Duración original
    private int tf; // Tiempo final
    private int T; // Tiempo de respuesta
    private int E; // Tiempo de espera
    private double I; // Índice de productividad

    Task(int id, int ti, int td) {
        this.id = id + 1;
        this.ti = ti;
        this.td = td;
        this.originalTd = td;
    }

    public void setTd(int td) {
        this.td = td;
    }

    public void setTf(int tf) {
        this.tf = tf;
    }

    public void setT(int t) {
        T = t;
    }

    public void setE(int e) {
        E = e;
    }

    public void setI(double i) {
        I = i;
    }

    public int getTi() {
        return ti;
    }

    public int getTd() {
        return td;
    }

    public int getTf() {
        return tf;
    }

    public int getT() {
        return T;
    }

    public int getE() {
        return E;
    }

    public double getI() {
        return I;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-4d | %-4d | %-4d | %-4d | %-4d | %-6.2f |",
                id, ti, originalTd, tf, T, E, I);
    }



}
