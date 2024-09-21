public class Tablet extends Equipo {
    private double tamanoPantalla;
    private String tipoPantalla;
    private int capacidadMemoriaNAND;
    private String sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microprocesador, double tamanoPantalla, String tipoPantalla, int capacidadMemoriaNAND, String sistemaOperativo) {
        super(fabricante, modelo, microprocesador, 0);
        this.tamanoPantalla = tamanoPantalla;
        this.tipoPantalla = tipoPantalla;
        this.capacidadMemoriaNAND = capacidadMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String[] getInfo() {
        return new String[]{fabricante, modelo, microprocesador, tamanoPantalla + " pulgadas", tipoPantalla, capacidadMemoriaNAND + " GB", sistemaOperativo};
    }
}
