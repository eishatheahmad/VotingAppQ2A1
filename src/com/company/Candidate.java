package com.company;

import java.util.Scanner;


class Candidate extends User{

    private int voteCount;

    public Candidate()
    {
        super();
        voteCount=0;

    }

    @Override
    void displayInfo() {
        System.out.println("Name:"+getName());
        System.out.println("ID:" +getId());
        System.out.println("Votes:" +getVoteCount());
    }

    void displayNameId()
    {
        System.out.println("Name:"+getName());
        System.out.println("ID:" +getId());
    }

    public Candidate(String nameOfCandidate, int candidateId, int votes)
    {
        super(nameOfCandidate,candidateId);
        this.voteCount=votes;
    }

    //this takes input from user to enter the name, id of candidates assuming the user is candidate
    void setCandidate()
    {
        String buffer;
        int tempInput;

        Scanner in = new Scanner(System.in);

        //System.out. println("You entered string "+s);
        System.out.println("Enter Candidate Name: \n");
        buffer = in. nextLine();
        this.name=buffer;

        System.out.println("Enter numeric candidate ID:\n");
        tempInput= in.nextInt();
        this.id=tempInput-1;
        this.voteCount=0;
    }

    void setCandidate(String name, int id, int totalVotes)
    {
        this.name=name;
        this.id=id;
        this.voteCount=totalVotes;
    }

    public void showCandidates(Candidate[] list,int number)
    {
        for(int i=0; i<number;i++)
        {
            System.out.println(list[i].getName() + list[i].getId() + list[i].getVoteCount());
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

    int getVoteCount(){
        return this.voteCount;
    }

    public void addVote()
    {
        this.voteCount++;
    }
}
