package ch.hackaton.apme.blockchain;

import java.util.List;

import ch.hackaton.apme.blockchain.api.ContentContract;

/**
 * The content-contract to handle contractual checks and other things for the Ethereum block-chain
 *
 * @author apme
 */
public class EtherumContentContract implements ContentContract {

    @Override
    public boolean isUserAuthorizedToGetContent(final String contentId, final String userId) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<String> getPurchases(final String userId) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getBuyers(final String contentId) {

        // TODO Auto-generated method stub
        return null;
    }

}
