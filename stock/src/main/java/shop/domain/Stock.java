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
//<<< DDD / Aggregate Root
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer stock;

    @PostPersist
    public void onPostPersist() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static StockRepository repository() {
        StockRepository stockRepository = StockApplication.applicationContext.getBean(
            StockRepository.class
        );
        return stockRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseStock(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(DeliveryCancelled deliveryCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancelled.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
