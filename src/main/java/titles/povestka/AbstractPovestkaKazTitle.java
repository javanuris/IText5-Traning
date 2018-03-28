package titles.povestka;

import titles.povestka.lang.AbstractLangTemplate;
import titles.povestka.lang.KazLangTemplate;

public abstract class AbstractPovestkaKazTitle extends AbstractPovestkaTitle {
    protected AbstractLangTemplate templ() {
        return new KazLangTemplate();
    }
}
