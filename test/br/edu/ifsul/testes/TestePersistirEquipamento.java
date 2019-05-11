package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Conserto;
import br.edu.ifsul.modelo.Equipamento;
import br.edu.ifsul.modelo.Setor;
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
public class TestePersistirEquipamento {

    public TestePersistirEquipamento() {
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
        Equipamento obj = new Equipamento();
        obj.setPatrimonio(950003500);
        obj.setNome("Monitor");
        obj.setStatus("Bom");
        obj.setSetor(em.find(Setor.class, 19));
        Conserto c = new Conserto();
        c.setDataFoiConserto(Calendar.getInstance());
        c.setDataVoltouConserto(Calendar.getInstance());
        c.setDescEquipConsert("Nao tem conserto");
        c.setNomeEmpresa("Info");
        c.setValorConserto(400.00);
        c.setProblema("Queimou");
        obj.adicionarConserto(c);
        em.getTransaction().begin();
        em.persist(obj);        
        em.getTransaction().commit();        
    }

}