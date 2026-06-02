public class Main {

    public static void main(String[] args) {

        Pelanggan pelanggan = new Pelanggan();
        MesinKasir kasir = new MesinKasir();

        try {

            pelanggan.daftarMember(15);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        try {

            pelanggan.pesanKopi(10);

        } catch (KopiHabisException e) {

            System.out.println(e.getMessage());
        }

        try {

            kasir.bayar(50000, 30000);

        } catch (UangKurangException e) {

            System.out.println(e.getMessage());
        }

        try {

            kasir.cetakStruk(false);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println(
                "Terima kasih telah berkunjung ke Cafe Java Bean. Program kasir ditutup."
            );
        }
    }
}