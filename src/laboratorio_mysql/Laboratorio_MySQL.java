package laboratorio_mysql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dirley Rocio Puentes
 */
public class Laboratorio_MySQL {

    public static void main(String[] args) {
        mySQL();
    }

    public static void mySQL() {
        try {
            //asegurarnos que el Driver se inicializa y se registra
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Cargado!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Establecemos la conexión con la base de datos.
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");
            System.out.println("Enlazado!");
            // Preparamos la consulta
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from persona");
            String all= "";
            // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
            System.out.println("Datos de la BDD:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3));
             //acumulador del JOP
                all += (rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + "\n");
            }
            //imprimimos todos los resultados en un JOP
            JOptionPane.showMessageDialog(null, "Datos: \n" + all);
            // Cerramos la conexion a la base de datos.
            conexion.close();
            System.out.println("Adios!");
            
        } catch (SQLException ex) {
            Logger.getLogger(Laboratorio_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
