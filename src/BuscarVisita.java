
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BuscarVisita extends JInternalFrame {

    private JButton Buscar;
    private JTextField Busqueda;
    private JPanel Panel;
    private JTable Tabla;
    private JLabel Titulo;
    private JLabel eBuscar;
    private JLabel dosPuntos;
    private JScrollPane jScrollPane1;
    private JComboBox<String> Por;
    String Select = "Nombre";

    public BuscarVisita() {
        GridBagConstraints gridBagConstraints;
        Panel = new JPanel();
        jScrollPane1 = new JScrollPane();
        Tabla = new JTable();
        Titulo = new JLabel();
        eBuscar = new JLabel();
        dosPuntos = new JLabel();
        Busqueda = new JTextField();
        Buscar = new JButton();
        Por = new JComboBox<>();

        setBackground(new Color(255, 255, 255));
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
                new Object[][]{{null, null, null, null, null, null, null, null}},
                new String[]{"ID", "Documento", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Fecha de Registro", "Visita a: ", "Motivo"}) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);
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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 980;
        gridBagConstraints.ipady = 392;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(12, 0, 14, 31);
        Panel.add(jScrollPane1, gridBagConstraints);

        Titulo.setFont(new Font("Century Gothic", 1, 48));
        Titulo.setForeground(new Color(153, 0, 0));
        Titulo.setText("Buscar Visita");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(23, 3, 0, 0);
        Panel.add(Titulo, gridBagConstraints);

        eBuscar.setFont(new Font("Arial", 1, 18)); // NOI18N
        eBuscar.setForeground(new java.awt.Color(153, 0, 0));
        eBuscar.setText("Buscar por ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 96, 0, 0);
        Panel.add(eBuscar, gridBagConstraints);

        dosPuntos.setFont(new Font("Arial", 1, 18));
        dosPuntos.setForeground(new Color(153, 0, 0));
        dosPuntos.setText(":");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 6, 0, 0);
        Panel.add(dosPuntos, gridBagConstraints);

        Busqueda.setBackground(new Color(204, 204, 204));
        Busqueda.setFont(new java.awt.Font("Arial", 0, 18));
        Busqueda.setForeground(new Color(0, 0, 0));
        Busqueda.setBorder(null);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 578;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(35, 18, 0, 0);
        Panel.add(Busqueda, gridBagConstraints);

        Buscar.setIcon(new ImageIcon("src/image/Buscar_OFF.png"));
        Buscar.setBorder(null);
        Buscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Buscar.setRolloverIcon(new ImageIcon("src/image/Buscar_ON.jpg"));
        Buscar.setRolloverSelectedIcon(new ImageIcon("src/image/Buscar_ON.jpg"));
        Buscar.setSelectedIcon(new ImageIcon("src/image/Buscar_ON.jpg"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(15, 84, 0, 0);
        Panel.add(Buscar, gridBagConstraints);
        Buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BuscarActionPerformed(e);
            }
        });

        Por.setBackground(new Color(255, 255, 255));
        Por.setFont(new Font("Century Gothic", 1, 12));
        Por.setForeground(new Color(0, 0, 0));
        Por.setModel(new DefaultComboBoxModel<>(new String[]{"Nombre(s)", "ID", "Documento", "Apellido Paterno", "Apellido Materno", "Visita a"}));
        Por.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 6, 0, 0);
        Panel.add(Por, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(Panel, gridBagConstraints);

        pack();
    }

    private void PorActionPerformed(ActionEvent evt) {
        String itemSeleecionado = (String) Por.getSelectedItem();
        switch (itemSeleecionado) {
            case "ID":
                Select = "IDVisita";
                break;
            case "Documento":
                Select = "TipoDocumento";
                break;
            case "Apellido Paterno":
                Select = "ApellidoPaterno";
                break;
            case "Apellido Materno":
                Select = "ApellidoMaterno";
                break;
            case "Visita a":
                Select = "VisitaA";
                break;
            default:
                break;
        }
    }

    public void BuscarActionPerformed(ActionEvent e) {
        String campo = Busqueda.getText();
        String where = "";
        if (!"".equals(campo)) {
            where = "WHERE " + Select + " = '" + campo + "'";
        }
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Tabla.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT IDVisita, TipoDocumento, Nombre, ApellidoPaterno, ApellidoMaterno, FechaRegistro, VisitaA, Motivo FROM Visita " + where;
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "La Busqueda no arrojó resultados.");
        }
    }
}
