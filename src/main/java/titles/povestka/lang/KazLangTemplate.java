package titles.povestka.lang;

public class KazLangTemplate extends AbstractLangTemplate {
    @Override
    public String getSudPovestka() {
        return "СОТ ХАБАРЛАУЫ";
    }

    @Override
    public String getSenderAndFrom() {
        return "от: %s %s";
    }

    @Override
    public String getRecipientPhone() {
        return super.getRecipientPhone();
    }

    @Override
    public String getPovestka() {
        return "СОТ ХАБАРЛАУЫ (ШАҚЫРУ ҚАҒАЗЫ)";
    }

    @Override
    public String getReceiver() {
        return " Кімге : %s";
    }

    @Override
    public String getAddress() {
        return " Қайда: %s %s %s %s";
    }

    @Override
    public String getSud() {
        return " Сізді %s соты";
    }


    @Override
    public String getCallYou() {
        return " %s мекенжай бойынша";
    }

    @Override
    public String getTo() {
        return " %s";
    }

    @Override
    public String getDeal() {
        return " %s іс бойынша";
    }

    @Override
    public String getAs() {
        return " %s ретінде шақырады.";
    }

    @Override
    public String getDemandOne() {
        return "   Шақыру қағазын қабылдап алған адам мүмкіндігінше шақыру қағазын адресатқа тапсыруға міндетті.\n   Процеске қатысушылар мен өзге тұлғалар сотқа келмеуден дәлелдi себептерсiз бас тартса әкімшілік жауапқа тартылады (ӘҚБТ-нің 513-бабы).\n";
    }

    @Override
    public String getDemandTwo() {
        return "   Жеке басты  куәландыратын құжат қолыңызда болуы қажет";
    }

    @Override
    public String getSecretary() {
        return "     Сот отырысының хатшысы: %s";
    }

    @Override
    public String getPhoneNumber() {
        return "     Телефон: %s";
    }

    @Override
    public String getOfficePhoneNumber() {
        return "     Кеңсе меңгерушісінің телефоны: %s";
    }

    @Override
    public String getJudge() {
        return "     Судья: %s";
    }

    @Override
    public String getDescription() {
        return "www.sud.gov.kz Жоғарғы Сот сайтында азаматтар мен заңды тұлғалар: \n" +
                "- «Сот кабинеті» электрондық сервисі арқылы өтініш, арыз (шағым), және өтінішхатты онлайн тәртібінде бере алады;\n" +
                "- «Сот құжаттарымен танысу» электрондық сервисінде сот құжаттарымен таныса алады;\n" +
                "- сот істерінің қаралуымен таныса алады;\n" +
                "- ұялы телефонға СМС-хабарлама арқылы түскен код бойынша «Сотқа шақыру қағазы» модулінен электрондық нұсқадағы сотқа шақыру қағазын шығарып ала алады.\n" +
                "\n" +
                "Туындаған сұрақтар бойынша сот органдарының Сall-орталығына қалалық телефоннан 1401 нөміріне (тегін), ұялы телефоннан 8-7172-71000 нөміріне (ақылы) қоңырау шалуға болады.";
    }


    @Override
    public String getText1() {
        return "ЖС байланыс орталығы";
    }

    @Override
    public String getText2() {
        return "1401 (ҚР бойынша тегін)";
    }

    @Override
    public String getText3() {
        return "8 (7172) 710 000";
    }
}
