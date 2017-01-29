package ch.hackathon.apme;

import java.io.Serializable;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author apme
 *
 */
@Entity
@Table(name = "CNT_CATALOG")
@SequenceGenerator(initialValue = 1,
        allocationSize = 1,
        name = "CNT_SEQ_CATALOG",
        sequenceName = "CNT_SEQ_CATALOG")
public class ContentInfo implements Serializable {

    private static final long serialVersionUID = -6565327322728128525L;

    @Id
    @GeneratedValue(generator = "CNT_SEQ_CATALOG")
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
            length = 32)
    private String multihash;
    
    @Column(name = "CNT_DEMO_MULTIHASH",
            nullable = false,
            length = 32)
    private String demoMultihash;
    
    @Column(name = "CNT_OWNER",
            nullable = false,
            length = 256)
    private String owner;
    
    @Column(name = "CNT_OWNER_WALLET",
            nullable = false,
            length = 32)
    private String ownerWallet;
    
    @Column(name = "CNT_PRICE",
            nullable = false)
    private Long price;

    @Column(name = "CNT_PUBLIC_KEY",
            nullable = false,
            length = 32)
    private String publickey;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMultihash() {
		return multihash;
	}

	public void setMultihash(String multihash) {
		this.multihash = multihash;
	}

	public String getDemoMultihash() {
		return demoMultihash;
	}

	public void setDemoMultihash(String demoMultihash) {
		this.demoMultihash = demoMultihash;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwnerWallet() {
		return ownerWallet;
	}

	public void setOwnerWallet(String ownerWallet) {
		this.ownerWallet = ownerWallet;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPublickey() {
		return publickey;
	}

	public void setPublickey(String publickey) {
		this.publickey = publickey;
	}
    
    
}
