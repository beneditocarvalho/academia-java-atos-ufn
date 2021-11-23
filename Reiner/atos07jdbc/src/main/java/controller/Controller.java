package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Veiculo;
import resources.MySQLR;

public class Controller extends MySQLR {

    MySQLR mysqlr;
    
    public Controller() {
        mysqlr = new MySQLR();
    }
    
    
    public void conectar(){
        boolean connected = mysqlr.connect("localhost", "3306", "locadora", "root", "12345");
        if (connected) {
            System.out.println("Base de dados conectada.");
        } else {
            System.out.println("Base de dados não conectada.");
        }
    }
    
    public void inserir(Veiculo veiculo){
        String query = "INSERT INTO Veiculos (ano, marca, modelo) "
                + "values ('"+veiculo.getAno()+"', '"+veiculo.getMarca()+"', "
                		+ "'"+veiculo.getModelo()+"')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }
    
    public void consultar(){
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM veiculos");
        
        if (rs != null) {
            try {
                while (rs.next()) {
                    // É possível referenciar a coluna pelo índice 
                    System.out.println("Id: " + rs.getString(1));
                    // Ou pelo nome
                    System.out.println("Marca: " + rs.getString("marca"));
                    System.out.println("Modelo: " + rs.getString("modelo"));
                    System.out.println();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public void alterar(Veiculo veiculo, int ID){
        int status;
        String query = "UPDATE veiculos SET marca='" + veiculo.getMarca() + "', "
                    + "modelo='" + veiculo.getModelo() + "', ano='" + veiculo.getAno() + "'  "
                    + "WHERE id=" + ID;
        status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }
    
    public void excluir(int ID){ 
        String query = "DELETE FROM veiculos WHERE id=" + ID;
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados excluídos com sucesso!");
        } else {
            System.out.println("Erro ao excluir dados!");
        }  
    } 
    
    public void fecharConexao() {
    	try {
			mysqlr.stmt.close();
			mysqlr.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}    