package titles.single.povestka;

import titles.single.povestka.lang.AbstractLangTemplate;
import titles.single.povestka.lang.RusLangTemplate;

public abstract class AbstractPovestkaRusTitle extends AbstractPovestkaTitle {

    protected AbstractLangTemplate templ() {
        return new RusLangTemplate();
    }


}
