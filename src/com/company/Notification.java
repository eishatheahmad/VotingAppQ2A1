package com.company;

import java.time.LocalTime;

abstract class Notification
{
    String notificationMessage;

    Notification()
    {
        notificationMessage=null;
    }
    abstract void sendMessage();
    boolean isItSixPm()
    {
        LocalTime currentTime= LocalTime.now();
        LocalTime limit= LocalTime.parse("18:00");
        boolean isItTimeNow= currentTime.isAfter(limit);

        if(isItTimeNow) {
            return true;
        }
        else
            return false;

    }


}
