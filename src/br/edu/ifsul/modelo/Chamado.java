    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "chamado")
public class Chamado implements Serializable{
    
    @Id    
    @SequenceGenerator(name = "seq_chamado", sequenceName = "seq_chamado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_chamado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Length(max = 100, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    
    @NotNull(message = "O status não pode ser nula")
    @NotBlank(message = "O status não pode ser em branco")
    @Length(max = 100, message = "O status não pode ter mais que {max} caracteres")
    @Column(name = "status", length = 100, nullable = false)
    private String status;
        
    @Length(max = 100, message = "A resolução não pode ter mais que {max} caracteres")
    @Column(name = "resolucao", length = 100)
    private String resolucao;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data de abertura não pode ser nula")    
    @Column(name = "dataAbertura", nullable = false)
    private Calendar dataAbertura;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataFechamento")
    private Calendar dataFechamento;
    
    @Column(name = "finalizado")
    private Boolean finalizado;
    
    @ManyToOne
    @JoinColumn(name = "prioridade", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_chamado_prioridade"))
    private Prioridade prioridade;
        
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "login", nullable = false, 
            foreignKey = @ForeignKey(name = "fk_chamado_usuario"))
    private Usuario usuario;
    
//    @OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL, 
//            orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Equipamento> equipamentos = new ArrayList<>();
    
    public Chamado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Chamado other = (Chamado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

//    public List<Equipamento> getEquipamentos() {
//        return equipamentos;
//    }
//
//    public void setEquipamentos(List<Equipamento> equipamentos) {
//        this.equipamentos = equipamentos;
//    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
    
}
