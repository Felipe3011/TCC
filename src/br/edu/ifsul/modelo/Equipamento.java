/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "equipamento")
public class Equipamento implements Serializable{
    
    
//    @SequenceGenerator(name = "seq_patrimonio", sequenceName = "seq_patrimonio_id", allocationSize = 1)
//    @GeneratedValue(generator = "seq_patrimonio", strategy = GenerationType.SEQUENCE)
    @Id
    @NotNull(message = "O patrimonio não pode ser nulo")
    @Column(name = "patrimonio", length = 20, nullable = false)
    private Integer patrimonio;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "O status não pode ser nulo")
    @NotBlank(message = "O status não pode ser em branco")
    @Length(max = 50, message = "O status não pode ter mais que {max} caracteres")
    @Column(name = "status", length = 50, nullable = false)
    private String status;  

    @ManyToOne
    @JoinColumn(name = "setor", referencedColumnName = "id", nullable = false, 
            foreignKey = @ForeignKey(name = "fk_equipamento_setor"))
    private Setor setor;
    
    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Conserto> consertos = new ArrayList<>();
    
    public Equipamento() {
    }
    
    public void adicionarConserto(Conserto obj){
        obj.setEquipamento(this);
        this.consertos.add(obj);
    }
    
    public void removerConserto(int index){
        this.consertos.remove(index);
    }

    public Integer getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Integer patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
        public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Conserto> getConsertos() {
        return consertos;
    }

    public void setConsertos(List<Conserto> consertos) {
        this.consertos = consertos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.patrimonio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipamento other = (Equipamento) obj;
        if (!Objects.equals(this.patrimonio, other.patrimonio)) {
            return false;
        }
        return true;
    }

   
}
