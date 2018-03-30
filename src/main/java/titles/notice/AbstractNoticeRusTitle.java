package titles.notice;


import titles.notice.lang.AbstractLangTemplate;
import titles.notice.lang.RusLangTemplate;

public abstract class AbstractNoticeRusTitle extends AbstractNoticeTitle {

    protected AbstractLangTemplate templ() {
        return new RusLangTemplate();
    }


}
