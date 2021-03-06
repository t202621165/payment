package com.cypay.common.entity;

import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$GTE;
import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$LTE;
import static com.cypay.common.annotation.jpa.Conditional.EQ;
import static com.cypay.common.annotation.jpa.VerifyMode.isBeanId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.cypay.common.annotation.jpa.JavaType;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.to.DbInfo;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.Result;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.hutool.core.util.IdUtil;

/**
 * 游戏分区实体
 * @author International
 * 2018年8月1日 上午10:13:25
 */
@SuppressWarnings("deprecation")
@Entity
@DynamicUpdate
@Table(name = "cy_partition")
@NamedEntityGraphs({
	@NamedEntityGraph(
			name = "partitionWithTemplate",
			attributeNodes = {@NamedAttributeNode(value = "template")}
	),
	@NamedEntityGraph(
			name = "partitionWithGroupAndMerchant",
			attributeNodes = {
				@NamedAttributeNode(value = "merchant", subgraph = "merchantWithParent")
			},
			subgraphs = {
				@NamedSubgraph(
					name = "merchantWithParent", 
					attributeNodes = {
						@NamedAttributeNode(value = "parent")
					}
				)
			}
	)
})
public class Partition implements Serializable {

	private static final long serialVersionUID = 1L;

	/**分区-ID*/
	@JpaQuery
	@Id
	@JpaOrderBy
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**分区-创建时间*/
	@JpaQuery(cond = BETWEEN_$GTE, jType = JavaType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createDate = new Date();
	
	@JpaQuery
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date changeDate = new Date();
	
	/**分区-名称*/
	@JpaQuery
	@Column(length = 50, nullable = false)
	private String name;
	
	/**开区时间*/
	@JpaQuery(cond = BETWEEN_$LTE, jType = JavaType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date useDate = new Date();
	
	/**开区-开区使用名称*/
	@JpaQuery
	@Column(length = 50, nullable = false)
	private String useName;
	
	/**分区-类型*/
	@JpaQuery(cond = EQ)
	@Column(nullable = false, updatable = false)
	private Integer type;
	
	/**分区-排序号*/
	@JpaQuery
	@JpaOrderBy
	@Column(updatable = false)
	private Integer sort = 0;
	
	/**分区唯一标识*/
	@JpaQuery
	@Column(length = 32, nullable = false, unique = true, updatable = false)
	private String uuid;
	
	/**是否开启分区元宝蛋*/
	@Column(nullable = false)
	private Boolean ybEgg = Boolean.FALSE;
	
	/**分区-启用状态*/
	@JpaQuery(cond = EQ)
	@Column(nullable = false, updatable = false)
	private Boolean state;

	/**分区-脚本路径*/
	@JpaQuery
	@Column(length = 100)
	private String scriptPath;
	
	/**通用分区数据库信息(JSONArray)*/
	@Column(columnDefinition = "text")
	private String dbInfo;
	
	/**通讯服务器IP*/
	@JpaQuery
	@Column(nullable = false)
	private String serverIp = "";
	
	/**通讯端口*/
	@JpaQuery
	@Column(length = 5, nullable = false)
	private Integer serverPort = 6880;
	
	/**游戏分区公告*/
	private String notice;
	
	/**公告开关*/
	@Column(nullable = false)
	private Boolean noticeState = Boolean.FALSE;
	
	/**WEB接收地址*/
	private String webUrl;
	
	/**WEB接收成功返回的标识*/
	private String successMark;
	
	/**WEB通讯数据格式*/
	private String dataFormat;
	
	/**是否指定时间更改分区名称*/
	@JpaQuery
	@Column(nullable = false)
	private Boolean isChangeInTime = Boolean.FALSE;
	
	/**分区-使用模版*/
	@JpaQuery(chain = {"name", "currencyName"}, cond = EQ, verify = isBeanId)
	@JsonIgnore
	@JSONField(serialize = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Template template;
	
	/**分区-所属商户*/
	@JpaQuery(chain = {"id", "nickname", "account"}, cond = EQ, verify = isBeanId)
	@JsonIgnore
	@JSONField(serialize = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false)
	private Merchant merchant;
	
	@JsonIgnore
	@OneToMany(mappedBy = "partition")
	@org.hibernate.annotations.ForeignKey(name = "none")
	private List<ReissueRecord> reissueRecords = new ArrayList<ReissueRecord>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "partition")
	@org.hibernate.annotations.ForeignKey(name = "none")
	private List<Order> orders = new ArrayList<Order>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "partition",cascade = CascadeType.REMOVE)
	private List<PartitionGroup> partitionGroups = new ArrayList<PartitionGroup>();
	
	@Transient
	private Group group;
	
	@Transient
	private List<Long> groupIds = new ArrayList<>();
	
	@Transient
	private DbInfo dbInfos;
	
	@Transient
	private String sign;
	
	@Transient
	private Boolean isCreate;
	
	public Result validate(Boolean isWg) {
		if (StringUtils.isEmpty(this.name.trim()) || this.name.length() > 50)
			return Result.error("分区名称不能为空，并且为1-50个字符", "name");
		
		if (isChangeInTime) {
			if (StringUtils.isEmpty(this.useName.trim()) || this.useName.length() > 50)
				return Result.error("更改名称不能为空，并且为1-50个字符", "useName");
		}
		
		if (createDate == null) {
			createDate = new Date();
		}
		
		if (changeDate == null) {
			changeDate = new Date();
		}
		
		if (useDate == null) {
			useDate = new Date();
		}
		
		if (this.groupIds.isEmpty()){
			return Result.error("请选择游戏分组");
		}
		
		if (this.template == null || this.template.getId() == null)
			return Result.error("请选择分区模板", "template.id");
		
		if (this.type != 0 && this.type != 4 && StringUtils.isEmpty(this.scriptPath))
			return Result.error("请设置分区脚本路径", "scriptPath");
		
		if (this.type != 4 && StringUtils.isEmpty(this.serverIp))
			return Result.error("请设置网关通讯IP", "serverIp");

		this.state = Boolean.TRUE;
		this.uuid = IdUtil.fastSimpleUUID();
		if (this.dbInfos != null) {
			this.dbInfo = JSON.toJSONString(this.dbInfos);
		}
		if (!isWg)
			this.merchant = ShiroManager.getPrincipal(Merchant.class);
		return Result.success();
	}
	
	public Partition() {
		
	}
	
	public Partition(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUseDate() {
		return useDate;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Boolean getYbEgg() {
		return ybEgg;
	}

	public void setYbEgg(Boolean ybEgg) {
		this.ybEgg = ybEgg;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getScriptPath() {
		return scriptPath;
	}

	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}

	public String getDbInfo() {
		return dbInfo;
	}

	public void setDbInfo(String dbInfo) {
		this.dbInfo = dbInfo;
		DbInfo info = CommonUtil.parseObject(dbInfo, DbInfo.class);
		info = info==null?new DbInfo():info;
		this.dbInfos = info;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Boolean getNoticeState() {
		return noticeState;
	}

	public void setNoticeState(Boolean noticeState) {
		this.noticeState = noticeState;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getSuccessMark() {
		return successMark;
	}

	public void setSuccessMark(String successMark) {
		this.successMark = successMark;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public DbInfo getDbInfos() {
		return dbInfos;
	}
	
	public void setDbInfos(DbInfo dbInfos) {
		this.dbInfos = dbInfos;
	}
	

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	

	public Boolean getIsCreate() {
		return isCreate;
	}

	public void setIsCreate(Boolean isCreate) {
		this.isCreate = isCreate;
	}

	public List<ReissueRecord> getReissueRecords() {
		return reissueRecords;
	}

	public void setReissueRecords(List<ReissueRecord> reissueRecords) {
		this.reissueRecords = reissueRecords;
	}
	

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<PartitionGroup> getPartitionGroups() {
		return partitionGroups;
	}

	public void setPartitionGroups(List<PartitionGroup> partitionGroups) {
		this.partitionGroups = partitionGroups;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Long> getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(List<Long> groupIds) {
		this.groupIds = groupIds;
	}

	public Boolean getIsChangeInTime() {
		return isChangeInTime;
	}

	public void setIsChangeInTime(Boolean isChangeInTime) {
		this.isChangeInTime = isChangeInTime;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	@Override
	public String toString() {
		return "Partition [id=" + id + ", createDate=" + createDate + ", name=" + name + ", useDate=" + useDate
				+ ", useName=" + useName + ", type=" + type + ", sort=" + sort + ", uuid=" + uuid + ", ybEgg=" + ybEgg
				+ ", state=" + state + ", scriptPath=" + scriptPath + ", dbInfo=" + dbInfo + ", serverIp=" + serverIp
				+ ", serverPort=" + serverPort + ", notice=" + notice + ", noticeState=" + noticeState + "]";
	}
	
}
