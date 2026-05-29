package Modelos;

public class CarroSedan extends Vehiculo {
    public String TipoCombustible;
    public String Transmision;

    public CarroSedan() {

    }

    public CarroSedan(String placa, String marca, int modelo, float precioDiario, String tipoCombustible,
            String transmision) {
        super(placa, marca, modelo, precioDiario);
        this.TipoCombustible = tipoCombustible;
        this.Transmision = transmision;
    }

    public String getTipoCombustible() {
        return TipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        TipoCombustible = tipoCombustible;
    }

    public String getTransmision() {
        return Transmision;
    }

    public void setTransmision(String transmision) {
        Transmision = transmision;
    }
}