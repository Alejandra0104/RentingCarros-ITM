package Modelos;

public class CamionetaSUV {
    public String Traccion;
    public float CapacidadMaletero;

    public CamionetaSUV() {

    }

    public CamionetaSUV(String placa, String marca, int modelo, float precioDiario, String estado, String traccion, float capacidadMaletero) {
        super(placa, marca, modelo, precioDiario, estado);
        this.Traccion = traccion;
        this.CapacidadMaletero = capacidadMaletero;
    }

    public String getTraccion() {
        return Traccion;
    }

    public void setTraccion(String traccion) {
        Traccion = traccion;
    }

    public float getCapacidadMaletero() {
        return CapacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
    }

    @Override
    public String tipo() {
        return "CamionetaSUV";
    }
}