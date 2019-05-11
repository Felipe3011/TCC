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
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "conserto")
public class Conserto implements Serializable{
    
    @Id    
    @SequenceGenerator(name = "seq_conserto", sequenceName = "seq_conserto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_conserto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O problema não pode ser nula")
    @NotBlank(message = "O problema não pode ser em branco")
    @Length(max = 100, message = "O problema não pode ter mais que {max} caracteres")
    @Column(name = "problema", length = 100, nullable = false)
    private String problema;
    
    @NotNull(message = "A Empresa não pode ser nula")
    @NotBlank(message = "A Empresa não pode ser em branco")
    @Length(max = 100, message = "A Empresa não pode ter mais que {max} caracteres")
    @Column(name = "nomeEmpresa", length = 100, nullable = false)
    private String nomeEmpresa;
        
    @Length(max = 100, message = "A resolução não pode ter mais que {max} caracteres")
    @Column(name = "descEquipConsert", length = 100)
    private String descEquipConsert;
    
    @Column(name = "valorConserto")
    private Double valorConserto;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data que foi para o conserto não pode ser nula")    
    @Column(name = "dataFoiConserto", nullable = false)
    private Calendar dataFoiConserto;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataVoltouConserto")
    private Calendar dataVoltouConserto;
    
    @NotNull(message = "O Equipamento não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "equipamento", referencedColumnName = "patrimonio", nullable = false)
    @ForeignKey(name = "fk_conserto_equipamento")        
    private Equipamento equipamento;
    
    
    public Conserto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDescEquipConsert() {
        return descEquipConsert;
    }

    public void setDescEquipConsert(String descEquipConsert) {
        this.descEquipConsert = descEquipConsert;
    }

    public Double getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(Double valorConserto) {
        this.valorConserto = valorConserto;
    }

    public Calendar getDataFoiConserto() {
        return dataFoiConserto;
    }

    public void setDataFoiConserto(Calendar dataFoiConserto) {
        this.dataFoiConserto = dataFoiConserto;
    }

    public Calendar getDataVoltouConserto() {
        return dataVoltouConserto;
    }

    public void setDataVoltouConserto(Calendar dataVoltouConserto) {
        this.dataVoltouConserto = dataVoltouConserto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Conserto other = (Conserto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    

    
}
