/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo.Chamado;
import br.edu.ifsul.modelo.Prioridade;
import br.edu.ifsul.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.HTML;

/**
 *
 * @author Felipe
 */
public class relatorios {

    

    public static List<Prioridade> carregarPrioridades() {        
       
        List<Prioridade> lista = new ArrayList<>();
        Prioridade prioridade = new Prioridade();        
        prioridade.setNome("FEFEFEE");
        lista.add(prioridade);

        return lista;
    }
    
    public static List<Chamado> carregarChamado() {
        
//        List<Chamado> c = new ArrayList<>();
//        Chamado chamado = new Chamado();
//        
//        chamado.setId(chamado.getId());
//        chamado.setDescricao(chamado.getDescricao());
//        chamado.setDataAbertura(chamado.getDataAbertura());
//        chamado.setDataFechamento(chamado.getDataFechamento());
//        chamado.setPrioridade(chamado.getPrioridade());
//        chamado.setFinalizado(chamado.getFinalizado());
//        chamado.setResolucao(chamado.getResolucao());
//        chamado.setStatus(chamado.getStatus());
//        Usuario usu = new Usuario();
//        usu.setNome("Felipe");
//        chamado.setUsuario(usu);
//        c.add(chamado);
        
        return null;
        
        
    }

}
