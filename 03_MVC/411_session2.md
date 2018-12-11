## session  

### 一、Session简单介绍  
　　在WEB开发中，服务器可以为每个用户浏览器创建一个会话对象（session对象），注意：一个浏览器独占一个session对象(默认情况下)。因此，在需要保存用户数据时，服务器程序可以把用户数据写到用户浏览器独占的session中，当用户使用浏览器访问其它程序时，其它程序可以从用户的session中取出该用户的数据，为用户服务。  

### 二、Session和Cookie的主要区别  
  - Cookie是把用户的数据写给用户的浏览器。  
  - Session技术把用户的数据写到用户独占的session中。  
  - Session对象由服务器创建，开发人员可以调用request对象的getSession方法得到session对象。  
### 三、session实现原理  
#### 3.1、服务器是如何实现一个session为一个用户浏览器服务的？  
服务器创建session出来后，会把session的id号，以cookie的形式回写给客户机。  
这样，只要客户机的浏览器不关，再去访问服务器时，都会带着session的id号去。  
服务器发现客户机浏览器带session id过来了，就会使用内存中与之对应的session为之服务。  
可以用如下的代码证明：  

    package xdp.gacl.session;
    
    import java.io.IOException;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    
    public class SessionDemo1 extends HttpServlet {
    
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
    
            response.setCharacterEncoding("UTF=8");
            response.setContentType("text/html;charset=UTF-8");
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = request.getSession();
            //将数据存储到session中
            session.setAttribute("data", "孤傲苍狼");
            //获取session的Id
            String sessionId = session.getId();
            //判断session是不是新创建的
            if (session.isNew()) {
                response.getWriter().print("session创建成功，session的id是："+sessionId);
            }else {
                response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
            }
        }
    
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
    }

第一次访问时，服务器会创建一个新的sesion，并且把session的Id以cookie的形式发送给客户端浏览器，如下图所示：  



点击刷新按钮，再次请求服务器，此时就可以看到浏览器再请求服务器时，会把存储到cookie中的session的Id一起传递到服务器端了，如下图所示：  
