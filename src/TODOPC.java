import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.util.ArrayList;

public class TODOPC {

    static ArrayList<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            String[] opciones = {"Registrar equipo", "Ver equipos", "Salir"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "TODOPC",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:  
                    registrarEquipo();
                    break;
                case 1:  
                    verEquipos();
                    break;
                case 2:  
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema TODOPC.");
                    break;
                default:
                    break;
            }
        } while (opcion != 2);
    }
    
 // Método para obtener una cadena no vacía
    public static String obtenerEntradaNoVacia(String mensaje) {
        String entrada;
        do {
            entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null || entrada.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este campo no puede quedar vacío. Por favor, ingrese un valor.");
            }
        } while (entrada == null || entrada.trim().isEmpty());
        return entrada.trim();
    }

    // Método para obtener un número entero que sea valido válido
    public static int obtenerNumeroValido(String mensaje) {
        int numero = -1;
        boolean valido = false;
        do {
            try {
                String entrada = JOptionPane.showInputDialog(mensaje);
                numero = Integer.parseInt(entrada);
                if (numero > 0) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número mayor que 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese un número.");
            }
        } while (!valido);
        return numero;
    }

    // Método para obtener un número decimal que sea válido (double)
    public static double obtenerDoubleValido(String mensaje) {
        double numero = -1;
        boolean valido = false;
        do {
            try {
                String entrada = JOptionPane.showInputDialog(mensaje);
                numero = Double.parseDouble(entrada);
                if (numero > 0) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número mayor que 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese un número decimal.");
            }
        } while (!valido);
        return numero;
    }


    public static void registrarEquipo() {
        String[] tiposEquipo = {"Desktop", "Laptop", "Tablet"};
        int tipoEquipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de equipo", "Registrar Equipo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tiposEquipo, tiposEquipo[0]);

        String fabricante = obtenerEntradaNoVacia("Ingrese el fabricante:");
        String modelo = obtenerEntradaNoVacia("Ingrese el modelo:");
        String microprocesador = obtenerEntradaNoVacia("Ingrese el microprocesador:");
        int memoria = obtenerNumeroValido("Ingrese la memoria RAM(GB):");

        switch (tipoEquipo) {
            case 0:  // Desktop
                String tarjetaGrafica = obtenerEntradaNoVacia("Ingrese la tarjeta gráfica:");
                int capacidadDiscoDuro = obtenerNumeroValido("Ingrese la capacidad del disco duro (GB):");
                int tamanoDeTorre = obtenerNumeroValido("Ingrese el tamaño de la torre (pulgadas):");
                equipos.add(new Desktop(fabricante, modelo, microprocesador, memoria, tarjetaGrafica, capacidadDiscoDuro, tamanoDeTorre));
                JOptionPane.showMessageDialog(null, "Desktop registrado exitosamente.");
                break;
            case 1:  // Laptop
                double tamanoPantalla = obtenerDoubleValido("Ingrese el tamaño de la pantalla (pulgadas):");
                capacidadDiscoDuro = obtenerNumeroValido("Ingrese la capacidad del disco duro (GB):");
                equipos.add(new Laptop(fabricante, modelo, microprocesador, memoria, tamanoPantalla, capacidadDiscoDuro));
                JOptionPane.showMessageDialog(null, "Laptop registrada exitosamente.");
                break;
            case 2:  // Tablet
                tamanoPantalla = obtenerDoubleValido("Ingrese el tamaño de la pantalla (pulgadas):");
                String tipoPantalla = obtenerEntradaNoVacia("¿Pantalla capacitiva o resistiva?");
                int capacidadMemoriaNAND = obtenerNumeroValido("Ingrese la capacidad de memoria NAND (GB):");
                String sistemaOperativo = obtenerEntradaNoVacia("Ingrese el sistema operativo:");
                equipos.add(new Tablet(fabricante, modelo, microprocesador, tamanoPantalla, tipoPantalla, capacidadMemoriaNAND, sistemaOperativo));
                JOptionPane.showMessageDialog(null, "Tablet registrada exitosamente.");
                break;
        }
    }
    
    

    
    public static void verEquipos() {
        String[] opcionesVer = {"Desktop", "Laptop", "Tablet"};
        int tipoVer = JOptionPane.showOptionDialog(null, "Seleccione el tipo de equipo que desea ver", "Ver Equipos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesVer, opcionesVer[0]);

        StringBuilder salida = new StringBuilder();
        switch (tipoVer) {
            case 0:  // Ver Desktops
                salida.append("Equipos tipo Desktop:\n\n");
                for (Equipo equipo : equipos) {
                    if (equipo instanceof Desktop) {
                        String[] info = equipo.getInfo();
                        salida.append("Fabricante: ").append(info[0]).append("\n")
                                .append("Modelo: ").append(info[1]).append("\n")
                                .append("Microprocesador: ").append(info[2]).append("\n")
                                .append("Memoria RAM: ").append(info[3]).append("\n")
                                .append("Tarjeta gráfica: ").append(info[4]).append("\n")
                                .append("Capacidad de disco duro: ").append(info[5]).append("\n")
                                .append("Tamaño de la torre: ").append(info[6]).append("\n\n");
                    }
                }
                break;
            case 1:  // Ver Laptops
                salida.append("Equipos tipo Laptop:\n\n");
                for (Equipo equipo : equipos) {
                    if (equipo instanceof Laptop) {
                        String[] info = equipo.getInfo();
                        salida.append("Fabricante: ").append(info[0]).append("\n")
                                .append("Modelo: ").append(info[1]).append("\n")
                                .append("Microprocesador: ").append(info[2]).append("\n")
                                .append("Memoria RAM: ").append(info[3]).append("\n")
                                .append("Tamaño de pantalla: ").append(info[4]).append("\n")
                                .append("Capacidad de disco duro: ").append(info[5]).append("\n\n");
                    }
                }
                break;
            case 2:  // Ver Tablets
                salida.append("Equipos tipo Tablet:\n\n");
                for (Equipo equipo : equipos) {
                    if (equipo instanceof Tablet) {
                        String[] info = equipo.getInfo();
                        salida.append("Fabricante: ").append(info[0]).append("\n")
                                .append("Modelo: ").append(info[1]).append("\n")
                                .append("Microprocesador: ").append(info[2]).append("\n")
                                .append("Tamaño de pantalla: ").append(info[3]).append("\n")
                                .append("Tipo de pantalla: ").append(info[4]).append("\n")
                                .append("Capacidad de memoria NAND: ").append(info[5]).append("\n")
                                .append("Sistema operativo: ").append(info[6]).append("\n\n");
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                return;
        }

        // Mostrar los equipos seleccionados
        if (salida.length() > 0) {
            JOptionPane.showMessageDialog(null, salida.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay equipos registrados de este tipo.");
        }
    }

}
