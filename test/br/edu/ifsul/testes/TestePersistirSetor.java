package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Setor;
import br.edu.ifsul.modelo.Unidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe Lima
 */
public class TestePersistirSetor {

    public TestePersistirSetor() {
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
        Setor obj = new Setor();
        obj.setNome("Vacinas");
        obj.setUnidade(em.find(Unidade.class, 4));
        em.getTransaction().begin();
        em.persist(obj);        
        em.getTransaction().commit();        
    }

}