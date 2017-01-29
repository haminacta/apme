package ch.hackaton.apme.views;

/**
 * @author apme
 *
 */
@SuppressWarnings("serial")
public class DefaultProvideContentDesign extends ProvideContentDesign {

    public DefaultProvideContentDesign() {

        super();

        this.priceField.setConverter(Long.class);
        this.priceField.setNullRepresentation("");
    }
}
