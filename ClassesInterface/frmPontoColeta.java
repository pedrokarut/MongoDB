package ClassesDeInterface;
import ClassesJava.PontoColeta;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.types.ObjectId;


public class frmPontoColeta extends javax.swing.JFrame {

    PontoColeta p;
    public ObjectId codPonto;
    
    public frmPontoColeta() {
        initComponents();
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }
    
    private void LimpaCampos()
    {
        txtCidade.setText(null);
        txtCodPosto.setText(null);
        txtData.setText(null);
        txtEndereco.setText(null);
        txtEstado.setText(null);
        txtNome.setText(null);
    }
    
    
    private void LimpaJTable()
    {
        DefaultTableModel model = (DefaultTableModel) jTablePonto.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
             
        jTablePonto.setModel(model);
    }
    
    private void PreencheJTable()
    {
        String[] cabecalhos = {"Código do Ponto", "Nome", "Endereço", "Cidade", "Estado", "Data de Retirada"};
        final DefaultTableModel model = (DefaultTableModel) jTablePonto.getModel();
        model.setColumnIdentifiers(cabecalhos);
        
        //MongoDB
         MongoClient mongoClient = new MongoClient("localhost" , 27017 );
         final MongoDatabase db = mongoClient.getDatabase("Coleta");
         MongoCollection<Document> coll = db.getCollection("PontoColeta");           
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
                  
         model.addRow(new Object[]{objects[i][0], objects[i][1], objects[i][2], objects[i][3]});

        }
        
        
    }
});
               
     jTablePonto.setModel(model);
    
  }      


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodPosto = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePonto = new javax.swing.JTable();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar1 = new javax.swing.JButton();
        btImportar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Ponto de Coleta");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/location.png"))); // NOI18N

        jLabel3.setText("Código Posto:");

        jLabel4.setText("Nome:");

        jLabel5.setText("Endereço:");

        jLabel6.setText("Cidade:");

        jLabel7.setText("Estado:");

        jLabel8.setText("Data de Retirada:");

        txtCodPosto.setEditable(false);
        txtCodPosto.setEnabled(false);

        jTablePonto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePontoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePonto);

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

        btEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/broom.png"))); // NOI18N
        btEditar1.setText("Limpar");
        btEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar1ActionPerformed(evt);
            }
        });

        btImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCodPosto)
                                        .addComponent(txtNome)
                                        .addComponent(jLabel5)
                                        .addComponent(txtEstado)
                                        .addComponent(txtData)
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(179, 179, 179))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btCadastrar)
                                    .addGap(34, 34, 34)
                                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodPosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btEditar)
                            .addComponent(btExcluir)
                            .addComponent(btCadastrar))
                        .addGap(12, 12, 12)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImportar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        p = new PontoColeta();
        p.setCidade(txtCidade.getText());
        p.setDataRetirada(txtData.getText());
        p.setEndereco(txtEndereco.getText());
        p.setEstado(txtEstado.getText());
        p.setNome(txtNome.getText());
        p.InsertPonto(p.getNome(), p.getEndereco(), p.getCidade(), p.getEstado(), p.getDataRetirada());
        JOptionPane.showMessageDialog(null, "Ponto de Coleta cadastrado com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void jTablePontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePontoMouseClicked
        int linha = jTablePonto.getSelectedRow();
        txtCodPosto.setText(String.valueOf(jTablePonto.getValueAt(linha, 0)));
        txtNome.setText(String.valueOf(jTablePonto.getValueAt(linha, 1)));
        txtEndereco.setText(String.valueOf(jTablePonto.getValueAt(linha, 2)));
        txtCidade.setText(String.valueOf(jTablePonto.getValueAt(linha, 3)));
        txtEstado.setText(String.valueOf(jTablePonto.getValueAt(linha, 4)));
        txtData.setText(String.valueOf(jTablePonto.getValueAt(linha, 5)));
    }//GEN-LAST:event_jTablePontoMouseClicked

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        p = new PontoColeta();
        ObjectId id = new ObjectId(txtCodPosto.getText());
        p.setCodPonto(id);
        p.setCidade(txtCidade.getText());
        p.setDataRetirada(txtData.getText());
        p.setEndereco(txtEndereco.getText());
        p.setEstado(txtEstado.getText());
        p.setNome(txtNome.getText());
        p.UpdatePonto(id, p.getNome(), p.getEndereco(), p.getCidade(),p.getEstado(), p.getDataRetirada());
        JOptionPane.showMessageDialog(null, "Ponto de Coleta cadastrado com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
           p = new PontoColeta();
           ObjectId id =  new ObjectId(txtCodPosto.getText());
           p.DeletePonto(id);
           JOptionPane.showMessageDialog(null, "Ponto de Coleta cadastrado com sucesso!");
           LimpaCampos();
           LimpaJTable();
           PreencheJTable();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportarActionPerformed
        codPonto = new ObjectId(txtCodPosto.getText());
        dispose();
        
    }//GEN-LAST:event_btImportarActionPerformed

    private void btEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar1ActionPerformed
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btEditar1ActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPontoColeta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEditar1;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTablePonto;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodPosto;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
