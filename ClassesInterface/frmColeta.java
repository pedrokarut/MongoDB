package ClassesDeInterface;

import ClassesJava.Coleta;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.types.ObjectId;


public class frmColeta extends javax.swing.JFrame {
    
    frmAgenteAmbiental frmAge;
    frmPontoColeta frmPost;
    Coleta c;
    public ObjectId codColeta;
  
    public frmColeta() {
        initComponents();
    }
    
    private void LimpaCampos()
    {
        txtCodAgente.setText(null);
        txtCodColeta.setText(null);
        txtCodPosto.setText(null);
        txtData.setText(null);
    }

    private void LimpaJTable()
    {
        DefaultTableModel model = (DefaultTableModel) jTableColeta.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
             
        jTableColeta.setModel(model);
    }
    
    private void PreencheJTable()
    {
        String[] cabecalhos = {"Código da Coleta", "Código do Agente", "Código do Ponto", "Data da retirada"};
        final DefaultTableModel model = (DefaultTableModel) jTableColeta.getModel();
        model.setColumnIdentifiers(cabecalhos);
        
        //MongoDB
         MongoClient mongoClient = new MongoClient("localhost" , 27017 );
         final MongoDatabase db = mongoClient.getDatabase("Coleta");
         MongoCollection<Document> coll = db.getCollection("Coleta");           
         final int numDocumentos = Integer.parseInt(String.valueOf(coll.count()));
         final Object[][] objects = new Object[numDocumentos][6];
         FindIterable<Document> iterable = coll.find();           
         
         iterable.forEach(new Block<Document>() {
    @Override
    public void apply(final Document document) {
        
        for(int i=0;i<numDocumentos;i++)
        {
         objects[i][0] = document.getObjectId("_id");
         objects[i][1] = document.getString("codAgente");
         objects[i][2] = document.getString("codPonto");
         objects[i][3] = document.getString("dataColeta");
         objects[i][4] = document.getString("estado");
         objects[i][5] = document.getString("dataRetirada");
         
         model.addRow(new Object[]{objects[i][0], objects[i][1], objects[i][2], objects[i][3], objects[i][4], objects[i][5]});

        }
        
        
    }
});
               
     jTableColeta.setModel(model);
    
  }      

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodColeta = new javax.swing.JTextField();
        txtCodPosto = new javax.swing.JTextField();
        txtCodAgente = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableColeta = new javax.swing.JTable();
        btAdiconarPonto = new javax.swing.JButton();
        btAdicionarAgente = new javax.swing.JButton();
        btImportarColeta = new javax.swing.JButton();
        btEditar1 = new javax.swing.JButton();

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/interface.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Coleta");

        jLabel3.setText("Data:");

        jLabel4.setText("Código Ponto:");

        jLabel5.setText("Código Agente:");

        jLabel6.setText("Código Coleta:");

        txtCodColeta.setEditable(false);
        txtCodColeta.setEnabled(false);

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/draw.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon("/home/peter/Pictures/Coletas icons/CRUD16/png/close.png")); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jTableColeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableColeta);

        btAdiconarPonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btAdiconarPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdiconarPontoActionPerformed(evt);
            }
        });

        btAdicionarAgente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btAdicionarAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarAgenteActionPerformed(evt);
            }
        });

        btImportarColeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btImportarColeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportarColetaActionPerformed(evt);
            }
        });

        btEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/broom.png"))); // NOI18N
        btEditar1.setText("Limpar");
        btEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtData)
                                    .addComponent(txtCodPosto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAdiconarPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btImportarColeta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCodColeta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtCodAgente, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btAdicionarAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(32, 32, 32)
                                        .addComponent(btEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditar1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodColeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAdicionarAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodPosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdiconarPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCadastrar)
                            .addComponent(btEditar)
                            .addComponent(btExcluir)))
                    .addComponent(btImportarColeta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarAgenteActionPerformed
        frmAge = new frmAgenteAmbiental();
        frmAge.setLocationRelativeTo(null);
        frmAge.setVisible(true);
    }//GEN-LAST:event_btAdicionarAgenteActionPerformed

    private void btAdiconarPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdiconarPontoActionPerformed
        frmPost = new frmPontoColeta();
        frmPost.setLocationRelativeTo(null);
        frmPost.setVisible(true);
    }//GEN-LAST:event_btAdiconarPontoActionPerformed

    private void btImportarColetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportarColetaActionPerformed
        codColeta = new ObjectId(txtCodColeta.getText());
        dispose();
    }//GEN-LAST:event_btImportarColetaActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        c  = new Coleta();
        ObjectId codAgente = new ObjectId(txtCodAgente.getText());
        ObjectId codPonto = new ObjectId(txtCodPosto.getText());
        c.setCodAgente(codAgente);
        c.setCodPonto(codPonto);
        c.setDataColeta(txtData.getText());
        c.InsertColeta(codAgente, codPonto, c.getDataColeta());
        JOptionPane.showMessageDialog(null, "Coleta realizada com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
       c = new Coleta();
       ObjectId id = new ObjectId(txtCodColeta.getText());
       ObjectId codAgente = new ObjectId(txtCodAgente.getText());
       ObjectId codPonto = new ObjectId(txtCodPosto.getText());
       c.setCodAgente(codAgente);
       c.setCodPonto(codPonto);
       c.setDataColeta(txtData.getText());
       c.UpdateColeta(id, codAgente, codPonto, c.getDataColeta());
       JOptionPane.showMessageDialog(null, "Coleta editada com sucesso!");
       LimpaCampos();
       LimpaJTable();
       PreencheJTable();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
       c = new Coleta();
       ObjectId id = new ObjectId(txtCodColeta.getText());
       c.DeleteColeta(id);
       JOptionPane.showMessageDialog(null, "Coleta deletada com sucesso!");
       LimpaCampos();
       LimpaJTable();
       PreencheJTable();
    }//GEN-LAST:event_btExcluirActionPerformed
       
    private void btEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar1ActionPerformed
        LimpaCampos();
    }//GEN-LAST:event_btEditar1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        frmAgenteAmbiental.
    }//GEN-LAST:event_formWindowGainedFocus

   
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
            java.util.logging.Logger.getLogger(frmColeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmColeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmColeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmColeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmColeta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarAgente;
    private javax.swing.JButton btAdiconarPonto;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEditar1;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImportarColeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableColeta;
    private javax.swing.JTextField txtCodAgente;
    private javax.swing.JTextField txtCodColeta;
    private javax.swing.JTextField txtCodPosto;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
