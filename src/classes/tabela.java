/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
//bibliotecas necessárias para Array list e criação de modelo da tabela
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class tabela extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public tabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }
    //contar linha
    public ArrayList getLinhas() {
        return linhas;
    }
    //mandar valores para linha
    public void setLinhas(ArrayList dados) {
        linhas = dados;
    }
    //contar colunas
    public String[] getColunas() {
        return colunas;
    }
    //mandar valores para colunas
    public void setColunas(String[] vetornomes) {
        colunas = vetornomes;
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return linhas.size();
    }

    public String getColumnName(int numcolumn) {
        return colunas[numcolumn];
    }
    
    public Object getValueAt(int numlinha, int numcol) {
        Object[] linha = (Object[]) getLinhas().get(numlinha);
        return linha[numcol];
    }
}