package ManajemenHotel;

public class Reservasi {
    private String namaTamu;
    private int noKamar;
    private String jenisPembayaran;


    public Reservasi(String namaTamu, int noKamar, String jenisPembayaran) {
        this.namaTamu = namaTamu;
        this.noKamar = noKamar;
        this.jenisPembayaran = jenisPembayaran;
    }

    public void displayDetail(Kamar kamar) {
        System.out.println("Detail Reservasi: ");
        System.out.println("Nama Tamu: " + namaTamu);
        System.out.println("Nomor Kamar: " + noKamar);
        System.out.println("Jenis Pembayaran: " + jenisPembayaran);
        System.out.println("Total Harga: " + kamar.getHargaPerMalam());
        System.out.println("-----------------------------");
    }

    public String getNamaTamu() {
        return namaTamu;
    }

    public int getNoKamar() {
        return noKamar;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

}