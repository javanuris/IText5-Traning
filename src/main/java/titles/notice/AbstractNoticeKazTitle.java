package titles.notice;


import titles.notice.lang.AbstractLangTemplate;
import titles.notice.lang.KazLangTemplate;

public abstract class AbstractNoticeKazTitle extends AbstractNoticeTitle {
    protected AbstractLangTemplate templ() {
        return new KazLangTemplate();
    }
}
