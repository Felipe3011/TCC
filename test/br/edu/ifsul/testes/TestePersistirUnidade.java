package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Unidade;
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
public class TestePersistirUnidade {

    public TestePersistirUnidade() {
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
        Unidade obj = new Unidade();
        obj.setNome("Administração");
        Unidade obj2 = new Unidade();
        obj2.setNome("Posto de Saude");
        em.getTransaction().begin();
        em.persist(obj);
        em.persist(obj2);
        em.getTransaction().commit();        
    }

}