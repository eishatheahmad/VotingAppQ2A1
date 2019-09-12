package com.company;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;


//for testing the whole code
public class Main {

    static void castVote(Voter currentVoter, int index,int numberOfCandidates, Candidate[] listCandidates)
    {
        if(!currentVoter.hasAlreadyVoted())
        {
            System.out.println("\nPlease cast your Vote:");
            System.out.println("Here is the list of Candidates.\n");
            for(int k=0; k<numberOfCandidates;k++)
            {
                listCandidates[k].displayNameId();
            }

            System.out.println("Enter the corresponding ID to cast your vote:");
            Scanner castVote= new Scanner(System.in);
            int enteredID= castVote.nextInt()-1;

            System.out.println("You voted for:");
            listCandidates[enteredID].displayNameId();
            listCandidates[enteredID].addVote();
            currentVoter.hasVotedNow();

        }
        else
        {
            System.out.println("You have already cast your vote. Wait for results now.");
        }
    }

    //calculates the result of the election
    static int calculateResult(Candidate[] list, int number)
    {
        int temp=0;
        for(int i=0; i<number-1;i++)
        {
            if(list[i].getVoteCount()<list[i+1].getVoteCount())
            {
                temp=i+1;
            }
        }

        return temp;
    }


    //setting the candidates, displaying them, getting voters registered and casting the vote
    static void votingProcess()
    {
        final int numberOfCandidates=3;
        final int numberOfVoters=2;

        Candidate[] listOfCandidates= new Candidate[numberOfCandidates];

        for(int i=0; i<numberOfCandidates;i++)
        {
            listOfCandidates[i]=new Candidate();
        }

        listOfCandidates[0].setCandidate("Pervaiz Musharraf",1,0);
        listOfCandidates[1].setCandidate("Imran Khan",2,0);
        listOfCandidates[2].setCandidate("Nawaz Sharif",3,0);

        for(int i=0; i<numberOfCandidates;i++)
        {
            listOfCandidates[i].displayNameId();
        }

        //first register all voters
        Voter[] listOfVoters= new Voter[numberOfVoters];

        boolean flag=false;
        for(int i=0; i<numberOfVoters;i++)
        {
           listOfVoters[i]=new Voter();
           listOfVoters[i].setVoter();

           for(int k=0;k<i;k++)
           {
               if(listOfVoters[k].getId() == listOfVoters[i].getId())
               {
                   flag=true;
                   break;
               }
           }

           if(flag)
           {
               System.out.println("Voter ID" +listOfVoters[i].getId() + " already exists. Enter Correct ID, Name and Details:");
               listOfVoters[i].setVoter();
               flag=false;
           }

            //call cast vote
            castVote(listOfVoters[i],i,numberOfCandidates,listOfCandidates);

        }

        int winnerId= calculateResult(listOfCandidates,numberOfCandidates);
        System.out.println("\n\nWINNER OF ELECTION IS: ");
        listOfCandidates[winnerId].displayInfo();


        //works after 6 pm
        for(int i=0; i<numberOfVoters;i++)
        {
            listOfVoters[i].electionNotification= new SMS();
            listOfVoters[i].electionNotification.sendMessage();
        }

    }



    public static void main(String[] args) {
	// write your code here
        votingProcess();


    }
}
