package Ej1.Entities;

public class Persona {
    private String nombre;
    private String sexo;
    private int edad;
    private double altura;
    private double peso;

    //Empty constructor.
    public Persona() {

    }

    //Constructor.
    public Persona(String nombre, String sexo, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    //Getters & Setters.
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

}
