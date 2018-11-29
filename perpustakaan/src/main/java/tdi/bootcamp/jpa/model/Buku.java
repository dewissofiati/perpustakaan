package tdi.bootcamp.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "Buku", schema = "public")
public class Buku extends BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_buku", updatable = false, nullable = false)
    private Integer idBuku;

    @Column(name = "judul_buku", length = 50)
    private String judulBuku;

    @Column(name = "pengarang_buku", length = 50)
    private String pengarang;

    @Column(name = "status_pinjaman")
    private boolean pinjam;

    @OneToOne
    @JoinColumn(name = "id_peminjam")
    private Peminjam peminjam;

    @Embedded
    private Perpustakaan perpustakaan;

    public Perpustakaan getPerpustakaan() {
        return perpustakaan;
    }

    public void setPerpustakaan(Perpustakaan perpustakaan) {
        this.perpustakaan = perpustakaan;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public boolean isPinjam() {
        return pinjam;
    }

    public void setPinjam(boolean pinjam) {
        this.pinjam = pinjam;
    }

    public Peminjam getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(Peminjam peminjam) {
        this.peminjam = peminjam;
    }
}