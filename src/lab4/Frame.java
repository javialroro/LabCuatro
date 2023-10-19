package lab4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    JFrame frame;
    JPanel panel;

    JPanel botones = new JPanel();

    JFrame frameOrden;

    JPanel panelI = new JPanel();

    JButton insertAutor = new JButton("Insertar Autor");
    JButton GetAutores = new JButton("Get Autores");

    JTextField idAutor = new JTextField("idAutor");
    JTextField nombre = new JTextField("nombre");
    JTextField idPais = new JTextField("idPais");
    JTextField vivo = new JTextField("vivo");
    JTextField fechaNacimiento = new JTextField("fechaNacimiento");
    JTextField primeraPublicacion = new JTextField("primeraPublicacion");
    JTextField publicaciones = new JTextField("publicaciones");
    JTextField calificacion = new JTextField("calificacion");
    JTextArea txaResult = new JTextArea();

    public Frame() {
        txaResult.setColumns(20);
        txaResult.setRows(5);
        frame = new JFrame();
        frame.setTitle("Autores");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        panel= new JPanel();
        panel.add(insertAutor);
        
        insertAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strResult = AutoresAccess.insertAutor(idAutor.getText(), nombre.getText(), idPais.getText(), 
                vivo.getText(), fechaNacimiento.getText(), primeraPublicacion.getText(), publicaciones.getText(), calificacion.getText());
            txaResult.setText(strResult);
            }
        });
        panel.add(GetAutores);
        GetAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strResult = AutoresAccess.getAutores();
                txaResult.setText(strResult);
            }
        });
        panel.setLayout(new GridLayout(1, 5));
        frame.add(panel, BorderLayout.SOUTH);
        
        panelI.add(idAutor);
        panelI.add(nombre);  
        panelI.add(idPais);
        panelI.add(vivo);
        panelI.add(fechaNacimiento);
        panelI.add(primeraPublicacion);
        panelI.add(publicaciones);
        panelI.add(calificacion);
        panelI.setLayout(new GridLayout(1, 8));
        frame.add(panelI, BorderLayout.NORTH);
        frame.add(txaResult, BorderLayout.CENTER);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Frame();
    }

    //hola
}


