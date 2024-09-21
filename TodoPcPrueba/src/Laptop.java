public class Laptop extends Equipo {
    private double tamanoPantalla;
    private int capacidadDiscoDuro;

    public Laptop(String fabricante, String modelo, String microprocesador, int memoria, double tamanoPantalla, int capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tamanoPantalla = tamanoPantalla;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public String[] getInfo() {
        return new String[]{fabricante, modelo, microprocesador, memoria + " GB", tamanoPantalla + " pulgadas", capacidadDiscoDuro + " GB"};
    }
}
