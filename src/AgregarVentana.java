import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;

public class AgregarVentana extends JInternalFrame {

    private JTextField ApMa1;
    private JTextField ApPa;
    private JButton Guardar;
    private JTextField Motivo;
    private JTextField Nombre1;
    private JPanel Panel;
    private JTable Tabla;
    private JTextField TipoDoc;
    private JLabel Titulo;
    private JTextField VisitaA;
    private JLabel eApMa;
    private JLabel eApPa;
    private JLabel eMotivo;
    private JLabel eNombre;
    private JLabel eTipoDoc;
    private JLabel eVisitaA;
    private JScrollPane Scroll;
    DefaultTableModel modelo = new DefaultTableModel();

    public AgregarVentana() throws ClassNotFoundException {
        GridBagConstraints gridBagConstraints;
        Panel = new JPanel();
        Scroll = new JScrollPane();
        Tabla = new JTable();
        Titulo = new JLabel();
        eNombre = new JLabel();
        eTipoDoc = new JLabel();
        eApPa = new JLabel();
        eApMa = new JLabel();
        ApPa = new JTextField();
        Nombre1 = new JTextField();
        ApMa1 = new JTextField();
        TipoDoc = new JTextField();
        eVisitaA = new JLabel();
        VisitaA = new JTextField();
        eMotivo = new JLabel();
        Motivo = new JTextField();
        Guardar = new JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar");
        getContentPane().setLayout(new GridBagLayout());

        Panel.setBackground(new Color(255, 255, 255));
        Panel.setForeground(new Color(255, 255, 255));
        Panel.setLayout(new GridBagLayout());

        Tabla.setBackground(new Color(255, 255, 255));
        Tabla.setFont(new Font("Arial", 0, 14));
        Tabla.setForeground(new Color(0, 0, 0));
        Tabla.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null}},
                new String[]{"ID", "Documento", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Fecha de Registro", "Visita a: ", "Motivo"}) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        Scroll.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(1);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(4).setResizable(false);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(5).setResizable(false);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(50);
            Tabla.getColumnModel().getColumn(6).setResizable(false);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(30);
            Tabla.getColumnModel().getColumn(7).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 983;
        gridBagConstraints.ipady = 266;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(32, 0, 16, 13);
        Panel.add(Scroll, gridBagConstraints);

        Titulo.setFont(new Font("Century Gothic", 1, 48));
        Titulo.setForeground(new Color(153, 0, 0));
        Titulo.setText("Agregar Nueva Visita");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(23, 28, 0, 0);
        Panel.add(Titulo, gridBagConstraints);

        eNombre.setFont(new Font("Arial", 1, 18));
        eNombre.setForeground(new Color(153, 0, 0));
        eNombre.setText("Nombre(s): ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 118, 0, 0);
        Panel.add(eNombre, gridBagConstraints);

        eApPa.setFont(new Font("Arial", 1, 18));
        eApPa.setForeground(new Color(153, 0, 0));
        eApPa.setText("Apellido Paterno: ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 65, 0, 0);
        Panel.add(eApPa, gridBagConstraints);

        eApMa.setFont(new Font("Arial", 1, 18));
        eApMa.setForeground(new Color(153, 0, 0));
        eApMa.setText("Apellido Materno: ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 62, 0, 0);
        Panel.add(eApMa, gridBagConstraints);

        ApPa.setBackground(new Color(204, 204, 204));
        ApPa.setFont(new Font("Arial", 0, 18));
        ApPa.setForeground(new Color(0, 0, 0));
        ApPa.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 247;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 12, 0, 0);
        Panel.add(ApPa, gridBagConstraints);

        Nombre1.setBackground(new Color(204, 204, 204));
        Nombre1.setFont(new java.awt.Font("Arial", 0, 18));
        Nombre1.setForeground(new Color(0, 0, 0));
        Nombre1.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 247;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 12, 0, 0);
        Panel.add(Nombre1, gridBagConstraints);

        ApMa1.setBackground(new Color(204, 204, 204));
        ApMa1.setFont(new Font("Arial", 0, 18));
        ApMa1.setForeground(new Color(0, 0, 0));
        ApMa1.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 247;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 12, 0, 0);
        Panel.add(ApMa1, gridBagConstraints);

        eTipoDoc.setFont(new Font("Arial", 1, 18));
        eTipoDoc.setForeground(new Color(153, 0, 0));
        eTipoDoc.setText("Tipo de Documento: ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 44, 0, 0);
        Panel.add(eTipoDoc, gridBagConstraints);

        TipoDoc.setBackground(new Color(204, 204, 204));
        TipoDoc.setFont(new Font("Arial", 0, 18));
        TipoDoc.setForeground(new Color(0, 0, 0));
        TipoDoc.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 247;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 6, 0, 0);
        Panel.add(TipoDoc, gridBagConstraints);

        eVisitaA.setFont(new Font("Arial", 1, 18));
        eVisitaA.setForeground(new Color(153, 0, 0));
        eVisitaA.setText("Visita a: ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 44, 0, 0);
        Panel.add(eVisitaA, gridBagConstraints);

        VisitaA.setBackground(new Color(204, 204, 204));
        VisitaA.setFont(new Font("Arial", 0, 18));
        VisitaA.setForeground(new Color(0, 0, 0));
        VisitaA.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.ipadx = 354;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        Panel.add(VisitaA, gridBagConstraints);

        eMotivo.setFont(new Font("Arial", 1, 18));
        eMotivo.setForeground(new Color(153, 0, 0));
        eMotivo.setText("Motivo:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 44, 0, 0);
        Panel.add(eMotivo, gridBagConstraints);

        Motivo.setBackground(new Color(204, 204, 204));
        Motivo.setFont(new Font("Arial", 0, 18));
        Motivo.setForeground(new Color(0, 0, 0));
        Motivo.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.ipadx = 364;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 6, 0, 0);
        Panel.add(Motivo, gridBagConstraints);

        Guardar.setIcon(new ImageIcon("src/image/Guardar_OFF.png"));
        Guardar.setBorder(null);
        Guardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Guardar.setRolloverIcon(new ImageIcon("src/image/Guardar_ON.jpg"));
        Guardar.setRolloverSelectedIcon(new ImageIcon("src/image/Guardar_ON.jpg"));
        Guardar.setSelectedIcon(new ImageIcon("src/image/Guardar_ON.jpg"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 219, 0, 0);
        Panel.add(Guardar, gridBagConstraints);
        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GuardarActionPerformed(e);
                } catch (ClassNotFoundException ex) {
                }
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(Panel, gridBagConstraints);

        pack();

        try {
            Tabla.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT IDVisita, TipoDocumento, Nombre, ApellidoPaterno, ApellidoMaterno, FechaRegistro, VisitaA, Motivo FROM Visita";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Documento");
            modelo.addColumn("Nombre(s)");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Fecha de Registro");
            modelo.addColumn("Visita a: ");
            modelo.addColumn("Motivo");

            int[] anchos = {1, 50, 50, 50, 50, 50, 30, 100};
            for (int i = 0; i < Tabla.getColumnCount(); i++) {
                Tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    private void GuardarActionPerformed(ActionEvent e) throws ClassNotFoundException {
        if (TipoDoc.getText().equals("") || Nombre1.getText().equals("") || ApPa.getText().equals("") || ApMa1.getText().equals("") || VisitaA.getText().equals("") || Motivo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Uno o varios datos estan sin completar.");
        } else {
            PreparedStatement ps = null;
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                Date date = new Date();
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();
                ps = conn.prepareStatement("INSERT INTO Visita (TipoDocumento, Nombre, ApellidoPaterno, ApellidoMaterno, FechaRegistro, VisitaA, Motivo)"
                        + " VALUES (?,?,?,?,?,?,?)");
                ps.setString(1, this.TipoDoc.getText());
                ps.setString(2, this.Nombre1.getText());
                ps.setString(3, this.ApPa.getText());
                ps.setString(4, this.ApMa1.getText());
                ps.setString(5, dateFormat.format(date));
                ps.setString(6, this.VisitaA.getText());
                ps.setString(7, this.Motivo.getText());
                ps.execute();

                JOptionPane.showMessageDialog(null, "Visita Agregada Exitosamente");
                conn.close();
                this.dispose();             

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Agregar");
                System.out.println(ex);
            }
        }
    }
}
