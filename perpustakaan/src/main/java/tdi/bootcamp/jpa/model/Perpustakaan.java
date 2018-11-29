package tdi.bootcamp.jpa.model;

import javax.persistence.*;
import java.sql.Timestamp;

//@MappedSuperclass
@Embeddable
//@Entity
@Table(name = "perpustakaan", schema = "public")
public class Perpustakaan {

    @Column(name = "id_perpus", updatable = false, nullable = false)
    private Integer idPerpus;

    @Column(name = "nama_perpus", length = 100)
    private String namaPerpus;

    public Integer getIdPerpus() {
        return idPerpus;
    }

    public void setIdPerpus(Integer idPerpus) {
        this.idPerpus = idPerpus;
    }

    public String getNamaPerpus() {
        return namaPerpus;
    }

    public void setNamaPerpus(String namaPerpus) {
        this.namaPerpus = namaPerpus;
    }
}