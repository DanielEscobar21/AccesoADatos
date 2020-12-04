
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VerVisitas extends JInternalFrame {

    private JPanel Panel;
    private JTable Tabla;
    private JLabel Titulo;
    private JScrollPane jScrollPane1;
    DefaultTableModel modelo = new DefaultTableModel();

    public VerVisitas() throws ClassNotFoundException {
        GridBagConstraints gridBagConstraints;

        Panel = new JPanel();
        jScrollPane1 = new JScrollPane();
        Tabla = new JTable();
        Titulo = new JLabel();

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
        Tabla.setFont(new Font("Arial", 0, 14)); // NOI18N
        Tabla.setForeground(new Color(0, 0, 0));
        Tabla.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Documento", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Fecha de Registro", "Visita a: ", "Motivo"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 985;
        gridBagConstraints.ipady = 464;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(32, 0, 19, 18);
        Panel.add(jScrollPane1, gridBagConstraints);

        Titulo.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        Titulo.setForeground(new Color(153, 0, 0));
        Titulo.setText("Visitantes");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(0, 398, 0, 0);
        Panel.add(Titulo, gridBagConstraints);

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

}
