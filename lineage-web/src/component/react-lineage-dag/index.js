'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var React = require('react');
var _ = require('lodash');
var PropTypes = require('prop-types');
var ReactButterfly = require('butterfly-react');
var require$$0 = require('lodash/clone');
var require$$1 = require('lodash/constant');
var require$$2 = require('lodash/each');
var require$$3 = require('lodash/filter');
var require$$4 = require('lodash/has');
var require$$5 = require('lodash/isArray');
var require$$6 = require('lodash/isEmpty');
var require$$7 = require('lodash/isFunction');
var require$$8 = require('lodash/isUndefined');
var require$$9 = require('lodash/keys');
var require$$10 = require('lodash/map');
var require$$11 = require('lodash/reduce');
var require$$12 = require('lodash/size');
var require$$13 = require('lodash/transform');
var require$$14 = require('lodash/union');
var require$$15 = require('lodash/values');
var require$$0$1 = require('lodash/cloneDeep');
var require$$2$1 = require('lodash/defaults');
var require$$5$1 = require('lodash/find');
var require$$6$1 = require('lodash/flatten');
var require$$7$1 = require('lodash/forEach');
var require$$8$1 = require('lodash/forIn');
var require$$11$1 = require('lodash/last');
var require$$13$1 = require('lodash/mapValues');
var require$$14$1 = require('lodash/max');
var require$$15$1 = require('lodash/merge');
var require$$16 = require('lodash/min');
var require$$17 = require('lodash/minBy');
var require$$18 = require('lodash/now');
var require$$19 = require('lodash/pick');
var require$$20 = require('lodash/range');
var require$$22 = require('lodash/sortBy');
var require$$23 = require('lodash/uniqueId');
var require$$25 = require('lodash/zipObject');
var classnames = require('classnames');
var antd = require('antd');
require('@ant-design/icons');

function _interopDefaultLegacy (e) { return e && typeof e === 'object' && 'default' in e ? e : { 'default': e }; }

var React__default = /*#__PURE__*/_interopDefaultLegacy(React);
var ___default = /*#__PURE__*/_interopDefaultLegacy(_);
var PropTypes__default = /*#__PURE__*/_interopDefaultLegacy(PropTypes);
var ReactButterfly__default = /*#__PURE__*/_interopDefaultLegacy(ReactButterfly);
var require$$0__default = /*#__PURE__*/_interopDefaultLegacy(require$$0);
var require$$1__default = /*#__PURE__*/_interopDefaultLegacy(require$$1);
var require$$2__default = /*#__PURE__*/_interopDefaultLegacy(require$$2);
var require$$3__default = /*#__PURE__*/_interopDefaultLegacy(require$$3);
var require$$4__default = /*#__PURE__*/_interopDefaultLegacy(require$$4);
var require$$5__default = /*#__PURE__*/_interopDefaultLegacy(require$$5);
var require$$6__default = /*#__PURE__*/_interopDefaultLegacy(require$$6);
var require$$7__default = /*#__PURE__*/_interopDefaultLegacy(require$$7);
var require$$8__default = /*#__PURE__*/_interopDefaultLegacy(require$$8);
var require$$9__default = /*#__PURE__*/_interopDefaultLegacy(require$$9);
var require$$10__default = /*#__PURE__*/_interopDefaultLegacy(require$$10);
var require$$11__default = /*#__PURE__*/_interopDefaultLegacy(require$$11);
var require$$12__default = /*#__PURE__*/_interopDefaultLegacy(require$$12);
var require$$13__default = /*#__PURE__*/_interopDefaultLegacy(require$$13);
var require$$14__default = /*#__PURE__*/_interopDefaultLegacy(require$$14);
var require$$15__default = /*#__PURE__*/_interopDefaultLegacy(require$$15);
var require$$0__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$0$1);
var require$$2__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$2$1);
var require$$5__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$5$1);
var require$$6__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$6$1);
var require$$7__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$7$1);
var require$$8__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$8$1);
var require$$11__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$11$1);
var require$$13__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$13$1);
var require$$14__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$14$1);
var require$$15__default$1 = /*#__PURE__*/_interopDefaultLegacy(require$$15$1);
var require$$16__default = /*#__PURE__*/_interopDefaultLegacy(require$$16);
var require$$17__default = /*#__PURE__*/_interopDefaultLegacy(require$$17);
var require$$18__default = /*#__PURE__*/_interopDefaultLegacy(require$$18);
var require$$19__default = /*#__PURE__*/_interopDefaultLegacy(require$$19);
var require$$20__default = /*#__PURE__*/_interopDefaultLegacy(require$$20);
var require$$22__default = /*#__PURE__*/_interopDefaultLegacy(require$$22);
var require$$23__default = /*#__PURE__*/_interopDefaultLegacy(require$$23);
var require$$25__default = /*#__PURE__*/_interopDefaultLegacy(require$$25);
var classnames__default = /*#__PURE__*/_interopDefaultLegacy(classnames);

function ownKeys(object, enumerableOnly) {
  var keys = Object.keys(object);

  if (Object.getOwnPropertySymbols) {
    var symbols = Object.getOwnPropertySymbols(object);
    enumerableOnly && (symbols = symbols.filter(function (sym) {
      return Object.getOwnPropertyDescriptor(object, sym).enumerable;
    })), keys.push.apply(keys, symbols);
  }

  return keys;
}

function _objectSpread2(target) {
  for (var i = 1; i < arguments.length; i++) {
    var source = null != arguments[i] ? arguments[i] : {};
    i % 2 ? ownKeys(Object(source), !0).forEach(function (key) {
      _defineProperty(target, key, source[key]);
    }) : Object.getOwnPropertyDescriptors ? Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)) : ownKeys(Object(source)).forEach(function (key) {
      Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key));
    });
  }

  return target;
}

function _defineProperty(obj, key, value) {
  if (key in obj) {
    Object.defineProperty(obj, key, {
      value: value,
      enumerable: true,
      configurable: true,
      writable: true
    });
  } else {
    obj[key] = value;
  }

  return obj;
}

function _slicedToArray(arr, i) {
  return _arrayWithHoles(arr) || _iterableToArrayLimit(arr, i) || _unsupportedIterableToArray(arr, i) || _nonIterableRest();
}

function _arrayWithHoles(arr) {
  if (Array.isArray(arr)) return arr;
}

function _iterableToArrayLimit(arr, i) {
  var _i = arr == null ? null : typeof Symbol !== "undefined" && arr[Symbol.iterator] || arr["@@iterator"];

  if (_i == null) return;
  var _arr = [];
  var _n = true;
  var _d = false;

  var _s, _e;

  try {
    for (_i = _i.call(arr); !(_n = (_s = _i.next()).done); _n = true) {
      _arr.push(_s.value);

      if (i && _arr.length === i) break;
    }
  } catch (err) {
    _d = true;
    _e = err;
  } finally {
    try {
      if (!_n && _i["return"] != null) _i["return"]();
    } finally {
      if (_d) throw _e;
    }
  }

  return _arr;
}

function _unsupportedIterableToArray(o, minLen) {
  if (!o) return;
  if (typeof o === "string") return _arrayLikeToArray(o, minLen);
  var n = Object.prototype.toString.call(o).slice(8, -1);
  if (n === "Object" && o.constructor) n = o.constructor.name;
  if (n === "Map" || n === "Set") return Array.from(o);
  if (n === "Arguments" || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return _arrayLikeToArray(o, minLen);
}

function _arrayLikeToArray(arr, len) {
  if (len == null || len > arr.length) len = arr.length;

  for (var i = 0, arr2 = new Array(len); i < len; i++) arr2[i] = arr[i];

  return arr2;
}

function _nonIterableRest() {
  throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.");
}

var commonjsGlobal = typeof globalThis !== 'undefined' ? globalThis : typeof window !== 'undefined' ? window : typeof global !== 'undefined' ? global : typeof self !== 'undefined' ? self : {};

function createCommonjsModule(fn) {
  var module = { exports: {} };
	return fn(module, module.exports), module.exports;
}

function commonjsRequire (target) {
	throw new Error('Could not dynamically require "' + target + '". Please configure the dynamicRequireTargets option of @rollup/plugin-commonjs appropriately for this require call to behave properly.');
}

/*!
 * jQuery JavaScript Library v3.6.0
 * https://jquery.com/
 *
 * Includes Sizzle.js
 * https://sizzlejs.com/
 *
 * Copyright OpenJS Foundation and other contributors
 * Released under the MIT license
 * https://jquery.org/license
 *
 * Date: 2021-03-02T17:08Z
 */
var jquery = createCommonjsModule(function (module) {
  (function (global, factory) {

    {
      // For CommonJS and CommonJS-like environments where a proper `window`
      // is present, execute the factory and get jQuery.
      // For environments that do not have a `window` with a `document`
      // (such as Node.js), expose a factory as module.exports.
      // This accentuates the need for the creation of a real `window`.
      // e.g. var jQuery = require("jquery")(window);
      // See ticket #14549 for more info.
      module.exports = global.document ? factory(global, true) : function (w) {
        if (!w.document) {
          throw new Error("jQuery requires a window with a document");
        }

        return factory(w);
      };
    } // Pass this if window is not defined yet

  })(typeof window !== "undefined" ? window : commonjsGlobal, function (window, noGlobal) {

    var arr = [];
    var getProto = Object.getPrototypeOf;
    var slice = arr.slice;
    var flat = arr.flat ? function (array) {
      return arr.flat.call(array);
    } : function (array) {
      return arr.concat.apply([], array);
    };
    var push = arr.push;
    var indexOf = arr.indexOf;
    var class2type = {};
    var toString = class2type.toString;
    var hasOwn = class2type.hasOwnProperty;
    var fnToString = hasOwn.toString;
    var ObjectFunctionString = fnToString.call(Object);
    var support = {};

    var isFunction = function isFunction(obj) {
      // Support: Chrome <=57, Firefox <=52
      // In some browsers, typeof returns "function" for HTML <object> elements
      // (i.e., `typeof document.createElement( "object" ) === "function"`).
      // We don't want to classify *any* DOM node as a function.
      // Support: QtWeb <=3.8.5, WebKit <=534.34, wkhtmltopdf tool <=0.12.5
      // Plus for old WebKit, typeof returns "function" for HTML collections
      // (e.g., `typeof document.getElementsByTagName("div") === "function"`). (gh-4756)
      return typeof obj === "function" && typeof obj.nodeType !== "number" && typeof obj.item !== "function";
    };

    var isWindow = function isWindow(obj) {
      return obj != null && obj === obj.window;
    };

    var document = window.document;
    var preservedScriptAttributes = {
      type: true,
      src: true,
      nonce: true,
      noModule: true
    };

    function DOMEval(code, node, doc) {
      doc = doc || document;
      var i,
          val,
          script = doc.createElement("script");
      script.text = code;

      if (node) {
        for (i in preservedScriptAttributes) {
          // Support: Firefox 64+, Edge 18+
          // Some browsers don't support the "nonce" property on scripts.
          // On the other hand, just using `getAttribute` is not enough as
          // the `nonce` attribute is reset to an empty string whenever it
          // becomes browsing-context connected.
          // See https://github.com/whatwg/html/issues/2369
          // See https://html.spec.whatwg.org/#nonce-attributes
          // The `node.getAttribute` check was added for the sake of
          // `jQuery.globalEval` so that it can fake a nonce-containing node
          // via an object.
          val = node[i] || node.getAttribute && node.getAttribute(i);

          if (val) {
            script.setAttribute(i, val);
          }
        }
      }

      doc.head.appendChild(script).parentNode.removeChild(script);
    }

    function toType(obj) {
      if (obj == null) {
        return obj + "";
      } // Support: Android <=2.3 only (functionish RegExp)


      return typeof obj === "object" || typeof obj === "function" ? class2type[toString.call(obj)] || "object" : typeof obj;
    }
    /* global Symbol */
    // Defining this global in .eslintrc.json would create a danger of using the global
    // unguarded in another place, it seems safer to define global only for this module


    var version = "3.6.0",
        // Define a local copy of jQuery
    jQuery = function (selector, context) {
      // The jQuery object is actually just the init constructor 'enhanced'
      // Need init if jQuery is called (just allow error to be thrown if not included)
      return new jQuery.fn.init(selector, context);
    };

    jQuery.fn = jQuery.prototype = {
      // The current version of jQuery being used
      jquery: version,
      constructor: jQuery,
      // The default length of a jQuery object is 0
      length: 0,
      toArray: function () {
        return slice.call(this);
      },
      // Get the Nth element in the matched element set OR
      // Get the whole matched element set as a clean array
      get: function (num) {
        // Return all the elements in a clean array
        if (num == null) {
          return slice.call(this);
        } // Return just the one element from the set


        return num < 0 ? this[num + this.length] : this[num];
      },
      // Take an array of elements and push it onto the stack
      // (returning the new matched element set)
      pushStack: function (elems) {
        // Build a new jQuery matched element set
        var ret = jQuery.merge(this.constructor(), elems); // Add the old object onto the stack (as a reference)

        ret.prevObject = this; // Return the newly-formed element set

        return ret;
      },
      // Execute a callback for every element in the matched set.
      each: function (callback) {
        return jQuery.each(this, callback);
      },
      map: function (callback) {
        return this.pushStack(jQuery.map(this, function (elem, i) {
          return callback.call(elem, i, elem);
        }));
      },
      slice: function () {
        return this.pushStack(slice.apply(this, arguments));
      },
      first: function () {
        return this.eq(0);
      },
      last: function () {
        return this.eq(-1);
      },
      even: function () {
        return this.pushStack(jQuery.grep(this, function (_elem, i) {
          return (i + 1) % 2;
        }));
      },
      odd: function () {
        return this.pushStack(jQuery.grep(this, function (_elem, i) {
          return i % 2;
        }));
      },
      eq: function (i) {
        var len = this.length,
            j = +i + (i < 0 ? len : 0);
        return this.pushStack(j >= 0 && j < len ? [this[j]] : []);
      },
      end: function () {
        return this.prevObject || this.constructor();
      },
      // For internal use only.
      // Behaves like an Array's method, not like a jQuery method.
      push: push,
      sort: arr.sort,
      splice: arr.splice
    };

    jQuery.extend = jQuery.fn.extend = function () {
      var options,
          name,
          src,
          copy,
          copyIsArray,
          clone,
          target = arguments[0] || {},
          i = 1,
          length = arguments.length,
          deep = false; // Handle a deep copy situation

      if (typeof target === "boolean") {
        deep = target; // Skip the boolean and the target

        target = arguments[i] || {};
        i++;
      } // Handle case when target is a string or something (possible in deep copy)


      if (typeof target !== "object" && !isFunction(target)) {
        target = {};
      } // Extend jQuery itself if only one argument is passed


      if (i === length) {
        target = this;
        i--;
      }

      for (; i < length; i++) {
        // Only deal with non-null/undefined values
        if ((options = arguments[i]) != null) {
          // Extend the base object
          for (name in options) {
            copy = options[name]; // Prevent Object.prototype pollution
            // Prevent never-ending loop

            if (name === "__proto__" || target === copy) {
              continue;
            } // Recurse if we're merging plain objects or arrays


            if (deep && copy && (jQuery.isPlainObject(copy) || (copyIsArray = Array.isArray(copy)))) {
              src = target[name]; // Ensure proper type for the source value

              if (copyIsArray && !Array.isArray(src)) {
                clone = [];
              } else if (!copyIsArray && !jQuery.isPlainObject(src)) {
                clone = {};
              } else {
                clone = src;
              }

              copyIsArray = false; // Never move original objects, clone them

              target[name] = jQuery.extend(deep, clone, copy); // Don't bring in undefined values
            } else if (copy !== undefined) {
              target[name] = copy;
            }
          }
        }
      } // Return the modified object


      return target;
    };

    jQuery.extend({
      // Unique for each copy of jQuery on the page
      expando: "jQuery" + (version + Math.random()).replace(/\D/g, ""),
      // Assume jQuery is ready without the ready module
      isReady: true,
      error: function (msg) {
        throw new Error(msg);
      },
      noop: function () {},
      isPlainObject: function (obj) {
        var proto, Ctor; // Detect obvious negatives
        // Use toString instead of jQuery.type to catch host objects

        if (!obj || toString.call(obj) !== "[object Object]") {
          return false;
        }

        proto = getProto(obj); // Objects with no prototype (e.g., `Object.create( null )`) are plain

        if (!proto) {
          return true;
        } // Objects with prototype are plain iff they were constructed by a global Object function


        Ctor = hasOwn.call(proto, "constructor") && proto.constructor;
        return typeof Ctor === "function" && fnToString.call(Ctor) === ObjectFunctionString;
      },
      isEmptyObject: function (obj) {
        var name;

        for (name in obj) {
          return false;
        }

        return true;
      },
      // Evaluates a script in a provided context; falls back to the global one
      // if not specified.
      globalEval: function (code, options, doc) {
        DOMEval(code, {
          nonce: options && options.nonce
        }, doc);
      },
      each: function (obj, callback) {
        var length,
            i = 0;

        if (isArrayLike(obj)) {
          length = obj.length;

          for (; i < length; i++) {
            if (callback.call(obj[i], i, obj[i]) === false) {
              break;
            }
          }
        } else {
          for (i in obj) {
            if (callback.call(obj[i], i, obj[i]) === false) {
              break;
            }
          }
        }

        return obj;
      },
      // results is for internal usage only
      makeArray: function (arr, results) {
        var ret = results || [];

        if (arr != null) {
          if (isArrayLike(Object(arr))) {
            jQuery.merge(ret, typeof arr === "string" ? [arr] : arr);
          } else {
            push.call(ret, arr);
          }
        }

        return ret;
      },
      inArray: function (elem, arr, i) {
        return arr == null ? -1 : indexOf.call(arr, elem, i);
      },
      // Support: Android <=4.0 only, PhantomJS 1 only
      // push.apply(_, arraylike) throws on ancient WebKit
      merge: function (first, second) {
        var len = +second.length,
            j = 0,
            i = first.length;

        for (; j < len; j++) {
          first[i++] = second[j];
        }

        first.length = i;
        return first;
      },
      grep: function (elems, callback, invert) {
        var callbackInverse,
            matches = [],
            i = 0,
            length = elems.length,
            callbackExpect = !invert; // Go through the array, only saving the items
        // that pass the validator function

        for (; i < length; i++) {
          callbackInverse = !callback(elems[i], i);

          if (callbackInverse !== callbackExpect) {
            matches.push(elems[i]);
          }
        }

        return matches;
      },
      // arg is for internal usage only
      map: function (elems, callback, arg) {
        var length,
            value,
            i = 0,
            ret = []; // Go through the array, translating each of the items to their new values

        if (isArrayLike(elems)) {
          length = elems.length;

          for (; i < length; i++) {
            value = callback(elems[i], i, arg);

            if (value != null) {
              ret.push(value);
            }
          } // Go through every key on the object,

        } else {
          for (i in elems) {
            value = callback(elems[i], i, arg);

            if (value != null) {
              ret.push(value);
            }
          }
        } // Flatten any nested arrays


        return flat(ret);
      },
      // A global GUID counter for objects
      guid: 1,
      // jQuery.support is not used in Core but other projects attach their
      // properties to it so it needs to exist.
      support: support
    });

    if (typeof Symbol === "function") {
      jQuery.fn[Symbol.iterator] = arr[Symbol.iterator];
    } // Populate the class2type map


    jQuery.each("Boolean Number String Function Array Date RegExp Object Error Symbol".split(" "), function (_i, name) {
      class2type["[object " + name + "]"] = name.toLowerCase();
    });

    function isArrayLike(obj) {
      // Support: real iOS 8.2 only (not reproducible in simulator)
      // `in` check used to prevent JIT error (gh-2145)
      // hasOwn isn't used here due to false negatives
      // regarding Nodelist length in IE
      var length = !!obj && "length" in obj && obj.length,
          type = toType(obj);

      if (isFunction(obj) || isWindow(obj)) {
        return false;
      }

      return type === "array" || length === 0 || typeof length === "number" && length > 0 && length - 1 in obj;
    }

    var Sizzle =
    /*!
     * Sizzle CSS Selector Engine v2.3.6
     * https://sizzlejs.com/
     *
     * Copyright JS Foundation and other contributors
     * Released under the MIT license
     * https://js.foundation/
     *
     * Date: 2021-02-16
     */
    function (window) {
      var i,
          support,
          Expr,
          getText,
          isXML,
          tokenize,
          compile,
          select,
          outermostContext,
          sortInput,
          hasDuplicate,
          // Local document vars
      setDocument,
          document,
          docElem,
          documentIsHTML,
          rbuggyQSA,
          rbuggyMatches,
          matches,
          contains,
          // Instance-specific data
      expando = "sizzle" + 1 * new Date(),
          preferredDoc = window.document,
          dirruns = 0,
          done = 0,
          classCache = createCache(),
          tokenCache = createCache(),
          compilerCache = createCache(),
          nonnativeSelectorCache = createCache(),
          sortOrder = function (a, b) {
        if (a === b) {
          hasDuplicate = true;
        }

        return 0;
      },
          // Instance methods
      hasOwn = {}.hasOwnProperty,
          arr = [],
          pop = arr.pop,
          pushNative = arr.push,
          push = arr.push,
          slice = arr.slice,
          // Use a stripped-down indexOf as it's faster than native
      // https://jsperf.com/thor-indexof-vs-for/5
      indexOf = function (list, elem) {
        var i = 0,
            len = list.length;

        for (; i < len; i++) {
          if (list[i] === elem) {
            return i;
          }
        }

        return -1;
      },
          booleans = "checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|" + "ismap|loop|multiple|open|readonly|required|scoped",
          // Regular expressions
      // http://www.w3.org/TR/css3-selectors/#whitespace
      whitespace = "[\\x20\\t\\r\\n\\f]",
          // https://www.w3.org/TR/css-syntax-3/#ident-token-diagram
      identifier = "(?:\\\\[\\da-fA-F]{1,6}" + whitespace + "?|\\\\[^\\r\\n\\f]|[\\w-]|[^\0-\\x7f])+",
          // Attribute selectors: http://www.w3.org/TR/selectors/#attribute-selectors
      attributes = "\\[" + whitespace + "*(" + identifier + ")(?:" + whitespace + // Operator (capture 2)
      "*([*^$|!~]?=)" + whitespace + // "Attribute values must be CSS identifiers [capture 5]
      // or strings [capture 3 or capture 4]"
      "*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\"|(" + identifier + "))|)" + whitespace + "*\\]",
          pseudos = ":(" + identifier + ")(?:\\((" + // To reduce the number of selectors needing tokenize in the preFilter, prefer arguments:
      // 1. quoted (capture 3; capture 4 or capture 5)
      "('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\")|" + // 2. simple (capture 6)
      "((?:\\\\.|[^\\\\()[\\]]|" + attributes + ")*)|" + // 3. anything else (capture 2)
      ".*" + ")\\)|)",
          // Leading and non-escaped trailing whitespace, capturing some non-whitespace characters preceding the latter
      rwhitespace = new RegExp(whitespace + "+", "g"),
          rtrim = new RegExp("^" + whitespace + "+|((?:^|[^\\\\])(?:\\\\.)*)" + whitespace + "+$", "g"),
          rcomma = new RegExp("^" + whitespace + "*," + whitespace + "*"),
          rcombinators = new RegExp("^" + whitespace + "*([>+~]|" + whitespace + ")" + whitespace + "*"),
          rdescend = new RegExp(whitespace + "|>"),
          rpseudo = new RegExp(pseudos),
          ridentifier = new RegExp("^" + identifier + "$"),
          matchExpr = {
        "ID": new RegExp("^#(" + identifier + ")"),
        "CLASS": new RegExp("^\\.(" + identifier + ")"),
        "TAG": new RegExp("^(" + identifier + "|[*])"),
        "ATTR": new RegExp("^" + attributes),
        "PSEUDO": new RegExp("^" + pseudos),
        "CHILD": new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" + whitespace + "*(even|odd|(([+-]|)(\\d*)n|)" + whitespace + "*(?:([+-]|)" + whitespace + "*(\\d+)|))" + whitespace + "*\\)|)", "i"),
        "bool": new RegExp("^(?:" + booleans + ")$", "i"),
        // For use in libraries implementing .is()
        // We use this for POS matching in `select`
        "needsContext": new RegExp("^" + whitespace + "*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + whitespace + "*((?:-\\d)?\\d*)" + whitespace + "*\\)|)(?=[^-]|$)", "i")
      },
          rhtml = /HTML$/i,
          rinputs = /^(?:input|select|textarea|button)$/i,
          rheader = /^h\d$/i,
          rnative = /^[^{]+\{\s*\[native \w/,
          // Easily-parseable/retrievable ID or TAG or CLASS selectors
      rquickExpr = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/,
          rsibling = /[+~]/,
          // CSS escapes
      // http://www.w3.org/TR/CSS21/syndata.html#escaped-characters
      runescape = new RegExp("\\\\[\\da-fA-F]{1,6}" + whitespace + "?|\\\\([^\\r\\n\\f])", "g"),
          funescape = function (escape, nonHex) {
        var high = "0x" + escape.slice(1) - 0x10000;
        return nonHex ? // Strip the backslash prefix from a non-hex escape sequence
        nonHex : // Replace a hexadecimal escape sequence with the encoded Unicode code point
        // Support: IE <=11+
        // For values outside the Basic Multilingual Plane (BMP), manually construct a
        // surrogate pair
        high < 0 ? String.fromCharCode(high + 0x10000) : String.fromCharCode(high >> 10 | 0xD800, high & 0x3FF | 0xDC00);
      },
          // CSS string/identifier serialization
      // https://drafts.csswg.org/cssom/#common-serializing-idioms
      rcssescape = /([\0-\x1f\x7f]|^-?\d)|^-$|[^\0-\x1f\x7f-\uFFFF\w-]/g,
          fcssescape = function (ch, asCodePoint) {
        if (asCodePoint) {
          // U+0000 NULL becomes U+FFFD REPLACEMENT CHARACTER
          if (ch === "\0") {
            return "\uFFFD";
          } // Control characters and (dependent upon position) numbers get escaped as code points


          return ch.slice(0, -1) + "\\" + ch.charCodeAt(ch.length - 1).toString(16) + " ";
        } // Other potentially-special ASCII characters get backslash-escaped


        return "\\" + ch;
      },
          // Used for iframes
      // See setDocument()
      // Removing the function wrapper causes a "Permission Denied"
      // error in IE
      unloadHandler = function () {
        setDocument();
      },
          inDisabledFieldset = addCombinator(function (elem) {
        return elem.disabled === true && elem.nodeName.toLowerCase() === "fieldset";
      }, {
        dir: "parentNode",
        next: "legend"
      }); // Optimize for push.apply( _, NodeList )


      try {
        push.apply(arr = slice.call(preferredDoc.childNodes), preferredDoc.childNodes); // Support: Android<4.0
        // Detect silently failing push.apply
        // eslint-disable-next-line no-unused-expressions

        arr[preferredDoc.childNodes.length].nodeType;
      } catch (e) {
        push = {
          apply: arr.length ? // Leverage slice if possible
          function (target, els) {
            pushNative.apply(target, slice.call(els));
          } : // Support: IE<9
          // Otherwise append directly
          function (target, els) {
            var j = target.length,
                i = 0; // Can't trust NodeList.length

            while (target[j++] = els[i++]) {}

            target.length = j - 1;
          }
        };
      }

      function Sizzle(selector, context, results, seed) {
        var m,
            i,
            elem,
            nid,
            match,
            groups,
            newSelector,
            newContext = context && context.ownerDocument,
            // nodeType defaults to 9, since context defaults to document
        nodeType = context ? context.nodeType : 9;
        results = results || []; // Return early from calls with invalid selector or context

        if (typeof selector !== "string" || !selector || nodeType !== 1 && nodeType !== 9 && nodeType !== 11) {
          return results;
        } // Try to shortcut find operations (as opposed to filters) in HTML documents


        if (!seed) {
          setDocument(context);
          context = context || document;

          if (documentIsHTML) {
            // If the selector is sufficiently simple, try using a "get*By*" DOM method
            // (excepting DocumentFragment context, where the methods don't exist)
            if (nodeType !== 11 && (match = rquickExpr.exec(selector))) {
              // ID selector
              if (m = match[1]) {
                // Document context
                if (nodeType === 9) {
                  if (elem = context.getElementById(m)) {
                    // Support: IE, Opera, Webkit
                    // TODO: identify versions
                    // getElementById can match elements by name instead of ID
                    if (elem.id === m) {
                      results.push(elem);
                      return results;
                    }
                  } else {
                    return results;
                  } // Element context

                } else {
                  // Support: IE, Opera, Webkit
                  // TODO: identify versions
                  // getElementById can match elements by name instead of ID
                  if (newContext && (elem = newContext.getElementById(m)) && contains(context, elem) && elem.id === m) {
                    results.push(elem);
                    return results;
                  }
                } // Type selector

              } else if (match[2]) {
                push.apply(results, context.getElementsByTagName(selector));
                return results; // Class selector
              } else if ((m = match[3]) && support.getElementsByClassName && context.getElementsByClassName) {
                push.apply(results, context.getElementsByClassName(m));
                return results;
              }
            } // Take advantage of querySelectorAll


            if (support.qsa && !nonnativeSelectorCache[selector + " "] && (!rbuggyQSA || !rbuggyQSA.test(selector)) && ( // Support: IE 8 only
            // Exclude object elements
            nodeType !== 1 || context.nodeName.toLowerCase() !== "object")) {
              newSelector = selector;
              newContext = context; // qSA considers elements outside a scoping root when evaluating child or
              // descendant combinators, which is not what we want.
              // In such cases, we work around the behavior by prefixing every selector in the
              // list with an ID selector referencing the scope context.
              // The technique has to be used as well when a leading combinator is used
              // as such selectors are not recognized by querySelectorAll.
              // Thanks to Andrew Dupont for this technique.

              if (nodeType === 1 && (rdescend.test(selector) || rcombinators.test(selector))) {
                // Expand context for sibling selectors
                newContext = rsibling.test(selector) && testContext(context.parentNode) || context; // We can use :scope instead of the ID hack if the browser
                // supports it & if we're not changing the context.

                if (newContext !== context || !support.scope) {
                  // Capture the context ID, setting it first if necessary
                  if (nid = context.getAttribute("id")) {
                    nid = nid.replace(rcssescape, fcssescape);
                  } else {
                    context.setAttribute("id", nid = expando);
                  }
                } // Prefix every selector in the list


                groups = tokenize(selector);
                i = groups.length;

                while (i--) {
                  groups[i] = (nid ? "#" + nid : ":scope") + " " + toSelector(groups[i]);
                }

                newSelector = groups.join(",");
              }

              try {
                push.apply(results, newContext.querySelectorAll(newSelector));
                return results;
              } catch (qsaError) {
                nonnativeSelectorCache(selector, true);
              } finally {
                if (nid === expando) {
                  context.removeAttribute("id");
                }
              }
            }
          }
        } // All others


        return select(selector.replace(rtrim, "$1"), context, results, seed);
      }
      /**
       * Create key-value caches of limited size
       * @returns {function(string, object)} Returns the Object data after storing it on itself with
       *	property name the (space-suffixed) string and (if the cache is larger than Expr.cacheLength)
       *	deleting the oldest entry
       */


      function createCache() {
        var keys = [];

        function cache(key, value) {
          // Use (key + " ") to avoid collision with native prototype properties (see Issue #157)
          if (keys.push(key + " ") > Expr.cacheLength) {
            // Only keep the most recent entries
            delete cache[keys.shift()];
          }

          return cache[key + " "] = value;
        }

        return cache;
      }
      /**
       * Mark a function for special use by Sizzle
       * @param {Function} fn The function to mark
       */


      function markFunction(fn) {
        fn[expando] = true;
        return fn;
      }
      /**
       * Support testing using an element
       * @param {Function} fn Passed the created element and returns a boolean result
       */


      function assert(fn) {
        var el = document.createElement("fieldset");

        try {
          return !!fn(el);
        } catch (e) {
          return false;
        } finally {
          // Remove from its parent by default
          if (el.parentNode) {
            el.parentNode.removeChild(el);
          } // release memory in IE


          el = null;
        }
      }
      /**
       * Adds the same handler for all of the specified attrs
       * @param {String} attrs Pipe-separated list of attributes
       * @param {Function} handler The method that will be applied
       */


      function addHandle(attrs, handler) {
        var arr = attrs.split("|"),
            i = arr.length;

        while (i--) {
          Expr.attrHandle[arr[i]] = handler;
        }
      }
      /**
       * Checks document order of two siblings
       * @param {Element} a
       * @param {Element} b
       * @returns {Number} Returns less than 0 if a precedes b, greater than 0 if a follows b
       */


      function siblingCheck(a, b) {
        var cur = b && a,
            diff = cur && a.nodeType === 1 && b.nodeType === 1 && a.sourceIndex - b.sourceIndex; // Use IE sourceIndex if available on both nodes

        if (diff) {
          return diff;
        } // Check if b follows a


        if (cur) {
          while (cur = cur.nextSibling) {
            if (cur === b) {
              return -1;
            }
          }
        }

        return a ? 1 : -1;
      }
      /**
       * Returns a function to use in pseudos for input types
       * @param {String} type
       */


      function createInputPseudo(type) {
        return function (elem) {
          var name = elem.nodeName.toLowerCase();
          return name === "input" && elem.type === type;
        };
      }
      /**
       * Returns a function to use in pseudos for buttons
       * @param {String} type
       */


      function createButtonPseudo(type) {
        return function (elem) {
          var name = elem.nodeName.toLowerCase();
          return (name === "input" || name === "button") && elem.type === type;
        };
      }
      /**
       * Returns a function to use in pseudos for :enabled/:disabled
       * @param {Boolean} disabled true for :disabled; false for :enabled
       */


      function createDisabledPseudo(disabled) {
        // Known :disabled false positives: fieldset[disabled] > legend:nth-of-type(n+2) :can-disable
        return function (elem) {
          // Only certain elements can match :enabled or :disabled
          // https://html.spec.whatwg.org/multipage/scripting.html#selector-enabled
          // https://html.spec.whatwg.org/multipage/scripting.html#selector-disabled
          if ("form" in elem) {
            // Check for inherited disabledness on relevant non-disabled elements:
            // * listed form-associated elements in a disabled fieldset
            //   https://html.spec.whatwg.org/multipage/forms.html#category-listed
            //   https://html.spec.whatwg.org/multipage/forms.html#concept-fe-disabled
            // * option elements in a disabled optgroup
            //   https://html.spec.whatwg.org/multipage/forms.html#concept-option-disabled
            // All such elements have a "form" property.
            if (elem.parentNode && elem.disabled === false) {
              // Option elements defer to a parent optgroup if present
              if ("label" in elem) {
                if ("label" in elem.parentNode) {
                  return elem.parentNode.disabled === disabled;
                } else {
                  return elem.disabled === disabled;
                }
              } // Support: IE 6 - 11
              // Use the isDisabled shortcut property to check for disabled fieldset ancestors


              return elem.isDisabled === disabled || // Where there is no isDisabled, check manually

              /* jshint -W018 */
              elem.isDisabled !== !disabled && inDisabledFieldset(elem) === disabled;
            }

            return elem.disabled === disabled; // Try to winnow out elements that can't be disabled before trusting the disabled property.
            // Some victims get caught in our net (label, legend, menu, track), but it shouldn't
            // even exist on them, let alone have a boolean value.
          } else if ("label" in elem) {
            return elem.disabled === disabled;
          } // Remaining elements are neither :enabled nor :disabled


          return false;
        };
      }
      /**
       * Returns a function to use in pseudos for positionals
       * @param {Function} fn
       */


      function createPositionalPseudo(fn) {
        return markFunction(function (argument) {
          argument = +argument;
          return markFunction(function (seed, matches) {
            var j,
                matchIndexes = fn([], seed.length, argument),
                i = matchIndexes.length; // Match elements found at the specified indexes

            while (i--) {
              if (seed[j = matchIndexes[i]]) {
                seed[j] = !(matches[j] = seed[j]);
              }
            }
          });
        });
      }
      /**
       * Checks a node for validity as a Sizzle context
       * @param {Element|Object=} context
       * @returns {Element|Object|Boolean} The input node if acceptable, otherwise a falsy value
       */


      function testContext(context) {
        return context && typeof context.getElementsByTagName !== "undefined" && context;
      } // Expose support vars for convenience


      support = Sizzle.support = {};
      /**
       * Detects XML nodes
       * @param {Element|Object} elem An element or a document
       * @returns {Boolean} True iff elem is a non-HTML XML node
       */

      isXML = Sizzle.isXML = function (elem) {
        var namespace = elem && elem.namespaceURI,
            docElem = elem && (elem.ownerDocument || elem).documentElement; // Support: IE <=8
        // Assume HTML when documentElement doesn't yet exist, such as inside loading iframes
        // https://bugs.jquery.com/ticket/4833

        return !rhtml.test(namespace || docElem && docElem.nodeName || "HTML");
      };
      /**
       * Sets document-related variables once based on the current document
       * @param {Element|Object} [doc] An element or document object to use to set the document
       * @returns {Object} Returns the current document
       */


      setDocument = Sizzle.setDocument = function (node) {
        var hasCompare,
            subWindow,
            doc = node ? node.ownerDocument || node : preferredDoc; // Return early if doc is invalid or already selected
        // Support: IE 11+, Edge 17 - 18+
        // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
        // two documents; shallow comparisons work.
        // eslint-disable-next-line eqeqeq

        if (doc == document || doc.nodeType !== 9 || !doc.documentElement) {
          return document;
        } // Update global variables


        document = doc;
        docElem = document.documentElement;
        documentIsHTML = !isXML(document); // Support: IE 9 - 11+, Edge 12 - 18+
        // Accessing iframe documents after unload throws "permission denied" errors (jQuery #13936)
        // Support: IE 11+, Edge 17 - 18+
        // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
        // two documents; shallow comparisons work.
        // eslint-disable-next-line eqeqeq

        if (preferredDoc != document && (subWindow = document.defaultView) && subWindow.top !== subWindow) {
          // Support: IE 11, Edge
          if (subWindow.addEventListener) {
            subWindow.addEventListener("unload", unloadHandler, false); // Support: IE 9 - 10 only
          } else if (subWindow.attachEvent) {
            subWindow.attachEvent("onunload", unloadHandler);
          }
        } // Support: IE 8 - 11+, Edge 12 - 18+, Chrome <=16 - 25 only, Firefox <=3.6 - 31 only,
        // Safari 4 - 5 only, Opera <=11.6 - 12.x only
        // IE/Edge & older browsers don't support the :scope pseudo-class.
        // Support: Safari 6.0 only
        // Safari 6.0 supports :scope but it's an alias of :root there.


        support.scope = assert(function (el) {
          docElem.appendChild(el).appendChild(document.createElement("div"));
          return typeof el.querySelectorAll !== "undefined" && !el.querySelectorAll(":scope fieldset div").length;
        });
        /* Attributes
        ---------------------------------------------------------------------- */
        // Support: IE<8
        // Verify that getAttribute really returns attributes and not properties
        // (excepting IE8 booleans)

        support.attributes = assert(function (el) {
          el.className = "i";
          return !el.getAttribute("className");
        });
        /* getElement(s)By*
        ---------------------------------------------------------------------- */
        // Check if getElementsByTagName("*") returns only elements

        support.getElementsByTagName = assert(function (el) {
          el.appendChild(document.createComment(""));
          return !el.getElementsByTagName("*").length;
        }); // Support: IE<9

        support.getElementsByClassName = rnative.test(document.getElementsByClassName); // Support: IE<10
        // Check if getElementById returns elements by name
        // The broken getElementById methods don't pick up programmatically-set names,
        // so use a roundabout getElementsByName test

        support.getById = assert(function (el) {
          docElem.appendChild(el).id = expando;
          return !document.getElementsByName || !document.getElementsByName(expando).length;
        }); // ID filter and find

        if (support.getById) {
          Expr.filter["ID"] = function (id) {
            var attrId = id.replace(runescape, funescape);
            return function (elem) {
              return elem.getAttribute("id") === attrId;
            };
          };

          Expr.find["ID"] = function (id, context) {
            if (typeof context.getElementById !== "undefined" && documentIsHTML) {
              var elem = context.getElementById(id);
              return elem ? [elem] : [];
            }
          };
        } else {
          Expr.filter["ID"] = function (id) {
            var attrId = id.replace(runescape, funescape);
            return function (elem) {
              var node = typeof elem.getAttributeNode !== "undefined" && elem.getAttributeNode("id");
              return node && node.value === attrId;
            };
          }; // Support: IE 6 - 7 only
          // getElementById is not reliable as a find shortcut


          Expr.find["ID"] = function (id, context) {
            if (typeof context.getElementById !== "undefined" && documentIsHTML) {
              var node,
                  i,
                  elems,
                  elem = context.getElementById(id);

              if (elem) {
                // Verify the id attribute
                node = elem.getAttributeNode("id");

                if (node && node.value === id) {
                  return [elem];
                } // Fall back on getElementsByName


                elems = context.getElementsByName(id);
                i = 0;

                while (elem = elems[i++]) {
                  node = elem.getAttributeNode("id");

                  if (node && node.value === id) {
                    return [elem];
                  }
                }
              }

              return [];
            }
          };
        } // Tag


        Expr.find["TAG"] = support.getElementsByTagName ? function (tag, context) {
          if (typeof context.getElementsByTagName !== "undefined") {
            return context.getElementsByTagName(tag); // DocumentFragment nodes don't have gEBTN
          } else if (support.qsa) {
            return context.querySelectorAll(tag);
          }
        } : function (tag, context) {
          var elem,
              tmp = [],
              i = 0,
              // By happy coincidence, a (broken) gEBTN appears on DocumentFragment nodes too
          results = context.getElementsByTagName(tag); // Filter out possible comments

          if (tag === "*") {
            while (elem = results[i++]) {
              if (elem.nodeType === 1) {
                tmp.push(elem);
              }
            }

            return tmp;
          }

          return results;
        }; // Class

        Expr.find["CLASS"] = support.getElementsByClassName && function (className, context) {
          if (typeof context.getElementsByClassName !== "undefined" && documentIsHTML) {
            return context.getElementsByClassName(className);
          }
        };
        /* QSA/matchesSelector
        ---------------------------------------------------------------------- */
        // QSA and matchesSelector support
        // matchesSelector(:active) reports false when true (IE9/Opera 11.5)


        rbuggyMatches = []; // qSa(:focus) reports false when true (Chrome 21)
        // We allow this because of a bug in IE8/9 that throws an error
        // whenever `document.activeElement` is accessed on an iframe
        // So, we allow :focus to pass through QSA all the time to avoid the IE error
        // See https://bugs.jquery.com/ticket/13378

        rbuggyQSA = [];

        if (support.qsa = rnative.test(document.querySelectorAll)) {
          // Build QSA regex
          // Regex strategy adopted from Diego Perini
          assert(function (el) {
            var input; // Select is set to empty string on purpose
            // This is to test IE's treatment of not explicitly
            // setting a boolean content attribute,
            // since its presence should be enough
            // https://bugs.jquery.com/ticket/12359

            docElem.appendChild(el).innerHTML = "<a id='" + expando + "'></a>" + "<select id='" + expando + "-\r\\' msallowcapture=''>" + "<option selected=''></option></select>"; // Support: IE8, Opera 11-12.16
            // Nothing should be selected when empty strings follow ^= or $= or *=
            // The test attribute must be unknown in Opera but "safe" for WinRT
            // https://msdn.microsoft.com/en-us/library/ie/hh465388.aspx#attribute_section

            if (el.querySelectorAll("[msallowcapture^='']").length) {
              rbuggyQSA.push("[*^$]=" + whitespace + "*(?:''|\"\")");
            } // Support: IE8
            // Boolean attributes and "value" are not treated correctly


            if (!el.querySelectorAll("[selected]").length) {
              rbuggyQSA.push("\\[" + whitespace + "*(?:value|" + booleans + ")");
            } // Support: Chrome<29, Android<4.4, Safari<7.0+, iOS<7.0+, PhantomJS<1.9.8+


            if (!el.querySelectorAll("[id~=" + expando + "-]").length) {
              rbuggyQSA.push("~=");
            } // Support: IE 11+, Edge 15 - 18+
            // IE 11/Edge don't find elements on a `[name='']` query in some cases.
            // Adding a temporary attribute to the document before the selection works
            // around the issue.
            // Interestingly, IE 10 & older don't seem to have the issue.


            input = document.createElement("input");
            input.setAttribute("name", "");
            el.appendChild(input);

            if (!el.querySelectorAll("[name='']").length) {
              rbuggyQSA.push("\\[" + whitespace + "*name" + whitespace + "*=" + whitespace + "*(?:''|\"\")");
            } // Webkit/Opera - :checked should return selected option elements
            // http://www.w3.org/TR/2011/REC-css3-selectors-20110929/#checked
            // IE8 throws error here and will not see later tests


            if (!el.querySelectorAll(":checked").length) {
              rbuggyQSA.push(":checked");
            } // Support: Safari 8+, iOS 8+
            // https://bugs.webkit.org/show_bug.cgi?id=136851
            // In-page `selector#id sibling-combinator selector` fails


            if (!el.querySelectorAll("a#" + expando + "+*").length) {
              rbuggyQSA.push(".#.+[+~]");
            } // Support: Firefox <=3.6 - 5 only
            // Old Firefox doesn't throw on a badly-escaped identifier.


            el.querySelectorAll("\\\f");
            rbuggyQSA.push("[\\r\\n\\f]");
          });
          assert(function (el) {
            el.innerHTML = "<a href='' disabled='disabled'></a>" + "<select disabled='disabled'><option/></select>"; // Support: Windows 8 Native Apps
            // The type and name attributes are restricted during .innerHTML assignment

            var input = document.createElement("input");
            input.setAttribute("type", "hidden");
            el.appendChild(input).setAttribute("name", "D"); // Support: IE8
            // Enforce case-sensitivity of name attribute

            if (el.querySelectorAll("[name=d]").length) {
              rbuggyQSA.push("name" + whitespace + "*[*^$|!~]?=");
            } // FF 3.5 - :enabled/:disabled and hidden elements (hidden elements are still enabled)
            // IE8 throws error here and will not see later tests


            if (el.querySelectorAll(":enabled").length !== 2) {
              rbuggyQSA.push(":enabled", ":disabled");
            } // Support: IE9-11+
            // IE's :disabled selector does not pick up the children of disabled fieldsets


            docElem.appendChild(el).disabled = true;

            if (el.querySelectorAll(":disabled").length !== 2) {
              rbuggyQSA.push(":enabled", ":disabled");
            } // Support: Opera 10 - 11 only
            // Opera 10-11 does not throw on post-comma invalid pseudos


            el.querySelectorAll("*,:x");
            rbuggyQSA.push(",.*:");
          });
        }

        if (support.matchesSelector = rnative.test(matches = docElem.matches || docElem.webkitMatchesSelector || docElem.mozMatchesSelector || docElem.oMatchesSelector || docElem.msMatchesSelector)) {
          assert(function (el) {
            // Check to see if it's possible to do matchesSelector
            // on a disconnected node (IE 9)
            support.disconnectedMatch = matches.call(el, "*"); // This should fail with an exception
            // Gecko does not error, returns false instead

            matches.call(el, "[s!='']:x");
            rbuggyMatches.push("!=", pseudos);
          });
        }

        rbuggyQSA = rbuggyQSA.length && new RegExp(rbuggyQSA.join("|"));
        rbuggyMatches = rbuggyMatches.length && new RegExp(rbuggyMatches.join("|"));
        /* Contains
        ---------------------------------------------------------------------- */

        hasCompare = rnative.test(docElem.compareDocumentPosition); // Element contains another
        // Purposefully self-exclusive
        // As in, an element does not contain itself

        contains = hasCompare || rnative.test(docElem.contains) ? function (a, b) {
          var adown = a.nodeType === 9 ? a.documentElement : a,
              bup = b && b.parentNode;
          return a === bup || !!(bup && bup.nodeType === 1 && (adown.contains ? adown.contains(bup) : a.compareDocumentPosition && a.compareDocumentPosition(bup) & 16));
        } : function (a, b) {
          if (b) {
            while (b = b.parentNode) {
              if (b === a) {
                return true;
              }
            }
          }

          return false;
        };
        /* Sorting
        ---------------------------------------------------------------------- */
        // Document order sorting

        sortOrder = hasCompare ? function (a, b) {
          // Flag for duplicate removal
          if (a === b) {
            hasDuplicate = true;
            return 0;
          } // Sort on method existence if only one input has compareDocumentPosition


          var compare = !a.compareDocumentPosition - !b.compareDocumentPosition;

          if (compare) {
            return compare;
          } // Calculate position if both inputs belong to the same document
          // Support: IE 11+, Edge 17 - 18+
          // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
          // two documents; shallow comparisons work.
          // eslint-disable-next-line eqeqeq


          compare = (a.ownerDocument || a) == (b.ownerDocument || b) ? a.compareDocumentPosition(b) : // Otherwise we know they are disconnected
          1; // Disconnected nodes

          if (compare & 1 || !support.sortDetached && b.compareDocumentPosition(a) === compare) {
            // Choose the first element that is related to our preferred document
            // Support: IE 11+, Edge 17 - 18+
            // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
            // two documents; shallow comparisons work.
            // eslint-disable-next-line eqeqeq
            if (a == document || a.ownerDocument == preferredDoc && contains(preferredDoc, a)) {
              return -1;
            } // Support: IE 11+, Edge 17 - 18+
            // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
            // two documents; shallow comparisons work.
            // eslint-disable-next-line eqeqeq


            if (b == document || b.ownerDocument == preferredDoc && contains(preferredDoc, b)) {
              return 1;
            } // Maintain original order


            return sortInput ? indexOf(sortInput, a) - indexOf(sortInput, b) : 0;
          }

          return compare & 4 ? -1 : 1;
        } : function (a, b) {
          // Exit early if the nodes are identical
          if (a === b) {
            hasDuplicate = true;
            return 0;
          }

          var cur,
              i = 0,
              aup = a.parentNode,
              bup = b.parentNode,
              ap = [a],
              bp = [b]; // Parentless nodes are either documents or disconnected

          if (!aup || !bup) {
            // Support: IE 11+, Edge 17 - 18+
            // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
            // two documents; shallow comparisons work.

            /* eslint-disable eqeqeq */
            return a == document ? -1 : b == document ? 1 :
            /* eslint-enable eqeqeq */
            aup ? -1 : bup ? 1 : sortInput ? indexOf(sortInput, a) - indexOf(sortInput, b) : 0; // If the nodes are siblings, we can do a quick check
          } else if (aup === bup) {
            return siblingCheck(a, b);
          } // Otherwise we need full lists of their ancestors for comparison


          cur = a;

          while (cur = cur.parentNode) {
            ap.unshift(cur);
          }

          cur = b;

          while (cur = cur.parentNode) {
            bp.unshift(cur);
          } // Walk down the tree looking for a discrepancy


          while (ap[i] === bp[i]) {
            i++;
          }

          return i ? // Do a sibling check if the nodes have a common ancestor
          siblingCheck(ap[i], bp[i]) : // Otherwise nodes in our document sort first
          // Support: IE 11+, Edge 17 - 18+
          // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
          // two documents; shallow comparisons work.

          /* eslint-disable eqeqeq */
          ap[i] == preferredDoc ? -1 : bp[i] == preferredDoc ? 1 :
          /* eslint-enable eqeqeq */
          0;
        };
        return document;
      };

      Sizzle.matches = function (expr, elements) {
        return Sizzle(expr, null, null, elements);
      };

      Sizzle.matchesSelector = function (elem, expr) {
        setDocument(elem);

        if (support.matchesSelector && documentIsHTML && !nonnativeSelectorCache[expr + " "] && (!rbuggyMatches || !rbuggyMatches.test(expr)) && (!rbuggyQSA || !rbuggyQSA.test(expr))) {
          try {
            var ret = matches.call(elem, expr); // IE 9's matchesSelector returns false on disconnected nodes

            if (ret || support.disconnectedMatch || // As well, disconnected nodes are said to be in a document
            // fragment in IE 9
            elem.document && elem.document.nodeType !== 11) {
              return ret;
            }
          } catch (e) {
            nonnativeSelectorCache(expr, true);
          }
        }

        return Sizzle(expr, document, null, [elem]).length > 0;
      };

      Sizzle.contains = function (context, elem) {
        // Set document vars if needed
        // Support: IE 11+, Edge 17 - 18+
        // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
        // two documents; shallow comparisons work.
        // eslint-disable-next-line eqeqeq
        if ((context.ownerDocument || context) != document) {
          setDocument(context);
        }

        return contains(context, elem);
      };

      Sizzle.attr = function (elem, name) {
        // Set document vars if needed
        // Support: IE 11+, Edge 17 - 18+
        // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
        // two documents; shallow comparisons work.
        // eslint-disable-next-line eqeqeq
        if ((elem.ownerDocument || elem) != document) {
          setDocument(elem);
        }

        var fn = Expr.attrHandle[name.toLowerCase()],
            // Don't get fooled by Object.prototype properties (jQuery #13807)
        val = fn && hasOwn.call(Expr.attrHandle, name.toLowerCase()) ? fn(elem, name, !documentIsHTML) : undefined;
        return val !== undefined ? val : support.attributes || !documentIsHTML ? elem.getAttribute(name) : (val = elem.getAttributeNode(name)) && val.specified ? val.value : null;
      };

      Sizzle.escape = function (sel) {
        return (sel + "").replace(rcssescape, fcssescape);
      };

      Sizzle.error = function (msg) {
        throw new Error("Syntax error, unrecognized expression: " + msg);
      };
      /**
       * Document sorting and removing duplicates
       * @param {ArrayLike} results
       */


      Sizzle.uniqueSort = function (results) {
        var elem,
            duplicates = [],
            j = 0,
            i = 0; // Unless we *know* we can detect duplicates, assume their presence

        hasDuplicate = !support.detectDuplicates;
        sortInput = !support.sortStable && results.slice(0);
        results.sort(sortOrder);

        if (hasDuplicate) {
          while (elem = results[i++]) {
            if (elem === results[i]) {
              j = duplicates.push(i);
            }
          }

          while (j--) {
            results.splice(duplicates[j], 1);
          }
        } // Clear input after sorting to release objects
        // See https://github.com/jquery/sizzle/pull/225


        sortInput = null;
        return results;
      };
      /**
       * Utility function for retrieving the text value of an array of DOM nodes
       * @param {Array|Element} elem
       */


      getText = Sizzle.getText = function (elem) {
        var node,
            ret = "",
            i = 0,
            nodeType = elem.nodeType;

        if (!nodeType) {
          // If no nodeType, this is expected to be an array
          while (node = elem[i++]) {
            // Do not traverse comment nodes
            ret += getText(node);
          }
        } else if (nodeType === 1 || nodeType === 9 || nodeType === 11) {
          // Use textContent for elements
          // innerText usage removed for consistency of new lines (jQuery #11153)
          if (typeof elem.textContent === "string") {
            return elem.textContent;
          } else {
            // Traverse its children
            for (elem = elem.firstChild; elem; elem = elem.nextSibling) {
              ret += getText(elem);
            }
          }
        } else if (nodeType === 3 || nodeType === 4) {
          return elem.nodeValue;
        } // Do not include comment or processing instruction nodes


        return ret;
      };

      Expr = Sizzle.selectors = {
        // Can be adjusted by the user
        cacheLength: 50,
        createPseudo: markFunction,
        match: matchExpr,
        attrHandle: {},
        find: {},
        relative: {
          ">": {
            dir: "parentNode",
            first: true
          },
          " ": {
            dir: "parentNode"
          },
          "+": {
            dir: "previousSibling",
            first: true
          },
          "~": {
            dir: "previousSibling"
          }
        },
        preFilter: {
          "ATTR": function (match) {
            match[1] = match[1].replace(runescape, funescape); // Move the given value to match[3] whether quoted or unquoted

            match[3] = (match[3] || match[4] || match[5] || "").replace(runescape, funescape);

            if (match[2] === "~=") {
              match[3] = " " + match[3] + " ";
            }

            return match.slice(0, 4);
          },
          "CHILD": function (match) {
            /* matches from matchExpr["CHILD"]
            	1 type (only|nth|...)
            	2 what (child|of-type)
            	3 argument (even|odd|\d*|\d*n([+-]\d+)?|...)
            	4 xn-component of xn+y argument ([+-]?\d*n|)
            	5 sign of xn-component
            	6 x of xn-component
            	7 sign of y-component
            	8 y of y-component
            */
            match[1] = match[1].toLowerCase();

            if (match[1].slice(0, 3) === "nth") {
              // nth-* requires argument
              if (!match[3]) {
                Sizzle.error(match[0]);
              } // numeric x and y parameters for Expr.filter.CHILD
              // remember that false/true cast respectively to 0/1


              match[4] = +(match[4] ? match[5] + (match[6] || 1) : 2 * (match[3] === "even" || match[3] === "odd"));
              match[5] = +(match[7] + match[8] || match[3] === "odd"); // other types prohibit arguments
            } else if (match[3]) {
              Sizzle.error(match[0]);
            }

            return match;
          },
          "PSEUDO": function (match) {
            var excess,
                unquoted = !match[6] && match[2];

            if (matchExpr["CHILD"].test(match[0])) {
              return null;
            } // Accept quoted arguments as-is


            if (match[3]) {
              match[2] = match[4] || match[5] || ""; // Strip excess characters from unquoted arguments
            } else if (unquoted && rpseudo.test(unquoted) && ( // Get excess from tokenize (recursively)
            excess = tokenize(unquoted, true)) && ( // advance to the next closing parenthesis
            excess = unquoted.indexOf(")", unquoted.length - excess) - unquoted.length)) {
              // excess is a negative index
              match[0] = match[0].slice(0, excess);
              match[2] = unquoted.slice(0, excess);
            } // Return only captures needed by the pseudo filter method (type and argument)


            return match.slice(0, 3);
          }
        },
        filter: {
          "TAG": function (nodeNameSelector) {
            var nodeName = nodeNameSelector.replace(runescape, funescape).toLowerCase();
            return nodeNameSelector === "*" ? function () {
              return true;
            } : function (elem) {
              return elem.nodeName && elem.nodeName.toLowerCase() === nodeName;
            };
          },
          "CLASS": function (className) {
            var pattern = classCache[className + " "];
            return pattern || (pattern = new RegExp("(^|" + whitespace + ")" + className + "(" + whitespace + "|$)")) && classCache(className, function (elem) {
              return pattern.test(typeof elem.className === "string" && elem.className || typeof elem.getAttribute !== "undefined" && elem.getAttribute("class") || "");
            });
          },
          "ATTR": function (name, operator, check) {
            return function (elem) {
              var result = Sizzle.attr(elem, name);

              if (result == null) {
                return operator === "!=";
              }

              if (!operator) {
                return true;
              }

              result += "";
              /* eslint-disable max-len */

              return operator === "=" ? result === check : operator === "!=" ? result !== check : operator === "^=" ? check && result.indexOf(check) === 0 : operator === "*=" ? check && result.indexOf(check) > -1 : operator === "$=" ? check && result.slice(-check.length) === check : operator === "~=" ? (" " + result.replace(rwhitespace, " ") + " ").indexOf(check) > -1 : operator === "|=" ? result === check || result.slice(0, check.length + 1) === check + "-" : false;
              /* eslint-enable max-len */
            };
          },
          "CHILD": function (type, what, _argument, first, last) {
            var simple = type.slice(0, 3) !== "nth",
                forward = type.slice(-4) !== "last",
                ofType = what === "of-type";
            return first === 1 && last === 0 ? // Shortcut for :nth-*(n)
            function (elem) {
              return !!elem.parentNode;
            } : function (elem, _context, xml) {
              var cache,
                  uniqueCache,
                  outerCache,
                  node,
                  nodeIndex,
                  start,
                  dir = simple !== forward ? "nextSibling" : "previousSibling",
                  parent = elem.parentNode,
                  name = ofType && elem.nodeName.toLowerCase(),
                  useCache = !xml && !ofType,
                  diff = false;

              if (parent) {
                // :(first|last|only)-(child|of-type)
                if (simple) {
                  while (dir) {
                    node = elem;

                    while (node = node[dir]) {
                      if (ofType ? node.nodeName.toLowerCase() === name : node.nodeType === 1) {
                        return false;
                      }
                    } // Reverse direction for :only-* (if we haven't yet done so)


                    start = dir = type === "only" && !start && "nextSibling";
                  }

                  return true;
                }

                start = [forward ? parent.firstChild : parent.lastChild]; // non-xml :nth-child(...) stores cache data on `parent`

                if (forward && useCache) {
                  // Seek `elem` from a previously-cached index
                  // ...in a gzip-friendly way
                  node = parent;
                  outerCache = node[expando] || (node[expando] = {}); // Support: IE <9 only
                  // Defend against cloned attroperties (jQuery gh-1709)

                  uniqueCache = outerCache[node.uniqueID] || (outerCache[node.uniqueID] = {});
                  cache = uniqueCache[type] || [];
                  nodeIndex = cache[0] === dirruns && cache[1];
                  diff = nodeIndex && cache[2];
                  node = nodeIndex && parent.childNodes[nodeIndex];

                  while (node = ++nodeIndex && node && node[dir] || ( // Fallback to seeking `elem` from the start
                  diff = nodeIndex = 0) || start.pop()) {
                    // When found, cache indexes on `parent` and break
                    if (node.nodeType === 1 && ++diff && node === elem) {
                      uniqueCache[type] = [dirruns, nodeIndex, diff];
                      break;
                    }
                  }
                } else {
                  // Use previously-cached element index if available
                  if (useCache) {
                    // ...in a gzip-friendly way
                    node = elem;
                    outerCache = node[expando] || (node[expando] = {}); // Support: IE <9 only
                    // Defend against cloned attroperties (jQuery gh-1709)

                    uniqueCache = outerCache[node.uniqueID] || (outerCache[node.uniqueID] = {});
                    cache = uniqueCache[type] || [];
                    nodeIndex = cache[0] === dirruns && cache[1];
                    diff = nodeIndex;
                  } // xml :nth-child(...)
                  // or :nth-last-child(...) or :nth(-last)?-of-type(...)


                  if (diff === false) {
                    // Use the same loop as above to seek `elem` from the start
                    while (node = ++nodeIndex && node && node[dir] || (diff = nodeIndex = 0) || start.pop()) {
                      if ((ofType ? node.nodeName.toLowerCase() === name : node.nodeType === 1) && ++diff) {
                        // Cache the index of each encountered element
                        if (useCache) {
                          outerCache = node[expando] || (node[expando] = {}); // Support: IE <9 only
                          // Defend against cloned attroperties (jQuery gh-1709)

                          uniqueCache = outerCache[node.uniqueID] || (outerCache[node.uniqueID] = {});
                          uniqueCache[type] = [dirruns, diff];
                        }

                        if (node === elem) {
                          break;
                        }
                      }
                    }
                  }
                } // Incorporate the offset, then check against cycle size


                diff -= last;
                return diff === first || diff % first === 0 && diff / first >= 0;
              }
            };
          },
          "PSEUDO": function (pseudo, argument) {
            // pseudo-class names are case-insensitive
            // http://www.w3.org/TR/selectors/#pseudo-classes
            // Prioritize by case sensitivity in case custom pseudos are added with uppercase letters
            // Remember that setFilters inherits from pseudos
            var args,
                fn = Expr.pseudos[pseudo] || Expr.setFilters[pseudo.toLowerCase()] || Sizzle.error("unsupported pseudo: " + pseudo); // The user may use createPseudo to indicate that
            // arguments are needed to create the filter function
            // just as Sizzle does

            if (fn[expando]) {
              return fn(argument);
            } // But maintain support for old signatures


            if (fn.length > 1) {
              args = [pseudo, pseudo, "", argument];
              return Expr.setFilters.hasOwnProperty(pseudo.toLowerCase()) ? markFunction(function (seed, matches) {
                var idx,
                    matched = fn(seed, argument),
                    i = matched.length;

                while (i--) {
                  idx = indexOf(seed, matched[i]);
                  seed[idx] = !(matches[idx] = matched[i]);
                }
              }) : function (elem) {
                return fn(elem, 0, args);
              };
            }

            return fn;
          }
        },
        pseudos: {
          // Potentially complex pseudos
          "not": markFunction(function (selector) {
            // Trim the selector passed to compile
            // to avoid treating leading and trailing
            // spaces as combinators
            var input = [],
                results = [],
                matcher = compile(selector.replace(rtrim, "$1"));
            return matcher[expando] ? markFunction(function (seed, matches, _context, xml) {
              var elem,
                  unmatched = matcher(seed, null, xml, []),
                  i = seed.length; // Match elements unmatched by `matcher`

              while (i--) {
                if (elem = unmatched[i]) {
                  seed[i] = !(matches[i] = elem);
                }
              }
            }) : function (elem, _context, xml) {
              input[0] = elem;
              matcher(input, null, xml, results); // Don't keep the element (issue #299)

              input[0] = null;
              return !results.pop();
            };
          }),
          "has": markFunction(function (selector) {
            return function (elem) {
              return Sizzle(selector, elem).length > 0;
            };
          }),
          "contains": markFunction(function (text) {
            text = text.replace(runescape, funescape);
            return function (elem) {
              return (elem.textContent || getText(elem)).indexOf(text) > -1;
            };
          }),
          // "Whether an element is represented by a :lang() selector
          // is based solely on the element's language value
          // being equal to the identifier C,
          // or beginning with the identifier C immediately followed by "-".
          // The matching of C against the element's language value is performed case-insensitively.
          // The identifier C does not have to be a valid language name."
          // http://www.w3.org/TR/selectors/#lang-pseudo
          "lang": markFunction(function (lang) {
            // lang value must be a valid identifier
            if (!ridentifier.test(lang || "")) {
              Sizzle.error("unsupported lang: " + lang);
            }

            lang = lang.replace(runescape, funescape).toLowerCase();
            return function (elem) {
              var elemLang;

              do {
                if (elemLang = documentIsHTML ? elem.lang : elem.getAttribute("xml:lang") || elem.getAttribute("lang")) {
                  elemLang = elemLang.toLowerCase();
                  return elemLang === lang || elemLang.indexOf(lang + "-") === 0;
                }
              } while ((elem = elem.parentNode) && elem.nodeType === 1);

              return false;
            };
          }),
          // Miscellaneous
          "target": function (elem) {
            var hash = window.location && window.location.hash;
            return hash && hash.slice(1) === elem.id;
          },
          "root": function (elem) {
            return elem === docElem;
          },
          "focus": function (elem) {
            return elem === document.activeElement && (!document.hasFocus || document.hasFocus()) && !!(elem.type || elem.href || ~elem.tabIndex);
          },
          // Boolean properties
          "enabled": createDisabledPseudo(false),
          "disabled": createDisabledPseudo(true),
          "checked": function (elem) {
            // In CSS3, :checked should return both checked and selected elements
            // http://www.w3.org/TR/2011/REC-css3-selectors-20110929/#checked
            var nodeName = elem.nodeName.toLowerCase();
            return nodeName === "input" && !!elem.checked || nodeName === "option" && !!elem.selected;
          },
          "selected": function (elem) {
            // Accessing this property makes selected-by-default
            // options in Safari work properly
            if (elem.parentNode) {
              // eslint-disable-next-line no-unused-expressions
              elem.parentNode.selectedIndex;
            }

            return elem.selected === true;
          },
          // Contents
          "empty": function (elem) {
            // http://www.w3.org/TR/selectors/#empty-pseudo
            // :empty is negated by element (1) or content nodes (text: 3; cdata: 4; entity ref: 5),
            //   but not by others (comment: 8; processing instruction: 7; etc.)
            // nodeType < 6 works because attributes (2) do not appear as children
            for (elem = elem.firstChild; elem; elem = elem.nextSibling) {
              if (elem.nodeType < 6) {
                return false;
              }
            }

            return true;
          },
          "parent": function (elem) {
            return !Expr.pseudos["empty"](elem);
          },
          // Element/input types
          "header": function (elem) {
            return rheader.test(elem.nodeName);
          },
          "input": function (elem) {
            return rinputs.test(elem.nodeName);
          },
          "button": function (elem) {
            var name = elem.nodeName.toLowerCase();
            return name === "input" && elem.type === "button" || name === "button";
          },
          "text": function (elem) {
            var attr;
            return elem.nodeName.toLowerCase() === "input" && elem.type === "text" && ( // Support: IE<8
            // New HTML5 attribute values (e.g., "search") appear with elem.type === "text"
            (attr = elem.getAttribute("type")) == null || attr.toLowerCase() === "text");
          },
          // Position-in-collection
          "first": createPositionalPseudo(function () {
            return [0];
          }),
          "last": createPositionalPseudo(function (_matchIndexes, length) {
            return [length - 1];
          }),
          "eq": createPositionalPseudo(function (_matchIndexes, length, argument) {
            return [argument < 0 ? argument + length : argument];
          }),
          "even": createPositionalPseudo(function (matchIndexes, length) {
            var i = 0;

            for (; i < length; i += 2) {
              matchIndexes.push(i);
            }

            return matchIndexes;
          }),
          "odd": createPositionalPseudo(function (matchIndexes, length) {
            var i = 1;

            for (; i < length; i += 2) {
              matchIndexes.push(i);
            }

            return matchIndexes;
          }),
          "lt": createPositionalPseudo(function (matchIndexes, length, argument) {
            var i = argument < 0 ? argument + length : argument > length ? length : argument;

            for (; --i >= 0;) {
              matchIndexes.push(i);
            }

            return matchIndexes;
          }),
          "gt": createPositionalPseudo(function (matchIndexes, length, argument) {
            var i = argument < 0 ? argument + length : argument;

            for (; ++i < length;) {
              matchIndexes.push(i);
            }

            return matchIndexes;
          })
        }
      };
      Expr.pseudos["nth"] = Expr.pseudos["eq"]; // Add button/input type pseudos

      for (i in {
        radio: true,
        checkbox: true,
        file: true,
        password: true,
        image: true
      }) {
        Expr.pseudos[i] = createInputPseudo(i);
      }

      for (i in {
        submit: true,
        reset: true
      }) {
        Expr.pseudos[i] = createButtonPseudo(i);
      } // Easy API for creating new setFilters


      function setFilters() {}

      setFilters.prototype = Expr.filters = Expr.pseudos;
      Expr.setFilters = new setFilters();

      tokenize = Sizzle.tokenize = function (selector, parseOnly) {
        var matched,
            match,
            tokens,
            type,
            soFar,
            groups,
            preFilters,
            cached = tokenCache[selector + " "];

        if (cached) {
          return parseOnly ? 0 : cached.slice(0);
        }

        soFar = selector;
        groups = [];
        preFilters = Expr.preFilter;

        while (soFar) {
          // Comma and first run
          if (!matched || (match = rcomma.exec(soFar))) {
            if (match) {
              // Don't consume trailing commas as valid
              soFar = soFar.slice(match[0].length) || soFar;
            }

            groups.push(tokens = []);
          }

          matched = false; // Combinators

          if (match = rcombinators.exec(soFar)) {
            matched = match.shift();
            tokens.push({
              value: matched,
              // Cast descendant combinators to space
              type: match[0].replace(rtrim, " ")
            });
            soFar = soFar.slice(matched.length);
          } // Filters


          for (type in Expr.filter) {
            if ((match = matchExpr[type].exec(soFar)) && (!preFilters[type] || (match = preFilters[type](match)))) {
              matched = match.shift();
              tokens.push({
                value: matched,
                type: type,
                matches: match
              });
              soFar = soFar.slice(matched.length);
            }
          }

          if (!matched) {
            break;
          }
        } // Return the length of the invalid excess
        // if we're just parsing
        // Otherwise, throw an error or return tokens


        return parseOnly ? soFar.length : soFar ? Sizzle.error(selector) : // Cache the tokens
        tokenCache(selector, groups).slice(0);
      };

      function toSelector(tokens) {
        var i = 0,
            len = tokens.length,
            selector = "";

        for (; i < len; i++) {
          selector += tokens[i].value;
        }

        return selector;
      }

      function addCombinator(matcher, combinator, base) {
        var dir = combinator.dir,
            skip = combinator.next,
            key = skip || dir,
            checkNonElements = base && key === "parentNode",
            doneName = done++;
        return combinator.first ? // Check against closest ancestor/preceding element
        function (elem, context, xml) {
          while (elem = elem[dir]) {
            if (elem.nodeType === 1 || checkNonElements) {
              return matcher(elem, context, xml);
            }
          }

          return false;
        } : // Check against all ancestor/preceding elements
        function (elem, context, xml) {
          var oldCache,
              uniqueCache,
              outerCache,
              newCache = [dirruns, doneName]; // We can't set arbitrary data on XML nodes, so they don't benefit from combinator caching

          if (xml) {
            while (elem = elem[dir]) {
              if (elem.nodeType === 1 || checkNonElements) {
                if (matcher(elem, context, xml)) {
                  return true;
                }
              }
            }
          } else {
            while (elem = elem[dir]) {
              if (elem.nodeType === 1 || checkNonElements) {
                outerCache = elem[expando] || (elem[expando] = {}); // Support: IE <9 only
                // Defend against cloned attroperties (jQuery gh-1709)

                uniqueCache = outerCache[elem.uniqueID] || (outerCache[elem.uniqueID] = {});

                if (skip && skip === elem.nodeName.toLowerCase()) {
                  elem = elem[dir] || elem;
                } else if ((oldCache = uniqueCache[key]) && oldCache[0] === dirruns && oldCache[1] === doneName) {
                  // Assign to newCache so results back-propagate to previous elements
                  return newCache[2] = oldCache[2];
                } else {
                  // Reuse newcache so results back-propagate to previous elements
                  uniqueCache[key] = newCache; // A match means we're done; a fail means we have to keep checking

                  if (newCache[2] = matcher(elem, context, xml)) {
                    return true;
                  }
                }
              }
            }
          }

          return false;
        };
      }

      function elementMatcher(matchers) {
        return matchers.length > 1 ? function (elem, context, xml) {
          var i = matchers.length;

          while (i--) {
            if (!matchers[i](elem, context, xml)) {
              return false;
            }
          }

          return true;
        } : matchers[0];
      }

      function multipleContexts(selector, contexts, results) {
        var i = 0,
            len = contexts.length;

        for (; i < len; i++) {
          Sizzle(selector, contexts[i], results);
        }

        return results;
      }

      function condense(unmatched, map, filter, context, xml) {
        var elem,
            newUnmatched = [],
            i = 0,
            len = unmatched.length,
            mapped = map != null;

        for (; i < len; i++) {
          if (elem = unmatched[i]) {
            if (!filter || filter(elem, context, xml)) {
              newUnmatched.push(elem);

              if (mapped) {
                map.push(i);
              }
            }
          }
        }

        return newUnmatched;
      }

      function setMatcher(preFilter, selector, matcher, postFilter, postFinder, postSelector) {
        if (postFilter && !postFilter[expando]) {
          postFilter = setMatcher(postFilter);
        }

        if (postFinder && !postFinder[expando]) {
          postFinder = setMatcher(postFinder, postSelector);
        }

        return markFunction(function (seed, results, context, xml) {
          var temp,
              i,
              elem,
              preMap = [],
              postMap = [],
              preexisting = results.length,
              // Get initial elements from seed or context
          elems = seed || multipleContexts(selector || "*", context.nodeType ? [context] : context, []),
              // Prefilter to get matcher input, preserving a map for seed-results synchronization
          matcherIn = preFilter && (seed || !selector) ? condense(elems, preMap, preFilter, context, xml) : elems,
              matcherOut = matcher ? // If we have a postFinder, or filtered seed, or non-seed postFilter or preexisting results,
          postFinder || (seed ? preFilter : preexisting || postFilter) ? // ...intermediate processing is necessary
          [] : // ...otherwise use results directly
          results : matcherIn; // Find primary matches

          if (matcher) {
            matcher(matcherIn, matcherOut, context, xml);
          } // Apply postFilter


          if (postFilter) {
            temp = condense(matcherOut, postMap);
            postFilter(temp, [], context, xml); // Un-match failing elements by moving them back to matcherIn

            i = temp.length;

            while (i--) {
              if (elem = temp[i]) {
                matcherOut[postMap[i]] = !(matcherIn[postMap[i]] = elem);
              }
            }
          }

          if (seed) {
            if (postFinder || preFilter) {
              if (postFinder) {
                // Get the final matcherOut by condensing this intermediate into postFinder contexts
                temp = [];
                i = matcherOut.length;

                while (i--) {
                  if (elem = matcherOut[i]) {
                    // Restore matcherIn since elem is not yet a final match
                    temp.push(matcherIn[i] = elem);
                  }
                }

                postFinder(null, matcherOut = [], temp, xml);
              } // Move matched elements from seed to results to keep them synchronized


              i = matcherOut.length;

              while (i--) {
                if ((elem = matcherOut[i]) && (temp = postFinder ? indexOf(seed, elem) : preMap[i]) > -1) {
                  seed[temp] = !(results[temp] = elem);
                }
              }
            } // Add elements to results, through postFinder if defined

          } else {
            matcherOut = condense(matcherOut === results ? matcherOut.splice(preexisting, matcherOut.length) : matcherOut);

            if (postFinder) {
              postFinder(null, results, matcherOut, xml);
            } else {
              push.apply(results, matcherOut);
            }
          }
        });
      }

      function matcherFromTokens(tokens) {
        var checkContext,
            matcher,
            j,
            len = tokens.length,
            leadingRelative = Expr.relative[tokens[0].type],
            implicitRelative = leadingRelative || Expr.relative[" "],
            i = leadingRelative ? 1 : 0,
            // The foundational matcher ensures that elements are reachable from top-level context(s)
        matchContext = addCombinator(function (elem) {
          return elem === checkContext;
        }, implicitRelative, true),
            matchAnyContext = addCombinator(function (elem) {
          return indexOf(checkContext, elem) > -1;
        }, implicitRelative, true),
            matchers = [function (elem, context, xml) {
          var ret = !leadingRelative && (xml || context !== outermostContext) || ((checkContext = context).nodeType ? matchContext(elem, context, xml) : matchAnyContext(elem, context, xml)); // Avoid hanging onto element (issue #299)

          checkContext = null;
          return ret;
        }];

        for (; i < len; i++) {
          if (matcher = Expr.relative[tokens[i].type]) {
            matchers = [addCombinator(elementMatcher(matchers), matcher)];
          } else {
            matcher = Expr.filter[tokens[i].type].apply(null, tokens[i].matches); // Return special upon seeing a positional matcher

            if (matcher[expando]) {
              // Find the next relative operator (if any) for proper handling
              j = ++i;

              for (; j < len; j++) {
                if (Expr.relative[tokens[j].type]) {
                  break;
                }
              }

              return setMatcher(i > 1 && elementMatcher(matchers), i > 1 && toSelector( // If the preceding token was a descendant combinator, insert an implicit any-element `*`
              tokens.slice(0, i - 1).concat({
                value: tokens[i - 2].type === " " ? "*" : ""
              })).replace(rtrim, "$1"), matcher, i < j && matcherFromTokens(tokens.slice(i, j)), j < len && matcherFromTokens(tokens = tokens.slice(j)), j < len && toSelector(tokens));
            }

            matchers.push(matcher);
          }
        }

        return elementMatcher(matchers);
      }

      function matcherFromGroupMatchers(elementMatchers, setMatchers) {
        var bySet = setMatchers.length > 0,
            byElement = elementMatchers.length > 0,
            superMatcher = function (seed, context, xml, results, outermost) {
          var elem,
              j,
              matcher,
              matchedCount = 0,
              i = "0",
              unmatched = seed && [],
              setMatched = [],
              contextBackup = outermostContext,
              // We must always have either seed elements or outermost context
          elems = seed || byElement && Expr.find["TAG"]("*", outermost),
              // Use integer dirruns iff this is the outermost matcher
          dirrunsUnique = dirruns += contextBackup == null ? 1 : Math.random() || 0.1,
              len = elems.length;

          if (outermost) {
            // Support: IE 11+, Edge 17 - 18+
            // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
            // two documents; shallow comparisons work.
            // eslint-disable-next-line eqeqeq
            outermostContext = context == document || context || outermost;
          } // Add elements passing elementMatchers directly to results
          // Support: IE<9, Safari
          // Tolerate NodeList properties (IE: "length"; Safari: <number>) matching elements by id


          for (; i !== len && (elem = elems[i]) != null; i++) {
            if (byElement && elem) {
              j = 0; // Support: IE 11+, Edge 17 - 18+
              // IE/Edge sometimes throw a "Permission denied" error when strict-comparing
              // two documents; shallow comparisons work.
              // eslint-disable-next-line eqeqeq

              if (!context && elem.ownerDocument != document) {
                setDocument(elem);
                xml = !documentIsHTML;
              }

              while (matcher = elementMatchers[j++]) {
                if (matcher(elem, context || document, xml)) {
                  results.push(elem);
                  break;
                }
              }

              if (outermost) {
                dirruns = dirrunsUnique;
              }
            } // Track unmatched elements for set filters


            if (bySet) {
              // They will have gone through all possible matchers
              if (elem = !matcher && elem) {
                matchedCount--;
              } // Lengthen the array for every element, matched or not


              if (seed) {
                unmatched.push(elem);
              }
            }
          } // `i` is now the count of elements visited above, and adding it to `matchedCount`
          // makes the latter nonnegative.


          matchedCount += i; // Apply set filters to unmatched elements
          // NOTE: This can be skipped if there are no unmatched elements (i.e., `matchedCount`
          // equals `i`), unless we didn't visit _any_ elements in the above loop because we have
          // no element matchers and no seed.
          // Incrementing an initially-string "0" `i` allows `i` to remain a string only in that
          // case, which will result in a "00" `matchedCount` that differs from `i` but is also
          // numerically zero.

          if (bySet && i !== matchedCount) {
            j = 0;

            while (matcher = setMatchers[j++]) {
              matcher(unmatched, setMatched, context, xml);
            }

            if (seed) {
              // Reintegrate element matches to eliminate the need for sorting
              if (matchedCount > 0) {
                while (i--) {
                  if (!(unmatched[i] || setMatched[i])) {
                    setMatched[i] = pop.call(results);
                  }
                }
              } // Discard index placeholder values to get only actual matches


              setMatched = condense(setMatched);
            } // Add matches to results


            push.apply(results, setMatched); // Seedless set matches succeeding multiple successful matchers stipulate sorting

            if (outermost && !seed && setMatched.length > 0 && matchedCount + setMatchers.length > 1) {
              Sizzle.uniqueSort(results);
            }
          } // Override manipulation of globals by nested matchers


          if (outermost) {
            dirruns = dirrunsUnique;
            outermostContext = contextBackup;
          }

          return unmatched;
        };

        return bySet ? markFunction(superMatcher) : superMatcher;
      }

      compile = Sizzle.compile = function (selector, match
      /* Internal Use Only */
      ) {
        var i,
            setMatchers = [],
            elementMatchers = [],
            cached = compilerCache[selector + " "];

        if (!cached) {
          // Generate a function of recursive functions that can be used to check each element
          if (!match) {
            match = tokenize(selector);
          }

          i = match.length;

          while (i--) {
            cached = matcherFromTokens(match[i]);

            if (cached[expando]) {
              setMatchers.push(cached);
            } else {
              elementMatchers.push(cached);
            }
          } // Cache the compiled function


          cached = compilerCache(selector, matcherFromGroupMatchers(elementMatchers, setMatchers)); // Save selector and tokenization

          cached.selector = selector;
        }

        return cached;
      };
      /**
       * A low-level selection function that works with Sizzle's compiled
       *  selector functions
       * @param {String|Function} selector A selector or a pre-compiled
       *  selector function built with Sizzle.compile
       * @param {Element} context
       * @param {Array} [results]
       * @param {Array} [seed] A set of elements to match against
       */


      select = Sizzle.select = function (selector, context, results, seed) {
        var i,
            tokens,
            token,
            type,
            find,
            compiled = typeof selector === "function" && selector,
            match = !seed && tokenize(selector = compiled.selector || selector);
        results = results || []; // Try to minimize operations if there is only one selector in the list and no seed
        // (the latter of which guarantees us context)

        if (match.length === 1) {
          // Reduce context if the leading compound selector is an ID
          tokens = match[0] = match[0].slice(0);

          if (tokens.length > 2 && (token = tokens[0]).type === "ID" && context.nodeType === 9 && documentIsHTML && Expr.relative[tokens[1].type]) {
            context = (Expr.find["ID"](token.matches[0].replace(runescape, funescape), context) || [])[0];

            if (!context) {
              return results; // Precompiled matchers will still verify ancestry, so step up a level
            } else if (compiled) {
              context = context.parentNode;
            }

            selector = selector.slice(tokens.shift().value.length);
          } // Fetch a seed set for right-to-left matching


          i = matchExpr["needsContext"].test(selector) ? 0 : tokens.length;

          while (i--) {
            token = tokens[i]; // Abort if we hit a combinator

            if (Expr.relative[type = token.type]) {
              break;
            }

            if (find = Expr.find[type]) {
              // Search, expanding context for leading sibling combinators
              if (seed = find(token.matches[0].replace(runescape, funescape), rsibling.test(tokens[0].type) && testContext(context.parentNode) || context)) {
                // If seed is empty or no tokens remain, we can return early
                tokens.splice(i, 1);
                selector = seed.length && toSelector(tokens);

                if (!selector) {
                  push.apply(results, seed);
                  return results;
                }

                break;
              }
            }
          }
        } // Compile and execute a filtering function if one is not provided
        // Provide `match` to avoid retokenization if we modified the selector above


        (compiled || compile(selector, match))(seed, context, !documentIsHTML, results, !context || rsibling.test(selector) && testContext(context.parentNode) || context);
        return results;
      }; // One-time assignments
      // Sort stability


      support.sortStable = expando.split("").sort(sortOrder).join("") === expando; // Support: Chrome 14-35+
      // Always assume duplicates if they aren't passed to the comparison function

      support.detectDuplicates = !!hasDuplicate; // Initialize against the default document

      setDocument(); // Support: Webkit<537.32 - Safari 6.0.3/Chrome 25 (fixed in Chrome 27)
      // Detached nodes confoundingly follow *each other*

      support.sortDetached = assert(function (el) {
        // Should return 1, but returns 4 (following)
        return el.compareDocumentPosition(document.createElement("fieldset")) & 1;
      }); // Support: IE<8
      // Prevent attribute/property "interpolation"
      // https://msdn.microsoft.com/en-us/library/ms536429%28VS.85%29.aspx

      if (!assert(function (el) {
        el.innerHTML = "<a href='#'></a>";
        return el.firstChild.getAttribute("href") === "#";
      })) {
        addHandle("type|href|height|width", function (elem, name, isXML) {
          if (!isXML) {
            return elem.getAttribute(name, name.toLowerCase() === "type" ? 1 : 2);
          }
        });
      } // Support: IE<9
      // Use defaultValue in place of getAttribute("value")


      if (!support.attributes || !assert(function (el) {
        el.innerHTML = "<input/>";
        el.firstChild.setAttribute("value", "");
        return el.firstChild.getAttribute("value") === "";
      })) {
        addHandle("value", function (elem, _name, isXML) {
          if (!isXML && elem.nodeName.toLowerCase() === "input") {
            return elem.defaultValue;
          }
        });
      } // Support: IE<9
      // Use getAttributeNode to fetch booleans when getAttribute lies


      if (!assert(function (el) {
        return el.getAttribute("disabled") == null;
      })) {
        addHandle(booleans, function (elem, name, isXML) {
          var val;

          if (!isXML) {
            return elem[name] === true ? name.toLowerCase() : (val = elem.getAttributeNode(name)) && val.specified ? val.value : null;
          }
        });
      }

      return Sizzle;
    }(window);

    jQuery.find = Sizzle;
    jQuery.expr = Sizzle.selectors; // Deprecated

    jQuery.expr[":"] = jQuery.expr.pseudos;
    jQuery.uniqueSort = jQuery.unique = Sizzle.uniqueSort;
    jQuery.text = Sizzle.getText;
    jQuery.isXMLDoc = Sizzle.isXML;
    jQuery.contains = Sizzle.contains;
    jQuery.escapeSelector = Sizzle.escape;

    var dir = function (elem, dir, until) {
      var matched = [],
          truncate = until !== undefined;

      while ((elem = elem[dir]) && elem.nodeType !== 9) {
        if (elem.nodeType === 1) {
          if (truncate && jQuery(elem).is(until)) {
            break;
          }

          matched.push(elem);
        }
      }

      return matched;
    };

    var siblings = function (n, elem) {
      var matched = [];

      for (; n; n = n.nextSibling) {
        if (n.nodeType === 1 && n !== elem) {
          matched.push(n);
        }
      }

      return matched;
    };

    var rneedsContext = jQuery.expr.match.needsContext;

    function nodeName(elem, name) {
      return elem.nodeName && elem.nodeName.toLowerCase() === name.toLowerCase();
    }

    var rsingleTag = /^<([a-z][^\/\0>:\x20\t\r\n\f]*)[\x20\t\r\n\f]*\/?>(?:<\/\1>|)$/i; // Implement the identical functionality for filter and not

    function winnow(elements, qualifier, not) {
      if (isFunction(qualifier)) {
        return jQuery.grep(elements, function (elem, i) {
          return !!qualifier.call(elem, i, elem) !== not;
        });
      } // Single element


      if (qualifier.nodeType) {
        return jQuery.grep(elements, function (elem) {
          return elem === qualifier !== not;
        });
      } // Arraylike of elements (jQuery, arguments, Array)


      if (typeof qualifier !== "string") {
        return jQuery.grep(elements, function (elem) {
          return indexOf.call(qualifier, elem) > -1 !== not;
        });
      } // Filtered directly for both simple and complex selectors


      return jQuery.filter(qualifier, elements, not);
    }

    jQuery.filter = function (expr, elems, not) {
      var elem = elems[0];

      if (not) {
        expr = ":not(" + expr + ")";
      }

      if (elems.length === 1 && elem.nodeType === 1) {
        return jQuery.find.matchesSelector(elem, expr) ? [elem] : [];
      }

      return jQuery.find.matches(expr, jQuery.grep(elems, function (elem) {
        return elem.nodeType === 1;
      }));
    };

    jQuery.fn.extend({
      find: function (selector) {
        var i,
            ret,
            len = this.length,
            self = this;

        if (typeof selector !== "string") {
          return this.pushStack(jQuery(selector).filter(function () {
            for (i = 0; i < len; i++) {
              if (jQuery.contains(self[i], this)) {
                return true;
              }
            }
          }));
        }

        ret = this.pushStack([]);

        for (i = 0; i < len; i++) {
          jQuery.find(selector, self[i], ret);
        }

        return len > 1 ? jQuery.uniqueSort(ret) : ret;
      },
      filter: function (selector) {
        return this.pushStack(winnow(this, selector || [], false));
      },
      not: function (selector) {
        return this.pushStack(winnow(this, selector || [], true));
      },
      is: function (selector) {
        return !!winnow(this, // If this is a positional/relative selector, check membership in the returned set
        // so $("p:first").is("p:last") won't return true for a doc with two "p".
        typeof selector === "string" && rneedsContext.test(selector) ? jQuery(selector) : selector || [], false).length;
      }
    }); // Initialize a jQuery object
    // A central reference to the root jQuery(document)

    var rootjQuery,
        // A simple way to check for HTML strings
    // Prioritize #id over <tag> to avoid XSS via location.hash (#9521)
    // Strict HTML recognition (#11290: must start with <)
    // Shortcut simple #id case for speed
    rquickExpr = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]+))$/,
        init = jQuery.fn.init = function (selector, context, root) {
      var match, elem; // HANDLE: $(""), $(null), $(undefined), $(false)

      if (!selector) {
        return this;
      } // Method init() accepts an alternate rootjQuery
      // so migrate can support jQuery.sub (gh-2101)


      root = root || rootjQuery; // Handle HTML strings

      if (typeof selector === "string") {
        if (selector[0] === "<" && selector[selector.length - 1] === ">" && selector.length >= 3) {
          // Assume that strings that start and end with <> are HTML and skip the regex check
          match = [null, selector, null];
        } else {
          match = rquickExpr.exec(selector);
        } // Match html or make sure no context is specified for #id


        if (match && (match[1] || !context)) {
          // HANDLE: $(html) -> $(array)
          if (match[1]) {
            context = context instanceof jQuery ? context[0] : context; // Option to run scripts is true for back-compat
            // Intentionally let the error be thrown if parseHTML is not present

            jQuery.merge(this, jQuery.parseHTML(match[1], context && context.nodeType ? context.ownerDocument || context : document, true)); // HANDLE: $(html, props)

            if (rsingleTag.test(match[1]) && jQuery.isPlainObject(context)) {
              for (match in context) {
                // Properties of context are called as methods if possible
                if (isFunction(this[match])) {
                  this[match](context[match]); // ...and otherwise set as attributes
                } else {
                  this.attr(match, context[match]);
                }
              }
            }

            return this; // HANDLE: $(#id)
          } else {
            elem = document.getElementById(match[2]);

            if (elem) {
              // Inject the element directly into the jQuery object
              this[0] = elem;
              this.length = 1;
            }

            return this;
          } // HANDLE: $(expr, $(...))

        } else if (!context || context.jquery) {
          return (context || root).find(selector); // HANDLE: $(expr, context)
          // (which is just equivalent to: $(context).find(expr)
        } else {
          return this.constructor(context).find(selector);
        } // HANDLE: $(DOMElement)

      } else if (selector.nodeType) {
        this[0] = selector;
        this.length = 1;
        return this; // HANDLE: $(function)
        // Shortcut for document ready
      } else if (isFunction(selector)) {
        return root.ready !== undefined ? root.ready(selector) : // Execute immediately if ready is not present
        selector(jQuery);
      }

      return jQuery.makeArray(selector, this);
    }; // Give the init function the jQuery prototype for later instantiation


    init.prototype = jQuery.fn; // Initialize central reference

    rootjQuery = jQuery(document);
    var rparentsprev = /^(?:parents|prev(?:Until|All))/,
        // Methods guaranteed to produce a unique set when starting from a unique set
    guaranteedUnique = {
      children: true,
      contents: true,
      next: true,
      prev: true
    };
    jQuery.fn.extend({
      has: function (target) {
        var targets = jQuery(target, this),
            l = targets.length;
        return this.filter(function () {
          var i = 0;

          for (; i < l; i++) {
            if (jQuery.contains(this, targets[i])) {
              return true;
            }
          }
        });
      },
      closest: function (selectors, context) {
        var cur,
            i = 0,
            l = this.length,
            matched = [],
            targets = typeof selectors !== "string" && jQuery(selectors); // Positional selectors never match, since there's no _selection_ context

        if (!rneedsContext.test(selectors)) {
          for (; i < l; i++) {
            for (cur = this[i]; cur && cur !== context; cur = cur.parentNode) {
              // Always skip document fragments
              if (cur.nodeType < 11 && (targets ? targets.index(cur) > -1 : // Don't pass non-elements to Sizzle
              cur.nodeType === 1 && jQuery.find.matchesSelector(cur, selectors))) {
                matched.push(cur);
                break;
              }
            }
          }
        }

        return this.pushStack(matched.length > 1 ? jQuery.uniqueSort(matched) : matched);
      },
      // Determine the position of an element within the set
      index: function (elem) {
        // No argument, return index in parent
        if (!elem) {
          return this[0] && this[0].parentNode ? this.first().prevAll().length : -1;
        } // Index in selector


        if (typeof elem === "string") {
          return indexOf.call(jQuery(elem), this[0]);
        } // Locate the position of the desired element


        return indexOf.call(this, // If it receives a jQuery object, the first element is used
        elem.jquery ? elem[0] : elem);
      },
      add: function (selector, context) {
        return this.pushStack(jQuery.uniqueSort(jQuery.merge(this.get(), jQuery(selector, context))));
      },
      addBack: function (selector) {
        return this.add(selector == null ? this.prevObject : this.prevObject.filter(selector));
      }
    });

    function sibling(cur, dir) {
      while ((cur = cur[dir]) && cur.nodeType !== 1) {}

      return cur;
    }

    jQuery.each({
      parent: function (elem) {
        var parent = elem.parentNode;
        return parent && parent.nodeType !== 11 ? parent : null;
      },
      parents: function (elem) {
        return dir(elem, "parentNode");
      },
      parentsUntil: function (elem, _i, until) {
        return dir(elem, "parentNode", until);
      },
      next: function (elem) {
        return sibling(elem, "nextSibling");
      },
      prev: function (elem) {
        return sibling(elem, "previousSibling");
      },
      nextAll: function (elem) {
        return dir(elem, "nextSibling");
      },
      prevAll: function (elem) {
        return dir(elem, "previousSibling");
      },
      nextUntil: function (elem, _i, until) {
        return dir(elem, "nextSibling", until);
      },
      prevUntil: function (elem, _i, until) {
        return dir(elem, "previousSibling", until);
      },
      siblings: function (elem) {
        return siblings((elem.parentNode || {}).firstChild, elem);
      },
      children: function (elem) {
        return siblings(elem.firstChild);
      },
      contents: function (elem) {
        if (elem.contentDocument != null && // Support: IE 11+
        // <object> elements with no `data` attribute has an object
        // `contentDocument` with a `null` prototype.
        getProto(elem.contentDocument)) {
          return elem.contentDocument;
        } // Support: IE 9 - 11 only, iOS 7 only, Android Browser <=4.3 only
        // Treat the template element as a regular one in browsers that
        // don't support it.


        if (nodeName(elem, "template")) {
          elem = elem.content || elem;
        }

        return jQuery.merge([], elem.childNodes);
      }
    }, function (name, fn) {
      jQuery.fn[name] = function (until, selector) {
        var matched = jQuery.map(this, fn, until);

        if (name.slice(-5) !== "Until") {
          selector = until;
        }

        if (selector && typeof selector === "string") {
          matched = jQuery.filter(selector, matched);
        }

        if (this.length > 1) {
          // Remove duplicates
          if (!guaranteedUnique[name]) {
            jQuery.uniqueSort(matched);
          } // Reverse order for parents* and prev-derivatives


          if (rparentsprev.test(name)) {
            matched.reverse();
          }
        }

        return this.pushStack(matched);
      };
    });
    var rnothtmlwhite = /[^\x20\t\r\n\f]+/g; // Convert String-formatted options into Object-formatted ones

    function createOptions(options) {
      var object = {};
      jQuery.each(options.match(rnothtmlwhite) || [], function (_, flag) {
        object[flag] = true;
      });
      return object;
    }
    /*
     * Create a callback list using the following parameters:
     *
     *	options: an optional list of space-separated options that will change how
     *			the callback list behaves or a more traditional option object
     *
     * By default a callback list will act like an event callback list and can be
     * "fired" multiple times.
     *
     * Possible options:
     *
     *	once:			will ensure the callback list can only be fired once (like a Deferred)
     *
     *	memory:			will keep track of previous values and will call any callback added
     *					after the list has been fired right away with the latest "memorized"
     *					values (like a Deferred)
     *
     *	unique:			will ensure a callback can only be added once (no duplicate in the list)
     *
     *	stopOnFalse:	interrupt callings when a callback returns false
     *
     */


    jQuery.Callbacks = function (options) {
      // Convert options from String-formatted to Object-formatted if needed
      // (we check in cache first)
      options = typeof options === "string" ? createOptions(options) : jQuery.extend({}, options);

      var // Flag to know if list is currently firing
      firing,
          // Last fire value for non-forgettable lists
      memory,
          // Flag to know if list was already fired
      fired,
          // Flag to prevent firing
      locked,
          // Actual callback list
      list = [],
          // Queue of execution data for repeatable lists
      queue = [],
          // Index of currently firing callback (modified by add/remove as needed)
      firingIndex = -1,
          // Fire callbacks
      fire = function () {
        // Enforce single-firing
        locked = locked || options.once; // Execute callbacks for all pending executions,
        // respecting firingIndex overrides and runtime changes

        fired = firing = true;

        for (; queue.length; firingIndex = -1) {
          memory = queue.shift();

          while (++firingIndex < list.length) {
            // Run callback and check for early termination
            if (list[firingIndex].apply(memory[0], memory[1]) === false && options.stopOnFalse) {
              // Jump to end and forget the data so .add doesn't re-fire
              firingIndex = list.length;
              memory = false;
            }
          }
        } // Forget the data if we're done with it


        if (!options.memory) {
          memory = false;
        }

        firing = false; // Clean up if we're done firing for good

        if (locked) {
          // Keep an empty list if we have data for future add calls
          if (memory) {
            list = []; // Otherwise, this object is spent
          } else {
            list = "";
          }
        }
      },
          // Actual Callbacks object
      self = {
        // Add a callback or a collection of callbacks to the list
        add: function () {
          if (list) {
            // If we have memory from a past run, we should fire after adding
            if (memory && !firing) {
              firingIndex = list.length - 1;
              queue.push(memory);
            }

            (function add(args) {
              jQuery.each(args, function (_, arg) {
                if (isFunction(arg)) {
                  if (!options.unique || !self.has(arg)) {
                    list.push(arg);
                  }
                } else if (arg && arg.length && toType(arg) !== "string") {
                  // Inspect recursively
                  add(arg);
                }
              });
            })(arguments);

            if (memory && !firing) {
              fire();
            }
          }

          return this;
        },
        // Remove a callback from the list
        remove: function () {
          jQuery.each(arguments, function (_, arg) {
            var index;

            while ((index = jQuery.inArray(arg, list, index)) > -1) {
              list.splice(index, 1); // Handle firing indexes

              if (index <= firingIndex) {
                firingIndex--;
              }
            }
          });
          return this;
        },
        // Check if a given callback is in the list.
        // If no argument is given, return whether or not list has callbacks attached.
        has: function (fn) {
          return fn ? jQuery.inArray(fn, list) > -1 : list.length > 0;
        },
        // Remove all callbacks from the list
        empty: function () {
          if (list) {
            list = [];
          }

          return this;
        },
        // Disable .fire and .add
        // Abort any current/pending executions
        // Clear all callbacks and values
        disable: function () {
          locked = queue = [];
          list = memory = "";
          return this;
        },
        disabled: function () {
          return !list;
        },
        // Disable .fire
        // Also disable .add unless we have memory (since it would have no effect)
        // Abort any pending executions
        lock: function () {
          locked = queue = [];

          if (!memory && !firing) {
            list = memory = "";
          }

          return this;
        },
        locked: function () {
          return !!locked;
        },
        // Call all callbacks with the given context and arguments
        fireWith: function (context, args) {
          if (!locked) {
            args = args || [];
            args = [context, args.slice ? args.slice() : args];
            queue.push(args);

            if (!firing) {
              fire();
            }
          }

          return this;
        },
        // Call all the callbacks with the given arguments
        fire: function () {
          self.fireWith(this, arguments);
          return this;
        },
        // To know if the callbacks have already been called at least once
        fired: function () {
          return !!fired;
        }
      };

      return self;
    };

    function Identity(v) {
      return v;
    }

    function Thrower(ex) {
      throw ex;
    }

    function adoptValue(value, resolve, reject, noValue) {
      var method;

      try {
        // Check for promise aspect first to privilege synchronous behavior
        if (value && isFunction(method = value.promise)) {
          method.call(value).done(resolve).fail(reject); // Other thenables
        } else if (value && isFunction(method = value.then)) {
          method.call(value, resolve, reject); // Other non-thenables
        } else {
          // Control `resolve` arguments by letting Array#slice cast boolean `noValue` to integer:
          // * false: [ value ].slice( 0 ) => resolve( value )
          // * true: [ value ].slice( 1 ) => resolve()
          resolve.apply(undefined, [value].slice(noValue));
        } // For Promises/A+, convert exceptions into rejections
        // Since jQuery.when doesn't unwrap thenables, we can skip the extra checks appearing in
        // Deferred#then to conditionally suppress rejection.

      } catch (value) {
        // Support: Android 4.0 only
        // Strict mode functions invoked without .call/.apply get global-object context
        reject.apply(undefined, [value]);
      }
    }

    jQuery.extend({
      Deferred: function (func) {
        var tuples = [// action, add listener, callbacks,
        // ... .then handlers, argument index, [final state]
        ["notify", "progress", jQuery.Callbacks("memory"), jQuery.Callbacks("memory"), 2], ["resolve", "done", jQuery.Callbacks("once memory"), jQuery.Callbacks("once memory"), 0, "resolved"], ["reject", "fail", jQuery.Callbacks("once memory"), jQuery.Callbacks("once memory"), 1, "rejected"]],
            state = "pending",
            promise = {
          state: function () {
            return state;
          },
          always: function () {
            deferred.done(arguments).fail(arguments);
            return this;
          },
          "catch": function (fn) {
            return promise.then(null, fn);
          },
          // Keep pipe for back-compat
          pipe: function
            /* fnDone, fnFail, fnProgress */
          () {
            var fns = arguments;
            return jQuery.Deferred(function (newDefer) {
              jQuery.each(tuples, function (_i, tuple) {
                // Map tuples (progress, done, fail) to arguments (done, fail, progress)
                var fn = isFunction(fns[tuple[4]]) && fns[tuple[4]]; // deferred.progress(function() { bind to newDefer or newDefer.notify })
                // deferred.done(function() { bind to newDefer or newDefer.resolve })
                // deferred.fail(function() { bind to newDefer or newDefer.reject })

                deferred[tuple[1]](function () {
                  var returned = fn && fn.apply(this, arguments);

                  if (returned && isFunction(returned.promise)) {
                    returned.promise().progress(newDefer.notify).done(newDefer.resolve).fail(newDefer.reject);
                  } else {
                    newDefer[tuple[0] + "With"](this, fn ? [returned] : arguments);
                  }
                });
              });
              fns = null;
            }).promise();
          },
          then: function (onFulfilled, onRejected, onProgress) {
            var maxDepth = 0;

            function resolve(depth, deferred, handler, special) {
              return function () {
                var that = this,
                    args = arguments,
                    mightThrow = function () {
                  var returned, then; // Support: Promises/A+ section 2.3.3.3.3
                  // https://promisesaplus.com/#point-59
                  // Ignore double-resolution attempts

                  if (depth < maxDepth) {
                    return;
                  }

                  returned = handler.apply(that, args); // Support: Promises/A+ section 2.3.1
                  // https://promisesaplus.com/#point-48

                  if (returned === deferred.promise()) {
                    throw new TypeError("Thenable self-resolution");
                  } // Support: Promises/A+ sections 2.3.3.1, 3.5
                  // https://promisesaplus.com/#point-54
                  // https://promisesaplus.com/#point-75
                  // Retrieve `then` only once


                  then = returned && ( // Support: Promises/A+ section 2.3.4
                  // https://promisesaplus.com/#point-64
                  // Only check objects and functions for thenability
                  typeof returned === "object" || typeof returned === "function") && returned.then; // Handle a returned thenable

                  if (isFunction(then)) {
                    // Special processors (notify) just wait for resolution
                    if (special) {
                      then.call(returned, resolve(maxDepth, deferred, Identity, special), resolve(maxDepth, deferred, Thrower, special)); // Normal processors (resolve) also hook into progress
                    } else {
                      // ...and disregard older resolution values
                      maxDepth++;
                      then.call(returned, resolve(maxDepth, deferred, Identity, special), resolve(maxDepth, deferred, Thrower, special), resolve(maxDepth, deferred, Identity, deferred.notifyWith));
                    } // Handle all other returned values

                  } else {
                    // Only substitute handlers pass on context
                    // and multiple values (non-spec behavior)
                    if (handler !== Identity) {
                      that = undefined;
                      args = [returned];
                    } // Process the value(s)
                    // Default process is resolve


                    (special || deferred.resolveWith)(that, args);
                  }
                },
                    // Only normal processors (resolve) catch and reject exceptions
                process = special ? mightThrow : function () {
                  try {
                    mightThrow();
                  } catch (e) {
                    if (jQuery.Deferred.exceptionHook) {
                      jQuery.Deferred.exceptionHook(e, process.stackTrace);
                    } // Support: Promises/A+ section 2.3.3.3.4.1
                    // https://promisesaplus.com/#point-61
                    // Ignore post-resolution exceptions


                    if (depth + 1 >= maxDepth) {
                      // Only substitute handlers pass on context
                      // and multiple values (non-spec behavior)
                      if (handler !== Thrower) {
                        that = undefined;
                        args = [e];
                      }

                      deferred.rejectWith(that, args);
                    }
                  }
                }; // Support: Promises/A+ section 2.3.3.3.1
                // https://promisesaplus.com/#point-57
                // Re-resolve promises immediately to dodge false rejection from
                // subsequent errors


                if (depth) {
                  process();
                } else {
                  // Call an optional hook to record the stack, in case of exception
                  // since it's otherwise lost when execution goes async
                  if (jQuery.Deferred.getStackHook) {
                    process.stackTrace = jQuery.Deferred.getStackHook();
                  }

                  window.setTimeout(process);
                }
              };
            }

            return jQuery.Deferred(function (newDefer) {
              // progress_handlers.add( ... )
              tuples[0][3].add(resolve(0, newDefer, isFunction(onProgress) ? onProgress : Identity, newDefer.notifyWith)); // fulfilled_handlers.add( ... )

              tuples[1][3].add(resolve(0, newDefer, isFunction(onFulfilled) ? onFulfilled : Identity)); // rejected_handlers.add( ... )

              tuples[2][3].add(resolve(0, newDefer, isFunction(onRejected) ? onRejected : Thrower));
            }).promise();
          },
          // Get a promise for this deferred
          // If obj is provided, the promise aspect is added to the object
          promise: function (obj) {
            return obj != null ? jQuery.extend(obj, promise) : promise;
          }
        },
            deferred = {}; // Add list-specific methods

        jQuery.each(tuples, function (i, tuple) {
          var list = tuple[2],
              stateString = tuple[5]; // promise.progress = list.add
          // promise.done = list.add
          // promise.fail = list.add

          promise[tuple[1]] = list.add; // Handle state

          if (stateString) {
            list.add(function () {
              // state = "resolved" (i.e., fulfilled)
              // state = "rejected"
              state = stateString;
            }, // rejected_callbacks.disable
            // fulfilled_callbacks.disable
            tuples[3 - i][2].disable, // rejected_handlers.disable
            // fulfilled_handlers.disable
            tuples[3 - i][3].disable, // progress_callbacks.lock
            tuples[0][2].lock, // progress_handlers.lock
            tuples[0][3].lock);
          } // progress_handlers.fire
          // fulfilled_handlers.fire
          // rejected_handlers.fire


          list.add(tuple[3].fire); // deferred.notify = function() { deferred.notifyWith(...) }
          // deferred.resolve = function() { deferred.resolveWith(...) }
          // deferred.reject = function() { deferred.rejectWith(...) }

          deferred[tuple[0]] = function () {
            deferred[tuple[0] + "With"](this === deferred ? undefined : this, arguments);
            return this;
          }; // deferred.notifyWith = list.fireWith
          // deferred.resolveWith = list.fireWith
          // deferred.rejectWith = list.fireWith


          deferred[tuple[0] + "With"] = list.fireWith;
        }); // Make the deferred a promise

        promise.promise(deferred); // Call given func if any

        if (func) {
          func.call(deferred, deferred);
        } // All done!


        return deferred;
      },
      // Deferred helper
      when: function (singleValue) {
        var // count of uncompleted subordinates
        remaining = arguments.length,
            // count of unprocessed arguments
        i = remaining,
            // subordinate fulfillment data
        resolveContexts = Array(i),
            resolveValues = slice.call(arguments),
            // the primary Deferred
        primary = jQuery.Deferred(),
            // subordinate callback factory
        updateFunc = function (i) {
          return function (value) {
            resolveContexts[i] = this;
            resolveValues[i] = arguments.length > 1 ? slice.call(arguments) : value;

            if (! --remaining) {
              primary.resolveWith(resolveContexts, resolveValues);
            }
          };
        }; // Single- and empty arguments are adopted like Promise.resolve


        if (remaining <= 1) {
          adoptValue(singleValue, primary.done(updateFunc(i)).resolve, primary.reject, !remaining); // Use .then() to unwrap secondary thenables (cf. gh-3000)

          if (primary.state() === "pending" || isFunction(resolveValues[i] && resolveValues[i].then)) {
            return primary.then();
          }
        } // Multiple arguments are aggregated like Promise.all array elements


        while (i--) {
          adoptValue(resolveValues[i], updateFunc(i), primary.reject);
        }

        return primary.promise();
      }
    }); // These usually indicate a programmer mistake during development,
    // warn about them ASAP rather than swallowing them by default.

    var rerrorNames = /^(Eval|Internal|Range|Reference|Syntax|Type|URI)Error$/;

    jQuery.Deferred.exceptionHook = function (error, stack) {
      // Support: IE 8 - 9 only
      // Console exists when dev tools are open, which can happen at any time
      if (window.console && window.console.warn && error && rerrorNames.test(error.name)) {
        window.console.warn("jQuery.Deferred exception: " + error.message, error.stack, stack);
      }
    };

    jQuery.readyException = function (error) {
      window.setTimeout(function () {
        throw error;
      });
    }; // The deferred used on DOM ready


    var readyList = jQuery.Deferred();

    jQuery.fn.ready = function (fn) {
      readyList.then(fn) // Wrap jQuery.readyException in a function so that the lookup
      // happens at the time of error handling instead of callback
      // registration.
      .catch(function (error) {
        jQuery.readyException(error);
      });
      return this;
    };

    jQuery.extend({
      // Is the DOM ready to be used? Set to true once it occurs.
      isReady: false,
      // A counter to track how many items to wait for before
      // the ready event fires. See #6781
      readyWait: 1,
      // Handle when the DOM is ready
      ready: function (wait) {
        // Abort if there are pending holds or we're already ready
        if (wait === true ? --jQuery.readyWait : jQuery.isReady) {
          return;
        } // Remember that the DOM is ready


        jQuery.isReady = true; // If a normal DOM Ready event fired, decrement, and wait if need be

        if (wait !== true && --jQuery.readyWait > 0) {
          return;
        } // If there are functions bound, to execute


        readyList.resolveWith(document, [jQuery]);
      }
    });
    jQuery.ready.then = readyList.then; // The ready event handler and self cleanup method

    function completed() {
      document.removeEventListener("DOMContentLoaded", completed);
      window.removeEventListener("load", completed);
      jQuery.ready();
    } // Catch cases where $(document).ready() is called
    // after the browser event has already occurred.
    // Support: IE <=9 - 10 only
    // Older IE sometimes signals "interactive" too soon


    if (document.readyState === "complete" || document.readyState !== "loading" && !document.documentElement.doScroll) {
      // Handle it asynchronously to allow scripts the opportunity to delay ready
      window.setTimeout(jQuery.ready);
    } else {
      // Use the handy event callback
      document.addEventListener("DOMContentLoaded", completed); // A fallback to window.onload, that will always work

      window.addEventListener("load", completed);
    } // Multifunctional method to get and set values of a collection
    // The value/s can optionally be executed if it's a function


    var access = function (elems, fn, key, value, chainable, emptyGet, raw) {
      var i = 0,
          len = elems.length,
          bulk = key == null; // Sets many values

      if (toType(key) === "object") {
        chainable = true;

        for (i in key) {
          access(elems, fn, i, key[i], true, emptyGet, raw);
        } // Sets one value

      } else if (value !== undefined) {
        chainable = true;

        if (!isFunction(value)) {
          raw = true;
        }

        if (bulk) {
          // Bulk operations run against the entire set
          if (raw) {
            fn.call(elems, value);
            fn = null; // ...except when executing function values
          } else {
            bulk = fn;

            fn = function (elem, _key, value) {
              return bulk.call(jQuery(elem), value);
            };
          }
        }

        if (fn) {
          for (; i < len; i++) {
            fn(elems[i], key, raw ? value : value.call(elems[i], i, fn(elems[i], key)));
          }
        }
      }

      if (chainable) {
        return elems;
      } // Gets


      if (bulk) {
        return fn.call(elems);
      }

      return len ? fn(elems[0], key) : emptyGet;
    }; // Matches dashed string for camelizing


    var rmsPrefix = /^-ms-/,
        rdashAlpha = /-([a-z])/g; // Used by camelCase as callback to replace()

    function fcamelCase(_all, letter) {
      return letter.toUpperCase();
    } // Convert dashed to camelCase; used by the css and data modules
    // Support: IE <=9 - 11, Edge 12 - 15
    // Microsoft forgot to hump their vendor prefix (#9572)


    function camelCase(string) {
      return string.replace(rmsPrefix, "ms-").replace(rdashAlpha, fcamelCase);
    }

    var acceptData = function (owner) {
      // Accepts only:
      //  - Node
      //    - Node.ELEMENT_NODE
      //    - Node.DOCUMENT_NODE
      //  - Object
      //    - Any
      return owner.nodeType === 1 || owner.nodeType === 9 || !+owner.nodeType;
    };

    function Data() {
      this.expando = jQuery.expando + Data.uid++;
    }

    Data.uid = 1;
    Data.prototype = {
      cache: function (owner) {
        // Check if the owner object already has a cache
        var value = owner[this.expando]; // If not, create one

        if (!value) {
          value = {}; // We can accept data for non-element nodes in modern browsers,
          // but we should not, see #8335.
          // Always return an empty object.

          if (acceptData(owner)) {
            // If it is a node unlikely to be stringify-ed or looped over
            // use plain assignment
            if (owner.nodeType) {
              owner[this.expando] = value; // Otherwise secure it in a non-enumerable property
              // configurable must be true to allow the property to be
              // deleted when data is removed
            } else {
              Object.defineProperty(owner, this.expando, {
                value: value,
                configurable: true
              });
            }
          }
        }

        return value;
      },
      set: function (owner, data, value) {
        var prop,
            cache = this.cache(owner); // Handle: [ owner, key, value ] args
        // Always use camelCase key (gh-2257)

        if (typeof data === "string") {
          cache[camelCase(data)] = value; // Handle: [ owner, { properties } ] args
        } else {
          // Copy the properties one-by-one to the cache object
          for (prop in data) {
            cache[camelCase(prop)] = data[prop];
          }
        }

        return cache;
      },
      get: function (owner, key) {
        return key === undefined ? this.cache(owner) : // Always use camelCase key (gh-2257)
        owner[this.expando] && owner[this.expando][camelCase(key)];
      },
      access: function (owner, key, value) {
        // In cases where either:
        //
        //   1. No key was specified
        //   2. A string key was specified, but no value provided
        //
        // Take the "read" path and allow the get method to determine
        // which value to return, respectively either:
        //
        //   1. The entire cache object
        //   2. The data stored at the key
        //
        if (key === undefined || key && typeof key === "string" && value === undefined) {
          return this.get(owner, key);
        } // When the key is not a string, or both a key and value
        // are specified, set or extend (existing objects) with either:
        //
        //   1. An object of properties
        //   2. A key and value
        //


        this.set(owner, key, value); // Since the "set" path can have two possible entry points
        // return the expected data based on which path was taken[*]

        return value !== undefined ? value : key;
      },
      remove: function (owner, key) {
        var i,
            cache = owner[this.expando];

        if (cache === undefined) {
          return;
        }

        if (key !== undefined) {
          // Support array or space separated string of keys
          if (Array.isArray(key)) {
            // If key is an array of keys...
            // We always set camelCase keys, so remove that.
            key = key.map(camelCase);
          } else {
            key = camelCase(key); // If a key with the spaces exists, use it.
            // Otherwise, create an array by matching non-whitespace

            key = key in cache ? [key] : key.match(rnothtmlwhite) || [];
          }

          i = key.length;

          while (i--) {
            delete cache[key[i]];
          }
        } // Remove the expando if there's no more data


        if (key === undefined || jQuery.isEmptyObject(cache)) {
          // Support: Chrome <=35 - 45
          // Webkit & Blink performance suffers when deleting properties
          // from DOM nodes, so set to undefined instead
          // https://bugs.chromium.org/p/chromium/issues/detail?id=378607 (bug restricted)
          if (owner.nodeType) {
            owner[this.expando] = undefined;
          } else {
            delete owner[this.expando];
          }
        }
      },
      hasData: function (owner) {
        var cache = owner[this.expando];
        return cache !== undefined && !jQuery.isEmptyObject(cache);
      }
    };
    var dataPriv = new Data();
    var dataUser = new Data(); //	Implementation Summary
    //
    //	1. Enforce API surface and semantic compatibility with 1.9.x branch
    //	2. Improve the module's maintainability by reducing the storage
    //		paths to a single mechanism.
    //	3. Use the same single mechanism to support "private" and "user" data.
    //	4. _Never_ expose "private" data to user code (TODO: Drop _data, _removeData)
    //	5. Avoid exposing implementation details on user objects (eg. expando properties)
    //	6. Provide a clear path for implementation upgrade to WeakMap in 2014

    var rbrace = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/,
        rmultiDash = /[A-Z]/g;

    function getData(data) {
      if (data === "true") {
        return true;
      }

      if (data === "false") {
        return false;
      }

      if (data === "null") {
        return null;
      } // Only convert to a number if it doesn't change the string


      if (data === +data + "") {
        return +data;
      }

      if (rbrace.test(data)) {
        return JSON.parse(data);
      }

      return data;
    }

    function dataAttr(elem, key, data) {
      var name; // If nothing was found internally, try to fetch any
      // data from the HTML5 data-* attribute

      if (data === undefined && elem.nodeType === 1) {
        name = "data-" + key.replace(rmultiDash, "-$&").toLowerCase();
        data = elem.getAttribute(name);

        if (typeof data === "string") {
          try {
            data = getData(data);
          } catch (e) {} // Make sure we set the data so it isn't changed later


          dataUser.set(elem, key, data);
        } else {
          data = undefined;
        }
      }

      return data;
    }

    jQuery.extend({
      hasData: function (elem) {
        return dataUser.hasData(elem) || dataPriv.hasData(elem);
      },
      data: function (elem, name, data) {
        return dataUser.access(elem, name, data);
      },
      removeData: function (elem, name) {
        dataUser.remove(elem, name);
      },
      // TODO: Now that all calls to _data and _removeData have been replaced
      // with direct calls to dataPriv methods, these can be deprecated.
      _data: function (elem, name, data) {
        return dataPriv.access(elem, name, data);
      },
      _removeData: function (elem, name) {
        dataPriv.remove(elem, name);
      }
    });
    jQuery.fn.extend({
      data: function (key, value) {
        var i,
            name,
            data,
            elem = this[0],
            attrs = elem && elem.attributes; // Gets all values

        if (key === undefined) {
          if (this.length) {
            data = dataUser.get(elem);

            if (elem.nodeType === 1 && !dataPriv.get(elem, "hasDataAttrs")) {
              i = attrs.length;

              while (i--) {
                // Support: IE 11 only
                // The attrs elements can be null (#14894)
                if (attrs[i]) {
                  name = attrs[i].name;

                  if (name.indexOf("data-") === 0) {
                    name = camelCase(name.slice(5));
                    dataAttr(elem, name, data[name]);
                  }
                }
              }

              dataPriv.set(elem, "hasDataAttrs", true);
            }
          }

          return data;
        } // Sets multiple values


        if (typeof key === "object") {
          return this.each(function () {
            dataUser.set(this, key);
          });
        }

        return access(this, function (value) {
          var data; // The calling jQuery object (element matches) is not empty
          // (and therefore has an element appears at this[ 0 ]) and the
          // `value` parameter was not undefined. An empty jQuery object
          // will result in `undefined` for elem = this[ 0 ] which will
          // throw an exception if an attempt to read a data cache is made.

          if (elem && value === undefined) {
            // Attempt to get data from the cache
            // The key will always be camelCased in Data
            data = dataUser.get(elem, key);

            if (data !== undefined) {
              return data;
            } // Attempt to "discover" the data in
            // HTML5 custom data-* attrs


            data = dataAttr(elem, key);

            if (data !== undefined) {
              return data;
            } // We tried really hard, but the data doesn't exist.


            return;
          } // Set the data...


          this.each(function () {
            // We always store the camelCased key
            dataUser.set(this, key, value);
          });
        }, null, value, arguments.length > 1, null, true);
      },
      removeData: function (key) {
        return this.each(function () {
          dataUser.remove(this, key);
        });
      }
    });
    jQuery.extend({
      queue: function (elem, type, data) {
        var queue;

        if (elem) {
          type = (type || "fx") + "queue";
          queue = dataPriv.get(elem, type); // Speed up dequeue by getting out quickly if this is just a lookup

          if (data) {
            if (!queue || Array.isArray(data)) {
              queue = dataPriv.access(elem, type, jQuery.makeArray(data));
            } else {
              queue.push(data);
            }
          }

          return queue || [];
        }
      },
      dequeue: function (elem, type) {
        type = type || "fx";

        var queue = jQuery.queue(elem, type),
            startLength = queue.length,
            fn = queue.shift(),
            hooks = jQuery._queueHooks(elem, type),
            next = function () {
          jQuery.dequeue(elem, type);
        }; // If the fx queue is dequeued, always remove the progress sentinel


        if (fn === "inprogress") {
          fn = queue.shift();
          startLength--;
        }

        if (fn) {
          // Add a progress sentinel to prevent the fx queue from being
          // automatically dequeued
          if (type === "fx") {
            queue.unshift("inprogress");
          } // Clear up the last queue stop function


          delete hooks.stop;
          fn.call(elem, next, hooks);
        }

        if (!startLength && hooks) {
          hooks.empty.fire();
        }
      },
      // Not public - generate a queueHooks object, or return the current one
      _queueHooks: function (elem, type) {
        var key = type + "queueHooks";
        return dataPriv.get(elem, key) || dataPriv.access(elem, key, {
          empty: jQuery.Callbacks("once memory").add(function () {
            dataPriv.remove(elem, [type + "queue", key]);
          })
        });
      }
    });
    jQuery.fn.extend({
      queue: function (type, data) {
        var setter = 2;

        if (typeof type !== "string") {
          data = type;
          type = "fx";
          setter--;
        }

        if (arguments.length < setter) {
          return jQuery.queue(this[0], type);
        }

        return data === undefined ? this : this.each(function () {
          var queue = jQuery.queue(this, type, data); // Ensure a hooks for this queue

          jQuery._queueHooks(this, type);

          if (type === "fx" && queue[0] !== "inprogress") {
            jQuery.dequeue(this, type);
          }
        });
      },
      dequeue: function (type) {
        return this.each(function () {
          jQuery.dequeue(this, type);
        });
      },
      clearQueue: function (type) {
        return this.queue(type || "fx", []);
      },
      // Get a promise resolved when queues of a certain type
      // are emptied (fx is the type by default)
      promise: function (type, obj) {
        var tmp,
            count = 1,
            defer = jQuery.Deferred(),
            elements = this,
            i = this.length,
            resolve = function () {
          if (! --count) {
            defer.resolveWith(elements, [elements]);
          }
        };

        if (typeof type !== "string") {
          obj = type;
          type = undefined;
        }

        type = type || "fx";

        while (i--) {
          tmp = dataPriv.get(elements[i], type + "queueHooks");

          if (tmp && tmp.empty) {
            count++;
            tmp.empty.add(resolve);
          }
        }

        resolve();
        return defer.promise(obj);
      }
    });
    var pnum = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source;
    var rcssNum = new RegExp("^(?:([+-])=|)(" + pnum + ")([a-z%]*)$", "i");
    var cssExpand = ["Top", "Right", "Bottom", "Left"];
    var documentElement = document.documentElement;

    var isAttached = function (elem) {
      return jQuery.contains(elem.ownerDocument, elem);
    },
        composed = {
      composed: true
    }; // Support: IE 9 - 11+, Edge 12 - 18+, iOS 10.0 - 10.2 only
    // Check attachment across shadow DOM boundaries when possible (gh-3504)
    // Support: iOS 10.0-10.2 only
    // Early iOS 10 versions support `attachShadow` but not `getRootNode`,
    // leading to errors. We need to check for `getRootNode`.


    if (documentElement.getRootNode) {
      isAttached = function (elem) {
        return jQuery.contains(elem.ownerDocument, elem) || elem.getRootNode(composed) === elem.ownerDocument;
      };
    }

    var isHiddenWithinTree = function (elem, el) {
      // isHiddenWithinTree might be called from jQuery#filter function;
      // in that case, element will be second argument
      elem = el || elem; // Inline style trumps all

      return elem.style.display === "none" || elem.style.display === "" && // Otherwise, check computed style
      // Support: Firefox <=43 - 45
      // Disconnected elements can have computed display: none, so first confirm that elem is
      // in the document.
      isAttached(elem) && jQuery.css(elem, "display") === "none";
    };

    function adjustCSS(elem, prop, valueParts, tween) {
      var adjusted,
          scale,
          maxIterations = 20,
          currentValue = tween ? function () {
        return tween.cur();
      } : function () {
        return jQuery.css(elem, prop, "");
      },
          initial = currentValue(),
          unit = valueParts && valueParts[3] || (jQuery.cssNumber[prop] ? "" : "px"),
          // Starting value computation is required for potential unit mismatches
      initialInUnit = elem.nodeType && (jQuery.cssNumber[prop] || unit !== "px" && +initial) && rcssNum.exec(jQuery.css(elem, prop));

      if (initialInUnit && initialInUnit[3] !== unit) {
        // Support: Firefox <=54
        // Halve the iteration target value to prevent interference from CSS upper bounds (gh-2144)
        initial = initial / 2; // Trust units reported by jQuery.css

        unit = unit || initialInUnit[3]; // Iteratively approximate from a nonzero starting point

        initialInUnit = +initial || 1;

        while (maxIterations--) {
          // Evaluate and update our best guess (doubling guesses that zero out).
          // Finish if the scale equals or crosses 1 (making the old*new product non-positive).
          jQuery.style(elem, prop, initialInUnit + unit);

          if ((1 - scale) * (1 - (scale = currentValue() / initial || 0.5)) <= 0) {
            maxIterations = 0;
          }

          initialInUnit = initialInUnit / scale;
        }

        initialInUnit = initialInUnit * 2;
        jQuery.style(elem, prop, initialInUnit + unit); // Make sure we update the tween properties later on

        valueParts = valueParts || [];
      }

      if (valueParts) {
        initialInUnit = +initialInUnit || +initial || 0; // Apply relative offset (+=/-=) if specified

        adjusted = valueParts[1] ? initialInUnit + (valueParts[1] + 1) * valueParts[2] : +valueParts[2];

        if (tween) {
          tween.unit = unit;
          tween.start = initialInUnit;
          tween.end = adjusted;
        }
      }

      return adjusted;
    }

    var defaultDisplayMap = {};

    function getDefaultDisplay(elem) {
      var temp,
          doc = elem.ownerDocument,
          nodeName = elem.nodeName,
          display = defaultDisplayMap[nodeName];

      if (display) {
        return display;
      }

      temp = doc.body.appendChild(doc.createElement(nodeName));
      display = jQuery.css(temp, "display");
      temp.parentNode.removeChild(temp);

      if (display === "none") {
        display = "block";
      }

      defaultDisplayMap[nodeName] = display;
      return display;
    }

    function showHide(elements, show) {
      var display,
          elem,
          values = [],
          index = 0,
          length = elements.length; // Determine new display value for elements that need to change

      for (; index < length; index++) {
        elem = elements[index];

        if (!elem.style) {
          continue;
        }

        display = elem.style.display;

        if (show) {
          // Since we force visibility upon cascade-hidden elements, an immediate (and slow)
          // check is required in this first loop unless we have a nonempty display value (either
          // inline or about-to-be-restored)
          if (display === "none") {
            values[index] = dataPriv.get(elem, "display") || null;

            if (!values[index]) {
              elem.style.display = "";
            }
          }

          if (elem.style.display === "" && isHiddenWithinTree(elem)) {
            values[index] = getDefaultDisplay(elem);
          }
        } else {
          if (display !== "none") {
            values[index] = "none"; // Remember what we're overwriting

            dataPriv.set(elem, "display", display);
          }
        }
      } // Set the display of the elements in a second loop to avoid constant reflow


      for (index = 0; index < length; index++) {
        if (values[index] != null) {
          elements[index].style.display = values[index];
        }
      }

      return elements;
    }

    jQuery.fn.extend({
      show: function () {
        return showHide(this, true);
      },
      hide: function () {
        return showHide(this);
      },
      toggle: function (state) {
        if (typeof state === "boolean") {
          return state ? this.show() : this.hide();
        }

        return this.each(function () {
          if (isHiddenWithinTree(this)) {
            jQuery(this).show();
          } else {
            jQuery(this).hide();
          }
        });
      }
    });
    var rcheckableType = /^(?:checkbox|radio)$/i;
    var rtagName = /<([a-z][^\/\0>\x20\t\r\n\f]*)/i;
    var rscriptType = /^$|^module$|\/(?:java|ecma)script/i;

    (function () {
      var fragment = document.createDocumentFragment(),
          div = fragment.appendChild(document.createElement("div")),
          input = document.createElement("input"); // Support: Android 4.0 - 4.3 only
      // Check state lost if the name is set (#11217)
      // Support: Windows Web Apps (WWA)
      // `name` and `type` must use .setAttribute for WWA (#14901)

      input.setAttribute("type", "radio");
      input.setAttribute("checked", "checked");
      input.setAttribute("name", "t");
      div.appendChild(input); // Support: Android <=4.1 only
      // Older WebKit doesn't clone checked state correctly in fragments

      support.checkClone = div.cloneNode(true).cloneNode(true).lastChild.checked; // Support: IE <=11 only
      // Make sure textarea (and checkbox) defaultValue is properly cloned

      div.innerHTML = "<textarea>x</textarea>";
      support.noCloneChecked = !!div.cloneNode(true).lastChild.defaultValue; // Support: IE <=9 only
      // IE <=9 replaces <option> tags with their contents when inserted outside of
      // the select element.

      div.innerHTML = "<option></option>";
      support.option = !!div.lastChild;
    })(); // We have to close these tags to support XHTML (#13200)


    var wrapMap = {
      // XHTML parsers do not magically insert elements in the
      // same way that tag soup parsers do. So we cannot shorten
      // this by omitting <tbody> or other required elements.
      thead: [1, "<table>", "</table>"],
      col: [2, "<table><colgroup>", "</colgroup></table>"],
      tr: [2, "<table><tbody>", "</tbody></table>"],
      td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
      _default: [0, "", ""]
    };
    wrapMap.tbody = wrapMap.tfoot = wrapMap.colgroup = wrapMap.caption = wrapMap.thead;
    wrapMap.th = wrapMap.td; // Support: IE <=9 only

    if (!support.option) {
      wrapMap.optgroup = wrapMap.option = [1, "<select multiple='multiple'>", "</select>"];
    }

    function getAll(context, tag) {
      // Support: IE <=9 - 11 only
      // Use typeof to avoid zero-argument method invocation on host objects (#15151)
      var ret;

      if (typeof context.getElementsByTagName !== "undefined") {
        ret = context.getElementsByTagName(tag || "*");
      } else if (typeof context.querySelectorAll !== "undefined") {
        ret = context.querySelectorAll(tag || "*");
      } else {
        ret = [];
      }

      if (tag === undefined || tag && nodeName(context, tag)) {
        return jQuery.merge([context], ret);
      }

      return ret;
    } // Mark scripts as having already been evaluated


    function setGlobalEval(elems, refElements) {
      var i = 0,
          l = elems.length;

      for (; i < l; i++) {
        dataPriv.set(elems[i], "globalEval", !refElements || dataPriv.get(refElements[i], "globalEval"));
      }
    }

    var rhtml = /<|&#?\w+;/;

    function buildFragment(elems, context, scripts, selection, ignored) {
      var elem,
          tmp,
          tag,
          wrap,
          attached,
          j,
          fragment = context.createDocumentFragment(),
          nodes = [],
          i = 0,
          l = elems.length;

      for (; i < l; i++) {
        elem = elems[i];

        if (elem || elem === 0) {
          // Add nodes directly
          if (toType(elem) === "object") {
            // Support: Android <=4.0 only, PhantomJS 1 only
            // push.apply(_, arraylike) throws on ancient WebKit
            jQuery.merge(nodes, elem.nodeType ? [elem] : elem); // Convert non-html into a text node
          } else if (!rhtml.test(elem)) {
            nodes.push(context.createTextNode(elem)); // Convert html into DOM nodes
          } else {
            tmp = tmp || fragment.appendChild(context.createElement("div")); // Deserialize a standard representation

            tag = (rtagName.exec(elem) || ["", ""])[1].toLowerCase();
            wrap = wrapMap[tag] || wrapMap._default;
            tmp.innerHTML = wrap[1] + jQuery.htmlPrefilter(elem) + wrap[2]; // Descend through wrappers to the right content

            j = wrap[0];

            while (j--) {
              tmp = tmp.lastChild;
            } // Support: Android <=4.0 only, PhantomJS 1 only
            // push.apply(_, arraylike) throws on ancient WebKit


            jQuery.merge(nodes, tmp.childNodes); // Remember the top-level container

            tmp = fragment.firstChild; // Ensure the created nodes are orphaned (#12392)

            tmp.textContent = "";
          }
        }
      } // Remove wrapper from fragment


      fragment.textContent = "";
      i = 0;

      while (elem = nodes[i++]) {
        // Skip elements already in the context collection (trac-4087)
        if (selection && jQuery.inArray(elem, selection) > -1) {
          if (ignored) {
            ignored.push(elem);
          }

          continue;
        }

        attached = isAttached(elem); // Append to fragment

        tmp = getAll(fragment.appendChild(elem), "script"); // Preserve script evaluation history

        if (attached) {
          setGlobalEval(tmp);
        } // Capture executables


        if (scripts) {
          j = 0;

          while (elem = tmp[j++]) {
            if (rscriptType.test(elem.type || "")) {
              scripts.push(elem);
            }
          }
        }
      }

      return fragment;
    }

    var rtypenamespace = /^([^.]*)(?:\.(.+)|)/;

    function returnTrue() {
      return true;
    }

    function returnFalse() {
      return false;
    } // Support: IE <=9 - 11+
    // focus() and blur() are asynchronous, except when they are no-op.
    // So expect focus to be synchronous when the element is already active,
    // and blur to be synchronous when the element is not already active.
    // (focus and blur are always synchronous in other supported browsers,
    // this just defines when we can count on it).


    function expectSync(elem, type) {
      return elem === safeActiveElement() === (type === "focus");
    } // Support: IE <=9 only
    // Accessing document.activeElement can throw unexpectedly
    // https://bugs.jquery.com/ticket/13393


    function safeActiveElement() {
      try {
        return document.activeElement;
      } catch (err) {}
    }

    function on(elem, types, selector, data, fn, one) {
      var origFn, type; // Types can be a map of types/handlers

      if (typeof types === "object") {
        // ( types-Object, selector, data )
        if (typeof selector !== "string") {
          // ( types-Object, data )
          data = data || selector;
          selector = undefined;
        }

        for (type in types) {
          on(elem, type, selector, data, types[type], one);
        }

        return elem;
      }

      if (data == null && fn == null) {
        // ( types, fn )
        fn = selector;
        data = selector = undefined;
      } else if (fn == null) {
        if (typeof selector === "string") {
          // ( types, selector, fn )
          fn = data;
          data = undefined;
        } else {
          // ( types, data, fn )
          fn = data;
          data = selector;
          selector = undefined;
        }
      }

      if (fn === false) {
        fn = returnFalse;
      } else if (!fn) {
        return elem;
      }

      if (one === 1) {
        origFn = fn;

        fn = function (event) {
          // Can use an empty set, since event contains the info
          jQuery().off(event);
          return origFn.apply(this, arguments);
        }; // Use same guid so caller can remove using origFn


        fn.guid = origFn.guid || (origFn.guid = jQuery.guid++);
      }

      return elem.each(function () {
        jQuery.event.add(this, types, fn, data, selector);
      });
    }
    /*
     * Helper functions for managing events -- not part of the public interface.
     * Props to Dean Edwards' addEvent library for many of the ideas.
     */


    jQuery.event = {
      global: {},
      add: function (elem, types, handler, data, selector) {
        var handleObjIn,
            eventHandle,
            tmp,
            events,
            t,
            handleObj,
            special,
            handlers,
            type,
            namespaces,
            origType,
            elemData = dataPriv.get(elem); // Only attach events to objects that accept data

        if (!acceptData(elem)) {
          return;
        } // Caller can pass in an object of custom data in lieu of the handler


        if (handler.handler) {
          handleObjIn = handler;
          handler = handleObjIn.handler;
          selector = handleObjIn.selector;
        } // Ensure that invalid selectors throw exceptions at attach time
        // Evaluate against documentElement in case elem is a non-element node (e.g., document)


        if (selector) {
          jQuery.find.matchesSelector(documentElement, selector);
        } // Make sure that the handler has a unique ID, used to find/remove it later


        if (!handler.guid) {
          handler.guid = jQuery.guid++;
        } // Init the element's event structure and main handler, if this is the first


        if (!(events = elemData.events)) {
          events = elemData.events = Object.create(null);
        }

        if (!(eventHandle = elemData.handle)) {
          eventHandle = elemData.handle = function (e) {
            // Discard the second event of a jQuery.event.trigger() and
            // when an event is called after a page has unloaded
            return typeof jQuery !== "undefined" && jQuery.event.triggered !== e.type ? jQuery.event.dispatch.apply(elem, arguments) : undefined;
          };
        } // Handle multiple events separated by a space


        types = (types || "").match(rnothtmlwhite) || [""];
        t = types.length;

        while (t--) {
          tmp = rtypenamespace.exec(types[t]) || [];
          type = origType = tmp[1];
          namespaces = (tmp[2] || "").split(".").sort(); // There *must* be a type, no attaching namespace-only handlers

          if (!type) {
            continue;
          } // If event changes its type, use the special event handlers for the changed type


          special = jQuery.event.special[type] || {}; // If selector defined, determine special event api type, otherwise given type

          type = (selector ? special.delegateType : special.bindType) || type; // Update special based on newly reset type

          special = jQuery.event.special[type] || {}; // handleObj is passed to all event handlers

          handleObj = jQuery.extend({
            type: type,
            origType: origType,
            data: data,
            handler: handler,
            guid: handler.guid,
            selector: selector,
            needsContext: selector && jQuery.expr.match.needsContext.test(selector),
            namespace: namespaces.join(".")
          }, handleObjIn); // Init the event handler queue if we're the first

          if (!(handlers = events[type])) {
            handlers = events[type] = [];
            handlers.delegateCount = 0; // Only use addEventListener if the special events handler returns false

            if (!special.setup || special.setup.call(elem, data, namespaces, eventHandle) === false) {
              if (elem.addEventListener) {
                elem.addEventListener(type, eventHandle);
              }
            }
          }

          if (special.add) {
            special.add.call(elem, handleObj);

            if (!handleObj.handler.guid) {
              handleObj.handler.guid = handler.guid;
            }
          } // Add to the element's handler list, delegates in front


          if (selector) {
            handlers.splice(handlers.delegateCount++, 0, handleObj);
          } else {
            handlers.push(handleObj);
          } // Keep track of which events have ever been used, for event optimization


          jQuery.event.global[type] = true;
        }
      },
      // Detach an event or set of events from an element
      remove: function (elem, types, handler, selector, mappedTypes) {
        var j,
            origCount,
            tmp,
            events,
            t,
            handleObj,
            special,
            handlers,
            type,
            namespaces,
            origType,
            elemData = dataPriv.hasData(elem) && dataPriv.get(elem);

        if (!elemData || !(events = elemData.events)) {
          return;
        } // Once for each type.namespace in types; type may be omitted


        types = (types || "").match(rnothtmlwhite) || [""];
        t = types.length;

        while (t--) {
          tmp = rtypenamespace.exec(types[t]) || [];
          type = origType = tmp[1];
          namespaces = (tmp[2] || "").split(".").sort(); // Unbind all events (on this namespace, if provided) for the element

          if (!type) {
            for (type in events) {
              jQuery.event.remove(elem, type + types[t], handler, selector, true);
            }

            continue;
          }

          special = jQuery.event.special[type] || {};
          type = (selector ? special.delegateType : special.bindType) || type;
          handlers = events[type] || [];
          tmp = tmp[2] && new RegExp("(^|\\.)" + namespaces.join("\\.(?:.*\\.|)") + "(\\.|$)"); // Remove matching events

          origCount = j = handlers.length;

          while (j--) {
            handleObj = handlers[j];

            if ((mappedTypes || origType === handleObj.origType) && (!handler || handler.guid === handleObj.guid) && (!tmp || tmp.test(handleObj.namespace)) && (!selector || selector === handleObj.selector || selector === "**" && handleObj.selector)) {
              handlers.splice(j, 1);

              if (handleObj.selector) {
                handlers.delegateCount--;
              }

              if (special.remove) {
                special.remove.call(elem, handleObj);
              }
            }
          } // Remove generic event handler if we removed something and no more handlers exist
          // (avoids potential for endless recursion during removal of special event handlers)


          if (origCount && !handlers.length) {
            if (!special.teardown || special.teardown.call(elem, namespaces, elemData.handle) === false) {
              jQuery.removeEvent(elem, type, elemData.handle);
            }

            delete events[type];
          }
        } // Remove data and the expando if it's no longer used


        if (jQuery.isEmptyObject(events)) {
          dataPriv.remove(elem, "handle events");
        }
      },
      dispatch: function (nativeEvent) {
        var i,
            j,
            ret,
            matched,
            handleObj,
            handlerQueue,
            args = new Array(arguments.length),
            // Make a writable jQuery.Event from the native event object
        event = jQuery.event.fix(nativeEvent),
            handlers = (dataPriv.get(this, "events") || Object.create(null))[event.type] || [],
            special = jQuery.event.special[event.type] || {}; // Use the fix-ed jQuery.Event rather than the (read-only) native event

        args[0] = event;

        for (i = 1; i < arguments.length; i++) {
          args[i] = arguments[i];
        }

        event.delegateTarget = this; // Call the preDispatch hook for the mapped type, and let it bail if desired

        if (special.preDispatch && special.preDispatch.call(this, event) === false) {
          return;
        } // Determine handlers


        handlerQueue = jQuery.event.handlers.call(this, event, handlers); // Run delegates first; they may want to stop propagation beneath us

        i = 0;

        while ((matched = handlerQueue[i++]) && !event.isPropagationStopped()) {
          event.currentTarget = matched.elem;
          j = 0;

          while ((handleObj = matched.handlers[j++]) && !event.isImmediatePropagationStopped()) {
            // If the event is namespaced, then each handler is only invoked if it is
            // specially universal or its namespaces are a superset of the event's.
            if (!event.rnamespace || handleObj.namespace === false || event.rnamespace.test(handleObj.namespace)) {
              event.handleObj = handleObj;
              event.data = handleObj.data;
              ret = ((jQuery.event.special[handleObj.origType] || {}).handle || handleObj.handler).apply(matched.elem, args);

              if (ret !== undefined) {
                if ((event.result = ret) === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }
              }
            }
          }
        } // Call the postDispatch hook for the mapped type


        if (special.postDispatch) {
          special.postDispatch.call(this, event);
        }

        return event.result;
      },
      handlers: function (event, handlers) {
        var i,
            handleObj,
            sel,
            matchedHandlers,
            matchedSelectors,
            handlerQueue = [],
            delegateCount = handlers.delegateCount,
            cur = event.target; // Find delegate handlers

        if (delegateCount && // Support: IE <=9
        // Black-hole SVG <use> instance trees (trac-13180)
        cur.nodeType && // Support: Firefox <=42
        // Suppress spec-violating clicks indicating a non-primary pointer button (trac-3861)
        // https://www.w3.org/TR/DOM-Level-3-Events/#event-type-click
        // Support: IE 11 only
        // ...but not arrow key "clicks" of radio inputs, which can have `button` -1 (gh-2343)
        !(event.type === "click" && event.button >= 1)) {
          for (; cur !== this; cur = cur.parentNode || this) {
            // Don't check non-elements (#13208)
            // Don't process clicks on disabled elements (#6911, #8165, #11382, #11764)
            if (cur.nodeType === 1 && !(event.type === "click" && cur.disabled === true)) {
              matchedHandlers = [];
              matchedSelectors = {};

              for (i = 0; i < delegateCount; i++) {
                handleObj = handlers[i]; // Don't conflict with Object.prototype properties (#13203)

                sel = handleObj.selector + " ";

                if (matchedSelectors[sel] === undefined) {
                  matchedSelectors[sel] = handleObj.needsContext ? jQuery(sel, this).index(cur) > -1 : jQuery.find(sel, this, null, [cur]).length;
                }

                if (matchedSelectors[sel]) {
                  matchedHandlers.push(handleObj);
                }
              }

              if (matchedHandlers.length) {
                handlerQueue.push({
                  elem: cur,
                  handlers: matchedHandlers
                });
              }
            }
          }
        } // Add the remaining (directly-bound) handlers


        cur = this;

        if (delegateCount < handlers.length) {
          handlerQueue.push({
            elem: cur,
            handlers: handlers.slice(delegateCount)
          });
        }

        return handlerQueue;
      },
      addProp: function (name, hook) {
        Object.defineProperty(jQuery.Event.prototype, name, {
          enumerable: true,
          configurable: true,
          get: isFunction(hook) ? function () {
            if (this.originalEvent) {
              return hook(this.originalEvent);
            }
          } : function () {
            if (this.originalEvent) {
              return this.originalEvent[name];
            }
          },
          set: function (value) {
            Object.defineProperty(this, name, {
              enumerable: true,
              configurable: true,
              writable: true,
              value: value
            });
          }
        });
      },
      fix: function (originalEvent) {
        return originalEvent[jQuery.expando] ? originalEvent : new jQuery.Event(originalEvent);
      },
      special: {
        load: {
          // Prevent triggered image.load events from bubbling to window.load
          noBubble: true
        },
        click: {
          // Utilize native event to ensure correct state for checkable inputs
          setup: function (data) {
            // For mutual compressibility with _default, replace `this` access with a local var.
            // `|| data` is dead code meant only to preserve the variable through minification.
            var el = this || data; // Claim the first handler

            if (rcheckableType.test(el.type) && el.click && nodeName(el, "input")) {
              // dataPriv.set( el, "click", ... )
              leverageNative(el, "click", returnTrue);
            } // Return false to allow normal processing in the caller


            return false;
          },
          trigger: function (data) {
            // For mutual compressibility with _default, replace `this` access with a local var.
            // `|| data` is dead code meant only to preserve the variable through minification.
            var el = this || data; // Force setup before triggering a click

            if (rcheckableType.test(el.type) && el.click && nodeName(el, "input")) {
              leverageNative(el, "click");
            } // Return non-false to allow normal event-path propagation


            return true;
          },
          // For cross-browser consistency, suppress native .click() on links
          // Also prevent it if we're currently inside a leveraged native-event stack
          _default: function (event) {
            var target = event.target;
            return rcheckableType.test(target.type) && target.click && nodeName(target, "input") && dataPriv.get(target, "click") || nodeName(target, "a");
          }
        },
        beforeunload: {
          postDispatch: function (event) {
            // Support: Firefox 20+
            // Firefox doesn't alert if the returnValue field is not set.
            if (event.result !== undefined && event.originalEvent) {
              event.originalEvent.returnValue = event.result;
            }
          }
        }
      }
    }; // Ensure the presence of an event listener that handles manually-triggered
    // synthetic events by interrupting progress until reinvoked in response to
    // *native* events that it fires directly, ensuring that state changes have
    // already occurred before other listeners are invoked.

    function leverageNative(el, type, expectSync) {
      // Missing expectSync indicates a trigger call, which must force setup through jQuery.event.add
      if (!expectSync) {
        if (dataPriv.get(el, type) === undefined) {
          jQuery.event.add(el, type, returnTrue);
        }

        return;
      } // Register the controller as a special universal handler for all event namespaces


      dataPriv.set(el, type, false);
      jQuery.event.add(el, type, {
        namespace: false,
        handler: function (event) {
          var notAsync,
              result,
              saved = dataPriv.get(this, type);

          if (event.isTrigger & 1 && this[type]) {
            // Interrupt processing of the outer synthetic .trigger()ed event
            // Saved data should be false in such cases, but might be a leftover capture object
            // from an async native handler (gh-4350)
            if (!saved.length) {
              // Store arguments for use when handling the inner native event
              // There will always be at least one argument (an event object), so this array
              // will not be confused with a leftover capture object.
              saved = slice.call(arguments);
              dataPriv.set(this, type, saved); // Trigger the native event and capture its result
              // Support: IE <=9 - 11+
              // focus() and blur() are asynchronous

              notAsync = expectSync(this, type);
              this[type]();
              result = dataPriv.get(this, type);

              if (saved !== result || notAsync) {
                dataPriv.set(this, type, false);
              } else {
                result = {};
              }

              if (saved !== result) {
                // Cancel the outer synthetic event
                event.stopImmediatePropagation();
                event.preventDefault(); // Support: Chrome 86+
                // In Chrome, if an element having a focusout handler is blurred by
                // clicking outside of it, it invokes the handler synchronously. If
                // that handler calls `.remove()` on the element, the data is cleared,
                // leaving `result` undefined. We need to guard against this.

                return result && result.value;
              } // If this is an inner synthetic event for an event with a bubbling surrogate
              // (focus or blur), assume that the surrogate already propagated from triggering the
              // native event and prevent that from happening again here.
              // This technically gets the ordering wrong w.r.t. to `.trigger()` (in which the
              // bubbling surrogate propagates *after* the non-bubbling base), but that seems
              // less bad than duplication.

            } else if ((jQuery.event.special[type] || {}).delegateType) {
              event.stopPropagation();
            } // If this is a native event triggered above, everything is now in order
            // Fire an inner synthetic event with the original arguments

          } else if (saved.length) {
            // ...and capture the result
            dataPriv.set(this, type, {
              value: jQuery.event.trigger( // Support: IE <=9 - 11+
              // Extend with the prototype to reset the above stopImmediatePropagation()
              jQuery.extend(saved[0], jQuery.Event.prototype), saved.slice(1), this)
            }); // Abort handling of the native event

            event.stopImmediatePropagation();
          }
        }
      });
    }

    jQuery.removeEvent = function (elem, type, handle) {
      // This "if" is needed for plain objects
      if (elem.removeEventListener) {
        elem.removeEventListener(type, handle);
      }
    };

    jQuery.Event = function (src, props) {
      // Allow instantiation without the 'new' keyword
      if (!(this instanceof jQuery.Event)) {
        return new jQuery.Event(src, props);
      } // Event object


      if (src && src.type) {
        this.originalEvent = src;
        this.type = src.type; // Events bubbling up the document may have been marked as prevented
        // by a handler lower down the tree; reflect the correct value.

        this.isDefaultPrevented = src.defaultPrevented || src.defaultPrevented === undefined && // Support: Android <=2.3 only
        src.returnValue === false ? returnTrue : returnFalse; // Create target properties
        // Support: Safari <=6 - 7 only
        // Target should not be a text node (#504, #13143)

        this.target = src.target && src.target.nodeType === 3 ? src.target.parentNode : src.target;
        this.currentTarget = src.currentTarget;
        this.relatedTarget = src.relatedTarget; // Event type
      } else {
        this.type = src;
      } // Put explicitly provided properties onto the event object


      if (props) {
        jQuery.extend(this, props);
      } // Create a timestamp if incoming event doesn't have one


      this.timeStamp = src && src.timeStamp || Date.now(); // Mark it as fixed

      this[jQuery.expando] = true;
    }; // jQuery.Event is based on DOM3 Events as specified by the ECMAScript Language Binding
    // https://www.w3.org/TR/2003/WD-DOM-Level-3-Events-20030331/ecma-script-binding.html


    jQuery.Event.prototype = {
      constructor: jQuery.Event,
      isDefaultPrevented: returnFalse,
      isPropagationStopped: returnFalse,
      isImmediatePropagationStopped: returnFalse,
      isSimulated: false,
      preventDefault: function () {
        var e = this.originalEvent;
        this.isDefaultPrevented = returnTrue;

        if (e && !this.isSimulated) {
          e.preventDefault();
        }
      },
      stopPropagation: function () {
        var e = this.originalEvent;
        this.isPropagationStopped = returnTrue;

        if (e && !this.isSimulated) {
          e.stopPropagation();
        }
      },
      stopImmediatePropagation: function () {
        var e = this.originalEvent;
        this.isImmediatePropagationStopped = returnTrue;

        if (e && !this.isSimulated) {
          e.stopImmediatePropagation();
        }

        this.stopPropagation();
      }
    }; // Includes all common event props including KeyEvent and MouseEvent specific props

    jQuery.each({
      altKey: true,
      bubbles: true,
      cancelable: true,
      changedTouches: true,
      ctrlKey: true,
      detail: true,
      eventPhase: true,
      metaKey: true,
      pageX: true,
      pageY: true,
      shiftKey: true,
      view: true,
      "char": true,
      code: true,
      charCode: true,
      key: true,
      keyCode: true,
      button: true,
      buttons: true,
      clientX: true,
      clientY: true,
      offsetX: true,
      offsetY: true,
      pointerId: true,
      pointerType: true,
      screenX: true,
      screenY: true,
      targetTouches: true,
      toElement: true,
      touches: true,
      which: true
    }, jQuery.event.addProp);
    jQuery.each({
      focus: "focusin",
      blur: "focusout"
    }, function (type, delegateType) {
      jQuery.event.special[type] = {
        // Utilize native event if possible so blur/focus sequence is correct
        setup: function () {
          // Claim the first handler
          // dataPriv.set( this, "focus", ... )
          // dataPriv.set( this, "blur", ... )
          leverageNative(this, type, expectSync); // Return false to allow normal processing in the caller

          return false;
        },
        trigger: function () {
          // Force setup before trigger
          leverageNative(this, type); // Return non-false to allow normal event-path propagation

          return true;
        },
        // Suppress native focus or blur as it's already being fired
        // in leverageNative.
        _default: function () {
          return true;
        },
        delegateType: delegateType
      };
    }); // Create mouseenter/leave events using mouseover/out and event-time checks
    // so that event delegation works in jQuery.
    // Do the same for pointerenter/pointerleave and pointerover/pointerout
    //
    // Support: Safari 7 only
    // Safari sends mouseenter too often; see:
    // https://bugs.chromium.org/p/chromium/issues/detail?id=470258
    // for the description of the bug (it existed in older Chrome versions as well).

    jQuery.each({
      mouseenter: "mouseover",
      mouseleave: "mouseout",
      pointerenter: "pointerover",
      pointerleave: "pointerout"
    }, function (orig, fix) {
      jQuery.event.special[orig] = {
        delegateType: fix,
        bindType: fix,
        handle: function (event) {
          var ret,
              target = this,
              related = event.relatedTarget,
              handleObj = event.handleObj; // For mouseenter/leave call the handler if related is outside the target.
          // NB: No relatedTarget if the mouse left/entered the browser window

          if (!related || related !== target && !jQuery.contains(target, related)) {
            event.type = handleObj.origType;
            ret = handleObj.handler.apply(this, arguments);
            event.type = fix;
          }

          return ret;
        }
      };
    });
    jQuery.fn.extend({
      on: function (types, selector, data, fn) {
        return on(this, types, selector, data, fn);
      },
      one: function (types, selector, data, fn) {
        return on(this, types, selector, data, fn, 1);
      },
      off: function (types, selector, fn) {
        var handleObj, type;

        if (types && types.preventDefault && types.handleObj) {
          // ( event )  dispatched jQuery.Event
          handleObj = types.handleObj;
          jQuery(types.delegateTarget).off(handleObj.namespace ? handleObj.origType + "." + handleObj.namespace : handleObj.origType, handleObj.selector, handleObj.handler);
          return this;
        }

        if (typeof types === "object") {
          // ( types-object [, selector] )
          for (type in types) {
            this.off(type, selector, types[type]);
          }

          return this;
        }

        if (selector === false || typeof selector === "function") {
          // ( types [, fn] )
          fn = selector;
          selector = undefined;
        }

        if (fn === false) {
          fn = returnFalse;
        }

        return this.each(function () {
          jQuery.event.remove(this, types, fn, selector);
        });
      }
    });
    var // Support: IE <=10 - 11, Edge 12 - 13 only
    // In IE/Edge using regex groups here causes severe slowdowns.
    // See https://connect.microsoft.com/IE/feedback/details/1736512/
    rnoInnerhtml = /<script|<style|<link/i,
        // checked="checked" or checked
    rchecked = /checked\s*(?:[^=]|=\s*.checked.)/i,
        rcleanScript = /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g; // Prefer a tbody over its parent table for containing new rows

    function manipulationTarget(elem, content) {
      if (nodeName(elem, "table") && nodeName(content.nodeType !== 11 ? content : content.firstChild, "tr")) {
        return jQuery(elem).children("tbody")[0] || elem;
      }

      return elem;
    } // Replace/restore the type attribute of script elements for safe DOM manipulation


    function disableScript(elem) {
      elem.type = (elem.getAttribute("type") !== null) + "/" + elem.type;
      return elem;
    }

    function restoreScript(elem) {
      if ((elem.type || "").slice(0, 5) === "true/") {
        elem.type = elem.type.slice(5);
      } else {
        elem.removeAttribute("type");
      }

      return elem;
    }

    function cloneCopyEvent(src, dest) {
      var i, l, type, pdataOld, udataOld, udataCur, events;

      if (dest.nodeType !== 1) {
        return;
      } // 1. Copy private data: events, handlers, etc.


      if (dataPriv.hasData(src)) {
        pdataOld = dataPriv.get(src);
        events = pdataOld.events;

        if (events) {
          dataPriv.remove(dest, "handle events");

          for (type in events) {
            for (i = 0, l = events[type].length; i < l; i++) {
              jQuery.event.add(dest, type, events[type][i]);
            }
          }
        }
      } // 2. Copy user data


      if (dataUser.hasData(src)) {
        udataOld = dataUser.access(src);
        udataCur = jQuery.extend({}, udataOld);
        dataUser.set(dest, udataCur);
      }
    } // Fix IE bugs, see support tests


    function fixInput(src, dest) {
      var nodeName = dest.nodeName.toLowerCase(); // Fails to persist the checked state of a cloned checkbox or radio button.

      if (nodeName === "input" && rcheckableType.test(src.type)) {
        dest.checked = src.checked; // Fails to return the selected option to the default selected state when cloning options
      } else if (nodeName === "input" || nodeName === "textarea") {
        dest.defaultValue = src.defaultValue;
      }
    }

    function domManip(collection, args, callback, ignored) {
      // Flatten any nested arrays
      args = flat(args);
      var fragment,
          first,
          scripts,
          hasScripts,
          node,
          doc,
          i = 0,
          l = collection.length,
          iNoClone = l - 1,
          value = args[0],
          valueIsFunction = isFunction(value); // We can't cloneNode fragments that contain checked, in WebKit

      if (valueIsFunction || l > 1 && typeof value === "string" && !support.checkClone && rchecked.test(value)) {
        return collection.each(function (index) {
          var self = collection.eq(index);

          if (valueIsFunction) {
            args[0] = value.call(this, index, self.html());
          }

          domManip(self, args, callback, ignored);
        });
      }

      if (l) {
        fragment = buildFragment(args, collection[0].ownerDocument, false, collection, ignored);
        first = fragment.firstChild;

        if (fragment.childNodes.length === 1) {
          fragment = first;
        } // Require either new content or an interest in ignored elements to invoke the callback


        if (first || ignored) {
          scripts = jQuery.map(getAll(fragment, "script"), disableScript);
          hasScripts = scripts.length; // Use the original fragment for the last item
          // instead of the first because it can end up
          // being emptied incorrectly in certain situations (#8070).

          for (; i < l; i++) {
            node = fragment;

            if (i !== iNoClone) {
              node = jQuery.clone(node, true, true); // Keep references to cloned scripts for later restoration

              if (hasScripts) {
                // Support: Android <=4.0 only, PhantomJS 1 only
                // push.apply(_, arraylike) throws on ancient WebKit
                jQuery.merge(scripts, getAll(node, "script"));
              }
            }

            callback.call(collection[i], node, i);
          }

          if (hasScripts) {
            doc = scripts[scripts.length - 1].ownerDocument; // Reenable scripts

            jQuery.map(scripts, restoreScript); // Evaluate executable scripts on first document insertion

            for (i = 0; i < hasScripts; i++) {
              node = scripts[i];

              if (rscriptType.test(node.type || "") && !dataPriv.access(node, "globalEval") && jQuery.contains(doc, node)) {
                if (node.src && (node.type || "").toLowerCase() !== "module") {
                  // Optional AJAX dependency, but won't run scripts if not present
                  if (jQuery._evalUrl && !node.noModule) {
                    jQuery._evalUrl(node.src, {
                      nonce: node.nonce || node.getAttribute("nonce")
                    }, doc);
                  }
                } else {
                  DOMEval(node.textContent.replace(rcleanScript, ""), node, doc);
                }
              }
            }
          }
        }
      }

      return collection;
    }

    function remove(elem, selector, keepData) {
      var node,
          nodes = selector ? jQuery.filter(selector, elem) : elem,
          i = 0;

      for (; (node = nodes[i]) != null; i++) {
        if (!keepData && node.nodeType === 1) {
          jQuery.cleanData(getAll(node));
        }

        if (node.parentNode) {
          if (keepData && isAttached(node)) {
            setGlobalEval(getAll(node, "script"));
          }

          node.parentNode.removeChild(node);
        }
      }

      return elem;
    }

    jQuery.extend({
      htmlPrefilter: function (html) {
        return html;
      },
      clone: function (elem, dataAndEvents, deepDataAndEvents) {
        var i,
            l,
            srcElements,
            destElements,
            clone = elem.cloneNode(true),
            inPage = isAttached(elem); // Fix IE cloning issues

        if (!support.noCloneChecked && (elem.nodeType === 1 || elem.nodeType === 11) && !jQuery.isXMLDoc(elem)) {
          // We eschew Sizzle here for performance reasons: https://jsperf.com/getall-vs-sizzle/2
          destElements = getAll(clone);
          srcElements = getAll(elem);

          for (i = 0, l = srcElements.length; i < l; i++) {
            fixInput(srcElements[i], destElements[i]);
          }
        } // Copy the events from the original to the clone


        if (dataAndEvents) {
          if (deepDataAndEvents) {
            srcElements = srcElements || getAll(elem);
            destElements = destElements || getAll(clone);

            for (i = 0, l = srcElements.length; i < l; i++) {
              cloneCopyEvent(srcElements[i], destElements[i]);
            }
          } else {
            cloneCopyEvent(elem, clone);
          }
        } // Preserve script evaluation history


        destElements = getAll(clone, "script");

        if (destElements.length > 0) {
          setGlobalEval(destElements, !inPage && getAll(elem, "script"));
        } // Return the cloned set


        return clone;
      },
      cleanData: function (elems) {
        var data,
            elem,
            type,
            special = jQuery.event.special,
            i = 0;

        for (; (elem = elems[i]) !== undefined; i++) {
          if (acceptData(elem)) {
            if (data = elem[dataPriv.expando]) {
              if (data.events) {
                for (type in data.events) {
                  if (special[type]) {
                    jQuery.event.remove(elem, type); // This is a shortcut to avoid jQuery.event.remove's overhead
                  } else {
                    jQuery.removeEvent(elem, type, data.handle);
                  }
                }
              } // Support: Chrome <=35 - 45+
              // Assign undefined instead of using delete, see Data#remove


              elem[dataPriv.expando] = undefined;
            }

            if (elem[dataUser.expando]) {
              // Support: Chrome <=35 - 45+
              // Assign undefined instead of using delete, see Data#remove
              elem[dataUser.expando] = undefined;
            }
          }
        }
      }
    });
    jQuery.fn.extend({
      detach: function (selector) {
        return remove(this, selector, true);
      },
      remove: function (selector) {
        return remove(this, selector);
      },
      text: function (value) {
        return access(this, function (value) {
          return value === undefined ? jQuery.text(this) : this.empty().each(function () {
            if (this.nodeType === 1 || this.nodeType === 11 || this.nodeType === 9) {
              this.textContent = value;
            }
          });
        }, null, value, arguments.length);
      },
      append: function () {
        return domManip(this, arguments, function (elem) {
          if (this.nodeType === 1 || this.nodeType === 11 || this.nodeType === 9) {
            var target = manipulationTarget(this, elem);
            target.appendChild(elem);
          }
        });
      },
      prepend: function () {
        return domManip(this, arguments, function (elem) {
          if (this.nodeType === 1 || this.nodeType === 11 || this.nodeType === 9) {
            var target = manipulationTarget(this, elem);
            target.insertBefore(elem, target.firstChild);
          }
        });
      },
      before: function () {
        return domManip(this, arguments, function (elem) {
          if (this.parentNode) {
            this.parentNode.insertBefore(elem, this);
          }
        });
      },
      after: function () {
        return domManip(this, arguments, function (elem) {
          if (this.parentNode) {
            this.parentNode.insertBefore(elem, this.nextSibling);
          }
        });
      },
      empty: function () {
        var elem,
            i = 0;

        for (; (elem = this[i]) != null; i++) {
          if (elem.nodeType === 1) {
            // Prevent memory leaks
            jQuery.cleanData(getAll(elem, false)); // Remove any remaining nodes

            elem.textContent = "";
          }
        }

        return this;
      },
      clone: function (dataAndEvents, deepDataAndEvents) {
        dataAndEvents = dataAndEvents == null ? false : dataAndEvents;
        deepDataAndEvents = deepDataAndEvents == null ? dataAndEvents : deepDataAndEvents;
        return this.map(function () {
          return jQuery.clone(this, dataAndEvents, deepDataAndEvents);
        });
      },
      html: function (value) {
        return access(this, function (value) {
          var elem = this[0] || {},
              i = 0,
              l = this.length;

          if (value === undefined && elem.nodeType === 1) {
            return elem.innerHTML;
          } // See if we can take a shortcut and just use innerHTML


          if (typeof value === "string" && !rnoInnerhtml.test(value) && !wrapMap[(rtagName.exec(value) || ["", ""])[1].toLowerCase()]) {
            value = jQuery.htmlPrefilter(value);

            try {
              for (; i < l; i++) {
                elem = this[i] || {}; // Remove element nodes and prevent memory leaks

                if (elem.nodeType === 1) {
                  jQuery.cleanData(getAll(elem, false));
                  elem.innerHTML = value;
                }
              }

              elem = 0; // If using innerHTML throws an exception, use the fallback method
            } catch (e) {}
          }

          if (elem) {
            this.empty().append(value);
          }
        }, null, value, arguments.length);
      },
      replaceWith: function () {
        var ignored = []; // Make the changes, replacing each non-ignored context element with the new content

        return domManip(this, arguments, function (elem) {
          var parent = this.parentNode;

          if (jQuery.inArray(this, ignored) < 0) {
            jQuery.cleanData(getAll(this));

            if (parent) {
              parent.replaceChild(elem, this);
            }
          } // Force callback invocation

        }, ignored);
      }
    });
    jQuery.each({
      appendTo: "append",
      prependTo: "prepend",
      insertBefore: "before",
      insertAfter: "after",
      replaceAll: "replaceWith"
    }, function (name, original) {
      jQuery.fn[name] = function (selector) {
        var elems,
            ret = [],
            insert = jQuery(selector),
            last = insert.length - 1,
            i = 0;

        for (; i <= last; i++) {
          elems = i === last ? this : this.clone(true);
          jQuery(insert[i])[original](elems); // Support: Android <=4.0 only, PhantomJS 1 only
          // .get() because push.apply(_, arraylike) throws on ancient WebKit

          push.apply(ret, elems.get());
        }

        return this.pushStack(ret);
      };
    });
    var rnumnonpx = new RegExp("^(" + pnum + ")(?!px)[a-z%]+$", "i");

    var getStyles = function (elem) {
      // Support: IE <=11 only, Firefox <=30 (#15098, #14150)
      // IE throws on elements created in popups
      // FF meanwhile throws on frame elements through "defaultView.getComputedStyle"
      var view = elem.ownerDocument.defaultView;

      if (!view || !view.opener) {
        view = window;
      }

      return view.getComputedStyle(elem);
    };

    var swap = function (elem, options, callback) {
      var ret,
          name,
          old = {}; // Remember the old values, and insert the new ones

      for (name in options) {
        old[name] = elem.style[name];
        elem.style[name] = options[name];
      }

      ret = callback.call(elem); // Revert the old values

      for (name in options) {
        elem.style[name] = old[name];
      }

      return ret;
    };

    var rboxStyle = new RegExp(cssExpand.join("|"), "i");

    (function () {
      // Executing both pixelPosition & boxSizingReliable tests require only one layout
      // so they're executed at the same time to save the second computation.
      function computeStyleTests() {
        // This is a singleton, we need to execute it only once
        if (!div) {
          return;
        }

        container.style.cssText = "position:absolute;left:-11111px;width:60px;" + "margin-top:1px;padding:0;border:0";
        div.style.cssText = "position:relative;display:block;box-sizing:border-box;overflow:scroll;" + "margin:auto;border:1px;padding:1px;" + "width:60%;top:1%";
        documentElement.appendChild(container).appendChild(div);
        var divStyle = window.getComputedStyle(div);
        pixelPositionVal = divStyle.top !== "1%"; // Support: Android 4.0 - 4.3 only, Firefox <=3 - 44

        reliableMarginLeftVal = roundPixelMeasures(divStyle.marginLeft) === 12; // Support: Android 4.0 - 4.3 only, Safari <=9.1 - 10.1, iOS <=7.0 - 9.3
        // Some styles come back with percentage values, even though they shouldn't

        div.style.right = "60%";
        pixelBoxStylesVal = roundPixelMeasures(divStyle.right) === 36; // Support: IE 9 - 11 only
        // Detect misreporting of content dimensions for box-sizing:border-box elements

        boxSizingReliableVal = roundPixelMeasures(divStyle.width) === 36; // Support: IE 9 only
        // Detect overflow:scroll screwiness (gh-3699)
        // Support: Chrome <=64
        // Don't get tricked when zoom affects offsetWidth (gh-4029)

        div.style.position = "absolute";
        scrollboxSizeVal = roundPixelMeasures(div.offsetWidth / 3) === 12;
        documentElement.removeChild(container); // Nullify the div so it wouldn't be stored in the memory and
        // it will also be a sign that checks already performed

        div = null;
      }

      function roundPixelMeasures(measure) {
        return Math.round(parseFloat(measure));
      }

      var pixelPositionVal,
          boxSizingReliableVal,
          scrollboxSizeVal,
          pixelBoxStylesVal,
          reliableTrDimensionsVal,
          reliableMarginLeftVal,
          container = document.createElement("div"),
          div = document.createElement("div"); // Finish early in limited (non-browser) environments

      if (!div.style) {
        return;
      } // Support: IE <=9 - 11 only
      // Style of cloned element affects source element cloned (#8908)


      div.style.backgroundClip = "content-box";
      div.cloneNode(true).style.backgroundClip = "";
      support.clearCloneStyle = div.style.backgroundClip === "content-box";
      jQuery.extend(support, {
        boxSizingReliable: function () {
          computeStyleTests();
          return boxSizingReliableVal;
        },
        pixelBoxStyles: function () {
          computeStyleTests();
          return pixelBoxStylesVal;
        },
        pixelPosition: function () {
          computeStyleTests();
          return pixelPositionVal;
        },
        reliableMarginLeft: function () {
          computeStyleTests();
          return reliableMarginLeftVal;
        },
        scrollboxSize: function () {
          computeStyleTests();
          return scrollboxSizeVal;
        },
        // Support: IE 9 - 11+, Edge 15 - 18+
        // IE/Edge misreport `getComputedStyle` of table rows with width/height
        // set in CSS while `offset*` properties report correct values.
        // Behavior in IE 9 is more subtle than in newer versions & it passes
        // some versions of this test; make sure not to make it pass there!
        //
        // Support: Firefox 70+
        // Only Firefox includes border widths
        // in computed dimensions. (gh-4529)
        reliableTrDimensions: function () {
          var table, tr, trChild, trStyle;

          if (reliableTrDimensionsVal == null) {
            table = document.createElement("table");
            tr = document.createElement("tr");
            trChild = document.createElement("div");
            table.style.cssText = "position:absolute;left:-11111px;border-collapse:separate";
            tr.style.cssText = "border:1px solid"; // Support: Chrome 86+
            // Height set through cssText does not get applied.
            // Computed height then comes back as 0.

            tr.style.height = "1px";
            trChild.style.height = "9px"; // Support: Android 8 Chrome 86+
            // In our bodyBackground.html iframe,
            // display for all div elements is set to "inline",
            // which causes a problem only in Android 8 Chrome 86.
            // Ensuring the div is display: block
            // gets around this issue.

            trChild.style.display = "block";
            documentElement.appendChild(table).appendChild(tr).appendChild(trChild);
            trStyle = window.getComputedStyle(tr);
            reliableTrDimensionsVal = parseInt(trStyle.height, 10) + parseInt(trStyle.borderTopWidth, 10) + parseInt(trStyle.borderBottomWidth, 10) === tr.offsetHeight;
            documentElement.removeChild(table);
          }

          return reliableTrDimensionsVal;
        }
      });
    })();

    function curCSS(elem, name, computed) {
      var width,
          minWidth,
          maxWidth,
          ret,
          // Support: Firefox 51+
      // Retrieving style before computed somehow
      // fixes an issue with getting wrong values
      // on detached elements
      style = elem.style;
      computed = computed || getStyles(elem); // getPropertyValue is needed for:
      //   .css('filter') (IE 9 only, #12537)
      //   .css('--customProperty) (#3144)

      if (computed) {
        ret = computed.getPropertyValue(name) || computed[name];

        if (ret === "" && !isAttached(elem)) {
          ret = jQuery.style(elem, name);
        } // A tribute to the "awesome hack by Dean Edwards"
        // Android Browser returns percentage for some values,
        // but width seems to be reliably pixels.
        // This is against the CSSOM draft spec:
        // https://drafts.csswg.org/cssom/#resolved-values


        if (!support.pixelBoxStyles() && rnumnonpx.test(ret) && rboxStyle.test(name)) {
          // Remember the original values
          width = style.width;
          minWidth = style.minWidth;
          maxWidth = style.maxWidth; // Put in the new values to get a computed value out

          style.minWidth = style.maxWidth = style.width = ret;
          ret = computed.width; // Revert the changed values

          style.width = width;
          style.minWidth = minWidth;
          style.maxWidth = maxWidth;
        }
      }

      return ret !== undefined ? // Support: IE <=9 - 11 only
      // IE returns zIndex value as an integer.
      ret + "" : ret;
    }

    function addGetHookIf(conditionFn, hookFn) {
      // Define the hook, we'll check on the first run if it's really needed.
      return {
        get: function () {
          if (conditionFn()) {
            // Hook not needed (or it's not possible to use it due
            // to missing dependency), remove it.
            delete this.get;
            return;
          } // Hook needed; redefine it so that the support test is not executed again.


          return (this.get = hookFn).apply(this, arguments);
        }
      };
    }

    var cssPrefixes = ["Webkit", "Moz", "ms"],
        emptyStyle = document.createElement("div").style,
        vendorProps = {}; // Return a vendor-prefixed property or undefined

    function vendorPropName(name) {
      // Check for vendor prefixed names
      var capName = name[0].toUpperCase() + name.slice(1),
          i = cssPrefixes.length;

      while (i--) {
        name = cssPrefixes[i] + capName;

        if (name in emptyStyle) {
          return name;
        }
      }
    } // Return a potentially-mapped jQuery.cssProps or vendor prefixed property


    function finalPropName(name) {
      var final = jQuery.cssProps[name] || vendorProps[name];

      if (final) {
        return final;
      }

      if (name in emptyStyle) {
        return name;
      }

      return vendorProps[name] = vendorPropName(name) || name;
    }

    var // Swappable if display is none or starts with table
    // except "table", "table-cell", or "table-caption"
    // See here for display values: https://developer.mozilla.org/en-US/docs/CSS/display
    rdisplayswap = /^(none|table(?!-c[ea]).+)/,
        rcustomProp = /^--/,
        cssShow = {
      position: "absolute",
      visibility: "hidden",
      display: "block"
    },
        cssNormalTransform = {
      letterSpacing: "0",
      fontWeight: "400"
    };

    function setPositiveNumber(_elem, value, subtract) {
      // Any relative (+/-) values have already been
      // normalized at this point
      var matches = rcssNum.exec(value);
      return matches ? // Guard against undefined "subtract", e.g., when used as in cssHooks
      Math.max(0, matches[2] - (subtract || 0)) + (matches[3] || "px") : value;
    }

    function boxModelAdjustment(elem, dimension, box, isBorderBox, styles, computedVal) {
      var i = dimension === "width" ? 1 : 0,
          extra = 0,
          delta = 0; // Adjustment may not be necessary

      if (box === (isBorderBox ? "border" : "content")) {
        return 0;
      }

      for (; i < 4; i += 2) {
        // Both box models exclude margin
        if (box === "margin") {
          delta += jQuery.css(elem, box + cssExpand[i], true, styles);
        } // If we get here with a content-box, we're seeking "padding" or "border" or "margin"


        if (!isBorderBox) {
          // Add padding
          delta += jQuery.css(elem, "padding" + cssExpand[i], true, styles); // For "border" or "margin", add border

          if (box !== "padding") {
            delta += jQuery.css(elem, "border" + cssExpand[i] + "Width", true, styles); // But still keep track of it otherwise
          } else {
            extra += jQuery.css(elem, "border" + cssExpand[i] + "Width", true, styles);
          } // If we get here with a border-box (content + padding + border), we're seeking "content" or
          // "padding" or "margin"

        } else {
          // For "content", subtract padding
          if (box === "content") {
            delta -= jQuery.css(elem, "padding" + cssExpand[i], true, styles);
          } // For "content" or "padding", subtract border


          if (box !== "margin") {
            delta -= jQuery.css(elem, "border" + cssExpand[i] + "Width", true, styles);
          }
        }
      } // Account for positive content-box scroll gutter when requested by providing computedVal


      if (!isBorderBox && computedVal >= 0) {
        // offsetWidth/offsetHeight is a rounded sum of content, padding, scroll gutter, and border
        // Assuming integer scroll gutter, subtract the rest and round down
        delta += Math.max(0, Math.ceil(elem["offset" + dimension[0].toUpperCase() + dimension.slice(1)] - computedVal - delta - extra - 0.5 // If offsetWidth/offsetHeight is unknown, then we can't determine content-box scroll gutter
        // Use an explicit zero to avoid NaN (gh-3964)
        )) || 0;
      }

      return delta;
    }

    function getWidthOrHeight(elem, dimension, extra) {
      // Start with computed style
      var styles = getStyles(elem),
          // To avoid forcing a reflow, only fetch boxSizing if we need it (gh-4322).
      // Fake content-box until we know it's needed to know the true value.
      boxSizingNeeded = !support.boxSizingReliable() || extra,
          isBorderBox = boxSizingNeeded && jQuery.css(elem, "boxSizing", false, styles) === "border-box",
          valueIsBorderBox = isBorderBox,
          val = curCSS(elem, dimension, styles),
          offsetProp = "offset" + dimension[0].toUpperCase() + dimension.slice(1); // Support: Firefox <=54
      // Return a confounding non-pixel value or feign ignorance, as appropriate.

      if (rnumnonpx.test(val)) {
        if (!extra) {
          return val;
        }

        val = "auto";
      } // Support: IE 9 - 11 only
      // Use offsetWidth/offsetHeight for when box sizing is unreliable.
      // In those cases, the computed value can be trusted to be border-box.


      if ((!support.boxSizingReliable() && isBorderBox || // Support: IE 10 - 11+, Edge 15 - 18+
      // IE/Edge misreport `getComputedStyle` of table rows with width/height
      // set in CSS while `offset*` properties report correct values.
      // Interestingly, in some cases IE 9 doesn't suffer from this issue.
      !support.reliableTrDimensions() && nodeName(elem, "tr") || // Fall back to offsetWidth/offsetHeight when value is "auto"
      // This happens for inline elements with no explicit setting (gh-3571)
      val === "auto" || // Support: Android <=4.1 - 4.3 only
      // Also use offsetWidth/offsetHeight for misreported inline dimensions (gh-3602)
      !parseFloat(val) && jQuery.css(elem, "display", false, styles) === "inline") && // Make sure the element is visible & connected
      elem.getClientRects().length) {
        isBorderBox = jQuery.css(elem, "boxSizing", false, styles) === "border-box"; // Where available, offsetWidth/offsetHeight approximate border box dimensions.
        // Where not available (e.g., SVG), assume unreliable box-sizing and interpret the
        // retrieved value as a content box dimension.

        valueIsBorderBox = offsetProp in elem;

        if (valueIsBorderBox) {
          val = elem[offsetProp];
        }
      } // Normalize "" and auto


      val = parseFloat(val) || 0; // Adjust for the element's box model

      return val + boxModelAdjustment(elem, dimension, extra || (isBorderBox ? "border" : "content"), valueIsBorderBox, styles, // Provide the current computed size to request scroll gutter calculation (gh-3589)
      val) + "px";
    }

    jQuery.extend({
      // Add in style property hooks for overriding the default
      // behavior of getting and setting a style property
      cssHooks: {
        opacity: {
          get: function (elem, computed) {
            if (computed) {
              // We should always get a number back from opacity
              var ret = curCSS(elem, "opacity");
              return ret === "" ? "1" : ret;
            }
          }
        }
      },
      // Don't automatically add "px" to these possibly-unitless properties
      cssNumber: {
        "animationIterationCount": true,
        "columnCount": true,
        "fillOpacity": true,
        "flexGrow": true,
        "flexShrink": true,
        "fontWeight": true,
        "gridArea": true,
        "gridColumn": true,
        "gridColumnEnd": true,
        "gridColumnStart": true,
        "gridRow": true,
        "gridRowEnd": true,
        "gridRowStart": true,
        "lineHeight": true,
        "opacity": true,
        "order": true,
        "orphans": true,
        "widows": true,
        "zIndex": true,
        "zoom": true
      },
      // Add in properties whose names you wish to fix before
      // setting or getting the value
      cssProps: {},
      // Get and set the style property on a DOM Node
      style: function (elem, name, value, extra) {
        // Don't set styles on text and comment nodes
        if (!elem || elem.nodeType === 3 || elem.nodeType === 8 || !elem.style) {
          return;
        } // Make sure that we're working with the right name


        var ret,
            type,
            hooks,
            origName = camelCase(name),
            isCustomProp = rcustomProp.test(name),
            style = elem.style; // Make sure that we're working with the right name. We don't
        // want to query the value if it is a CSS custom property
        // since they are user-defined.

        if (!isCustomProp) {
          name = finalPropName(origName);
        } // Gets hook for the prefixed version, then unprefixed version


        hooks = jQuery.cssHooks[name] || jQuery.cssHooks[origName]; // Check if we're setting a value

        if (value !== undefined) {
          type = typeof value; // Convert "+=" or "-=" to relative numbers (#7345)

          if (type === "string" && (ret = rcssNum.exec(value)) && ret[1]) {
            value = adjustCSS(elem, name, ret); // Fixes bug #9237

            type = "number";
          } // Make sure that null and NaN values aren't set (#7116)


          if (value == null || value !== value) {
            return;
          } // If a number was passed in, add the unit (except for certain CSS properties)
          // The isCustomProp check can be removed in jQuery 4.0 when we only auto-append
          // "px" to a few hardcoded values.


          if (type === "number" && !isCustomProp) {
            value += ret && ret[3] || (jQuery.cssNumber[origName] ? "" : "px");
          } // background-* props affect original clone's values


          if (!support.clearCloneStyle && value === "" && name.indexOf("background") === 0) {
            style[name] = "inherit";
          } // If a hook was provided, use that value, otherwise just set the specified value


          if (!hooks || !("set" in hooks) || (value = hooks.set(elem, value, extra)) !== undefined) {
            if (isCustomProp) {
              style.setProperty(name, value);
            } else {
              style[name] = value;
            }
          }
        } else {
          // If a hook was provided get the non-computed value from there
          if (hooks && "get" in hooks && (ret = hooks.get(elem, false, extra)) !== undefined) {
            return ret;
          } // Otherwise just get the value from the style object


          return style[name];
        }
      },
      css: function (elem, name, extra, styles) {
        var val,
            num,
            hooks,
            origName = camelCase(name),
            isCustomProp = rcustomProp.test(name); // Make sure that we're working with the right name. We don't
        // want to modify the value if it is a CSS custom property
        // since they are user-defined.

        if (!isCustomProp) {
          name = finalPropName(origName);
        } // Try prefixed name followed by the unprefixed name


        hooks = jQuery.cssHooks[name] || jQuery.cssHooks[origName]; // If a hook was provided get the computed value from there

        if (hooks && "get" in hooks) {
          val = hooks.get(elem, true, extra);
        } // Otherwise, if a way to get the computed value exists, use that


        if (val === undefined) {
          val = curCSS(elem, name, styles);
        } // Convert "normal" to computed value


        if (val === "normal" && name in cssNormalTransform) {
          val = cssNormalTransform[name];
        } // Make numeric if forced or a qualifier was provided and val looks numeric


        if (extra === "" || extra) {
          num = parseFloat(val);
          return extra === true || isFinite(num) ? num || 0 : val;
        }

        return val;
      }
    });
    jQuery.each(["height", "width"], function (_i, dimension) {
      jQuery.cssHooks[dimension] = {
        get: function (elem, computed, extra) {
          if (computed) {
            // Certain elements can have dimension info if we invisibly show them
            // but it must have a current display style that would benefit
            return rdisplayswap.test(jQuery.css(elem, "display")) && ( // Support: Safari 8+
            // Table columns in Safari have non-zero offsetWidth & zero
            // getBoundingClientRect().width unless display is changed.
            // Support: IE <=11 only
            // Running getBoundingClientRect on a disconnected node
            // in IE throws an error.
            !elem.getClientRects().length || !elem.getBoundingClientRect().width) ? swap(elem, cssShow, function () {
              return getWidthOrHeight(elem, dimension, extra);
            }) : getWidthOrHeight(elem, dimension, extra);
          }
        },
        set: function (elem, value, extra) {
          var matches,
              styles = getStyles(elem),
              // Only read styles.position if the test has a chance to fail
          // to avoid forcing a reflow.
          scrollboxSizeBuggy = !support.scrollboxSize() && styles.position === "absolute",
              // To avoid forcing a reflow, only fetch boxSizing if we need it (gh-3991)
          boxSizingNeeded = scrollboxSizeBuggy || extra,
              isBorderBox = boxSizingNeeded && jQuery.css(elem, "boxSizing", false, styles) === "border-box",
              subtract = extra ? boxModelAdjustment(elem, dimension, extra, isBorderBox, styles) : 0; // Account for unreliable border-box dimensions by comparing offset* to computed and
          // faking a content-box to get border and padding (gh-3699)

          if (isBorderBox && scrollboxSizeBuggy) {
            subtract -= Math.ceil(elem["offset" + dimension[0].toUpperCase() + dimension.slice(1)] - parseFloat(styles[dimension]) - boxModelAdjustment(elem, dimension, "border", false, styles) - 0.5);
          } // Convert to pixels if value adjustment is needed


          if (subtract && (matches = rcssNum.exec(value)) && (matches[3] || "px") !== "px") {
            elem.style[dimension] = value;
            value = jQuery.css(elem, dimension);
          }

          return setPositiveNumber(elem, value, subtract);
        }
      };
    });
    jQuery.cssHooks.marginLeft = addGetHookIf(support.reliableMarginLeft, function (elem, computed) {
      if (computed) {
        return (parseFloat(curCSS(elem, "marginLeft")) || elem.getBoundingClientRect().left - swap(elem, {
          marginLeft: 0
        }, function () {
          return elem.getBoundingClientRect().left;
        })) + "px";
      }
    }); // These hooks are used by animate to expand properties

    jQuery.each({
      margin: "",
      padding: "",
      border: "Width"
    }, function (prefix, suffix) {
      jQuery.cssHooks[prefix + suffix] = {
        expand: function (value) {
          var i = 0,
              expanded = {},
              // Assumes a single number if not a string
          parts = typeof value === "string" ? value.split(" ") : [value];

          for (; i < 4; i++) {
            expanded[prefix + cssExpand[i] + suffix] = parts[i] || parts[i - 2] || parts[0];
          }

          return expanded;
        }
      };

      if (prefix !== "margin") {
        jQuery.cssHooks[prefix + suffix].set = setPositiveNumber;
      }
    });
    jQuery.fn.extend({
      css: function (name, value) {
        return access(this, function (elem, name, value) {
          var styles,
              len,
              map = {},
              i = 0;

          if (Array.isArray(name)) {
            styles = getStyles(elem);
            len = name.length;

            for (; i < len; i++) {
              map[name[i]] = jQuery.css(elem, name[i], false, styles);
            }

            return map;
          }

          return value !== undefined ? jQuery.style(elem, name, value) : jQuery.css(elem, name);
        }, name, value, arguments.length > 1);
      }
    });

    function Tween(elem, options, prop, end, easing) {
      return new Tween.prototype.init(elem, options, prop, end, easing);
    }

    jQuery.Tween = Tween;
    Tween.prototype = {
      constructor: Tween,
      init: function (elem, options, prop, end, easing, unit) {
        this.elem = elem;
        this.prop = prop;
        this.easing = easing || jQuery.easing._default;
        this.options = options;
        this.start = this.now = this.cur();
        this.end = end;
        this.unit = unit || (jQuery.cssNumber[prop] ? "" : "px");
      },
      cur: function () {
        var hooks = Tween.propHooks[this.prop];
        return hooks && hooks.get ? hooks.get(this) : Tween.propHooks._default.get(this);
      },
      run: function (percent) {
        var eased,
            hooks = Tween.propHooks[this.prop];

        if (this.options.duration) {
          this.pos = eased = jQuery.easing[this.easing](percent, this.options.duration * percent, 0, 1, this.options.duration);
        } else {
          this.pos = eased = percent;
        }

        this.now = (this.end - this.start) * eased + this.start;

        if (this.options.step) {
          this.options.step.call(this.elem, this.now, this);
        }

        if (hooks && hooks.set) {
          hooks.set(this);
        } else {
          Tween.propHooks._default.set(this);
        }

        return this;
      }
    };
    Tween.prototype.init.prototype = Tween.prototype;
    Tween.propHooks = {
      _default: {
        get: function (tween) {
          var result; // Use a property on the element directly when it is not a DOM element,
          // or when there is no matching style property that exists.

          if (tween.elem.nodeType !== 1 || tween.elem[tween.prop] != null && tween.elem.style[tween.prop] == null) {
            return tween.elem[tween.prop];
          } // Passing an empty string as a 3rd parameter to .css will automatically
          // attempt a parseFloat and fallback to a string if the parse fails.
          // Simple values such as "10px" are parsed to Float;
          // complex values such as "rotate(1rad)" are returned as-is.


          result = jQuery.css(tween.elem, tween.prop, ""); // Empty strings, null, undefined and "auto" are converted to 0.

          return !result || result === "auto" ? 0 : result;
        },
        set: function (tween) {
          // Use step hook for back compat.
          // Use cssHook if its there.
          // Use .style if available and use plain properties where available.
          if (jQuery.fx.step[tween.prop]) {
            jQuery.fx.step[tween.prop](tween);
          } else if (tween.elem.nodeType === 1 && (jQuery.cssHooks[tween.prop] || tween.elem.style[finalPropName(tween.prop)] != null)) {
            jQuery.style(tween.elem, tween.prop, tween.now + tween.unit);
          } else {
            tween.elem[tween.prop] = tween.now;
          }
        }
      }
    }; // Support: IE <=9 only
    // Panic based approach to setting things on disconnected nodes

    Tween.propHooks.scrollTop = Tween.propHooks.scrollLeft = {
      set: function (tween) {
        if (tween.elem.nodeType && tween.elem.parentNode) {
          tween.elem[tween.prop] = tween.now;
        }
      }
    };
    jQuery.easing = {
      linear: function (p) {
        return p;
      },
      swing: function (p) {
        return 0.5 - Math.cos(p * Math.PI) / 2;
      },
      _default: "swing"
    };
    jQuery.fx = Tween.prototype.init; // Back compat <1.8 extension point

    jQuery.fx.step = {};
    var fxNow,
        inProgress,
        rfxtypes = /^(?:toggle|show|hide)$/,
        rrun = /queueHooks$/;

    function schedule() {
      if (inProgress) {
        if (document.hidden === false && window.requestAnimationFrame) {
          window.requestAnimationFrame(schedule);
        } else {
          window.setTimeout(schedule, jQuery.fx.interval);
        }

        jQuery.fx.tick();
      }
    } // Animations created synchronously will run synchronously


    function createFxNow() {
      window.setTimeout(function () {
        fxNow = undefined;
      });
      return fxNow = Date.now();
    } // Generate parameters to create a standard animation


    function genFx(type, includeWidth) {
      var which,
          i = 0,
          attrs = {
        height: type
      }; // If we include width, step value is 1 to do all cssExpand values,
      // otherwise step value is 2 to skip over Left and Right

      includeWidth = includeWidth ? 1 : 0;

      for (; i < 4; i += 2 - includeWidth) {
        which = cssExpand[i];
        attrs["margin" + which] = attrs["padding" + which] = type;
      }

      if (includeWidth) {
        attrs.opacity = attrs.width = type;
      }

      return attrs;
    }

    function createTween(value, prop, animation) {
      var tween,
          collection = (Animation.tweeners[prop] || []).concat(Animation.tweeners["*"]),
          index = 0,
          length = collection.length;

      for (; index < length; index++) {
        if (tween = collection[index].call(animation, prop, value)) {
          // We're done with this property
          return tween;
        }
      }
    }

    function defaultPrefilter(elem, props, opts) {
      var prop,
          value,
          toggle,
          hooks,
          oldfire,
          propTween,
          restoreDisplay,
          display,
          isBox = "width" in props || "height" in props,
          anim = this,
          orig = {},
          style = elem.style,
          hidden = elem.nodeType && isHiddenWithinTree(elem),
          dataShow = dataPriv.get(elem, "fxshow"); // Queue-skipping animations hijack the fx hooks

      if (!opts.queue) {
        hooks = jQuery._queueHooks(elem, "fx");

        if (hooks.unqueued == null) {
          hooks.unqueued = 0;
          oldfire = hooks.empty.fire;

          hooks.empty.fire = function () {
            if (!hooks.unqueued) {
              oldfire();
            }
          };
        }

        hooks.unqueued++;
        anim.always(function () {
          // Ensure the complete handler is called before this completes
          anim.always(function () {
            hooks.unqueued--;

            if (!jQuery.queue(elem, "fx").length) {
              hooks.empty.fire();
            }
          });
        });
      } // Detect show/hide animations


      for (prop in props) {
        value = props[prop];

        if (rfxtypes.test(value)) {
          delete props[prop];
          toggle = toggle || value === "toggle";

          if (value === (hidden ? "hide" : "show")) {
            // Pretend to be hidden if this is a "show" and
            // there is still data from a stopped show/hide
            if (value === "show" && dataShow && dataShow[prop] !== undefined) {
              hidden = true; // Ignore all other no-op show/hide data
            } else {
              continue;
            }
          }

          orig[prop] = dataShow && dataShow[prop] || jQuery.style(elem, prop);
        }
      } // Bail out if this is a no-op like .hide().hide()


      propTween = !jQuery.isEmptyObject(props);

      if (!propTween && jQuery.isEmptyObject(orig)) {
        return;
      } // Restrict "overflow" and "display" styles during box animations


      if (isBox && elem.nodeType === 1) {
        // Support: IE <=9 - 11, Edge 12 - 15
        // Record all 3 overflow attributes because IE does not infer the shorthand
        // from identically-valued overflowX and overflowY and Edge just mirrors
        // the overflowX value there.
        opts.overflow = [style.overflow, style.overflowX, style.overflowY]; // Identify a display type, preferring old show/hide data over the CSS cascade

        restoreDisplay = dataShow && dataShow.display;

        if (restoreDisplay == null) {
          restoreDisplay = dataPriv.get(elem, "display");
        }

        display = jQuery.css(elem, "display");

        if (display === "none") {
          if (restoreDisplay) {
            display = restoreDisplay;
          } else {
            // Get nonempty value(s) by temporarily forcing visibility
            showHide([elem], true);
            restoreDisplay = elem.style.display || restoreDisplay;
            display = jQuery.css(elem, "display");
            showHide([elem]);
          }
        } // Animate inline elements as inline-block


        if (display === "inline" || display === "inline-block" && restoreDisplay != null) {
          if (jQuery.css(elem, "float") === "none") {
            // Restore the original display value at the end of pure show/hide animations
            if (!propTween) {
              anim.done(function () {
                style.display = restoreDisplay;
              });

              if (restoreDisplay == null) {
                display = style.display;
                restoreDisplay = display === "none" ? "" : display;
              }
            }

            style.display = "inline-block";
          }
        }
      }

      if (opts.overflow) {
        style.overflow = "hidden";
        anim.always(function () {
          style.overflow = opts.overflow[0];
          style.overflowX = opts.overflow[1];
          style.overflowY = opts.overflow[2];
        });
      } // Implement show/hide animations


      propTween = false;

      for (prop in orig) {
        // General show/hide setup for this element animation
        if (!propTween) {
          if (dataShow) {
            if ("hidden" in dataShow) {
              hidden = dataShow.hidden;
            }
          } else {
            dataShow = dataPriv.access(elem, "fxshow", {
              display: restoreDisplay
            });
          } // Store hidden/visible for toggle so `.stop().toggle()` "reverses"


          if (toggle) {
            dataShow.hidden = !hidden;
          } // Show elements before animating them


          if (hidden) {
            showHide([elem], true);
          }
          /* eslint-disable no-loop-func */


          anim.done(function () {
            /* eslint-enable no-loop-func */
            // The final step of a "hide" animation is actually hiding the element
            if (!hidden) {
              showHide([elem]);
            }

            dataPriv.remove(elem, "fxshow");

            for (prop in orig) {
              jQuery.style(elem, prop, orig[prop]);
            }
          });
        } // Per-property setup


        propTween = createTween(hidden ? dataShow[prop] : 0, prop, anim);

        if (!(prop in dataShow)) {
          dataShow[prop] = propTween.start;

          if (hidden) {
            propTween.end = propTween.start;
            propTween.start = 0;
          }
        }
      }
    }

    function propFilter(props, specialEasing) {
      var index, name, easing, value, hooks; // camelCase, specialEasing and expand cssHook pass

      for (index in props) {
        name = camelCase(index);
        easing = specialEasing[name];
        value = props[index];

        if (Array.isArray(value)) {
          easing = value[1];
          value = props[index] = value[0];
        }

        if (index !== name) {
          props[name] = value;
          delete props[index];
        }

        hooks = jQuery.cssHooks[name];

        if (hooks && "expand" in hooks) {
          value = hooks.expand(value);
          delete props[name]; // Not quite $.extend, this won't overwrite existing keys.
          // Reusing 'index' because we have the correct "name"

          for (index in value) {
            if (!(index in props)) {
              props[index] = value[index];
              specialEasing[index] = easing;
            }
          }
        } else {
          specialEasing[name] = easing;
        }
      }
    }

    function Animation(elem, properties, options) {
      var result,
          stopped,
          index = 0,
          length = Animation.prefilters.length,
          deferred = jQuery.Deferred().always(function () {
        // Don't match elem in the :animated selector
        delete tick.elem;
      }),
          tick = function () {
        if (stopped) {
          return false;
        }

        var currentTime = fxNow || createFxNow(),
            remaining = Math.max(0, animation.startTime + animation.duration - currentTime),
            // Support: Android 2.3 only
        // Archaic crash bug won't allow us to use `1 - ( 0.5 || 0 )` (#12497)
        temp = remaining / animation.duration || 0,
            percent = 1 - temp,
            index = 0,
            length = animation.tweens.length;

        for (; index < length; index++) {
          animation.tweens[index].run(percent);
        }

        deferred.notifyWith(elem, [animation, percent, remaining]); // If there's more to do, yield

        if (percent < 1 && length) {
          return remaining;
        } // If this was an empty animation, synthesize a final progress notification


        if (!length) {
          deferred.notifyWith(elem, [animation, 1, 0]);
        } // Resolve the animation and report its conclusion


        deferred.resolveWith(elem, [animation]);
        return false;
      },
          animation = deferred.promise({
        elem: elem,
        props: jQuery.extend({}, properties),
        opts: jQuery.extend(true, {
          specialEasing: {},
          easing: jQuery.easing._default
        }, options),
        originalProperties: properties,
        originalOptions: options,
        startTime: fxNow || createFxNow(),
        duration: options.duration,
        tweens: [],
        createTween: function (prop, end) {
          var tween = jQuery.Tween(elem, animation.opts, prop, end, animation.opts.specialEasing[prop] || animation.opts.easing);
          animation.tweens.push(tween);
          return tween;
        },
        stop: function (gotoEnd) {
          var index = 0,
              // If we are going to the end, we want to run all the tweens
          // otherwise we skip this part
          length = gotoEnd ? animation.tweens.length : 0;

          if (stopped) {
            return this;
          }

          stopped = true;

          for (; index < length; index++) {
            animation.tweens[index].run(1);
          } // Resolve when we played the last frame; otherwise, reject


          if (gotoEnd) {
            deferred.notifyWith(elem, [animation, 1, 0]);
            deferred.resolveWith(elem, [animation, gotoEnd]);
          } else {
            deferred.rejectWith(elem, [animation, gotoEnd]);
          }

          return this;
        }
      }),
          props = animation.props;

      propFilter(props, animation.opts.specialEasing);

      for (; index < length; index++) {
        result = Animation.prefilters[index].call(animation, elem, props, animation.opts);

        if (result) {
          if (isFunction(result.stop)) {
            jQuery._queueHooks(animation.elem, animation.opts.queue).stop = result.stop.bind(result);
          }

          return result;
        }
      }

      jQuery.map(props, createTween, animation);

      if (isFunction(animation.opts.start)) {
        animation.opts.start.call(elem, animation);
      } // Attach callbacks from options


      animation.progress(animation.opts.progress).done(animation.opts.done, animation.opts.complete).fail(animation.opts.fail).always(animation.opts.always);
      jQuery.fx.timer(jQuery.extend(tick, {
        elem: elem,
        anim: animation,
        queue: animation.opts.queue
      }));
      return animation;
    }

    jQuery.Animation = jQuery.extend(Animation, {
      tweeners: {
        "*": [function (prop, value) {
          var tween = this.createTween(prop, value);
          adjustCSS(tween.elem, prop, rcssNum.exec(value), tween);
          return tween;
        }]
      },
      tweener: function (props, callback) {
        if (isFunction(props)) {
          callback = props;
          props = ["*"];
        } else {
          props = props.match(rnothtmlwhite);
        }

        var prop,
            index = 0,
            length = props.length;

        for (; index < length; index++) {
          prop = props[index];
          Animation.tweeners[prop] = Animation.tweeners[prop] || [];
          Animation.tweeners[prop].unshift(callback);
        }
      },
      prefilters: [defaultPrefilter],
      prefilter: function (callback, prepend) {
        if (prepend) {
          Animation.prefilters.unshift(callback);
        } else {
          Animation.prefilters.push(callback);
        }
      }
    });

    jQuery.speed = function (speed, easing, fn) {
      var opt = speed && typeof speed === "object" ? jQuery.extend({}, speed) : {
        complete: fn || !fn && easing || isFunction(speed) && speed,
        duration: speed,
        easing: fn && easing || easing && !isFunction(easing) && easing
      }; // Go to the end state if fx are off

      if (jQuery.fx.off) {
        opt.duration = 0;
      } else {
        if (typeof opt.duration !== "number") {
          if (opt.duration in jQuery.fx.speeds) {
            opt.duration = jQuery.fx.speeds[opt.duration];
          } else {
            opt.duration = jQuery.fx.speeds._default;
          }
        }
      } // Normalize opt.queue - true/undefined/null -> "fx"


      if (opt.queue == null || opt.queue === true) {
        opt.queue = "fx";
      } // Queueing


      opt.old = opt.complete;

      opt.complete = function () {
        if (isFunction(opt.old)) {
          opt.old.call(this);
        }

        if (opt.queue) {
          jQuery.dequeue(this, opt.queue);
        }
      };

      return opt;
    };

    jQuery.fn.extend({
      fadeTo: function (speed, to, easing, callback) {
        // Show any hidden elements after setting opacity to 0
        return this.filter(isHiddenWithinTree).css("opacity", 0).show() // Animate to the value specified
        .end().animate({
          opacity: to
        }, speed, easing, callback);
      },
      animate: function (prop, speed, easing, callback) {
        var empty = jQuery.isEmptyObject(prop),
            optall = jQuery.speed(speed, easing, callback),
            doAnimation = function () {
          // Operate on a copy of prop so per-property easing won't be lost
          var anim = Animation(this, jQuery.extend({}, prop), optall); // Empty animations, or finishing resolves immediately

          if (empty || dataPriv.get(this, "finish")) {
            anim.stop(true);
          }
        };

        doAnimation.finish = doAnimation;
        return empty || optall.queue === false ? this.each(doAnimation) : this.queue(optall.queue, doAnimation);
      },
      stop: function (type, clearQueue, gotoEnd) {
        var stopQueue = function (hooks) {
          var stop = hooks.stop;
          delete hooks.stop;
          stop(gotoEnd);
        };

        if (typeof type !== "string") {
          gotoEnd = clearQueue;
          clearQueue = type;
          type = undefined;
        }

        if (clearQueue) {
          this.queue(type || "fx", []);
        }

        return this.each(function () {
          var dequeue = true,
              index = type != null && type + "queueHooks",
              timers = jQuery.timers,
              data = dataPriv.get(this);

          if (index) {
            if (data[index] && data[index].stop) {
              stopQueue(data[index]);
            }
          } else {
            for (index in data) {
              if (data[index] && data[index].stop && rrun.test(index)) {
                stopQueue(data[index]);
              }
            }
          }

          for (index = timers.length; index--;) {
            if (timers[index].elem === this && (type == null || timers[index].queue === type)) {
              timers[index].anim.stop(gotoEnd);
              dequeue = false;
              timers.splice(index, 1);
            }
          } // Start the next in the queue if the last step wasn't forced.
          // Timers currently will call their complete callbacks, which
          // will dequeue but only if they were gotoEnd.


          if (dequeue || !gotoEnd) {
            jQuery.dequeue(this, type);
          }
        });
      },
      finish: function (type) {
        if (type !== false) {
          type = type || "fx";
        }

        return this.each(function () {
          var index,
              data = dataPriv.get(this),
              queue = data[type + "queue"],
              hooks = data[type + "queueHooks"],
              timers = jQuery.timers,
              length = queue ? queue.length : 0; // Enable finishing flag on private data

          data.finish = true; // Empty the queue first

          jQuery.queue(this, type, []);

          if (hooks && hooks.stop) {
            hooks.stop.call(this, true);
          } // Look for any active animations, and finish them


          for (index = timers.length; index--;) {
            if (timers[index].elem === this && timers[index].queue === type) {
              timers[index].anim.stop(true);
              timers.splice(index, 1);
            }
          } // Look for any animations in the old queue and finish them


          for (index = 0; index < length; index++) {
            if (queue[index] && queue[index].finish) {
              queue[index].finish.call(this);
            }
          } // Turn off finishing flag


          delete data.finish;
        });
      }
    });
    jQuery.each(["toggle", "show", "hide"], function (_i, name) {
      var cssFn = jQuery.fn[name];

      jQuery.fn[name] = function (speed, easing, callback) {
        return speed == null || typeof speed === "boolean" ? cssFn.apply(this, arguments) : this.animate(genFx(name, true), speed, easing, callback);
      };
    }); // Generate shortcuts for custom animations

    jQuery.each({
      slideDown: genFx("show"),
      slideUp: genFx("hide"),
      slideToggle: genFx("toggle"),
      fadeIn: {
        opacity: "show"
      },
      fadeOut: {
        opacity: "hide"
      },
      fadeToggle: {
        opacity: "toggle"
      }
    }, function (name, props) {
      jQuery.fn[name] = function (speed, easing, callback) {
        return this.animate(props, speed, easing, callback);
      };
    });
    jQuery.timers = [];

    jQuery.fx.tick = function () {
      var timer,
          i = 0,
          timers = jQuery.timers;
      fxNow = Date.now();

      for (; i < timers.length; i++) {
        timer = timers[i]; // Run the timer and safely remove it when done (allowing for external removal)

        if (!timer() && timers[i] === timer) {
          timers.splice(i--, 1);
        }
      }

      if (!timers.length) {
        jQuery.fx.stop();
      }

      fxNow = undefined;
    };

    jQuery.fx.timer = function (timer) {
      jQuery.timers.push(timer);
      jQuery.fx.start();
    };

    jQuery.fx.interval = 13;

    jQuery.fx.start = function () {
      if (inProgress) {
        return;
      }

      inProgress = true;
      schedule();
    };

    jQuery.fx.stop = function () {
      inProgress = null;
    };

    jQuery.fx.speeds = {
      slow: 600,
      fast: 200,
      // Default speed
      _default: 400
    }; // Based off of the plugin by Clint Helfers, with permission.
    // https://web.archive.org/web/20100324014747/http://blindsignals.com/index.php/2009/07/jquery-delay/

    jQuery.fn.delay = function (time, type) {
      time = jQuery.fx ? jQuery.fx.speeds[time] || time : time;
      type = type || "fx";
      return this.queue(type, function (next, hooks) {
        var timeout = window.setTimeout(next, time);

        hooks.stop = function () {
          window.clearTimeout(timeout);
        };
      });
    };

    (function () {
      var input = document.createElement("input"),
          select = document.createElement("select"),
          opt = select.appendChild(document.createElement("option"));
      input.type = "checkbox"; // Support: Android <=4.3 only
      // Default value for a checkbox should be "on"

      support.checkOn = input.value !== ""; // Support: IE <=11 only
      // Must access selectedIndex to make default options select

      support.optSelected = opt.selected; // Support: IE <=11 only
      // An input loses its value after becoming a radio

      input = document.createElement("input");
      input.value = "t";
      input.type = "radio";
      support.radioValue = input.value === "t";
    })();

    var boolHook,
        attrHandle = jQuery.expr.attrHandle;
    jQuery.fn.extend({
      attr: function (name, value) {
        return access(this, jQuery.attr, name, value, arguments.length > 1);
      },
      removeAttr: function (name) {
        return this.each(function () {
          jQuery.removeAttr(this, name);
        });
      }
    });
    jQuery.extend({
      attr: function (elem, name, value) {
        var ret,
            hooks,
            nType = elem.nodeType; // Don't get/set attributes on text, comment and attribute nodes

        if (nType === 3 || nType === 8 || nType === 2) {
          return;
        } // Fallback to prop when attributes are not supported


        if (typeof elem.getAttribute === "undefined") {
          return jQuery.prop(elem, name, value);
        } // Attribute hooks are determined by the lowercase version
        // Grab necessary hook if one is defined


        if (nType !== 1 || !jQuery.isXMLDoc(elem)) {
          hooks = jQuery.attrHooks[name.toLowerCase()] || (jQuery.expr.match.bool.test(name) ? boolHook : undefined);
        }

        if (value !== undefined) {
          if (value === null) {
            jQuery.removeAttr(elem, name);
            return;
          }

          if (hooks && "set" in hooks && (ret = hooks.set(elem, value, name)) !== undefined) {
            return ret;
          }

          elem.setAttribute(name, value + "");
          return value;
        }

        if (hooks && "get" in hooks && (ret = hooks.get(elem, name)) !== null) {
          return ret;
        }

        ret = jQuery.find.attr(elem, name); // Non-existent attributes return null, we normalize to undefined

        return ret == null ? undefined : ret;
      },
      attrHooks: {
        type: {
          set: function (elem, value) {
            if (!support.radioValue && value === "radio" && nodeName(elem, "input")) {
              var val = elem.value;
              elem.setAttribute("type", value);

              if (val) {
                elem.value = val;
              }

              return value;
            }
          }
        }
      },
      removeAttr: function (elem, value) {
        var name,
            i = 0,
            // Attribute names can contain non-HTML whitespace characters
        // https://html.spec.whatwg.org/multipage/syntax.html#attributes-2
        attrNames = value && value.match(rnothtmlwhite);

        if (attrNames && elem.nodeType === 1) {
          while (name = attrNames[i++]) {
            elem.removeAttribute(name);
          }
        }
      }
    }); // Hooks for boolean attributes

    boolHook = {
      set: function (elem, value, name) {
        if (value === false) {
          // Remove boolean attributes when set to false
          jQuery.removeAttr(elem, name);
        } else {
          elem.setAttribute(name, name);
        }

        return name;
      }
    };
    jQuery.each(jQuery.expr.match.bool.source.match(/\w+/g), function (_i, name) {
      var getter = attrHandle[name] || jQuery.find.attr;

      attrHandle[name] = function (elem, name, isXML) {
        var ret,
            handle,
            lowercaseName = name.toLowerCase();

        if (!isXML) {
          // Avoid an infinite loop by temporarily removing this function from the getter
          handle = attrHandle[lowercaseName];
          attrHandle[lowercaseName] = ret;
          ret = getter(elem, name, isXML) != null ? lowercaseName : null;
          attrHandle[lowercaseName] = handle;
        }

        return ret;
      };
    });
    var rfocusable = /^(?:input|select|textarea|button)$/i,
        rclickable = /^(?:a|area)$/i;
    jQuery.fn.extend({
      prop: function (name, value) {
        return access(this, jQuery.prop, name, value, arguments.length > 1);
      },
      removeProp: function (name) {
        return this.each(function () {
          delete this[jQuery.propFix[name] || name];
        });
      }
    });
    jQuery.extend({
      prop: function (elem, name, value) {
        var ret,
            hooks,
            nType = elem.nodeType; // Don't get/set properties on text, comment and attribute nodes

        if (nType === 3 || nType === 8 || nType === 2) {
          return;
        }

        if (nType !== 1 || !jQuery.isXMLDoc(elem)) {
          // Fix name and attach hooks
          name = jQuery.propFix[name] || name;
          hooks = jQuery.propHooks[name];
        }

        if (value !== undefined) {
          if (hooks && "set" in hooks && (ret = hooks.set(elem, value, name)) !== undefined) {
            return ret;
          }

          return elem[name] = value;
        }

        if (hooks && "get" in hooks && (ret = hooks.get(elem, name)) !== null) {
          return ret;
        }

        return elem[name];
      },
      propHooks: {
        tabIndex: {
          get: function (elem) {
            // Support: IE <=9 - 11 only
            // elem.tabIndex doesn't always return the
            // correct value when it hasn't been explicitly set
            // https://web.archive.org/web/20141116233347/http://fluidproject.org/blog/2008/01/09/getting-setting-and-removing-tabindex-values-with-javascript/
            // Use proper attribute retrieval(#12072)
            var tabindex = jQuery.find.attr(elem, "tabindex");

            if (tabindex) {
              return parseInt(tabindex, 10);
            }

            if (rfocusable.test(elem.nodeName) || rclickable.test(elem.nodeName) && elem.href) {
              return 0;
            }

            return -1;
          }
        }
      },
      propFix: {
        "for": "htmlFor",
        "class": "className"
      }
    }); // Support: IE <=11 only
    // Accessing the selectedIndex property
    // forces the browser to respect setting selected
    // on the option
    // The getter ensures a default option is selected
    // when in an optgroup
    // eslint rule "no-unused-expressions" is disabled for this code
    // since it considers such accessions noop

    if (!support.optSelected) {
      jQuery.propHooks.selected = {
        get: function (elem) {
          /* eslint no-unused-expressions: "off" */
          var parent = elem.parentNode;

          if (parent && parent.parentNode) {
            parent.parentNode.selectedIndex;
          }

          return null;
        },
        set: function (elem) {
          /* eslint no-unused-expressions: "off" */
          var parent = elem.parentNode;

          if (parent) {
            parent.selectedIndex;

            if (parent.parentNode) {
              parent.parentNode.selectedIndex;
            }
          }
        }
      };
    }

    jQuery.each(["tabIndex", "readOnly", "maxLength", "cellSpacing", "cellPadding", "rowSpan", "colSpan", "useMap", "frameBorder", "contentEditable"], function () {
      jQuery.propFix[this.toLowerCase()] = this;
    }); // Strip and collapse whitespace according to HTML spec
    // https://infra.spec.whatwg.org/#strip-and-collapse-ascii-whitespace

    function stripAndCollapse(value) {
      var tokens = value.match(rnothtmlwhite) || [];
      return tokens.join(" ");
    }

    function getClass(elem) {
      return elem.getAttribute && elem.getAttribute("class") || "";
    }

    function classesToArray(value) {
      if (Array.isArray(value)) {
        return value;
      }

      if (typeof value === "string") {
        return value.match(rnothtmlwhite) || [];
      }

      return [];
    }

    jQuery.fn.extend({
      addClass: function (value) {
        var classes,
            elem,
            cur,
            curValue,
            clazz,
            j,
            finalValue,
            i = 0;

        if (isFunction(value)) {
          return this.each(function (j) {
            jQuery(this).addClass(value.call(this, j, getClass(this)));
          });
        }

        classes = classesToArray(value);

        if (classes.length) {
          while (elem = this[i++]) {
            curValue = getClass(elem);
            cur = elem.nodeType === 1 && " " + stripAndCollapse(curValue) + " ";

            if (cur) {
              j = 0;

              while (clazz = classes[j++]) {
                if (cur.indexOf(" " + clazz + " ") < 0) {
                  cur += clazz + " ";
                }
              } // Only assign if different to avoid unneeded rendering.


              finalValue = stripAndCollapse(cur);

              if (curValue !== finalValue) {
                elem.setAttribute("class", finalValue);
              }
            }
          }
        }

        return this;
      },
      removeClass: function (value) {
        var classes,
            elem,
            cur,
            curValue,
            clazz,
            j,
            finalValue,
            i = 0;

        if (isFunction(value)) {
          return this.each(function (j) {
            jQuery(this).removeClass(value.call(this, j, getClass(this)));
          });
        }

        if (!arguments.length) {
          return this.attr("class", "");
        }

        classes = classesToArray(value);

        if (classes.length) {
          while (elem = this[i++]) {
            curValue = getClass(elem); // This expression is here for better compressibility (see addClass)

            cur = elem.nodeType === 1 && " " + stripAndCollapse(curValue) + " ";

            if (cur) {
              j = 0;

              while (clazz = classes[j++]) {
                // Remove *all* instances
                while (cur.indexOf(" " + clazz + " ") > -1) {
                  cur = cur.replace(" " + clazz + " ", " ");
                }
              } // Only assign if different to avoid unneeded rendering.


              finalValue = stripAndCollapse(cur);

              if (curValue !== finalValue) {
                elem.setAttribute("class", finalValue);
              }
            }
          }
        }

        return this;
      },
      toggleClass: function (value, stateVal) {
        var type = typeof value,
            isValidValue = type === "string" || Array.isArray(value);

        if (typeof stateVal === "boolean" && isValidValue) {
          return stateVal ? this.addClass(value) : this.removeClass(value);
        }

        if (isFunction(value)) {
          return this.each(function (i) {
            jQuery(this).toggleClass(value.call(this, i, getClass(this), stateVal), stateVal);
          });
        }

        return this.each(function () {
          var className, i, self, classNames;

          if (isValidValue) {
            // Toggle individual class names
            i = 0;
            self = jQuery(this);
            classNames = classesToArray(value);

            while (className = classNames[i++]) {
              // Check each className given, space separated list
              if (self.hasClass(className)) {
                self.removeClass(className);
              } else {
                self.addClass(className);
              }
            } // Toggle whole class name

          } else if (value === undefined || type === "boolean") {
            className = getClass(this);

            if (className) {
              // Store className if set
              dataPriv.set(this, "__className__", className);
            } // If the element has a class name or if we're passed `false`,
            // then remove the whole classname (if there was one, the above saved it).
            // Otherwise bring back whatever was previously saved (if anything),
            // falling back to the empty string if nothing was stored.


            if (this.setAttribute) {
              this.setAttribute("class", className || value === false ? "" : dataPriv.get(this, "__className__") || "");
            }
          }
        });
      },
      hasClass: function (selector) {
        var className,
            elem,
            i = 0;
        className = " " + selector + " ";

        while (elem = this[i++]) {
          if (elem.nodeType === 1 && (" " + stripAndCollapse(getClass(elem)) + " ").indexOf(className) > -1) {
            return true;
          }
        }

        return false;
      }
    });
    var rreturn = /\r/g;
    jQuery.fn.extend({
      val: function (value) {
        var hooks,
            ret,
            valueIsFunction,
            elem = this[0];

        if (!arguments.length) {
          if (elem) {
            hooks = jQuery.valHooks[elem.type] || jQuery.valHooks[elem.nodeName.toLowerCase()];

            if (hooks && "get" in hooks && (ret = hooks.get(elem, "value")) !== undefined) {
              return ret;
            }

            ret = elem.value; // Handle most common string cases

            if (typeof ret === "string") {
              return ret.replace(rreturn, "");
            } // Handle cases where value is null/undef or number


            return ret == null ? "" : ret;
          }

          return;
        }

        valueIsFunction = isFunction(value);
        return this.each(function (i) {
          var val;

          if (this.nodeType !== 1) {
            return;
          }

          if (valueIsFunction) {
            val = value.call(this, i, jQuery(this).val());
          } else {
            val = value;
          } // Treat null/undefined as ""; convert numbers to string


          if (val == null) {
            val = "";
          } else if (typeof val === "number") {
            val += "";
          } else if (Array.isArray(val)) {
            val = jQuery.map(val, function (value) {
              return value == null ? "" : value + "";
            });
          }

          hooks = jQuery.valHooks[this.type] || jQuery.valHooks[this.nodeName.toLowerCase()]; // If set returns undefined, fall back to normal setting

          if (!hooks || !("set" in hooks) || hooks.set(this, val, "value") === undefined) {
            this.value = val;
          }
        });
      }
    });
    jQuery.extend({
      valHooks: {
        option: {
          get: function (elem) {
            var val = jQuery.find.attr(elem, "value");
            return val != null ? val : // Support: IE <=10 - 11 only
            // option.text throws exceptions (#14686, #14858)
            // Strip and collapse whitespace
            // https://html.spec.whatwg.org/#strip-and-collapse-whitespace
            stripAndCollapse(jQuery.text(elem));
          }
        },
        select: {
          get: function (elem) {
            var value,
                option,
                i,
                options = elem.options,
                index = elem.selectedIndex,
                one = elem.type === "select-one",
                values = one ? null : [],
                max = one ? index + 1 : options.length;

            if (index < 0) {
              i = max;
            } else {
              i = one ? index : 0;
            } // Loop through all the selected options


            for (; i < max; i++) {
              option = options[i]; // Support: IE <=9 only
              // IE8-9 doesn't update selected after form reset (#2551)

              if ((option.selected || i === index) && // Don't return options that are disabled or in a disabled optgroup
              !option.disabled && (!option.parentNode.disabled || !nodeName(option.parentNode, "optgroup"))) {
                // Get the specific value for the option
                value = jQuery(option).val(); // We don't need an array for one selects

                if (one) {
                  return value;
                } // Multi-Selects return an array


                values.push(value);
              }
            }

            return values;
          },
          set: function (elem, value) {
            var optionSet,
                option,
                options = elem.options,
                values = jQuery.makeArray(value),
                i = options.length;

            while (i--) {
              option = options[i];
              /* eslint-disable no-cond-assign */

              if (option.selected = jQuery.inArray(jQuery.valHooks.option.get(option), values) > -1) {
                optionSet = true;
              }
              /* eslint-enable no-cond-assign */

            } // Force browsers to behave consistently when non-matching value is set


            if (!optionSet) {
              elem.selectedIndex = -1;
            }

            return values;
          }
        }
      }
    }); // Radios and checkboxes getter/setter

    jQuery.each(["radio", "checkbox"], function () {
      jQuery.valHooks[this] = {
        set: function (elem, value) {
          if (Array.isArray(value)) {
            return elem.checked = jQuery.inArray(jQuery(elem).val(), value) > -1;
          }
        }
      };

      if (!support.checkOn) {
        jQuery.valHooks[this].get = function (elem) {
          return elem.getAttribute("value") === null ? "on" : elem.value;
        };
      }
    }); // Return jQuery for attributes-only inclusion

    support.focusin = "onfocusin" in window;

    var rfocusMorph = /^(?:focusinfocus|focusoutblur)$/,
        stopPropagationCallback = function (e) {
      e.stopPropagation();
    };

    jQuery.extend(jQuery.event, {
      trigger: function (event, data, elem, onlyHandlers) {
        var i,
            cur,
            tmp,
            bubbleType,
            ontype,
            handle,
            special,
            lastElement,
            eventPath = [elem || document],
            type = hasOwn.call(event, "type") ? event.type : event,
            namespaces = hasOwn.call(event, "namespace") ? event.namespace.split(".") : [];
        cur = lastElement = tmp = elem = elem || document; // Don't do events on text and comment nodes

        if (elem.nodeType === 3 || elem.nodeType === 8) {
          return;
        } // focus/blur morphs to focusin/out; ensure we're not firing them right now


        if (rfocusMorph.test(type + jQuery.event.triggered)) {
          return;
        }

        if (type.indexOf(".") > -1) {
          // Namespaced trigger; create a regexp to match event type in handle()
          namespaces = type.split(".");
          type = namespaces.shift();
          namespaces.sort();
        }

        ontype = type.indexOf(":") < 0 && "on" + type; // Caller can pass in a jQuery.Event object, Object, or just an event type string

        event = event[jQuery.expando] ? event : new jQuery.Event(type, typeof event === "object" && event); // Trigger bitmask: & 1 for native handlers; & 2 for jQuery (always true)

        event.isTrigger = onlyHandlers ? 2 : 3;
        event.namespace = namespaces.join(".");
        event.rnamespace = event.namespace ? new RegExp("(^|\\.)" + namespaces.join("\\.(?:.*\\.|)") + "(\\.|$)") : null; // Clean up the event in case it is being reused

        event.result = undefined;

        if (!event.target) {
          event.target = elem;
        } // Clone any incoming data and prepend the event, creating the handler arg list


        data = data == null ? [event] : jQuery.makeArray(data, [event]); // Allow special events to draw outside the lines

        special = jQuery.event.special[type] || {};

        if (!onlyHandlers && special.trigger && special.trigger.apply(elem, data) === false) {
          return;
        } // Determine event propagation path in advance, per W3C events spec (#9951)
        // Bubble up to document, then to window; watch for a global ownerDocument var (#9724)


        if (!onlyHandlers && !special.noBubble && !isWindow(elem)) {
          bubbleType = special.delegateType || type;

          if (!rfocusMorph.test(bubbleType + type)) {
            cur = cur.parentNode;
          }

          for (; cur; cur = cur.parentNode) {
            eventPath.push(cur);
            tmp = cur;
          } // Only add window if we got to document (e.g., not plain obj or detached DOM)


          if (tmp === (elem.ownerDocument || document)) {
            eventPath.push(tmp.defaultView || tmp.parentWindow || window);
          }
        } // Fire handlers on the event path


        i = 0;

        while ((cur = eventPath[i++]) && !event.isPropagationStopped()) {
          lastElement = cur;
          event.type = i > 1 ? bubbleType : special.bindType || type; // jQuery handler

          handle = (dataPriv.get(cur, "events") || Object.create(null))[event.type] && dataPriv.get(cur, "handle");

          if (handle) {
            handle.apply(cur, data);
          } // Native handler


          handle = ontype && cur[ontype];

          if (handle && handle.apply && acceptData(cur)) {
            event.result = handle.apply(cur, data);

            if (event.result === false) {
              event.preventDefault();
            }
          }
        }

        event.type = type; // If nobody prevented the default action, do it now

        if (!onlyHandlers && !event.isDefaultPrevented()) {
          if ((!special._default || special._default.apply(eventPath.pop(), data) === false) && acceptData(elem)) {
            // Call a native DOM method on the target with the same name as the event.
            // Don't do default actions on window, that's where global variables be (#6170)
            if (ontype && isFunction(elem[type]) && !isWindow(elem)) {
              // Don't re-trigger an onFOO event when we call its FOO() method
              tmp = elem[ontype];

              if (tmp) {
                elem[ontype] = null;
              } // Prevent re-triggering of the same event, since we already bubbled it above


              jQuery.event.triggered = type;

              if (event.isPropagationStopped()) {
                lastElement.addEventListener(type, stopPropagationCallback);
              }

              elem[type]();

              if (event.isPropagationStopped()) {
                lastElement.removeEventListener(type, stopPropagationCallback);
              }

              jQuery.event.triggered = undefined;

              if (tmp) {
                elem[ontype] = tmp;
              }
            }
          }
        }

        return event.result;
      },
      // Piggyback on a donor event to simulate a different one
      // Used only for `focus(in | out)` events
      simulate: function (type, elem, event) {
        var e = jQuery.extend(new jQuery.Event(), event, {
          type: type,
          isSimulated: true
        });
        jQuery.event.trigger(e, null, elem);
      }
    });
    jQuery.fn.extend({
      trigger: function (type, data) {
        return this.each(function () {
          jQuery.event.trigger(type, data, this);
        });
      },
      triggerHandler: function (type, data) {
        var elem = this[0];

        if (elem) {
          return jQuery.event.trigger(type, data, elem, true);
        }
      }
    }); // Support: Firefox <=44
    // Firefox doesn't have focus(in | out) events
    // Related ticket - https://bugzilla.mozilla.org/show_bug.cgi?id=687787
    //
    // Support: Chrome <=48 - 49, Safari <=9.0 - 9.1
    // focus(in | out) events fire after focus & blur events,
    // which is spec violation - http://www.w3.org/TR/DOM-Level-3-Events/#events-focusevent-event-order
    // Related ticket - https://bugs.chromium.org/p/chromium/issues/detail?id=449857

    if (!support.focusin) {
      jQuery.each({
        focus: "focusin",
        blur: "focusout"
      }, function (orig, fix) {
        // Attach a single capturing handler on the document while someone wants focusin/focusout
        var handler = function (event) {
          jQuery.event.simulate(fix, event.target, jQuery.event.fix(event));
        };

        jQuery.event.special[fix] = {
          setup: function () {
            // Handle: regular nodes (via `this.ownerDocument`), window
            // (via `this.document`) & document (via `this`).
            var doc = this.ownerDocument || this.document || this,
                attaches = dataPriv.access(doc, fix);

            if (!attaches) {
              doc.addEventListener(orig, handler, true);
            }

            dataPriv.access(doc, fix, (attaches || 0) + 1);
          },
          teardown: function () {
            var doc = this.ownerDocument || this.document || this,
                attaches = dataPriv.access(doc, fix) - 1;

            if (!attaches) {
              doc.removeEventListener(orig, handler, true);
              dataPriv.remove(doc, fix);
            } else {
              dataPriv.access(doc, fix, attaches);
            }
          }
        };
      });
    }

    var location = window.location;
    var nonce = {
      guid: Date.now()
    };
    var rquery = /\?/; // Cross-browser xml parsing

    jQuery.parseXML = function (data) {
      var xml, parserErrorElem;

      if (!data || typeof data !== "string") {
        return null;
      } // Support: IE 9 - 11 only
      // IE throws on parseFromString with invalid input.


      try {
        xml = new window.DOMParser().parseFromString(data, "text/xml");
      } catch (e) {}

      parserErrorElem = xml && xml.getElementsByTagName("parsererror")[0];

      if (!xml || parserErrorElem) {
        jQuery.error("Invalid XML: " + (parserErrorElem ? jQuery.map(parserErrorElem.childNodes, function (el) {
          return el.textContent;
        }).join("\n") : data));
      }

      return xml;
    };

    var rbracket = /\[\]$/,
        rCRLF = /\r?\n/g,
        rsubmitterTypes = /^(?:submit|button|image|reset|file)$/i,
        rsubmittable = /^(?:input|select|textarea|keygen)/i;

    function buildParams(prefix, obj, traditional, add) {
      var name;

      if (Array.isArray(obj)) {
        // Serialize array item.
        jQuery.each(obj, function (i, v) {
          if (traditional || rbracket.test(prefix)) {
            // Treat each array item as a scalar.
            add(prefix, v);
          } else {
            // Item is non-scalar (array or object), encode its numeric index.
            buildParams(prefix + "[" + (typeof v === "object" && v != null ? i : "") + "]", v, traditional, add);
          }
        });
      } else if (!traditional && toType(obj) === "object") {
        // Serialize object item.
        for (name in obj) {
          buildParams(prefix + "[" + name + "]", obj[name], traditional, add);
        }
      } else {
        // Serialize scalar item.
        add(prefix, obj);
      }
    } // Serialize an array of form elements or a set of
    // key/values into a query string


    jQuery.param = function (a, traditional) {
      var prefix,
          s = [],
          add = function (key, valueOrFunction) {
        // If value is a function, invoke it and use its return value
        var value = isFunction(valueOrFunction) ? valueOrFunction() : valueOrFunction;
        s[s.length] = encodeURIComponent(key) + "=" + encodeURIComponent(value == null ? "" : value);
      };

      if (a == null) {
        return "";
      } // If an array was passed in, assume that it is an array of form elements.


      if (Array.isArray(a) || a.jquery && !jQuery.isPlainObject(a)) {
        // Serialize the form elements
        jQuery.each(a, function () {
          add(this.name, this.value);
        });
      } else {
        // If traditional, encode the "old" way (the way 1.3.2 or older
        // did it), otherwise encode params recursively.
        for (prefix in a) {
          buildParams(prefix, a[prefix], traditional, add);
        }
      } // Return the resulting serialization


      return s.join("&");
    };

    jQuery.fn.extend({
      serialize: function () {
        return jQuery.param(this.serializeArray());
      },
      serializeArray: function () {
        return this.map(function () {
          // Can add propHook for "elements" to filter or add form elements
          var elements = jQuery.prop(this, "elements");
          return elements ? jQuery.makeArray(elements) : this;
        }).filter(function () {
          var type = this.type; // Use .is( ":disabled" ) so that fieldset[disabled] works

          return this.name && !jQuery(this).is(":disabled") && rsubmittable.test(this.nodeName) && !rsubmitterTypes.test(type) && (this.checked || !rcheckableType.test(type));
        }).map(function (_i, elem) {
          var val = jQuery(this).val();

          if (val == null) {
            return null;
          }

          if (Array.isArray(val)) {
            return jQuery.map(val, function (val) {
              return {
                name: elem.name,
                value: val.replace(rCRLF, "\r\n")
              };
            });
          }

          return {
            name: elem.name,
            value: val.replace(rCRLF, "\r\n")
          };
        }).get();
      }
    });
    var r20 = /%20/g,
        rhash = /#.*$/,
        rantiCache = /([?&])_=[^&]*/,
        rheaders = /^(.*?):[ \t]*([^\r\n]*)$/mg,
        // #7653, #8125, #8152: local protocol detection
    rlocalProtocol = /^(?:about|app|app-storage|.+-extension|file|res|widget):$/,
        rnoContent = /^(?:GET|HEAD)$/,
        rprotocol = /^\/\//,

    /* Prefilters
     * 1) They are useful to introduce custom dataTypes (see ajax/jsonp.js for an example)
     * 2) These are called:
     *    - BEFORE asking for a transport
     *    - AFTER param serialization (s.data is a string if s.processData is true)
     * 3) key is the dataType
     * 4) the catchall symbol "*" can be used
     * 5) execution will start with transport dataType and THEN continue down to "*" if needed
     */
    prefilters = {},

    /* Transports bindings
     * 1) key is the dataType
     * 2) the catchall symbol "*" can be used
     * 3) selection will start with transport dataType and THEN go to "*" if needed
     */
    transports = {},
        // Avoid comment-prolog char sequence (#10098); must appease lint and evade compression
    allTypes = "*/".concat("*"),
        // Anchor tag for parsing the document origin
    originAnchor = document.createElement("a");
    originAnchor.href = location.href; // Base "constructor" for jQuery.ajaxPrefilter and jQuery.ajaxTransport

    function addToPrefiltersOrTransports(structure) {
      // dataTypeExpression is optional and defaults to "*"
      return function (dataTypeExpression, func) {
        if (typeof dataTypeExpression !== "string") {
          func = dataTypeExpression;
          dataTypeExpression = "*";
        }

        var dataType,
            i = 0,
            dataTypes = dataTypeExpression.toLowerCase().match(rnothtmlwhite) || [];

        if (isFunction(func)) {
          // For each dataType in the dataTypeExpression
          while (dataType = dataTypes[i++]) {
            // Prepend if requested
            if (dataType[0] === "+") {
              dataType = dataType.slice(1) || "*";
              (structure[dataType] = structure[dataType] || []).unshift(func); // Otherwise append
            } else {
              (structure[dataType] = structure[dataType] || []).push(func);
            }
          }
        }
      };
    } // Base inspection function for prefilters and transports


    function inspectPrefiltersOrTransports(structure, options, originalOptions, jqXHR) {
      var inspected = {},
          seekingTransport = structure === transports;

      function inspect(dataType) {
        var selected;
        inspected[dataType] = true;
        jQuery.each(structure[dataType] || [], function (_, prefilterOrFactory) {
          var dataTypeOrTransport = prefilterOrFactory(options, originalOptions, jqXHR);

          if (typeof dataTypeOrTransport === "string" && !seekingTransport && !inspected[dataTypeOrTransport]) {
            options.dataTypes.unshift(dataTypeOrTransport);
            inspect(dataTypeOrTransport);
            return false;
          } else if (seekingTransport) {
            return !(selected = dataTypeOrTransport);
          }
        });
        return selected;
      }

      return inspect(options.dataTypes[0]) || !inspected["*"] && inspect("*");
    } // A special extend for ajax options
    // that takes "flat" options (not to be deep extended)
    // Fixes #9887


    function ajaxExtend(target, src) {
      var key,
          deep,
          flatOptions = jQuery.ajaxSettings.flatOptions || {};

      for (key in src) {
        if (src[key] !== undefined) {
          (flatOptions[key] ? target : deep || (deep = {}))[key] = src[key];
        }
      }

      if (deep) {
        jQuery.extend(true, target, deep);
      }

      return target;
    }
    /* Handles responses to an ajax request:
     * - finds the right dataType (mediates between content-type and expected dataType)
     * - returns the corresponding response
     */


    function ajaxHandleResponses(s, jqXHR, responses) {
      var ct,
          type,
          finalDataType,
          firstDataType,
          contents = s.contents,
          dataTypes = s.dataTypes; // Remove auto dataType and get content-type in the process

      while (dataTypes[0] === "*") {
        dataTypes.shift();

        if (ct === undefined) {
          ct = s.mimeType || jqXHR.getResponseHeader("Content-Type");
        }
      } // Check if we're dealing with a known content-type


      if (ct) {
        for (type in contents) {
          if (contents[type] && contents[type].test(ct)) {
            dataTypes.unshift(type);
            break;
          }
        }
      } // Check to see if we have a response for the expected dataType


      if (dataTypes[0] in responses) {
        finalDataType = dataTypes[0];
      } else {
        // Try convertible dataTypes
        for (type in responses) {
          if (!dataTypes[0] || s.converters[type + " " + dataTypes[0]]) {
            finalDataType = type;
            break;
          }

          if (!firstDataType) {
            firstDataType = type;
          }
        } // Or just use first one


        finalDataType = finalDataType || firstDataType;
      } // If we found a dataType
      // We add the dataType to the list if needed
      // and return the corresponding response


      if (finalDataType) {
        if (finalDataType !== dataTypes[0]) {
          dataTypes.unshift(finalDataType);
        }

        return responses[finalDataType];
      }
    }
    /* Chain conversions given the request and the original response
     * Also sets the responseXXX fields on the jqXHR instance
     */


    function ajaxConvert(s, response, jqXHR, isSuccess) {
      var conv2,
          current,
          conv,
          tmp,
          prev,
          converters = {},
          // Work with a copy of dataTypes in case we need to modify it for conversion
      dataTypes = s.dataTypes.slice(); // Create converters map with lowercased keys

      if (dataTypes[1]) {
        for (conv in s.converters) {
          converters[conv.toLowerCase()] = s.converters[conv];
        }
      }

      current = dataTypes.shift(); // Convert to each sequential dataType

      while (current) {
        if (s.responseFields[current]) {
          jqXHR[s.responseFields[current]] = response;
        } // Apply the dataFilter if provided


        if (!prev && isSuccess && s.dataFilter) {
          response = s.dataFilter(response, s.dataType);
        }

        prev = current;
        current = dataTypes.shift();

        if (current) {
          // There's only work to do if current dataType is non-auto
          if (current === "*") {
            current = prev; // Convert response if prev dataType is non-auto and differs from current
          } else if (prev !== "*" && prev !== current) {
            // Seek a direct converter
            conv = converters[prev + " " + current] || converters["* " + current]; // If none found, seek a pair

            if (!conv) {
              for (conv2 in converters) {
                // If conv2 outputs current
                tmp = conv2.split(" ");

                if (tmp[1] === current) {
                  // If prev can be converted to accepted input
                  conv = converters[prev + " " + tmp[0]] || converters["* " + tmp[0]];

                  if (conv) {
                    // Condense equivalence converters
                    if (conv === true) {
                      conv = converters[conv2]; // Otherwise, insert the intermediate dataType
                    } else if (converters[conv2] !== true) {
                      current = tmp[0];
                      dataTypes.unshift(tmp[1]);
                    }

                    break;
                  }
                }
              }
            } // Apply converter (if not an equivalence)


            if (conv !== true) {
              // Unless errors are allowed to bubble, catch and return them
              if (conv && s.throws) {
                response = conv(response);
              } else {
                try {
                  response = conv(response);
                } catch (e) {
                  return {
                    state: "parsererror",
                    error: conv ? e : "No conversion from " + prev + " to " + current
                  };
                }
              }
            }
          }
        }
      }

      return {
        state: "success",
        data: response
      };
    }

    jQuery.extend({
      // Counter for holding the number of active queries
      active: 0,
      // Last-Modified header cache for next request
      lastModified: {},
      etag: {},
      ajaxSettings: {
        url: location.href,
        type: "GET",
        isLocal: rlocalProtocol.test(location.protocol),
        global: true,
        processData: true,
        async: true,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",

        /*
        timeout: 0,
        data: null,
        dataType: null,
        username: null,
        password: null,
        cache: null,
        throws: false,
        traditional: false,
        headers: {},
        */
        accepts: {
          "*": allTypes,
          text: "text/plain",
          html: "text/html",
          xml: "application/xml, text/xml",
          json: "application/json, text/javascript"
        },
        contents: {
          xml: /\bxml\b/,
          html: /\bhtml/,
          json: /\bjson\b/
        },
        responseFields: {
          xml: "responseXML",
          text: "responseText",
          json: "responseJSON"
        },
        // Data converters
        // Keys separate source (or catchall "*") and destination types with a single space
        converters: {
          // Convert anything to text
          "* text": String,
          // Text to html (true = no transformation)
          "text html": true,
          // Evaluate text as a json expression
          "text json": JSON.parse,
          // Parse text as xml
          "text xml": jQuery.parseXML
        },
        // For options that shouldn't be deep extended:
        // you can add your own custom options here if
        // and when you create one that shouldn't be
        // deep extended (see ajaxExtend)
        flatOptions: {
          url: true,
          context: true
        }
      },
      // Creates a full fledged settings object into target
      // with both ajaxSettings and settings fields.
      // If target is omitted, writes into ajaxSettings.
      ajaxSetup: function (target, settings) {
        return settings ? // Building a settings object
        ajaxExtend(ajaxExtend(target, jQuery.ajaxSettings), settings) : // Extending ajaxSettings
        ajaxExtend(jQuery.ajaxSettings, target);
      },
      ajaxPrefilter: addToPrefiltersOrTransports(prefilters),
      ajaxTransport: addToPrefiltersOrTransports(transports),
      // Main method
      ajax: function (url, options) {
        // If url is an object, simulate pre-1.5 signature
        if (typeof url === "object") {
          options = url;
          url = undefined;
        } // Force options to be an object


        options = options || {};
        var transport,
            // URL without anti-cache param
        cacheURL,
            // Response headers
        responseHeadersString,
            responseHeaders,
            // timeout handle
        timeoutTimer,
            // Url cleanup var
        urlAnchor,
            // Request state (becomes false upon send and true upon completion)
        completed,
            // To know if global events are to be dispatched
        fireGlobals,
            // Loop variable
        i,
            // uncached part of the url
        uncached,
            // Create the final options object
        s = jQuery.ajaxSetup({}, options),
            // Callbacks context
        callbackContext = s.context || s,
            // Context for global events is callbackContext if it is a DOM node or jQuery collection
        globalEventContext = s.context && (callbackContext.nodeType || callbackContext.jquery) ? jQuery(callbackContext) : jQuery.event,
            // Deferreds
        deferred = jQuery.Deferred(),
            completeDeferred = jQuery.Callbacks("once memory"),
            // Status-dependent callbacks
        statusCode = s.statusCode || {},
            // Headers (they are sent all at once)
        requestHeaders = {},
            requestHeadersNames = {},
            // Default abort message
        strAbort = "canceled",
            // Fake xhr
        jqXHR = {
          readyState: 0,
          // Builds headers hashtable if needed
          getResponseHeader: function (key) {
            var match;

            if (completed) {
              if (!responseHeaders) {
                responseHeaders = {};

                while (match = rheaders.exec(responseHeadersString)) {
                  responseHeaders[match[1].toLowerCase() + " "] = (responseHeaders[match[1].toLowerCase() + " "] || []).concat(match[2]);
                }
              }

              match = responseHeaders[key.toLowerCase() + " "];
            }

            return match == null ? null : match.join(", ");
          },
          // Raw string
          getAllResponseHeaders: function () {
            return completed ? responseHeadersString : null;
          },
          // Caches the header
          setRequestHeader: function (name, value) {
            if (completed == null) {
              name = requestHeadersNames[name.toLowerCase()] = requestHeadersNames[name.toLowerCase()] || name;
              requestHeaders[name] = value;
            }

            return this;
          },
          // Overrides response content-type header
          overrideMimeType: function (type) {
            if (completed == null) {
              s.mimeType = type;
            }

            return this;
          },
          // Status-dependent callbacks
          statusCode: function (map) {
            var code;

            if (map) {
              if (completed) {
                // Execute the appropriate callbacks
                jqXHR.always(map[jqXHR.status]);
              } else {
                // Lazy-add the new callbacks in a way that preserves old ones
                for (code in map) {
                  statusCode[code] = [statusCode[code], map[code]];
                }
              }
            }

            return this;
          },
          // Cancel the request
          abort: function (statusText) {
            var finalText = statusText || strAbort;

            if (transport) {
              transport.abort(finalText);
            }

            done(0, finalText);
            return this;
          }
        }; // Attach deferreds

        deferred.promise(jqXHR); // Add protocol if not provided (prefilters might expect it)
        // Handle falsy url in the settings object (#10093: consistency with old signature)
        // We also use the url parameter if available

        s.url = ((url || s.url || location.href) + "").replace(rprotocol, location.protocol + "//"); // Alias method option to type as per ticket #12004

        s.type = options.method || options.type || s.method || s.type; // Extract dataTypes list

        s.dataTypes = (s.dataType || "*").toLowerCase().match(rnothtmlwhite) || [""]; // A cross-domain request is in order when the origin doesn't match the current origin.

        if (s.crossDomain == null) {
          urlAnchor = document.createElement("a"); // Support: IE <=8 - 11, Edge 12 - 15
          // IE throws exception on accessing the href property if url is malformed,
          // e.g. http://example.com:80x/

          try {
            urlAnchor.href = s.url; // Support: IE <=8 - 11 only
            // Anchor's host property isn't correctly set when s.url is relative

            urlAnchor.href = urlAnchor.href;
            s.crossDomain = originAnchor.protocol + "//" + originAnchor.host !== urlAnchor.protocol + "//" + urlAnchor.host;
          } catch (e) {
            // If there is an error parsing the URL, assume it is crossDomain,
            // it can be rejected by the transport if it is invalid
            s.crossDomain = true;
          }
        } // Convert data if not already a string


        if (s.data && s.processData && typeof s.data !== "string") {
          s.data = jQuery.param(s.data, s.traditional);
        } // Apply prefilters


        inspectPrefiltersOrTransports(prefilters, s, options, jqXHR); // If request was aborted inside a prefilter, stop there

        if (completed) {
          return jqXHR;
        } // We can fire global events as of now if asked to
        // Don't fire events if jQuery.event is undefined in an AMD-usage scenario (#15118)


        fireGlobals = jQuery.event && s.global; // Watch for a new set of requests

        if (fireGlobals && jQuery.active++ === 0) {
          jQuery.event.trigger("ajaxStart");
        } // Uppercase the type


        s.type = s.type.toUpperCase(); // Determine if request has content

        s.hasContent = !rnoContent.test(s.type); // Save the URL in case we're toying with the If-Modified-Since
        // and/or If-None-Match header later on
        // Remove hash to simplify url manipulation

        cacheURL = s.url.replace(rhash, ""); // More options handling for requests with no content

        if (!s.hasContent) {
          // Remember the hash so we can put it back
          uncached = s.url.slice(cacheURL.length); // If data is available and should be processed, append data to url

          if (s.data && (s.processData || typeof s.data === "string")) {
            cacheURL += (rquery.test(cacheURL) ? "&" : "?") + s.data; // #9682: remove data so that it's not used in an eventual retry

            delete s.data;
          } // Add or update anti-cache param if needed


          if (s.cache === false) {
            cacheURL = cacheURL.replace(rantiCache, "$1");
            uncached = (rquery.test(cacheURL) ? "&" : "?") + "_=" + nonce.guid++ + uncached;
          } // Put hash and anti-cache on the URL that will be requested (gh-1732)


          s.url = cacheURL + uncached; // Change '%20' to '+' if this is encoded form body content (gh-2658)
        } else if (s.data && s.processData && (s.contentType || "").indexOf("application/x-www-form-urlencoded") === 0) {
          s.data = s.data.replace(r20, "+");
        } // Set the If-Modified-Since and/or If-None-Match header, if in ifModified mode.


        if (s.ifModified) {
          if (jQuery.lastModified[cacheURL]) {
            jqXHR.setRequestHeader("If-Modified-Since", jQuery.lastModified[cacheURL]);
          }

          if (jQuery.etag[cacheURL]) {
            jqXHR.setRequestHeader("If-None-Match", jQuery.etag[cacheURL]);
          }
        } // Set the correct header, if data is being sent


        if (s.data && s.hasContent && s.contentType !== false || options.contentType) {
          jqXHR.setRequestHeader("Content-Type", s.contentType);
        } // Set the Accepts header for the server, depending on the dataType


        jqXHR.setRequestHeader("Accept", s.dataTypes[0] && s.accepts[s.dataTypes[0]] ? s.accepts[s.dataTypes[0]] + (s.dataTypes[0] !== "*" ? ", " + allTypes + "; q=0.01" : "") : s.accepts["*"]); // Check for headers option

        for (i in s.headers) {
          jqXHR.setRequestHeader(i, s.headers[i]);
        } // Allow custom headers/mimetypes and early abort


        if (s.beforeSend && (s.beforeSend.call(callbackContext, jqXHR, s) === false || completed)) {
          // Abort if not done already and return
          return jqXHR.abort();
        } // Aborting is no longer a cancellation


        strAbort = "abort"; // Install callbacks on deferreds

        completeDeferred.add(s.complete);
        jqXHR.done(s.success);
        jqXHR.fail(s.error); // Get transport

        transport = inspectPrefiltersOrTransports(transports, s, options, jqXHR); // If no transport, we auto-abort

        if (!transport) {
          done(-1, "No Transport");
        } else {
          jqXHR.readyState = 1; // Send global event

          if (fireGlobals) {
            globalEventContext.trigger("ajaxSend", [jqXHR, s]);
          } // If request was aborted inside ajaxSend, stop there


          if (completed) {
            return jqXHR;
          } // Timeout


          if (s.async && s.timeout > 0) {
            timeoutTimer = window.setTimeout(function () {
              jqXHR.abort("timeout");
            }, s.timeout);
          }

          try {
            completed = false;
            transport.send(requestHeaders, done);
          } catch (e) {
            // Rethrow post-completion exceptions
            if (completed) {
              throw e;
            } // Propagate others as results


            done(-1, e);
          }
        } // Callback for when everything is done


        function done(status, nativeStatusText, responses, headers) {
          var isSuccess,
              success,
              error,
              response,
              modified,
              statusText = nativeStatusText; // Ignore repeat invocations

          if (completed) {
            return;
          }

          completed = true; // Clear timeout if it exists

          if (timeoutTimer) {
            window.clearTimeout(timeoutTimer);
          } // Dereference transport for early garbage collection
          // (no matter how long the jqXHR object will be used)


          transport = undefined; // Cache response headers

          responseHeadersString = headers || ""; // Set readyState

          jqXHR.readyState = status > 0 ? 4 : 0; // Determine if successful

          isSuccess = status >= 200 && status < 300 || status === 304; // Get response data

          if (responses) {
            response = ajaxHandleResponses(s, jqXHR, responses);
          } // Use a noop converter for missing script but not if jsonp


          if (!isSuccess && jQuery.inArray("script", s.dataTypes) > -1 && jQuery.inArray("json", s.dataTypes) < 0) {
            s.converters["text script"] = function () {};
          } // Convert no matter what (that way responseXXX fields are always set)


          response = ajaxConvert(s, response, jqXHR, isSuccess); // If successful, handle type chaining

          if (isSuccess) {
            // Set the If-Modified-Since and/or If-None-Match header, if in ifModified mode.
            if (s.ifModified) {
              modified = jqXHR.getResponseHeader("Last-Modified");

              if (modified) {
                jQuery.lastModified[cacheURL] = modified;
              }

              modified = jqXHR.getResponseHeader("etag");

              if (modified) {
                jQuery.etag[cacheURL] = modified;
              }
            } // if no content


            if (status === 204 || s.type === "HEAD") {
              statusText = "nocontent"; // if not modified
            } else if (status === 304) {
              statusText = "notmodified"; // If we have data, let's convert it
            } else {
              statusText = response.state;
              success = response.data;
              error = response.error;
              isSuccess = !error;
            }
          } else {
            // Extract error from statusText and normalize for non-aborts
            error = statusText;

            if (status || !statusText) {
              statusText = "error";

              if (status < 0) {
                status = 0;
              }
            }
          } // Set data for the fake xhr object


          jqXHR.status = status;
          jqXHR.statusText = (nativeStatusText || statusText) + ""; // Success/Error

          if (isSuccess) {
            deferred.resolveWith(callbackContext, [success, statusText, jqXHR]);
          } else {
            deferred.rejectWith(callbackContext, [jqXHR, statusText, error]);
          } // Status-dependent callbacks


          jqXHR.statusCode(statusCode);
          statusCode = undefined;

          if (fireGlobals) {
            globalEventContext.trigger(isSuccess ? "ajaxSuccess" : "ajaxError", [jqXHR, s, isSuccess ? success : error]);
          } // Complete


          completeDeferred.fireWith(callbackContext, [jqXHR, statusText]);

          if (fireGlobals) {
            globalEventContext.trigger("ajaxComplete", [jqXHR, s]); // Handle the global AJAX counter

            if (! --jQuery.active) {
              jQuery.event.trigger("ajaxStop");
            }
          }
        }

        return jqXHR;
      },
      getJSON: function (url, data, callback) {
        return jQuery.get(url, data, callback, "json");
      },
      getScript: function (url, callback) {
        return jQuery.get(url, undefined, callback, "script");
      }
    });
    jQuery.each(["get", "post"], function (_i, method) {
      jQuery[method] = function (url, data, callback, type) {
        // Shift arguments if data argument was omitted
        if (isFunction(data)) {
          type = type || callback;
          callback = data;
          data = undefined;
        } // The url can be an options object (which then must have .url)


        return jQuery.ajax(jQuery.extend({
          url: url,
          type: method,
          dataType: type,
          data: data,
          success: callback
        }, jQuery.isPlainObject(url) && url));
      };
    });
    jQuery.ajaxPrefilter(function (s) {
      var i;

      for (i in s.headers) {
        if (i.toLowerCase() === "content-type") {
          s.contentType = s.headers[i] || "";
        }
      }
    });

    jQuery._evalUrl = function (url, options, doc) {
      return jQuery.ajax({
        url: url,
        // Make this explicit, since user can override this through ajaxSetup (#11264)
        type: "GET",
        dataType: "script",
        cache: true,
        async: false,
        global: false,
        // Only evaluate the response if it is successful (gh-4126)
        // dataFilter is not invoked for failure responses, so using it instead
        // of the default converter is kludgy but it works.
        converters: {
          "text script": function () {}
        },
        dataFilter: function (response) {
          jQuery.globalEval(response, options, doc);
        }
      });
    };

    jQuery.fn.extend({
      wrapAll: function (html) {
        var wrap;

        if (this[0]) {
          if (isFunction(html)) {
            html = html.call(this[0]);
          } // The elements to wrap the target around


          wrap = jQuery(html, this[0].ownerDocument).eq(0).clone(true);

          if (this[0].parentNode) {
            wrap.insertBefore(this[0]);
          }

          wrap.map(function () {
            var elem = this;

            while (elem.firstElementChild) {
              elem = elem.firstElementChild;
            }

            return elem;
          }).append(this);
        }

        return this;
      },
      wrapInner: function (html) {
        if (isFunction(html)) {
          return this.each(function (i) {
            jQuery(this).wrapInner(html.call(this, i));
          });
        }

        return this.each(function () {
          var self = jQuery(this),
              contents = self.contents();

          if (contents.length) {
            contents.wrapAll(html);
          } else {
            self.append(html);
          }
        });
      },
      wrap: function (html) {
        var htmlIsFunction = isFunction(html);
        return this.each(function (i) {
          jQuery(this).wrapAll(htmlIsFunction ? html.call(this, i) : html);
        });
      },
      unwrap: function (selector) {
        this.parent(selector).not("body").each(function () {
          jQuery(this).replaceWith(this.childNodes);
        });
        return this;
      }
    });

    jQuery.expr.pseudos.hidden = function (elem) {
      return !jQuery.expr.pseudos.visible(elem);
    };

    jQuery.expr.pseudos.visible = function (elem) {
      return !!(elem.offsetWidth || elem.offsetHeight || elem.getClientRects().length);
    };

    jQuery.ajaxSettings.xhr = function () {
      try {
        return new window.XMLHttpRequest();
      } catch (e) {}
    };

    var xhrSuccessStatus = {
      // File protocol always yields status code 0, assume 200
      0: 200,
      // Support: IE <=9 only
      // #1450: sometimes IE returns 1223 when it should be 204
      1223: 204
    },
        xhrSupported = jQuery.ajaxSettings.xhr();
    support.cors = !!xhrSupported && "withCredentials" in xhrSupported;
    support.ajax = xhrSupported = !!xhrSupported;
    jQuery.ajaxTransport(function (options) {
      var callback, errorCallback; // Cross domain only allowed if supported through XMLHttpRequest

      if (support.cors || xhrSupported && !options.crossDomain) {
        return {
          send: function (headers, complete) {
            var i,
                xhr = options.xhr();
            xhr.open(options.type, options.url, options.async, options.username, options.password); // Apply custom fields if provided

            if (options.xhrFields) {
              for (i in options.xhrFields) {
                xhr[i] = options.xhrFields[i];
              }
            } // Override mime type if needed


            if (options.mimeType && xhr.overrideMimeType) {
              xhr.overrideMimeType(options.mimeType);
            } // X-Requested-With header
            // For cross-domain requests, seeing as conditions for a preflight are
            // akin to a jigsaw puzzle, we simply never set it to be sure.
            // (it can always be set on a per-request basis or even using ajaxSetup)
            // For same-domain requests, won't change header if already provided.


            if (!options.crossDomain && !headers["X-Requested-With"]) {
              headers["X-Requested-With"] = "XMLHttpRequest";
            } // Set headers


            for (i in headers) {
              xhr.setRequestHeader(i, headers[i]);
            } // Callback


            callback = function (type) {
              return function () {
                if (callback) {
                  callback = errorCallback = xhr.onload = xhr.onerror = xhr.onabort = xhr.ontimeout = xhr.onreadystatechange = null;

                  if (type === "abort") {
                    xhr.abort();
                  } else if (type === "error") {
                    // Support: IE <=9 only
                    // On a manual native abort, IE9 throws
                    // errors on any property access that is not readyState
                    if (typeof xhr.status !== "number") {
                      complete(0, "error");
                    } else {
                      complete( // File: protocol always yields status 0; see #8605, #14207
                      xhr.status, xhr.statusText);
                    }
                  } else {
                    complete(xhrSuccessStatus[xhr.status] || xhr.status, xhr.statusText, // Support: IE <=9 only
                    // IE9 has no XHR2 but throws on binary (trac-11426)
                    // For XHR2 non-text, let the caller handle it (gh-2498)
                    (xhr.responseType || "text") !== "text" || typeof xhr.responseText !== "string" ? {
                      binary: xhr.response
                    } : {
                      text: xhr.responseText
                    }, xhr.getAllResponseHeaders());
                  }
                }
              };
            }; // Listen to events


            xhr.onload = callback();
            errorCallback = xhr.onerror = xhr.ontimeout = callback("error"); // Support: IE 9 only
            // Use onreadystatechange to replace onabort
            // to handle uncaught aborts

            if (xhr.onabort !== undefined) {
              xhr.onabort = errorCallback;
            } else {
              xhr.onreadystatechange = function () {
                // Check readyState before timeout as it changes
                if (xhr.readyState === 4) {
                  // Allow onerror to be called first,
                  // but that will not handle a native abort
                  // Also, save errorCallback to a variable
                  // as xhr.onerror cannot be accessed
                  window.setTimeout(function () {
                    if (callback) {
                      errorCallback();
                    }
                  });
                }
              };
            } // Create the abort callback


            callback = callback("abort");

            try {
              // Do send the request (this may raise an exception)
              xhr.send(options.hasContent && options.data || null);
            } catch (e) {
              // #14683: Only rethrow if this hasn't been notified as an error yet
              if (callback) {
                throw e;
              }
            }
          },
          abort: function () {
            if (callback) {
              callback();
            }
          }
        };
      }
    }); // Prevent auto-execution of scripts when no explicit dataType was provided (See gh-2432)

    jQuery.ajaxPrefilter(function (s) {
      if (s.crossDomain) {
        s.contents.script = false;
      }
    }); // Install script dataType

    jQuery.ajaxSetup({
      accepts: {
        script: "text/javascript, application/javascript, " + "application/ecmascript, application/x-ecmascript"
      },
      contents: {
        script: /\b(?:java|ecma)script\b/
      },
      converters: {
        "text script": function (text) {
          jQuery.globalEval(text);
          return text;
        }
      }
    }); // Handle cache's special case and crossDomain

    jQuery.ajaxPrefilter("script", function (s) {
      if (s.cache === undefined) {
        s.cache = false;
      }

      if (s.crossDomain) {
        s.type = "GET";
      }
    }); // Bind script tag hack transport

    jQuery.ajaxTransport("script", function (s) {
      // This transport only deals with cross domain or forced-by-attrs requests
      if (s.crossDomain || s.scriptAttrs) {
        var script, callback;
        return {
          send: function (_, complete) {
            script = jQuery("<script>").attr(s.scriptAttrs || {}).prop({
              charset: s.scriptCharset,
              src: s.url
            }).on("load error", callback = function (evt) {
              script.remove();
              callback = null;

              if (evt) {
                complete(evt.type === "error" ? 404 : 200, evt.type);
              }
            }); // Use native DOM manipulation to avoid our domManip AJAX trickery

            document.head.appendChild(script[0]);
          },
          abort: function () {
            if (callback) {
              callback();
            }
          }
        };
      }
    });
    var oldCallbacks = [],
        rjsonp = /(=)\?(?=&|$)|\?\?/; // Default jsonp settings

    jQuery.ajaxSetup({
      jsonp: "callback",
      jsonpCallback: function () {
        var callback = oldCallbacks.pop() || jQuery.expando + "_" + nonce.guid++;
        this[callback] = true;
        return callback;
      }
    }); // Detect, normalize options and install callbacks for jsonp requests

    jQuery.ajaxPrefilter("json jsonp", function (s, originalSettings, jqXHR) {
      var callbackName,
          overwritten,
          responseContainer,
          jsonProp = s.jsonp !== false && (rjsonp.test(s.url) ? "url" : typeof s.data === "string" && (s.contentType || "").indexOf("application/x-www-form-urlencoded") === 0 && rjsonp.test(s.data) && "data"); // Handle iff the expected data type is "jsonp" or we have a parameter to set

      if (jsonProp || s.dataTypes[0] === "jsonp") {
        // Get callback name, remembering preexisting value associated with it
        callbackName = s.jsonpCallback = isFunction(s.jsonpCallback) ? s.jsonpCallback() : s.jsonpCallback; // Insert callback into url or form data

        if (jsonProp) {
          s[jsonProp] = s[jsonProp].replace(rjsonp, "$1" + callbackName);
        } else if (s.jsonp !== false) {
          s.url += (rquery.test(s.url) ? "&" : "?") + s.jsonp + "=" + callbackName;
        } // Use data converter to retrieve json after script execution


        s.converters["script json"] = function () {
          if (!responseContainer) {
            jQuery.error(callbackName + " was not called");
          }

          return responseContainer[0];
        }; // Force json dataType


        s.dataTypes[0] = "json"; // Install callback

        overwritten = window[callbackName];

        window[callbackName] = function () {
          responseContainer = arguments;
        }; // Clean-up function (fires after converters)


        jqXHR.always(function () {
          // If previous value didn't exist - remove it
          if (overwritten === undefined) {
            jQuery(window).removeProp(callbackName); // Otherwise restore preexisting value
          } else {
            window[callbackName] = overwritten;
          } // Save back as free


          if (s[callbackName]) {
            // Make sure that re-using the options doesn't screw things around
            s.jsonpCallback = originalSettings.jsonpCallback; // Save the callback name for future use

            oldCallbacks.push(callbackName);
          } // Call if it was a function and we have a response


          if (responseContainer && isFunction(overwritten)) {
            overwritten(responseContainer[0]);
          }

          responseContainer = overwritten = undefined;
        }); // Delegate to script

        return "script";
      }
    }); // Support: Safari 8 only
    // In Safari 8 documents created via document.implementation.createHTMLDocument
    // collapse sibling forms: the second one becomes a child of the first one.
    // Because of that, this security measure has to be disabled in Safari 8.
    // https://bugs.webkit.org/show_bug.cgi?id=137337

    support.createHTMLDocument = function () {
      var body = document.implementation.createHTMLDocument("").body;
      body.innerHTML = "<form></form><form></form>";
      return body.childNodes.length === 2;
    }(); // Argument "data" should be string of html
    // context (optional): If specified, the fragment will be created in this context,
    // defaults to document
    // keepScripts (optional): If true, will include scripts passed in the html string


    jQuery.parseHTML = function (data, context, keepScripts) {
      if (typeof data !== "string") {
        return [];
      }

      if (typeof context === "boolean") {
        keepScripts = context;
        context = false;
      }

      var base, parsed, scripts;

      if (!context) {
        // Stop scripts or inline event handlers from being executed immediately
        // by using document.implementation
        if (support.createHTMLDocument) {
          context = document.implementation.createHTMLDocument(""); // Set the base href for the created document
          // so any parsed elements with URLs
          // are based on the document's URL (gh-2965)

          base = context.createElement("base");
          base.href = document.location.href;
          context.head.appendChild(base);
        } else {
          context = document;
        }
      }

      parsed = rsingleTag.exec(data);
      scripts = !keepScripts && []; // Single tag

      if (parsed) {
        return [context.createElement(parsed[1])];
      }

      parsed = buildFragment([data], context, scripts);

      if (scripts && scripts.length) {
        jQuery(scripts).remove();
      }

      return jQuery.merge([], parsed.childNodes);
    };
    /**
     * Load a url into a page
     */


    jQuery.fn.load = function (url, params, callback) {
      var selector,
          type,
          response,
          self = this,
          off = url.indexOf(" ");

      if (off > -1) {
        selector = stripAndCollapse(url.slice(off));
        url = url.slice(0, off);
      } // If it's a function


      if (isFunction(params)) {
        // We assume that it's the callback
        callback = params;
        params = undefined; // Otherwise, build a param string
      } else if (params && typeof params === "object") {
        type = "POST";
      } // If we have elements to modify, make the request


      if (self.length > 0) {
        jQuery.ajax({
          url: url,
          // If "type" variable is undefined, then "GET" method will be used.
          // Make value of this field explicit since
          // user can override it through ajaxSetup method
          type: type || "GET",
          dataType: "html",
          data: params
        }).done(function (responseText) {
          // Save response for use in complete callback
          response = arguments;
          self.html(selector ? // If a selector was specified, locate the right elements in a dummy div
          // Exclude scripts to avoid IE 'Permission Denied' errors
          jQuery("<div>").append(jQuery.parseHTML(responseText)).find(selector) : // Otherwise use the full result
          responseText); // If the request succeeds, this function gets "data", "status", "jqXHR"
          // but they are ignored because response was set above.
          // If it fails, this function gets "jqXHR", "status", "error"
        }).always(callback && function (jqXHR, status) {
          self.each(function () {
            callback.apply(this, response || [jqXHR.responseText, status, jqXHR]);
          });
        });
      }

      return this;
    };

    jQuery.expr.pseudos.animated = function (elem) {
      return jQuery.grep(jQuery.timers, function (fn) {
        return elem === fn.elem;
      }).length;
    };

    jQuery.offset = {
      setOffset: function (elem, options, i) {
        var curPosition,
            curLeft,
            curCSSTop,
            curTop,
            curOffset,
            curCSSLeft,
            calculatePosition,
            position = jQuery.css(elem, "position"),
            curElem = jQuery(elem),
            props = {}; // Set position first, in-case top/left are set even on static elem

        if (position === "static") {
          elem.style.position = "relative";
        }

        curOffset = curElem.offset();
        curCSSTop = jQuery.css(elem, "top");
        curCSSLeft = jQuery.css(elem, "left");
        calculatePosition = (position === "absolute" || position === "fixed") && (curCSSTop + curCSSLeft).indexOf("auto") > -1; // Need to be able to calculate position if either
        // top or left is auto and position is either absolute or fixed

        if (calculatePosition) {
          curPosition = curElem.position();
          curTop = curPosition.top;
          curLeft = curPosition.left;
        } else {
          curTop = parseFloat(curCSSTop) || 0;
          curLeft = parseFloat(curCSSLeft) || 0;
        }

        if (isFunction(options)) {
          // Use jQuery.extend here to allow modification of coordinates argument (gh-1848)
          options = options.call(elem, i, jQuery.extend({}, curOffset));
        }

        if (options.top != null) {
          props.top = options.top - curOffset.top + curTop;
        }

        if (options.left != null) {
          props.left = options.left - curOffset.left + curLeft;
        }

        if ("using" in options) {
          options.using.call(elem, props);
        } else {
          curElem.css(props);
        }
      }
    };
    jQuery.fn.extend({
      // offset() relates an element's border box to the document origin
      offset: function (options) {
        // Preserve chaining for setter
        if (arguments.length) {
          return options === undefined ? this : this.each(function (i) {
            jQuery.offset.setOffset(this, options, i);
          });
        }

        var rect,
            win,
            elem = this[0];

        if (!elem) {
          return;
        } // Return zeros for disconnected and hidden (display: none) elements (gh-2310)
        // Support: IE <=11 only
        // Running getBoundingClientRect on a
        // disconnected node in IE throws an error


        if (!elem.getClientRects().length) {
          return {
            top: 0,
            left: 0
          };
        } // Get document-relative position by adding viewport scroll to viewport-relative gBCR


        rect = elem.getBoundingClientRect();
        win = elem.ownerDocument.defaultView;
        return {
          top: rect.top + win.pageYOffset,
          left: rect.left + win.pageXOffset
        };
      },
      // position() relates an element's margin box to its offset parent's padding box
      // This corresponds to the behavior of CSS absolute positioning
      position: function () {
        if (!this[0]) {
          return;
        }

        var offsetParent,
            offset,
            doc,
            elem = this[0],
            parentOffset = {
          top: 0,
          left: 0
        }; // position:fixed elements are offset from the viewport, which itself always has zero offset

        if (jQuery.css(elem, "position") === "fixed") {
          // Assume position:fixed implies availability of getBoundingClientRect
          offset = elem.getBoundingClientRect();
        } else {
          offset = this.offset(); // Account for the *real* offset parent, which can be the document or its root element
          // when a statically positioned element is identified

          doc = elem.ownerDocument;
          offsetParent = elem.offsetParent || doc.documentElement;

          while (offsetParent && (offsetParent === doc.body || offsetParent === doc.documentElement) && jQuery.css(offsetParent, "position") === "static") {
            offsetParent = offsetParent.parentNode;
          }

          if (offsetParent && offsetParent !== elem && offsetParent.nodeType === 1) {
            // Incorporate borders into its offset, since they are outside its content origin
            parentOffset = jQuery(offsetParent).offset();
            parentOffset.top += jQuery.css(offsetParent, "borderTopWidth", true);
            parentOffset.left += jQuery.css(offsetParent, "borderLeftWidth", true);
          }
        } // Subtract parent offsets and element margins


        return {
          top: offset.top - parentOffset.top - jQuery.css(elem, "marginTop", true),
          left: offset.left - parentOffset.left - jQuery.css(elem, "marginLeft", true)
        };
      },
      // This method will return documentElement in the following cases:
      // 1) For the element inside the iframe without offsetParent, this method will return
      //    documentElement of the parent window
      // 2) For the hidden or detached element
      // 3) For body or html element, i.e. in case of the html node - it will return itself
      //
      // but those exceptions were never presented as a real life use-cases
      // and might be considered as more preferable results.
      //
      // This logic, however, is not guaranteed and can change at any point in the future
      offsetParent: function () {
        return this.map(function () {
          var offsetParent = this.offsetParent;

          while (offsetParent && jQuery.css(offsetParent, "position") === "static") {
            offsetParent = offsetParent.offsetParent;
          }

          return offsetParent || documentElement;
        });
      }
    }); // Create scrollLeft and scrollTop methods

    jQuery.each({
      scrollLeft: "pageXOffset",
      scrollTop: "pageYOffset"
    }, function (method, prop) {
      var top = "pageYOffset" === prop;

      jQuery.fn[method] = function (val) {
        return access(this, function (elem, method, val) {
          // Coalesce documents and windows
          var win;

          if (isWindow(elem)) {
            win = elem;
          } else if (elem.nodeType === 9) {
            win = elem.defaultView;
          }

          if (val === undefined) {
            return win ? win[prop] : elem[method];
          }

          if (win) {
            win.scrollTo(!top ? val : win.pageXOffset, top ? val : win.pageYOffset);
          } else {
            elem[method] = val;
          }
        }, method, val, arguments.length);
      };
    }); // Support: Safari <=7 - 9.1, Chrome <=37 - 49
    // Add the top/left cssHooks using jQuery.fn.position
    // Webkit bug: https://bugs.webkit.org/show_bug.cgi?id=29084
    // Blink bug: https://bugs.chromium.org/p/chromium/issues/detail?id=589347
    // getComputedStyle returns percent when specified for top/left/bottom/right;
    // rather than make the css module depend on the offset module, just check for it here

    jQuery.each(["top", "left"], function (_i, prop) {
      jQuery.cssHooks[prop] = addGetHookIf(support.pixelPosition, function (elem, computed) {
        if (computed) {
          computed = curCSS(elem, prop); // If curCSS returns percentage, fallback to offset

          return rnumnonpx.test(computed) ? jQuery(elem).position()[prop] + "px" : computed;
        }
      });
    }); // Create innerHeight, innerWidth, height, width, outerHeight and outerWidth methods

    jQuery.each({
      Height: "height",
      Width: "width"
    }, function (name, type) {
      jQuery.each({
        padding: "inner" + name,
        content: type,
        "": "outer" + name
      }, function (defaultExtra, funcName) {
        // Margin is only for outerHeight, outerWidth
        jQuery.fn[funcName] = function (margin, value) {
          var chainable = arguments.length && (defaultExtra || typeof margin !== "boolean"),
              extra = defaultExtra || (margin === true || value === true ? "margin" : "border");
          return access(this, function (elem, type, value) {
            var doc;

            if (isWindow(elem)) {
              // $( window ).outerWidth/Height return w/h including scrollbars (gh-1729)
              return funcName.indexOf("outer") === 0 ? elem["inner" + name] : elem.document.documentElement["client" + name];
            } // Get document width or height


            if (elem.nodeType === 9) {
              doc = elem.documentElement; // Either scroll[Width/Height] or offset[Width/Height] or client[Width/Height],
              // whichever is greatest

              return Math.max(elem.body["scroll" + name], doc["scroll" + name], elem.body["offset" + name], doc["offset" + name], doc["client" + name]);
            }

            return value === undefined ? // Get width or height on the element, requesting but not forcing parseFloat
            jQuery.css(elem, type, extra) : // Set width or height on the element
            jQuery.style(elem, type, value, extra);
          }, type, chainable ? margin : undefined, chainable);
        };
      });
    });
    jQuery.each(["ajaxStart", "ajaxStop", "ajaxComplete", "ajaxError", "ajaxSuccess", "ajaxSend"], function (_i, type) {
      jQuery.fn[type] = function (fn) {
        return this.on(type, fn);
      };
    });
    jQuery.fn.extend({
      bind: function (types, data, fn) {
        return this.on(types, null, data, fn);
      },
      unbind: function (types, fn) {
        return this.off(types, null, fn);
      },
      delegate: function (selector, types, data, fn) {
        return this.on(types, selector, data, fn);
      },
      undelegate: function (selector, types, fn) {
        // ( namespace ) or ( selector, types [, fn] )
        return arguments.length === 1 ? this.off(selector, "**") : this.off(types, selector || "**", fn);
      },
      hover: function (fnOver, fnOut) {
        return this.mouseenter(fnOver).mouseleave(fnOut || fnOver);
      }
    });
    jQuery.each(("blur focus focusin focusout resize scroll click dblclick " + "mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave " + "change select submit keydown keypress keyup contextmenu").split(" "), function (_i, name) {
      // Handle event binding
      jQuery.fn[name] = function (data, fn) {
        return arguments.length > 0 ? this.on(name, null, data, fn) : this.trigger(name);
      };
    }); // Support: Android <=4.0 only
    // Make sure we trim BOM and NBSP

    var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g; // Bind a function to a context, optionally partially applying any
    // arguments.
    // jQuery.proxy is deprecated to promote standards (specifically Function#bind)
    // However, it is not slated for removal any time soon

    jQuery.proxy = function (fn, context) {
      var tmp, args, proxy;

      if (typeof context === "string") {
        tmp = fn[context];
        context = fn;
        fn = tmp;
      } // Quick check to determine if target is callable, in the spec
      // this throws a TypeError, but we will just return undefined.


      if (!isFunction(fn)) {
        return undefined;
      } // Simulated bind


      args = slice.call(arguments, 2);

      proxy = function () {
        return fn.apply(context || this, args.concat(slice.call(arguments)));
      }; // Set the guid of unique handler to the same of original handler, so it can be removed


      proxy.guid = fn.guid = fn.guid || jQuery.guid++;
      return proxy;
    };

    jQuery.holdReady = function (hold) {
      if (hold) {
        jQuery.readyWait++;
      } else {
        jQuery.ready(true);
      }
    };

    jQuery.isArray = Array.isArray;
    jQuery.parseJSON = JSON.parse;
    jQuery.nodeName = nodeName;
    jQuery.isFunction = isFunction;
    jQuery.isWindow = isWindow;
    jQuery.camelCase = camelCase;
    jQuery.type = toType;
    jQuery.now = Date.now;

    jQuery.isNumeric = function (obj) {
      // As of jQuery 3.0, isNumeric is limited to
      // strings and numbers (primitives or objects)
      // that can be coerced to finite numbers (gh-2662)
      var type = jQuery.type(obj);
      return (type === "number" || type === "string") && // parseFloat NaNs numeric-cast false positives ("")
      // ...but misinterprets leading-number strings, particularly hex literals ("0x...")
      // subtraction forces infinities to NaN
      !isNaN(obj - parseFloat(obj));
    };

    jQuery.trim = function (text) {
      return text == null ? "" : (text + "").replace(rtrim, "");
    }; // Register as a named AMD module, since jQuery can be concatenated with other

    var // Map over jQuery in case of overwrite
    _jQuery = window.jQuery,
        // Map over the $ in case of overwrite
    _$ = window.$;

    jQuery.noConflict = function (deep) {
      if (window.$ === jQuery) {
        window.$ = _$;
      }

      if (deep && window.jQuery === jQuery) {
        window.jQuery = _jQuery;
      }

      return jQuery;
    }; // Expose jQuery and $ identifiers, even in AMD
    // (#7102#comment:10, https://github.com/jquery/jquery/pull/557)
    // and CommonJS for browser emulators (#13566)


    if (typeof noGlobal === "undefined") {
      window.jQuery = window.$ = jQuery;
    }

    return jQuery;
  });
});

/* global window */
var lodash$1;

if (typeof commonjsRequire === "function") {
  try {
    lodash$1 = {
      clone: require$$0__default["default"],
      constant: require$$1__default["default"],
      each: require$$2__default["default"],
      filter: require$$3__default["default"],
      has: require$$4__default["default"],
      isArray: require$$5__default["default"],
      isEmpty: require$$6__default["default"],
      isFunction: require$$7__default["default"],
      isUndefined: require$$8__default["default"],
      keys: require$$9__default["default"],
      map: require$$10__default["default"],
      reduce: require$$11__default["default"],
      size: require$$12__default["default"],
      transform: require$$13__default["default"],
      union: require$$14__default["default"],
      values: require$$15__default["default"]
    };
  } catch (e) {// continue regardless of error
  }
}

if (!lodash$1) {
  lodash$1 = window._;
}

var lodash_1$1 = lodash$1;

var graph = Graph$8;
var DEFAULT_EDGE_NAME = "\x00";
var GRAPH_NODE = "\x00";
var EDGE_KEY_DELIM = "\x01"; // Implementation notes:
//
//  * Node id query functions should return string ids for the nodes
//  * Edge id query functions should return an "edgeObj", edge object, that is
//    composed of enough information to uniquely identify an edge: {v, w, name}.
//  * Internally we use an "edgeId", a stringified form of the edgeObj, to
//    reference edges. This is because we need a performant way to look these
//    edges up and, object properties, which have string keys, are the closest
//    we're going to get to a performant hashtable in JavaScript.

function Graph$8(opts) {
  this._isDirected = lodash_1$1.has(opts, "directed") ? opts.directed : true;
  this._isMultigraph = lodash_1$1.has(opts, "multigraph") ? opts.multigraph : false;
  this._isCompound = lodash_1$1.has(opts, "compound") ? opts.compound : false; // Label for the graph itself

  this._label = undefined; // Defaults to be set when creating a new node

  this._defaultNodeLabelFn = lodash_1$1.constant(undefined); // Defaults to be set when creating a new edge

  this._defaultEdgeLabelFn = lodash_1$1.constant(undefined); // v -> label

  this._nodes = {};

  if (this._isCompound) {
    // v -> parent
    this._parent = {}; // v -> children

    this._children = {};
    this._children[GRAPH_NODE] = {};
  } // v -> edgeObj


  this._in = {}; // u -> v -> Number

  this._preds = {}; // v -> edgeObj

  this._out = {}; // v -> w -> Number

  this._sucs = {}; // e -> edgeObj

  this._edgeObjs = {}; // e -> label

  this._edgeLabels = {};
}
/* Number of nodes in the graph. Should only be changed by the implementation. */


Graph$8.prototype._nodeCount = 0;
/* Number of edges in the graph. Should only be changed by the implementation. */

Graph$8.prototype._edgeCount = 0;
/* === Graph functions ========= */

Graph$8.prototype.isDirected = function () {
  return this._isDirected;
};

Graph$8.prototype.isMultigraph = function () {
  return this._isMultigraph;
};

Graph$8.prototype.isCompound = function () {
  return this._isCompound;
};

Graph$8.prototype.setGraph = function (label) {
  this._label = label;
  return this;
};

Graph$8.prototype.graph = function () {
  return this._label;
};
/* === Node functions ========== */


Graph$8.prototype.setDefaultNodeLabel = function (newDefault) {
  if (!lodash_1$1.isFunction(newDefault)) {
    newDefault = lodash_1$1.constant(newDefault);
  }

  this._defaultNodeLabelFn = newDefault;
  return this;
};

Graph$8.prototype.nodeCount = function () {
  return this._nodeCount;
};

Graph$8.prototype.nodes = function () {
  return lodash_1$1.keys(this._nodes);
};

Graph$8.prototype.sources = function () {
  var self = this;
  return lodash_1$1.filter(this.nodes(), function (v) {
    return lodash_1$1.isEmpty(self._in[v]);
  });
};

Graph$8.prototype.sinks = function () {
  var self = this;
  return lodash_1$1.filter(this.nodes(), function (v) {
    return lodash_1$1.isEmpty(self._out[v]);
  });
};

Graph$8.prototype.setNodes = function (vs, value) {
  var args = arguments;
  var self = this;

  lodash_1$1.each(vs, function (v) {
    if (args.length > 1) {
      self.setNode(v, value);
    } else {
      self.setNode(v);
    }
  });

  return this;
};

Graph$8.prototype.setNode = function (v, value) {
  if (lodash_1$1.has(this._nodes, v)) {
    if (arguments.length > 1) {
      this._nodes[v] = value;
    }

    return this;
  }

  this._nodes[v] = arguments.length > 1 ? value : this._defaultNodeLabelFn(v);

  if (this._isCompound) {
    this._parent[v] = GRAPH_NODE;
    this._children[v] = {};
    this._children[GRAPH_NODE][v] = true;
  }

  this._in[v] = {};
  this._preds[v] = {};
  this._out[v] = {};
  this._sucs[v] = {};
  ++this._nodeCount;
  return this;
};

Graph$8.prototype.node = function (v) {
  return this._nodes[v];
};

Graph$8.prototype.hasNode = function (v) {
  return lodash_1$1.has(this._nodes, v);
};

Graph$8.prototype.removeNode = function (v) {
  var self = this;

  if (lodash_1$1.has(this._nodes, v)) {
    var removeEdge = function (e) {
      self.removeEdge(self._edgeObjs[e]);
    };

    delete this._nodes[v];

    if (this._isCompound) {
      this._removeFromParentsChildList(v);

      delete this._parent[v];

      lodash_1$1.each(this.children(v), function (child) {
        self.setParent(child);
      });

      delete this._children[v];
    }

    lodash_1$1.each(lodash_1$1.keys(this._in[v]), removeEdge);

    delete this._in[v];
    delete this._preds[v];

    lodash_1$1.each(lodash_1$1.keys(this._out[v]), removeEdge);

    delete this._out[v];
    delete this._sucs[v];
    --this._nodeCount;
  }

  return this;
};

Graph$8.prototype.setParent = function (v, parent) {
  if (!this._isCompound) {
    throw new Error("Cannot set parent in a non-compound graph");
  }

  if (lodash_1$1.isUndefined(parent)) {
    parent = GRAPH_NODE;
  } else {
    // Coerce parent to string
    parent += "";

    for (var ancestor = parent; !lodash_1$1.isUndefined(ancestor); ancestor = this.parent(ancestor)) {
      if (ancestor === v) {
        throw new Error("Setting " + parent + " as parent of " + v + " would create a cycle");
      }
    }

    this.setNode(parent);
  }

  this.setNode(v);

  this._removeFromParentsChildList(v);

  this._parent[v] = parent;
  this._children[parent][v] = true;
  return this;
};

Graph$8.prototype._removeFromParentsChildList = function (v) {
  delete this._children[this._parent[v]][v];
};

Graph$8.prototype.parent = function (v) {
  if (this._isCompound) {
    var parent = this._parent[v];

    if (parent !== GRAPH_NODE) {
      return parent;
    }
  }
};

Graph$8.prototype.children = function (v) {
  if (lodash_1$1.isUndefined(v)) {
    v = GRAPH_NODE;
  }

  if (this._isCompound) {
    var children = this._children[v];

    if (children) {
      return lodash_1$1.keys(children);
    }
  } else if (v === GRAPH_NODE) {
    return this.nodes();
  } else if (this.hasNode(v)) {
    return [];
  }
};

Graph$8.prototype.predecessors = function (v) {
  var predsV = this._preds[v];

  if (predsV) {
    return lodash_1$1.keys(predsV);
  }
};

Graph$8.prototype.successors = function (v) {
  var sucsV = this._sucs[v];

  if (sucsV) {
    return lodash_1$1.keys(sucsV);
  }
};

Graph$8.prototype.neighbors = function (v) {
  var preds = this.predecessors(v);

  if (preds) {
    return lodash_1$1.union(preds, this.successors(v));
  }
};

Graph$8.prototype.isLeaf = function (v) {
  var neighbors;

  if (this.isDirected()) {
    neighbors = this.successors(v);
  } else {
    neighbors = this.neighbors(v);
  }

  return neighbors.length === 0;
};

Graph$8.prototype.filterNodes = function (filter) {
  var copy = new this.constructor({
    directed: this._isDirected,
    multigraph: this._isMultigraph,
    compound: this._isCompound
  });
  copy.setGraph(this.graph());
  var self = this;

  lodash_1$1.each(this._nodes, function (value, v) {
    if (filter(v)) {
      copy.setNode(v, value);
    }
  });

  lodash_1$1.each(this._edgeObjs, function (e) {
    if (copy.hasNode(e.v) && copy.hasNode(e.w)) {
      copy.setEdge(e, self.edge(e));
    }
  });

  var parents = {};

  function findParent(v) {
    var parent = self.parent(v);

    if (parent === undefined || copy.hasNode(parent)) {
      parents[v] = parent;
      return parent;
    } else if (parent in parents) {
      return parents[parent];
    } else {
      return findParent(parent);
    }
  }

  if (this._isCompound) {
    lodash_1$1.each(copy.nodes(), function (v) {
      copy.setParent(v, findParent(v));
    });
  }

  return copy;
};
/* === Edge functions ========== */


Graph$8.prototype.setDefaultEdgeLabel = function (newDefault) {
  if (!lodash_1$1.isFunction(newDefault)) {
    newDefault = lodash_1$1.constant(newDefault);
  }

  this._defaultEdgeLabelFn = newDefault;
  return this;
};

Graph$8.prototype.edgeCount = function () {
  return this._edgeCount;
};

Graph$8.prototype.edges = function () {
  return lodash_1$1.values(this._edgeObjs);
};

Graph$8.prototype.setPath = function (vs, value) {
  var self = this;
  var args = arguments;

  lodash_1$1.reduce(vs, function (v, w) {
    if (args.length > 1) {
      self.setEdge(v, w, value);
    } else {
      self.setEdge(v, w);
    }

    return w;
  });

  return this;
};
/*
 * setEdge(v, w, [value, [name]])
 * setEdge({ v, w, [name] }, [value])
 */


Graph$8.prototype.setEdge = function () {
  var v, w, name, value;
  var valueSpecified = false;
  var arg0 = arguments[0];

  if (typeof arg0 === "object" && arg0 !== null && "v" in arg0) {
    v = arg0.v;
    w = arg0.w;
    name = arg0.name;

    if (arguments.length === 2) {
      value = arguments[1];
      valueSpecified = true;
    }
  } else {
    v = arg0;
    w = arguments[1];
    name = arguments[3];

    if (arguments.length > 2) {
      value = arguments[2];
      valueSpecified = true;
    }
  }

  v = "" + v;
  w = "" + w;

  if (!lodash_1$1.isUndefined(name)) {
    name = "" + name;
  }

  var e = edgeArgsToId(this._isDirected, v, w, name);

  if (lodash_1$1.has(this._edgeLabels, e)) {
    if (valueSpecified) {
      this._edgeLabels[e] = value;
    }

    return this;
  }

  if (!lodash_1$1.isUndefined(name) && !this._isMultigraph) {
    throw new Error("Cannot set a named edge when isMultigraph = false");
  } // It didn't exist, so we need to create it.
  // First ensure the nodes exist.


  this.setNode(v);
  this.setNode(w);
  this._edgeLabels[e] = valueSpecified ? value : this._defaultEdgeLabelFn(v, w, name);
  var edgeObj = edgeArgsToObj(this._isDirected, v, w, name); // Ensure we add undirected edges in a consistent way.

  v = edgeObj.v;
  w = edgeObj.w;
  Object.freeze(edgeObj);
  this._edgeObjs[e] = edgeObj;
  incrementOrInitEntry(this._preds[w], v);
  incrementOrInitEntry(this._sucs[v], w);
  this._in[w][e] = edgeObj;
  this._out[v][e] = edgeObj;
  this._edgeCount++;
  return this;
};

Graph$8.prototype.edge = function (v, w, name) {
  var e = arguments.length === 1 ? edgeObjToId(this._isDirected, arguments[0]) : edgeArgsToId(this._isDirected, v, w, name);
  return this._edgeLabels[e];
};

Graph$8.prototype.hasEdge = function (v, w, name) {
  var e = arguments.length === 1 ? edgeObjToId(this._isDirected, arguments[0]) : edgeArgsToId(this._isDirected, v, w, name);
  return lodash_1$1.has(this._edgeLabels, e);
};

Graph$8.prototype.removeEdge = function (v, w, name) {
  var e = arguments.length === 1 ? edgeObjToId(this._isDirected, arguments[0]) : edgeArgsToId(this._isDirected, v, w, name);
  var edge = this._edgeObjs[e];

  if (edge) {
    v = edge.v;
    w = edge.w;
    delete this._edgeLabels[e];
    delete this._edgeObjs[e];
    decrementOrRemoveEntry(this._preds[w], v);
    decrementOrRemoveEntry(this._sucs[v], w);
    delete this._in[w][e];
    delete this._out[v][e];
    this._edgeCount--;
  }

  return this;
};

Graph$8.prototype.inEdges = function (v, u) {
  var inV = this._in[v];

  if (inV) {
    var edges = lodash_1$1.values(inV);

    if (!u) {
      return edges;
    }

    return lodash_1$1.filter(edges, function (edge) {
      return edge.v === u;
    });
  }
};

Graph$8.prototype.outEdges = function (v, w) {
  var outV = this._out[v];

  if (outV) {
    var edges = lodash_1$1.values(outV);

    if (!w) {
      return edges;
    }

    return lodash_1$1.filter(edges, function (edge) {
      return edge.w === w;
    });
  }
};

Graph$8.prototype.nodeEdges = function (v, w) {
  var inEdges = this.inEdges(v, w);

  if (inEdges) {
    return inEdges.concat(this.outEdges(v, w));
  }
};

function incrementOrInitEntry(map, k) {
  if (map[k]) {
    map[k]++;
  } else {
    map[k] = 1;
  }
}

function decrementOrRemoveEntry(map, k) {
  if (! --map[k]) {
    delete map[k];
  }
}

function edgeArgsToId(isDirected, v_, w_, name) {
  var v = "" + v_;
  var w = "" + w_;

  if (!isDirected && v > w) {
    var tmp = v;
    v = w;
    w = tmp;
  }

  return v + EDGE_KEY_DELIM + w + EDGE_KEY_DELIM + (lodash_1$1.isUndefined(name) ? DEFAULT_EDGE_NAME : name);
}

function edgeArgsToObj(isDirected, v_, w_, name) {
  var v = "" + v_;
  var w = "" + w_;

  if (!isDirected && v > w) {
    var tmp = v;
    v = w;
    w = tmp;
  }

  var edgeObj = {
    v: v,
    w: w
  };

  if (name) {
    edgeObj.name = name;
  }

  return edgeObj;
}

function edgeObjToId(isDirected, edgeObj) {
  return edgeArgsToId(isDirected, edgeObj.v, edgeObj.w, edgeObj.name);
}

var version$1 = '2.1.8';

var lib = {
  Graph: graph,
  version: version$1
};

var json = {
  write: write,
  read: read
};

function write(g) {
  var json = {
    options: {
      directed: g.isDirected(),
      multigraph: g.isMultigraph(),
      compound: g.isCompound()
    },
    nodes: writeNodes(g),
    edges: writeEdges(g)
  };

  if (!lodash_1$1.isUndefined(g.graph())) {
    json.value = lodash_1$1.clone(g.graph());
  }

  return json;
}

function writeNodes(g) {
  return lodash_1$1.map(g.nodes(), function (v) {
    var nodeValue = g.node(v);
    var parent = g.parent(v);
    var node = {
      v: v
    };

    if (!lodash_1$1.isUndefined(nodeValue)) {
      node.value = nodeValue;
    }

    if (!lodash_1$1.isUndefined(parent)) {
      node.parent = parent;
    }

    return node;
  });
}

function writeEdges(g) {
  return lodash_1$1.map(g.edges(), function (e) {
    var edgeValue = g.edge(e);
    var edge = {
      v: e.v,
      w: e.w
    };

    if (!lodash_1$1.isUndefined(e.name)) {
      edge.name = e.name;
    }

    if (!lodash_1$1.isUndefined(edgeValue)) {
      edge.value = edgeValue;
    }

    return edge;
  });
}

function read(json) {
  var g = new graph(json.options).setGraph(json.value);

  lodash_1$1.each(json.nodes, function (entry) {
    g.setNode(entry.v, entry.value);

    if (entry.parent) {
      g.setParent(entry.v, entry.parent);
    }
  });

  lodash_1$1.each(json.edges, function (entry) {
    g.setEdge({
      v: entry.v,
      w: entry.w,
      name: entry.name
    }, entry.value);
  });

  return g;
}

var components_1 = components;

function components(g) {
  var visited = {};
  var cmpts = [];
  var cmpt;

  function dfs(v) {
    if (lodash_1$1.has(visited, v)) return;
    visited[v] = true;
    cmpt.push(v);

    lodash_1$1.each(g.successors(v), dfs);

    lodash_1$1.each(g.predecessors(v), dfs);
  }

  lodash_1$1.each(g.nodes(), function (v) {
    cmpt = [];
    dfs(v);

    if (cmpt.length) {
      cmpts.push(cmpt);
    }
  });

  return cmpts;
}

var priorityQueue = PriorityQueue;
/**
 * A min-priority queue data structure. This algorithm is derived from Cormen,
 * et al., "Introduction to Algorithms". The basic idea of a min-priority
 * queue is that you can efficiently (in O(1) time) get the smallest key in
 * the queue. Adding and removing elements takes O(log n) time. A key can
 * have its priority decreased in O(log n) time.
 */

function PriorityQueue() {
  this._arr = [];
  this._keyIndices = {};
}
/**
 * Returns the number of elements in the queue. Takes `O(1)` time.
 */


PriorityQueue.prototype.size = function () {
  return this._arr.length;
};
/**
 * Returns the keys that are in the queue. Takes `O(n)` time.
 */


PriorityQueue.prototype.keys = function () {
  return this._arr.map(function (x) {
    return x.key;
  });
};
/**
 * Returns `true` if **key** is in the queue and `false` if not.
 */


PriorityQueue.prototype.has = function (key) {
  return lodash_1$1.has(this._keyIndices, key);
};
/**
 * Returns the priority for **key**. If **key** is not present in the queue
 * then this function returns `undefined`. Takes `O(1)` time.
 *
 * @param {Object} key
 */


PriorityQueue.prototype.priority = function (key) {
  var index = this._keyIndices[key];

  if (index !== undefined) {
    return this._arr[index].priority;
  }
};
/**
 * Returns the key for the minimum element in this queue. If the queue is
 * empty this function throws an Error. Takes `O(1)` time.
 */


PriorityQueue.prototype.min = function () {
  if (this.size() === 0) {
    throw new Error("Queue underflow");
  }

  return this._arr[0].key;
};
/**
 * Inserts a new key into the priority queue. If the key already exists in
 * the queue this function returns `false`; otherwise it will return `true`.
 * Takes `O(n)` time.
 *
 * @param {Object} key the key to add
 * @param {Number} priority the initial priority for the key
 */


PriorityQueue.prototype.add = function (key, priority) {
  var keyIndices = this._keyIndices;
  key = String(key);

  if (!lodash_1$1.has(keyIndices, key)) {
    var arr = this._arr;
    var index = arr.length;
    keyIndices[key] = index;
    arr.push({
      key: key,
      priority: priority
    });

    this._decrease(index);

    return true;
  }

  return false;
};
/**
 * Removes and returns the smallest key in the queue. Takes `O(log n)` time.
 */


PriorityQueue.prototype.removeMin = function () {
  this._swap(0, this._arr.length - 1);

  var min = this._arr.pop();

  delete this._keyIndices[min.key];

  this._heapify(0);

  return min.key;
};
/**
 * Decreases the priority for **key** to **priority**. If the new priority is
 * greater than the previous priority, this function will throw an Error.
 *
 * @param {Object} key the key for which to raise priority
 * @param {Number} priority the new priority for the key
 */


PriorityQueue.prototype.decrease = function (key, priority) {
  var index = this._keyIndices[key];

  if (priority > this._arr[index].priority) {
    throw new Error("New priority is greater than current priority. " + "Key: " + key + " Old: " + this._arr[index].priority + " New: " + priority);
  }

  this._arr[index].priority = priority;

  this._decrease(index);
};

PriorityQueue.prototype._heapify = function (i) {
  var arr = this._arr;
  var l = 2 * i;
  var r = l + 1;
  var largest = i;

  if (l < arr.length) {
    largest = arr[l].priority < arr[largest].priority ? l : largest;

    if (r < arr.length) {
      largest = arr[r].priority < arr[largest].priority ? r : largest;
    }

    if (largest !== i) {
      this._swap(i, largest);

      this._heapify(largest);
    }
  }
};

PriorityQueue.prototype._decrease = function (index) {
  var arr = this._arr;
  var priority = arr[index].priority;
  var parent;

  while (index !== 0) {
    parent = index >> 1;

    if (arr[parent].priority < priority) {
      break;
    }

    this._swap(index, parent);

    index = parent;
  }
};

PriorityQueue.prototype._swap = function (i, j) {
  var arr = this._arr;
  var keyIndices = this._keyIndices;
  var origArrI = arr[i];
  var origArrJ = arr[j];
  arr[i] = origArrJ;
  arr[j] = origArrI;
  keyIndices[origArrJ.key] = i;
  keyIndices[origArrI.key] = j;
};

var dijkstra_1 = dijkstra;

var DEFAULT_WEIGHT_FUNC$1 = lodash_1$1.constant(1);

function dijkstra(g, source, weightFn, edgeFn) {
  return runDijkstra(g, String(source), weightFn || DEFAULT_WEIGHT_FUNC$1, edgeFn || function (v) {
    return g.outEdges(v);
  });
}

function runDijkstra(g, source, weightFn, edgeFn) {
  var results = {};
  var pq = new priorityQueue();
  var v, vEntry;

  var updateNeighbors = function (edge) {
    var w = edge.v !== v ? edge.v : edge.w;
    var wEntry = results[w];
    var weight = weightFn(edge);
    var distance = vEntry.distance + weight;

    if (weight < 0) {
      throw new Error("dijkstra does not allow negative edge weights. " + "Bad edge: " + edge + " Weight: " + weight);
    }

    if (distance < wEntry.distance) {
      wEntry.distance = distance;
      wEntry.predecessor = v;
      pq.decrease(w, distance);
    }
  };

  g.nodes().forEach(function (v) {
    var distance = v === source ? 0 : Number.POSITIVE_INFINITY;
    results[v] = {
      distance: distance
    };
    pq.add(v, distance);
  });

  while (pq.size() > 0) {
    v = pq.removeMin();
    vEntry = results[v];

    if (vEntry.distance === Number.POSITIVE_INFINITY) {
      break;
    }

    edgeFn(v).forEach(updateNeighbors);
  }

  return results;
}

var dijkstraAll_1 = dijkstraAll;

function dijkstraAll(g, weightFunc, edgeFunc) {
  return lodash_1$1.transform(g.nodes(), function (acc, v) {
    acc[v] = dijkstra_1(g, v, weightFunc, edgeFunc);
  }, {});
}

var tarjan_1 = tarjan;

function tarjan(g) {
  var index = 0;
  var stack = [];
  var visited = {}; // node id -> { onStack, lowlink, index }

  var results = [];

  function dfs(v) {
    var entry = visited[v] = {
      onStack: true,
      lowlink: index,
      index: index++
    };
    stack.push(v);
    g.successors(v).forEach(function (w) {
      if (!lodash_1$1.has(visited, w)) {
        dfs(w);
        entry.lowlink = Math.min(entry.lowlink, visited[w].lowlink);
      } else if (visited[w].onStack) {
        entry.lowlink = Math.min(entry.lowlink, visited[w].index);
      }
    });

    if (entry.lowlink === entry.index) {
      var cmpt = [];
      var w;

      do {
        w = stack.pop();
        visited[w].onStack = false;
        cmpt.push(w);
      } while (v !== w);

      results.push(cmpt);
    }
  }

  g.nodes().forEach(function (v) {
    if (!lodash_1$1.has(visited, v)) {
      dfs(v);
    }
  });
  return results;
}

var findCycles_1 = findCycles;

function findCycles(g) {
  return lodash_1$1.filter(tarjan_1(g), function (cmpt) {
    return cmpt.length > 1 || cmpt.length === 1 && g.hasEdge(cmpt[0], cmpt[0]);
  });
}

var floydWarshall_1 = floydWarshall;

var DEFAULT_WEIGHT_FUNC = lodash_1$1.constant(1);

function floydWarshall(g, weightFn, edgeFn) {
  return runFloydWarshall(g, weightFn || DEFAULT_WEIGHT_FUNC, edgeFn || function (v) {
    return g.outEdges(v);
  });
}

function runFloydWarshall(g, weightFn, edgeFn) {
  var results = {};
  var nodes = g.nodes();
  nodes.forEach(function (v) {
    results[v] = {};
    results[v][v] = {
      distance: 0
    };
    nodes.forEach(function (w) {
      if (v !== w) {
        results[v][w] = {
          distance: Number.POSITIVE_INFINITY
        };
      }
    });
    edgeFn(v).forEach(function (edge) {
      var w = edge.v === v ? edge.w : edge.v;
      var d = weightFn(edge);
      results[v][w] = {
        distance: d,
        predecessor: v
      };
    });
  });
  nodes.forEach(function (k) {
    var rowK = results[k];
    nodes.forEach(function (i) {
      var rowI = results[i];
      nodes.forEach(function (j) {
        var ik = rowI[k];
        var kj = rowK[j];
        var ij = rowI[j];
        var altDistance = ik.distance + kj.distance;

        if (altDistance < ij.distance) {
          ij.distance = altDistance;
          ij.predecessor = kj.predecessor;
        }
      });
    });
  });
  return results;
}

var topsort_1 = topsort;
topsort.CycleException = CycleException;

function topsort(g) {
  var visited = {};
  var stack = {};
  var results = [];

  function visit(node) {
    if (lodash_1$1.has(stack, node)) {
      throw new CycleException();
    }

    if (!lodash_1$1.has(visited, node)) {
      stack[node] = true;
      visited[node] = true;

      lodash_1$1.each(g.predecessors(node), visit);

      delete stack[node];
      results.push(node);
    }
  }

  lodash_1$1.each(g.sinks(), visit);

  if (lodash_1$1.size(visited) !== g.nodeCount()) {
    throw new CycleException();
  }

  return results;
}

function CycleException() {}

CycleException.prototype = new Error(); // must be an instance of Error to pass testing

var isAcyclic_1 = isAcyclic;

function isAcyclic(g) {
  try {
    topsort_1(g);
  } catch (e) {
    if (e instanceof topsort_1.CycleException) {
      return false;
    }

    throw e;
  }

  return true;
}

var dfs_1 = dfs$1;
/*
 * A helper that preforms a pre- or post-order traversal on the input graph
 * and returns the nodes in the order they were visited. If the graph is
 * undirected then this algorithm will navigate using neighbors. If the graph
 * is directed then this algorithm will navigate using successors.
 *
 * Order must be one of "pre" or "post".
 */

function dfs$1(g, vs, order) {
  if (!lodash_1$1.isArray(vs)) {
    vs = [vs];
  }

  var navigation = (g.isDirected() ? g.successors : g.neighbors).bind(g);
  var acc = [];
  var visited = {};

  lodash_1$1.each(vs, function (v) {
    if (!g.hasNode(v)) {
      throw new Error("Graph does not have node: " + v);
    }

    doDfs(g, v, order === "post", visited, navigation, acc);
  });

  return acc;
}

function doDfs(g, v, postorder, visited, navigation, acc) {
  if (!lodash_1$1.has(visited, v)) {
    visited[v] = true;

    if (!postorder) {
      acc.push(v);
    }

    lodash_1$1.each(navigation(v), function (w) {
      doDfs(g, w, postorder, visited, navigation, acc);
    });

    if (postorder) {
      acc.push(v);
    }
  }
}

var postorder_1 = postorder$2;

function postorder$2(g, vs) {
  return dfs_1(g, vs, "post");
}

var preorder_1 = preorder$1;

function preorder$1(g, vs) {
  return dfs_1(g, vs, "pre");
}

var prim_1 = prim;

function prim(g, weightFunc) {
  var result = new graph();
  var parents = {};
  var pq = new priorityQueue();
  var v;

  function updateNeighbors(edge) {
    var w = edge.v === v ? edge.w : edge.v;
    var pri = pq.priority(w);

    if (pri !== undefined) {
      var edgeWeight = weightFunc(edge);

      if (edgeWeight < pri) {
        parents[w] = v;
        pq.decrease(w, edgeWeight);
      }
    }
  }

  if (g.nodeCount() === 0) {
    return result;
  }

  lodash_1$1.each(g.nodes(), function (v) {
    pq.add(v, Number.POSITIVE_INFINITY);
    result.setNode(v);
  }); // Start from an arbitrary node


  pq.decrease(g.nodes()[0], 0);
  var init = false;

  while (pq.size() > 0) {
    v = pq.removeMin();

    if (lodash_1$1.has(parents, v)) {
      result.setEdge(v, parents[v]);
    } else if (init) {
      throw new Error("Input graph is not connected: " + g);
    } else {
      init = true;
    }

    g.nodeEdges(v).forEach(updateNeighbors);
  }

  return result;
}

var alg = {
  components: components_1,
  dijkstra: dijkstra_1,
  dijkstraAll: dijkstraAll_1,
  findCycles: findCycles_1,
  floydWarshall: floydWarshall_1,
  isAcyclic: isAcyclic_1,
  postorder: postorder_1,
  preorder: preorder_1,
  prim: prim_1,
  tarjan: tarjan_1,
  topsort: topsort_1
};

/**
 * Copyright (c) 2014, Chris Pettitt
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
var graphlib$1 = {
  Graph: lib.Graph,
  json: json,
  alg: alg,
  version: lib.version
};

/* global window */
var graphlib;

if (typeof commonjsRequire === "function") {
  try {
    graphlib = graphlib$1;
  } catch (e) {// continue regardless of error
  }
}

if (!graphlib) {
  graphlib = window.graphlib;
}

var graphlib_1 = graphlib;

/* global window */
var lodash;

if (typeof commonjsRequire === "function") {
  try {
    lodash = {
      cloneDeep: require$$0__default$1["default"],
      constant: require$$1__default["default"],
      defaults: require$$2__default$1["default"],
      each: require$$2__default["default"],
      filter: require$$3__default["default"],
      find: require$$5__default$1["default"],
      flatten: require$$6__default$1["default"],
      forEach: require$$7__default$1["default"],
      forIn: require$$8__default$1["default"],
      has: require$$4__default["default"],
      isUndefined: require$$8__default["default"],
      last: require$$11__default$1["default"],
      map: require$$10__default["default"],
      mapValues: require$$13__default$1["default"],
      max: require$$14__default$1["default"],
      merge: require$$15__default$1["default"],
      min: require$$16__default["default"],
      minBy: require$$17__default["default"],
      now: require$$18__default["default"],
      pick: require$$19__default["default"],
      range: require$$20__default["default"],
      reduce: require$$11__default["default"],
      sortBy: require$$22__default["default"],
      uniqueId: require$$23__default["default"],
      values: require$$15__default["default"],
      zipObject: require$$25__default["default"]
    };
  } catch (e) {// continue regardless of error
  }
}

if (!lodash) {
  lodash = window._;
}

var lodash_1 = lodash;

/*
 * Simple doubly linked list implementation derived from Cormen, et al.,
 * "Introduction to Algorithms".
 */
var list = List;

function List() {
  var sentinel = {};
  sentinel._next = sentinel._prev = sentinel;
  this._sentinel = sentinel;
}

List.prototype.dequeue = function () {
  var sentinel = this._sentinel;
  var entry = sentinel._prev;

  if (entry !== sentinel) {
    unlink(entry);
    return entry;
  }
};

List.prototype.enqueue = function (entry) {
  var sentinel = this._sentinel;

  if (entry._prev && entry._next) {
    unlink(entry);
  }

  entry._next = sentinel._next;
  sentinel._next._prev = entry;
  sentinel._next = entry;
  entry._prev = sentinel;
};

List.prototype.toString = function () {
  var strs = [];
  var sentinel = this._sentinel;
  var curr = sentinel._prev;

  while (curr !== sentinel) {
    strs.push(JSON.stringify(curr, filterOutLinks));
    curr = curr._prev;
  }

  return "[" + strs.join(", ") + "]";
};

function unlink(entry) {
  entry._prev._next = entry._next;
  entry._next._prev = entry._prev;
  delete entry._next;
  delete entry._prev;
}

function filterOutLinks(k, v) {
  if (k !== "_next" && k !== "_prev") {
    return v;
  }
}

var Graph$7 = graphlib_1.Graph;
/*
 * A greedy heuristic for finding a feedback arc set for a graph. A feedback
 * arc set is a set of edges that can be removed to make a graph acyclic.
 * The algorithm comes from: P. Eades, X. Lin, and W. F. Smyth, "A fast and
 * effective heuristic for the feedback arc set problem." This implementation
 * adjusts that from the paper to allow for weighted edges.
 */

var greedyFas = greedyFAS;

var DEFAULT_WEIGHT_FN = lodash_1.constant(1);

function greedyFAS(g, weightFn) {
  if (g.nodeCount() <= 1) {
    return [];
  }

  var state = buildState(g, weightFn || DEFAULT_WEIGHT_FN);
  var results = doGreedyFAS(state.graph, state.buckets, state.zeroIdx); // Expand multi-edges

  return lodash_1.flatten(lodash_1.map(results, function (e) {
    return g.outEdges(e.v, e.w);
  }), true);
}

function doGreedyFAS(g, buckets, zeroIdx) {
  var results = [];
  var sources = buckets[buckets.length - 1];
  var sinks = buckets[0];
  var entry;

  while (g.nodeCount()) {
    while (entry = sinks.dequeue()) {
      removeNode(g, buckets, zeroIdx, entry);
    }

    while (entry = sources.dequeue()) {
      removeNode(g, buckets, zeroIdx, entry);
    }

    if (g.nodeCount()) {
      for (var i = buckets.length - 2; i > 0; --i) {
        entry = buckets[i].dequeue();

        if (entry) {
          results = results.concat(removeNode(g, buckets, zeroIdx, entry, true));
          break;
        }
      }
    }
  }

  return results;
}

function removeNode(g, buckets, zeroIdx, entry, collectPredecessors) {
  var results = collectPredecessors ? [] : undefined;

  lodash_1.forEach(g.inEdges(entry.v), function (edge) {
    var weight = g.edge(edge);
    var uEntry = g.node(edge.v);

    if (collectPredecessors) {
      results.push({
        v: edge.v,
        w: edge.w
      });
    }

    uEntry.out -= weight;
    assignBucket(buckets, zeroIdx, uEntry);
  });

  lodash_1.forEach(g.outEdges(entry.v), function (edge) {
    var weight = g.edge(edge);
    var w = edge.w;
    var wEntry = g.node(w);
    wEntry["in"] -= weight;
    assignBucket(buckets, zeroIdx, wEntry);
  });

  g.removeNode(entry.v);
  return results;
}

function buildState(g, weightFn) {
  var fasGraph = new Graph$7();
  var maxIn = 0;
  var maxOut = 0;

  lodash_1.forEach(g.nodes(), function (v) {
    fasGraph.setNode(v, {
      v: v,
      "in": 0,
      out: 0
    });
  }); // Aggregate weights on nodes, but also sum the weights across multi-edges
  // into a single edge for the fasGraph.


  lodash_1.forEach(g.edges(), function (e) {
    var prevWeight = fasGraph.edge(e.v, e.w) || 0;
    var weight = weightFn(e);
    var edgeWeight = prevWeight + weight;
    fasGraph.setEdge(e.v, e.w, edgeWeight);
    maxOut = Math.max(maxOut, fasGraph.node(e.v).out += weight);
    maxIn = Math.max(maxIn, fasGraph.node(e.w)["in"] += weight);
  });

  var buckets = lodash_1.range(maxOut + maxIn + 3).map(function () {
    return new list();
  });

  var zeroIdx = maxIn + 1;

  lodash_1.forEach(fasGraph.nodes(), function (v) {
    assignBucket(buckets, zeroIdx, fasGraph.node(v));
  });

  return {
    graph: fasGraph,
    buckets: buckets,
    zeroIdx: zeroIdx
  };
}

function assignBucket(buckets, zeroIdx, entry) {
  if (!entry.out) {
    buckets[0].enqueue(entry);
  } else if (!entry["in"]) {
    buckets[buckets.length - 1].enqueue(entry);
  } else {
    buckets[entry.out - entry["in"] + zeroIdx].enqueue(entry);
  }
}

var acyclic = {
  run: run$2,
  undo: undo$2
};

function run$2(g) {
  var fas = g.graph().acyclicer === "greedy" ? greedyFas(g, weightFn(g)) : dfsFAS(g);

  lodash_1.forEach(fas, function (e) {
    var label = g.edge(e);
    g.removeEdge(e);
    label.forwardName = e.name;
    label.reversed = true;
    g.setEdge(e.w, e.v, label, lodash_1.uniqueId("rev"));
  });

  function weightFn(g) {
    return function (e) {
      return g.edge(e).weight;
    };
  }
}

function dfsFAS(g) {
  var fas = [];
  var stack = {};
  var visited = {};

  function dfs(v) {
    if (lodash_1.has(visited, v)) {
      return;
    }

    visited[v] = true;
    stack[v] = true;

    lodash_1.forEach(g.outEdges(v), function (e) {
      if (lodash_1.has(stack, e.w)) {
        fas.push(e);
      } else {
        dfs(e.w);
      }
    });

    delete stack[v];
  }

  lodash_1.forEach(g.nodes(), dfs);

  return fas;
}

function undo$2(g) {
  lodash_1.forEach(g.edges(), function (e) {
    var label = g.edge(e);

    if (label.reversed) {
      g.removeEdge(e);
      var forwardName = label.forwardName;
      delete label.reversed;
      delete label.forwardName;
      g.setEdge(e.w, e.v, label, forwardName);
    }
  });
}

/* eslint "no-console": off */

var Graph$6 = graphlib_1.Graph;
var util$1 = {
  addDummyNode: addDummyNode,
  simplify: simplify$1,
  asNonCompoundGraph: asNonCompoundGraph,
  successorWeights: successorWeights,
  predecessorWeights: predecessorWeights,
  intersectRect: intersectRect,
  buildLayerMatrix: buildLayerMatrix,
  normalizeRanks: normalizeRanks$1,
  removeEmptyRanks: removeEmptyRanks$1,
  addBorderNode: addBorderNode$1,
  maxRank: maxRank,
  partition: partition,
  time: time,
  notime: notime
};
/*
 * Adds a dummy node to the graph and return v.
 */

function addDummyNode(g, type, attrs, name) {
  var v;

  do {
    v = lodash_1.uniqueId(name);
  } while (g.hasNode(v));

  attrs.dummy = type;
  g.setNode(v, attrs);
  return v;
}
/*
 * Returns a new graph with only simple edges. Handles aggregation of data
 * associated with multi-edges.
 */


function simplify$1(g) {
  var simplified = new Graph$6().setGraph(g.graph());

  lodash_1.forEach(g.nodes(), function (v) {
    simplified.setNode(v, g.node(v));
  });

  lodash_1.forEach(g.edges(), function (e) {
    var simpleLabel = simplified.edge(e.v, e.w) || {
      weight: 0,
      minlen: 1
    };
    var label = g.edge(e);
    simplified.setEdge(e.v, e.w, {
      weight: simpleLabel.weight + label.weight,
      minlen: Math.max(simpleLabel.minlen, label.minlen)
    });
  });

  return simplified;
}

function asNonCompoundGraph(g) {
  var simplified = new Graph$6({
    multigraph: g.isMultigraph()
  }).setGraph(g.graph());

  lodash_1.forEach(g.nodes(), function (v) {
    if (!g.children(v).length) {
      simplified.setNode(v, g.node(v));
    }
  });

  lodash_1.forEach(g.edges(), function (e) {
    simplified.setEdge(e, g.edge(e));
  });

  return simplified;
}

function successorWeights(g) {
  var weightMap = lodash_1.map(g.nodes(), function (v) {
    var sucs = {};

    lodash_1.forEach(g.outEdges(v), function (e) {
      sucs[e.w] = (sucs[e.w] || 0) + g.edge(e).weight;
    });

    return sucs;
  });

  return lodash_1.zipObject(g.nodes(), weightMap);
}

function predecessorWeights(g) {
  var weightMap = lodash_1.map(g.nodes(), function (v) {
    var preds = {};

    lodash_1.forEach(g.inEdges(v), function (e) {
      preds[e.v] = (preds[e.v] || 0) + g.edge(e).weight;
    });

    return preds;
  });

  return lodash_1.zipObject(g.nodes(), weightMap);
}
/*
 * Finds where a line starting at point ({x, y}) would intersect a rectangle
 * ({x, y, width, height}) if it were pointing at the rectangle's center.
 */


function intersectRect(rect, point) {
  var x = rect.x;
  var y = rect.y; // Rectangle intersection algorithm from:
  // http://math.stackexchange.com/questions/108113/find-edge-between-two-boxes

  var dx = point.x - x;
  var dy = point.y - y;
  var w = rect.width / 2;
  var h = rect.height / 2;

  if (!dx && !dy) {
    throw new Error("Not possible to find intersection inside of the rectangle");
  }

  var sx, sy;

  if (Math.abs(dy) * w > Math.abs(dx) * h) {
    // Intersection is top or bottom of rect.
    if (dy < 0) {
      h = -h;
    }

    sx = h * dx / dy;
    sy = h;
  } else {
    // Intersection is left or right of rect.
    if (dx < 0) {
      w = -w;
    }

    sx = w;
    sy = w * dy / dx;
  }

  return {
    x: x + sx,
    y: y + sy
  };
}
/*
 * Given a DAG with each node assigned "rank" and "order" properties, this
 * function will produce a matrix with the ids of each node.
 */


function buildLayerMatrix(g) {
  var layering = lodash_1.map(lodash_1.range(maxRank(g) + 1), function () {
    return [];
  });

  lodash_1.forEach(g.nodes(), function (v) {
    var node = g.node(v);
    var rank = node.rank;

    if (!lodash_1.isUndefined(rank)) {
      layering[rank][node.order] = v;
    }
  });

  return layering;
}
/*
 * Adjusts the ranks for all nodes in the graph such that all nodes v have
 * rank(v) >= 0 and at least one node w has rank(w) = 0.
 */


function normalizeRanks$1(g) {
  var min = lodash_1.min(lodash_1.map(g.nodes(), function (v) {
    return g.node(v).rank;
  }));

  lodash_1.forEach(g.nodes(), function (v) {
    var node = g.node(v);

    if (lodash_1.has(node, "rank")) {
      node.rank -= min;
    }
  });
}

function removeEmptyRanks$1(g) {
  // Ranks may not start at 0, so we need to offset them
  var offset = lodash_1.min(lodash_1.map(g.nodes(), function (v) {
    return g.node(v).rank;
  }));

  var layers = [];

  lodash_1.forEach(g.nodes(), function (v) {
    var rank = g.node(v).rank - offset;

    if (!layers[rank]) {
      layers[rank] = [];
    }

    layers[rank].push(v);
  });

  var delta = 0;
  var nodeRankFactor = g.graph().nodeRankFactor;

  lodash_1.forEach(layers, function (vs, i) {
    if (lodash_1.isUndefined(vs) && i % nodeRankFactor !== 0) {
      --delta;
    } else if (delta) {
      lodash_1.forEach(vs, function (v) {
        g.node(v).rank += delta;
      });
    }
  });
}

function addBorderNode$1(g, prefix, rank, order) {
  var node = {
    width: 0,
    height: 0
  };

  if (arguments.length >= 4) {
    node.rank = rank;
    node.order = order;
  }

  return addDummyNode(g, "border", node, prefix);
}

function maxRank(g) {
  return lodash_1.max(lodash_1.map(g.nodes(), function (v) {
    var rank = g.node(v).rank;

    if (!lodash_1.isUndefined(rank)) {
      return rank;
    }
  }));
}
/*
 * Partition a collection into two groups: `lhs` and `rhs`. If the supplied
 * function returns true for an entry it goes into `lhs`. Otherwise it goes
 * into `rhs.
 */


function partition(collection, fn) {
  var result = {
    lhs: [],
    rhs: []
  };

  lodash_1.forEach(collection, function (value) {
    if (fn(value)) {
      result.lhs.push(value);
    } else {
      result.rhs.push(value);
    }
  });

  return result;
}
/*
 * Returns a new function that wraps `fn` with a timer. The wrapper logs the
 * time it takes to execute the function.
 */


function time(name, fn) {
  var start = lodash_1.now();

  try {
    return fn();
  } finally {
    console.log(name + " time: " + (lodash_1.now() - start) + "ms");
  }
}

function notime(name, fn) {
  return fn();
}

var normalize = {
  run: run$1,
  undo: undo$1
};
/*
 * Breaks any long edges in the graph into short segments that span 1 layer
 * each. This operation is undoable with the denormalize function.
 *
 * Pre-conditions:
 *
 *    1. The input graph is a DAG.
 *    2. Each node in the graph has a "rank" property.
 *
 * Post-condition:
 *
 *    1. All edges in the graph have a length of 1.
 *    2. Dummy nodes are added where edges have been split into segments.
 *    3. The graph is augmented with a "dummyChains" attribute which contains
 *       the first dummy in each chain of dummy nodes produced.
 */

function run$1(g) {
  g.graph().dummyChains = [];

  lodash_1.forEach(g.edges(), function (edge) {
    normalizeEdge(g, edge);
  });
}

function normalizeEdge(g, e) {
  var v = e.v;
  var vRank = g.node(v).rank;
  var w = e.w;
  var wRank = g.node(w).rank;
  var name = e.name;
  var edgeLabel = g.edge(e);
  var labelRank = edgeLabel.labelRank;
  if (wRank === vRank + 1) return;
  g.removeEdge(e);
  var dummy, attrs, i;

  for (i = 0, ++vRank; vRank < wRank; ++i, ++vRank) {
    edgeLabel.points = [];
    attrs = {
      width: 0,
      height: 0,
      edgeLabel: edgeLabel,
      edgeObj: e,
      rank: vRank
    };
    dummy = util$1.addDummyNode(g, "edge", attrs, "_d");

    if (vRank === labelRank) {
      attrs.width = edgeLabel.width;
      attrs.height = edgeLabel.height;
      attrs.dummy = "edge-label";
      attrs.labelpos = edgeLabel.labelpos;
    }

    g.setEdge(v, dummy, {
      weight: edgeLabel.weight
    }, name);

    if (i === 0) {
      g.graph().dummyChains.push(dummy);
    }

    v = dummy;
  }

  g.setEdge(v, w, {
    weight: edgeLabel.weight
  }, name);
}

function undo$1(g) {
  lodash_1.forEach(g.graph().dummyChains, function (v) {
    var node = g.node(v);
    var origLabel = node.edgeLabel;
    var w;
    g.setEdge(node.edgeObj, origLabel);

    while (node.dummy) {
      w = g.successors(v)[0];
      g.removeNode(v);
      origLabel.points.push({
        x: node.x,
        y: node.y
      });

      if (node.dummy === "edge-label") {
        origLabel.x = node.x;
        origLabel.y = node.y;
        origLabel.width = node.width;
        origLabel.height = node.height;
      }

      v = w;
      node = g.node(v);
    }
  });
}

var util = {
  longestPath: longestPath$1,
  slack: slack$2
};
/*
 * Initializes ranks for the input graph using the longest path algorithm. This
 * algorithm scales well and is fast in practice, it yields rather poor
 * solutions. Nodes are pushed to the lowest layer possible, leaving the bottom
 * ranks wide and leaving edges longer than necessary. However, due to its
 * speed, this algorithm is good for getting an initial ranking that can be fed
 * into other algorithms.
 *
 * This algorithm does not normalize layers because it will be used by other
 * algorithms in most cases. If using this algorithm directly, be sure to
 * run normalize at the end.
 *
 * Pre-conditions:
 *
 *    1. Input graph is a DAG.
 *    2. Input graph node labels can be assigned properties.
 *
 * Post-conditions:
 *
 *    1. Each node will be assign an (unnormalized) "rank" property.
 */

function longestPath$1(g) {
  var visited = {};

  function dfs(v) {
    var label = g.node(v);

    if (lodash_1.has(visited, v)) {
      return label.rank;
    }

    visited[v] = true;

    var rank = lodash_1.min(lodash_1.map(g.outEdges(v), function (e) {
      return dfs(e.w) - g.edge(e).minlen;
    }));

    if (rank === Number.POSITIVE_INFINITY || // return value of _.map([]) for Lodash 3
    rank === undefined || // return value of _.map([]) for Lodash 4
    rank === null) {
      // return value of _.map([null])
      rank = 0;
    }

    return label.rank = rank;
  }

  lodash_1.forEach(g.sources(), dfs);
}
/*
 * Returns the amount of slack for the given edge. The slack is defined as the
 * difference between the length of the edge and its minimum length.
 */


function slack$2(g, e) {
  return g.node(e.w).rank - g.node(e.v).rank - g.edge(e).minlen;
}

var Graph$5 = graphlib_1.Graph;
var slack$1 = util.slack;
var feasibleTree_1 = feasibleTree;
/*
 * Constructs a spanning tree with tight edges and adjusted the input node's
 * ranks to achieve this. A tight edge is one that is has a length that matches
 * its "minlen" attribute.
 *
 * The basic structure for this function is derived from Gansner, et al., "A
 * Technique for Drawing Directed Graphs."
 *
 * Pre-conditions:
 *
 *    1. Graph must be a DAG.
 *    2. Graph must be connected.
 *    3. Graph must have at least one node.
 *    5. Graph nodes must have been previously assigned a "rank" property that
 *       respects the "minlen" property of incident edges.
 *    6. Graph edges must have a "minlen" property.
 *
 * Post-conditions:
 *
 *    - Graph nodes will have their rank adjusted to ensure that all edges are
 *      tight.
 *
 * Returns a tree (undirected graph) that is constructed using only "tight"
 * edges.
 */

function feasibleTree(g) {
  var t = new Graph$5({
    directed: false
  }); // Choose arbitrary node from which to start our tree

  var start = g.nodes()[0];
  var size = g.nodeCount();
  t.setNode(start, {});
  var edge, delta;

  while (tightTree(t, g) < size) {
    edge = findMinSlackEdge(t, g);
    delta = t.hasNode(edge.v) ? slack$1(g, edge) : -slack$1(g, edge);
    shiftRanks(t, g, delta);
  }

  return t;
}
/*
 * Finds a maximal tree of tight edges and returns the number of nodes in the
 * tree.
 */


function tightTree(t, g) {
  function dfs(v) {
    lodash_1.forEach(g.nodeEdges(v), function (e) {
      var edgeV = e.v,
          w = v === edgeV ? e.w : edgeV;

      if (!t.hasNode(w) && !slack$1(g, e)) {
        t.setNode(w, {});
        t.setEdge(v, w, {});
        dfs(w);
      }
    });
  }

  lodash_1.forEach(t.nodes(), dfs);

  return t.nodeCount();
}
/*
 * Finds the edge with the smallest slack that is incident on tree and returns
 * it.
 */


function findMinSlackEdge(t, g) {
  return lodash_1.minBy(g.edges(), function (e) {
    if (t.hasNode(e.v) !== t.hasNode(e.w)) {
      return slack$1(g, e);
    }
  });
}

function shiftRanks(t, g, delta) {
  lodash_1.forEach(t.nodes(), function (v) {
    g.node(v).rank += delta;
  });
}

var slack = util.slack;
var initRank = util.longestPath;
var preorder = graphlib_1.alg.preorder;
var postorder$1 = graphlib_1.alg.postorder;
var simplify = util$1.simplify;
var networkSimplex_1 = networkSimplex; // Expose some internals for testing purposes

networkSimplex.initLowLimValues = initLowLimValues;
networkSimplex.initCutValues = initCutValues;
networkSimplex.calcCutValue = calcCutValue;
networkSimplex.leaveEdge = leaveEdge;
networkSimplex.enterEdge = enterEdge;
networkSimplex.exchangeEdges = exchangeEdges;
/*
 * The network simplex algorithm assigns ranks to each node in the input graph
 * and iteratively improves the ranking to reduce the length of edges.
 *
 * Preconditions:
 *
 *    1. The input graph must be a DAG.
 *    2. All nodes in the graph must have an object value.
 *    3. All edges in the graph must have "minlen" and "weight" attributes.
 *
 * Postconditions:
 *
 *    1. All nodes in the graph will have an assigned "rank" attribute that has
 *       been optimized by the network simplex algorithm. Ranks start at 0.
 *
 *
 * A rough sketch of the algorithm is as follows:
 *
 *    1. Assign initial ranks to each node. We use the longest path algorithm,
 *       which assigns ranks to the lowest position possible. In general this
 *       leads to very wide bottom ranks and unnecessarily long edges.
 *    2. Construct a feasible tight tree. A tight tree is one such that all
 *       edges in the tree have no slack (difference between length of edge
 *       and minlen for the edge). This by itself greatly improves the assigned
 *       rankings by shorting edges.
 *    3. Iteratively find edges that have negative cut values. Generally a
 *       negative cut value indicates that the edge could be removed and a new
 *       tree edge could be added to produce a more compact graph.
 *
 * Much of the algorithms here are derived from Gansner, et al., "A Technique
 * for Drawing Directed Graphs." The structure of the file roughly follows the
 * structure of the overall algorithm.
 */

function networkSimplex(g) {
  g = simplify(g);
  initRank(g);
  var t = feasibleTree_1(g);
  initLowLimValues(t);
  initCutValues(t, g);
  var e, f;

  while (e = leaveEdge(t)) {
    f = enterEdge(t, g, e);
    exchangeEdges(t, g, e, f);
  }
}
/*
 * Initializes cut values for all edges in the tree.
 */


function initCutValues(t, g) {
  var vs = postorder$1(t, t.nodes());
  vs = vs.slice(0, vs.length - 1);

  lodash_1.forEach(vs, function (v) {
    assignCutValue(t, g, v);
  });
}

function assignCutValue(t, g, child) {
  var childLab = t.node(child);
  var parent = childLab.parent;
  t.edge(child, parent).cutvalue = calcCutValue(t, g, child);
}
/*
 * Given the tight tree, its graph, and a child in the graph calculate and
 * return the cut value for the edge between the child and its parent.
 */


function calcCutValue(t, g, child) {
  var childLab = t.node(child);
  var parent = childLab.parent; // True if the child is on the tail end of the edge in the directed graph

  var childIsTail = true; // The graph's view of the tree edge we're inspecting

  var graphEdge = g.edge(child, parent); // The accumulated cut value for the edge between this node and its parent

  var cutValue = 0;

  if (!graphEdge) {
    childIsTail = false;
    graphEdge = g.edge(parent, child);
  }

  cutValue = graphEdge.weight;

  lodash_1.forEach(g.nodeEdges(child), function (e) {
    var isOutEdge = e.v === child,
        other = isOutEdge ? e.w : e.v;

    if (other !== parent) {
      var pointsToHead = isOutEdge === childIsTail,
          otherWeight = g.edge(e).weight;
      cutValue += pointsToHead ? otherWeight : -otherWeight;

      if (isTreeEdge(t, child, other)) {
        var otherCutValue = t.edge(child, other).cutvalue;
        cutValue += pointsToHead ? -otherCutValue : otherCutValue;
      }
    }
  });

  return cutValue;
}

function initLowLimValues(tree, root) {
  if (arguments.length < 2) {
    root = tree.nodes()[0];
  }

  dfsAssignLowLim(tree, {}, 1, root);
}

function dfsAssignLowLim(tree, visited, nextLim, v, parent) {
  var low = nextLim;
  var label = tree.node(v);
  visited[v] = true;

  lodash_1.forEach(tree.neighbors(v), function (w) {
    if (!lodash_1.has(visited, w)) {
      nextLim = dfsAssignLowLim(tree, visited, nextLim, w, v);
    }
  });

  label.low = low;
  label.lim = nextLim++;

  if (parent) {
    label.parent = parent;
  } else {
    // TODO should be able to remove this when we incrementally update low lim
    delete label.parent;
  }

  return nextLim;
}

function leaveEdge(tree) {
  return lodash_1.find(tree.edges(), function (e) {
    return tree.edge(e).cutvalue < 0;
  });
}

function enterEdge(t, g, edge) {
  var v = edge.v;
  var w = edge.w; // For the rest of this function we assume that v is the tail and w is the
  // head, so if we don't have this edge in the graph we should flip it to
  // match the correct orientation.

  if (!g.hasEdge(v, w)) {
    v = edge.w;
    w = edge.v;
  }

  var vLabel = t.node(v);
  var wLabel = t.node(w);
  var tailLabel = vLabel;
  var flip = false; // If the root is in the tail of the edge then we need to flip the logic that
  // checks for the head and tail nodes in the candidates function below.

  if (vLabel.lim > wLabel.lim) {
    tailLabel = wLabel;
    flip = true;
  }

  var candidates = lodash_1.filter(g.edges(), function (edge) {
    return flip === isDescendant(t, t.node(edge.v), tailLabel) && flip !== isDescendant(t, t.node(edge.w), tailLabel);
  });

  return lodash_1.minBy(candidates, function (edge) {
    return slack(g, edge);
  });
}

function exchangeEdges(t, g, e, f) {
  var v = e.v;
  var w = e.w;
  t.removeEdge(v, w);
  t.setEdge(f.v, f.w, {});
  initLowLimValues(t);
  initCutValues(t, g);
  updateRanks(t, g);
}

function updateRanks(t, g) {
  var root = lodash_1.find(t.nodes(), function (v) {
    return !g.node(v).parent;
  });

  var vs = preorder(t, root);
  vs = vs.slice(1);

  lodash_1.forEach(vs, function (v) {
    var parent = t.node(v).parent,
        edge = g.edge(v, parent),
        flipped = false;

    if (!edge) {
      edge = g.edge(parent, v);
      flipped = true;
    }

    g.node(v).rank = g.node(parent).rank + (flipped ? edge.minlen : -edge.minlen);
  });
}
/*
 * Returns true if the edge is in the tree.
 */


function isTreeEdge(tree, u, v) {
  return tree.hasEdge(u, v);
}
/*
 * Returns true if the specified node is descendant of the root node per the
 * assigned low and lim attributes in the tree.
 */


function isDescendant(tree, vLabel, rootLabel) {
  return rootLabel.low <= vLabel.lim && vLabel.lim <= rootLabel.lim;
}

var longestPath = util.longestPath;
var rank_1 = rank;
/*
 * Assigns a rank to each node in the input graph that respects the "minlen"
 * constraint specified on edges between nodes.
 *
 * This basic structure is derived from Gansner, et al., "A Technique for
 * Drawing Directed Graphs."
 *
 * Pre-conditions:
 *
 *    1. Graph must be a connected DAG
 *    2. Graph nodes must be objects
 *    3. Graph edges must have "weight" and "minlen" attributes
 *
 * Post-conditions:
 *
 *    1. Graph nodes will have a "rank" attribute based on the results of the
 *       algorithm. Ranks can start at any index (including negative), we'll
 *       fix them up later.
 */

function rank(g) {
  switch (g.graph().ranker) {
    case "network-simplex":
      networkSimplexRanker(g);
      break;

    case "tight-tree":
      tightTreeRanker(g);
      break;

    case "longest-path":
      longestPathRanker(g);
      break;

    default:
      networkSimplexRanker(g);
  }
} // A fast and simple ranker, but results are far from optimal.


var longestPathRanker = longestPath;

function tightTreeRanker(g) {
  longestPath(g);
  feasibleTree_1(g);
}

function networkSimplexRanker(g) {
  networkSimplex_1(g);
}

var parentDummyChains_1 = parentDummyChains;

function parentDummyChains(g) {
  var postorderNums = postorder(g);

  lodash_1.forEach(g.graph().dummyChains, function (v) {
    var node = g.node(v);
    var edgeObj = node.edgeObj;
    var pathData = findPath(g, postorderNums, edgeObj.v, edgeObj.w);
    var path = pathData.path;
    var lca = pathData.lca;
    var pathIdx = 0;
    var pathV = path[pathIdx];
    var ascending = true;

    while (v !== edgeObj.w) {
      node = g.node(v);

      if (ascending) {
        while ((pathV = path[pathIdx]) !== lca && g.node(pathV).maxRank < node.rank) {
          pathIdx++;
        }

        if (pathV === lca) {
          ascending = false;
        }
      }

      if (!ascending) {
        while (pathIdx < path.length - 1 && g.node(pathV = path[pathIdx + 1]).minRank <= node.rank) {
          pathIdx++;
        }

        pathV = path[pathIdx];
      }

      g.setParent(v, pathV);
      v = g.successors(v)[0];
    }
  });
} // Find a path from v to w through the lowest common ancestor (LCA). Return the
// full path and the LCA.


function findPath(g, postorderNums, v, w) {
  var vPath = [];
  var wPath = [];
  var low = Math.min(postorderNums[v].low, postorderNums[w].low);
  var lim = Math.max(postorderNums[v].lim, postorderNums[w].lim);
  var parent;
  var lca; // Traverse up from v to find the LCA

  parent = v;

  do {
    parent = g.parent(parent);
    vPath.push(parent);
  } while (parent && (postorderNums[parent].low > low || lim > postorderNums[parent].lim));

  lca = parent; // Traverse from w to LCA

  parent = w;

  while ((parent = g.parent(parent)) !== lca) {
    wPath.push(parent);
  }

  return {
    path: vPath.concat(wPath.reverse()),
    lca: lca
  };
}

function postorder(g) {
  var result = {};
  var lim = 0;

  function dfs(v) {
    var low = lim;

    lodash_1.forEach(g.children(v), dfs);

    result[v] = {
      low: low,
      lim: lim++
    };
  }

  lodash_1.forEach(g.children(), dfs);

  return result;
}

var nestingGraph = {
  run: run,
  cleanup: cleanup
};
/*
 * A nesting graph creates dummy nodes for the tops and bottoms of subgraphs,
 * adds appropriate edges to ensure that all cluster nodes are placed between
 * these boundries, and ensures that the graph is connected.
 *
 * In addition we ensure, through the use of the minlen property, that nodes
 * and subgraph border nodes to not end up on the same rank.
 *
 * Preconditions:
 *
 *    1. Input graph is a DAG
 *    2. Nodes in the input graph has a minlen attribute
 *
 * Postconditions:
 *
 *    1. Input graph is connected.
 *    2. Dummy nodes are added for the tops and bottoms of subgraphs.
 *    3. The minlen attribute for nodes is adjusted to ensure nodes do not
 *       get placed on the same rank as subgraph border nodes.
 *
 * The nesting graph idea comes from Sander, "Layout of Compound Directed
 * Graphs."
 */

function run(g) {
  var root = util$1.addDummyNode(g, "root", {}, "_root");
  var depths = treeDepths(g);
  var height = lodash_1.max(lodash_1.values(depths)) - 1; // Note: depths is an Object not an array

  var nodeSep = 2 * height + 1;
  g.graph().nestingRoot = root; // Multiply minlen by nodeSep to align nodes on non-border ranks.

  lodash_1.forEach(g.edges(), function (e) {
    g.edge(e).minlen *= nodeSep;
  }); // Calculate a weight that is sufficient to keep subgraphs vertically compact


  var weight = sumWeights(g) + 1; // Create border nodes and link them up

  lodash_1.forEach(g.children(), function (child) {
    dfs(g, root, nodeSep, weight, height, depths, child);
  }); // Save the multiplier for node layers for later removal of empty border
  // layers.


  g.graph().nodeRankFactor = nodeSep;
}

function dfs(g, root, nodeSep, weight, height, depths, v) {
  var children = g.children(v);

  if (!children.length) {
    if (v !== root) {
      g.setEdge(root, v, {
        weight: 0,
        minlen: nodeSep
      });
    }

    return;
  }

  var top = util$1.addBorderNode(g, "_bt");
  var bottom = util$1.addBorderNode(g, "_bb");
  var label = g.node(v);
  g.setParent(top, v);
  label.borderTop = top;
  g.setParent(bottom, v);
  label.borderBottom = bottom;

  lodash_1.forEach(children, function (child) {
    dfs(g, root, nodeSep, weight, height, depths, child);
    var childNode = g.node(child);
    var childTop = childNode.borderTop ? childNode.borderTop : child;
    var childBottom = childNode.borderBottom ? childNode.borderBottom : child;
    var thisWeight = childNode.borderTop ? weight : 2 * weight;
    var minlen = childTop !== childBottom ? 1 : height - depths[v] + 1;
    g.setEdge(top, childTop, {
      weight: thisWeight,
      minlen: minlen,
      nestingEdge: true
    });
    g.setEdge(childBottom, bottom, {
      weight: thisWeight,
      minlen: minlen,
      nestingEdge: true
    });
  });

  if (!g.parent(v)) {
    g.setEdge(root, top, {
      weight: 0,
      minlen: height + depths[v]
    });
  }
}

function treeDepths(g) {
  var depths = {};

  function dfs(v, depth) {
    var children = g.children(v);

    if (children && children.length) {
      lodash_1.forEach(children, function (child) {
        dfs(child, depth + 1);
      });
    }

    depths[v] = depth;
  }

  lodash_1.forEach(g.children(), function (v) {
    dfs(v, 1);
  });

  return depths;
}

function sumWeights(g) {
  return lodash_1.reduce(g.edges(), function (acc, e) {
    return acc + g.edge(e).weight;
  }, 0);
}

function cleanup(g) {
  var graphLabel = g.graph();
  g.removeNode(graphLabel.nestingRoot);
  delete graphLabel.nestingRoot;

  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);

    if (edge.nestingEdge) {
      g.removeEdge(e);
    }
  });
}

var addBorderSegments_1 = addBorderSegments;

function addBorderSegments(g) {
  function dfs(v) {
    var children = g.children(v);
    var node = g.node(v);

    if (children.length) {
      lodash_1.forEach(children, dfs);
    }

    if (lodash_1.has(node, "minRank")) {
      node.borderLeft = [];
      node.borderRight = [];

      for (var rank = node.minRank, maxRank = node.maxRank + 1; rank < maxRank; ++rank) {
        addBorderNode(g, "borderLeft", "_bl", v, node, rank);
        addBorderNode(g, "borderRight", "_br", v, node, rank);
      }
    }
  }

  lodash_1.forEach(g.children(), dfs);
}

function addBorderNode(g, prop, prefix, sg, sgNode, rank) {
  var label = {
    width: 0,
    height: 0,
    rank: rank,
    borderType: prop
  };
  var prev = sgNode[prop][rank - 1];
  var curr = util$1.addDummyNode(g, "border", label, prefix);
  sgNode[prop][rank] = curr;
  g.setParent(curr, sg);

  if (prev) {
    g.setEdge(prev, curr, {
      weight: 1
    });
  }
}

var coordinateSystem = {
  adjust: adjust,
  undo: undo
};

function adjust(g) {
  var rankDir = g.graph().rankdir.toLowerCase();

  if (rankDir === "lr" || rankDir === "rl") {
    swapWidthHeight(g);
  }
}

function undo(g) {
  var rankDir = g.graph().rankdir.toLowerCase();

  if (rankDir === "bt" || rankDir === "rl") {
    reverseY(g);
  }

  if (rankDir === "lr" || rankDir === "rl") {
    swapXY(g);
    swapWidthHeight(g);
  }
}

function swapWidthHeight(g) {
  lodash_1.forEach(g.nodes(), function (v) {
    swapWidthHeightOne(g.node(v));
  });

  lodash_1.forEach(g.edges(), function (e) {
    swapWidthHeightOne(g.edge(e));
  });
}

function swapWidthHeightOne(attrs) {
  var w = attrs.width;
  attrs.width = attrs.height;
  attrs.height = w;
}

function reverseY(g) {
  lodash_1.forEach(g.nodes(), function (v) {
    reverseYOne(g.node(v));
  });

  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);

    lodash_1.forEach(edge.points, reverseYOne);

    if (lodash_1.has(edge, "y")) {
      reverseYOne(edge);
    }
  });
}

function reverseYOne(attrs) {
  attrs.y = -attrs.y;
}

function swapXY(g) {
  lodash_1.forEach(g.nodes(), function (v) {
    swapXYOne(g.node(v));
  });

  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);

    lodash_1.forEach(edge.points, swapXYOne);

    if (lodash_1.has(edge, "x")) {
      swapXYOne(edge);
    }
  });
}

function swapXYOne(attrs) {
  var x = attrs.x;
  attrs.x = attrs.y;
  attrs.y = x;
}

var initOrder_1 = initOrder;
/*
 * Assigns an initial order value for each node by performing a DFS search
 * starting from nodes in the first rank. Nodes are assigned an order in their
 * rank as they are first visited.
 *
 * This approach comes from Gansner, et al., "A Technique for Drawing Directed
 * Graphs."
 *
 * Returns a layering matrix with an array per layer and each layer sorted by
 * the order of its nodes.
 */

function initOrder(g) {
  var visited = {};

  var simpleNodes = lodash_1.filter(g.nodes(), function (v) {
    return !g.children(v).length;
  });

  var maxRank = lodash_1.max(lodash_1.map(simpleNodes, function (v) {
    return g.node(v).rank;
  }));

  var layers = lodash_1.map(lodash_1.range(maxRank + 1), function () {
    return [];
  });

  function dfs(v) {
    if (lodash_1.has(visited, v)) return;
    visited[v] = true;
    var node = g.node(v);
    layers[node.rank].push(v);

    lodash_1.forEach(g.successors(v), dfs);
  }

  var orderedVs = lodash_1.sortBy(simpleNodes, function (v) {
    return g.node(v).rank;
  });

  lodash_1.forEach(orderedVs, dfs);

  return layers;
}

var crossCount_1 = crossCount;
/*
 * A function that takes a layering (an array of layers, each with an array of
 * ordererd nodes) and a graph and returns a weighted crossing count.
 *
 * Pre-conditions:
 *
 *    1. Input graph must be simple (not a multigraph), directed, and include
 *       only simple edges.
 *    2. Edges in the input graph must have assigned weights.
 *
 * Post-conditions:
 *
 *    1. The graph and layering matrix are left unchanged.
 *
 * This algorithm is derived from Barth, et al., "Bilayer Cross Counting."
 */

function crossCount(g, layering) {
  var cc = 0;

  for (var i = 1; i < layering.length; ++i) {
    cc += twoLayerCrossCount(g, layering[i - 1], layering[i]);
  }

  return cc;
}

function twoLayerCrossCount(g, northLayer, southLayer) {
  // Sort all of the edges between the north and south layers by their position
  // in the north layer and then the south. Map these edges to the position of
  // their head in the south layer.
  var southPos = lodash_1.zipObject(southLayer, lodash_1.map(southLayer, function (v, i) {
    return i;
  }));

  var southEntries = lodash_1.flatten(lodash_1.map(northLayer, function (v) {
    return lodash_1.sortBy(lodash_1.map(g.outEdges(v), function (e) {
      return {
        pos: southPos[e.w],
        weight: g.edge(e).weight
      };
    }), "pos");
  }), true); // Build the accumulator tree


  var firstIndex = 1;

  while (firstIndex < southLayer.length) firstIndex <<= 1;

  var treeSize = 2 * firstIndex - 1;
  firstIndex -= 1;

  var tree = lodash_1.map(new Array(treeSize), function () {
    return 0;
  }); // Calculate the weighted crossings


  var cc = 0;

  lodash_1.forEach(southEntries.forEach(function (entry) {
    var index = entry.pos + firstIndex;
    tree[index] += entry.weight;
    var weightSum = 0;

    while (index > 0) {
      if (index % 2) {
        weightSum += tree[index + 1];
      }

      index = index - 1 >> 1;
      tree[index] += entry.weight;
    }

    cc += entry.weight * weightSum;
  }));

  return cc;
}

var barycenter_1 = barycenter;

function barycenter(g, movable) {
  return lodash_1.map(movable, function (v) {
    var inV = g.inEdges(v);

    if (!inV.length) {
      return {
        v: v
      };
    } else {
      var result = lodash_1.reduce(inV, function (acc, e) {
        var edge = g.edge(e),
            nodeU = g.node(e.v);
        return {
          sum: acc.sum + edge.weight * nodeU.order,
          weight: acc.weight + edge.weight
        };
      }, {
        sum: 0,
        weight: 0
      });

      return {
        v: v,
        barycenter: result.sum / result.weight,
        weight: result.weight
      };
    }
  });
}

var resolveConflicts_1 = resolveConflicts;
/*
 * Given a list of entries of the form {v, barycenter, weight} and a
 * constraint graph this function will resolve any conflicts between the
 * constraint graph and the barycenters for the entries. If the barycenters for
 * an entry would violate a constraint in the constraint graph then we coalesce
 * the nodes in the conflict into a new node that respects the contraint and
 * aggregates barycenter and weight information.
 *
 * This implementation is based on the description in Forster, "A Fast and
 * Simple Hueristic for Constrained Two-Level Crossing Reduction," thought it
 * differs in some specific details.
 *
 * Pre-conditions:
 *
 *    1. Each entry has the form {v, barycenter, weight}, or if the node has
 *       no barycenter, then {v}.
 *
 * Returns:
 *
 *    A new list of entries of the form {vs, i, barycenter, weight}. The list
 *    `vs` may either be a singleton or it may be an aggregation of nodes
 *    ordered such that they do not violate constraints from the constraint
 *    graph. The property `i` is the lowest original index of any of the
 *    elements in `vs`.
 */

function resolveConflicts(entries, cg) {
  var mappedEntries = {};

  lodash_1.forEach(entries, function (entry, i) {
    var tmp = mappedEntries[entry.v] = {
      indegree: 0,
      "in": [],
      out: [],
      vs: [entry.v],
      i: i
    };

    if (!lodash_1.isUndefined(entry.barycenter)) {
      tmp.barycenter = entry.barycenter;
      tmp.weight = entry.weight;
    }
  });

  lodash_1.forEach(cg.edges(), function (e) {
    var entryV = mappedEntries[e.v];
    var entryW = mappedEntries[e.w];

    if (!lodash_1.isUndefined(entryV) && !lodash_1.isUndefined(entryW)) {
      entryW.indegree++;
      entryV.out.push(mappedEntries[e.w]);
    }
  });

  var sourceSet = lodash_1.filter(mappedEntries, function (entry) {
    return !entry.indegree;
  });

  return doResolveConflicts(sourceSet);
}

function doResolveConflicts(sourceSet) {
  var entries = [];

  function handleIn(vEntry) {
    return function (uEntry) {
      if (uEntry.merged) {
        return;
      }

      if (lodash_1.isUndefined(uEntry.barycenter) || lodash_1.isUndefined(vEntry.barycenter) || uEntry.barycenter >= vEntry.barycenter) {
        mergeEntries(vEntry, uEntry);
      }
    };
  }

  function handleOut(vEntry) {
    return function (wEntry) {
      wEntry["in"].push(vEntry);

      if (--wEntry.indegree === 0) {
        sourceSet.push(wEntry);
      }
    };
  }

  while (sourceSet.length) {
    var entry = sourceSet.pop();
    entries.push(entry);

    lodash_1.forEach(entry["in"].reverse(), handleIn(entry));

    lodash_1.forEach(entry.out, handleOut(entry));
  }

  return lodash_1.map(lodash_1.filter(entries, function (entry) {
    return !entry.merged;
  }), function (entry) {
    return lodash_1.pick(entry, ["vs", "i", "barycenter", "weight"]);
  });
}

function mergeEntries(target, source) {
  var sum = 0;
  var weight = 0;

  if (target.weight) {
    sum += target.barycenter * target.weight;
    weight += target.weight;
  }

  if (source.weight) {
    sum += source.barycenter * source.weight;
    weight += source.weight;
  }

  target.vs = source.vs.concat(target.vs);
  target.barycenter = sum / weight;
  target.weight = weight;
  target.i = Math.min(source.i, target.i);
  source.merged = true;
}

var sort_1 = sort;

function sort(entries, biasRight) {
  var parts = util$1.partition(entries, function (entry) {
    return lodash_1.has(entry, "barycenter");
  });

  var sortable = parts.lhs,
      unsortable = lodash_1.sortBy(parts.rhs, function (entry) {
    return -entry.i;
  }),
      vs = [],
      sum = 0,
      weight = 0,
      vsIndex = 0;

  sortable.sort(compareWithBias(!!biasRight));
  vsIndex = consumeUnsortable(vs, unsortable, vsIndex);

  lodash_1.forEach(sortable, function (entry) {
    vsIndex += entry.vs.length;
    vs.push(entry.vs);
    sum += entry.barycenter * entry.weight;
    weight += entry.weight;
    vsIndex = consumeUnsortable(vs, unsortable, vsIndex);
  });

  var result = {
    vs: lodash_1.flatten(vs, true)
  };

  if (weight) {
    result.barycenter = sum / weight;
    result.weight = weight;
  }

  return result;
}

function consumeUnsortable(vs, unsortable, index) {
  var last;

  while (unsortable.length && (last = lodash_1.last(unsortable)).i <= index) {
    unsortable.pop();
    vs.push(last.vs);
    index++;
  }

  return index;
}

function compareWithBias(bias) {
  return function (entryV, entryW) {
    if (entryV.barycenter < entryW.barycenter) {
      return -1;
    } else if (entryV.barycenter > entryW.barycenter) {
      return 1;
    }

    return !bias ? entryV.i - entryW.i : entryW.i - entryV.i;
  };
}

var sortSubgraph_1 = sortSubgraph;

function sortSubgraph(g, v, cg, biasRight) {
  var movable = g.children(v);
  var node = g.node(v);
  var bl = node ? node.borderLeft : undefined;
  var br = node ? node.borderRight : undefined;
  var subgraphs = {};

  if (bl) {
    movable = lodash_1.filter(movable, function (w) {
      return w !== bl && w !== br;
    });
  }

  var barycenters = barycenter_1(g, movable);

  lodash_1.forEach(barycenters, function (entry) {
    if (g.children(entry.v).length) {
      var subgraphResult = sortSubgraph(g, entry.v, cg, biasRight);
      subgraphs[entry.v] = subgraphResult;

      if (lodash_1.has(subgraphResult, "barycenter")) {
        mergeBarycenters(entry, subgraphResult);
      }
    }
  });

  var entries = resolveConflicts_1(barycenters, cg);
  expandSubgraphs(entries, subgraphs);
  var result = sort_1(entries, biasRight);

  if (bl) {
    result.vs = lodash_1.flatten([bl, result.vs, br], true);

    if (g.predecessors(bl).length) {
      var blPred = g.node(g.predecessors(bl)[0]),
          brPred = g.node(g.predecessors(br)[0]);

      if (!lodash_1.has(result, "barycenter")) {
        result.barycenter = 0;
        result.weight = 0;
      }

      result.barycenter = (result.barycenter * result.weight + blPred.order + brPred.order) / (result.weight + 2);
      result.weight += 2;
    }
  }

  return result;
}

function expandSubgraphs(entries, subgraphs) {
  lodash_1.forEach(entries, function (entry) {
    entry.vs = lodash_1.flatten(entry.vs.map(function (v) {
      if (subgraphs[v]) {
        return subgraphs[v].vs;
      }

      return v;
    }), true);
  });
}

function mergeBarycenters(target, other) {
  if (!lodash_1.isUndefined(target.barycenter)) {
    target.barycenter = (target.barycenter * target.weight + other.barycenter * other.weight) / (target.weight + other.weight);
    target.weight += other.weight;
  } else {
    target.barycenter = other.barycenter;
    target.weight = other.weight;
  }
}

var Graph$4 = graphlib_1.Graph;
var buildLayerGraph_1 = buildLayerGraph;
/*
 * Constructs a graph that can be used to sort a layer of nodes. The graph will
 * contain all base and subgraph nodes from the request layer in their original
 * hierarchy and any edges that are incident on these nodes and are of the type
 * requested by the "relationship" parameter.
 *
 * Nodes from the requested rank that do not have parents are assigned a root
 * node in the output graph, which is set in the root graph attribute. This
 * makes it easy to walk the hierarchy of movable nodes during ordering.
 *
 * Pre-conditions:
 *
 *    1. Input graph is a DAG
 *    2. Base nodes in the input graph have a rank attribute
 *    3. Subgraph nodes in the input graph has minRank and maxRank attributes
 *    4. Edges have an assigned weight
 *
 * Post-conditions:
 *
 *    1. Output graph has all nodes in the movable rank with preserved
 *       hierarchy.
 *    2. Root nodes in the movable layer are made children of the node
 *       indicated by the root attribute of the graph.
 *    3. Non-movable nodes incident on movable nodes, selected by the
 *       relationship parameter, are included in the graph (without hierarchy).
 *    4. Edges incident on movable nodes, selected by the relationship
 *       parameter, are added to the output graph.
 *    5. The weights for copied edges are aggregated as need, since the output
 *       graph is not a multi-graph.
 */

function buildLayerGraph(g, rank, relationship) {
  var root = createRootNode(g),
      result = new Graph$4({
    compound: true
  }).setGraph({
    root: root
  }).setDefaultNodeLabel(function (v) {
    return g.node(v);
  });

  lodash_1.forEach(g.nodes(), function (v) {
    var node = g.node(v),
        parent = g.parent(v);

    if (node.rank === rank || node.minRank <= rank && rank <= node.maxRank) {
      result.setNode(v);
      result.setParent(v, parent || root); // This assumes we have only short edges!

      lodash_1.forEach(g[relationship](v), function (e) {
        var u = e.v === v ? e.w : e.v,
            edge = result.edge(u, v),
            weight = !lodash_1.isUndefined(edge) ? edge.weight : 0;
        result.setEdge(u, v, {
          weight: g.edge(e).weight + weight
        });
      });

      if (lodash_1.has(node, "minRank")) {
        result.setNode(v, {
          borderLeft: node.borderLeft[rank],
          borderRight: node.borderRight[rank]
        });
      }
    }
  });

  return result;
}

function createRootNode(g) {
  var v;

  while (g.hasNode(v = lodash_1.uniqueId("_root")));

  return v;
}

var addSubgraphConstraints_1 = addSubgraphConstraints;

function addSubgraphConstraints(g, cg, vs) {
  var prev = {},
      rootPrev;

  lodash_1.forEach(vs, function (v) {
    var child = g.parent(v),
        parent,
        prevChild;

    while (child) {
      parent = g.parent(child);

      if (parent) {
        prevChild = prev[parent];
        prev[parent] = child;
      } else {
        prevChild = rootPrev;
        rootPrev = child;
      }

      if (prevChild && prevChild !== child) {
        cg.setEdge(prevChild, child);
        return;
      }

      child = parent;
    }
  });
  /*
  function dfs(v) {
    var children = v ? g.children(v) : g.children();
    if (children.length) {
      var min = Number.POSITIVE_INFINITY,
          subgraphs = [];
      _.each(children, function(child) {
        var childMin = dfs(child);
        if (g.children(child).length) {
          subgraphs.push({ v: child, order: childMin });
        }
        min = Math.min(min, childMin);
      });
      _.reduce(_.sortBy(subgraphs, "order"), function(prev, curr) {
        cg.setEdge(prev.v, curr.v);
        return curr;
      });
      return min;
    }
    return g.node(v).order;
  }
  dfs(undefined);
  */

}

var Graph$3 = graphlib_1.Graph;
var order_1 = order;
/*
 * Applies heuristics to minimize edge crossings in the graph and sets the best
 * order solution as an order attribute on each node.
 *
 * Pre-conditions:
 *
 *    1. Graph must be DAG
 *    2. Graph nodes must be objects with a "rank" attribute
 *    3. Graph edges must have the "weight" attribute
 *
 * Post-conditions:
 *
 *    1. Graph nodes will have an "order" attribute based on the results of the
 *       algorithm.
 */

function order(g) {
  var maxRank = util$1.maxRank(g),
      downLayerGraphs = buildLayerGraphs(g, lodash_1.range(1, maxRank + 1), "inEdges"),
      upLayerGraphs = buildLayerGraphs(g, lodash_1.range(maxRank - 1, -1, -1), "outEdges");
  var layering = initOrder_1(g);
  assignOrder(g, layering);
  var bestCC = Number.POSITIVE_INFINITY,
      best;

  for (var i = 0, lastBest = 0; lastBest < 4; ++i, ++lastBest) {
    sweepLayerGraphs(i % 2 ? downLayerGraphs : upLayerGraphs, i % 4 >= 2);
    layering = util$1.buildLayerMatrix(g);
    var cc = crossCount_1(g, layering);

    if (cc < bestCC) {
      lastBest = 0;
      best = lodash_1.cloneDeep(layering);
      bestCC = cc;
    }
  }

  assignOrder(g, best);
}

function buildLayerGraphs(g, ranks, relationship) {
  return lodash_1.map(ranks, function (rank) {
    return buildLayerGraph_1(g, rank, relationship);
  });
}

function sweepLayerGraphs(layerGraphs, biasRight) {
  var cg = new Graph$3();

  lodash_1.forEach(layerGraphs, function (lg) {
    var root = lg.graph().root;
    var sorted = sortSubgraph_1(lg, root, cg, biasRight);

    lodash_1.forEach(sorted.vs, function (v, i) {
      lg.node(v).order = i;
    });

    addSubgraphConstraints_1(lg, cg, sorted.vs);
  });
}

function assignOrder(g, layering) {
  lodash_1.forEach(layering, function (layer) {
    lodash_1.forEach(layer, function (v, i) {
      g.node(v).order = i;
    });
  });
}

var Graph$2 = graphlib_1.Graph;
/*
 * This module provides coordinate assignment based on Brandes and Köpf, "Fast
 * and Simple Horizontal Coordinate Assignment."
 */

var bk = {
  positionX: positionX$1,
  findType1Conflicts: findType1Conflicts,
  findType2Conflicts: findType2Conflicts,
  addConflict: addConflict,
  hasConflict: hasConflict,
  verticalAlignment: verticalAlignment,
  horizontalCompaction: horizontalCompaction,
  alignCoordinates: alignCoordinates,
  findSmallestWidthAlignment: findSmallestWidthAlignment,
  balance: balance
};
/*
 * Marks all edges in the graph with a type-1 conflict with the "type1Conflict"
 * property. A type-1 conflict is one where a non-inner segment crosses an
 * inner segment. An inner segment is an edge with both incident nodes marked
 * with the "dummy" property.
 *
 * This algorithm scans layer by layer, starting with the second, for type-1
 * conflicts between the current layer and the previous layer. For each layer
 * it scans the nodes from left to right until it reaches one that is incident
 * on an inner segment. It then scans predecessors to determine if they have
 * edges that cross that inner segment. At the end a final scan is done for all
 * nodes on the current rank to see if they cross the last visited inner
 * segment.
 *
 * This algorithm (safely) assumes that a dummy node will only be incident on a
 * single node in the layers being scanned.
 */

function findType1Conflicts(g, layering) {
  var conflicts = {};

  function visitLayer(prevLayer, layer) {
    var // last visited node in the previous layer that is incident on an inner
    // segment.
    k0 = 0,
        // Tracks the last node in this layer scanned for crossings with a type-1
    // segment.
    scanPos = 0,
        prevLayerLength = prevLayer.length,
        lastNode = lodash_1.last(layer);

    lodash_1.forEach(layer, function (v, i) {
      var w = findOtherInnerSegmentNode(g, v),
          k1 = w ? g.node(w).order : prevLayerLength;

      if (w || v === lastNode) {
        lodash_1.forEach(layer.slice(scanPos, i + 1), function (scanNode) {
          lodash_1.forEach(g.predecessors(scanNode), function (u) {
            var uLabel = g.node(u),
                uPos = uLabel.order;

            if ((uPos < k0 || k1 < uPos) && !(uLabel.dummy && g.node(scanNode).dummy)) {
              addConflict(conflicts, u, scanNode);
            }
          });
        });

        scanPos = i + 1;
        k0 = k1;
      }
    });

    return layer;
  }

  lodash_1.reduce(layering, visitLayer);

  return conflicts;
}

function findType2Conflicts(g, layering) {
  var conflicts = {};

  function scan(south, southPos, southEnd, prevNorthBorder, nextNorthBorder) {
    var v;

    lodash_1.forEach(lodash_1.range(southPos, southEnd), function (i) {
      v = south[i];

      if (g.node(v).dummy) {
        lodash_1.forEach(g.predecessors(v), function (u) {
          var uNode = g.node(u);

          if (uNode.dummy && (uNode.order < prevNorthBorder || uNode.order > nextNorthBorder)) {
            addConflict(conflicts, u, v);
          }
        });
      }
    });
  }

  function visitLayer(north, south) {
    var prevNorthPos = -1,
        nextNorthPos,
        southPos = 0;

    lodash_1.forEach(south, function (v, southLookahead) {
      if (g.node(v).dummy === "border") {
        var predecessors = g.predecessors(v);

        if (predecessors.length) {
          nextNorthPos = g.node(predecessors[0]).order;
          scan(south, southPos, southLookahead, prevNorthPos, nextNorthPos);
          southPos = southLookahead;
          prevNorthPos = nextNorthPos;
        }
      }

      scan(south, southPos, south.length, nextNorthPos, north.length);
    });

    return south;
  }

  lodash_1.reduce(layering, visitLayer);

  return conflicts;
}

function findOtherInnerSegmentNode(g, v) {
  if (g.node(v).dummy) {
    return lodash_1.find(g.predecessors(v), function (u) {
      return g.node(u).dummy;
    });
  }
}

function addConflict(conflicts, v, w) {
  if (v > w) {
    var tmp = v;
    v = w;
    w = tmp;
  }

  var conflictsV = conflicts[v];

  if (!conflictsV) {
    conflicts[v] = conflictsV = {};
  }

  conflictsV[w] = true;
}

function hasConflict(conflicts, v, w) {
  if (v > w) {
    var tmp = v;
    v = w;
    w = tmp;
  }

  return lodash_1.has(conflicts[v], w);
}
/*
 * Try to align nodes into vertical "blocks" where possible. This algorithm
 * attempts to align a node with one of its median neighbors. If the edge
 * connecting a neighbor is a type-1 conflict then we ignore that possibility.
 * If a previous node has already formed a block with a node after the node
 * we're trying to form a block with, we also ignore that possibility - our
 * blocks would be split in that scenario.
 */


function verticalAlignment(g, layering, conflicts, neighborFn) {
  var root = {},
      align = {},
      pos = {}; // We cache the position here based on the layering because the graph and
  // layering may be out of sync. The layering matrix is manipulated to
  // generate different extreme alignments.

  lodash_1.forEach(layering, function (layer) {
    lodash_1.forEach(layer, function (v, order) {
      root[v] = v;
      align[v] = v;
      pos[v] = order;
    });
  });

  lodash_1.forEach(layering, function (layer) {
    var prevIdx = -1;

    lodash_1.forEach(layer, function (v) {
      var ws = neighborFn(v);

      if (ws.length) {
        ws = lodash_1.sortBy(ws, function (w) {
          return pos[w];
        });
        var mp = (ws.length - 1) / 2;

        for (var i = Math.floor(mp), il = Math.ceil(mp); i <= il; ++i) {
          var w = ws[i];

          if (align[v] === v && prevIdx < pos[w] && !hasConflict(conflicts, v, w)) {
            align[w] = v;
            align[v] = root[v] = root[w];
            prevIdx = pos[w];
          }
        }
      }
    });
  });

  return {
    root: root,
    align: align
  };
}

function horizontalCompaction(g, layering, root, align, reverseSep) {
  // This portion of the algorithm differs from BK due to a number of problems.
  // Instead of their algorithm we construct a new block graph and do two
  // sweeps. The first sweep places blocks with the smallest possible
  // coordinates. The second sweep removes unused space by moving blocks to the
  // greatest coordinates without violating separation.
  var xs = {},
      blockG = buildBlockGraph(g, layering, root, reverseSep),
      borderType = reverseSep ? "borderLeft" : "borderRight";

  function iterate(setXsFunc, nextNodesFunc) {
    var stack = blockG.nodes();
    var elem = stack.pop();
    var visited = {};

    while (elem) {
      if (visited[elem]) {
        setXsFunc(elem);
      } else {
        visited[elem] = true;
        stack.push(elem);
        stack = stack.concat(nextNodesFunc(elem));
      }

      elem = stack.pop();
    }
  } // First pass, assign smallest coordinates


  function pass1(elem) {
    xs[elem] = blockG.inEdges(elem).reduce(function (acc, e) {
      return Math.max(acc, xs[e.v] + blockG.edge(e));
    }, 0);
  } // Second pass, assign greatest coordinates


  function pass2(elem) {
    var min = blockG.outEdges(elem).reduce(function (acc, e) {
      return Math.min(acc, xs[e.w] - blockG.edge(e));
    }, Number.POSITIVE_INFINITY);
    var node = g.node(elem);

    if (min !== Number.POSITIVE_INFINITY && node.borderType !== borderType) {
      xs[elem] = Math.max(xs[elem], min);
    }
  }

  iterate(pass1, blockG.predecessors.bind(blockG));
  iterate(pass2, blockG.successors.bind(blockG)); // Assign x coordinates to all nodes

  lodash_1.forEach(align, function (v) {
    xs[v] = xs[root[v]];
  });

  return xs;
}

function buildBlockGraph(g, layering, root, reverseSep) {
  var blockGraph = new Graph$2(),
      graphLabel = g.graph(),
      sepFn = sep(graphLabel.nodesep, graphLabel.edgesep, reverseSep);

  lodash_1.forEach(layering, function (layer) {
    var u;

    lodash_1.forEach(layer, function (v) {
      var vRoot = root[v];
      blockGraph.setNode(vRoot);

      if (u) {
        var uRoot = root[u],
            prevMax = blockGraph.edge(uRoot, vRoot);
        blockGraph.setEdge(uRoot, vRoot, Math.max(sepFn(g, v, u), prevMax || 0));
      }

      u = v;
    });
  });

  return blockGraph;
}
/*
 * Returns the alignment that has the smallest width of the given alignments.
 */


function findSmallestWidthAlignment(g, xss) {
  return lodash_1.minBy(lodash_1.values(xss), function (xs) {
    var max = Number.NEGATIVE_INFINITY;
    var min = Number.POSITIVE_INFINITY;

    lodash_1.forIn(xs, function (x, v) {
      var halfWidth = width(g, v) / 2;
      max = Math.max(x + halfWidth, max);
      min = Math.min(x - halfWidth, min);
    });

    return max - min;
  });
}
/*
 * Align the coordinates of each of the layout alignments such that
 * left-biased alignments have their minimum coordinate at the same point as
 * the minimum coordinate of the smallest width alignment and right-biased
 * alignments have their maximum coordinate at the same point as the maximum
 * coordinate of the smallest width alignment.
 */


function alignCoordinates(xss, alignTo) {
  var alignToVals = lodash_1.values(alignTo),
      alignToMin = lodash_1.min(alignToVals),
      alignToMax = lodash_1.max(alignToVals);

  lodash_1.forEach(["u", "d"], function (vert) {
    lodash_1.forEach(["l", "r"], function (horiz) {
      var alignment = vert + horiz,
          xs = xss[alignment],
          delta;
      if (xs === alignTo) return;

      var xsVals = lodash_1.values(xs);

      delta = horiz === "l" ? alignToMin - lodash_1.min(xsVals) : alignToMax - lodash_1.max(xsVals);

      if (delta) {
        xss[alignment] = lodash_1.mapValues(xs, function (x) {
          return x + delta;
        });
      }
    });
  });
}

function balance(xss, align) {
  return lodash_1.mapValues(xss.ul, function (ignore, v) {
    if (align) {
      return xss[align.toLowerCase()][v];
    } else {
      var xs = lodash_1.sortBy(lodash_1.map(xss, v));

      return (xs[1] + xs[2]) / 2;
    }
  });
}

function positionX$1(g) {
  var layering = util$1.buildLayerMatrix(g);

  var conflicts = lodash_1.merge(findType1Conflicts(g, layering), findType2Conflicts(g, layering));

  var xss = {};
  var adjustedLayering;

  lodash_1.forEach(["u", "d"], function (vert) {
    adjustedLayering = vert === "u" ? layering : lodash_1.values(layering).reverse();

    lodash_1.forEach(["l", "r"], function (horiz) {
      if (horiz === "r") {
        adjustedLayering = lodash_1.map(adjustedLayering, function (inner) {
          return lodash_1.values(inner).reverse();
        });
      }

      var neighborFn = (vert === "u" ? g.predecessors : g.successors).bind(g);
      var align = verticalAlignment(g, adjustedLayering, conflicts, neighborFn);
      var xs = horizontalCompaction(g, adjustedLayering, align.root, align.align, horiz === "r");

      if (horiz === "r") {
        xs = lodash_1.mapValues(xs, function (x) {
          return -x;
        });
      }

      xss[vert + horiz] = xs;
    });
  });

  var smallestWidth = findSmallestWidthAlignment(g, xss);
  alignCoordinates(xss, smallestWidth);
  return balance(xss, g.graph().align);
}

function sep(nodeSep, edgeSep, reverseSep) {
  return function (g, v, w) {
    var vLabel = g.node(v);
    var wLabel = g.node(w);
    var sum = 0;
    var delta;
    sum += vLabel.width / 2;

    if (lodash_1.has(vLabel, "labelpos")) {
      switch (vLabel.labelpos.toLowerCase()) {
        case "l":
          delta = -vLabel.width / 2;
          break;

        case "r":
          delta = vLabel.width / 2;
          break;
      }
    }

    if (delta) {
      sum += reverseSep ? delta : -delta;
    }

    delta = 0;
    sum += (vLabel.dummy ? edgeSep : nodeSep) / 2;
    sum += (wLabel.dummy ? edgeSep : nodeSep) / 2;
    sum += wLabel.width / 2;

    if (lodash_1.has(wLabel, "labelpos")) {
      switch (wLabel.labelpos.toLowerCase()) {
        case "l":
          delta = wLabel.width / 2;
          break;

        case "r":
          delta = -wLabel.width / 2;
          break;
      }
    }

    if (delta) {
      sum += reverseSep ? delta : -delta;
    }

    delta = 0;
    return sum;
  };
}

function width(g, v) {
  return g.node(v).width;
}

var positionX = bk.positionX;
var position_1 = position;

function position(g) {
  g = util$1.asNonCompoundGraph(g);
  positionY(g);

  lodash_1.forEach(positionX(g), function (x, v) {
    g.node(v).x = x;
  });
}

function positionY(g) {
  var layering = util$1.buildLayerMatrix(g);
  var rankSep = g.graph().ranksep;
  var prevY = 0;

  lodash_1.forEach(layering, function (layer) {
    var maxHeight = lodash_1.max(lodash_1.map(layer, function (v) {
      return g.node(v).height;
    }));

    lodash_1.forEach(layer, function (v) {
      g.node(v).y = prevY + maxHeight / 2;
    });

    prevY += maxHeight + rankSep;
  });
}

var normalizeRanks = util$1.normalizeRanks;
var removeEmptyRanks = util$1.removeEmptyRanks;
var Graph$1 = graphlib_1.Graph;
var layout_1 = layout;

function layout(g, opts) {
  var time = opts && opts.debugTiming ? util$1.time : util$1.notime;
  time("layout", function () {
    var layoutGraph = time("  buildLayoutGraph", function () {
      return buildLayoutGraph(g);
    });
    time("  runLayout", function () {
      runLayout(layoutGraph, time);
    });
    time("  updateInputGraph", function () {
      updateInputGraph(g, layoutGraph);
    });
  });
}

function runLayout(g, time) {
  time("    makeSpaceForEdgeLabels", function () {
    makeSpaceForEdgeLabels(g);
  });
  time("    removeSelfEdges", function () {
    removeSelfEdges(g);
  });
  time("    acyclic", function () {
    acyclic.run(g);
  });
  time("    nestingGraph.run", function () {
    nestingGraph.run(g);
  });
  time("    rank", function () {
    rank_1(util$1.asNonCompoundGraph(g));
  });
  time("    injectEdgeLabelProxies", function () {
    injectEdgeLabelProxies(g);
  });
  time("    removeEmptyRanks", function () {
    removeEmptyRanks(g);
  });
  time("    nestingGraph.cleanup", function () {
    nestingGraph.cleanup(g);
  });
  time("    normalizeRanks", function () {
    normalizeRanks(g);
  });
  time("    assignRankMinMax", function () {
    assignRankMinMax(g);
  });
  time("    removeEdgeLabelProxies", function () {
    removeEdgeLabelProxies(g);
  });
  time("    normalize.run", function () {
    normalize.run(g);
  });
  time("    parentDummyChains", function () {
    parentDummyChains_1(g);
  });
  time("    addBorderSegments", function () {
    addBorderSegments_1(g);
  });
  time("    order", function () {
    order_1(g);
  });
  time("    insertSelfEdges", function () {
    insertSelfEdges(g);
  });
  time("    adjustCoordinateSystem", function () {
    coordinateSystem.adjust(g);
  });
  time("    position", function () {
    position_1(g);
  });
  time("    positionSelfEdges", function () {
    positionSelfEdges(g);
  });
  time("    removeBorderNodes", function () {
    removeBorderNodes(g);
  });
  time("    normalize.undo", function () {
    normalize.undo(g);
  });
  time("    fixupEdgeLabelCoords", function () {
    fixupEdgeLabelCoords(g);
  });
  time("    undoCoordinateSystem", function () {
    coordinateSystem.undo(g);
  });
  time("    translateGraph", function () {
    translateGraph(g);
  });
  time("    assignNodeIntersects", function () {
    assignNodeIntersects(g);
  });
  time("    reversePoints", function () {
    reversePointsForReversedEdges(g);
  });
  time("    acyclic.undo", function () {
    acyclic.undo(g);
  });
}
/*
 * Copies final layout information from the layout graph back to the input
 * graph. This process only copies whitelisted attributes from the layout graph
 * to the input graph, so it serves as a good place to determine what
 * attributes can influence layout.
 */


function updateInputGraph(inputGraph, layoutGraph) {
  lodash_1.forEach(inputGraph.nodes(), function (v) {
    var inputLabel = inputGraph.node(v);
    var layoutLabel = layoutGraph.node(v);

    if (inputLabel) {
      inputLabel.x = layoutLabel.x;
      inputLabel.y = layoutLabel.y;

      if (layoutGraph.children(v).length) {
        inputLabel.width = layoutLabel.width;
        inputLabel.height = layoutLabel.height;
      }
    }
  });

  lodash_1.forEach(inputGraph.edges(), function (e) {
    var inputLabel = inputGraph.edge(e);
    var layoutLabel = layoutGraph.edge(e);
    inputLabel.points = layoutLabel.points;

    if (lodash_1.has(layoutLabel, "x")) {
      inputLabel.x = layoutLabel.x;
      inputLabel.y = layoutLabel.y;
    }
  });

  inputGraph.graph().width = layoutGraph.graph().width;
  inputGraph.graph().height = layoutGraph.graph().height;
}

var graphNumAttrs = ["nodesep", "edgesep", "ranksep", "marginx", "marginy"];
var graphDefaults = {
  ranksep: 50,
  edgesep: 20,
  nodesep: 50,
  rankdir: "tb"
};
var graphAttrs = ["acyclicer", "ranker", "rankdir", "align"];
var nodeNumAttrs = ["width", "height"];
var nodeDefaults = {
  width: 0,
  height: 0
};
var edgeNumAttrs = ["minlen", "weight", "width", "height", "labeloffset"];
var edgeDefaults = {
  minlen: 1,
  weight: 1,
  width: 0,
  height: 0,
  labeloffset: 10,
  labelpos: "r"
};
var edgeAttrs = ["labelpos"];
/*
 * Constructs a new graph from the input graph, which can be used for layout.
 * This process copies only whitelisted attributes from the input graph to the
 * layout graph. Thus this function serves as a good place to determine what
 * attributes can influence layout.
 */

function buildLayoutGraph(inputGraph) {
  var g = new Graph$1({
    multigraph: true,
    compound: true
  });
  var graph = canonicalize(inputGraph.graph());
  g.setGraph(lodash_1.merge({}, graphDefaults, selectNumberAttrs(graph, graphNumAttrs), lodash_1.pick(graph, graphAttrs)));

  lodash_1.forEach(inputGraph.nodes(), function (v) {
    var node = canonicalize(inputGraph.node(v));
    g.setNode(v, lodash_1.defaults(selectNumberAttrs(node, nodeNumAttrs), nodeDefaults));
    g.setParent(v, inputGraph.parent(v));
  });

  lodash_1.forEach(inputGraph.edges(), function (e) {
    var edge = canonicalize(inputGraph.edge(e));
    g.setEdge(e, lodash_1.merge({}, edgeDefaults, selectNumberAttrs(edge, edgeNumAttrs), lodash_1.pick(edge, edgeAttrs)));
  });

  return g;
}
/*
 * This idea comes from the Gansner paper: to account for edge labels in our
 * layout we split each rank in half by doubling minlen and halving ranksep.
 * Then we can place labels at these mid-points between nodes.
 *
 * We also add some minimal padding to the width to push the label for the edge
 * away from the edge itself a bit.
 */


function makeSpaceForEdgeLabels(g) {
  var graph = g.graph();
  graph.ranksep /= 2;

  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);
    edge.minlen *= 2;

    if (edge.labelpos.toLowerCase() !== "c") {
      if (graph.rankdir === "TB" || graph.rankdir === "BT") {
        edge.width += edge.labeloffset;
      } else {
        edge.height += edge.labeloffset;
      }
    }
  });
}
/*
 * Creates temporary dummy nodes that capture the rank in which each edge's
 * label is going to, if it has one of non-zero width and height. We do this
 * so that we can safely remove empty ranks while preserving balance for the
 * label's position.
 */


function injectEdgeLabelProxies(g) {
  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);

    if (edge.width && edge.height) {
      var v = g.node(e.v);
      var w = g.node(e.w);
      var label = {
        rank: (w.rank - v.rank) / 2 + v.rank,
        e: e
      };
      util$1.addDummyNode(g, "edge-proxy", label, "_ep");
    }
  });
}

function assignRankMinMax(g) {
  var maxRank = 0;

  lodash_1.forEach(g.nodes(), function (v) {
    var node = g.node(v);

    if (node.borderTop) {
      node.minRank = g.node(node.borderTop).rank;
      node.maxRank = g.node(node.borderBottom).rank;
      maxRank = lodash_1.max(maxRank, node.maxRank);
    }
  });

  g.graph().maxRank = maxRank;
}

function removeEdgeLabelProxies(g) {
  lodash_1.forEach(g.nodes(), function (v) {
    var node = g.node(v);

    if (node.dummy === "edge-proxy") {
      g.edge(node.e).labelRank = node.rank;
      g.removeNode(v);
    }
  });
}

function translateGraph(g) {
  var minX = Number.POSITIVE_INFINITY;
  var maxX = 0;
  var minY = Number.POSITIVE_INFINITY;
  var maxY = 0;
  var graphLabel = g.graph();
  var marginX = graphLabel.marginx || 0;
  var marginY = graphLabel.marginy || 0;

  function getExtremes(attrs) {
    var x = attrs.x;
    var y = attrs.y;
    var w = attrs.width;
    var h = attrs.height;
    minX = Math.min(minX, x - w / 2);
    maxX = Math.max(maxX, x + w / 2);
    minY = Math.min(minY, y - h / 2);
    maxY = Math.max(maxY, y + h / 2);
  }

  lodash_1.forEach(g.nodes(), function (v) {
    getExtremes(g.node(v));
  });

  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);

    if (lodash_1.has(edge, "x")) {
      getExtremes(edge);
    }
  });

  minX -= marginX;
  minY -= marginY;

  lodash_1.forEach(g.nodes(), function (v) {
    var node = g.node(v);
    node.x -= minX;
    node.y -= minY;
  });

  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);

    lodash_1.forEach(edge.points, function (p) {
      p.x -= minX;
      p.y -= minY;
    });

    if (lodash_1.has(edge, "x")) {
      edge.x -= minX;
    }

    if (lodash_1.has(edge, "y")) {
      edge.y -= minY;
    }
  });

  graphLabel.width = maxX - minX + marginX;
  graphLabel.height = maxY - minY + marginY;
}

function assignNodeIntersects(g) {
  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);
    var nodeV = g.node(e.v);
    var nodeW = g.node(e.w);
    var p1, p2;

    if (!edge.points) {
      edge.points = [];
      p1 = nodeW;
      p2 = nodeV;
    } else {
      p1 = edge.points[0];
      p2 = edge.points[edge.points.length - 1];
    }

    edge.points.unshift(util$1.intersectRect(nodeV, p1));
    edge.points.push(util$1.intersectRect(nodeW, p2));
  });
}

function fixupEdgeLabelCoords(g) {
  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);

    if (lodash_1.has(edge, "x")) {
      if (edge.labelpos === "l" || edge.labelpos === "r") {
        edge.width -= edge.labeloffset;
      }

      switch (edge.labelpos) {
        case "l":
          edge.x -= edge.width / 2 + edge.labeloffset;
          break;

        case "r":
          edge.x += edge.width / 2 + edge.labeloffset;
          break;
      }
    }
  });
}

function reversePointsForReversedEdges(g) {
  lodash_1.forEach(g.edges(), function (e) {
    var edge = g.edge(e);

    if (edge.reversed) {
      edge.points.reverse();
    }
  });
}

function removeBorderNodes(g) {
  lodash_1.forEach(g.nodes(), function (v) {
    if (g.children(v).length) {
      var node = g.node(v);
      var t = g.node(node.borderTop);
      var b = g.node(node.borderBottom);
      var l = g.node(lodash_1.last(node.borderLeft));
      var r = g.node(lodash_1.last(node.borderRight));
      node.width = Math.abs(r.x - l.x);
      node.height = Math.abs(b.y - t.y);
      node.x = l.x + node.width / 2;
      node.y = t.y + node.height / 2;
    }
  });

  lodash_1.forEach(g.nodes(), function (v) {
    if (g.node(v).dummy === "border") {
      g.removeNode(v);
    }
  });
}

function removeSelfEdges(g) {
  lodash_1.forEach(g.edges(), function (e) {
    if (e.v === e.w) {
      var node = g.node(e.v);

      if (!node.selfEdges) {
        node.selfEdges = [];
      }

      node.selfEdges.push({
        e: e,
        label: g.edge(e)
      });
      g.removeEdge(e);
    }
  });
}

function insertSelfEdges(g) {
  var layers = util$1.buildLayerMatrix(g);

  lodash_1.forEach(layers, function (layer) {
    var orderShift = 0;

    lodash_1.forEach(layer, function (v, i) {
      var node = g.node(v);
      node.order = i + orderShift;

      lodash_1.forEach(node.selfEdges, function (selfEdge) {
        util$1.addDummyNode(g, "selfedge", {
          width: selfEdge.label.width,
          height: selfEdge.label.height,
          rank: node.rank,
          order: i + ++orderShift,
          e: selfEdge.e,
          label: selfEdge.label
        }, "_se");
      });

      delete node.selfEdges;
    });
  });
}

function positionSelfEdges(g) {
  lodash_1.forEach(g.nodes(), function (v) {
    var node = g.node(v);

    if (node.dummy === "selfedge") {
      var selfNode = g.node(node.e.v);
      var x = selfNode.x + selfNode.width / 2;
      var y = selfNode.y;
      var dx = node.x - x;
      var dy = selfNode.height / 2;
      g.setEdge(node.e, node.label);
      g.removeNode(v);
      node.label.points = [{
        x: x + 2 * dx / 3,
        y: y - dy
      }, {
        x: x + 5 * dx / 6,
        y: y - dy
      }, {
        x: x + dx,
        y: y
      }, {
        x: x + 5 * dx / 6,
        y: y + dy
      }, {
        x: x + 2 * dx / 3,
        y: y + dy
      }];
      node.label.x = node.x;
      node.label.y = node.y;
    }
  });
}

function selectNumberAttrs(obj, attrs) {
  return lodash_1.mapValues(lodash_1.pick(obj, attrs), Number);
}

function canonicalize(attrs) {
  var newAttrs = {};

  lodash_1.forEach(attrs, function (v, k) {
    newAttrs[k.toLowerCase()] = v;
  });

  return newAttrs;
}

var Graph = graphlib_1.Graph;
var debug = {
  debugOrdering: debugOrdering
};
/* istanbul ignore next */

function debugOrdering(g) {
  var layerMatrix = util$1.buildLayerMatrix(g);
  var h = new Graph({
    compound: true,
    multigraph: true
  }).setGraph({});

  lodash_1.forEach(g.nodes(), function (v) {
    h.setNode(v, {
      label: v
    });
    h.setParent(v, "layer" + g.node(v).rank);
  });

  lodash_1.forEach(g.edges(), function (e) {
    h.setEdge(e.v, e.w, {}, e.name);
  });

  lodash_1.forEach(layerMatrix, function (layer, i) {
    var layerV = "layer" + i;
    h.setNode(layerV, {
      rank: "same"
    });

    lodash_1.reduce(layer, function (u, v) {
      h.setEdge(u, v, {
        style: "invis"
      });
      return v;
    });
  });

  return h;
}

var version = "0.8.5";

/*
Copyright (c) 2012-2014 Chris Pettitt

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
var dagre = {
  graphlib: graphlib_1,
  layout: layout_1,
  debug: debug,
  util: {
    time: util$1.time,
    notime: util$1.notime
  },
  version: version
};

const defaultParams = {
  rankdir: 'LR',
  ranksep: 150,
  graph: 'tight-tree',
  height: 10000,
  width: 10000
};
const DEFAULT_NODE_SEP = 50;
/**
 * y轴防碰撞检测，由于dagre算法要求的节点高度是固定的
 * 所以计算的时候，对于同一个y轴上的节点，可能会出现节点碰撞的问题
 * @param {Object} _nodes graph 输出的节点
 *                - x {Number}
 *                - y {Number}
 *                - height {Number}
 *                - width {Number}
 * @param {Number} nodestep 每个节点之间的距离
 */

const precollide = (_nodes, nodestep) => {
  const nodes = [];
  const rank = {};
  const after = {};
  Object.keys(_nodes).forEach(key => {
    nodes.push({
      id: key,
      ..._nodes[key]
    });
  });

  for (let node of nodes) {
    if (!rank[node.x]) {
      rank[node.x] = [];
      rank[node.x].push(node);
    } else {
      rank[node.x].push(node);
    }
  } // 保证统一层级上的节点，排序是不变的，利用order进行从大到小排序


  Object.keys(rank).forEach(level => {
    let rnodes = rank[level];
    const xys = rnodes.sort((a, b) => a.y - b.y).map(n => [n.x, n.y]);
    rnodes = rnodes.sort((a, b) => a.order - b.order);
    rank[level].forEach((node, ind) => {
      node.x = xys[ind][0];
      node.y = xys[ind][1];
    });
  }); // 同一个x轴上的节点

  Object.keys(rank).forEach(level => {
    let rnodes = rank[level];

    if (rnodes.length === 1) {
      return;
    } // 从小到大排序


    rnodes = rnodes.sort((a, b) => {
      return a.y - b.y;
    });

    for (let i = 0; i < rnodes.length - 1; i++) {
      const current = rnodes[i];
      const next = rnodes[i + 1]; // 方案一  next.y = current.y + current.height*2 + nodestep
      // next.y = current.y + current.height*2 + nodestep
      // 方案二

      next.y = current.y + current.height * 2 + nodestep; // if ((current.y + current.height) >= next.y) {
      //   next.y = (current.y + current.height)/2 + nodestep;
      // }
      // if((current.y + current.height + nodestep) < next.y) {
      //   next.y = current.y + current.height + nodestep;
      // }
    }
  });
  Object.keys(rank).forEach(level => {
    const ns = rank[level];
    ns.forEach(n => {
      after[n.id] = n;
    });
  });
  return after;
}; // drage布局


const drageLayout = parmas => _ref => {
  let {
    height,
    width,
    data
  } = _ref;
  const {
    nodesep = DEFAULT_NODE_SEP
  } = parmas;
  const graphParams = Object.assign({}, defaultParams, {
    ranksep: parmas.ranksep || 150
  });
  graphParams.center = [width / 2, height / 2];
  const edges = data.edges;
  const curnode = data.nodes;
  const nodes = curnode.map(item => {
    return {
      id: item.id,
      top: item.top,
      left: item.left,
      size: item.dom ? [jquery(item.dom).width(), jquery(item.dom).height()] : [40, 40]
    };
  }); // 形成新数组后布局失效

  if (!nodes) {
    return;
  }

  const g = new dagre.graphlib.Graph();
  nodes.forEach((node, index) => {
    const size = node.size;
    const width = size[0];
    const height = size[1];
    g.setNode(node.id, {
      width,
      height,
      x: node.left,
      y: node.top,
      order: index
    });
  });
  edges.forEach(edge => {
    // dagrejs Wiki https://github.com/dagrejs/dagre/wiki#configuring-the-layout
    g.setEdge(edge.sourceNode.id, edge.targetNode.id, {
      weight: edge.weight || 1
    });
  });
  g.setGraph(graphParams);
  dagre.layout(g);
  let coord;
  g._nodes = precollide(g._nodes, nodesep); // 重新布局时g.nodes()可能为undefined

  g.nodes().forEach(node => {
    coord = g.node(node);

    if (!coord) {
      return;
    }

    const i = nodes.findIndex(it => it.id === node);
    nodes[i].left = coord.x;
    nodes[i].top = coord.y - coord.height / 2;
  }); // 将数据挂载到原有数据上，以触发布局

  nodes.forEach((item, index) => {
    curnode[index].left = item.left;
    curnode[index].top = item.top;
  });
};

const focusNode = (node, options, canvas) => {
  if (!node) {
    return;
  }

  const client = jquery(canvas.root);
  const size = [client.height(), client.width()];
  const offset = client.offset();
  let center = [offset.left + size[1] / 2, offset.top + size[0] / 2];
  center = canvas.terminal2canvas(center);
  const moffset = [node.left - center[0], node.top - center[1]];
  canvas.nodes.forEach(node => {
    node.moveTo(node.left - moffset[0], node.top - moffset[1]);
  });
  canvas.recalc();
};

const NodeTypes = PropTypes__default["default"].shape({
  id: PropTypes__default["default"].string,
  // 节点ID
  icon: PropTypes__default["default"].string,
  // 图标
  isHide: PropTypes__default["default"].bool,
  // 是否收起
  isUnRelItemHidden: PropTypes__default["default"].bool,
  // 是否收起非关联字段(尚未实现)
  title: PropTypes__default["default"].string,
  // node整体的标题
  nodeItems: PropTypes__default["default"].arrayOf(PropTypes__default["default"].shape({
    id: PropTypes__default["default"].string,
    // 唯一ID
    level: PropTypes__default["default"].number,
    // 渲染层级
    icon: PropTypes__default["default"].string,
    // 图标
    title: PropTypes__default["default"].string,
    // 描述标题
    onClick: PropTypes__default["default"].func // 单击节点

  })),
  operators: PropTypes__default["default"].arrayOf(PropTypes__default["default"].shape({
    compnent: PropTypes__default["default"].element
  }))
}); // 连线类型

const EdgeTypes = PropTypes__default["default"].shape({
  srcNodeItemId: PropTypes__default["default"].string,
  // 源item的id
  tgtNodeItemId: PropTypes__default["default"].string,
  // 目标item的id
  id: PropTypes__default["default"].string // 节点自身ID

});

var img$7 = "data:image/svg+xml,%3c%3fxml version='1.0' encoding='UTF-8'%3f%3e%3csvg width='12px' height='12px' viewBox='0 0 12 12' version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'%3e %3c!-- Generator: Sketch 63.1 (92452) - https://sketch.com --%3e %3ctitle%3e1.%e9%80%9a%e7%94%a8/2.Icon%e5%9b%be%e6%a0%87/Fill/%e6%95%b0%e6%8d%ae%e5%9c%b0%e5%9b%be/API%3c/title%3e %3cdesc%3eCreated with Sketch.%3c/desc%3e %3cdefs%3e %3clinearGradient x1='50%25' y1='0%25' x2='50%25' y2='82.0854638%25' id='linearGradient-1'%3e %3cstop stop-color='%23B1E997' offset='0%25'%3e%3c/stop%3e %3cstop stop-color='%2361BA46' offset='100%25'%3e%3c/stop%3e %3c/linearGradient%3e %3c/defs%3e %3cg id='%e9%a1%b5%e9%9d%a2-1' stroke='none' stroke-width='1' fill='none' fill-rule='evenodd'%3e %3cg id='%e4%ba%a4%e4%ba%92%e7%bb%86%e8%8a%82' transform='translate(-160.000000%2c -708.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84-25%e5%a4%87%e4%bb%bd-5' transform='translate(151.000000%2c 698.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84-2%e5%a4%87%e4%bb%bd-4'%3e %3cg id='1.%e9%80%9a%e7%94%a8/2.Icon%e5%9b%be%e6%a0%87/Fill/%e6%95%b0%e6%8d%ae%e5%9c%b0%e5%9b%be/API' transform='translate(8.000000%2c 9.000000)'%3e %3cg id='API'%3e %3cpath d='M11.2%2c1.4 C11.9731987%2c1.4 12.6%2c2.02680135 12.6%2c2.8 L12.6%2c11.2 C12.6%2c11.9731987 11.9731987%2c12.6 11.2%2c12.6 L2.8%2c12.6 C2.02680135%2c12.6 1.4%2c11.9731987 1.4%2c11.2 L1.4%2c2.8 C1.4%2c2.02680135 2.02680135%2c1.4 2.8%2c1.4 L11.2%2c1.4 Z M7.67636125%2c4.50938262 L6.42758021%2c4.50938262 L6.42758021%2c9.82058831 L7.26182813%2c9.82058831 L7.26182813%2c7.74274101 L7.68672458%2c7.74274101 C7.94580779%2c7.75310435 8.21007265%2c7.7012877 8.43806587%2c7.59247276 C8.62460577%2c7.49402114 8.78523736%2c7.3541162 8.89405231%2c7.18312129 C8.98732222%2c7.04321636 9.0546839%2c6.88776644 9.08577392%2c6.72195319 C9.12204557%2c6.52504995 9.13240882%2c6.31778339 9.13240882%2c6.12088015 C9.14277217%2c5.86697862 9.10650052%2c5.61307708 9.04950227%2c5.3643572 C8.99768556%2c5.18299896 8.89405231%2c5.01718571 8.75414737%2c4.88246243 C8.62460577%2c4.75292083 8.46397419%2c4.64928755 8.28261595%2c4.59228925 C8.08571271%2c4.53529095 7.87844615%2c4.50420096 7.67636125%2c4.50938262 L7.67636125%2c4.50938262 Z M4.72281272%2c4.50938262 L4.03365139%2c4.50938262 L2.73823538%2c9.81540668 L3.56730163%2c9.81540668 L3.81602151%2c8.67544055 L4.95080594%2c8.67544055 L5.19952581%2c9.81540668 L6.01822874%2c9.81540668 L4.72281272%2c4.50938262 Z M10.6040015%2c4.50938262 L9.7749352%2c4.50938262 L9.7749352%2c9.81540668 L10.6040015%2c9.81540668 L10.6040015%2c4.50938262 Z M4.38082289%2c6.03797353 L4.79017436%2c7.9603709 L3.95074477%2c7.9603709 L4.37045957%2c6.03797353 L4.38082289%2c6.03797353 Z M7.70745123%2c5.22963393 C7.83181117%2c5.22445227 7.96135277%2c5.25036059 8.08053105%2c5.29699556 C8.16343767%2c5.33844887 8.23598097%2c5.40581051 8.27225262%2c5.48871714 C8.3188876%2c5.58716875 8.34479592%2c5.68562037 8.34479592%2c5.78925365 L8.34479592%2c5.78925365 L8.34441209%2c6.27134032 C8.34364444%2c6.35463078 8.34134147%2c6.43178 8.33443259%2c6.50432329 C8.32406926%2c6.59759325 8.29816094%2c6.6908632 8.25152596%2c6.7789515 C8.21007265%2c6.85667645 8.13752935%2c6.92403809 8.04944107%2c6.9654914 C7.92508113%2c7.01212638 7.79035786%2c7.03285303 7.6556346%2c7.02767137 L7.6556346%2c7.02767137 L7.26182813%2c7.02767137 L7.26182813%2c5.22963393 Z' id='%e5%bd%a2%e7%8a%b6%e7%bb%93%e5%90%88' fill='url(%23linearGradient-1)' fill-rule='nonzero'%3e%3c/path%3e %3crect id='%e7%9f%a9%e5%bd%a2' x='0' y='0' width='14' height='14'%3e%3c/rect%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e%3c/svg%3e";

var img$6 = "data:image/svg+xml,%3c%3fxml version='1.0' encoding='UTF-8'%3f%3e%3csvg width='12px' height='13px' viewBox='0 0 12 13' version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'%3e %3c!-- Generator: Sketch 63.1 (92452) - https://sketch.com --%3e %3ctitle%3e1.%e9%80%9a%e7%94%a8/2.Icon%e5%9b%be%e6%a0%87/Fill/%e6%95%b0%e6%8d%ae%e5%9c%b0%e5%9b%be/%e5%ba%94%e7%94%a8%e7%b3%bb%e7%bb%9f%3c/title%3e %3cdesc%3eCreated with Sketch.%3c/desc%3e %3cdefs%3e %3clinearGradient x1='50%25' y1='0%25' x2='50%25' y2='86.6829028%25' id='linearGradient-1'%3e %3cstop stop-color='%23BBA7FE' offset='1.61000845%25'%3e%3c/stop%3e %3cstop stop-color='%236C41FA' offset='100%25'%3e%3c/stop%3e %3c/linearGradient%3e %3c/defs%3e %3cg id='%e9%a1%b5%e9%9d%a2-1' stroke='none' stroke-width='1' fill='none' fill-rule='evenodd'%3e %3cg id='%e4%ba%a4%e4%ba%92%e7%bb%86%e8%8a%82' transform='translate(-160.000000%2c -588.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84-25%e5%a4%87%e4%bb%bd-6' transform='translate(151.000000%2c 579.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84-2%e5%a4%87%e4%bb%bd-4'%3e %3cg id='1.%e9%80%9a%e7%94%a8/2.Icon%e5%9b%be%e6%a0%87/Fill/%e6%95%b0%e6%8d%ae%e5%9c%b0%e5%9b%be/%e5%ba%94%e7%94%a8%e7%b3%bb%e7%bb%9f' transform='translate(8.000000%2c 9.000000)'%3e %3cg id='%e5%ba%94%e7%94%a8%e7%b3%bb%e7%bb%9f'%3e %3cpath d='M1.9274418%2c7.48837205 L5.61302319%2c7.48837205 C5.78199439%2c7.46522203 5.95203733%2c7.52269685 6.07231385%2c7.64361315 C6.19259037%2c7.76452943 6.24916231%2c7.93487488 6.22511621%2c8.10372089 L6.22511621%2c11.776279 C6.24916231%2c11.9451251 6.19259037%2c12.1154705 6.07231385%2c12.2363868 C5.95203733%2c12.3573031 5.78199439%2c12.4147779 5.61302319%2c12.3916279 L1.9274418%2c12.3916279 C1.75640694%2c12.4193894 1.58238169%2c12.3639692 1.45889806%2c12.242415 C1.33541444%2c12.1208609 1.27726068%2c11.9477299 1.30232552%2c11.776279 L1.30232552%2c8.09395345 C1.28069836%2c7.92406976 1.34037282%2c7.75392488 1.4633749%2c7.63476661 C1.58637698%2c7.51560835 1.75833009%2c7.46136401 1.9274418%2c7.48837205 Z M8.08093017%2c7.48837205 L11.7665116%2c7.48837205 C11.9325097%2c7.46811443 12.0985957%2c7.52537102 12.2168449%2c7.64362018 C12.335094%2c7.76186934 12.3923506%2c7.92795538 12.372093%2c8.09395345 L12.372093%2c11.776279 C12.3961391%2c11.9451251 12.3395671%2c12.1154705 12.2192906%2c12.2363868 C12.0990141%2c12.3573031 11.9289712%2c12.4147779 11.7599999%2c12.3916279 L8.08093017%2c12.3916279 C7.91195898%2c12.4147779 7.74191604%2c12.3573031 7.62163952%2c12.2363868 C7.501363%2c12.1154705 7.44479106%2c11.9451251 7.46883715%2c11.776279 L7.46883715%2c8.09395345 C7.44815639%2c7.92667598 7.5062233%2c7.75926567 7.62604249%2c7.64072114 C7.74586169%2c7.52217661 7.91388345%2c7.46590346 8.08093017%2c7.48837205 Z M9.95302324%2c0.912711317 C10.123521%2c0.912711317 10.2840223%2c0.993163728 10.3860465%2c1.1297674 L12.5772092%2c3.32093019 C12.7137637%2c3.42226881 12.794275%2c3.58227667 12.794275%2c3.75232554 C12.794275%2c3.92237441 12.7137637%2c4.08238227 12.5772092%2c4.18372089 L10.3860465%2c6.3781395 C10.2832376%2c6.51352817 10.1230225%2c6.59303934 9.95302324%2c6.59303934 C9.78302386%2c6.59303934 9.62280886%2c6.51352817 9.51999994%2c6.3781395 L7.32883715%2c4.18372089 C7.19350859%2c4.0815874 7.11394936%2c3.92186925 7.11394936%2c3.75232554 C7.11394936%2c3.58278183 7.19350859%2c3.42306368 7.32883715%2c3.32093019 L9.51999994%2c1.1297674 C9.62202416%2c0.993163728 9.78252538%2c0.912711317 9.95302324%2c0.912711317 Z M1.9274418%2c1.32837205 L5.61302319%2c1.32837205 C5.78427611%2c1.30298377 5.95732673%2c1.36117198 6.07844899%2c1.48487131 C6.19957125%2c1.60857064 6.2541038%2c1.78280779 6.22511621%2c1.95348833 L6.22511621%2c5.62279066 C6.24916231%2c5.79163666 6.19259037%2c5.96198212 6.07231385%2c6.0828984 C5.95203733%2c6.20381469 5.78199439%2c6.26128952 5.61302319%2c6.2381395 L1.9274418%2c6.2381395 C1.75640694%2c6.26590107 1.58238169%2c6.21048083 1.45889806%2c6.08892664 C1.33541444%2c5.96737244 1.27726068%2c5.79424147 1.30232552%2c5.62279066 L1.30232552%2c1.95348833 C1.27217013%2c1.78018763 1.32823975%2c1.60305316 1.45262318%2c1.47866972 C1.57700662%2c1.35428628 1.7541411%2c1.29821666 1.9274418%2c1.32837205 Z' id='%e5%bd%a2%e7%8a%b6%e7%bb%93%e5%90%88' fill='url(%23linearGradient-1)' fill-rule='nonzero'%3e%3c/path%3e %3crect id='%e7%9f%a9%e5%bd%a2' x='0' y='0' width='14' height='14'%3e%3c/rect%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e%3c/svg%3e";

var img$5 = "data:image/svg+xml,%3c%3fxml version='1.0' encoding='UTF-8'%3f%3e%3csvg width='14px' height='14px' viewBox='0 0 14 14' version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'%3e %3c!-- Generator: Sketch 63.1 (92452) - https://sketch.com --%3e %3ctitle%3e1.%e9%80%9a%e7%94%a8/2.Icon%e5%9b%be%e6%a0%87/Fill/%e6%95%b0%e6%8d%ae%e5%9c%b0%e5%9b%be/%e6%a0%87%e7%ad%be%3c/title%3e %3cdesc%3eCreated with Sketch.%3c/desc%3e %3cdefs%3e %3clinearGradient x1='50%25' y1='0%25' x2='50%25' y2='100%25' id='linearGradient-1'%3e %3cstop stop-color='%23FFE77D' offset='0%25'%3e%3c/stop%3e %3cstop stop-color='%23FFC500' offset='100%25'%3e%3c/stop%3e %3c/linearGradient%3e %3c/defs%3e %3cg id='%e9%a1%b5%e9%9d%a2-1' stroke='none' stroke-width='1' fill='none' fill-rule='evenodd'%3e %3cg id='%e4%ba%a4%e4%ba%92%e7%bb%86%e8%8a%82' transform='translate(-160.000000%2c -472.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84-25%e5%a4%87%e4%bb%bd-8' transform='translate(151.000000%2c 463.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84-2%e5%a4%87%e4%bb%bd-4'%3e %3cg id='1.%e9%80%9a%e7%94%a8/2.Icon%e5%9b%be%e6%a0%87/Fill/%e6%95%b0%e6%8d%ae%e5%9c%b0%e5%9b%be/%e6%a0%87%e7%ad%be' transform='translate(8.000000%2c 8.000000)'%3e %3cg id='%e6%a0%87%e7%ad%be'%3e %3crect id='%e7%9f%a9%e5%bd%a2' x='-6.94555524e-13' y='2.14939178e-13' width='15.6353488' height='15.6353488'%3e%3c/rect%3e %3cpath d='M13.4909853%2c2.04637268 C13.5762492%2c2.19494681 13.6294828%2c2.35971747 13.6472643%2c2.53009361 L13.6472643%2c2.53009361 L14.0714504%2c7.19241919 C14.0649313%2c7.45929951 13.9794734%2c7.71826309 13.825869%2c7.93660524 L13.825869%2c7.93660524 L9.5616829%2c13.8900936 C9.42615182%2c14.0965011 9.21297733%2c14.2393964 8.97055404%2c14.2863397 C8.72813074%2c14.3332829 8.47702446%2c14.2802917 8.27424104%2c14.1393959 L8.27424104%2c14.1393959 L7.3105201%2c13.3952099 C7.61167703%2c13.3972157 7.90159867%2c13.2809799 8.11796197%2c13.071489 L8.11796197%2c13.071489 L13.0072643%2c7.69474477 C13.2110273%2c7.50075289 13.3266349%2c7.23189806 13.3272643%2c6.95055873 L13.3272643%2c6.95055873 L13.4909853%2c2.29195408 Z M12.2407527%2c1.20172152 C12.4888478%2c1.18646068 12.7324164%2c1.2731663 12.9150621%2c1.4417623 C13.0977078%2c1.61035831 13.2035907%2c1.84622343 13.2081946%2c2.09474477 L13.2081946%2c2.09474477 L12.9626132%2c6.72730291 C12.95961%2c7.00740078 12.8459084%2c7.27493385 12.6463341%2c7.47148896 L12.6463341%2c7.47148896 L7.57470615%2c12.6807913 C7.17284569%2c13.0863727 6.52540383%2c13.1719541 6.20540383%2c12.7663727 L6.20540383%2c12.7663727 L2.02679917%2c8.36451222 C1.69423954%2c7.95004255 1.73129735%2c7.35067276 2.11238057%2c6.98032617 L2.11238057%2c6.98032617 L7.17284569%2c1.77102385 C7.34049526%2c1.58583258 7.5715448%2c1.47030781 7.82028755%2c1.44730292 L7.82028755%2c1.44730292 Z M10.357962%2c2.95613796 C10.0385769%2c2.95613796 9.7332063%2c3.08730014 9.5133108%2c3.31893082 C9.28446339%2c3.54415081 9.15558889%2c3.85179992 9.15558889%2c4.17288431 C9.15558889%2c4.4939687 9.28446339%2c4.8016178 9.5133108%2c5.0268378 C9.7332063%2c5.25846848 10.0385769%2c5.38963065 10.357962%2c5.38963065 C10.677347%2c5.38963065 10.9827176%2c5.25846848 11.2026131%2c5.0268378 C11.6039449%2c4.52826556 11.6039449%2c3.81750306 11.2026131%2c3.31893082 C10.9827176%2c3.08730014 10.677347%2c2.95613796 10.357962%2c2.95613796 Z' id='%e5%bd%a2%e7%8a%b6%e7%bb%93%e5%90%88' fill='url(%23linearGradient-1)' fill-rule='nonzero'%3e%3c/path%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e%3c/svg%3e";

const Table$1 = _ref => {
  let {
    tableIcon,
    mappingTable
  } = _ref;
  return /*#__PURE__*/React__default["default"].createElement(antd.Tooltip, {
    title: `${!!mappingTable ? '映射' : ''}表`
  }, /*#__PURE__*/React__default["default"].createElement("span", {
    className: "icon-table"
  }, /*#__PURE__*/React__default["default"].createElement("img", {
    alt: "",
    src: tableIcon
  })));
};
const Api = () => {
  return /*#__PURE__*/React__default["default"].createElement(antd.Tooltip, {
    title: "Api"
  }, /*#__PURE__*/React__default["default"].createElement("span", {
    className: "icon-table"
  }, /*#__PURE__*/React__default["default"].createElement("img", {
    alt: "",
    src: img$7
  })));
};
const Application = () => {
  return /*#__PURE__*/React__default["default"].createElement(antd.Tooltip, {
    title: "\u5E94\u7528"
  }, /*#__PURE__*/React__default["default"].createElement("span", {
    className: "icon-table"
  }, /*#__PURE__*/React__default["default"].createElement("img", {
    alt: "",
    src: img$6
  })));
};
const Label = () => {
  return /*#__PURE__*/React__default["default"].createElement(antd.Tooltip, {
    title: "\u6807\u7B7E"
  }, /*#__PURE__*/React__default["default"].createElement("span", {
    className: "icon-table"
  }, /*#__PURE__*/React__default["default"].createElement("img", {
    alt: "",
    src: img$5
  })));
};

var img$4 = "data:image/svg+xml,%3c%3fxml version='1.0' encoding='UTF-8'%3f%3e%3csvg width='13px' height='13px' viewBox='0 0 13 13' version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'%3e %3c!-- Generator: Sketch 63.1 (92452) - https://sketch.com --%3e %3ctitle%3e%e8%a1%a8%e6%a0%bc%3c/title%3e %3cdesc%3eCreated with Sketch.%3c/desc%3e %3cg id='%e9%a1%b5%e9%9d%a2-1' stroke='none' stroke-width='1' fill='none' fill-rule='evenodd' fill-opacity='0.65'%3e %3cg id='1-%e9%bb%98%e8%ae%a4%e6%a0%b7%e5%bc%8f' transform='translate(-717.000000%2c -538.000000)' fill='white' fill-rule='nonzero'%3e %3cg id='%e4%b8%bb%e8%a1%a8' transform='translate(695.000000%2c 528.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84-25%e5%a4%87%e4%bb%bd' transform='translate(14.000000%2c 0.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84-2%e5%a4%87%e4%bb%bd-4'%3e %3cg id='%e8%a1%a8%e6%a0%bc' transform='translate(8.000000%2c 9.000000)'%3e %3cg id='%e7%bc%96%e7%bb%84' transform='translate(0.976744%2c 1.302326)'%3e %3cpath d='M7.73795%2c8.50294014 L7.73795%2c12 L4.25146592%2c12 L4.25146592%2c8.50294014 L7.73795%2c8.50294014 Z M3.4935346%2c8.50294014 L3.4935346%2c11.985899 L1.49823633%2c11.985899 C0.677633277%2c11.9840044 0.0112464185%2c11.3223326 0.00352526196%2c10.5017637 L0.00352526196%2c8.50294014 L3.4935346%2c8.50294014 Z M11.9894159%2c8.50294014 L11.9894159%2c10.5017637 C11.9816691%2c11.3250807 11.3110054%2c11.9878727 10.4876543%2c11.9859033 L8.49940658%2c11.9859033 L8.49940658%2c8.50294014 L11.9894159%2c8.50294014 Z M3.48648408%2c4.25147421 L3.48648408%2c7.74853408 L-2.87325719e-13%2c7.74853408 L-2.87325719e-13%2c4.25147421 L3.48648408%2c4.25147421 Z M7.73795%2c4.25147421 L7.73795%2c7.74853408 L4.25146592%2c7.74853408 L4.25146592%2c4.25147421 L7.73795%2c4.25147421 Z M11.9858907%2c4.25147421 L11.9858907%2c7.74853408 L8.49940658%2c7.74853408 L8.49940658%2c4.25147421 L11.9858907%2c4.25147421 Z M10.4876543%2c4.1264248e-06 C10.8862334%2c-0.000930652001 11.2687581%2c0.15698867 11.5505968%2c0.438827394 C11.8324355%2c0.720666119 11.9903549%2c1.10319084 11.9894201%2c1.50176988 L11.9894201%2c3.50059342 L0.00352109892%2c3.50059342 L0.00352109892%2c1.50176988 C0.00258920361%2c1.10441257 0.159541631%2c0.722958246 0.43985457%2c0.441323076 C0.720167509%2c0.159687907 1.10087901%2c0.000942148026 1.49823633%2c4.1264248e-06 L10.4876543%2c4.1264248e-06 Z' id='%e5%bd%a2%e7%8a%b6%e7%bb%93%e5%90%88'%3e%3c/path%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e %3c/g%3e%3c/svg%3e";

const TableWhite = _ref => {
  let {
    mappingTable
  } = _ref;
  return /*#__PURE__*/React__default["default"].createElement(antd.Tooltip, {
    title: `${!!mappingTable ? '映射' : ''}表`
  }, /*#__PURE__*/React__default["default"].createElement("span", {
    className: "icon-table"
  }, /*#__PURE__*/React__default["default"].createElement("img", {
    alt: "",
    src: img$4
  })));
};

const Column = () => {
  return /*#__PURE__*/React__default["default"].createElement("div", {
    className: "icon-column"
  }, /*#__PURE__*/React__default["default"].createElement("svg", {
    t: "1613907626847",
    className: "icon",
    viewBox: "0 0 1024 1024",
    version: "1.1",
    xmlns: "http://www.w3.org/2000/svg",
    "p-id": "30796",
    width: "128",
    height: "128"
  }, /*#__PURE__*/React__default["default"].createElement("path", {
    d: "M0 0h1024v1024H0V0z m73.356 72.937V953.25h881.43V72.937H73.357z",
    "p-id": "30797"
  }), /*#__PURE__*/React__default["default"].createElement("path", {
    d: "M206.522 186.228l-20.34 162.91h20.34c0-57.019 44.823-101.795 101.842-101.795h142.661V766.51c0 28.485-22.434 50.92-50.967 50.92h-50.92v20.387h325.818v-20.387h-50.921a50.409 50.409 0 0 1-50.92-50.92V247.296h142.568c56.972 0 101.841 44.823 101.841 101.795h20.294l-20.294-162.91H206.522v0.047z",
    "p-id": "30798"
  })));
};

function styleInject(css, ref) {
  if (ref === void 0) ref = {};
  var insertAt = ref.insertAt;

  if (!css || typeof document === 'undefined') {
    return;
  }

  var head = document.head || document.getElementsByTagName('head')[0];
  var style = document.createElement('style');
  style.type = 'text/css';

  if (insertAt === 'top') {
    if (head.firstChild) {
      head.insertBefore(style, head.firstChild);
    } else {
      head.appendChild(style);
    }
  } else {
    head.appendChild(style);
  }

  if (style.styleSheet) {
    style.styleSheet.cssText = css;
  } else {
    style.appendChild(document.createTextNode(css));
  }
}

var css_248z$2 = ".icon-table {\n  width: 14px;\n  height: 14px;\n  color: white;\n  border-radius: 2px;\n  display: block;\n}\n.icon-table img {\n  height: 100%;\n  width: 100%;\n  vertical-align: initial;\n}\n.icon-table svg {\n  height: 100%;\n  width: 100%;\n  stroke: white;\n  fill: white;\n  left: 0;\n  top: 0;\n  margin: 0;\n  padding-top: 0px;\n}\n.icon-table svg path {\n  stroke: white;\n  fill: white;\n}\n.icon-column {\n  height: 12.5px;\n  width: 12.5px;\n}\n.icon-column svg {\n  height: 100%;\n  width: 100%;\n}\n.icon-column svg path {\n  fill: #9B9B9B;\n}\n";
styleInject(css_248z$2);

var Icons = {
  Table: Table$1,
  TableWhite,
  Column,
  Api,
  Application,
  Label
};

var css_248z$1 = ".component {\n  height: fit-content;\n  text-align: center;\n  background: #fff;\n  box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.15);\n  border-radius: 4px;\n  background: transparent;\n}\n.component .node-icon {\n  margin-right: 8px;\n}\n.component .node-icon .white-bg {\n  background: #fff;\n  border-radius: 2px;\n  padding: 3px;\n}\n.component .filed-title-name {\n  width: 70%;\n  overflow: hidden;\n  text-overflow: ellipsis;\n  white-space: nowrap;\n}\n.component .operators {\n  margin-left: 10px;\n  display: flex;\n  justify-content: space-between;\n  align-items: center;\n}\n.component .dashed {\n  border: 1px dashed #c9cbd3;\n  border-top-left-radius: 2px;\n  border-top-right-radius: 2px;\n}\n.component .dashed .field-content {\n  border: 0!important;\n}\n.component .field {\n  min-width: 216px;\n  background: #fff;\n}\n.component .field.loop-active .field-title {\n  border: 1px solid #F5222D;\n  border-radius: 2px;\n}\n.component .field.loop-active .field-title .item-endpoint-left {\n  border-left: 5px solid #F5222D !important;\n}\n.component .field.loop-active .field-title .item-endpoint-right {\n  background: #F5222D !important;\n}\n.component .field .field-content {\n  background: #fff;\n  border: 1px solid #D9E2EC;\n  border-top: 0;\n}\n.component .field .field-content.field-item {\n  border-bottom: 0;\n}\n.component .field .field-item {\n  font-size: 12px;\n  text-align: left;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  cursor: pointer;\n  position: relative;\n  padding: 4px 8px;\n  border-bottom: 1px solid #f2f5f9;\n  background-color: #fff;\n}\n.component .field .field-item.field-content:hover .item-endpoint-right {\n  border-color: #ff6a00;\n  background: #ff6a00;\n}\n.component .field .field-item.field-content:hover .item-endpoint-left {\n  left: -6px;\n  display: inline-block;\n  width: 0;\n  height: 0;\n  border-top: 3px solid transparent;\n  border-bottom: 3px solid transparent;\n  border-left: 5px solid #ff6a00;\n  background: transparent;\n}\n.component .field .field-item .item-endpoint {\n  display: inline-block;\n  width: 2px;\n  height: 14px;\n  background: #c9cbd2;\n  position: absolute;\n  top: 52%;\n  transform: translateY(-50%);\n  opacity: 0;\n}\n.component .field .field-item .item-endpoint.visible {\n  opacity: 1;\n}\n.component .field .field-item .item-endpoint span {\n  display: block;\n  height: 100%;\n  width: 100%;\n}\n.component .field .field-item .item-endpoint-left {\n  left: -6px;\n  display: inline-block;\n  width: 0;\n  height: 0;\n  border-top: 3px solid transparent;\n  border-bottom: 3px solid transparent;\n  border-left: 5px solid #bdbdbd;\n  background: transparent;\n}\n.component .field .field-item .item-endpoint-right {\n  right: -3px;\n}\n.component .field .field-item .field-item-content {\n  flex: 1;\n  display: flex;\n  padding: 2px 0;\n}\n.component .field .field-item .field-item-content .field-item-icon {\n  width: 20px;\n  text-align: center;\n  font-size: 12px;\n}\n.component .field .field-item .field-item-content .field-item-title {\n  flex: 1;\n  text-align: left;\n  color: #000;\n  display: flex;\n  align-items: center;\n  width: 100%;\n}\n.component .field .field-item .field-item-content .field-item-title .item-icon {\n  height: 12.5px;\n  width: 12.5px;\n  display: inline-block;\n  margin-right: 10px;\n  margin-left: 4.25px;\n}\n.component .field .field-item .field-item-content .field-item-title .item-text {\n  display: flex;\n  flex: 1;\n  justify-content: space-between;\n}\n.component .field .field-item .field-item-content .field-item-title .item-text .name {\n  flex: 2;\n}\n.component .field .field-item .field-item-content .field-item-title .item-text .name:hover {\n  color: #2466ff;\n}\n.component .field .field-item .field-item-content .field-item-title .item-text .desc {\n  flex: 1;\n}\n.component .field .field-item .field-item-content .field-item-title .item-text .desc .gray {\n  color: rgba(0, 0, 0, 0.25);\n}\n.component .field .field-item .field-item-content .component-operator-comtainer {\n  margin-left: 20px;\n  display: flex;\n  justify-content: space-around;\n  align-items: center;\n}\n.component .field .field-title .item-endpoint {\n  opacity: 1!important;\n}\n.component .field .field-item-active {\n  background-color: #fef0e5;\n}\n.component .field .field-item-active .field-item-content .item-text {\n  display: flex;\n  flex: 1;\n  justify-content: space-between;\n}\n.component .field .field-item-active .field-item-content .item-text .name {\n  flex: 2;\n  color: #2466ff;\n}\n.component .field .field-item-active .field-item-content .item-text .desc {\n  flex: 1;\n}\n.component .field .field-item-active .field-item-content .item-text .desc .gray {\n  color: rgba(0, 0, 0, 0.25);\n}\n.component .field .field-item-active .item-endpoint-right {\n  border-color: #ff6a00;\n  background: #ff6a00;\n}\n.component .field .field-item-active .item-endpoint-left {\n  left: -6px;\n  display: inline-block;\n  width: 0;\n  height: 0;\n  border-top: 3px solid transparent;\n  border-bottom: 3px solid transparent;\n  border-left: 5px solid #ff6a00;\n  background: transparent;\n}\n.component .field .field-title {\n  display: flex;\n  justify-content: space-between;\n  border-bottom: 1px solid #ededed;\n  background-color: #e6f6ff;\n  height: 32px;\n  padding: 8px;\n  border-radius: 2px;\n  box-shadow: 0 2px 2px 0 rgba(181, 183, 192, 0.25);\n  z-index: 1;\n}\n.component .primay-table .field-title {\n  color: #fff;\n  background-image: linear-gradient(180deg, #5DBAFF 0%, #0075FF 71%);\n  border: 1px solid #FFFFFF;\n}\n.component .primay-table .field-content {\n  border: 1px solid #5DBAFF;\n  border-top: 0;\n}\n.component .left21 {\n  left: -21px !important;\n}\n";
styleInject(css_248z$1);

const noop$2 = () => null;
/**
 * 获取一个锚点
 * @param {String} nodeId 节点的ID
 * @param {String} id 唯一ID
 * @param {String} direction 方向
 * @param {Boolean} visible 是否可见
 * @param {Boolean} isUpExpand 上游是否可展开
 */


const getEndpoint = function (nodeId, id, direction) {
  let visible = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : false;
  let endpointClassName = arguments.length > 4 && arguments[4] !== undefined ? arguments[4] : '';
  let onEndpointClick = arguments.length > 5 && arguments[5] !== undefined ? arguments[5] : noop$2;
  return /*#__PURE__*/React__default["default"].createElement("span", {
    className: classnames__default["default"]('item-endpoint', `item-endpoint-${direction}`, {
      visible
    }, `${endpointClassName}`),
    onClick: () => visible && onEndpointClick(nodeId, direction)
  }, /*#__PURE__*/React__default["default"].createElement(ReactButterfly.Endpoint, {
    nodeId: nodeId,
    id: id + `-${direction}`,
    orientation: direction === 'left' ? [-1, 0] : [1, 0]
  }));
};

const NodeComponent = props => {
  const {
    node,
    onItemActive,
    activeNodeItemIds = [],
    isHidden = false,
    onNodeClick = noop$2,
    onItemClick = noop$2,
    onNodeDoubleClick = noop$2,
    endpointEdge = {},
    isUnRelItemHidden = false,
    onNodeItemDoubleClick = noop$2,
    onEndpointClick = noop$2,
    isLoop = false,
    loopNum = 0
  } = props;
  const {
    isPrimary = false
  } = node;
  const typeObj = {
    // 1: <Icons.Application />,
    2: isPrimary || node.tableIcon === '' || !node.tableIcon ? /*#__PURE__*/React__default["default"].createElement(Icons.TableWhite, {
      mappingTable: node.mappingTable
    }) : /*#__PURE__*/React__default["default"].createElement("div", {
      className: "white-bg"
    }, /*#__PURE__*/React__default["default"].createElement(Icons.Table, {
      tableIcon: node.tableIcon,
      mappingTable: node.mappingTable
    })),
    3: /*#__PURE__*/React__default["default"].createElement(Icons.Api, null),
    4: /*#__PURE__*/React__default["default"].createElement(Icons.Application, null),
    5: /*#__PURE__*/React__default["default"].createElement(Icons.Label, null)
  };
  const colorObj = {
    2: '#E6F6FF',
    // 表
    3: '#EFFBEC',
    // api
    4: '#F7F5FF',
    // 应用
    5: '#FFF8EA' // 标签

  };
  const {
    nodeItems,
    title,
    id,
    type,
    operators = [],
    isHideEndpoint = false,
    endpointClassName = '',
    nodeClassName = '',
    nodeIcon = typeObj[type],
    isLoopActive = false,
    // 环路是否高亮
    isFold,
    isUpExpand,
    // 上游是否展开
    isDownExpand,
    // 下游是否展开
    scopeType,
    DownIsTable,
    // 下游节点是否为表，是： true，
    mappingTable // 当前节点是否为映射表

  } = node;
  const isTableActive = activeNodeItemIds.includes(id);
  const leftClassName = !isLoop ? loopNum === 0 ? isUpExpand && (scopeType === '1' || scopeType === '3') ? 'left21' : '' : '' : '';
  return /*#__PURE__*/React__default["default"].createElement("div", {
    className: `component ${nodeClassName}`,
    key: id
  }, /*#__PURE__*/React__default["default"].createElement("div", {
    // className={
    //   !isLoopActive ? 
    //   (isPrimary ? "field primay-table" : "field" ) 
    //   : 
    //   (isPrimary ? "field primay-table loop-active" : "field loop-active" )
    // }
    className: `${!!mappingTable ? "dashed" : ""} ${!isLoopActive ? isPrimary ? "field primay-table" : "field" : isPrimary ? "field primay-table loop-active" : "field loop-active"}`,
    onClick: () => {}
  }, /*#__PURE__*/React__default["default"].createElement("div", {
    className: `field-title field-item ${isTableActive ? 'field-item-active' : ''}`,
    style: {
      backgroundColor: colorObj[type]
    },
    onClick: e => {
      if (!isLoop && loopNum === 0) {
        e.stopPropagation();
        onNodeClick(id);
      } else if (!isLoop) {
        antd.message.warning(`当前血缘存在${loopNum}条环路，不支持血缘高亮，请开启血缘环路进行检测！`);
      }
    },
    onDoubleClick: () => onNodeDoubleClick(id)
  }, /*#__PURE__*/React__default["default"].createElement("div", {
    className: "node-icon"
  }, nodeIcon), /*#__PURE__*/React__default["default"].createElement("div", {
    className: "filed-title-name"
  }, /*#__PURE__*/React__default["default"].createElement(antd.Tooltip, {
    title: title
  }, title)), isDownExpand || !DownIsTable ? getEndpoint(id, id, 'right', isHideEndpoint, endpointClassName, onEndpointClick, isUpExpand) : null, isUpExpand || type !== 2 ? getEndpoint(id, id, 'left', isHideEndpoint, leftClassName, onEndpointClick, isUpExpand) : null, /*#__PURE__*/React__default["default"].createElement("div", {
    className: "operators"
  }, operators.map((_ref, index) => {
    let {
      component
    } = _ref;
    return /*#__PURE__*/React__default["default"].createElement("span", {
      className: "op-item",
      key: index
    }, component);
  }))), /*#__PURE__*/React__default["default"].createElement("div", {
    className: !isHidden && nodeItems.length > 0 ? "field-content" : ""
  }, !isHidden && nodeItems.map(nodeItem => {
    const isActive = activeNodeItemIds.includes(nodeItem.id) || nodeItem.isActive; // 是否有链接
    // const hasConnect = endpointEdge[`${nodeItem.id}-left`] || endpointEdge[`${nodeItem.id}-right`];
    // if (isUnRelItemHidden && !hasConnect) {
    //   return null;
    // }

    return /*#__PURE__*/React__default["default"].createElement("div", {
      className: classnames__default["default"]('field-item', {
        'field-item-active': isActive
      }),
      key: nodeItem.id,
      onMouseEnter: () => {
        if (!isLoop && loopNum === 0) {
          onItemActive(nodeItem.id);
        }
      } // onMouseLeave={() => {
      //   onItemActive()
      // }}
      ,
      onClick: e => {
        e.stopPropagation(); // 获取详情

        onItemClick(nodeItem);

        if (!isLoop && loopNum === 0) {
          // 获取血缘
          onItemActive(nodeItem.id);
        }
      },
      onDoubleClick: () => onNodeItemDoubleClick(nodeItem.id)
    }, getEndpoint(id, nodeItem.id, 'left', endpointEdge[`${nodeItem.id}-left`] || nodeItem.isHideEndpoint, endpointClassName, onEndpointClick), getEndpoint(id, nodeItem.id, 'right', endpointEdge[`${nodeItem.id}-right`] || nodeItem.isHideEndpoint, endpointClassName, onEndpointClick), /*#__PURE__*/React__default["default"].createElement("div", {
      className: "field-item-content"
    }, /*#__PURE__*/React__default["default"].createElement("div", {
      className: "field-item-title"
    }, /*#__PURE__*/React__default["default"].createElement("div", {
      className: "item-text"
    }, /*#__PURE__*/React__default["default"].createElement("div", {
      style: {
        flex: 2
      }
    }, /*#__PURE__*/React__default["default"].createElement("span", {
      className: "name"
    }, nodeItem.name)), /*#__PURE__*/React__default["default"].createElement("div", {
      className: "desc omit",
      title: nodeItem.descr || '-'
    }, nodeItem.descr || /*#__PURE__*/React__default["default"].createElement("span", {
      className: "gray"
    }, "-"))))));
  }))));
};

NodeComponent.propTypes = {
  node: NodeTypes,
  onItemActive: PropTypes__default["default"].func,
  // 节点hover时
  activeNodeItemIds: PropTypes__default["default"].arrayOf(PropTypes__default["default"].string),
  // 当前active的节点，用于判断是否应该高亮
  isHidden: PropTypes__default["default"].bool,
  // 是否收起字段
  onNodeClick: PropTypes__default["default"].func,
  // 节点点击时
  onItemClick: PropTypes__default["default"].func,
  // 字段点击时
  onNodeDoubleClick: PropTypes__default["default"].func,
  // 节点双击是
  onNodeItemDoubleClick: PropTypes__default["default"].func,
  // 字段双击
  isActive: PropTypes__default["default"].bool,
  // 字段是否高亮
  isNodeActive: PropTypes__default["default"].bool,
  // 血缘环路中，节点是否高亮
  endpointEdge: PropTypes__default["default"].object,
  // 边和锚点的映射，渲染用
  isUnRelItemHidden: PropTypes__default["default"].bool,
  // 是否隐藏没有联系的列
  onEndpointClick: PropTypes__default["default"].func,
  // 锚点单击事件
  isLoop: PropTypes__default["default"].bool // 是否是血缘环路

};

var img$3 = "data:image/svg+xml,%3csvg id='%e5%9b%be%e5%b1%82_1' data-name='%e5%9b%be%e5%b1%82 1' xmlns='http://www.w3.org/2000/svg' viewBox='0 0 40 40'%3e%3ctitle%3eHIVE%3c/title%3e%3cpath d='M11.17%2c22.38a7.91%2c7.91%2c0%2c0%2c0%2c1.64%2c2.19c1.3%2c1.4%2c2.71%2c2.2%2c5.55%2c3.11.57.16.84%2c1.54.27%2c1.54-1.14%2c0-4.59-1.48-6.13-2.61l-1.84-1.34a14.37%2c14.37%2c0%2c0%2c1%2c.39-3.71%2c1.71%2c1.71%2c0%2c0%2c0%2c.12.82Zm3.91-3.3c.4%2c1.67%2c2.91%2c6.46%2c3.61%2c7%2c.37.27.61.6.47.7-.26.27-3.64-1.94-4.68-3a7.26%2c7.26%2c0%2c0%2c1-1.74-3.58c-.2-1.11-.14-1.24.73-1.54C14.81%2c18.07%2c14.81%2c18.07%2c15.08%2c19.08Z' style='fill:%23fe0'/%3e%3cpath d='M29.43%2c11.42%2c28.5%2c9.61' style='fill:%23f6e923'/%3e%3cpath d='M14.24%2c5.56A36.41%2c36.41%2c0%2c0%2c1%2c22%2c9.78a6.06%2c6.06%2c0%2c0%2c1%2c1.71%2c3c.36%2c1.18.8%2c2%2c1.07%2c2s.4-.1%2c0-.54a5.24%2c5.24%2c0%2c0%2c1-.74-2A5.48%2c5.48%2c0%2c0%2c0%2c21.27%2c8.4c-.4-.16-.37-.33.27-1s1.07-.8%2c2.51-.73A2.75%2c2.75%2c0%2c0%2c1%2c26.86%2c8a11.93%2c11.93%2c0%2c0%2c1%2c1.6%2c2.34c.47%2c1%2c.47%2c1.24-.13%2c3l-.67%2c1.94%2c1.17%2c2.28c1.24%2c2.51%2c1.37%2c3.07.64%2c2.81a.52.52%2c0%2c0%2c0-.67.1c-.13.2%2c0%2c.33.17.33s.3.14.2.3%2c0%2c.4.2.47-.07.1-.64%2c0-1.1%2c0-1.1.17.27.3.6.17c.5-.2.54-.17.07.4s-.47.6.26.2.91-.3.41.67c-.24.4-.24.63%2c0%2c.63s.5-.53.74-1.17c.4-1.1%2c1-1.57%2c1-.83%2c0%2c.5.77.4%2c1.54-.17.6-.44.6-.47-.2-.3s-.74.1-.17-.17a1.07%2c1.07%2c0%2c0%2c1%2c1%2c0c.47.46-.47%2c3.58-1.51%2c5a3.52%2c3.52%2c0%2c0%2c1-4%2c1.54c-1.14-.37-3.65-2.51-3.42-2.91.14-.2%2c0-.3-.2-.2a.92.92%2c0%2c0%2c0-.6.6c-.1.24%2c0%2c.34.23.2.57-.37.44.67-.13%2c1.14a.89.89%2c0%2c0%2c0-.37.9c.1.27%2c0%2c.37-.13.27a.78.78%2c0%2c0%2c1-.34-.67%2c4.32%2c4.32%2c0%2c0%2c0-.87-1.5%2c2.32%2c2.32%2c0%2c0%2c1-.7-2.28c.2-1.14.14-1.27-.87-1.74s-1.07-.6-1.17-2.71l-.1-2.24-1.24.3c-.67.13-2.57.7-4.25%2c1.27-3.94%2c1.31-5.89%2c1.17-6.45-.43A12%2c12%2c0%2c0%2c0%2c4.71%2c15c-2-2.18-2.44-3.78-1.61-5.46.5-1%2c.81-1.24%2c1.81-1.34a8.38%2c8.38%2c0%2c0%2c1%2c3%2c.57c2.27.87%2c2.54.67.5-.3L6.85%2c7.74l.94-1.07C10.06%2c4.09%2c10.6%2c4%2c14.24%2c5.56Z' style='fill:%23fe0'/%3e%3cpath d='M8%2c5.53C6.58%2c6.93%2c6%2c7.3%2c4.81%2c7.43S3.3%2c7.77%2c2.6%2c9.21c-1%2c2.07-.8%2c3%2c1.27%2c5.42A16.72%2c16.72%2c0%2c0%2c1%2c6.18%2c18l.67%2c1.5H8.69a9.1%2c9.1%2c0%2c0%2c0%2c2.68-.33c1-.4%2c1-.34.16%2c1.14s-.67%2c2.17%2c1.28%2c4.25c1.3%2c1.4%2c2.71%2c2.2%2c5.55%2c3.11.57.16.84%2c1.54.27%2c1.54-1.14%2c0-4.59-1.48-6.13-2.61l-1.84-1.34.34%2c1.5a3.7%2c3.7%2c0%2c0%2c0%2c.5%2c1.3A4.21%2c4.21%2c0%2c0%2c0%2c13%2c29.12a21.11%2c21.11%2c0%2c0%2c0%2c4%2c1.3c2.25.47%2c3.05.94%2c2.68%2c1.54s-2.34.3-4.55-.4A8.85%2c8.85%2c0%2c0%2c0%2c13%2c31c-.07.06.18.26.63.62a7.52%2c7.52%2c0%2c0%2c0%2c3.69%2c1.94%2c6.21%2c6.21%2c0%2c0%2c0%2c2.56-.27c.84-.23%2c1.11-.2%2c1.27.24a.84.84%2c0%2c0%2c1-.36%2c1c-.27.19-.41.32-.42.37s.47%2c0%2c1.62-.44c.77-.27%2c1.47-.5%2c1.54-.5a3%2c3%2c0%2c0%2c1%2c.13%2c1.21c0%2c1%2c.1%2c1.17.74%2c1.07s.77-.27.67-1.31c-.07-.7%2c0-1.34.23-1.47s.37.33.37%2c1.34c0%2c1.4.07%2c1.54.77%2c1.44s.74-.27.8-3.52l.1-3.44h-.83c-.77%2c0-.84.13-.84%2c1.37%2c0%2c.8-.13%2c1.27-.33%2c1.14A2.2%2c2.2%2c0%2c0%2c1%2c25%2c30.35c0-.9-.13-1.13-.67-1.13s-.67.23-.67%2c1.87v1.84l-1.07-.1c-.6-.07-1-.23-1-.4s-.1-.44-.4-.6c-.77-.44-.67-1.21.23-1.38.67-.13.67-.13-.1-.2-1%2c0-1.67-.6-1.67-1.47%2c0-.57%2c0-.57.53-.1a1.68%2c1.68%2c0%2c0%2c0%2c1%2c.54c.4%2c0%2c.3-.24-.33-.87s-.81-1-.71-1.17c.37-.61%2c1.41-.27%2c2%2c.56s.7.84%2c1.77.67a10.69%2c10.69%2c0%2c0%2c1%2c4.28%2c0c1.58.23%2c1.78.17%2c2.91-.8s2-2.78%2c2.41-5.42c.27-1.48-.4-2.25-1.47-1.68s-1.37.47-1.37-.16a11.71%2c11.71%2c0%2c0%2c0-1.21-2.81l-1.2-2.28.6-1.91.6-1.9L28.5%2c9.61C27.13%2c7%2c26%2c6.13%2c24%2c6.13A3.46%2c3.46%2c0%2c0%2c0%2c21.3%2c7l-1%2c.87-3-1.54c-2.54-1.3-6-2.54-7.23-2.54A8%2c8%2c0%2c0%2c0%2c8%2c5.53Zm6.25%2c0A36.41%2c36.41%2c0%2c0%2c1%2c22%2c9.78a6.06%2c6.06%2c0%2c0%2c1%2c1.71%2c3c.36%2c1.18.8%2c2%2c1.07%2c2s.4-.1%2c0-.54a5.24%2c5.24%2c0%2c0%2c1-.74-2A5.48%2c5.48%2c0%2c0%2c0%2c21.27%2c8.4c-.4-.16-.37-.33.27-1s1.07-.8%2c2.51-.73A2.75%2c2.75%2c0%2c0%2c1%2c26.86%2c8a11.93%2c11.93%2c0%2c0%2c1%2c1.6%2c2.34c.47%2c1%2c.47%2c1.24-.13%2c3l-.67%2c1.94%2c1.17%2c2.28c1.24%2c2.51%2c1.37%2c3.07.64%2c2.81a.52.52%2c0%2c0%2c0-.67.1c-.13.2%2c0%2c.33.17.33s.3.14.2.3%2c0%2c.4.2.47-.07.1-.64%2c0-1.1%2c0-1.1.17.27.3.6.17c.5-.2.54-.17.07.4s-.47.6.26.2.91-.3.41.67c-.24.4-.24.63%2c0%2c.63s.5-.53.74-1.17c.4-1.1%2c1-1.57%2c1-.83%2c0%2c.5.77.4%2c1.54-.17.6-.44.6-.47-.2-.3s-.74.1-.17-.17a1.07%2c1.07%2c0%2c0%2c1%2c1%2c0c.47.46-.47%2c3.58-1.51%2c5a3.52%2c3.52%2c0%2c0%2c1-4%2c1.54c-1.14-.37-3.65-2.51-3.42-2.91.14-.2%2c0-.3-.2-.2a.92.92%2c0%2c0%2c0-.6.6c-.1.24%2c0%2c.34.23.2.57-.37.44.67-.13%2c1.14a.89.89%2c0%2c0%2c0-.37.9c.1.27%2c0%2c.37-.13.27a.78.78%2c0%2c0%2c1-.34-.67%2c4.32%2c4.32%2c0%2c0%2c0-.87-1.5%2c2.32%2c2.32%2c0%2c0%2c1-.7-2.28c.2-1.14.14-1.27-.87-1.74s-1.07-.6-1.17-2.71l-.1-2.24-1.24.3c-.67.13-2.57.7-4.25%2c1.27-3.94%2c1.31-5.89%2c1.17-6.45-.43A12%2c12%2c0%2c0%2c0%2c4.71%2c15c-2-2.18-2.44-3.78-1.61-5.46.5-1%2c.81-1.24%2c1.81-1.34a8.38%2c8.38%2c0%2c0%2c1%2c3%2c.57c2.27.87%2c2.54.67.5-.3L6.85%2c7.74l.94-1.07C10.06%2c4.09%2c10.6%2c4%2c14.24%2c5.56Zm.84%2c13.52c.4%2c1.67%2c2.91%2c6.46%2c3.61%2c7%2c.37.27.61.6.47.7-.26.27-3.64-1.94-4.68-3a7.26%2c7.26%2c0%2c0%2c1-1.74-3.58c-.2-1.11-.14-1.24.73-1.54C14.81%2c18.07%2c14.81%2c18.07%2c15.08%2c19.08Zm9.54%2c8.63a1.53%2c1.53%2c0%2c0%2c1-1%2c.5c-.37%2c0-.27-.16.3-.47C25.05%2c27.11%2c25.12%2c27.11%2c24.62%2c27.71Z'/%3e%3cpath d='M25.29%2c8.27c0%2c.4%2c1.67%2c3.35%2c1.67%2c3a6%2c6%2c0%2c0%2c0-1.31-2.88c-.2-.14-.36-.17-.36-.07Zm-7.2%2c3.35c1.88.33%2c1.94.4%2c1.17.77l-.83.4h1a2.75%2c2.75%2c0%2c0%2c1%2c1.94%2c1.1L22.31%2c15l-.84-1.71c-1-2-1.27-2.14-3.65-2.11l-1.74%2c0%2c2%2c.4Zm6%2c6.25c-.36.57%2c0%2c.67.71.14s.57-.47.06-.5A1%2c1%2c0%2c0%2c0%2c24.11%2c17.87Zm.41%2c1.88c-.41.4-.24.77.36.8s.47.07-.1.3-.36.27.61.24%2c1.2-.2%2c1.07-.51a2.64%2c2.64%2c0%2c0%2c1-.17-.77c0-.33-1.44-.4-1.77-.06Zm3.17%2c12.88c.11%2c3.28.14%2c3.45.87%2c3.55s.74.06.74-3.42V29.22H27.59l.1%2c3.41ZM29.77%2c30c.33%2c1.51%2c1.2%2c6%2c1.2%2c6.19s.41.1.91%2c0c.83-.1%2c1-.31%2c1.34-1.91.2-1%2c.5-2.54.6-3.45.23-1.57.2-1.6-.64-1.6s-.87.13-.87%2c1.33c0%2c.74-.13%2c1.34-.33%2c1.34s-.34-.36-.34-.8c0-1.34-.37-1.87-1.2-1.87-.67%2c0-.8.13-.67.73Zm4.68%2c2.68.1%2c3.45h1.64c1.54%2c0%2c1.64-.07%2c1.74-.94s0-.9-.9-.9c-.57%2c0-1-.17-1-.34s.24-.33.5-.33.51-.31.51-.84-.14-.84-.34-.84-.33-.23-.33-.5.3-.5.83-.5.84-.17.84-.84-.1-.83-1.81-.83h-1.8l.06%2c3.41Z'/%3e%3cpath d='M11.5%2c28.07A4.25%2c4.25%2c0%2c0%2c0%2c13%2c29.12a21.22%2c21.22%2c0%2c0%2c0%2c4.05%2c1.3c2.24.47%2c3.05.94%2c2.68%2c1.54s-2.34.3-4.55-.4A10%2c10%2c0%2c0%2c0%2c13%2c31%2c6.69%2c6.69%2c0%2c0%2c1%2c11.5%2c28.07Zm5.17%2c5.34a4.73%2c4.73%2c0%2c0%2c0%2c1.56.15%2c7.88%2c7.88%2c0%2c0%2c0%2c1.6-.3c.84-.23%2c1.11-.2%2c1.28.24a.86.86%2c0%2c0%2c1-.37%2c1c-.26.19-.41.31-.42.37C17.28%2c34.53%2c16.67%2c33.41%2c16.67%2c33.41Z' style='fill:%23fe0'/%3e%3c/svg%3e";

var img$2 = "data:image/svg+xml,%3csvg id='%e5%9b%be%e5%b1%82_1' data-name='%e5%9b%be%e5%b1%82 1' xmlns='http://www.w3.org/2000/svg' viewBox='0 0 40 40'%3e%3ctitle%3eHIVE2%3c/title%3e%3cpath d='M9%2c22.36a7.57%2c7.57%2c0%2c0%2c0%2c1.62%2c2.16c1.29%2c1.4%2c2.68%2c2.19%2c5.5%2c3.09.56.16.83%2c1.52.27%2c1.52-1.13%2c0-4.55-1.45-6.07-2.58L8.48%2c25.22a14%2c14%2c0%2c0%2c1%2c.39-3.67%2c1.66%2c1.66%2c0%2c0%2c0%2c.12.81Zm3.87-3.27c.4%2c1.65%2c2.89%2c6.4%2c3.58%2c6.89.37.27.6.6.47.7-.27.27-3.62-1.92-4.65-3a7.18%2c7.18%2c0%2c0%2c1-1.72-3.55c-.2-1.09-.13-1.22.73-1.52C12.6%2c18.09%2c12.6%2c18.09%2c12.86%2c19.09Z' style='fill:%23fe0'/%3e%3cpath d='M27.09%2c11.49%2c26.16%2c9.7' style='fill:%23f6e923'/%3e%3cpath d='M12%2c5.69a35.82%2c35.82%2c0%2c0%2c1%2c7.73%2c4.18%2c6%2c6%2c0%2c0%2c1%2c1.69%2c3c.36%2c1.16.8%2c2%2c1.06%2c2s.4-.1%2c0-.53a5.26%2c5.26%2c0%2c0%2c1-.73-2A5.42%2c5.42%2c0%2c0%2c0%2c19%2c8.51c-.4-.17-.37-.33.26-1s1.06-.8%2c2.49-.73a2.71%2c2.71%2c0%2c0%2c1%2c2.78%2c1.32%2c12.63%2c12.63%2c0%2c0%2c1%2c1.6%2c2.32c.46%2c1%2c.46%2c1.23-.14%2c3l-.66%2c1.92%2c1.16%2c2.26c1.23%2c2.48%2c1.36%2c3.05.63%2c2.78a.53.53%2c0%2c0%2c0-.66.1c-.14.2%2c0%2c.33.16.33s.3.14.2.3a.32.32%2c0%2c0%2c0%2c.2.47c.23.1-.07.1-.63%2c0s-1.09%2c0-1.09.16.26.3.59.17c.5-.2.53-.17.07.4s-.46.59.26.2.9-.3.4.66c-.23.4-.23.63%2c0%2c.63s.5-.53.73-1.16c.4-1.1%2c1-1.56%2c1-.83%2c0%2c.5.76.4%2c1.53-.17.59-.43.59-.46-.2-.3s-.73.1-.17-.16a1%2c1%2c0%2c0%2c1%2c1%2c0c.47.46-.46%2c3.54-1.49%2c4.94a3.5%2c3.5%2c0%2c0%2c1-4%2c1.52c-1.13-.36-3.62-2.49-3.38-2.88.13-.2%2c0-.3-.2-.2a.89.89%2c0%2c0%2c0-.6.59c-.1.24%2c0%2c.34.23.2.57-.36.43.67-.13%2c1.13a.9.9%2c0%2c0%2c0-.37.9c.1.26%2c0%2c.36-.13.26A.77.77%2c0%2c0%2c1%2c20%2c27a4.31%2c4.31%2c0%2c0%2c0-.86-1.49%2c2.28%2c2.28%2c0%2c0%2c1-.7-2.26c.2-1.13.13-1.26-.86-1.72s-1.06-.6-1.16-2.69l-.1-2.22-1.23.3c-.66.13-2.55.69-4.21%2c1.26C7%2c19.45%2c5%2c19.32%2c4.47%2c17.73A11.78%2c11.78%2c0%2c0%2c0%2c2.58%2c15C.63%2c12.89.16%2c11.29%2c1%2c9.64c.5-1%2c.8-1.23%2c1.79-1.33a8.2%2c8.2%2c0%2c0%2c1%2c3%2c.56c2.26.87%2c2.52.67.5-.3L4.7%2c7.85l.93-1.07C7.89%2c4.23%2c8.42%2c4.13%2c12%2c5.69Z' style='fill:%23fe0'/%3e%3cpath d='M5.83%2c5.66c-1.39%2c1.39-2%2c1.75-3.15%2c1.89S1.19%2c7.88.49%2c9.3c-1%2c2.06-.79%2c3%2c1.26%2c5.38A16.16%2c16.16%2c0%2c0%2c1%2c4%2c18l.66%2c1.49H6.53a9.22%2c9.22%2c0%2c0%2c0%2c2.65-.33c1-.4%2c1-.34.17%2c1.12s-.67%2c2.16%2c1.26%2c4.21c1.29%2c1.4%2c2.68%2c2.19%2c5.5%2c3.09.56.16.83%2c1.52.27%2c1.52-1.13%2c0-4.55-1.45-6.07-2.58L8.48%2c25.22l.34%2c1.49A3.46%2c3.46%2c0%2c0%2c0%2c9.32%2c28a4.1%2c4.1%2c0%2c0%2c0%2c1.49%2c1%2c19.89%2c19.89%2c0%2c0%2c0%2c4%2c1.3c2.22.46%2c3%2c.93%2c2.65%2c1.52s-2.32.3-4.51-.39a8.27%2c8.27%2c0%2c0%2c0-2.21-.58c-.07.05.18.25.62.61A7.47%2c7.47%2c0%2c0%2c0%2c15%2c33.41a6.43%2c6.43%2c0%2c0%2c0%2c2.54-.26c.83-.24%2c1.09-.2%2c1.26.23a.84.84%2c0%2c0%2c1-.36%2c1c-.26.19-.41.31-.42.37s.47%2c0%2c1.61-.44c.76-.26%2c1.46-.49%2c1.52-.49A2.77%2c2.77%2c0%2c0%2c1%2c21.32%2c35c0%2c1%2c.1%2c1.16.73%2c1.06s.76-.26.66-1.29c-.07-.7%2c0-1.33.23-1.46s.37.33.37%2c1.33c0%2c1.39.06%2c1.52.76%2c1.42s.73-.26.8-3.48L25%2c29.13h-.82c-.77%2c0-.83.14-.83%2c1.36%2c0%2c.8-.14%2c1.26-.34%2c1.13a2.24%2c2.24%2c0%2c0%2c1-.33-1.36c0-.89-.13-1.13-.66-1.13s-.66.24-.66%2c1.86v1.82l-1.06-.09c-.6-.07-1-.24-1-.4s-.1-.43-.4-.6c-.76-.43-.66-1.19.24-1.36.66-.13.66-.13-.1-.2-1%2c0-1.66-.59-1.66-1.46%2c0-.56%2c0-.56.53-.1a1.62%2c1.62%2c0%2c0%2c0%2c1%2c.53c.39%2c0%2c.29-.23-.34-.86s-.79-1-.69-1.16c.36-.6%2c1.39-.26%2c1.95.56s.7.83%2c1.76.67a10.54%2c10.54%2c0%2c0%2c1%2c4.25%2c0c1.56.23%2c1.75.16%2c2.88-.8s2-2.75%2c2.39-5.37c.26-1.46-.4-2.22-1.46-1.66s-1.36.46-1.36-.17a11.74%2c11.74%2c0%2c0%2c0-1.19-2.78l-1.2-2.26.6-1.89.6-1.89L26.16%2c9.7c-1.36-2.55-2.52-3.45-4.51-3.45A3.38%2c3.38%2c0%2c0%2c0%2c19%2c7.12L18%2c8%2c15.05%2c6.45c-2.52-1.29-6-2.52-7.16-2.52A8.16%2c8.16%2c0%2c0%2c0%2c5.83%2c5.66Zm6.2%2c0a35.82%2c35.82%2c0%2c0%2c1%2c7.73%2c4.18%2c6%2c6%2c0%2c0%2c1%2c1.69%2c3c.36%2c1.16.8%2c2%2c1.06%2c2s.4-.1%2c0-.53a5.26%2c5.26%2c0%2c0%2c1-.73-2A5.42%2c5.42%2c0%2c0%2c0%2c19%2c8.51c-.4-.17-.37-.33.26-1s1.06-.8%2c2.49-.73a2.71%2c2.71%2c0%2c0%2c1%2c2.78%2c1.32%2c12.63%2c12.63%2c0%2c0%2c1%2c1.6%2c2.32c.46%2c1%2c.46%2c1.23-.14%2c3l-.66%2c1.92%2c1.16%2c2.26c1.23%2c2.48%2c1.36%2c3.05.63%2c2.78a.53.53%2c0%2c0%2c0-.66.1c-.14.2%2c0%2c.33.16.33s.3.14.2.3a.32.32%2c0%2c0%2c0%2c.2.47c.23.1-.07.1-.63%2c0s-1.09%2c0-1.09.16.26.3.59.17c.5-.2.53-.17.07.4s-.46.59.26.2.9-.3.4.66c-.23.4-.23.63%2c0%2c.63s.5-.53.73-1.16c.4-1.1%2c1-1.56%2c1-.83%2c0%2c.5.76.4%2c1.53-.17.59-.43.59-.46-.2-.3s-.73.1-.17-.16a1%2c1%2c0%2c0%2c1%2c1%2c0c.47.46-.46%2c3.54-1.49%2c4.94a3.5%2c3.5%2c0%2c0%2c1-4%2c1.52c-1.13-.36-3.62-2.49-3.38-2.88.13-.2%2c0-.3-.2-.2a.89.89%2c0%2c0%2c0-.6.59c-.1.24%2c0%2c.34.23.2.57-.36.43.67-.13%2c1.13a.9.9%2c0%2c0%2c0-.37.9c.1.26%2c0%2c.36-.13.26A.77.77%2c0%2c0%2c1%2c20%2c27a4.31%2c4.31%2c0%2c0%2c0-.86-1.49%2c2.28%2c2.28%2c0%2c0%2c1-.7-2.26c.2-1.13.13-1.26-.86-1.72s-1.06-.6-1.16-2.69l-.1-2.22-1.23.3c-.66.13-2.55.69-4.21%2c1.26C7%2c19.45%2c5%2c19.32%2c4.47%2c17.73A11.78%2c11.78%2c0%2c0%2c0%2c2.58%2c15C.63%2c12.89.16%2c11.29%2c1%2c9.64c.5-1%2c.8-1.23%2c1.79-1.33a8.2%2c8.2%2c0%2c0%2c1%2c3%2c.56c2.26.87%2c2.52.67.5-.3L4.7%2c7.85l.93-1.07C7.89%2c4.23%2c8.42%2c4.13%2c12%2c5.69Zm.83%2c13.4c.4%2c1.65%2c2.89%2c6.4%2c3.58%2c6.89.37.27.6.6.47.7-.27.27-3.62-1.92-4.65-3a7.18%2c7.18%2c0%2c0%2c1-1.72-3.55c-.2-1.09-.13-1.22.73-1.52C12.6%2c18.09%2c12.6%2c18.09%2c12.86%2c19.09Zm9.45%2c8.55a1.49%2c1.49%2c0%2c0%2c1-1%2c.5c-.36%2c0-.27-.17.3-.47C22.74%2c27.05%2c22.81%2c27.05%2c22.31%2c27.64Z'/%3e%3cpath d='M23%2c8.38c0%2c.39%2c1.66%2c3.31%2c1.66%2c2.91a6%2c6%2c0%2c0%2c0-1.29-2.85c-.2-.13-.37-.16-.37-.06Zm-7.12%2c3.31c1.85.33%2c1.92.4%2c1.16.76l-.83.4h1A2.77%2c2.77%2c0%2c0%2c1%2c19.1%2c14L20%2c15l-.83-1.69c-1-2-1.26-2.12-3.61-2.09l-1.72%2c0%2c2%2c.4Zm6%2c6.2c-.36.57%2c0%2c.67.7.14s.56-.47.07-.5A1%2c1%2c0%2c0%2c0%2c21.81%2c17.89Zm.4%2c1.86c-.4.4-.23.76.37.8s.46.06-.1.29-.37.27.59.24%2c1.2-.2%2c1.07-.5a2.72%2c2.72%2c0%2c0%2c1-.17-.76c0-.34-1.43-.4-1.76-.07Zm3.15%2c12.77c.1%2c3.25.14%2c3.41.86%2c3.51s.73.07.73-3.38V29.13H25.26l.1%2c3.39Zm2.06-2.66c.33%2c1.5%2c1.19%2c6%2c1.19%2c6.14s.4.1.9%2c0c.83-.1%2c1-.3%2c1.32-1.89.2-1%2c.5-2.52.6-3.41.23-1.56.2-1.6-.63-1.6s-.86.14-.86%2c1.33c0%2c.73-.13%2c1.33-.33%2c1.33s-.33-.37-.33-.8c0-1.33-.37-1.86-1.2-1.86-.66%2c0-.79.14-.66.73Zm4.64%2c2.66.1%2c3.41h1.63c1.52%2c0%2c1.62-.06%2c1.72-.93s0-.89-.9-.89c-.56%2c0-1-.17-1-.33s.23-.34.49-.34.5-.29.5-.82-.13-.83-.33-.83-.33-.24-.33-.5.3-.5.83-.5.83-.16.83-.83-.1-.83-1.79-.83H32l.07%2c3.39Z'/%3e%3cpath d='M9.31%2c28a4.29%2c4.29%2c0%2c0%2c0%2c1.49%2c1%2c20.32%2c20.32%2c0%2c0%2c0%2c4%2c1.3c2.23.46%2c3%2c.93%2c2.66%2c1.52s-2.32.3-4.51-.39a8.8%2c8.8%2c0%2c0%2c0-2.21-.58A6.72%2c6.72%2c0%2c0%2c1%2c9.31%2c28Zm5.13%2c5.29a4.88%2c4.88%2c0%2c0%2c0%2c1.54.15%2c8.4%2c8.4%2c0%2c0%2c0%2c1.59-.3c.83-.23%2c1.1-.2%2c1.26.23a.84.84%2c0%2c0%2c1-.36%2c1c-.26.19-.41.31-.42.37C15%2c34.4%2c14.44%2c33.29%2c14.44%2c33.29Z' style='fill:%23fe0'/%3e%3cpath d='M36%2c31.22a2.27%2c2.27%2c0%2c0%2c1%2c.75-1.67%2c1.76%2c1.76%2c0%2c0%2c1%2c2-.15%2c1.83%2c1.83%2c0%2c0%2c1%2c.88%2c2.17%2c7.29%2c7.29%2c0%2c0%2c1-1.24%2c2c-.48.63-.74%2c1-.74%2c1a7%2c7%2c0%2c0%2c1%2c2%2c.07c.34.24.2.94-.09%2c1-.48.11-3.47%2c0-3.47%2c0-.39%2c0-.55-.57-.12-1.15s1.71-2%2c1.95-2.25c.54-.66.61-1%2c.51-1.27a.64.64%2c0%2c0%2c0-.77-.33.85.85%2c0%2c0%2c0-.5.66.38.38%2c0%2c0%2c1-.27.42%2c1.17%2c1.17%2c0%2c0%2c1-.53-.05A.69.69%2c0%2c0%2c1%2c36%2c31.22Z'/%3e%3c/svg%3e";

var img$1 = "data:image/svg+xml,%3csvg id='%e5%9b%be%e5%b1%82_1' data-name='%e5%9b%be%e5%b1%82 1' xmlns='http://www.w3.org/2000/svg' viewBox='0 0 40 40'%3e%3ctitle%3eMSQL%3c/title%3e%3cpath d='M38%2c34.09a1.2%2c1.2%2c0%2c0%2c1-.17-.32%2c1.86%2c1.86%2c0%2c0%2c0-.2-.4l-.31-.29%2c0%2c0L37.18%2c33l-.24-.23a11%2c11%2c0%2c0%2c0-2.34-2.28c-.19-.13-.43-.27-.69-.42A6.13%2c6.13%2c0%2c0%2c1%2c32.1%2c28.7s0-.07-.07-.08a9.48%2c9.48%2c0%2c0%2c0%2c1.46-.35%2c7.6%2c7.6%2c0%2c0%2c1%2c1.08-.17%2c7.63%2c7.63%2c0%2c0%2c0%2c1.15-.19c.32-.08.64-.17%2c1-.28l.18-.14%2c0-.27a5.89%2c5.89%2c0%2c0%2c1-.5-.6%2c5.25%2c5.25%2c0%2c0%2c0-.62-.72A31.34%2c31.34%2c0%2c0%2c0%2c32%2c23.15a11%2c11%2c0%2c0%2c0-1.46-.72c-.3-.13-.59-.26-.87-.4a2.06%2c2.06%2c0%2c0%2c0-.33-.13%2c1.12%2c1.12%2c0%2c0%2c1-.5-.26%2c6%2c6%2c0%2c0%2c1-.68-1.23c-.07-.16-.15-.31-.22-.47-.57-1.07-1.18-2.38-1.83-3.87-.14-.32-.27-.64-.39-1a10%2c10%2c0%2c0%2c0-.75-1.6%2c22.5%2c22.5%2c0%2c0%2c0-8.67-8.38%2c9.75%2c9.75%2c0%2c0%2c0-2.56-.85l-.35-.08-.75%2c0c-.31%2c0-.61%2c0-.88%2c0a2.37%2c2.37%2c0%2c0%2c1-.59-.43%2c3.19%2c3.19%2c0%2c0%2c0-.43-.34A8.27%2c8.27%2c0%2c0%2c0%2c7%2c2a1.85%2c1.85%2c0%2c0%2c0-1.87%2c1.2c-.53%2c1.27.44%2c2.49%2c1.11%2c3.33.12.14.22.27.31.39l.27.37a7.1%2c7.1%2c0%2c0%2c1%2c.85%2c1.28%2c4.39%2c4.39%2c0%2c0%2c1%2c.18.58%2c4.56%2c4.56%2c0%2c0%2c0%2c.18.6c.1.25.19.51.28.79a18.87%2c18.87%2c0%2c0%2c0%2c.89%2c2.21A10.85%2c10.85%2c0%2c0%2c0%2c10%2c14.1a1.26%2c1.26%2c0%2c0%2c0%2c.22.24%2c1.17%2c1.17%2c0%2c0%2c1%2c.33.39%2c3.24%2c3.24%2c0%2c0%2c0-.38%2c1.11%2c3.92%2c3.92%2c0%2c0%2c1-.15.59A10%2c10%2c0%2c0%2c0%2c10.71%2c24c.26.4.95%2c1.47%2c1.92%2c1.47a1.5%2c1.5%2c0%2c0%2c0%2c.55-.11c.78-.32.88-1.09%2c1-1.92a7.69%2c7.69%2c0%2c0%2c1%2c.16-.94%2c1.77%2c1.77%2c0%2c0%2c0%2c0-.29.17.17%2c0%2c0%2c1%2c0-.07l.23.47c.2.39.39.78.59%2c1.19a12.9%2c12.9%2c0%2c0%2c0%2c2.92%2c3%2c4.16%2c4.16%2c0%2c0%2c1%2c.54.5%2c2.74%2c2.74%2c0%2c0%2c0%2c1.08.77l.12.13v-.15h0V28h0v0a1.76%2c1.76%2c0%2c0%2c0-.37-.35.58.58%2c0%2c0%2c1-.15-.11%2c10.39%2c10.39%2c0%2c0%2c1-1.15-1.33%2c29.11%2c29.11%2c0%2c0%2c1-2.49-4c-.32-.62-.61-1.31-.86-1.92l-.1-.22a2.92%2c2.92%2c0%2c0%2c1-.11-.32.56.56%2c0%2c0%2c0-.44-.5%2c4.3%2c4.3%2c0%2c0%2c1-.38.49%2c4.28%2c4.28%2c0%2c0%2c0-.7%2c1.05%2c9.36%2c9.36%2c0%2c0%2c0-.55%2c2.68%2c3.44%2c3.44%2c0%2c0%2c0%2c0%2c.63%2c0%2c0%2c0%2c0%2c0%2c0%2c0c-.59-.15-.84-.73-1.08-1.3l-.07-.17a9.54%2c9.54%2c0%2c0%2c1-.19-5.87l.14-.38c.26-.67.65-1.69.42-2.07a1.81%2c1.81%2c0%2c0%2c0-.52-.7%2c2.54%2c2.54%2c0%2c0%2c1-.32-.34%2c9%2c9%2c0%2c0%2c1-.8-1.4c-.24-.57-.43-1.18-.62-1.79a17.4%2c17.4%2c0%2c0%2c0-.76-2.09%2c9.68%2c9.68%2c0%2c0%2c0-.9-1.43l-.22-.3c-.14-.2-.28-.38-.45-.58a5.76%2c5.76%2c0%2c0%2c1-.77-1.15.94.94%2c0%2c0%2c1-.08-.84c0-.12.07-.17.27-.24a.45.45%2c0%2c0%2c1%2c.26-.06%2c2.94%2c2.94%2c0%2c0%2c1%2c1%2c.28%2c10.54%2c10.54%2c0%2c0%2c1%2c2.18%2c1.1l.3.25a2%2c2%2c0%2c0%2c0%2c.81.53h.45a5.81%2c5.81%2c0%2c0%2c0%2c1%2c.11%2c4.56%2c4.56%2c0%2c0%2c1%2c1.14.14A13.88%2c13.88%2c0%2c0%2c1%2c17%2c7.24a19.78%2c19.78%2c0%2c0%2c1%2c6.92%2c7.59%2c7.11%2c7.11%2c0%2c0%2c1%2c.34.82c.08.22.17.45.28.69.25.57.52%2c1.14.81%2c1.75s.49%2c1%2c.71%2c1.53l.16.35a13%2c13%2c0%2c0%2c0%2c1.44%2c2.65%2c3.4%2c3.4%2c0%2c0%2c0%2c1.63.77%2c5.31%2c5.31%2c0%2c0%2c1%2c.68.23c.18.07.38.15.6.22a5.92%2c5.92%2c0%2c0%2c1%2c.93.39c.65.41%2c1.37.91%2c2.22%2c1.52.09.07.23.15.38.25a11%2c11%2c0%2c0%2c1%2c1.12.76l.05.06H34.8a9.7%2c9.7%2c0%2c0%2c0-3.87.65l-.28.08c-.3.08-.66.18-.68.65a.85.85%2c0%2c0%2c1%2c.18.34%2c1.26%2c1.26%2c0%2c0%2c0%2c.17.35%2c5.57%2c5.57%2c0%2c0%2c0%2c1.18%2c1.4c.48.36.94.71%2c1.43%2c1a13.23%2c13.23%2c0%2c0%2c0%2c1.35.69%2c13.34%2c13.34%2c0%2c0%2c1%2c1.36.69c.27.17.54.37.82.58s.43.32.64.46a2.61%2c2.61%2c0%2c0%2c1%2c.25.23%2c1.21%2c1.21%2c0%2c0%2c0%2c.49.37l.11-.1%2c0%2c0v-.11Z' style='fill:%23006690'/%3e%3cpath d='M13.38%2c9.13a1.37%2c1.37%2c0%2c0%2c1%2c.19.23l.36.75.06%2c0%2c0-.05a1%2c1%2c0%2c0%2c0%2c.34-.86.75.75%2c0%2c0%2c1-.1-.17%2c1.09%2c1.09%2c0%2c0%2c0-.08-.15.67.67%2c0%2c0%2c0-.26-.24l-.21-.15a1.06%2c1.06%2c0%2c0%2c0-.5.11l-.14%2c0v0h0l0%2c0A1.73%2c1.73%2c0%2c0%2c0%2c13.38%2c9.13Z' style='fill:%23006690'/%3e%3cpath d='M8.75%2c36a2.18%2c2.18%2c0%2c0%2c1%2c0%2c.25.33.33%2c0%2c0%2c1-.06.19.34.34%2c0%2c0%2c1-.18.14.74.74%2c0%2c0%2c1-.32.05.44.44%2c0%2c0%2c1-.39-.12.84.84%2c0%2c0%2c1-.15-.41L7.22%2c33.2c0-.13-.06-.19-.11-.19S7%2c33.07%2c7%2c33.2L6%2c36.33a.53.53%2c0%2c0%2c1-.15.25.65.65%2c0%2c0%2c1-.4.09.9.9%2c0%2c0%2c1-.25%2c0A.38.38%2c0%2c0%2c1%2c5%2c36.59a.31.31%2c0%2c0%2c1-.09-.11%2c1.16%2c1.16%2c0%2c0%2c1-.06-.15c-.18-.53-.35-1-.53-1.56L3.8%2c33.21c0-.13-.08-.2-.13-.2s-.08.07-.1.2l-.43%2c2.88a.81.81%2c0%2c0%2c1-.18.44.63.63%2c0%2c0%2c1-.48.14.45.45%2c0%2c0%2c1-.39-.14.62.62%2c0%2c0%2c1%2c0-.49l.78-4.62A.66.66%2c0%2c0%2c1%2c3.07%2c31a.77.77%2c0%2c0%2c1%2c.49-.15.88.88%2c0%2c0%2c1%2c.49.13.91.91%2c0%2c0%2c1%2c.32.52l1%2c3.41%2c1-3.43A1%2c1%2c0%2c0%2c1%2c6.74%2c31a1%2c1%2c0%2c0%2c1%2c.48-.12A.83.83%2c0%2c0%2c1%2c7.7%2c31a.74.74%2c0%2c0%2c1%2c.27.47Z' style='fill:%23666'/%3e%3cpath d='M12.67%2c35.76a2.22%2c2.22%2c0%2c0%2c1-.19.27%2c1.61%2c1.61%2c0%2c0%2c1-.28.24%2c1.4%2c1.4%2c0%2c0%2c1-.37.17%2c1.65%2c1.65%2c0%2c0%2c1-.46.06%2c2.09%2c2.09%2c0%2c0%2c1-.67-.1%2c1.57%2c1.57%2c0%2c0%2c1-.54-.29%2c1.37%2c1.37%2c0%2c0%2c1-.37-.48%2c1.63%2c1.63%2c0%2c0%2c1-.13-.69V32.53a.27.27%2c0%2c0%2c1%2c.15-.24.68.68%2c0%2c0%2c1%2c.4-.1.71.71%2c0%2c0%2c1%2c.41.1.26.26%2c0%2c0%2c1%2c.16.24v2a2.92%2c2.92%2c0%2c0%2c0%2c0%2c.46.82.82%2c0%2c0%2c0%2c.13.33.66.66%2c0%2c0%2c0%2c.27.19%2c1.13%2c1.13%2c0%2c0%2c0%2c.44.07%2c2.46%2c2.46%2c0%2c0%2c0%2c.4%2c0%2c.79.79%2c0%2c0%2c0%2c.32-.15.77.77%2c0%2c0%2c0%2c.21-.31%2c1.43%2c1.43%2c0%2c0%2c0%2c.08-.51v-2a.3.3%2c0%2c0%2c1%2c.15-.24.76.76%2c0%2c0%2c1%2c.41-.1.7.7%2c0%2c0%2c1%2c.4.1.29.29%2c0%2c0%2c1%2c.16.24V36.4a1.32%2c1.32%2c0%2c0%2c1-.17.68%2c1.57%2c1.57%2c0%2c0%2c1-.48.52%2c2.64%2c2.64%2c0%2c0%2c1-.72.33%2c2.9%2c2.9%2c0%2c0%2c1-.89.11A4.44%2c4.44%2c0%2c0%2c1%2c11%2c38a2.38%2c2.38%2c0%2c0%2c1-.42-.09%2c1.94%2c1.94%2c0%2c0%2c1-.36-.15%2c2.2%2c2.2%2c0%2c0%2c1-.32-.21.89.89%2c0%2c0%2c1-.18-.14.39.39%2c0%2c0%2c1-.1-.24%2c1.06%2c1.06%2c0%2c0%2c1%2c0-.29.55.55%2c0%2c0%2c1%2c.1-.17.23.23%2c0%2c0%2c1%2c.11-.07l.1%2c0a.43.43%2c0%2c0%2c1%2c.23.11%2c1.88%2c1.88%2c0%2c0%2c0%2c.55.27%2c2.57%2c2.57%2c0%2c0%2c0%2c.79.1A1.87%2c1.87%2c0%2c0%2c0%2c12%2c37a1.5%2c1.5%2c0%2c0%2c0%2c.36-.16.72.72%2c0%2c0%2c0%2c.21-.22.49.49%2c0%2c0%2c0%2c.08-.25Z' style='fill:%23666'/%3e%3cpath d='M15.69%2c32.36a.48.48%2c0%2c0%2c0%2c.13.32%2c1.26%2c1.26%2c0%2c0%2c0%2c.31.25%2c2.87%2c2.87%2c0%2c0%2c0%2c.4.18l.36.14a6.34%2c6.34%2c0%2c0%2c1%2c.72.32%2c2.38%2c2.38%2c0%2c0%2c1%2c.48.35%2c1.44%2c1.44%2c0%2c0%2c1%2c.29.42%2c1.55%2c1.55%2c0%2c0%2c1%2c.08.55%2c1.71%2c1.71%2c0%2c0%2c1-.57%2c1.3%2c2.49%2c2.49%2c0%2c0%2c1-1.66.52%2c2.37%2c2.37%2c0%2c0%2c1-.76-.08%2c4.05%2c4.05%2c0%2c0%2c1-.63-.23%2c1.38%2c1.38%2c0%2c0%2c1-.38-.24.94.94%2c0%2c0%2c1-.2-.27.45.45%2c0%2c0%2c1-.06-.27.45.45%2c0%2c0%2c1%2c.38-.42.54.54%2c0%2c0%2c1%2c.33.07l.29.18a2.4%2c2.4%2c0%2c0%2c0%2c.32.17%2c2.06%2c2.06%2c0%2c0%2c0%2c.35.12%2c1.32%2c1.32%2c0%2c0%2c0%2c.41%2c0%2c1%2c1%2c0%2c0%2c0%2c.35-.06.88.88%2c0%2c0%2c0%2c.32-.16.92.92%2c0%2c0%2c0%2c.22-.26.87.87%2c0%2c0%2c0%2c.08-.37.65.65%2c0%2c0%2c0-.1-.34%2c1.48%2c1.48%2c0%2c0%2c0-.24-.26%2c1.92%2c1.92%2c0%2c0%2c0-.31-.18%2c1.67%2c1.67%2c0%2c0%2c0-.31-.11c-.25-.09-.49-.17-.71-.27a2.53%2c2.53%2c0%2c0%2c1-.58-.34%2c1.57%2c1.57%2c0%2c0%2c1-.39-.46%2c1.29%2c1.29%2c0%2c0%2c1-.14-.64%2c1.41%2c1.41%2c0%2c0%2c1%2c.17-.69%2c1.57%2c1.57%2c0%2c0%2c1%2c.47-.49%2c2.07%2c2.07%2c0%2c0%2c1%2c.66-.29%2c2.41%2c2.41%2c0%2c0%2c1%2c.75-.09%2c2.64%2c2.64%2c0%2c0%2c1%2c1.4.4.9.9%2c0%2c0%2c1%2c.32.37.37.37%2c0%2c0%2c1%2c0%2c.38.46.46%2c0%2c0%2c1-.16.15.68.68%2c0%2c0%2c1-.2.07.45.45%2c0%2c0%2c1-.2%2c0%2c.43.43%2c0%2c0%2c1-.17-.06l-.2-.13L17%2c31.83l-.29-.1a1.53%2c1.53%2c0%2c0%2c0-.3%2c0%2c.75.75%2c0%2c0%2c0-.31.06.76.76%2c0%2c0%2c0-.23.15.69.69%2c0%2c0%2c0-.15.21A.53.53%2c0%2c0%2c0%2c15.69%2c32.36Z' style='fill:%23666'/%3e%3cpath d='M21.77%2c30.74A3.09%2c3.09%2c0%2c0%2c1%2c23%2c31a2.44%2c2.44%2c0%2c0%2c1%2c.9.63%2c2.68%2c2.68%2c0%2c0%2c1%2c.53%2c1%2c4.22%2c4.22%2c0%2c0%2c1%2c0%2c2.37%2c2.64%2c2.64%2c0%2c0%2c1-.53%2c1%2c2.44%2c2.44%2c0%2c0%2c1-.9.63%2c3.1%2c3.1%2c0%2c0%2c1-1.27.23%2c3.21%2c3.21%2c0%2c0%2c1-1.25-.22%2c2.54%2c2.54%2c0%2c0%2c1-.9-.62%2c2.84%2c2.84%2c0%2c0%2c1-.55-1%2c3.87%2c3.87%2c0%2c0%2c1-.18-1.2%2c4.05%2c4.05%2c0%2c0%2c1%2c.17-1.18%2c2.6%2c2.6%2c0%2c0%2c1%2c.51-1%2c2.32%2c2.32%2c0%2c0%2c1%2c.89-.63A3.23%2c3.23%2c0%2c0%2c1%2c21.77%2c30.74Zm0%2c5.08a1.87%2c1.87%2c0%2c0%2c0%2c.8-.16%2c1.3%2c1.3%2c0%2c0%2c0%2c.52-.43%2c1.75%2c1.75%2c0%2c0%2c0%2c.29-.65%2c4.12%2c4.12%2c0%2c0%2c0%2c.08-.81%2c3.62%2c3.62%2c0%2c0%2c0-.09-.82%2c2%2c2%2c0%2c0%2c0-.29-.66%2c1.36%2c1.36%2c0%2c0%2c0-.53-.45%2c1.67%2c1.67%2c0%2c0%2c0-.78-.17%2c1.71%2c1.71%2c0%2c0%2c0-.79.17%2c1.34%2c1.34%2c0%2c0%2c0-.52.45%2c1.8%2c1.8%2c0%2c0%2c0-.29.66%2c3.38%2c3.38%2c0%2c0%2c0-.09.8%2c3.19%2c3.19%2c0%2c0%2c0%2c.08.75%2c1.78%2c1.78%2c0%2c0%2c0%2c.28.66%2c1.5%2c1.5%2c0%2c0%2c0%2c.52.48A1.67%2c1.67%2c0%2c0%2c0%2c21.77%2c35.82Zm.47-.65a.26.26%2c0%2c0%2c1-.11-.25.64.64%2c0%2c0%2c1%2c.25-.38.92.92%2c0%2c0%2c1%2c.3-.2.35.35%2c0%2c0%2c1%2c.24%2c0%2c.32.32%2c0%2c0%2c1%2c.17.1l1.74%2c1.46a.39.39%2c0%2c0%2c1%2c.09.17.5.5%2c0%2c0%2c1%2c0%2c.24.59.59%2c0%2c0%2c1-.18.25.84.84%2c0%2c0%2c1-.28.18.47.47%2c0%2c0%2c1-.26%2c0%2c.41.41%2c0%2c0%2c1-.19-.08Z' style='fill:%23666'/%3e%3cpath d='M29.59%2c35.65a.47.47%2c0%2c0%2c1%2c.33.11.41.41%2c0%2c0%2c1%2c.15.36.39.39%2c0%2c0%2c1-.16.36.5.5%2c0%2c0%2c1-.32.11H26.4a.66.66%2c0%2c0%2c1-.47-.17.57.57%2c0%2c0%2c1-.17-.42V31.24a.34.34%2c0%2c0%2c1%2c.17-.3.71.71%2c0%2c0%2c1%2c.42-.11.73.73%2c0%2c0%2c1%2c.43.11.33.33%2c0%2c0%2c1%2c.16.3v4.41Z' style='fill:%23666'/%3e%3c/svg%3e";

var img = "data:image/svg+xml,%3csvg id='%e5%9b%be%e5%b1%82_1' data-name='%e5%9b%be%e5%b1%82 1' xmlns='http://www.w3.org/2000/svg' viewBox='0 0 40 40'%3e%3cdefs%3e%3cstyle%3e.cls-1%7bfill:%231890ff%3b%7d.cls-2%7bfill:%2300c1c1%3b%7d%3c/style%3e%3c/defs%3e%3ctitle%3e%e5%86%85%e9%a1%b5icon0214-40px%3c/title%3e%3cpath class='cls-1' d='M18%2c2H3.94A1.89%2c1.89%2c0%2c0%2c0%2c2%2c3.94V18a1.89%2c1.89%2c0%2c0%2c0%2c1.94%2c1.94H18A1.89%2c1.89%2c0%2c0%2c0%2c19.94%2c18V3.94A1.89%2c1.89%2c0%2c0%2c0%2c18%2c2ZM4.46%2c17.48l.06-13h13v13Z'/%3e%3cpath class='cls-1' d='M36.06%2c20.06H22A1.89%2c1.89%2c0%2c0%2c0%2c20.06%2c22V36.06A1.89%2c1.89%2c0%2c0%2c0%2c22%2c38H36.06A1.89%2c1.89%2c0%2c0%2c0%2c38%2c36.06V22A1.89%2c1.89%2c0%2c0%2c0%2c36.06%2c20.06ZM22.52%2c35.54l.06-13h13v13Z'/%3e%3cpath class='cls-2' d='M33.51%2c4.74H24.09a2%2c2%2c0%2c0%2c0-2%2c2v9.42a2%2c2%2c0%2c0%2c0%2c2%2c2h9.42a2%2c2%2c0%2c0%2c0%2c2-2V6.75A2%2c2%2c0%2c0%2c0%2c33.51%2c4.74Zm-9%2c11V7.21l8.5-.06.06%2c8.56Z'/%3e%3crect class='cls-2' x='26.06' y='26.06' width='5.88' height='5.88' rx='1.23'/%3e%3cpath class='cls-2' d='M15.91%2c21.94H6.49a2%2c2%2c0%2c0%2c0-2%2c2v9.41a2%2c2%2c0%2c0%2c0%2c2%2c2h9.42a2%2c2%2c0%2c0%2c0%2c2-2V24A2%2c2%2c0%2c0%2c0%2c15.91%2c21.94ZM7%2c33V24.4l8.5%2c0%2c.06%2c8.56Z'/%3e%3cpath class='cls-2' d='M12.65%2c8H9.23A1.26%2c1.26%2c0%2c0%2c0%2c8%2c9.29v3.42a1.16%2c1.16%2c0%2c0%2c0%2c1.13%2c1.17h3.52a1.26%2c1.26%2c0%2c0%2c0%2c1.23-1.23V9.23A1.25%2c1.25%2c0%2c0%2c0%2c12.65%2c8Z'/%3e%3c/svg%3e";

var Task = {
  Hive: img$3,
  Hive2: img$2,
  Mysql: img$1,
  Default: img
};

const noop$1 = () => null; // 任务图标base64，页面各模块公用
// const reqIcon = require.context('../com/icons/icon-task')
// const icon = {}
// reqIcon.keys().map(item => {
//   icon[item.split('.')[1].slice(1)] = reqIcon(item)
//   return item
// })
// // perl类型支持大小写敏感，而操作系统文件类型大小写不敏感，所以需要复制一份
// if (icon.Perl) {
//   icon.perl = icon.Perl
// }
// export const iconBase64 = icon

/**
 * 获取锚点和edge的映射
 * @param {EdgeTypes[]} edges
 */


const getEpEdgeMap = edges => {
  const map = {};

  for (let edge of edges) {
    const {
      srcNodeItemId,
      tgtNodeItemId
    } = edge;
    map[`${srcNodeItemId}-right`] = true;
    map[`${tgtNodeItemId}-left`] = true;
  }

  return map;
};
/**
 * 从用户传入的数据转换为butterfly-react支持的数据格式
 * @param {NodeTypes} nodes 用户节点
 * @param {String} string activeItemId
 * @return {INode} ref: https://github.com/alibaba/butterfly/blob/master/docs/zh-CN/react.md#%E5%B1%9E%E6%80%A7
 */


const toNodes = _ref => {
  let {
    nodes,
    activeNodeItemIds = [],
    onItemActive = noop$1,
    onNodeClick = noop$1,
    onItemClick = noop$1,
    onNodeDoubleClick = noop$1,
    onNodeItemDoubleClick = noop$1,
    edges = [],
    onEndpointClick = noop$1,
    isLoop = false,
    endpointClassName = '',
    loopNum = 0
  } = _ref;

  if (!nodes || nodes.length === 0) {
    return [];
  }

  const btfNodes = [];
  const epEdgeMap = getEpEdgeMap(edges);
  PropTypes__default["default"].checkPropTypes(NodeTypes, nodes[0]);
  nodes.forEach(node => {
    const {
      nodeItems,
      id: _id
    } = node;
    let id = _id;

    if (!id) {
      id = nodeItems[0].info.id;
    } // if (!nodeItems || nodeItems.length === 0) {
    //   return;
    // }


    btfNodes.push({
      id: id,

      render() {
        return /*#__PURE__*/React__default["default"].createElement(NodeComponent, {
          node: node,
          isUnRelItemHidden: node.isUnRelItemHidden,
          onMouseMethod: this.onMouseMethod,
          onDoubleClick: this.onNodeDoubleClick,
          activeNodeItemIds: activeNodeItemIds,
          onItemActive: onItemActive,
          isHidden: node.isHide,
          onNodeClick: onNodeClick,
          onNodeDoubleClick: onNodeDoubleClick,
          onNodeItemDoubleClick: onNodeItemDoubleClick,
          endpointEdge: epEdgeMap,
          onEndpointClick: onEndpointClick,
          isLoop: isLoop,
          loopNum: loopNum,
          endpointClassName: endpointClassName,
          onItemClick: onItemClick
        });
      }

    });
  });
  return btfNodes;
};
/**
 * 得到item和node的映射
 * @param {NodeTypes} nodes 用户节点
 */

const getItemIdMap = nodes => {
  if (!nodes) {
    return {};
  }

  const map = {};

  for (let node of nodes) {
    const {
      id,
      nodeItems
    } = node; // if (!nodeItems || nodeItems.length === 0) {
    //   continue;
    // }

    for (let item of nodeItems) {
      map[item.id] = id;
    } // if(nodeItems.length === 0) {


    map[id] = id; // }
  }

  return map;
};

const getNodeIdMap = nodes => {
  const nodeIdMap = {};

  for (let node of nodes) {
    nodeIdMap[node.id] = node;
  }

  return nodeIdMap;
};
/**
 * 将用户传入的节点属性转换为ButterflyReact可识别的类型
 * @param {EdgeTypes} edges 用户边
 * @param {NodeTypes} nodes 用户节点
 * @param {String} id 当前active的item的id
 * @return {IEdge} ref: https://github.com/alibaba/butterfly/blob/master/docs/zh-CN/react.md#%E5%B1%9E%E6%80%A7
 */


const toEdges = _ref2 => {
  let {
    edges,
    nodes,
    activeEdgeIds = []
  } = _ref2;

  if (!edges || edges.length === 0) {
    return [];
  }

  const btfEdges = [];
  const itemNodeMap = getItemIdMap(nodes);
  const nodeIdMap = getNodeIdMap(nodes);
  PropTypes__default["default"].checkPropTypes(EdgeTypes, edges[0]);
  edges.forEach(edge => {
    let {
      srcNodeItemId,
      tgtNodeItemId,
      isHide
    } = edge;
    const sourceNodeId = itemNodeMap[srcNodeItemId];
    const targetNodeId = itemNodeMap[tgtNodeItemId];

    if (!edge.id) {
      edge.id = `${srcNodeItemId}@@${tgtNodeItemId}`;
    }

    const sourceNode = nodeIdMap[sourceNodeId];
    const targetNode = nodeIdMap[targetNodeId];

    if (!targetNodeId || !sourceNodeId) {
      // console.warn(`边(${srcNodeItemId}->${targetNodeId})找不到对应节点，无法渲染！`);
      return;
    } // 隐藏的节点将线直接连到节点上


    if (sourceNode.isHide && targetNode.type === 2) {
      srcNodeItemId = sourceNodeId;
    }

    if (targetNode.isHide && targetNode.type === 2) {
      tgtNodeItemId = targetNodeId;
    }

    let isActive = activeEdgeIds.includes(edge.id) || edge.isActive;
    const edgeItem = {
      id: srcNodeItemId + tgtNodeItemId,
      sourceNode: sourceNodeId,
      targetNode: targetNodeId,
      source: srcNodeItemId + '-right',
      target: tgtNodeItemId + '-left',
      isActive,
      type: 'endpoint',
      // calcPath,
      shapeType: 'AdvancedBezier',
      className: classnames__default["default"]({
        'lineage-edge-un': !!edge.mappingLink,
        'lineage-edge-hover-active': isActive,
        'lineage-edge-content': !!isActive,
        // 'lineage-edge-hide': isHide,
        'lineage-edge-loop-active': edge.isLoopActive
      }),

      labelRender() {
        // const imgUrl = !!edge?.task?.specificType ? (!!Task[edge?.task?.specificType] ? Task[edge?.task?.specificType] : Task.Default) : ''
        const imgUrl = !!edge?.task ? !!edge?.task?.taskIcon ? edge?.task?.taskIcon : Task.Default : null; // taskType: 1-离线，2-运维，3-实时
        // platform: 1-离线，2-实时

        const platFormMap = {
          1: `/operation/index.html#/offline-task?taskId=${edge?.task?.taskId}&workspaceId=${edge?.task?.workspaceId}`,
          2: `/scheduler/index.html#/stream?taskId=${edge?.task?.taskId}&workspaceId=${edge?.task?.workspaceId}`
        };
        const urlMap = {
          1: '/batch/index.html#/dipper/task',
          2: platFormMap[edge?.task?.platform],
          3: '/stream/index.html#/dipper/task'
        };
        const Href = urlMap[edge?.task?.taskType]; // const Href = edge?.task?.taskType == 1 ? '/batch/index.html#/dipper/task' : `/operation/index.html#/offline-task?taskId=${edge?.task?.taskId}`

        const isItemEdge = !!edge.u || !!edge.v;

        if ((isActive || !isItemEdge) && imgUrl) {
          return /*#__PURE__*/React__default["default"].createElement(antd.Tooltip, {
            title: edge?.task?.taskName
          }, /*#__PURE__*/React__default["default"].createElement("span", {
            onClick: () => {
              localStorage.setItem(`${window.location.origin}_projectId`, edge?.task?.taskProjectId);
              window.open(Href, '_blank');
            },
            className: `task-icon ${isActive ? 'active' : ''} ${edge.isLoopActive ? 'loop-active' : ''}`
          }, /*#__PURE__*/React__default["default"].createElement("img", {
            src: imgUrl,
            width: 14,
            height: 14
          })));
        }
      },

      labelOffset: 20
    };
    btfEdges.push(edgeItem);
  });
  return btfEdges;
};
/**
 * 字段血缘算出所有被激活的边和点
 * @param {NodeTypes[]} nodes
 * @param {NodeTypes[]} edges
 * @param {String} activeItemId
 */

const getActiveThings = _ref3 => {
  let {
    edges,
    nodes,
    activeItemId
  } = _ref3;
  const activeNodeItemIds = [activeItemId];
  const activeEdgeIds = [];

  if (!activeItemId) {
    return {
      activeNodeItemIds: [],
      activeEdgeIds
    };
  }

  const findBefore = activeId => {
    for (let edge of edges) {
      if (edge.tgtNodeItemId === activeId) {
        const curNode = nodes.filter(n => n.id === edge.relU)[0];

        if (curNode.isHide) {
          if (activeNodeItemIds.findIndex(t => t === edge.relU) === -1 && activeNodeItemIds.findIndex(t => t === edge.srcNodeItemId) === -1) {
            activeNodeItemIds.push(edge.relU);
            activeNodeItemIds.push(edge.srcNodeItemId);
            activeEdgeIds.push(edge.id);
            findBefore(edge.relU);
            findBefore(edge.srcNodeItemId);
          }
        } else {
          if (activeNodeItemIds.findIndex(t => t === edge.srcNodeItemId) === -1) {
            activeNodeItemIds.push(edge.srcNodeItemId);
            activeEdgeIds.push(edge.id);
            findBefore(edge.srcNodeItemId);
          }
        }
      }
    }
  };

  const findAfter = activeId => {
    for (let edge of edges) {
      if (edge.srcNodeItemId === activeId) {
        const curNode = nodes.filter(n => n.id === edge.relV)[0];

        if (curNode.isHide) {
          // 折叠
          if (activeNodeItemIds.findIndex(t => t === edge.relV) === -1 && activeNodeItemIds.findIndex(t => t === edge.tgtNodeItemId) === -1) {
            activeNodeItemIds.push(edge.relV);
            activeNodeItemIds.push(edge.tgtNodeItemId);
            activeEdgeIds.push(edge.id);
            findAfter(edge.relV);
            findAfter(edge.tgtNodeItemId);
          }
        } else {
          // 展开
          if (activeNodeItemIds.findIndex(t => t === edge.tgtNodeItemId) === -1) {
            activeNodeItemIds.push(edge.tgtNodeItemId);
            activeEdgeIds.push(edge.id);
            findAfter(edge.tgtNodeItemId);
          }
        }
      }
    }
  };

  findBefore(activeItemId);
  findAfter(activeItemId);
  return {
    activeNodeItemIds,
    activeEdgeIds
  };
};
/**
 * 将用户传入的节点属性转换为ButterflyReact可识别的类型
 * @param {EdgeTypes} edges 用户边
 * @param {NodeTypes} nodes 用户节点
 * @param {String} id 当前active的item的id
 * @return {IEdge} ref: https://github.com/alibaba/butterfly/blob/master/docs/zh-CN/react.md#%E5%B1%9E%E6%80%A7
 */

const toEdgesItem = _ref4 => {
  let {
    edges,
    nodes,
    activeEdgeIds = []
  } = _ref4;

  if (!edges || edges.length === 0) {
    return [];
  }

  const btfEdges = [];
  const itemNodeMap = getItemIdMap(nodes);
  const nodeIdMap = getNodeIdMap(nodes);
  PropTypes__default["default"].checkPropTypes(EdgeTypes, edges[0]);
  edges.forEach(edge => {
    let {
      srcNodeItemId,
      tgtNodeItemId,
      isHide
    } = edge;
    const sourceNodeId = itemNodeMap[srcNodeItemId];
    const targetNodeId = itemNodeMap[tgtNodeItemId];

    if (!edge.id) {
      edge.id = `${srcNodeItemId}@@${tgtNodeItemId}`;
    }

    const sourceNode = nodeIdMap[sourceNodeId];
    const targetNode = nodeIdMap[targetNodeId];

    if (!targetNodeId || !sourceNodeId) {
      // console.warn(`边(${srcNodeItemId}->${targetNodeId})找不到对应节点，无法渲染！`);
      return;
    } // 隐藏的节点将线直接连到节点上


    if (sourceNode.isHide) {
      srcNodeItemId = sourceNodeId;
    }

    if (targetNode.isHide) {
      tgtNodeItemId = targetNodeId;
    }

    let isActive = activeEdgeIds.includes(edge.id) || edge.isActive;
    const edgeItem = {
      id: srcNodeItemId + tgtNodeItemId,
      sourceNode: sourceNodeId,
      targetNode: targetNodeId,
      source: srcNodeItemId + '-right',
      target: tgtNodeItemId + '-left',
      isActive,
      type: 'endpoint',
      // calcPath,
      shapeType: 'AdvancedBezier',
      className: classnames__default["default"]({
        'lineage-edge-un': !!edge.mappingLink,
        'lineage-edge-hover-active': isActive,
        'lineage-edge-content': !!isActive // 'lineage-edge-hide': isHide,

      }),
      // labelRender: () => null
      labelRender: () => {
        // const imgUrl = !!edge?.task?.specificType ? (!!Task[edge?.task?.specificType] ? Task[edge?.task?.specificType] : Task.Default) : ''
        const imgUrl = !!edge?.task ? !!edge?.task?.taskIcon ? edge?.task?.taskIcon : Task.Default : null; // taskType: 1-离线，2-运维，3-实时
        // platform: 1-离线，2-实时

        const platFormMap = {
          1: `/operation/index.html#/offline-task?taskId=${edge?.task?.taskId}&workspaceId=${edge?.task?.workspaceId}`,
          2: `/scheduler/index.html#/stream?taskId=${edge?.task?.taskId}&workspaceId=${edge?.task?.workspaceId}`
        };
        const urlMap = {
          1: '/batch/index.html#/dipper/task',
          2: platFormMap[edge?.task?.platform],
          3: '/stream/index.html#/dipper/task'
        };
        const Href = urlMap[edge?.task?.taskType]; // const Href = edge?.task?.taskType == 1 ? '/batch/index.html#/dipper/task' : `/operation/index.html#/offline-task?taskId=${edge?.task?.taskId}`

        const isItemEdge = !!edge.u || !!edge.v;

        if ((isActive || !isItemEdge) && imgUrl) {
          return /*#__PURE__*/React__default["default"].createElement(antd.Tooltip, {
            title: edge?.task?.taskName
          }, /*#__PURE__*/React__default["default"].createElement("a", {
            href: Href,
            target: "_blank",
            className: `task-icon ${isActive ? 'active' : ''} ${edge.isLoopActive ? 'loop-active' : ''}`
          }, /*#__PURE__*/React__default["default"].createElement("img", {
            src: imgUrl,
            width: 14,
            height: 14
          })));
        }
      },
      labelOffset: 20
    };
    btfEdges.push(edgeItem);
  });
  return btfEdges;
};
/**
 * 从用户传入的数据转换为butterfly-react支持的数据格式
 * @param {NodeTypes} nodes 用户节点
 * @param {String} string activeItemId
 * @return {INode} ref: https://github.com/alibaba/butterfly/blob/master/docs/zh-CN/react.md#%E5%B1%9E%E6%80%A7
 */

const toNodesItem = _ref5 => {
  let {
    nodes,
    activeNodeItemIds = [],
    onItemActive = noop$1,
    onNodeClick = noop$1,
    onItemClick = noop$1,
    onNodeDoubleClick = noop$1,
    onNodeItemDoubleClick = noop$1,
    edges = [],
    onEndpointClick = noop$1
  } = _ref5;

  if (!nodes || nodes.length === 0) {
    return [];
  }

  const btfNodes = [];
  const epEdgeMap = getEpEdgeMap(edges);
  PropTypes__default["default"].checkPropTypes(NodeTypes, nodes[0]);
  nodes.forEach(node => {
    const {
      nodeItems,
      id: _id
    } = node;
    let id = _id;

    if (!id) {
      id = nodeItems[0].info.id;
    } // if (!nodeItems || nodeItems.length === 0) {
    //   return;
    // }


    btfNodes.push({
      id: id,

      render() {
        return /*#__PURE__*/React__default["default"].createElement(NodeComponent, {
          node: node,
          isUnRelItemHidden: node.isUnRelItemHidden,
          onMouseMethod: this.onMouseMethod,
          onDoubleClick: this.onNodeDoubleClick,
          activeNodeItemIds: activeNodeItemIds,
          onItemActive: onItemActive,
          isHidden: node.isHide,
          onNodeClick: onNodeClick,
          onItemClick: onItemClick,
          onNodeDoubleClick: onNodeDoubleClick,
          onNodeItemDoubleClick: onNodeItemDoubleClick,
          endpointEdge: epEdgeMap,
          onEndpointClick: onEndpointClick
        });
      }

    });
  });
  return btfNodes;
};
/**
 * 表血缘算出所有被激活的边和点
 * @param {NodeTypes[]} nodes
 * @param {NodeTypes[]} edges
 * @param {String} activeItemId
 */

const getItemActiveThings = _ref6 => {
  let {
    edges,
    nodes,
    activeItemId
  } = _ref6;
  const activeNodeItemIds = [activeItemId];
  const activeEdgeIds = [];
  const arry = edges.filter(t => t.relU === activeItemId || t.relV === activeItemId);
  arry.forEach(t => {
    // 下游
    if (t.relU === activeItemId) {
      activeNodeItemIds.push(t.srcNodeItemId);
    } // 上游


    if (t.relV === activeItemId) {
      activeNodeItemIds.push(t.tgtNodeItemId);
    }
  });

  if (!activeItemId) {
    return {
      activeNodeItemIds: [],
      activeEdgeIds
    };
  }

  const findBefore = activeId => {
    for (let edge of edges) {
      if (edge.tgtNodeItemId === activeId) {
        activeEdgeIds.push(edge.id);
        const curNode = nodes.filter(n => n.id === edge.relU)[0];

        if (curNode.isHide) {
          if (activeNodeItemIds.findIndex(t => t === edge.relU) === -1) {
            activeNodeItemIds.push(edge.relU);
            findBefore(edge.relU);
          }
        } else {
          if (activeNodeItemIds.findIndex(t => t === edge.srcNodeItemId) === -1) {
            activeNodeItemIds.push(edge.srcNodeItemId);
            findBefore(edge.srcNodeItemId);
          }
        }
      }

      if (edge.relV && edge.relV === activeId) {
        activeEdgeIds.push(edge.id); // 获取当前节点

        const curNode = nodes.filter(n => n.id === edge.relU)[0];

        if (curNode.isHide) {
          if (activeNodeItemIds.findIndex(t => t === edge.relU) === -1) {
            activeNodeItemIds.push(edge.relU);
            findBefore(edge.relU);
          }
        } else {
          if (activeNodeItemIds.findIndex(t => t === edge.srcNodeItemId) === -1) {
            activeNodeItemIds.push(edge.srcNodeItemId);
            findBefore(edge.srcNodeItemId);
          }
        }
      }
    }
  };

  const findAfter = activeId => {
    for (let edge of edges) {
      if (edge.srcNodeItemId === activeId) {
        activeEdgeIds.push(edge.id);
        const curNode = nodes.filter(n => n.id === edge.relU)[0];

        if (curNode.isHide) {
          if (activeNodeItemIds.findIndex(t => t === edge.relV) === -1) {
            activeNodeItemIds.push(edge.relV);
            findAfter(edge.relV);
          }
        } else {
          if (activeNodeItemIds.findIndex(t => t === edge.tgtNodeItemId) === -1) {
            activeNodeItemIds.push(edge.tgtNodeItemId);
            findAfter(edge.tgtNodeItemId);
          }
        }
      }

      if (edge.relU && edge.relU === activeId) {
        activeEdgeIds.push(edge.id); // 获取当前节点

        const curNode = nodes.filter(n => n.id === edge.relV)[0];

        if (curNode.isHide) {
          if (activeNodeItemIds.findIndex(t => t === edge.relV) === -1) {
            activeNodeItemIds.push(edge.relV);
            findAfter(edge.relV);
          }
        } else {
          if (activeNodeItemIds.findIndex(t => t === edge.tgtNodeItemId) === -1) {
            activeNodeItemIds.push(edge.tgtNodeItemId);
            findAfter(edge.tgtNodeItemId);
          }
        }
      }
    }
  };

  findBefore(activeItemId);
  findAfter(activeItemId);
  return {
    activeNodeItemIds,
    activeEdgeIds
  };
};

var css_248z = ".lineage_dag {\n  height: 100%;\n}\n.lineage_dag .lineage-edge-content {\n  stroke: #BFBFBF;\n}\n.lineage_dag .lineage-edge-content:hover {\n  stroke: #f79a02;\n  stroke-width: 1px;\n}\n.lineage_dag .lineage-edge-hover-active {\n  stroke: #f79a02;\n  stroke-width: 1px;\n}\n.lineage_dag .lineage-edge-loop-active {\n  stroke: red;\n  stroke-width: 1px;\n}\n.lineage_dag .lineage-edge-hide {\n  stroke: transparent;\n}\n.lineage_dag .lineage-edge-un {\n  stroke-dasharray: 4px;\n}\n.lineage_dag .task-icon {\n  cursor: pointer;\n  position: absolute;\n  display: none;\n  border: 1px solid #dbdbdb;\n  border-radius: 10px;\n  padding: 2px;\n  width: 20px;\n  height: 20px;\n  line-height: 10px;\n  background: #fff;\n  left: -9px;\n  top: -10px;\n  z-index: 999;\n}\n.lineage_dag .task-icon:hover {\n  border: 1px solid #2466ff;\n}\n.lineage_dag .task-icon:first-child {\n  display: inline-block;\n}\n.lineage_dag .task-icon.active {\n  border: 1px solid #ff6a00;\n}\n.lineage_dag .task-icon.loop-active {\n  border: 1px solid #F5222D;\n}\n";
styleInject(css_248z);

var defaultOptions = {
  theme: {
    edge: {// arrow: true,
      // arrowPosition: 0.1,
      // arrowOffset: 0.0,
      // isExpandWidth: true,
    }
  }
};
var constOption = {
  disLinkable: false,
  // 可删除连线
  linkable: false,
  // 可连线
  draggable: true,
  // 可拖动
  zoomable: true,
  // 可放大
  moveable: true,
  // 可平移
  ranker: 'tight-tree'
};

var noop = function noop() {
  return null;
};

var baseZIndex = 10;

var LineageDag = function LineageDag(props) {
  var _props$nodes = props.nodes,
      nodes = _props$nodes === void 0 ? [] : _props$nodes,
      _props$edges = props.edges,
      edges = _props$edges === void 0 ? [] : _props$edges,
      _props$onNodeDoubleCl = props.onNodeDoubleClick,
      onNodeDoubleClick = _props$onNodeDoubleCl === void 0 ? noop : _props$onNodeDoubleCl,
      _props$onNodeItemDoub = props.onNodeItemDoubleClick,
      onNodeItemDoubleClick = _props$onNodeItemDoub === void 0 ? noop : _props$onNodeItemDoub,
      _props$onLoaded = props.onLoaded,
      onLoaded = _props$onLoaded === void 0 ? noop : _props$onLoaded,
      _props$layout = props.layout,
      layout = _props$layout === void 0 ? {} : _props$layout,
      _props$onEndpointClic = props.onEndpointClick,
      onEndpointClick = _props$onEndpointClic === void 0 ? noop : _props$onEndpointClic,
      _props$onItemClick = props.onItemClick,
      onItemClick = _props$onItemClick === void 0 ? noop : _props$onItemClick,
      _props$isLoop = props.isLoop,
      isLoop = _props$isLoop === void 0 ? false : _props$isLoop,
      _props$loopNum = props.loopNum,
      loopNum = _props$loopNum === void 0 ? 0 : _props$loopNum;
  var canvasRef = React.useRef(null);

  var _useState = React.useState([]),
      _useState2 = _slicedToArray(_useState, 2),
      btfEdges = _useState2[0],
      setBtfEdges = _useState2[1];

  var _useState3 = React.useState([]),
      _useState4 = _slicedToArray(_useState3, 2),
      btfNodes = _useState4[0],
      setBtfNodes = _useState4[1];

  var _useState5 = React.useState(false),
      _useState6 = _slicedToArray(_useState5, 2),
      relayout = _useState6[0],
      setRelayout = _useState6[1];

  var options = ___default["default"].merge({}, defaultOptions, constOption, props.options, {
    // layout: 'ForceLayout'
    layout: drageLayout({
      ranksep: layout.ranksep,
      nodesep: layout.nodesep
    })
  }); // 画布初始化


  var onCvsLoaded = function onCvsLoaded(canvas) {
    console.log('画布初始化');
    canvasRef.current = canvas;
    onLoaded(canvas);

    canvas.focusNode = function (nodeId, options) {
      var node = canvas.getNode(nodeId);
      focusNode(node, options, canvas);
    };

    canvas.setZoomable(true, true);
    setTimeout(function () {
      canvas.relayout();
      canvas.focusCenterWithAnimate(); // 设置缩略图

      canvas.setMinimap(true, {
        nodeColor: '#2466ff',
        groupColor: '#2466ff',
        containerStyle: {
          height: '100px',
          background: '#f8f9ff',
          left: '0px',
          bottom: '0px',
          border: '1px solid rgb(221 221 221 / 63%)',
          boxShadow: '0px 0px 7px #726d6d21'
        },
        viewportStyle: {
          background: 'rgb(128 204 247 / 21%)' // border: '2px solid rgb(43, 102, 255)',

        }
      });
    }, 100);
  };
  /**
   * 响应边和item的高亮事件
   * @param {String} itemId item的id
   */


  var onItemActive = ___default["default"].debounce(function (itemId) {
    var canvas = canvasRef.current;

    var _getActiveThings = getActiveThings({
      edges: edges,
      nodes: nodes,
      activeItemId: itemId
    }),
        activeEdgeIds = _getActiveThings.activeEdgeIds,
        activeNodeItemIds = _getActiveThings.activeNodeItemIds;

    setBtfNodes(toNodesItem(_objectSpread2(_objectSpread2({}, nodeOptions), {}, {
      activeNodeItemIds: activeNodeItemIds,
      onEndpointClick: onEndpointClick
    })));
    var btfEdges = toEdgesItem(_objectSpread2(_objectSpread2({}, edgeOptions), {}, {
      activeEdgeIds: activeEdgeIds
    }));
    var activeEdges = [];
    btfEdges.forEach(function (edge) {
      var edgeId = edge.id;

      if (edge.isActive) {
        var e = canvas.getEdge(edgeId);

        if (e) {
          activeEdges.push(e);
        }
      }
    });
    canvas.setEdgeZIndex(activeEdges, baseZIndex);
    baseZIndex++;
    setBtfEdges(btfEdges);
  }, 100);
  /**
  * 响应边和item的高亮事件
  * @param {String} itemId item的id
  */


  var onNodeClick = ___default["default"].debounce(function (itemId) {
    var canvas = canvasRef.current;

    var _getItemActiveThings = getItemActiveThings({
      edges: edges,
      nodes: nodes,
      activeItemId: itemId
    }),
        activeEdgeIds = _getItemActiveThings.activeEdgeIds,
        activeNodeItemIds = _getItemActiveThings.activeNodeItemIds;

    setBtfNodes(toNodes(_objectSpread2(_objectSpread2({}, nodeOptions), {}, {
      activeNodeItemIds: activeNodeItemIds,
      onEndpointClick: onEndpointClick
    })));
    var btfEdges = toEdges(_objectSpread2(_objectSpread2({}, edgeOptions), {}, {
      activeEdgeIds: activeEdgeIds
    }));
    var activeEdges = [];
    btfEdges.forEach(function (edge) {
      var edgeId = edge.id;

      if (edge.isActive) {
        var e = canvas.getEdge(edgeId);

        if (e) {
          activeEdges.push(e);
        }
      }
    });
    canvas.setEdgeZIndex(activeEdges, baseZIndex);
    baseZIndex++;
    setBtfEdges(btfEdges);
  }, 100);
  /**
   * 节点展开收起逻辑
   *   收起某一个节点时：
   *    1. 只收起当前节点
   *   展开某一个节点时：
   *    1. 一个节点展开时，其他两侧的节点也需要展开
   *    2. 一个节点展开时，我们只计算他的item的边，收起只计算他的node的边
   */


  var nodeOptions = {
    nodes: nodes,
    edges: edges,
    onItemActive: onItemActive,
    onNodeClick: onNodeClick,
    onItemClick: onItemClick,
    onNodeDoubleClick: onNodeDoubleClick,
    onNodeItemDoubleClick: onNodeItemDoubleClick,
    onEndpointClick: onEndpointClick,
    isLoop: isLoop,
    loopNum: loopNum
  };
  var edgeOptions = {
    edges: edges,
    nodes: nodes
  };
  React.useEffect(function () {
    if (nodes.length === 0) {
      return;
    }

    setBtfNodes(toNodes(nodeOptions));
    setBtfEdges(toEdges(edgeOptions));
  }, [nodes, edges, nodes.length, edges.length]);
  React.useEffect(function () {
    if (!canvasRef.current) {
      return;
    }

    setRelayout(true);
  }, [nodes, edges.length]);

  if (nodes.length === 0 || btfNodes.length === 0) {
    return null;
  }

  return /*#__PURE__*/React__default["default"].createElement("div", {
    className: "lineage_dag"
  }, /*#__PURE__*/React__default["default"].createElement(ReactButterfly__default["default"], {
    nodes: btfNodes,
    edges: btfEdges,
    options: options,
    onLoaded: onCvsLoaded,
    onEachFrame: function onEachFrame() {
      if (relayout) {
        canvasRef.current.relayout();
        setRelayout(false);
      }

      props.onEachFrame();
    }
  }));
};

LineageDag.propTypes = {
  options: PropTypes__default["default"].object,
  // 小蝴蝶画布属性，参考：https://github.com/alibaba/butterfly/blob/master/docs/zh-CN/canvas.md#%E5%B1%9E%E6%80%A7
  layout: {
    ranksep: PropTypes__default["default"].number,
    radius: PropTypes__default["default"].number
  },
  nodes: PropTypes__default["default"].arrayOf(NodeTypes),
  // 节点
  edges: PropTypes__default["default"].arrayOf(EdgeTypes),
  // 边类型
  onNodeDoubleClick: PropTypes__default["default"].func,
  // 双击某个节点
  onNodeItemDoubleClick: PropTypes__default["default"].func,
  // 双击某个字段
  onLoaded: PropTypes__default["default"].func,
  // 小蝴蝶加载完时调用
  onEachFrame: PropTypes__default["default"].func,
  // 每一帧画完之后
  onEndpointClick: PropTypes__default["default"].func,
  // 锚点单击事件
  isLoop: PropTypes__default["default"].boolean,
  loopNum: PropTypes__default["default"].number
};

var adapter = function adapter(data) {
  return _objectSpread2(_objectSpread2({}, data), {}, {
    nodes: ___default["default"].get(data, 'nodes', []).map(function (table) {
      return _objectSpread2(_objectSpread2({}, table), {}, {
        title: table.name,
        isHide: table.isFold,
        isUnRelItemHidden: table.isUnRelColHide,
        nodeItems: table.columns.map(function (column) {
          return _objectSpread2(_objectSpread2({}, column), {}, {
            id: [table.id, column.id || ''].join('@')
          });
        })
      });
    }),
    edges: ___default["default"].get(data, 'links', []).map(function (relation) {
      var relU = relation.relU,
          _relation$u = relation.u,
          u = _relation$u === void 0 ? '' : _relation$u,
          relV = relation.relV,
          _relation$v = relation.v,
          v = _relation$v === void 0 ? '' : _relation$v;
      return _objectSpread2(_objectSpread2({}, relation), {}, {
        id: relation.id || [relU, u || '', relV, v || ''].join('@'),
        srcNodeItemId: u ? [relU, u].join('@') : relU,
        tgtNodeItemId: v ? [relV, v].join('@') : relV,
        label: '1111'
      });
    })
  });
}; // 与表、列相关的概念放在这


var Table = function Table(props) {
  var p = adapter(props);
  return /*#__PURE__*/React__default["default"].createElement(LineageDag, p);
};

Table.propTypes = {
  options: PropTypes__default["default"].object,
  layout: {
    ranksep: PropTypes__default["default"].number,
    // 每一层级之间的间距
    nodesep: PropTypes__default["default"].number // 每一层节点之间上下的距离

  },
  nodes: PropTypes__default["default"].arrayOf(PropTypes__default["default"].shape({
    id: PropTypes__default["default"].string,
    // 每一个表的 ID
    icon: PropTypes__default["default"].any,
    // 表头的 icon
    name: PropTypes__default["default"].string,
    // 表名
    isFold: PropTypes__default["default"].bool,
    // 是否收起所有列
    isUnRelColHidden: PropTypes__default["default"].bool,
    // 是否收起所有没有关系的列
    columns: PropTypes__default["default"].arrayOf(PropTypes__default["default"].shape({
      name: PropTypes__default["default"].string,
      // 列名（英文名，唯一标识）
      icon: PropTypes__default["default"].string,
      // 列的icon
      title: PropTypes__default["default"].string,
      // 列的中文名
      onClick: PropTypes__default["default"].func // 点击事件

    })),
    operators: PropTypes__default["default"].arrayOf(PropTypes__default["default"].shape({
      component: PropTypes__default["default"].element // 渲染组件

    }))
  })),
  links: PropTypes__default["default"].arrayOf(PropTypes__default["default"].shape({
    id: PropTypes__default["default"].string,
    // 关系ID，可以没有
    relU: PropTypes__default["default"].string,
    // 源头表的ID
    relV: PropTypes__default["default"].string,
    // 目标表的ID
    u: PropTypes__default["default"].string,
    // 源头表列名
    v: PropTypes__default["default"].string,
    // 目标表的列明
    label: PropTypes__default["default"].string || PropTypes__default["default"].func
  })),
  onTableDoubleClick: PropTypes__default["default"].func,
  // 当某一个表节点被双击时
  onLoaded: PropTypes__default["default"].func,
  // 当画布加载时，返回发布实例
  onEachFrame: PropTypes__default["default"].func,
  // 每一帧渲染之后的回调函数
  onItemClick: PropTypes__default["default"].func // 当表下面的字段倍点击时 
  // isLoop: PropTypes.boolean,

};

var LineageTable = Table;

exports.LineageTable = LineageTable;
//# sourceMappingURL=index.js.map
