package com.company;

class SMS extends Notification
{

    SMS()
    {
        super();
    }

    @Override
    void sendMessage() {

        if(isItSixPm())
        {
            System.out.println("SMS: Voting time has ended! Wait for results now.");
        }

    }
}
