package titles.single.notice;


import titles.single.notice.lang.AbstractLangTemplate;
import titles.single.notice.lang.KazLangTemplate;

public abstract class AbstractNoticeKazTitle extends AbstractNoticeTitle {
    protected AbstractLangTemplate templ() {
        return new KazLangTemplate();
    }
}
