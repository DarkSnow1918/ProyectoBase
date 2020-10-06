package Clases;

public class Planes {
    //Declaración de datos

    private String Normal;
    private String Fitness;
    private String Mamadisimo;

    public Planes(){
        Normal = "10000";
        Fitness = "15000";
        Mamadisimo = "20000";

    }

    public String getNormal() {
        return Normal;
    }

    public void setNormal(String normal) {
        Normal = normal;
    }

    public String getFitness() {
        return Fitness;
    }

    public void setFitness(String fitness) {
        Fitness = fitness;
    }

    public String getMamadisimo() {
        return Mamadisimo;
    }

    public void setMamadisimo(String mamadisimo) {
        Mamadisimo = mamadisimo;
    }
}
