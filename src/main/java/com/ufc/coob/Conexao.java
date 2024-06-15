package com.ufc.coob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao {
    private static String DB_URL = "jdbc:mysql://localhost/db_java";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "Password123#@!";

    public Conexao(){};

    public void insert(String nome, String email){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();

            String sqlComand = "INSERT INTO students(nome, email) VALUES ('"+nome+"', '"+email+"')";
            stmt.executeUpdate(sqlComand);

            conn.close();
            System.out.println("Aluno adicionado com sucesso!\n");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao inserir dados no banco!");
        }
    }

    public void showStudents(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();

            String sqlComand = "SELECT * FROM students;";
            stmt.execute(sqlComand);

            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println("Aluno "+id+":\nNome: "+nome+"\nEmail: "+email+"\n");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Não foi possivel recuperar os dados!");
        }
    }

    public void update(int id, String novo_nome, String novo_email){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();

            String sqlComand = "UPDATE students SET nome = ' "+novo_nome+" ', email = '"+novo_email+"' WHERE id = "+ id;
            stmt.execute(sqlComand);

            conn.close();
            System.out.println("Aluno atualizado com sucesso!\n");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar aluno: "+e);
        }
    }

    public void delete(int id){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();

            String sqlComand = "DELETE FROM students WHERE id = "+id;
            stmt.execute(sqlComand);

            conn.close();
            System.out.println("Aluno deletado da lista com sucesso!\n");
        } catch (Exception e) {
            System.out.println("Erro ao deletar aluno: "+e);
        }
    }
}
