package com.ufc.coob.interfaces;

import com.ufc.coob.models.Disciplina;
import com.ufc.coob.models.Estudantes;

public interface Aluno_disciplina {
    
    //Estudantes
    public void inserEstudantes(Estudantes estudante);
    public void listarEstudantes();
    public Estudantes encontrarEstudante(Estudantes estudante, int matricula);
    public void atualizarEstudante (Estudantes estudante, int matricula);
    public void deletarEstudante(int matricula);

    //Disciplinas
    public void inserirDisciplina(Disciplina disciplina);
    public void listarDisciplinas();
    public void atualizarDisciplina(Disciplina disciplina, int codigo);
    public void deletarDisciplina(Disciplina disciplina, int código);
}

