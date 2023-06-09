
package vista;

import controller.ReglasEnJuegoController;

/**
 *
 * @author Ivan
 */
public class ReglasEnJuego extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    /**
     * Creates new form ReglasEnJuego
     */
    public ReglasEnJuego() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnCerrar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Amontesa", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("\nEn cada ronda, el primer jugador debe anunciar una \ncombinación de dados incluyendo \"cantidad y valor\". \nPor ejemplo, \"tres 4\".\n\n Los jugadores deben continuar diciendo combinaciones de\ndados que superen en cantidad o valor a la combinación \nanunciada anteriormente, o pueden \"desconfiar\" si creen \nque el jugador anterior ha mentido.\n\n Si un jugador \"desconfia\", todos los dados se revelan y se\nhace un recuento.\n Si la combinación anunciada es mayor al recuento, el \njugador que la hizo pierde. Si la combinación  es menor o \nigual al recuento, el jugador que \"desconfió\" pierde.\n\n Ejemplo :\n  Tu mano : 5-5-3-2-1 \n  Mano de Davy Jones : 4-3-3-2-6 \n\n Si apuestas que en total hay \"tres 5\" creyendo que Davy\nJones podría tener al menos un 5, Davy Jones puede\napostar la misma cantidad de dados, pero con un numero\nmás alto \"tres 6\" ó apostar una cantidad mayor al mismo\nvalor \"cuatro 5\" (no importa la cantidad siempre que no\nsupere el total de dados en juego \"diez\") ó puede \"desconfiar\".\n En el último caso perderias la mano por tener solo \"dos 5\".\n \n Recuerda ir leyendo el cuadro de dialogo, ubicado en la \nesquina inferior derecha de la pantalla. Con cada acción\nse irá actualizando los pasos a seguir. \n  ");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 360));

        btnCerrar.setBackground(new java.awt.Color(3, 35, 35));
        btnCerrar.setFont(new java.awt.Font("thedarkestpearl", 0, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

       ReglasEnJuegoController.cerrarVentana();       
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
