package com.example.competitiveexamtrainer.generalKnowledge.indian_politics;

public class indian_politics_questions1 {

    public String Questions[] = {
            "A person wants to contest election for the membership of Gram Panchayath, what should be his age?",
            "Which state first adopted the Panchayath Raj in india in 1959?",
            "How many languages are originally recognized by the constitution as regional languages",
            "Which Act was passed to consolidate the provisions of the preceding Government of indian Acts?",
            "By which of the following acts were the Commercial Rights of East India Company abolished?",
            "Shankarlal Guru Committee was associated with - ",
            "How many articles were there originally in Constitution of India?",
            "provincial Autonamy was a significant feature of ",
            "When were high courts established in Bombay,Madras and Calcutta",
            "The battle of Plassy was fought in"
    };

    public String Choices[][] = {
            {"minimum 25 years","19 years or above","21 years or above","20 years or above"},
            {"Gujarat","Rajasthan","Maharastra","Kerala"},
            {"14","16","15","13"},
            {"Government of India Act, 1925","Government of India Act, 1919","Government of India Act, 1911","Government of India Act, 1915"},
            {"Regulating Act of 1902","Charter Act of 1873","Charter Act of 1833","Charter Act of 1853"},
            {"Public Distribution System","Agriculture Marketing","Agriculture Production","None of the above"},
            {"395","398","405","390"},
            {"The Government of India Act,1947","The Government of India Act,1914","The Government of India Act,1919","The Government of India Act,1935"},
            {"1951","1861","1851","1961"},
            {"1754","1857","1757","1854"}
    };

    public String Answers[] = {"21 years or above","Rajasthan","14","Government of India Act, 1915","Charter Act of 1873",
            "Agriculture Marketing","395","The Government of India Act,1935","1861","1757"};



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
