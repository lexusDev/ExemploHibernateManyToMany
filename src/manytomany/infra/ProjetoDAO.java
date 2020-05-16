package manytomany.infra;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import manytomany.model.Projeto;

/**
 *
 * @author mello
 */
public class ProjetoDAO {
    
    public void salvar(Projeto projeto) {

        //cria um gerenciador de entidades
        EntityManager em = ConnectionFactoryHibernate.getEntityManager();

        try {
            //abrir uma transacao
            em.getTransaction().begin();
            //solicita ao gerenciador que salve a entidade
            em.persist(projeto);
            //fechar a transacao
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //encerra o gerenciador de entidades
            em.close();
        }
    }

    public List<Projeto> recuperarTodos() {
        List<Projeto> projetos = new ArrayList<>();

        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            //solicita ao gerenciador todas as instâncias da classe Projeto
            Query query = em.createQuery("from Projeto p JOIN FETCH p.desenvolvedores ");
            projetos = query.getResultList();
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return projetos;
    }
}
