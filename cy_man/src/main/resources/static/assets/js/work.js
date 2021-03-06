/**系统登陆*/
function login() {
	var data = {
		username : $("#username").val(),
		password : $("#password").val(),
		ip : $("#cip").val(),
		location : $("#cname").val()
	}
	ajaxSend("post", "/man/login", data, function(data) {
		if (data.state) {
			window.location.href = data.url;
		} else {
			error(data.msg, 2000);
		}
	})
}

/**修改密码*/
function modifyPassModal(e) {
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : "修改密码",
		area : [ '25%', '32%' ],
		fixed : false,
		maxmin : true,
		content : '/man/password?id=' + e
	});
}

/**重置密码*/
function reset(id) {
	layer.confirm('重置密码后,将恢复系统默认登陆密码,是否重置？', {
		btn : [ '重置', '放弃' ] //按钮
	}, function() {
		ajaxSend("get", "/man/password/reset", {
			id : id
		}, function(data) {
			if (data.state)
				success(data.msg, 2000);
			else
				error(data.msg, 2000);
		})

	}, function() {
		layer.msg('放弃重置密码');
	});
}

/*解绑微信服务*/
function unbind(id){
	layer.confirm('是否解绑微信服务？', {
		btn : [ '解绑', '放弃' ] //按钮
	}, function() {
		ajaxSend("get", "/man/unbind", {
			id : id
		}, function(data) {
			if (data.state)
				success("解绑成功", 2000);
			else
				error("解绑失败", 2000);
		})

	}, function() {
		layer.msg('放弃解绑微信服务');
	});
}

/**冻结账户*/
function frozen(id) {
	layer.confirm('是否冻结该商户账户余额？', {
		btn : [ '冻结', '放弃' ] //按钮
	}, function() {
		ajaxSend("post", "/man/bank/frozen", {
			id : id
		}, function(data) {
			if (data.state)
				success(data.msg, 2000);
			else
				error(data.msg, 2000);
		});

	}, function() {
		layer.msg('放弃冻结该商户账户余额');
	});
}

/**商户银行卡iframe*/
function bank(e) {
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : "商户银行卡",
		area : [ '550px', '329px' ],
		fixed : false,
		maxmin : false,
		content : '/man/merchant/bank?' + $.param(e)
	});
}

function testLine(e) {
	$.ajax({
        type: "post",
        url: "/man/line/test",
        data: e,
        success:function(data){
        	if (data.state) {
    			success("连接成功！", 2000);
    		} else {
    			error("连接失败，请检查域名或端口是否有误！", 2000);
    		}
        },
        error: function (e) {
        	error("连接失败，请检查域名或端口是否有误！", 2000);
        }
    });
}

/**移除充值线路*/
function removeLine(options) {
	layer.confirm('是否移除充值线路？', {
		btn : [ '移除', '放弃' ] //按钮
	}, function() {
		var data = {
			_method : "DELETE",
			id : options.id,
		}
		ajaxSend("post", "/man/remove/line", data, function(data) {
			if (data.state) {
				options.render && options.render();
				success("线路移除成功", 2000);
			} else {
				error("线路移除失败", 2000);
			}
		});
	});
}

/**保存充值线路*/
function saveLine(e) {
	ajaxSend("post", "/man/save/line", e, function(data) {
		if (data.state) {
			mainFrame.location.reload();
			success(data.msg, 2000);
		} else {
			error(data.msg, 2000);
		}
	});
}

/**设置默认线路*/
function defaults(id, type) {
	var url = "/man/line/default";
	ajaxSend("post", url, {
		id : id,
		type : type
	}, function(data) {
		if (data.state) {
			mainFrame.location.reload();
			success(data.msg, 2000);
		} else {
			error(data.msg, 2000);
		}
	});
}

/**系统更新*/
function sysUpdate(e) {
	var index = window.parent.layer.load(0, {
		shade : [ 0.7, '#393D49' ]
	}, {
		shadeClose : true
	}); //0代表加载的风格，支持0-2
	ajaxSend("post", "/man/update/sys", e, function(data) {
		if (data.state) {
			window.parent.success(data.msg, 2000, function() {
				window.parent.layer.close(index);
				mainFrame.location.reload();
			});
		} else {
			window.parent.error(data.msg, 2000, function() {
				window.parent.layer.close(index);
			});
		}
	});
}

/**订单详情iframe*/
function orderDetail(orderNumber) {
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : "订单详情",
		area : [ '50%', '553px' ],
		fixed : false,
		maxmin : false,
		content : '/man/order/detail?orderNumber=' + orderNumber
	});
}

/**批复详情iframe*/
function replyDetail(e) {
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : "批复详情",
		area : [ '75%', '70%' ],
		fixed : true,
		maxmin : true,
		content : '/man/reply/detail?serialNumber=' + e,
	});
}

/**通道收款iframe*/
function fundsGallery(e) {
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : "通道收款详情",
		area : [ '50%', '40%' ],
		fixed : true,
		maxmin : true,
		content : '/man/funds/gallery?merchantId=' + e.id
	});
}

/**分区iframe*/
function partition(e) {
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : "分区",
		area : [ '70%', '70%' ],
		fixed : true,
		maxmin : true,
		content : '/man/group/partiton',
		success : function(element, index) {
			element.find("iframe")[0].contentWindow.partition.data = e;
		}
	});
}

/*添加或编辑代付配置*/
function daifuUI(e) {
	var url = "/man/daifu/opration/ui";
	var title = "配置代付";
	if (e != undefined) {
		title = "编辑代付";
		url = "/man/daifu/opration/ui?" + $.param(e);
	}
	var daifu = layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : title,
		area : [ '750px', '609px' ],
		fixed : false,
		maxmin : true,
		content : url
	});
	return function(){layer.close(daifu);};
}

/**添加或编辑用户*/
function user(e) {
	var url = "/man/user/opration/ui";
	var title = "添加用户";
	if (e != undefined) {
		title = "编辑用户"
		url = "/man/user/opration/ui?id=" + e;
	}
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : title,
		area : [ '50%', '50%' ],
		fixed : false,
		maxmin : true,
		content : url,
		cancel : function() {
			mainFrame.location.reload();
		}
	});
}

/**添加角色*/
function role(e) {
	var url = "/man/role/opration/ui";
	var title = "添加角色";
	if (e != undefined) {
		title = "编辑角色"
		url = "/man/role/opration/ui?id=" + e;
	}
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : title,
		area : [ '30%', '25%' ],
		fixed : false,
		maxmin : true,
		content : url,
		cancel : function() {
			mainFrame.location.reload();
		}
	});
}

/**添加产品iframe*/
function product(e) {
	var url = "/man/product/opration/ui";
	var title = "添加产品";
	if (e != null) {
		var param = $.param(e);
		url = "/man/product/opration/ui?" + param;
		title = "编辑产品";
	}
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : title,
		area : [ '550px', '330px' ],
		fixed : false,
		maxmin : true,
		content : url
	});
}

/**添加公告iframe*/
function notice(e) {
	var url = "/man/notice/opration/ui";
	var title = "发布公告";
	if (e != undefined) {
		url = "/man/notice/opration/ui?id=" + e;
		title = "编辑公告";
	}
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : title,
		area : [ '30%', '40%' ],
		fixed : false,
		maxmin : true,
		content : url
	});
}

/**退款*/
function refund(orderNumber) {
	layer.confirm('是否确定对该笔订单进行退款？', {
		btn : [ '确定', '放弃' ] //按钮
	}, function() {
		layer.close(index);
		var index = layer.load(0, {
			shade : [ 0.7, '#393D49' ]
		}, {
			shadeClose : true
		}); //0代表加载的风格，支持0-2
		ajaxSend("get", "/man/order/refund", {
			"orderNumber" : orderNumber
		}, function(data) {
			if (data.state) {
				layer.close(index);
				layer.close(mainFrame.order_detail);
				mainFrame.paging && mainFrame.paging.query();
				success(data.msg, 3000);
			} else {
				layer.close(index);
				error(data.msg, 3000);
			}
		});

	}, function() {
		layer.msg('放弃退款');
	});
}

/**加载层*/
function loading(tip, time) {
	if (time == undefined) {
		var index = layer.msg(tip, {
			icon : 16,
			shade : [ 0.8, '#393D49' ],
			time : 20000
		});
	} else {
		var index = layer.msg(tip, {
			icon : 16,
			shade : [ 0.8, '#393D49' ],
			time : time
		});
	}
	return index;
}



/**删除*/
function del(url, id, confirm) {
	layer.confirm(confirm, {
		btn : [ '确定', '取消' ] //按钮
	}, function(index) {
		layer.close(index);
		ajaxSend("get", url, {
			id : id
		}, function(data) {
			if (data.state) {
				mainFrame.paging.query();
				success(data.msg, 2000);
			} else {
				error(data.msg, 2000);
			}
		});
	});
}

/**
 * 添加通道iframe
 */
function gallery(e) {
	if (e) {
		var url = "/man/gallery/opration/ui";
		var height = (e.signType == 1||e.mark=="wechat") ? "491px" : "435px";
		height = e.isSupportRiskAmount ? "592px" : height;
		url = url + '?' + $.param(e).replace(/%5B/g, ".").replace(/%5D/g, "");
		var gallery_edit = layer.open({
			type : 2,
			skin : 'layui-layer-lan',
			title : "编辑通道",
			area : [ '650px', height ],
			fixed : false,
			maxmin : true,
			content : url
		});
	}
}

/**
 * 费率iframe
 */
function rate(e) {
	var _id = e.id == undefined ? '' : e.id;
	var _agency = e.isAgency == undefined ? '' : e.isAgency;
	var _name = e.name == undefined ? '' : e.name;
	var url = "/man/rate/opration/ui";
	var height = "492px";
	var title = "添加费率";
	if (_id != '') {
		url = "/man/rate/opration/ui?id=" + _id + "&isAgency=" + _agency + "&name=" + _name;
		title = "编辑费率";
	}
	if (!_agency) {
		height = "552px";
	}
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : title,
		area : [ '800px', height ],
		fixed : false,
		maxmin : true,
		content : url
	});
}

/**
 * 通道费率iframe
 */
function galleryRate(e) {
	layer.open({
		type : 2,
		skin : 'layui-layer-lan',
		title : "通道费率",
		area : [ '1000px', '552px' ],
		fixed : false,
		maxmin : true,
		content : '/man/gallery/rate/ui?' + $.param(e).replace(/%5B/g, ".").replace(/%5D/g, "")
	});
}

var systemDate = {
		engines: {engine: "", command: ""},	
		banks: {name: "", mark: ""},	
		fees: {type: "", des: "单笔金额50000以内,大客户洽谈分成！", rate: "联系客服", settleType: "T0"}
}

function systemSet(options) {
	var vm = avalon.define({
		$id: options.id,
		data: {
			engines: options.engines.concat(),
			banks: options.banks.concat(),
			fees: options.fees.concat()
		},
		isRenew: function(mark) {
			return this.data[mark].length < options[mark].length;
		},
		add: function(mark) {
			this.data[mark].push(systemDate[mark]);
		},
		remove: function(mark, index) {
			this.data[mark].splice(index, 1);
		},
		renew: function(mark) {
			this.data[mark] = options[mark].concat();
		}
	});
	return vm;
}

/**
 * 自定义avalonjs公共方法
 */
function work(options) {
	var vm = avalon.define({
		$id : options.id.id,
		data : {},
		render : {},
		dup : {},
		query : function() {
			if (options.query.url != undefined) {
				var param = null;
				if (options.query.param != undefined) {
					param = options.query.param;
				}
				ajaxSend(options.query.type, options.query.url, param, function(data) {
					vm.data = data
				});
			}
		},
		commit : function() {
			if (options.commit.url != undefined) {
				var param = $(options.commit.form).serialize();
				if (options.commit.param != undefined) {
					param = options.commit.param;
				}
				ajaxSend(options.commit.type, options.commit.url, param, function(data) {
					if (data.state) {
						window.parent.success(data.msg, 2000);
						var index = window.parent.layer.getFrameIndex(window.name);
						window.parent.layer.close(index);
						window.parent.mainFrame.paging && window.parent.mainFrame.paging.query();
					} else {
						window.parent.error(data.msg, 2000);
						data.ele && $("input[name="+data.ele+"]").focus();
					}
				});
			}
		}
	});
	if (options.render && typeof options.render === "object") {
		vm.render = $.extend({}, options.render, {
			dropdown : function(e) {
				$(e.target).dropdown(e);
			}
		});
	}
	return vm;
}

/**
 * 设置默认级别
 */
function def(e) {
	var data = {
		_method : "PUT",
		id : e
	}
	ajaxSend("post", "/man/update/rank/default", data, function(result) {
		if (result.state) {
			mainFrame.paging.query();
			success(result.msg, 2000);
		} else {
			error(result.msg, 2000);
		}
	});
}

/**资金操作*/
function settlement(list, url) {
	window.parent.ajaxSend("post", url, JSON.stringify(list), function(data) {
		if (data.state) {
			mainFrame.paging && mainFrame.paging.query();
			success(data.msg, 2000);
		} else {
			error(data.msg, 2000);
		}
	}, "json");
}

/*最小结算金额*/
function minSettlementAmount(flag){
	var minAmount = 0;
	$.ajax({
		type:"get",
	    url: '/man/settlement/minAmount',
	    async: false,
	    data:{"flag":flag ? "t1" : "t0"},
	    success: function(data) {
	    	if (data.state){
	    		 minAmount = data.data;
			}else{
				minAmount = 0;
			}
	    }
	});
	return minAmount;
}

function selectDaiFu(list, url, mark) {
	ajaxSend("get", "/man/daifu/" + mark, null, function(data) {
		var html = "<select id='markName' style='width:100%'>";
		for (var i = 0; i < data.length; i++) {
			html += "<option value='"+data[i][0]+"'>" + data[i][1] + "</option>"
		}
		html += "</select>";
		layer.alert(html, {
			title : '选择付款账号',
		}, function(data) {
			url = url + mark + "/" + $("#markName option:selected").val();
			settlement(list, url);
		});
	});
}

/**
 * ajax请求封装
 */
function ajaxSend(type, url, data, func, flag) {
	if (flag == undefined) {
		$.ajax({
			type : type,
			url : url,
			data : data,
			success : func
		});
	} else {
		$.ajax({
			type : type,
			url : url,
			dataType : "json",
			contentType : 'application/json;charset=utf-8', //设置请求头信息 
			data : data,
			success : func
		});
	}
}

/**
 * layer成功弹框封装
 */
function success(msg, time, func) {
	layer.msg(msg, {
		icon : 1,
		time : time
	}, func || function() {});
}

/**
 * layer失败弹框封装
 */
function error(msg, time, func) {
	layer.msg(msg, {
		icon : 2,
		time : time
	}, func || function() {});
}

/**
 * 拼接html
 * flag = partition:分区拼接
 * flag = rankRate :商户费率拼接
 * flag = galleryRate : 通道费率拼接
 */
function splicing(options) {
	var html = "";
	if (options.flag == "partition") {
		html = partitionHtml(options)
	}
	return html;
}

/*拼接分区*/
function partitionHtml(options){
	var html = "";
	if (options.data.pars.length > 0){
		for (var i = 0; i < options.data.pars.length; i++) {
			html += "<tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">";
			html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">" + (i + 1) + "</td>"
			html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">" + options.data.pars[i].createDate + "</td>";
			html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">" + options.data.pars[i].name + "</td>";
			html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">" + options.data.pars[i].useDate + "</td>";
			html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">" + options.data.pars[i].useName + "</td>";
			html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">" + options.data.pars[i].serverIp + "</td>";
			html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">" + options.data.pars[i].serverPort + "</td>";
			html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\">" + options.data.pars[i].scriptPath + "</td>";
			html += "</tr>";
		}
	}else{
		html +="<tr onMouseOut=\"this.style.backgroundColor='#ffffff'\" onMouseOver=\"this.style.backgroundColor='#edf5ff'\">";
		html += "<td align=\"center\" valign=\"middle\" class=\"borderright borderbottom\" colspan = \"8\" >暂无分区</td>";
		html += "</tr>";
	}
	return html;
}

/**
 * 文件上传
 */
function upload(type, url, data) {
	$.ajax({
		type : type,
		url : url,
		cache : false,
		data : data,
		processData : false,
		contentType : false
	}).done(function(res) {
		if (res.state) {
			success(res.msg, 2000);
		} else {
			error(res.msg, 2000);
		}
	}).fail(function(res) {
		error("文件上传失败!", 2000);
	});
}

function DateFomate(time) {
	var d = new Date(time);
	var month = "";
	var day = "";
	var hours = "";
	var minutes = "";
	var seconds = "";
	if (d.getMonth() > 9) {
		month = (d.getMonth() + 1) + '-';
	} else {
		month = "0" + (d.getMonth() + 1) + '-';
	}
	if (d.getDate() > 9) {
		day = d.getDate() + ' ';
	} else {
		day = "0" + d.getDate() + ' ';
	}
	if (d.getHours() > 9) {
		hours = d.getHours() + ':';
	} else {
		hours = "0" + d.getHours() + ':';
	}
	if (d.getMinutes() > 9) {
		minutes = d.getMinutes() + ':'
	} else {
		minutes = "0" + d.getMinutes() + ":";
	}
	if (d.getSeconds() > 9) {
		seconds = d.getSeconds();
	} else {
		seconds = "0" + d.getSeconds()
	}
	var times = d.getFullYear() + '-' + month + day + hours + minutes + seconds;
	return times;
}

function isNotEmpty(obj){
	if (obj != null && obj != ""){
		return true
	}
	return false;
}