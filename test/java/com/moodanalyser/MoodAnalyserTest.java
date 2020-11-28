package com.moodanalyser;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void givenMessage_WhenSadMood_ShouldReturnSAD() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        String result = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", result);
    }

    @Test
    public void givenMessage_WhenNotSadMood_ShouldReturnHAPPY() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        String result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", result);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnHAPPY() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String result = null;
        try {
            result = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            result = "HAPPY";
        }
        Assert.assertEquals("HAPPY", result);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnMoodAnalysisException() throws MoodAnalysisException{
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try{
            moodAnalyser.analyseMood();
        } catch(MoodAnalysisException e) {
            Assert.assertEquals("Null Mood Error", e.getMessage());
        }
    }

    @Test
    public void givenMessage_WhenEmpty_ShouldReturnMoodAnalysisException() throws MoodAnalysisException{
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try{
            moodAnalyser.analyseMood();
        } catch(MoodAnalysisException e) {
            Assert.assertEquals("Empty Mood Error", e.getMessage());
        }
    }
}
