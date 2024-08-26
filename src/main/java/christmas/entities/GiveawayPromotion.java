package christmas.entities;

public class GiveawayPromotion {
    private final int price;

    public GiveawayPromotion(int price) {
        this.price = price;
    }

    public boolean isPromotion() {
        return this.price >= 120_000;
    }

    public int getPrice() {
        if (!isPromotion()){
            return 0;
        }
        return Menu.priceOfMenu.get("샴페인");
    }
}
