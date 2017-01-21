/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class banco {

    //preparo e realização de pesquisas no bd
    public Statement stm;
    //armazenar o resultado de uma pesquisa, passada para o statement
    public ResultSet rs;
    
    public ResultSet rs2;
    //fazer a identificação do bd
    private String driver = "com.mysql.jdbc.Driver";
    //caminho do meu banco
    private String caminho = "jdbc:mysql://localhost:3306/projetofinal";
    //usuario
    private String usuario = "root";
    //senha, como no meu não tem, só abre aspas
    private String senha = "";
    //responsável por fazer a conexão
    public Connection con;

    public void conexao() { //metodo para realizar a conexão com o bd
        try {
            System.setProperty("jdbc.Drivers", driver); //seta a propriedade do driver de conexão
            con = DriverManager.getConnection(caminho, usuario, senha); //realiza a conexão com o bd
        } catch (SQLException ex) {//exceção, caso dê errado
            JOptionPane.showMessageDialog(null, "Não");
        }
    }

    public void executaSQL(String sql) {
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }

    //metodo para desconectar com o bd
    public void desconecta() {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar");
        }

    }
}