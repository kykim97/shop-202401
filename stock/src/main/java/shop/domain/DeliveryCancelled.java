package shop.domain;

import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private String address;
    private String customerId;
    private Integer qty;
    private String orderId;
}
