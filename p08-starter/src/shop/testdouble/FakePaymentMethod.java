package shop.testdouble;
import shop.payment.PaymentMethod;
import shop.exception.PaymentFailedException;
public class FakePaymentMethod implements PaymentMethod {
 private long lastAmount; private int callCount;
 public String name(){return "Fake";}
 public void pay(long amount) throws PaymentFailedException {lastAmount=amount;callCount++;}
 public long getLastAmount(){return lastAmount;}
 public int getCallCount(){return callCount;}
}
