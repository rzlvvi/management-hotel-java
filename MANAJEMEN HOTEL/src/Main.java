import ManajemenHotel.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("user","admin");

        ArrayList<Kamar> daftarKamar = new ArrayList<>();
        daftarKamar.add(new Kamar(1,"Suite","Super VVIP",900));
        daftarKamar.add(new Kamar(2,"Double Bed","VIP",600));
        daftarKamar.add(new Kamar(3,"Single Bed","Standart",399));

        ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
        System.out.println("|==========================================|");
        System.out.println("|              SILAHKAN LOGIN              |");
        System.out.println("|==========================================|");
        System.out.print("Masukkan Username : ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Masukkan Password : ");
        String enteredPassword = scanner.nextLine();

        if(admin.login(enteredUsername, enteredPassword)) {
            System.out.println("Login Berhasil!\n");

            int pilih;
            do{
                System.out.println("|==========================================|");
                System.out.println("|      SELAMAT DATANG DI HOTEL WIKWIK      |");
                System.out.println("|==========================================|\n\n");
                System.out.println("|==========================================|");
                System.out.println("|               MENU UTAMA                 |");
                System.out.println("|==========================================|");
                System.out.println("| 1. Lihat Informasi Kamar                 |");
                System.out.println("| 2. Reservasi Kamar (Check-in)            |");
                System.out.println("| 3. Lihat Detail Reservasi                |");
                System.out.println("| 4. Reservasi Kamar (Check-out)           |");
                System.out.println("| 5. Lihat Jumlah Kamar Yang Tersedia      |");
                System.out.println("| 6. Lihat Data Tamu (Penginap)            |");
                System.out.println("| 0. Keluar(EXIT)                          |");
                System.out.println("|==========================================|\n");
                System.out.print("Pilih Menu : ");
                pilih = scanner.nextInt();

                switch (pilih) {
                    case 1:
                        for (Kamar kamar : daftarKamar) {
                            kamar.displayInfo();
                        }
                        break;
                    case 2:
                        System.out.print("Masukkan Nama Tamu : ");
                        scanner.nextLine();
                        String namaTamu = scanner.nextLine();
                        System.out.print("Masukkan Nomor Kamar : ");
                        int nomorKamar = scanner.nextInt();
                        System.out.print("Masukkan Jenis Pembayaran : ");
                        scanner.nextLine();
                        String jenisPembayaran = scanner.nextLine();
                        Kamar kamarDipesan = cariKamar(daftarKamar, nomorKamar);
                        if (kamarDipesan != null && kamarDipesan.isTersedia()) {
                            kamarDipesan.setTersedia(false);
                            daftarReservasi.add(new Reservasi(namaTamu, nomorKamar, jenisPembayaran));
                            System.out.println("Reservasi Berhasil !");
                        } else {
                            System.out.println("Nomor Kamar Tidak Valid atau Kamar Sudah Tidak Tersedia!");
                        }
                        break;
                    case 3:
                        System.out.print("Masukkan Nomor Kamar : ");
                        int nomorKamarDetail = scanner.nextInt();
                        Kamar kamarDetail = cariKamar(daftarKamar, nomorKamarDetail);
                        if (kamarDetail != null) {
                            for (Reservasi reservasi : daftarReservasi) {
                                if (reservasi.getNoKamar () == nomorKamarDetail) {
                                    reservasi.displayDetail(kamarDetail);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Nomor Kamar Tidak Valid atau Kamar Sudah Tidak Tersedia!");
                        }
                        break;
                    case 4:
                        System.out.print("Masukkan Nomor Kamar : ");
                        int nomorKamarCheckout = scanner.nextInt();
                        Kamar kamarCheckout = cariKamar(daftarKamar, nomorKamarCheckout);
                        if (kamarCheckout != null && !kamarCheckout.isTersedia()) {
                            kamarCheckout.setTersedia(true);
                            System.out.println("Check-out Berhasil!");
                        } else {
                            System.out.println("Nomor Kamar Tidak Valid atau Kamar Sudah Tidak Tersedia!");
                        }
                        break;
                    case 5:
                        int jumlahKamarTersedia = hitungKamarTersedia(daftarKamar);
                        System.out.println("Jumlah Kamar Tersedia : " + jumlahKamarTersedia);
                        break;
                    case 6:
                        for (Reservasi reservasi : daftarReservasi) {
                            System.out.println("Nama Tamu : " + reservasi.getNamaTamu());
                            System.out.println("Nomor Kamar : " + reservasi.getNoKamar());
                            System.out.println("Jenis Pembayaran : " + reservasi.getJenisPembayaran());
                            System.out.println("==========================================");
                        }
                        break;
                    case 0:
                        System.out.println("|==========================================|");
                        System.out.println("|               TERIMA KASIH!              |");
                        System.out.println("|==========================================|");
                        break;
                    default:
                        System.out.println("PILIHAN TIDAK VALID!");
                        break;
                }
            } while (pilih != 0);

        } else {
            System.out.println("Login Gagal ! Username atau Password Salah");
        }
    }

    private static Kamar cariKamar(ArrayList<Kamar> daftarKamar, int nomorKamar) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.getNoKamar() == nomorKamar){
                return kamar;
            }
        }
        return null;
    }

    private static int hitungKamarTersedia(ArrayList<Kamar> daftarKamar) {
        int count = 0;
        for (Kamar kamar : daftarKamar) {
            if (kamar.isTersedia()) {
                count++;
            }
        }
        return count;
    }
}