package com.ufc.coob.models;

public class Disciplina {
    private int codido;
    private String nome;
    private int creditos;

    

    public Disciplina() {
    }
    
    public Disciplina(int codido, String nome, int creditos) {
        this.codido = codido;
        this.nome = nome;
        this.creditos = creditos;
    }
    public int getCodido() {
        return codido;
    }
    public void setCodido(int codido) {
        this.codido = codido;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Disciplina [codido=" + codido + ", nome=" + nome + ", creditos=" + creditos + "]";
    }

    
}
