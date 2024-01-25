package shop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import shop.StockApplication;
import shop.domain.StockDecreased;
import shop.domain.StockIncreased;

@Entity
@Table(name = "Stock_table")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer stock;

    public static void decreaseStock(DeliveryStarted deliveryStarted) {
        repository()
            .findById(deliveryStarted.getId())
            .ifPresent(stock -> {
                stock.stock -= deliveryStarted.getQty();
                repository().save(stock);
            });
    }
    //other class contents
}
