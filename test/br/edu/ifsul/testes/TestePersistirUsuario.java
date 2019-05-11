package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Setor;
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
public class TestePersistirUsuario {

    public TestePersistirUsuario() {
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
        Usuario obj = new Usuario();
        obj.setEmail("felipe2@felipe2.com");
        obj.setNome("Felipe2 Lima");
        obj.setLogin("felipelima2");
        obj.setSenha("123");
        obj.setSetor(em.find(Setor.class, 11));
        em.getTransaction().begin();
        em.persist(obj);        
        em.getTransaction().commit();        
    }

}