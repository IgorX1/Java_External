package com.javacourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TelephonyServiceController {
    private List<Tariff> tariffs;
    private List<Client> clients;

    public TelephonyServiceController() {
        fillBasicSetOfClients();
        fillBasicSetOfTariffs();
    }

    private void fillBasicSetOfClients(){
        clients.addAll(Arrays.asList(
            new Client("Ivan Ivanov", GeneralTariff.INSTANCE),
            new Client("John Thomson", BusinessTariff.INSTANCE),
            new Client("Eliza White", FeedInTariff.INSTANCE)
        ));
    }

    private void fillBasicSetOfTariffs(){
        tariffs.addAll(Arrays.asList(
             BusinessTariff.INSTANCE,
             GeneralTariff.INSTANCE,
             FeedInTariff.INSTANCE
        ));
    }

    int getTotalNumberOfClients(){
        return clients.size();
    }

    List<Tariff> getSorsetTariffListByPrice(){
        List<Tariff> sortedList = new ArrayList<>(tariffs);
        Collections.sort(sortedList,
                (x1, x2)-> (int)(x1.pricePerMonth-x2.pricePerMonth));
        return sortedList;
    }

    List<Tariff> getTariffsByPriceLimits(double minPrice, double maxPrice){
        List<Tariff> result = new ArrayList<>();
        tariffs.forEach(x->{
            if(doesPriceCorrespondToPriceLimits(x.pricePerMonth, minPrice, maxPrice)){
                result.add(x);
            }
        });
        return result;
    }

    boolean doesPriceCorrespondToPriceLimits(double actual, double min, double max){
        if(actual>=min && actual<=max)
            return true;
        else return false;
    }
}
