public class AkunBank {

    private String nomorRekening;
    private double saldo;
    private double totalTransferHariIni;

    private final double LIMIT_HARIAN = 10000000;

    public AkunBank(String nomorRekening, double saldo) {

        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariIni = 0;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void tarikTunai(double nominal)
            throws SaldoTidakMencukupiException {

        if (nominal > saldo) {

            double kurang = nominal - saldo;

            throw new SaldoTidakMencukupiException(
                    "Saldo tidak mencukupi!",
                    kurang);
        }

        saldo -= nominal;

        System.out.println(
                "Tarik tunai berhasil. Sisa saldo: Rp" + saldo);
    }

    public void transfer(
            AkunBank tujuan,
            double nominal)
            throws SaldoTidakMencukupiException,
            BatasTransferHarianException {

        if (nominal > saldo) {

            double kurang = nominal - saldo;

            throw new SaldoTidakMencukupiException(
                    "Saldo tidak mencukupi untuk transfer!",
                    kurang);
        }

        if (totalTransferHariIni + nominal > LIMIT_HARIAN) {

            throw new BatasTransferHarianException(
                    "Transfer melebihi batas harian Rp10.000.000");
        }

        saldo -= nominal;
        tujuan.saldo += nominal;
        totalTransferHariIni += nominal;

        System.out.println(
                "Transfer berhasil ke rekening "
                        + tujuan.getNomorRekening());
    }
}