/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talkplay;

/**
 *
 * @author danie
 */
public class Talkplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*frmusuario log = new frmusuario();
        log.setResizable(false);
        log.setVisible(true);*/
        login log = new login();
        log.setTitle("Logue-se no sistema");
        log.setResizable(false);
        log.setVisible(true);
    }
    
}
