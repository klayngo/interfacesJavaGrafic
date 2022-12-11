package Ventana;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

public class WindowMain extends JFrame {

    public JPanel panel1;
    private JButton calcularNotaButton;
    private JButton imprimir;
    private JTextField nombre;
    private JTextField nota1;
    private JTextField nota2;
    private JTextField nota3;
    private JLabel result;
    private JLabel result1;
    private JLabel result2;
    private JLabel result3;
    private JLabel result4;
    private JLabel result5;
    private JLabel result6;
    private JList list1;

    HashMap<String,Double> notasEstudent = new HashMap<String,Double>();
    double n1,n2,n3;
    int cantGanan=0, cantpierden=0, cantRecupera=0, cantPierden=0 ,cantEstudiantesValidados=0;
    public void  calcularAprendiz(){

        String nombre;


        nombre = this.nombre.getText();
        n1 = Double.parseDouble(this.nota1.getText());
        n2 = Double.parseDouble(this.nota2.getText());
        n3 = Double.parseDouble(this.nota3.getText());


        double promedio = (n1+n2+n3)/3;
        notasEstudent.put(nombre,promedio);
        cantEstudiantesValidados++;
        if (promedio>=3.5) {
            result.setText("El estudiante " + nombre + " gana la materia con un promedio de " + promedio);

            cantGanan++;
        }else{
            result.setText("El estudiante " + nombre + " pierde la materia con un promedio de " + promedio);
            cantpierden++;
        }
        if (promedio > 2.0 && promedio < 3.5) {
            cantRecupera++;
        }else if (promedio < 2.0) {
            cantPierden++;
        }



    }

    public WindowMain() {
        calcularNotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularAprendiz();
            }
        });

        imprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double promedioTotal = 0;
                for (String key : notasEstudent.keySet()) {
                    promedioTotal += notasEstudent.get(key);
                }

                result.setText("El promedio de las notas finales obtenidas es : "+promedioTotal/notasEstudent.size());
                Iterator<String> it = notasEstudent.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();

                    System.out.println("Nombre: " + key + " Nota: " + notasEstudent.get(key));

                    result1.setText("Nombre: " + key + " Nota: " + notasEstudent.get(key));


                    result2.setText("Cantidad de estudiantes que ganan: " + notasEstudent.size());
                    result3.setText("Cantidad de estudiantes que pierden: " + cantpierden);
                    result4.setText("Cantidad de estudiantes que recuperan: " + cantRecupera);
                    result5.setText("Cantidad de estudiantes registrados: " + cantEstudiantesValidados);
                    // notas ingrsesadas
                    result6.setText("Notas ingrsesadas: " + cantEstudiantesValidados*3);



                }


            }
        });

    }


}