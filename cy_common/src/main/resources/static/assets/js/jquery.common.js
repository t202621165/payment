(function(global, factory) {
	var browser = {
		isIE8: false,
		isIE7: false,
		isIE6: false,
		isMain: false
	}, user_agent = navigator.userAgent.toLowerCase();
	if (user_agent.indexOf("msie 8.0") > -1) {
		browser.isIE8 = true;
	} else if (user_agent.indexOf("msie 7.0") > -1 && user_agent.indexOf("trident/4.0") > -1) {
		browser.isIE8 = true; // IE8兼容模式
	} else if (user_agent.indexOf("msie 7.0") > -1) {
		browser.isIE7 = true;
	} else if (user_agent.indexOf("msie 6.0") > -1) {
		browser.isIE6 = true;
	} else {
		browser.isMain = true;
	}
	
	if (typeof jQuery !== "undefined")
		factory(global, jQuery, browser);
	
})(typeof window !== "undefined" ? window : this, function(window, $, browser) {
	
	$.selectBox = function(selector) {
		selector = selector || ".select-box";
		var selectBoxs = $(selector || ".select-box");
		selectBoxs.each(function(index, element) {
			if (selector == ".select-box" 
				&& element.className.indexOf("select-box-after") > -1) {
				return;
			}
			var item = $(element),
				$inputs = item.find(".select-box-input"),
				$selectLists = item.find(".select-box-list");
			if ($inputs.length > 0 && $selectLists.length > 0) {
				var $selectList = $($selectLists[0]);
				if (browser.isIE6 || browser.isIE7) {
					item.append($('<i class="before">'+item.attr("data-select-box-on")+'</i>'));
					item.append($('<i class="after img-png"></i>'));
					$selectList.css("width", $selectList.outerWidth()+"px");
					$selectList.css("top", $selectList.offset().top+"px");
					$selectList.css("left", $selectList.offset().left+"px");
					$("body").append($selectList);
				}
				
				$selectList.css("display", "none").css("visibility", "visible")
				item.on("click", function(e) {
					var e = e||window.event;
					e.stopPropagation? e.stopPropagation():e.cancelBubble=true;
					if ($selectList.is(":hidden")) {
						$(".select-box-list").css("display", "none").parent().removeClass("select-box-show");
					}
					$selectList.slideToggle(100);
					item.toggleClass("select-box-show");
				});
				
				var $lis = $selectList.find("li");
				$lis.on("click", function(e) {
					$lis.removeClass("selected");
					$(this).addClass("selected");
					$inputs.val($(this).attr("data-value"));
					item.attr("data-select-box-on", $(this).text())
					item.find(".before").text($(this).text())
				});
			}
		});
	};
	$.selectBox();
	
	$("body").on("click", function() {
		$(".select-box-list").css("display", "none").parent().removeClass("select-box-show");
	});
	
	var getValidator = function(message, regExp) {
		return {
			message: message,
			get: function (value, field, next) {
				var ok = regExp.test(value);
				next(ok);
				return value;
			}
		};
	};
	
	if (typeof avalon != "undefined") {
		avalon.config({
			debug: false
		});
		
		avalon.filters.truncateTail = function(str, start, end) {
			var length = Number(start) + Number(end) + 3,result = "";
			var size = str.length;
			if (size <= length) {return str;}
			result = str.slice(0, start) + "..." + str.slice(size-end, size);
			return result;
		};
		
		avalon.filters.isNull = function(str) {
			return str == "" || str == null;
		};

		avalon.filters.parseNull = function(str, reStr) {
			return str || (reStr || "");
		};
		
		avalon.filters.compareToNowDate = function(date, trueData, falseData) {
			return (date > new Date().format("yyyy-MM-dd HH:mm:ss")) ? trueData : falseData;
		};
		
		avalon.filters.dateNotNull = function(date, format) {
			if (date)
				return avalon.filters.date(date, format);
			
			return "--";
		};

		avalon.validators.notnull = {
				message: "不能为空!",
				get: function (value, field, next) {
					var ok = (value && value !== 'null');
					next(ok);
					return value
				}
		};
		avalon.validators.max = {
				message: '输入值不能大于{{max}}',
				get: function get(value, field, next) {
	                var num = parseFloat(field.data.max);
	                next(parseFloat(value) <= num);
	                return value;
	            }
		};
		
		avalon.validators.qqnumber = getValidator("QQ：5-11位非0开头！", /^[1-9]\d{4,}$/);
		
		avalon.validators.phonenumber = getValidator("手机号码输入有误！", /^1[345789]\d{9}$/);
		
		avalon.validators.account = getValidator("请输入数字、字母或下划线！", /^\w+$/);
	}
	
	Date.prototype.format = function(pattern) {
		
		if(!pattern)
			pattern = "yyyy-MM-dd HH:mm:ss";
		
		var Week = ['日', '一', '二', '三', '四', '五', '六'];
		
		var str = pattern.replace(/yyyy|YYYY/, this.getFullYear());
	    str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));
	    var month = this.getMonth() + 1;
	    str = str.replace(/MM/, month > 9 ? month.toString() : '0' + month);
	    str = str.replace(/M/g, month);

	    str = str.replace(/w|W/g, Week[this.getDay()]);

	    str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
	    str = str.replace(/d|D/g, this.getDate());

	    str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
	    str = str.replace(/h|H/g, this.getHours());
	    str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
	    str = str.replace(/m/g, this.getMinutes());

	    str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
	    str = str.replace(/s|S/g, this.getSeconds());
	    return str;
	};
	
	$.fn.extend({
		previousDay: function(pattern) {
			var time = $(this).val().replace(/-/g,':').replace(' ',':');
			time = time.split(':');
			var curDate = new Date(time[0],(time[1]-1),time[2],time[3],time[4],time[5]);
		    var preDate = new Date(), time = curDate.getTime();
		    
	    	if (!isNaN(time))
	    		preDate = new Date(time - 24 * 60 * 60 * 1000);
		    
		    var dateStr = preDate.format(pattern);
		    $(this).val(dateStr);
		    return dateStr;
		},
		today: function(pattern) {
			var dateStr = new Date().format(pattern);
			$(this).val(dateStr);
			return dateStr;
		},
		nextDay: function(pattern) {
			var time = $(this).val().replace(/-/g,':').replace(' ',':');
			time = time.split(':');
			var curDate = new Date(time[0],(time[1]-1),time[2],time[3],time[4],time[5]);
			var preDate = new Date(), time = curDate.getTime();
			
			if (!isNaN(time)) {
				preDate = new Date(time + 24 * 60 * 60 * 1000);
				if (new Date().toDateString() == preDate.toDateString()) {
					var dateStr = preDate.format(pattern);
					$(this).val(dateStr);
					return true;
				}
			}
			
			var dateStr = preDate.format(pattern);
			$(this).val(dateStr);
			return false;
		},
		dropdown: function(e) {
			e.stopPropagation();
			if ($(this).attr("data-on") == "true") {
				$(this).attr("data-on", false).parent().removeClass("on");
			}else {
				$(".btn-list.on").removeClass("on").find("a").attr("data-on", false);
				$(this).attr("data-on", true).parent().addClass("on");
			}
			
			$(document).off().on("click", function() {
				if ($(".btn-list.on").length > 0)
					$(".btn-list.on").removeClass("on").find("a").attr("data-on", false);
			});
			
		}
	});
	
	$.paging = function(_id, options, form) {
		var paging = avalon.define({
			$id: _id,
			isToday: true,
			param: $(form?""+form+"":"#search").serialize(),
			render: {},
			data: {number: -1, totalPages: 0, totalElements: 0, extra: {}},
			extra:{},
			opacity: 0,
			query: function() {
				this.postData();
			},
			postData: function() {
				$(".batch-check tr").find(":first .label-box input").prop("checked", false).parent().removeClass("label-box-checked");
				$(".cy-batchs").prop("disabled", true);
				$("[name=number]").val(this.data.number);
				this.param = $(form?""+form+"":"#search").serialize();
				var _this = this;
				$.ajax({
					url: _id+"/list",
					data: _this.param,
					isPaging: true,
					success: function(data) {
						_this.opacity = 1;
						if (data.page != undefined){
							if (data) _this.data = data.page;
							_this.extra = data;
						}else{
							if (data) _this.data = data;
						}													
					}
				});
			},
			first: function() {
				if (this.data.number > 0) {
					this.data.number = 0;
					this.postData();
				}else {
					$.modalmsg && $.modalmsg("当前已是第一页！");
				}
			},
			prev: function() {
				if (this.data.number > 0) {
					 this.data.number--;
				}else {
					this.data.number = this.data.totalPages - 1;
				}
				this.postData();
			},
			next: function() {
				if (this.data.number < this.data.totalPages - 1) {
					this.data.number++;
				}else {
					this.data.number = 0;
				}
				this.postData();
			},
			last: function() {
				if (this.data.number < this.data.totalPages - 1) {
					this.data.number = this.data.totalPages - 1;
					this.postData();
				}else {
					$.modalmsg && $.modalmsg("当前已是最后一页！");
				}
			},
			checkAll: function(e) {
				if(e.target.checked !== undefined) {
					var isChecked = e.target.checked,$item=$(e.target),$inputs = $("tbody.batch-check tr").find(":first .label-box input");
					$inputs.prop("checked", isChecked);
					if (isChecked) {
						$item.parent().addClass("label-box-checked");
						$inputs.parent().addClass("label-box-checked");
					} else {
						$item.parent().removeClass("label-box-checked");
						$inputs.parent().removeClass("label-box-checked");
					}
					
					$(".cy-batchs").prop("disabled", !isChecked);
				}
			},
			checkOne: function(e) {
				var isCheck = $("tbody.batch-check tr").find(":first .label-box input:checked").length;
				var disabled = true;
				if (isCheck > 0) {
					disabled = false;
				}
				
				var $item=$(e.target),$input = $("thead.batch-check tr").find(":first .label-box input");
				$input.prop("checked", isCheck)
				if (isCheck) {
					$input.parent().addClass("label-box-checked");
				} else {
					$input.parent().removeClass("label-box-checked");
				}
				if (e.target.checked) {
					$item.parent().addClass("label-box-checked");
				} else {
					$item.parent().removeClass("label-box-checked");
				}
				$(".cy-batchs").prop("disabled", disabled);
			},
			batch: function() {
				var paging = this;
				$(".cy-batchs.cy-on").off().on("click", function(){
					var url = $(this).attr("data-url");
					var batch = $(this).attr("data-batch");
					if (url && batch) {
						var doBatch = paging[batch] || paging.render[batch];
						doBatch && doBatch(url);
					}
				});
			},
			batchDel: function(url) {
				var change = this.change;
				var array = $("tbody.batch-check tr").find(":first input:checked");
				if (url && array.length > 0) {
					$.confirm({
						content: "\u5220\u9664\u540e\u6570\u636e\u5c06\u65e0\u6cd5\u6062\u590d\uff0c\u662f\u5426\u786e\u5b9a\uff1f",
						yes: function() {
							$.ajax({
								url: url,
								data: array.serialize(),
								load: false,
								success: function(data) {
									$.modalmsg(data.msg);
									if (data.state)
										change();
								}
							});
							return true;
						}
					});
				}
			},
			change: function(e) {
				this.data.number = 0;
				this.postData();
			},
			checkNav: function(e) {
				$(".nav a").removeClass("active");
				$(e.target).addClass("active");
				$("[name="+$(e.target).attr("data-nav-name")+"]")
					.val($(e.target).attr("data-nav-value"));
				
				this.data.number = 0;
				this.postData();
			},
			jump: function() {
				var jumpto = $("#jumpto").val();
				if (jumpto && !isNaN(jumpto)) {
					jumpto--;
					if (jumpto >= 0 && jumpto < this.data.totalPages) {
						this.data.number = jumpto;
						this.postData();
					}else {
						$("#jumpto").focus();
						$.modalmsg && $.modalmsg("不可超过当前最大页数！", "error");
					}
				}else {
					$("#jumpto").focus();
					$.modalmsg && $.modalmsg("请输入有效页数！", "error");
				}
			},
			previousDay: function() {
				this.isToday = false;
				this.data.number = 0;
				$("#startDate").previousDay("yyyy-MM-dd 00:00:00");
				$("#endDate").previousDay("yyyy-MM-dd 23:59:59");
				this.postData();
			},
			today: function() {
				this.isToday = true;
				this.data.number = 0;
				$("#startDate").today("yyyy-MM-dd 00:00:00");
				$("#endDate").today("yyyy-MM-dd 23:59:59");
				this.postData();
			},
			nextDay: function(e) {
				if (this.isToday) return;
					
				this.isToday = $("#startDate").nextDay("yyyy-MM-dd 00:00:00");
				this.isToday?$("#endDate").today("yyyy-MM-dd 23:59:59"):$("#endDate").nextDay("yyyy-MM-dd 23:59:59");
				this.data.number = 0;
				this.postData();
			},
			merge: function(data) {
				this.render.merge && this.render.merge(data);
			}
		});
		
		if (options && typeof options === "object") {
			paging.render = $.extend({}, options, {
				dropdown: function(e) {
					$(e.target).dropdown(e);
				},
				callback: function() {
					paging.query();
				}
			});
		}
		
		paging.batch();
		paging.postData();
		return paging;
	};
	
	$.customPage = function(options) {
		var page = avalon.define({
			$id: options.id,
			param: null,
			data: {number: -1, totalPages: 0, totalElements: 0, size: 10, content:[]},
			tabData: null,
			isAgency: false,
			query: function() {
				this.param = $(options.form).serialize();
				var _this = this;
				$.ajax({
					url: options.url,
					data: _this.param,
					success: function(data) {
						if (data) {
							_this.data.content = data;
							if (options.render) {
								options.render(data);
							} else {
								_this.tab();
							}
						}
					}
				});
			},
			tab: function() {
				this.data.number = 0;
				this.data.totalElements = this.data.content.length;
				this.page();
			},
			page: function() {
				var data = this.data.content, tabData = [];
				var start = this.data.size * this.data.number;
				var end = this.data.size * (this.data.number+1);
				this.data.totalPages = Math.ceil(
						this.data.content.length/this.data.size);
				end = end > data.length?data.length:end;
				for (var i = start; i < end; i++) {
					if (options.page) {
						tabData.push(options.page(data[i], i));
					} else {
						tabData.push(data[i]);
					}
					
				}
				this.tabData = tabData;
			},
			first: function() {
				this.data.number = 0;
				this.page();
			},
			prev: function() {
				if (this.data.number > 0) {
					 this.data.number--;
				}else {
					this.data.number = this.data.totalPages - 1;
				}
				this.page();
			},
			next: function() {
				if (this.data.number < this.data.totalPages - 1) {
					this.data.number++;
				}else {
					this.data.number = 0;
				}
				this.page();
			},
			last: function() {
				this.data.number = this.data.totalPages - 1;
				this.page();
			},
			change: function(e) {
				this.data.number = 0;
				this.data.size = $("#pageSize").val();
				this.page();
			},
			jump: function() {
				var jumpto = $("#jumpto").val();
				if (jumpto && !isNaN(jumpto)) {
					jumpto--;
					if (jumpto >= 0 && jumpto < this.data.totalPages) {
						this.data.number = jumpto;
						this.page();
					}else {
						$("#jumpto").focus();
					}
				}else {
					$("#jumpto").focus();
				}
			}
		});
		page.query();
	};
});