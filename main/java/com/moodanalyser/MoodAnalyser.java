package com.moodanalyser;

import java.util.Scanner;

enum MoodAnalyserErrorMessage {
    NULLMESSAGE("Null Mood Error"), EMPTYMESSAGE("Empty Mood Error");
    private final String message;

    MoodAnalyserErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public MoodAnalyser() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Mood Analyser Program");
        try{
            System.out.print("Enter mood: ");
            String moodMessage = in.nextLine();
            MoodAnalyser moodAnalyser = new MoodAnalyser(moodMessage);
            System.out.println(moodAnalyser.analyseMood());
        }catch(MoodAnalysisException e){
            System.out.println("Output: HAPPY\n" + e.getMessage());
        }
    }

    protected String analyseMood() throws MoodAnalysisException {
        if(message==null)
            throw new MoodAnalysisException(MoodAnalyserErrorMessage.NULLMESSAGE.getMessage());
        else if (message.isEmpty())
            throw new MoodAnalysisException(MoodAnalyserErrorMessage.EMPTYMESSAGE.getMessage());
        else if (message.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
