package tdi.bootcamp.jpa;

import org.hibernate.Session;
import tdi.bootcamp.jpa.model.*;

import tdi.bootcamp.jpa.util.HibernateUtil;

import java.sql.Timestamp;
import java.util.*;

public class MainPerpus {

	private static String getNativeQuery(Session session, String sql){
		return (String) session.createNativeQuery(sql).getSingleResult();
	}

//	========== SIMPAN PERPUSTAKAAN DAN BUKU BUKU YG ADA =========
	public static Integer simpanSemua(Session session){
		Perpustakaan perpus = new Perpustakaan();
		perpus.setIdPerpus(1);
		perpus.setNamaPerpus("Perpustakaan Jawa Barat");

		Peminjam peminjam = new Peminjam();
		peminjam.setPerpustakaan(perpus);
		peminjam.setNamaPeminjam("Astari");
		peminjam.setAlamat("GBA 2");

		List<Buku> daftarBuku = new ArrayList<>();
		for(int i=1; i<3; i++){
			Buku buku = new Buku();
			buku.setJudulBuku("Winnie The Pooh " + i);
			buku.setPengarang("Robin Hood " + i);
			buku.setPerpustakaan(perpus);
			buku.setPinjam(true);
			buku.setIdEntry("Baru");
			buku.setPeminjam(peminjam);
			buku.setTglEntry(new Timestamp(System.currentTimeMillis()));
			daftarBuku.add(buku);
		}

		peminjam.setDaftarBuku(daftarBuku);

		return (Integer) session.save(peminjam);
	}

	private static Integer simpanPeminjam(Session session){
		Peminjam peminjam = new Peminjam();
		peminjam.setNamaPeminjam("Astri");
		peminjam.setAlamat("Baturaden");

		List<Buku> daftarBuku = new ArrayList<>();
		for(int i=1; i<3; i++){
			Buku buku = new Buku();
			buku.setJudulBuku("Winnie The Pooh " + i);
			buku.setPengarang("Robin Hood " + i);
			buku.setPinjam(true);
			buku.setIdEntry("Baru");
			buku.setPeminjam(peminjam);
			buku.setTglEntry(new Timestamp(System.currentTimeMillis()));
			daftarBuku.add(buku);
		}
		peminjam.setDaftarBuku(daftarBuku);



//		peminjam.setDaftarBuku(daftarBuku);

		return (Integer) session.save(peminjam);
	}


	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();
//		String result = getNativeQuery(session, "select version()");

//		MainPerpus.simpanPeminjam(session);
		MainPerpus.simpanSemua(session);

		session.flush();


		session.close();

		HibernateUtil.shutdown();
	}
}