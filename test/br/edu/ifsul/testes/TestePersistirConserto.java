package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Conserto;
import br.edu.ifsul.modelo.Equipamento;
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
public class TestePersistirConserto {

    public TestePersistirConserto() {
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
        Equipamento e = em.find(Equipamento.class, 1);
        Conserto obj = new Conserto();
        obj.setNomeEmpresa("Infoway");
        obj.setProblema("Nao liga");
        obj.setDataFoiConserto(Calendar.getInstance());
        obj.setDataVoltouConserto(Calendar.getInstance());
        obj.setDescEquipConsert("Consertado");
        obj.setValorConserto(200.00);
        e.adicionarConserto(obj);
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();        
    }

}