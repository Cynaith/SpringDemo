### URL映射到方法
---
#### @RequestMapping
RequestMapping有多个属性来进一步匹配HTTP请求到Controller方法
* **value:** 请求的URL路径,支持URL模版、正则表达式。
* **method:** HTTP请求方法,有GET、POST、PUT等。
* **consumes:** 允许的媒体类型(Media Types),如`consumes = "application/json"`,对应于请求的HTTP的Content-Type。 
* **produces:** 相应的媒体类型,如`produces = "application/json"`,对应于HTTP的Accept字段。
* **params:** 请求的参数,如`params = "action = update"。
* **headers:** 请求的HTTP头的值,如headers = "myHeader = myValue"。
