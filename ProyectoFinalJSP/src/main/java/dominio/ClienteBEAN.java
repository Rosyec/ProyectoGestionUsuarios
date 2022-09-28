/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author chech
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "ClienteBEAN.findAll", query = "SELECT c FROM ClienteBEAN c"),
    @NamedQuery(name = "ClienteBEAN.findByIdcliente", query = "SELECT c FROM ClienteBEAN c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "ClienteBEAN.findByNombre", query = "SELECT c FROM ClienteBEAN c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "ClienteBEAN.findByApellido", query = "SELECT c FROM ClienteBEAN c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "ClienteBEAN.findByEmail", query = "SELECT c FROM ClienteBEAN c WHERE c.email = :email"),
    @NamedQuery(name = "ClienteBEAN.findByTelefono", query = "SELECT c FROM ClienteBEAN c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "ClienteBEAN.findBySaldo", query = "SELECT c FROM ClienteBEAN c WHERE c.saldo = :saldo")})
public class ClienteBEAN implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idcliente;
    @Size(max = 45)
    private String nombre;
    @Size(max = 45)
    private String apellido;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    private String email;
    @Size(max = 45)
    private String telefono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double saldo;

    public ClienteBEAN() {
    }

    public ClienteBEAN(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteBEAN)) {
            return false;
        }
        ClienteBEAN other = (ClienteBEAN) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.ClienteBEAN[ idcliente=" + idcliente + " ]";
    }
    
}
