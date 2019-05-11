package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Prioridade;
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
public class TestePersistirPrioridade {

    public TestePersistirPrioridade() {
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
        Prioridade obj = new Prioridade();
        obj.setNome("Urgente");        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
}