/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlReservas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marki
 */
public class ReservaTableModel extends AbstractTableModel {
    // Lista de Reservas a serem exibidos na tabela
    private List<Reserva> linhas;
 
    // Cria um ReservaTableModel sem nenhuma linha
    public ReservaTableModel() {
        linhas = new ArrayList<Reserva>();
    }
 
    // Cria um ReservaTableModel contendo a lista recebida por parâmetro
    public ReservaTableModel(List<Reserva> listaDeReservas) {
        linhas = new ArrayList<Reserva>(listaDeReservas);
    }
    
    // Array com os nomes das colunas.
    private String[] colunas = new String[] { "Sala", "Horario","Data"};
    
    // Constantes representando o índice das colunas
    private static final int SALA = 0;
    private static final int HORARIO = 1;
    private static final int DATA = 2;
    
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
        case HORARIO:
            return String.class;
        case DATA:
            return Date.class;
        default:
            // Não deve ocorrer, pois só existem 3 colunas
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       // Pega a reserva referente a linha especificada.
        Reserva reserva = linhas.get(rowIndex);

        switch (columnIndex) {
        case SALA:
            return reserva.getSala();
        case HORARIO:
            return reserva.getHorario();
        case DATA:
            return reserva.getData();
        default:
            // Não deve ocorrer, pois só existem 3 colunas
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega a reserva referente a linha especificada.
        Reserva reserva= linhas.get(rowIndex);

        switch (columnIndex) {
        case SALA:
            reserva.setSala((String) aValue);
            break;
        case HORARIO:
            reserva.setHorario((String) aValue);
            break;
        case DATA:
            reserva.setData((Date) aValue);
        default:
            // Não deve ocorrer, pois só existem 3 colunas
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }
    
    // Retorna a reserva referente a linha especificada
    public Reserva getReserva(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    // Adiciona a reserva especificada ao modelo
    public void addReserva(Reserva reserva) {
        // Adiciona o registro.
        linhas.add(reserva);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    // Adiciona uma lista de reservas no final da lista.
    public void addListaDeReservas(List<Reserva> reservas) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(reservas);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + reservas.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}
