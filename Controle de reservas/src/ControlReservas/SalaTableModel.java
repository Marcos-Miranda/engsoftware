/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlReservas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marki
 */
public class SalaTableModel extends AbstractTableModel {
    // Lista de Salas a serem exibidos na tabela
    private List<Sala> linhas;
 
    // Cria um SalaTableModel sem nenhuma linha
    public SalaTableModel() {
        linhas = new ArrayList<Sala>();
    }
 
    // Cria um SalaTableModel contendo a lista recebida por parâmetro
    public SalaTableModel(List<Sala> listaDeSalas) {
        linhas = new ArrayList<Sala>(listaDeSalas);
    }
    
    // Array com os nomes das colunas.
    private String[] colunas = new String[] { "Sala", "Categoria" };
    
    // Constantes representando o índice das colunas
    private static final int SALA = 0;
    private static final int CATEGORIA = 1;
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case SALA:
            return String.class;
        case CATEGORIA:
            return String.class;
        default:
            // Não deve ocorrer, pois só existem 2 colunas
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       // Pega a sala referente a linha especificada.
        Sala sala = linhas.get(rowIndex);

        switch (columnIndex) {
        case SALA:
            return sala.getIdSala();
        case CATEGORIA:
            return sala.getCategoria();
        default:
            // Não deve ocorrer, pois só existem 2 colunas
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sala referente a linha especificada.
        Sala sala= linhas.get(rowIndex);

        switch (columnIndex) {
        case SALA:
            sala.setIdSala((String) aValue);
            break;
        case CATEGORIA:
            sala.setCategoria((String) aValue);
            break;
        default:
            // Não deve ocorrer, pois só existem 2 colunas
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }
    
    // Retorna a sala referente a linha especificada
    public Sala getSocio(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    // Adiciona a sala especificada ao modelo
    public void addSala(Sala sala) {
        // Adiciona o registro.
        linhas.add(sala);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    // Adiciona uma lista de salas no final da lista.
    public void addListaDeSalas(List<Sala> salas) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(salas);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + salas.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de salas.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }

    
}
