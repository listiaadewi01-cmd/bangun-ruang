import java.util.Scanner;

abstract class BangunRuang {
    protected String nama;
    
    public BangunRuang(String nama) {
        this.nama = nama;
    }
    
    public abstract double hitungVolume();
    public abstract double hitungLuasPermukaan();
    
    public void tampilkanInfo() {
        System.out.println("\n=== Hasil Perhitungan " + nama + " ===");
        System.out.printf("Volume: %.2f satuan kubik\n", hitungVolume());
        System.out.printf("Luas Permukaan: %.2f satuan persegi\n", hitungLuasPermukaan());
    }
}

class Balok extends BangunRuang {
    private double panjang;
    private double lebar;
    private double tinggi;
    
    public Balok(double panjang, double lebar, double tinggi) {
        super("Balok");
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }
    
    @Override
    public double hitungVolume() {
        return panjang * lebar * tinggi;
    }
    
    @Override
    public double hitungLuasPermukaan() {
        return 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }
}

class Kubus extends BangunRuang {
    private double sisi;
    
    public Kubus(double sisi) {
        super("Kubus");
        this.sisi = sisi;
    }
    
    @Override
    public double hitungVolume() {
        return Math.pow(sisi, 3);
    }
    
    @Override
    public double hitungLuasPermukaan() {
        return 6 * Math.pow(sisi, 2);
    }
}

class Bola extends BangunRuang {
    private double jariJari;
    
    public Bola(double jariJari) {
        super("Bola");
        this.jariJari = jariJari;
    }
    
    @Override
    public double hitungVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(jariJari, 3);
    }
    
    @Override
    public double hitungLuasPermukaan() {
        return 4 * Math.PI * Math.pow(jariJari, 2);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean lanjut = true;
        
        System.out.println("============================================");
        System.out.println("  PROGRAM PERHITUNGAN BANGUN RUANG 3D");
        System.out.println("============================================");
        
        while (lanjut) {
            System.out.println("\n=== Menu Bangun Ruang ===");
            System.out.println("1. Balok");
            System.out.println("2. Kubus");
            System.out.println("3. Bola");
            System.out.println("4. Keluar");
            System.out.print("Pilih bangun ruang (1-4): ");
            
            int pilihan = input.nextInt();
            
            switch (pilihan) {
                case 1:
                    hitungBalok(input);
                    break;
                case 2:
                    hitungKubus(input);
                    break;
                case 3:
                    hitungBola(input);
                    break;
                case 4:
                    lanjut = false;
                    System.out.println("\n============================================");
                    System.out.println("  Terima kasih telah menggunakan program!");
                    System.out.println("============================================");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid! Silakan pilih 1-4.");
            }
        }
        
        input.close();
    }
    
    private static void hitungBalok(Scanner input) {
        System.out.println("\n--- Input Data Balok ---");
        System.out.print("Masukkan panjang: ");
        double panjang = input.nextDouble();
        System.out.print("Masukkan lebar: ");
        double lebar = input.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi = input.nextDouble();
        
        Balok balok = new Balok(panjang, lebar, tinggi);
        balok.tampilkanInfo();
    }
    
    private static void hitungKubus(Scanner input) {
        System.out.println("\n--- Input Data Kubus ---");
        System.out.print("Masukkan panjang sisi: ");
        double sisi = input.nextDouble();
        
        Kubus kubus = new Kubus(sisi);
        kubus.tampilkanInfo();
    }
    
    private static void hitungBola(Scanner input) {
        System.out.println("\n--- Input Data Bola ---");
        System.out.print("Masukkan jari-jari: ");
        double jariJari = input.nextDouble();
        
        Bola bola = new Bola(jariJari);
        bola.tampilkanInfo();
    }
}