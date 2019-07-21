<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style type="text/css">
            *{margin: 0;
              padding: 0; 
            }/*去掉页面样式，通用选择器*/
            body{color:white}/*标签选择器*/
            .context{background: #50A3A2;
            position: absolute;
            left: 0;
            top:50%;
            width: 100%;
            height: 400px;
            margin-top: -200px;
            overflow: hidden;/*隐藏滚动条*/
            }/*定位浏览器边距位置 左 上 */
            .container{/*类选择器*/
                max-width: 600px;
                height: 400px;/*左右*/
                padding: 80px 0;/*上下*/
                text-align: center;
                margin: 0 auto;/*居中显示*/
            }
            .container h1{/*派生*/
                font-size: 40px;
                font-weight: 300;}
             form{padding: 20px 0;}
             form input{border: 1px solid #FFF;
             width: 220px;
             padding: 10px 15px;
             display: block;
             margin: 0 auto 10px auto;
             border-radius: 30px;/*圆角*/
            font-size: 18px;
            font-weight: 300;
            text-align: center;
             }
             form button{
                 background: white;
                 border: 0;
                 padding: 10px 15px;
                 color: green;
                  border-radius: 8px;
                  width: 250px;
                 font-size: 16px;
             }
             form button:hover{
                 background:#CCC; /*鼠标移动上去按钮颜色变灰色*/
             }
        </style>
    </head>
    <body>
        <div class="context">
            <div class="container">
                <h1>Welcome</h1>
                <form action="login.do" method="post">
                    <input type="text"  name="userName" placeholder="qiwen"/>
                    <input type="password"  name="password" placeholder="123456"/>
                    <button type="submit">登  陆</button>               
                </form>
            </div>
        </div>  

</body>
</html>