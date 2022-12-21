package com.example.competitiveexamtrainer.generalKnowledge.culture_history;

public class culture_history_questions1 {

    public String Questions[] = {
            "On which river is the Idukki Hydroelectricity Project located?",
            "Who put an end to the system of Dual Government in Bengal",
            "Sattriya is a classical dance form of which state?",
            "Who had introduced Police System in india",
            "The first-land boundary agreement between india and bangladesh was signed in which year?",
            "Kathak is a classical dance of ",
            "Who is considered as the Chief architect of Tajmahal?",
            "Who start Arya Samaj",
            "Malayalam era began in _______?",
            "Who has written famous novel \'Devdas\'"
    };

    public String Choices[][] = {
            {"Tungabhadra","Malaprabha","Periyar","Damodar"},
            {"British Parliament","Warren Hasting","Clive","Regulating act"},
            {"Arunachal Pradesh","Nagpur","Maharashtra","Assam"},
            {"Lord Cornwallis","Lord Wellesley","Lord Hasting","None"},
            {"1947","1980","1950","1974"},
            {"Kolkata","Mumbai","new Delhi","North India"},
            {"Ahmad Khan","Ahmad Lahauri","Makramat Khan","Mohammmed Khan"},
            {"Raja Ram Mohan Roy","Gopal Krishna Gokhale","Swami Dhayanand Saraswati", "Swami Vivekananda"},
            {"800 AD","830 AD","890 AD","825 AD"},
            {"Bankim Chardra Chattopadhyay","Samudra Gupta","Rabindranath Tagore","Saratchandra Chatyopadhyay"}
    };

    public String Answers[] = {"Periyar","Warren Hasting","Assam","Lord Cornwallis","1974","North India","Ahmad Lahauri",
            "Swami Dhayanand Saraswati","825 AD","Saratchandra Chatyopadhyay"};

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
