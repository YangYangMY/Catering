package rsf2s1g2.utility;

import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;

public class DummyScript {

    public static void DummyOrderData(CircularQueueInterface<Order> orderQueue){
        Order item1 =new Order("Lee Wee Yan", "2021-7-12", "0177255766", 15.12
        );
        Order item2 =new Order("Cheong Tzen Yang", "2022-5-1", "0177255766", 10003.12
        );
        Order item3 =new Order("Tam Ga Men", "2020-1-1", "0177255766", 20.12
        );
        Order item4 =new Order("BC", "2019-4-1", "0177255766", 20.12
        );
        Order item5 =new Order("Tan Cherng Ming", "2012-8-1", "0175125766", 1020.12
        );

        orderQueue.enqueue(item1);
        orderQueue.enqueue(item2);
        orderQueue.enqueue(item3);
        orderQueue.enqueue(item4);
        orderQueue.enqueue(item5);
    }

}