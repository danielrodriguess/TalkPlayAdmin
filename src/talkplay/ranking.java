/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talkplay;

import classes.banco;
import classes.tabela;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author danie
 */
public class ranking extends javax.swing.JFrame {
banco banco = new banco();
login login = new login();
categoria categoria = new categoria();
public String pegartipo = categoria.tipo;
public String email = login.user;
public String senha = login.senha;
    /**
     * Creates new form ranking
     */
    public ranking() {
        initComponents();
        banco.conexao();
        try{
        String consulta = "select * from admin where email = '" + this.email.toString()+ "' and senha = '"+this.senha.toString()+"' and status = 'ativo'";            
                PreparedStatement pst1 = banco.con.prepareStatement(consulta);
                 banco.rs = pst1.executeQuery(consulta); 
                 if(!banco.rs.next()){
                     JOptionPane.showMessageDialog(null,"Perfil desativado");
                     System.exit(0);
                 }
        }catch(SQLException ex){
            
        }
        preenchertabela("select * from ranking where categoria = '"+pegartipo.toString()+"' order by pontuacao desc");
        setLocationRelativeTo(null);
        lbl1.setText("Bem-vindo "+login.user);
    }
public void preenchertabela(String banco1) {
        //variavel do tipo arratlist
        ArrayList dados = new ArrayList();
        //nomeando as colunas da tabela, usando vetor
        String[] colunas = new String[]{"Apelido", "Pontuação"};
        //comando para buscar dados da tabela
        banco.executaSQL(banco1);
        try {
            //volta para a primeira coluna
            banco.rs.first();
            //pode fazer  com o if
            //realizando busca de dados, caso tenha algum
            //o nome é igual ao nome do campo no bd
            do {
                dados.add(new Object[]{
                    banco.rs.getString("email"),
                    banco.rs.getString("pontuacao")});
            } while (banco.rs.next());
        } catch (SQLException ex) {
        }
        tabela table = new tabela(dados, colunas);
        tabela1.setModel(table);
        //preenchendo as tabelas, no caso apenas algumas preferencias
        //no caso defini apenas o tamanho e se ela poderia ser redimensionada
        tabela1.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabela1.getColumnModel().getColumn(0).setResizable(false);
        tabela1.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela1.getColumnModel().getColumn(1).setResizable(false);
        tabela1.getTableHeader().setReorderingAllowed(false);
        /*opcional*/
        //a tabela não pode ser redimensioanda
        tabela1.setAutoResizeMode(tabela1.AUTO_RESIZE_OFF);
        //seleção única
        tabela1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(667, 402));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste.png"))); // NOI18N

        lbl1.setText("jLabel1");

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela1);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(143, 188, 143));
        jButton1.setText("Voltar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
                .addComponent(lbl1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        categoria gere = new categoria();
         gere.setTitle("Categoria(Talkresponde) - Talkplay");
        this.setVisible(false);
        gere.setVisible(true);
        gere.setResizable(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setBackground(ColorUIResource.decode("#8FBC8F"));
        jButton1.setForeground(ColorUIResource.WHITE);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setBackground(ColorUIResource.WHITE);
        jButton1.setForeground(ColorUIResource.decode("#8FBC8F"));
    }//GEN-LAST:event_jButton1MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ranking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}