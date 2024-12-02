package personal.UniversityProjects.OSProject;

//class to compare processes
public class AlgorithmTime {
    private final String name;
    private final double time;

    public AlgorithmTime(String name, double time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }
}
