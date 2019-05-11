package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Felipe Lima
 */
public class TestePersistirUsuarioPermissao {

    public TestePersistirUsuarioPermissao() {
    }
    
    EntityManagerFactory emf;
    EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("PC2-ModelPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        Usuario obj = em.find(Usuario.class,"carlos_humberto");
        
        obj.getPermissoes().remove(em.find(Permissao.class, "USUARIO"));
        em.getTransaction().begin();
        em.persist(obj);        
        em.getTransaction().commit();        
    }
}