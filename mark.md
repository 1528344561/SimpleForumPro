### 记录一些内容.

1. controller 一般就做请求数据的校验和响应数据的处理就行了，当然也可以做一些权限校验等等非核心的业务逻辑处理，核心的业务逻辑处理最好写到service中.
> 比如校验账号密码长度就放到controller
> 
> 逻辑层面的就放到service层.


既然前后端分离了；就可以独自开发了；前端mock数据；后端使用postman进行测试；最开始约定好数据格式即可。最后答辩的时候，放在一台机器上演示即可。


2. interceptor 拦截器
> 网页的某些内容必须要加以限制访问,如一些信息等,这时如果在每个Controller里面都加上
> 验证将会导致代码变得冗余,因此可以使用拦截器 interceptor
> 把token放到请求头中,通过请求头验证是否可以访问.

3. @RequestParam 注解
> [详情](https://blog.csdn.net/GDFHGFHGFH/article/details/124748026)
> 加上后,可以指定 required,defaultValue等
> 还可以用 value="xxx" 匹配参数(当请求的参数和方法参数名不一致时)

