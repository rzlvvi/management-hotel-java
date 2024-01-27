package ManajemenHotel;

public class Kamar {
    private int noKamar;
    private String jenisBed;
    private String kelas;
    private double hargaPerMalam;
    private boolean tersedia;

    public Kamar(int noKamar, String jenisBed, String kelas, double hargaPerMalam) {
        this.noKamar = noKamar;
        this.jenisBed = jenisBed;
        this.kelas = kelas;
        this.hargaPerMalam = hargaPerMalam;
        this.tersedia = true;
    }

    public void displayInfo() {
        System.out.println("Nomor Kamar: " + noKamar);
        System.out.println("Jenis Bed: " + jenisBed);
        System.out.println("Jenis Kelas: " + kelas);
        System.out.println("Harga per Malam: " + hargaPerMalam);
        System.out.println("Status: " + (tersedia ? "Tersedia" : "Tidak Tersedia"));
        System.out.println("-----------------------------");
    }

    public int getNoKamar() {
        return noKamar;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }
}