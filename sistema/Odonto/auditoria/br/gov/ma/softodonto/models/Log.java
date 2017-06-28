package br.gov.ma.softodonto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "log", schema = "auditoria")
public class Log implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String action;
	
	private String detail;
	
	@Column(name = "entity_id")
	private long entityId;
	
	@Column(name = "entity_name")
	private String entityName;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	public Log() {
	}

	public Log(String action, String detail, Date created, Long entityId,
			String entityName) {

		this.action = action;
		this.detail = detail;
		this.created = created;
		this.entityId = entityId;
		this.entityName = entityName;
		
	}
	
	public Log(String action, String detail, Date created, Long entityId,
			String entityName, Integer userId) {

		this.action = action;
		this.detail = detail;
		this.created = created;
		this.entityId = entityId;
		this.entityName = entityName;
		this.userId = userId;
		
	}

	public Long getId() {
		return id;
	}

	public void setAuditLogId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}