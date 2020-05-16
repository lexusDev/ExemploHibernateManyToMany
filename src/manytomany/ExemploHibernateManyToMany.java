package manytomany;

import java.util.ArrayList;
import java.util.List;
import manytomany.infra.FuncionarioDAO;
import manytomany.infra.ProjetoDAO;
import manytomany.model.Funcionario;
import manytomany.model.Projeto;

/**
 *
 * @author mello
 */
public class ExemploHibernateManyToMany {

    public static void main(String[] args) {

        // Cadastra projetos
        Projeto p1 = new Projeto();
        p1.setNome("Projeto 1");

        Projeto p2 = new Projeto();
        p2.setNome("Projeto 2");

        ProjetoDAO pdao = new ProjetoDAO();
        pdao.salvar(p1);
        pdao.salvar(p2);

        // Cria funcionaria Maria
        Funcionario f1 = new Funcionario();
        f1.setNome("Maria");

        List<Projeto> projetosMaria = new ArrayList<>();
        projetosMaria.add(p1);
        projetosMaria.add(p2);
        f1.setProjetos(projetosMaria);

        // cria funcionario Joao
        Funcionario f2 = new Funcionario();
        f2.setNome("Joao");

        List<Projeto> projetosJoao = new ArrayList<>();
        projetosJoao.add(p1);
        f2.setProjetos(projetosJoao);

        // Cadastra funcionarios criados
        FuncionarioDAO fdao = new FuncionarioDAO();
        fdao.salvar(f1);
        fdao.salvar(f2);

        // lista todos os projetos salvos no banco
        List<Projeto> projetos = new ArrayList<>();
        projetos = pdao.recuperarTodos();
        for (Projeto p : projetos) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Devs:");
            for (Funcionario f : p.getDesenvolvedores()) {
                System.out.println("\tID: " + f.getId() +". Nome: " + f.getNome());
            }

        }

        // lista todos os funcionarios cadastrados
        List<Funcionario> funcionarios = fdao.recuperarTodos();
        for (Funcionario f : funcionarios) {
            System.out.println("ID: " + f.getId());
            System.out.println("Nome: " + f.getNome());
            System.out.println("Projetos:");
            for (Projeto p : f.getProjetos()) {
                System.out.println("\tID: " + p.getId() +". Nome: " + p.getNome());
            }

        }
    }

}
