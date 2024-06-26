package com.ufc.coob.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ufc.coob.interfaces.Aluno_disciplina;
import com.ufc.coob.models.Disciplina;
import com.ufc.coob.models.Estudantes;


public class Manager implements Aluno_disciplina{
    private static String DB_URL = "jdbc:mysql://localhost/db_java";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "";

    private Connection conn(){
        Connection conect = null;
        try{
            conect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch (SQLException e){
            System.out.println(e);
        }

        return conect;
        
    }

    private Statement statement(){
        Statement stmt = null;
        try {
            Connection c = conn();
            stmt = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }

        return stmt;
    }

    @Override
    public void inserEstudantes(Estudantes estudante) {
        try {
            Connection conn = conn();
            Statement stmt = statement();

            String sqlComand = "INSERT INTO estudantes(matricula, nome, idade, email) VALUES ("+estudante.getMatricula()+", '"+estudante.getNome()+"', "+estudante.getIdade()+", '"+estudante.getEmail()+"')";
            stmt.executeUpdate(sqlComand);

            conn.close();
            System.out.println("Aluno adicionado com sucesso!\n");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao inserir dados no banco!");
        }
    }

    @Override
    public void listarEstudantes() {
        try {
            Connection conn = conn();
            Statement stmt = statement();

            String sqlComand = "SELECT e.matricula, e.nome, e.idade, a.periodo FROM aluno_disciplina a INNER JOIN estudantes e ON a.aluno_matr = e.matricula INNER JOIN disciplina d ON a.disciplina_cod = d.codigo GROUP BY e.matricula, e.nome, e.idade, a.periodo;";
            stmt.execute(sqlComand);

            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                int matr = rs.getInt("matricula");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                int periodo = rs.getInt("periodo");
                System.out.println("Aluno \nMatricula: "+matr+":\nNome: "+nome+"\nidade: "+idade+"\nPeriodo: "+periodo+"\n");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Não foi possivel recuperar os dados!");
        }
    }

    @Override
    public Estudantes encontrarEstudante(Estudantes estudante, int matricula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encontrarEstudante'");
    }

    @Override
    public void atualizarEstudante(Estudantes estudante, int matricula) {
        try {
            Connection conn = conn();
            Statement stmt = statement();

            String sqlComand = "UPDATE estudantes SET nome = ' "+estudante.getNome()+" ', idade = "+estudante.getIdade()+", email = '"+estudante.getEmail()+"' WHERE matricula = "+ estudante.getMatricula();
            stmt.execute(sqlComand);

            conn.close();
            System.out.println("Aluno atualizado com sucesso!\n");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar aluno: "+e);
        }
    }

    @Override
    public void deletarEstudante(int matricula) {
        try {
            Connection conn = conn();
            Statement stmt = statement();

            String sqlComand = "DELETE FROM estudantes WHERE matricula = "+matricula;
            stmt.execute(sqlComand);

            conn.close();
            System.out.println("Aluno deletado da lista com sucesso!\n");
        } catch (Exception e) {
            System.out.println("Erro ao deletar aluno: "+e);
        }
    }

    @Override
    public void inserirDisciplina(Disciplina disciplina) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirDisciplina'");
    }

    @Override
    public void listarDisciplinas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarDisciplinas'");
    }

    @Override
    public void atualizarDisciplina(Disciplina disciplina, int codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarDisciplina'");
    }

    @Override
    public void deletarDisciplina(Disciplina disciplina, int código) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarDisciplina'");
    }
    
}
