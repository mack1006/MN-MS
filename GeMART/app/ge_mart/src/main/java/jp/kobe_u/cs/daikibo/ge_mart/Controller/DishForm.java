package jp.kobe_u.cs.daikibo.ge_mart.Controller;
import lombok.Data;

@Data
public class DishForm {
    String name;
    String recipe;
    String foodstuff;
    int price;
    String cookingTime;
    String photoUrl;
}
