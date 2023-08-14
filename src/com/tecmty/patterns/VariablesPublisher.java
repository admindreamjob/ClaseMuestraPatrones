package com.tecmty.patterns;

import java.util.ArrayList;
import java.util.List;

public class VariablesPublisher {
     List<VariableSuscriber> suscribers = new ArrayList<>();
     Variable variable = new Variable();

     public void suscribe(VariableSuscriber suscriber){
            if(!suscribers.contains(suscriber)) {
                suscribers.add(suscriber);
            }
     }

    public void unSuscribe(VariableSuscriber suscriber){
         suscribers.remove(suscriber);

    }

    public synchronized void updateVariable(Variable variable){
          this.variable = variable;
          notifySuscribers();
    }

    public void notifySuscribers(){
        for(VariableSuscriber suscriber : suscribers){
            suscriber.update(variable);
        }
    }
}
