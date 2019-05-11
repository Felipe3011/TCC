package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Chamado;
import br.edu.ifsul.modelo.Equipamento;
import br.edu.ifsul.modelo.Prioridade;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
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
public class TestePersistirChamado {

    public TestePersistirChamado() {
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
        Chamado obj = new Chamado();
        obj.setDescricao("Teclado nao funciona");        
        obj.setDataAbertura(Calendar.getInstance());
        obj.setDataFechamento(Calendar.getInstance());
        obj.setStatus("Aguardando Técnico");
        obj.setResolucao("Trocado Memoria RAM");
        obj.setPrioridade(em.find(Prioridade.class, 3));
        obj.setFinalizado(false);
        obj.setUsuario(em.find(Usuario.class, "carlos_humberto"));        
        
                        
        em.getTransaction().begin();
        em.persist(obj);        
        em.getTransaction().commit();        
    }
}