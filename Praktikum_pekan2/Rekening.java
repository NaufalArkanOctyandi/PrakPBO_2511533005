package Praktikum_pekan2;
import java.util.ArrayList;

public class Rekening {
    String nomorRekening;
    String namaPemilik;
    double saldo;
    
    // Implementasi Asosiasi (1-to-many)
    ArrayList<Transaksi> riwayatTransaksi;
    
    public Rekening(String nomor, String nama, double saldoAwal) {
        this.nomorRekening = nomor;
        this.namaPemilik = nama;
        this.saldo = saldoAwal;
        
        // wajib menginisialisasi Arraylist di dalam constructor agar tidak NullPointerException
        this.riwayatTransaksi = new ArrayList<>();
        
        System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat. ");
        
    }
    public void setorTunai(double nominal) {
        if (nominal > 0) {
            saldo += nominal;
            //merekam riwayat (.Pembuatan objek Transaksi di dalam method)
            String idTrx = "TRX-S" + System.currentTimeMillis();
            Transaksi trxBaru = new Transaksi(idTrx, "Kredit", nominal);
            riwayatTransaksi.add(trxBaru);
            
            System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo saat ini: Rp" + saldo
            );
        } else {
            System.out.println("Gagal: Nominal setor harus lebih dari 0!"
            );
        }
    }
    public void tarikTunai(double nominal) {
        if (nominal < 0) {
            System.out.println("Transaksi Gagal: Nominal penarikan minimal Rp10.000."
            );
        } else if (nominal > saldo) {
            System.out.println("Transaksi Gagal: Saldo tidak mencukupi. " + "Saldo Anda: Rp" + saldo
            );
        } else {
            saldo -= nominal;
            String idTrx = "TRX-T" + System.currentTimeMillis();
            Transaksi TrxBaru = new Transaksi(idTrx, "Debit", nominal); 
            riwayatTransaksi.add(TrxBaru);
            System.out.println("Tarik tunai Rp" + nominal + " berhasil. Saldo saat ini: Rp" + saldo
            );
        }
    }
    public void cetakMutasi() {
    	if (riwayatTransaksi.isEmpty()) {
    		System.out.println("Belum Ada Transaksi Pada Akun Ini ");
    	} else {
    		for (Transaksi transaksi : riwayatTransaksi) {
    			transaksi.cetakDetail();
    		}
    	}
    }
    public void cekInformasi() {
        System.out.println("\n--- INFO REKENING ---");
        System.out.println("No. Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik : " + namaPemilik);
        System.out.println("Saldo Akhir  : Rp" + saldo);
        System.out.println("---------------------");
    }
}