/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "/";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./src/app.jsx");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/assertThisInitialized.js":
/*!********************************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/assertThisInitialized.js ***!
  \********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function _assertThisInitialized(self) {
  if (self === void 0) {
    throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
  }

  return self;
}

module.exports = _assertThisInitialized;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js":
/*!*************************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function _classCallCheck(instance, Constructor) {
  if (!(instance instanceof Constructor)) {
    throw new TypeError("Cannot call a class as a function");
  }
}

module.exports = _classCallCheck;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js":
/*!**********************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function _defineProperties(target, props) {
  for (var i = 0; i < props.length; i++) {
    var descriptor = props[i];
    descriptor.enumerable = descriptor.enumerable || false;
    descriptor.configurable = true;
    if ("value" in descriptor) descriptor.writable = true;
    Object.defineProperty(target, descriptor.key, descriptor);
  }
}

function _createClass(Constructor, protoProps, staticProps) {
  if (protoProps) _defineProperties(Constructor.prototype, protoProps);
  if (staticProps) _defineProperties(Constructor, staticProps);
  return Constructor;
}

module.exports = _createClass;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js":
/*!*************************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function _getPrototypeOf(o) {
  module.exports = _getPrototypeOf = Object.setPrototypeOf ? Object.getPrototypeOf : function _getPrototypeOf(o) {
    return o.__proto__ || Object.getPrototypeOf(o);
  };
  return _getPrototypeOf(o);
}

module.exports = _getPrototypeOf;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js":
/*!*******************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var setPrototypeOf = __webpack_require__(/*! ./setPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/setPrototypeOf.js");

function _inherits(subClass, superClass) {
  if (typeof superClass !== "function" && superClass !== null) {
    throw new TypeError("Super expression must either be null or a function");
  }

  subClass.prototype = Object.create(superClass && superClass.prototype, {
    constructor: {
      value: subClass,
      writable: true,
      configurable: true
    }
  });
  if (superClass) setPrototypeOf(subClass, superClass);
}

module.exports = _inherits;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js":
/*!********************************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js ***!
  \********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function _interopRequireDefault(obj) {
  return obj && obj.__esModule ? obj : {
    "default": obj
  };
}

module.exports = _interopRequireDefault;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireWildcard.js":
/*!*********************************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireWildcard.js ***!
  \*********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var _typeof = __webpack_require__(/*! ../helpers/typeof */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/typeof.js");

function _getRequireWildcardCache() {
  if (typeof WeakMap !== "function") return null;
  var cache = new WeakMap();

  _getRequireWildcardCache = function _getRequireWildcardCache() {
    return cache;
  };

  return cache;
}

function _interopRequireWildcard(obj) {
  if (obj && obj.__esModule) {
    return obj;
  }

  if (obj === null || _typeof(obj) !== "object" && typeof obj !== "function") {
    return {
      "default": obj
    };
  }

  var cache = _getRequireWildcardCache();

  if (cache && cache.has(obj)) {
    return cache.get(obj);
  }

  var newObj = {};
  var hasPropertyDescriptor = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var key in obj) {
    if (Object.prototype.hasOwnProperty.call(obj, key)) {
      var desc = hasPropertyDescriptor ? Object.getOwnPropertyDescriptor(obj, key) : null;

      if (desc && (desc.get || desc.set)) {
        Object.defineProperty(newObj, key, desc);
      } else {
        newObj[key] = obj[key];
      }
    }
  }

  newObj["default"] = obj;

  if (cache) {
    cache.set(obj, newObj);
  }

  return newObj;
}

module.exports = _interopRequireWildcard;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js":
/*!************************************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js ***!
  \************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var _typeof = __webpack_require__(/*! ../helpers/typeof */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/typeof.js");

var assertThisInitialized = __webpack_require__(/*! ./assertThisInitialized */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/assertThisInitialized.js");

function _possibleConstructorReturn(self, call) {
  if (call && (_typeof(call) === "object" || typeof call === "function")) {
    return call;
  }

  return assertThisInitialized(self);
}

module.exports = _possibleConstructorReturn;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/setPrototypeOf.js":
/*!*************************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/setPrototypeOf.js ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function _setPrototypeOf(o, p) {
  module.exports = _setPrototypeOf = Object.setPrototypeOf || function _setPrototypeOf(o, p) {
    o.__proto__ = p;
    return o;
  };

  return _setPrototypeOf(o, p);
}

module.exports = _setPrototypeOf;

/***/ }),

/***/ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/typeof.js":
/*!*****************************************************************************!*\
  !*** ./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/typeof.js ***!
  \*****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function _typeof2(obj) { if (typeof Symbol === "function" && typeof Symbol.iterator === "symbol") { _typeof2 = function _typeof2(obj) { return typeof obj; }; } else { _typeof2 = function _typeof2(obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; }; } return _typeof2(obj); }

function _typeof(obj) {
  if (typeof Symbol === "function" && _typeof2(Symbol.iterator) === "symbol") {
    module.exports = _typeof = function _typeof(obj) {
      return _typeof2(obj);
    };
  } else {
    module.exports = _typeof = function _typeof(obj) {
      return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : _typeof2(obj);
    };
  }

  return _typeof(obj);
}

module.exports = _typeof;

/***/ }),

/***/ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js":
/*!*********************************************************!*\
  !*** ./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(global) {/**
 * IE6+，有问题请加QQ 370262116 by 司徒正美 Copyright 2019-09-10
 */

(function (global, factory) {
     true ? module.exports = factory() :
    undefined;
}(this, (function () {
    var arrayPush = Array.prototype.push;
    var innerHTML = 'dangerouslySetInnerHTML';
    var hasOwnProperty = Object.prototype.hasOwnProperty;
    var gSBU = 'getSnapshotBeforeUpdate';
    var gDSFP = 'getDerivedStateFromProps';
    var hasSymbol = typeof Symbol === 'function' && Symbol['for'];
    var effects = [];
    var topFibers = [];
    var topNodes = [];
    var emptyObject = {};
    var REACT_ELEMENT_TYPE = hasSymbol ? Symbol['for']('react.element') : 0xeac7;
    function noop() {}
    function Fragment(props) {
        return props.children;
    }
    function returnFalse() {
        return false;
    }
    function returnTrue() {
        return true;
    }
    function resetStack(info) {
        keepLast(info.containerStack);
        keepLast(info.contextStack);
    }
    function keepLast(list) {
        var n = list.length;
        list.splice(0, n - 1);
    }
    function get(key) {
        return key._reactInternalFiber;
    }
    var __type = Object.prototype.toString;
    var fakeWindow = {};
    function getWindow() {
        try {
            if (window) {
                return window;
            }
        } catch (e) {        }
        try {
            if (global) {
                return global;
            }
        } catch (e) {        }
        return fakeWindow;
    }
    function isMounted(instance) {
        var fiber = get(instance);
        return !!(fiber && fiber.hasMounted);
    }
    function toWarnDev(msg, deprecated) {
        msg = deprecated ? msg + ' is deprecated' : msg;
        var process = getWindow().process;
        if (process && process.env.NODE_ENV === 'development') {
            throw msg;
        }
    }
    function extend(obj, props) {
        for (var i in props) {
            if (hasOwnProperty.call(props, i)) {
                obj[i] = props[i];
            }
        }
        return obj;
    }
    function inherit(SubClass, SupClass) {
        function Bridge() {}
        var orig = SubClass.prototype;
        Bridge.prototype = SupClass.prototype;
        var fn = SubClass.prototype = new Bridge();
        extend(fn, orig);
        fn.constructor = SubClass;
        return fn;
    }
    try {
        var supportEval = Function('a', 'return a + 1')(2) == 3;
    } catch (e) {}
    var rname = /function\s+(\w+)/;
    function miniCreateClass(ctor, superClass, methods, statics) {
        var className = ctor.name || (ctor.toString().match(rname) || ['', 'Anonymous'])[1];
        var Ctor = supportEval ? Function('superClass', 'ctor', 'return function ' + className + ' (props, context) {\n            superClass.apply(this, arguments); \n            ctor.apply(this, arguments);\n      }')(superClass, ctor) : function ReactInstance() {
            superClass.apply(this, arguments);
            ctor.apply(this, arguments);
        };
        Ctor.displayName = className;
        var proto = inherit(Ctor, superClass);
        extend(proto, methods);
        extend(Ctor, superClass);
        if (statics) {
            extend(Ctor, statics);
        }
        return Ctor;
    }
    var lowerCache = {};
    function toLowerCase(s) {
        return lowerCache[s] || (lowerCache[s] = s.toLowerCase());
    }
    function isFn(obj) {
        return __type.call(obj) === '[object Function]';
    }
    var rword = /[^, ]+/g;
    function oneObject(array, val) {
        if (array + '' === array) {
            array = array.match(rword) || [];
        }
        var result = {},
        value = val !== void 666 ? val : 1;
        for (var i = 0, n = array.length; i < n; i++) {
            result[array[i]] = value;
        }
        return result;
    }
    var rcamelize = /[-_][^-_]/g;
    function camelize(target) {
        if (!target || target.indexOf('-') < 0 && target.indexOf('_') < 0) {
            return target;
        }
        var str = target.replace(rcamelize, function (match) {
            return match.charAt(1).toUpperCase();
        });
        return firstLetterLower(str);
    }
    function firstLetterLower(str) {
        return str.charAt(0).toLowerCase() + str.slice(1);
    }
    var numberMap = {
        '[object Boolean]': 2,
        '[object Number]': 3,
        '[object String]': 4,
        '[object Function]': 5,
        '[object Symbol]': 6,
        '[object Array]': 7
    };
    function typeNumber(data) {
        if (data === null) {
            return 1;
        }
        if (data === void 666) {
            return 0;
        }
        var a = numberMap[__type.call(data)];
        return a || 8;
    }

    function createRenderer(methods) {
        return extend(Renderer, methods);
    }
    var middlewares = [];
    var Renderer = {
        controlledCbs: [],
        mountOrder: 1,
        macrotasks: [],
        boundaries: [],
        onBeforeRender: noop,
        onAfterRender: noop,
        onDispose: noop,
        middleware: function middleware(obj) {
            if (obj.begin && obj.end) {
                middlewares.push(obj);
            }
        },
        updateControlled: function updateControlled() {},
        fireMiddlewares: function fireMiddlewares(begin) {
            var index = begin ? middlewares.length - 1 : 0,
                delta = begin ? -1 : 1,
                method = begin ? "begin" : "end",
                obj = void 0;
            while (obj = middlewares[index]) {
                obj[method]();
                index += delta;
            }
        },
        currentOwner: null
    };

    var fakeObject = {
        enqueueSetState: returnFalse,
        isMounted: returnFalse
    };
    function Component(props, context) {
        Renderer.currentOwner = this;
        this.context = context;
        this.props = props;
        this.refs = {};
        this.updater = fakeObject;
        this.state = null;
    }
    Component.prototype = {
        constructor: Component,
        replaceState: function replaceState() {
            toWarnDev("replaceState", true);
        },
        isReactComponent: returnTrue,
        isMounted: function isMounted$$1() {
            toWarnDev("isMounted", true);
            return this.updater.isMounted(this);
        },
        setState: function setState(state, cb) {
            this.updater.enqueueSetState(get(this), state, cb);
        },
        forceUpdate: function forceUpdate(cb) {
            this.updater.enqueueSetState(get(this), true, cb);
        },
        render: function render() {
            throw "must implement render";
        }
    };

    var RESERVED_PROPS = {
        key: true,
        ref: true,
        __self: true,
        __source: true
    };
    function makeProps(type, config, props, children, len) {
        var defaultProps = void 0,
            propName = void 0;
        for (propName in config) {
            if (hasOwnProperty.call(config, propName) && !RESERVED_PROPS.hasOwnProperty(propName)) {
                props[propName] = config[propName];
            }
        }
        if (type && type.defaultProps) {
            defaultProps = type.defaultProps;
            for (propName in defaultProps) {
                if (props[propName] === undefined) {
                    props[propName] = defaultProps[propName];
                }
            }
        }
        if (len === 1) {
            props.children = children[0];
        } else if (len > 1) {
            props.children = children;
        }
        return props;
    }
    function hasValidRef(config) {
        return config.ref !== undefined;
    }
    function hasValidKey(config) {
        return config.key !== undefined;
    }
    function createElement(type, config) {
        for (var _len = arguments.length, children = Array(_len > 2 ? _len - 2 : 0), _key = 2; _key < _len; _key++) {
            children[_key - 2] = arguments[_key];
        }
        var props = {},
            tag = 5,
            key = null,
            ref = null,
            argsLen = children.length;
        if (type && type.call) {
            tag = type.prototype && type.prototype.render ? 2 : 1;
        } else if (type + '' !== type) {
            toWarnDev('React.createElement: type is invalid.');
        }
        if (config != null) {
            if (hasValidRef(config)) {
                ref = config.ref;
            }
            if (hasValidKey(config)) {
                key = '' + config.key;
            }
        }
        props = makeProps(type, config || {}, props, children, argsLen);
        return ReactElement(type, tag, props, key, ref, Renderer.currentOwner);
    }
    function cloneElement(element, config) {
        var props = Object.assign({}, element.props);
        var type = element.type;
        var key = element.key;
        var ref = element.ref;
        var tag = element.tag;
        var owner = element._owner;
        for (var _len2 = arguments.length, children = Array(_len2 > 2 ? _len2 - 2 : 0), _key2 = 2; _key2 < _len2; _key2++) {
            children[_key2 - 2] = arguments[_key2];
        }
        var argsLen = children.length;
        if (config != null) {
            if (hasValidRef(config)) {
                ref = config.ref;
                owner = Renderer.currentOwner;
            }
            if (hasValidKey(config)) {
                key = '' + config.key;
            }
        }
        props = makeProps(type, config || {}, props, children, argsLen);
        return ReactElement(type, tag, props, key, ref, owner);
    }
    function createFactory(type) {
        var factory = createElement.bind(null, type);
        factory.type = type;
        return factory;
    }
    function ReactElement(type, tag, props, key, ref, owner) {
        var ret = {
            type: type,
            tag: tag,
            props: props
        };
        if (tag !== 6) {
            ret.$$typeof = REACT_ELEMENT_TYPE;
            ret.key = key || null;
            var refType = typeNumber(ref);
            if (refType === 2 || refType === 3 || refType === 4 || refType === 5 || refType === 8) {
                if (refType < 4) {
                    ref += '';
                }
                ret.ref = ref;
            } else {
                ret.ref = null;
            }
            ret._owner = owner;
        }
        return ret;
    }
    function isValidElement(vnode) {
        return !!vnode && vnode.$$typeof === REACT_ELEMENT_TYPE;
    }
    function createVText(text) {
        return ReactElement('#text', 6, text + '');
    }
    function escape(key) {
        var escapeRegex = /[=:]/g;
        var escaperLookup = {
            '=': '=0',
            ':': '=2'
        };
        var escapedString = ('' + key).replace(escapeRegex, function (match) {
            return escaperLookup[match];
        });
        return '$' + escapedString;
    }
    var lastText = void 0,
        flattenIndex = void 0,
        flattenObject = void 0;
    function flattenCb(context, child, key, childType) {
        if (child === null) {
            lastText = null;
            return;
        }
        if (childType === 3 || childType === 4) {
            if (lastText) {
                lastText.props += child;
                return;
            }
            lastText = child = createVText(child);
        } else {
            lastText = null;
        }
        if (!flattenObject[key]) {
            flattenObject[key] = child;
        } else {
            key = '.' + flattenIndex;
            flattenObject[key] = child;
        }
        flattenIndex++;
    }
    function fiberizeChildren(children, fiber) {
        flattenObject = {};
        flattenIndex = 0;
        if (children !== void 666) {
            lastText = null;
            traverseAllChildren(children, '', flattenCb);
        }
        flattenIndex = 0;
        return fiber.children = flattenObject;
    }
    function getComponentKey(component, index) {
        if (Object(component).key != null) {
            return escape(component.key);
        }
        return index.toString(36);
    }
    var SEPARATOR = '.';
    var SUBSEPARATOR = ':';
    function traverseAllChildren(children, nameSoFar, callback, bookKeeping) {
        var childType = typeNumber(children);
        var invokeCallback = false;
        switch (childType) {
            case 0:
            case 1:
            case 2:
            case 5:
            case 6:
                children = null;
                invokeCallback = true;
                break;
            case 3:
            case 4:
                invokeCallback = true;
                break;
            case 8:
                if (children.$$typeof || children instanceof Component) {
                    invokeCallback = true;
                } else if (children.hasOwnProperty('toString')) {
                    children = children + '';
                    invokeCallback = true;
                    childType = 3;
                }
                break;
        }
        if (invokeCallback) {
            callback(bookKeeping, children,
            nameSoFar === '' ? SEPARATOR + getComponentKey(children, 0) : nameSoFar, childType);
            return 1;
        }
        var subtreeCount = 0;
        var nextNamePrefix = nameSoFar === '' ? SEPARATOR : nameSoFar + SUBSEPARATOR;
        if (children.forEach) {
            children.forEach(function (child, i) {
                var nextName = nextNamePrefix + getComponentKey(child, i);
                subtreeCount += traverseAllChildren(child, nextName, callback, bookKeeping);
            });
            return subtreeCount;
        }
        var iteratorFn = getIteractor(children);
        if (iteratorFn) {
            var iterator = iteratorFn.call(children),
                child = void 0,
                ii = 0,
                step = void 0,
                nextName = void 0;
            while (!(step = iterator.next()).done) {
                child = step.value;
                nextName = nextNamePrefix + getComponentKey(child, ii++);
                subtreeCount += traverseAllChildren(child, nextName, callback, bookKeeping);
            }
            return subtreeCount;
        }
        throw 'children: type is invalid.';
    }
    var REAL_SYMBOL = hasSymbol && Symbol.iterator;
    var FAKE_SYMBOL = '@@iterator';
    function getIteractor(a) {
        var iteratorFn = REAL_SYMBOL && a[REAL_SYMBOL] || a[FAKE_SYMBOL];
        if (iteratorFn && iteratorFn.call) {
            return iteratorFn;
        }
    }

    var Children = {
        only: function only(children) {
            if (isValidElement(children)) {
                return children;
            }
            throw new Error("expect only one child");
        },
        count: function count(children) {
            if (children == null) {
                return 0;
            }
            return traverseAllChildren(children, "", noop);
        },
        map: function map(children, func, context) {
            return proxyIt(children, func, [], context);
        },
        forEach: function forEach(children, func, context) {
            return proxyIt(children, func, null, context);
        },
        toArray: function toArray$$1(children) {
            return proxyIt(children, K, []);
        }
    };
    function proxyIt(children, func, result, context) {
        if (children == null) {
            return [];
        }
        mapChildren(children, null, func, result, context);
        return result;
    }
    function K(el) {
        return el;
    }
    function mapChildren(children, prefix, func, result, context) {
        var keyPrefix = "";
        if (prefix != null) {
            keyPrefix = escapeUserProvidedKey(prefix) + "/";
        }
        traverseAllChildren(children, "", traverseCallback, {
            context: context,
            keyPrefix: keyPrefix,
            func: func,
            result: result,
            count: 0
        });
    }
    var userProvidedKeyEscapeRegex = /\/+/g;
    function escapeUserProvidedKey(text) {
        return ("" + text).replace(userProvidedKeyEscapeRegex, "$&/");
    }
    function traverseCallback(bookKeeping, child, childKey) {
        var result = bookKeeping.result,
            keyPrefix = bookKeeping.keyPrefix,
            func = bookKeeping.func,
            context = bookKeeping.context;
        var mappedChild = func.call(context, child, bookKeeping.count++);
        if (!result) {
            return;
        }
        if (Array.isArray(mappedChild)) {
            mapChildren(mappedChild, childKey, K, result);
        } else if (mappedChild != null) {
            if (isValidElement(mappedChild)) {
                mappedChild = extend({}, mappedChild);
                mappedChild.key = keyPrefix + (mappedChild.key && (!child || child.key !== mappedChild.key) ? escapeUserProvidedKey(mappedChild.key) + "/" : "") + childKey;
            }
            result.push(mappedChild);
        }
    }

    var check = function check() {
        return check;
    };
    check.isRequired = check;
    var PropTypes = {
        array: check,
        bool: check,
        func: check,
        number: check,
        object: check,
        string: check,
        any: check,
        arrayOf: check,
        element: check,
        instanceOf: check,
        node: check,
        objectOf: check,
        oneOf: check,
        oneOfType: check,
        shape: check
    };

    function shallowEqual(objA, objB) {
        if (Object.is(objA, objB)) {
            return true;
        }
        if (typeNumber(objA) < 7 || typeNumber(objB) < 7) {
            return false;
        }
        var keysA = Object.keys(objA);
        var keysB = Object.keys(objB);
        if (keysA.length !== keysB.length) {
            return false;
        }
        for (var i = 0; i < keysA.length; i++) {
            if (!hasOwnProperty.call(objB, keysA[i]) || !Object.is(objA[keysA[i]], objB[keysA[i]])) {
                return false;
            }
        }
        return true;
    }

    var PureComponent = miniCreateClass(function PureComponent() {
        this.isPureComponent = true;
    }, Component, {
        shouldComponentUpdate: function shouldComponentUpdate(nextProps, nextState) {
            var a = shallowEqual(this.props, nextProps);
            var b = shallowEqual(this.state, nextState);
            return !a || !b;
        }
    });

    function createRef() {
        return {
            current: null
        };
    }
    function forwardRef(fn) {
        return function ForwardRefComponent(props) {
            return fn(props, this.ref);
        };
    }

    function AnuPortal(props) {
        return props.children;
    }
    function createPortal(children, parent) {
        var child = createElement(AnuPortal, { children: children, parent: parent });
        child.isPortal = true;
        return child;
    }

    var MAX_NUMBER = 1073741823;
    function createContext(defaultValue, calculateChangedBits) {
        if (calculateChangedBits == void 0) {
            calculateChangedBits = null;
        }
        var instance = {
            value: defaultValue,
            subscribers: []
        };
        var Provider = miniCreateClass(function Provider(props) {
            this.value = props.value;
            getContext.subscribers = this.subscribers = [];
            instance = this;
        }, Component, {
            componentWillUnmount: function componentWillUnmount() {
                this.subscribers.length = 0;
            },
            UNSAFE_componentWillReceiveProps: function UNSAFE_componentWillReceiveProps(nextProps) {
                if (this.props.value !== nextProps.value) {
                    var oldValue = this.props.value;
                    var newValue = nextProps.value;
                    var changedBits = void 0;
                    if (Object.is(oldValue, newValue)) {
                        changedBits = 0;
                    } else {
                        this.value = newValue;
                        changedBits = isFn(calculateChangedBits) ? calculateChangedBits(oldValue, newValue) : MAX_NUMBER;
                        changedBits |= 0;
                        if (changedBits !== 0) {
                            instance.subscribers.forEach(function (fiber) {
                                if (fiber.setState) {
                                    fiber.setState({ value: newValue });
                                    fiber = get(fiber);
                                }
                                Renderer.updateComponent(fiber, true);
                            });
                        }
                    }
                }
            },
            render: function render() {
                return this.props.children;
            }
        });
        var Consumer = miniCreateClass(function Consumer() {
            instance.subscribers.push(this);
            this.observedBits = 0;
            this.state = {
                value: instance.value
            };
        }, Component, {
            componentWillUnmount: function componentWillUnmount() {
                var i = instance.subscribers.indexOf(this);
                instance.subscribers.splice(i, 1);
            },
            render: function render() {
                return this.props.children(getContext(get(this)));
            }
        });
        function getContext(fiber) {
            while (fiber['return']) {
                if (fiber.type == Provider) {
                    return instance.value;
                }
                fiber = fiber['return'];
            }
            return defaultValue;
        }
        getContext.subscribers = [];
        getContext.Provider = Provider;
        getContext.Consumer = Consumer;
        return getContext;
    }

    function findHostInstance(fiber) {
        if (!fiber) {
            return null;
        } else if (fiber.nodeType) {
            return fiber;
        } else if (fiber.tag > 3) {
            return fiber.stateNode;
        } else if (fiber.tag < 3) {
            return findHostInstance(fiber.stateNode);
        } else if (fiber.refs && fiber.render) {
            fiber = get(fiber);
            var childrenMap = fiber.children;
            if (childrenMap) {
                for (var i in childrenMap) {
                    var dom = findHostInstance(childrenMap[i]);
                    if (dom) {
                        return dom;
                    }
                }
            }
        }
        return null;
    }

    function findDOMNode(fiber) {
        if (fiber == null) {
            return null;
        }
        if (fiber.nodeType === 1) {
            return fiber;
        }
        if (!fiber.render) {
            throw "findDOMNode:invalid type";
        }
        return findHostInstance(fiber);
    }

    function DOMElement(type) {
        this.nodeName = type;
        this.style = {};
        this.children = [];
    }
    var NAMESPACE = {
        svg: 'http://www.w3.org/2000/svg',
        xmlns: 'http://www.w3.org/2000/xmlns/',
        xlink: 'http://www.w3.org/1999/xlink',
        xhtml: 'http://www.w3.org/1999/xhtml',
        math: 'http://www.w3.org/1998/Math/MathML'
    };
    var fn = DOMElement.prototype = {
        contains: Boolean
    };
    String('replaceChild,appendChild,removeAttributeNS,setAttributeNS,removeAttribute,setAttribute' + ',getAttribute,insertBefore,removeChild,addEventListener,removeEventListener,attachEvent' + ',detachEvent').replace(/\w+/g, function (name) {
        fn[name] = noop;
    });
    var fakeDoc = new DOMElement();
    fakeDoc.createElement = fakeDoc.createElementNS = fakeDoc.createDocumentFragment = function (type) {
        return new DOMElement(type);
    };
    fakeDoc.createTextNode = fakeDoc.createComment = Boolean;
    fakeDoc.documentElement = new DOMElement('html');
    fakeDoc.body = new DOMElement('body');
    fakeDoc.nodeName = '#document';
    fakeDoc.textContent = '';
    var win = getWindow();
    var inBrowser = !!win.alert;
    if (!inBrowser) {
        win.document = fakeDoc;
    }
    var document = win.document;
    var versions = {
        88: 7,
        80: 6,
        '00': NaN,
        '08': NaN
    };
    var msie = document.documentMode || versions[typeNumber(document.all) + '' + typeNumber(win.XMLHttpRequest)];
    var modern = /NaN|undefined/.test(msie) || msie > 8;
    function contains(a, b) {
        if (b) {
            while (b = b.parentNode) {
                if (b === a) {
                    return true;
                }
            }
        }
        return false;
    }

    var rnumber = /^-?\d+(\.\d+)?$/;
    function patchStyle(dom, lastStyle, nextStyle) {
        if (lastStyle === nextStyle) {
            return;
        }
        for (var name in nextStyle) {
            var val = nextStyle[name];
            if (lastStyle[name] !== val) {
                name = cssName(name, dom);
                if (val !== 0 && !val) {
                    val = "";
                } else if (rnumber.test(val) && !cssNumber[name]) {
                    val = val + "px";
                }
                try {
                    dom.style[name] = val;
                } catch (e) {
                    console.log("dom.style[" + name + "] = " + val + "throw error");
                }
            }
        }
        for (var _name in lastStyle) {
            if (!(_name in nextStyle)) {
                _name = cssName(_name, dom);
                dom.style[_name] = "";
            }
        }
    }
    var cssNumber = oneObject("animationIterationCount,columnCount,order,flex,flexGrow,flexShrink,fillOpacity,fontWeight,lineHeight,opacity,orphans,widows,zIndex,zoom");
    var prefixes = ["", "-webkit-", "-o-", "-moz-", "-ms-"];
    var cssMap = oneObject("float", "cssFloat");
    function cssName(name, dom) {
        if (cssMap[name]) {
            return cssMap[name];
        }
        var host = dom && dom.style || {};
        for (var i = 0, n = prefixes.length; i < n; i++) {
            var camelCase = camelize(prefixes[i] + name);
            if (camelCase in host) {
                return cssMap[name] = camelCase;
            }
        }
        return null;
    }

    function getSafeValue(value) {
        switch (typeNumber(value)) {
            case 2:
            case 3:
            case 8:
            case 4:
            case 0:
                return value;
            default:
                return "";
        }
    }
    var duplexMap = {
        input: {
            init: function init(node, props) {
                var defaultValue = props.defaultValue == null ? "" : props.defaultValue;
                return node._wrapperState = {
                    initialValue: getSafeValue(props.value != null ? props.value : defaultValue)
                };
            },
            mount: function mount(node, props, state) {
                if (props.hasOwnProperty("value") || props.hasOwnProperty("defaultValue")) {
                    var stateValue = "" + state.initialValue;
                    if (node.value === "" && node.value !== stateValue) {
                        syncValue(node, "value", stateValue);
                    }
                    node.defaultValue = stateValue;
                }
                var name = node.name;
                if (name !== "") {
                    node.name = "";
                }
                node.defaultChecked = !node.defaultChecked;
                node.defaultChecked = !node.defaultChecked;
                if (name !== "") {
                    node.name = name;
                }
            },
            update: function update(node, props) {
                if (props.checked != null) {
                    syncValue(node, "checked", !!props.checked);
                }
                var isActive = node === node.ownerDocument.activeElement;
                var value = getSafeValue(props.value);
                if (value != null) {
                    if (props.type === "number") {
                        if (value === 0 && node.value === "" ||
                        node.value != value) {
                            syncValue(node, "value", "" + value);
                        }
                    } else if (node.value !== "" + value) {
                        syncValue(node, "value", "" + value);
                    }
                }
                if (props.hasOwnProperty("value")) {
                    setDefaultValue(node, props.type, value, isActive);
                } else if (props.hasOwnProperty("defaultValue")) {
                    setDefaultValue(node, props.type, getSafeValue(props.defaultValue), isActive);
                }
                if (props.checked == null && props.defaultChecked != null) {
                    node.defaultChecked = !!props.defaultChecked;
                }
            }
        },
        select: {
            init: function init(node, props) {
                var value = props.value;
                return node._wrapperState = {
                    initialValue: value != null ? value : props.defaultValue,
                    wasMultiple: !!props.multiple
                };
            },
            mount: function mount(node, props) {
                var multiple = node.multiple = !!props.multiple;
                var value = props.value;
                if (value != null) {
                    updateOptions(node, multiple, value, false);
                } else if (props.defaultValue != null) {
                    updateOptions(node, multiple, props.defaultValue, true);
                }
            },
            update: function update(node, props) {
                node._wrapperState.initialValue = void 666;
                var wasMultiple = node._wrapperState.wasMultiple;
                var multiple = node._wrapperState.wasMultiple = !!props.multiple;
                var value = props.value;
                if (value != null) {
                    updateOptions(node, multiple, value, false);
                } else if (wasMultiple !== multiple) {
                    if (props.defaultValue != null) {
                        updateOptions(node, multiple, props.defaultValue, true);
                    } else {
                        updateOptions(node, multiple, multiple ? [] : "", false);
                    }
                }
            }
        },
        textarea: {
            init: function init(node, props) {
                var initialValue = props.value;
                if (initialValue == null) {
                    var defaultValue = props.defaultValue;
                    var children = props.children;
                    if (children != null) {
                        defaultValue = textContent(node);
                        node.innerHTML = "";
                    }
                    if (defaultValue == null) {
                        defaultValue = "";
                    }
                    initialValue = defaultValue;
                }
                return node._wrapperState = {
                    initialValue: "" + initialValue
                };
            },
            mount: function mount(node, props, state) {
                var text = textContent(node);
                var stateValue = "" + state.initialValue;
                if (text !== stateValue) {
                    syncValue(node, "value", stateValue);
                }
            },
            update: function update(node, props) {
                var value = props.value;
                if (value != null) {
                    var newValue = "" + value;
                    if (newValue !== node.value) {
                        syncValue(node, "value", newValue);
                    }
                    if (props.defaultValue == null) {
                        node.defaultValue = newValue;
                    }
                }
                if (props.defaultValue != null) {
                    node.defaultValue = props.defaultValue;
                }
            }
        },
        option: {
            init: function init() {},
            update: function update(node, props) {
                duplexMap.option.mount(node, props);
            },
            mount: function mount(node, props) {
                var elems = node.getElementsByTagName("*");
                var n = elems.length,
                    el = void 0;
                if (n) {
                    for (n = n - 1, el; el = elems[n--];) {
                        node.removeChild(el);
                    }
                }
                if ("value" in props) {
                    node.duplexValue = node.value = props.value;
                } else {
                    node.duplexValue = node.text;
                }
            }
        }
    };
    function textContent(node) {
        return node.textContent || node.innerText;
    }
    function setDefaultValue(node, type, value, isActive) {
        if (
        type !== "number" || !isActive) {
            if (value == null) {
                node.defaultValue = "" + node._wrapperState.initialValue;
            } else if (node.defaultValue !== "" + value) {
                node.defaultValue = "" + value;
            }
        }
    }
    function updateOptions(node, multiple, propValue, setDefaultSelected) {
        var options = node.options;
        if (multiple) {
            var selectedValues = propValue;
            var selectedValue = {};
            for (var i = 0; i < selectedValues.length; i++) {
                selectedValue["$" + selectedValues[i]] = true;
            }
            for (var _i = 0; _i < options.length; _i++) {
                var selected = selectedValue.hasOwnProperty("$" + options[_i].duplexValue);
                if (options[_i].selected !== selected) {
                    options[_i].selected = selected;
                }
                if (selected && setDefaultSelected) {
                    options[_i].defaultSelected = true;
                }
            }
        } else {
            var _selectedValue = "" + propValue;
            var defaultSelected = null;
            for (var _i2 = 0; _i2 < options.length; _i2++) {
                if (options[_i2].duplexValue === _selectedValue) {
                    options[_i2].selected = true;
                    if (setDefaultSelected) {
                        options[_i2].defaultSelected = true;
                    }
                    return;
                }
                if (defaultSelected === null && !options[_i2].disabled) {
                    defaultSelected = options[_i2];
                }
            }
            if (defaultSelected !== null) {
                defaultSelected.selected = true;
            }
        }
    }
    function syncValue(dom, name, value) {
        dom.__anuSetValue = true;
        dom[name] = value;
        dom.__anuSetValue = false;
    }
    function duplexAction(fiber) {
        var dom = fiber.stateNode,
            name = fiber.name,
            props = fiber.props,
            lastProps = fiber.lastProps;
        var fns = duplexMap[name];
        if (name !== "option") {
            enqueueDuplex(dom);
        }
        if (!lastProps || lastProps == emptyObject) {
            var state = fns.init(dom, props);
            fns.mount(dom, props, state);
        } else {
            fns.update(dom, props);
        }
    }
    var duplexNodes = [];
    function enqueueDuplex(dom) {
        if (duplexNodes.indexOf(dom) == -1) {
            duplexNodes.push(dom);
        }
    }
    function fireDuplex() {
        var radioMap = {};
        if (duplexNodes.length) {
            do {
                var dom = duplexNodes.shift();
                var e = dom.__events;
                var fiber = e && e.vnode;
                if (fiber && !fiber.disposed) {
                    var props = fiber.props;
                    var tag = fiber.name;
                    if (name === "select") {
                        var value = props.value;
                        if (value != null) {
                            updateOptions(dom, !!props.multiple, value, false);
                        }
                    } else {
                        duplexMap[tag].update(dom, props);
                        var _name = props.name;
                        if (props.type === "radio" && _name != null && !radioMap[_name]) {
                            radioMap[_name] = 1;
                            collectNamedCousins(dom, _name);
                        }
                    }
                }
            } while (duplexNodes.length);
        }
    }
    function collectNamedCousins(rootNode, name) {
        var queryRoot = rootNode;
        while (queryRoot.parentNode) {
            queryRoot = queryRoot.parentNode;
        }
        var group = queryRoot.getElementsByTagName("input");
        for (var i = 0; i < group.length; i++) {
            var otherNode = group[i];
            if (otherNode === rootNode || otherNode.name !== name || otherNode.type !== "radio" || otherNode.form !== rootNode.form) {
                continue;
            }
            enqueueDuplex(otherNode);
        }
    }

    var rform = /textarea|input|select|option/i;
    var globalEvents = {};
    var eventPropHooks = {};
    var eventHooks = {};
    var eventLowerCache = {
        onClick: 'click',
        onChange: 'change',
        onWheel: 'wheel'
    };
    function eventAction(dom, name, val, lastProps, fiber) {
        var events = dom.__events || (dom.__events = {});
        events.vnode = fiber;
        var refName = toLowerCase(name.slice(2));
        if (val === false) {
            delete events[refName];
        } else {
            if (!lastProps[name]) {
                var eventName = getBrowserName(name);
                var hook = eventHooks[eventName];
                if (hook) {
                    hook(dom, eventName);
                }
                addGlobalEvent(eventName);
            }
            events[refName] = val;
        }
    }
    var isTouch = 'ontouchstart' in document;
    function dispatchEvent(e, type, endpoint) {
        e = new SyntheticEvent(e);
        if (type) {
            e.type = type;
        }
        var bubble = e.type,
            terminal = endpoint || document,
            hook = eventPropHooks[e.type];
        if (hook && false === hook(e)) {
            return;
        }
        Renderer.batchedUpdates(function () {
            var paths = collectPaths(e.target, terminal, {});
            var captured = bubble + 'capture';
            triggerEventFlow(paths, captured, e);
            if (!e._stopPropagation) {
                triggerEventFlow(paths.reverse(), bubble, e);
            }
        }, e);
    }
    var nodeID = 1;
    function collectPaths(begin, end, unique) {
        var paths = [];
        var node = begin;
        while (node && node.nodeType == 1) {
            var checkChange = node;
            if (node.__events) {
                var vnode = node.__events.vnode;
                inner: while (vnode['return']) {
                    if (vnode.tag === 5) {
                        node = vnode.stateNode;
                        if (node === end) {
                            return paths;
                        }
                        if (!node) {
                            break inner;
                        }
                        var uid = node.uniqueID || (node.uniqueID = ++nodeID);
                        if (node.__events && !unique[uid]) {
                            unique[uid] = 1;
                            paths.push({ node: node, events: node.__events });
                        }
                    }
                    vnode = vnode['return'];
                }
            }
            if (node === checkChange) {
                node = node.parentNode;
            }
        }
        return paths;
    }
    function triggerEventFlow(paths, prop, e) {
        for (var i = paths.length; i--;) {
            var path = paths[i];
            var fn = path.events[prop];
            if (isFn(fn)) {
                e.currentTarget = path.node;
                fn.call(void 666, e);
                if (e._stopPropagation) {
                    break;
                }
            }
        }
    }
    function addGlobalEvent(name, capture) {
        if (!globalEvents[name]) {
            globalEvents[name] = true;
            addEvent(document, name, dispatchEvent, capture);
        }
    }
    function addEvent(el, type, fn, bool) {
        if (el.addEventListener) {
            el.addEventListener(type, fn, bool || false);
        } else if (el.attachEvent) {
            el.attachEvent('on' + type, fn);
        }
    }
    var rcapture = /Capture$/;
    function getBrowserName(onStr) {
        var lower = eventLowerCache[onStr];
        if (lower) {
            return lower;
        }
        var camel = onStr.slice(2).replace(rcapture, '');
        lower = camel.toLowerCase();
        eventLowerCache[onStr] = lower;
        return lower;
    }
    function getRelatedTarget(e) {
        if (!e.timeStamp) {
            e.relatedTarget = e.type === 'mouseover' ? e.fromElement : e.toElement;
        }
        return e.relatedTarget;
    }
    function getTarget(e) {
        return e.target || e.srcElement;
    }
    String('load,error').replace(/\w+/g, function (name) {
        eventHooks[name] = function (dom, type) {
            var mark = '__' + type;
            if (!dom[mark]) {
                dom[mark] = true;
                addEvent(dom, type, dispatchEvent);
            }
        };
    });
    String('mouseenter,mouseleave').replace(/\w+/g, function (name) {
        eventHooks[name] = function (dom, type) {
            var mark = '__' + type;
            if (!dom[mark]) {
                dom[mark] = true;
                var mask = type === 'mouseenter' ? 'mouseover' : 'mouseout';
                addEvent(dom, mask, function (e) {
                    var t = getRelatedTarget(e);
                    if (!t || t !== dom && !contains(dom, t)) {
                        var common = getLowestCommonAncestor(dom, t);
                        dispatchEvent(e, type, common);
                    }
                });
            }
        };
    });
    var specialHandles = {};
    function createHandle(name, fn) {
        return specialHandles[name] = function (e) {
            if (fn && fn(e) === false) {
                return;
            }
            dispatchEvent(e, name);
        };
    }
    function onCompositionStart(e) {
        e.target.__onComposition = true;
    }
    function onCompositionEnd(e) {
        e.target.__onComposition = false;
    }
    var input2change = /text|password|search|url|email/i;
    if (!document['__input']) {
        globalEvents.input = document['__input'] = true;
        addEvent(document, 'compositionstart', onCompositionStart);
        addEvent(document, 'compositionend', onCompositionEnd);
        addEvent(document, 'input', function (e) {
            var dom = getTarget(e);
            if (input2change.test(dom.type)) {
                if (!dom.__onComposition) {
                    dispatchEvent(e, 'change');
                }
            }
            dispatchEvent(e);
        });
    }
    function getLowestCommonAncestor(instA, instB) {
        var depthA = 0;
        for (var tempA = instA; tempA; tempA = tempA.parentNode) {
            depthA++;
        }
        var depthB = 0;
        for (var tempB = instB; tempB; tempB = tempB.parentNode) {
            depthB++;
        }
        while (depthA - depthB > 0) {
            instA = instA.parentNode;
            depthA--;
        }
        while (depthB - depthA > 0) {
            instB = instB.parentNode;
            depthB--;
        }
        var depth = depthA;
        while (depth--) {
            if (instA === instB) {
                return instA;
            }
            instA = instA.parentNode;
            instB = instB.parentNode;
        }
        return null;
    }
    eventPropHooks.change = function (e) {
        enqueueDuplex(e.target);
    };
    createHandle('doubleclick');
    createHandle('scroll');
    createHandle('wheel');
    globalEvents.wheel = true;
    globalEvents.scroll = true;
    globalEvents.doubleclick = true;
    if (isTouch) {
        eventHooks.click = eventHooks.clickcapture = function (dom) {
            dom.onclick = dom.onclick || noop;
        };
    }
    eventPropHooks.click = function (e) {
        return !e.target.disabled;
    };
    var fixWheelType = document.onwheel !== void 666 ? 'wheel' : 'onmousewheel' in document ? 'mousewheel' : 'DOMMouseScroll';
    eventHooks.wheel = function (dom) {
        addEvent(dom, fixWheelType, specialHandles.wheel);
    };
    eventPropHooks.wheel = function (event) {
        event.deltaX = 'deltaX' in event ? event.deltaX :
        'wheelDeltaX' in event ? -event.wheelDeltaX : 0;
        event.deltaY = 'deltaY' in event ? event.deltaY :
        'wheelDeltaY' in event ? -event.wheelDeltaY :
        'wheelDelta' in event ? -event.wheelDelta : 0;
    };
    var focusMap = {
        focus: 'focus',
        blur: 'blur'
    };
    var innerFocus = void 0;
    function blurFocus(e) {
        var dom = getTarget(e);
        var type = focusMap[e.type];
        if (Renderer.inserting) {
            if (type === 'blur') {
                innerFocus = true;
                Renderer.inserting.focus();
                return;
            }
        }
        if (innerFocus) {
            innerFocus = false;
            return;
        }
        do {
            if (dom.nodeType === 1) {
                if (dom.__events && dom.__events[type]) {
                    dispatchEvent(e, type);
                    break;
                }
            } else {
                break;
            }
        } while (dom = dom.parentNode);
    }
    'blur,focus'.replace(/\w+/g, function (type) {
        globalEvents[type] = true;
        if (modern) {
            var mark = '__' + type;
            if (!document[mark]) {
                document[mark] = true;
                addEvent(document, type, blurFocus, true);
            }
        } else {
            eventHooks[type] = function (dom, name) {
                addEvent(dom, focusMap[name], blurFocus);
            };
        }
    });
    eventHooks.scroll = function (dom, name) {
        addEvent(dom, name, specialHandles[name]);
    };
    eventHooks.doubleclick = function (dom, name) {
        addEvent(document, 'dblclick', specialHandles[name]);
    };
    function SyntheticEvent(event) {
        if (event.nativeEvent) {
            return event;
        }
        for (var i in event) {
            if (!eventProto[i]) {
                this[i] = event[i];
            }
        }
        if (!this.target) {
            this.target = event.srcElement;
        }
        this.fixEvent();
        this.timeStamp = new Date() - 0;
        this.nativeEvent = event;
    }
    var eventProto = SyntheticEvent.prototype = {
        fixEvent: noop,
        fixHooks: noop,
        persist: noop,
        preventDefault: function preventDefault() {
            var e = this.nativeEvent || {};
            e.returnValue = this.returnValue = false;
            if (e.preventDefault) {
                e.preventDefault();
                this.defaultPrevented = true;
            }
        },
        stopPropagation: function stopPropagation() {
            var e = this.nativeEvent || {};
            e.cancelBubble = this._stopPropagation = true;
            if (e.stopPropagation) {
                e.stopPropagation();
            }
        },
        stopImmediatePropagation: function stopImmediatePropagation() {
            this.stopPropagation();
            this.stopImmediate = true;
        },
        toString: function toString() {
            return '[object Event]';
        }
    };
    Renderer.eventSystem = {
        eventPropHooks: eventPropHooks,
        addEvent: addEvent,
        dispatchEvent: dispatchEvent,
        SyntheticEvent: SyntheticEvent
    };

    var NOWORK = 1;
    var WORKING = 2;
    var PLACE = 3;
    var CONTENT = 5;
    var ATTR = 7;
    var DUPLEX = 11;
    var DETACH = 13;
    var HOOK = 17;
    var REF = 19;
    var CALLBACK = 23;
    var PASSIVE = 29;
    var CAPTURE = 31;
    var effectNames = [DUPLEX, HOOK, REF, DETACH, CALLBACK, PASSIVE, CAPTURE].sort(function (a, b) {
        return a - b;
    });
    var effectLength = effectNames.length;

    var isSpecialAttr = {
        style: 1,
        autoFocus: 1,
        innerHTML: 1,
        dangerouslySetInnerHTML: 1
    };
    var svgCache = {};
    var strategyCache = {};
    var svgCamelCase = {
        w: { r: 1, b: 1, t: 1 },
        e: { n: 1, t: 1, f: 1, p: 1, c: 1, m: 1, a: 2, u: 1, s: 1, v: 1 },
        o: { r: 1 },
        c: { m: 1 },
        p: { p: 1 },
        t: { s: 2, t: 1, u: 1, c: 1, d: 1, o: 1, x: 1, y: 1, l: 1 },
        l: { r: 1, m: 1, u: 1, b: -1, l: -1, s: -1 },
        r: { r: 1, u: 2, h: 1, w: 1, c: 1, e: 1 },
        h: { r: 1, a: 1, l: 1, t: 1 },
        y: { p: 1, s: 1, t: 1, c: 1 },
        g: { c: 1 },
        k: { a: -1, h: -1, r: -1, s: -1, t: -1, c: 1, u: 1 },
        m: { o: 1, l: 1, a: 1 },
        n: { c: 1, t: 1, u: 1 },
        s: { a: 3 },
        f: { x: 1, y: 1 },
        d: { e: 1, f: 1, m: 1, d: 1 },
        x: { c: 1 }
    };
    var specialSVGPropertyName = {
        "overline-thickness": 2,
        "underline-thickness": 2,
        "overline-position": 2,
        "underline-position": 2,
        "stroke-miterlimit": 2,
        "baseline-shift": 2,
        "clip-path": 2,
        "font-size": 2,
        "font-size-adjust": 2,
        "font-stretch": 2,
        "font-style": 2,
        "text-decoration": 2,
        "vert-origin-x": 2,
        "vert-origin-y": 2,
        "paint-order": 2,
        "fill-rule": 2,
        "color-rendering": 2,
        "marker-end": 2,
        "pointer-events": 2,
        "units-per-em": 2,
        "strikethrough-thickness": 2,
        "lighting-color": 2
    };
    var repeatedKey = ["et", "ep", "em", "es", "pp", "ts", "td", "to", "lr", "rr", "re", "ht", "gc"];
    function createRepaceFn(split) {
        return function (match) {
            return match.slice(0, 1) + split + match.slice(1).toLowerCase();
        };
    }
    var rhump = /([a-z])([A-Z])/;
    var toHyphen = createRepaceFn("-");
    var toColon = createRepaceFn(":");
    function getSVGAttributeName(name) {
        if (svgCache[name]) {
            return svgCache[name];
        }
        var match = name.match(rhump);
        if (!match) {
            return svgCache[name] = name;
        }
        var prefix = match[1];
        var postfix = match[2].toLowerCase();
        var orig = name;
        var count = svgCamelCase[prefix] && svgCamelCase[prefix][postfix];
        if (count) {
            if (count === -1) {
                return svgCache[orig] = {
                    name: name.replace(rhump, toColon),
                    ifSpecial: true
                };
            }
            if (~repeatedKey.indexOf(prefix + postfix)) {
                var dashName = name.replace(rhump, toHyphen);
                if (specialSVGPropertyName[dashName]) {
                    name = dashName;
                }
            }
        } else {
            name = name.replace(rhump, toHyphen);
        }
        return svgCache[orig] = name;
    }
    function diffProps(dom, lastProps, nextProps, fiber) {
        var isSVG = fiber.namespaceURI === NAMESPACE.svg;
        var tag = fiber.type;
        var continueProps = skipProps;
        if (!isSVG && rform.test(fiber.type)) {
            continueProps = duplexProps;
            if (!("onChange" in nextProps)) {
                eventAction(dom, "onChange", noop, lastProps, fiber);
            }
            fiber.effectTag *= DUPLEX;
            fiber.onDuplex = continueProps.onDuplex;
        }
        for (var name in nextProps) {
            if (continueProps[name]) {
                continue;
            }
            var val = nextProps[name];
            if (val !== lastProps[name]) {
                var which = tag + isSVG + name;
                var action = strategyCache[which];
                if (!action) {
                    action = strategyCache[which] = getPropAction(dom, name, isSVG);
                }
                actionStrategy[action](dom, name, val, lastProps, fiber);
            }
        }
        for (var _name in lastProps) {
            if (continueProps[_name]) {
                continue;
            }
            if (!nextProps.hasOwnProperty(_name)) {
                var _which = tag + isSVG + _name;
                var _action = strategyCache[_which];
                if (!_action) {
                    continue;
                }
                actionStrategy[_action](dom, _name, false, lastProps, fiber);
            }
        }
    }
    function isBooleanAttr(dom, name) {
        var val = dom[name];
        return val === true || val === false;
    }
    function isEventName(name) {
        return (/^on[A-Z]/.test(name)
        );
    }
    function getPropAction(dom, name, isSVG) {
        if (isSVG && name === "className") {
            return "svgClass";
        }
        if (isSpecialAttr[name]) {
            return name;
        }
        if (isEventName(name)) {
            return "event";
        }
        if (isSVG) {
            return "svgAttr";
        }
        if (name === "width" || name === "height") {
            return "attribute";
        }
        if (isBooleanAttr(dom, name)) {
            return "booleanAttr";
        }
        return name.indexOf("data-") === 0 || dom[name] === void 666 ? "attribute" : "property";
    }
    var builtinStringProps = {
        className: 1,
        title: 1,
        name: 1,
        type: 1,
        alt: 1,
        lang: 1
    };
    var skipProps = {
        innerHTML: 1,
        children: 1,
        onDuplex: noop
    };
    var duplexProps = {
        value: 1,
        defaultValue: 1,
        checked: 1,
        innerHTML: 1,
        children: 1
    };
    var actionStrategy = {
        style: function style(dom, _, val, lastProps) {
            patchStyle(dom, lastProps.style || emptyObject, val || emptyObject);
        },
        autoFocus: function autoFocus(dom) {
            if (/input|text/i.test(dom.nodeName) || dom.contentEditable === "true") {
                dom.focus();
            }
        },
        svgClass: function svgClass(dom, name, val) {
            if (!val) {
                dom.removeAttribute("class");
            } else {
                dom.setAttribute("class", val);
            }
        },
        svgAttr: function svgAttr(dom, name, val) {
            var method = typeNumber(val) < 3 && !val ? "removeAttribute" : "setAttribute";
            var nameRes = getSVGAttributeName(name);
            if (nameRes.ifSpecial) {
                var prefix = nameRes.name.split(":")[0];
                dom[method + "NS"](NAMESPACE[prefix], nameRes.name, val || "");
            } else {
                dom[method](nameRes, typeNumber(val) !== 3 && !val ? "" : val);
            }
        },
        booleanAttr: function booleanAttr(dom, name, val) {
            dom[name] = !!val;
            if (dom[name] === false) {
                dom.removeAttribute(name);
            } else if (dom[name] === "false") {
                dom[name] = "";
            }
        },
        attribute: function attribute(dom, name, val) {
            if (val == null || val === false) {
                return dom.removeAttribute(name);
            }
            try {
                dom.setAttribute(name, val);
            } catch (e) {
                console.warn("setAttribute error", name, val);
            }
        },
        property: function property(dom, name, val) {
            try {
                if (!val && val !== 0) {
                    if (builtinStringProps[name]) {
                        dom[name] = "";
                    } else {
                        dom.removeAttribute(name);
                    }
                } else {
                    dom[name] = val;
                }
            } catch (e) {
                try {
                    dom.setAttribute(name, val);
                } catch (e) {
                }
            }
        },
        event: eventAction,
        dangerouslySetInnerHTML: function dangerouslySetInnerHTML(dom, name, val, lastProps) {
            var oldhtml = lastProps[name] && lastProps[name].__html;
            var html = val && val.__html;
            html = html == null ? "" : html;
            if (html !== oldhtml) {
                dom.innerHTML = html;
            }
        }
    };

    function UpdateQueue() {
        return {
            pendingStates: [],
            pendingCbs: []
        };
    }
    function createInstance(fiber, context) {
        var updater = {
            mountOrder: Renderer.mountOrder++,
            enqueueSetState: returnFalse,
            isMounted: isMounted
        };
        var props = fiber.props,
            type = fiber.type,
            tag = fiber.tag,
            ref = fiber.ref,
            key = fiber.key,
            isStateless = tag === 1,
            lastOwn = Renderer.currentOwner,
            instance = {
            refs: {},
            props: props,
            key: key,
            context: context,
            ref: ref,
            _reactInternalFiber: fiber,
            __proto__: type.prototype
        };
        fiber.updateQueue = UpdateQueue();
        fiber.errorHook = 'constructor';
        try {
            if (isStateless) {
                Renderer.currentOwner = instance;
                extend(instance, {
                    __isStateless: true,
                    renderImpl: type,
                    render: function f1() {
                        return this.renderImpl(this.props, this.context);
                    }
                });
                Renderer.currentOwner = instance;
            } else {
                instance = new type(props, context);
                if (!(instance instanceof Component)) {
                    if (!instance.updater || !instance.updater.enqueueSetState) {
                        throw type.name + ' doesn\'t extend React.Component';
                    }
                }
            }
        } finally {
            Renderer.currentOwner = lastOwn;
            fiber.stateNode = instance;
            instance._reactInternalFiber = fiber;
            instance.updater = updater;
            instance.context = context;
            updater.enqueueSetState = Renderer.updateComponent;
            if (type[gDSFP] || instance[gSBU]) {
                instance.__useNewHooks = true;
            }
        }
        return instance;
    }

    function Fiber(vnode) {
        extend(this, vnode);
        var type = vnode.type || "ProxyComponent(react-hot-loader)";
        this.name = type.displayName || type.name || type;
        this.effectTag = 1;
    }

    function pushError(fiber, hook, error) {
        var names = [];
        var boundary = findCatchComponent(fiber, names, hook);
        var stack = describeError(names, hook);
        if (boundary) {
            if (fiber.hasMounted) ; else {
                fiber.stateNode = {
                    updater: fakeObject
                };
                fiber.effectTag = NOWORK;
            }
            var values = boundary.capturedValues || (boundary.capturedValues = []);
            values.push(error, {
                componentStack: stack
            });
        } else {
            var p = fiber["return"];
            for (var i in p.children) {
                if (p.children[i] == fiber) {
                    fiber.type = noop;
                }
            }
            while (p) {
                p._hydrating = false;
                p = p["return"];
            }
            if (!Renderer.catchError) {
                Renderer.catchStack = stack;
                Renderer.catchError = error;
            }
        }
    }
    function guardCallback(host, hook, args) {
        try {
            return applyCallback(host, hook, args);
        } catch (error) {
            pushError(get(host), hook, error);
        }
    }
    function applyCallback(host, hook, args) {
        var fiber = host._reactInternalFiber;
        fiber.errorHook = hook;
        var fn = host[hook];
        if (hook == "componentWillUnmount") {
            host[hook] = noop;
        }
        if (fn) {
            return fn.apply(host, args);
        }
        return true;
    }
    function describeError(names, hook) {
        var segments = ["**" + hook + "** method occur error "];
        names.forEach(function (name, i) {
            if (names[i + 1]) {
                segments.push("in " + name + " (created By " + names[i + 1] + ")");
            }
        });
        return segments.join("\n\r").trim();
    }
    function findCatchComponent(fiber, names, hook) {
        var instance = void 0,
            name = void 0,
            topFiber = fiber,
            retry = void 0,
            boundary = void 0;
        while (fiber) {
            name = fiber.name;
            if (fiber.tag < 4) {
                names.push(name);
                instance = fiber.stateNode || {};
                if (instance.componentDidCatch && !boundary) {
                    if (!fiber.caughtError && topFiber !== fiber) {
                        boundary = fiber;
                    } else if (fiber.caughtError) {
                        retry = fiber;
                    }
                }
            } else if (fiber.tag === 5) {
                names.push(name);
            }
            fiber = fiber["return"];
            if (boundary) {
                var boundaries = Renderer.boundaries;
                if (!retry || retry !== boundary) {
                    var effectTag = boundary.effectTag;
                    var f = boundary.alternate;
                    if (f && !f.catchError) {
                        f.forward = boundary.forward;
                        f.sibling = boundary.sibling;
                        if (boundary["return"].child == boundary) {
                            boundary["return"].child = f;
                        }
                        boundary = f;
                    }
                    if (!boundary.catchError) {
                        if (hook == "componentWillUnmount" || hook == "componentDidUpdate") {
                            boundary.effectTag = CAPTURE;
                        } else {
                            boundary.effectTag = effectTag * CAPTURE;
                        }
                        boundaries.unshift(boundary);
                        boundary.catchError = true;
                    }
                    if (retry) {
                        var arr = boundary.effects || (boundary.effects = []);
                        arr.push(retry);
                    }
                }
                return boundary;
            }
        }
    }
    function removeFormBoundaries(fiber) {
        delete fiber.catchError;
        var arr = Renderer.boundaries;
        var index = arr.indexOf(fiber);
        if (index !== -1) {
            arr.splice(index, 1);
        }
    }
    function detachFiber(fiber, effects$$1) {
        fiber.effectTag = DETACH;
        effects$$1.push(fiber);
        fiber.disposed = true;
        for (var child = fiber.child; child; child = child.sibling) {
            detachFiber(child, effects$$1);
        }
    }

    function setter(compute, cursor, value) {
        var _this = this;
        Renderer.batchedUpdates(function () {
            _this.updateQueue[cursor] = compute(cursor, value);
            Renderer.updateComponent(_this, true);
        });
    }
    var hookCursor = 0;
    function resetCursor() {
        hookCursor = 0;
    }
    function getCurrentKey() {
        var key = hookCursor + 'Hook';
        hookCursor++;
        return key;
    }
    function useContext(getContext) {
        if (isFn(getContext)) {
            var fiber = getCurrentFiber();
            var context = getContext(fiber);
            var list = getContext.subscribers;
            if (list.indexOf(fiber) === -1) {
                list.push(fiber);
            }
            return context;
        }
        return null;
    }
    function useReducerImpl(reducer, initValue, initAction) {
        var fiber = getCurrentFiber();
        var key = getCurrentKey();
        var updateQueue = fiber.updateQueue;
        var compute = reducer ? function (cursor, action) {
            return reducer(updateQueue[cursor], action || { type: Math.random() });
        } : function (cursor, value) {
            var other = updateQueue[cursor];
            return isFn(value) ? value(other) : value;
        };
        var dispatch = setter.bind(fiber, compute, key);
        if (key in updateQueue) {
            delete updateQueue.isForced;
            return [updateQueue[key], dispatch];
        }
        var value = updateQueue[key] = initAction ? reducer(initValue, initAction) : initValue;
        return [value, dispatch];
    }
    function useCallbackImpl(create, deps, isMemo, isEffect) {
        var fiber = getCurrentFiber();
        var key = getCurrentKey();
        var updateQueue = fiber.updateQueue;
        var nextInputs = Array.isArray(deps) ? deps : [create];
        var prevState = updateQueue[key];
        if (prevState) {
            var prevInputs = prevState[1];
            if (areHookInputsEqual(nextInputs, prevInputs)) {
                return isEffect ? null : prevState[0];
            }
        }
        var fn = isMemo ? create() : create;
        updateQueue[key] = [fn, nextInputs];
        return fn;
    }
    function useEffectImpl(create, deps, EffectTag, createList, destroyList) {
        var fiber = getCurrentFiber();
        var updateQueue = fiber.updateQueue;
        if (useCallbackImpl(create, deps, false, true)) {
            if (fiber.effectTag % EffectTag) {
                fiber.effectTag *= EffectTag;
            }
            var list = updateQueue[createList] || (updateQueue[createList] = []);
            updateQueue[destroyList] || (updateQueue[destroyList] = []);
            list.push(create);
        }
    }
    function useRef(initValue) {
        var fiber = getCurrentFiber();
        var key = getCurrentKey();
        var updateQueue = fiber.updateQueue;
        if (key in updateQueue) {
            return updateQueue[key];
        }
        return updateQueue[key] = { current: initValue };
    }
    function useImperativeHandle(ref, create, deps) {
        var nextInputs = Array.isArray(deps) ? deps.concat([ref]) : [ref, create];
        useEffectImpl(function () {
            if (isFn(ref)) {
                var refCallback = ref;
                var inst = create();
                refCallback(inst);
                return function () {
                    return refCallback(null);
                };
            } else if (Object(ref) === ref) {
                var refObject = ref;
                var _inst = create();
                refObject.current = _inst;
                return function () {
                    refObject.current = null;
                };
            }
        }, nextInputs, HOOK, 'layout', 'unlayout');
    }
    function getCurrentFiber() {
        return get(Renderer.currentOwner);
    }
    function areHookInputsEqual(arr1, arr2) {
        for (var i = 0; i < arr1.length; i++) {
            if (Object.is(arr1[i], arr2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }

    function getInsertPoint(fiber) {
        var parent = fiber.parent;
        while (fiber) {
            if (fiber.stateNode === parent || fiber.isPortal) {
                return null;
            }
            var found = forward(fiber);
            if (found) {
                return found;
            }
            fiber = fiber['return'];
        }
    }
    function setInsertPoints(children) {
        for (var i in children) {
            var child = children[i];
            if (child.disposed) {
                continue;
            }
            if (child.tag > 4) {
                var p = child.parent;
                child.effectTag = PLACE;
                child.forwardFiber = p.insertPoint;
                p.insertPoint = child;
                for (var pp = child['return']; pp && pp.effectTag === NOWORK; pp = pp['return']) {
                    pp.effectTag = WORKING;
                }
            } else {
                if (child.child) {
                    setInsertPoints(child.children);
                }
            }
        }
    }
    function forward(fiber) {
        var found;
        while (fiber.forward) {
            fiber = fiber.forward;
            if (fiber.disposed || fiber.isPortal) {
                continue;
            }
            if (fiber.tag > 3) {
                return fiber;
            }
            if (fiber.child) {
                found = downward(fiber);
                if (found) {
                    return found;
                }
            }
        }
    }
    function downward(fiber) {
        var found;
        while (fiber.lastChild) {
            fiber = fiber.lastChild;
            if (fiber.disposed || fiber.isPortal) {
                return;
            }
            if (fiber.tag > 3) {
                return fiber;
            }
            if (fiber.forward) {
                found = forward(fiber);
                if (found) {
                    return found;
                }
            }
        }
    }

    function reconcileDFS(fiber, info, deadline, ENOUGH_TIME) {
        var topWork = fiber;
        outerLoop: while (fiber) {
            if (fiber.disposed || deadline.timeRemaining() <= ENOUGH_TIME) {
                break;
            }
            var occurError = void 0;
            if (fiber.tag < 3) {
                var keepbook = Renderer.currentOwner;
                try {
                    updateClassComponent(fiber, info);
                } catch (e) {
                    occurError = true;
                    pushError(fiber, fiber.errorHook, e);
                }
                Renderer.currentOwner = keepbook;
                if (fiber.batching) {
                    delete fiber.updateFail;
                    delete fiber.batching;
                }
            } else {
                updateHostComponent(fiber, info);
            }
            if (fiber.child && !fiber.updateFail && !occurError) {
                fiber = fiber.child;
                continue outerLoop;
            }
            var f = fiber;
            while (f) {
                var instance = f.stateNode;
                if (f.tag > 3 || f.shiftContainer) {
                    if (f.shiftContainer) {
                        delete f.shiftContainer;
                        info.containerStack.shift();
                    }
                } else {
                    var updater = instance && instance.updater;
                    if (f.shiftContext) {
                        delete f.shiftContext;
                        info.contextStack.shift();
                    }
                    if (f.hasMounted && instance[gSBU]) {
                        updater.snapshot = guardCallback(instance, gSBU, [updater.prevProps, updater.prevState]);
                    }
                }
                if (f === topWork) {
                    break outerLoop;
                }
                if (f.sibling) {
                    fiber = f.sibling;
                    continue outerLoop;
                }
                f = f['return'];
            }
        }
    }
    function updateHostComponent(fiber, info) {
        var props = fiber.props,
            tag = fiber.tag,
            prev = fiber.alternate;
        if (!fiber.stateNode) {
            fiber.parent = info.containerStack[0];
            fiber.stateNode = Renderer.createElement(fiber);
        }
        var parent = fiber.parent;
        fiber.forwardFiber = parent.insertPoint;
        parent.insertPoint = fiber;
        fiber.effectTag = PLACE;
        if (tag === 5) {
            fiber.stateNode.insertPoint = null;
            info.containerStack.unshift(fiber.stateNode);
            fiber.shiftContainer = true;
            fiber.effectTag *= ATTR;
            if (fiber.ref) {
                fiber.effectTag *= REF;
            }
            diffChildren(fiber, props.children);
        } else {
            if (!prev || prev.props !== props) {
                fiber.effectTag *= CONTENT;
            }
        }
    }
    function mergeStates(fiber, nextProps) {
        var instance = fiber.stateNode,
            pendings = fiber.updateQueue.pendingStates,
            n = pendings.length,
            state = fiber.memoizedState || instance.state;
        if (n === 0) {
            return state;
        }
        var nextState = extend({}, state);
        var fail = true;
        for (var i = 0; i < n; i++) {
            var pending = pendings[i];
            if (pending) {
                if (isFn(pending)) {
                    var a = pending.call(instance, nextState, nextProps);
                    if (!a) {
                        continue;
                    } else {
                        pending = a;
                    }
                }
                fail = false;
                extend(nextState, pending);
            }
        }
        if (fail) {
            return state;
        } else {
            return fiber.memoizedState = nextState;
        }
    }
    function updateClassComponent(fiber, info) {
        var type = fiber.type,
            instance = fiber.stateNode,
            props = fiber.props;
        var contextStack = info.contextStack,
            containerStack = info.containerStack;
        var getContext = type.contextType;
        var unmaskedContext = contextStack[0];
        var isStaticContextType = isFn(type.contextType);
        var newContext = isStaticContextType ? getContext(fiber) : getMaskedContext(instance, type.contextTypes, unmaskedContext);
        if (instance == null) {
            fiber.parent = type === AnuPortal ? props.parent : containerStack[0];
            instance = createInstance(fiber, newContext);
            if (isStaticContextType) {
                getContext.subscribers.push(instance);
            }
        }
        if (!isStaticContextType) {
            cacheContext(instance, unmaskedContext, newContext);
        }
        var isStateful = !instance.__isStateless;
        instance._reactInternalFiber = fiber;
        if (isStateful) {
            var updateQueue = fiber.updateQueue;
            delete fiber.updateFail;
            if (fiber.hasMounted) {
                applybeforeUpdateHooks(fiber, instance, props, newContext, contextStack);
            } else {
                applybeforeMountHooks(fiber, instance, props);
            }
            if (fiber.memoizedState) {
                instance.state = fiber.memoizedState;
            }
            fiber.batching = updateQueue.batching;
            var cbs = updateQueue.pendingCbs;
            if (cbs.length) {
                fiber.pendingCbs = cbs;
                fiber.effectTag *= CALLBACK;
            }
            if (fiber.ref) {
                fiber.effectTag *= REF;
            }
        } else if (type === AnuPortal) {
            containerStack.unshift(fiber.parent);
            fiber.shiftContainer = true;
        }
        instance.context = newContext;
        fiber.memoizedProps = instance.props = props;
        fiber.memoizedState = instance.state;
        if (instance.getChildContext) {
            var context = instance.getChildContext();
            context = Object.assign({}, unmaskedContext, context);
            fiber.shiftContext = true;
            contextStack.unshift(context);
        }
        if (fiber.parent && fiber.hasMounted && fiber.dirty) {
            fiber.parent.insertPoint = getInsertPoint(fiber);
        }
        if (isStateful) {
            if (fiber.updateFail) {
                cloneChildren(fiber);
                fiber._hydrating = false;
                return;
            }
            delete fiber.dirty;
            fiber.effectTag *= HOOK;
        } else if (fiber.effectTag == 1) {
            fiber.effectTag = WORKING;
        }
        if (fiber.catchError) {
            return;
        }
        Renderer.onBeforeRender(fiber);
        fiber._hydrating = true;
        Renderer.currentOwner = instance;
        var rendered = applyCallback(instance, 'render', []);
        resetCursor();
        diffChildren(fiber, rendered);
        Renderer.onAfterRender(fiber);
    }
    function applybeforeMountHooks(fiber, instance, newProps) {
        fiber.setout = true;
        if (instance.__useNewHooks) {
            setStateByProps(fiber, newProps, instance.state);
        } else {
            callUnsafeHook(instance, 'componentWillMount', []);
        }
        delete fiber.setout;
        mergeStates(fiber, newProps);
        fiber.updateQueue = UpdateQueue();
    }
    function applybeforeUpdateHooks(fiber, instance, newProps, newContext, contextStack) {
        var oldProps = fiber.memoizedProps;
        var oldState = fiber.memoizedState;
        var updater = instance.updater;
        updater.prevProps = oldProps;
        updater.prevState = oldState;
        var propsChanged = oldProps !== newProps;
        fiber.setout = true;
        if (!instance.__useNewHooks) {
            var contextChanged = instance.context !== newContext;
            if (propsChanged || contextChanged) {
                var prevState = instance.state;
                callUnsafeHook(instance, 'componentWillReceiveProps', [newProps, newContext]);
                if (prevState !== instance.state) {
                    fiber.memoizedState = instance.state;
                }
            }
        }
        var newState = instance.state = oldState;
        var updateQueue = fiber.updateQueue;
        mergeStates(fiber, newProps);
        newState = fiber.memoizedState;
        setStateByProps(fiber, newProps, newState);
        newState = fiber.memoizedState;
        delete fiber.setout;
        fiber._hydrating = true;
        if (!propsChanged && newState === oldState && contextStack.length == 1 && !updateQueue.isForced) {
            fiber.updateFail = true;
        } else {
            var args = [newProps, newState, newContext];
            fiber.updateQueue = UpdateQueue();
            if (!updateQueue.isForced && !applyCallback(instance, 'shouldComponentUpdate', args)) {
                fiber.updateFail = true;
            } else if (!instance.__useNewHooks) {
                callUnsafeHook(instance, 'componentWillUpdate', args);
            }
        }
    }
    function callUnsafeHook(a, b, c) {
        applyCallback(a, b, c);
        applyCallback(a, 'UNSAFE_' + b, c);
    }
    function isSameNode(a, b) {
        if (a.type === b.type && a.key === b.key) {
            return true;
        }
    }
    function setStateByProps(fiber, nextProps, prevState) {
        fiber.errorHook = gDSFP;
        var fn = fiber.type[gDSFP];
        if (fn) {
            var partialState = fn.call(null, nextProps, prevState);
            if (typeNumber(partialState) === 8) {
                fiber.memoizedState = Object.assign({}, prevState, partialState);
            }
        }
    }
    function cloneChildren(fiber) {
        var prev = fiber.alternate;
        if (prev && prev.child) {
            var pc = prev.children;
            var cc = fiber.children = {};
            fiber.child = prev.child;
            fiber.lastChild = prev.lastChild;
            for (var i in pc) {
                var a = pc[i];
                a['return'] = fiber;
                cc[i] = a;
            }
            setInsertPoints(cc);
        }
    }
    function cacheContext(instance, unmaskedContext, context) {
        instance.__unmaskedContext = unmaskedContext;
        instance.__maskedContext = context;
    }
    function getMaskedContext(instance, contextTypes, unmaskedContext) {
        var noContext = !contextTypes;
        if (instance) {
            if (noContext) {
                return instance.context;
            }
            var cachedUnmasked = instance.__unmaskedContext;
            if (cachedUnmasked === unmaskedContext) {
                return instance.__maskedContext;
            }
        }
        var context = {};
        if (noContext) {
            return context;
        }
        for (var key in contextTypes) {
            if (contextTypes.hasOwnProperty(key)) {
                context[key] = unmaskedContext[key];
            }
        }
        return context;
    }
    function diffChildren(parentFiber, children) {
        var oldFibers = parentFiber.children;
        if (oldFibers) {
            parentFiber.oldChildren = oldFibers;
        } else {
            oldFibers = {};
        }
        var newFibers = fiberizeChildren(children, parentFiber);
        var effects$$1 = parentFiber.effects || (parentFiber.effects = []);
        var matchFibers = new Object();
        delete parentFiber.child;
        for (var i in oldFibers) {
            var newFiber = newFibers[i];
            var oldFiber = oldFibers[i];
            if (newFiber && newFiber.type === oldFiber.type) {
                matchFibers[i] = oldFiber;
                if (newFiber.key != null) {
                    oldFiber.key = newFiber.key;
                }
                continue;
            }
            detachFiber(oldFiber, effects$$1);
        }
        var prevFiber = void 0,
            index = 0;
        for (var _i in newFibers) {
            var _newFiber = newFibers[_i];
            var _oldFiber = matchFibers[_i];
            var alternate = null;
            if (_oldFiber) {
                if (isSameNode(_oldFiber, _newFiber)) {
                    alternate = new Fiber(_oldFiber);
                    var oldRef = _oldFiber.ref;
                    _newFiber = extend(_oldFiber, _newFiber);
                    delete _newFiber.disposed;
                    _newFiber.alternate = alternate;
                    if (_newFiber.ref && _newFiber.deleteRef) {
                        delete _newFiber.ref;
                        delete _newFiber.deleteRef;
                    }
                    if (oldRef && oldRef !== _newFiber.ref) {
                        effects$$1.push(alternate);
                    }
                    if (_newFiber.tag === 5) {
                        _newFiber.lastProps = alternate.props;
                    }
                } else {
                    detachFiber(_oldFiber, effects$$1);
                }
            } else {
                _newFiber = new Fiber(_newFiber);
            }
            newFibers[_i] = _newFiber;
            _newFiber.index = index++;
            _newFiber['return'] = parentFiber;
            if (prevFiber) {
                prevFiber.sibling = _newFiber;
                _newFiber.forward = prevFiber;
            } else {
                parentFiber.child = _newFiber;
                _newFiber.forward = null;
            }
            prevFiber = _newFiber;
        }
        parentFiber.lastChild = prevFiber;
        if (prevFiber) {
            prevFiber.sibling = null;
        }
    }

    function getDOMNode() {
        return this;
    }
    var Refs = {
        fireRef: function fireRef(fiber, dom) {
            var ref = fiber.ref;
            var owner = fiber._owner;
            try {
                var number = typeNumber(ref);
                refStrategy[number](owner, ref, dom);
                if (owner && owner.__isStateless) {
                    delete fiber.ref;
                    fiber.deleteRef = true;
                }
            } catch (e) {
                pushError(fiber, 'ref', e);
            }
        }
    };
    var refStrategy = {
        4: function _(owner, ref, dom) {
            if (dom === null) {
                delete owner.refs[ref];
            } else {
                if (dom.nodeType) {
                    dom.getDOMNode = getDOMNode;
                }
                owner.refs[ref] = dom;
            }
        },
        5: function _(owner, ref, dom) {
            ref(dom);
        },
        8: function _(owner, ref, dom) {
            ref.current = dom;
        }
    };

    var domFns = ['insertElement', 'updateContent', 'updateAttribute'];
    var domEffects = [PLACE, CONTENT, ATTR];
    var domRemoved = [];
    var passiveFibers = [];
    function commitDFSImpl(fiber) {
        var topFiber = fiber;
        outerLoop: while (true) {
            if (fiber.effects && fiber.effects.length) {
                fiber.effects.forEach(disposeFiber);
                delete fiber.effects;
            }
            if (fiber.effectTag % PLACE == 0) {
                domEffects.forEach(function (effect, i) {
                    if (fiber.effectTag % effect == 0) {
                        Renderer[domFns[i]](fiber);
                        fiber.effectTag /= effect;
                    }
                });
                fiber.hasMounted = true;
            } else {
                if (fiber.catchError) {
                    removeFormBoundaries(fiber);
                    disposeFibers(fiber);
                }
            }
            if (fiber.updateFail) {
                delete fiber.updateFail;
            }
            if (fiber.child && fiber.child.effectTag > NOWORK) {
                fiber = fiber.child;
                continue;
            }
            var f = fiber;
            while (f) {
                if (f.effectTag === WORKING) {
                    f.effectTag = NOWORK;
                    f.hasMounted = true;
                } else if (f.effectTag > WORKING) {
                    commitEffects(f);
                    f.hasMounted = true;
                    if (f.capturedValues) {
                        f.effectTag = CAPTURE;
                    }
                }
                if (f === topFiber || f.hostRoot) {
                    break outerLoop;
                }
                if (f.sibling) {
                    fiber = f.sibling;
                    continue outerLoop;
                }
                f = f['return'];
            }
        }
    }
    function commitDFS(effects$$1) {
        Renderer.batchedUpdates(function () {
            var el;
            while (el = effects$$1.shift()) {
                if (el.effectTag === DETACH && el.caughtError) {
                    disposeFiber(el);
                } else {
                    commitDFSImpl(el);
                }
                if (passiveFibers.length) {
                    passiveFibers.forEach(function (fiber) {
                        safeInvokeHooks(fiber.updateQueue, 'passive', 'unpassive');
                    });
                    passiveFibers.length = 0;
                }
                if (domRemoved.length) {
                    domRemoved.forEach(Renderer.removeElement);
                    domRemoved.length = 0;
                }
            }
        }, {});
        var error = Renderer.catchError;
        if (error) {
            delete Renderer.catchError;
            throw error;
        }
    }
    function commitEffects(fiber) {
        var instance = fiber.stateNode || emptyObject;
        var amount = fiber.effectTag;
        var updater = instance.updater || fakeObject;
        for (var i = 0; i < effectLength; i++) {
            var effectNo = effectNames[i];
            if (effectNo > amount) {
                break;
            }
            if (amount % effectNo === 0) {
                amount /= effectNo;
                switch (effectNo) {
                    case WORKING:
                        break;
                    case DUPLEX:
                        Renderer.updateControlled(fiber);
                        break;
                    case HOOK:
                        if (instance.__isStateless) {
                            safeInvokeHooks(fiber.updateQueue, 'layout', 'unlayout');
                        } else if (fiber.hasMounted) {
                            guardCallback(instance, 'componentDidUpdate', [updater.prevProps, updater.prevState, updater.snapshot]);
                        } else {
                            fiber.hasMounted = true;
                            guardCallback(instance, 'componentDidMount', []);
                        }
                        delete fiber._hydrating;
                        if (fiber.catchError) {
                            fiber.effectTag = amount;
                            return;
                        }
                        break;
                    case PASSIVE:
                        passiveFibers.push(fiber);
                        break;
                    case REF:
                        Refs.fireRef(fiber, instance);
                        break;
                    case CALLBACK:
                        var queue = fiber.pendingCbs;
                        fiber._hydrating = true;
                        queue.forEach(function (fn) {
                            fn.call(instance);
                        });
                        delete fiber._hydrating;
                        delete fiber.pendingCbs;
                        break;
                    case CAPTURE:
                        var values = fiber.capturedValues;
                        fiber.caughtError = true;
                        var a = values.shift();
                        var b = values.shift();
                        if (!values.length) {
                            fiber.effectTag = amount;
                            delete fiber.capturedValues;
                        }
                        instance.componentDidCatch(a, b);
                        break;
                }
            }
        }
        fiber.effectTag = NOWORK;
    }
    function disposeFibers(fiber) {
        var list = [fiber.oldChildren, fiber.children];
        for (var i = 0; i < 2; i++) {
            var c = list[i];
            if (c) {
                for (var _i in c) {
                    var child = c[_i];
                    if (!child.disposed && child.hasMounted) {
                        disposeFiber(child, true);
                        disposeFibers(child);
                    }
                }
            }
        }
        delete fiber.child;
        delete fiber.lastChild;
        delete fiber.oldChildren;
        fiber.children = {};
    }
    function safeInvokeHooks(upateQueue, create, destory) {
        var uneffects = upateQueue[destory],
            effects$$1 = upateQueue[create],
            fn;
        if (!uneffects) {
            return;
        }
        while (fn = uneffects.shift()) {
            try {
                fn();
            } catch (e) {      }
        }
        while (fn = effects$$1.shift()) {
            try {
                var f = fn();
                if (typeof f === 'function') {
                    uneffects.push(f);
                }
            } catch (e) {      }
        }
    }
    function disposeFiber(fiber, force) {
        var stateNode = fiber.stateNode,
            effectTag = fiber.effectTag;
        if (!stateNode) {
            return;
        }
        var isStateless = stateNode.__isStateless;
        if (!isStateless && fiber.ref) {
            Refs.fireRef(fiber, null);
        }
        if (effectTag % DETACH == 0 || force === true) {
            if (fiber.tag > 3) {
                domRemoved.push(fiber);
            } else {
                Renderer.onDispose(fiber);
                if (fiber.hasMounted) {
                    if (isStateless) {
                        safeInvokeHooks(fiber.updateQueue, 'layout', 'unlayout');
                        safeInvokeHooks(fiber.updateQueue, 'passive', 'unpassive');
                    }
                    stateNode.updater.enqueueSetState = returnFalse;
                    guardCallback(stateNode, 'componentWillUnmount', []);
                    delete fiber.stateNode;
                }
            }
            delete fiber.alternate;
            delete fiber.hasMounted;
            fiber.disposed = true;
        }
        fiber.effectTag = NOWORK;
    }

    var Unbatch = miniCreateClass(function Unbatch(props) {
        this.state = {
            child: props.child
        };
    }, Component, {
        render: function f3() {
            return this.state.child;
        }
    });

    var macrotasks = Renderer.macrotasks;
    var boundaries = Renderer.boundaries;
    var batchedtasks = [];
    function render(vnode, root, callback) {
        var container = createContainer(root),
            immediateUpdate = false;
        if (!container.hostRoot) {
            var fiber = new Fiber({
                type: Unbatch,
                tag: 2,
                props: {},
                hasMounted: true,
                memoizedState: {},
                'return': container
            });
            fiber.index = 0;
            container.child = fiber;
            var instance = createInstance(fiber, {});
            container.hostRoot = instance;
            immediateUpdate = true;
            Renderer.emptyElement(container);
        }
        var carrier = {};
        updateComponent(container.child, {
            child: vnode
        }, wrapCb(callback, carrier), immediateUpdate);
        return carrier.instance;
    }
    function wrapCb(fn, carrier) {
        return function () {
            var fiber = get(this);
            var target = fiber.child ? fiber.child.stateNode : null;
            fn && fn.call(target);
            carrier.instance = target;
        };
    }
    function performWork(deadline) {
        workLoop(deadline);
        if (boundaries.length) {
            macrotasks.unshift.apply(macrotasks, boundaries);
            boundaries.length = 0;
        }
        topFibers.forEach(function (el) {
            var microtasks = el.microtasks;
            while (el = microtasks.shift()) {
                if (!el.disposed) {
                    macrotasks.push(el);
                }
            }
        });
        if (macrotasks.length) {
            requestIdleCallback(performWork);
        }
    }
    var ENOUGH_TIME = 1;
    var deadline = {
        didTimeout: false,
        timeRemaining: function timeRemaining() {
            return 2;
        }
    };
    function requestIdleCallback(fn) {
        fn(deadline);
    }
    Renderer.scheduleWork = function () {
        performWork(deadline);
    };
    var isBatching = false;
    Renderer.batchedUpdates = function (callback, event) {
        var keepbook = isBatching;
        isBatching = true;
        try {
            event && Renderer.fireMiddlewares(true);
            return callback(event);
        } finally {
            isBatching = keepbook;
            if (!isBatching) {
                var el = void 0;
                while (el = batchedtasks.shift()) {
                    if (!el.disabled) {
                        macrotasks.push(el);
                    }
                }
                event && Renderer.fireMiddlewares();
                Renderer.scheduleWork();
            }
        }
    };
    function workLoop(deadline) {
        var fiber = macrotasks.shift(),
            info = void 0;
        if (fiber) {
            if (fiber.type === Unbatch) {
                info = fiber['return'];
            } else {
                var dom = getContainer(fiber);
                info = {
                    containerStack: [dom],
                    contextStack: [fiber.stateNode.__unmaskedContext]
                };
            }
            reconcileDFS(fiber, info, deadline, ENOUGH_TIME);
            updateCommitQueue(fiber);
            resetStack(info);
            if (macrotasks.length && deadline.timeRemaining() > ENOUGH_TIME) {
                workLoop(deadline);
            } else {
                commitDFS(effects);
            }
        }
    }
    function updateCommitQueue(fiber) {
        var hasBoundary = boundaries.length;
        if (fiber.type !== Unbatch) {
            if (hasBoundary) {
                arrayPush.apply(effects, boundaries);
            } else {
                effects.push(fiber);
            }
        } else {
            effects.push(fiber);
        }
        boundaries.length = 0;
    }
    function mergeUpdates(fiber, state, isForced, callback) {
        var updateQueue = fiber.updateQueue;
        if (isForced) {
            updateQueue.isForced = true;
        }
        if (state) {
            updateQueue.pendingStates.push(state);
        }
        if (isFn(callback)) {
            updateQueue.pendingCbs.push(callback);
        }
    }
    function fiberContains(p, son) {
        while (son['return']) {
            if (son['return'] === p) {
                return true;
            }
            son = son['return'];
        }
    }
    function getQueue(fiber) {
        while (fiber) {
            if (fiber.microtasks) {
                return fiber.microtasks;
            }
            fiber = fiber['return'];
        }
    }
    function pushChildQueue(fiber, queue) {
        var maps = {};
        for (var i = queue.length, el; el = queue[--i];) {
            if (fiber === el) {
                queue.splice(i, 1);
                continue;
            } else if (fiberContains(fiber, el)) {
                queue.splice(i, 1);
                continue;
            }
            maps[el.stateNode.updater.mountOrder] = true;
        }
        var enqueue = true,
            p = fiber,
            hackSCU = [];
        while (p['return']) {
            p = p['return'];
            var instance = p.stateNode;
            if (instance.refs && !instance.__isStateless && p.type !== Unbatch) {
                hackSCU.push(p);
                var u = instance.updater;
                if (maps[u.mountOrder]) {
                    enqueue = false;
                    break;
                }
            }
        }
        hackSCU.forEach(function (el) {
            el.updateQueue.batching = true;
        });
        if (enqueue) {
            queue.push(fiber);
        }
    }
    function updateComponent(fiber, state, callback, immediateUpdate) {
        fiber.dirty = true;
        var sn = typeNumber(state);
        var isForced = state === true;
        var microtasks = getQueue(fiber);
        state = isForced ? null : sn === 5 || sn === 8 ? state : null;
        if (fiber.setout) {
            immediateUpdate = false;
        } else if (isBatching && !immediateUpdate || fiber._hydrating) {
            pushChildQueue(fiber, batchedtasks);
        } else {
            immediateUpdate = immediateUpdate || !fiber._hydrating;
            pushChildQueue(fiber, microtasks);
        }
        mergeUpdates(fiber, state, isForced, callback);
        if (immediateUpdate) {
            Renderer.scheduleWork();
        }
    }
    Renderer.updateComponent = updateComponent;
    function validateTag(el) {
        return el && el.appendChild;
    }
    function createContainer(root, onlyGet, validate) {
        validate = validate || validateTag;
        if (!validate(root)) {
            throw 'container is not a element';
        }
        root.anuProp = 2018;
        var useProp = root.anuProp === 2018;
        if (useProp) {
            root.anuProp = void 0;
            if (get(root)) {
                return get(root);
            }
        } else {
            var index = topNodes.indexOf(root);
            if (index !== -1) {
                return topFibers[index];
            }
        }
        if (onlyGet) {
            return null;
        }
        var container = new Fiber({
            stateNode: root,
            tag: 5,
            name: 'hostRoot',
            contextStack: [{}],
            containerStack: [root],
            microtasks: [],
            type: root.nodeName || root.type
        });
        if (useProp) {
            root._reactInternalFiber = container;
        }
        topNodes.push(root);
        topFibers.push(container);
        return container;
    }
    function getContainer(p) {
        if (p.parent) {
            return p.parent;
        }
        while (p = p['return']) {
            if (p.tag === 5) {
                return p.stateNode;
            }
        }
    }

    var reuseTextNodes = [];
    function createElement$1(vnode) {
        var p = vnode['return'];
        var type = vnode.type,
            props = vnode.props,
            ns = vnode.ns;
        switch (type) {
            case '#text':
                var node = reuseTextNodes.pop();
                if (node) {
                    node.nodeValue = props;
                    return node;
                }
                return document.createTextNode(props);
            case '#comment':
                return document.createComment(props);
            case 'svg':
                ns = NAMESPACE.svg;
                break;
            case 'math':
                ns = NAMESPACE.math;
                break;
            default:
                do {
                    var s = p.name == 'AnuPortal' ? p.props.parent : p.tag === 5 ? p.stateNode : null;
                    if (s) {
                        ns = s.namespaceURI;
                        if (p.type === 'foreignObject' || ns === NAMESPACE.xhtml) {
                            ns = '';
                        }
                        break;
                    }
                } while (p = p['return']);
                break;
        }
        try {
            if (ns) {
                vnode.namespaceURI = ns;
                return document.createElementNS(ns, type);
            }
        } catch (e1) {
        }
        var elem = document.createElement(type);
        var inputType = props && props.type;
        if (inputType && elem.uniqueID) {
            try {
                elem = document.createElement('<' + type + ' type=\'' + inputType + '\'/>');
            } catch (e2) {
            }
        }
        return elem;
    }
    var hyperspace = document.createElement('div');
    function _emptyElement(node) {
        while (node.firstChild) {
            node.removeChild(node.firstChild);
        }
    }
    Renderer.middleware({
        begin: noop,
        end: fireDuplex
    });
    function _removeElement(node) {
        if (!node) {
            return;
        }
        var nodeType = node.nodeType;
        if (nodeType === 1 && node.__events) {
            node.__events = null;
        } else if (nodeType === 3 && reuseTextNodes.length < 100) {
            reuseTextNodes.push(node);
        }
        hyperspace.appendChild(node);
        hyperspace.removeChild(node);
    }
    function safeActiveElement() {
        try {
            return document.activeElement;
        } catch (e) {}
    }
    function insertElement(fiber) {
        var dom = fiber.stateNode,
            parent = fiber.parent;
        try {
            var insertPoint = fiber.forwardFiber ? fiber.forwardFiber.stateNode : null;
            var after = insertPoint ? insertPoint.nextSibling : parent.firstChild;
            if (after == dom) {
                return;
            }
            if (after === null && dom === parent.lastChild) {
                return;
            }
            Renderer.inserting = fiber.tag === 5 && safeActiveElement();
            parent.insertBefore(dom, after);
            Renderer.inserting = null;
        } catch (e) {
            throw e;
        }
    }
    render.Render = Renderer;
    function mergeContext(container, context) {
        container.contextStack[0] = Object.assign({}, context);
    }
    var DOMRenderer = createRenderer({
        render: render,
        updateAttribute: function updateAttribute(fiber) {
            var props = fiber.props,
                lastProps = fiber.lastProps,
                stateNode = fiber.stateNode;
            diffProps(stateNode, lastProps || emptyObject, props, fiber);
        },
        updateContent: function updateContent(fiber) {
            fiber.stateNode.nodeValue = fiber.props;
        },
        updateControlled: duplexAction,
        createElement: createElement$1,
        insertElement: insertElement,
        emptyElement: function emptyElement(fiber) {
            _emptyElement(fiber.stateNode);
        },
        unstable_renderSubtreeIntoContainer: function unstable_renderSubtreeIntoContainer(instance, vnode, root, callback) {
            var container = createContainer(root),
                fiber = get(instance),
                backup = void 0;
            do {
                var inst = fiber.stateNode;
                if (inst && inst.getChildContext) {
                    backup = mergeContext(container, inst.getChildContext());
                    break;
                } else {
                    backup = fiber;
                }
            } while (fiber = fiber['return']);
            if (backup && backup.contextStack) {
                mergeContext(container, backup.contextStack[0]);
            }
            return Renderer.render(vnode, root, callback);
        },
        unmountComponentAtNode: function unmountComponentAtNode(root) {
            var container = createContainer(root, true);
            var fiber = Object(container).child;
            if (fiber) {
                Renderer.updateComponent(fiber, {
                    child: null
                }, function () {
                    removeTop(root);
                }, true);
                return true;
            }
            return false;
        },
        removeElement: function removeElement(fiber) {
            var dom = fiber.stateNode;
            if (dom) {
                _removeElement(dom);
                delete fiber.stateNode;
                if (dom._reactInternalFiber) {
                    removeTop(dom);
                }
            }
        }
    });
    function removeTop(dom) {
        var j = topNodes.indexOf(dom);
        if (j !== -1) {
            topFibers.splice(j, 1);
            topNodes.splice(j, 1);
        }
        dom._reactInternalFiber = null;
    }

    function useState(initValue) {
        return useReducerImpl(null, initValue);
    }
    function useReducer(reducer, initValue, initAction) {
        return useReducerImpl(reducer, initValue, initAction);
    }
    function useEffect(create, deps) {
        return useEffectImpl(create, deps, PASSIVE, 'passive', 'unpassive');
    }
    function useLayoutEffect(create, deps) {
        return useEffectImpl(create, deps, HOOK, 'layout', 'unlayout');
    }
    function useCallback(create, deps) {
        return useCallbackImpl(create, deps);
    }
    function useMemo(create, deps) {
        return useCallbackImpl(create, deps, true);
    }

    function Suspense(props) {
        return props.children;
    }

    var LazyComponent = miniCreateClass(function LazyComponent(props, context) {
        var _this = this;
        this.props = props;
        this.context = context;
        this.state = {
            component: null,
            resolved: false
        };
        var promise = props.render();
        if (!promise || !isFn(promise.then)) {
            throw "lazy必须返回一个thenable对象";
        }
        promise.then(function (value) {
            return _this.setState({
                component: value["default"],
                resolved: true
            });
        });
    }, Component, {
        fallback: function fallback() {
            var parent = Object(get(this))["return"];
            while (parent) {
                if (parent.type === Suspense) {
                    return parent.props.fallback;
                }
                parent = parent["return"];
            }
            throw "lazy组件必须包一个Suspense组件";
        },
        render: function f2() {
            return this.state.resolved ? createElement(this.state.component) : this.fallback();
        }
    });
    function lazy(fn) {
        return function () {
            return createElement(LazyComponent, {
                render: fn
            });
        };
    }

    var noCheck = false;
    function setSelectValue(e) {
        if (e.propertyName === "value" && !noCheck) {
            syncValueByOptionValue(e.srcElement);
        }
    }
    function syncValueByOptionValue(dom) {
        var idx = dom.selectedIndex,
            option = void 0,
            attr = void 0;
        if (idx > -1) {
            option = dom.options[idx];
            attr = option.attributes.value;
            dom.value = attr && attr.specified ? option.value : option.text;
        }
    }
    var fixIEChangeHandle = createHandle("change", function (e) {
        var dom = e.srcElement;
        if (dom.type === "select-one") {
            if (!dom.__bindFixValueFn) {
                addEvent(dom, "propertychange", setSelectValue);
                dom.__bindFixValueFn = true;
            }
            noCheck = true;
            syncValueByOptionValue(dom);
            noCheck = false;
            return true;
        }
        if (e.type === "propertychange") {
            return e.propertyName === "value" && !dom.__anuSetValue;
        }
    });
    var fixIEInputHandle = createHandle("input", function (e) {
        return e.propertyName === "value";
    });
    var IEHandleFix = {
        input: function input(dom) {
            addEvent(dom, "propertychange", fixIEInputHandle);
        },
        change: function change(dom) {
            var mask = /radio|check/.test(dom.type) ? "click" : /text|password/.test(dom.type) ? "propertychange" : "change";
            addEvent(dom, mask, fixIEChangeHandle);
        },
        submit: function submit(dom) {
            if (dom.nodeName === "FORM") {
                addEvent(dom, "submit", dispatchEvent);
            }
        }
    };
    if (msie < 9) {
        actionStrategy[innerHTML] = function (dom, name, val, lastProps) {
            var oldhtml = lastProps[name] && lastProps[name].__html;
            var html = val && val.__html;
            if (html !== oldhtml) {
                dom.innerHTML = String.fromCharCode(0xfeff) + html;
                var textNode = dom.firstChild;
                if (textNode.data.length === 1) {
                    dom.removeChild(textNode);
                } else {
                    textNode.deleteData(0, 1);
                }
            }
        };
        focusMap.focus = "focusin";
        focusMap.blur = "focusout";
        focusMap.focusin = "focus";
        focusMap.focusout = "blur";
        extend(eventPropHooks, oneObject("mousemove, mouseout,mouseenter, mouseleave, mouseout,mousewheel, mousewheel, whe" + "el, click", function (event) {
            if (!("pageX" in event)) {
                var doc = event.target.ownerDocument || document;
                var box = doc.compatMode === "BackCompat" ? doc.body : doc.documentElement;
                event.pageX = event.clientX + (box.scrollLeft >> 0) - (box.clientLeft >> 0);
                event.pageY = event.clientY + (box.scrollTop >> 0) - (box.clientTop >> 0);
            }
        }));
        var translateToKey = {
            "8": "Backspace",
            "9": "Tab",
            "12": "Clear",
            "13": "Enter",
            "16": "Shift",
            "17": "Control",
            "18": "Alt",
            "19": "Pause",
            "20": "CapsLock",
            "27": "Escape",
            "32": " ",
            "33": "PageUp",
            "34": "PageDown",
            "35": "End",
            "36": "Home",
            "37": "ArrowLeft",
            "38": "ArrowUp",
            "39": "ArrowRight",
            "40": "ArrowDown",
            "45": "Insert",
            "46": "Delete",
            "112": "F1",
            "113": "F2",
            "114": "F3",
            "115": "F4",
            "116": "F5",
            "117": "F6",
            "118": "F7",
            "119": "F8",
            "120": "F9",
            "121": "F10",
            "122": "F11",
            "123": "F12",
            "144": "NumLock",
            "145": "ScrollLock",
            "224": "Meta"
        };
        extend(eventPropHooks, oneObject("keyup, keydown, keypress", function (event) {
            if (!event.which && event.type.indexOf("key") === 0) {
                event.key = translateToKey[event.keyCode];
                event.which = event.charCode != null ? event.charCode : event.keyCode;
            }
        }));
        for (var i in IEHandleFix) {
            eventHooks[i] = eventHooks[i + "capture"] = IEHandleFix[i];
        }
    }

    var win$1 = getWindow();
    var prevReact = win$1.React;
    var React = void 0;
    if (prevReact && prevReact.eventSystem) {
        React = prevReact;
    } else {
        var render$1 = DOMRenderer.render,
            eventSystem = DOMRenderer.eventSystem,
            unstable_renderSubtreeIntoContainer = DOMRenderer.unstable_renderSubtreeIntoContainer,
            unmountComponentAtNode = DOMRenderer.unmountComponentAtNode;
        React = win$1.React = win$1.ReactDOM = {
            eventSystem: eventSystem,
            findDOMNode: findDOMNode,
            unmountComponentAtNode: unmountComponentAtNode,
            unstable_renderSubtreeIntoContainer: unstable_renderSubtreeIntoContainer,
            miniCreateClass: miniCreateClass,
            version: '1.6.0',
            render: render$1,
            hydrate: render$1,
            unstable_batchedUpdates: DOMRenderer.batchedUpdates,
            Fragment: Fragment,
            PropTypes: PropTypes,
            Children: Children,
            createPortal: createPortal,
            createContext: createContext,
            Component: Component,
            lazy: lazy,
            Suspense: Suspense,
            createRef: createRef,
            forwardRef: forwardRef,
            useState: useState,
            useReducer: useReducer,
            useEffect: useEffect,
            useLayoutEffect: useLayoutEffect,
            useContext: useContext,
            useCallback: useCallback,
            useMemo: useMemo,
            useRef: useRef,
            useImperativeHandle: useImperativeHandle,
            createElement: createElement,
            cloneElement: cloneElement,
            PureComponent: PureComponent,
            isValidElement: isValidElement,
            createFactory: createFactory
        };
    }
    var React$1 = React;

    return React$1;

})));

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../_webpack@4.41.2@webpack/buildin/global.js */ "./node_modules/_webpack@4.41.2@webpack/buildin/global.js")))

/***/ }),

/***/ "./node_modules/_anujs@1.6.0@anujs/dist/Router.js":
/*!********************************************************!*\
  !*** ./node_modules/_anujs@1.6.0@anujs/dist/Router.js ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(global) {/**
 * Reach Router的anujs适配版 文档见这里 https://reach.tech/router
 */

(function (global, factory) {
     true ? module.exports = factory() :
        undefined;
}(this, (function () {
    var hasOwnProperty = Object.prototype.hasOwnProperty;
    var fakeWindow = {};
    function getWindow() {
        try {
            if (window) {
                return window;
            }
        } catch (e) { }
        try {
            if (global) {
                return global;
            }
        } catch (e) { }
        return fakeWindow;
    }
    function extend(obj, props) {
        for (var i in props) {
            if (hasOwnProperty.call(props, i)) {
                obj[i] = props[i];
            }
        }
        return obj;
    }
    function inherit(SubClass, SupClass) {
        function Bridge() { }
        var orig = SubClass.prototype;
        Bridge.prototype = SupClass.prototype;
        var fn = SubClass.prototype = new Bridge();
        extend(fn, orig);
        fn.constructor = SubClass;
        return fn;
    }
    try {
        var supportEval = Function('a', 'return a + 1')(2) == 3;
    } catch (e) { }
    var rname = /function\s+(\w+)/;
    function miniCreateClass(ctor, superClass, methods, statics) {
        var className = ctor.name || (ctor.toString().match(rname) || ['', 'Anonymous'])[1];
        var Ctor = supportEval ? Function('superClass', 'ctor', 'return function ' + className + ' (props, context) {\n            superClass.apply(this, arguments); \n            ctor.apply(this, arguments);\n      }')(superClass, ctor) : function ReactInstance() {
            superClass.apply(this, arguments);
            ctor.apply(this, arguments);
        };
        Ctor.displayName = className;
        var proto = inherit(Ctor, superClass);
        extend(proto, methods);
        extend(Ctor, superClass);
        if (statics) {
            extend(Ctor, statics);
        }
        return Ctor;
    }

    function startsWith(string, search) {
        return string.slice(0, search.length) === search;
    }
    var reservedNames = ["uri", "path"];
    function invariant(condition, msg) {
        if (!condition) {
            throw msg;
        }
    }
    function pick(routes, uri) {
        var match = void 0;
        var default_ = void 0;
        var uriPathname = uri.split("?").shift();
        var uriSegments = segmentize(uriPathname);
        var isRootUri = uriSegments[0] === "";
        var ranked = rankRoutes(routes);
        for (var i = 0, l = ranked.length; i < l; i++) {
            var missed = false;
            var route = ranked[i].route;
            if (route["default"]) {
                default_ = {
                    route: route,
                    params: {},
                    uri: uri
                };
                continue;
            }
            var routeSegments = segmentize(route.path);
            var params = {};
            var max = Math.max(uriSegments.length, routeSegments.length);
            var index = 0;
            for (; index < max; index++) {
                var routeSegment = routeSegments[index];
                var uriSegment = uriSegments[index];
                var _isSplat = routeSegment === "*";
                if (_isSplat) {
                    params["*"] = uriSegments.slice(index).map(decodeURIComponent).join("/");
                    break;
                }
                if (uriSegment === undefined) {
                    missed = true;
                    break;
                }
                var dynamicMatch = paramRe.exec(routeSegment);
                if (dynamicMatch && !isRootUri) {
                    invariant(!reservedNames.includes(dynamicMatch[1]), "<Router> dynamic segment \"" + dynamicMatch[1] + "\" is a reserved name. Please use a different name in path \"" + route.path + "\".");
                    var value = decodeURIComponent(uriSegment);
                    params[dynamicMatch[1]] = value;
                } else if (routeSegment !== uriSegment) {
                    missed = true;
                    break;
                }
            }
            if (!missed) {
                match = {
                    route: route,
                    params: params,
                    uri: "/" + uriSegments.slice(0, index).join("/")
                };
                break;
            }
        }
        return match || default_ || null;
    }
    function match(path, uri) {
        return pick([{ path: path }], uri);
    }
    function resolve(to, base) {
        if (startsWith(to, "/")) {
            return to;
        }
        var _arr = to.split("?");
        var toPathname = _arr[0];
        var toQuery = _arr[1];
        var basePathname = base.split("?").shift();
        var toSegments = segmentize(toPathname);
        var baseSegments = segmentize(basePathname);
        if (toSegments[0] === "") {
            return addQuery(basePathname, toQuery);
        }
        if (!startsWith(toSegments[0], ".")) {
            var pathname = baseSegments.concat(toSegments).join("/");
            return addQuery((basePathname === "/" ? "" : "/") + pathname, toQuery);
        }
        var allSegments = baseSegments.concat(toSegments);
        var segments = [];
        for (var i = 0, n = allSegments.length; i < n; i++) {
            var segment = allSegments[i];
            if (segment === "..") {
                segments.pop();
            } else if (segment !== ".") {
                segments.push(segment);
            }
        }
        return addQuery("/" + segments.join("/"), toQuery);
    }
    function insertParams(path, params) {
        var segments = segmentize(path);
        return "/" + segments.map(function (segment) {
            var match = paramRe.exec(segment);
            return match ? params[match[1]] : segment;
        }).join("/");
    }
    function validateRedirect(from, to) {
        var filter = function filter(segment) {
            return isDynamic(segment);
        };
        var fromString = segmentize(from).filter(filter).sort().join("/");
        var toString = segmentize(to).filter(filter).sort().join("/");
        return fromString === toString;
    }
    var paramRe = /^:(.+)/;
    var SEGMENT_POINTS = 4;
    var STATIC_POINTS = 3;
    var DYNAMIC_POINTS = 2;
    var SPLAT_PENALTY = 1;
    var ROOT_POINTS = 1;
    var isRootSegment = function isRootSegment(segment) {
        return segment == "";
    };
    var isDynamic = function isDynamic(segment) {
        return paramRe.test(segment);
    };
    var isSplat = function isSplat(segment) {
        return segment === "*";
    };
    function rankRoute(route, index) {
        var score = route["default"] ? 0 : segmentize(route.path).reduce(function (score, segment) {
            score += SEGMENT_POINTS;
            if (isRootSegment(segment)) {
                score += ROOT_POINTS;
            } else if (isDynamic(segment)) {
                score += DYNAMIC_POINTS;
            } else if (isSplat(segment)) {
                score -= SEGMENT_POINTS + SPLAT_PENALTY;
            } else {
                score += STATIC_POINTS;
            }
            return score;
        }, 0);
        return { route: route, score: score, index: index };
    }
    function sorter(a, b) {
        return a.score < b.score ? 1 : a.score > b.score ? -1 : a.index - b.index;
    }
    function rankRoutes(routes) {
        return routes.map(rankRoute).sort(sorter);
    }
    function segmentize(uri) {
        return uri.replace(/(^\/+|\/+$)/g, "").split("/");
    }
    function addQuery(pathname, query) {
        return pathname + (query ? "?" + query : "");
    }

    var modeObject = {};
    function getLocation(source) {
        var location = {
            getPath: function getPath() {
                return modeObject.value === 'hash' ? this.hash.slice(1) : this.pathname;
            },
            state: source.history.state,
            key: source.history.state && source.history.state.key || 'initial'
        };
        for (var key in source.location) {
            if (Object.prototype.hasOwnProperty.call(source.location, key)) {
                location[key] = source.location[key];
            }
        }
        return location;
    }
    function createHistory(source) {
        var listeners = [];
        var transitioning = false;
        var resolveTransition = function resolveTransition() { };
        var target = {
            location: getLocation(source),
            transitioning: transitioning,
            _onTransitionComplete: function _onTransitionComplete() {
                target.transitioning = transitioning = false;
                resolveTransition();
            },
            listen: function listen(listener) {
                listeners.push(listener);
                var popstateListener = function popstateListener(e) {
                    target.location = getLocation(source);
                    listener();
                };
                var event = modeObject.value === 'hash' ? 'hashchange' : 'popstate';
                addEvent(source, event, popstateListener);
                return function () {
                    removeEvent(source, event, popstateListener);
                    listeners = listeners.filter(function (fn) {
                        return fn !== listener;
                    });
                };
            },
            navigate: function navigate(to) {
                var _ref = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : {},
                    state = _ref.state,
                    _ref$replace = _ref.replace,
                    replace = _ref$replace === undefined ? false : _ref$replace;
                state = Object.assign({}, state, {
                    key: Date.now() + ''
                });
                var slocation = source.location;
                if (modeObject.value === 'hash') {
                    if (replace && slocation.hash !== newHash) {
                        history.back();
                    }
                    slocation.hash = to;
                } else {
                    try {
                        if (transitioning || replace) {
                            source.history.replaceState(state, null, to);
                        } else {
                            source.history.pushState(state, null, to);
                        }
                    } catch (e) {
                        slocation[replace ? 'replace' : 'assign'](to);
                    }
                }
                target.location = getLocation(source);
                target.transitioning = transitioning = true;
                var transition = new Promise(function (res) {
                    return resolveTransition = res;
                });
                listeners.forEach(function (fn) {
                    return fn();
                });
                return transition;
            }
        };
        return target;
    }
    function addEvent(dom, name, fn) {
        if (dom.addEventListener) {
            dom.addEventListener(name, fn);
        } else if (dom.attachEvent) {
            dom.attachEvent('on' + name, fn);
        }
    }
    function removeEvent(dom, name, fn) {
        if (dom.removeEventListener) {
            dom.removeEventListener(name, fn);
        } else if (dom.detachEvent) {
            dom.detachEvent('on' + name, fn);
        }
    }
    function createMemorySource() {
        var initialPathname = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : '/';
        var index = 0;
        var states = [];
        var stack = [{
            pathname: initialPathname,
            search: ''
        }];
        var target = {
            addEventListener: function addEventListener(name, fn) { },
            removeEventListener: function removeEventListener(name, fn) { },
            history: {
                back: function back() { },
                pushState: function pushState(state, _, uri) {
                    index++;
                    stack.push(uri2obj(uri));
                    states.push(state);
                    sync(target);
                },
                replaceState: function replaceState(state, _, uri) {
                    stack[index] = uri2obj(uri);
                    states[index] = state;
                    sync(target);
                }
            }
        };
        function sync(target) {
            var history = target.history;
            history.index = index;
            history.entries = stack;
            history.state = states[index];
            target.location = stack[index];
        }
        sync(target);
        return target;
    }
    function uri2obj(uri) {
        var arr = uri.split('?');
        var pathname = arr[0];
        var search = arr[1] || '';
        return {
            pathname: pathname,
            search: search
        };
    }
    var win = getWindow();
    var getSource = function getSource() {
        return win.location ? win : createMemorySource();
    };
    var globalHistory = createHistory(getSource());
    var navigate = globalHistory.navigate;

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }
    var win$1 = getWindow();
    var supportPushState = !!win$1.history && win$1.history.pushState;
    var React = win$1.React;
    if (!React || !React.eventSystem) {
        throw "请先安装anujs";
    }
    var unstable_deferredUpdates = React.unstable_deferredUpdates,
        PropTypes = React.PropTypes,
        cloneElement = React.cloneElement,
        PureComponent = React.PureComponent,
        createContext = React.createContext,
        Children = React.Children,
        Component = React.Component;
    if (unstable_deferredUpdates === undefined) {
        unstable_deferredUpdates = function unstable_deferredUpdates(fn) {
            return fn();
        };
    }
    var createNamedContext = function createNamedContext(name, defaultValue) {
        var Ctx = createContext(defaultValue);
        Ctx.Consumer.displayName = name + ".Consumer";
        Ctx.Provider.displayName = name + ".Provider";
        return Ctx;
    };
    var LocationContext = createNamedContext("Location");
    var Location = function Location(_ref) {
        var children = _ref.children;
        return React.createElement(
            LocationContext.Consumer,
            null,
            function (context) {
                return context ? children(context) : React.createElement(
                    LocationProvider,
                    null,
                    children
                );
            }
        );
    };
    var LocationProvider = miniCreateClass(function LocationProvider() {
        this.state = {
            context: this.getContext(),
            refs: { unlisten: null }
        };
    }, Component, {
            getContext: function getContext() {
                var _props$history = this.props.history,
                    navigate$$1 = _props$history.navigate,
                    location = _props$history.location;
                return { navigate: navigate$$1, location: location };
            },
            componentDidCatch: function componentDidCatch(error, info) {
                if (isRedirect(error)) {
                    var _navigate = this.props.history.navigate;
                    _navigate(error.uri, { replace: true });
                } else {
                    throw error;
                }
            },
            componentDidUpdate: function componentDidUpdate(prevProps, prevState) {
                if (prevState.context.location !== this.state.context.location) {
                    this.props.history._onTransitionComplete();
                }
            },
            componentDidMount: function componentDidMount() {
                var _this = this;
                var refs = this.state.refs,
                    history = this.props.history;
                refs.unlisten = history.listen(function () {
                    Promise.resolve().then(function () {
                        unstable_deferredUpdates(function () {
                            if (!_this.unmounted) {
                                _this.setState(function () {
                                    return { context: _this.getContext() };
                                });
                            }
                        });
                    });
                });
            },
            componentWillUnmount: function componentWillUnmount() {
                var refs = this.state.refs;
                this.unmounted = true;
                refs.unlisten();
            },
            render: function render() {
                var context = this.state.context,
                    children = this.props.children;
                return React.createElement(
                    LocationContext.Provider,
                    { value: context },
                    typeof children === "function" ? children(context) : children || null
                );
            }
        }, {
            defaultProps: {
                history: globalHistory
            }
        });
    var ServerLocation = function ServerLocation(_ref2) {
        var url = _ref2.url,
            children = _ref2.children;
        return React.createElement(
            LocationContext.Provider,
            {
                value: {
                    location: { pathname: url },
                    navigate: function navigate$$1() {
                        throw new Error("You can't call navigate on the server.");
                    }
                }
            },
            children
        );
    };
    var BaseContext = createNamedContext("Base", { baseuri: "/", basepath: "/" });
    function Router(props) {
        modeObject.value = supportPushState && (!props.mode || props.mode === "history") ? "history" : "hash";
        return React.createElement(
            BaseContext.Consumer,
            null,
            function (baseContext) {
                return React.createElement(
                    Location,
                    null,
                    function (locationContext) {
                        return React.createElement(RouterImpl, _extends({}, baseContext, locationContext, props));
                    }
                );
            }
        );
    }
    var RouterImpl = miniCreateClass(function RouterImpl() { }, PureComponent, {
        render: function render() {
            var _props = this.props,
                location = _props.location,
                _navigate2 = _props.navigate,
                basepath = _props.basepath,
                primary = _props.primary,
                children = _props.children,
                _props$component = _props.component,
                component = _props$component === undefined ? "div" : _props$component,
                baseuri = _props.baseuri,
                mode = _props.mode,
                domProps = _objectWithoutProperties(_props, ["location", "navigate", "basepath", "primary", "children", "component", "baseuri", "mode"]);
            var routes = Children.map(children, createRoute(basepath));
            var pathname = location.getPath();
            var match$$1 = pick(routes, pathname);
            if (match$$1) {
                var params = match$$1.params,
                    uri = match$$1.uri,
                    route = match$$1.route,
                    element = match$$1.route.value;
                basepath = route["default"] ? basepath : route.path.replace(/\*$/, "");
                var props = Object.assign({}, params, {
                    uri: uri,
                    location: location,
                    navigate: function navigate$$1(to, options) {
                        return _navigate2(resolve(to, uri), options);
                    }
                });
                var clone = cloneElement(element, props, element.props.children ? React.createElement(
                    Router,
                    { primary: primary, mode: mode },
                    element.props.children
                ) : void 666);
                var FocusWrapper = primary ? FocusHandler : component;
                var wrapperProps = primary ? Object.assign({ uri: uri, location: location }, domProps) : domProps;
                return React.createElement(
                    BaseContext.Provider,
                    { value: { baseuri: uri, basepath: basepath } },
                    React.createElement(
                        FocusWrapper,
                        wrapperProps,
                        clone
                    )
                );
            } else {
                return null;
            }
        }
    }, {
            defaultProps: {
                primary: true
            }
        });
    var FocusContext = createNamedContext("Focus");
    var FocusHandler = function FocusHandler(_ref3) {
        var uri = _ref3.uri,
            location = _ref3.location,
            domProps = _objectWithoutProperties(_ref3, ["uri", "location"]);
        return React.createElement(
            FocusContext.Consumer,
            null,
            function (requestFocus) {
                return React.createElement(FocusHandlerImpl, _extends({}, domProps, {
                    requestFocus: requestFocus,
                    uri: uri,
                    location: location
                }));
            }
        );
    };
    var initialRender = true;
    var focusHandlerCount = 0;
    var FocusHandlerImpl = miniCreateClass(function FocusHandlerImpl() {
        var _this2 = this;
        this.state = {};
        this.requestFocus = function (node) {
            if (!_this2.state.shouldFocus) {
                node.focus();
            }
        };
    }, Component, {
            componentDidMount: function componentDidMount() {
                focusHandlerCount++;
                this.focus();
            },
            componentWillUnmount: function componentWillUnmount() {
                focusHandlerCount--;
                if (focusHandlerCount === 0) {
                    initialRender = true;
                }
            },
            componentDidUpdate: function componentDidUpdate(prevProps, prevState) {
                if (prevProps.location !== this.props.location && this.state.shouldFocus) {
                    this.focus();
                }
            },
            focus: function focus() {
                if (getWindow().process) {
                    return;
                }
                var requestFocus = this.props.requestFocus;
                if (requestFocus) {
                    requestFocus(this.node);
                } else {
                    if (initialRender) {
                        initialRender = false;
                    } else {
                        this.node.focus();
                    }
                }
            },
            render: function render() {
                var _this3 = this;
                var _props2 = this.props,
                    children = _props2.children,
                    style = _props2.style,
                    requestFocus = _props2.requestFocus,
                    _props2$role = _props2.role,
                    role = _props2$role === undefined ? "group" : _props2$role,
                    _props2$component = _props2.component,
                    Comp = _props2$component === undefined ? "div" : _props2$component,
                    uri = _props2.uri,
                    location = _props2.location,
                    domProps = _objectWithoutProperties(_props2, ["children", "style", "requestFocus", "role", "component", "uri", "location"]);
                return React.createElement(
                    Comp,
                    _extends({
                        style: Object.assign({ outline: "none" }, style),
                        tabIndex: "-1",
                        role: role,
                        ref: function ref(n) {
                            return _this3.node = n;
                        }
                    }, domProps),
                    React.createElement(
                        FocusContext.Provider,
                        { value: this.requestFocus },
                        this.props.children
                    )
                );
            }
        }, {
            getDerivedStateFromProps: function getDerivedStateFromProps(nextProps, prevState) {
                var initial = prevState.uri == null;
                if (initial) {
                    return Object.assign({
                        shouldFocus: true
                    }, nextProps);
                } else {
                    var myURIChanged = nextProps.uri !== prevState.uri;
                    var nextPath = nextProps.location.getPath();
                    var navigatedUpToMe = prevState.location.getPath() !== nextPath && nextPath === nextProps.uri;
                    return Object.assign({
                        shouldFocus: myURIChanged || navigatedUpToMe
                    }, nextProps);
                }
            }
        });
    function noop$1() { }
    var Link = function Link(props) {
        return React.createElement(
            BaseContext.Consumer,
            null,
            function (_ref4) {
                var basepath = _ref4.basepath,
                    baseuri = _ref4.baseuri;
                return React.createElement(
                    Location,
                    null,
                    function (_ref5) {
                        var location = _ref5.location,
                            navigate$$1 = _ref5.navigate;
                        var anchorProps = {},
                            to = void 0,
                            state = void 0,
                            replace = void 0,
                            getProps = noop$1;
                        for (var key in props) {
                            var val = props[key];
                            if (key === "to") {
                                to = val;
                            } else if (key === "state") {
                                state = val;
                            } else if (key === "replace") {
                                replace = val;
                            } else if (key == "getProps" && val) {
                                getProps = val;
                            } else {
                                anchorProps[key] = val;
                            }
                        }
                        var href = resolve(to, baseuri);
                        var isCurrent = location.getPath() === href;
                        var isPartiallyCurrent = startsWith(location.getPath(), href);
                        Object.assign(anchorProps, getProps({ isCurrent: isCurrent, isPartiallyCurrent: isPartiallyCurrent, href: href, location: location }));
                        anchorProps.href = href;
                        if (isCurrent) {
                            anchorProps["aria-current"] = "page";
                        }
                        var fn = anchorProps.onClick;
                        anchorProps.onClick = function (event) {
                            if (fn) {
                                fn(event);
                            }
                            if (shouldNavigate(event)) {
                                event.preventDefault();
                                navigate$$1(href, { state: state, replace: replace });
                            }
                        };
                        return React.createElement("a", anchorProps);
                    }
                );
            }
        );
    };
    function RedirectRequest(uri) {
        this.uri = uri;
    }
    var isRedirect = function isRedirect(o) {
        return o instanceof RedirectRequest;
    };
    var redirectTo = function redirectTo(to) {
        throw new RedirectRequest(to);
    };
    var RedirectImpl = miniCreateClass(function RedirectImpl() { }, Component, {
        componentDidMount: function componentDidMount() {
            var _props3 = this.props,
                navigate$$1 = _props3.navigate,
                to = _props3.to,
                from = _props3.from,
                _props3$replace = _props3.replace,
                replace = _props3$replace === undefined ? true : _props3$replace,
                state = _props3.state,
                noThrow = _props3.noThrow,
                props = _objectWithoutProperties(_props3, ["navigate", "to", "from", "replace", "state", "noThrow"]);
            navigate$$1(insertParams(to, props), { replace: replace, state: state });
        },
        render: function render() {
            var _props4 = this.props,
                navigate$$1 = _props4.navigate,
                to = _props4.to,
                from = _props4.from,
                replace = _props4.replace,
                state = _props4.state,
                noThrow = _props4.noThrow,
                props = _objectWithoutProperties(_props4, ["navigate", "to", "from", "replace", "state", "noThrow"]);
            if (!noThrow) {
                redirectTo(insertParams(to, props));
            }
            return null;
        }
    });
    var Redirect = function Redirect(props) {
        return React.createElement(
            Location,
            null,
            function (locationContext) {
                return React.createElement(RedirectImpl, _extends({}, locationContext, props));
            }
        );
    };
    Redirect.propTypes = {
        from: PropTypes.string,
        to: PropTypes.string.isRequired
    };
    var Match = function Match(_ref6) {
        var path = _ref6.path,
            children = _ref6.children;
        return React.createElement(
            BaseContext.Consumer,
            null,
            function (_ref7) {
                var baseuri = _ref7.baseuri;
                return React.createElement(
                    Location,
                    null,
                    function (_ref8) {
                        var navigate$$1 = _ref8.navigate,
                            location = _ref8.location;
                        var resolvedPath = resolve(path, baseuri);
                        var result = match(resolvedPath, location.getPath());
                        return children({
                            navigate: navigate$$1,
                            location: location,
                            match: result ? Object.assign({}, result.params, {
                                uri: result.uri,
                                path: path
                            }) : null
                        });
                    }
                );
            }
        );
    };
    var stripSlashes = function stripSlashes(str) {
        return str.replace(/(^\/+|\/+$)/g, "");
    };
    var createRoute = function createRoute(basepath) {
        return function (element) {
            invariant(element.props.path || element.props["default"] || element.type === Redirect, "<Router>: Children of <Router> must have a \"path\" or \"default\" prop, or be a \"<Redirect>\". \n         None found on element type \"" + element.type + "\"");
            invariant(!(element.type === Redirect && (!element.props.from || !element.props.to)), "<Redirect from=\"" + element.props.from + " to=\"" + element.props.to + "\"/> requires both \"from\" and \"to\" props when inside a <Router>.");
            invariant(!(element.type === Redirect && !validateRedirect(element.props.from, element.props.to)), "<Redirect from=\"" + element.props.from + " to=\"" + element.props.to + "\"/> has mismatched dynamic segments, ensure both paths have the exact same dynamic segments.");
            if (element.props["default"]) {
                return { value: element, "default": true };
            }
            var elementPath = element.type === Redirect ? element.props.from : element.props.path;
            var path = elementPath === "/" ? basepath : stripSlashes(basepath) + "/" + stripSlashes(elementPath);
            return {
                value: element,
                "default": element.props["default"],
                path: element.props.children ? stripSlashes(path) + "/*" : path
            };
        };
    };
    function shouldNavigate(event) {
        return !event.button && !(event.metaKey || event.altKey || event.ctrlKey || event.shiftKey);
    }
    var ReachRouter = {
        version: "1.5.3",
        Link: Link,
        Location: Location,
        LocationProvider: LocationProvider,
        Match: Match,
        Redirect: Redirect,
        Router: Router,
        ServerLocation: ServerLocation,
        createHistory: createHistory,
        createMemorySource: createMemorySource,
        isRedirect: isRedirect,
        navigate: navigate,
        redirectTo: redirectTo
    };

    return ReachRouter;

})));

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../_webpack@4.41.2@webpack/buildin/global.js */ "./node_modules/_webpack@4.41.2@webpack/buildin/global.js")))

/***/ }),

/***/ "./node_modules/_anujs@1.6.0@anujs/lib/ReactPropTypes.js":
/*!***************************************************************!*\
  !*** ./node_modules/_anujs@1.6.0@anujs/lib/ReactPropTypes.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

(function umd(root, factory) {
    if (true) {
        module.exports = factory();
    } else {}
})(this, function () {
    var check = function () {
        return check;
    };
    check.isRequired = check;
    return {
        array: check,
        bool: check,
        func: check,
        number: check,
        object: check,
        string: check,
        any: check,
        arrayOf: check,
        element: check,
        instanceOf: check,
        node: check,
        objectOf: check,
        oneOf: check,
        oneOfType: check,
        shape: check
    };
});


/***/ }),

/***/ "./node_modules/_bluebird@3.7.1@bluebird/js/browser/bluebird.js":
/*!**********************************************************************!*\
  !*** ./node_modules/_bluebird@3.7.1@bluebird/js/browser/bluebird.js ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(process, global, setImmediate) {/* @preserve
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013-2018 Petka Antonov
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */
/**
 * bluebird build version 3.7.1
 * Features enabled: core, race, call_get, generators, map, nodeify, promisify, props, reduce, settle, some, using, timers, filter, any, each
*/
!function(e){if(true)module.exports=e();else { var f; }}(function(){var define,module,exports;return (function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof _dereq_=="function"&&_dereq_;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof _dereq_=="function"&&_dereq_;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise) {
var SomePromiseArray = Promise._SomePromiseArray;
function any(promises) {
    var ret = new SomePromiseArray(promises);
    var promise = ret.promise();
    ret.setHowMany(1);
    ret.setUnwrap();
    ret.init();
    return promise;
}

Promise.any = function (promises) {
    return any(promises);
};

Promise.prototype.any = function () {
    return any(this);
};

};

},{}],2:[function(_dereq_,module,exports){
"use strict";
var firstLineError;
try {throw new Error(); } catch (e) {firstLineError = e;}
var schedule = _dereq_("./schedule");
var Queue = _dereq_("./queue");

function Async() {
    this._customScheduler = false;
    this._isTickUsed = false;
    this._lateQueue = new Queue(16);
    this._normalQueue = new Queue(16);
    this._haveDrainedQueues = false;
    var self = this;
    this.drainQueues = function () {
        self._drainQueues();
    };
    this._schedule = schedule;
}

Async.prototype.setScheduler = function(fn) {
    var prev = this._schedule;
    this._schedule = fn;
    this._customScheduler = true;
    return prev;
};

Async.prototype.hasCustomScheduler = function() {
    return this._customScheduler;
};

Async.prototype.haveItemsQueued = function () {
    return this._isTickUsed || this._haveDrainedQueues;
};


Async.prototype.fatalError = function(e, isNode) {
    if (isNode) {
        process.stderr.write("Fatal " + (e instanceof Error ? e.stack : e) +
            "\n");
        process.exit(2);
    } else {
        this.throwLater(e);
    }
};

Async.prototype.throwLater = function(fn, arg) {
    if (arguments.length === 1) {
        arg = fn;
        fn = function () { throw arg; };
    }
    if (typeof setTimeout !== "undefined") {
        setTimeout(function() {
            fn(arg);
        }, 0);
    } else try {
        this._schedule(function() {
            fn(arg);
        });
    } catch (e) {
        throw new Error("No async scheduler available\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
};

function AsyncInvokeLater(fn, receiver, arg) {
    this._lateQueue.push(fn, receiver, arg);
    this._queueTick();
}

function AsyncInvoke(fn, receiver, arg) {
    this._normalQueue.push(fn, receiver, arg);
    this._queueTick();
}

function AsyncSettlePromises(promise) {
    this._normalQueue._pushOne(promise);
    this._queueTick();
}

Async.prototype.invokeLater = AsyncInvokeLater;
Async.prototype.invoke = AsyncInvoke;
Async.prototype.settlePromises = AsyncSettlePromises;


function _drainQueue(queue) {
    while (queue.length() > 0) {
        _drainQueueStep(queue);
    }
}

function _drainQueueStep(queue) {
    var fn = queue.shift();
    if (typeof fn !== "function") {
        fn._settlePromises();
    } else {
        var receiver = queue.shift();
        var arg = queue.shift();
        fn.call(receiver, arg);
    }
}

Async.prototype._drainQueues = function () {
    _drainQueue(this._normalQueue);
    this._reset();
    this._haveDrainedQueues = true;
    _drainQueue(this._lateQueue);
};

Async.prototype._queueTick = function () {
    if (!this._isTickUsed) {
        this._isTickUsed = true;
        this._schedule(this.drainQueues);
    }
};

Async.prototype._reset = function () {
    this._isTickUsed = false;
};

module.exports = Async;
module.exports.firstLineError = firstLineError;

},{"./queue":26,"./schedule":29}],3:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, INTERNAL, tryConvertToPromise, debug) {
var calledBind = false;
var rejectThis = function(_, e) {
    this._reject(e);
};

var targetRejected = function(e, context) {
    context.promiseRejectionQueued = true;
    context.bindingPromise._then(rejectThis, rejectThis, null, this, e);
};

var bindingResolved = function(thisArg, context) {
    if (((this._bitField & 50397184) === 0)) {
        this._resolveCallback(context.target);
    }
};

var bindingRejected = function(e, context) {
    if (!context.promiseRejectionQueued) this._reject(e);
};

Promise.prototype.bind = function (thisArg) {
    if (!calledBind) {
        calledBind = true;
        Promise.prototype._propagateFrom = debug.propagateFromFunction();
        Promise.prototype._boundValue = debug.boundValueFunction();
    }
    var maybePromise = tryConvertToPromise(thisArg);
    var ret = new Promise(INTERNAL);
    ret._propagateFrom(this, 1);
    var target = this._target();
    ret._setBoundTo(maybePromise);
    if (maybePromise instanceof Promise) {
        var context = {
            promiseRejectionQueued: false,
            promise: ret,
            target: target,
            bindingPromise: maybePromise
        };
        target._then(INTERNAL, targetRejected, undefined, ret, context);
        maybePromise._then(
            bindingResolved, bindingRejected, undefined, ret, context);
        ret._setOnCancel(maybePromise);
    } else {
        ret._resolveCallback(target);
    }
    return ret;
};

Promise.prototype._setBoundTo = function (obj) {
    if (obj !== undefined) {
        this._bitField = this._bitField | 2097152;
        this._boundTo = obj;
    } else {
        this._bitField = this._bitField & (~2097152);
    }
};

Promise.prototype._isBound = function () {
    return (this._bitField & 2097152) === 2097152;
};

Promise.bind = function (thisArg, value) {
    return Promise.resolve(value).bind(thisArg);
};
};

},{}],4:[function(_dereq_,module,exports){
"use strict";
var old;
if (typeof Promise !== "undefined") old = Promise;
function noConflict() {
    try { if (Promise === bluebird) Promise = old; }
    catch (e) {}
    return bluebird;
}
var bluebird = _dereq_("./promise")();
bluebird.noConflict = noConflict;
module.exports = bluebird;

},{"./promise":22}],5:[function(_dereq_,module,exports){
"use strict";
var cr = Object.create;
if (cr) {
    var callerCache = cr(null);
    var getterCache = cr(null);
    callerCache[" size"] = getterCache[" size"] = 0;
}

module.exports = function(Promise) {
var util = _dereq_("./util");
var canEvaluate = util.canEvaluate;
var isIdentifier = util.isIdentifier;

var getMethodCaller;
var getGetter;
if (false) { var getCompiled, makeGetter, makeMethodCaller; }

function ensureMethod(obj, methodName) {
    var fn;
    if (obj != null) fn = obj[methodName];
    if (typeof fn !== "function") {
        var message = "Object " + util.classString(obj) + " has no method '" +
            util.toString(methodName) + "'";
        throw new Promise.TypeError(message);
    }
    return fn;
}

function caller(obj) {
    var methodName = this.pop();
    var fn = ensureMethod(obj, methodName);
    return fn.apply(obj, this);
}
Promise.prototype.call = function (methodName) {
    var args = [].slice.call(arguments, 1);;
    if (false) { var maybeCaller; }
    args.push(methodName);
    return this._then(caller, undefined, undefined, args, undefined);
};

function namedGetter(obj) {
    return obj[this];
}
function indexedGetter(obj) {
    var index = +this;
    if (index < 0) index = Math.max(0, index + obj.length);
    return obj[index];
}
Promise.prototype.get = function (propertyName) {
    var isIndex = (typeof propertyName === "number");
    var getter;
    if (!isIndex) {
        if (canEvaluate) {
            var maybeGetter = getGetter(propertyName);
            getter = maybeGetter !== null ? maybeGetter : namedGetter;
        } else {
            getter = namedGetter;
        }
    } else {
        getter = indexedGetter;
    }
    return this._then(getter, undefined, undefined, propertyName, undefined);
};
};

},{"./util":36}],6:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, PromiseArray, apiRejection, debug) {
var util = _dereq_("./util");
var tryCatch = util.tryCatch;
var errorObj = util.errorObj;
var async = Promise._async;

Promise.prototype["break"] = Promise.prototype.cancel = function() {
    if (!debug.cancellation()) return this._warn("cancellation is disabled");

    var promise = this;
    var child = promise;
    while (promise._isCancellable()) {
        if (!promise._cancelBy(child)) {
            if (child._isFollowing()) {
                child._followee().cancel();
            } else {
                child._cancelBranched();
            }
            break;
        }

        var parent = promise._cancellationParent;
        if (parent == null || !parent._isCancellable()) {
            if (promise._isFollowing()) {
                promise._followee().cancel();
            } else {
                promise._cancelBranched();
            }
            break;
        } else {
            if (promise._isFollowing()) promise._followee().cancel();
            promise._setWillBeCancelled();
            child = promise;
            promise = parent;
        }
    }
};

Promise.prototype._branchHasCancelled = function() {
    this._branchesRemainingToCancel--;
};

Promise.prototype._enoughBranchesHaveCancelled = function() {
    return this._branchesRemainingToCancel === undefined ||
           this._branchesRemainingToCancel <= 0;
};

Promise.prototype._cancelBy = function(canceller) {
    if (canceller === this) {
        this._branchesRemainingToCancel = 0;
        this._invokeOnCancel();
        return true;
    } else {
        this._branchHasCancelled();
        if (this._enoughBranchesHaveCancelled()) {
            this._invokeOnCancel();
            return true;
        }
    }
    return false;
};

Promise.prototype._cancelBranched = function() {
    if (this._enoughBranchesHaveCancelled()) {
        this._cancel();
    }
};

Promise.prototype._cancel = function() {
    if (!this._isCancellable()) return;
    this._setCancelled();
    async.invoke(this._cancelPromises, this, undefined);
};

Promise.prototype._cancelPromises = function() {
    if (this._length() > 0) this._settlePromises();
};

Promise.prototype._unsetOnCancel = function() {
    this._onCancelField = undefined;
};

Promise.prototype._isCancellable = function() {
    return this.isPending() && !this._isCancelled();
};

Promise.prototype.isCancellable = function() {
    return this.isPending() && !this.isCancelled();
};

Promise.prototype._doInvokeOnCancel = function(onCancelCallback, internalOnly) {
    if (util.isArray(onCancelCallback)) {
        for (var i = 0; i < onCancelCallback.length; ++i) {
            this._doInvokeOnCancel(onCancelCallback[i], internalOnly);
        }
    } else if (onCancelCallback !== undefined) {
        if (typeof onCancelCallback === "function") {
            if (!internalOnly) {
                var e = tryCatch(onCancelCallback).call(this._boundValue());
                if (e === errorObj) {
                    this._attachExtraTrace(e.e);
                    async.throwLater(e.e);
                }
            }
        } else {
            onCancelCallback._resultCancelled(this);
        }
    }
};

Promise.prototype._invokeOnCancel = function() {
    var onCancelCallback = this._onCancel();
    this._unsetOnCancel();
    async.invoke(this._doInvokeOnCancel, this, onCancelCallback);
};

Promise.prototype._invokeInternalOnCancel = function() {
    if (this._isCancellable()) {
        this._doInvokeOnCancel(this._onCancel(), true);
        this._unsetOnCancel();
    }
};

Promise.prototype._resultCancelled = function() {
    this.cancel();
};

};

},{"./util":36}],7:[function(_dereq_,module,exports){
"use strict";
module.exports = function(NEXT_FILTER) {
var util = _dereq_("./util");
var getKeys = _dereq_("./es5").keys;
var tryCatch = util.tryCatch;
var errorObj = util.errorObj;

function catchFilter(instances, cb, promise) {
    return function(e) {
        var boundTo = promise._boundValue();
        predicateLoop: for (var i = 0; i < instances.length; ++i) {
            var item = instances[i];

            if (item === Error ||
                (item != null && item.prototype instanceof Error)) {
                if (e instanceof item) {
                    return tryCatch(cb).call(boundTo, e);
                }
            } else if (typeof item === "function") {
                var matchesPredicate = tryCatch(item).call(boundTo, e);
                if (matchesPredicate === errorObj) {
                    return matchesPredicate;
                } else if (matchesPredicate) {
                    return tryCatch(cb).call(boundTo, e);
                }
            } else if (util.isObject(e)) {
                var keys = getKeys(item);
                for (var j = 0; j < keys.length; ++j) {
                    var key = keys[j];
                    if (item[key] != e[key]) {
                        continue predicateLoop;
                    }
                }
                return tryCatch(cb).call(boundTo, e);
            }
        }
        return NEXT_FILTER;
    };
}

return catchFilter;
};

},{"./es5":13,"./util":36}],8:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise) {
var longStackTraces = false;
var contextStack = [];

Promise.prototype._promiseCreated = function() {};
Promise.prototype._pushContext = function() {};
Promise.prototype._popContext = function() {return null;};
Promise._peekContext = Promise.prototype._peekContext = function() {};

function Context() {
    this._trace = new Context.CapturedTrace(peekContext());
}
Context.prototype._pushContext = function () {
    if (this._trace !== undefined) {
        this._trace._promiseCreated = null;
        contextStack.push(this._trace);
    }
};

Context.prototype._popContext = function () {
    if (this._trace !== undefined) {
        var trace = contextStack.pop();
        var ret = trace._promiseCreated;
        trace._promiseCreated = null;
        return ret;
    }
    return null;
};

function createContext() {
    if (longStackTraces) return new Context();
}

function peekContext() {
    var lastIndex = contextStack.length - 1;
    if (lastIndex >= 0) {
        return contextStack[lastIndex];
    }
    return undefined;
}
Context.CapturedTrace = null;
Context.create = createContext;
Context.deactivateLongStackTraces = function() {};
Context.activateLongStackTraces = function() {
    var Promise_pushContext = Promise.prototype._pushContext;
    var Promise_popContext = Promise.prototype._popContext;
    var Promise_PeekContext = Promise._peekContext;
    var Promise_peekContext = Promise.prototype._peekContext;
    var Promise_promiseCreated = Promise.prototype._promiseCreated;
    Context.deactivateLongStackTraces = function() {
        Promise.prototype._pushContext = Promise_pushContext;
        Promise.prototype._popContext = Promise_popContext;
        Promise._peekContext = Promise_PeekContext;
        Promise.prototype._peekContext = Promise_peekContext;
        Promise.prototype._promiseCreated = Promise_promiseCreated;
        longStackTraces = false;
    };
    longStackTraces = true;
    Promise.prototype._pushContext = Context.prototype._pushContext;
    Promise.prototype._popContext = Context.prototype._popContext;
    Promise._peekContext = Promise.prototype._peekContext = peekContext;
    Promise.prototype._promiseCreated = function() {
        var ctx = this._peekContext();
        if (ctx && ctx._promiseCreated == null) ctx._promiseCreated = this;
    };
};
return Context;
};

},{}],9:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, Context,
    enableAsyncHooks, disableAsyncHooks) {
var async = Promise._async;
var Warning = _dereq_("./errors").Warning;
var util = _dereq_("./util");
var es5 = _dereq_("./es5");
var canAttachTrace = util.canAttachTrace;
var unhandledRejectionHandled;
var possiblyUnhandledRejection;
var bluebirdFramePattern =
    /[\\\/]bluebird[\\\/]js[\\\/](release|debug|instrumented)/;
var nodeFramePattern = /\((?:timers\.js):\d+:\d+\)/;
var parseLinePattern = /[\/<\(](.+?):(\d+):(\d+)\)?\s*$/;
var stackFramePattern = null;
var formatStack = null;
var indentStackFrames = false;
var printWarning;
var debugging = !!(util.env("BLUEBIRD_DEBUG") != 0 &&
                        ( true ||
                         false));

var warnings = !!(util.env("BLUEBIRD_WARNINGS") != 0 &&
    (debugging || util.env("BLUEBIRD_WARNINGS")));

var longStackTraces = !!(util.env("BLUEBIRD_LONG_STACK_TRACES") != 0 &&
    (debugging || util.env("BLUEBIRD_LONG_STACK_TRACES")));

var wForgottenReturn = util.env("BLUEBIRD_W_FORGOTTEN_RETURN") != 0 &&
    (warnings || !!util.env("BLUEBIRD_W_FORGOTTEN_RETURN"));

var deferUnhandledRejectionCheck;
(function() {
    var promises = [];

    function unhandledRejectionCheck() {
        for (var i = 0; i < promises.length; ++i) {
            promises[i]._notifyUnhandledRejection();
        }
        unhandledRejectionClear();
    }

    function unhandledRejectionClear() {
        promises.length = 0;
    }

    if (typeof document === "object" && document.createElement) {
        deferUnhandledRejectionCheck = (function() {
            var iframeSetTimeout;

            function checkIframe() {
                if (document.body) {
                    var iframe = document.createElement("iframe");
                    document.body.appendChild(iframe);
                    if (iframe.contentWindow &&
                        iframe.contentWindow.setTimeout) {
                        iframeSetTimeout = iframe.contentWindow.setTimeout;
                    }
                    document.body.removeChild(iframe);
                }
            }
            checkIframe();
            return function(promise) {
                promises.push(promise);
                if (iframeSetTimeout) {
                    iframeSetTimeout(unhandledRejectionCheck, 1);
                } else {
                    checkIframe();
                }
            };
        })();
    } else {
        deferUnhandledRejectionCheck = function(promise) {
            promises.push(promise);
            setTimeout(unhandledRejectionCheck, 1);
        };
    }

    es5.defineProperty(Promise, "_unhandledRejectionCheck", {
        value: unhandledRejectionCheck
    });
    es5.defineProperty(Promise, "_unhandledRejectionClear", {
        value: unhandledRejectionClear
    });
})();

Promise.prototype.suppressUnhandledRejections = function() {
    var target = this._target();
    target._bitField = ((target._bitField & (~1048576)) |
                      524288);
};

Promise.prototype._ensurePossibleRejectionHandled = function () {
    if ((this._bitField & 524288) !== 0) return;
    this._setRejectionIsUnhandled();
    deferUnhandledRejectionCheck(this);
};

Promise.prototype._notifyUnhandledRejectionIsHandled = function () {
    fireRejectionEvent("rejectionHandled",
                                  unhandledRejectionHandled, undefined, this);
};

Promise.prototype._setReturnedNonUndefined = function() {
    this._bitField = this._bitField | 268435456;
};

Promise.prototype._returnedNonUndefined = function() {
    return (this._bitField & 268435456) !== 0;
};

Promise.prototype._notifyUnhandledRejection = function () {
    if (this._isRejectionUnhandled()) {
        var reason = this._settledValue();
        this._setUnhandledRejectionIsNotified();
        fireRejectionEvent("unhandledRejection",
                                      possiblyUnhandledRejection, reason, this);
    }
};

Promise.prototype._setUnhandledRejectionIsNotified = function () {
    this._bitField = this._bitField | 262144;
};

Promise.prototype._unsetUnhandledRejectionIsNotified = function () {
    this._bitField = this._bitField & (~262144);
};

Promise.prototype._isUnhandledRejectionNotified = function () {
    return (this._bitField & 262144) > 0;
};

Promise.prototype._setRejectionIsUnhandled = function () {
    this._bitField = this._bitField | 1048576;
};

Promise.prototype._unsetRejectionIsUnhandled = function () {
    this._bitField = this._bitField & (~1048576);
    if (this._isUnhandledRejectionNotified()) {
        this._unsetUnhandledRejectionIsNotified();
        this._notifyUnhandledRejectionIsHandled();
    }
};

Promise.prototype._isRejectionUnhandled = function () {
    return (this._bitField & 1048576) > 0;
};

Promise.prototype._warn = function(message, shouldUseOwnTrace, promise) {
    return warn(message, shouldUseOwnTrace, promise || this);
};

Promise.onPossiblyUnhandledRejection = function (fn) {
    var context = Promise._getContext();
    possiblyUnhandledRejection = util.contextBind(context, fn);
};

Promise.onUnhandledRejectionHandled = function (fn) {
    var context = Promise._getContext();
    unhandledRejectionHandled = util.contextBind(context, fn);
};

var disableLongStackTraces = function() {};
Promise.longStackTraces = function () {
    if (async.haveItemsQueued() && !config.longStackTraces) {
        throw new Error("cannot enable long stack traces after promises have been created\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
    if (!config.longStackTraces && longStackTracesIsSupported()) {
        var Promise_captureStackTrace = Promise.prototype._captureStackTrace;
        var Promise_attachExtraTrace = Promise.prototype._attachExtraTrace;
        var Promise_dereferenceTrace = Promise.prototype._dereferenceTrace;
        config.longStackTraces = true;
        disableLongStackTraces = function() {
            if (async.haveItemsQueued() && !config.longStackTraces) {
                throw new Error("cannot enable long stack traces after promises have been created\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
            }
            Promise.prototype._captureStackTrace = Promise_captureStackTrace;
            Promise.prototype._attachExtraTrace = Promise_attachExtraTrace;
            Promise.prototype._dereferenceTrace = Promise_dereferenceTrace;
            Context.deactivateLongStackTraces();
            config.longStackTraces = false;
        };
        Promise.prototype._captureStackTrace = longStackTracesCaptureStackTrace;
        Promise.prototype._attachExtraTrace = longStackTracesAttachExtraTrace;
        Promise.prototype._dereferenceTrace = longStackTracesDereferenceTrace;
        Context.activateLongStackTraces();
    }
};

Promise.hasLongStackTraces = function () {
    return config.longStackTraces && longStackTracesIsSupported();
};


var legacyHandlers = {
    unhandledrejection: {
        before: function() {
            var ret = util.global.onunhandledrejection;
            util.global.onunhandledrejection = null;
            return ret;
        },
        after: function(fn) {
            util.global.onunhandledrejection = fn;
        }
    },
    rejectionhandled: {
        before: function() {
            var ret = util.global.onrejectionhandled;
            util.global.onrejectionhandled = null;
            return ret;
        },
        after: function(fn) {
            util.global.onrejectionhandled = fn;
        }
    }
};

var fireDomEvent = (function() {
    var dispatch = function(legacy, e) {
        if (legacy) {
            var fn;
            try {
                fn = legacy.before();
                return !util.global.dispatchEvent(e);
            } finally {
                legacy.after(fn);
            }
        } else {
            return !util.global.dispatchEvent(e);
        }
    };
    try {
        if (typeof CustomEvent === "function") {
            var event = new CustomEvent("CustomEvent");
            util.global.dispatchEvent(event);
            return function(name, event) {
                name = name.toLowerCase();
                var eventData = {
                    detail: event,
                    cancelable: true
                };
                var domEvent = new CustomEvent(name, eventData);
                es5.defineProperty(
                    domEvent, "promise", {value: event.promise});
                es5.defineProperty(
                    domEvent, "reason", {value: event.reason});

                return dispatch(legacyHandlers[name], domEvent);
            };
        } else if (typeof Event === "function") {
            var event = new Event("CustomEvent");
            util.global.dispatchEvent(event);
            return function(name, event) {
                name = name.toLowerCase();
                var domEvent = new Event(name, {
                    cancelable: true
                });
                domEvent.detail = event;
                es5.defineProperty(domEvent, "promise", {value: event.promise});
                es5.defineProperty(domEvent, "reason", {value: event.reason});
                return dispatch(legacyHandlers[name], domEvent);
            };
        } else {
            var event = document.createEvent("CustomEvent");
            event.initCustomEvent("testingtheevent", false, true, {});
            util.global.dispatchEvent(event);
            return function(name, event) {
                name = name.toLowerCase();
                var domEvent = document.createEvent("CustomEvent");
                domEvent.initCustomEvent(name, false, true,
                    event);
                return dispatch(legacyHandlers[name], domEvent);
            };
        }
    } catch (e) {}
    return function() {
        return false;
    };
})();

var fireGlobalEvent = (function() {
    if (util.isNode) {
        return function() {
            return process.emit.apply(process, arguments);
        };
    } else {
        if (!util.global) {
            return function() {
                return false;
            };
        }
        return function(name) {
            var methodName = "on" + name.toLowerCase();
            var method = util.global[methodName];
            if (!method) return false;
            method.apply(util.global, [].slice.call(arguments, 1));
            return true;
        };
    }
})();

function generatePromiseLifecycleEventObject(name, promise) {
    return {promise: promise};
}

var eventToObjectGenerator = {
    promiseCreated: generatePromiseLifecycleEventObject,
    promiseFulfilled: generatePromiseLifecycleEventObject,
    promiseRejected: generatePromiseLifecycleEventObject,
    promiseResolved: generatePromiseLifecycleEventObject,
    promiseCancelled: generatePromiseLifecycleEventObject,
    promiseChained: function(name, promise, child) {
        return {promise: promise, child: child};
    },
    warning: function(name, warning) {
        return {warning: warning};
    },
    unhandledRejection: function (name, reason, promise) {
        return {reason: reason, promise: promise};
    },
    rejectionHandled: generatePromiseLifecycleEventObject
};

var activeFireEvent = function (name) {
    var globalEventFired = false;
    try {
        globalEventFired = fireGlobalEvent.apply(null, arguments);
    } catch (e) {
        async.throwLater(e);
        globalEventFired = true;
    }

    var domEventFired = false;
    try {
        domEventFired = fireDomEvent(name,
                    eventToObjectGenerator[name].apply(null, arguments));
    } catch (e) {
        async.throwLater(e);
        domEventFired = true;
    }

    return domEventFired || globalEventFired;
};

Promise.config = function(opts) {
    opts = Object(opts);
    if ("longStackTraces" in opts) {
        if (opts.longStackTraces) {
            Promise.longStackTraces();
        } else if (!opts.longStackTraces && Promise.hasLongStackTraces()) {
            disableLongStackTraces();
        }
    }
    if ("warnings" in opts) {
        var warningsOption = opts.warnings;
        config.warnings = !!warningsOption;
        wForgottenReturn = config.warnings;

        if (util.isObject(warningsOption)) {
            if ("wForgottenReturn" in warningsOption) {
                wForgottenReturn = !!warningsOption.wForgottenReturn;
            }
        }
    }
    if ("cancellation" in opts && opts.cancellation && !config.cancellation) {
        if (async.haveItemsQueued()) {
            throw new Error(
                "cannot enable cancellation after promises are in use");
        }
        Promise.prototype._clearCancellationData =
            cancellationClearCancellationData;
        Promise.prototype._propagateFrom = cancellationPropagateFrom;
        Promise.prototype._onCancel = cancellationOnCancel;
        Promise.prototype._setOnCancel = cancellationSetOnCancel;
        Promise.prototype._attachCancellationCallback =
            cancellationAttachCancellationCallback;
        Promise.prototype._execute = cancellationExecute;
        propagateFromFunction = cancellationPropagateFrom;
        config.cancellation = true;
    }
    if ("monitoring" in opts) {
        if (opts.monitoring && !config.monitoring) {
            config.monitoring = true;
            Promise.prototype._fireEvent = activeFireEvent;
        } else if (!opts.monitoring && config.monitoring) {
            config.monitoring = false;
            Promise.prototype._fireEvent = defaultFireEvent;
        }
    }
    if ("asyncHooks" in opts && util.nodeSupportsAsyncResource) {
        var prev = config.asyncHooks;
        var cur = !!opts.asyncHooks;
        if (prev !== cur) {
            config.asyncHooks = cur;
            if (cur) {
                enableAsyncHooks();
            } else {
                disableAsyncHooks();
            }
        }
    }
    return Promise;
};

function defaultFireEvent() { return false; }

Promise.prototype._fireEvent = defaultFireEvent;
Promise.prototype._execute = function(executor, resolve, reject) {
    try {
        executor(resolve, reject);
    } catch (e) {
        return e;
    }
};
Promise.prototype._onCancel = function () {};
Promise.prototype._setOnCancel = function (handler) { ; };
Promise.prototype._attachCancellationCallback = function(onCancel) {
    ;
};
Promise.prototype._captureStackTrace = function () {};
Promise.prototype._attachExtraTrace = function () {};
Promise.prototype._dereferenceTrace = function () {};
Promise.prototype._clearCancellationData = function() {};
Promise.prototype._propagateFrom = function (parent, flags) {
    ;
    ;
};

function cancellationExecute(executor, resolve, reject) {
    var promise = this;
    try {
        executor(resolve, reject, function(onCancel) {
            if (typeof onCancel !== "function") {
                throw new TypeError("onCancel must be a function, got: " +
                                    util.toString(onCancel));
            }
            promise._attachCancellationCallback(onCancel);
        });
    } catch (e) {
        return e;
    }
}

function cancellationAttachCancellationCallback(onCancel) {
    if (!this._isCancellable()) return this;

    var previousOnCancel = this._onCancel();
    if (previousOnCancel !== undefined) {
        if (util.isArray(previousOnCancel)) {
            previousOnCancel.push(onCancel);
        } else {
            this._setOnCancel([previousOnCancel, onCancel]);
        }
    } else {
        this._setOnCancel(onCancel);
    }
}

function cancellationOnCancel() {
    return this._onCancelField;
}

function cancellationSetOnCancel(onCancel) {
    this._onCancelField = onCancel;
}

function cancellationClearCancellationData() {
    this._cancellationParent = undefined;
    this._onCancelField = undefined;
}

function cancellationPropagateFrom(parent, flags) {
    if ((flags & 1) !== 0) {
        this._cancellationParent = parent;
        var branchesRemainingToCancel = parent._branchesRemainingToCancel;
        if (branchesRemainingToCancel === undefined) {
            branchesRemainingToCancel = 0;
        }
        parent._branchesRemainingToCancel = branchesRemainingToCancel + 1;
    }
    if ((flags & 2) !== 0 && parent._isBound()) {
        this._setBoundTo(parent._boundTo);
    }
}

function bindingPropagateFrom(parent, flags) {
    if ((flags & 2) !== 0 && parent._isBound()) {
        this._setBoundTo(parent._boundTo);
    }
}
var propagateFromFunction = bindingPropagateFrom;

function boundValueFunction() {
    var ret = this._boundTo;
    if (ret !== undefined) {
        if (ret instanceof Promise) {
            if (ret.isFulfilled()) {
                return ret.value();
            } else {
                return undefined;
            }
        }
    }
    return ret;
}

function longStackTracesCaptureStackTrace() {
    this._trace = new CapturedTrace(this._peekContext());
}

function longStackTracesAttachExtraTrace(error, ignoreSelf) {
    if (canAttachTrace(error)) {
        var trace = this._trace;
        if (trace !== undefined) {
            if (ignoreSelf) trace = trace._parent;
        }
        if (trace !== undefined) {
            trace.attachExtraTrace(error);
        } else if (!error.__stackCleaned__) {
            var parsed = parseStackAndMessage(error);
            util.notEnumerableProp(error, "stack",
                parsed.message + "\n" + parsed.stack.join("\n"));
            util.notEnumerableProp(error, "__stackCleaned__", true);
        }
    }
}

function longStackTracesDereferenceTrace() {
    this._trace = undefined;
}

function checkForgottenReturns(returnValue, promiseCreated, name, promise,
                               parent) {
    if (returnValue === undefined && promiseCreated !== null &&
        wForgottenReturn) {
        if (parent !== undefined && parent._returnedNonUndefined()) return;
        if ((promise._bitField & 65535) === 0) return;

        if (name) name = name + " ";
        var handlerLine = "";
        var creatorLine = "";
        if (promiseCreated._trace) {
            var traceLines = promiseCreated._trace.stack.split("\n");
            var stack = cleanStack(traceLines);
            for (var i = stack.length - 1; i >= 0; --i) {
                var line = stack[i];
                if (!nodeFramePattern.test(line)) {
                    var lineMatches = line.match(parseLinePattern);
                    if (lineMatches) {
                        handlerLine  = "at " + lineMatches[1] +
                            ":" + lineMatches[2] + ":" + lineMatches[3] + " ";
                    }
                    break;
                }
            }

            if (stack.length > 0) {
                var firstUserLine = stack[0];
                for (var i = 0; i < traceLines.length; ++i) {

                    if (traceLines[i] === firstUserLine) {
                        if (i > 0) {
                            creatorLine = "\n" + traceLines[i - 1];
                        }
                        break;
                    }
                }

            }
        }
        var msg = "a promise was created in a " + name +
            "handler " + handlerLine + "but was not returned from it, " +
            "see http://goo.gl/rRqMUw" +
            creatorLine;
        promise._warn(msg, true, promiseCreated);
    }
}

function deprecated(name, replacement) {
    var message = name +
        " is deprecated and will be removed in a future version.";
    if (replacement) message += " Use " + replacement + " instead.";
    return warn(message);
}

function warn(message, shouldUseOwnTrace, promise) {
    if (!config.warnings) return;
    var warning = new Warning(message);
    var ctx;
    if (shouldUseOwnTrace) {
        promise._attachExtraTrace(warning);
    } else if (config.longStackTraces && (ctx = Promise._peekContext())) {
        ctx.attachExtraTrace(warning);
    } else {
        var parsed = parseStackAndMessage(warning);
        warning.stack = parsed.message + "\n" + parsed.stack.join("\n");
    }

    if (!activeFireEvent("warning", warning)) {
        formatAndLogError(warning, "", true);
    }
}

function reconstructStack(message, stacks) {
    for (var i = 0; i < stacks.length - 1; ++i) {
        stacks[i].push("From previous event:");
        stacks[i] = stacks[i].join("\n");
    }
    if (i < stacks.length) {
        stacks[i] = stacks[i].join("\n");
    }
    return message + "\n" + stacks.join("\n");
}

function removeDuplicateOrEmptyJumps(stacks) {
    for (var i = 0; i < stacks.length; ++i) {
        if (stacks[i].length === 0 ||
            ((i + 1 < stacks.length) && stacks[i][0] === stacks[i+1][0])) {
            stacks.splice(i, 1);
            i--;
        }
    }
}

function removeCommonRoots(stacks) {
    var current = stacks[0];
    for (var i = 1; i < stacks.length; ++i) {
        var prev = stacks[i];
        var currentLastIndex = current.length - 1;
        var currentLastLine = current[currentLastIndex];
        var commonRootMeetPoint = -1;

        for (var j = prev.length - 1; j >= 0; --j) {
            if (prev[j] === currentLastLine) {
                commonRootMeetPoint = j;
                break;
            }
        }

        for (var j = commonRootMeetPoint; j >= 0; --j) {
            var line = prev[j];
            if (current[currentLastIndex] === line) {
                current.pop();
                currentLastIndex--;
            } else {
                break;
            }
        }
        current = prev;
    }
}

function cleanStack(stack) {
    var ret = [];
    for (var i = 0; i < stack.length; ++i) {
        var line = stack[i];
        var isTraceLine = "    (No stack trace)" === line ||
            stackFramePattern.test(line);
        var isInternalFrame = isTraceLine && shouldIgnore(line);
        if (isTraceLine && !isInternalFrame) {
            if (indentStackFrames && line.charAt(0) !== " ") {
                line = "    " + line;
            }
            ret.push(line);
        }
    }
    return ret;
}

function stackFramesAsArray(error) {
    var stack = error.stack.replace(/\s+$/g, "").split("\n");
    for (var i = 0; i < stack.length; ++i) {
        var line = stack[i];
        if ("    (No stack trace)" === line || stackFramePattern.test(line)) {
            break;
        }
    }
    if (i > 0 && error.name != "SyntaxError") {
        stack = stack.slice(i);
    }
    return stack;
}

function parseStackAndMessage(error) {
    var stack = error.stack;
    var message = error.toString();
    stack = typeof stack === "string" && stack.length > 0
                ? stackFramesAsArray(error) : ["    (No stack trace)"];
    return {
        message: message,
        stack: error.name == "SyntaxError" ? stack : cleanStack(stack)
    };
}

function formatAndLogError(error, title, isSoft) {
    if (typeof console !== "undefined") {
        var message;
        if (util.isObject(error)) {
            var stack = error.stack;
            message = title + formatStack(stack, error);
        } else {
            message = title + String(error);
        }
        if (typeof printWarning === "function") {
            printWarning(message, isSoft);
        } else if (typeof console.log === "function" ||
            typeof console.log === "object") {
            console.log(message);
        }
    }
}

function fireRejectionEvent(name, localHandler, reason, promise) {
    var localEventFired = false;
    try {
        if (typeof localHandler === "function") {
            localEventFired = true;
            if (name === "rejectionHandled") {
                localHandler(promise);
            } else {
                localHandler(reason, promise);
            }
        }
    } catch (e) {
        async.throwLater(e);
    }

    if (name === "unhandledRejection") {
        if (!activeFireEvent(name, reason, promise) && !localEventFired) {
            formatAndLogError(reason, "Unhandled rejection ");
        }
    } else {
        activeFireEvent(name, promise);
    }
}

function formatNonError(obj) {
    var str;
    if (typeof obj === "function") {
        str = "[function " +
            (obj.name || "anonymous") +
            "]";
    } else {
        str = obj && typeof obj.toString === "function"
            ? obj.toString() : util.toString(obj);
        var ruselessToString = /\[object [a-zA-Z0-9$_]+\]/;
        if (ruselessToString.test(str)) {
            try {
                var newStr = JSON.stringify(obj);
                str = newStr;
            }
            catch(e) {

            }
        }
        if (str.length === 0) {
            str = "(empty array)";
        }
    }
    return ("(<" + snip(str) + ">, no stack trace)");
}

function snip(str) {
    var maxChars = 41;
    if (str.length < maxChars) {
        return str;
    }
    return str.substr(0, maxChars - 3) + "...";
}

function longStackTracesIsSupported() {
    return typeof captureStackTrace === "function";
}

var shouldIgnore = function() { return false; };
var parseLineInfoRegex = /[\/<\(]([^:\/]+):(\d+):(?:\d+)\)?\s*$/;
function parseLineInfo(line) {
    var matches = line.match(parseLineInfoRegex);
    if (matches) {
        return {
            fileName: matches[1],
            line: parseInt(matches[2], 10)
        };
    }
}

function setBounds(firstLineError, lastLineError) {
    if (!longStackTracesIsSupported()) return;
    var firstStackLines = (firstLineError.stack || "").split("\n");
    var lastStackLines = (lastLineError.stack || "").split("\n");
    var firstIndex = -1;
    var lastIndex = -1;
    var firstFileName;
    var lastFileName;
    for (var i = 0; i < firstStackLines.length; ++i) {
        var result = parseLineInfo(firstStackLines[i]);
        if (result) {
            firstFileName = result.fileName;
            firstIndex = result.line;
            break;
        }
    }
    for (var i = 0; i < lastStackLines.length; ++i) {
        var result = parseLineInfo(lastStackLines[i]);
        if (result) {
            lastFileName = result.fileName;
            lastIndex = result.line;
            break;
        }
    }
    if (firstIndex < 0 || lastIndex < 0 || !firstFileName || !lastFileName ||
        firstFileName !== lastFileName || firstIndex >= lastIndex) {
        return;
    }

    shouldIgnore = function(line) {
        if (bluebirdFramePattern.test(line)) return true;
        var info = parseLineInfo(line);
        if (info) {
            if (info.fileName === firstFileName &&
                (firstIndex <= info.line && info.line <= lastIndex)) {
                return true;
            }
        }
        return false;
    };
}

function CapturedTrace(parent) {
    this._parent = parent;
    this._promisesCreated = 0;
    var length = this._length = 1 + (parent === undefined ? 0 : parent._length);
    captureStackTrace(this, CapturedTrace);
    if (length > 32) this.uncycle();
}
util.inherits(CapturedTrace, Error);
Context.CapturedTrace = CapturedTrace;

CapturedTrace.prototype.uncycle = function() {
    var length = this._length;
    if (length < 2) return;
    var nodes = [];
    var stackToIndex = {};

    for (var i = 0, node = this; node !== undefined; ++i) {
        nodes.push(node);
        node = node._parent;
    }
    length = this._length = i;
    for (var i = length - 1; i >= 0; --i) {
        var stack = nodes[i].stack;
        if (stackToIndex[stack] === undefined) {
            stackToIndex[stack] = i;
        }
    }
    for (var i = 0; i < length; ++i) {
        var currentStack = nodes[i].stack;
        var index = stackToIndex[currentStack];
        if (index !== undefined && index !== i) {
            if (index > 0) {
                nodes[index - 1]._parent = undefined;
                nodes[index - 1]._length = 1;
            }
            nodes[i]._parent = undefined;
            nodes[i]._length = 1;
            var cycleEdgeNode = i > 0 ? nodes[i - 1] : this;

            if (index < length - 1) {
                cycleEdgeNode._parent = nodes[index + 1];
                cycleEdgeNode._parent.uncycle();
                cycleEdgeNode._length =
                    cycleEdgeNode._parent._length + 1;
            } else {
                cycleEdgeNode._parent = undefined;
                cycleEdgeNode._length = 1;
            }
            var currentChildLength = cycleEdgeNode._length + 1;
            for (var j = i - 2; j >= 0; --j) {
                nodes[j]._length = currentChildLength;
                currentChildLength++;
            }
            return;
        }
    }
};

CapturedTrace.prototype.attachExtraTrace = function(error) {
    if (error.__stackCleaned__) return;
    this.uncycle();
    var parsed = parseStackAndMessage(error);
    var message = parsed.message;
    var stacks = [parsed.stack];

    var trace = this;
    while (trace !== undefined) {
        stacks.push(cleanStack(trace.stack.split("\n")));
        trace = trace._parent;
    }
    removeCommonRoots(stacks);
    removeDuplicateOrEmptyJumps(stacks);
    util.notEnumerableProp(error, "stack", reconstructStack(message, stacks));
    util.notEnumerableProp(error, "__stackCleaned__", true);
};

var captureStackTrace = (function stackDetection() {
    var v8stackFramePattern = /^\s*at\s*/;
    var v8stackFormatter = function(stack, error) {
        if (typeof stack === "string") return stack;

        if (error.name !== undefined &&
            error.message !== undefined) {
            return error.toString();
        }
        return formatNonError(error);
    };

    if (typeof Error.stackTraceLimit === "number" &&
        typeof Error.captureStackTrace === "function") {
        Error.stackTraceLimit += 6;
        stackFramePattern = v8stackFramePattern;
        formatStack = v8stackFormatter;
        var captureStackTrace = Error.captureStackTrace;

        shouldIgnore = function(line) {
            return bluebirdFramePattern.test(line);
        };
        return function(receiver, ignoreUntil) {
            Error.stackTraceLimit += 6;
            captureStackTrace(receiver, ignoreUntil);
            Error.stackTraceLimit -= 6;
        };
    }
    var err = new Error();

    if (typeof err.stack === "string" &&
        err.stack.split("\n")[0].indexOf("stackDetection@") >= 0) {
        stackFramePattern = /@/;
        formatStack = v8stackFormatter;
        indentStackFrames = true;
        return function captureStackTrace(o) {
            o.stack = new Error().stack;
        };
    }

    var hasStackAfterThrow;
    try { throw new Error(); }
    catch(e) {
        hasStackAfterThrow = ("stack" in e);
    }
    if (!("stack" in err) && hasStackAfterThrow &&
        typeof Error.stackTraceLimit === "number") {
        stackFramePattern = v8stackFramePattern;
        formatStack = v8stackFormatter;
        return function captureStackTrace(o) {
            Error.stackTraceLimit += 6;
            try { throw new Error(); }
            catch(e) { o.stack = e.stack; }
            Error.stackTraceLimit -= 6;
        };
    }

    formatStack = function(stack, error) {
        if (typeof stack === "string") return stack;

        if ((typeof error === "object" ||
            typeof error === "function") &&
            error.name !== undefined &&
            error.message !== undefined) {
            return error.toString();
        }
        return formatNonError(error);
    };

    return null;

})([]);

if (typeof console !== "undefined" && typeof console.warn !== "undefined") {
    printWarning = function (message) {
        console.warn(message);
    };
    if (util.isNode && process.stderr.isTTY) {
        printWarning = function(message, isSoft) {
            var color = isSoft ? "\u001b[33m" : "\u001b[31m";
            console.warn(color + message + "\u001b[0m\n");
        };
    } else if (!util.isNode && typeof (new Error().stack) === "string") {
        printWarning = function(message, isSoft) {
            console.warn("%c" + message,
                        isSoft ? "color: darkorange" : "color: red");
        };
    }
}

var config = {
    warnings: warnings,
    longStackTraces: false,
    cancellation: false,
    monitoring: false,
    asyncHooks: false
};

if (longStackTraces) Promise.longStackTraces();

return {
    asyncHooks: function() {
        return config.asyncHooks;
    },
    longStackTraces: function() {
        return config.longStackTraces;
    },
    warnings: function() {
        return config.warnings;
    },
    cancellation: function() {
        return config.cancellation;
    },
    monitoring: function() {
        return config.monitoring;
    },
    propagateFromFunction: function() {
        return propagateFromFunction;
    },
    boundValueFunction: function() {
        return boundValueFunction;
    },
    checkForgottenReturns: checkForgottenReturns,
    setBounds: setBounds,
    warn: warn,
    deprecated: deprecated,
    CapturedTrace: CapturedTrace,
    fireDomEvent: fireDomEvent,
    fireGlobalEvent: fireGlobalEvent
};
};

},{"./errors":12,"./es5":13,"./util":36}],10:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise) {
function returner() {
    return this.value;
}
function thrower() {
    throw this.reason;
}

Promise.prototype["return"] =
Promise.prototype.thenReturn = function (value) {
    if (value instanceof Promise) value.suppressUnhandledRejections();
    return this._then(
        returner, undefined, undefined, {value: value}, undefined);
};

Promise.prototype["throw"] =
Promise.prototype.thenThrow = function (reason) {
    return this._then(
        thrower, undefined, undefined, {reason: reason}, undefined);
};

Promise.prototype.catchThrow = function (reason) {
    if (arguments.length <= 1) {
        return this._then(
            undefined, thrower, undefined, {reason: reason}, undefined);
    } else {
        var _reason = arguments[1];
        var handler = function() {throw _reason;};
        return this.caught(reason, handler);
    }
};

Promise.prototype.catchReturn = function (value) {
    if (arguments.length <= 1) {
        if (value instanceof Promise) value.suppressUnhandledRejections();
        return this._then(
            undefined, returner, undefined, {value: value}, undefined);
    } else {
        var _value = arguments[1];
        if (_value instanceof Promise) _value.suppressUnhandledRejections();
        var handler = function() {return _value;};
        return this.caught(value, handler);
    }
};
};

},{}],11:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, INTERNAL) {
var PromiseReduce = Promise.reduce;
var PromiseAll = Promise.all;

function promiseAllThis() {
    return PromiseAll(this);
}

function PromiseMapSeries(promises, fn) {
    return PromiseReduce(promises, fn, INTERNAL, INTERNAL);
}

Promise.prototype.each = function (fn) {
    return PromiseReduce(this, fn, INTERNAL, 0)
              ._then(promiseAllThis, undefined, undefined, this, undefined);
};

Promise.prototype.mapSeries = function (fn) {
    return PromiseReduce(this, fn, INTERNAL, INTERNAL);
};

Promise.each = function (promises, fn) {
    return PromiseReduce(promises, fn, INTERNAL, 0)
              ._then(promiseAllThis, undefined, undefined, promises, undefined);
};

Promise.mapSeries = PromiseMapSeries;
};


},{}],12:[function(_dereq_,module,exports){
"use strict";
var es5 = _dereq_("./es5");
var Objectfreeze = es5.freeze;
var util = _dereq_("./util");
var inherits = util.inherits;
var notEnumerableProp = util.notEnumerableProp;

function subError(nameProperty, defaultMessage) {
    function SubError(message) {
        if (!(this instanceof SubError)) return new SubError(message);
        notEnumerableProp(this, "message",
            typeof message === "string" ? message : defaultMessage);
        notEnumerableProp(this, "name", nameProperty);
        if (Error.captureStackTrace) {
            Error.captureStackTrace(this, this.constructor);
        } else {
            Error.call(this);
        }
    }
    inherits(SubError, Error);
    return SubError;
}

var _TypeError, _RangeError;
var Warning = subError("Warning", "warning");
var CancellationError = subError("CancellationError", "cancellation error");
var TimeoutError = subError("TimeoutError", "timeout error");
var AggregateError = subError("AggregateError", "aggregate error");
try {
    _TypeError = TypeError;
    _RangeError = RangeError;
} catch(e) {
    _TypeError = subError("TypeError", "type error");
    _RangeError = subError("RangeError", "range error");
}

var methods = ("join pop push shift unshift slice filter forEach some " +
    "every map indexOf lastIndexOf reduce reduceRight sort reverse").split(" ");

for (var i = 0; i < methods.length; ++i) {
    if (typeof Array.prototype[methods[i]] === "function") {
        AggregateError.prototype[methods[i]] = Array.prototype[methods[i]];
    }
}

es5.defineProperty(AggregateError.prototype, "length", {
    value: 0,
    configurable: false,
    writable: true,
    enumerable: true
});
AggregateError.prototype["isOperational"] = true;
var level = 0;
AggregateError.prototype.toString = function() {
    var indent = Array(level * 4 + 1).join(" ");
    var ret = "\n" + indent + "AggregateError of:" + "\n";
    level++;
    indent = Array(level * 4 + 1).join(" ");
    for (var i = 0; i < this.length; ++i) {
        var str = this[i] === this ? "[Circular AggregateError]" : this[i] + "";
        var lines = str.split("\n");
        for (var j = 0; j < lines.length; ++j) {
            lines[j] = indent + lines[j];
        }
        str = lines.join("\n");
        ret += str + "\n";
    }
    level--;
    return ret;
};

function OperationalError(message) {
    if (!(this instanceof OperationalError))
        return new OperationalError(message);
    notEnumerableProp(this, "name", "OperationalError");
    notEnumerableProp(this, "message", message);
    this.cause = message;
    this["isOperational"] = true;

    if (message instanceof Error) {
        notEnumerableProp(this, "message", message.message);
        notEnumerableProp(this, "stack", message.stack);
    } else if (Error.captureStackTrace) {
        Error.captureStackTrace(this, this.constructor);
    }

}
inherits(OperationalError, Error);

var errorTypes = Error["__BluebirdErrorTypes__"];
if (!errorTypes) {
    errorTypes = Objectfreeze({
        CancellationError: CancellationError,
        TimeoutError: TimeoutError,
        OperationalError: OperationalError,
        RejectionError: OperationalError,
        AggregateError: AggregateError
    });
    es5.defineProperty(Error, "__BluebirdErrorTypes__", {
        value: errorTypes,
        writable: false,
        enumerable: false,
        configurable: false
    });
}

module.exports = {
    Error: Error,
    TypeError: _TypeError,
    RangeError: _RangeError,
    CancellationError: errorTypes.CancellationError,
    OperationalError: errorTypes.OperationalError,
    TimeoutError: errorTypes.TimeoutError,
    AggregateError: errorTypes.AggregateError,
    Warning: Warning
};

},{"./es5":13,"./util":36}],13:[function(_dereq_,module,exports){
var isES5 = (function(){
    "use strict";
    return this === undefined;
})();

if (isES5) {
    module.exports = {
        freeze: Object.freeze,
        defineProperty: Object.defineProperty,
        getDescriptor: Object.getOwnPropertyDescriptor,
        keys: Object.keys,
        names: Object.getOwnPropertyNames,
        getPrototypeOf: Object.getPrototypeOf,
        isArray: Array.isArray,
        isES5: isES5,
        propertyIsWritable: function(obj, prop) {
            var descriptor = Object.getOwnPropertyDescriptor(obj, prop);
            return !!(!descriptor || descriptor.writable || descriptor.set);
        }
    };
} else {
    var has = {}.hasOwnProperty;
    var str = {}.toString;
    var proto = {}.constructor.prototype;

    var ObjectKeys = function (o) {
        var ret = [];
        for (var key in o) {
            if (has.call(o, key)) {
                ret.push(key);
            }
        }
        return ret;
    };

    var ObjectGetDescriptor = function(o, key) {
        return {value: o[key]};
    };

    var ObjectDefineProperty = function (o, key, desc) {
        o[key] = desc.value;
        return o;
    };

    var ObjectFreeze = function (obj) {
        return obj;
    };

    var ObjectGetPrototypeOf = function (obj) {
        try {
            return Object(obj).constructor.prototype;
        }
        catch (e) {
            return proto;
        }
    };

    var ArrayIsArray = function (obj) {
        try {
            return str.call(obj) === "[object Array]";
        }
        catch(e) {
            return false;
        }
    };

    module.exports = {
        isArray: ArrayIsArray,
        keys: ObjectKeys,
        names: ObjectKeys,
        defineProperty: ObjectDefineProperty,
        getDescriptor: ObjectGetDescriptor,
        freeze: ObjectFreeze,
        getPrototypeOf: ObjectGetPrototypeOf,
        isES5: isES5,
        propertyIsWritable: function() {
            return true;
        }
    };
}

},{}],14:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, INTERNAL) {
var PromiseMap = Promise.map;

Promise.prototype.filter = function (fn, options) {
    return PromiseMap(this, fn, options, INTERNAL);
};

Promise.filter = function (promises, fn, options) {
    return PromiseMap(promises, fn, options, INTERNAL);
};
};

},{}],15:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, tryConvertToPromise, NEXT_FILTER) {
var util = _dereq_("./util");
var CancellationError = Promise.CancellationError;
var errorObj = util.errorObj;
var catchFilter = _dereq_("./catch_filter")(NEXT_FILTER);

function PassThroughHandlerContext(promise, type, handler) {
    this.promise = promise;
    this.type = type;
    this.handler = handler;
    this.called = false;
    this.cancelPromise = null;
}

PassThroughHandlerContext.prototype.isFinallyHandler = function() {
    return this.type === 0;
};

function FinallyHandlerCancelReaction(finallyHandler) {
    this.finallyHandler = finallyHandler;
}

FinallyHandlerCancelReaction.prototype._resultCancelled = function() {
    checkCancel(this.finallyHandler);
};

function checkCancel(ctx, reason) {
    if (ctx.cancelPromise != null) {
        if (arguments.length > 1) {
            ctx.cancelPromise._reject(reason);
        } else {
            ctx.cancelPromise._cancel();
        }
        ctx.cancelPromise = null;
        return true;
    }
    return false;
}

function succeed() {
    return finallyHandler.call(this, this.promise._target()._settledValue());
}
function fail(reason) {
    if (checkCancel(this, reason)) return;
    errorObj.e = reason;
    return errorObj;
}
function finallyHandler(reasonOrValue) {
    var promise = this.promise;
    var handler = this.handler;

    if (!this.called) {
        this.called = true;
        var ret = this.isFinallyHandler()
            ? handler.call(promise._boundValue())
            : handler.call(promise._boundValue(), reasonOrValue);
        if (ret === NEXT_FILTER) {
            return ret;
        } else if (ret !== undefined) {
            promise._setReturnedNonUndefined();
            var maybePromise = tryConvertToPromise(ret, promise);
            if (maybePromise instanceof Promise) {
                if (this.cancelPromise != null) {
                    if (maybePromise._isCancelled()) {
                        var reason =
                            new CancellationError("late cancellation observer");
                        promise._attachExtraTrace(reason);
                        errorObj.e = reason;
                        return errorObj;
                    } else if (maybePromise.isPending()) {
                        maybePromise._attachCancellationCallback(
                            new FinallyHandlerCancelReaction(this));
                    }
                }
                return maybePromise._then(
                    succeed, fail, undefined, this, undefined);
            }
        }
    }

    if (promise.isRejected()) {
        checkCancel(this);
        errorObj.e = reasonOrValue;
        return errorObj;
    } else {
        checkCancel(this);
        return reasonOrValue;
    }
}

Promise.prototype._passThrough = function(handler, type, success, fail) {
    if (typeof handler !== "function") return this.then();
    return this._then(success,
                      fail,
                      undefined,
                      new PassThroughHandlerContext(this, type, handler),
                      undefined);
};

Promise.prototype.lastly =
Promise.prototype["finally"] = function (handler) {
    return this._passThrough(handler,
                             0,
                             finallyHandler,
                             finallyHandler);
};


Promise.prototype.tap = function (handler) {
    return this._passThrough(handler, 1, finallyHandler);
};

Promise.prototype.tapCatch = function (handlerOrPredicate) {
    var len = arguments.length;
    if(len === 1) {
        return this._passThrough(handlerOrPredicate,
                                 1,
                                 undefined,
                                 finallyHandler);
    } else {
         var catchInstances = new Array(len - 1),
            j = 0, i;
        for (i = 0; i < len - 1; ++i) {
            var item = arguments[i];
            if (util.isObject(item)) {
                catchInstances[j++] = item;
            } else {
                return Promise.reject(new TypeError(
                    "tapCatch statement predicate: "
                    + "expecting an object but got " + util.classString(item)
                ));
            }
        }
        catchInstances.length = j;
        var handler = arguments[i];
        return this._passThrough(catchFilter(catchInstances, handler, this),
                                 1,
                                 undefined,
                                 finallyHandler);
    }

};

return PassThroughHandlerContext;
};

},{"./catch_filter":7,"./util":36}],16:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise,
                          apiRejection,
                          INTERNAL,
                          tryConvertToPromise,
                          Proxyable,
                          debug) {
var errors = _dereq_("./errors");
var TypeError = errors.TypeError;
var util = _dereq_("./util");
var errorObj = util.errorObj;
var tryCatch = util.tryCatch;
var yieldHandlers = [];

function promiseFromYieldHandler(value, yieldHandlers, traceParent) {
    for (var i = 0; i < yieldHandlers.length; ++i) {
        traceParent._pushContext();
        var result = tryCatch(yieldHandlers[i])(value);
        traceParent._popContext();
        if (result === errorObj) {
            traceParent._pushContext();
            var ret = Promise.reject(errorObj.e);
            traceParent._popContext();
            return ret;
        }
        var maybePromise = tryConvertToPromise(result, traceParent);
        if (maybePromise instanceof Promise) return maybePromise;
    }
    return null;
}

function PromiseSpawn(generatorFunction, receiver, yieldHandler, stack) {
    if (debug.cancellation()) {
        var internal = new Promise(INTERNAL);
        var _finallyPromise = this._finallyPromise = new Promise(INTERNAL);
        this._promise = internal.lastly(function() {
            return _finallyPromise;
        });
        internal._captureStackTrace();
        internal._setOnCancel(this);
    } else {
        var promise = this._promise = new Promise(INTERNAL);
        promise._captureStackTrace();
    }
    this._stack = stack;
    this._generatorFunction = generatorFunction;
    this._receiver = receiver;
    this._generator = undefined;
    this._yieldHandlers = typeof yieldHandler === "function"
        ? [yieldHandler].concat(yieldHandlers)
        : yieldHandlers;
    this._yieldedPromise = null;
    this._cancellationPhase = false;
}
util.inherits(PromiseSpawn, Proxyable);

PromiseSpawn.prototype._isResolved = function() {
    return this._promise === null;
};

PromiseSpawn.prototype._cleanup = function() {
    this._promise = this._generator = null;
    if (debug.cancellation() && this._finallyPromise !== null) {
        this._finallyPromise._fulfill();
        this._finallyPromise = null;
    }
};

PromiseSpawn.prototype._promiseCancelled = function() {
    if (this._isResolved()) return;
    var implementsReturn = typeof this._generator["return"] !== "undefined";

    var result;
    if (!implementsReturn) {
        var reason = new Promise.CancellationError(
            "generator .return() sentinel");
        Promise.coroutine.returnSentinel = reason;
        this._promise._attachExtraTrace(reason);
        this._promise._pushContext();
        result = tryCatch(this._generator["throw"]).call(this._generator,
                                                         reason);
        this._promise._popContext();
    } else {
        this._promise._pushContext();
        result = tryCatch(this._generator["return"]).call(this._generator,
                                                          undefined);
        this._promise._popContext();
    }
    this._cancellationPhase = true;
    this._yieldedPromise = null;
    this._continue(result);
};

PromiseSpawn.prototype._promiseFulfilled = function(value) {
    this._yieldedPromise = null;
    this._promise._pushContext();
    var result = tryCatch(this._generator.next).call(this._generator, value);
    this._promise._popContext();
    this._continue(result);
};

PromiseSpawn.prototype._promiseRejected = function(reason) {
    this._yieldedPromise = null;
    this._promise._attachExtraTrace(reason);
    this._promise._pushContext();
    var result = tryCatch(this._generator["throw"])
        .call(this._generator, reason);
    this._promise._popContext();
    this._continue(result);
};

PromiseSpawn.prototype._resultCancelled = function() {
    if (this._yieldedPromise instanceof Promise) {
        var promise = this._yieldedPromise;
        this._yieldedPromise = null;
        promise.cancel();
    }
};

PromiseSpawn.prototype.promise = function () {
    return this._promise;
};

PromiseSpawn.prototype._run = function () {
    this._generator = this._generatorFunction.call(this._receiver);
    this._receiver =
        this._generatorFunction = undefined;
    this._promiseFulfilled(undefined);
};

PromiseSpawn.prototype._continue = function (result) {
    var promise = this._promise;
    if (result === errorObj) {
        this._cleanup();
        if (this._cancellationPhase) {
            return promise.cancel();
        } else {
            return promise._rejectCallback(result.e, false);
        }
    }

    var value = result.value;
    if (result.done === true) {
        this._cleanup();
        if (this._cancellationPhase) {
            return promise.cancel();
        } else {
            return promise._resolveCallback(value);
        }
    } else {
        var maybePromise = tryConvertToPromise(value, this._promise);
        if (!(maybePromise instanceof Promise)) {
            maybePromise =
                promiseFromYieldHandler(maybePromise,
                                        this._yieldHandlers,
                                        this._promise);
            if (maybePromise === null) {
                this._promiseRejected(
                    new TypeError(
                        "A value %s was yielded that could not be treated as a promise\u000a\u000a    See http://goo.gl/MqrFmX\u000a\u000a".replace("%s", String(value)) +
                        "From coroutine:\u000a" +
                        this._stack.split("\n").slice(1, -7).join("\n")
                    )
                );
                return;
            }
        }
        maybePromise = maybePromise._target();
        var bitField = maybePromise._bitField;
        ;
        if (((bitField & 50397184) === 0)) {
            this._yieldedPromise = maybePromise;
            maybePromise._proxy(this, null);
        } else if (((bitField & 33554432) !== 0)) {
            Promise._async.invoke(
                this._promiseFulfilled, this, maybePromise._value()
            );
        } else if (((bitField & 16777216) !== 0)) {
            Promise._async.invoke(
                this._promiseRejected, this, maybePromise._reason()
            );
        } else {
            this._promiseCancelled();
        }
    }
};

Promise.coroutine = function (generatorFunction, options) {
    if (typeof generatorFunction !== "function") {
        throw new TypeError("generatorFunction must be a function\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
    var yieldHandler = Object(options).yieldHandler;
    var PromiseSpawn$ = PromiseSpawn;
    var stack = new Error().stack;
    return function () {
        var generator = generatorFunction.apply(this, arguments);
        var spawn = new PromiseSpawn$(undefined, undefined, yieldHandler,
                                      stack);
        var ret = spawn.promise();
        spawn._generator = generator;
        spawn._promiseFulfilled(undefined);
        return ret;
    };
};

Promise.coroutine.addYieldHandler = function(fn) {
    if (typeof fn !== "function") {
        throw new TypeError("expecting a function but got " + util.classString(fn));
    }
    yieldHandlers.push(fn);
};

Promise.spawn = function (generatorFunction) {
    debug.deprecated("Promise.spawn()", "Promise.coroutine()");
    if (typeof generatorFunction !== "function") {
        return apiRejection("generatorFunction must be a function\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
    var spawn = new PromiseSpawn(generatorFunction, this);
    var ret = spawn.promise();
    spawn._run(Promise.spawn);
    return ret;
};
};

},{"./errors":12,"./util":36}],17:[function(_dereq_,module,exports){
"use strict";
module.exports =
function(Promise, PromiseArray, tryConvertToPromise, INTERNAL, async) {
var util = _dereq_("./util");
var canEvaluate = util.canEvaluate;
var tryCatch = util.tryCatch;
var errorObj = util.errorObj;
var reject;

if (false) { var i, promiseSetters, thenCallbacks, holderClasses, generateHolderClass, promiseSetter, thenCallback; }

Promise.join = function () {
    var last = arguments.length - 1;
    var fn;
    if (last > 0 && typeof arguments[last] === "function") {
        fn = arguments[last];
        if (false) { var context, bitField, maybePromise, i, callbacks, holder, HolderClass, ret; }
    }
    var args = [].slice.call(arguments);;
    if (fn) args.pop();
    var ret = new PromiseArray(args).promise();
    return fn !== undefined ? ret.spread(fn) : ret;
};

};

},{"./util":36}],18:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise,
                          PromiseArray,
                          apiRejection,
                          tryConvertToPromise,
                          INTERNAL,
                          debug) {
var util = _dereq_("./util");
var tryCatch = util.tryCatch;
var errorObj = util.errorObj;
var async = Promise._async;

function MappingPromiseArray(promises, fn, limit, _filter) {
    this.constructor$(promises);
    this._promise._captureStackTrace();
    var context = Promise._getContext();
    this._callback = util.contextBind(context, fn);
    this._preservedValues = _filter === INTERNAL
        ? new Array(this.length())
        : null;
    this._limit = limit;
    this._inFlight = 0;
    this._queue = [];
    async.invoke(this._asyncInit, this, undefined);
    if (util.isArray(promises)) {
        for (var i = 0; i < promises.length; ++i) {
            var maybePromise = promises[i];
            if (maybePromise instanceof Promise) {
                maybePromise.suppressUnhandledRejections();
            }
        }
    }
}
util.inherits(MappingPromiseArray, PromiseArray);

MappingPromiseArray.prototype._asyncInit = function() {
    this._init$(undefined, -2);
};

MappingPromiseArray.prototype._init = function () {};

MappingPromiseArray.prototype._promiseFulfilled = function (value, index) {
    var values = this._values;
    var length = this.length();
    var preservedValues = this._preservedValues;
    var limit = this._limit;

    if (index < 0) {
        index = (index * -1) - 1;
        values[index] = value;
        if (limit >= 1) {
            this._inFlight--;
            this._drainQueue();
            if (this._isResolved()) return true;
        }
    } else {
        if (limit >= 1 && this._inFlight >= limit) {
            values[index] = value;
            this._queue.push(index);
            return false;
        }
        if (preservedValues !== null) preservedValues[index] = value;

        var promise = this._promise;
        var callback = this._callback;
        var receiver = promise._boundValue();
        promise._pushContext();
        var ret = tryCatch(callback).call(receiver, value, index, length);
        var promiseCreated = promise._popContext();
        debug.checkForgottenReturns(
            ret,
            promiseCreated,
            preservedValues !== null ? "Promise.filter" : "Promise.map",
            promise
        );
        if (ret === errorObj) {
            this._reject(ret.e);
            return true;
        }

        var maybePromise = tryConvertToPromise(ret, this._promise);
        if (maybePromise instanceof Promise) {
            maybePromise = maybePromise._target();
            var bitField = maybePromise._bitField;
            ;
            if (((bitField & 50397184) === 0)) {
                if (limit >= 1) this._inFlight++;
                values[index] = maybePromise;
                maybePromise._proxy(this, (index + 1) * -1);
                return false;
            } else if (((bitField & 33554432) !== 0)) {
                ret = maybePromise._value();
            } else if (((bitField & 16777216) !== 0)) {
                this._reject(maybePromise._reason());
                return true;
            } else {
                this._cancel();
                return true;
            }
        }
        values[index] = ret;
    }
    var totalResolved = ++this._totalResolved;
    if (totalResolved >= length) {
        if (preservedValues !== null) {
            this._filter(values, preservedValues);
        } else {
            this._resolve(values);
        }
        return true;
    }
    return false;
};

MappingPromiseArray.prototype._drainQueue = function () {
    var queue = this._queue;
    var limit = this._limit;
    var values = this._values;
    while (queue.length > 0 && this._inFlight < limit) {
        if (this._isResolved()) return;
        var index = queue.pop();
        this._promiseFulfilled(values[index], index);
    }
};

MappingPromiseArray.prototype._filter = function (booleans, values) {
    var len = values.length;
    var ret = new Array(len);
    var j = 0;
    for (var i = 0; i < len; ++i) {
        if (booleans[i]) ret[j++] = values[i];
    }
    ret.length = j;
    this._resolve(ret);
};

MappingPromiseArray.prototype.preservedValues = function () {
    return this._preservedValues;
};

function map(promises, fn, options, _filter) {
    if (typeof fn !== "function") {
        return apiRejection("expecting a function but got " + util.classString(fn));
    }

    var limit = 0;
    if (options !== undefined) {
        if (typeof options === "object" && options !== null) {
            if (typeof options.concurrency !== "number") {
                return Promise.reject(
                    new TypeError("'concurrency' must be a number but it is " +
                                    util.classString(options.concurrency)));
            }
            limit = options.concurrency;
        } else {
            return Promise.reject(new TypeError(
                            "options argument must be an object but it is " +
                             util.classString(options)));
        }
    }
    limit = typeof limit === "number" &&
        isFinite(limit) && limit >= 1 ? limit : 0;
    return new MappingPromiseArray(promises, fn, limit, _filter).promise();
}

Promise.prototype.map = function (fn, options) {
    return map(this, fn, options, null);
};

Promise.map = function (promises, fn, options, _filter) {
    return map(promises, fn, options, _filter);
};


};

},{"./util":36}],19:[function(_dereq_,module,exports){
"use strict";
module.exports =
function(Promise, INTERNAL, tryConvertToPromise, apiRejection, debug) {
var util = _dereq_("./util");
var tryCatch = util.tryCatch;

Promise.method = function (fn) {
    if (typeof fn !== "function") {
        throw new Promise.TypeError("expecting a function but got " + util.classString(fn));
    }
    return function () {
        var ret = new Promise(INTERNAL);
        ret._captureStackTrace();
        ret._pushContext();
        var value = tryCatch(fn).apply(this, arguments);
        var promiseCreated = ret._popContext();
        debug.checkForgottenReturns(
            value, promiseCreated, "Promise.method", ret);
        ret._resolveFromSyncValue(value);
        return ret;
    };
};

Promise.attempt = Promise["try"] = function (fn) {
    if (typeof fn !== "function") {
        return apiRejection("expecting a function but got " + util.classString(fn));
    }
    var ret = new Promise(INTERNAL);
    ret._captureStackTrace();
    ret._pushContext();
    var value;
    if (arguments.length > 1) {
        debug.deprecated("calling Promise.try with more than 1 argument");
        var arg = arguments[1];
        var ctx = arguments[2];
        value = util.isArray(arg) ? tryCatch(fn).apply(ctx, arg)
                                  : tryCatch(fn).call(ctx, arg);
    } else {
        value = tryCatch(fn)();
    }
    var promiseCreated = ret._popContext();
    debug.checkForgottenReturns(
        value, promiseCreated, "Promise.try", ret);
    ret._resolveFromSyncValue(value);
    return ret;
};

Promise.prototype._resolveFromSyncValue = function (value) {
    if (value === util.errorObj) {
        this._rejectCallback(value.e, false);
    } else {
        this._resolveCallback(value, true);
    }
};
};

},{"./util":36}],20:[function(_dereq_,module,exports){
"use strict";
var util = _dereq_("./util");
var maybeWrapAsError = util.maybeWrapAsError;
var errors = _dereq_("./errors");
var OperationalError = errors.OperationalError;
var es5 = _dereq_("./es5");

function isUntypedError(obj) {
    return obj instanceof Error &&
        es5.getPrototypeOf(obj) === Error.prototype;
}

var rErrorKey = /^(?:name|message|stack|cause)$/;
function wrapAsOperationalError(obj) {
    var ret;
    if (isUntypedError(obj)) {
        ret = new OperationalError(obj);
        ret.name = obj.name;
        ret.message = obj.message;
        ret.stack = obj.stack;
        var keys = es5.keys(obj);
        for (var i = 0; i < keys.length; ++i) {
            var key = keys[i];
            if (!rErrorKey.test(key)) {
                ret[key] = obj[key];
            }
        }
        return ret;
    }
    util.markAsOriginatingFromRejection(obj);
    return obj;
}

function nodebackForPromise(promise, multiArgs) {
    return function(err, value) {
        if (promise === null) return;
        if (err) {
            var wrapped = wrapAsOperationalError(maybeWrapAsError(err));
            promise._attachExtraTrace(wrapped);
            promise._reject(wrapped);
        } else if (!multiArgs) {
            promise._fulfill(value);
        } else {
            var args = [].slice.call(arguments, 1);;
            promise._fulfill(args);
        }
        promise = null;
    };
}

module.exports = nodebackForPromise;

},{"./errors":12,"./es5":13,"./util":36}],21:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise) {
var util = _dereq_("./util");
var async = Promise._async;
var tryCatch = util.tryCatch;
var errorObj = util.errorObj;

function spreadAdapter(val, nodeback) {
    var promise = this;
    if (!util.isArray(val)) return successAdapter.call(promise, val, nodeback);
    var ret =
        tryCatch(nodeback).apply(promise._boundValue(), [null].concat(val));
    if (ret === errorObj) {
        async.throwLater(ret.e);
    }
}

function successAdapter(val, nodeback) {
    var promise = this;
    var receiver = promise._boundValue();
    var ret = val === undefined
        ? tryCatch(nodeback).call(receiver, null)
        : tryCatch(nodeback).call(receiver, null, val);
    if (ret === errorObj) {
        async.throwLater(ret.e);
    }
}
function errorAdapter(reason, nodeback) {
    var promise = this;
    if (!reason) {
        var newReason = new Error(reason + "");
        newReason.cause = reason;
        reason = newReason;
    }
    var ret = tryCatch(nodeback).call(promise._boundValue(), reason);
    if (ret === errorObj) {
        async.throwLater(ret.e);
    }
}

Promise.prototype.asCallback = Promise.prototype.nodeify = function (nodeback,
                                                                     options) {
    if (typeof nodeback == "function") {
        var adapter = successAdapter;
        if (options !== undefined && Object(options).spread) {
            adapter = spreadAdapter;
        }
        this._then(
            adapter,
            errorAdapter,
            undefined,
            this,
            nodeback
        );
    }
    return this;
};
};

},{"./util":36}],22:[function(_dereq_,module,exports){
"use strict";
module.exports = function() {
var makeSelfResolutionError = function () {
    return new TypeError("circular promise resolution chain\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
};
var reflectHandler = function() {
    return new Promise.PromiseInspection(this._target());
};
var apiRejection = function(msg) {
    return Promise.reject(new TypeError(msg));
};
function Proxyable() {}
var UNDEFINED_BINDING = {};
var util = _dereq_("./util");
util.setReflectHandler(reflectHandler);

var getDomain = function() {
    var domain = process.domain;
    if (domain === undefined) {
        return null;
    }
    return domain;
};
var getContextDefault = function() {
    return null;
};
var getContextDomain = function() {
    return {
        domain: getDomain(),
        async: null
    };
};
var AsyncResource = util.isNode && util.nodeSupportsAsyncResource ?
    _dereq_("async_hooks").AsyncResource : null;
var getContextAsyncHooks = function() {
    return {
        domain: getDomain(),
        async: new AsyncResource("Bluebird::Promise")
    };
};
var getContext = util.isNode ? getContextDomain : getContextDefault;
util.notEnumerableProp(Promise, "_getContext", getContext);
var enableAsyncHooks = function() {
    getContext = getContextAsyncHooks;
    util.notEnumerableProp(Promise, "_getContext", getContextAsyncHooks);
};
var disableAsyncHooks = function() {
    getContext = getContextDomain;
    util.notEnumerableProp(Promise, "_getContext", getContextDomain);
};

var es5 = _dereq_("./es5");
var Async = _dereq_("./async");
var async = new Async();
es5.defineProperty(Promise, "_async", {value: async});
var errors = _dereq_("./errors");
var TypeError = Promise.TypeError = errors.TypeError;
Promise.RangeError = errors.RangeError;
var CancellationError = Promise.CancellationError = errors.CancellationError;
Promise.TimeoutError = errors.TimeoutError;
Promise.OperationalError = errors.OperationalError;
Promise.RejectionError = errors.OperationalError;
Promise.AggregateError = errors.AggregateError;
var INTERNAL = function(){};
var APPLY = {};
var NEXT_FILTER = {};
var tryConvertToPromise = _dereq_("./thenables")(Promise, INTERNAL);
var PromiseArray =
    _dereq_("./promise_array")(Promise, INTERNAL,
                               tryConvertToPromise, apiRejection, Proxyable);
var Context = _dereq_("./context")(Promise);
 /*jshint unused:false*/
var createContext = Context.create;

var debug = _dereq_("./debuggability")(Promise, Context,
    enableAsyncHooks, disableAsyncHooks);
var CapturedTrace = debug.CapturedTrace;
var PassThroughHandlerContext =
    _dereq_("./finally")(Promise, tryConvertToPromise, NEXT_FILTER);
var catchFilter = _dereq_("./catch_filter")(NEXT_FILTER);
var nodebackForPromise = _dereq_("./nodeback");
var errorObj = util.errorObj;
var tryCatch = util.tryCatch;
function check(self, executor) {
    if (self == null || self.constructor !== Promise) {
        throw new TypeError("the promise constructor cannot be invoked directly\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
    if (typeof executor !== "function") {
        throw new TypeError("expecting a function but got " + util.classString(executor));
    }

}

function Promise(executor) {
    if (executor !== INTERNAL) {
        check(this, executor);
    }
    this._bitField = 0;
    this._fulfillmentHandler0 = undefined;
    this._rejectionHandler0 = undefined;
    this._promise0 = undefined;
    this._receiver0 = undefined;
    this._resolveFromExecutor(executor);
    this._promiseCreated();
    this._fireEvent("promiseCreated", this);
}

Promise.prototype.toString = function () {
    return "[object Promise]";
};

Promise.prototype.caught = Promise.prototype["catch"] = function (fn) {
    var len = arguments.length;
    if (len > 1) {
        var catchInstances = new Array(len - 1),
            j = 0, i;
        for (i = 0; i < len - 1; ++i) {
            var item = arguments[i];
            if (util.isObject(item)) {
                catchInstances[j++] = item;
            } else {
                return apiRejection("Catch statement predicate: " +
                    "expecting an object but got " + util.classString(item));
            }
        }
        catchInstances.length = j;
        fn = arguments[i];

        if (typeof fn !== "function") {
            throw new TypeError("The last argument to .catch() " +
                "must be a function, got " + util.toString(fn));
        }
        return this.then(undefined, catchFilter(catchInstances, fn, this));
    }
    return this.then(undefined, fn);
};

Promise.prototype.reflect = function () {
    return this._then(reflectHandler,
        reflectHandler, undefined, this, undefined);
};

Promise.prototype.then = function (didFulfill, didReject) {
    if (debug.warnings() && arguments.length > 0 &&
        typeof didFulfill !== "function" &&
        typeof didReject !== "function") {
        var msg = ".then() only accepts functions but was passed: " +
                util.classString(didFulfill);
        if (arguments.length > 1) {
            msg += ", " + util.classString(didReject);
        }
        this._warn(msg);
    }
    return this._then(didFulfill, didReject, undefined, undefined, undefined);
};

Promise.prototype.done = function (didFulfill, didReject) {
    var promise =
        this._then(didFulfill, didReject, undefined, undefined, undefined);
    promise._setIsFinal();
};

Promise.prototype.spread = function (fn) {
    if (typeof fn !== "function") {
        return apiRejection("expecting a function but got " + util.classString(fn));
    }
    return this.all()._then(fn, undefined, undefined, APPLY, undefined);
};

Promise.prototype.toJSON = function () {
    var ret = {
        isFulfilled: false,
        isRejected: false,
        fulfillmentValue: undefined,
        rejectionReason: undefined
    };
    if (this.isFulfilled()) {
        ret.fulfillmentValue = this.value();
        ret.isFulfilled = true;
    } else if (this.isRejected()) {
        ret.rejectionReason = this.reason();
        ret.isRejected = true;
    }
    return ret;
};

Promise.prototype.all = function () {
    if (arguments.length > 0) {
        this._warn(".all() was passed arguments but it does not take any");
    }
    return new PromiseArray(this).promise();
};

Promise.prototype.error = function (fn) {
    return this.caught(util.originatesFromRejection, fn);
};

Promise.getNewLibraryCopy = module.exports;

Promise.is = function (val) {
    return val instanceof Promise;
};

Promise.fromNode = Promise.fromCallback = function(fn) {
    var ret = new Promise(INTERNAL);
    ret._captureStackTrace();
    var multiArgs = arguments.length > 1 ? !!Object(arguments[1]).multiArgs
                                         : false;
    var result = tryCatch(fn)(nodebackForPromise(ret, multiArgs));
    if (result === errorObj) {
        ret._rejectCallback(result.e, true);
    }
    if (!ret._isFateSealed()) ret._setAsyncGuaranteed();
    return ret;
};

Promise.all = function (promises) {
    return new PromiseArray(promises).promise();
};

Promise.cast = function (obj) {
    var ret = tryConvertToPromise(obj);
    if (!(ret instanceof Promise)) {
        ret = new Promise(INTERNAL);
        ret._captureStackTrace();
        ret._setFulfilled();
        ret._rejectionHandler0 = obj;
    }
    return ret;
};

Promise.resolve = Promise.fulfilled = Promise.cast;

Promise.reject = Promise.rejected = function (reason) {
    var ret = new Promise(INTERNAL);
    ret._captureStackTrace();
    ret._rejectCallback(reason, true);
    return ret;
};

Promise.setScheduler = function(fn) {
    if (typeof fn !== "function") {
        throw new TypeError("expecting a function but got " + util.classString(fn));
    }
    return async.setScheduler(fn);
};

Promise.prototype._then = function (
    didFulfill,
    didReject,
    _,    receiver,
    internalData
) {
    var haveInternalData = internalData !== undefined;
    var promise = haveInternalData ? internalData : new Promise(INTERNAL);
    var target = this._target();
    var bitField = target._bitField;

    if (!haveInternalData) {
        promise._propagateFrom(this, 3);
        promise._captureStackTrace();
        if (receiver === undefined &&
            ((this._bitField & 2097152) !== 0)) {
            if (!((bitField & 50397184) === 0)) {
                receiver = this._boundValue();
            } else {
                receiver = target === this ? undefined : this._boundTo;
            }
        }
        this._fireEvent("promiseChained", this, promise);
    }

    var context = getContext();
    if (!((bitField & 50397184) === 0)) {
        var handler, value, settler = target._settlePromiseCtx;
        if (((bitField & 33554432) !== 0)) {
            value = target._rejectionHandler0;
            handler = didFulfill;
        } else if (((bitField & 16777216) !== 0)) {
            value = target._fulfillmentHandler0;
            handler = didReject;
            target._unsetRejectionIsUnhandled();
        } else {
            settler = target._settlePromiseLateCancellationObserver;
            value = new CancellationError("late cancellation observer");
            target._attachExtraTrace(value);
            handler = didReject;
        }

        async.invoke(settler, target, {
            handler: util.contextBind(context, handler),
            promise: promise,
            receiver: receiver,
            value: value
        });
    } else {
        target._addCallbacks(didFulfill, didReject, promise,
                receiver, context);
    }

    return promise;
};

Promise.prototype._length = function () {
    return this._bitField & 65535;
};

Promise.prototype._isFateSealed = function () {
    return (this._bitField & 117506048) !== 0;
};

Promise.prototype._isFollowing = function () {
    return (this._bitField & 67108864) === 67108864;
};

Promise.prototype._setLength = function (len) {
    this._bitField = (this._bitField & -65536) |
        (len & 65535);
};

Promise.prototype._setFulfilled = function () {
    this._bitField = this._bitField | 33554432;
    this._fireEvent("promiseFulfilled", this);
};

Promise.prototype._setRejected = function () {
    this._bitField = this._bitField | 16777216;
    this._fireEvent("promiseRejected", this);
};

Promise.prototype._setFollowing = function () {
    this._bitField = this._bitField | 67108864;
    this._fireEvent("promiseResolved", this);
};

Promise.prototype._setIsFinal = function () {
    this._bitField = this._bitField | 4194304;
};

Promise.prototype._isFinal = function () {
    return (this._bitField & 4194304) > 0;
};

Promise.prototype._unsetCancelled = function() {
    this._bitField = this._bitField & (~65536);
};

Promise.prototype._setCancelled = function() {
    this._bitField = this._bitField | 65536;
    this._fireEvent("promiseCancelled", this);
};

Promise.prototype._setWillBeCancelled = function() {
    this._bitField = this._bitField | 8388608;
};

Promise.prototype._setAsyncGuaranteed = function() {
    if (async.hasCustomScheduler()) return;
    var bitField = this._bitField;
    this._bitField = bitField |
        (((bitField & 536870912) >> 2) ^
        134217728);
};

Promise.prototype._setNoAsyncGuarantee = function() {
    this._bitField = (this._bitField | 536870912) &
        (~134217728);
};

Promise.prototype._receiverAt = function (index) {
    var ret = index === 0 ? this._receiver0 : this[
            index * 4 - 4 + 3];
    if (ret === UNDEFINED_BINDING) {
        return undefined;
    } else if (ret === undefined && this._isBound()) {
        return this._boundValue();
    }
    return ret;
};

Promise.prototype._promiseAt = function (index) {
    return this[
            index * 4 - 4 + 2];
};

Promise.prototype._fulfillmentHandlerAt = function (index) {
    return this[
            index * 4 - 4 + 0];
};

Promise.prototype._rejectionHandlerAt = function (index) {
    return this[
            index * 4 - 4 + 1];
};

Promise.prototype._boundValue = function() {};

Promise.prototype._migrateCallback0 = function (follower) {
    var bitField = follower._bitField;
    var fulfill = follower._fulfillmentHandler0;
    var reject = follower._rejectionHandler0;
    var promise = follower._promise0;
    var receiver = follower._receiverAt(0);
    if (receiver === undefined) receiver = UNDEFINED_BINDING;
    this._addCallbacks(fulfill, reject, promise, receiver, null);
};

Promise.prototype._migrateCallbackAt = function (follower, index) {
    var fulfill = follower._fulfillmentHandlerAt(index);
    var reject = follower._rejectionHandlerAt(index);
    var promise = follower._promiseAt(index);
    var receiver = follower._receiverAt(index);
    if (receiver === undefined) receiver = UNDEFINED_BINDING;
    this._addCallbacks(fulfill, reject, promise, receiver, null);
};

Promise.prototype._addCallbacks = function (
    fulfill,
    reject,
    promise,
    receiver,
    context
) {
    var index = this._length();

    if (index >= 65535 - 4) {
        index = 0;
        this._setLength(0);
    }

    if (index === 0) {
        this._promise0 = promise;
        this._receiver0 = receiver;
        if (typeof fulfill === "function") {
            this._fulfillmentHandler0 = util.contextBind(context, fulfill);
        }
        if (typeof reject === "function") {
            this._rejectionHandler0 = util.contextBind(context, reject);
        }
    } else {
        var base = index * 4 - 4;
        this[base + 2] = promise;
        this[base + 3] = receiver;
        if (typeof fulfill === "function") {
            this[base + 0] =
                util.contextBind(context, fulfill);
        }
        if (typeof reject === "function") {
            this[base + 1] =
                util.contextBind(context, reject);
        }
    }
    this._setLength(index + 1);
    return index;
};

Promise.prototype._proxy = function (proxyable, arg) {
    this._addCallbacks(undefined, undefined, arg, proxyable, null);
};

Promise.prototype._resolveCallback = function(value, shouldBind) {
    if (((this._bitField & 117506048) !== 0)) return;
    if (value === this)
        return this._rejectCallback(makeSelfResolutionError(), false);
    var maybePromise = tryConvertToPromise(value, this);
    if (!(maybePromise instanceof Promise)) return this._fulfill(value);

    if (shouldBind) this._propagateFrom(maybePromise, 2);


    var promise = maybePromise._target();

    if (promise === this) {
        this._reject(makeSelfResolutionError());
        return;
    }

    var bitField = promise._bitField;
    if (((bitField & 50397184) === 0)) {
        var len = this._length();
        if (len > 0) promise._migrateCallback0(this);
        for (var i = 1; i < len; ++i) {
            promise._migrateCallbackAt(this, i);
        }
        this._setFollowing();
        this._setLength(0);
        this._setFollowee(maybePromise);
    } else if (((bitField & 33554432) !== 0)) {
        this._fulfill(promise._value());
    } else if (((bitField & 16777216) !== 0)) {
        this._reject(promise._reason());
    } else {
        var reason = new CancellationError("late cancellation observer");
        promise._attachExtraTrace(reason);
        this._reject(reason);
    }
};

Promise.prototype._rejectCallback =
function(reason, synchronous, ignoreNonErrorWarnings) {
    var trace = util.ensureErrorObject(reason);
    var hasStack = trace === reason;
    if (!hasStack && !ignoreNonErrorWarnings && debug.warnings()) {
        var message = "a promise was rejected with a non-error: " +
            util.classString(reason);
        this._warn(message, true);
    }
    this._attachExtraTrace(trace, synchronous ? hasStack : false);
    this._reject(reason);
};

Promise.prototype._resolveFromExecutor = function (executor) {
    if (executor === INTERNAL) return;
    var promise = this;
    this._captureStackTrace();
    this._pushContext();
    var synchronous = true;
    var r = this._execute(executor, function(value) {
        promise._resolveCallback(value);
    }, function (reason) {
        promise._rejectCallback(reason, synchronous);
    });
    synchronous = false;
    this._popContext();

    if (r !== undefined) {
        promise._rejectCallback(r, true);
    }
};

Promise.prototype._settlePromiseFromHandler = function (
    handler, receiver, value, promise
) {
    var bitField = promise._bitField;
    if (((bitField & 65536) !== 0)) return;
    promise._pushContext();
    var x;
    if (receiver === APPLY) {
        if (!value || typeof value.length !== "number") {
            x = errorObj;
            x.e = new TypeError("cannot .spread() a non-array: " +
                                    util.classString(value));
        } else {
            x = tryCatch(handler).apply(this._boundValue(), value);
        }
    } else {
        x = tryCatch(handler).call(receiver, value);
    }
    var promiseCreated = promise._popContext();
    bitField = promise._bitField;
    if (((bitField & 65536) !== 0)) return;

    if (x === NEXT_FILTER) {
        promise._reject(value);
    } else if (x === errorObj) {
        promise._rejectCallback(x.e, false);
    } else {
        debug.checkForgottenReturns(x, promiseCreated, "",  promise, this);
        promise._resolveCallback(x);
    }
};

Promise.prototype._target = function() {
    var ret = this;
    while (ret._isFollowing()) ret = ret._followee();
    return ret;
};

Promise.prototype._followee = function() {
    return this._rejectionHandler0;
};

Promise.prototype._setFollowee = function(promise) {
    this._rejectionHandler0 = promise;
};

Promise.prototype._settlePromise = function(promise, handler, receiver, value) {
    var isPromise = promise instanceof Promise;
    var bitField = this._bitField;
    var asyncGuaranteed = ((bitField & 134217728) !== 0);
    if (((bitField & 65536) !== 0)) {
        if (isPromise) promise._invokeInternalOnCancel();

        if (receiver instanceof PassThroughHandlerContext &&
            receiver.isFinallyHandler()) {
            receiver.cancelPromise = promise;
            if (tryCatch(handler).call(receiver, value) === errorObj) {
                promise._reject(errorObj.e);
            }
        } else if (handler === reflectHandler) {
            promise._fulfill(reflectHandler.call(receiver));
        } else if (receiver instanceof Proxyable) {
            receiver._promiseCancelled(promise);
        } else if (isPromise || promise instanceof PromiseArray) {
            promise._cancel();
        } else {
            receiver.cancel();
        }
    } else if (typeof handler === "function") {
        if (!isPromise) {
            handler.call(receiver, value, promise);
        } else {
            if (asyncGuaranteed) promise._setAsyncGuaranteed();
            this._settlePromiseFromHandler(handler, receiver, value, promise);
        }
    } else if (receiver instanceof Proxyable) {
        if (!receiver._isResolved()) {
            if (((bitField & 33554432) !== 0)) {
                receiver._promiseFulfilled(value, promise);
            } else {
                receiver._promiseRejected(value, promise);
            }
        }
    } else if (isPromise) {
        if (asyncGuaranteed) promise._setAsyncGuaranteed();
        if (((bitField & 33554432) !== 0)) {
            promise._fulfill(value);
        } else {
            promise._reject(value);
        }
    }
};

Promise.prototype._settlePromiseLateCancellationObserver = function(ctx) {
    var handler = ctx.handler;
    var promise = ctx.promise;
    var receiver = ctx.receiver;
    var value = ctx.value;
    if (typeof handler === "function") {
        if (!(promise instanceof Promise)) {
            handler.call(receiver, value, promise);
        } else {
            this._settlePromiseFromHandler(handler, receiver, value, promise);
        }
    } else if (promise instanceof Promise) {
        promise._reject(value);
    }
};

Promise.prototype._settlePromiseCtx = function(ctx) {
    this._settlePromise(ctx.promise, ctx.handler, ctx.receiver, ctx.value);
};

Promise.prototype._settlePromise0 = function(handler, value, bitField) {
    var promise = this._promise0;
    var receiver = this._receiverAt(0);
    this._promise0 = undefined;
    this._receiver0 = undefined;
    this._settlePromise(promise, handler, receiver, value);
};

Promise.prototype._clearCallbackDataAtIndex = function(index) {
    var base = index * 4 - 4;
    this[base + 2] =
    this[base + 3] =
    this[base + 0] =
    this[base + 1] = undefined;
};

Promise.prototype._fulfill = function (value) {
    var bitField = this._bitField;
    if (((bitField & 117506048) >>> 16)) return;
    if (value === this) {
        var err = makeSelfResolutionError();
        this._attachExtraTrace(err);
        return this._reject(err);
    }
    this._setFulfilled();
    this._rejectionHandler0 = value;

    if ((bitField & 65535) > 0) {
        if (((bitField & 134217728) !== 0)) {
            this._settlePromises();
        } else {
            async.settlePromises(this);
        }
        this._dereferenceTrace();
    }
};

Promise.prototype._reject = function (reason) {
    var bitField = this._bitField;
    if (((bitField & 117506048) >>> 16)) return;
    this._setRejected();
    this._fulfillmentHandler0 = reason;

    if (this._isFinal()) {
        return async.fatalError(reason, util.isNode);
    }

    if ((bitField & 65535) > 0) {
        async.settlePromises(this);
    } else {
        this._ensurePossibleRejectionHandled();
    }
};

Promise.prototype._fulfillPromises = function (len, value) {
    for (var i = 1; i < len; i++) {
        var handler = this._fulfillmentHandlerAt(i);
        var promise = this._promiseAt(i);
        var receiver = this._receiverAt(i);
        this._clearCallbackDataAtIndex(i);
        this._settlePromise(promise, handler, receiver, value);
    }
};

Promise.prototype._rejectPromises = function (len, reason) {
    for (var i = 1; i < len; i++) {
        var handler = this._rejectionHandlerAt(i);
        var promise = this._promiseAt(i);
        var receiver = this._receiverAt(i);
        this._clearCallbackDataAtIndex(i);
        this._settlePromise(promise, handler, receiver, reason);
    }
};

Promise.prototype._settlePromises = function () {
    var bitField = this._bitField;
    var len = (bitField & 65535);

    if (len > 0) {
        if (((bitField & 16842752) !== 0)) {
            var reason = this._fulfillmentHandler0;
            this._settlePromise0(this._rejectionHandler0, reason, bitField);
            this._rejectPromises(len, reason);
        } else {
            var value = this._rejectionHandler0;
            this._settlePromise0(this._fulfillmentHandler0, value, bitField);
            this._fulfillPromises(len, value);
        }
        this._setLength(0);
    }
    this._clearCancellationData();
};

Promise.prototype._settledValue = function() {
    var bitField = this._bitField;
    if (((bitField & 33554432) !== 0)) {
        return this._rejectionHandler0;
    } else if (((bitField & 16777216) !== 0)) {
        return this._fulfillmentHandler0;
    }
};

if (typeof Symbol !== "undefined" && Symbol.toStringTag) {
    es5.defineProperty(Promise.prototype, Symbol.toStringTag, {
        get: function () {
            return "Object";
        }
    });
}

function deferResolve(v) {this.promise._resolveCallback(v);}
function deferReject(v) {this.promise._rejectCallback(v, false);}

Promise.defer = Promise.pending = function() {
    debug.deprecated("Promise.defer", "new Promise");
    var promise = new Promise(INTERNAL);
    return {
        promise: promise,
        resolve: deferResolve,
        reject: deferReject
    };
};

util.notEnumerableProp(Promise,
                       "_makeSelfResolutionError",
                       makeSelfResolutionError);

_dereq_("./method")(Promise, INTERNAL, tryConvertToPromise, apiRejection,
    debug);
_dereq_("./bind")(Promise, INTERNAL, tryConvertToPromise, debug);
_dereq_("./cancel")(Promise, PromiseArray, apiRejection, debug);
_dereq_("./direct_resolve")(Promise);
_dereq_("./synchronous_inspection")(Promise);
_dereq_("./join")(
    Promise, PromiseArray, tryConvertToPromise, INTERNAL, async);
Promise.Promise = Promise;
Promise.version = "3.7.1";
_dereq_('./call_get.js')(Promise);
_dereq_('./generators.js')(Promise, apiRejection, INTERNAL, tryConvertToPromise, Proxyable, debug);
_dereq_('./map.js')(Promise, PromiseArray, apiRejection, tryConvertToPromise, INTERNAL, debug);
_dereq_('./nodeify.js')(Promise);
_dereq_('./promisify.js')(Promise, INTERNAL);
_dereq_('./props.js')(Promise, PromiseArray, tryConvertToPromise, apiRejection);
_dereq_('./race.js')(Promise, INTERNAL, tryConvertToPromise, apiRejection);
_dereq_('./reduce.js')(Promise, PromiseArray, apiRejection, tryConvertToPromise, INTERNAL, debug);
_dereq_('./settle.js')(Promise, PromiseArray, debug);
_dereq_('./some.js')(Promise, PromiseArray, apiRejection);
_dereq_('./timers.js')(Promise, INTERNAL, debug);
_dereq_('./using.js')(Promise, apiRejection, tryConvertToPromise, createContext, INTERNAL, debug);
_dereq_('./any.js')(Promise);
_dereq_('./each.js')(Promise, INTERNAL);
_dereq_('./filter.js')(Promise, INTERNAL);
                                                         
    util.toFastProperties(Promise);                                          
    util.toFastProperties(Promise.prototype);                                
    function fillTypes(value) {                                              
        var p = new Promise(INTERNAL);                                       
        p._fulfillmentHandler0 = value;                                      
        p._rejectionHandler0 = value;                                        
        p._promise0 = value;                                                 
        p._receiver0 = value;                                                
    }                                                                        
    // Complete slack tracking, opt out of field-type tracking and           
    // stabilize map                                                         
    fillTypes({a: 1});                                                       
    fillTypes({b: 2});                                                       
    fillTypes({c: 3});                                                       
    fillTypes(1);                                                            
    fillTypes(function(){});                                                 
    fillTypes(undefined);                                                    
    fillTypes(false);                                                        
    fillTypes(new Promise(INTERNAL));                                        
    debug.setBounds(Async.firstLineError, util.lastLineError);               
    return Promise;                                                          

};

},{"./any.js":1,"./async":2,"./bind":3,"./call_get.js":5,"./cancel":6,"./catch_filter":7,"./context":8,"./debuggability":9,"./direct_resolve":10,"./each.js":11,"./errors":12,"./es5":13,"./filter.js":14,"./finally":15,"./generators.js":16,"./join":17,"./map.js":18,"./method":19,"./nodeback":20,"./nodeify.js":21,"./promise_array":23,"./promisify.js":24,"./props.js":25,"./race.js":27,"./reduce.js":28,"./settle.js":30,"./some.js":31,"./synchronous_inspection":32,"./thenables":33,"./timers.js":34,"./using.js":35,"./util":36,"async_hooks":undefined}],23:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, INTERNAL, tryConvertToPromise,
    apiRejection, Proxyable) {
var util = _dereq_("./util");
var isArray = util.isArray;

function toResolutionValue(val) {
    switch(val) {
    case -2: return [];
    case -3: return {};
    case -6: return new Map();
    }
}

function PromiseArray(values) {
    var promise = this._promise = new Promise(INTERNAL);
    if (values instanceof Promise) {
        promise._propagateFrom(values, 3);
        values.suppressUnhandledRejections();
    }
    promise._setOnCancel(this);
    this._values = values;
    this._length = 0;
    this._totalResolved = 0;
    this._init(undefined, -2);
}
util.inherits(PromiseArray, Proxyable);

PromiseArray.prototype.length = function () {
    return this._length;
};

PromiseArray.prototype.promise = function () {
    return this._promise;
};

PromiseArray.prototype._init = function init(_, resolveValueIfEmpty) {
    var values = tryConvertToPromise(this._values, this._promise);
    if (values instanceof Promise) {
        values = values._target();
        var bitField = values._bitField;
        ;
        this._values = values;

        if (((bitField & 50397184) === 0)) {
            this._promise._setAsyncGuaranteed();
            return values._then(
                init,
                this._reject,
                undefined,
                this,
                resolveValueIfEmpty
           );
        } else if (((bitField & 33554432) !== 0)) {
            values = values._value();
        } else if (((bitField & 16777216) !== 0)) {
            return this._reject(values._reason());
        } else {
            return this._cancel();
        }
    }
    values = util.asArray(values);
    if (values === null) {
        var err = apiRejection(
            "expecting an array or an iterable object but got " + util.classString(values)).reason();
        this._promise._rejectCallback(err, false);
        return;
    }

    if (values.length === 0) {
        if (resolveValueIfEmpty === -5) {
            this._resolveEmptyArray();
        }
        else {
            this._resolve(toResolutionValue(resolveValueIfEmpty));
        }
        return;
    }
    this._iterate(values);
};

PromiseArray.prototype._iterate = function(values) {
    var len = this.getActualLength(values.length);
    this._length = len;
    this._values = this.shouldCopyValues() ? new Array(len) : this._values;
    var result = this._promise;
    var isResolved = false;
    var bitField = null;
    for (var i = 0; i < len; ++i) {
        var maybePromise = tryConvertToPromise(values[i], result);

        if (maybePromise instanceof Promise) {
            maybePromise = maybePromise._target();
            bitField = maybePromise._bitField;
        } else {
            bitField = null;
        }

        if (isResolved) {
            if (bitField !== null) {
                maybePromise.suppressUnhandledRejections();
            }
        } else if (bitField !== null) {
            if (((bitField & 50397184) === 0)) {
                maybePromise._proxy(this, i);
                this._values[i] = maybePromise;
            } else if (((bitField & 33554432) !== 0)) {
                isResolved = this._promiseFulfilled(maybePromise._value(), i);
            } else if (((bitField & 16777216) !== 0)) {
                isResolved = this._promiseRejected(maybePromise._reason(), i);
            } else {
                isResolved = this._promiseCancelled(i);
            }
        } else {
            isResolved = this._promiseFulfilled(maybePromise, i);
        }
    }
    if (!isResolved) result._setAsyncGuaranteed();
};

PromiseArray.prototype._isResolved = function () {
    return this._values === null;
};

PromiseArray.prototype._resolve = function (value) {
    this._values = null;
    this._promise._fulfill(value);
};

PromiseArray.prototype._cancel = function() {
    if (this._isResolved() || !this._promise._isCancellable()) return;
    this._values = null;
    this._promise._cancel();
};

PromiseArray.prototype._reject = function (reason) {
    this._values = null;
    this._promise._rejectCallback(reason, false);
};

PromiseArray.prototype._promiseFulfilled = function (value, index) {
    this._values[index] = value;
    var totalResolved = ++this._totalResolved;
    if (totalResolved >= this._length) {
        this._resolve(this._values);
        return true;
    }
    return false;
};

PromiseArray.prototype._promiseCancelled = function() {
    this._cancel();
    return true;
};

PromiseArray.prototype._promiseRejected = function (reason) {
    this._totalResolved++;
    this._reject(reason);
    return true;
};

PromiseArray.prototype._resultCancelled = function() {
    if (this._isResolved()) return;
    var values = this._values;
    this._cancel();
    if (values instanceof Promise) {
        values.cancel();
    } else {
        for (var i = 0; i < values.length; ++i) {
            if (values[i] instanceof Promise) {
                values[i].cancel();
            }
        }
    }
};

PromiseArray.prototype.shouldCopyValues = function () {
    return true;
};

PromiseArray.prototype.getActualLength = function (len) {
    return len;
};

return PromiseArray;
};

},{"./util":36}],24:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, INTERNAL) {
var THIS = {};
var util = _dereq_("./util");
var nodebackForPromise = _dereq_("./nodeback");
var withAppended = util.withAppended;
var maybeWrapAsError = util.maybeWrapAsError;
var canEvaluate = util.canEvaluate;
var TypeError = _dereq_("./errors").TypeError;
var defaultSuffix = "Async";
var defaultPromisified = {__isPromisified__: true};
var noCopyProps = [
    "arity",    "length",
    "name",
    "arguments",
    "caller",
    "callee",
    "prototype",
    "__isPromisified__"
];
var noCopyPropsPattern = new RegExp("^(?:" + noCopyProps.join("|") + ")$");

var defaultFilter = function(name) {
    return util.isIdentifier(name) &&
        name.charAt(0) !== "_" &&
        name !== "constructor";
};

function propsFilter(key) {
    return !noCopyPropsPattern.test(key);
}

function isPromisified(fn) {
    try {
        return fn.__isPromisified__ === true;
    }
    catch (e) {
        return false;
    }
}

function hasPromisified(obj, key, suffix) {
    var val = util.getDataPropertyOrDefault(obj, key + suffix,
                                            defaultPromisified);
    return val ? isPromisified(val) : false;
}
function checkValid(ret, suffix, suffixRegexp) {
    for (var i = 0; i < ret.length; i += 2) {
        var key = ret[i];
        if (suffixRegexp.test(key)) {
            var keyWithoutAsyncSuffix = key.replace(suffixRegexp, "");
            for (var j = 0; j < ret.length; j += 2) {
                if (ret[j] === keyWithoutAsyncSuffix) {
                    throw new TypeError("Cannot promisify an API that has normal methods with '%s'-suffix\u000a\u000a    See http://goo.gl/MqrFmX\u000a"
                        .replace("%s", suffix));
                }
            }
        }
    }
}

function promisifiableMethods(obj, suffix, suffixRegexp, filter) {
    var keys = util.inheritedDataKeys(obj);
    var ret = [];
    for (var i = 0; i < keys.length; ++i) {
        var key = keys[i];
        var value = obj[key];
        var passesDefaultFilter = filter === defaultFilter
            ? true : defaultFilter(key, value, obj);
        if (typeof value === "function" &&
            !isPromisified(value) &&
            !hasPromisified(obj, key, suffix) &&
            filter(key, value, obj, passesDefaultFilter)) {
            ret.push(key, value);
        }
    }
    checkValid(ret, suffix, suffixRegexp);
    return ret;
}

var escapeIdentRegex = function(str) {
    return str.replace(/([$])/, "\\$");
};

var makeNodePromisifiedEval;
if (false) { var parameterCount, parameterDeclaration, argumentSequence, switchCaseArgumentOrder; }

function makeNodePromisifiedClosure(callback, receiver, _, fn, __, multiArgs) {
    var defaultThis = (function() {return this;})();
    var method = callback;
    if (typeof method === "string") {
        callback = fn;
    }
    function promisified() {
        var _receiver = receiver;
        if (receiver === THIS) _receiver = this;
        var promise = new Promise(INTERNAL);
        promise._captureStackTrace();
        var cb = typeof method === "string" && this !== defaultThis
            ? this[method] : callback;
        var fn = nodebackForPromise(promise, multiArgs);
        try {
            cb.apply(_receiver, withAppended(arguments, fn));
        } catch(e) {
            promise._rejectCallback(maybeWrapAsError(e), true, true);
        }
        if (!promise._isFateSealed()) promise._setAsyncGuaranteed();
        return promise;
    }
    util.notEnumerableProp(promisified, "__isPromisified__", true);
    return promisified;
}

var makeNodePromisified = canEvaluate
    ? makeNodePromisifiedEval
    : makeNodePromisifiedClosure;

function promisifyAll(obj, suffix, filter, promisifier, multiArgs) {
    var suffixRegexp = new RegExp(escapeIdentRegex(suffix) + "$");
    var methods =
        promisifiableMethods(obj, suffix, suffixRegexp, filter);

    for (var i = 0, len = methods.length; i < len; i+= 2) {
        var key = methods[i];
        var fn = methods[i+1];
        var promisifiedKey = key + suffix;
        if (promisifier === makeNodePromisified) {
            obj[promisifiedKey] =
                makeNodePromisified(key, THIS, key, fn, suffix, multiArgs);
        } else {
            var promisified = promisifier(fn, function() {
                return makeNodePromisified(key, THIS, key,
                                           fn, suffix, multiArgs);
            });
            util.notEnumerableProp(promisified, "__isPromisified__", true);
            obj[promisifiedKey] = promisified;
        }
    }
    util.toFastProperties(obj);
    return obj;
}

function promisify(callback, receiver, multiArgs) {
    return makeNodePromisified(callback, receiver, undefined,
                                callback, null, multiArgs);
}

Promise.promisify = function (fn, options) {
    if (typeof fn !== "function") {
        throw new TypeError("expecting a function but got " + util.classString(fn));
    }
    if (isPromisified(fn)) {
        return fn;
    }
    options = Object(options);
    var receiver = options.context === undefined ? THIS : options.context;
    var multiArgs = !!options.multiArgs;
    var ret = promisify(fn, receiver, multiArgs);
    util.copyDescriptors(fn, ret, propsFilter);
    return ret;
};

Promise.promisifyAll = function (target, options) {
    if (typeof target !== "function" && typeof target !== "object") {
        throw new TypeError("the target of promisifyAll must be an object or a function\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
    options = Object(options);
    var multiArgs = !!options.multiArgs;
    var suffix = options.suffix;
    if (typeof suffix !== "string") suffix = defaultSuffix;
    var filter = options.filter;
    if (typeof filter !== "function") filter = defaultFilter;
    var promisifier = options.promisifier;
    if (typeof promisifier !== "function") promisifier = makeNodePromisified;

    if (!util.isIdentifier(suffix)) {
        throw new RangeError("suffix must be a valid identifier\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }

    var keys = util.inheritedDataKeys(target);
    for (var i = 0; i < keys.length; ++i) {
        var value = target[keys[i]];
        if (keys[i] !== "constructor" &&
            util.isClass(value)) {
            promisifyAll(value.prototype, suffix, filter, promisifier,
                multiArgs);
            promisifyAll(value, suffix, filter, promisifier, multiArgs);
        }
    }

    return promisifyAll(target, suffix, filter, promisifier, multiArgs);
};
};


},{"./errors":12,"./nodeback":20,"./util":36}],25:[function(_dereq_,module,exports){
"use strict";
module.exports = function(
    Promise, PromiseArray, tryConvertToPromise, apiRejection) {
var util = _dereq_("./util");
var isObject = util.isObject;
var es5 = _dereq_("./es5");
var Es6Map;
if (typeof Map === "function") Es6Map = Map;

var mapToEntries = (function() {
    var index = 0;
    var size = 0;

    function extractEntry(value, key) {
        this[index] = value;
        this[index + size] = key;
        index++;
    }

    return function mapToEntries(map) {
        size = map.size;
        index = 0;
        var ret = new Array(map.size * 2);
        map.forEach(extractEntry, ret);
        return ret;
    };
})();

var entriesToMap = function(entries) {
    var ret = new Es6Map();
    var length = entries.length / 2 | 0;
    for (var i = 0; i < length; ++i) {
        var key = entries[length + i];
        var value = entries[i];
        ret.set(key, value);
    }
    return ret;
};

function PropertiesPromiseArray(obj) {
    var isMap = false;
    var entries;
    if (Es6Map !== undefined && obj instanceof Es6Map) {
        entries = mapToEntries(obj);
        isMap = true;
    } else {
        var keys = es5.keys(obj);
        var len = keys.length;
        entries = new Array(len * 2);
        for (var i = 0; i < len; ++i) {
            var key = keys[i];
            entries[i] = obj[key];
            entries[i + len] = key;
        }
    }
    this.constructor$(entries);
    this._isMap = isMap;
    this._init$(undefined, isMap ? -6 : -3);
}
util.inherits(PropertiesPromiseArray, PromiseArray);

PropertiesPromiseArray.prototype._init = function () {};

PropertiesPromiseArray.prototype._promiseFulfilled = function (value, index) {
    this._values[index] = value;
    var totalResolved = ++this._totalResolved;
    if (totalResolved >= this._length) {
        var val;
        if (this._isMap) {
            val = entriesToMap(this._values);
        } else {
            val = {};
            var keyOffset = this.length();
            for (var i = 0, len = this.length(); i < len; ++i) {
                val[this._values[i + keyOffset]] = this._values[i];
            }
        }
        this._resolve(val);
        return true;
    }
    return false;
};

PropertiesPromiseArray.prototype.shouldCopyValues = function () {
    return false;
};

PropertiesPromiseArray.prototype.getActualLength = function (len) {
    return len >> 1;
};

function props(promises) {
    var ret;
    var castValue = tryConvertToPromise(promises);

    if (!isObject(castValue)) {
        return apiRejection("cannot await properties of a non-object\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    } else if (castValue instanceof Promise) {
        ret = castValue._then(
            Promise.props, undefined, undefined, undefined, undefined);
    } else {
        ret = new PropertiesPromiseArray(castValue).promise();
    }

    if (castValue instanceof Promise) {
        ret._propagateFrom(castValue, 2);
    }
    return ret;
}

Promise.prototype.props = function () {
    return props(this);
};

Promise.props = function (promises) {
    return props(promises);
};
};

},{"./es5":13,"./util":36}],26:[function(_dereq_,module,exports){
"use strict";
function arrayMove(src, srcIndex, dst, dstIndex, len) {
    for (var j = 0; j < len; ++j) {
        dst[j + dstIndex] = src[j + srcIndex];
        src[j + srcIndex] = void 0;
    }
}

function Queue(capacity) {
    this._capacity = capacity;
    this._length = 0;
    this._front = 0;
}

Queue.prototype._willBeOverCapacity = function (size) {
    return this._capacity < size;
};

Queue.prototype._pushOne = function (arg) {
    var length = this.length();
    this._checkCapacity(length + 1);
    var i = (this._front + length) & (this._capacity - 1);
    this[i] = arg;
    this._length = length + 1;
};

Queue.prototype.push = function (fn, receiver, arg) {
    var length = this.length() + 3;
    if (this._willBeOverCapacity(length)) {
        this._pushOne(fn);
        this._pushOne(receiver);
        this._pushOne(arg);
        return;
    }
    var j = this._front + length - 3;
    this._checkCapacity(length);
    var wrapMask = this._capacity - 1;
    this[(j + 0) & wrapMask] = fn;
    this[(j + 1) & wrapMask] = receiver;
    this[(j + 2) & wrapMask] = arg;
    this._length = length;
};

Queue.prototype.shift = function () {
    var front = this._front,
        ret = this[front];

    this[front] = undefined;
    this._front = (front + 1) & (this._capacity - 1);
    this._length--;
    return ret;
};

Queue.prototype.length = function () {
    return this._length;
};

Queue.prototype._checkCapacity = function (size) {
    if (this._capacity < size) {
        this._resizeTo(this._capacity << 1);
    }
};

Queue.prototype._resizeTo = function (capacity) {
    var oldCapacity = this._capacity;
    this._capacity = capacity;
    var front = this._front;
    var length = this._length;
    var moveItemsCount = (front + length) & (oldCapacity - 1);
    arrayMove(this, 0, this, oldCapacity, moveItemsCount);
};

module.exports = Queue;

},{}],27:[function(_dereq_,module,exports){
"use strict";
module.exports = function(
    Promise, INTERNAL, tryConvertToPromise, apiRejection) {
var util = _dereq_("./util");

var raceLater = function (promise) {
    return promise.then(function(array) {
        return race(array, promise);
    });
};

function race(promises, parent) {
    var maybePromise = tryConvertToPromise(promises);

    if (maybePromise instanceof Promise) {
        return raceLater(maybePromise);
    } else {
        promises = util.asArray(promises);
        if (promises === null)
            return apiRejection("expecting an array or an iterable object but got " + util.classString(promises));
    }

    var ret = new Promise(INTERNAL);
    if (parent !== undefined) {
        ret._propagateFrom(parent, 3);
    }
    var fulfill = ret._fulfill;
    var reject = ret._reject;
    for (var i = 0, len = promises.length; i < len; ++i) {
        var val = promises[i];

        if (val === undefined && !(i in promises)) {
            continue;
        }

        Promise.cast(val)._then(fulfill, reject, undefined, ret, null);
    }
    return ret;
}

Promise.race = function (promises) {
    return race(promises, undefined);
};

Promise.prototype.race = function () {
    return race(this, undefined);
};

};

},{"./util":36}],28:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise,
                          PromiseArray,
                          apiRejection,
                          tryConvertToPromise,
                          INTERNAL,
                          debug) {
var util = _dereq_("./util");
var tryCatch = util.tryCatch;

function ReductionPromiseArray(promises, fn, initialValue, _each) {
    this.constructor$(promises);
    var context = Promise._getContext();
    this._fn = util.contextBind(context, fn);
    if (initialValue !== undefined) {
        initialValue = Promise.resolve(initialValue);
        initialValue._attachCancellationCallback(this);
    }
    this._initialValue = initialValue;
    this._currentCancellable = null;
    if(_each === INTERNAL) {
        this._eachValues = Array(this._length);
    } else if (_each === 0) {
        this._eachValues = null;
    } else {
        this._eachValues = undefined;
    }
    this._promise._captureStackTrace();
    this._init$(undefined, -5);
}
util.inherits(ReductionPromiseArray, PromiseArray);

ReductionPromiseArray.prototype._gotAccum = function(accum) {
    if (this._eachValues !== undefined &&
        this._eachValues !== null &&
        accum !== INTERNAL) {
        this._eachValues.push(accum);
    }
};

ReductionPromiseArray.prototype._eachComplete = function(value) {
    if (this._eachValues !== null) {
        this._eachValues.push(value);
    }
    return this._eachValues;
};

ReductionPromiseArray.prototype._init = function() {};

ReductionPromiseArray.prototype._resolveEmptyArray = function() {
    this._resolve(this._eachValues !== undefined ? this._eachValues
                                                 : this._initialValue);
};

ReductionPromiseArray.prototype.shouldCopyValues = function () {
    return false;
};

ReductionPromiseArray.prototype._resolve = function(value) {
    this._promise._resolveCallback(value);
    this._values = null;
};

ReductionPromiseArray.prototype._resultCancelled = function(sender) {
    if (sender === this._initialValue) return this._cancel();
    if (this._isResolved()) return;
    this._resultCancelled$();
    if (this._currentCancellable instanceof Promise) {
        this._currentCancellable.cancel();
    }
    if (this._initialValue instanceof Promise) {
        this._initialValue.cancel();
    }
};

ReductionPromiseArray.prototype._iterate = function (values) {
    this._values = values;
    var value;
    var i;
    var length = values.length;
    if (this._initialValue !== undefined) {
        value = this._initialValue;
        i = 0;
    } else {
        value = Promise.resolve(values[0]);
        i = 1;
    }

    this._currentCancellable = value;

    for (var j = i; j < length; ++j) {
        var maybePromise = values[j];
        if (maybePromise instanceof Promise) {
            maybePromise.suppressUnhandledRejections();
        }
    }

    if (!value.isRejected()) {
        for (; i < length; ++i) {
            var ctx = {
                accum: null,
                value: values[i],
                index: i,
                length: length,
                array: this
            };

            value = value._then(gotAccum, undefined, undefined, ctx, undefined);

            if ((i & 127) === 0) {
                value._setNoAsyncGuarantee();
            }
        }
    }

    if (this._eachValues !== undefined) {
        value = value
            ._then(this._eachComplete, undefined, undefined, this, undefined);
    }
    value._then(completed, completed, undefined, value, this);
};

Promise.prototype.reduce = function (fn, initialValue) {
    return reduce(this, fn, initialValue, null);
};

Promise.reduce = function (promises, fn, initialValue, _each) {
    return reduce(promises, fn, initialValue, _each);
};

function completed(valueOrReason, array) {
    if (this.isFulfilled()) {
        array._resolve(valueOrReason);
    } else {
        array._reject(valueOrReason);
    }
}

function reduce(promises, fn, initialValue, _each) {
    if (typeof fn !== "function") {
        return apiRejection("expecting a function but got " + util.classString(fn));
    }
    var array = new ReductionPromiseArray(promises, fn, initialValue, _each);
    return array.promise();
}

function gotAccum(accum) {
    this.accum = accum;
    this.array._gotAccum(accum);
    var value = tryConvertToPromise(this.value, this.array._promise);
    if (value instanceof Promise) {
        this.array._currentCancellable = value;
        return value._then(gotValue, undefined, undefined, this, undefined);
    } else {
        return gotValue.call(this, value);
    }
}

function gotValue(value) {
    var array = this.array;
    var promise = array._promise;
    var fn = tryCatch(array._fn);
    promise._pushContext();
    var ret;
    if (array._eachValues !== undefined) {
        ret = fn.call(promise._boundValue(), value, this.index, this.length);
    } else {
        ret = fn.call(promise._boundValue(),
                              this.accum, value, this.index, this.length);
    }
    if (ret instanceof Promise) {
        array._currentCancellable = ret;
    }
    var promiseCreated = promise._popContext();
    debug.checkForgottenReturns(
        ret,
        promiseCreated,
        array._eachValues !== undefined ? "Promise.each" : "Promise.reduce",
        promise
    );
    return ret;
}
};

},{"./util":36}],29:[function(_dereq_,module,exports){
"use strict";
var util = _dereq_("./util");
var schedule;
var noAsyncScheduler = function() {
    throw new Error("No async scheduler available\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
};
var NativePromise = util.getNativePromise();
if (util.isNode && typeof MutationObserver === "undefined") {
    var GlobalSetImmediate = global.setImmediate;
    var ProcessNextTick = process.nextTick;
    schedule = util.isRecentNode
                ? function(fn) { GlobalSetImmediate.call(global, fn); }
                : function(fn) { ProcessNextTick.call(process, fn); };
} else if (typeof NativePromise === "function" &&
           typeof NativePromise.resolve === "function") {
    var nativePromise = NativePromise.resolve();
    schedule = function(fn) {
        nativePromise.then(fn);
    };
} else if ((typeof MutationObserver !== "undefined") &&
          !(typeof window !== "undefined" &&
            window.navigator &&
            (window.navigator.standalone || window.cordova)) &&
          ("classList" in document.documentElement)) {
    schedule = (function() {
        var div = document.createElement("div");
        var opts = {attributes: true};
        var toggleScheduled = false;
        var div2 = document.createElement("div");
        var o2 = new MutationObserver(function() {
            div.classList.toggle("foo");
            toggleScheduled = false;
        });
        o2.observe(div2, opts);

        var scheduleToggle = function() {
            if (toggleScheduled) return;
            toggleScheduled = true;
            div2.classList.toggle("foo");
        };

        return function schedule(fn) {
            var o = new MutationObserver(function() {
                o.disconnect();
                fn();
            });
            o.observe(div, opts);
            scheduleToggle();
        };
    })();
} else if (typeof setImmediate !== "undefined") {
    schedule = function (fn) {
        setImmediate(fn);
    };
} else if (typeof setTimeout !== "undefined") {
    schedule = function (fn) {
        setTimeout(fn, 0);
    };
} else {
    schedule = noAsyncScheduler;
}
module.exports = schedule;

},{"./util":36}],30:[function(_dereq_,module,exports){
"use strict";
module.exports =
    function(Promise, PromiseArray, debug) {
var PromiseInspection = Promise.PromiseInspection;
var util = _dereq_("./util");

function SettledPromiseArray(values) {
    this.constructor$(values);
}
util.inherits(SettledPromiseArray, PromiseArray);

SettledPromiseArray.prototype._promiseResolved = function (index, inspection) {
    this._values[index] = inspection;
    var totalResolved = ++this._totalResolved;
    if (totalResolved >= this._length) {
        this._resolve(this._values);
        return true;
    }
    return false;
};

SettledPromiseArray.prototype._promiseFulfilled = function (value, index) {
    var ret = new PromiseInspection();
    ret._bitField = 33554432;
    ret._settledValueField = value;
    return this._promiseResolved(index, ret);
};
SettledPromiseArray.prototype._promiseRejected = function (reason, index) {
    var ret = new PromiseInspection();
    ret._bitField = 16777216;
    ret._settledValueField = reason;
    return this._promiseResolved(index, ret);
};

Promise.settle = function (promises) {
    debug.deprecated(".settle()", ".reflect()");
    return new SettledPromiseArray(promises).promise();
};

Promise.allSettled = function (promises) {
    return new SettledPromiseArray(promises).promise();
};

Promise.prototype.settle = function () {
    return Promise.settle(this);
};
};

},{"./util":36}],31:[function(_dereq_,module,exports){
"use strict";
module.exports =
function(Promise, PromiseArray, apiRejection) {
var util = _dereq_("./util");
var RangeError = _dereq_("./errors").RangeError;
var AggregateError = _dereq_("./errors").AggregateError;
var isArray = util.isArray;
var CANCELLATION = {};


function SomePromiseArray(values) {
    this.constructor$(values);
    this._howMany = 0;
    this._unwrap = false;
    this._initialized = false;
}
util.inherits(SomePromiseArray, PromiseArray);

SomePromiseArray.prototype._init = function () {
    if (!this._initialized) {
        return;
    }
    if (this._howMany === 0) {
        this._resolve([]);
        return;
    }
    this._init$(undefined, -5);
    var isArrayResolved = isArray(this._values);
    if (!this._isResolved() &&
        isArrayResolved &&
        this._howMany > this._canPossiblyFulfill()) {
        this._reject(this._getRangeError(this.length()));
    }
};

SomePromiseArray.prototype.init = function () {
    this._initialized = true;
    this._init();
};

SomePromiseArray.prototype.setUnwrap = function () {
    this._unwrap = true;
};

SomePromiseArray.prototype.howMany = function () {
    return this._howMany;
};

SomePromiseArray.prototype.setHowMany = function (count) {
    this._howMany = count;
};

SomePromiseArray.prototype._promiseFulfilled = function (value) {
    this._addFulfilled(value);
    if (this._fulfilled() === this.howMany()) {
        this._values.length = this.howMany();
        if (this.howMany() === 1 && this._unwrap) {
            this._resolve(this._values[0]);
        } else {
            this._resolve(this._values);
        }
        return true;
    }
    return false;

};
SomePromiseArray.prototype._promiseRejected = function (reason) {
    this._addRejected(reason);
    return this._checkOutcome();
};

SomePromiseArray.prototype._promiseCancelled = function () {
    if (this._values instanceof Promise || this._values == null) {
        return this._cancel();
    }
    this._addRejected(CANCELLATION);
    return this._checkOutcome();
};

SomePromiseArray.prototype._checkOutcome = function() {
    if (this.howMany() > this._canPossiblyFulfill()) {
        var e = new AggregateError();
        for (var i = this.length(); i < this._values.length; ++i) {
            if (this._values[i] !== CANCELLATION) {
                e.push(this._values[i]);
            }
        }
        if (e.length > 0) {
            this._reject(e);
        } else {
            this._cancel();
        }
        return true;
    }
    return false;
};

SomePromiseArray.prototype._fulfilled = function () {
    return this._totalResolved;
};

SomePromiseArray.prototype._rejected = function () {
    return this._values.length - this.length();
};

SomePromiseArray.prototype._addRejected = function (reason) {
    this._values.push(reason);
};

SomePromiseArray.prototype._addFulfilled = function (value) {
    this._values[this._totalResolved++] = value;
};

SomePromiseArray.prototype._canPossiblyFulfill = function () {
    return this.length() - this._rejected();
};

SomePromiseArray.prototype._getRangeError = function (count) {
    var message = "Input array must contain at least " +
            this._howMany + " items but contains only " + count + " items";
    return new RangeError(message);
};

SomePromiseArray.prototype._resolveEmptyArray = function () {
    this._reject(this._getRangeError(0));
};

function some(promises, howMany) {
    if ((howMany | 0) !== howMany || howMany < 0) {
        return apiRejection("expecting a positive integer\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
    var ret = new SomePromiseArray(promises);
    var promise = ret.promise();
    ret.setHowMany(howMany);
    ret.init();
    return promise;
}

Promise.some = function (promises, howMany) {
    return some(promises, howMany);
};

Promise.prototype.some = function (howMany) {
    return some(this, howMany);
};

Promise._SomePromiseArray = SomePromiseArray;
};

},{"./errors":12,"./util":36}],32:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise) {
function PromiseInspection(promise) {
    if (promise !== undefined) {
        promise = promise._target();
        this._bitField = promise._bitField;
        this._settledValueField = promise._isFateSealed()
            ? promise._settledValue() : undefined;
    }
    else {
        this._bitField = 0;
        this._settledValueField = undefined;
    }
}

PromiseInspection.prototype._settledValue = function() {
    return this._settledValueField;
};

var value = PromiseInspection.prototype.value = function () {
    if (!this.isFulfilled()) {
        throw new TypeError("cannot get fulfillment value of a non-fulfilled promise\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
    return this._settledValue();
};

var reason = PromiseInspection.prototype.error =
PromiseInspection.prototype.reason = function () {
    if (!this.isRejected()) {
        throw new TypeError("cannot get rejection reason of a non-rejected promise\u000a\u000a    See http://goo.gl/MqrFmX\u000a");
    }
    return this._settledValue();
};

var isFulfilled = PromiseInspection.prototype.isFulfilled = function() {
    return (this._bitField & 33554432) !== 0;
};

var isRejected = PromiseInspection.prototype.isRejected = function () {
    return (this._bitField & 16777216) !== 0;
};

var isPending = PromiseInspection.prototype.isPending = function () {
    return (this._bitField & 50397184) === 0;
};

var isResolved = PromiseInspection.prototype.isResolved = function () {
    return (this._bitField & 50331648) !== 0;
};

PromiseInspection.prototype.isCancelled = function() {
    return (this._bitField & 8454144) !== 0;
};

Promise.prototype.__isCancelled = function() {
    return (this._bitField & 65536) === 65536;
};

Promise.prototype._isCancelled = function() {
    return this._target().__isCancelled();
};

Promise.prototype.isCancelled = function() {
    return (this._target()._bitField & 8454144) !== 0;
};

Promise.prototype.isPending = function() {
    return isPending.call(this._target());
};

Promise.prototype.isRejected = function() {
    return isRejected.call(this._target());
};

Promise.prototype.isFulfilled = function() {
    return isFulfilled.call(this._target());
};

Promise.prototype.isResolved = function() {
    return isResolved.call(this._target());
};

Promise.prototype.value = function() {
    return value.call(this._target());
};

Promise.prototype.reason = function() {
    var target = this._target();
    target._unsetRejectionIsUnhandled();
    return reason.call(target);
};

Promise.prototype._value = function() {
    return this._settledValue();
};

Promise.prototype._reason = function() {
    this._unsetRejectionIsUnhandled();
    return this._settledValue();
};

Promise.PromiseInspection = PromiseInspection;
};

},{}],33:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, INTERNAL) {
var util = _dereq_("./util");
var errorObj = util.errorObj;
var isObject = util.isObject;

function tryConvertToPromise(obj, context) {
    if (isObject(obj)) {
        if (obj instanceof Promise) return obj;
        var then = getThen(obj);
        if (then === errorObj) {
            if (context) context._pushContext();
            var ret = Promise.reject(then.e);
            if (context) context._popContext();
            return ret;
        } else if (typeof then === "function") {
            if (isAnyBluebirdPromise(obj)) {
                var ret = new Promise(INTERNAL);
                obj._then(
                    ret._fulfill,
                    ret._reject,
                    undefined,
                    ret,
                    null
                );
                return ret;
            }
            return doThenable(obj, then, context);
        }
    }
    return obj;
}

function doGetThen(obj) {
    return obj.then;
}

function getThen(obj) {
    try {
        return doGetThen(obj);
    } catch (e) {
        errorObj.e = e;
        return errorObj;
    }
}

var hasProp = {}.hasOwnProperty;
function isAnyBluebirdPromise(obj) {
    try {
        return hasProp.call(obj, "_promise0");
    } catch (e) {
        return false;
    }
}

function doThenable(x, then, context) {
    var promise = new Promise(INTERNAL);
    var ret = promise;
    if (context) context._pushContext();
    promise._captureStackTrace();
    if (context) context._popContext();
    var synchronous = true;
    var result = util.tryCatch(then).call(x, resolve, reject);
    synchronous = false;

    if (promise && result === errorObj) {
        promise._rejectCallback(result.e, true, true);
        promise = null;
    }

    function resolve(value) {
        if (!promise) return;
        promise._resolveCallback(value);
        promise = null;
    }

    function reject(reason) {
        if (!promise) return;
        promise._rejectCallback(reason, synchronous, true);
        promise = null;
    }
    return ret;
}

return tryConvertToPromise;
};

},{"./util":36}],34:[function(_dereq_,module,exports){
"use strict";
module.exports = function(Promise, INTERNAL, debug) {
var util = _dereq_("./util");
var TimeoutError = Promise.TimeoutError;

function HandleWrapper(handle)  {
    this.handle = handle;
}

HandleWrapper.prototype._resultCancelled = function() {
    clearTimeout(this.handle);
};

var afterValue = function(value) { return delay(+this).thenReturn(value); };
var delay = Promise.delay = function (ms, value) {
    var ret;
    var handle;
    if (value !== undefined) {
        ret = Promise.resolve(value)
                ._then(afterValue, null, null, ms, undefined);
        if (debug.cancellation() && value instanceof Promise) {
            ret._setOnCancel(value);
        }
    } else {
        ret = new Promise(INTERNAL);
        handle = setTimeout(function() { ret._fulfill(); }, +ms);
        if (debug.cancellation()) {
            ret._setOnCancel(new HandleWrapper(handle));
        }
        ret._captureStackTrace();
    }
    ret._setAsyncGuaranteed();
    return ret;
};

Promise.prototype.delay = function (ms) {
    return delay(ms, this);
};

var afterTimeout = function (promise, message, parent) {
    var err;
    if (typeof message !== "string") {
        if (message instanceof Error) {
            err = message;
        } else {
            err = new TimeoutError("operation timed out");
        }
    } else {
        err = new TimeoutError(message);
    }
    util.markAsOriginatingFromRejection(err);
    promise._attachExtraTrace(err);
    promise._reject(err);

    if (parent != null) {
        parent.cancel();
    }
};

function successClear(value) {
    clearTimeout(this.handle);
    return value;
}

function failureClear(reason) {
    clearTimeout(this.handle);
    throw reason;
}

Promise.prototype.timeout = function (ms, message) {
    ms = +ms;
    var ret, parent;

    var handleWrapper = new HandleWrapper(setTimeout(function timeoutTimeout() {
        if (ret.isPending()) {
            afterTimeout(ret, message, parent);
        }
    }, ms));

    if (debug.cancellation()) {
        parent = this.then();
        ret = parent._then(successClear, failureClear,
                            undefined, handleWrapper, undefined);
        ret._setOnCancel(handleWrapper);
    } else {
        ret = this._then(successClear, failureClear,
                            undefined, handleWrapper, undefined);
    }

    return ret;
};

};

},{"./util":36}],35:[function(_dereq_,module,exports){
"use strict";
module.exports = function (Promise, apiRejection, tryConvertToPromise,
    createContext, INTERNAL, debug) {
    var util = _dereq_("./util");
    var TypeError = _dereq_("./errors").TypeError;
    var inherits = _dereq_("./util").inherits;
    var errorObj = util.errorObj;
    var tryCatch = util.tryCatch;
    var NULL = {};

    function thrower(e) {
        setTimeout(function(){throw e;}, 0);
    }

    function castPreservingDisposable(thenable) {
        var maybePromise = tryConvertToPromise(thenable);
        if (maybePromise !== thenable &&
            typeof thenable._isDisposable === "function" &&
            typeof thenable._getDisposer === "function" &&
            thenable._isDisposable()) {
            maybePromise._setDisposable(thenable._getDisposer());
        }
        return maybePromise;
    }
    function dispose(resources, inspection) {
        var i = 0;
        var len = resources.length;
        var ret = new Promise(INTERNAL);
        function iterator() {
            if (i >= len) return ret._fulfill();
            var maybePromise = castPreservingDisposable(resources[i++]);
            if (maybePromise instanceof Promise &&
                maybePromise._isDisposable()) {
                try {
                    maybePromise = tryConvertToPromise(
                        maybePromise._getDisposer().tryDispose(inspection),
                        resources.promise);
                } catch (e) {
                    return thrower(e);
                }
                if (maybePromise instanceof Promise) {
                    return maybePromise._then(iterator, thrower,
                                              null, null, null);
                }
            }
            iterator();
        }
        iterator();
        return ret;
    }

    function Disposer(data, promise, context) {
        this._data = data;
        this._promise = promise;
        this._context = context;
    }

    Disposer.prototype.data = function () {
        return this._data;
    };

    Disposer.prototype.promise = function () {
        return this._promise;
    };

    Disposer.prototype.resource = function () {
        if (this.promise().isFulfilled()) {
            return this.promise().value();
        }
        return NULL;
    };

    Disposer.prototype.tryDispose = function(inspection) {
        var resource = this.resource();
        var context = this._context;
        if (context !== undefined) context._pushContext();
        var ret = resource !== NULL
            ? this.doDispose(resource, inspection) : null;
        if (context !== undefined) context._popContext();
        this._promise._unsetDisposable();
        this._data = null;
        return ret;
    };

    Disposer.isDisposer = function (d) {
        return (d != null &&
                typeof d.resource === "function" &&
                typeof d.tryDispose === "function");
    };

    function FunctionDisposer(fn, promise, context) {
        this.constructor$(fn, promise, context);
    }
    inherits(FunctionDisposer, Disposer);

    FunctionDisposer.prototype.doDispose = function (resource, inspection) {
        var fn = this.data();
        return fn.call(resource, resource, inspection);
    };

    function maybeUnwrapDisposer(value) {
        if (Disposer.isDisposer(value)) {
            this.resources[this.index]._setDisposable(value);
            return value.promise();
        }
        return value;
    }

    function ResourceList(length) {
        this.length = length;
        this.promise = null;
        this[length-1] = null;
    }

    ResourceList.prototype._resultCancelled = function() {
        var len = this.length;
        for (var i = 0; i < len; ++i) {
            var item = this[i];
            if (item instanceof Promise) {
                item.cancel();
            }
        }
    };

    Promise.using = function () {
        var len = arguments.length;
        if (len < 2) return apiRejection(
                        "you must pass at least 2 arguments to Promise.using");
        var fn = arguments[len - 1];
        if (typeof fn !== "function") {
            return apiRejection("expecting a function but got " + util.classString(fn));
        }
        var input;
        var spreadArgs = true;
        if (len === 2 && Array.isArray(arguments[0])) {
            input = arguments[0];
            len = input.length;
            spreadArgs = false;
        } else {
            input = arguments;
            len--;
        }
        var resources = new ResourceList(len);
        for (var i = 0; i < len; ++i) {
            var resource = input[i];
            if (Disposer.isDisposer(resource)) {
                var disposer = resource;
                resource = resource.promise();
                resource._setDisposable(disposer);
            } else {
                var maybePromise = tryConvertToPromise(resource);
                if (maybePromise instanceof Promise) {
                    resource =
                        maybePromise._then(maybeUnwrapDisposer, null, null, {
                            resources: resources,
                            index: i
                    }, undefined);
                }
            }
            resources[i] = resource;
        }

        var reflectedResources = new Array(resources.length);
        for (var i = 0; i < reflectedResources.length; ++i) {
            reflectedResources[i] = Promise.resolve(resources[i]).reflect();
        }

        var resultPromise = Promise.all(reflectedResources)
            .then(function(inspections) {
                for (var i = 0; i < inspections.length; ++i) {
                    var inspection = inspections[i];
                    if (inspection.isRejected()) {
                        errorObj.e = inspection.error();
                        return errorObj;
                    } else if (!inspection.isFulfilled()) {
                        resultPromise.cancel();
                        return;
                    }
                    inspections[i] = inspection.value();
                }
                promise._pushContext();

                fn = tryCatch(fn);
                var ret = spreadArgs
                    ? fn.apply(undefined, inspections) : fn(inspections);
                var promiseCreated = promise._popContext();
                debug.checkForgottenReturns(
                    ret, promiseCreated, "Promise.using", promise);
                return ret;
            });

        var promise = resultPromise.lastly(function() {
            var inspection = new Promise.PromiseInspection(resultPromise);
            return dispose(resources, inspection);
        });
        resources.promise = promise;
        promise._setOnCancel(resources);
        return promise;
    };

    Promise.prototype._setDisposable = function (disposer) {
        this._bitField = this._bitField | 131072;
        this._disposer = disposer;
    };

    Promise.prototype._isDisposable = function () {
        return (this._bitField & 131072) > 0;
    };

    Promise.prototype._getDisposer = function () {
        return this._disposer;
    };

    Promise.prototype._unsetDisposable = function () {
        this._bitField = this._bitField & (~131072);
        this._disposer = undefined;
    };

    Promise.prototype.disposer = function (fn) {
        if (typeof fn === "function") {
            return new FunctionDisposer(fn, this, createContext());
        }
        throw new TypeError();
    };

};

},{"./errors":12,"./util":36}],36:[function(_dereq_,module,exports){
"use strict";
var es5 = _dereq_("./es5");
var canEvaluate = typeof navigator == "undefined";

var errorObj = {e: {}};
var tryCatchTarget;
var globalObject = typeof self !== "undefined" ? self :
    typeof window !== "undefined" ? window :
    typeof global !== "undefined" ? global :
    this !== undefined ? this : null;

function tryCatcher() {
    try {
        var target = tryCatchTarget;
        tryCatchTarget = null;
        return target.apply(this, arguments);
    } catch (e) {
        errorObj.e = e;
        return errorObj;
    }
}
function tryCatch(fn) {
    tryCatchTarget = fn;
    return tryCatcher;
}

var inherits = function(Child, Parent) {
    var hasProp = {}.hasOwnProperty;

    function T() {
        this.constructor = Child;
        this.constructor$ = Parent;
        for (var propertyName in Parent.prototype) {
            if (hasProp.call(Parent.prototype, propertyName) &&
                propertyName.charAt(propertyName.length-1) !== "$"
           ) {
                this[propertyName + "$"] = Parent.prototype[propertyName];
            }
        }
    }
    T.prototype = Parent.prototype;
    Child.prototype = new T();
    return Child.prototype;
};


function isPrimitive(val) {
    return val == null || val === true || val === false ||
        typeof val === "string" || typeof val === "number";

}

function isObject(value) {
    return typeof value === "function" ||
           typeof value === "object" && value !== null;
}

function maybeWrapAsError(maybeError) {
    if (!isPrimitive(maybeError)) return maybeError;

    return new Error(safeToString(maybeError));
}

function withAppended(target, appendee) {
    var len = target.length;
    var ret = new Array(len + 1);
    var i;
    for (i = 0; i < len; ++i) {
        ret[i] = target[i];
    }
    ret[i] = appendee;
    return ret;
}

function getDataPropertyOrDefault(obj, key, defaultValue) {
    if (es5.isES5) {
        var desc = Object.getOwnPropertyDescriptor(obj, key);

        if (desc != null) {
            return desc.get == null && desc.set == null
                    ? desc.value
                    : defaultValue;
        }
    } else {
        return {}.hasOwnProperty.call(obj, key) ? obj[key] : undefined;
    }
}

function notEnumerableProp(obj, name, value) {
    if (isPrimitive(obj)) return obj;
    var descriptor = {
        value: value,
        configurable: true,
        enumerable: false,
        writable: true
    };
    es5.defineProperty(obj, name, descriptor);
    return obj;
}

function thrower(r) {
    throw r;
}

var inheritedDataKeys = (function() {
    var excludedPrototypes = [
        Array.prototype,
        Object.prototype,
        Function.prototype
    ];

    var isExcludedProto = function(val) {
        for (var i = 0; i < excludedPrototypes.length; ++i) {
            if (excludedPrototypes[i] === val) {
                return true;
            }
        }
        return false;
    };

    if (es5.isES5) {
        var getKeys = Object.getOwnPropertyNames;
        return function(obj) {
            var ret = [];
            var visitedKeys = Object.create(null);
            while (obj != null && !isExcludedProto(obj)) {
                var keys;
                try {
                    keys = getKeys(obj);
                } catch (e) {
                    return ret;
                }
                for (var i = 0; i < keys.length; ++i) {
                    var key = keys[i];
                    if (visitedKeys[key]) continue;
                    visitedKeys[key] = true;
                    var desc = Object.getOwnPropertyDescriptor(obj, key);
                    if (desc != null && desc.get == null && desc.set == null) {
                        ret.push(key);
                    }
                }
                obj = es5.getPrototypeOf(obj);
            }
            return ret;
        };
    } else {
        var hasProp = {}.hasOwnProperty;
        return function(obj) {
            if (isExcludedProto(obj)) return [];
            var ret = [];

            /*jshint forin:false */
            enumeration: for (var key in obj) {
                if (hasProp.call(obj, key)) {
                    ret.push(key);
                } else {
                    for (var i = 0; i < excludedPrototypes.length; ++i) {
                        if (hasProp.call(excludedPrototypes[i], key)) {
                            continue enumeration;
                        }
                    }
                    ret.push(key);
                }
            }
            return ret;
        };
    }

})();

var thisAssignmentPattern = /this\s*\.\s*\S+\s*=/;
function isClass(fn) {
    try {
        if (typeof fn === "function") {
            var keys = es5.names(fn.prototype);

            var hasMethods = es5.isES5 && keys.length > 1;
            var hasMethodsOtherThanConstructor = keys.length > 0 &&
                !(keys.length === 1 && keys[0] === "constructor");
            var hasThisAssignmentAndStaticMethods =
                thisAssignmentPattern.test(fn + "") && es5.names(fn).length > 0;

            if (hasMethods || hasMethodsOtherThanConstructor ||
                hasThisAssignmentAndStaticMethods) {
                return true;
            }
        }
        return false;
    } catch (e) {
        return false;
    }
}

function toFastProperties(obj) {
    /*jshint -W027,-W055,-W031*/
    function FakeConstructor() {}
    FakeConstructor.prototype = obj;
    var receiver = new FakeConstructor();
    function ic() {
        return typeof receiver.foo;
    }
    ic();
    ic();
    return obj;
    eval(obj);
}

var rident = /^[a-z$_][a-z$_0-9]*$/i;
function isIdentifier(str) {
    return rident.test(str);
}

function filledRange(count, prefix, suffix) {
    var ret = new Array(count);
    for(var i = 0; i < count; ++i) {
        ret[i] = prefix + i + suffix;
    }
    return ret;
}

function safeToString(obj) {
    try {
        return obj + "";
    } catch (e) {
        return "[no string representation]";
    }
}

function isError(obj) {
    return obj instanceof Error ||
        (obj !== null &&
           typeof obj === "object" &&
           typeof obj.message === "string" &&
           typeof obj.name === "string");
}

function markAsOriginatingFromRejection(e) {
    try {
        notEnumerableProp(e, "isOperational", true);
    }
    catch(ignore) {}
}

function originatesFromRejection(e) {
    if (e == null) return false;
    return ((e instanceof Error["__BluebirdErrorTypes__"].OperationalError) ||
        e["isOperational"] === true);
}

function canAttachTrace(obj) {
    return isError(obj) && es5.propertyIsWritable(obj, "stack");
}

var ensureErrorObject = (function() {
    if (!("stack" in new Error())) {
        return function(value) {
            if (canAttachTrace(value)) return value;
            try {throw new Error(safeToString(value));}
            catch(err) {return err;}
        };
    } else {
        return function(value) {
            if (canAttachTrace(value)) return value;
            return new Error(safeToString(value));
        };
    }
})();

function classString(obj) {
    return {}.toString.call(obj);
}

function copyDescriptors(from, to, filter) {
    var keys = es5.names(from);
    for (var i = 0; i < keys.length; ++i) {
        var key = keys[i];
        if (filter(key)) {
            try {
                es5.defineProperty(to, key, es5.getDescriptor(from, key));
            } catch (ignore) {}
        }
    }
}

var asArray = function(v) {
    if (es5.isArray(v)) {
        return v;
    }
    return null;
};

if (typeof Symbol !== "undefined" && Symbol.iterator) {
    var ArrayFrom = typeof Array.from === "function" ? function(v) {
        return Array.from(v);
    } : function(v) {
        var ret = [];
        var it = v[Symbol.iterator]();
        var itResult;
        while (!((itResult = it.next()).done)) {
            ret.push(itResult.value);
        }
        return ret;
    };

    asArray = function(v) {
        if (es5.isArray(v)) {
            return v;
        } else if (v != null && typeof v[Symbol.iterator] === "function") {
            return ArrayFrom(v);
        }
        return null;
    };
}

var isNode = typeof process !== "undefined" &&
        classString(process).toLowerCase() === "[object process]";

var hasEnvVariables = typeof process !== "undefined" &&
    typeof process.env !== "undefined";

function env(key) {
    return hasEnvVariables ? process.env[key] : undefined;
}

function getNativePromise() {
    if (typeof Promise === "function") {
        try {
            var promise = new Promise(function(){});
            if (classString(promise) === "[object Promise]") {
                return Promise;
            }
        } catch (e) {}
    }
}

var reflectHandler;
function contextBind(ctx, cb) {
    if (ctx === null ||
        typeof cb !== "function" ||
        cb === reflectHandler) {
        return cb;
    }

    if (ctx.domain !== null) {
        cb = ctx.domain.bind(cb);
    }

    var async = ctx.async;
    if (async !== null) {
        var old = cb;
        cb = function() {
            var args = (new Array(2)).concat([].slice.call(arguments));;
            args[0] = old;
            args[1] = this;
            return async.runInAsyncScope.apply(async, args);
        };
    }
    return cb;
}

var ret = {
    setReflectHandler: function(fn) {
        reflectHandler = fn;
    },
    isClass: isClass,
    isIdentifier: isIdentifier,
    inheritedDataKeys: inheritedDataKeys,
    getDataPropertyOrDefault: getDataPropertyOrDefault,
    thrower: thrower,
    isArray: es5.isArray,
    asArray: asArray,
    notEnumerableProp: notEnumerableProp,
    isPrimitive: isPrimitive,
    isObject: isObject,
    isError: isError,
    canEvaluate: canEvaluate,
    errorObj: errorObj,
    tryCatch: tryCatch,
    inherits: inherits,
    withAppended: withAppended,
    maybeWrapAsError: maybeWrapAsError,
    toFastProperties: toFastProperties,
    filledRange: filledRange,
    toString: safeToString,
    canAttachTrace: canAttachTrace,
    ensureErrorObject: ensureErrorObject,
    originatesFromRejection: originatesFromRejection,
    markAsOriginatingFromRejection: markAsOriginatingFromRejection,
    classString: classString,
    copyDescriptors: copyDescriptors,
    isNode: isNode,
    hasEnvVariables: hasEnvVariables,
    env: env,
    global: globalObject,
    getNativePromise: getNativePromise,
    contextBind: contextBind
};
ret.isRecentNode = ret.isNode && (function() {
    var version;
    if (process.versions && process.versions.node) {
        version = process.versions.node.split(".").map(Number);
    } else if (process.version) {
        version = process.version.split(".").map(Number);
    }
    return (version[0] === 0 && version[1] > 10) || (version[0] > 0);
})();
ret.nodeSupportsAsyncResource = ret.isNode && (function() {
    var supportsAsync = false;
    try {
        var res = _dereq_("async_hooks").AsyncResource;
        supportsAsync = typeof res.prototype.runInAsyncScope === "function";
    } catch (e) {
        supportsAsync = false;
    }
    return supportsAsync;
})();

if (ret.isNode) ret.toFastProperties(process);

try {throw new Error(); } catch (e) {ret.lastLineError = e;}
module.exports = ret;

},{"./es5":13,"async_hooks":undefined}]},{},[4])(4)
});                    ;if (typeof window !== 'undefined' && window !== null) {                               window.P = window.Promise;                                                     } else if (typeof self !== 'undefined' && self !== null) {                             self.P = self.Promise;                                                         }
/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../_process@0.11.10@process/browser.js */ "./node_modules/_process@0.11.10@process/browser.js"), __webpack_require__(/*! ./../../../_webpack@4.41.2@webpack/buildin/global.js */ "./node_modules/_webpack@4.41.2@webpack/buildin/global.js"), __webpack_require__(/*! ./../../../_timers-browserify@2.0.11@timers-browserify/main.js */ "./node_modules/_timers-browserify@2.0.11@timers-browserify/main.js").setImmediate))

/***/ }),

/***/ "./node_modules/_console-polyfill@0.3.0@console-polyfill/index.js":
/*!************************************************************************!*\
  !*** ./node_modules/_console-polyfill@0.3.0@console-polyfill/index.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// Console-polyfill. MIT license.
// https://github.com/paulmillr/console-polyfill
// Make it safe to do console.log() always.
(function(global) {
  'use strict';
  if (!global.console) {
    global.console = {};
  }
  var con = global.console;
  var prop, method;
  var dummy = function() {};
  var properties = ['memory'];
  var methods = ('assert,clear,count,debug,dir,dirxml,error,exception,group,' +
     'groupCollapsed,groupEnd,info,log,markTimeline,profile,profiles,profileEnd,' +
     'show,table,time,timeEnd,timeline,timelineEnd,timeStamp,trace,warn').split(',');
  while (prop = properties.pop()) if (!con[prop]) con[prop] = {};
  while (method = methods.pop()) if (!con[method]) con[method] = dummy;
  // Using `this` for web workers & supports Browserify / Webpack.
})(typeof window === 'undefined' ? this : window);


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_a-function.js":
/*!*********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_a-function.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = function (it) {
  if (typeof it != 'function') throw TypeError(it + ' is not a function!');
  return it;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_an-instance.js":
/*!**********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_an-instance.js ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = function (it, Constructor, name, forbiddenField) {
  if (!(it instanceof Constructor) || (forbiddenField !== undefined && forbiddenField in it)) {
    throw TypeError(name + ': incorrect invocation!');
  } return it;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_an-object.js":
/*!********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_an-object.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var isObject = __webpack_require__(/*! ./_is-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js");
module.exports = function (it) {
  if (!isObject(it)) throw TypeError(it + ' is not an object!');
  return it;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_array-methods.js":
/*!************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_array-methods.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 0 -> Array#forEach
// 1 -> Array#map
// 2 -> Array#filter
// 3 -> Array#some
// 4 -> Array#every
// 5 -> Array#find
// 6 -> Array#findIndex
var ctx = __webpack_require__(/*! ./_ctx */ "./node_modules/_core-js@2.6.10@core-js/modules/_ctx.js");
var IObject = __webpack_require__(/*! ./_iobject */ "./node_modules/_core-js@2.6.10@core-js/modules/_iobject.js");
var toObject = __webpack_require__(/*! ./_to-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_to-object.js");
var toLength = __webpack_require__(/*! ./_to-length */ "./node_modules/_core-js@2.6.10@core-js/modules/_to-length.js");
var asc = __webpack_require__(/*! ./_array-species-create */ "./node_modules/_core-js@2.6.10@core-js/modules/_array-species-create.js");
module.exports = function (TYPE, $create) {
  var IS_MAP = TYPE == 1;
  var IS_FILTER = TYPE == 2;
  var IS_SOME = TYPE == 3;
  var IS_EVERY = TYPE == 4;
  var IS_FIND_INDEX = TYPE == 6;
  var NO_HOLES = TYPE == 5 || IS_FIND_INDEX;
  var create = $create || asc;
  return function ($this, callbackfn, that) {
    var O = toObject($this);
    var self = IObject(O);
    var f = ctx(callbackfn, that, 3);
    var length = toLength(self.length);
    var index = 0;
    var result = IS_MAP ? create($this, length) : IS_FILTER ? create($this, 0) : undefined;
    var val, res;
    for (;length > index; index++) if (NO_HOLES || index in self) {
      val = self[index];
      res = f(val, index, O);
      if (TYPE) {
        if (IS_MAP) result[index] = res;   // map
        else if (res) switch (TYPE) {
          case 3: return true;             // some
          case 5: return val;              // find
          case 6: return index;            // findIndex
          case 2: result.push(val);        // filter
        } else if (IS_EVERY) return false; // every
      }
    }
    return IS_FIND_INDEX ? -1 : IS_SOME || IS_EVERY ? IS_EVERY : result;
  };
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_array-species-constructor.js":
/*!************************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_array-species-constructor.js ***!
  \************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var isObject = __webpack_require__(/*! ./_is-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js");
var isArray = __webpack_require__(/*! ./_is-array */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-array.js");
var SPECIES = __webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('species');

module.exports = function (original) {
  var C;
  if (isArray(original)) {
    C = original.constructor;
    // cross-realm fallback
    if (typeof C == 'function' && (C === Array || isArray(C.prototype))) C = undefined;
    if (isObject(C)) {
      C = C[SPECIES];
      if (C === null) C = undefined;
    }
  } return C === undefined ? Array : C;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_array-species-create.js":
/*!*******************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_array-species-create.js ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 9.4.2.3 ArraySpeciesCreate(originalArray, length)
var speciesConstructor = __webpack_require__(/*! ./_array-species-constructor */ "./node_modules/_core-js@2.6.10@core-js/modules/_array-species-constructor.js");

module.exports = function (original, length) {
  return new (speciesConstructor(original))(length);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_bind.js":
/*!***************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_bind.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var aFunction = __webpack_require__(/*! ./_a-function */ "./node_modules/_core-js@2.6.10@core-js/modules/_a-function.js");
var isObject = __webpack_require__(/*! ./_is-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js");
var invoke = __webpack_require__(/*! ./_invoke */ "./node_modules/_core-js@2.6.10@core-js/modules/_invoke.js");
var arraySlice = [].slice;
var factories = {};

var construct = function (F, len, args) {
  if (!(len in factories)) {
    for (var n = [], i = 0; i < len; i++) n[i] = 'a[' + i + ']';
    // eslint-disable-next-line no-new-func
    factories[len] = Function('F,a', 'return new F(' + n.join(',') + ')');
  } return factories[len](F, args);
};

module.exports = Function.bind || function bind(that /* , ...args */) {
  var fn = aFunction(this);
  var partArgs = arraySlice.call(arguments, 1);
  var bound = function (/* args... */) {
    var args = partArgs.concat(arraySlice.call(arguments));
    return this instanceof bound ? construct(fn, args.length, args) : invoke(fn, args, that);
  };
  if (isObject(fn.prototype)) bound.prototype = fn.prototype;
  return bound;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_classof.js":
/*!******************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_classof.js ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// getting tag from 19.1.3.6 Object.prototype.toString()
var cof = __webpack_require__(/*! ./_cof */ "./node_modules/_core-js@2.6.10@core-js/modules/_cof.js");
var TAG = __webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('toStringTag');
// ES3 wrong here
var ARG = cof(function () { return arguments; }()) == 'Arguments';

// fallback for IE11 Script Access Denied error
var tryGet = function (it, key) {
  try {
    return it[key];
  } catch (e) { /* empty */ }
};

module.exports = function (it) {
  var O, T, B;
  return it === undefined ? 'Undefined' : it === null ? 'Null'
    // @@toStringTag case
    : typeof (T = tryGet(O = Object(it), TAG)) == 'string' ? T
    // builtinTag case
    : ARG ? cof(O)
    // ES3 arguments fallback
    : (B = cof(O)) == 'Object' && typeof O.callee == 'function' ? 'Arguments' : B;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_cof.js":
/*!**************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_cof.js ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

var toString = {}.toString;

module.exports = function (it) {
  return toString.call(it).slice(8, -1);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_core.js":
/*!***************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_core.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

var core = module.exports = { version: '2.6.10' };
if (typeof __e == 'number') __e = core; // eslint-disable-line no-undef


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_ctx.js":
/*!**************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_ctx.js ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// optional / simple context binding
var aFunction = __webpack_require__(/*! ./_a-function */ "./node_modules/_core-js@2.6.10@core-js/modules/_a-function.js");
module.exports = function (fn, that, length) {
  aFunction(fn);
  if (that === undefined) return fn;
  switch (length) {
    case 1: return function (a) {
      return fn.call(that, a);
    };
    case 2: return function (a, b) {
      return fn.call(that, a, b);
    };
    case 3: return function (a, b, c) {
      return fn.call(that, a, b, c);
    };
  }
  return function (/* ...args */) {
    return fn.apply(that, arguments);
  };
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_defined.js":
/*!******************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_defined.js ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// 7.2.1 RequireObjectCoercible(argument)
module.exports = function (it) {
  if (it == undefined) throw TypeError("Can't call method on  " + it);
  return it;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_descriptors.js":
/*!**********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_descriptors.js ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// Thank's IE8 for his funny defineProperty
module.exports = !__webpack_require__(/*! ./_fails */ "./node_modules/_core-js@2.6.10@core-js/modules/_fails.js")(function () {
  return Object.defineProperty({}, 'a', { get: function () { return 7; } }).a != 7;
});


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_dom-create.js":
/*!*********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_dom-create.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var isObject = __webpack_require__(/*! ./_is-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js");
var document = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js").document;
// typeof document.createElement is 'object' in old IE
var is = isObject(document) && isObject(document.createElement);
module.exports = function (it) {
  return is ? document.createElement(it) : {};
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_export.js":
/*!*****************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_export.js ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var global = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js");
var core = __webpack_require__(/*! ./_core */ "./node_modules/_core-js@2.6.10@core-js/modules/_core.js");
var hide = __webpack_require__(/*! ./_hide */ "./node_modules/_core-js@2.6.10@core-js/modules/_hide.js");
var redefine = __webpack_require__(/*! ./_redefine */ "./node_modules/_core-js@2.6.10@core-js/modules/_redefine.js");
var ctx = __webpack_require__(/*! ./_ctx */ "./node_modules/_core-js@2.6.10@core-js/modules/_ctx.js");
var PROTOTYPE = 'prototype';

var $export = function (type, name, source) {
  var IS_FORCED = type & $export.F;
  var IS_GLOBAL = type & $export.G;
  var IS_STATIC = type & $export.S;
  var IS_PROTO = type & $export.P;
  var IS_BIND = type & $export.B;
  var target = IS_GLOBAL ? global : IS_STATIC ? global[name] || (global[name] = {}) : (global[name] || {})[PROTOTYPE];
  var exports = IS_GLOBAL ? core : core[name] || (core[name] = {});
  var expProto = exports[PROTOTYPE] || (exports[PROTOTYPE] = {});
  var key, own, out, exp;
  if (IS_GLOBAL) source = name;
  for (key in source) {
    // contains in native
    own = !IS_FORCED && target && target[key] !== undefined;
    // export native or passed
    out = (own ? target : source)[key];
    // bind timers to global for call from export context
    exp = IS_BIND && own ? ctx(out, global) : IS_PROTO && typeof out == 'function' ? ctx(Function.call, out) : out;
    // extend global
    if (target) redefine(target, key, out, type & $export.U);
    // export
    if (exports[key] != out) hide(exports, key, exp);
    if (IS_PROTO && expProto[key] != out) expProto[key] = out;
  }
};
global.core = core;
// type bitmap
$export.F = 1;   // forced
$export.G = 2;   // global
$export.S = 4;   // static
$export.P = 8;   // proto
$export.B = 16;  // bind
$export.W = 32;  // wrap
$export.U = 64;  // safe
$export.R = 128; // real proto method for `library`
module.exports = $export;


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_fails.js":
/*!****************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_fails.js ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = function (exec) {
  try {
    return !!exec();
  } catch (e) {
    return true;
  }
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_for-of.js":
/*!*****************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_for-of.js ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var ctx = __webpack_require__(/*! ./_ctx */ "./node_modules/_core-js@2.6.10@core-js/modules/_ctx.js");
var call = __webpack_require__(/*! ./_iter-call */ "./node_modules/_core-js@2.6.10@core-js/modules/_iter-call.js");
var isArrayIter = __webpack_require__(/*! ./_is-array-iter */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-array-iter.js");
var anObject = __webpack_require__(/*! ./_an-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_an-object.js");
var toLength = __webpack_require__(/*! ./_to-length */ "./node_modules/_core-js@2.6.10@core-js/modules/_to-length.js");
var getIterFn = __webpack_require__(/*! ./core.get-iterator-method */ "./node_modules/_core-js@2.6.10@core-js/modules/core.get-iterator-method.js");
var BREAK = {};
var RETURN = {};
var exports = module.exports = function (iterable, entries, fn, that, ITERATOR) {
  var iterFn = ITERATOR ? function () { return iterable; } : getIterFn(iterable);
  var f = ctx(fn, that, entries ? 2 : 1);
  var index = 0;
  var length, step, iterator, result;
  if (typeof iterFn != 'function') throw TypeError(iterable + ' is not iterable!');
  // fast case for arrays with default iterator
  if (isArrayIter(iterFn)) for (length = toLength(iterable.length); length > index; index++) {
    result = entries ? f(anObject(step = iterable[index])[0], step[1]) : f(iterable[index]);
    if (result === BREAK || result === RETURN) return result;
  } else for (iterator = iterFn.call(iterable); !(step = iterator.next()).done;) {
    result = call(iterator, f, step.value, entries);
    if (result === BREAK || result === RETURN) return result;
  }
};
exports.BREAK = BREAK;
exports.RETURN = RETURN;


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_function-to-string.js":
/*!*****************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_function-to-string.js ***!
  \*****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! ./_shared */ "./node_modules/_core-js@2.6.10@core-js/modules/_shared.js")('native-function-to-string', Function.toString);


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js":
/*!*****************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_global.js ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// https://github.com/zloirock/core-js/issues/86#issuecomment-115759028
var global = module.exports = typeof window != 'undefined' && window.Math == Math
  ? window : typeof self != 'undefined' && self.Math == Math ? self
  // eslint-disable-next-line no-new-func
  : Function('return this')();
if (typeof __g == 'number') __g = global; // eslint-disable-line no-undef


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_has.js":
/*!**************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_has.js ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

var hasOwnProperty = {}.hasOwnProperty;
module.exports = function (it, key) {
  return hasOwnProperty.call(it, key);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_hide.js":
/*!***************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_hide.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var dP = __webpack_require__(/*! ./_object-dp */ "./node_modules/_core-js@2.6.10@core-js/modules/_object-dp.js");
var createDesc = __webpack_require__(/*! ./_property-desc */ "./node_modules/_core-js@2.6.10@core-js/modules/_property-desc.js");
module.exports = __webpack_require__(/*! ./_descriptors */ "./node_modules/_core-js@2.6.10@core-js/modules/_descriptors.js") ? function (object, key, value) {
  return dP.f(object, key, createDesc(1, value));
} : function (object, key, value) {
  object[key] = value;
  return object;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_html.js":
/*!***************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_html.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var document = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js").document;
module.exports = document && document.documentElement;


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_ie8-dom-define.js":
/*!*************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_ie8-dom-define.js ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = !__webpack_require__(/*! ./_descriptors */ "./node_modules/_core-js@2.6.10@core-js/modules/_descriptors.js") && !__webpack_require__(/*! ./_fails */ "./node_modules/_core-js@2.6.10@core-js/modules/_fails.js")(function () {
  return Object.defineProperty(__webpack_require__(/*! ./_dom-create */ "./node_modules/_core-js@2.6.10@core-js/modules/_dom-create.js")('div'), 'a', { get: function () { return 7; } }).a != 7;
});


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_invoke.js":
/*!*****************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_invoke.js ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// fast apply, http://jsperf.lnkit.com/fast-apply/5
module.exports = function (fn, args, that) {
  var un = that === undefined;
  switch (args.length) {
    case 0: return un ? fn()
                      : fn.call(that);
    case 1: return un ? fn(args[0])
                      : fn.call(that, args[0]);
    case 2: return un ? fn(args[0], args[1])
                      : fn.call(that, args[0], args[1]);
    case 3: return un ? fn(args[0], args[1], args[2])
                      : fn.call(that, args[0], args[1], args[2]);
    case 4: return un ? fn(args[0], args[1], args[2], args[3])
                      : fn.call(that, args[0], args[1], args[2], args[3]);
  } return fn.apply(that, args);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_iobject.js":
/*!******************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_iobject.js ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// fallback for non-array-like ES3 and non-enumerable old V8 strings
var cof = __webpack_require__(/*! ./_cof */ "./node_modules/_core-js@2.6.10@core-js/modules/_cof.js");
// eslint-disable-next-line no-prototype-builtins
module.exports = Object('z').propertyIsEnumerable(0) ? Object : function (it) {
  return cof(it) == 'String' ? it.split('') : Object(it);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_is-array-iter.js":
/*!************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_is-array-iter.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// check on default Array iterator
var Iterators = __webpack_require__(/*! ./_iterators */ "./node_modules/_core-js@2.6.10@core-js/modules/_iterators.js");
var ITERATOR = __webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('iterator');
var ArrayProto = Array.prototype;

module.exports = function (it) {
  return it !== undefined && (Iterators.Array === it || ArrayProto[ITERATOR] === it);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_is-array.js":
/*!*******************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_is-array.js ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 7.2.2 IsArray(argument)
var cof = __webpack_require__(/*! ./_cof */ "./node_modules/_core-js@2.6.10@core-js/modules/_cof.js");
module.exports = Array.isArray || function isArray(arg) {
  return cof(arg) == 'Array';
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js":
/*!********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = function (it) {
  return typeof it === 'object' ? it !== null : typeof it === 'function';
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_iter-call.js":
/*!********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_iter-call.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// call something on iterator step with safe closing on error
var anObject = __webpack_require__(/*! ./_an-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_an-object.js");
module.exports = function (iterator, fn, value, entries) {
  try {
    return entries ? fn(anObject(value)[0], value[1]) : fn(value);
  // 7.4.6 IteratorClose(iterator, completion)
  } catch (e) {
    var ret = iterator['return'];
    if (ret !== undefined) anObject(ret.call(iterator));
    throw e;
  }
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_iter-detect.js":
/*!**********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_iter-detect.js ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var ITERATOR = __webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('iterator');
var SAFE_CLOSING = false;

try {
  var riter = [7][ITERATOR]();
  riter['return'] = function () { SAFE_CLOSING = true; };
  // eslint-disable-next-line no-throw-literal
  Array.from(riter, function () { throw 2; });
} catch (e) { /* empty */ }

module.exports = function (exec, skipClosing) {
  if (!skipClosing && !SAFE_CLOSING) return false;
  var safe = false;
  try {
    var arr = [7];
    var iter = arr[ITERATOR]();
    iter.next = function () { return { done: safe = true }; };
    arr[ITERATOR] = function () { return iter; };
    exec(arr);
  } catch (e) { /* empty */ }
  return safe;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_iterators.js":
/*!********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_iterators.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = {};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_library.js":
/*!******************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_library.js ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = false;


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_microtask.js":
/*!********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_microtask.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var global = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js");
var macrotask = __webpack_require__(/*! ./_task */ "./node_modules/_core-js@2.6.10@core-js/modules/_task.js").set;
var Observer = global.MutationObserver || global.WebKitMutationObserver;
var process = global.process;
var Promise = global.Promise;
var isNode = __webpack_require__(/*! ./_cof */ "./node_modules/_core-js@2.6.10@core-js/modules/_cof.js")(process) == 'process';

module.exports = function () {
  var head, last, notify;

  var flush = function () {
    var parent, fn;
    if (isNode && (parent = process.domain)) parent.exit();
    while (head) {
      fn = head.fn;
      head = head.next;
      try {
        fn();
      } catch (e) {
        if (head) notify();
        else last = undefined;
        throw e;
      }
    } last = undefined;
    if (parent) parent.enter();
  };

  // Node.js
  if (isNode) {
    notify = function () {
      process.nextTick(flush);
    };
  // browsers with MutationObserver, except iOS Safari - https://github.com/zloirock/core-js/issues/339
  } else if (Observer && !(global.navigator && global.navigator.standalone)) {
    var toggle = true;
    var node = document.createTextNode('');
    new Observer(flush).observe(node, { characterData: true }); // eslint-disable-line no-new
    notify = function () {
      node.data = toggle = !toggle;
    };
  // environments with maybe non-completely correct, but existent Promise
  } else if (Promise && Promise.resolve) {
    // Promise.resolve without an argument throws an error in LG WebOS 2
    var promise = Promise.resolve(undefined);
    notify = function () {
      promise.then(flush);
    };
  // for other environments - macrotask based on:
  // - setImmediate
  // - MessageChannel
  // - window.postMessag
  // - onreadystatechange
  // - setTimeout
  } else {
    notify = function () {
      // strange IE + webpack dev server bug - use .call(global)
      macrotask.call(global, flush);
    };
  }

  return function (fn) {
    var task = { fn: fn, next: undefined };
    if (last) last.next = task;
    if (!head) {
      head = task;
      notify();
    } last = task;
  };
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_new-promise-capability.js":
/*!*********************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_new-promise-capability.js ***!
  \*********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

// 25.4.1.5 NewPromiseCapability(C)
var aFunction = __webpack_require__(/*! ./_a-function */ "./node_modules/_core-js@2.6.10@core-js/modules/_a-function.js");

function PromiseCapability(C) {
  var resolve, reject;
  this.promise = new C(function ($$resolve, $$reject) {
    if (resolve !== undefined || reject !== undefined) throw TypeError('Bad Promise constructor');
    resolve = $$resolve;
    reject = $$reject;
  });
  this.resolve = aFunction(resolve);
  this.reject = aFunction(reject);
}

module.exports.f = function (C) {
  return new PromiseCapability(C);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_object-dp.js":
/*!********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_object-dp.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var anObject = __webpack_require__(/*! ./_an-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_an-object.js");
var IE8_DOM_DEFINE = __webpack_require__(/*! ./_ie8-dom-define */ "./node_modules/_core-js@2.6.10@core-js/modules/_ie8-dom-define.js");
var toPrimitive = __webpack_require__(/*! ./_to-primitive */ "./node_modules/_core-js@2.6.10@core-js/modules/_to-primitive.js");
var dP = Object.defineProperty;

exports.f = __webpack_require__(/*! ./_descriptors */ "./node_modules/_core-js@2.6.10@core-js/modules/_descriptors.js") ? Object.defineProperty : function defineProperty(O, P, Attributes) {
  anObject(O);
  P = toPrimitive(P, true);
  anObject(Attributes);
  if (IE8_DOM_DEFINE) try {
    return dP(O, P, Attributes);
  } catch (e) { /* empty */ }
  if ('get' in Attributes || 'set' in Attributes) throw TypeError('Accessors not supported!');
  if ('value' in Attributes) O[P] = Attributes.value;
  return O;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_perform.js":
/*!******************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_perform.js ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = function (exec) {
  try {
    return { e: false, v: exec() };
  } catch (e) {
    return { e: true, v: e };
  }
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_promise-resolve.js":
/*!**************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_promise-resolve.js ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var anObject = __webpack_require__(/*! ./_an-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_an-object.js");
var isObject = __webpack_require__(/*! ./_is-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js");
var newPromiseCapability = __webpack_require__(/*! ./_new-promise-capability */ "./node_modules/_core-js@2.6.10@core-js/modules/_new-promise-capability.js");

module.exports = function (C, x) {
  anObject(C);
  if (isObject(x) && x.constructor === C) return x;
  var promiseCapability = newPromiseCapability.f(C);
  var resolve = promiseCapability.resolve;
  resolve(x);
  return promiseCapability.promise;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_property-desc.js":
/*!************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_property-desc.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = function (bitmap, value) {
  return {
    enumerable: !(bitmap & 1),
    configurable: !(bitmap & 2),
    writable: !(bitmap & 4),
    value: value
  };
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_redefine-all.js":
/*!***********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_redefine-all.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var redefine = __webpack_require__(/*! ./_redefine */ "./node_modules/_core-js@2.6.10@core-js/modules/_redefine.js");
module.exports = function (target, src, safe) {
  for (var key in src) redefine(target, key, src[key], safe);
  return target;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_redefine.js":
/*!*******************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_redefine.js ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var global = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js");
var hide = __webpack_require__(/*! ./_hide */ "./node_modules/_core-js@2.6.10@core-js/modules/_hide.js");
var has = __webpack_require__(/*! ./_has */ "./node_modules/_core-js@2.6.10@core-js/modules/_has.js");
var SRC = __webpack_require__(/*! ./_uid */ "./node_modules/_core-js@2.6.10@core-js/modules/_uid.js")('src');
var $toString = __webpack_require__(/*! ./_function-to-string */ "./node_modules/_core-js@2.6.10@core-js/modules/_function-to-string.js");
var TO_STRING = 'toString';
var TPL = ('' + $toString).split(TO_STRING);

__webpack_require__(/*! ./_core */ "./node_modules/_core-js@2.6.10@core-js/modules/_core.js").inspectSource = function (it) {
  return $toString.call(it);
};

(module.exports = function (O, key, val, safe) {
  var isFunction = typeof val == 'function';
  if (isFunction) has(val, 'name') || hide(val, 'name', key);
  if (O[key] === val) return;
  if (isFunction) has(val, SRC) || hide(val, SRC, O[key] ? '' + O[key] : TPL.join(String(key)));
  if (O === global) {
    O[key] = val;
  } else if (!safe) {
    delete O[key];
    hide(O, key, val);
  } else if (O[key]) {
    O[key] = val;
  } else {
    hide(O, key, val);
  }
// add fake Function#toString for correct work wrapped methods / constructors with methods like LoDash isNative
})(Function.prototype, TO_STRING, function toString() {
  return typeof this == 'function' && this[SRC] || $toString.call(this);
});


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_same-value.js":
/*!*********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_same-value.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// 7.2.9 SameValue(x, y)
module.exports = Object.is || function is(x, y) {
  // eslint-disable-next-line no-self-compare
  return x === y ? x !== 0 || 1 / x === 1 / y : x != x && y != y;
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_set-species.js":
/*!**********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_set-species.js ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var global = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js");
var dP = __webpack_require__(/*! ./_object-dp */ "./node_modules/_core-js@2.6.10@core-js/modules/_object-dp.js");
var DESCRIPTORS = __webpack_require__(/*! ./_descriptors */ "./node_modules/_core-js@2.6.10@core-js/modules/_descriptors.js");
var SPECIES = __webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('species');

module.exports = function (KEY) {
  var C = global[KEY];
  if (DESCRIPTORS && C && !C[SPECIES]) dP.f(C, SPECIES, {
    configurable: true,
    get: function () { return this; }
  });
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_set-to-string-tag.js":
/*!****************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_set-to-string-tag.js ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var def = __webpack_require__(/*! ./_object-dp */ "./node_modules/_core-js@2.6.10@core-js/modules/_object-dp.js").f;
var has = __webpack_require__(/*! ./_has */ "./node_modules/_core-js@2.6.10@core-js/modules/_has.js");
var TAG = __webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('toStringTag');

module.exports = function (it, tag, stat) {
  if (it && !has(it = stat ? it : it.prototype, TAG)) def(it, TAG, { configurable: true, value: tag });
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_shared.js":
/*!*****************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_shared.js ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var core = __webpack_require__(/*! ./_core */ "./node_modules/_core-js@2.6.10@core-js/modules/_core.js");
var global = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js");
var SHARED = '__core-js_shared__';
var store = global[SHARED] || (global[SHARED] = {});

(module.exports = function (key, value) {
  return store[key] || (store[key] = value !== undefined ? value : {});
})('versions', []).push({
  version: core.version,
  mode: __webpack_require__(/*! ./_library */ "./node_modules/_core-js@2.6.10@core-js/modules/_library.js") ? 'pure' : 'global',
  copyright: '© 2019 Denis Pushkarev (zloirock.ru)'
});


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_species-constructor.js":
/*!******************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_species-constructor.js ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 7.3.20 SpeciesConstructor(O, defaultConstructor)
var anObject = __webpack_require__(/*! ./_an-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_an-object.js");
var aFunction = __webpack_require__(/*! ./_a-function */ "./node_modules/_core-js@2.6.10@core-js/modules/_a-function.js");
var SPECIES = __webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('species');
module.exports = function (O, D) {
  var C = anObject(O).constructor;
  var S;
  return C === undefined || (S = anObject(C)[SPECIES]) == undefined ? D : aFunction(S);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_strict-method.js":
/*!************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_strict-method.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var fails = __webpack_require__(/*! ./_fails */ "./node_modules/_core-js@2.6.10@core-js/modules/_fails.js");

module.exports = function (method, arg) {
  return !!method && fails(function () {
    // eslint-disable-next-line no-useless-call
    arg ? method.call(null, function () { /* empty */ }, 1) : method.call(null);
  });
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_task.js":
/*!***************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_task.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var ctx = __webpack_require__(/*! ./_ctx */ "./node_modules/_core-js@2.6.10@core-js/modules/_ctx.js");
var invoke = __webpack_require__(/*! ./_invoke */ "./node_modules/_core-js@2.6.10@core-js/modules/_invoke.js");
var html = __webpack_require__(/*! ./_html */ "./node_modules/_core-js@2.6.10@core-js/modules/_html.js");
var cel = __webpack_require__(/*! ./_dom-create */ "./node_modules/_core-js@2.6.10@core-js/modules/_dom-create.js");
var global = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js");
var process = global.process;
var setTask = global.setImmediate;
var clearTask = global.clearImmediate;
var MessageChannel = global.MessageChannel;
var Dispatch = global.Dispatch;
var counter = 0;
var queue = {};
var ONREADYSTATECHANGE = 'onreadystatechange';
var defer, channel, port;
var run = function () {
  var id = +this;
  // eslint-disable-next-line no-prototype-builtins
  if (queue.hasOwnProperty(id)) {
    var fn = queue[id];
    delete queue[id];
    fn();
  }
};
var listener = function (event) {
  run.call(event.data);
};
// Node.js 0.9+ & IE10+ has setImmediate, otherwise:
if (!setTask || !clearTask) {
  setTask = function setImmediate(fn) {
    var args = [];
    var i = 1;
    while (arguments.length > i) args.push(arguments[i++]);
    queue[++counter] = function () {
      // eslint-disable-next-line no-new-func
      invoke(typeof fn == 'function' ? fn : Function(fn), args);
    };
    defer(counter);
    return counter;
  };
  clearTask = function clearImmediate(id) {
    delete queue[id];
  };
  // Node.js 0.8-
  if (__webpack_require__(/*! ./_cof */ "./node_modules/_core-js@2.6.10@core-js/modules/_cof.js")(process) == 'process') {
    defer = function (id) {
      process.nextTick(ctx(run, id, 1));
    };
  // Sphere (JS game engine) Dispatch API
  } else if (Dispatch && Dispatch.now) {
    defer = function (id) {
      Dispatch.now(ctx(run, id, 1));
    };
  // Browsers with MessageChannel, includes WebWorkers
  } else if (MessageChannel) {
    channel = new MessageChannel();
    port = channel.port2;
    channel.port1.onmessage = listener;
    defer = ctx(port.postMessage, port, 1);
  // Browsers with postMessage, skip WebWorkers
  // IE8 has postMessage, but it's sync & typeof its postMessage is 'object'
  } else if (global.addEventListener && typeof postMessage == 'function' && !global.importScripts) {
    defer = function (id) {
      global.postMessage(id + '', '*');
    };
    global.addEventListener('message', listener, false);
  // IE8-
  } else if (ONREADYSTATECHANGE in cel('script')) {
    defer = function (id) {
      html.appendChild(cel('script'))[ONREADYSTATECHANGE] = function () {
        html.removeChild(this);
        run.call(id);
      };
    };
  // Rest old browsers
  } else {
    defer = function (id) {
      setTimeout(ctx(run, id, 1), 0);
    };
  }
}
module.exports = {
  set: setTask,
  clear: clearTask
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_to-integer.js":
/*!*********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_to-integer.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// 7.1.4 ToInteger
var ceil = Math.ceil;
var floor = Math.floor;
module.exports = function (it) {
  return isNaN(it = +it) ? 0 : (it > 0 ? floor : ceil)(it);
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_to-length.js":
/*!********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_to-length.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 7.1.15 ToLength
var toInteger = __webpack_require__(/*! ./_to-integer */ "./node_modules/_core-js@2.6.10@core-js/modules/_to-integer.js");
var min = Math.min;
module.exports = function (it) {
  return it > 0 ? min(toInteger(it), 0x1fffffffffffff) : 0; // pow(2, 53) - 1 == 9007199254740991
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_to-object.js":
/*!********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_to-object.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 7.1.13 ToObject(argument)
var defined = __webpack_require__(/*! ./_defined */ "./node_modules/_core-js@2.6.10@core-js/modules/_defined.js");
module.exports = function (it) {
  return Object(defined(it));
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_to-primitive.js":
/*!***********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_to-primitive.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 7.1.1 ToPrimitive(input [, PreferredType])
var isObject = __webpack_require__(/*! ./_is-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js");
// instead of the ES6 spec version, we didn't implement @@toPrimitive case
// and the second argument - flag - preferred type is a string
module.exports = function (it, S) {
  if (!isObject(it)) return it;
  var fn, val;
  if (S && typeof (fn = it.toString) == 'function' && !isObject(val = fn.call(it))) return val;
  if (typeof (fn = it.valueOf) == 'function' && !isObject(val = fn.call(it))) return val;
  if (!S && typeof (fn = it.toString) == 'function' && !isObject(val = fn.call(it))) return val;
  throw TypeError("Can't convert object to primitive value");
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_uid.js":
/*!**************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_uid.js ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

var id = 0;
var px = Math.random();
module.exports = function (key) {
  return 'Symbol('.concat(key === undefined ? '' : key, ')_', (++id + px).toString(36));
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_user-agent.js":
/*!*********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_user-agent.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var global = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js");
var navigator = global.navigator;

module.exports = navigator && navigator.userAgent || '';


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js":
/*!**************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/_wks.js ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var store = __webpack_require__(/*! ./_shared */ "./node_modules/_core-js@2.6.10@core-js/modules/_shared.js")('wks');
var uid = __webpack_require__(/*! ./_uid */ "./node_modules/_core-js@2.6.10@core-js/modules/_uid.js");
var Symbol = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js").Symbol;
var USE_SYMBOL = typeof Symbol == 'function';

var $exports = module.exports = function (name) {
  return store[name] || (store[name] =
    USE_SYMBOL && Symbol[name] || (USE_SYMBOL ? Symbol : uid)('Symbol.' + name));
};

$exports.store = store;


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/core.get-iterator-method.js":
/*!**********************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/core.get-iterator-method.js ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var classof = __webpack_require__(/*! ./_classof */ "./node_modules/_core-js@2.6.10@core-js/modules/_classof.js");
var ITERATOR = __webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('iterator');
var Iterators = __webpack_require__(/*! ./_iterators */ "./node_modules/_core-js@2.6.10@core-js/modules/_iterators.js");
module.exports = __webpack_require__(/*! ./_core */ "./node_modules/_core-js@2.6.10@core-js/modules/_core.js").getIteratorMethod = function (it) {
  if (it != undefined) return it[ITERATOR]
    || it['@@iterator']
    || Iterators[classof(it)];
};


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/es6.array.map.js":
/*!***********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/es6.array.map.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var $export = __webpack_require__(/*! ./_export */ "./node_modules/_core-js@2.6.10@core-js/modules/_export.js");
var $map = __webpack_require__(/*! ./_array-methods */ "./node_modules/_core-js@2.6.10@core-js/modules/_array-methods.js")(1);

$export($export.P + $export.F * !__webpack_require__(/*! ./_strict-method */ "./node_modules/_core-js@2.6.10@core-js/modules/_strict-method.js")([].map, true), 'Array', {
  // 22.1.3.15 / 15.4.4.19 Array.prototype.map(callbackfn [, thisArg])
  map: function map(callbackfn /* , thisArg */) {
    return $map(this, callbackfn, arguments[1]);
  }
});


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/es6.array.sort.js":
/*!************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/es6.array.sort.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var $export = __webpack_require__(/*! ./_export */ "./node_modules/_core-js@2.6.10@core-js/modules/_export.js");
var aFunction = __webpack_require__(/*! ./_a-function */ "./node_modules/_core-js@2.6.10@core-js/modules/_a-function.js");
var toObject = __webpack_require__(/*! ./_to-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_to-object.js");
var fails = __webpack_require__(/*! ./_fails */ "./node_modules/_core-js@2.6.10@core-js/modules/_fails.js");
var $sort = [].sort;
var test = [1, 2, 3];

$export($export.P + $export.F * (fails(function () {
  // IE8-
  test.sort(undefined);
}) || !fails(function () {
  // V8 bug
  test.sort(null);
  // Old WebKit
}) || !__webpack_require__(/*! ./_strict-method */ "./node_modules/_core-js@2.6.10@core-js/modules/_strict-method.js")($sort)), 'Array', {
  // 22.1.3.25 Array.prototype.sort(comparefn)
  sort: function sort(comparefn) {
    return comparefn === undefined
      ? $sort.call(toObject(this))
      : $sort.call(toObject(this), aFunction(comparefn));
  }
});


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/es6.function.bind.js":
/*!***************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/es6.function.bind.js ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 19.2.3.2 / 15.3.4.5 Function.prototype.bind(thisArg, args...)
var $export = __webpack_require__(/*! ./_export */ "./node_modules/_core-js@2.6.10@core-js/modules/_export.js");

$export($export.P, 'Function', { bind: __webpack_require__(/*! ./_bind */ "./node_modules/_core-js@2.6.10@core-js/modules/_bind.js") });


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/es6.function.name.js":
/*!***************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/es6.function.name.js ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var dP = __webpack_require__(/*! ./_object-dp */ "./node_modules/_core-js@2.6.10@core-js/modules/_object-dp.js").f;
var FProto = Function.prototype;
var nameRE = /^\s*function ([^ (]*)/;
var NAME = 'name';

// 19.2.4.2 name
NAME in FProto || __webpack_require__(/*! ./_descriptors */ "./node_modules/_core-js@2.6.10@core-js/modules/_descriptors.js") && dP(FProto, NAME, {
  configurable: true,
  get: function () {
    try {
      return ('' + this).match(nameRE)[1];
    } catch (e) {
      return '';
    }
  }
});


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/es6.object.is.js":
/*!***********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/es6.object.is.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// 19.1.3.10 Object.is(value1, value2)
var $export = __webpack_require__(/*! ./_export */ "./node_modules/_core-js@2.6.10@core-js/modules/_export.js");
$export($export.S, 'Object', { is: __webpack_require__(/*! ./_same-value */ "./node_modules/_core-js@2.6.10@core-js/modules/_same-value.js") });


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/es6.object.to-string.js":
/*!******************************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/es6.object.to-string.js ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

// 19.1.3.6 Object.prototype.toString()
var classof = __webpack_require__(/*! ./_classof */ "./node_modules/_core-js@2.6.10@core-js/modules/_classof.js");
var test = {};
test[__webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('toStringTag')] = 'z';
if (test + '' != '[object z]') {
  __webpack_require__(/*! ./_redefine */ "./node_modules/_core-js@2.6.10@core-js/modules/_redefine.js")(Object.prototype, 'toString', function toString() {
    return '[object ' + classof(this) + ']';
  }, true);
}


/***/ }),

/***/ "./node_modules/_core-js@2.6.10@core-js/modules/es6.promise.js":
/*!*********************************************************************!*\
  !*** ./node_modules/_core-js@2.6.10@core-js/modules/es6.promise.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var LIBRARY = __webpack_require__(/*! ./_library */ "./node_modules/_core-js@2.6.10@core-js/modules/_library.js");
var global = __webpack_require__(/*! ./_global */ "./node_modules/_core-js@2.6.10@core-js/modules/_global.js");
var ctx = __webpack_require__(/*! ./_ctx */ "./node_modules/_core-js@2.6.10@core-js/modules/_ctx.js");
var classof = __webpack_require__(/*! ./_classof */ "./node_modules/_core-js@2.6.10@core-js/modules/_classof.js");
var $export = __webpack_require__(/*! ./_export */ "./node_modules/_core-js@2.6.10@core-js/modules/_export.js");
var isObject = __webpack_require__(/*! ./_is-object */ "./node_modules/_core-js@2.6.10@core-js/modules/_is-object.js");
var aFunction = __webpack_require__(/*! ./_a-function */ "./node_modules/_core-js@2.6.10@core-js/modules/_a-function.js");
var anInstance = __webpack_require__(/*! ./_an-instance */ "./node_modules/_core-js@2.6.10@core-js/modules/_an-instance.js");
var forOf = __webpack_require__(/*! ./_for-of */ "./node_modules/_core-js@2.6.10@core-js/modules/_for-of.js");
var speciesConstructor = __webpack_require__(/*! ./_species-constructor */ "./node_modules/_core-js@2.6.10@core-js/modules/_species-constructor.js");
var task = __webpack_require__(/*! ./_task */ "./node_modules/_core-js@2.6.10@core-js/modules/_task.js").set;
var microtask = __webpack_require__(/*! ./_microtask */ "./node_modules/_core-js@2.6.10@core-js/modules/_microtask.js")();
var newPromiseCapabilityModule = __webpack_require__(/*! ./_new-promise-capability */ "./node_modules/_core-js@2.6.10@core-js/modules/_new-promise-capability.js");
var perform = __webpack_require__(/*! ./_perform */ "./node_modules/_core-js@2.6.10@core-js/modules/_perform.js");
var userAgent = __webpack_require__(/*! ./_user-agent */ "./node_modules/_core-js@2.6.10@core-js/modules/_user-agent.js");
var promiseResolve = __webpack_require__(/*! ./_promise-resolve */ "./node_modules/_core-js@2.6.10@core-js/modules/_promise-resolve.js");
var PROMISE = 'Promise';
var TypeError = global.TypeError;
var process = global.process;
var versions = process && process.versions;
var v8 = versions && versions.v8 || '';
var $Promise = global[PROMISE];
var isNode = classof(process) == 'process';
var empty = function () { /* empty */ };
var Internal, newGenericPromiseCapability, OwnPromiseCapability, Wrapper;
var newPromiseCapability = newGenericPromiseCapability = newPromiseCapabilityModule.f;

var USE_NATIVE = !!function () {
  try {
    // correct subclassing with @@species support
    var promise = $Promise.resolve(1);
    var FakePromise = (promise.constructor = {})[__webpack_require__(/*! ./_wks */ "./node_modules/_core-js@2.6.10@core-js/modules/_wks.js")('species')] = function (exec) {
      exec(empty, empty);
    };
    // unhandled rejections tracking support, NodeJS Promise without it fails @@species test
    return (isNode || typeof PromiseRejectionEvent == 'function')
      && promise.then(empty) instanceof FakePromise
      // v8 6.6 (Node 10 and Chrome 66) have a bug with resolving custom thenables
      // https://bugs.chromium.org/p/chromium/issues/detail?id=830565
      // we can't detect it synchronously, so just check versions
      && v8.indexOf('6.6') !== 0
      && userAgent.indexOf('Chrome/66') === -1;
  } catch (e) { /* empty */ }
}();

// helpers
var isThenable = function (it) {
  var then;
  return isObject(it) && typeof (then = it.then) == 'function' ? then : false;
};
var notify = function (promise, isReject) {
  if (promise._n) return;
  promise._n = true;
  var chain = promise._c;
  microtask(function () {
    var value = promise._v;
    var ok = promise._s == 1;
    var i = 0;
    var run = function (reaction) {
      var handler = ok ? reaction.ok : reaction.fail;
      var resolve = reaction.resolve;
      var reject = reaction.reject;
      var domain = reaction.domain;
      var result, then, exited;
      try {
        if (handler) {
          if (!ok) {
            if (promise._h == 2) onHandleUnhandled(promise);
            promise._h = 1;
          }
          if (handler === true) result = value;
          else {
            if (domain) domain.enter();
            result = handler(value); // may throw
            if (domain) {
              domain.exit();
              exited = true;
            }
          }
          if (result === reaction.promise) {
            reject(TypeError('Promise-chain cycle'));
          } else if (then = isThenable(result)) {
            then.call(result, resolve, reject);
          } else resolve(result);
        } else reject(value);
      } catch (e) {
        if (domain && !exited) domain.exit();
        reject(e);
      }
    };
    while (chain.length > i) run(chain[i++]); // variable length - can't use forEach
    promise._c = [];
    promise._n = false;
    if (isReject && !promise._h) onUnhandled(promise);
  });
};
var onUnhandled = function (promise) {
  task.call(global, function () {
    var value = promise._v;
    var unhandled = isUnhandled(promise);
    var result, handler, console;
    if (unhandled) {
      result = perform(function () {
        if (isNode) {
          process.emit('unhandledRejection', value, promise);
        } else if (handler = global.onunhandledrejection) {
          handler({ promise: promise, reason: value });
        } else if ((console = global.console) && console.error) {
          console.error('Unhandled promise rejection', value);
        }
      });
      // Browsers should not trigger `rejectionHandled` event if it was handled here, NodeJS - should
      promise._h = isNode || isUnhandled(promise) ? 2 : 1;
    } promise._a = undefined;
    if (unhandled && result.e) throw result.v;
  });
};
var isUnhandled = function (promise) {
  return promise._h !== 1 && (promise._a || promise._c).length === 0;
};
var onHandleUnhandled = function (promise) {
  task.call(global, function () {
    var handler;
    if (isNode) {
      process.emit('rejectionHandled', promise);
    } else if (handler = global.onrejectionhandled) {
      handler({ promise: promise, reason: promise._v });
    }
  });
};
var $reject = function (value) {
  var promise = this;
  if (promise._d) return;
  promise._d = true;
  promise = promise._w || promise; // unwrap
  promise._v = value;
  promise._s = 2;
  if (!promise._a) promise._a = promise._c.slice();
  notify(promise, true);
};
var $resolve = function (value) {
  var promise = this;
  var then;
  if (promise._d) return;
  promise._d = true;
  promise = promise._w || promise; // unwrap
  try {
    if (promise === value) throw TypeError("Promise can't be resolved itself");
    if (then = isThenable(value)) {
      microtask(function () {
        var wrapper = { _w: promise, _d: false }; // wrap
        try {
          then.call(value, ctx($resolve, wrapper, 1), ctx($reject, wrapper, 1));
        } catch (e) {
          $reject.call(wrapper, e);
        }
      });
    } else {
      promise._v = value;
      promise._s = 1;
      notify(promise, false);
    }
  } catch (e) {
    $reject.call({ _w: promise, _d: false }, e); // wrap
  }
};

// constructor polyfill
if (!USE_NATIVE) {
  // 25.4.3.1 Promise(executor)
  $Promise = function Promise(executor) {
    anInstance(this, $Promise, PROMISE, '_h');
    aFunction(executor);
    Internal.call(this);
    try {
      executor(ctx($resolve, this, 1), ctx($reject, this, 1));
    } catch (err) {
      $reject.call(this, err);
    }
  };
  // eslint-disable-next-line no-unused-vars
  Internal = function Promise(executor) {
    this._c = [];             // <- awaiting reactions
    this._a = undefined;      // <- checked in isUnhandled reactions
    this._s = 0;              // <- state
    this._d = false;          // <- done
    this._v = undefined;      // <- value
    this._h = 0;              // <- rejection state, 0 - default, 1 - handled, 2 - unhandled
    this._n = false;          // <- notify
  };
  Internal.prototype = __webpack_require__(/*! ./_redefine-all */ "./node_modules/_core-js@2.6.10@core-js/modules/_redefine-all.js")($Promise.prototype, {
    // 25.4.5.3 Promise.prototype.then(onFulfilled, onRejected)
    then: function then(onFulfilled, onRejected) {
      var reaction = newPromiseCapability(speciesConstructor(this, $Promise));
      reaction.ok = typeof onFulfilled == 'function' ? onFulfilled : true;
      reaction.fail = typeof onRejected == 'function' && onRejected;
      reaction.domain = isNode ? process.domain : undefined;
      this._c.push(reaction);
      if (this._a) this._a.push(reaction);
      if (this._s) notify(this, false);
      return reaction.promise;
    },
    // 25.4.5.1 Promise.prototype.catch(onRejected)
    'catch': function (onRejected) {
      return this.then(undefined, onRejected);
    }
  });
  OwnPromiseCapability = function () {
    var promise = new Internal();
    this.promise = promise;
    this.resolve = ctx($resolve, promise, 1);
    this.reject = ctx($reject, promise, 1);
  };
  newPromiseCapabilityModule.f = newPromiseCapability = function (C) {
    return C === $Promise || C === Wrapper
      ? new OwnPromiseCapability(C)
      : newGenericPromiseCapability(C);
  };
}

$export($export.G + $export.W + $export.F * !USE_NATIVE, { Promise: $Promise });
__webpack_require__(/*! ./_set-to-string-tag */ "./node_modules/_core-js@2.6.10@core-js/modules/_set-to-string-tag.js")($Promise, PROMISE);
__webpack_require__(/*! ./_set-species */ "./node_modules/_core-js@2.6.10@core-js/modules/_set-species.js")(PROMISE);
Wrapper = __webpack_require__(/*! ./_core */ "./node_modules/_core-js@2.6.10@core-js/modules/_core.js")[PROMISE];

// statics
$export($export.S + $export.F * !USE_NATIVE, PROMISE, {
  // 25.4.4.5 Promise.reject(r)
  reject: function reject(r) {
    var capability = newPromiseCapability(this);
    var $$reject = capability.reject;
    $$reject(r);
    return capability.promise;
  }
});
$export($export.S + $export.F * (LIBRARY || !USE_NATIVE), PROMISE, {
  // 25.4.4.6 Promise.resolve(x)
  resolve: function resolve(x) {
    return promiseResolve(LIBRARY && this === Wrapper ? $Promise : this, x);
  }
});
$export($export.S + $export.F * !(USE_NATIVE && __webpack_require__(/*! ./_iter-detect */ "./node_modules/_core-js@2.6.10@core-js/modules/_iter-detect.js")(function (iter) {
  $Promise.all(iter)['catch'](empty);
})), PROMISE, {
  // 25.4.4.1 Promise.all(iterable)
  all: function all(iterable) {
    var C = this;
    var capability = newPromiseCapability(C);
    var resolve = capability.resolve;
    var reject = capability.reject;
    var result = perform(function () {
      var values = [];
      var index = 0;
      var remaining = 1;
      forOf(iterable, false, function (promise) {
        var $index = index++;
        var alreadyCalled = false;
        values.push(undefined);
        remaining++;
        C.resolve(promise).then(function (value) {
          if (alreadyCalled) return;
          alreadyCalled = true;
          values[$index] = value;
          --remaining || resolve(values);
        }, reject);
      });
      --remaining || resolve(values);
    });
    if (result.e) reject(result.v);
    return capability.promise;
  },
  // 25.4.4.4 Promise.race(iterable)
  race: function race(iterable) {
    var C = this;
    var capability = newPromiseCapability(C);
    var reject = capability.reject;
    var result = perform(function () {
      forOf(iterable, false, function (promise) {
        C.resolve(promise).then(capability.resolve, reject);
      });
    });
    if (result.e) reject(result.v);
    return capability.promise;
  }
});


/***/ }),

/***/ "./node_modules/_css-loader@3.2.0@css-loader/dist/cjs.js?!./node_modules/_postcss-loader@3.0.0@postcss-loader/src/index.js!./src/static/css/iconfont.css":
/*!***************************************************************************************************************************************************************!*\
  !*** ./node_modules/_css-loader@3.2.0@css-loader/dist/cjs.js??ref--5-1!./node_modules/_postcss-loader@3.0.0@postcss-loader/src!./src/static/css/iconfont.css ***!
  \***************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../node_modules/_css-loader@3.2.0@css-loader/dist/runtime/api.js */ "./node_modules/_css-loader@3.2.0@css-loader/dist/runtime/api.js")(false);
// Imports
var getUrl = __webpack_require__(/*! ../../../node_modules/_css-loader@3.2.0@css-loader/dist/runtime/getUrl.js */ "./node_modules/_css-loader@3.2.0@css-loader/dist/runtime/getUrl.js");
var ___CSS_LOADER_URL___0___ = getUrl(__webpack_require__(/*! ./iconfont.eot?t=1575009924499 */ "./src/static/css/iconfont.eot?t=1575009924499"));
var ___CSS_LOADER_URL___1___ = getUrl(__webpack_require__(/*! ./iconfont.eot?t=1575009924499 */ "./src/static/css/iconfont.eot?t=1575009924499") + "#iefix");
var ___CSS_LOADER_URL___2___ = getUrl(__webpack_require__(/*! ./iconfont.woff */ "./src/static/css/iconfont.woff"));
var ___CSS_LOADER_URL___3___ = getUrl(__webpack_require__(/*! ./iconfont.woff?t=1575009924499 */ "./src/static/css/iconfont.woff?t=1575009924499"));
var ___CSS_LOADER_URL___4___ = getUrl(__webpack_require__(/*! ./iconfont.ttf?t=1575009924499 */ "./src/static/css/iconfont.ttf?t=1575009924499"));
var ___CSS_LOADER_URL___5___ = getUrl(__webpack_require__(/*! ./iconfont.svg?t=1575009924499 */ "./src/static/css/iconfont.svg?t=1575009924499") + "#iconfont");
// Module
exports.push([module.i, "@font-face {font-family: \"iconfont\";\n  src: url(" + ___CSS_LOADER_URL___0___ + "); /* IE9 */\n  src: url(" + ___CSS_LOADER_URL___1___ + ") format('embedded-opentype'), \n  url(" + ___CSS_LOADER_URL___2___ + ") format('woff'),\n  url(" + ___CSS_LOADER_URL___3___ + ") format('woff'),\n  url(" + ___CSS_LOADER_URL___4___ + ") format('truetype'), \n  url(" + ___CSS_LOADER_URL___5___ + ") format('svg'); /* iOS 4.1- */\n}\n\n.iconfont {\n  font-family: \"iconfont\" !important;\n  font-size: 16px;\n  font-style: normal;\n  -webkit-font-smoothing: antialiased;\n  -moz-osx-font-smoothing: grayscale;\n}\n\n.icon-zhanghu:before {\n  content: \"\\e601\";\n}\n\n.icon-checkbox:before {\n  content: \"\\e684\";\n}\n\n.icon-checkboxchecked:before {\n  content: \"\\e67d\";\n}\n\n.icon-74wodedingdan:before {\n  content: \"\\e64e\";\n}\n\n.icon-084tuichu:before {\n  content: \"\\e659\";\n}\n\n.icon-radiobutton:before {\n  content: \"\\e6a7\";\n}\n\n.icon-ai-code:before {\n  content: \"\\e606\";\n}\n\n.icon-ai-user:before {\n  content: \"\\e60c\";\n}\n\n.icon-shouye:before {\n  content: \"\\e61e\";\n}\n\n.icon-radiobox:before {\n  content: \"\\e6d4\";\n}\n\n.icon-liuliangyunpingtaitubiao03:before {\n  content: \"\\e689\";\n}\n\n.icon-fasong:before {\n  content: \"\\e642\";\n}\n\n.icon-radiobox1:before {\n  content: \"\\e764\";\n}\n\n.icon-kefu-tianchong:before {\n  content: \"\\e620\";\n}\n\n.icon-xiazai:before {\n  content: \"\\e610\";\n}\n\n.icon-arrow_down:before {\n  content: \"\\e779\";\n}\n\n.icon-web-icon-:before {\n  content: \"\\e711\";\n}\n\n.icon-yingxiaotuiguang:before {\n  content: \"\\e672\";\n}\n\n.icon-fenzu:before {\n  content: \"\\e613\";\n}\n\n.icon-jiluliebiao:before {\n  content: \"\\e60d\";\n}\n\n.icon-rili1:before {\n  content: \"\\e602\";\n}\n\n.icon-tixianjilu:before {\n  content: \"\\e6bb\";\n}\n\n.icon-kong:before {\n  content: \"\\e708\";\n}\n\n.icon-moban:before {\n  content: \"\\e730\";\n}\n\n.icon-rili:before {\n  content: \"\\e6c5\";\n}\n\n.icon-rizhiguanli:before {\n  content: \"\\e6aa\";\n}\n\n.icon-shujufenxi:before {\n  content: \"\\e600\";\n}\n\n.icon-settings-:before {\n  content: \"\\e652\";\n}\n\n", ""]);


/***/ }),

/***/ "./node_modules/_css-loader@3.2.0@css-loader/dist/cjs.js?!./node_modules/_postcss-loader@3.0.0@postcss-loader/src/index.js!./src/static/css/style.css":
/*!************************************************************************************************************************************************************!*\
  !*** ./node_modules/_css-loader@3.2.0@css-loader/dist/cjs.js??ref--5-1!./node_modules/_postcss-loader@3.0.0@postcss-loader/src!./src/static/css/style.css ***!
  \************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../node_modules/_css-loader@3.2.0@css-loader/dist/runtime/api.js */ "./node_modules/_css-loader@3.2.0@css-loader/dist/runtime/api.js")(false);
// Imports
var getUrl = __webpack_require__(/*! ../../../node_modules/_css-loader@3.2.0@css-loader/dist/runtime/getUrl.js */ "./node_modules/_css-loader@3.2.0@css-loader/dist/runtime/getUrl.js");
var ___CSS_LOADER_URL___0___ = getUrl(__webpack_require__(/*! ../images/bg.jpg */ "./src/static/images/bg.jpg"));
var ___CSS_LOADER_URL___1___ = getUrl(__webpack_require__(/*! ../images/icon_arrow_down.png */ "./src/static/images/icon_arrow_down.png"));
// Module
exports.push([module.i, "* {\r\n    margin: 0;\r\n    padding: 0;\r\n    -webkit-box-sizing: border-box;\r\n            box-sizing: border-box;\r\n}\r\n*:before,\r\n*:after {\r\n    margin: 0;\r\n    padding: 0;\r\n    -webkit-box-sizing: border-box;\r\n            box-sizing: border-box;\r\n}\r\n*::-webkit-scrollbar {\r\n    width: 8px;\r\n    height: 8px;\r\n}\r\n*::-webkit-scrollbar-thumb {\r\n    border-radius: 8px;\r\n    background-color: #CBCBCB;\r\n    background-image: -webkit-linear-gradient(150deg, rgba(255, 255, 255, .2) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, .2) 50%, rgba(255, 255, 255, .2) 75%, transparent 75%, transparent);\r\n}\r\n*::-webkit-scrollbar-track {\r\n    background-color: #fff;\r\n\tborder-radius: 8px;\r\n}\r\n*::-webkit-scrollbar-thumb:hover {\r\n\tbackground-color: #000;\r\n}\r\nhtml, body, #root {height: 100%;}\r\nbody {\r\n    font-size: 14px;\r\n    background-image: url(" + ___CSS_LOADER_URL___0___ + ");\r\n}\r\n.pull-right {float: right!important;}\r\n.pl-0 {padding-left: 0!important;}\r\n.pr-0 {padding-right: 0!important;}\r\n.text-center {text-align: center!important;}\r\nbutton:focus {outline: 0;}\r\n.header {\r\n    position: -webkit-sticky;\r\n    position: sticky;\r\n    top: 0;\r\n    width: 100%;\r\n    min-width: 1280px;\r\n    z-index: 22;\r\n    -webkit-box-shadow: 0 4px 8px rgba(0, 0, 0, .25);\r\n            box-shadow: 0 4px 8px rgba(0, 0, 0, .25);\r\n}\r\n.container,\r\n.header-content {\r\n    width: 1280px;\r\n    margin: auto;\r\n}\r\n.header-content {\r\n    height: 60px;\r\n}\r\n#menu {padding-left: 220px;}\r\n#menu a {\r\n    color: #fff;\r\n    text-decoration: none;\r\n    font-weight: 500;\r\n    font-size: 16px;\r\n    height: 60px;\r\n    line-height: 60px;\r\n    display: inline-block;\r\n    letter-spacing: 3px;\r\n    padding: 0 10px;\r\n    margin: 0 5px;\r\n}\r\n#menu a.on,\r\n#menu a.menu:hover {\r\n    background-color: #1d9fb3;\r\n}\r\n#menu .users {\r\n    margin: 0;\r\n    padding: 0;\r\n    float: right;\r\n}\r\n.users .icon {\r\n    font-size: 32px;\r\n    margin-right: 5px;\r\n}\r\n.container {\r\n    position: relative;\r\n    border-radius: 3px;\r\n    margin-bottom: 20px;\r\n    border: 1px solid #cecece;\r\n    top: 20px;\r\n    -webkit-box-shadow: 0 0 8px rgba(0, 0, 0, .25);\r\n            box-shadow: 0 0 8px rgba(0, 0, 0, .25);\r\n}\r\n.control {\r\n    position: absolute;\r\n    width: 160px;\r\n    height: 100%;\r\n    border-right: 1px solid #cecece;\r\n    border-top-left-radius: 3px;\r\n    border-bottom-left-radius: 3px;\r\n    background: #f2f2f2;\r\n    background: -webkit-gradient(linear,left top, left bottom,color-stop(0, #f2f2f2),to(#f8f8f8));\r\n    background: linear-gradient(to bottom,#f2f2f2 0,#f8f8f8 100%);\r\n    background-repeat: repeat-x;\r\n}\r\n.control .title {\r\n    margin-right: -1px;\r\n    border-top-left-radius: 3px;\r\n}\r\n.wrapper {padding: 5px 15px;}\r\n.wrapper a {\r\n    position: relative;\r\n    display: block;\r\n    height: 45px;\r\n    line-height: 32px;\r\n    text-align: center;\r\n    color: #333;\r\n    font-size: 14px;\r\n    padding: 6px 0 6px 25px;\r\n    text-decoration: none;\r\n    border-bottom: 1px solid #e8e8e8;\r\n}\r\n.wrapper a:hover {\r\n    color: #03a9f4;\r\n}\r\n.wrapper .icon {\r\n    position: absolute;\r\n    font-size: 24px;\r\n    left: 15px;\r\n}\r\n.content {\r\n    display: -webkit-box;\r\n    display: -ms-flexbox;\r\n    display: flex;\r\n    -webkit-box-orient: vertical;\r\n    -webkit-box-direction: normal;\r\n        -ms-flex-direction: column;\r\n            flex-direction: column;\r\n    min-height: 580px;\r\n    margin-left: 160px;\r\n    background-color: #fff;\r\n    border-top-right-radius: 3px;\r\n    border-bottom-right-radius: 3px;\r\n}\r\n.control .title,\r\n.content .title {\r\n    height: 40px;\r\n    line-height: 40px;\r\n    text-align: center;\r\n    font-size: 15px;\r\n    color: #fff;\r\n}\r\n.content .title {\r\n    position: relative;\r\n    background: #1d9fb3;\r\n    border-top-right-radius: 3px;\r\n}\r\n.content .body {\r\n    -webkit-box-flex: 1;\r\n        -ms-flex: auto;\r\n            flex: auto;\r\n    padding: 15px;\r\n}\r\n.wrapper a.on:before,\r\n.wrapper a.on:after,\r\n.content .title:after {\r\n    content: '';\r\n    position: absolute;\r\n    display: block;\r\n    border-style: solid;\r\n    border-color: transparent;\r\n}\r\n.wrapper a.on:before {\r\n    border-width: 12px;\r\n    border-right-color: #cecece;\r\n    right: -16px;\r\n    top: 12px;\r\n}\r\n.wrapper a.on:after {\r\n    border-width: 10px;\r\n    border-right-color: #fff;\r\n    right: -16px;\r\n    top: 14px;\r\n}\r\n.content .title:after {\r\n    border-width: 8px;\r\n    border-left-color: #008194;\r\n    left: 0;\r\n    top: 12px;\r\n}\r\n/* Table */\r\ntable,\r\n.table {\r\n    width: 100%;\r\n    border-spacing: 0;\r\n    border-collapse: collapse;\r\n    text-align: center;\r\n}\r\n.table caption, \r\n.table th, \r\n.table td {\r\n    padding: 8px;\r\n    text-align: center;\r\n    vertical-align: middle;\r\n}\r\n.table thead th {\r\n    position: -webkit-sticky;\r\n    position: sticky;\r\n    top: 0;\r\n    background-color: #ececec;\r\n    background-image: -webkit-gradient(linear,left top, left bottom,color-stop(0, #f8f8f8),to(#ececec));\r\n    background-image: linear-gradient(to bottom,#f8f8f8 0,#ececec 100%);\r\n    border-top: 1px solid #e6e6e6;\r\n    border-bottom: 2px solid #e6e6e6;\r\n}\r\n.table-bordered td {\r\n\tborder: 1px solid #e6e6e6;\r\n}\r\n.table tbody td {\r\n    line-height: 1.42857143;\r\n    border-bottom: 1px solid #e6e6e6;\r\n}\r\n.table .tr-odd {background-color: #f9f9f9;}\r\n.table tbody tr:nth-of-type(odd) {background-color: #f9f9f9;}\r\n.table tbody .tr-hover {background-color: #edf5ff;}\r\n.table tbody tr:hover {background-color: #edf5ff;}\r\n.nowrap {white-space: nowrap!important;}\r\n/* Button */\r\n.btn {\r\n    display: inline-block;\r\n    border: 0;\r\n    border-radius: 4px;\r\n    padding: 6px 12px;\r\n    cursor: pointer;\r\n    font-size: 14px;\r\n    white-space: nowrap;\r\n    color: #fff;\r\n    background-color: #ccc;\r\n}\r\n.btn-min {\r\n    padding: 3px 6px;\r\n}\r\n.btn.bg-primary:hover {background-color: #03606e;}\r\n.btn.bg-danger:hover {background-color: #ac2617;}\r\n.btn-min .btn {\r\n    line-height: 25px;\r\n}\r\n.btn-group {\r\n    display: inline-block;\r\n    white-space: nowrap;\r\n}\r\n.btn-group .btn {\r\n    line-height: 25px;\r\n    padding: 0 5px;\r\n    border-radius: 0;\r\n    border-right: 1px solid #fff;\r\n}\r\n.btn-paging .btn {\r\n    line-height: 32px;\r\n    padding: 0 8px;\r\n    border-radius: 0;\r\n    border-right: 1px solid #fff; \r\n}\r\n.btn-group .btn:first-child,\r\n.btn-paging .btn:first-child {\r\n    border-radius: 4px 0 0 4px;\r\n}\r\n.btn-group .btn:last-child,\r\n.btn-paging .btn:last-child {\r\n    border-radius: 0 4px 4px 0;\r\n    border: 0;\r\n}\r\n/* Labels */\r\n.labels {\r\n    height: 20px;\r\n\tline-height: 20px;\r\n    text-align: center;\r\n    background: #adabab;\r\n    color: #fff;\r\n    white-space: nowrap;\r\n    display: inline-block;\r\n    position: relative;\r\n\tfont-size: 12px;\r\n\tpadding: 0 8px;\r\n    border-radius: 4px;\r\n    cursor: default;\r\n\tz-index: 1;\r\n}\r\n.labels-l,\r\n.labels-r {\r\n    padding: 0 5px;\r\n\tborder-radius: 0;\r\n}\r\n.bg-success.labels-l:before,\r\n.bg-success.labels-l:after,\r\n.bg-success.labels-r:before,\r\n.bg-success.labels-r:after {border-color: #009f5d;}\r\n.bg-info.labels-l:before,\r\n.bg-info.labels-l:after,\r\n.bg-info.labels-r:before,\r\n.bg-info.labels-r:after {border-color: #019fde;}\r\n.bg-danger.labels-l:before,\r\n.bg-danger.labels-l:after,\r\n.bg-danger.labels-r:before,\r\n.bg-danger.labels-r:after {border-color: #D83420;}\r\n.labels-l:before,\r\n.labels-l:after,\r\n.labels-r:before,\r\n.labels-r:after {\r\n\tcontent: \"\";\r\n\tposition: absolute;\r\n\t*height: 0;\r\n\t*line-height: 0;\r\n\tfont-size: 0;\r\n\tborder-color: #adabab;\r\n\tborder-width: 10px 6px;\r\n\t_border-width: 10px;\r\n\ttop: 0;\r\n\tz-index: -1;\r\n}\r\n.labels.labels-l:before {\r\n\tborder-style: dashed;\r\n\tborder-left-color: transparent;\r\n\tborder-top-color: transparent;\r\n\tborder-bottom-color: transparent;\r\n\tborder-right-style: solid;\r\n\tleft: -12px;\r\n\t_left: -20px;\r\n}\r\n.labels.labels-l:after {\r\n\tborder-style: solid;\r\n\tborder-right-color: transparent;\r\n\tborder-right-style: dashed;\r\n} \r\n.labels.labels-r:before {\r\n\tborder-style: solid;\r\n\tborder-left-color: transparent;\r\n\tborder-left-style: dashed;\r\n\tleft: -11px;\r\n} \r\n.labels.labels-r:after {\r\n\tborder-style: dashed;\r\n\tborder-right-color: transparent;\r\n\tborder-top-color: transparent;\r\n\tborder-bottom-color: transparent;\r\n\tborder-left-style: solid;\r\n\tright: -12px;\r\n\t_right: -20px;\r\n}\r\n/* Check Box */\r\n.check-box {\r\n    position: relative;\r\n    cursor: pointer;\r\n    padding-right: 10px;\r\n    -webkit-user-select: none;\r\n       -moz-user-select: none;\r\n        -ms-user-select: none;\r\n            user-select: none;\r\n}\r\n.check-box:before {\r\n    content: '';\r\n    position: relative;\r\n    display: inline-block;\r\n    width: 16px;\r\n    height: 16px;\r\n    border: 1px solid #979797;\r\n    border-radius: 2px;\r\n    vertical-align: -3px;\r\n    margin-right: 5px;\r\n}\r\n.icon.no-check {color: #979797;}\r\n.icon.check {color: #00b066;}\r\n/* Input */\r\n.form-control {\r\n    color: #333;\r\n    border: solid 1px #ced4da;\r\n    border-radius: 4px;\r\n    padding: 0 8px;\r\n    background: #FFF;\r\n    font-size: 14px;\r\n    height: 30px;\r\n    line-height: 28px\\0;\r\n}\r\n.form-control:focus {\r\n    border-color: #0097CF;\r\n    outline: 0;\r\n    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(0, 151, 207, 0.6);\r\n            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(0, 151, 207, 0.6);\r\n}\r\n/* Input Group */\r\n.tab-input-addon {\r\n    width: 1%;\r\n    white-space: nowrap;\r\n    vertical-align: top;\r\n}\r\n.tab-input-addon .tab-input-tag {\r\n    display: block;\r\n    height: 30px\\0;\r\n    line-height: 28px;\r\n    line-height: 30px\\0;\r\n    padding: 0 8px;\r\n    -webkit-user-select: none;\r\n       -moz-user-select: none;\r\n        -ms-user-select: none;\r\n            user-select: none;\r\n    white-space: nowrap;\r\n    background-color: #eee;\r\n    border: 1px solid #ced4da;\r\n    border-radius: 4px;\r\n}\r\n.tab-input-group .form-control {\r\n    position: relative;\r\n    width: 100%;\r\n    border-radius: 0;\r\n}\r\n.tig-head .form-control, \r\n.tig-head .tab-input-tag {\r\n    border-radius: 4px 0 0 4px;\r\n}\r\n.tig-end {position: relative;}\r\n.tig-end .form-control, \r\n.tig-end .tab-input-tag {\r\n    border-radius: 0 4px 4px 0;\r\n}\r\n.tig-head .tab-input-tag {\r\n    border-right: 0;\r\n}\r\n.calendar {\r\n    padding-right: 32px;\r\n    background: #f5f5f5;\r\n    cursor: default;\r\n}\r\n.calendar + i {\r\n    position: absolute;\r\n    right: 1px;\r\n    top: 1px;\r\n    color: #9ea1a3;\r\n    z-index: 1;\r\n    width: 32px;\r\n    line-height: 28px;\r\n    background: #eee;\r\n    border-radius: 0 4px 4px 0;\r\n    border-left: 1px solid #ced4da;\r\n    -webkit-user-select: none;\r\n       -moz-user-select: none;\r\n        -ms-user-select: none;\r\n            user-select: none;\r\n    cursor: default;\r\n}\r\n/* Selector */\r\n.selector {\r\n    position: relative;\r\n    cursor: default;\r\n    text-align: left;\r\n    line-height: 30px;\r\n    padding-right: 20px;\r\n    overflow: hidden;\r\n}\r\n.selector:after {\r\n    content: '';\r\n    position: absolute;\r\n    right: 8px;\r\n    top: 10px;\r\n    width: 10px;\r\n    height: 8px;\r\n    background-image: url(" + ___CSS_LOADER_URL___1___ + ");\r\n    -webkit-transition: all ease-out .3s;\r\n    transition: all ease-out .3s;\r\n}\r\n.selector.on:after {\r\n    -webkit-transform: rotate(-180deg);\r\n            transform: rotate(-180deg);\r\n}\r\n.selector-list {\r\n    width: 100%;\r\n    max-height: 0;\r\n    background-color: #fff;\r\n    font-size: 14px;\r\n    position: absolute;\r\n    top: 34px;\r\n    left: 0;\r\n    z-index: 11;\r\n    border: 1px solid #ccc;\r\n    border-radius: 0 0 4px 4px;\r\n    overflow: auto;\r\n    margin-bottom: 10px;\r\n\t-webkit-transition: max-height .2s ease;\r\n\ttransition: max-height .2s ease;\r\n    visibility: hidden;\r\n}\r\n.selector.on {overflow: visible;}\r\n.selector.on .selector-list {\r\n    visibility: visible;\r\n    max-height: 300px;\r\n}\r\n.selector-list li {\r\n    list-style: none;\r\n    padding: 0 10px;\r\n    line-height: 28px;\r\n    text-align: left;\r\n    overflow: hidden;\r\n    white-space: nowrap;\r\n    text-overflow: ellipsis;\r\n    cursor: pointer;\r\n}\r\n.selector-list li:hover {\r\n    background-color: #eee;\r\n}\r\n.selector-list li.on {\r\n    background-color: #1e90ff;\r\n    color: #fff;\r\n}\r\n/*****progress*****/\r\n@-webkit-keyframes progress-bar-stripes {\r\n\tfrom{background-position:40px 0}\r\n\tto{background-position:0 0}\r\n}\r\n@keyframes progress-bar-stripes {\r\n\tfrom{background-position:40px 0}\r\n\tto{background-position:0 0}\r\n}\r\n.progress {\r\n    height: 12px;\r\n    background: #dadada;\r\n    position: relative;\r\n\tfont-size: 0;\r\n}\r\n.progress-bar {\r\n    width: 0;\r\n    height: 100%;\r\n    background: #00b066;\r\n    background-image: linear-gradient(45deg,rgba(255,255,255,0.2) 25%,transparent 25%,transparent 50%,rgba(255,255,255,0.2) 50%,rgba(255,255,255,0.2) 75%,transparent 75%,transparent);\r\n    background-size: 40px 40px;\r\n}\r\n.progress-active .progress-bar {\r\n    -webkit-animation: progress-bar-stripes 2s linear infinite;\r\n    animation: progress-bar-stripes 2s linear infinite;\r\n}\r\n.progress:after {\r\n    content: attr(data-percent);\r\n    text-align: center;\r\n    color: #fff;\r\n    position: absolute;\r\n    width: 100%;\r\n    top: 0;\r\n    height: 100%;\r\n    font-size: 13px;\r\n\tline-height: 12px;\r\n}\r\n/* Grid */\r\n.col-xs-3,.col-xs-4 {\r\n    display: inline-block;\r\n    padding: 3px;\r\n}\r\n.col-xs-3 {width: 25%;}\r\n.col-xs-4 {width: 33.333%;}\r\n/*** SKIN ***/\r\n.bg-primary {background-color: #008194;}\r\n.bg-success {background-color: #009f5d;}\r\n.bg-info {background-color: #019fde;}\r\n.bg-danger {background-color: #D83420;}\r\n/* Skin - Red */\r\nbody.skin-red .bg-primary {background-color: #7c2937;}\r\nbody.skin-red #menu a.on,\r\nbody.skin-red #menu a.menu:hover {\r\n    background-color: #ab3348;\r\n}\r\nbody.skin-red .content .title {\r\n    background: #ab3348;\r\n}\r\nbody.skin-red .content .title:after {\r\n    border-left-color: #7c2937;\r\n}\r\n/* Skin - Night */\r\nbody.skin-night .bg-primary {background-color: #1c1f2b;}\r\nbody.skin-night #menu a.on,\r\nbody.skin-night #menu a.menu:hover {\r\n    background-color: #3a3f54;\r\n}\r\nbody.skin-night .content .title {\r\n    background: #3a3f54;\r\n}\r\nbody.skin-night .content .title:after {\r\n    border-left-color: #1c1f2b;\r\n}\r\n/* Skin - Blue */\r\nbody.skin-blue .bg-primary {background-color: #0398d6;}\r\n/*** SKIN END ***/", ""]);


/***/ }),

/***/ "./node_modules/_css-loader@3.2.0@css-loader/dist/runtime/api.js":
/*!***********************************************************************!*\
  !*** ./node_modules/_css-loader@3.2.0@css-loader/dist/runtime/api.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


/*
  MIT License http://www.opensource.org/licenses/mit-license.php
  Author Tobias Koppers @sokra
*/
// css base code, injected by the css-loader
// eslint-disable-next-line func-names
module.exports = function (useSourceMap) {
  var list = []; // return the list of modules as css string

  list.toString = function toString() {
    return this.map(function (item) {
      var content = cssWithMappingToString(item, useSourceMap);

      if (item[2]) {
        return "@media ".concat(item[2], "{").concat(content, "}");
      }

      return content;
    }).join('');
  }; // import a list of modules into the list
  // eslint-disable-next-line func-names


  list.i = function (modules, mediaQuery) {
    if (typeof modules === 'string') {
      // eslint-disable-next-line no-param-reassign
      modules = [[null, modules, '']];
    }

    var alreadyImportedModules = {};

    for (var i = 0; i < this.length; i++) {
      // eslint-disable-next-line prefer-destructuring
      var id = this[i][0];

      if (id != null) {
        alreadyImportedModules[id] = true;
      }
    }

    for (var _i = 0; _i < modules.length; _i++) {
      var item = modules[_i]; // skip already imported module
      // this implementation is not 100% perfect for weird media query combinations
      // when a module is imported multiple times with different media queries.
      // I hope this will never occur (Hey this way we have smaller bundles)

      if (item[0] == null || !alreadyImportedModules[item[0]]) {
        if (mediaQuery && !item[2]) {
          item[2] = mediaQuery;
        } else if (mediaQuery) {
          item[2] = "(".concat(item[2], ") and (").concat(mediaQuery, ")");
        }

        list.push(item);
      }
    }
  };

  return list;
};

function cssWithMappingToString(item, useSourceMap) {
  var content = item[1] || ''; // eslint-disable-next-line prefer-destructuring

  var cssMapping = item[3];

  if (!cssMapping) {
    return content;
  }

  if (useSourceMap && typeof btoa === 'function') {
    var sourceMapping = toComment(cssMapping);
    var sourceURLs = cssMapping.sources.map(function (source) {
      return "/*# sourceURL=".concat(cssMapping.sourceRoot).concat(source, " */");
    });
    return [content].concat(sourceURLs).concat([sourceMapping]).join('\n');
  }

  return [content].join('\n');
} // Adapted from convert-source-map (MIT)


function toComment(sourceMap) {
  // eslint-disable-next-line no-undef
  var base64 = btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap))));
  var data = "sourceMappingURL=data:application/json;charset=utf-8;base64,".concat(base64);
  return "/*# ".concat(data, " */");
}

/***/ }),

/***/ "./node_modules/_css-loader@3.2.0@css-loader/dist/runtime/getUrl.js":
/*!**************************************************************************!*\
  !*** ./node_modules/_css-loader@3.2.0@css-loader/dist/runtime/getUrl.js ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


module.exports = function (url, needQuotes) {
  // eslint-disable-next-line no-underscore-dangle, no-param-reassign
  url = url.__esModule ? url["default"] : url;

  if (typeof url !== 'string') {
    return url;
  } // If url is already wrapped in quotes, remove them


  if (/^['"].*['"]$/.test(url)) {
    // eslint-disable-next-line no-param-reassign
    url = url.slice(1, -1);
  } // Should url be wrapped?
  // See https://drafts.csswg.org/css-values-3/#urls


  if (/["'() \t\n]/.test(url) || needQuotes) {
    return "\"".concat(url.replace(/"/g, '\\"').replace(/\n/g, '\\n'), "\"");
  }

  return url;
};

/***/ }),

/***/ "./node_modules/_es5-shim@4.5.13@es5-shim/es5-shim.js":
/*!************************************************************!*\
  !*** ./node_modules/_es5-shim@4.5.13@es5-shim/es5-shim.js ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var __WEBPACK_AMD_DEFINE_FACTORY__, __WEBPACK_AMD_DEFINE_RESULT__;/*!
 * https://github.com/es-shims/es5-shim
 * @license es5-shim Copyright 2009-2015 by contributors, MIT License
 * see https://github.com/es-shims/es5-shim/blob/master/LICENSE
 */

// vim: ts=4 sts=4 sw=4 expandtab

// Add semicolon to prevent IIFE from being passed as argument to concatenated code.
;

// UMD (Universal Module Definition)
// see https://github.com/umdjs/umd/blob/master/templates/returnExports.js
(function (root, factory) {
    'use strict';

    /* global define, exports, module */
    if (true) {
        // AMD. Register as an anonymous module.
        !(__WEBPACK_AMD_DEFINE_FACTORY__ = (factory),
				__WEBPACK_AMD_DEFINE_RESULT__ = (typeof __WEBPACK_AMD_DEFINE_FACTORY__ === 'function' ?
				(__WEBPACK_AMD_DEFINE_FACTORY__.call(exports, __webpack_require__, exports, module)) :
				__WEBPACK_AMD_DEFINE_FACTORY__),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
    } else {}
}(this, function () {
    /**
     * Brings an environment as close to ECMAScript 5 compliance
     * as is possible with the facilities of erstwhile engines.
     *
     * Annotated ES5: http://es5.github.com/ (specific links below)
     * ES5 Spec: http://www.ecma-international.org/publications/files/ECMA-ST/Ecma-262.pdf
     * Required reading: http://javascriptweblog.wordpress.com/2011/12/05/extending-javascript-natives/
     */

    // Shortcut to an often accessed properties, in order to avoid multiple
    // dereference that costs universally. This also holds a reference to known-good
    // functions.
    var $Array = Array;
    var ArrayPrototype = $Array.prototype;
    var $Object = Object;
    var ObjectPrototype = $Object.prototype;
    var $Function = Function;
    var FunctionPrototype = $Function.prototype;
    var $String = String;
    var StringPrototype = $String.prototype;
    var $Number = Number;
    var NumberPrototype = $Number.prototype;
    var array_slice = ArrayPrototype.slice;
    var array_splice = ArrayPrototype.splice;
    var array_push = ArrayPrototype.push;
    var array_unshift = ArrayPrototype.unshift;
    var array_concat = ArrayPrototype.concat;
    var array_join = ArrayPrototype.join;
    var call = FunctionPrototype.call;
    var apply = FunctionPrototype.apply;
    var max = Math.max;
    var min = Math.min;

    // Having a toString local variable name breaks in Opera so use to_string.
    var to_string = ObjectPrototype.toString;

    /* global Symbol */
    /* eslint-disable one-var-declaration-per-line, no-redeclare, max-statements-per-line */
    var hasToStringTag = typeof Symbol === 'function' && typeof Symbol.toStringTag === 'symbol';
    var isCallable; /* inlined from https://npmjs.com/is-callable */ var fnToStr = Function.prototype.toString, constructorRegex = /^\s*class /, isES6ClassFn = function isES6ClassFn(value) { try { var fnStr = fnToStr.call(value); var singleStripped = fnStr.replace(/\/\/.*\n/g, ''); var multiStripped = singleStripped.replace(/\/\*[.\s\S]*\*\//g, ''); var spaceStripped = multiStripped.replace(/\n/mg, ' ').replace(/ {2}/g, ' '); return constructorRegex.test(spaceStripped); } catch (e) { return false; /* not a function */ } }, tryFunctionObject = function tryFunctionObject(value) { try { if (isES6ClassFn(value)) { return false; } fnToStr.call(value); return true; } catch (e) { return false; } }, fnClass = '[object Function]', genClass = '[object GeneratorFunction]', isCallable = function isCallable(value) { if (!value) { return false; } if (typeof value !== 'function' && typeof value !== 'object') { return false; } if (hasToStringTag) { return tryFunctionObject(value); } if (isES6ClassFn(value)) { return false; } var strClass = to_string.call(value); return strClass === fnClass || strClass === genClass; };

    var isRegex; /* inlined from https://npmjs.com/is-regex */ var regexExec = RegExp.prototype.exec, tryRegexExec = function tryRegexExec(value) { try { regexExec.call(value); return true; } catch (e) { return false; } }, regexClass = '[object RegExp]'; isRegex = function isRegex(value) { if (typeof value !== 'object') { return false; } return hasToStringTag ? tryRegexExec(value) : to_string.call(value) === regexClass; };
    var isString; /* inlined from https://npmjs.com/is-string */ var strValue = String.prototype.valueOf, tryStringObject = function tryStringObject(value) { try { strValue.call(value); return true; } catch (e) { return false; } }, stringClass = '[object String]'; isString = function isString(value) { if (typeof value === 'string') { return true; } if (typeof value !== 'object') { return false; } return hasToStringTag ? tryStringObject(value) : to_string.call(value) === stringClass; };
    /* eslint-enable one-var-declaration-per-line, no-redeclare, max-statements-per-line */

    /* inlined from http://npmjs.com/define-properties */
    var supportsDescriptors = $Object.defineProperty && (function () {
        try {
            var obj = {};
            $Object.defineProperty(obj, 'x', { enumerable: false, value: obj });
            for (var _ in obj) { // jscs:ignore disallowUnusedVariables
                return false;
            }
            return obj.x === obj;
        } catch (e) { /* this is ES3 */
            return false;
        }
    }());
    var defineProperties = (function (has) {
        // Define configurable, writable, and non-enumerable props
        // if they don't exist.
        var defineProperty;
        if (supportsDescriptors) {
            defineProperty = function (object, name, method, forceAssign) {
                if (!forceAssign && (name in object)) {
                    return;
                }
                $Object.defineProperty(object, name, {
                    configurable: true,
                    enumerable: false,
                    writable: true,
                    value: method
                });
            };
        } else {
            defineProperty = function (object, name, method, forceAssign) {
                if (!forceAssign && (name in object)) {
                    return;
                }
                object[name] = method;
            };
        }
        return function defineProperties(object, map, forceAssign) {
            for (var name in map) {
                if (has.call(map, name)) {
                    defineProperty(object, name, map[name], forceAssign);
                }
            }
        };
    }(ObjectPrototype.hasOwnProperty));

    //
    // Util
    // ======
    //

    /* replaceable with https://npmjs.com/package/es-abstract /helpers/isPrimitive */
    var isPrimitive = function isPrimitive(input) {
        var type = typeof input;
        return input === null || (type !== 'object' && type !== 'function');
    };

    var isActualNaN = $Number.isNaN || function isActualNaN(x) {
        return x !== x;
    };

    var ES = {
        // ES5 9.4
        // http://es5.github.com/#x9.4
        // http://jsperf.com/to-integer
        /* replaceable with https://npmjs.com/package/es-abstract ES5.ToInteger */
        ToInteger: function ToInteger(num) {
            var n = +num;
            if (isActualNaN(n)) {
                n = 0;
            } else if (n !== 0 && n !== (1 / 0) && n !== -(1 / 0)) {
                n = (n > 0 || -1) * Math.floor(Math.abs(n));
            }
            return n;
        },

        /* replaceable with https://npmjs.com/package/es-abstract ES5.ToPrimitive */
        ToPrimitive: function ToPrimitive(input) {
            var val, valueOf, toStr;
            if (isPrimitive(input)) {
                return input;
            }
            valueOf = input.valueOf;
            if (isCallable(valueOf)) {
                val = valueOf.call(input);
                if (isPrimitive(val)) {
                    return val;
                }
            }
            toStr = input.toString;
            if (isCallable(toStr)) {
                val = toStr.call(input);
                if (isPrimitive(val)) {
                    return val;
                }
            }
            throw new TypeError();
        },

        // ES5 9.9
        // http://es5.github.com/#x9.9
        /* replaceable with https://npmjs.com/package/es-abstract ES5.ToObject */
        ToObject: function (o) {
            if (o == null) { // this matches both null and undefined
                throw new TypeError("can't convert " + o + ' to object');
            }
            return $Object(o);
        },

        /* replaceable with https://npmjs.com/package/es-abstract ES5.ToUint32 */
        ToUint32: function ToUint32(x) {
            return x >>> 0;
        }
    };

    //
    // Function
    // ========
    //

    // ES-5 15.3.4.5
    // http://es5.github.com/#x15.3.4.5

    var Empty = function Empty() {};

    defineProperties(FunctionPrototype, {
        bind: function bind(that) { // .length is 1
            // 1. Let Target be the this value.
            var target = this;
            // 2. If IsCallable(Target) is false, throw a TypeError exception.
            if (!isCallable(target)) {
                throw new TypeError('Function.prototype.bind called on incompatible ' + target);
            }
            // 3. Let A be a new (possibly empty) internal list of all of the
            //   argument values provided after thisArg (arg1, arg2 etc), in order.
            // XXX slicedArgs will stand in for "A" if used
            var args = array_slice.call(arguments, 1); // for normal call
            // 4. Let F be a new native ECMAScript object.
            // 11. Set the [[Prototype]] internal property of F to the standard
            //   built-in Function prototype object as specified in 15.3.3.1.
            // 12. Set the [[Call]] internal property of F as described in
            //   15.3.4.5.1.
            // 13. Set the [[Construct]] internal property of F as described in
            //   15.3.4.5.2.
            // 14. Set the [[HasInstance]] internal property of F as described in
            //   15.3.4.5.3.
            var bound;
            var binder = function () {

                if (this instanceof bound) {
                    // 15.3.4.5.2 [[Construct]]
                    // When the [[Construct]] internal method of a function object,
                    // F that was created using the bind function is called with a
                    // list of arguments ExtraArgs, the following steps are taken:
                    // 1. Let target be the value of F's [[TargetFunction]]
                    //   internal property.
                    // 2. If target has no [[Construct]] internal method, a
                    //   TypeError exception is thrown.
                    // 3. Let boundArgs be the value of F's [[BoundArgs]] internal
                    //   property.
                    // 4. Let args be a new list containing the same values as the
                    //   list boundArgs in the same order followed by the same
                    //   values as the list ExtraArgs in the same order.
                    // 5. Return the result of calling the [[Construct]] internal
                    //   method of target providing args as the arguments.

                    var result = apply.call(
                        target,
                        this,
                        array_concat.call(args, array_slice.call(arguments))
                    );
                    if ($Object(result) === result) {
                        return result;
                    }
                    return this;

                } else {
                    // 15.3.4.5.1 [[Call]]
                    // When the [[Call]] internal method of a function object, F,
                    // which was created using the bind function is called with a
                    // this value and a list of arguments ExtraArgs, the following
                    // steps are taken:
                    // 1. Let boundArgs be the value of F's [[BoundArgs]] internal
                    //   property.
                    // 2. Let boundThis be the value of F's [[BoundThis]] internal
                    //   property.
                    // 3. Let target be the value of F's [[TargetFunction]] internal
                    //   property.
                    // 4. Let args be a new list containing the same values as the
                    //   list boundArgs in the same order followed by the same
                    //   values as the list ExtraArgs in the same order.
                    // 5. Return the result of calling the [[Call]] internal method
                    //   of target providing boundThis as the this value and
                    //   providing args as the arguments.

                    // equiv: target.call(this, ...boundArgs, ...args)
                    return apply.call(
                        target,
                        that,
                        array_concat.call(args, array_slice.call(arguments))
                    );

                }

            };

            // 15. If the [[Class]] internal property of Target is "Function", then
            //     a. Let L be the length property of Target minus the length of A.
            //     b. Set the length own property of F to either 0 or L, whichever is
            //       larger.
            // 16. Else set the length own property of F to 0.

            var boundLength = max(0, target.length - args.length);

            // 17. Set the attributes of the length own property of F to the values
            //   specified in 15.3.5.1.
            var boundArgs = [];
            for (var i = 0; i < boundLength; i++) {
                array_push.call(boundArgs, '$' + i);
            }

            // XXX Build a dynamic function with desired amount of arguments is the only
            // way to set the length property of a function.
            // In environments where Content Security Policies enabled (Chrome extensions,
            // for ex.) all use of eval or Function costructor throws an exception.
            // However in all of these environments Function.prototype.bind exists
            // and so this code will never be executed.
            bound = $Function('binder', 'return function (' + array_join.call(boundArgs, ',') + '){ return binder.apply(this, arguments); }')(binder);

            if (target.prototype) {
                Empty.prototype = target.prototype;
                bound.prototype = new Empty();
                // Clean up dangling references.
                Empty.prototype = null;
            }

            // TODO
            // 18. Set the [[Extensible]] internal property of F to true.

            // TODO
            // 19. Let thrower be the [[ThrowTypeError]] function Object (13.2.3).
            // 20. Call the [[DefineOwnProperty]] internal method of F with
            //   arguments "caller", PropertyDescriptor {[[Get]]: thrower, [[Set]]:
            //   thrower, [[Enumerable]]: false, [[Configurable]]: false}, and
            //   false.
            // 21. Call the [[DefineOwnProperty]] internal method of F with
            //   arguments "arguments", PropertyDescriptor {[[Get]]: thrower,
            //   [[Set]]: thrower, [[Enumerable]]: false, [[Configurable]]: false},
            //   and false.

            // TODO
            // NOTE Function objects created using Function.prototype.bind do not
            // have a prototype property or the [[Code]], [[FormalParameters]], and
            // [[Scope]] internal properties.
            // XXX can't delete prototype in pure-js.

            // 22. Return F.
            return bound;
        }
    });

    // _Please note: Shortcuts are defined after `Function.prototype.bind` as we
    // use it in defining shortcuts.
    var owns = call.bind(ObjectPrototype.hasOwnProperty);
    var toStr = call.bind(ObjectPrototype.toString);
    var arraySlice = call.bind(array_slice);
    var arraySliceApply = apply.bind(array_slice);
    /* globals document */
    if (typeof document === 'object' && document && document.documentElement) {
        try {
            arraySlice(document.documentElement.childNodes);
        } catch (e) {
            var origArraySlice = arraySlice;
            var origArraySliceApply = arraySliceApply;
            arraySlice = function arraySliceIE(arr) {
                var r = [];
                var i = arr.length;
                while (i-- > 0) {
                    r[i] = arr[i];
                }
                return origArraySliceApply(r, origArraySlice(arguments, 1));
            };
            arraySliceApply = function arraySliceApplyIE(arr, args) {
                return origArraySliceApply(arraySlice(arr), args);
            };
        }
    }
    var strSlice = call.bind(StringPrototype.slice);
    var strSplit = call.bind(StringPrototype.split);
    var strIndexOf = call.bind(StringPrototype.indexOf);
    var pushCall = call.bind(array_push);
    var isEnum = call.bind(ObjectPrototype.propertyIsEnumerable);
    var arraySort = call.bind(ArrayPrototype.sort);

    //
    // Array
    // =====
    //

    var isArray = $Array.isArray || function isArray(obj) {
        return toStr(obj) === '[object Array]';
    };

    // ES5 15.4.4.12
    // http://es5.github.com/#x15.4.4.13
    // Return len+argCount.
    // [bugfix, ielt8]
    // IE < 8 bug: [].unshift(0) === undefined but should be "1"
    var hasUnshiftReturnValueBug = [].unshift(0) !== 1;
    defineProperties(ArrayPrototype, {
        unshift: function () {
            array_unshift.apply(this, arguments);
            return this.length;
        }
    }, hasUnshiftReturnValueBug);

    // ES5 15.4.3.2
    // http://es5.github.com/#x15.4.3.2
    // https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Array/isArray
    defineProperties($Array, { isArray: isArray });

    // The IsCallable() check in the Array functions
    // has been replaced with a strict check on the
    // internal class of the object to trap cases where
    // the provided function was actually a regular
    // expression literal, which in V8 and
    // JavaScriptCore is a typeof "function".  Only in
    // V8 are regular expression literals permitted as
    // reduce parameters, so it is desirable in the
    // general case for the shim to match the more
    // strict and common behavior of rejecting regular
    // expressions.

    // ES5 15.4.4.18
    // http://es5.github.com/#x15.4.4.18
    // https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/array/forEach

    // Check failure of by-index access of string characters (IE < 9)
    // and failure of `0 in boxedString` (Rhino)
    var boxedString = $Object('a');
    var splitString = boxedString[0] !== 'a' || !(0 in boxedString);

    var properlyBoxesContext = function properlyBoxed(method) {
        // Check node 0.6.21 bug where third parameter is not boxed
        var properlyBoxesNonStrict = true;
        var properlyBoxesStrict = true;
        var threwException = false;
        if (method) {
            try {
                method.call('foo', function (_, __, context) {
                    if (typeof context !== 'object') {
                        properlyBoxesNonStrict = false;
                    }
                });

                method.call([1], function () {
                    'use strict';

                    properlyBoxesStrict = typeof this === 'string';
                }, 'x');
            } catch (e) {
                threwException = true;
            }
        }
        return !!method && !threwException && properlyBoxesNonStrict && properlyBoxesStrict;
    };

    defineProperties(ArrayPrototype, {
        forEach: function forEach(callbackfn/*, thisArg*/) {
            var object = ES.ToObject(this);
            var self = splitString && isString(this) ? strSplit(this, '') : object;
            var i = -1;
            var length = ES.ToUint32(self.length);
            var T;
            if (arguments.length > 1) {
                T = arguments[1];
            }

            // If no callback function or if callback is not a callable function
            if (!isCallable(callbackfn)) {
                throw new TypeError('Array.prototype.forEach callback must be a function');
            }

            while (++i < length) {
                if (i in self) {
                    // Invoke the callback function with call, passing arguments:
                    // context, property value, property key, thisArg object
                    if (typeof T === 'undefined') {
                        callbackfn(self[i], i, object);
                    } else {
                        callbackfn.call(T, self[i], i, object);
                    }
                }
            }
        }
    }, !properlyBoxesContext(ArrayPrototype.forEach));

    // ES5 15.4.4.19
    // http://es5.github.com/#x15.4.4.19
    // https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/map
    defineProperties(ArrayPrototype, {
        map: function map(callbackfn/*, thisArg*/) {
            var object = ES.ToObject(this);
            var self = splitString && isString(this) ? strSplit(this, '') : object;
            var length = ES.ToUint32(self.length);
            var result = $Array(length);
            var T;
            if (arguments.length > 1) {
                T = arguments[1];
            }

            // If no callback function or if callback is not a callable function
            if (!isCallable(callbackfn)) {
                throw new TypeError('Array.prototype.map callback must be a function');
            }

            for (var i = 0; i < length; i++) {
                if (i in self) {
                    if (typeof T === 'undefined') {
                        result[i] = callbackfn(self[i], i, object);
                    } else {
                        result[i] = callbackfn.call(T, self[i], i, object);
                    }
                }
            }
            return result;
        }
    }, !properlyBoxesContext(ArrayPrototype.map));

    // ES5 15.4.4.20
    // http://es5.github.com/#x15.4.4.20
    // https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/filter
    defineProperties(ArrayPrototype, {
        filter: function filter(callbackfn/*, thisArg*/) {
            var object = ES.ToObject(this);
            var self = splitString && isString(this) ? strSplit(this, '') : object;
            var length = ES.ToUint32(self.length);
            var result = [];
            var value;
            var T;
            if (arguments.length > 1) {
                T = arguments[1];
            }

            // If no callback function or if callback is not a callable function
            if (!isCallable(callbackfn)) {
                throw new TypeError('Array.prototype.filter callback must be a function');
            }

            for (var i = 0; i < length; i++) {
                if (i in self) {
                    value = self[i];
                    if (typeof T === 'undefined' ? callbackfn(value, i, object) : callbackfn.call(T, value, i, object)) {
                        pushCall(result, value);
                    }
                }
            }
            return result;
        }
    }, !properlyBoxesContext(ArrayPrototype.filter));

    // ES5 15.4.4.16
    // http://es5.github.com/#x15.4.4.16
    // https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Array/every
    defineProperties(ArrayPrototype, {
        every: function every(callbackfn/*, thisArg*/) {
            var object = ES.ToObject(this);
            var self = splitString && isString(this) ? strSplit(this, '') : object;
            var length = ES.ToUint32(self.length);
            var T;
            if (arguments.length > 1) {
                T = arguments[1];
            }

            // If no callback function or if callback is not a callable function
            if (!isCallable(callbackfn)) {
                throw new TypeError('Array.prototype.every callback must be a function');
            }

            for (var i = 0; i < length; i++) {
                if (i in self && !(typeof T === 'undefined' ? callbackfn(self[i], i, object) : callbackfn.call(T, self[i], i, object))) {
                    return false;
                }
            }
            return true;
        }
    }, !properlyBoxesContext(ArrayPrototype.every));

    // ES5 15.4.4.17
    // http://es5.github.com/#x15.4.4.17
    // https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Array/some
    defineProperties(ArrayPrototype, {
        some: function some(callbackfn/*, thisArg */) {
            var object = ES.ToObject(this);
            var self = splitString && isString(this) ? strSplit(this, '') : object;
            var length = ES.ToUint32(self.length);
            var T;
            if (arguments.length > 1) {
                T = arguments[1];
            }

            // If no callback function or if callback is not a callable function
            if (!isCallable(callbackfn)) {
                throw new TypeError('Array.prototype.some callback must be a function');
            }

            for (var i = 0; i < length; i++) {
                if (i in self && (typeof T === 'undefined' ? callbackfn(self[i], i, object) : callbackfn.call(T, self[i], i, object))) {
                    return true;
                }
            }
            return false;
        }
    }, !properlyBoxesContext(ArrayPrototype.some));

    // ES5 15.4.4.21
    // http://es5.github.com/#x15.4.4.21
    // https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/reduce
    var reduceCoercesToObject = false;
    if (ArrayPrototype.reduce) {
        reduceCoercesToObject = typeof ArrayPrototype.reduce.call('es5', function (_, __, ___, list) {
            return list;
        }) === 'object';
    }
    defineProperties(ArrayPrototype, {
        reduce: function reduce(callbackfn/*, initialValue*/) {
            var object = ES.ToObject(this);
            var self = splitString && isString(this) ? strSplit(this, '') : object;
            var length = ES.ToUint32(self.length);

            // If no callback function or if callback is not a callable function
            if (!isCallable(callbackfn)) {
                throw new TypeError('Array.prototype.reduce callback must be a function');
            }

            // no value to return if no initial value and an empty array
            if (length === 0 && arguments.length === 1) {
                throw new TypeError('reduce of empty array with no initial value');
            }

            var i = 0;
            var result;
            if (arguments.length >= 2) {
                result = arguments[1];
            } else {
                do {
                    if (i in self) {
                        result = self[i++];
                        break;
                    }

                    // if array contains no values, no initial value to return
                    if (++i >= length) {
                        throw new TypeError('reduce of empty array with no initial value');
                    }
                } while (true);
            }

            for (; i < length; i++) {
                if (i in self) {
                    result = callbackfn(result, self[i], i, object);
                }
            }

            return result;
        }
    }, !reduceCoercesToObject);

    // ES5 15.4.4.22
    // http://es5.github.com/#x15.4.4.22
    // https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/reduceRight
    var reduceRightCoercesToObject = false;
    if (ArrayPrototype.reduceRight) {
        reduceRightCoercesToObject = typeof ArrayPrototype.reduceRight.call('es5', function (_, __, ___, list) {
            return list;
        }) === 'object';
    }
    defineProperties(ArrayPrototype, {
        reduceRight: function reduceRight(callbackfn/*, initial*/) {
            var object = ES.ToObject(this);
            var self = splitString && isString(this) ? strSplit(this, '') : object;
            var length = ES.ToUint32(self.length);

            // If no callback function or if callback is not a callable function
            if (!isCallable(callbackfn)) {
                throw new TypeError('Array.prototype.reduceRight callback must be a function');
            }

            // no value to return if no initial value, empty array
            if (length === 0 && arguments.length === 1) {
                throw new TypeError('reduceRight of empty array with no initial value');
            }

            var result;
            var i = length - 1;
            if (arguments.length >= 2) {
                result = arguments[1];
            } else {
                do {
                    if (i in self) {
                        result = self[i--];
                        break;
                    }

                    // if array contains no values, no initial value to return
                    if (--i < 0) {
                        throw new TypeError('reduceRight of empty array with no initial value');
                    }
                } while (true);
            }

            if (i < 0) {
                return result;
            }

            do {
                if (i in self) {
                    result = callbackfn(result, self[i], i, object);
                }
            } while (i--);

            return result;
        }
    }, !reduceRightCoercesToObject);

    // ES5 15.4.4.14
    // http://es5.github.com/#x15.4.4.14
    // https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Array/indexOf
    var hasFirefox2IndexOfBug = ArrayPrototype.indexOf && [0, 1].indexOf(1, 2) !== -1;
    defineProperties(ArrayPrototype, {
        indexOf: function indexOf(searchElement/*, fromIndex */) {
            var self = splitString && isString(this) ? strSplit(this, '') : ES.ToObject(this);
            var length = ES.ToUint32(self.length);

            if (length === 0) {
                return -1;
            }

            var i = 0;
            if (arguments.length > 1) {
                i = ES.ToInteger(arguments[1]);
            }

            // handle negative indices
            i = i >= 0 ? i : max(0, length + i);
            for (; i < length; i++) {
                if (i in self && self[i] === searchElement) {
                    return i;
                }
            }
            return -1;
        }
    }, hasFirefox2IndexOfBug);

    // ES5 15.4.4.15
    // http://es5.github.com/#x15.4.4.15
    // https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Array/lastIndexOf
    var hasFirefox2LastIndexOfBug = ArrayPrototype.lastIndexOf && [0, 1].lastIndexOf(0, -3) !== -1;
    defineProperties(ArrayPrototype, {
        lastIndexOf: function lastIndexOf(searchElement/*, fromIndex */) {
            var self = splitString && isString(this) ? strSplit(this, '') : ES.ToObject(this);
            var length = ES.ToUint32(self.length);

            if (length === 0) {
                return -1;
            }
            var i = length - 1;
            if (arguments.length > 1) {
                i = min(i, ES.ToInteger(arguments[1]));
            }
            // handle negative indices
            i = i >= 0 ? i : length - Math.abs(i);
            for (; i >= 0; i--) {
                if (i in self && searchElement === self[i]) {
                    return i;
                }
            }
            return -1;
        }
    }, hasFirefox2LastIndexOfBug);

    // ES5 15.4.4.12
    // http://es5.github.com/#x15.4.4.12
    var spliceNoopReturnsEmptyArray = (function () {
        var a = [1, 2];
        var result = a.splice();
        return a.length === 2 && isArray(result) && result.length === 0;
    }());
    defineProperties(ArrayPrototype, {
        // Safari 5.0 bug where .splice() returns undefined
        splice: function splice(start, deleteCount) {
            if (arguments.length === 0) {
                return [];
            } else {
                return array_splice.apply(this, arguments);
            }
        }
    }, !spliceNoopReturnsEmptyArray);

    var spliceWorksWithEmptyObject = (function () {
        var obj = {};
        ArrayPrototype.splice.call(obj, 0, 0, 1);
        return obj.length === 1;
    }());
    defineProperties(ArrayPrototype, {
        splice: function splice(start, deleteCount) {
            if (arguments.length === 0) {
                return [];
            }
            var args = arguments;
            this.length = max(ES.ToInteger(this.length), 0);
            if (arguments.length > 0 && typeof deleteCount !== 'number') {
                args = arraySlice(arguments);
                if (args.length < 2) {
                    pushCall(args, this.length - start);
                } else {
                    args[1] = ES.ToInteger(deleteCount);
                }
            }
            return array_splice.apply(this, args);
        }
    }, !spliceWorksWithEmptyObject);
    var spliceWorksWithLargeSparseArrays = (function () {
        // Per https://github.com/es-shims/es5-shim/issues/295
        // Safari 7/8 breaks with sparse arrays of size 1e5 or greater
        var arr = new $Array(1e5);
        // note: the index MUST be 8 or larger or the test will false pass
        arr[8] = 'x';
        arr.splice(1, 1);
        // note: this test must be defined *after* the indexOf shim
        // per https://github.com/es-shims/es5-shim/issues/313
        return arr.indexOf('x') === 7;
    }());
    var spliceWorksWithSmallSparseArrays = (function () {
        // Per https://github.com/es-shims/es5-shim/issues/295
        // Opera 12.15 breaks on this, no idea why.
        var n = 256;
        var arr = [];
        arr[n] = 'a';
        arr.splice(n + 1, 0, 'b');
        return arr[n] === 'a';
    }());
    defineProperties(ArrayPrototype, {
        splice: function splice(start, deleteCount) {
            var O = ES.ToObject(this);
            var A = [];
            var len = ES.ToUint32(O.length);
            var relativeStart = ES.ToInteger(start);
            var actualStart = relativeStart < 0 ? max((len + relativeStart), 0) : min(relativeStart, len);
            var actualDeleteCount = min(max(ES.ToInteger(deleteCount), 0), len - actualStart);

            var k = 0;
            var from;
            while (k < actualDeleteCount) {
                from = $String(actualStart + k);
                if (owns(O, from)) {
                    A[k] = O[from];
                }
                k += 1;
            }

            var items = arraySlice(arguments, 2);
            var itemCount = items.length;
            var to;
            if (itemCount < actualDeleteCount) {
                k = actualStart;
                var maxK = len - actualDeleteCount;
                while (k < maxK) {
                    from = $String(k + actualDeleteCount);
                    to = $String(k + itemCount);
                    if (owns(O, from)) {
                        O[to] = O[from];
                    } else {
                        delete O[to];
                    }
                    k += 1;
                }
                k = len;
                var minK = len - actualDeleteCount + itemCount;
                while (k > minK) {
                    delete O[k - 1];
                    k -= 1;
                }
            } else if (itemCount > actualDeleteCount) {
                k = len - actualDeleteCount;
                while (k > actualStart) {
                    from = $String(k + actualDeleteCount - 1);
                    to = $String(k + itemCount - 1);
                    if (owns(O, from)) {
                        O[to] = O[from];
                    } else {
                        delete O[to];
                    }
                    k -= 1;
                }
            }
            k = actualStart;
            for (var i = 0; i < items.length; ++i) {
                O[k] = items[i];
                k += 1;
            }
            O.length = len - actualDeleteCount + itemCount;

            return A;
        }
    }, !spliceWorksWithLargeSparseArrays || !spliceWorksWithSmallSparseArrays);

    var originalJoin = ArrayPrototype.join;
    var hasStringJoinBug;
    try {
        hasStringJoinBug = Array.prototype.join.call('123', ',') !== '1,2,3';
    } catch (e) {
        hasStringJoinBug = true;
    }
    if (hasStringJoinBug) {
        defineProperties(ArrayPrototype, {
            join: function join(separator) {
                var sep = typeof separator === 'undefined' ? ',' : separator;
                return originalJoin.call(isString(this) ? strSplit(this, '') : this, sep);
            }
        }, hasStringJoinBug);
    }

    var hasJoinUndefinedBug = [1, 2].join(undefined) !== '1,2';
    if (hasJoinUndefinedBug) {
        defineProperties(ArrayPrototype, {
            join: function join(separator) {
                var sep = typeof separator === 'undefined' ? ',' : separator;
                return originalJoin.call(this, sep);
            }
        }, hasJoinUndefinedBug);
    }

    var pushShim = function push(item) {
        var O = ES.ToObject(this);
        var n = ES.ToUint32(O.length);
        var i = 0;
        while (i < arguments.length) {
            O[n + i] = arguments[i];
            i += 1;
        }
        O.length = n + i;
        return n + i;
    };

    var pushIsNotGeneric = (function () {
        var obj = {};
        var result = Array.prototype.push.call(obj, undefined);
        return result !== 1 || obj.length !== 1 || typeof obj[0] !== 'undefined' || !owns(obj, 0);
    }());
    defineProperties(ArrayPrototype, {
        push: function push(item) {
            if (isArray(this)) {
                return array_push.apply(this, arguments);
            }
            return pushShim.apply(this, arguments);
        }
    }, pushIsNotGeneric);

    // This fixes a very weird bug in Opera 10.6 when pushing `undefined
    var pushUndefinedIsWeird = (function () {
        var arr = [];
        var result = arr.push(undefined);
        return result !== 1 || arr.length !== 1 || typeof arr[0] !== 'undefined' || !owns(arr, 0);
    }());
    defineProperties(ArrayPrototype, { push: pushShim }, pushUndefinedIsWeird);

    // ES5 15.2.3.14
    // http://es5.github.io/#x15.4.4.10
    // Fix boxed string bug
    defineProperties(ArrayPrototype, {
        slice: function (start, end) {
            var arr = isString(this) ? strSplit(this, '') : this;
            return arraySliceApply(arr, arguments);
        }
    }, splitString);

    var sortIgnoresNonFunctions = (function () {
        try {
            [1, 2].sort(null);
        } catch (e) {
            try {
                [1, 2].sort({});
            } catch (e2) {
                return false;
            }
        }
        return true;
    }());
    var sortThrowsOnRegex = (function () {
        // this is a problem in Firefox 4, in which `typeof /a/ === 'function'`
        try {
            [1, 2].sort(/a/);
            return false;
        } catch (e) {}
        return true;
    }());
    var sortIgnoresUndefined = (function () {
        // applies in IE 8, for one.
        try {
            [1, 2].sort(undefined);
            return true;
        } catch (e) {}
        return false;
    }());
    defineProperties(ArrayPrototype, {
        sort: function sort(compareFn) {
            if (typeof compareFn === 'undefined') {
                return arraySort(this);
            }
            if (!isCallable(compareFn)) {
                throw new TypeError('Array.prototype.sort callback must be a function');
            }
            return arraySort(this, compareFn);
        }
    }, sortIgnoresNonFunctions || !sortIgnoresUndefined || !sortThrowsOnRegex);

    //
    // Object
    // ======
    //

    // ES5 15.2.3.14
    // http://es5.github.com/#x15.2.3.14

    // http://whattheheadsaid.com/2010/10/a-safer-object-keys-compatibility-implementation
    var hasDontEnumBug = !isEnum({ 'toString': null }, 'toString'); // jscs:ignore disallowQuotedKeysInObjects
    var hasProtoEnumBug = isEnum(function () {}, 'prototype');
    var hasStringEnumBug = !owns('x', '0');
    var equalsConstructorPrototype = function (o) {
        var ctor = o.constructor;
        return ctor && ctor.prototype === o;
    };
    var excludedKeys = {
        $applicationCache: true,
        $console: true,
        $external: true,
        $frame: true,
        $frameElement: true,
        $frames: true,
        $innerHeight: true,
        $innerWidth: true,
        $onmozfullscreenchange: true,
        $onmozfullscreenerror: true,
        $outerHeight: true,
        $outerWidth: true,
        $pageXOffset: true,
        $pageYOffset: true,
        $parent: true,
        $scrollLeft: true,
        $scrollTop: true,
        $scrollX: true,
        $scrollY: true,
        $self: true,
        $webkitIndexedDB: true,
        $webkitStorageInfo: true,
        $window: true,

        $width: true,
        $height: true,
        $top: true,
        $localStorage: true
    };
    var hasAutomationEqualityBug = (function () {
        /* globals window */
        if (typeof window === 'undefined') {
            return false;
        }
        for (var k in window) {
            try {
                if (!excludedKeys['$' + k] && owns(window, k) && window[k] !== null && typeof window[k] === 'object') {
                    equalsConstructorPrototype(window[k]);
                }
            } catch (e) {
                return true;
            }
        }
        return false;
    }());
    var equalsConstructorPrototypeIfNotBuggy = function (object) {
        if (typeof window === 'undefined' || !hasAutomationEqualityBug) {
            return equalsConstructorPrototype(object);
        }
        try {
            return equalsConstructorPrototype(object);
        } catch (e) {
            return false;
        }
    };
    var dontEnums = [
        'toString',
        'toLocaleString',
        'valueOf',
        'hasOwnProperty',
        'isPrototypeOf',
        'propertyIsEnumerable',
        'constructor'
    ];
    var dontEnumsLength = dontEnums.length;

    // taken directly from https://github.com/ljharb/is-arguments/blob/master/index.js
    // can be replaced with require('is-arguments') if we ever use a build process instead
    var isStandardArguments = function isArguments(value) {
        return toStr(value) === '[object Arguments]';
    };
    var isLegacyArguments = function isArguments(value) {
        return value !== null
            && typeof value === 'object'
            && typeof value.length === 'number'
            && value.length >= 0
            && !isArray(value)
            && isCallable(value.callee);
    };
    var isArguments = isStandardArguments(arguments) ? isStandardArguments : isLegacyArguments;

    defineProperties($Object, {
        keys: function keys(object) {
            var isFn = isCallable(object);
            var isArgs = isArguments(object);
            var isObject = object !== null && typeof object === 'object';
            var isStr = isObject && isString(object);

            if (!isObject && !isFn && !isArgs) {
                throw new TypeError('Object.keys called on a non-object');
            }

            var theKeys = [];
            var skipProto = hasProtoEnumBug && isFn;
            if ((isStr && hasStringEnumBug) || isArgs) {
                for (var i = 0; i < object.length; ++i) {
                    pushCall(theKeys, $String(i));
                }
            }

            if (!isArgs) {
                for (var name in object) {
                    if (!(skipProto && name === 'prototype') && owns(object, name)) {
                        pushCall(theKeys, $String(name));
                    }
                }
            }

            if (hasDontEnumBug) {
                var skipConstructor = equalsConstructorPrototypeIfNotBuggy(object);
                for (var j = 0; j < dontEnumsLength; j++) {
                    var dontEnum = dontEnums[j];
                    if (!(skipConstructor && dontEnum === 'constructor') && owns(object, dontEnum)) {
                        pushCall(theKeys, dontEnum);
                    }
                }
            }
            return theKeys;
        }
    });

    var keysWorksWithArguments = $Object.keys && (function () {
        // Safari 5.0 bug
        return $Object.keys(arguments).length === 2;
    }(1, 2));
    var keysHasArgumentsLengthBug = $Object.keys && (function () {
        var argKeys = $Object.keys(arguments);
        return arguments.length !== 1 || argKeys.length !== 1 || argKeys[0] !== 1;
    }(1));
    var originalKeys = $Object.keys;
    defineProperties($Object, {
        keys: function keys(object) {
            if (isArguments(object)) {
                return originalKeys(arraySlice(object));
            } else {
                return originalKeys(object);
            }
        }
    }, !keysWorksWithArguments || keysHasArgumentsLengthBug);

    //
    // Date
    // ====
    //

    var hasNegativeMonthYearBug = new Date(-3509827329600292).getUTCMonth() !== 0;
    var aNegativeTestDate = new Date(-1509842289600292);
    var aPositiveTestDate = new Date(1449662400000);
    var hasToUTCStringFormatBug = aNegativeTestDate.toUTCString() !== 'Mon, 01 Jan -45875 11:59:59 GMT';
    var hasToDateStringFormatBug;
    var hasToStringFormatBug;
    var timeZoneOffset = aNegativeTestDate.getTimezoneOffset();
    if (timeZoneOffset < -720) {
        hasToDateStringFormatBug = aNegativeTestDate.toDateString() !== 'Tue Jan 02 -45875';
        hasToStringFormatBug = !(/^Thu Dec 10 2015 \d\d:\d\d:\d\d GMT[-+]\d\d\d\d(?: |$)/).test(String(aPositiveTestDate));
    } else {
        hasToDateStringFormatBug = aNegativeTestDate.toDateString() !== 'Mon Jan 01 -45875';
        hasToStringFormatBug = !(/^Wed Dec 09 2015 \d\d:\d\d:\d\d GMT[-+]\d\d\d\d(?: |$)/).test(String(aPositiveTestDate));
    }

    var originalGetFullYear = call.bind(Date.prototype.getFullYear);
    var originalGetMonth = call.bind(Date.prototype.getMonth);
    var originalGetDate = call.bind(Date.prototype.getDate);
    var originalGetUTCFullYear = call.bind(Date.prototype.getUTCFullYear);
    var originalGetUTCMonth = call.bind(Date.prototype.getUTCMonth);
    var originalGetUTCDate = call.bind(Date.prototype.getUTCDate);
    var originalGetUTCDay = call.bind(Date.prototype.getUTCDay);
    var originalGetUTCHours = call.bind(Date.prototype.getUTCHours);
    var originalGetUTCMinutes = call.bind(Date.prototype.getUTCMinutes);
    var originalGetUTCSeconds = call.bind(Date.prototype.getUTCSeconds);
    var originalGetUTCMilliseconds = call.bind(Date.prototype.getUTCMilliseconds);
    var dayName = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    var monthName = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    var daysInMonth = function daysInMonth(month, year) {
        return originalGetDate(new Date(year, month, 0));
    };

    defineProperties(Date.prototype, {
        getFullYear: function getFullYear() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var year = originalGetFullYear(this);
            if (year < 0 && originalGetMonth(this) > 11) {
                return year + 1;
            }
            return year;
        },
        getMonth: function getMonth() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var year = originalGetFullYear(this);
            var month = originalGetMonth(this);
            if (year < 0 && month > 11) {
                return 0;
            }
            return month;
        },
        getDate: function getDate() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var year = originalGetFullYear(this);
            var month = originalGetMonth(this);
            var date = originalGetDate(this);
            if (year < 0 && month > 11) {
                if (month === 12) {
                    return date;
                }
                var days = daysInMonth(0, year + 1);
                return (days - date) + 1;
            }
            return date;
        },
        getUTCFullYear: function getUTCFullYear() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var year = originalGetUTCFullYear(this);
            if (year < 0 && originalGetUTCMonth(this) > 11) {
                return year + 1;
            }
            return year;
        },
        getUTCMonth: function getUTCMonth() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var year = originalGetUTCFullYear(this);
            var month = originalGetUTCMonth(this);
            if (year < 0 && month > 11) {
                return 0;
            }
            return month;
        },
        getUTCDate: function getUTCDate() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var year = originalGetUTCFullYear(this);
            var month = originalGetUTCMonth(this);
            var date = originalGetUTCDate(this);
            if (year < 0 && month > 11) {
                if (month === 12) {
                    return date;
                }
                var days = daysInMonth(0, year + 1);
                return (days - date) + 1;
            }
            return date;
        }
    }, hasNegativeMonthYearBug);

    defineProperties(Date.prototype, {
        toUTCString: function toUTCString() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var day = originalGetUTCDay(this);
            var date = originalGetUTCDate(this);
            var month = originalGetUTCMonth(this);
            var year = originalGetUTCFullYear(this);
            var hour = originalGetUTCHours(this);
            var minute = originalGetUTCMinutes(this);
            var second = originalGetUTCSeconds(this);
            return dayName[day] + ', '
                + (date < 10 ? '0' + date : date) + ' '
                + monthName[month] + ' '
                + year + ' '
                + (hour < 10 ? '0' + hour : hour) + ':'
                + (minute < 10 ? '0' + minute : minute) + ':'
                + (second < 10 ? '0' + second : second) + ' GMT';
        }
    }, hasNegativeMonthYearBug || hasToUTCStringFormatBug);

    // Opera 12 has `,`
    defineProperties(Date.prototype, {
        toDateString: function toDateString() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var day = this.getDay();
            var date = this.getDate();
            var month = this.getMonth();
            var year = this.getFullYear();
            return dayName[day] + ' '
                + monthName[month] + ' '
                + (date < 10 ? '0' + date : date) + ' '
                + year;
        }
    }, hasNegativeMonthYearBug || hasToDateStringFormatBug);

    // can't use defineProperties here because of toString enumeration issue in IE <= 8
    if (hasNegativeMonthYearBug || hasToStringFormatBug) {
        Date.prototype.toString = function toString() {
            if (!this || !(this instanceof Date)) {
                throw new TypeError('this is not a Date object.');
            }
            var day = this.getDay();
            var date = this.getDate();
            var month = this.getMonth();
            var year = this.getFullYear();
            var hour = this.getHours();
            var minute = this.getMinutes();
            var second = this.getSeconds();
            var timezoneOffset = this.getTimezoneOffset();
            var hoursOffset = Math.floor(Math.abs(timezoneOffset) / 60);
            var minutesOffset = Math.floor(Math.abs(timezoneOffset) % 60);
            return dayName[day] + ' '
                + monthName[month] + ' '
                + (date < 10 ? '0' + date : date) + ' '
                + year + ' '
                + (hour < 10 ? '0' + hour : hour) + ':'
                + (minute < 10 ? '0' + minute : minute) + ':'
                + (second < 10 ? '0' + second : second) + ' GMT'
                + (timezoneOffset > 0 ? '-' : '+')
                + (hoursOffset < 10 ? '0' + hoursOffset : hoursOffset)
                + (minutesOffset < 10 ? '0' + minutesOffset : minutesOffset);
        };
        if (supportsDescriptors) {
            $Object.defineProperty(Date.prototype, 'toString', {
                configurable: true,
                enumerable: false,
                writable: true
            });
        }
    }

    // ES5 15.9.5.43
    // http://es5.github.com/#x15.9.5.43
    // This function returns a String value represent the instance in time
    // represented by this Date object. The format of the String is the Date Time
    // string format defined in 15.9.1.15. All fields are present in the String.
    // The time zone is always UTC, denoted by the suffix Z. If the time value of
    // this object is not a finite Number a RangeError exception is thrown.
    var negativeDate = -62198755200000;
    var negativeYearString = '-000001';
    var hasNegativeDateBug = Date.prototype.toISOString && new Date(negativeDate).toISOString().indexOf(negativeYearString) === -1; // eslint-disable-line max-len
    var hasSafari51DateBug = Date.prototype.toISOString && new Date(-1).toISOString() !== '1969-12-31T23:59:59.999Z';

    var getTime = call.bind(Date.prototype.getTime);

    defineProperties(Date.prototype, {
        toISOString: function toISOString() {
            if (!isFinite(this) || !isFinite(getTime(this))) {
                // Adope Photoshop requires the second check.
                throw new RangeError('Date.prototype.toISOString called on non-finite value.');
            }

            var year = originalGetUTCFullYear(this);

            var month = originalGetUTCMonth(this);
            // see https://github.com/es-shims/es5-shim/issues/111
            year += Math.floor(month / 12);
            month = ((month % 12) + 12) % 12;

            // the date time string format is specified in 15.9.1.15.
            var result = [
                month + 1,
                originalGetUTCDate(this),
                originalGetUTCHours(this),
                originalGetUTCMinutes(this),
                originalGetUTCSeconds(this)
            ];
            year = (
                (year < 0 ? '-' : (year > 9999 ? '+' : ''))
                + strSlice('00000' + Math.abs(year), (0 <= year && year <= 9999) ? -4 : -6)
            );

            for (var i = 0; i < result.length; ++i) {
                // pad months, days, hours, minutes, and seconds to have two digits.
                result[i] = strSlice('00' + result[i], -2);
            }
            // pad milliseconds to have three digits.
            return (
                year + '-' + arraySlice(result, 0, 2).join('-')
                + 'T' + arraySlice(result, 2).join(':') + '.'
                + strSlice('000' + originalGetUTCMilliseconds(this), -3) + 'Z'
            );
        }
    }, hasNegativeDateBug || hasSafari51DateBug);

    // ES5 15.9.5.44
    // http://es5.github.com/#x15.9.5.44
    // This function provides a String representation of a Date object for use by
    // JSON.stringify (15.12.3).
    var dateToJSONIsSupported = (function () {
        try {
            return Date.prototype.toJSON
                && new Date(NaN).toJSON() === null
                && new Date(negativeDate).toJSON().indexOf(negativeYearString) !== -1
                && Date.prototype.toJSON.call({ // generic
                    toISOString: function () { return true; }
                });
        } catch (e) {
            return false;
        }
    }());
    if (!dateToJSONIsSupported) {
        Date.prototype.toJSON = function toJSON(key) {
            // When the toJSON method is called with argument key, the following
            // steps are taken:

            // 1.  Let O be the result of calling ToObject, giving it the this
            // value as its argument.
            // 2. Let tv be ES.ToPrimitive(O, hint Number).
            var O = $Object(this);
            var tv = ES.ToPrimitive(O);
            // 3. If tv is a Number and is not finite, return null.
            if (typeof tv === 'number' && !isFinite(tv)) {
                return null;
            }
            // 4. Let toISO be the result of calling the [[Get]] internal method of
            // O with argument "toISOString".
            var toISO = O.toISOString;
            // 5. If IsCallable(toISO) is false, throw a TypeError exception.
            if (!isCallable(toISO)) {
                throw new TypeError('toISOString property is not callable');
            }
            // 6. Return the result of calling the [[Call]] internal method of
            //  toISO with O as the this value and an empty argument list.
            return toISO.call(O);

            // NOTE 1 The argument is ignored.

            // NOTE 2 The toJSON function is intentionally generic; it does not
            // require that its this value be a Date object. Therefore, it can be
            // transferred to other kinds of objects for use as a method. However,
            // it does require that any such object have a toISOString method. An
            // object is free to use the argument key to filter its
            // stringification.
        };
    }

    // ES5 15.9.4.2
    // http://es5.github.com/#x15.9.4.2
    // based on work shared by Daniel Friesen (dantman)
    // http://gist.github.com/303249
    var supportsExtendedYears = Date.parse('+033658-09-27T01:46:40.000Z') === 1e15;
    var acceptsInvalidDates = !isNaN(Date.parse('2012-04-04T24:00:00.500Z')) || !isNaN(Date.parse('2012-11-31T23:59:59.000Z')) || !isNaN(Date.parse('2012-12-31T23:59:60.000Z'));
    var doesNotParseY2KNewYear = isNaN(Date.parse('2000-01-01T00:00:00.000Z'));
    if (doesNotParseY2KNewYear || acceptsInvalidDates || !supportsExtendedYears) {
        // XXX global assignment won't work in embeddings that use
        // an alternate object for the context.
        /* global Date: true */
        var maxSafeUnsigned32Bit = Math.pow(2, 31) - 1;
        var hasSafariSignedIntBug = isActualNaN(new Date(1970, 0, 1, 0, 0, 0, maxSafeUnsigned32Bit + 1).getTime());
        // eslint-disable-next-line no-implicit-globals, no-global-assign
        Date = (function (NativeDate) {
            // Date.length === 7
            var DateShim = function Date(Y, M, D, h, m, s, ms) {
                var length = arguments.length;
                var date;
                if (this instanceof NativeDate) {
                    var seconds = s;
                    var millis = ms;
                    if (hasSafariSignedIntBug && length >= 7 && ms > maxSafeUnsigned32Bit) {
                        // work around a Safari 8/9 bug where it treats the seconds as signed
                        var msToShift = Math.floor(ms / maxSafeUnsigned32Bit) * maxSafeUnsigned32Bit;
                        var sToShift = Math.floor(msToShift / 1e3);
                        seconds += sToShift;
                        millis -= sToShift * 1e3;
                    }
                    date = length === 1 && $String(Y) === Y // isString(Y)
                        // We explicitly pass it through parse:
                        ? new NativeDate(DateShim.parse(Y))
                        // We have to manually make calls depending on argument
                        // length here
                        : length >= 7 ? new NativeDate(Y, M, D, h, m, seconds, millis)
                            : length >= 6 ? new NativeDate(Y, M, D, h, m, seconds)
                                : length >= 5 ? new NativeDate(Y, M, D, h, m)
                                    : length >= 4 ? new NativeDate(Y, M, D, h)
                                        : length >= 3 ? new NativeDate(Y, M, D)
                                            : length >= 2 ? new NativeDate(Y, M)
                                                : length >= 1 ? new NativeDate(Y instanceof NativeDate ? +Y : Y)
                                                    : new NativeDate();
                } else {
                    date = NativeDate.apply(this, arguments);
                }
                if (!isPrimitive(date)) {
                    // Prevent mixups with unfixed Date object
                    defineProperties(date, { constructor: DateShim }, true);
                }
                return date;
            };

            // 15.9.1.15 Date Time String Format.
            var isoDateExpression = new RegExp('^'
                + '(\\d{4}|[+-]\\d{6})' // four-digit year capture or sign + 6-digit extended year
                + '(?:-(\\d{2})' // optional month capture
                + '(?:-(\\d{2})' // optional day capture
                + '(?:' // capture hours:minutes:seconds.milliseconds
                    + 'T(\\d{2})' // hours capture
                    + ':(\\d{2})' // minutes capture
                    + '(?:' // optional :seconds.milliseconds
                        + ':(\\d{2})' // seconds capture
                        + '(?:(\\.\\d{1,}))?' // milliseconds capture
                    + ')?'
                + '(' // capture UTC offset component
                    + 'Z|' // UTC capture
                    + '(?:' // offset specifier +/-hours:minutes
                        + '([-+])' // sign capture
                        + '(\\d{2})' // hours offset capture
                        + ':(\\d{2})' // minutes offset capture
                    + ')'
                + ')?)?)?)?'
            + '$');

            var months = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365];

            var dayFromMonth = function dayFromMonth(year, month) {
                var t = month > 1 ? 1 : 0;
                return (
                    months[month]
                    + Math.floor((year - 1969 + t) / 4)
                    - Math.floor((year - 1901 + t) / 100)
                    + Math.floor((year - 1601 + t) / 400)
                    + (365 * (year - 1970))
                );
            };

            var toUTC = function toUTC(t) {
                var s = 0;
                var ms = t;
                if (hasSafariSignedIntBug && ms > maxSafeUnsigned32Bit) {
                    // work around a Safari 8/9 bug where it treats the seconds as signed
                    var msToShift = Math.floor(ms / maxSafeUnsigned32Bit) * maxSafeUnsigned32Bit;
                    var sToShift = Math.floor(msToShift / 1e3);
                    s += sToShift;
                    ms -= sToShift * 1e3;
                }
                return $Number(new NativeDate(1970, 0, 1, 0, 0, s, ms));
            };

            // Copy any custom methods a 3rd party library may have added
            for (var key in NativeDate) {
                if (owns(NativeDate, key)) {
                    DateShim[key] = NativeDate[key];
                }
            }

            // Copy "native" methods explicitly; they may be non-enumerable
            defineProperties(DateShim, {
                now: NativeDate.now,
                UTC: NativeDate.UTC
            }, true);
            DateShim.prototype = NativeDate.prototype;
            defineProperties(DateShim.prototype, { constructor: DateShim }, true);

            // Upgrade Date.parse to handle simplified ISO 8601 strings
            var parseShim = function parse(string) {
                var match = isoDateExpression.exec(string);
                if (match) {
                    // parse months, days, hours, minutes, seconds, and milliseconds
                    // provide default values if necessary
                    // parse the UTC offset component
                    var year = $Number(match[1]),
                        month = $Number(match[2] || 1) - 1,
                        day = $Number(match[3] || 1) - 1,
                        hour = $Number(match[4] || 0),
                        minute = $Number(match[5] || 0),
                        second = $Number(match[6] || 0),
                        millisecond = Math.floor($Number(match[7] || 0) * 1000),
                        // When time zone is missed, local offset should be used
                        // (ES 5.1 bug)
                        // see https://bugs.ecmascript.org/show_bug.cgi?id=112
                        isLocalTime = Boolean(match[4] && !match[8]),
                        signOffset = match[9] === '-' ? 1 : -1,
                        hourOffset = $Number(match[10] || 0),
                        minuteOffset = $Number(match[11] || 0),
                        result;
                    var hasMinutesOrSecondsOrMilliseconds = minute > 0 || second > 0 || millisecond > 0;
                    if (
                        hour < (hasMinutesOrSecondsOrMilliseconds ? 24 : 25)
                        && minute < 60 && second < 60 && millisecond < 1000
                        && month > -1 && month < 12 && hourOffset < 24
                        && minuteOffset < 60 // detect invalid offsets
                        && day > -1
                        && day < (dayFromMonth(year, month + 1) - dayFromMonth(year, month))
                    ) {
                        result = (
                            ((dayFromMonth(year, month) + day) * 24)
                            + hour
                            + (hourOffset * signOffset)
                        ) * 60;
                        result = ((
                            ((result + minute + (minuteOffset * signOffset)) * 60)
                            + second
                        ) * 1000) + millisecond;
                        if (isLocalTime) {
                            result = toUTC(result);
                        }
                        if (-8.64e15 <= result && result <= 8.64e15) {
                            return result;
                        }
                    }
                    return NaN;
                }
                return NativeDate.parse.apply(this, arguments);
            };
            defineProperties(DateShim, { parse: parseShim });

            return DateShim;
        }(Date));
        /* global Date: false */
    }

    // ES5 15.9.4.4
    // http://es5.github.com/#x15.9.4.4
    if (!Date.now) {
        Date.now = function now() {
            return new Date().getTime();
        };
    }

    //
    // Number
    // ======
    //

    // ES5.1 15.7.4.5
    // http://es5.github.com/#x15.7.4.5
    var hasToFixedBugs = NumberPrototype.toFixed && (
        (0.00008).toFixed(3) !== '0.000'
        || (0.9).toFixed(0) !== '1'
        || (1.255).toFixed(2) !== '1.25'
        || (1000000000000000128).toFixed(0) !== '1000000000000000128'
    );

    var toFixedHelpers = {
        base: 1e7,
        size: 6,
        data: [0, 0, 0, 0, 0, 0],
        multiply: function multiply(n, c) {
            var i = -1;
            var c2 = c;
            while (++i < toFixedHelpers.size) {
                c2 += n * toFixedHelpers.data[i];
                toFixedHelpers.data[i] = c2 % toFixedHelpers.base;
                c2 = Math.floor(c2 / toFixedHelpers.base);
            }
        },
        divide: function divide(n) {
            var i = toFixedHelpers.size;
            var c = 0;
            while (--i >= 0) {
                c += toFixedHelpers.data[i];
                toFixedHelpers.data[i] = Math.floor(c / n);
                c = (c % n) * toFixedHelpers.base;
            }
        },
        numToString: function numToString() {
            var i = toFixedHelpers.size;
            var s = '';
            while (--i >= 0) {
                if (s !== '' || i === 0 || toFixedHelpers.data[i] !== 0) {
                    var t = $String(toFixedHelpers.data[i]);
                    if (s === '') {
                        s = t;
                    } else {
                        s += strSlice('0000000', 0, 7 - t.length) + t;
                    }
                }
            }
            return s;
        },
        pow: function pow(x, n, acc) {
            return (n === 0 ? acc : (n % 2 === 1 ? pow(x, n - 1, acc * x) : pow(x * x, n / 2, acc)));
        },
        log: function log(x) {
            var n = 0;
            var x2 = x;
            while (x2 >= 4096) {
                n += 12;
                x2 /= 4096;
            }
            while (x2 >= 2) {
                n += 1;
                x2 /= 2;
            }
            return n;
        }
    };

    var toFixedShim = function toFixed(fractionDigits) {
        var f, x, s, m, e, z, j, k;

        // Test for NaN and round fractionDigits down
        f = $Number(fractionDigits);
        f = isActualNaN(f) ? 0 : Math.floor(f);

        if (f < 0 || f > 20) {
            throw new RangeError('Number.toFixed called with invalid number of decimals');
        }

        x = $Number(this);

        if (isActualNaN(x)) {
            return 'NaN';
        }

        // If it is too big or small, return the string value of the number
        if (x <= -1e21 || x >= 1e21) {
            return $String(x);
        }

        s = '';

        if (x < 0) {
            s = '-';
            x = -x;
        }

        m = '0';

        if (x > 1e-21) {
            // 1e-21 < x < 1e21
            // -70 < log2(x) < 70
            e = toFixedHelpers.log(x * toFixedHelpers.pow(2, 69, 1)) - 69;
            z = (e < 0 ? x * toFixedHelpers.pow(2, -e, 1) : x / toFixedHelpers.pow(2, e, 1));
            z *= 0x10000000000000; // Math.pow(2, 52);
            e = 52 - e;

            // -18 < e < 122
            // x = z / 2 ^ e
            if (e > 0) {
                toFixedHelpers.multiply(0, z);
                j = f;

                while (j >= 7) {
                    toFixedHelpers.multiply(1e7, 0);
                    j -= 7;
                }

                toFixedHelpers.multiply(toFixedHelpers.pow(10, j, 1), 0);
                j = e - 1;

                while (j >= 23) {
                    toFixedHelpers.divide(1 << 23);
                    j -= 23;
                }

                toFixedHelpers.divide(1 << j);
                toFixedHelpers.multiply(1, 1);
                toFixedHelpers.divide(2);
                m = toFixedHelpers.numToString();
            } else {
                toFixedHelpers.multiply(0, z);
                toFixedHelpers.multiply(1 << (-e), 0);
                m = toFixedHelpers.numToString() + strSlice('0.00000000000000000000', 2, 2 + f);
            }
        }

        if (f > 0) {
            k = m.length;

            if (k <= f) {
                m = s + strSlice('0.0000000000000000000', 0, f - k + 2) + m;
            } else {
                m = s + strSlice(m, 0, k - f) + '.' + strSlice(m, k - f);
            }
        } else {
            m = s + m;
        }

        return m;
    };
    defineProperties(NumberPrototype, { toFixed: toFixedShim }, hasToFixedBugs);

    var hasToPrecisionUndefinedBug = (function () {
        try {
            return 1.0.toPrecision(undefined) === '1';
        } catch (e) {
            return true;
        }
    }());
    var originalToPrecision = NumberPrototype.toPrecision;
    defineProperties(NumberPrototype, {
        toPrecision: function toPrecision(precision) {
            return typeof precision === 'undefined' ? originalToPrecision.call(this) : originalToPrecision.call(this, precision);
        }
    }, hasToPrecisionUndefinedBug);

    //
    // String
    // ======
    //

    // ES5 15.5.4.14
    // http://es5.github.com/#x15.5.4.14

    // [bugfix, IE lt 9, firefox 4, Konqueror, Opera, obscure browsers]
    // Many browsers do not split properly with regular expressions or they
    // do not perform the split correctly under obscure conditions.
    // See http://blog.stevenlevithan.com/archives/cross-browser-split
    // I've tested in many browsers and this seems to cover the deviant ones:
    //    'ab'.split(/(?:ab)*/) should be ["", ""], not [""]
    //    '.'.split(/(.?)(.?)/) should be ["", ".", "", ""], not ["", ""]
    //    'tesst'.split(/(s)*/) should be ["t", undefined, "e", "s", "t"], not
    //       [undefined, "t", undefined, "e", ...]
    //    ''.split(/.?/) should be [], not [""]
    //    '.'.split(/()()/) should be ["."], not ["", "", "."]

    if (
        'ab'.split(/(?:ab)*/).length !== 2
        || '.'.split(/(.?)(.?)/).length !== 4
        || 'tesst'.split(/(s)*/)[1] === 't'
        || 'test'.split(/(?:)/, -1).length !== 4
        || ''.split(/.?/).length
        || '.'.split(/()()/).length > 1
    ) {
        (function () {
            var compliantExecNpcg = typeof (/()??/).exec('')[1] === 'undefined'; // NPCG: nonparticipating capturing group
            var maxSafe32BitInt = Math.pow(2, 32) - 1;

            StringPrototype.split = function (separator, limit) {
                var string = String(this);
                if (typeof separator === 'undefined' && limit === 0) {
                    return [];
                }

                // If `separator` is not a regex, use native split
                if (!isRegex(separator)) {
                    return strSplit(this, separator, limit);
                }

                var output = [];
                var flags = (separator.ignoreCase ? 'i' : '')
                            + (separator.multiline ? 'm' : '')
                            + (separator.unicode ? 'u' : '') // in ES6
                            + (separator.sticky ? 'y' : ''), // Firefox 3+ and ES6
                    lastLastIndex = 0,
                    // Make `global` and avoid `lastIndex` issues by working with a copy
                    separator2, match, lastIndex, lastLength;
                var separatorCopy = new RegExp(separator.source, flags + 'g');
                if (!compliantExecNpcg) {
                    // Doesn't need flags gy, but they don't hurt
                    separator2 = new RegExp('^' + separatorCopy.source + '$(?!\\s)', flags);
                }
                /* Values for `limit`, per the spec:
                 * If undefined: 4294967295 // maxSafe32BitInt
                 * If 0, Infinity, or NaN: 0
                 * If positive number: limit = Math.floor(limit); if (limit > 4294967295) limit -= 4294967296;
                 * If negative number: 4294967296 - Math.floor(Math.abs(limit))
                 * If other: Type-convert, then use the above rules
                 */
                var splitLimit = typeof limit === 'undefined' ? maxSafe32BitInt : ES.ToUint32(limit);
                match = separatorCopy.exec(string);
                while (match) {
                    // `separatorCopy.lastIndex` is not reliable cross-browser
                    lastIndex = match.index + match[0].length;
                    if (lastIndex > lastLastIndex) {
                        pushCall(output, strSlice(string, lastLastIndex, match.index));
                        // Fix browsers whose `exec` methods don't consistently return `undefined` for
                        // nonparticipating capturing groups
                        if (!compliantExecNpcg && match.length > 1) {
                            /* eslint-disable no-loop-func */
                            match[0].replace(separator2, function () {
                                for (var i = 1; i < arguments.length - 2; i++) {
                                    if (typeof arguments[i] === 'undefined') {
                                        match[i] = void 0;
                                    }
                                }
                            });
                            /* eslint-enable no-loop-func */
                        }
                        if (match.length > 1 && match.index < string.length) {
                            array_push.apply(output, arraySlice(match, 1));
                        }
                        lastLength = match[0].length;
                        lastLastIndex = lastIndex;
                        if (output.length >= splitLimit) {
                            break;
                        }
                    }
                    if (separatorCopy.lastIndex === match.index) {
                        separatorCopy.lastIndex++; // Avoid an infinite loop
                    }
                    match = separatorCopy.exec(string);
                }
                if (lastLastIndex === string.length) {
                    if (lastLength || !separatorCopy.test('')) {
                        pushCall(output, '');
                    }
                } else {
                    pushCall(output, strSlice(string, lastLastIndex));
                }
                return output.length > splitLimit ? arraySlice(output, 0, splitLimit) : output;
            };
        }());

    // [bugfix, chrome]
    // If separator is undefined, then the result array contains just one String,
    // which is the this value (converted to a String). If limit is not undefined,
    // then the output array is truncated so that it contains no more than limit
    // elements.
    // "0".split(undefined, 0) -> []
    } else if ('0'.split(void 0, 0).length) {
        StringPrototype.split = function split(separator, limit) {
            if (typeof separator === 'undefined' && limit === 0) {
                return [];
            }
            return strSplit(this, separator, limit);
        };
    }

    var str_replace = StringPrototype.replace;
    var replaceReportsGroupsCorrectly = (function () {
        var groups = [];
        'x'.replace(/x(.)?/g, function (match, group) {
            pushCall(groups, group);
        });
        return groups.length === 1 && typeof groups[0] === 'undefined';
    }());

    if (!replaceReportsGroupsCorrectly) {
        StringPrototype.replace = function replace(searchValue, replaceValue) {
            var isFn = isCallable(replaceValue);
            var hasCapturingGroups = isRegex(searchValue) && (/\)[*?]/).test(searchValue.source);
            if (!isFn || !hasCapturingGroups) {
                return str_replace.call(this, searchValue, replaceValue);
            } else {
                var wrappedReplaceValue = function (match) {
                    var length = arguments.length;
                    var originalLastIndex = searchValue.lastIndex;
                    searchValue.lastIndex = 0;
                    var args = searchValue.exec(match) || [];
                    searchValue.lastIndex = originalLastIndex;
                    pushCall(args, arguments[length - 2], arguments[length - 1]);
                    return replaceValue.apply(this, args);
                };
                return str_replace.call(this, searchValue, wrappedReplaceValue);
            }
        };
    }

    // ECMA-262, 3rd B.2.3
    // Not an ECMAScript standard, although ECMAScript 3rd Edition has a
    // non-normative section suggesting uniform semantics and it should be
    // normalized across all browsers
    // [bugfix, IE lt 9] IE < 9 substr() with negative value not working in IE
    var string_substr = StringPrototype.substr;
    var hasNegativeSubstrBug = ''.substr && '0b'.substr(-1) !== 'b';
    defineProperties(StringPrototype, {
        substr: function substr(start, length) {
            var normalizedStart = start;
            if (start < 0) {
                normalizedStart = max(this.length + start, 0);
            }
            return string_substr.call(this, normalizedStart, length);
        }
    }, hasNegativeSubstrBug);

    // ES5 15.5.4.20
    // whitespace from: http://es5.github.io/#x15.5.4.20
    var ws = '\x09\x0A\x0B\x0C\x0D\x20\xA0\u1680\u180E\u2000\u2001\u2002\u2003'
        + '\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u202F\u205F\u3000\u2028'
        + '\u2029\uFEFF';
    var zeroWidth = '\u200b';
    var wsRegexChars = '[' + ws + ']';
    var trimBeginRegexp = new RegExp('^' + wsRegexChars + wsRegexChars + '*');
    var trimEndRegexp = new RegExp(wsRegexChars + wsRegexChars + '*$');
    var hasTrimWhitespaceBug = StringPrototype.trim && (ws.trim() || !zeroWidth.trim());
    defineProperties(StringPrototype, {
        // http://blog.stevenlevithan.com/archives/faster-trim-javascript
        // http://perfectionkills.com/whitespace-deviations/
        trim: function trim() {
            if (typeof this === 'undefined' || this === null) {
                throw new TypeError("can't convert " + this + ' to object');
            }
            return $String(this).replace(trimBeginRegexp, '').replace(trimEndRegexp, '');
        }
    }, hasTrimWhitespaceBug);
    var trim = call.bind(String.prototype.trim);

    var hasLastIndexBug = StringPrototype.lastIndexOf && 'abcあい'.lastIndexOf('あい', 2) !== -1;
    defineProperties(StringPrototype, {
        lastIndexOf: function lastIndexOf(searchString) {
            if (typeof this === 'undefined' || this === null) {
                throw new TypeError("can't convert " + this + ' to object');
            }
            var S = $String(this);
            var searchStr = $String(searchString);
            var numPos = arguments.length > 1 ? $Number(arguments[1]) : NaN;
            var pos = isActualNaN(numPos) ? Infinity : ES.ToInteger(numPos);
            var start = min(max(pos, 0), S.length);
            var searchLen = searchStr.length;
            var k = start + searchLen;
            while (k > 0) {
                k = max(0, k - searchLen);
                var index = strIndexOf(strSlice(S, k, start + searchLen), searchStr);
                if (index !== -1) {
                    return k + index;
                }
            }
            return -1;
        }
    }, hasLastIndexBug);

    var originalLastIndexOf = StringPrototype.lastIndexOf;
    defineProperties(StringPrototype, {
        lastIndexOf: function lastIndexOf(searchString) {
            return originalLastIndexOf.apply(this, arguments);
        }
    }, StringPrototype.lastIndexOf.length !== 1);

    // ES-5 15.1.2.2
    // eslint-disable-next-line radix
    if (parseInt(ws + '08') !== 8 || parseInt(ws + '0x16') !== 22) {
        /* global parseInt: true */
        parseInt = (function (origParseInt) {
            var hexRegex = /^[-+]?0[xX]/;
            return function parseInt(str, radix) {
                if (typeof str === 'symbol') {
                    // handle Symbols in node 8.3/8.4
                    // eslint-disable-next-line no-implicit-coercion, no-unused-expressions
                    '' + str; // jscs:ignore disallowImplicitTypeConversion
                }

                var string = trim(String(str));
                var defaultedRadix = $Number(radix) || (hexRegex.test(string) ? 16 : 10);
                return origParseInt(string, defaultedRadix);
            };
        }(parseInt));
    }

    // https://es5.github.io/#x15.1.2.3
    if (1 / parseFloat('-0') !== -Infinity) {
        /* global parseFloat: true */
        parseFloat = (function (origParseFloat) {
            return function parseFloat(string) {
                var inputString = trim(String(string));
                var result = origParseFloat(inputString);
                return result === 0 && strSlice(inputString, 0, 1) === '-' ? -0 : result;
            };
        }(parseFloat));
    }

    if (String(new RangeError('test')) !== 'RangeError: test') {
        var errorToStringShim = function toString() {
            if (typeof this === 'undefined' || this === null) {
                throw new TypeError("can't convert " + this + ' to object');
            }
            var name = this.name;
            if (typeof name === 'undefined') {
                name = 'Error';
            } else if (typeof name !== 'string') {
                name = $String(name);
            }
            var msg = this.message;
            if (typeof msg === 'undefined') {
                msg = '';
            } else if (typeof msg !== 'string') {
                msg = $String(msg);
            }
            if (!name) {
                return msg;
            }
            if (!msg) {
                return name;
            }
            return name + ': ' + msg;
        };
        // can't use defineProperties here because of toString enumeration issue in IE <= 8
        Error.prototype.toString = errorToStringShim;
    }

    if (supportsDescriptors) {
        var ensureNonEnumerable = function (obj, prop) {
            if (isEnum(obj, prop)) {
                var desc = Object.getOwnPropertyDescriptor(obj, prop);
                if (desc.configurable) {
                    desc.enumerable = false;
                    Object.defineProperty(obj, prop, desc);
                }
            }
        };
        ensureNonEnumerable(Error.prototype, 'message');
        if (Error.prototype.message !== '') {
            Error.prototype.message = '';
        }
        ensureNonEnumerable(Error.prototype, 'name');
    }

    if (String(/a/mig) !== '/a/gim') {
        var regexToString = function toString() {
            var str = '/' + this.source + '/';
            if (this.global) {
                str += 'g';
            }
            if (this.ignoreCase) {
                str += 'i';
            }
            if (this.multiline) {
                str += 'm';
            }
            return str;
        };
        // can't use defineProperties here because of toString enumeration issue in IE <= 8
        RegExp.prototype.toString = regexToString;
    }
}));


/***/ }),

/***/ "./node_modules/_fetch-polyfill2@0.0.3@fetch-polyfill2/dist/index.js":
/*!***************************************************************************!*\
  !*** ./node_modules/_fetch-polyfill2@0.0.3@fetch-polyfill2/dist/index.js ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

(function webpackUniversalModuleDefinition(root, factory) {
	if(true)
		module.exports = factory();
	else {}
})(this, function() {
return /******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	var Request = __webpack_require__(1)
	var Response = __webpack_require__(5)
	var Headers = __webpack_require__(2)
	var Transport = __webpack_require__(6)

	if (![].forEach) {
	    Array.prototype.forEach = function (fn, scope) {
	        'use strict'
	        var i, len
	        for (i = 0, len = this.length; i < len; ++i) {
	            if (i in this) {
	                fn.call(scope, this[i], i, this)
	            }
	        }
	    }
	}
	if (!'司徒正美'.trim) {
	    var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g
	    String.prototype.trim = function () {
	        return this.replace(rtrim, '')
	    }
	}
	function headers(xhr) {
	    var head = new Headers()
	    if (xhr.getAllResponseHeaders) {
	        var headerStr = xhr.getAllResponseHeaders() || ''
	        if (/\S/.test(headerStr)) {
	            //http://www.w3.org/TR/XMLHttpRequest/#the-getallresponseheaders-method
	            var headerPairs = headerStr.split('\u000d\u000a');
	            for (var i = 0; i < headerPairs.length; i++) {
	                var headerPair = headerPairs[i];
	                // Can't use split() here because it does the wrong thing
	                // if the header value has the string ": " in it.
	                var index = headerPair.indexOf('\u003a\u0020')
	                if (index > 0) {
	                    var key = headerPair.substring(0, index).trim()
	                    var value = headerPair.substring(index + 2).trim()
	                    head.append(key, value)
	                }
	            }
	        }
	    }
	    return head
	}
	function fetch(input, init) {
		console.log("【Debugger2】: 666666666666666")
	    return new Promise(function (resolve, reject) {
	        var request
	        if (!init && (init instanceof Request)) {
	            request = input
	        } else {
	            request = new Request(input, init)
	        }
	     

	        var xhr = new Transport(request)
	        function responseURL() {
	            if ('responseURL' in xhr) {
	                return xhr.responseURL
	            }
	            // Avoid security warnings on getResponseHeader when not allowed by CORS
	            if (xhr.getResponseHeader && /^X-Request-URL:/m.test(xhr.getAllResponseHeaders())) {
	                return xhr.getResponseHeader('X-Request-URL')
	            }

	            return
	        }

	        xhr.on('load', function (event) {
	            var options = {
	                status: event.status,
	                statusText: event.statusText,
	                headers: headers(event),
	                url: responseURL()
	            }
	            var body = 'response' in event ? event.response : event.responseText
	            resolve(new Response(body, options))
	        })
	        xhr.on('error', function () {
	            reject(new TypeError('Network request failed'))
	        })
	        xhr.on('timeout', function () {
	            reject(new TypeError('Network request timeout'))
	        })

	        xhr.open(request.method, request.url, true)
			
			if ('responseType' in xhr && ('Blob' in window)) {
				xhr.responseType = 'blob'
			}
			
	        request.headers.forEach(function (value, name) {
	            xhr.setRequestHeader(name, value)
	        })

	        xhr.send(typeof request._body === 'undefined' ? null : request._body)
	    })
	}
	function notFunc(a){
	  return  !/\scode\]\s+\}$/.test(a)
	}
	if (notFunc(window.fetch)) {
	    window.fetch = fetch
	}
	if (typeof avalon === 'function') {
	    avalon.fetch = fetch
	}
	module.exports = fetch

/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var Headers = __webpack_require__(2)
	var Body = __webpack_require__(4)

	function Request(input, options) {
	    options = options || {}
	    var body = options.body
	    if (input instanceof Request) {
	        if (input.bodyUsed) {
	            throw new TypeError('Already read')
	        }
	        this.url = input.url
	        this.credentials = input.credentials
	        if (!options.headers) {
	            var h = this.headers = new Headers(input.headers)
	            if(!h.map['x-requested-with']){
	                h.set('X-Requested-With', 'XMLHttpRequest')
	            }
	        }
	        this.method = input.method
	        this.mode = input.mode
	        if (!body) {
	            body = input._body
	            input.bodyUsed = true
	        }
	    } else {
	        this.url = input
	    }

	    this.credentials = options.credentials || this.credentials || 'omit'
	    if (options.headers || !this.headers) {
	        this.headers = new Headers(options.headers)
	    }
	    this.method = (options.method || this.method || 'GET').toUpperCase()
	    this.mode = options.mode || this.mode || null
	    this.referrer = null

	    if ((this.method === 'GET' || this.method === 'HEAD') && body) {
	        throw new TypeError('Body not allowed for GET or HEAD requests')
	    }
	    this._initBody(body)
	}

	Request.prototype.clone = function () {
	    return new Request(this)
	}

	var F = function(){} 
	F.prototype = Body.prototype 
	Request.prototype = new F() 

	module.exports = Request

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	var support = __webpack_require__(3)

	function Headers(headers) {
	    this.map = {}
	    if (headers instanceof Headers) {
	        headers.forEach(function (value, name) {
	            this.append(name, value)
	        }, this)

	    } else if (headers) {
	        for (var name in headers) {
	            if (headers.hasOwnProperty(name)) {
	                this.append(name, headers[name])
	            }
	        }

	    }
	}

	Headers.prototype.append = function (name, value) {
	    name = normalizeName(name)
	    value = normalizeValue(value)
	    var list = this.map[name]
	    if (!list) {
	        list = []
	        this.map[name] = list
	    }
	    list.push(value)
	}

	Headers.prototype['delete'] = function (name) {
	    delete this.map[normalizeName(name)]
	}

	Headers.prototype.get = function (name) {
	    var values = this.map[normalizeName(name)]
	    return values ? values[0] : null
	}

	Headers.prototype.getAll = function (name) {
	    return this.map[normalizeName(name)] || []
	}

	Headers.prototype.has = function (name) {
	    return this.map.hasOwnProperty(normalizeName(name))
	}

	Headers.prototype.set = function (name, value) {
	    this.map[normalizeName(name)] = [normalizeValue(value)]
	}

	Headers.prototype.forEach = function (callback, thisArg) {
	    for (var name in this.map) {
	        if (this.map.hasOwnProperty(name)) {
	            this.map[name].forEach(function (value) {
	                callback.call(thisArg, value, name, this)
	            }, this)
	        }
	    }
	}

	Headers.prototype.keys = function () {
	    var items = []
	    this.forEach(function (value, name) {
	        items.push(name)
	    })
	    return iteratorFor(items)
	}

	Headers.prototype.values = function () {
	    var items = []
	    this.forEach(function (value) {
	        items.push(value)
	    })
	    return iteratorFor(items)
	}

	Headers.prototype.entries = function () {
	    var items = []
	    this.forEach(function (value, name) {
	        items.push([name, value])
	    })
	    return iteratorFor(items)
	}

	  if (support.iterable) {
	    Headers.prototype[Symbol.iterator] = Headers.prototype.entries
	  }

	function normalizeName(name) {
	    if (typeof name !== 'string') {
	        name = String(name)
	    }
	    if (/[^a-z0-9\-#$%&'*+.\^_`|~]/i.test(name)) {
	        throw new TypeError('Invalid character in header field name')
	    }
	    return name.toLowerCase()
	}

	function normalizeValue(value) {
	    if (typeof value !== 'string') {
	        value = String(value)
	    }
	    return value
	}

	module.exports = Headers

/***/ },
/* 3 */
/***/ function(module, exports) {

	module.exports = {
	    searchParams: 'URLSearchParams' in window,
	    iterable: 'Symbol' in window && 'iterator' in window,
	    blob: 'FileReader' in window && 'Blob' in window && (function () {
	        try {
	            new Blob()
	            return true
	        } catch (e) {
	            return false
	        }
	    })(),
	    formData: 'FormData' in window,
	    arrayBuffer: 'ArrayBuffer' in window
	}


/***/ },
/* 4 */
/***/ function(module, exports, __webpack_require__) {

	var support = __webpack_require__(3)

	function Body() {
	    this.bodyUsed = false
	}
	var p = Body.prototype

	'text,blob,formData,json,arrayBuffer'.replace(/\w+/g, function (method) {
	    p[method] = function () {
	        return consumeBody(this).then(function (body) {
	            return convertBody(body, method)
	        })
	    }
	})

	p._initBody = function (body) {
	    this._body = body
	    if (!this.headers.get('content-type')) {
	        var a = bodyType(body)
	        switch (a) {
	            case 'text':
	                this.headers.set('content-type', 'text/plain;charset=UTF-8')
	                break
	            case 'blob':
	                if (body && body.type) {
	                    this.headers.set('content-type', body.type)
	                }
	                break
	            case 'searchParams':
	                this.headers.set('content-type', 'application/x-www-form-urlencoded;charset=UTF-8')
	                break
	        }
	    }
	}

	function consumeBody(body) {
	    if (body.bodyUsed) {
	        return Promise.reject(new TypeError('Already read'))
	    } else {
	        body.bodyUsed = true
	        return Promise.resolve(body._body)
	    }
	}

	function convertBody(body, to) {
	    var from = bodyType(body)
	    if (body === null || body === void 0 || !from || from === to) {
	        return Promise.resolve(body)
	    } else if (map[to] && map[to][from]) {
	        return map[to][from](body)
	    } else {
	        return Promise.reject(new Error('Convertion from ' + from + ' to ' + to + ' not supported'))
	    }
	}


	var map = {
	    text: {
	        json: function (body) {//json --> text
	            return Promise.resolve(JSON.stringify(body))
	        },
	        blob: function (body) {//blob --> text
	            return blob2text(body)
	        },
	        searchParams: function (body) {//searchParams --> text
	            return Promise.resolve(body.toString())
	        }
	    },
	    json: {
	        text: function (body) {//text --> json
	            return Promise.resolve(parseJSON(body))
	        },
	        blob: function (body) {//blob --> json
	            return blob2text(body).then(parseJSON)
	        }
	    },
	    formData: {
	        text: function (body) {//text --> formData
	            return text2formData(body)
	        }
	    },
	    blob: {
	        text: function (body) {//json --> blob
	            return Promise.resolve(new Blob([body]))
	        },
	        json: function (body) {//json --> blob
	            return Promise.resolve(new Blob([JSON.stringify(body)]))
	        }
	    },
	    arrayBuffer: {
	        blob: function (body) {
	            return blob2ArrayBuffer(body)
	        }
	    }
	}

	function bodyType(body) {
	    if (typeof body === 'string') {
	        return 'text'
	    } else if (support.blob && (body instanceof Blob)) {
	        return 'blob'
	    } else if (support.formData && (body instanceof FormData)) {
	        return 'formData'
	    } else if (support.searchParams && (body instanceof URLSearchParams)) {
	        return 'searchParams'
	    } else if (body && typeof body === 'object') {
	        return 'json'
	    } else {
	        return null
	    }
	}


	function reader2Promise(reader) {
	    return new Promise(function (resolve, reject) {
	        reader.onload = function () {
	            resolve(reader.result)
	        }
	        reader.onerror = function () {
	            reject(reader.error)
	        }
	    })
	}
	/*
	 readAsBinaryString(File|Blob)
	 readAsText(File|Blob [, encoding])
	 readAsDataURL(File|Blob)
	 readAsArrayBuffer(File|Blob)
	 */
	function text2formData(body) {
	    var form = new FormData()
	    body.trim().split('&').forEach(function (bytes) {
	        if (bytes) {
	            var split = bytes.split('=')
	            var name = split.shift().replace(/\+/g, ' ')
	            var value = split.join('=').replace(/\+/g, ' ')
	            form.append(decodeURIComponent(name), decodeURIComponent(value))
	        }
	    })
	    return Promise.resolve(form)
	}

	function blob2ArrayBuffer(blob) {
	    var reader = new FileReader()
	    reader.readAsArrayBuffer(blob)
	    return reader2Promise(reader)
	}

	function blob2text(blob) {
	    var reader = new FileReader()
	    reader.readAsText(blob)
	    return reader2Promise(reader)
	}


	function parseJSON(body) {
	    try {
	        return JSON.parse(body)
	    } catch (ex) {
	        throw 'Invalid JSON'
	    }
	}

	module.exports = Body

/***/ },
/* 5 */
/***/ function(module, exports, __webpack_require__) {

	var Headers = __webpack_require__(2)
	var Body = __webpack_require__(4)

	function Response(bodyInit, options) {
	    if (!options) {
	        options = {}
	    }

	    this.type = 'default'

	    this.status = options.status
	    if (1223 === this.status) {
	        this.status = 204
	    }
	    this.ok = this.status >= 200 && this.status < 300
	    this.statusText = options.statusText
	    this.headers = options.headers instanceof Headers ? options.headers : new Headers(options.headers)
	    this.url = options.url || ''
	    this._initBody(bodyInit)
	}

	var F = function(){} 
	F.prototype = Body.prototype 
	Response.prototype = new F() 

	Response.prototype.clone = function () {
	    return new Response(this._bodyInit, {
	        status: this.status,
	        statusText: this.statusText,
	        headers: new Headers(this.headers),
	        url: this.url
	    })
	}

	Response.error = function () {
	    var response = new Response(null, {status: 0, statusText: ''})
	    response.type = 'error'
	    return response
	}

	var redirectStatuses = [301, 302, 303, 307, 308]

	Response.redirect = function (url, status) {
	    if (redirectStatuses.indexOf(status) === -1) {
	        throw new RangeError('Invalid status code')
	    }

	    return new Response(null, {status: status, headers: {location: url}})
	}

	module.exports = Response

/***/ },
/* 6 */
/***/ function(module, exports, __webpack_require__) {

	var AXO = __webpack_require__(7)
	var JSONP = __webpack_require__(8)
	var XDR = __webpack_require__(9)
	var XHR = __webpack_require__(10)
	var msie = 0
	if (window.VBArray) {
	    msie = document.documentMode || (window.XMLHttpRequest ? 7 : 6)
	}

	function Transport(request) {
	    if (msie === 8 || msie === 9) {
	        this.core = new XDR(request)
	    } else if (msie <= 7) {
	        if (request.credentials === 'include') {
	            this.core = new JSONP(request)
	        } else {
	            this.core = new AXO(request)
	        }
	    } else {
			this.core = new XHR(request)
		}
	}

	var p = Transport.prototype
	p.on = function (type, fn) {
	    this.core.on(type, fn)
	}

	p.setRequestHeader = function (a, b) {
	    if (this.core.setRequestHeader) {
	        this.core.setRequestHeader(a, b)
	    }
	}

	p.open = function (a, b, c, d, e) {
	    if (this.core.open) {
	        this.core.open(a, b, c, d, e)
	    }
	}

	p.send = function (a) {
	    if (this.core.send) {
	        this.core.send(a)
	    }
	}

	p.abort = function () {
	    if (this.core.abort) {
	        this.core.abort()
	    }
	}

	module.exports = Transport

/***/ },
/* 7 */
/***/ function(module, exports) {

	

	module.exports = function AXO(opts) {
	    var xhr = new ActiveXObject('Microsoft.XMLHTTP')
	    
	    xhr.onreadystatechange = function () {
	        if (xhr.readyState === 4) {
	            if (/^2\d\d|1224/.test(xhr.status)) {
	                events['load'] && events['load'](xhr)
	            } else {
	                events['error'] && events['error']()
	            }
	        }
	    }
	    var events = {}
	    xhr.on = function (type, fn) {
	        events[type] = fn
	    }

	    xhr.abort = function () {
	        events = {}
	    }
	    if (opts.timeout === 'number') {
	        setTimeout(function () {
	            events['timeout'] && events['timeout']()
	            xhr.abort()
	        }, opts.timeout)
	    }
	    return xhr
	}

/***/ },
/* 8 */
/***/ function(module, exports) {

	
	function JSONP(opts) {
	    var callbackFunction = opts.jsonpCallbackFunction || generateCallbackFunction();
	    var jsonpCallback = opts.jsonpCallback || 'callback'
	    var xhr = document.createElement('script')
	    if (xhr.charset) {
	        xhr.charset = opts.charset
	    }
	    xhr.onerror = xhr[useOnload ? 'onload' : 'onreadystatechange'] = function (e) {
	        var execute = /loaded|complete|undefined/i.test(xhr.readyState)
	        if (e && e.type === 'error') {
	            events['error'] && events['error']()
	        } else if (execute) {
	            setTimeout(function () {
	                xhr.abort()
	            }, 0)
	        }
	    }

	    var events = {}
	    xhr.on = function (type, fn) {
	        events[type] = fn
	    }
	    xhr.abort = function () {
	        events = {}
	        removeNode(xhr)
	        clearFunction(callbackFunction)
	    }
	    xhr.open = function (a, url) {
	        window[callbackFunction] = function (response) {
	            events['load'] && events['load']({
	                status: 200,
	                statusText: 'ok',
	                response: response
	            })
	            clearFunction(callbackFunction)
	        }
	        var head = document.getElementsTagName('head')[0]

	        url += (url.indexOf('?') === -1) ? '?' : '&';
	        xhr.setAttribute('src', url + jsonpCallback + '=' + callbackFunction);
	        head.insertBefore(xhr, head.firstChild)
	        if (typeof opts.timeout === 'number') {
	            setTimeout(function () {
	                events['timeout'] && events['timeout']()
	                xhr.abort()
	            }, opts.timeout)
	        }
	    }
	}


	function generateCallbackFunction() {
	    return ('jsonp' + Math.random()).replace(/0\./, '')
	}

	// Known issue: Will throw 'Uncaught ReferenceError: callback_*** is not defined' error if request timeout
	function clearFunction(functionName) {
	    // IE8 throws an exception when you try to delete a property on window
	    // http://stackoverflow.com/a/1824228/751089
	    try {
	        delete window[functionName];
	    } catch (e) {
	        window[functionName] = undefined;
	    }
	}

	var f = document.createDocumentFragment()
	var useOnload = 'textContent' in document

	function removeNode(node) {
	    f.appendChild(node)
	    f.removeChild(node)
	    node.onload = onerror = onreadystatechange = function () {
	    }
	    return node
	}

	module.exports = JSONP

/***/ },
/* 9 */
/***/ function(module, exports) {

	//https://msdn.microsoft.com/en-us/library/cc288060(v=VS.85).aspx
	module.exports = function XDR(opts) {
	    var xhr = new XDomainRequest()
	    'load,error,timeout'.replace(/\w+/g, function (method) {
	        xhr['on' + method] = function () {
	            if (events[method]) {
	                events[method](xhr)
	            }
	        }
	    })
	    var events = {}
	    xhr.on = function (type, fn) {
	        events[type] = fn
	    }
	    xhr.onabort = function () {
	        events = {}
	    }
	    if (typeof opts.timeout === 'number') {
	        xhr.timeout = opts.timeout
	    }
	    return xhr
	}

/***/ },
/* 10 */
/***/ function(module, exports) {

	
	module.exports = function XHR(opts) {
	    var xhr = new XMLHttpRequest
	    'load,error,timeout'.replace(/\w+/g, function (method) {
	        xhr['on' + method] = function () {
	            if (events[method]) {
	                events[method](xhr)
	            }
	        }
	    })
	    var events = {}
	    xhr.on = function (type, fn) {
	        events[type] = fn
	    }
	    xhr.onabort = function () {
	        events = {}
	    }
	    if (opts.credentials === 'include') {
	        xhr.withCredentials = true
	    }
	    return xhr
	}

/***/ }
/******/ ])
});
;

/***/ }),

/***/ "./node_modules/_json3@3.3.3@json3/lib/json3.js":
/*!******************************************************!*\
  !*** ./node_modules/_json3@3.3.3@json3/lib/json3.js ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(module, global) {var __WEBPACK_AMD_DEFINE_RESULT__;/*! JSON v3.3.2 | https://bestiejs.github.io/json3 | Copyright 2012-2015, Kit Cambridge, Benjamin Tan | http://kit.mit-license.org */
;(function () {
  // Detect the `define` function exposed by asynchronous module loaders. The
  // strict `define` check is necessary for compatibility with `r.js`.
  var isLoader =  true && __webpack_require__(/*! !webpack amd options */ "./node_modules/_webpack@4.41.2@webpack/buildin/amd-options.js");

  // A set of types used to distinguish objects from primitives.
  var objectTypes = {
    "function": true,
    "object": true
  };

  // Detect the `exports` object exposed by CommonJS implementations.
  var freeExports = objectTypes[typeof exports] && exports && !exports.nodeType && exports;

  // Use the `global` object exposed by Node (including Browserify via
  // `insert-module-globals`), Narwhal, and Ringo as the default context,
  // and the `window` object in browsers. Rhino exports a `global` function
  // instead.
  var root = objectTypes[typeof window] && window || this,
      freeGlobal = freeExports && objectTypes[typeof module] && module && !module.nodeType && typeof global == "object" && global;

  if (freeGlobal && (freeGlobal.global === freeGlobal || freeGlobal.window === freeGlobal || freeGlobal.self === freeGlobal)) {
    root = freeGlobal;
  }

  // Public: Initializes JSON 3 using the given `context` object, attaching the
  // `stringify` and `parse` functions to the specified `exports` object.
  function runInContext(context, exports) {
    context || (context = root.Object());
    exports || (exports = root.Object());

    // Native constructor aliases.
    var Number = context.Number || root.Number,
        String = context.String || root.String,
        Object = context.Object || root.Object,
        Date = context.Date || root.Date,
        SyntaxError = context.SyntaxError || root.SyntaxError,
        TypeError = context.TypeError || root.TypeError,
        Math = context.Math || root.Math,
        nativeJSON = context.JSON || root.JSON;

    // Delegate to the native `stringify` and `parse` implementations.
    if (typeof nativeJSON == "object" && nativeJSON) {
      exports.stringify = nativeJSON.stringify;
      exports.parse = nativeJSON.parse;
    }

    // Convenience aliases.
    var objectProto = Object.prototype,
        getClass = objectProto.toString,
        isProperty = objectProto.hasOwnProperty,
        undefined;

    // Internal: Contains `try...catch` logic used by other functions.
    // This prevents other functions from being deoptimized.
    function attempt(func, errorFunc) {
      try {
        func();
      } catch (exception) {
        if (errorFunc) {
          errorFunc();
        }
      }
    }

    // Test the `Date#getUTC*` methods. Based on work by @Yaffle.
    var isExtended = new Date(-3509827334573292);
    attempt(function () {
      // The `getUTCFullYear`, `Month`, and `Date` methods return nonsensical
      // results for certain dates in Opera >= 10.53.
      isExtended = isExtended.getUTCFullYear() == -109252 && isExtended.getUTCMonth() === 0 && isExtended.getUTCDate() === 1 &&
        isExtended.getUTCHours() == 10 && isExtended.getUTCMinutes() == 37 && isExtended.getUTCSeconds() == 6 && isExtended.getUTCMilliseconds() == 708;
    });

    // Internal: Determines whether the native `JSON.stringify` and `parse`
    // implementations are spec-compliant. Based on work by Ken Snyder.
    function has(name) {
      if (has[name] != null) {
        // Return cached feature test result.
        return has[name];
      }
      var isSupported;
      if (name == "bug-string-char-index") {
        // IE <= 7 doesn't support accessing string characters using square
        // bracket notation. IE 8 only supports this for primitives.
        isSupported = "a"[0] != "a";
      } else if (name == "json") {
        // Indicates whether both `JSON.stringify` and `JSON.parse` are
        // supported.
        isSupported = has("json-stringify") && has("date-serialization") && has("json-parse");
      } else if (name == "date-serialization") {
        // Indicates whether `Date`s can be serialized accurately by `JSON.stringify`.
        isSupported = has("json-stringify") && isExtended;
        if (isSupported) {
          var stringify = exports.stringify;
          attempt(function () {
            isSupported =
              // JSON 2, Prototype <= 1.7, and older WebKit builds incorrectly
              // serialize extended years.
              stringify(new Date(-8.64e15)) == '"-271821-04-20T00:00:00.000Z"' &&
              // The milliseconds are optional in ES 5, but required in 5.1.
              stringify(new Date(8.64e15)) == '"+275760-09-13T00:00:00.000Z"' &&
              // Firefox <= 11.0 incorrectly serializes years prior to 0 as negative
              // four-digit years instead of six-digit years. Credits: @Yaffle.
              stringify(new Date(-621987552e5)) == '"-000001-01-01T00:00:00.000Z"' &&
              // Safari <= 5.1.5 and Opera >= 10.53 incorrectly serialize millisecond
              // values less than 1000. Credits: @Yaffle.
              stringify(new Date(-1)) == '"1969-12-31T23:59:59.999Z"';
          });
        }
      } else {
        var value, serialized = '{"a":[1,true,false,null,"\\u0000\\b\\n\\f\\r\\t"]}';
        // Test `JSON.stringify`.
        if (name == "json-stringify") {
          var stringify = exports.stringify, stringifySupported = typeof stringify == "function";
          if (stringifySupported) {
            // A test function object with a custom `toJSON` method.
            (value = function () {
              return 1;
            }).toJSON = value;
            attempt(function () {
              stringifySupported =
                // Firefox 3.1b1 and b2 serialize string, number, and boolean
                // primitives as object literals.
                stringify(0) === "0" &&
                // FF 3.1b1, b2, and JSON 2 serialize wrapped primitives as object
                // literals.
                stringify(new Number()) === "0" &&
                stringify(new String()) == '""' &&
                // FF 3.1b1, 2 throw an error if the value is `null`, `undefined`, or
                // does not define a canonical JSON representation (this applies to
                // objects with `toJSON` properties as well, *unless* they are nested
                // within an object or array).
                stringify(getClass) === undefined &&
                // IE 8 serializes `undefined` as `"undefined"`. Safari <= 5.1.7 and
                // FF 3.1b3 pass this test.
                stringify(undefined) === undefined &&
                // Safari <= 5.1.7 and FF 3.1b3 throw `Error`s and `TypeError`s,
                // respectively, if the value is omitted entirely.
                stringify() === undefined &&
                // FF 3.1b1, 2 throw an error if the given value is not a number,
                // string, array, object, Boolean, or `null` literal. This applies to
                // objects with custom `toJSON` methods as well, unless they are nested
                // inside object or array literals. YUI 3.0.0b1 ignores custom `toJSON`
                // methods entirely.
                stringify(value) === "1" &&
                stringify([value]) == "[1]" &&
                // Prototype <= 1.6.1 serializes `[undefined]` as `"[]"` instead of
                // `"[null]"`.
                stringify([undefined]) == "[null]" &&
                // YUI 3.0.0b1 fails to serialize `null` literals.
                stringify(null) == "null" &&
                // FF 3.1b1, 2 halts serialization if an array contains a function:
                // `[1, true, getClass, 1]` serializes as "[1,true,],". FF 3.1b3
                // elides non-JSON values from objects and arrays, unless they
                // define custom `toJSON` methods.
                stringify([undefined, getClass, null]) == "[null,null,null]" &&
                // Simple serialization test. FF 3.1b1 uses Unicode escape sequences
                // where character escape codes are expected (e.g., `\b` => `\u0008`).
                stringify({ "a": [value, true, false, null, "\x00\b\n\f\r\t"] }) == serialized &&
                // FF 3.1b1 and b2 ignore the `filter` and `width` arguments.
                stringify(null, value) === "1" &&
                stringify([1, 2], null, 1) == "[\n 1,\n 2\n]";
            }, function () {
              stringifySupported = false;
            });
          }
          isSupported = stringifySupported;
        }
        // Test `JSON.parse`.
        if (name == "json-parse") {
          var parse = exports.parse, parseSupported;
          if (typeof parse == "function") {
            attempt(function () {
              // FF 3.1b1, b2 will throw an exception if a bare literal is provided.
              // Conforming implementations should also coerce the initial argument to
              // a string prior to parsing.
              if (parse("0") === 0 && !parse(false)) {
                // Simple parsing test.
                value = parse(serialized);
                parseSupported = value["a"].length == 5 && value["a"][0] === 1;
                if (parseSupported) {
                  attempt(function () {
                    // Safari <= 5.1.2 and FF 3.1b1 allow unescaped tabs in strings.
                    parseSupported = !parse('"\t"');
                  });
                  if (parseSupported) {
                    attempt(function () {
                      // FF 4.0 and 4.0.1 allow leading `+` signs and leading
                      // decimal points. FF 4.0, 4.0.1, and IE 9-10 also allow
                      // certain octal literals.
                      parseSupported = parse("01") !== 1;
                    });
                  }
                  if (parseSupported) {
                    attempt(function () {
                      // FF 4.0, 4.0.1, and Rhino 1.7R3-R4 allow trailing decimal
                      // points. These environments, along with FF 3.1b1 and 2,
                      // also allow trailing commas in JSON objects and arrays.
                      parseSupported = parse("1.") !== 1;
                    });
                  }
                }
              }
            }, function () {
              parseSupported = false;
            });
          }
          isSupported = parseSupported;
        }
      }
      return has[name] = !!isSupported;
    }
    has["bug-string-char-index"] = has["date-serialization"] = has["json"] = has["json-stringify"] = has["json-parse"] = null;

    if (!has("json")) {
      // Common `[[Class]]` name aliases.
      var functionClass = "[object Function]",
          dateClass = "[object Date]",
          numberClass = "[object Number]",
          stringClass = "[object String]",
          arrayClass = "[object Array]",
          booleanClass = "[object Boolean]";

      // Detect incomplete support for accessing string characters by index.
      var charIndexBuggy = has("bug-string-char-index");

      // Internal: Normalizes the `for...in` iteration algorithm across
      // environments. Each enumerated key is yielded to a `callback` function.
      var forOwn = function (object, callback) {
        var size = 0, Properties, dontEnums, property;

        // Tests for bugs in the current environment's `for...in` algorithm. The
        // `valueOf` property inherits the non-enumerable flag from
        // `Object.prototype` in older versions of IE, Netscape, and Mozilla.
        (Properties = function () {
          this.valueOf = 0;
        }).prototype.valueOf = 0;

        // Iterate over a new instance of the `Properties` class.
        dontEnums = new Properties();
        for (property in dontEnums) {
          // Ignore all properties inherited from `Object.prototype`.
          if (isProperty.call(dontEnums, property)) {
            size++;
          }
        }
        Properties = dontEnums = null;

        // Normalize the iteration algorithm.
        if (!size) {
          // A list of non-enumerable properties inherited from `Object.prototype`.
          dontEnums = ["valueOf", "toString", "toLocaleString", "propertyIsEnumerable", "isPrototypeOf", "hasOwnProperty", "constructor"];
          // IE <= 8, Mozilla 1.0, and Netscape 6.2 ignore shadowed non-enumerable
          // properties.
          forOwn = function (object, callback) {
            var isFunction = getClass.call(object) == functionClass, property, length;
            var hasProperty = !isFunction && typeof object.constructor != "function" && objectTypes[typeof object.hasOwnProperty] && object.hasOwnProperty || isProperty;
            for (property in object) {
              // Gecko <= 1.0 enumerates the `prototype` property of functions under
              // certain conditions; IE does not.
              if (!(isFunction && property == "prototype") && hasProperty.call(object, property)) {
                callback(property);
              }
            }
            // Manually invoke the callback for each non-enumerable property.
            for (length = dontEnums.length; property = dontEnums[--length];) {
              if (hasProperty.call(object, property)) {
                callback(property);
              }
            }
          };
        } else {
          // No bugs detected; use the standard `for...in` algorithm.
          forOwn = function (object, callback) {
            var isFunction = getClass.call(object) == functionClass, property, isConstructor;
            for (property in object) {
              if (!(isFunction && property == "prototype") && isProperty.call(object, property) && !(isConstructor = property === "constructor")) {
                callback(property);
              }
            }
            // Manually invoke the callback for the `constructor` property due to
            // cross-environment inconsistencies.
            if (isConstructor || isProperty.call(object, (property = "constructor"))) {
              callback(property);
            }
          };
        }
        return forOwn(object, callback);
      };

      // Public: Serializes a JavaScript `value` as a JSON string. The optional
      // `filter` argument may specify either a function that alters how object and
      // array members are serialized, or an array of strings and numbers that
      // indicates which properties should be serialized. The optional `width`
      // argument may be either a string or number that specifies the indentation
      // level of the output.
      if (!has("json-stringify") && !has("date-serialization")) {
        // Internal: A map of control characters and their escaped equivalents.
        var Escapes = {
          92: "\\\\",
          34: '\\"',
          8: "\\b",
          12: "\\f",
          10: "\\n",
          13: "\\r",
          9: "\\t"
        };

        // Internal: Converts `value` into a zero-padded string such that its
        // length is at least equal to `width`. The `width` must be <= 6.
        var leadingZeroes = "000000";
        var toPaddedString = function (width, value) {
          // The `|| 0` expression is necessary to work around a bug in
          // Opera <= 7.54u2 where `0 == -0`, but `String(-0) !== "0"`.
          return (leadingZeroes + (value || 0)).slice(-width);
        };

        // Internal: Serializes a date object.
        var serializeDate = function (value) {
          var getData, year, month, date, time, hours, minutes, seconds, milliseconds;
          // Define additional utility methods if the `Date` methods are buggy.
          if (!isExtended) {
            var floor = Math.floor;
            // A mapping between the months of the year and the number of days between
            // January 1st and the first of the respective month.
            var Months = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334];
            // Internal: Calculates the number of days between the Unix epoch and the
            // first day of the given month.
            var getDay = function (year, month) {
              return Months[month] + 365 * (year - 1970) + floor((year - 1969 + (month = +(month > 1))) / 4) - floor((year - 1901 + month) / 100) + floor((year - 1601 + month) / 400);
            };
            getData = function (value) {
              // Manually compute the year, month, date, hours, minutes,
              // seconds, and milliseconds if the `getUTC*` methods are
              // buggy. Adapted from @Yaffle's `date-shim` project.
              date = floor(value / 864e5);
              for (year = floor(date / 365.2425) + 1970 - 1; getDay(year + 1, 0) <= date; year++);
              for (month = floor((date - getDay(year, 0)) / 30.42); getDay(year, month + 1) <= date; month++);
              date = 1 + date - getDay(year, month);
              // The `time` value specifies the time within the day (see ES
              // 5.1 section 15.9.1.2). The formula `(A % B + B) % B` is used
              // to compute `A modulo B`, as the `%` operator does not
              // correspond to the `modulo` operation for negative numbers.
              time = (value % 864e5 + 864e5) % 864e5;
              // The hours, minutes, seconds, and milliseconds are obtained by
              // decomposing the time within the day. See section 15.9.1.10.
              hours = floor(time / 36e5) % 24;
              minutes = floor(time / 6e4) % 60;
              seconds = floor(time / 1e3) % 60;
              milliseconds = time % 1e3;
            };
          } else {
            getData = function (value) {
              year = value.getUTCFullYear();
              month = value.getUTCMonth();
              date = value.getUTCDate();
              hours = value.getUTCHours();
              minutes = value.getUTCMinutes();
              seconds = value.getUTCSeconds();
              milliseconds = value.getUTCMilliseconds();
            };
          }
          serializeDate = function (value) {
            if (value > -1 / 0 && value < 1 / 0) {
              // Dates are serialized according to the `Date#toJSON` method
              // specified in ES 5.1 section 15.9.5.44. See section 15.9.1.15
              // for the ISO 8601 date time string format.
              getData(value);
              // Serialize extended years correctly.
              value = (year <= 0 || year >= 1e4 ? (year < 0 ? "-" : "+") + toPaddedString(6, year < 0 ? -year : year) : toPaddedString(4, year)) +
              "-" + toPaddedString(2, month + 1) + "-" + toPaddedString(2, date) +
              // Months, dates, hours, minutes, and seconds should have two
              // digits; milliseconds should have three.
              "T" + toPaddedString(2, hours) + ":" + toPaddedString(2, minutes) + ":" + toPaddedString(2, seconds) +
              // Milliseconds are optional in ES 5.0, but required in 5.1.
              "." + toPaddedString(3, milliseconds) + "Z";
              year = month = date = hours = minutes = seconds = milliseconds = null;
            } else {
              value = null;
            }
            return value;
          };
          return serializeDate(value);
        };

        // For environments with `JSON.stringify` but buggy date serialization,
        // we override the native `Date#toJSON` implementation with a
        // spec-compliant one.
        if (has("json-stringify") && !has("date-serialization")) {
          // Internal: the `Date#toJSON` implementation used to override the native one.
          function dateToJSON (key) {
            return serializeDate(this);
          }

          // Public: `JSON.stringify`. See ES 5.1 section 15.12.3.
          var nativeStringify = exports.stringify;
          exports.stringify = function (source, filter, width) {
            var nativeToJSON = Date.prototype.toJSON;
            Date.prototype.toJSON = dateToJSON;
            var result = nativeStringify(source, filter, width);
            Date.prototype.toJSON = nativeToJSON;
            return result;
          }
        } else {
          // Internal: Double-quotes a string `value`, replacing all ASCII control
          // characters (characters with code unit values between 0 and 31) with
          // their escaped equivalents. This is an implementation of the
          // `Quote(value)` operation defined in ES 5.1 section 15.12.3.
          var unicodePrefix = "\\u00";
          var escapeChar = function (character) {
            var charCode = character.charCodeAt(0), escaped = Escapes[charCode];
            if (escaped) {
              return escaped;
            }
            return unicodePrefix + toPaddedString(2, charCode.toString(16));
          };
          var reEscape = /[\x00-\x1f\x22\x5c]/g;
          var quote = function (value) {
            reEscape.lastIndex = 0;
            return '"' +
              (
                reEscape.test(value)
                  ? value.replace(reEscape, escapeChar)
                  : value
              ) +
              '"';
          };

          // Internal: Recursively serializes an object. Implements the
          // `Str(key, holder)`, `JO(value)`, and `JA(value)` operations.
          var serialize = function (property, object, callback, properties, whitespace, indentation, stack) {
            var value, type, className, results, element, index, length, prefix, result;
            attempt(function () {
              // Necessary for host object support.
              value = object[property];
            });
            if (typeof value == "object" && value) {
              if (value.getUTCFullYear && getClass.call(value) == dateClass && value.toJSON === Date.prototype.toJSON) {
                value = serializeDate(value);
              } else if (typeof value.toJSON == "function") {
                value = value.toJSON(property);
              }
            }
            if (callback) {
              // If a replacement function was provided, call it to obtain the value
              // for serialization.
              value = callback.call(object, property, value);
            }
            // Exit early if value is `undefined` or `null`.
            if (value == undefined) {
              return value === undefined ? value : "null";
            }
            type = typeof value;
            // Only call `getClass` if the value is an object.
            if (type == "object") {
              className = getClass.call(value);
            }
            switch (className || type) {
              case "boolean":
              case booleanClass:
                // Booleans are represented literally.
                return "" + value;
              case "number":
              case numberClass:
                // JSON numbers must be finite. `Infinity` and `NaN` are serialized as
                // `"null"`.
                return value > -1 / 0 && value < 1 / 0 ? "" + value : "null";
              case "string":
              case stringClass:
                // Strings are double-quoted and escaped.
                return quote("" + value);
            }
            // Recursively serialize objects and arrays.
            if (typeof value == "object") {
              // Check for cyclic structures. This is a linear search; performance
              // is inversely proportional to the number of unique nested objects.
              for (length = stack.length; length--;) {
                if (stack[length] === value) {
                  // Cyclic structures cannot be serialized by `JSON.stringify`.
                  throw TypeError();
                }
              }
              // Add the object to the stack of traversed objects.
              stack.push(value);
              results = [];
              // Save the current indentation level and indent one additional level.
              prefix = indentation;
              indentation += whitespace;
              if (className == arrayClass) {
                // Recursively serialize array elements.
                for (index = 0, length = value.length; index < length; index++) {
                  element = serialize(index, value, callback, properties, whitespace, indentation, stack);
                  results.push(element === undefined ? "null" : element);
                }
                result = results.length ? (whitespace ? "[\n" + indentation + results.join(",\n" + indentation) + "\n" + prefix + "]" : ("[" + results.join(",") + "]")) : "[]";
              } else {
                // Recursively serialize object members. Members are selected from
                // either a user-specified list of property names, or the object
                // itself.
                forOwn(properties || value, function (property) {
                  var element = serialize(property, value, callback, properties, whitespace, indentation, stack);
                  if (element !== undefined) {
                    // According to ES 5.1 section 15.12.3: "If `gap` {whitespace}
                    // is not the empty string, let `member` {quote(property) + ":"}
                    // be the concatenation of `member` and the `space` character."
                    // The "`space` character" refers to the literal space
                    // character, not the `space` {width} argument provided to
                    // `JSON.stringify`.
                    results.push(quote(property) + ":" + (whitespace ? " " : "") + element);
                  }
                });
                result = results.length ? (whitespace ? "{\n" + indentation + results.join(",\n" + indentation) + "\n" + prefix + "}" : ("{" + results.join(",") + "}")) : "{}";
              }
              // Remove the object from the traversed object stack.
              stack.pop();
              return result;
            }
          };

          // Public: `JSON.stringify`. See ES 5.1 section 15.12.3.
          exports.stringify = function (source, filter, width) {
            var whitespace, callback, properties, className;
            if (objectTypes[typeof filter] && filter) {
              className = getClass.call(filter);
              if (className == functionClass) {
                callback = filter;
              } else if (className == arrayClass) {
                // Convert the property names array into a makeshift set.
                properties = {};
                for (var index = 0, length = filter.length, value; index < length;) {
                  value = filter[index++];
                  className = getClass.call(value);
                  if (className == "[object String]" || className == "[object Number]") {
                    properties[value] = 1;
                  }
                }
              }
            }
            if (width) {
              className = getClass.call(width);
              if (className == numberClass) {
                // Convert the `width` to an integer and create a string containing
                // `width` number of space characters.
                if ((width -= width % 1) > 0) {
                  if (width > 10) {
                    width = 10;
                  }
                  for (whitespace = ""; whitespace.length < width;) {
                    whitespace += " ";
                  }
                }
              } else if (className == stringClass) {
                whitespace = width.length <= 10 ? width : width.slice(0, 10);
              }
            }
            // Opera <= 7.54u2 discards the values associated with empty string keys
            // (`""`) only if they are used directly within an object member list
            // (e.g., `!("" in { "": 1})`).
            return serialize("", (value = {}, value[""] = source, value), callback, properties, whitespace, "", []);
          };
        }
      }

      // Public: Parses a JSON source string.
      if (!has("json-parse")) {
        var fromCharCode = String.fromCharCode;

        // Internal: A map of escaped control characters and their unescaped
        // equivalents.
        var Unescapes = {
          92: "\\",
          34: '"',
          47: "/",
          98: "\b",
          116: "\t",
          110: "\n",
          102: "\f",
          114: "\r"
        };

        // Internal: Stores the parser state.
        var Index, Source;

        // Internal: Resets the parser state and throws a `SyntaxError`.
        var abort = function () {
          Index = Source = null;
          throw SyntaxError();
        };

        // Internal: Returns the next token, or `"$"` if the parser has reached
        // the end of the source string. A token may be a string, number, `null`
        // literal, or Boolean literal.
        var lex = function () {
          var source = Source, length = source.length, value, begin, position, isSigned, charCode;
          while (Index < length) {
            charCode = source.charCodeAt(Index);
            switch (charCode) {
              case 9: case 10: case 13: case 32:
                // Skip whitespace tokens, including tabs, carriage returns, line
                // feeds, and space characters.
                Index++;
                break;
              case 123: case 125: case 91: case 93: case 58: case 44:
                // Parse a punctuator token (`{`, `}`, `[`, `]`, `:`, or `,`) at
                // the current position.
                value = charIndexBuggy ? source.charAt(Index) : source[Index];
                Index++;
                return value;
              case 34:
                // `"` delimits a JSON string; advance to the next character and
                // begin parsing the string. String tokens are prefixed with the
                // sentinel `@` character to distinguish them from punctuators and
                // end-of-string tokens.
                for (value = "@", Index++; Index < length;) {
                  charCode = source.charCodeAt(Index);
                  if (charCode < 32) {
                    // Unescaped ASCII control characters (those with a code unit
                    // less than the space character) are not permitted.
                    abort();
                  } else if (charCode == 92) {
                    // A reverse solidus (`\`) marks the beginning of an escaped
                    // control character (including `"`, `\`, and `/`) or Unicode
                    // escape sequence.
                    charCode = source.charCodeAt(++Index);
                    switch (charCode) {
                      case 92: case 34: case 47: case 98: case 116: case 110: case 102: case 114:
                        // Revive escaped control characters.
                        value += Unescapes[charCode];
                        Index++;
                        break;
                      case 117:
                        // `\u` marks the beginning of a Unicode escape sequence.
                        // Advance to the first character and validate the
                        // four-digit code point.
                        begin = ++Index;
                        for (position = Index + 4; Index < position; Index++) {
                          charCode = source.charCodeAt(Index);
                          // A valid sequence comprises four hexdigits (case-
                          // insensitive) that form a single hexadecimal value.
                          if (!(charCode >= 48 && charCode <= 57 || charCode >= 97 && charCode <= 102 || charCode >= 65 && charCode <= 70)) {
                            // Invalid Unicode escape sequence.
                            abort();
                          }
                        }
                        // Revive the escaped character.
                        value += fromCharCode("0x" + source.slice(begin, Index));
                        break;
                      default:
                        // Invalid escape sequence.
                        abort();
                    }
                  } else {
                    if (charCode == 34) {
                      // An unescaped double-quote character marks the end of the
                      // string.
                      break;
                    }
                    charCode = source.charCodeAt(Index);
                    begin = Index;
                    // Optimize for the common case where a string is valid.
                    while (charCode >= 32 && charCode != 92 && charCode != 34) {
                      charCode = source.charCodeAt(++Index);
                    }
                    // Append the string as-is.
                    value += source.slice(begin, Index);
                  }
                }
                if (source.charCodeAt(Index) == 34) {
                  // Advance to the next character and return the revived string.
                  Index++;
                  return value;
                }
                // Unterminated string.
                abort();
              default:
                // Parse numbers and literals.
                begin = Index;
                // Advance past the negative sign, if one is specified.
                if (charCode == 45) {
                  isSigned = true;
                  charCode = source.charCodeAt(++Index);
                }
                // Parse an integer or floating-point value.
                if (charCode >= 48 && charCode <= 57) {
                  // Leading zeroes are interpreted as octal literals.
                  if (charCode == 48 && ((charCode = source.charCodeAt(Index + 1)), charCode >= 48 && charCode <= 57)) {
                    // Illegal octal literal.
                    abort();
                  }
                  isSigned = false;
                  // Parse the integer component.
                  for (; Index < length && ((charCode = source.charCodeAt(Index)), charCode >= 48 && charCode <= 57); Index++);
                  // Floats cannot contain a leading decimal point; however, this
                  // case is already accounted for by the parser.
                  if (source.charCodeAt(Index) == 46) {
                    position = ++Index;
                    // Parse the decimal component.
                    for (; position < length; position++) {
                      charCode = source.charCodeAt(position);
                      if (charCode < 48 || charCode > 57) {
                        break;
                      }
                    }
                    if (position == Index) {
                      // Illegal trailing decimal.
                      abort();
                    }
                    Index = position;
                  }
                  // Parse exponents. The `e` denoting the exponent is
                  // case-insensitive.
                  charCode = source.charCodeAt(Index);
                  if (charCode == 101 || charCode == 69) {
                    charCode = source.charCodeAt(++Index);
                    // Skip past the sign following the exponent, if one is
                    // specified.
                    if (charCode == 43 || charCode == 45) {
                      Index++;
                    }
                    // Parse the exponential component.
                    for (position = Index; position < length; position++) {
                      charCode = source.charCodeAt(position);
                      if (charCode < 48 || charCode > 57) {
                        break;
                      }
                    }
                    if (position == Index) {
                      // Illegal empty exponent.
                      abort();
                    }
                    Index = position;
                  }
                  // Coerce the parsed value to a JavaScript number.
                  return +source.slice(begin, Index);
                }
                // A negative sign may only precede numbers.
                if (isSigned) {
                  abort();
                }
                // `true`, `false`, and `null` literals.
                var temp = source.slice(Index, Index + 4);
                if (temp == "true") {
                  Index += 4;
                  return true;
                } else if (temp == "fals" && source.charCodeAt(Index + 4 ) == 101) {
                  Index += 5;
                  return false;
                } else if (temp == "null") {
                  Index += 4;
                  return null;
                }
                // Unrecognized token.
                abort();
            }
          }
          // Return the sentinel `$` character if the parser has reached the end
          // of the source string.
          return "$";
        };

        // Internal: Parses a JSON `value` token.
        var get = function (value) {
          var results, hasMembers;
          if (value == "$") {
            // Unexpected end of input.
            abort();
          }
          if (typeof value == "string") {
            if ((charIndexBuggy ? value.charAt(0) : value[0]) == "@") {
              // Remove the sentinel `@` character.
              return value.slice(1);
            }
            // Parse object and array literals.
            if (value == "[") {
              // Parses a JSON array, returning a new JavaScript array.
              results = [];
              for (;;) {
                value = lex();
                // A closing square bracket marks the end of the array literal.
                if (value == "]") {
                  break;
                }
                // If the array literal contains elements, the current token
                // should be a comma separating the previous element from the
                // next.
                if (hasMembers) {
                  if (value == ",") {
                    value = lex();
                    if (value == "]") {
                      // Unexpected trailing `,` in array literal.
                      abort();
                    }
                  } else {
                    // A `,` must separate each array element.
                    abort();
                  }
                } else {
                  hasMembers = true;
                }
                // Elisions and leading commas are not permitted.
                if (value == ",") {
                  abort();
                }
                results.push(get(value));
              }
              return results;
            } else if (value == "{") {
              // Parses a JSON object, returning a new JavaScript object.
              results = {};
              for (;;) {
                value = lex();
                // A closing curly brace marks the end of the object literal.
                if (value == "}") {
                  break;
                }
                // If the object literal contains members, the current token
                // should be a comma separator.
                if (hasMembers) {
                  if (value == ",") {
                    value = lex();
                    if (value == "}") {
                      // Unexpected trailing `,` in object literal.
                      abort();
                    }
                  } else {
                    // A `,` must separate each object member.
                    abort();
                  }
                } else {
                  hasMembers = true;
                }
                // Leading commas are not permitted, object property names must be
                // double-quoted strings, and a `:` must separate each property
                // name and value.
                if (value == "," || typeof value != "string" || (charIndexBuggy ? value.charAt(0) : value[0]) != "@" || lex() != ":") {
                  abort();
                }
                results[value.slice(1)] = get(lex());
              }
              return results;
            }
            // Unexpected token encountered.
            abort();
          }
          return value;
        };

        // Internal: Updates a traversed object member.
        var update = function (source, property, callback) {
          var element = walk(source, property, callback);
          if (element === undefined) {
            delete source[property];
          } else {
            source[property] = element;
          }
        };

        // Internal: Recursively traverses a parsed JSON object, invoking the
        // `callback` function for each value. This is an implementation of the
        // `Walk(holder, name)` operation defined in ES 5.1 section 15.12.2.
        var walk = function (source, property, callback) {
          var value = source[property], length;
          if (typeof value == "object" && value) {
            // `forOwn` can't be used to traverse an array in Opera <= 8.54
            // because its `Object#hasOwnProperty` implementation returns `false`
            // for array indices (e.g., `![1, 2, 3].hasOwnProperty("0")`).
            if (getClass.call(value) == arrayClass) {
              for (length = value.length; length--;) {
                update(getClass, forOwn, value, length, callback);
              }
            } else {
              forOwn(value, function (property) {
                update(value, property, callback);
              });
            }
          }
          return callback.call(source, property, value);
        };

        // Public: `JSON.parse`. See ES 5.1 section 15.12.2.
        exports.parse = function (source, callback) {
          var result, value;
          Index = 0;
          Source = "" + source;
          result = get(lex());
          // If a JSON string contains multiple tokens, it is invalid.
          if (lex() != "$") {
            abort();
          }
          // Reset the parser state.
          Index = Source = null;
          return callback && getClass.call(callback) == functionClass ? walk((value = {}, value[""] = result, value), "", callback) : result;
        };
      }
    }

    exports.runInContext = runInContext;
    return exports;
  }

  if (freeExports && !isLoader) {
    // Export for CommonJS environments.
    runInContext(root, freeExports);
  } else {
    // Export for web browsers and JavaScript engines.
    var nativeJSON = root.JSON,
        previousJSON = root.JSON3,
        isRestored = false;

    var JSON3 = runInContext(root, (root.JSON3 = {
      // Public: Restores the original value of the global `JSON` object and
      // returns a reference to the `JSON3` object.
      "noConflict": function () {
        if (!isRestored) {
          isRestored = true;
          root.JSON = nativeJSON;
          root.JSON3 = previousJSON;
          nativeJSON = previousJSON = null;
        }
        return JSON3;
      }
    }));

    root.JSON = {
      "parse": JSON3.parse,
      "stringify": JSON3.stringify
    };
  }

  // Export for asynchronous module loaders.
  if (isLoader) {
    !(__WEBPACK_AMD_DEFINE_RESULT__ = (function () {
      return JSON3;
    }).call(exports, __webpack_require__, exports, module),
				__WEBPACK_AMD_DEFINE_RESULT__ !== undefined && (module.exports = __WEBPACK_AMD_DEFINE_RESULT__));
  }
}).call(this);

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../_webpack@4.41.2@webpack/buildin/module.js */ "./node_modules/_webpack@4.41.2@webpack/buildin/module.js")(module), __webpack_require__(/*! ./../../_webpack@4.41.2@webpack/buildin/global.js */ "./node_modules/_webpack@4.41.2@webpack/buildin/global.js")))

/***/ }),

/***/ "./node_modules/_object-create-ie8@1.0.0@object-create-ie8/index.js":
/*!**************************************************************************!*\
  !*** ./node_modules/_object-create-ie8@1.0.0@object-create-ie8/index.js ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

if(!/\[native code\]/.test(Object.create)){
    Object.create = function(a){
        var f = function(){}
        f.prototype = a;
        return new f()
    }
}

/***/ }),

/***/ "./node_modules/_object-defineproperty-ie8@1.0.1@object-defineproperty-ie8/index.js":
/*!******************************************************************************************!*\
  !*** ./node_modules/_object-defineproperty-ie8@1.0.1@object-defineproperty-ie8/index.js ***!
  \******************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

var origDefineProperty = Object.defineProperty;

var arePropertyDescriptorsSupported = function() {
  var obj = {};
  try {
    origDefineProperty(obj, "x", { enumerable: false, value: obj });
    for (var _ in obj) {
      return false;
    }
    return obj.x === obj;
  } catch (e) {
    /* this is IE 8. */
    return false;
  }
};
var supportsDescriptors =
  origDefineProperty && arePropertyDescriptorsSupported();

if (!supportsDescriptors) {
  Object.defineProperty = function(a, b, c) {
    //IE8支持修改元素节点的属性
    if (origDefineProperty && a.nodeType == 1) {
      return origDefineProperty(a, b, c);
    } else {
      a[b] = c.value || (c.get && c.get());
    }
  };
}


/***/ }),

/***/ "./node_modules/_object-is@1.0.1@object-is/index.js":
/*!**********************************************************!*\
  !*** ./node_modules/_object-is@1.0.1@object-is/index.js ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


/* https://people.mozilla.org/~jorendorff/es6-draft.html#sec-object.is */

var NumberIsNaN = function (value) {
	return value !== value;
};

module.exports = function is(a, b) {
	if (a === 0 && b === 0) {
		return 1 / a === 1 / b;
	} else if (a === b) {
		return true;
	} else if (NumberIsNaN(a) && NumberIsNaN(b)) {
		return true;
	}
	return false;
};



/***/ }),

/***/ "./node_modules/_process@0.11.10@process/browser.js":
/*!**********************************************************!*\
  !*** ./node_modules/_process@0.11.10@process/browser.js ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// shim for using process in browser
var process = module.exports = {};

// cached from whatever global is present so that test runners that stub it
// don't break things.  But we need to wrap it in a try catch in case it is
// wrapped in strict mode code which doesn't define any globals.  It's inside a
// function because try/catches deoptimize in certain engines.

var cachedSetTimeout;
var cachedClearTimeout;

function defaultSetTimout() {
    throw new Error('setTimeout has not been defined');
}
function defaultClearTimeout () {
    throw new Error('clearTimeout has not been defined');
}
(function () {
    try {
        if (typeof setTimeout === 'function') {
            cachedSetTimeout = setTimeout;
        } else {
            cachedSetTimeout = defaultSetTimout;
        }
    } catch (e) {
        cachedSetTimeout = defaultSetTimout;
    }
    try {
        if (typeof clearTimeout === 'function') {
            cachedClearTimeout = clearTimeout;
        } else {
            cachedClearTimeout = defaultClearTimeout;
        }
    } catch (e) {
        cachedClearTimeout = defaultClearTimeout;
    }
} ())
function runTimeout(fun) {
    if (cachedSetTimeout === setTimeout) {
        //normal enviroments in sane situations
        return setTimeout(fun, 0);
    }
    // if setTimeout wasn't available but was latter defined
    if ((cachedSetTimeout === defaultSetTimout || !cachedSetTimeout) && setTimeout) {
        cachedSetTimeout = setTimeout;
        return setTimeout(fun, 0);
    }
    try {
        // when when somebody has screwed with setTimeout but no I.E. maddness
        return cachedSetTimeout(fun, 0);
    } catch(e){
        try {
            // When we are in I.E. but the script has been evaled so I.E. doesn't trust the global object when called normally
            return cachedSetTimeout.call(null, fun, 0);
        } catch(e){
            // same as above but when it's a version of I.E. that must have the global object for 'this', hopfully our context correct otherwise it will throw a global error
            return cachedSetTimeout.call(this, fun, 0);
        }
    }


}
function runClearTimeout(marker) {
    if (cachedClearTimeout === clearTimeout) {
        //normal enviroments in sane situations
        return clearTimeout(marker);
    }
    // if clearTimeout wasn't available but was latter defined
    if ((cachedClearTimeout === defaultClearTimeout || !cachedClearTimeout) && clearTimeout) {
        cachedClearTimeout = clearTimeout;
        return clearTimeout(marker);
    }
    try {
        // when when somebody has screwed with setTimeout but no I.E. maddness
        return cachedClearTimeout(marker);
    } catch (e){
        try {
            // When we are in I.E. but the script has been evaled so I.E. doesn't  trust the global object when called normally
            return cachedClearTimeout.call(null, marker);
        } catch (e){
            // same as above but when it's a version of I.E. that must have the global object for 'this', hopfully our context correct otherwise it will throw a global error.
            // Some versions of I.E. have different rules for clearTimeout vs setTimeout
            return cachedClearTimeout.call(this, marker);
        }
    }



}
var queue = [];
var draining = false;
var currentQueue;
var queueIndex = -1;

function cleanUpNextTick() {
    if (!draining || !currentQueue) {
        return;
    }
    draining = false;
    if (currentQueue.length) {
        queue = currentQueue.concat(queue);
    } else {
        queueIndex = -1;
    }
    if (queue.length) {
        drainQueue();
    }
}

function drainQueue() {
    if (draining) {
        return;
    }
    var timeout = runTimeout(cleanUpNextTick);
    draining = true;

    var len = queue.length;
    while(len) {
        currentQueue = queue;
        queue = [];
        while (++queueIndex < len) {
            if (currentQueue) {
                currentQueue[queueIndex].run();
            }
        }
        queueIndex = -1;
        len = queue.length;
    }
    currentQueue = null;
    draining = false;
    runClearTimeout(timeout);
}

process.nextTick = function (fun) {
    var args = new Array(arguments.length - 1);
    if (arguments.length > 1) {
        for (var i = 1; i < arguments.length; i++) {
            args[i - 1] = arguments[i];
        }
    }
    queue.push(new Item(fun, args));
    if (queue.length === 1 && !draining) {
        runTimeout(drainQueue);
    }
};

// v8 likes predictible objects
function Item(fun, array) {
    this.fun = fun;
    this.array = array;
}
Item.prototype.run = function () {
    this.fun.apply(null, this.array);
};
process.title = 'browser';
process.browser = true;
process.env = {};
process.argv = [];
process.version = ''; // empty string to avoid regexp issues
process.versions = {};

function noop() {}

process.on = noop;
process.addListener = noop;
process.once = noop;
process.off = noop;
process.removeListener = noop;
process.removeAllListeners = noop;
process.emit = noop;
process.prependListener = noop;
process.prependOnceListener = noop;

process.listeners = function (name) { return [] }

process.binding = function (name) {
    throw new Error('process.binding is not supported');
};

process.cwd = function () { return '/' };
process.chdir = function (dir) {
    throw new Error('process.chdir is not supported');
};
process.umask = function() { return 0; };


/***/ }),

/***/ "./node_modules/_react-loadable@5.5.0@react-loadable/lib/index.js":
/*!************************************************************************!*\
  !*** ./node_modules/_react-loadable@5.5.0@react-loadable/lib/index.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var React = __webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js");
var PropTypes = __webpack_require__(/*! prop-types */ "./node_modules/_anujs@1.6.0@anujs/lib/ReactPropTypes.js");

var ALL_INITIALIZERS = [];
var READY_INITIALIZERS = [];

function isWebpackReady(getModuleIds) {
  if (( false ? undefined : _typeof(__webpack_require__.m)) !== "object") {
    return false;
  }

  return getModuleIds().every(function (moduleId) {
    return typeof moduleId !== "undefined" && typeof __webpack_require__.m[moduleId] !== "undefined";
  });
}

function load(loader) {
  var promise = loader();

  var state = {
    loading: true,
    loaded: null,
    error: null
  };

  state.promise = promise.then(function (loaded) {
    state.loading = false;
    state.loaded = loaded;
    return loaded;
  })["catch"](function (err) {
    state.loading = false;
    state.error = err;
    throw err;
  });

  return state;
}

function loadMap(obj) {
  var state = {
    loading: false,
    loaded: {},
    error: null
  };

  var promises = [];

  try {
    Object.keys(obj).forEach(function (key) {
      var result = load(obj[key]);

      if (!result.loading) {
        state.loaded[key] = result.loaded;
        state.error = result.error;
      } else {
        state.loading = true;
      }

      promises.push(result.promise);

      result.promise.then(function (res) {
        state.loaded[key] = res;
      })["catch"](function (err) {
        state.error = err;
      });
    });
  } catch (err) {
    state.error = err;
  }

  state.promise = Promise.all(promises).then(function (res) {
    state.loading = false;
    return res;
  })["catch"](function (err) {
    state.loading = false;
    throw err;
  });

  return state;
}

function resolve(obj) {
  return obj && obj.__esModule ? obj["default"] : obj;
}

function render(loaded, props) {
  return React.createElement(resolve(loaded), props);
}

function createLoadableComponent(loadFn, options) {
  var _class, _temp;

  if (!options.loading) {
    throw new Error("react-loadable requires a `loading` component");
  }

  var opts = Object.assign({
    loader: null,
    loading: null,
    delay: 200,
    timeout: null,
    render: render,
    webpack: null,
    modules: null
  }, options);

  var res = null;

  function init() {
    if (!res) {
      res = loadFn(opts.loader);
    }
    return res.promise;
  }

  ALL_INITIALIZERS.push(init);

  if (typeof opts.webpack === "function") {
    READY_INITIALIZERS.push(function () {
      if (isWebpackReady(opts.webpack)) {
        return init();
      }
    });
  }

  return _temp = _class = function (_React$Component) {
    _inherits(LoadableComponent, _React$Component);

    function LoadableComponent(props) {
      _classCallCheck(this, LoadableComponent);

      var _this = _possibleConstructorReturn(this, _React$Component.call(this, props));

      _this.retry = function () {
        _this.setState({ error: null, loading: true, timedOut: false });
        res = loadFn(opts.loader);
        _this._loadModule();
      };

      init();

      _this.state = {
        error: res.error,
        pastDelay: false,
        timedOut: false,
        loading: res.loading,
        loaded: res.loaded
      };
      return _this;
    }

    LoadableComponent.preload = function preload() {
      return init();
    };

    LoadableComponent.prototype.componentWillMount = function componentWillMount() {
      this._mounted = true;
      this._loadModule();
    };

    LoadableComponent.prototype._loadModule = function _loadModule() {
      var _this2 = this;

      if (this.context.loadable && Array.isArray(opts.modules)) {
        opts.modules.forEach(function (moduleName) {
          _this2.context.loadable.report(moduleName);
        });
      }

      if (!res.loading) {
        return;
      }

      if (typeof opts.delay === "number") {
        if (opts.delay === 0) {
          this.setState({ pastDelay: true });
        } else {
          this._delay = setTimeout(function () {
            _this2.setState({ pastDelay: true });
          }, opts.delay);
        }
      }

      if (typeof opts.timeout === "number") {
        this._timeout = setTimeout(function () {
          _this2.setState({ timedOut: true });
        }, opts.timeout);
      }

      var update = function update() {
        if (!_this2._mounted) {
          return;
        }

        _this2.setState({
          error: res.error,
          loaded: res.loaded,
          loading: res.loading
        });

        _this2._clearTimeouts();
      };

      res.promise.then(function () {
        update();
      })["catch"](function (err) {
        update();
      });
    };

    LoadableComponent.prototype.componentWillUnmount = function componentWillUnmount() {
      this._mounted = false;
      this._clearTimeouts();
    };

    LoadableComponent.prototype._clearTimeouts = function _clearTimeouts() {
      clearTimeout(this._delay);
      clearTimeout(this._timeout);
    };

    LoadableComponent.prototype.render = function render() {
      if (this.state.loading || this.state.error) {
        return React.createElement(opts.loading, {
          isLoading: this.state.loading,
          pastDelay: this.state.pastDelay,
          timedOut: this.state.timedOut,
          error: this.state.error,
          retry: this.retry
        });
      } else if (this.state.loaded) {
        return opts.render(this.state.loaded, this.props);
      } else {
        return null;
      }
    };

    return LoadableComponent;
  }(React.Component), _class.contextTypes = {
    loadable: PropTypes.shape({
      report: PropTypes.func.isRequired
    })
  }, _temp;
}

function Loadable(opts) {
  return createLoadableComponent(load, opts);
}

function LoadableMap(opts) {
  if (typeof opts.render !== "function") {
    throw new Error("LoadableMap requires a `render(loaded, props)` function");
  }

  return createLoadableComponent(loadMap, opts);
}

Loadable.Map = LoadableMap;

var Capture = function (_React$Component2) {
  _inherits(Capture, _React$Component2);

  function Capture() {
    _classCallCheck(this, Capture);

    return _possibleConstructorReturn(this, _React$Component2.apply(this, arguments));
  }

  Capture.prototype.getChildContext = function getChildContext() {
    return {
      loadable: {
        report: this.props.report
      }
    };
  };

  Capture.prototype.render = function render() {
    return React.Children.only(this.props.children);
  };

  return Capture;
}(React.Component);

Capture.propTypes = {
  report: PropTypes.func.isRequired
};
Capture.childContextTypes = {
  loadable: PropTypes.shape({
    report: PropTypes.func.isRequired
  }).isRequired
};


Loadable.Capture = Capture;

function flushInitializers(initializers) {
  var promises = [];

  while (initializers.length) {
    var init = initializers.pop();
    promises.push(init());
  }

  return Promise.all(promises).then(function () {
    if (initializers.length) {
      return flushInitializers(initializers);
    }
  });
}

Loadable.preloadAll = function () {
  return new Promise(function (resolve, reject) {
    flushInitializers(ALL_INITIALIZERS).then(resolve, reject);
  });
};

Loadable.preloadReady = function () {
  return new Promise(function (resolve, reject) {
    // We always will resolve, errors should be handled within loading UIs.
    flushInitializers(READY_INITIALIZERS).then(resolve, resolve);
  });
};

module.exports = Loadable;

/***/ }),

/***/ "./node_modules/_setimmediate@1.0.5@setimmediate/setImmediate.js":
/*!***********************************************************************!*\
  !*** ./node_modules/_setimmediate@1.0.5@setimmediate/setImmediate.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(global, process) {(function (global, undefined) {
    "use strict";

    if (global.setImmediate) {
        return;
    }

    var nextHandle = 1; // Spec says greater than zero
    var tasksByHandle = {};
    var currentlyRunningATask = false;
    var doc = global.document;
    var registerImmediate;

    function setImmediate(callback) {
      // Callback can either be a function or a string
      if (typeof callback !== "function") {
        callback = new Function("" + callback);
      }
      // Copy function arguments
      var args = new Array(arguments.length - 1);
      for (var i = 0; i < args.length; i++) {
          args[i] = arguments[i + 1];
      }
      // Store and register the task
      var task = { callback: callback, args: args };
      tasksByHandle[nextHandle] = task;
      registerImmediate(nextHandle);
      return nextHandle++;
    }

    function clearImmediate(handle) {
        delete tasksByHandle[handle];
    }

    function run(task) {
        var callback = task.callback;
        var args = task.args;
        switch (args.length) {
        case 0:
            callback();
            break;
        case 1:
            callback(args[0]);
            break;
        case 2:
            callback(args[0], args[1]);
            break;
        case 3:
            callback(args[0], args[1], args[2]);
            break;
        default:
            callback.apply(undefined, args);
            break;
        }
    }

    function runIfPresent(handle) {
        // From the spec: "Wait until any invocations of this algorithm started before this one have completed."
        // So if we're currently running a task, we'll need to delay this invocation.
        if (currentlyRunningATask) {
            // Delay by doing a setTimeout. setImmediate was tried instead, but in Firefox 7 it generated a
            // "too much recursion" error.
            setTimeout(runIfPresent, 0, handle);
        } else {
            var task = tasksByHandle[handle];
            if (task) {
                currentlyRunningATask = true;
                try {
                    run(task);
                } finally {
                    clearImmediate(handle);
                    currentlyRunningATask = false;
                }
            }
        }
    }

    function installNextTickImplementation() {
        registerImmediate = function(handle) {
            process.nextTick(function () { runIfPresent(handle); });
        };
    }

    function canUsePostMessage() {
        // The test against `importScripts` prevents this implementation from being installed inside a web worker,
        // where `global.postMessage` means something completely different and can't be used for this purpose.
        if (global.postMessage && !global.importScripts) {
            var postMessageIsAsynchronous = true;
            var oldOnMessage = global.onmessage;
            global.onmessage = function() {
                postMessageIsAsynchronous = false;
            };
            global.postMessage("", "*");
            global.onmessage = oldOnMessage;
            return postMessageIsAsynchronous;
        }
    }

    function installPostMessageImplementation() {
        // Installs an event handler on `global` for the `message` event: see
        // * https://developer.mozilla.org/en/DOM/window.postMessage
        // * http://www.whatwg.org/specs/web-apps/current-work/multipage/comms.html#crossDocumentMessages

        var messagePrefix = "setImmediate$" + Math.random() + "$";
        var onGlobalMessage = function(event) {
            if (event.source === global &&
                typeof event.data === "string" &&
                event.data.indexOf(messagePrefix) === 0) {
                runIfPresent(+event.data.slice(messagePrefix.length));
            }
        };

        if (global.addEventListener) {
            global.addEventListener("message", onGlobalMessage, false);
        } else {
            global.attachEvent("onmessage", onGlobalMessage);
        }

        registerImmediate = function(handle) {
            global.postMessage(messagePrefix + handle, "*");
        };
    }

    function installMessageChannelImplementation() {
        var channel = new MessageChannel();
        channel.port1.onmessage = function(event) {
            var handle = event.data;
            runIfPresent(handle);
        };

        registerImmediate = function(handle) {
            channel.port2.postMessage(handle);
        };
    }

    function installReadyStateChangeImplementation() {
        var html = doc.documentElement;
        registerImmediate = function(handle) {
            // Create a <script> element; its readystatechange event will be fired asynchronously once it is inserted
            // into the document. Do so, thus queuing up the task. Remember to clean up once it's been called.
            var script = doc.createElement("script");
            script.onreadystatechange = function () {
                runIfPresent(handle);
                script.onreadystatechange = null;
                html.removeChild(script);
                script = null;
            };
            html.appendChild(script);
        };
    }

    function installSetTimeoutImplementation() {
        registerImmediate = function(handle) {
            setTimeout(runIfPresent, 0, handle);
        };
    }

    // If supported, we should attach to the prototype of global, since that is where setTimeout et al. live.
    var attachTo = Object.getPrototypeOf && Object.getPrototypeOf(global);
    attachTo = attachTo && attachTo.setTimeout ? attachTo : global;

    // Don't get fooled by e.g. browserify environments.
    if ({}.toString.call(global.process) === "[object process]") {
        // For Node.js before 0.9
        installNextTickImplementation();

    } else if (canUsePostMessage()) {
        // For non-IE10 modern browsers
        installPostMessageImplementation();

    } else if (global.MessageChannel) {
        // For web workers, where supported
        installMessageChannelImplementation();

    } else if (doc && "onreadystatechange" in doc.createElement("script")) {
        // For IE 6–8
        installReadyStateChangeImplementation();

    } else {
        // For older browsers
        installSetTimeoutImplementation();
    }

    attachTo.setImmediate = setImmediate;
    attachTo.clearImmediate = clearImmediate;
}(typeof self === "undefined" ? typeof global === "undefined" ? this : global : self));

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../_webpack@4.41.2@webpack/buildin/global.js */ "./node_modules/_webpack@4.41.2@webpack/buildin/global.js"), __webpack_require__(/*! ./../_process@0.11.10@process/browser.js */ "./node_modules/_process@0.11.10@process/browser.js")))

/***/ }),

/***/ "./node_modules/_style-loader@1.0.0@style-loader/dist/runtime/injectStylesIntoStyleTag.js":
/*!************************************************************************************************!*\
  !*** ./node_modules/_style-loader@1.0.0@style-loader/dist/runtime/injectStylesIntoStyleTag.js ***!
  \************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var stylesInDom = {};

var isOldIE = function isOldIE() {
  var memo;
  return function memorize() {
    if (typeof memo === 'undefined') {
      // Test for IE <= 9 as proposed by Browserhacks
      // @see http://browserhacks.com/#hack-e71d8692f65334173fee715c222cb805
      // Tests for existence of standard globals is to allow style-loader
      // to operate correctly into non-standard environments
      // @see https://github.com/webpack-contrib/style-loader/issues/177
      memo = Boolean(window && document && document.all && !window.atob);
    }

    return memo;
  };
}();

var getTarget = function getTarget() {
  var memo = {};
  return function memorize(target) {
    if (typeof memo[target] === 'undefined') {
      var styleTarget = document.querySelector(target); // Special case to return head of iframe instead of iframe itself

      if (window.HTMLIFrameElement && styleTarget instanceof window.HTMLIFrameElement) {
        try {
          // This will throw an exception if access to iframe is blocked
          // due to cross-origin restrictions
          styleTarget = styleTarget.contentDocument.head;
        } catch (e) {
          // istanbul ignore next
          styleTarget = null;
        }
      }

      memo[target] = styleTarget;
    }

    return memo[target];
  };
}();

function listToStyles(list, options) {
  var styles = [];
  var newStyles = {};

  for (var i = 0; i < list.length; i++) {
    var item = list[i];
    var id = options.base ? item[0] + options.base : item[0];
    var css = item[1];
    var media = item[2];
    var sourceMap = item[3];
    var part = {
      css: css,
      media: media,
      sourceMap: sourceMap
    };

    if (!newStyles[id]) {
      styles.push(newStyles[id] = {
        id: id,
        parts: [part]
      });
    } else {
      newStyles[id].parts.push(part);
    }
  }

  return styles;
}

function addStylesToDom(styles, options) {
  for (var i = 0; i < styles.length; i++) {
    var item = styles[i];
    var domStyle = stylesInDom[item.id];
    var j = 0;

    if (domStyle) {
      domStyle.refs++;

      for (; j < domStyle.parts.length; j++) {
        domStyle.parts[j](item.parts[j]);
      }

      for (; j < item.parts.length; j++) {
        domStyle.parts.push(addStyle(item.parts[j], options));
      }
    } else {
      var parts = [];

      for (; j < item.parts.length; j++) {
        parts.push(addStyle(item.parts[j], options));
      }

      stylesInDom[item.id] = {
        id: item.id,
        refs: 1,
        parts: parts
      };
    }
  }
}

function insertStyleElement(options) {
  var style = document.createElement('style');

  if (typeof options.attributes.nonce === 'undefined') {
    var nonce =  true ? __webpack_require__.nc : undefined;

    if (nonce) {
      options.attributes.nonce = nonce;
    }
  }

  Object.keys(options.attributes).forEach(function (key) {
    style.setAttribute(key, options.attributes[key]);
  });

  if (typeof options.insert === 'function') {
    options.insert(style);
  } else {
    var target = getTarget(options.insert || 'head');

    if (!target) {
      throw new Error("Couldn't find a style target. This probably means that the value for the 'insert' parameter is invalid.");
    }

    target.appendChild(style);
  }

  return style;
}

function removeStyleElement(style) {
  // istanbul ignore if
  if (style.parentNode === null) {
    return false;
  }

  style.parentNode.removeChild(style);
}
/* istanbul ignore next  */


var replaceText = function replaceText() {
  var textStore = [];
  return function replace(index, replacement) {
    textStore[index] = replacement;
    return textStore.filter(Boolean).join('\n');
  };
}();

function applyToSingletonTag(style, index, remove, obj) {
  var css = remove ? '' : obj.css; // For old IE

  /* istanbul ignore if  */

  if (style.styleSheet) {
    style.styleSheet.cssText = replaceText(index, css);
  } else {
    var cssNode = document.createTextNode(css);
    var childNodes = style.childNodes;

    if (childNodes[index]) {
      style.removeChild(childNodes[index]);
    }

    if (childNodes.length) {
      style.insertBefore(cssNode, childNodes[index]);
    } else {
      style.appendChild(cssNode);
    }
  }
}

function applyToTag(style, options, obj) {
  var css = obj.css;
  var media = obj.media;
  var sourceMap = obj.sourceMap;

  if (media) {
    style.setAttribute('media', media);
  }

  if (sourceMap && btoa) {
    css += "\n/*# sourceMappingURL=data:application/json;base64,".concat(btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap)))), " */");
  } // For old IE

  /* istanbul ignore if  */


  if (style.styleSheet) {
    style.styleSheet.cssText = css;
  } else {
    while (style.firstChild) {
      style.removeChild(style.firstChild);
    }

    style.appendChild(document.createTextNode(css));
  }
}

var singleton = null;
var singletonCounter = 0;

function addStyle(obj, options) {
  var style;
  var update;
  var remove;

  if (options.singleton) {
    var styleIndex = singletonCounter++;
    style = singleton || (singleton = insertStyleElement(options));
    update = applyToSingletonTag.bind(null, style, styleIndex, false);
    remove = applyToSingletonTag.bind(null, style, styleIndex, true);
  } else {
    style = insertStyleElement(options);
    update = applyToTag.bind(null, style, options);

    remove = function remove() {
      removeStyleElement(style);
    };
  }

  update(obj);
  return function updateStyle(newObj) {
    if (newObj) {
      if (newObj.css === obj.css && newObj.media === obj.media && newObj.sourceMap === obj.sourceMap) {
        return;
      }

      update(obj = newObj);
    } else {
      remove();
    }
  };
}

module.exports = function (list, options) {
  options = options || {};
  options.attributes = typeof options.attributes === 'object' ? options.attributes : {}; // Force single-tag solution on IE6-9, which has a hard limit on the # of <style>
  // tags it will allow on a page

  if (!options.singleton && typeof options.singleton !== 'boolean') {
    options.singleton = isOldIE();
  }

  var styles = listToStyles(list, options);
  addStylesToDom(styles, options);
  return function update(newList) {
    var mayRemove = [];

    for (var i = 0; i < styles.length; i++) {
      var item = styles[i];
      var domStyle = stylesInDom[item.id];

      if (domStyle) {
        domStyle.refs--;
        mayRemove.push(domStyle);
      }
    }

    if (newList) {
      var newStyles = listToStyles(newList, options);
      addStylesToDom(newStyles, options);
    }

    for (var _i = 0; _i < mayRemove.length; _i++) {
      var _domStyle = mayRemove[_i];

      if (_domStyle.refs === 0) {
        for (var j = 0; j < _domStyle.parts.length; j++) {
          _domStyle.parts[j]();
        }

        delete stylesInDom[_domStyle.id];
      }
    }
  };
};

/***/ }),

/***/ "./node_modules/_timers-browserify@2.0.11@timers-browserify/main.js":
/*!**************************************************************************!*\
  !*** ./node_modules/_timers-browserify@2.0.11@timers-browserify/main.js ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function(global) {var scope = (typeof global !== "undefined" && global) ||
            (typeof self !== "undefined" && self) ||
            window;
var apply = Function.prototype.apply;

// DOM APIs, for completeness

exports.setTimeout = function() {
  return new Timeout(apply.call(setTimeout, scope, arguments), clearTimeout);
};
exports.setInterval = function() {
  return new Timeout(apply.call(setInterval, scope, arguments), clearInterval);
};
exports.clearTimeout =
exports.clearInterval = function(timeout) {
  if (timeout) {
    timeout.close();
  }
};

function Timeout(id, clearFn) {
  this._id = id;
  this._clearFn = clearFn;
}
Timeout.prototype.unref = Timeout.prototype.ref = function() {};
Timeout.prototype.close = function() {
  this._clearFn.call(scope, this._id);
};

// Does not start the time, just sets up the members needed.
exports.enroll = function(item, msecs) {
  clearTimeout(item._idleTimeoutId);
  item._idleTimeout = msecs;
};

exports.unenroll = function(item) {
  clearTimeout(item._idleTimeoutId);
  item._idleTimeout = -1;
};

exports._unrefActive = exports.active = function(item) {
  clearTimeout(item._idleTimeoutId);

  var msecs = item._idleTimeout;
  if (msecs >= 0) {
    item._idleTimeoutId = setTimeout(function onTimeout() {
      if (item._onTimeout)
        item._onTimeout();
    }, msecs);
  }
};

// setimmediate attaches itself to the global object
__webpack_require__(/*! setimmediate */ "./node_modules/_setimmediate@1.0.5@setimmediate/setImmediate.js");
// On some exotic environments, it's not clear which object `setimmediate` was
// able to install onto.  Search each possibility in the same order as the
// `setimmediate` library.
exports.setImmediate = (typeof self !== "undefined" && self.setImmediate) ||
                       (typeof global !== "undefined" && global.setImmediate) ||
                       (this && this.setImmediate);
exports.clearImmediate = (typeof self !== "undefined" && self.clearImmediate) ||
                         (typeof global !== "undefined" && global.clearImmediate) ||
                         (this && this.clearImmediate);

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../_webpack@4.41.2@webpack/buildin/global.js */ "./node_modules/_webpack@4.41.2@webpack/buildin/global.js")))

/***/ }),

/***/ "./node_modules/_webpack@4.41.2@webpack/buildin/amd-options.js":
/*!****************************************!*\
  !*** (webpack)/buildin/amd-options.js ***!
  \****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

/* WEBPACK VAR INJECTION */(function(__webpack_amd_options__) {/* globals __webpack_amd_options__ */
module.exports = __webpack_amd_options__;

/* WEBPACK VAR INJECTION */}.call(this, {}))

/***/ }),

/***/ "./node_modules/_webpack@4.41.2@webpack/buildin/global.js":
/*!***********************************!*\
  !*** (webpack)/buildin/global.js ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

var g;

// This works in non-strict mode
g = (function() {
	return this;
})();

try {
	// This works if eval is allowed (see CSP)
	g = g || new Function("return this")();
} catch (e) {
	// This works if the window reference is available
	if (typeof window === "object") g = window;
}

// g can still be undefined, but nothing to do about it...
// We return undefined, instead of nothing here, so it's
// easier to handle this case. if(!global) { ...}

module.exports = g;


/***/ }),

/***/ "./node_modules/_webpack@4.41.2@webpack/buildin/module.js":
/*!***********************************!*\
  !*** (webpack)/buildin/module.js ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = function(module) {
	if (!module.webpackPolyfill) {
		module.deprecate = function() {};
		module.paths = [];
		// module.parent = undefined by default
		if (!module.children) module.children = [];
		Object.defineProperty(module, "loaded", {
			enumerable: true,
			get: function() {
				return module.l;
			}
		});
		Object.defineProperty(module, "id", {
			enumerable: true,
			get: function() {
				return module.i;
			}
		});
		module.webpackPolyfill = 1;
	}
	return module;
};


/***/ }),

/***/ "./polyfill/isarray/index.js":
/*!***********************************!*\
  !*** ./polyfill/isarray/index.js ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

var toString = {}.toString;

module.exports = Array.isArray || function (arr) {
  return toString.call(arr) == '[object Array]';
};


/***/ }),

/***/ "./polyfill/object-assign-polyfill.js":
/*!********************************************!*\
  !*** ./polyfill/object-assign-polyfill.js ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/**
 * Object.assign() - Polyfill
 *
 * @ref https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/assign
 */



(function() {
    if (typeof Object.assign != 'function') {
        (function () {
            Object.assign = function (target) {
                'use strict';
                if (target === undefined || target === null) {
                    throw new TypeError('Cannot convert undefined or null to object');
                }

                var output = Object(target);
                for (var index = 1; index < arguments.length; index++) {
                    var source = arguments[index];
                    if (source !== undefined && source !== null) {
                        for (var nextKey in source) {
                            if (Object.prototype.hasOwnProperty.call(source, nextKey)) {
                                output[nextKey] = source[nextKey];
                            }
                        }
                    }
                }
                return output;
            };
        })();
    }
})();


/***/ }),

/***/ "./src/api/api.jsx":
/*!*************************!*\
  !*** ./src/api/api.jsx ***!
  \*************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var host = 'http://192.168.0.100';

var getAction = function getAction(url, callback) {
  fetch(host + url).then(function (res) {
    return res.json();
  }).then(function (data) {
    console.log("【api】", url, data);

    if (typeof callback === 'function') {
      callback(data);
    }
  })["catch"](function (e) {
    return console.log(e);
  });
};

var partitionList = function partitionList(callback) {
  return getAction('/mer/partition/list', callback);
};

var groupList = function groupList(callback) {
  return getAction('/mer/group/list', callback);
};

var productList = function productList(callback) {
  return getAction('/mer/product/list', callback);
};

var templateList = function templateList(callback) {
  return getAction('/mer/template/list', callback);
};

module.exports = {
  partitionList: partitionList,
  groupList: groupList,
  productList: productList,
  templateList: templateList
};

/***/ }),

/***/ "./src/app.jsx":
/*!*********************!*\
  !*** ./src/app.jsx ***!
  \*********************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.object.is */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.object.is.js");

__webpack_require__(/*! ../polyfill/object-assign-polyfill */ "./polyfill/object-assign-polyfill.js");

__webpack_require__(/*! ../polyfill/isarray */ "./polyfill/isarray/index.js");

__webpack_require__(/*! es5-shim */ "./node_modules/_es5-shim@4.5.13@es5-shim/es5-shim.js");

__webpack_require__(/*! object-create-ie8 */ "./node_modules/_object-create-ie8@1.0.0@object-create-ie8/index.js");

__webpack_require__(/*! object-defineproperty-ie8 */ "./node_modules/_object-defineproperty-ie8@1.0.1@object-defineproperty-ie8/index.js");

__webpack_require__(/*! console-polyfill */ "./node_modules/_console-polyfill@0.3.0@console-polyfill/index.js");

__webpack_require__(/*! json3 */ "./node_modules/_json3@3.3.3@json3/lib/json3.js");

__webpack_require__(/*! fetch-polyfill2 */ "./node_modules/_fetch-polyfill2@0.0.3@fetch-polyfill2/dist/index.js");

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _reactDom = _interopRequireDefault(__webpack_require__(/*! react-dom */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _header = _interopRequireDefault(__webpack_require__(/*! ./components/header */ "./src/components/header/index.jsx"));

var _body = _interopRequireDefault(__webpack_require__(/*! ./components/body */ "./src/components/body/index.jsx"));

//兼容低版本IE
//IE8 ^4.5.13
//IE8
//IE8
//IE8下，如果你不打开开发者工具，window下是没有console这个对象的，只有打开了F12才会有这个方法
//比IE8的JSON好用
//fetch 实现
Object.is = __webpack_require__(/*! object-is */ "./node_modules/_object-is@1.0.1@object-is/index.js");
window.Promise = __webpack_require__(/*! bluebird */ "./node_modules/_bluebird@3.7.1@bluebird/js/browser/bluebird.js");

__webpack_require__(/*! ./static/css/style.css */ "./src/static/css/style.css");

__webpack_require__(/*! ./static/css/iconfont.css */ "./src/static/css/iconfont.css");

var render = function render() {
  _reactDom["default"].render(_react["default"].createElement("div", {
    style: {
      height: '100%'
    }
  }, _react["default"].createElement(_header["default"], null), _react["default"].createElement(_body["default"], null)), document.getElementById('root'));
};

render();

/***/ }),

/***/ "./src/components/body/index.jsx":
/*!***************************************!*\
  !*** ./src/components/body/index.jsx ***!
  \***************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.function.name */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.function.name.js");

__webpack_require__(/*! core-js/modules/es6.array.map */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.array.map.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _router = __webpack_require__(/*! router */ "./node_modules/_anujs@1.6.0@anujs/dist/Router.js");

var _home = _interopRequireDefault(__webpack_require__(/*! ../../views/home */ "./src/views/home/index.jsx"));

var _async = _interopRequireDefault(__webpack_require__(/*! ../../views/page1/async */ "./src/views/page1/async.jsx"));

var _page = _interopRequireDefault(__webpack_require__(/*! ../../views/page2 */ "./src/views/page2/index.jsx"));

var _ = _interopRequireDefault(__webpack_require__(/*! ../../views/404 */ "./src/views/404/index.jsx"));

var _order = _interopRequireDefault(__webpack_require__(/*! ../../views/order */ "./src/views/order/index.jsx"));

var _partition = _interopRequireDefault(__webpack_require__(/*! ../../views/partition */ "./src/views/partition/index.jsx"));

var _group = _interopRequireDefault(__webpack_require__(/*! ../../views/group */ "./src/views/group/index.jsx"));

var _template = _interopRequireDefault(__webpack_require__(/*! ../../views/template */ "./src/views/template/index.jsx"));

var Body =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Body, _React$Component);

  function Body(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Body);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Body).call(this, props));
    _this.state = {
      onIndex: -1,
      menus: [{
        name: '分区模版',
        to: 'templates',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#03b0ce'
          }
        }, "\uE730")
      }, {
        name: '安装分区',
        to: 'orders',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#009688'
          }
        }, "\uE711")
      }, {
        name: '分区管理',
        to: 'partitionss',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#2196F3'
          }
        }, "\uE672")
      }, {
        name: '分组管理',
        to: 'groups',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#ff8345'
          }
        }, "\uE613")
      }, {
        name: '补发记录',
        to: 'page2',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#009688'
          }
        }, "\uE60D")
      }, {
        name: '订单补发',
        to: 'page2',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#2196F3'
          }
        }, "\uE642")
      }, {
        name: '提现记录',
        to: 'page2',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#009688'
          }
        }, "\uE6BB")
      }, {
        name: '用户日志',
        to: 'page2',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#2196F3'
          }
        }, "\uE6AA")
      }, {
        name: '获取代码',
        to: 'page2',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont",
          style: {
            color: '#ff8345'
          }
        }, "\uE606")
      }]
    };
    return _this;
  }

  (0, _createClass2["default"])(Body, [{
    key: "render",
    value: function render() {
      var _this2 = this;

      return _react["default"].createElement("div", {
        "class": "container"
      }, _react["default"].createElement("div", {
        "class": "control"
      }, _react["default"].createElement("div", {
        "class": "title bg-primary"
      }, "\u63A7\u5236\u9762\u677F"), _react["default"].createElement("div", {
        "class": "wrapper"
      }, this.state.menus.map(function (menu, index) {
        return _react["default"].createElement(_router.Link, {
          to: menu.to,
          "class": index == _this2.state.onIndex ? 'menu on' : 'menu',
          onClick: function onClick() {
            return _this2.setState({
              onIndex: index
            });
          }
        }, menu.icon, menu.name);
      }), _react["default"].createElement(_router.Link, {
        to: "page2"
      }, _react["default"].createElement("i", {
        "class": "icon iconfont",
        style: {
          color: '#ff35f2'
        }
      }, "\uE610"), "\u4E0B\u8F7D\u7F51\u5173"), _react["default"].createElement(_router.Link, {
        to: "page2"
      }, _react["default"].createElement("i", {
        "class": "icon iconfont",
        style: {
          color: '#d83420'
        }
      }, "\uE659"), "\u9000\u51FA\u767B\u5F55"))), _react["default"].createElement("div", {
        "class": "content"
      }, _react["default"].createElement("div", {
        "class": "title"
      }), _react["default"].createElement(_router.Router, {
        "class": "body"
      }, _react["default"].createElement(_home["default"], {
        path: "mer"
      }), _react["default"].createElement(_home["default"], {
        path: "/"
      }), _react["default"].createElement(_async["default"], {
        path: "page1"
      }), _react["default"].createElement(_page["default"], {
        path: "page2"
      }), _react["default"].createElement(_order["default"], {
        path: "orders"
      }), _react["default"].createElement(_partition["default"], {
        path: "partitionss"
      }), _react["default"].createElement(_group["default"], {
        path: "groups"
      }), _react["default"].createElement(_template["default"], {
        path: "templates"
      }), _react["default"].createElement(_["default"], {
        "default": true
      }))));
    }
  }]);
  return Body;
}(_react["default"].Component);

module.exports = Body;

/***/ }),

/***/ "./src/components/header/index.jsx":
/*!*****************************************!*\
  !*** ./src/components/header/index.jsx ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.function.name */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.function.name.js");

__webpack_require__(/*! core-js/modules/es6.array.map */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.array.map.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _router = __webpack_require__(/*! router */ "./node_modules/_anujs@1.6.0@anujs/dist/Router.js");

var Header =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Header, _React$Component);

  function Header(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Header);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Header).call(this, props));
    _this.state = {
      onIndex: 0,
      menus: [{
        name: '首　页',
        to: 'mer',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont"
        }, "\uE61E")
      }, {
        name: '订单管理',
        to: 'orders',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont"
        }, "\uE64E")
      }, {
        name: '分区管理',
        to: 'partitionss',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont"
        }, "\uE672")
      }, {
        name: '数据分析',
        to: 'page2',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont"
        }, "\uE600")
      }, {
        name: '账户管理',
        to: 'page2',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont"
        }, "\uE601")
      }, {
        name: '代理系统',
        to: 'page2',
        icon: _react["default"].createElement("i", {
          "class": "icon iconfont"
        }, "\uE689")
      }]
    };
    return _this;
  }

  (0, _createClass2["default"])(Header, [{
    key: "componentDidMount",
    value: function componentDidMount() {
      console.log(location.pathname);
    }
  }, {
    key: "onClick",
    value: function onClick(index) {
      this.setState({
        onIndex: index
      });
    }
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      return _react["default"].createElement("div", {
        "class": "header bg-primary"
      }, _react["default"].createElement("div", {
        "class": "header-content"
      }, _react["default"].createElement("div", {
        id: "menu"
      }, this.state.menus.map(function (menu, index) {
        return _react["default"].createElement(_router.Link, {
          to: menu.to,
          "class": index == _this2.state.onIndex ? 'menu on' : 'menu',
          onClick: function onClick() {
            return _this2.onClick(index);
          }
        }, menu.icon, menu.name);
      }), _react["default"].createElement("a", {
        href: "javascript:;",
        "class": "users"
      }, _react["default"].createElement("i", {
        "class": "icon iconfont"
      }, "\uE60C"), "a123"))));
    }
  }]);
  return Header;
}(_react["default"].Component);

module.exports = Header;

/***/ }),

/***/ "./src/components/loading/index.jsx":
/*!******************************************!*\
  !*** ./src/components/loading/index.jsx ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

function Loading() {
  return _react["default"].createElement("div", null, "Loading...");
}

module.exports = Loading;

/***/ }),

/***/ "./src/components/tools/index.jsx":
/*!****************************************!*\
  !*** ./src/components/tools/index.jsx ***!
  \****************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.function.name */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.function.name.js");

__webpack_require__(/*! core-js/modules/es6.array.map */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.array.map.js");

__webpack_require__(/*! core-js/modules/es6.function.bind */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.function.bind.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _assertThisInitialized2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/assertThisInitialized */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/assertThisInitialized.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var number = 1;

var Input =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Input, _React$Component);

  function Input(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Input);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Input).call(this, props));
    console.log(props);
    _this.state = {
      type: props.type || 'text',
      value: props.value || ''
    };
    _this.onChange = _this.onChange.bind((0, _assertThisInitialized2["default"])(_this));
    return _this;
  }

  (0, _createClass2["default"])(Input, [{
    key: "onChange",
    value: function onChange(e) {
      this.setState({
        value: e.target.value
      });
    }
  }, {
    key: "render",
    value: function render() {
      return _react["default"].createElement("input", {
        "class": "form-control",
        type: this.state.type,
        value: this.props.value,
        onChange: this.props.onChange && this.props.onChange,
        style: this.props.style
      });
    }
  }]);
  return Input;
}(_react["default"].Component);

var Selector =
/*#__PURE__*/
function (_React$Component2) {
  (0, _inherits2["default"])(Selector, _React$Component2);

  function Selector(props) {
    var _this2;

    (0, _classCallCheck2["default"])(this, Selector);
    _this2 = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Selector).call(this, props));
    var def = _this2.props.def || {
      title: '-请选择-',
      value: ''
    };
    _this2.state = {
      title: def.title,
      value: def.value,
      on: -1,
      def: def,
      no_def: _this2.props['no-def'] || false,
      t_f: _this2.props['t-f'] || 'title',
      v_f: _this2.props['v-f'] || 'value',
      checked: false
    };
    _this2.onClick = _this2.onClick.bind((0, _assertThisInitialized2["default"])(_this2));
    _this2.onBlur = _this2.onBlur.bind((0, _assertThisInitialized2["default"])(_this2));
    _this2.onCheck = _this2.onCheck.bind((0, _assertThisInitialized2["default"])(_this2));
    _this2.onDefault = _this2.onDefault.bind((0, _assertThisInitialized2["default"])(_this2));
    return _this2;
  }

  (0, _createClass2["default"])(Selector, [{
    key: "onClick",
    value: function onClick() {
      this.setState({
        checked: !this.state.checked
      });
    }
  }, {
    key: "onBlur",
    value: function onBlur() {
      this.setState({
        checked: false
      });
    }
  }, {
    key: "onCheck",
    value: function onCheck(item, index) {
      this.setState({
        title: item[this.state.t_f],
        value: item[this.state.v_f],
        on: index
      });
    }
  }, {
    key: "onDefault",
    value: function onDefault() {
      this.setState({
        title: this.state.def.title,
        value: this.state.def.value,
        on: -1
      });
    }
  }, {
    key: "render",
    value: function render() {
      var _this3 = this;

      return _react["default"].createElement("div", {
        "class": 'selector form-control' + (this.state.checked ? ' on' : ''),
        title: this.state.title,
        tabIndex: "1",
        onClick: this.onClick,
        onBlur: this.onBlur
      }, this.state.title, _react["default"].createElement("ul", {
        "class": "selector-list"
      }, !this.props['no-def'] && _react["default"].createElement("li", {
        "class": this.state.on == -1 ? 'on' : '',
        onClick: this.onDefault
      }, this.state.def.title), this.props.children || this.props.items.map(function (item, index) {
        return _react["default"].createElement("li", {
          "class": index == _this3.state.on ? 'on' : '',
          title: item[_this3.state.t_f],
          onClick: function onClick() {
            return _this3.onCheck(item, index);
          }
        }, item[_this3.state.t_f]);
      })), _react["default"].createElement("input", {
        name: this.props.name,
        value: this.state.value,
        type: "hidden"
      }));
    }
  }]);
  return Selector;
}(_react["default"].Component);

var CheckBox =
/*#__PURE__*/
function (_React$Component3) {
  (0, _inherits2["default"])(CheckBox, _React$Component3);

  function CheckBox(props) {
    var _this4;

    (0, _classCallCheck2["default"])(this, CheckBox);
    _this4 = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(CheckBox).call(this, props));
    var id = _this4.props.id;

    if (!_this4.props.id) {
      id = 'checkbox-' + number;
      number++;
    }

    _this4.state = {
      id: id
    };
    return _this4;
  }

  (0, _createClass2["default"])(CheckBox, [{
    key: "componentDidMount",
    value: function componentDidMount() {}
  }, {
    key: "render",
    value: function render() {
      return _react["default"].createElement("div", null, _react["default"].createElement("input", {
        id: this.state.id,
        name: this.props.name,
        value: this.props.value,
        type: "checkbox"
      }), _react["default"].createElement("label", {
        "for": this.state.id,
        "class": "check-box"
      }, typeof this.props.children === 'string' ? this.props.children : ''));
    }
  }]);
  return CheckBox;
}(_react["default"].Component);

var Radios =
/*#__PURE__*/
function (_React$Component4) {
  (0, _inherits2["default"])(Radios, _React$Component4);

  function Radios(props) {
    (0, _classCallCheck2["default"])(this, Radios);
    return (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Radios).call(this, props));
  }

  (0, _createClass2["default"])(Radios, [{
    key: "render",
    value: function render() {
      return _react["default"].createElement("div", null, _react["default"].createElement("input", {
        id: "check-box-2",
        type: "radios"
      }), _react["default"].createElement("label", {
        "for": "check-box-2",
        "class": "radios"
      }, _react["default"].createElement("i", null)));
    }
  }]);
  return Radios;
}(_react["default"].Component);

var FormGroup =
/*#__PURE__*/
function (_React$Component5) {
  (0, _inherits2["default"])(FormGroup, _React$Component5);

  function FormGroup(props) {
    (0, _classCallCheck2["default"])(this, FormGroup);
    return (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(FormGroup).call(this, props));
  }

  (0, _createClass2["default"])(FormGroup, [{
    key: "componentDidMount",
    value: function componentDidMount() {}
  }, {
    key: "render",
    value: function render() {
      return _react["default"].createElement("table", {
        "class": "tab-input-group"
      }, _react["default"].createElement("tr", null, _react["default"].createElement("td", {
        "class": "tab-input-addon tig-head"
      }, _react["default"].createElement("label", {
        "for": this.props.id,
        "class": "tab-input-tag"
      }, this.props.title)), _react["default"].createElement("td", {
        "class": "tig-end"
      }, this.props.children)));
    }
  }]);
  return FormGroup;
}(_react["default"].Component);

module.exports = {
  Input: Input,
  Selector: Selector,
  CheckBox: CheckBox,
  Radios: Radios,
  FormGroup: FormGroup
};

/***/ }),

/***/ "./src/static/css/iconfont.css":
/*!*************************************!*\
  !*** ./src/static/css/iconfont.css ***!
  \*************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var content = __webpack_require__(/*! !../../../node_modules/_css-loader@3.2.0@css-loader/dist/cjs.js??ref--5-1!../../../node_modules/_postcss-loader@3.0.0@postcss-loader/src!./iconfont.css */ "./node_modules/_css-loader@3.2.0@css-loader/dist/cjs.js?!./node_modules/_postcss-loader@3.0.0@postcss-loader/src/index.js!./src/static/css/iconfont.css");

if (typeof content === 'string') {
  content = [[module.i, content, '']];
}

var options = {}

options.insert = "head";
options.singleton = false;

var update = __webpack_require__(/*! ../../../node_modules/_style-loader@1.0.0@style-loader/dist/runtime/injectStylesIntoStyleTag.js */ "./node_modules/_style-loader@1.0.0@style-loader/dist/runtime/injectStylesIntoStyleTag.js")(content, options);

if (content.locals) {
  module.exports = content.locals;
}


/***/ }),

/***/ "./src/static/css/iconfont.eot?t=1575009924499":
/*!*****************************************************!*\
  !*** ./src/static/css/iconfont.eot?t=1575009924499 ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "assets/css/iconfont.eot";

/***/ }),

/***/ "./src/static/css/iconfont.svg?t=1575009924499":
/*!*****************************************************!*\
  !*** ./src/static/css/iconfont.svg?t=1575009924499 ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "assets/css/iconfont.svg";

/***/ }),

/***/ "./src/static/css/iconfont.ttf?t=1575009924499":
/*!*****************************************************!*\
  !*** ./src/static/css/iconfont.ttf?t=1575009924499 ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "assets/css/iconfont.ttf";

/***/ }),

/***/ "./src/static/css/iconfont.woff":
/*!**************************************!*\
  !*** ./src/static/css/iconfont.woff ***!
  \**************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "assets/css/iconfont.woff";

/***/ }),

/***/ "./src/static/css/iconfont.woff?t=1575009924499":
/*!******************************************************!*\
  !*** ./src/static/css/iconfont.woff?t=1575009924499 ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "assets/css/iconfont.woff";

/***/ }),

/***/ "./src/static/css/style.css":
/*!**********************************!*\
  !*** ./src/static/css/style.css ***!
  \**********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var content = __webpack_require__(/*! !../../../node_modules/_css-loader@3.2.0@css-loader/dist/cjs.js??ref--5-1!../../../node_modules/_postcss-loader@3.0.0@postcss-loader/src!./style.css */ "./node_modules/_css-loader@3.2.0@css-loader/dist/cjs.js?!./node_modules/_postcss-loader@3.0.0@postcss-loader/src/index.js!./src/static/css/style.css");

if (typeof content === 'string') {
  content = [[module.i, content, '']];
}

var options = {}

options.insert = "head";
options.singleton = false;

var update = __webpack_require__(/*! ../../../node_modules/_style-loader@1.0.0@style-loader/dist/runtime/injectStylesIntoStyleTag.js */ "./node_modules/_style-loader@1.0.0@style-loader/dist/runtime/injectStylesIntoStyleTag.js")(content, options);

if (content.locals) {
  module.exports = content.locals;
}


/***/ }),

/***/ "./src/static/images/bg.jpg":
/*!**********************************!*\
  !*** ./src/static/images/bg.jpg ***!
  \**********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "assets/css/bg.jpg";

/***/ }),

/***/ "./src/static/images/icon_arrow_down.png":
/*!***********************************************!*\
  !*** ./src/static/images/icon_arrow_down.png ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "assets/css/icon_arrow_down.png";

/***/ }),

/***/ "./src/utils/paging.jsx":
/*!******************************!*\
  !*** ./src/utils/paging.jsx ***!
  \******************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.array.map */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.array.map.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var Paging =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Paging, _React$Component);

  function Paging(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Paging);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Paging).call(this, props));
    _this.state = {
      fields: props.fields,
      items: props.items || []
    };

    if (!props.items) {
      _this.postData();
    }

    return _this;
  }

  (0, _createClass2["default"])(Paging, [{
    key: "postData",
    value: function postData() {
      var _this2 = this;

      fetch(this.props.url, {
        method: 'POST'
      }).then(function (res) {
        return res.json();
      }).then(function (data) {
        console.log(data);

        _this2.setState({
          items: data.content || []
        });
      })["catch"](function (e) {
        return console.log(e);
      });
    }
  }, {
    key: "componentDidMount",
    value: function componentDidMount() {
      var row = _react["default"].createElement(Row, {
        cloumns: this.state.fields
      });

      var h_items = [];
      this.state.fields.map(function (field) {
        h_items.push(_react["default"].createElement("th", null, field.label ? field.label : field.render()));
      });
      this.setState({
        head: _react["default"].createElement("tr", null, h_items),
        body: function body(item, index) {
          return _react["default"].cloneElement(row, {
            item: item,
            index: index
          });
        }
      });
    }
  }, {
    key: "render",
    value: function render() {
      var _this3 = this;

      return _react["default"].createElement("div", null, _react["default"].createElement("table", {
        "class": "table"
      }, _react["default"].createElement("thead", null, this.state.head), _react["default"].createElement("tbody", null, this.state.items.length == 0 ? _react["default"].createElement("tr", null, _react["default"].createElement("td", {
        colSpan: this.state.fields.length,
        style: {
          color: '#ccc'
        }
      }, _react["default"].createElement("p", null, _react["default"].createElement("i", {
        "class": "icon iconfont",
        style: {
          fontSize: 36
        }
      }, "\uE708")), _react["default"].createElement("p", null, "\u6682\u65E0\u6570\u636E"))) : this.state.items.map(function (item, index) {
        return _this3.state.body(item, index);
      }))));
    }
  }]);
  return Paging;
}(_react["default"].Component);

var Row =
/*#__PURE__*/
function (_React$Component2) {
  (0, _inherits2["default"])(Row, _React$Component2);

  function Row(props) {
    var _this4;

    (0, _classCallCheck2["default"])(this, Row);
    _this4 = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Row).call(this, props));
    _this4.state = {
      item: props.item || {},
      index: props.index || 0
    };
    return _this4;
  }

  (0, _createClass2["default"])(Row, [{
    key: "render",
    value: function render() {
      var _this5 = this;

      return _react["default"].createElement("tr", null, this.props.cloumns.map(function (c) {
        return _react["default"].createElement("td", null, c.render ? c.render(_this5.state.item, _this5.state.index) : _this5.state.item[c.key]);
      }));
    }
  }]);
  return Row;
}(_react["default"].Component);

module.exports = Paging;

/***/ }),

/***/ "./src/views/404/index.jsx":
/*!*********************************!*\
  !*** ./src/views/404/index.jsx ***!
  \*********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

function PageNotFound() {
  return _react["default"].createElement("h1", null, "404! The page lost the way!");
}

module.exports = PageNotFound;

/***/ }),

/***/ "./src/views/group/index.jsx":
/*!***********************************!*\
  !*** ./src/views/group/index.jsx ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.array.sort */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.array.sort.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _paging = _interopRequireDefault(__webpack_require__(/*! ../../utils/paging */ "./src/utils/paging.jsx"));

var Group =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Group, _React$Component);

  function Group(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Group);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Group).call(this, props));
    _this.state = {
      data: [],
      fields: [{
        key: 'createDate',
        label: '创建时间',
        render: function render(item) {
          return _react["default"].createElement(Input, {
            type: "text",
            value: item.sort,
            style: {
              width: 45
            }
          });
        }
      }, {
        key: 'name',
        label: '分组名称'
      }, {
        key: 'length',
        label: '分区个数',
        render: function render(item) {
          return item.partitionGroups.length;
        }
      }, {
        key: 'id',
        label: '操作',
        render: function render(item) {
          return _react["default"].createElement("div", {
            "class": "btn-group"
          }, _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u5145\u503C"), _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u7F16\u8F91"), _react["default"].createElement("a", {
            "class": "btn bg-danger",
            href: ""
          }, "\u5220\u9664"));
        }
      }]
    };
    return _this;
  }

  (0, _createClass2["default"])(Group, [{
    key: "componentDidMount",
    value: function componentDidMount() {// fetch("/mer/group/list", {
      //     method: "POST"
      // })
    }
  }, {
    key: "render",
    value: function render() {
      return _react["default"].createElement("div", null, _react["default"].createElement(_paging["default"], {
        items: this.state.data,
        fields: this.state.fields
      }));
    }
  }]);
  return Group;
}(_react["default"].Component);

module.exports = Group;

/***/ }),

/***/ "./src/views/home/index.jsx":
/*!**********************************!*\
  !*** ./src/views/home/index.jsx ***!
  \**********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.function.name */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.function.name.js");

__webpack_require__(/*! core-js/modules/es6.function.bind */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.function.bind.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _assertThisInitialized2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/assertThisInitialized */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/assertThisInitialized.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _tools = __webpack_require__(/*! ../../components/tools */ "./src/components/tools/index.jsx");

var Home =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Home, _React$Component);

  function Home(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Home);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Home).call(this, props));
    _this.state = {
      name: 'Vanson',
      date: new Date(),
      data: []
    };
    console.log(new Date());
    _this.onChange = _this.onChange.bind((0, _assertThisInitialized2["default"])(_this));
    return _this;
  }

  (0, _createClass2["default"])(Home, [{
    key: "onChange",
    value: function onChange(e) {
      this.setState({
        name: e.target.value
      });
    }
  }, {
    key: "componentDidMount",
    value: function componentDidMount() {
      var _this2 = this;

      fetch('http://192.168.0.100/mer/product/list').then(function (res) {
        return res.json();
      }).then(function (data) {
        console.log(data);

        _this2.setState({
          data: data
        });
      })["catch"](function (e) {
        return console.log(e);
      });
    }
  }, {
    key: "render",
    value: function render() {
      return _react["default"].createElement("div", null, _react["default"].createElement(_tools.CheckBox, {
        id: "zfb",
        name: "zfb",
        value: "0"
      }, "\u652F\u4ED8\u5B9D"), _react["default"].createElement(_tools.CheckBox, {
        id: "wx",
        name: "wx",
        value: "1"
      }, "\u5FAE\u4FE1"), _react["default"].createElement(_tools.CheckBox, null, "000"), _react["default"].createElement(_tools.CheckBox, null, "111"), _react["default"].createElement("h2", null, "This is home."), _react["default"].createElement(_tools.Input, {
        value: this.state.name,
        onChange: this.onChange
      }), _react["default"].createElement("p", null, "My name is ", this.state.name, "."), _react["default"].createElement("p", null, "\u73B0\u5728\u662F ", this.state.date.toLocaleTimeString()), _react["default"].createElement("input", {
        id: "check-box-1",
        type: "checkbox"
      }), _react["default"].createElement("label", {
        "for": "check-box-1",
        "class": "check-box"
      }, _react["default"].createElement("i", null), "\u652F\u4ED8\u5B9D"), _react["default"].createElement("input", {
        id: "check-box-2",
        type: "checkbox"
      }), _react["default"].createElement("label", {
        "for": "check-box-2",
        "class": "check-box"
      }, _react["default"].createElement("i", null), "\u5FAE\u4FE1"), _react["default"].createElement("i", {
        "class": "icon iconfont no-check"
      }, "\uE764"), _react["default"].createElement("i", {
        "class": "icon iconfont check"
      }, "\uE6D4"), _react["default"].createElement("i", {
        "class": "icon iconfont check"
      }, "\uE6A7"), _react["default"].createElement("i", {
        "class": "icon iconfont no-check"
      }, "\uE684"), _react["default"].createElement("i", {
        "class": "icon iconfont check"
      }, "\uE67D"), _react["default"].createElement("i", {
        "class": "icon iconfont"
      }, "\uE652"), _react["default"].createElement("div", {
        style: {
          width: '33.3333%',
          marginBottom: '5px'
        }
      }, _react["default"].createElement(_tools.FormGroup, {
        id: "startDate",
        title: "\u5F00\u59CB\u65F6\u95F4"
      }, _react["default"].createElement("input", {
        "class": "form-control",
        name: "startDate",
        type: "text",
        placeholder: "-\u5E74-\u6708-\u65E5  --:--:--"
      }))), _react["default"].createElement("div", {
        style: {
          width: '33.3333%',
          marginBottom: '5px'
        }
      }, _react["default"].createElement(_tools.FormGroup, {
        id: "startDate",
        title: "\u5F00\u59CB\u65F6\u95F4"
      }, _react["default"].createElement(_tools.Selector, {
        items: this.state.data,
        "t-f": "name",
        "v-f": "id"
      }))));
    }
  }]);
  return Home;
}(_react["default"].Component);

module.exports = Home;

/***/ }),

/***/ "./src/views/order/index.jsx":
/*!***********************************!*\
  !*** ./src/views/order/index.jsx ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _paging = _interopRequireDefault(__webpack_require__(/*! ../../utils/paging */ "./src/utils/paging.jsx"));

var _tools = __webpack_require__(/*! ../../components/tools */ "./src/components/tools/index.jsx");

var _api = __webpack_require__(/*! ../../api/api */ "./src/api/api.jsx");

var Order =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Order, _React$Component);

  function Order(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Order);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Order).call(this, props));
    _this.state = {
      data: [],
      fields: [{
        key: 'orderDate',
        label: '充值时间'
      }, {
        key: 'orderNumber',
        label: '订单号',
        render: function render(item) {
          return _react["default"].createElement("a", {
            href: "javascript:;"
          }, item.orderNumber);
        }
      }, {
        key: 'playerAccount',
        label: '游戏帐号'
      }, {
        key: 'partitionName',
        label: '分区'
      }, {
        key: 'amount',
        label: '充值金额'
      }, {
        key: 'merchantProfit',
        label: '利润'
      }, {
        key: 'productName',
        label: '充值方式'
      }, {
        key: 'state',
        label: '订单状态',
        render: function render(item) {
          if (item.state == 2) {
            return _react["default"].createElement("button", {
              "class": "btn btn-min bg-primary"
            }, "\u8865\u53D1");
          }

          var s = _this.state.states[item.state];
          return _react["default"].createElement("span", {
            "class": 'labels labels-l ' + s.clazz
          }, s.content);
        }
      }],
      states: [{
        clazz: "bg-danger",
        content: "待付款"
      }, {
        clazz: "bg-success",
        content: "成　功"
      }, {
        clazz: "bg-info",
        content: "待发送"
      }, {
        clazz: "orange",
        content: "已退款"
      }],
      groups: [],
      partitions: [],
      products: []
    };
    return _this;
  }

  (0, _createClass2["default"])(Order, [{
    key: "componentDidMount",
    value: function componentDidMount() {// groupList(data => {
      //     this.setState({
      //         groups: data
      //     });
      // });
      // partitionList(data => {
      //     this.setState({
      //         partitions: data
      //     });
      // });
      // productList(data => {
      //     this.setState({
      //         products: data
      //     });
      // });
    }
  }, {
    key: "render",
    value: function render() {
      return _react["default"].createElement("div", null, _react["default"].createElement("div", {
        "class": "col-xs-4 pl-0"
      }, _react["default"].createElement(_tools.FormGroup, {
        title: "\u5F00\u59CB\u65F6\u95F4"
      }, _react["default"].createElement("input", {
        "class": "form-control calendar",
        id: "startDate",
        name: "orderDate",
        type: "text",
        placeholder: "-\u5E74-\u6708-\u65E5  --:--:--",
        readOnly: true
      }), _react["default"].createElement("i", {
        "class": "icon iconfont"
      }, "\uE6C5"))), _react["default"].createElement("div", {
        "class": "col-xs-4"
      }, _react["default"].createElement(_tools.FormGroup, {
        title: "\u7ED3\u675F\u65F6\u95F4"
      }, _react["default"].createElement("input", {
        "class": "form-control calendar",
        id: "endDate",
        name: "payDate",
        type: "text",
        placeholder: "-\u5E74-\u6708-\u65E5  --:--:--",
        readOnly: true
      }), _react["default"].createElement("i", {
        "class": "icon iconfont"
      }, "\uE6C5"))), _react["default"].createElement("div", {
        "class": "col-xs-4 pr-0"
      }, _react["default"].createElement(_tools.FormGroup, {
        title: "\u8BA2\u5355\u7F16\u53F7"
      }, _react["default"].createElement("input", {
        "class": "form-control",
        name: "orderNumber",
        type: "text",
        placeholder: "\u8BF7\u8F93\u5165\u8BA2\u5355\u53F7"
      }))), _react["default"].createElement("div", {
        "class": "col-xs-4 pl-0"
      }, _react["default"].createElement(_tools.FormGroup, {
        title: "\u6240\u5C5E\u5206\u7EC4"
      }, _react["default"].createElement(_tools.Selector, {
        name: "product.id",
        items: this.state.groups,
        "t-f": "name",
        "v-f": "id"
      }))), _react["default"].createElement("div", {
        "class": "col-xs-4"
      }, _react["default"].createElement(_tools.FormGroup, {
        title: "\u6240\u5C5E\u5206\u533A"
      }, _react["default"].createElement(_tools.Selector, {
        name: "product.id",
        items: this.state.partitions,
        "t-f": "name",
        "v-f": "id"
      }))), _react["default"].createElement("div", {
        "class": "col-xs-4 pr-0"
      }, _react["default"].createElement(_tools.FormGroup, {
        title: "\u5145\u503C\u65B9\u5F0F"
      }, _react["default"].createElement(_tools.Selector, {
        name: "product.id",
        items: this.state.products,
        "t-f": "name",
        "v-f": "id"
      }))), _react["default"].createElement("div", {
        "class": "text-center",
        style: {
          padding: 3
        }
      }, _react["default"].createElement("button", {
        "class": "btn bg-success",
        style: {
          marginRight: 5
        }
      }, "\u4E0A\u4E00\u5929"), _react["default"].createElement("button", {
        "class": "btn bg-primary",
        style: {
          marginRight: 5
        }
      }, "\u4ECA\u5929"), _react["default"].createElement("button", {
        "class": "btn bg-success",
        style: {
          marginRight: 5
        }
      }, "\u4E0B\u4E00\u5929"), _react["default"].createElement("button", {
        "class": "btn bg-info"
      }, "\u67E5\u8BE2")), _react["default"].createElement("div", {
        "class": "progress progress-active",
        "data-percent": "55%"
      }, _react["default"].createElement("div", {
        "class": "progress-bar",
        style: {
          width: '55%'
        }
      })), _react["default"].createElement(_paging["default"], {
        items: this.state.data,
        fields: this.state.fields
      }));
    }
  }]);
  return Order;
}(_react["default"].Component);

module.exports = Order;

/***/ }),

/***/ "./src/views/page1/async.jsx":
/*!***********************************!*\
  !*** ./src/views/page1/async.jsx ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.promise */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.promise.js");

__webpack_require__(/*! core-js/modules/es6.object.to-string */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.object.to-string.js");

var _interopRequireWildcard2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/interopRequireWildcard */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireWildcard.js"));

var _reactLoadable = _interopRequireDefault(__webpack_require__(/*! react-loadable */ "./node_modules/_react-loadable@5.5.0@react-loadable/lib/index.js"));

var _loading = _interopRequireDefault(__webpack_require__(/*! ../../components/loading */ "./src/components/loading/index.jsx"));

var AsyncPage1 = (0, _reactLoadable["default"])({
  loader: function loader() {
    return Promise.resolve().then(function () {
      return (0, _interopRequireWildcard2["default"])(__webpack_require__(/*! ./index */ "./src/views/page1/index.jsx"));
    });
  },
  loading: _loading["default"]
});
module.exports = AsyncPage1;

/***/ }),

/***/ "./src/views/page1/index.jsx":
/*!***********************************!*\
  !*** ./src/views/page1/index.jsx ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

function Page1() {
  return _react["default"].createElement("h2", null, "This is page1.");
}

module.exports = Page1;

/***/ }),

/***/ "./src/views/page2/index.jsx":
/*!***********************************!*\
  !*** ./src/views/page2/index.jsx ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

function Page2() {
  return _react["default"].createElement("h2", null, "This is page2.");
}

module.exports = Page2;

/***/ }),

/***/ "./src/views/partition/index.jsx":
/*!***************************************!*\
  !*** ./src/views/partition/index.jsx ***!
  \***************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

__webpack_require__(/*! core-js/modules/es6.array.sort */ "./node_modules/_core-js@2.6.10@core-js/modules/es6.array.sort.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _paging = _interopRequireDefault(__webpack_require__(/*! ../../utils/paging */ "./src/utils/paging.jsx"));

var _tools = __webpack_require__(/*! ../../components/tools */ "./src/components/tools/index.jsx");

var _api = __webpack_require__(/*! ../../api/api */ "./src/api/api.jsx");

var Partition =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Partition, _React$Component);

  function Partition(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Partition);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Partition).call(this, props));
    _this.state = {
      data: [],
      fields: [{
        key: 'id',
        render: function render(item, index) {
          return _react["default"].createElement(_tools.CheckBox, {
            id: 'p-' + (isNaN(index) ? 'all' : index),
            name: item ? 'id' : '',
            value: item ? item.id : ''
          });
        }
      }, {
        key: 'sort',
        label: '排序',
        render: function render(item) {
          return _react["default"].createElement(_tools.Input, {
            type: "text",
            value: item.sort,
            style: {
              width: 45
            }
          });
        }
      }, {
        key: 'name',
        label: '名称'
      }, {
        key: 'currencyName',
        label: '游戏币'
      }, {
        key: 'serverIp',
        label: '服务器'
      }, {
        key: 'scriptPath',
        label: '路径'
      }, {
        key: 'id',
        label: '操作',
        render: function render(item) {
          return _react["default"].createElement("div", {
            "class": "btn-group"
          }, _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u5145\u503C"), _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u68C0\u6D4B"), _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u7F16\u8F91"), _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u52A0\u8F7D"), _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u514B\u9686"), _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u8865\u53D1"), _react["default"].createElement("a", {
            "class": "btn bg-danger",
            href: ""
          }, "\u5220\u9664"));
        }
      }],
      groups: [],
      templates: []
    };
    return _this;
  }

  (0, _createClass2["default"])(Partition, [{
    key: "componentDidMount",
    value: function componentDidMount() {// groupList(data => {
      //     this.setState({
      //         groups: data
      //     });
      // });
      // templateList(data => {
      //     this.setState({
      //         templates: data
      //     });
      // });
    }
  }, {
    key: "render",
    value: function render() {
      return _react["default"].createElement("div", null, _react["default"].createElement("div", {
        "class": "col-xs-3 pl-0"
      }, _react["default"].createElement(_tools.FormGroup, {
        id: "group",
        title: "\u6240\u5C5E\u5206\u7EC4"
      }, _react["default"].createElement(_tools.Selector, {
        name: "product.id",
        items: this.state.groups,
        "t-f": "name",
        "v-f": "id"
      }))), _react["default"].createElement("div", {
        "class": "col-xs-3 pr-0"
      }, _react["default"].createElement(_tools.FormGroup, {
        id: "template",
        title: "\u5206\u533A\u6A21\u7248"
      }, _react["default"].createElement(_tools.Selector, {
        name: "template.id",
        items: this.state.templates,
        "t-f": "name",
        "v-f": "id"
      }))), _react["default"].createElement("div", {
        style: {
          marginBottom: 10
        }
      }, _react["default"].createElement("b", null, "\u63D0\u793A\uFF1A"), "\u5173\u4E8E\u201C", _react["default"].createElement("b", null, "\u70ED\u8840\u4F20\u5947"), "\u201D\u652F\u6301\u7B2C\u4E8C\u79CD\u6E38\u620F\u5E01,\u5982\u4EBA\u6C11\u5E01\uFF0C\u7528\u6237\u53EF\u4EE5\u901A\u8FC7\u514B\u9686\u5206\u533A\u65B9\u5F0F\u5B9E\u73B0\u3002"), _react["default"].createElement(_paging["default"], {
        items: this.state.data,
        fields: this.state.fields
      }));
    }
  }]);
  return Partition;
}(_react["default"].Component);

module.exports = Partition;

/***/ }),

/***/ "./src/views/template/index.jsx":
/*!**************************************!*\
  !*** ./src/views/template/index.jsx ***!
  \**************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/interopRequireDefault.js");

var _classCallCheck2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/classCallCheck.js"));

var _createClass2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/createClass.js"));

var _possibleConstructorReturn2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/possibleConstructorReturn.js"));

var _getPrototypeOf2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/getPrototypeOf.js"));

var _inherits2 = _interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/_@babel_runtime@7.7.2@@babel/runtime/helpers/inherits.js"));

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/_anujs@1.6.0@anujs/dist/ReactIE.js"));

var _paging = _interopRequireDefault(__webpack_require__(/*! ../../utils/paging */ "./src/utils/paging.jsx"));

var Template =
/*#__PURE__*/
function (_React$Component) {
  (0, _inherits2["default"])(Template, _React$Component);

  function Template(props) {
    var _this;

    (0, _classCallCheck2["default"])(this, Template);
    _this = (0, _possibleConstructorReturn2["default"])(this, (0, _getPrototypeOf2["default"])(Template).call(this, props));
    _this.state = {
      data: [],
      games: ['', '热血传奇', '传奇世界', '传奇三'],
      fields: [{
        key: 'name',
        label: '模版名称'
      }, {
        key: 'type',
        label: '游戏',
        render: function render(item) {
          return item.type == 0 ? item.gameName : _this.state.games[item.type];
        }
      }, {
        key: 'currencyName',
        label: '游戏币'
      }, {
        key: 'ratio',
        label: '兑换比例'
      }, {
        key: 'length',
        label: '分区个数',
        render: function render(item) {
          return item.partitions.length;
        }
      }, {
        key: 'id',
        label: '操作',
        render: function render(item) {
          return _react["default"].createElement("div", {
            "class": "btn-group"
          }, _react["default"].createElement("a", {
            "class": "btn bg-primary",
            href: ""
          }, "\u7F16\u8F91"), _react["default"].createElement("a", {
            "class": "btn bg-danger",
            href: ""
          }, "\u5220\u9664"));
        }
      }]
    };
    return _this;
  }

  (0, _createClass2["default"])(Template, [{
    key: "componentDidMount",
    value: function componentDidMount() {// fetch("/mer/group/list", {
      //     method: "POST"
      // })
    }
  }, {
    key: "render",
    value: function render() {
      return _react["default"].createElement("div", null, _react["default"].createElement(_paging["default"], {
        items: this.state.data,
        fields: this.state.fields
      }));
    }
  }]);
  return Template;
}(_react["default"].Component);

module.exports = Template;

/***/ })

/******/ });
//# sourceMappingURL=app.a5c246e1532b8245f196.js.map