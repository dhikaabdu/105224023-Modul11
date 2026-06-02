public class Main {

    public static void main(String[] args) {

        AkunBank nasabahA =
                new AkunBank("1234567890", 15000000);

        AkunBank nasabahB =
                new AkunBank("0987654321", 2500000);

        try {

            System.out.println("===== ATM DIGITAL BANK PERTAMINA =====");

            nasabahA.transfer(nasabahB, 3000000);

            nasabahA.transfer(nasabahB, 4500000);

            nasabahA.transfer(nasabahB, 3500000);

        }

        catch (SaldoTidakMencukupiException e) {

            System.out.println("[ERROR SALDO]");
            System.out.println(e.getMessage());
            System.out.println("Kekurangan : Rp" +
                    e.getKekuranganSaldo());

        }

        catch (BatasTransferHarianException e) {

            System.out.println("[ERROR LIMIT TRANSFER]");
            System.out.println(e.getMessage());

        }

        finally {

            System.out.println("\nStruk Digital:");
            System.out.println("Sesi transaksi ATM Anda telah diakhiri.");
            System.out.println("Kartu dikeluarkan otomatis.");
        }
    }
}