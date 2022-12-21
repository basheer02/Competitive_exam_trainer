package com.example.competitiveexamtrainer.generalKnowledge.day_year;

public class day_year_questions {
    public String Questions[] = {
            "When is National Technology Day Celebrated?",
            "When is World Red Cross Day Celebrate?",
            "World Human Rights Day is observed on ",
            "When is National Youth Day celebrated?",
            "In Which month of 2004,Olympic Games were held in Greece",
            "International Women's Day is celebrated on _______",
            "Which day is observed as World Food Day?",
            "Which day is observed as World Day of War Orphans?",
            "The year 1985 was declared as the International Year of",
            "1981 was the International year of the ",
            "The first death anniversary day of Sri Rajiv Gandhi was observed as the",
            "Which year Earth day was first celebrated?",
            "India celebrates February 28 every year as \"National Science Day\" becuase on this day",
            "_______ is celebrated as World Environment Day",
            "In which year Kargil Memoriable Day was celebrated?",
            "When National Republic Day celebrate?",
            "When is Quit India Day celebrated?",
            "When is Doctor's Day celebrated?",
            "In which year International Volunteers Day is celebrated?",
            "In which year International Mother Language Day is celebrated?"

    };

    public String Choices[][] = {
            {"1st May","12th July","11th May","12th May"},
            {"9th May","9th June","8th July","8th May"},
            {"September 5","December 10","December 7","April 8"},
            {"January 14","February 12","February 14","January 12"},
            {"August","June","July","September"},
            {"March 8","May 8","June 8","April 8"},
            {"September 10","August 16","October 16","November 10"},
            {"5th January","6th January","5th February","6th February"},
            {"Blind","Youth","Children","GrandWomen"},
            {"Disabled","Women","Children","Blind"},
            {"National Integration Day","Peace and Love Day","Secularism Day","Anti-Terrorism Day"},
            {"1971","1973","1970","1975"},
            {"first Indian Space craft was launched","Nehru led the foundation of science labs all over india",
                    "Vikram Sarabhai was born","in 1928 C.V. Raman discovered what was later called the \'Raman Effect\'"},
            {"June 5","July 5","January 5","June 6"},
            {"1995","1996","1998","1999"},
            {"November 26","January 25","August 15","September 26"},
            {"9th August","19th August","10th August","8th August"},
            {"1st April","1st March","1st July","1st June"},
            {"1985","1984","1983","1995"},
            {"1990","1991","1999","2000"}
    };

    public String Answers[] = {"1st May","8th July","December 10","January 12","August","March 8","October 16",
            "6th January","Youth","Disabled","Anti-Terrorism Day","1970",
            "in 1928 C.V. Raman discovered what was later called the \'Raman Effect\'","June 5","1999",
            "January 25","9th August","1st July","1985","1999"};

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
