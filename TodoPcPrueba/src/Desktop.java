public class Desktop extends Equipo {
    private String tarjetaGrafica;
    private int capacidadDiscoDuro;

    public Desktop(String fabricante, String modelo, String microprocesador, int memoria, String tarjetaGrafica, int capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tarjetaGrafica = tarjetaGrafica;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public String[] getInfo() {
        return new String[]{fabricante, modelo, microprocesador, memoria + " GB", tarjetaGrafica, capacidadDiscoDuro + " GB"};
    }
}
