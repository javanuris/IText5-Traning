package titles.povestka;

import titles.povestka.lang.AbstractLangTemplate;
import titles.povestka.lang.RusLangTemplate;

public abstract class AbstractPovestkaRusTitle extends AbstractPovestkaTitle {

    protected AbstractLangTemplate templ() {
        return new RusLangTemplate();
    }


}
