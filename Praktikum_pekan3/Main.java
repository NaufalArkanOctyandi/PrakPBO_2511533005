package Praktikum_pekan3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Rekening> daftarRekening = new ArrayList<>();
        Rekening akunAktif = null;
        boolean isRunning = true;

        System.out.println("=== SISTEM PERBANKAN MINI ===");
        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Buka Rekening Baru");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Cek Informasi Rekening");
            System.out.println("5. Ganti Akun");
            System.out.println("6. Cetak Mutasi(Riwayat)");
            System.out.println("0. Keluar");
            System.out.println("Pilih menu:");
            
            int pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                	System.out.print("Masukkan PIN: ");
                    String PIN = input.nextLine();
                    while (!PIN.matches("\\d{6}")) {
                    	System.out.println("PIN Harus terdiri dari 6 angka");
                    	
                    	System.out.println("Masukkan PIN (Harus 6 angka)");
                    	PIN = input.nextLine();
                    }
                    System.out.print("Masukkan No Rekening: ");
                    String no = input.nextLine();
                    System.out.print("Masukkan Nama Pemilik: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Saldo Awal: ");
                    double saldo = input.nextDouble();
                    input.nextLine();
                    
                    Rekening rekeningBaru = new Rekening(no, nama, saldo, PIN);
                    
                    daftarRekening.add(rekeningBaru);

                    akunAktif = rekeningBaru;

                    break;
                case 2:
                    if (akunAktif == null) {
                        System.out.println("Error: Mohon maaf, Anda belum memiliki nomor rekening!");
                    } else {
                        System.out.print("Masukkan nominal setor: ");
                        double setor = input.nextDouble();
                        input.nextLine();
                        akunAktif.setorTunai(setor);
                    }
                    break;
                case 3:
                    if (akunAktif == null) {
                        System.out.println("Error: Anda belum memiliki rekening aktif!");
                    } else {
                    	System.out.print("Masukkan PIN: ");
                    	String pin = input.nextLine();
                    	if (akunAktif.otentikasi(pin)) {
                    		System.out.println("Masukkan nominal tarik: ");
                            double tarik = input.nextDouble();
                            input.nextLine();
                            akunAktif.tarikTunai(tarik);
                    	} else {
                    		System.out.println("Akses Ditolak: PIN yang anda masukkan Salah!");
                    	}
                    }
                    break;
                case 4:
                    if (akunAktif == null) {
                        System.out.println("Error: Anda belum membuka rekening!");
                    } else {
                        akunAktif.cekInformasi();
                    }
                    break;
                case 5:
                    if (daftarRekening.isEmpty()) {
                        System.out.println("Error: Belum ada rekening yang terdaftar!");
                    } else {
                        System.out.print("Masukkan nomor rekening: ");
                        String nomorCari = input.nextLine();
                        Rekening rekeningDitemukan = null;
                        for (Rekening rekening : daftarRekening) {
                            if (rekening.getNomorRekening().equals(nomorCari)) {
                                rekeningDitemukan = rekening;
                                break;
                            }
                        }
                        if (rekeningDitemukan != null) {
                            akunAktif = rekeningDitemukan;
                            System.out.println("Berhasil mengganti akun aktif ke rekening " + akunAktif.getNomorRekening());
                        } else {
                            System.out.println(
                                "Error: Nomor rekening tidak ditemukan!"
                            );
                        }
                    }
                    break;
                case 6:
                	if (akunAktif == null) {
                		System.out.println("Error: Anda belum membuka rekening!");
                	} else {
                		System.out.print("Masukkan PIN: ");
                    	String pin = input.nextLine();
                		if (akunAktif.otentikasi(pin)) {
                			akunAktif.cetakMutasi();
                		} else {
                			System.out.println("Akses Ditolak: PIN yang anda masukkan Salah!");
                		}
                		
                	}
                	break;
                case 0:
                    isRunning = false;
                    System.out.println("Sistem ditutup. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        input.close();
    }
}