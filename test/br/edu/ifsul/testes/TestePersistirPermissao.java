package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
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
public class TestePersistirPermissao {

    public TestePersistirPermissao() {
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
        Permissao obj = new Permissao();
        obj.setNome("Supervisor");
        obj.setDescricao("Supervisor do Técnico de TI");        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }

}