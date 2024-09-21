public abstract class Equipo {
    protected String fabricante;
    protected String modelo;
    protected String microprocesador;
    protected int memoria;

    public Equipo(String fabricante, String modelo, String microprocesador, int memoria) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.memoria = memoria;
    }

    public abstract String[] getInfo();  // Método abstracto para devolver la información en un formato de array
}
