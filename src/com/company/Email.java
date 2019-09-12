package com.company;

class Email extends Notification
{

    Email()
    {
        super();
    }

    @Override
    void sendMessage() {
        if(isItSixPm())
        {
            System.out.println("EMAIL: Voting time has ended! Wait for results now.");
        }
        else
        {
            System.out.println("It isnt time yet");
        }
    }
}
