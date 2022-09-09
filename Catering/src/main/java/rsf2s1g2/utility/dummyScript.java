package rsf2s1g2.utility;

import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;

public class dummyScript {

    public static Order DummyOrderData(){
        Order O = new Order();
        O.addOrder("Lee Wee Yan", "2021-7-12", "0177255766", 15.12);
        O.addOrder("Cheong Tzen Yang", "2022-5-1", "0177255766", 10003.12);
        O.addOrder("Tam Ga Men", "2020-1-1", "0177255766", 20.12);
        O.addOrder("BC", "2019-4-1", "0177255766", 20.12);
        O.addOrder("Tan Cherng Ming", "2012-8-1", "0175125766", 1020.12);
        
        return O;
    }

}