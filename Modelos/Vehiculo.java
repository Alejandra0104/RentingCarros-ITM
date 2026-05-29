package Modelos;

public class Vehiculo {

    private String Placa;
    private String Marca;
    private int Modelo;
    private float PrecioDiario;
    private String Estado;

    public Vehiculo() {

    }

    public Vehiculo(String placa, String marca, int modelo, float precioDiario) {
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        PrecioDiario = precioDiario;
        Estado = "Disponible";
    }

    public String getPlaca() {
        return Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        Modelo = modelo;
    }

    public float getPrecioDiario() {
        return PrecioDiario;
    }

    public void setPrecioDiario(float precioDiario) {
        PrecioDiario = precioDiario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Marca: " + Marca + "\n" +
                "Modelo: " + Modelo + "\n" +
                "Precio Diario: " + PrecioDiario + "\n" +
                "Estado: " + Estado;
    }
}
