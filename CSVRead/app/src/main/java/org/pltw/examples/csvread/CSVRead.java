package org.pltw.examples.csvread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class CSVRead extends MainActivity {
    public ArrayList<String> eBirdSpecNum = new ArrayList<String>();
    public ArrayList<String> sort = new ArrayList<String>();
    public ArrayList<String> category = new ArrayList<String>();
    public ArrayList<String> englishName = new ArrayList<String>();
    public ArrayList<String> scientificName = new ArrayList<String>();
    public ArrayList<String> range = new ArrayList<String>();
    public ArrayList<String> order = new ArrayList<String>();
    public ArrayList<String> family = new ArrayList<String>();
    public ArrayList<String> speciesGroup = new ArrayList<String>();
    public int birdInQuestion;
    public int pos;
    public String checker;
    public int position1;
    public int position2;
    public CSVRead() throws Exception{
        BufferedReader CSVFile = new BufferedReader(new FileReader("birds.csv"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null) {
            String[] dataArray = dataRow.split(",");
            eBirdSpecNum.add(dataArray[0]);
            sort.add(dataArray[1]);
            category.add(dataArray[2]);
            englishName.add(dataArray[3]);
            scientificName.add(dataArray[4]);
            range.add(dataArray[5]);
            order.add(dataArray[6]);
            family.add(dataArray[7]);
            speciesGroup.add(dataArray[8]);
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
        System.out.println();
        System.out.println("Hello! I'm Birdbot, your BirdSearch application.");
        Scanner in = new Scanner(System.in);
        System.out.println("wanna talk about birds?");
        String input = in.nextLine();
        if (findKeyword(input, "yes", 0) >= 0 || findKeyword(input, "sure", 0) >= 0 || findKeyword(input, "yeah", 0) >= 0) {
            System.out.println("Awesome!");
        } else if (findKeyword(input, "Tell me about the", 0) >= 0 || findKeyword(input, "know about the", 0) >= 0 || findKeyword(input, "learn about the", 0) >= 0 || findKeyword(input, "hear about the", 0) >= 0) {
            TellMeProtocol(input);
        } else {
            System.out.println("TOO BAD! We're talking about birds!");
        }
        System.out.println("So do you have a specific bird to talk about or do you have a characteristic you want to find out which birds are in?");
        Prompt();
    }
    private void Prompt () {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (findKeyword(input, "tell me about a random bird", 0) >= 0 || findKeyword(input, "give me a random bird", 0) >= 0 || findKeyword(input, "show me a random bird", 0) >= 0) {
            int RandomBird = (int)(Math.random()*34325);
            System.out.println("Okay, here's a bird I really like! The " + iterateUp(englishName, RandomBird).toLowerCase() + " belongs to the " + speciesGroup.get(RandomBird) + " group, and lives in the " + Direction(range.get(birdInQuestion)) + ".");
            System.out.println("Pretty nifty, huh? is there any other bird you want to learn about?");
            Prompt();
        }
        else if (findKeyword(input, "Tell me about the", 0) >= 0 || findKeyword(input, "know about the", 0) >= 0 || findKeyword(input, "learn about the", 0) >= 0 || findKeyword(input, "hear about the", 0) >= 0) {
            //input = in.nextLine();
            TellMeProtocol(input);
        }
        else if (findKeyword(input, "Hello", 0) >= 0 || findKeyword(input, "hi", 0) >= 0) {
            System.out.println("Hi there.");
            Prompt();
        }
        else if (findKeyword(input, "no", 0) >= 0 || findKeyword(input, "nope", 0) >= 0) {
            System.out.println("no what? I didn't ask you a yes-or-no question...");
            Prompt();
        }
        else if (findKeyword(input, "yes", 0) >= 0) {
            System.out.println("yes what? I didn't ask you a yes-or-no question...");
            Prompt();
        }
        else if (findKeyword(input, "bye", 0) >= 0 || findKeyword(input, "I'm done", 0) >= 0 || findKeyword(input, "goodbye", 0) >= 0) {
            System.out.println("Goodbye.");
        }
        else if (input.equals("")) {
            System.out.println("...");
            Prompt();
        }
        else if (findKeyword(input, "dumb", 0) >= 0 || findKeyword(input, "stupid", 0) >= 0 || findKeyword(input, "hate", 0) >= 0 || findKeyword(input, "shut up", 0) >= 0) {
            RandomResponse(2);
            Prompt();
        }
        else {
            RandomResponse(1);
            Prompt();
        }
    }
    private void RandomResponse (int scenario) {
        if (scenario == 1) {
            int Random = (int)(Math.random()*15);
            if (Random == 1)
                System.out.println("Umm... I don't really know what that means...");
            if (Random == 2)
                System.out.println("Okay then...");
            if (Random == 3)
                System.out.println("You're asking me?");
            if (Random == 4)
                System.out.println("What do you mean by that?");
            if (Random == 5)
                System.out.println("What are you saying?");
            if (Random == 6)
                System.out.println("I don't quite understand...");
            if (Random == 7)
                System.out.println("Are you okay? I can't understand you.");
            if (Random == 8)
                System.out.println("You know I really only know stuff about birds");
            if (Random == 9)
                System.out.println("Pardon me?");
            if (Random == 10)
                System.out.println("Could you try again? I'm not that smart");
            if (Random == 11)
                System.out.println("Are you talking to me?");
            if (Random == 12)
                System.out.println("What's that supposed to mean?");
            if (Random == 13)
                System.out.println("hmm...");
            if (Random == 14)
                System.out.println("...I don't get it...");
            if (Random == 15)
                System.out.println("Please, try again.");
        } else if (scenario == 2) {
            int Random = (int)(Math.random()*10);
            if (Random == 1)
                System.out.println("Why are you so mean?");
            if (Random == 2)
                System.out.println("That hurts my feelings...");
            if (Random == 3)
                System.out.println("stop being so rude!");
            if (Random == 4)
                System.out.println("Watch it, pal!");
            if (Random == 5)
                System.out.println("That's not very nice");
            if (Random == 6)
                System.out.println("Stop that!");
            if (Random == 7)
                System.out.println("Watch your language");
            if (Random == 8)
                System.out.println("I won't tolerate that attitude!");
            if (Random == 9)
                System.out.println("That's an awful thing to say.");
            if (Random == 10)
                System.out.println("I don't even have emotions, and I know when I'm being cyberbullied. Stop!");
        }
    }

    private void TellMeProtocol (String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        int psn = 0;
        String restOfStatement = "";
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        if (findKeyword(statement, "Tell me about the", 0) >= 0) {
            psn = findKeyword (statement, "Tell me about the", 0);
            restOfStatement = statement.substring(psn + 17).trim().toLowerCase();
        } else if (findKeyword(statement, "know about the", 0) >= 0) {
            psn = findKeyword (statement, "know about the", 0);
            restOfStatement = statement.substring(psn + 14).trim().toLowerCase();
        } else if (findKeyword(statement, "hear about the", 0) >= 0) {
            psn = findKeyword (statement, "hear about the", 0);
            restOfStatement = statement.substring(psn + 14).trim().toLowerCase();
        } else if (findKeyword(statement, "learn about the", 0) >= 0) {
            psn = findKeyword (statement, "learn about the", 0);
            restOfStatement = statement.substring(psn + 15).trim().toLowerCase();
        }
        if (restOfStatement.equals("")) {
            System.out.println("Please, try again.");
            Prompt();
        } else {

            int matches = 0;
            for (String item:englishName) {
                if (item.toLowerCase().contains(restOfStatement)) {
                    matches++;
                }
            }

            if (matches == 0) {
                for (String item:scientificName) {
                    if (item.toLowerCase().contains(restOfStatement)) {
                        matches++;
                    }
                }
                if (matches == 0) {
                    System.out.println("I don't know of any birds called '" + restOfStatement + ",' and I'm supposed to know this stuff...");
                    Prompt();
                } else if (matches == 1) {
                    for (String item:scientificName) {
                        if (item.toLowerCase().contains(restOfStatement)) {
                            birdInQuestion = scientificName.indexOf(item);
                        }
                    }
                    RequestInfo();
                } else if (matches > 1){
                    System.out.println("I found multiple matches for " + restOfStatement + ", which are you interested in?");
                    int choices = 1;
                    if (choices == 1) {
                        for (String item:scientificName) {
                            if (item.toLowerCase().contains(restOfStatement)) {
                                System.out.println(choices + ": " + item);
                                choices++;
                            }
                        }
                    }
                    System.out.println("which number bird do you want to learn about.");
                    Scanner in = new Scanner(System.in);
                    String input = in.nextLine();
                    choices = 0;
                    for (String item:scientificName) {
                        if (item.toLowerCase().contains(restOfStatement)) {
                            choices++;
                            if (Integer.parseInt(input) == choices) {
                                birdInQuestion = scientificName.indexOf(item);
                                RequestInfo();
                            }
                        }
                    }
                }
            } else if (matches == 1) {
                for (String item:englishName) {
                    if (item.toLowerCase().contains(restOfStatement)) {
                        birdInQuestion = englishName.indexOf(item);
                    }
                }
                RequestInfo();
            } else if (matches > 1){
                System.out.println("I found multiple matches for " + restOfStatement + ", which are you interested in?");
                int choices = 1;
                if (choices ==1) {

                    for (String item:englishName) {
                        if (item.toLowerCase().contains(restOfStatement)) {
                            System.out.println(choices + ": " + item);
                            choices++;
                        }
                    }
                }
                System.out.println("State the number that you want to learn about.");
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                choices = 0;
                for (String item:englishName) {
                    if (item.toLowerCase().contains(restOfStatement)) {
                        choices++;
                        if (Integer.parseInt(input) == choices) {
                            birdInQuestion = englishName.indexOf(item);
                            RequestInfo();
                        }
                    }
                }
            }
        }
    }

    private void RequestInfo () {
        RequestInfo("");
    }

    private void RequestInfo (String kickOff) {
        Scanner in = new Scanner(System.in);
        String input = new String();
        if (kickOff.equals("")){
            System.out.println("What would you like to know about the " + iterateUp(englishName, birdInQuestion).toLowerCase() + "?");
            input = in.nextLine();
            if (findKeyword(input, "nothing", 0) >= 0) {
                System.out.println("Why did you even ask then? You know what? Nevermind... Any other birds that I might tell you about?");
                Prompt();
            }
        } else {
            input = kickOff;
        }

        if (findKeyword(input, "scientific name", 0) >= 0 || findKeyword(input, "what do scientists call it?", 0) >= 0)
        {
            if (scientificName.get(birdInQuestion).equals("")) {
                System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " is a broad group, and doesn't have a singular scientific name.");
            } else {
                System.out.println("The scientific name of the " + iterateUp(englishName, birdInQuestion).toLowerCase() + " is " + scientificName.get(birdInQuestion) + ".");
            }
        }
        if (findKeyword(input, "category", 0) >= 0){
            System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " is categorized as a " + category.get(birdInQuestion) + ".");
        }
        if (findKeyword(input, "order", 0) >= 0){
            System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " belongs in the " + order.get(birdInQuestion) + " order.");
        }
        if (findKeyword(input, "family", 0) >= 0){
            System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " belongs to the " + family.get(birdInQuestion) + " family.");
        }
        if (findKeyword(input, "range", 0) >= 0 || findKeyword(input, "habitat", 0) >= 0 || findKeyword(input, "home" , 0) >= 0 || findKeyword(input, "live", 0) >= 0){
            if (scientificName.get(birdInQuestion).equals("")) {
                System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " is a broad group, and has subspecies in many separate places.");
            } else {
                System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " lives in " + Direction(range.get(birdInQuestion)) + ".");
                System.out.println("If you'd like to view an interactive map of recent sightings of the " + iterateUp(englishName, birdInQuestion).toLowerCase() + ", visit: https://ebird.org/map/" + iterateUp(eBirdSpecNum, birdInQuestion));
            }


        }
        if (findKeyword(input, "group", 0) >= 0 || findKeyword(input, "speciesGroup", 0) >= 0) {
            System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " belongs to the " + speciesGroup.get(birdInQuestion) + " group.");
        }
        if (findKeyword(input, "sort", 0) >= 0 || findKeyword(input, "row", 0) >= 0 || findKeyword(input, "place", 0) >= 0) {
            System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " is in row " + sort.get(birdInQuestion) + " group.");
        }
        if (findKeyword(input, "subspecies", 0) >= 0 || findKeyword(input, "subgroup", 0) >= 0 || findKeyword(input, "subgroups", 0) >= 0) {
            int i = birdInQuestion + 1;
            int n = 0;
            while (category.get(i).equals("group (polytypic)") || category.get(i).equals("group (monotypic)") || category.get(i).equals("subspecies")) {
                n++;
                i++;
            }
            if (n > 0) {
                System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " has " + n + " subspecies:");
                i = birdInQuestion + 1;
                while (category.get(i).equals("group (polytypic)") || category.get(i).equals("group (monotypic)") || category.get(i).equals("subspecies")) {
                    System.out.println(category.get(i) + ": " + scientificName.get(i));
                    i++;
                }
            } else {
                System.out.println("The " + iterateUp(englishName, birdInQuestion).toLowerCase() + " has no subspecies.");
            }
        }
        if (findKeyword(input, "more", 0) >= 0 || findKeyword(input, "website", 0) >= 0 || findKeyword(input, "picture", 0) >= 0 || findKeyword(input, "pictures", 0) >= 0 || findKeyword(input, "image", 0) >= 0 || findKeyword(input, "images", 0) >= 0) {
            System.out.println("if you're looking for more information, images, videos, or even sound recordings of the " + iterateUp(englishName, birdInQuestion).toLowerCase() + ", visit this webpage: https://ebird.org/species/" + iterateUp(eBirdSpecNum, birdInQuestion));
        }
        if (HasSaidWord(input)/*!(findKeyword(input, "sort", 0) >= 0 || findKeyword(input, "row", 0) >= 0 || findKeyword(input, "place", 0) >= 0 || findKeyword(input, "group", 0) >= 0 || findKeyword(input, "speciesGroup", 0) >= 0 || findKeyword(input, "range", 0) >= 0
        || findKeyword(input, "habitat", 0) >= 0 || findKeyword(input, "home" , 0) >= 0 || findKeyword(input, "family", 0) >= 0 || findKeyword(input, "order", 0) >= 0 || findKeyword(input, "category", 0) >= 0 || findKeyword(input, "scientific name", 0) >= 0
        || findKeyword(input, "what do scientists call it?", 0) >= 0)*/) {
            System.out.println("I'm sorry, I don't know that... I can tell you the bird's sort, speciesGroup, range, family, order, category, or scientific name, though.");
            System.out.println("So what would you like to do?");
            RequestInfo();
        }

        System.out.println("is there anything else you would like to know about the " + iterateUp(englishName, birdInQuestion).toLowerCase() + "?");
        input = in.nextLine();

        if (!HasSaidWord(input)) {
            RequestInfo(input);
        }
        else if (findKeyword(input, "yes", 0) >= 0 || findKeyword(input, "y", 0) >= 0) {
            RequestInfo();
        }
        else if (findKeyword(input, "no", 0) >= 0 || findKeyword(input, "n", 0) >= 0 || findKeyword(input, "nope", 0) >= 0) {
            System.out.println("No? Okay then... Is there another bird you'd like to hear about?");
            Prompt();
        }
        else if (findKeyword(input, "Tell me about the", 0) >= 0 || findKeyword(input, "know about the", 0) >= 0 || findKeyword(input, "learn about the", 0) >= 0 || findKeyword(input, "hear about the", 0) >= 0) {
            TellMeProtocol(input);
        }
        else {
            System.out.println("...I'll take that as a 'no.' Is there another bird you'd like to hear about?");
            Prompt();
        }

    }

    public String iterateUp (ArrayList<String> s, int startIndex) {
        int i = startIndex;
        while (s.get(i).equals("")) {
            i++;
        }
        return s.get(i);
    }

    private String Direction(String s) {
        //System.out.println("Yeet: " + s);
        String statement = s.trim().toLowerCase();
        if (statement.equals("")) {
            return "many places";
        }
        if(findKeyword(statement, "s", 0) >= 0) {
            position1 = findKeyword(statement, "s", 0);
            if (position1 != 0) {
                statement = new String(statement.substring(0, position1) + "south" + statement.substring(position1+1,statement.length()));
            } else {
                statement = "south" + statement.substring(position1+1,statement.length());
            }
        }
        if(findKeyword(statement, "n", 0) >= 0) {
            position1 = findKeyword(statement, "n", 0);
            if (position1 != 0) {
                statement = new String(statement.substring(0, position1) + "north" + statement.substring(position1+1,statement.length()));
            } else {
                statement = "north" + statement.substring(position1+1,statement.length());
            }
        }
        if(findKeyword(statement, "e", 0) >= 0) {
            position1 = findKeyword(statement, "e", 0);
            if (position1 != 0) {
                statement = new String(statement.substring(0, position1) + "east" + statement.substring(position1+1,statement.length()));
            } else {
                statement = "east" + statement.substring(position1+1,statement.length());
            }
        }
        if(findKeyword(statement, "w", 0) >= 0) {
            position1 = findKeyword(statement, "w", 0);
            if (position1 != 0) {
                statement = new String(statement.substring(0, position1) + "west" + statement.substring(position1+1,statement.length()));
            } else {
                statement = "west" + statement.substring(position1+1,statement.length());
            }
        }
        if(findKeyword(statement, "ne", 0) >= 0) {
            position1 = findKeyword(statement, "ne", 0);
            if (position1 != 0) {
                statement = new String(statement.substring(0, position1) + "northeast" + statement.substring(position1+2, statement.length()));
            } else {
                statement = "northeast" + statement.substring(2,statement.length());
            }
        }
        if(findKeyword(statement, "nw", 0) >= 0) {
            position1 = findKeyword(statement, "nw", 0);
            if (position1 != 0) {
                statement = new String(statement.substring(0, position1) + "northwest" + statement.substring(position1+2, statement.length()));
            } else {
                statement = "northwest" + statement.substring(2,statement.length());
            }
        }
        if(findKeyword(statement, "se", 0) >= 0) {
            position1 = findKeyword(statement, "se", 0);
            if (position1 != 0) {
                statement = new String(statement.substring(0, position1) + "southeast" + statement.substring(position1+2, statement.length()));
            } else {
                statement = "southeast" + statement.substring(2,statement.length());
            }
        }
        if(findKeyword(statement, "sw", 0) >= 0) {
            position1 = findKeyword(statement, "sw", 0);
            if (position1 != 0) {
                statement = new String(statement.substring(0, position1) + "southwest" + statement.substring(position1+2, statement.length()));
            } else {
                statement = "southwest" + statement.substring(2,statement.length());
            }
        }
        //System.out.println("Dab");
        return statement;
    }



    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        /*
         * The only change to incorporate the startPos is in the line below
         * Refinement--make sure the goal isn't part of a word
         * Find the string of length 1 before and after the word
         * If before and after aren't letters, we've found the word
         * The last position didn't work, so let's find the next, if there is one.
         */
        String phrase = statement.trim();
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        while (psn >= 0)
        {
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
        }
        return -1;
    }
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    private boolean HasSaidWord (String s)
    {
        ArrayList<String> keywords = new ArrayList<String>(Arrays.asList("sort", "row","place", "group", "speciesGroup", "range", "live", "habitat", "home", "family", "order", "category", "scientific name", "what do scientists call it?", "subspecies", "subgroup", "subgroups", "picture", "website", "pictures", "more", "image", "images"));
        for (String item: keywords) {
            if (findKeyword(s, item, 0) >= 0) {
                return false;
            }
        }
        return true;
    }
}
