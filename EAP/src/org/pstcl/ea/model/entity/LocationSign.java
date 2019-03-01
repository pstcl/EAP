package org.pstcl.ea.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="location_mf_map")
@NamedQuery(name="LocationMFMap.findAll", query="SELECT m FROM LocationMFMap m")
public class LocationSign {
	
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	private LocationMaster locationMaster;
	
	@Column
	private Integer netWHSign;
	
	private Date startDate;
	private Date endDate;
	
	
	public Date getEndDate() {
		return endDate;
	}
	public int getId() {
		return id;
	}
	public LocationMaster getLocationMaster() {
		return locationMaster;
	}
	public Integer getNetWHSign() {
		return netWHSign;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public void setLocationMaster(LocationMaster locationMaster) {
		this.locationMaster = locationMaster;
	}


	public void setNetWHSign(Integer netWHSign) {
		this.netWHSign = netWHSign;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
