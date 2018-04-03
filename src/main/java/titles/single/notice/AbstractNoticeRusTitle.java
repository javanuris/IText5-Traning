package titles.single.notice;


import titles.single.notice.lang.AbstractLangTemplate;
import titles.single.notice.lang.RusLangTemplate;

public abstract class AbstractNoticeRusTitle extends AbstractNoticeTitle {

    protected AbstractLangTemplate templ() {
        return new RusLangTemplate();
    }


}
