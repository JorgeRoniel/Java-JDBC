package com.ufc.coob;

import com.ufc.coob.Conexao;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
    public static void pauseForReading() {
        System.out.println("Pressione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Conexao c = new Conexao();
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println();
            System.out.println("#########################");
            System.out.println("#### Lista de Alunos ####");
            System.out.println("#########################");
            System.out.println("O que voce deseja fazer:\n1 - Adicionar Aluno\n2 - Listar Alunos\n3 - Atualizar Aluno\n4 - Deletar Aluno\n0 - Sair");
            System.out.println("#########################");
            System.out.println("#########################\n");
            int esc = s.nextInt();

            switch (esc) {
                case 1:
                    s.nextLine();
                    System.out.println("Digite o nome do aluno: ");
                    String nome = s.nextLine();
                    System.out.println("Digite o email do aluno");
                    String email = s.nextLine();

                    c.insert(nome, email);
                    break;
                case 2:
                    System.out.flush();
                    c.showStudents();
                    pauseForReading();
                    break;
                case 3:
                    
                    System.out.println("Informe o numero do aluno que voce deseja atualizar: ");
                    int id_aluno = s.nextInt();
                    s.nextLine();

                    System.out.println("Digite o novo nome: ");
                    String novo_nome = s.nextLine();

                    System.out.println("Digite o novo email: ");
                    String novo_email = s.nextLine();

                    c.update(id_aluno, novo_nome, novo_email);
                    break;
                case 4:
                    System.out.println("Informe o numero do aluno que voce deseja deletar da lista: ");
                    int id_aluno_del = s.nextInt();

                    c.delete(id_aluno_del);
                    break;
                case 0:
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        }
    }
}