package tdi.bootcamp.jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "peminjam", schema = "public")
public class Peminjam extends BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_peminjam", updatable = false, nullable = false)
    private Integer idPeminjam;

    @Column(name = "nama_peminjam", length = 50)
    private String namaPeminjam;

    @Column(name = "alamat", length = 50)
    private String alamat;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "peminjam")
    private List<Buku> daftarBuku;

    @OneToOne
    @JoinColumn(name = "nama_buku")
    private Buku buku;

    @Embedded
    private Perpustakaan perpustakaan;

    public Perpustakaan getPerpustakaan() {
        return perpustakaan;
    }

    public void setPerpustakaan(Perpustakaan perpustakaan) {
        this.perpustakaan = perpustakaan;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Integer getIdPeminjam() {
        return idPeminjam;
    }

    public void setIdPeminjam(Integer idPeminjam) {
        this.idPeminjam = idPeminjam;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public void setDaftarBuku(List<Buku> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }
}