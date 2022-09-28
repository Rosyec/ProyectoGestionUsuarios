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
@Table(name = "admin")
@NamedQueries({
    @NamedQuery(name = "AdminBEAN.findAll", query = "SELECT a FROM AdminBEAN a"),
    @NamedQuery(name = "AdminBEAN.findByIdadmin", query = "SELECT a FROM AdminBEAN a WHERE a.idadmin = :idadmin"),
    @NamedQuery(name = "AdminBEAN.findByEmail", query = "SELECT a FROM AdminBEAN a WHERE a.email = :email"),
    @NamedQuery(name = "AdminBEAN.findByPassword", query = "SELECT a FROM AdminBEAN a WHERE a.password = :password")})
public class AdminBEAN implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idadmin;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    private String email;
    @Size(max = 45)
    private String password;

    public AdminBEAN() {
    }

    public AdminBEAN(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public AdminBEAN(String email) {
        this.email = email;
    }
    

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadmin != null ? idadmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminBEAN)) {
            return false;
        }
        AdminBEAN other = (AdminBEAN) object;
        if ((this.idadmin == null && other.idadmin != null) || (this.idadmin != null && !this.idadmin.equals(other.idadmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.AdminBEAN[ idadmin=" + idadmin + " ]";
    }
    
}
