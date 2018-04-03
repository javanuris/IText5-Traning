package titles.single.povestka;

import titles.single.povestka.lang.AbstractLangTemplate;
import titles.single.povestka.lang.KazLangTemplate;

public abstract class AbstractPovestkaKazTitle extends AbstractPovestkaTitle {
    protected AbstractLangTemplate templ() {
        return new KazLangTemplate();
    }
}
