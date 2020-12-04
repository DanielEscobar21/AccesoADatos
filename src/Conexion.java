
import com.mysql.jdbc.Connection;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;

public class Conexion extends JInternalFrame {

    String server;
    String BD;
    String user;
    String password;
    private Connection con = null;
    JPanel panel = new JPanel();
    JButton aceptar = new JButton("Aceptar");
    JLabel eArchivoRegistro = new JLabel("Servicio de Base de Datos: ");
    JLabel eServer = new JLabel("Servidor: ");
    JLabel eBaseDeDatos = new JLabel("Base de Datos: ");
    JLabel eUsuario = new JLabel("Usuario: ");
    JLabel eContrasena = new JLabel("Contraseña: ");
    JComboBox<String> Registro = new JComboBox();
    JLabel Servidor = new JLabel();
    JLabel BaseDeDatos = new JLabel();
    JLabel Usuario = new JLabel();
    JLabel Contrasena = new JLabel();
    File contenedor = new File("src/Log/");
    File[] registros = contenedor.listFiles();
    String id;

    public Conexion() {

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        eArchivoRegistro.setFont(new Font("Century Gothic", 1, 30));
        Registro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegistroActionPerformed(evt);
            }
        });
        panel.add(eArchivoRegistro);
        panel.add(Registro);

        eServer.setFont(new Font("Century Gothic", 1, 30));
        panel.add(eServer);
        panel.add(Servidor);

        eBaseDeDatos.setFont(new Font("Century Gothic", 1, 30));
        panel.add(eBaseDeDatos);
        panel.add(BaseDeDatos);

        eUsuario.setFont(new Font("Century Gothic", 1, 30));
        panel.add(eUsuario);
        panel.add(Usuario);

        eContrasena.setFont(new Font("Century Gothic", 1, 30));
        panel.add(eContrasena);
        panel.add(Contrasena);

        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar);
        this.setMaximizable(false);
        this.setClosable(true);
        this.setResizable(true);
        this.add(panel);
        this.pack();
        
        
        for (int i = 0; i < registros.length; i++) {
            Registro.addItem(registros[i].getName().replace(".txt",""));
        }
       
    }

    private void Mostrar() {
        try {
            FileInputStream fis = new FileInputStream("src/Log/" + id);
            Properties mostrar = new Properties();
            mostrar.load(fis);
            this.Servidor.setText(mostrar.getProperty("Server"));
            this.BaseDeDatos.setText(mostrar.getProperty("Name"));
            this.Usuario.setText(mostrar.getProperty("Username"));
            this.Contrasena.setText(mostrar.getProperty("Password"));
        } catch (Exception e) {
        }
    }

    private void RegistroActionPerformed(ActionEvent evt) {
        String copiar = (String) Registro.getSelectedItem();
        id = copiar;
        Mostrar();

    }


    private void AceptarActionPerformed(ActionEvent evt) {
        try {
            FileInputStream fis = new FileInputStream("src/Log/" + id);
            Properties mostrar = new Properties();
            mostrar.load(fis);
            this.server = mostrar.getProperty("Server");
            this.BD = mostrar.getProperty("Name");
            this.user = mostrar.getProperty("Username");
            this.password = mostrar.getProperty("Password");
        } catch (Exception e) {
        }
        this.dispose();
    }

    public Connection getConexion() throws ClassNotFoundException, SQLException {
        try {
            FileInputStream fis = new FileInputStream("src/Log/" + id);
            Properties mostrar = new Properties();
            mostrar.load(fis);
            this.server = mostrar.getProperty("Server");
            this.BD = mostrar.getProperty("Name");
            this.user = mostrar.getProperty("Username");
            this.password = mostrar.getProperty("Password");
            String url = "jdbc:mysql://" + server + "/" + BD;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                e.printStackTrace();
                con.close();
            }
        } catch (Exception e) {
        }
        return con;
    }
}
