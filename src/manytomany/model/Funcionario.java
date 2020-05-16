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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Classe utilizada para representar um Funcionario.
 * Exemplo disponivel em: http://www.universidadejava.com.br/materiais/jpa-manytomany/ 
 */
@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNCIONARIO_ID")
    private Long id;
    private String nome;
    
    
    /* Exemplo usando FetchType.EAGER (não é aconselhável usar esta opcao) 
    * Os projetos sempre serão recuperados quando buscarmos um funcionario no banco
    * Veja o metodo recuperarTodos() da classe FuncionarioDAO
    */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "PROJETO_FUNCIONARIO",
            joinColumns = {@JoinColumn(name = "PROJETO_ID")},
            inverseJoinColumns = {@JoinColumn(name = "FUNCIONARIO_ID")})
    private List<Projeto> projetos;

    public Funcionario() {
    }

    
       
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", projetos=" + projetos + '}';
    }
    
    
    
}
