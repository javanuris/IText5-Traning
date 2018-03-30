package titles.notice.lang;


public class RusLangTemplate extends AbstractLangTemplate {
    @Override
    public String getSudPovestka() {
        return "Судебное извещение";
    }

    @Override
    public String getPovestka() {
        return "СУДЕБНОЕ ИЗВЕЩЕНИЕ";
    }

    @Override
    public String getReceiver() {
        return "     Кому: %s";
    }

    @Override
    public String getAddress() {
        return "     Куда: %s %s %s %s";
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
