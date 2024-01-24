package shop.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shop.domain.*;

@Component
public class StockHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Stock>> {

    @Override
    public EntityModel<Stock> process(EntityModel<Stock> model) {
        return model;
    }
}
