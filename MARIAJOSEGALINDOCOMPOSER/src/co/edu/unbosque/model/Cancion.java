package co.edu.unbosque.model;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.view.Interfaz;

public class Cancion {
    private String titulo;
    private EjercicioEstrofa[] estrofas;

    public Cancion() {
        this.titulo = "";
        this.estrofas = new EjercicioEstrofa[0];
    }

    public Cancion(String titulo, EjercicioEstrofa[] estrofas) {
        this.titulo = titulo;
        this.estrofas = estrofas;
    }

    public void agregarEstrofa(EjercicioEstrofa estrofa) {
        EjercicioEstrofa[] nuevoArreglo = new EjercicioEstrofa[estrofas.length + 1];
        System.arraycopy(estrofas, 0, nuevoArreglo, 0, estrofas.length);
        nuevoArreglo[estrofas.length] = estrofa;
        estrofas = nuevoArreglo;
    }

    public String generarCancion() {
        StringBuilder sb = new StringBuilder();
        for (EjercicioEstrofa estrofa : estrofas) {
            sb.append(estrofa.generarEstrofa()).append("\n");
        }
        return sb.toString();
    }

    public void generarCancionAleatoria(int numeroEstrofas, int numeroFrasesPorEstrofa) {
        for (int i = 0; i < numeroEstrofas; i++) {
            EjercicioEstrofa estrofa = new EjercicioEstrofa();
            for (int j = 0; j < numeroFrasesPorEstrofa; j++) {
                EjercicioFrase frase = generarFraseAleatoria();
                estrofa.agregarFrase(frase);
            }
            agregarEstrofa(estrofa);
        }
    }

    private EjercicioFrase generarFraseAleatoria() {
        String[] palabras1 = { " mami", " bebe", " plincess", " bandida" };
        String[] palabras2 = { " yo puedo", " yo quielo", " yo vengo a", " mami voy a" };
        String[] palabras3 = { " encendelte", " amalte", " ligal", " jugal" };
        String[] palabras4 = { " suave", " lento", " lápido", " fuelte" };
        String[] palabras5 = { " hasta que salga el sol", " toda la noche", " hasta el amanecel", " todo el día" };
        String[] palabras6 = { " sin anestesia", " sin complomiso", " feis to feis", " sin miedo" };

        Random random = new Random();
        String palabra1 = palabras1[random.nextInt(palabras1.length)];
        String palabra2 = palabras2[random.nextInt(palabras2.length)];
        String palabra3 = palabras3[random.nextInt(palabras3.length)];
        String palabra4 = palabras4[random.nextInt(palabras4.length)];
        String palabra5 = palabras5[random.nextInt(palabras5.length)];
        String palabra6 = palabras6[random.nextInt(palabras6.length)];

        String fraseCompleta = palabra1 + "\t" + palabra2 + "\t" + palabra3 + "\t" + palabra4 + "\t" + palabra5 + "\t"
                + palabra6;
        return new EjercicioFrase(fraseCompleta);
    }

    public void pedirEstrofas(Interfaz in, Propiedades pro) {
        int numeroEstrofas = 0;
        int numeroFrasesPorEstrofa = 0;

        while (numeroEstrofas <= 0) {
            try {
                numeroEstrofas = in.pedirEstrofa();
            } catch (NumberFormatException e) {
                in.mostrarMensaje("El valor introducido para el número de estrofas no es válido.");
            }
        }

        while (numeroFrasesPorEstrofa <= 0) {
            try {
                numeroFrasesPorEstrofa = Integer.parseInt(in.pedirFrase());
            } catch (NumberFormatException e) {
                in.mostrarMensaje("El valor introducido para el número de frases por estrofa no es válido.");
            }
        }

        pro.guardarParametros(numeroEstrofas, numeroFrasesPorEstrofa);
    }

    public void crearCancion(Interfaz in, Propiedades pro) {
        int numeroEstrofas = pro.leerNumeroEstrofas();
        int numeroFrasesPorEstrofa = pro.leerNumeroFrasesPorEstrofa();

        generarCancionAleatoria(numeroEstrofas, numeroFrasesPorEstrofa);

        String textoCancion = generarCancion();
        in.mostrarMensaje(textoCancion);

        boolean opcion = in.mostrarConfirmacion("¿Desea guardar la canción?");
        if (opcion) {
            guardarCancionEnArchivo(textoCancion, in);
        }
    }

    public void guardarCancionEnArchivo(String textoCancion, Interfaz in) {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String nombreArchivo = archivo.getName();

            if (!nombreArchivo.endsWith(".txt")) {
                archivo = new File(archivo.getParent(), nombreArchivo + ".txt");
            }

            try (PrintWriter salida = new PrintWriter(new FileOutputStream(archivo))) {
                salida.println(textoCancion);
                in.mostrarMensaje("Canción guardada con éxito!");
            } catch (IOException ex) {
                ex.printStackTrace();
                in.mostrarMensaje("Error al guardar la canción.");
            }
        }
    }

    public void seleccionarCancion(Interfaz in, Propiedades pro) {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            Cancion cancion = pro.leerCancionDelArchivo(archivo);
            in.mostrarMensaje(cancion.toString());
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public EjercicioEstrofa[] getEstrofas() {
        return estrofas;
    }

    public void setEstrofas(EjercicioEstrofa[] estrofas) {
        this.estrofas = estrofas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Estrofas:\n");
        for (EjercicioEstrofa estrofa : estrofas) {
            sb.append(estrofa).append("\n");
        }
        return sb.toString();
    }
}
