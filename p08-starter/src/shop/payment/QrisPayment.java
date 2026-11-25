package shop.payment;
import shop.exception.PaymentFailedException;
public class QrisPayment implements PaymentMethod {
 public String name(){return "QRIS";}
 public void pay(long amount) throws PaymentFailedException {
  if(amount>10_000_000L) throw new PaymentFailedException("transaksi QRIS maksimal Rp10.000.000");
 }
}
