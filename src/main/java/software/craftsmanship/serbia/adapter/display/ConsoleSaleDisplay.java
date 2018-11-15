package software.craftsmanship.serbia.adapter.display;

import software.craftsmanship.serbia.impl.display.*;
import software.craftsmanship.serbia.impl.display.message.*;

public class ConsoleSaleDisplay implements SaleDisplay {

    @Override
    public void display(Message message) {
        System.out.println(message.getFormattedMessage());
    }

}
