package com.redpacket.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class RedPacket implements Serializable {
	
	private static final long serialVersionUID = 7567567480558510660L;

	private Long id;
	
	/**
	 * 红包接收人
	 */
    private WechatUser user;
	
	private Long wechatUserId;
	private String wechatNickname;
    
    /**
     * 红包发放金额（单位分）
     */
    private int amount = 0;
    
    /**
     * 红包发放时间
     */
    private Date createDateTime = new Date();
    
    private Product product;
	
	private Long productId;
	private String productName;

	public RedPacket() {
	}

	public RedPacket(int amount, Date createDateTime) {
		this.amount = amount;
		this.createDateTime = createDateTime;
	}

	public RedPacket(WechatUser user, int amount, Date createDateTime) {
		this.user = user;
		this.amount = amount;
		this.createDateTime = createDateTime;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "wechat_user_id", foreignKey = @ForeignKey(name="FK_WECHAT_USER_ID"), referencedColumnName = "id", insertable = false, updatable = false),
	    @JoinColumn(name = "wechat_nickname", referencedColumnName = "nickname", insertable = false, updatable = false)
	})
	@JsonProperty(access = Access.WRITE_ONLY)
	public WechatUser getUser() {
		return user;
	}

	public void setUser(WechatUser user) {
		this.user = user;
	}

    @Column(name="wechat_user_id")
	public Long getWechatUserId() {
		return wechatUserId;
	}

	public void setWechatUserId(Long wechatUserId) {
		this.wechatUserId = wechatUserId;
	}

    @Column(name="wechat_nickname")
	public String getWechatNickname() {
		return wechatNickname;
	}

	public void setWechatNickname(String wechatNickname) {
		this.wechatNickname = wechatNickname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false),
	    @JoinColumn(name = "product_name", referencedColumnName = "name", insertable = false, updatable = false)
	})
	@JsonProperty(access = Access.WRITE_ONLY)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

    @Column(name="product_id")
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

    @Column(name="product_name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
    
    
}
