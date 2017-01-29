package ch.hackathon.apme;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author apme
 *
 */
@Entity
@Table(name = "CNT_CATALOG")
public class ContentInfo implements Serializable {

    private static final long serialVersionUID = -6565327322728128525L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CNT_ID",
            unique = true,
            nullable = false)
    private Integer id;

    @Column(name = "CNT_TITLE",
            nullable = false,
            length = 256)
    private String title;

    @Column(name = "CNT_DESC",
            nullable = false,
            length = 256)
    private String description;

    @Column(name = "CNT_MULTIHASH",
            nullable = false,
            length = 64)
    private String multihash;

    @Column(name = "CNT_DEMO_MULTIHASH",
            nullable = false,
            length = 64)
    private String demoMultihash;

    @Column(name = "CNT_OWNER",
            nullable = false,
            length = 256)
    private String owner;

    @Column(name = "CNT_OWNER_WALLET",
            nullable = false,
            length = 64)
    private String ownerWallet;

    @Column(name = "CNT_PRICE",
            nullable = false)
    private Long price;

    @Column(name = "CNT_PUBLIC_KEY",
            nullable = false,
            length = 64)
    private String publickey;

    public Integer getId() {

        return this.id;
    }

    public void setId(final Integer id) {

        this.id = id;
    }

    public String getTitle() {

        return this.title;
    }

    public void setTitle(final String title) {

        this.title = title;
    }

    public String getDescription() {

        return this.description;
    }

    public void setDescription(final String description) {

        this.description = description;
    }

    public String getMultihash() {

        return this.multihash;
    }

    public void setMultihash(final String multihash) {

        this.multihash = multihash;
    }

    public String getDemoMultihash() {

        return this.demoMultihash;
    }

    public void setDemoMultihash(final String demoMultihash) {

        this.demoMultihash = demoMultihash;
    }

    public String getOwner() {

        return this.owner;
    }

    public void setOwner(final String owner) {

        this.owner = owner;
    }

    public String getOwnerWallet() {

        return this.ownerWallet;
    }

    public void setOwnerWallet(final String ownerWallet) {

        this.ownerWallet = ownerWallet;
    }

    public Long getPrice() {

        return this.price;
    }

    public void setPrice(final Long price) {

        this.price = price;
    }

    public String getPublickey() {

        return this.publickey;
    }

    public void setPublickey(final String publickey) {

        this.publickey = publickey;
    }

}
