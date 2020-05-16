package manytomany.infra;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import manytomany.model.Funcionario;

/**
 *
 * @author mello
 */
public class FuncionarioDAO {

    public void salvar(Funcionario funcionario) {

        //cria um gerenciador de entidades
        EntityManager em = ConnectionFactoryHibernate.getEntityManager();

        try {
            //abrir uma transacao
            em.getTransaction().begin();

            funcionario = em.merge(funcionario);
            em.persist(funcionario);
            //fechar a transacao
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //encerra o gerenciador de entidades
            em.close();
        }
    }

    public List<Funcionario> recuperarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();

            //solicita ao gerenciador todas as instâncias da classe Funcionario
            Query query = em.createQuery("from Funcionario");
            funcionarios = query.getResultList();
            
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return funcionarios;
    }
}
