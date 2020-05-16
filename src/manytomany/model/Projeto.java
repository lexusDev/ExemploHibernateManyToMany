package manytomany.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Classe utilizada para representar um projeto.
 * Exemplo disponivel em: http://www.universidadejava.com.br/materiais/jpa-manytomany/ 
 */
@Entity
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJETO_ID")
    private Long id;
    
    private String nome;
    
    /* Exemplo usando FetchType.Lazy. 
    * Os desenvolvedores só serão carregados do banco se explicitarmos esta busca
    * Veja o metodo recuperarTodos() da classe ProjetoDAO
    */
    @ManyToMany(mappedBy = "projetos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Funcionario> desenvolvedores;

       
    
    public Projeto() {
    }

    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDesenvolvedores(List<Funcionario> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    @Override
    public String toString() {
        return "Projeto{" + "id=" + id + ", nome=" + nome + ", desenvolvedores=" + desenvolvedores + '}';
    }
   
    
    
    
}
