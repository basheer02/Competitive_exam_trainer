package com.example.competitiveexamtrainer.generalKnowledge.books_authors;

public class gkQuestions1 {
    public String Questions[] = {
            "Who is the writer of these book \"Wealth of Nations\"?",
            "Who is the author of \"A Passage to India\"?",
            "The famous book \"My Experiments with Truth\" was written by which of the following?",
            "\"Origin of Species\" is the book written by",
            "Who is the author of \"Gullivers Travels\"?",
            "Who is the writer of these book \"Arthashastra\"?",
            "Who is the author of \"My Truth\"?",
            "\"Discovery of India\" was written by",
            "The famous book \"Geetanjali\" was written by which of the following ?",
            "\"Pride and Prejudice\" was written by"
    };

    public String Choices[][] = {
            {"Victor Hugo","H.G. Wells","Adam Smith","Indira Gandhi"},
            {"E.M. Forster","R.K. Narayan","Vikram Seth","Charles Dickens"},
            {"Indira Gandhi","Pandit Jawaharlal Nehru","Bankimchandra Chattopadhyay","Mahatma Gandhi"},
            {"Sir Thomas Moore","Thomas Hardy","Charles Darwin","Charles Dickens"},
            {"D.H. Lowerence","R.L. Stevenson","Jonathan Swift","H.G. Wells"},
            {"Kautilya","R.K. Narayan","Rabindranath Tagore","Vikram Seth"},
            {"R.K. Narayan","Indira Gandhi","Pandit Jawaharlal Nehru","Kautilya"},
            {"Rabindranath Tagore","Mahatma Gandhi","Vikram Seth","Pandit Jawaharlal Nehru"},
            {"Indira Gandhi","Kautilya","Rabindranath Tagore","Bankimchandra Chattopadhyay"},
            {"William Shakespeare","Jane Austen","Sidney Sheldon","Ernest Hemingway"}
    };

    public String Answers[] = {"Adam Smith","E.M. Forster","Mahatma Gandhi","Charles Darwin","Jonathan Swift",
            "Kautilya","Indira Gandhi","Pandit Jawaharlal Nehru","Rabindranath Tagore","Sidney Sheldon"};

    public String getQuestions(int a){
        String question = Questions[a];
        return question;
    }
    public String getChoice1(int a){
        String choice1 = Choices[a][0];
        return choice1;
    }
    public String getChoice2(int a){
        String choice2 = Choices[a][1];
        return choice2;
    }
    public String getChoice3(int a){
        String choice3 = Choices[a][2];
        return choice3;
    }
    public String getChoice4(int a){
        String choice4 = Choices[a][3];
        return choice4;
    }
    public String getCorrectAnswer(int a){
        String answer = Answers[a];
        return answer;
    }
}
