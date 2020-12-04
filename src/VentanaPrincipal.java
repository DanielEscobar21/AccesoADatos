
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JMenu Acciones;
    private JMenuItem Agregar;
    private JMenuItem Eliminar;
    private JMenu Opciones;
    private JMenuItem Conexion;
    private JMenuBar Menu;
    private JMenuItem Modificar;
    public JDesktopPane Panel;
    private JMenuItem Salir;
    private JMenuItem Ver;
    private JMenuItem Buscar;
    AgregarVentana AccAgregar = null;
    BuscarVisita BuscarVisita = null;
    VerVisitas VerVis = null;
    ModificarVisita Mod = null;
    EliminarVisita Eli = null;
    Conexion Conect = null;

    public VentanaPrincipal() {
        super("Visitantes");
        GridBagConstraints gridBagConstraints;

        Panel = new JDesktopPane();
        Menu = new JMenuBar();
        Acciones = new JMenu();
        Agregar = new JMenuItem();
        Modificar = new JMenuItem();
        Eliminar = new JMenuItem();
        Ver = new JMenuItem();
        Buscar = new JMenuItem();
        Opciones = new JMenu();
        Conexion = new JMenuItem();
        Salir = new JMenuItem();

        getContentPane().setLayout(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
        Panel.setLayout(new GridLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1000;
        gridBagConstraints.ipady = 650;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(Panel, gridBagConstraints);

        Acciones.setText("Acciones");

        Agregar.setText("Agregar");
        Agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    AgregarActionPerformed(evt);
                } catch (ClassNotFoundException ex) {}
            }
        });
        Acciones.add(Agregar);

        Modificar.setText("Modificar");
        Modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    ModificarActionPerformed(evt);
                } catch (ClassNotFoundException ex) {}
            }
        });
        Acciones.add(Modificar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    EliminarActionPerformed(evt);
                } catch (ClassNotFoundException ex) {}
            }
        });
        Acciones.add(Eliminar);

        Buscar.setText("Buscar Visita");
        Buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    BuscarVisitaAcionPerformed(evt);
                } catch (ClassNotFoundException ex) {}
            }
        });
        Acciones.add(Buscar);

        Ver.setText("Ver Visitas");
        Ver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    VerVisitasActionPerformed(evt);
                } catch (ClassNotFoundException ex) {}
            }   
        });
        Acciones.add(Ver);

        Opciones.setText("Opciones");

        Conexion.setText("Base de Datos");
        Conexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ConexionActionPerformed(evt);
            }
        });
        Opciones.add(Conexion);

        Salir.setMnemonic('a');
        Salir.setText("Salir");
        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                close();
            }
        });
        Opciones.add(Salir);
        
        
        Menu.add(Acciones);
        Menu.add(Opciones);
        setJMenuBar(Menu);
        pack();

    }

    private void AgregarActionPerformed(ActionEvent evt) throws ClassNotFoundException {
        if (AccAgregar == null || AccAgregar.isClosed()) {
            AccAgregar = new AgregarVentana();
            this.Panel.add(AccAgregar);
        }

        AccAgregar.setVisible(true);
    }

    private void BuscarVisitaAcionPerformed(ActionEvent evt) throws ClassNotFoundException {
        if (BuscarVisita == null || BuscarVisita.isClosed()) {
            BuscarVisita = new BuscarVisita();
            this.Panel.add(BuscarVisita);

        }
        BuscarVisita.setVisible(true);

    }

    private void VerVisitasActionPerformed(ActionEvent evt) throws ClassNotFoundException {
        if (VerVis == null || VerVis.isClosed()) {
            VerVis = new VerVisitas();
            this.Panel.add(VerVis);

        }
        VerVis.setVisible(true);

    }

    private void ModificarActionPerformed(ActionEvent evt) throws ClassNotFoundException {
        if (Mod == null || Mod.isClosed()) {
            Mod = new ModificarVisita();
            this.Panel.add(Mod);
        }
        Mod.setVisible(true);
    }

    private void EliminarActionPerformed(ActionEvent evt) throws ClassNotFoundException {
        if (Eli == null || Eli.isClosed()) {
            Eli = new EliminarVisita();
            this.Panel.add(Eli);
        }
        Eli.setVisible(true);

    }

    private void ConexionActionPerformed(ActionEvent evt) {
        if (Conect == null || Conect.isClosed()) {
            Conect = new Conexion();
            this.Panel.add(Conect);
        }
        Conect.setVisible(true);
    }

    private void close() {
        if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro que desea salir?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
