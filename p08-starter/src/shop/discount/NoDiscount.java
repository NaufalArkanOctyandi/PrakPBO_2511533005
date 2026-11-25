package shop.discount;
public class NoDiscount implements DiscountStrategy {
 public long discountFor(long subtotal) { return 0; }
}
