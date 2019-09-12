package com.company;

import java.util.Random;
import java.util.Scanner;

class Voter extends User {

    private boolean hasVoted;
    Notification electionNotification;

    private static int countOfVoters; //just to maintain the number of voting processes that took place


    public Voter(String name, int id, boolean hasUserVoted)
    {

        super(name,id);
        this.hasVoted=hasUserVoted;
        Random rand = new Random();
        int temp=rand.nextInt(2);

        if(temp==0)
        {
            electionNotification=new SMS();
        }
        else
        {
            electionNotification=new Email();
        }
        ;

    }

    void getNotified()
    {
        electionNotification.sendMessage();
    }

   Voter() {
        super();
        hasVoted=false;


    }

    //true means has voted, false means not voted yet
    public void hasVotedNow()
    {
        this.hasVoted=true;
    }

    @Override
    void displayInfo() {
        System.out.println("Name:"+ getName());
        System.out.println("ID:"+ getId());
        System.out.println("Voting Status:" + hasAlreadyVoted());
    }

    //takes input for voter and their details
    void setVoter()
    {
        this.countOfVoters++;
        System.out.println("\n\nVoting Process# "+countOfVoters);


        Scanner input= new Scanner(System.in);
        System.out.println("Enter your Name:");
        String buffer= input.nextLine();
        this.name=buffer;

        System.out.println("Enter your numeric ID:");
        int temp= input.nextInt();
        this.id=temp;


        System.out.println("Have you already cast your vote: Enter Y for yes and N for no: ");
        Scanner enter= new Scanner(System.in);
        String verify= enter.nextLine();

        if(verify.equals("Y") || verify.equals("y"))
        {
            this.hasVoted=true;
        }
        else
        {
            this.hasVoted=false;
        }


    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    int getId() {
        return this.id;
    }

    boolean hasAlreadyVoted(){
        return this.hasVoted;
    }


}
