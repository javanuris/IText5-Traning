package titles.povestka.lang;

public class RusLangTemplate extends AbstractLangTemplate {

    @Override
    public String getSudPovestka() {
        return "Судебная повестка";
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
        return "СУДЕБНАЯ ПОВЕСТКА/ИЗВЕЩЕНИЕ";
    }

    @Override
    public String getReceiver() {
        return "  Кому: %s";
    }

    @Override
    public String getAddress() {
        return "  Куда: %s %s %s %s";
    }

    @Override
    public String getSud() {
        return "  Суд: %s";
    }

    @Override
    public String getCallYou() {
        return "  вызывает Вас по адресу: %s";
    }

    @Override
    public String getTo() {
        return "  на: %s";
    }

    @Override
    public String getDeal() {
        return "  по делу: %s";
    }

    @Override
    public String getAs() {
        return "  в качестве: %s";
    }

    @Override
    public String getDemandOne() {
        return "   Лицо, принявшее повестку, обязано при первой возможности вручить её адресату.\n   Уклонение без уважительных причин участников процесса и иных лиц от явки в суд влечет административную ответственность (ст.513 КоАП).\n";
    }

    @Override
    public String getDemandTwo() {
        return "   При себе иметь документ, удостоверяющий личность.";
    }

    @Override
    public String getSecretary() {
        return "     Секретарь судебного заседания: %s";
    }

    @Override
    public String getPhoneNumber() {
        return "     Телефон: %s";
    }

    @Override
    public String getOfficePhoneNumber() {
        return "     Телефон заведующего канцелярии: %s";
    }

    @Override
    public String getJudge() {
        return "     Судья: %s";
    }

    @Override
    public String getDescription() {
        return "       На сайте Верховного Суда www.sud.gov.kz для граждан и юридических лиц реализованы:\n" +
                "- возможность подачи обращения, заявления (жалобы) и ходатайства в онлайн режиме через электронный сервис «Судебный кабинет»;\n" +
                "- ознакомление с судебными документами в электронном сервисе «Ознакомление с судебными документами»;\n" +
                "- ознакомление со списком слушаний судебных дел;\n" +
                "- распечатка электронной судебной повестки в модуле «Судебная повестка» по коду, полученному СМС-сообщением на сотовый телефон.\n" +
                "По возникшим вопросам звонить в Сall-центр судебных органов с городских телефонов на номер 1401(бесплатно), с мобильных телефонов на номер 8-7172-710000 (платно).\n";
    }

    @Override
    public String getText1() {
        return "Контакт-Центр ВС: ";
    }

    @Override
    public String getText2() {
        return "1401 ( бесплатно по всему РК )";
    }

    @Override
    public String getText3() {
        return "8 (7172) 710 000";
    }
}
