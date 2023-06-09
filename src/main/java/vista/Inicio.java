package vista;

import controller.InicioController;
import controller.ReglasController;
import controller.TableroController;
import javax.swing.JLabel;

/**
 *
 * @author Ivan
 */
public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbPlay = new javax.swing.JLabel();
        lbRules = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbGif = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPlay.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ivan\\Spring Boot\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\juego-dados-piratas-del-caribe\\src\\main\\resources\\imagenes\\play.png")); // NOI18N
        lbPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPlayMouseClicked(evt);
            }
        });
        jPanel1.add(lbPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 110, 50));

        lbRules.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ivan\\Spring Boot\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\juego-dados-piratas-del-caribe\\src\\main\\resources\\imagenes\\rules.png")); // NOI18N
        lbRules.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRulesMouseClicked(evt);
            }
        });
        jPanel1.add(lbRules, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 80, 40));

        lbTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lbTitulo.setFont(new java.awt.Font("Battlesbridge Demo", 0, 18)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(204, 153, 0));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ivan\\Spring Boot\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\juego-dados-piratas-del-caribe\\src\\main\\resources\\imagenes\\titulo.png")); // NOI18N
        jPanel1.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 470, 110));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 290, 60));

        lbGif.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ivan\\Spring Boot\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\juego-dados-piratas-del-caribe\\src\\main\\resources\\imagenes\\pcIcon.gif")); // NOI18N
        lbGif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -20, 290, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPlayMouseClicked
        InicioController.cerrarVentana();
        TableroController.iniciarVentana();
    }//GEN-LAST:event_lbPlayMouseClicked

    private void lbRulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRulesMouseClicked
        InicioController.cerrarVentana();
        ReglasController.iniciarVentana();
    }//GEN-LAST:event_lbRulesMouseClicked

    public JLabel getLbGif() {
        return lbGif;
    }

    public void setLbGif(JLabel lbGif) {
        this.lbGif = lbGif;
    }

    public JLabel getLbRules() {
        return lbRules;
    }

    public void setLbRules(JLabel lbRules) {
        this.lbRules = lbRules;
    }

    public JLabel getLbTitulo() {
        return lbTitulo;
    }

    public void setLbTitulo(JLabel lbTitulo) {
        this.lbTitulo = lbTitulo;
    }

    public JLabel getLbPlay() {
        return lbPlay;
    }

    public void setLbPlay(JLabel lbPlay) {
        this.lbPlay = lbPlay;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbGif;
    private javax.swing.JLabel lbPlay;
    private javax.swing.JLabel lbRules;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
