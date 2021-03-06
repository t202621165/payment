(function($) {
	var _ajax = $.ajax;
	$.ajax = function(options) {
		var _options = $.extend({}, $.ajax.fn, options);
		return _ajax(_options);
	};
	
	$.ajax.fn = {
		type: "POST",
		ele: "",
		isDis: true,
		load: true,
		isPaging: false,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			$.modalmsg("\u7cfb\u7edf\u5f02\u5e38\uff01", "danger");
		},
		beforeSend: function(XHR) {
			if (this.load && this.isPaging)
				$(".load-box").css("display", "block");
			
			if(event && this.isDis) {
				this.ele = $(event.target);
				this.ele.attr("disabled", true);
			}
		},
		complete: function(XHR, TS) {
			if (this.load && this.isPaging)
				$(".load-box").css("display", "none");
			
			this.isDis && this.ele && this.ele.attr("disabled", false);
			
			this.render && this.render();
		}
	};
	
	$.fn.combobox = function(options) {
		var _this = $(this);
		
		if(_this.length <= 0 || !options)
			return;
		
		if (typeof options != "object")
			return;
		
		var _options = $.extend({}, $.fn.combobox._defaults, options);
		var url = _options.url;
		if(!url)
			return;
		
		$.getJSON(url, _options.param, function(data) {
			if (!data)
				return;
			var template = _options.template;
			if (!_options.isDefault) {
				_this.empty();
				_this.append(("<option value=''>"+_options.placeholder+"</option>"));
			}
			
			$.each(data, function(index, item) {
				var _value = _options.valuePrefix+item[_options.valueField],
					text = item[_options.textField],_option;
				if (template) {
					_option = $(template.replace(/(@value)/g, _value).replace(/(@text)/g, text));
				} else {
					_option = $("<option>").val(_value).text(item[_options.textField]);
				}
				
				_option.prop("title",text).attr("data-index", index);
				var selectedVal = _options.selectedVal;
				if (selectedVal && _value == selectedVal) {
					if (_this.is("select")) {
						_option.prop("selected", true);
					} else {
						_option.addClass("selected");
					}
				}
				
				_this.append(_option);
			});

			if (typeof _options.callback === "function") {
				_options.callback(data, _this);
			}
			
			var change = _options.change;
			if(change && typeof change == "function") {
				_options.execute && change(data, _this);
				if (_this.is("select")) {
					_this.on("change", function(e) {
						change(data, $(e.target));
					});
				} else {
					_this.children().on("click", function(e) {
						change(data, $(e.target));
					});
				}
			}
		});
		
	};
	
	$.fn.combobox._defaults = {
		url: null,
		param: null,
		textField: "name",
		valueField: "id",
		selectedVal: "",
		valuePrefix: "",
		placeholder: "-\u8bf7\u9009\u62e9-",
		change: null
	};
	
	var _tooltip;
	$._tooltip = function() {
		$("[data-tooltip-title]").on("mouseout",function (){
			$(".tooltip-title").remove();
		});
		$("[data-tooltip-title]").on("mouseover",function (){
			var _title = $(this).attr("data-tooltip-title");
			if (_title) {
				if (!_tooltip) {
					_tooltip = $("<div>").addClass("tooltip-title").append(
						$("<div>").addClass("tooltip-content")
					).append(
						$("<div>").addClass("tooltip-arrow")
					).css("display", "none");
				}
				_tooltip.appendTo(document.body).find(".tooltip-content").text(_title);
				var _x = $(this).offset().left + parseInt($(this).css("width"))/2 - parseInt($(_tooltip).css("width"))/2 + "px";
				var _y = $(this).offset().top + parseInt($(this).css("height"))/2 + parseInt($(_tooltip).css("height"))/2 + 12 + "px";
				_tooltip.css("left", _x).css("top", _y).css("display", "block");
			}
		});
	};
	
	$.modalmsg = function(content, type) {
		$(".tooltip-msg").remove();
		
		var _msg = $("<div>").addClass("tooltip-msg");
		type && _msg.addClass(type);
		
		$("<div>").addClass("tooltip-content").append(content).appendTo(_msg);
		
		_msg.appendTo(document.body);
		setTimeout(function() {
			_msg.animate({opacity: "0"}, 500, function() {
				_msg.remove();
			});
		}, 2000);
	};
	
	$.modalload = function(content, time, callback) {
		$(".tooltip-msg").remove();
		
		var _msg = $("<div>").addClass("tooltip-msg");
		
		$("<div>").addClass("tooltip-content").append(content).appendTo(_msg);
		
		_msg.appendTo(document.body);
		setTimeout(function() {
			_msg.animate({opacity: "0"}, 1000, function() {
				_msg.remove();
				callback && callback();
			});
		}, time||600);
	};
	
	var _modalbox, _shade;
	$.modalbox = function(options, isConfirm) {
		if (!_shade) {
			_shade = $("<div>").addClass("modal-shade");
		}
		
		if (!_modalbox) {
			_modalbox = $("<div>").addClass("modal-box").append(
				$("<div>").addClass("modal-box-title").append($("<span class='title'></span>"))
					.append($("<span class='modal-close'>\u00d7</span>"))
			).append(
				$("<div>").addClass("modal-box-body").append(
					$("<div>").addClass("modal-box-content")
				).append(
					$("<div>").addClass("modal-box-footer").append(
						$("<button>").attr("id", "confirm").addClass("btn").text("\u786e\u5b9a")
					).append(
						$("<button>").attr("id", "cancel").addClass("btn btn-danger").text("\u53d6\u6d88")
					)	
				)
			);
		}
		_modalbox.removeClass("modal-dialog");
		
		if (isConfirm)
			_modalbox.addClass("modal-dialog");
			
		_modalbox.find(".title").text((options && options.title)?options.title:"\u786e\u8ba4\u4fe1\u606f\uff1f");
		
		_modalbox.find(".modal-box-content").empty().append((options && options.content)?options.content:"\u8bf7\u786e\u8ba4\u5f53\u524d\u64cd\u4f5c\uff01");
		
		_modalbox.find("#confirm").on("click", function() {
			var success = true, data;
			if (options.validate) {
				_modalbox.find("[name]").each(function(i, item) {
					if (!item.value) {
						$.modalmsg("\u4e0d\u80fd\u4e3a\u7a7a\uff01", "top-200")
						item.focus();
						success = false;
						return false;
					}
				});
			}
			
			if (success) {
				options && options.yes && options.yes(_modalbox.find("[name]").serialize())
				&& $(this).parents(".modal-shade").remove();
			}
		});
		
		_modalbox.find(".modal-close").on("click", function() {
			$(this).parents(".modal-shade").remove();
		});
		
		_modalbox.find("#cancel").on("click", function() {
			$(this).parents(".modal-shade").remove();
			options && options.no && options.no();
		});
		_shade.append(_modalbox).appendTo(document.body);
	};
	
	$.confirm = function(options) {
		$.modalbox(options, true);
	};
	
	$.fn.formvalidate = function(render, modaltype) {
		var _form = $(this);
		var forms = _form.find("[data-rule]");
		var rules = [];
		for (var i = 0; i < forms.length; i++) {
			var rule = eval("("+$(forms[i]).attr("data-rule")+")");
			for (var it in rule) {
				attribute[it] && rules.push(validators($(forms[i]), rule[it], it));
			}
			$(forms[i]).removeAttr("data-rule");
		}
		
		_form.find("#form-commit").on("click", function() {
			var className = this.className;
			if (className.indexOf("disabled") != -1) {
				if (className.indexOf("required-clause") != -1) {
					$.modalmsg("请先阅读并勾选本站服务条款", modaltype||"");
				}
				return;
			}
			for (var i in rules) {
				if (!rules[i].validate(modaltype)) {
					return;
				}
			}
			
			var _this = $(this);
			_this.attr("disabled", true);
			render && render(_form.serialize(), function() {
				_this.attr("disabled", false);
			});
		});
	};
	
	var validators = function(element, rule, attr) {
		return $.extend({
			element: element,
			rule: rule,
			validate: function(modaltype) {
				if (this.before && this.before()) {
					return true;
				}
					
				if (this.regExp && this.regExp.test(this.element.val())) {
					if (this.around) {
						if (this.around()) {
							return true;
						}
						
						this.element.focus();
						$.modalmsg(this.element.attr("data-rule-msg")||this.message, modaltype||"");
						return false;
					}
					return true;
				}
				
				if (this.after && this.after()) {
					return true;
				}
				
				this.element.focus();
				$.modalmsg(this.element.attr("data-rule-msg")||this.message, modaltype||"");
			}
		}, attribute[attr]);
	};
	
	var attribute = {
		account: {
			regExp: /^\w+$/,
			message: "\u8bf7\u8f93\u5165\u6570\u5b57\u3001\u5b57\u6bcd\u6216\u4e0b\u5212\u7ebf\uff01",
			around: function() {
				if (this.rule instanceof Array) {
					var len = this.element.val().length;
					if (len < this.rule[0]) {
						return false;
					}
					
					if (this.rule[1] && this.rule[1] > this.rule[0] && len > this.rule[1]) {
						return false;
					}
					return true;
				}
			}
		},
		pwd: {
			regExp: /^\w{6,20}$/,
			message: "\u5bc6\u7801\u75316~20\u4e2a\u82f1\u6587\u5b57\u6bcd\u3001\u6570\u5b57\u548c\u4e0b\u5212\u7ebf\u7ec4\u6210\uff01"
		},
		length: {
			message: "",
			after: function() {
				if (this.rule instanceof Array) {
					var len = this.element.val().length;
					if (len < this.rule[0]) {
						this.message = "输入不能低于" + this.rule[0] + "个字符！";
						return false;
					}
					
					if (this.rule[1] && this.rule[1] > this.rule[0] && len > this.rule[1]) {
						this.message = "输入不能超过" + this.rule[1] + "个字符！";
						return false;
					}
					return true;
				}
			}
		},
		qqnumber: {
			regExp: /^[1-9]\d{4,}$/,
			message: "QQ\uff1a5-11\u4f4d\u975e0\u5f00\u5934\uff01",
			before: function() {
				if (!this.rule && this.element.val() == "") {
					return true;
				}
			}
		},
		phonenumber: {
			regExp: /^1[345789]\d{9}$/,
			message: "\u624b\u673a\u53f7\u7801\u8f93\u5165\u6709\u8bef\uff01",
			before: function() {
				if (!this.rule && this.element.val() == "") {
					return true;
				}
			}
		},
		equalto: {
			regExp: null,
			message: "\u4e24\u6b21\u8f93\u5165\u4e0d\u4e00\u81f4\uff01",
			after: function() {
				if (this.rule && this.element.val() == $("#"+this.rule).val()) {
					return true;
				}
			}
		},
		digits: {
			regExp: /^[1-9]\d*$/,
			message: "\u8bf7\u8f93\u5165\u6574\u6570\uff01",
			around: function() {
				if (this.rule instanceof Array) {
					if (this.element.val() < this.rule[0]) {
						this.message = "\u4e0d\u80fd\u5c0f\u4e8e"+this.rule[0]+"\uff01";
						return false;
					}
					if (this.element.val() > this.rule[1]) {
						this.message = "\u4e0d\u80fd\u5927\u4e8e"+this.rule[1]+"\uff01";
						return false;
					}
				}
				return true;
			}
		},
		required: {
			message: "\u4e0d\u80fd\u4e3a\u7a7a\uff01",
			after: function() {
				if (this.element.val() != "") {
					return true;
				}
			}
		}
	};
})(jQuery);