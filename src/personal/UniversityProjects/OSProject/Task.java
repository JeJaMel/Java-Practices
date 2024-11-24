package personal.UniversityProjects.OSProject;

public class Task {
    int ti; //Initial time
    int td; //Duration Time
    int tf; //Final Time
    int T; // Total Time
    int E; // Waiting Time
    double I; // Service Index

    Task(int ti, int td) {
        this.ti = ti;
        this.td = td;
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

    @Override
    public String toString() {
        return "Task{" +
                "ti=" + ti +
                ", td=" + td +
                ", tf=" + tf +
                ", tt=" + T +
                ", te=" + E +
                ", is=" + I +
                '}';
    }
}
