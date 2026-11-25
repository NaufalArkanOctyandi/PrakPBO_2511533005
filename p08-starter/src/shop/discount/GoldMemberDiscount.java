package shop.discount;
public class GoldMemberDiscount implements DiscountStrategy {
 private final int percent;
 public GoldMemberDiscount(int percent) { this.percent = percent; }
 public long discountFor(long subtotal) { return subtotal * percent / 100; }
}
