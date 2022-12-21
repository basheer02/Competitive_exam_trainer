package com.example.competitiveexamtrainer.generalKnowledge.indian_economy;

public class indian_economy_questions1 {

    public String Questions[] = {
            "Union Budget is always presented first in ______",
            "Who appoints Comptroller and Auditor General?",
            "The position of the president which was undermined by the 42nd amendment was sub-sequently " +
                    "somewhat retrieved by the",
            "The veto power of the president of india  consists of : ",
            "From which country the concept of Single Citizenship been adopted in India",
            "The legel advisor to the state government is known as : ",
            "In India which of the following means measures of money denotes the \"Broad Money\"?",
            "Bachawat Commission is concerned with",
            "\"Globalisation of Indian Economy\" means ",
            "Survey of is under the Ministry of "
    };

    public String Choices[][] = {
            {"The Rajya Sabha","The Lok Sabha","Joint session of the Parliament","Meeting of the Union Cabinet"},
            {"Rajya Sabha","Lok Sabha","Prime Minister","President"},
            {"44th amendment","45th amendment","46th amendment","26th amendment"},
            {"Pocket Veto","Absolute Veto","Suspensive Veto","All of the above"},
            {"England","USA","Germany","Australia"},
            {"Attorney General","Solicitor General","Advocate General","None of the above"},
            {"M4","M3","M1","M2"},
            {"wages for working literary workers","wages for working journalists","wages for working sportsman",
                    "wages for employees in Public Sector Undertakings"},
            {"Stepping up external borrowings","establishing Indian business units abroad","giving up programmes of import substitution",
            "having minimum possible restrictions on economic relations with other countries"},
            {"Science and Technology","Home Affairs","Environment & Forests","Defence"}
    };

    public String Answers[] = {"The Lok Sabha","President","44th amendment","All of the above","England",
                    "Advocate General","M3","wages for working journalists",
            "having minimum possible restrictions on economic relations with other countries", "Science and Technology"};

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
