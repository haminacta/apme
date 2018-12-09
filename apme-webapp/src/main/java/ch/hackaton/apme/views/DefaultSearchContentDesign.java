package ch.hackaton.apme.views;

import com.vaadin.annotations.JavaScript;

/**
 * @author apme
 *
 */
@SuppressWarnings("serial")
@JavaScript({ "https://blockone.thomsonreuters.com/wallet-bar/bundle.js", "https://cdn.jsdelivr.net/gh/ethereum/web3.js@develop/dist/web3.min.js",
        "vaadin://js/alert.js" })
public class DefaultSearchContentDesign extends SearchContentDesign {

    public DefaultSearchContentDesign() {

        super();
    }
}
