public class Desktop extends Equipo {
    private String tarjetaGrafica;
    private int capacidadDiscoDuro;
	private int tamanoDeTorre;

    public Desktop(String fabricante, String modelo, String microprocesador, int memoria, String tarjetaGrafica, int capacidadDiscoDuro, int tamanoDeTorre) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoDeTorre = tamanoDeTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public String[] getInfo() {
        return new String[]{fabricante, modelo, microprocesador, memoria + " GB", tarjetaGrafica, capacidadDiscoDuro + " GB", tamanoDeTorre + " Pulgadas"};
    }
}
