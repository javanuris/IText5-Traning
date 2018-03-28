package titles.povestka.lang;

public class RusLangTemplate extends AbstractLangTemplate {

    @Override
    public String getSudPovestka() {
        return "Судебная повестка";
    }

    @Override
    public String getSenderAndFrom() {
        return "от";
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
        return "Кому";
    }

    @Override
    public String getAddress() {
        return "Куда";
    }

    @Override
    public String getSud() {
        return "Суд";
    }

    @Override
    public String getCallYou() {
        return "вызывает Вас по адресу";
    }

    @Override
    public String getTo() {
        return "на";
    }

    @Override
    public String getDeal() {
        return "по делу";
    }

    @Override
    public String getAs() {
        return "в качестве";
    }

    @Override
    public String getDemandOne() {
        return "Лицо, принявшее повестку, обязано при первой возможности вручить её адресату.\n   Уклонение без уважительных причин участников процесса и иных лиц от явки в суд влечет административную ответственность (ст.513 КоАП).\n";
    }

    @Override
    public String getDemandTwo() {
        return "При себе иметь документ, удостоверяющий личность.";
    }

    @Override
    public String getSecretary() {
        return "Секретарь судебного заседания";
    }

    @Override
    public String getPhoneNumber() {
        return "Телефон";
    }

    @Override
    public String getOfficePhoneNumber() {
        return "Телефон заведующего канцелярии";
    }

    @Override
    public String getJudge() {
        return "Судья";
    }

    @Override
    public String getDescription() {
        return "На сайте Верховного Суда www.sud.gov.kz для граждан и юридических лиц реализованы:\n" +
                "- возможность подачи обращения, заявления (жалобы) и ходатайства в онлайн режиме через электронный сервис «Судебный кабинет»;\n" +
                "- ознакомление с судебными документами в электронном сервисе «Ознакомление с судебными документами»;\n" +
                "- ознакомление со списком слушаний судебных дел;\n" +
                "- распечатка электронной судебной повестки в модуле «Судебная повестка» по коду, полученному СМС-сообщением на сотовый телефон.\n" +
                "По возникшим вопросам звонить в Сall-центр судебных органов с городских телефонов на номер 1401(бесплатно), с мобильных телефонов на номер 8-7172-710000 (платно).\n";
    }

    @Override
    public String getText1() {
        return "Контакт-Центр ВС:";
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
