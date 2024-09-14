/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Funcionario;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class FuncionarioDAO {
    
    public void create(Funcionario f){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO funcionarios(nome,cargo)VALUES(?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCargo());
            //stmt.setDate(3, f.getData_admissao());
            
            stmt.executeUpdate();
                        
            JOptionPane.showMessageDialog(null, "Usuário cadastrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
